/*     */ package gnu.trove.set.hash;
/*     */ 
/*     */ import gnu.trove.TLongCollection;
/*     */ import gnu.trove.impl.HashFunctions;
/*     */ import gnu.trove.impl.hash.THashPrimitiveIterator;
/*     */ import gnu.trove.impl.hash.TLongHash;
/*     */ import gnu.trove.impl.hash.TPrimitiveHash;
/*     */ import gnu.trove.iterator.TLongIterator;
/*     */ import gnu.trove.set.TLongSet;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
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
/*     */ public class TLongHashSet
/*     */   extends TLongHash
/*     */   implements TLongSet, Externalizable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   
/*     */   public TLongHashSet() {}
/*     */   
/*     */   public TLongHashSet(int initialCapacity) {
/*  71 */     super(initialCapacity);
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
/*     */   public TLongHashSet(int initialCapacity, float load_factor) {
/*  84 */     super(initialCapacity, load_factor);
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
/*     */   public TLongHashSet(int initial_capacity, float load_factor, long no_entry_value) {
/*  99 */     super(initial_capacity, load_factor, no_entry_value);
/*     */     
/* 101 */     if (no_entry_value != 0L) {
/* 102 */       Arrays.fill(this._set, no_entry_value);
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
/*     */   public TLongHashSet(Collection<? extends Long> collection) {
/* 114 */     this(Math.max(collection.size(), 10));
/* 115 */     addAll(collection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TLongHashSet(TLongCollection collection) {
/* 126 */     this(Math.max(collection.size(), 10));
/* 127 */     if (collection instanceof TLongHashSet) {
/* 128 */       TLongHashSet hashset = (TLongHashSet)collection;
/* 129 */       this._loadFactor = hashset._loadFactor;
/* 130 */       this.no_entry_value = hashset.no_entry_value;
/*     */       
/* 132 */       if (this.no_entry_value != 0L) {
/* 133 */         Arrays.fill(this._set, this.no_entry_value);
/*     */       }
/* 135 */       setUp(saturatedCast(fastCeil(10.0D / this._loadFactor)));
/*     */     } 
/* 137 */     addAll(collection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TLongHashSet(long[] array) {
/* 148 */     this(Math.max(array.length, 10));
/* 149 */     addAll(array);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TLongIterator iterator() {
/* 155 */     return new TLongHashIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] toArray() {
/* 161 */     return toArray(new long[this._size]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] toArray(long[] dest) {
/* 167 */     if (dest.length < this._size) {
/* 168 */       dest = new long[this._size];
/*     */     }
/*     */     
/* 171 */     long[] set = this._set;
/* 172 */     byte[] states = this._states;
/*     */     
/* 174 */     for (int i = states.length, j = 0; i-- > 0;) {
/* 175 */       if (states[i] == 1) {
/* 176 */         dest[j++] = set[i];
/*     */       }
/*     */     } 
/*     */     
/* 180 */     if (dest.length > this._size) {
/* 181 */       dest[this._size] = this.no_entry_value;
/*     */     }
/* 183 */     return dest;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(long val) {
/* 189 */     int index = insertKey(val);
/*     */     
/* 191 */     if (index < 0) {
/* 192 */       return false;
/*     */     }
/*     */     
/* 195 */     postInsertHook(this.consumeFreeSlot);
/*     */     
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(long val) {
/* 203 */     int index = index(val);
/* 204 */     if (index >= 0) {
/* 205 */       removeAt(index);
/* 206 */       return true;
/*     */     } 
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> collection) {
/* 214 */     for (Object element : collection) {
/* 215 */       if (element instanceof Long) {
/* 216 */         long c = ((Long)element).longValue();
/* 217 */         if (!contains(c))
/* 218 */           return false; 
/*     */         continue;
/*     */       } 
/* 221 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(TLongCollection collection) {
/* 231 */     TLongIterator iter = collection.iterator();
/* 232 */     while (iter.hasNext()) {
/* 233 */       long element = iter.next();
/* 234 */       if (!contains(element)) {
/* 235 */         return false;
/*     */       }
/*     */     } 
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(long[] array) {
/* 244 */     for (int i = array.length; i-- > 0;) {
/* 245 */       if (!contains(array[i])) {
/* 246 */         return false;
/*     */       }
/*     */     } 
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends Long> collection) {
/* 255 */     boolean changed = false;
/* 256 */     for (Long element : collection) {
/* 257 */       long e = element.longValue();
/* 258 */       if (add(e)) {
/* 259 */         changed = true;
/*     */       }
/*     */     } 
/* 262 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(TLongCollection collection) {
/* 268 */     boolean changed = false;
/* 269 */     TLongIterator iter = collection.iterator();
/* 270 */     while (iter.hasNext()) {
/* 271 */       long element = iter.next();
/* 272 */       if (add(element)) {
/* 273 */         changed = true;
/*     */       }
/*     */     } 
/* 276 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(long[] array) {
/* 282 */     boolean changed = false;
/* 283 */     for (int i = array.length; i-- > 0;) {
/* 284 */       if (add(array[i])) {
/* 285 */         changed = true;
/*     */       }
/*     */     } 
/* 288 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> collection) {
/* 295 */     boolean modified = false;
/* 296 */     TLongIterator iter = iterator();
/* 297 */     while (iter.hasNext()) {
/* 298 */       if (!collection.contains(Long.valueOf(iter.next()))) {
/* 299 */         iter.remove();
/* 300 */         modified = true;
/*     */       } 
/*     */     } 
/* 303 */     return modified;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(TLongCollection collection) {
/* 309 */     if (this == collection) {
/* 310 */       return false;
/*     */     }
/* 312 */     boolean modified = false;
/* 313 */     TLongIterator iter = iterator();
/* 314 */     while (iter.hasNext()) {
/* 315 */       if (!collection.contains(iter.next())) {
/* 316 */         iter.remove();
/* 317 */         modified = true;
/*     */       } 
/*     */     } 
/* 320 */     return modified;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(long[] array) {
/* 326 */     boolean changed = false;
/* 327 */     Arrays.sort(array);
/* 328 */     long[] set = this._set;
/* 329 */     byte[] states = this._states;
/*     */     
/* 331 */     this._autoCompactTemporaryDisable = true;
/* 332 */     for (int i = set.length; i-- > 0;) {
/* 333 */       if (states[i] == 1 && Arrays.binarySearch(array, set[i]) < 0) {
/* 334 */         removeAt(i);
/* 335 */         changed = true;
/*     */       } 
/*     */     } 
/* 338 */     this._autoCompactTemporaryDisable = false;
/*     */     
/* 340 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> collection) {
/* 346 */     boolean changed = false;
/* 347 */     for (Object element : collection) {
/* 348 */       if (element instanceof Long) {
/* 349 */         long c = ((Long)element).longValue();
/* 350 */         if (remove(c)) {
/* 351 */           changed = true;
/*     */         }
/*     */       } 
/*     */     } 
/* 355 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(TLongCollection collection) {
/* 361 */     boolean changed = false;
/* 362 */     TLongIterator iter = collection.iterator();
/* 363 */     while (iter.hasNext()) {
/* 364 */       long element = iter.next();
/* 365 */       if (remove(element)) {
/* 366 */         changed = true;
/*     */       }
/*     */     } 
/* 369 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(long[] array) {
/* 375 */     boolean changed = false;
/* 376 */     for (int i = array.length; i-- > 0;) {
/* 377 */       if (remove(array[i])) {
/* 378 */         changed = true;
/*     */       }
/*     */     } 
/* 381 */     return changed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 387 */     super.clear();
/* 388 */     long[] set = this._set;
/* 389 */     byte[] states = this._states;
/*     */     
/* 391 */     for (int i = set.length; i-- > 0; ) {
/* 392 */       set[i] = this.no_entry_value;
/* 393 */       states[i] = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void rehash(int newCapacity) {
/* 400 */     int oldCapacity = this._set.length;
/*     */     
/* 402 */     long[] oldSet = this._set;
/* 403 */     byte[] oldStates = this._states;
/*     */     
/* 405 */     this._set = new long[newCapacity];
/* 406 */     this._states = new byte[newCapacity];
/*     */     
/* 408 */     for (int i = oldCapacity; i-- > 0;) {
/* 409 */       if (oldStates[i] == 1) {
/* 410 */         long o = oldSet[i];
/* 411 */         int j = insertKey(o);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object other) {
/* 419 */     if (!(other instanceof TLongSet)) {
/* 420 */       return false;
/*     */     }
/* 422 */     TLongSet that = (TLongSet)other;
/* 423 */     if (that.size() != size()) {
/* 424 */       return false;
/*     */     }
/* 426 */     for (int i = this._states.length; i-- > 0;) {
/* 427 */       if (this._states[i] == 1 && 
/* 428 */         !that.contains(this._set[i])) {
/* 429 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 433 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 439 */     int hashcode = 0;
/* 440 */     for (int i = this._states.length; i-- > 0;) {
/* 441 */       if (this._states[i] == 1) {
/* 442 */         hashcode += HashFunctions.hash(this._set[i]);
/*     */       }
/*     */     } 
/* 445 */     return hashcode;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 451 */     StringBuilder buffy = new StringBuilder(this._size * 2 + 2);
/* 452 */     buffy.append("{");
/* 453 */     for (int i = this._states.length, j = 1; i-- > 0;) {
/* 454 */       if (this._states[i] == 1) {
/* 455 */         buffy.append(this._set[i]);
/* 456 */         if (j++ < this._size) {
/* 457 */           buffy.append(",");
/*     */         }
/*     */       } 
/*     */     } 
/* 461 */     buffy.append("}");
/* 462 */     return buffy.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   class TLongHashIterator
/*     */     extends THashPrimitiveIterator
/*     */     implements TLongIterator
/*     */   {
/*     */     private final TLongHash _hash;
/*     */     
/*     */     public TLongHashIterator(TLongHash hash) {
/* 473 */       super((TPrimitiveHash)hash);
/* 474 */       this._hash = hash;
/*     */     }
/*     */ 
/*     */     
/*     */     public long next() {
/* 479 */       moveToNextIndex();
/* 480 */       return this._hash._set[this._index];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 489 */     out.writeByte(1);
/*     */ 
/*     */     
/* 492 */     super.writeExternal(out);
/*     */ 
/*     */     
/* 495 */     out.writeInt(this._size);
/*     */ 
/*     */     
/* 498 */     out.writeFloat(this._loadFactor);
/*     */ 
/*     */     
/* 501 */     out.writeLong(this.no_entry_value);
/*     */ 
/*     */     
/* 504 */     for (int i = this._states.length; i-- > 0;) {
/* 505 */       if (this._states[i] == 1) {
/* 506 */         out.writeLong(this._set[i]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 517 */     int version = in.readByte();
/*     */ 
/*     */     
/* 520 */     super.readExternal(in);
/*     */ 
/*     */     
/* 523 */     int size = in.readInt();
/*     */     
/* 525 */     if (version >= 1) {
/*     */       
/* 527 */       this._loadFactor = in.readFloat();
/*     */ 
/*     */       
/* 530 */       this.no_entry_value = in.readLong();
/*     */       
/* 532 */       if (this.no_entry_value != 0L) {
/* 533 */         Arrays.fill(this._set, this.no_entry_value);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 538 */     setUp(size);
/* 539 */     while (size-- > 0) {
/* 540 */       long val = in.readLong();
/* 541 */       add(val);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\set\hash\TLongHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */