/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCharCollection;
/*     */ import gnu.trove.function.TCharFunction;
/*     */ import gnu.trove.list.TCharList;
/*     */ import gnu.trove.procedure.TCharProcedure;
/*     */ import java.util.Random;
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
/*     */ public class TUnmodifiableCharList
/*     */   extends TUnmodifiableCharCollection
/*     */   implements TCharList
/*     */ {
/*     */   static final long serialVersionUID = -283967356065247728L;
/*     */   final TCharList list;
/*     */   
/*     */   public TUnmodifiableCharList(TCharList list) {
/*  58 */     super((TCharCollection)list);
/*  59 */     this.list = list;
/*     */   }
/*     */   
/*  62 */   public boolean equals(Object o) { return (o == this || this.list.equals(o)); } public int hashCode() {
/*  63 */     return this.list.hashCode();
/*     */   }
/*  65 */   public char get(int index) { return this.list.get(index); }
/*  66 */   public int indexOf(char o) { return this.list.indexOf(o); } public int lastIndexOf(char o) {
/*  67 */     return this.list.lastIndexOf(o);
/*     */   }
/*     */   public char[] toArray(int offset, int len) {
/*  70 */     return this.list.toArray(offset, len);
/*     */   }
/*     */   public char[] toArray(char[] dest, int offset, int len) {
/*  73 */     return this.list.toArray(dest, offset, len);
/*     */   }
/*     */   public char[] toArray(char[] dest, int source_pos, int dest_pos, int len) {
/*  76 */     return this.list.toArray(dest, source_pos, dest_pos, len);
/*     */   }
/*     */   
/*     */   public boolean forEachDescending(TCharProcedure procedure) {
/*  80 */     return this.list.forEachDescending(procedure);
/*     */   }
/*     */   public int binarySearch(char value) {
/*  83 */     return this.list.binarySearch(value);
/*     */   } public int binarySearch(char value, int fromIndex, int toIndex) {
/*  85 */     return this.list.binarySearch(value, fromIndex, toIndex);
/*     */   }
/*     */   
/*  88 */   public int indexOf(int offset, char value) { return this.list.indexOf(offset, value); }
/*  89 */   public int lastIndexOf(int offset, char value) { return this.list.lastIndexOf(offset, value); }
/*  90 */   public TCharList grep(TCharProcedure condition) { return this.list.grep(condition); } public TCharList inverseGrep(TCharProcedure condition) {
/*  91 */     return this.list.inverseGrep(condition);
/*     */   }
/*  93 */   public char max() { return this.list.max(); }
/*  94 */   public char min() { return this.list.min(); } public char sum() {
/*  95 */     return this.list.sum();
/*     */   }
/*     */   public TCharList subList(int fromIndex, int toIndex) {
/*  98 */     return new TUnmodifiableCharList(this.list.subList(fromIndex, toIndex));
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
/*     */   private Object readResolve() {
/* 140 */     return (this.list instanceof java.util.RandomAccess) ? new TUnmodifiableRandomAccessCharList(this.list) : this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(char[] vals) {
/* 145 */     throw new UnsupportedOperationException(); } public void add(char[] vals, int offset, int length) {
/* 146 */     throw new UnsupportedOperationException();
/*     */   }
/* 148 */   public char removeAt(int offset) { throw new UnsupportedOperationException(); } public void remove(int offset, int length) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/* 151 */   public void insert(int offset, char value) { throw new UnsupportedOperationException(); }
/* 152 */   public void insert(int offset, char[] values) { throw new UnsupportedOperationException(); } public void insert(int offset, char[] values, int valOffset, int len) {
/* 153 */     throw new UnsupportedOperationException();
/*     */   }
/* 155 */   public char set(int offset, char val) { throw new UnsupportedOperationException(); }
/* 156 */   public void set(int offset, char[] values) { throw new UnsupportedOperationException(); } public void set(int offset, char[] values, int valOffset, int length) {
/* 157 */     throw new UnsupportedOperationException();
/*     */   } public char replace(int offset, char val) {
/* 159 */     throw new UnsupportedOperationException();
/*     */   } public void transformValues(TCharFunction function) {
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/* 163 */   public void reverse() { throw new UnsupportedOperationException(); }
/* 164 */   public void reverse(int from, int to) { throw new UnsupportedOperationException(); } public void shuffle(Random rand) {
/* 165 */     throw new UnsupportedOperationException();
/*     */   }
/* 167 */   public void sort() { throw new UnsupportedOperationException(); }
/* 168 */   public void sort(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
/* 169 */   public void fill(char val) { throw new UnsupportedOperationException(); } public void fill(int fromIndex, int toIndex, char val) {
/* 170 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableCharList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */