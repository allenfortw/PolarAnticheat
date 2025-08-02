/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TByteCollection;
/*     */ import gnu.trove.iterator.TByteIterator;
/*     */ import gnu.trove.procedure.TByteProcedure;
/*     */ import java.io.Serializable;
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
/*     */ public class TUnmodifiableByteCollection
/*     */   implements TByteCollection, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1820017752578914078L;
/*     */   final TByteCollection c;
/*     */   
/*     */   public TUnmodifiableByteCollection(TByteCollection c) {
/*  58 */     if (c == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.c = c;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.c.size(); }
/*  64 */   public boolean isEmpty() { return this.c.isEmpty(); }
/*  65 */   public boolean contains(byte o) { return this.c.contains(o); }
/*  66 */   public byte[] toArray() { return this.c.toArray(); }
/*  67 */   public byte[] toArray(byte[] a) { return this.c.toArray(a); }
/*  68 */   public String toString() { return this.c.toString(); }
/*  69 */   public byte getNoEntryValue() { return this.c.getNoEntryValue(); } public boolean forEach(TByteProcedure procedure) {
/*  70 */     return this.c.forEach(procedure);
/*     */   }
/*     */   public TByteIterator iterator() {
/*  73 */     return new TByteIterator() {
/*  74 */         TByteIterator i = TUnmodifiableByteCollection.this.c.iterator();
/*     */         
/*  76 */         public boolean hasNext() { return this.i.hasNext(); }
/*  77 */         public byte next() { return this.i.next(); } public void remove() {
/*  78 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*  82 */   public boolean add(byte e) { throw new UnsupportedOperationException(); } public boolean remove(byte o) {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*  85 */   public boolean containsAll(Collection<?> coll) { return this.c.containsAll(coll); }
/*  86 */   public boolean containsAll(TByteCollection coll) { return this.c.containsAll(coll); } public boolean containsAll(byte[] array) {
/*  87 */     return this.c.containsAll(array);
/*     */   }
/*  89 */   public boolean addAll(TByteCollection coll) { throw new UnsupportedOperationException(); }
/*  90 */   public boolean addAll(Collection<? extends Byte> coll) { throw new UnsupportedOperationException(); } public boolean addAll(byte[] array) {
/*  91 */     throw new UnsupportedOperationException();
/*     */   }
/*  93 */   public boolean removeAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/*  94 */   public boolean removeAll(TByteCollection coll) { throw new UnsupportedOperationException(); } public boolean removeAll(byte[] array) {
/*  95 */     throw new UnsupportedOperationException();
/*     */   }
/*  97 */   public boolean retainAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/*  98 */   public boolean retainAll(TByteCollection coll) { throw new UnsupportedOperationException(); } public boolean retainAll(byte[] array) {
/*  99 */     throw new UnsupportedOperationException();
/*     */   } public void clear() {
/* 101 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableByteCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */