/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TLongCollection;
/*     */ import gnu.trove.function.TLongFunction;
/*     */ import gnu.trove.list.TLongList;
/*     */ import gnu.trove.procedure.TLongProcedure;
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
/*     */ public class TUnmodifiableLongList
/*     */   extends TUnmodifiableLongCollection
/*     */   implements TLongList
/*     */ {
/*     */   static final long serialVersionUID = -283967356065247728L;
/*     */   final TLongList list;
/*     */   
/*     */   public TUnmodifiableLongList(TLongList list) {
/*  58 */     super((TLongCollection)list);
/*  59 */     this.list = list;
/*     */   }
/*     */   
/*  62 */   public boolean equals(Object o) { return (o == this || this.list.equals(o)); } public int hashCode() {
/*  63 */     return this.list.hashCode();
/*     */   }
/*  65 */   public long get(int index) { return this.list.get(index); }
/*  66 */   public int indexOf(long o) { return this.list.indexOf(o); } public int lastIndexOf(long o) {
/*  67 */     return this.list.lastIndexOf(o);
/*     */   }
/*     */   public long[] toArray(int offset, int len) {
/*  70 */     return this.list.toArray(offset, len);
/*     */   }
/*     */   public long[] toArray(long[] dest, int offset, int len) {
/*  73 */     return this.list.toArray(dest, offset, len);
/*     */   }
/*     */   public long[] toArray(long[] dest, int source_pos, int dest_pos, int len) {
/*  76 */     return this.list.toArray(dest, source_pos, dest_pos, len);
/*     */   }
/*     */   
/*     */   public boolean forEachDescending(TLongProcedure procedure) {
/*  80 */     return this.list.forEachDescending(procedure);
/*     */   }
/*     */   public int binarySearch(long value) {
/*  83 */     return this.list.binarySearch(value);
/*     */   } public int binarySearch(long value, int fromIndex, int toIndex) {
/*  85 */     return this.list.binarySearch(value, fromIndex, toIndex);
/*     */   }
/*     */   
/*  88 */   public int indexOf(int offset, long value) { return this.list.indexOf(offset, value); }
/*  89 */   public int lastIndexOf(int offset, long value) { return this.list.lastIndexOf(offset, value); }
/*  90 */   public TLongList grep(TLongProcedure condition) { return this.list.grep(condition); } public TLongList inverseGrep(TLongProcedure condition) {
/*  91 */     return this.list.inverseGrep(condition);
/*     */   }
/*  93 */   public long max() { return this.list.max(); }
/*  94 */   public long min() { return this.list.min(); } public long sum() {
/*  95 */     return this.list.sum();
/*     */   }
/*     */   public TLongList subList(int fromIndex, int toIndex) {
/*  98 */     return new TUnmodifiableLongList(this.list.subList(fromIndex, toIndex));
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
/* 140 */     return (this.list instanceof java.util.RandomAccess) ? new TUnmodifiableRandomAccessLongList(this.list) : this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(long[] vals) {
/* 145 */     throw new UnsupportedOperationException(); } public void add(long[] vals, int offset, int length) {
/* 146 */     throw new UnsupportedOperationException();
/*     */   }
/* 148 */   public long removeAt(int offset) { throw new UnsupportedOperationException(); } public void remove(int offset, int length) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/* 151 */   public void insert(int offset, long value) { throw new UnsupportedOperationException(); }
/* 152 */   public void insert(int offset, long[] values) { throw new UnsupportedOperationException(); } public void insert(int offset, long[] values, int valOffset, int len) {
/* 153 */     throw new UnsupportedOperationException();
/*     */   }
/* 155 */   public long set(int offset, long val) { throw new UnsupportedOperationException(); }
/* 156 */   public void set(int offset, long[] values) { throw new UnsupportedOperationException(); } public void set(int offset, long[] values, int valOffset, int length) {
/* 157 */     throw new UnsupportedOperationException();
/*     */   } public long replace(int offset, long val) {
/* 159 */     throw new UnsupportedOperationException();
/*     */   } public void transformValues(TLongFunction function) {
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/* 163 */   public void reverse() { throw new UnsupportedOperationException(); }
/* 164 */   public void reverse(int from, int to) { throw new UnsupportedOperationException(); } public void shuffle(Random rand) {
/* 165 */     throw new UnsupportedOperationException();
/*     */   }
/* 167 */   public void sort() { throw new UnsupportedOperationException(); }
/* 168 */   public void sort(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
/* 169 */   public void fill(long val) { throw new UnsupportedOperationException(); } public void fill(int fromIndex, int toIndex, long val) {
/* 170 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableLongList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */