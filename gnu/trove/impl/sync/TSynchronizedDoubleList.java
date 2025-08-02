/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TDoubleCollection;
/*     */ import gnu.trove.function.TDoubleFunction;
/*     */ import gnu.trove.list.TDoubleList;
/*     */ import gnu.trove.procedure.TDoubleProcedure;
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
/*     */ 
/*     */ 
/*     */ public class TSynchronizedDoubleList
/*     */   extends TSynchronizedDoubleCollection
/*     */   implements TDoubleList
/*     */ {
/*     */   static final long serialVersionUID = -7754090372962971524L;
/*     */   final TDoubleList list;
/*     */   
/*     */   public TSynchronizedDoubleList(TDoubleList list) {
/*  60 */     super((TDoubleCollection)list);
/*  61 */     this.list = list;
/*     */   }
/*     */   public TSynchronizedDoubleList(TDoubleList list, Object mutex) {
/*  64 */     super((TDoubleCollection)list, mutex);
/*  65 */     this.list = list;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/*  69 */     synchronized (this.mutex) { return this.list.equals(o); }
/*     */   
/*     */   } public int hashCode() {
/*  72 */     synchronized (this.mutex) { return this.list.hashCode(); }
/*     */   
/*     */   }
/*     */   public double get(int index) {
/*  76 */     synchronized (this.mutex) { return this.list.get(index); }
/*     */   
/*     */   } public double set(int index, double element) {
/*  79 */     synchronized (this.mutex) { return this.list.set(index, element); }
/*     */   
/*     */   } public void set(int offset, double[] values) {
/*  82 */     synchronized (this.mutex) { this.list.set(offset, values); }
/*     */   
/*     */   } public void set(int offset, double[] values, int valOffset, int length) {
/*  85 */     synchronized (this.mutex) { this.list.set(offset, values, valOffset, length); }
/*     */   
/*     */   }
/*     */   public double replace(int offset, double val) {
/*  89 */     synchronized (this.mutex) { return this.list.replace(offset, val); }
/*     */   
/*     */   } public void remove(int offset, int length) {
/*  92 */     synchronized (this.mutex) { this.list.remove(offset, length); }
/*     */   
/*     */   } public double removeAt(int offset) {
/*  95 */     synchronized (this.mutex) { return this.list.removeAt(offset); }
/*     */   
/*     */   }
/*     */   public void add(double[] vals) {
/*  99 */     synchronized (this.mutex) { this.list.add(vals); }
/*     */   
/*     */   } public void add(double[] vals, int offset, int length) {
/* 102 */     synchronized (this.mutex) { this.list.add(vals, offset, length); }
/*     */   
/*     */   }
/*     */   public void insert(int offset, double value) {
/* 106 */     synchronized (this.mutex) { this.list.insert(offset, value); }
/*     */   
/*     */   } public void insert(int offset, double[] values) {
/* 109 */     synchronized (this.mutex) { this.list.insert(offset, values); }
/*     */   
/*     */   } public void insert(int offset, double[] values, int valOffset, int len) {
/* 112 */     synchronized (this.mutex) { this.list.insert(offset, values, valOffset, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(double o) {
/* 116 */     synchronized (this.mutex) { return this.list.indexOf(o); }
/*     */   
/*     */   } public int lastIndexOf(double o) {
/* 119 */     synchronized (this.mutex) { return this.list.lastIndexOf(o); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TDoubleList subList(int fromIndex, int toIndex) {
/* 131 */     synchronized (this.mutex) {
/* 132 */       return new TSynchronizedDoubleList(this.list.subList(fromIndex, toIndex), this.mutex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] toArray(int offset, int len) {
/* 138 */     synchronized (this.mutex) { return this.list.toArray(offset, len); }
/*     */   
/*     */   } public double[] toArray(double[] dest, int offset, int len) {
/* 141 */     synchronized (this.mutex) { return this.list.toArray(dest, offset, len); }
/*     */   
/*     */   } public double[] toArray(double[] dest, int source_pos, int dest_pos, int len) {
/* 144 */     synchronized (this.mutex) { return this.list.toArray(dest, source_pos, dest_pos, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(int offset, double value) {
/* 148 */     synchronized (this.mutex) { return this.list.indexOf(offset, value); }
/*     */   
/*     */   } public int lastIndexOf(int offset, double value) {
/* 151 */     synchronized (this.mutex) { return this.list.lastIndexOf(offset, value); }
/*     */   
/*     */   }
/*     */   public void fill(double val) {
/* 155 */     synchronized (this.mutex) { this.list.fill(val); }
/*     */   
/*     */   } public void fill(int fromIndex, int toIndex, double val) {
/* 158 */     synchronized (this.mutex) { this.list.fill(fromIndex, toIndex, val); }
/*     */   
/*     */   }
/*     */   public void reverse() {
/* 162 */     synchronized (this.mutex) { this.list.reverse(); }
/*     */   
/*     */   } public void reverse(int from, int to) {
/* 165 */     synchronized (this.mutex) { this.list.reverse(from, to); }
/*     */   
/*     */   }
/*     */   public void shuffle(Random rand) {
/* 169 */     synchronized (this.mutex) { this.list.shuffle(rand); }
/*     */   
/*     */   }
/*     */   public void sort() {
/* 173 */     synchronized (this.mutex) { this.list.sort(); }
/*     */   
/*     */   } public void sort(int fromIndex, int toIndex) {
/* 176 */     synchronized (this.mutex) { this.list.sort(fromIndex, toIndex); }
/*     */   
/*     */   }
/*     */   public int binarySearch(double value) {
/* 180 */     synchronized (this.mutex) { return this.list.binarySearch(value); }
/*     */   
/*     */   } public int binarySearch(double value, int fromIndex, int toIndex) {
/* 183 */     synchronized (this.mutex) { return this.list.binarySearch(value, fromIndex, toIndex); }
/*     */   
/*     */   }
/*     */   public TDoubleList grep(TDoubleProcedure condition) {
/* 187 */     synchronized (this.mutex) { return this.list.grep(condition); }
/*     */   
/*     */   } public TDoubleList inverseGrep(TDoubleProcedure condition) {
/* 190 */     synchronized (this.mutex) { return this.list.inverseGrep(condition); }
/*     */   
/*     */   }
/* 193 */   public double max() { synchronized (this.mutex) { return this.list.max(); }
/* 194 */      } public double min() { synchronized (this.mutex) { return this.list.min(); }
/* 195 */      } public double sum() { synchronized (this.mutex) { return this.list.sum(); }
/*     */      }
/*     */    public boolean forEachDescending(TDoubleProcedure procedure) {
/* 198 */     synchronized (this.mutex) { return this.list.forEachDescending(procedure); }
/*     */   
/*     */   }
/*     */   public void transformValues(TDoubleFunction function) {
/* 202 */     synchronized (this.mutex) { this.list.transformValues(function); }
/*     */   
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
/*     */   private Object readResolve() {
/* 218 */     return (this.list instanceof java.util.RandomAccess) ? new TSynchronizedRandomAccessDoubleList(this.list) : this;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedDoubleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */