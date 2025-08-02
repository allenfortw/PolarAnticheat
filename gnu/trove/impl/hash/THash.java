/*     */ package gnu.trove.impl.hash;
/*     */ 
/*     */ import gnu.trove.impl.PrimeFinder;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class THash
/*     */   implements Externalizable
/*     */ {
/*     */   static final long serialVersionUID = -1792948471915530295L;
/*     */   protected static final float DEFAULT_LOAD_FACTOR = 0.5F;
/*     */   protected static final int DEFAULT_CAPACITY = 10;
/*     */   protected transient int _size;
/*     */   protected transient int _free;
/*     */   protected float _loadFactor;
/*     */   protected int _maxSize;
/*     */   protected int _autoCompactRemovesRemaining;
/*     */   protected float _autoCompactionFactor;
/*     */   protected transient boolean _autoCompactTemporaryDisable = false;
/*     */   
/*     */   public THash() {
/* 103 */     this(10, 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public THash(int initialCapacity) {
/* 115 */     this(initialCapacity, 0.5F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public THash(int initialCapacity, float loadFactor) {
/* 129 */     if (initialCapacity < 0)
/* 130 */       throw new IllegalArgumentException("negative capacity: " + initialCapacity); 
/* 131 */     if (0.0F >= loadFactor) {
/* 132 */       throw new IllegalArgumentException("load factor out of range: " + loadFactor);
/*     */     }
/* 134 */     this._loadFactor = loadFactor;
/*     */ 
/*     */ 
/*     */     
/* 138 */     this._autoCompactionFactor = loadFactor;
/*     */ 
/*     */     
/* 141 */     setUp(saturatedCast(fastCeil(initialCapacity / loadFactor)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static long fastCeil(double v) {
/* 151 */     long possible_result = (long)v;
/* 152 */     if (v - possible_result > 0.0D) possible_result++; 
/* 153 */     return possible_result;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static int saturatedCast(long v) {
/* 158 */     int r = (int)(v & 0x7FFFFFFFL);
/* 159 */     if (r != v) {
/* 160 */       return Integer.MAX_VALUE;
/*     */     }
/* 162 */     return r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 171 */     return (0 == this._size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 181 */     return this._size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int capacity();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int desiredCapacity) {
/* 198 */     if (desiredCapacity > this._maxSize - size()) {
/* 199 */       rehash(PrimeFinder.nextPrime(Math.max(this._size + 1, 
/* 200 */               saturatedCast(fastCeil((desiredCapacity + this._size) / this._loadFactor) + 1L))));
/* 201 */       if (capacity() >= PrimeFinder.largestPrime) {
/* 202 */         this._loadFactor = 1.0F;
/*     */       }
/* 204 */       computeMaxSize(capacity());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compact() {
/* 227 */     rehash(PrimeFinder.nextPrime(Math.max(this._size + 1, 
/* 228 */             saturatedCast(fastCeil(this._size / this._loadFactor) + 1L))));
/* 229 */     computeMaxSize(capacity());
/*     */ 
/*     */     
/* 232 */     if (this._autoCompactionFactor != 0.0F) {
/* 233 */       computeNextAutoCompactionAmount(size());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCompactionFactor(float factor) {
/* 250 */     if (factor < 0.0F) {
/* 251 */       throw new IllegalArgumentException("Factor must be >= 0: " + factor);
/*     */     }
/*     */     
/* 254 */     this._autoCompactionFactor = factor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAutoCompactionFactor() {
/* 264 */     return this._autoCompactionFactor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trimToSize() {
/* 278 */     compact();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAt(int index) {
/* 289 */     this._size--;
/*     */ 
/*     */     
/* 292 */     if (this._autoCompactionFactor != 0.0F) {
/* 293 */       this._autoCompactRemovesRemaining--;
/*     */       
/* 295 */       if (!this._autoCompactTemporaryDisable && this._autoCompactRemovesRemaining <= 0)
/*     */       {
/*     */         
/* 298 */         compact();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 306 */     this._size = 0;
/* 307 */     this._free = capacity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int setUp(int initialCapacity) {
/* 321 */     int capacity = PrimeFinder.nextPrime(initialCapacity);
/* 322 */     if (capacity >= PrimeFinder.largestPrime) {
/* 323 */       this._loadFactor = 1.0F;
/*     */     }
/* 325 */     computeMaxSize(capacity);
/* 326 */     computeNextAutoCompactionAmount(initialCapacity);
/*     */     
/* 328 */     return capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void rehash(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tempDisableAutoCompaction() {
/* 345 */     this._autoCompactTemporaryDisable = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reenableAutoCompaction(boolean check_for_compaction) {
/* 358 */     this._autoCompactTemporaryDisable = false;
/*     */     
/* 360 */     if (check_for_compaction && this._autoCompactRemovesRemaining <= 0 && this._autoCompactionFactor != 0.0F)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 365 */       compact();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void computeMaxSize(int capacity) {
/* 378 */     this._maxSize = Math.min(capacity - 1, (int)(capacity * this._loadFactor));
/* 379 */     this._free = capacity - this._size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void computeNextAutoCompactionAmount(int size) {
/* 390 */     if (this._autoCompactionFactor != 0.0F)
/*     */     {
/*     */       
/* 393 */       this._autoCompactRemovesRemaining = (int)(size * this._autoCompactionFactor + 0.5F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void postInsertHook(boolean usedFreeSlot) {
/* 406 */     if (usedFreeSlot) {
/* 407 */       this._free--;
/*     */     }
/*     */ 
/*     */     
/* 411 */     if (++this._size > this._maxSize || this._free == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 416 */       int newCapacity = (this._size > this._maxSize) ? PrimeFinder.nextPrime(capacity() << 1) : capacity();
/* 417 */       rehash(newCapacity);
/* 418 */       computeMaxSize(capacity());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int calculateGrownCapacity() {
/* 424 */     return capacity() << 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 430 */     out.writeByte(0);
/*     */ 
/*     */     
/* 433 */     out.writeFloat(this._loadFactor);
/*     */ 
/*     */     
/* 436 */     out.writeFloat(this._autoCompactionFactor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 444 */     in.readByte();
/*     */ 
/*     */     
/* 447 */     float old_factor = this._loadFactor;
/* 448 */     this._loadFactor = Math.abs(in.readFloat());
/*     */ 
/*     */     
/* 451 */     this._autoCompactionFactor = in.readFloat();
/*     */ 
/*     */     
/* 454 */     if (old_factor != this._loadFactor)
/* 455 */       setUp(saturatedCast((long)Math.ceil(10.0D / this._loadFactor))); 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\hash\THash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */