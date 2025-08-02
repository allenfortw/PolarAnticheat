/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCharCollection;
/*     */ import gnu.trove.iterator.TCharIterator;
/*     */ import gnu.trove.procedure.TCharProcedure;
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
/*     */ public class TUnmodifiableCharCollection
/*     */   implements TCharCollection, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1820017752578914078L;
/*     */   final TCharCollection c;
/*     */   
/*     */   public TUnmodifiableCharCollection(TCharCollection c) {
/*  58 */     if (c == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.c = c;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.c.size(); }
/*  64 */   public boolean isEmpty() { return this.c.isEmpty(); }
/*  65 */   public boolean contains(char o) { return this.c.contains(o); }
/*  66 */   public char[] toArray() { return this.c.toArray(); }
/*  67 */   public char[] toArray(char[] a) { return this.c.toArray(a); }
/*  68 */   public String toString() { return this.c.toString(); }
/*  69 */   public char getNoEntryValue() { return this.c.getNoEntryValue(); } public boolean forEach(TCharProcedure procedure) {
/*  70 */     return this.c.forEach(procedure);
/*     */   }
/*     */   public TCharIterator iterator() {
/*  73 */     return new TCharIterator() {
/*  74 */         TCharIterator i = TUnmodifiableCharCollection.this.c.iterator();
/*     */         
/*  76 */         public boolean hasNext() { return this.i.hasNext(); }
/*  77 */         public char next() { return this.i.next(); } public void remove() {
/*  78 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*  82 */   public boolean add(char e) { throw new UnsupportedOperationException(); } public boolean remove(char o) {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*  85 */   public boolean containsAll(Collection<?> coll) { return this.c.containsAll(coll); }
/*  86 */   public boolean containsAll(TCharCollection coll) { return this.c.containsAll(coll); } public boolean containsAll(char[] array) {
/*  87 */     return this.c.containsAll(array);
/*     */   }
/*  89 */   public boolean addAll(TCharCollection coll) { throw new UnsupportedOperationException(); }
/*  90 */   public boolean addAll(Collection<? extends Character> coll) { throw new UnsupportedOperationException(); } public boolean addAll(char[] array) {
/*  91 */     throw new UnsupportedOperationException();
/*     */   }
/*  93 */   public boolean removeAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/*  94 */   public boolean removeAll(TCharCollection coll) { throw new UnsupportedOperationException(); } public boolean removeAll(char[] array) {
/*  95 */     throw new UnsupportedOperationException();
/*     */   }
/*  97 */   public boolean retainAll(Collection<?> coll) { throw new UnsupportedOperationException(); }
/*  98 */   public boolean retainAll(TCharCollection coll) { throw new UnsupportedOperationException(); } public boolean retainAll(char[] array) {
/*  99 */     throw new UnsupportedOperationException();
/*     */   } public void clear() {
/* 101 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableCharCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */