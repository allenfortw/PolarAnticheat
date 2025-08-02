/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TIntCollection;
/*     */ import gnu.trove.function.TIntFunction;
/*     */ import gnu.trove.list.TIntList;
/*     */ import gnu.trove.procedure.TIntProcedure;
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
/*     */ public class TUnmodifiableIntList
/*     */   extends TUnmodifiableIntCollection
/*     */   implements TIntList
/*     */ {
/*     */   static final long serialVersionUID = -283967356065247728L;
/*     */   final TIntList list;
/*     */   
/*     */   public TUnmodifiableIntList(TIntList list) {
/*  58 */     super((TIntCollection)list);
/*  59 */     this.list = list;
/*     */   }
/*     */   
/*  62 */   public boolean equals(Object o) { return (o == this || this.list.equals(o)); } public int hashCode() {
/*  63 */     return this.list.hashCode();
/*     */   }
/*  65 */   public int get(int index) { return this.list.get(index); }
/*  66 */   public int indexOf(int o) { return this.list.indexOf(o); } public int lastIndexOf(int o) {
/*  67 */     return this.list.lastIndexOf(o);
/*     */   }
/*     */   public int[] toArray(int offset, int len) {
/*  70 */     return this.list.toArray(offset, len);
/*     */   }
/*     */   public int[] toArray(int[] dest, int offset, int len) {
/*  73 */     return this.list.toArray(dest, offset, len);
/*     */   }
/*     */   public int[] toArray(int[] dest, int source_pos, int dest_pos, int len) {
/*  76 */     return this.list.toArray(dest, source_pos, dest_pos, len);
/*     */   }
/*     */   
/*     */   public boolean forEachDescending(TIntProcedure procedure) {
/*  80 */     return this.list.forEachDescending(procedure);
/*     */   }
/*     */   public int binarySearch(int value) {
/*  83 */     return this.list.binarySearch(value);
/*     */   } public int binarySearch(int value, int fromIndex, int toIndex) {
/*  85 */     return this.list.binarySearch(value, fromIndex, toIndex);
/*     */   }
/*     */   
/*  88 */   public int indexOf(int offset, int value) { return this.list.indexOf(offset, value); }
/*  89 */   public int lastIndexOf(int offset, int value) { return this.list.lastIndexOf(offset, value); }
/*  90 */   public TIntList grep(TIntProcedure condition) { return this.list.grep(condition); } public TIntList inverseGrep(TIntProcedure condition) {
/*  91 */     return this.list.inverseGrep(condition);
/*     */   }
/*  93 */   public int max() { return this.list.max(); }
/*  94 */   public int min() { return this.list.min(); } public int sum() {
/*  95 */     return this.list.sum();
/*     */   }
/*     */   public TIntList subList(int fromIndex, int toIndex) {
/*  98 */     return new TUnmodifiableIntList(this.list.subList(fromIndex, toIndex));
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
/* 140 */     return (this.list instanceof java.util.RandomAccess) ? new TUnmodifiableRandomAccessIntList(this.list) : this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int[] vals) {
/* 145 */     throw new UnsupportedOperationException(); } public void add(int[] vals, int offset, int length) {
/* 146 */     throw new UnsupportedOperationException();
/*     */   }
/* 148 */   public int removeAt(int offset) { throw new UnsupportedOperationException(); } public void remove(int offset, int length) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/* 151 */   public void insert(int offset, int value) { throw new UnsupportedOperationException(); }
/* 152 */   public void insert(int offset, int[] values) { throw new UnsupportedOperationException(); } public void insert(int offset, int[] values, int valOffset, int len) {
/* 153 */     throw new UnsupportedOperationException();
/*     */   }
/* 155 */   public int set(int offset, int val) { throw new UnsupportedOperationException(); }
/* 156 */   public void set(int offset, int[] values) { throw new UnsupportedOperationException(); } public void set(int offset, int[] values, int valOffset, int length) {
/* 157 */     throw new UnsupportedOperationException();
/*     */   } public int replace(int offset, int val) {
/* 159 */     throw new UnsupportedOperationException();
/*     */   } public void transformValues(TIntFunction function) {
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/* 163 */   public void reverse() { throw new UnsupportedOperationException(); }
/* 164 */   public void reverse(int from, int to) { throw new UnsupportedOperationException(); } public void shuffle(Random rand) {
/* 165 */     throw new UnsupportedOperationException();
/*     */   }
/* 167 */   public void sort() { throw new UnsupportedOperationException(); }
/* 168 */   public void sort(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
/* 169 */   public void fill(int val) { throw new UnsupportedOperationException(); } public void fill(int fromIndex, int toIndex, int val) {
/* 170 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableIntList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */