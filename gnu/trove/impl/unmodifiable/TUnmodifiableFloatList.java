/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TFloatCollection;
/*     */ import gnu.trove.function.TFloatFunction;
/*     */ import gnu.trove.list.TFloatList;
/*     */ import gnu.trove.procedure.TFloatProcedure;
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
/*     */ public class TUnmodifiableFloatList
/*     */   extends TUnmodifiableFloatCollection
/*     */   implements TFloatList
/*     */ {
/*     */   static final long serialVersionUID = -283967356065247728L;
/*     */   final TFloatList list;
/*     */   
/*     */   public TUnmodifiableFloatList(TFloatList list) {
/*  58 */     super((TFloatCollection)list);
/*  59 */     this.list = list;
/*     */   }
/*     */   
/*  62 */   public boolean equals(Object o) { return (o == this || this.list.equals(o)); } public int hashCode() {
/*  63 */     return this.list.hashCode();
/*     */   }
/*  65 */   public float get(int index) { return this.list.get(index); }
/*  66 */   public int indexOf(float o) { return this.list.indexOf(o); } public int lastIndexOf(float o) {
/*  67 */     return this.list.lastIndexOf(o);
/*     */   }
/*     */   public float[] toArray(int offset, int len) {
/*  70 */     return this.list.toArray(offset, len);
/*     */   }
/*     */   public float[] toArray(float[] dest, int offset, int len) {
/*  73 */     return this.list.toArray(dest, offset, len);
/*     */   }
/*     */   public float[] toArray(float[] dest, int source_pos, int dest_pos, int len) {
/*  76 */     return this.list.toArray(dest, source_pos, dest_pos, len);
/*     */   }
/*     */   
/*     */   public boolean forEachDescending(TFloatProcedure procedure) {
/*  80 */     return this.list.forEachDescending(procedure);
/*     */   }
/*     */   public int binarySearch(float value) {
/*  83 */     return this.list.binarySearch(value);
/*     */   } public int binarySearch(float value, int fromIndex, int toIndex) {
/*  85 */     return this.list.binarySearch(value, fromIndex, toIndex);
/*     */   }
/*     */   
/*  88 */   public int indexOf(int offset, float value) { return this.list.indexOf(offset, value); }
/*  89 */   public int lastIndexOf(int offset, float value) { return this.list.lastIndexOf(offset, value); }
/*  90 */   public TFloatList grep(TFloatProcedure condition) { return this.list.grep(condition); } public TFloatList inverseGrep(TFloatProcedure condition) {
/*  91 */     return this.list.inverseGrep(condition);
/*     */   }
/*  93 */   public float max() { return this.list.max(); }
/*  94 */   public float min() { return this.list.min(); } public float sum() {
/*  95 */     return this.list.sum();
/*     */   }
/*     */   public TFloatList subList(int fromIndex, int toIndex) {
/*  98 */     return new TUnmodifiableFloatList(this.list.subList(fromIndex, toIndex));
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
/* 140 */     return (this.list instanceof java.util.RandomAccess) ? new TUnmodifiableRandomAccessFloatList(this.list) : this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(float[] vals) {
/* 145 */     throw new UnsupportedOperationException(); } public void add(float[] vals, int offset, int length) {
/* 146 */     throw new UnsupportedOperationException();
/*     */   }
/* 148 */   public float removeAt(int offset) { throw new UnsupportedOperationException(); } public void remove(int offset, int length) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/* 151 */   public void insert(int offset, float value) { throw new UnsupportedOperationException(); }
/* 152 */   public void insert(int offset, float[] values) { throw new UnsupportedOperationException(); } public void insert(int offset, float[] values, int valOffset, int len) {
/* 153 */     throw new UnsupportedOperationException();
/*     */   }
/* 155 */   public float set(int offset, float val) { throw new UnsupportedOperationException(); }
/* 156 */   public void set(int offset, float[] values) { throw new UnsupportedOperationException(); } public void set(int offset, float[] values, int valOffset, int length) {
/* 157 */     throw new UnsupportedOperationException();
/*     */   } public float replace(int offset, float val) {
/* 159 */     throw new UnsupportedOperationException();
/*     */   } public void transformValues(TFloatFunction function) {
/* 161 */     throw new UnsupportedOperationException();
/*     */   }
/* 163 */   public void reverse() { throw new UnsupportedOperationException(); }
/* 164 */   public void reverse(int from, int to) { throw new UnsupportedOperationException(); } public void shuffle(Random rand) {
/* 165 */     throw new UnsupportedOperationException();
/*     */   }
/* 167 */   public void sort() { throw new UnsupportedOperationException(); }
/* 168 */   public void sort(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
/* 169 */   public void fill(float val) { throw new UnsupportedOperationException(); } public void fill(int fromIndex, int toIndex, float val) {
/* 170 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableFloatList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */