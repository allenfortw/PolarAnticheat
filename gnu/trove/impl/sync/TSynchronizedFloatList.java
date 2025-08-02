/*     */ package gnu.trove.impl.sync;
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
/*     */ 
/*     */ 
/*     */ public class TSynchronizedFloatList
/*     */   extends TSynchronizedFloatCollection
/*     */   implements TFloatList
/*     */ {
/*     */   static final long serialVersionUID = -7754090372962971524L;
/*     */   final TFloatList list;
/*     */   
/*     */   public TSynchronizedFloatList(TFloatList list) {
/*  60 */     super((TFloatCollection)list);
/*  61 */     this.list = list;
/*     */   }
/*     */   public TSynchronizedFloatList(TFloatList list, Object mutex) {
/*  64 */     super((TFloatCollection)list, mutex);
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
/*     */   public float get(int index) {
/*  76 */     synchronized (this.mutex) { return this.list.get(index); }
/*     */   
/*     */   } public float set(int index, float element) {
/*  79 */     synchronized (this.mutex) { return this.list.set(index, element); }
/*     */   
/*     */   } public void set(int offset, float[] values) {
/*  82 */     synchronized (this.mutex) { this.list.set(offset, values); }
/*     */   
/*     */   } public void set(int offset, float[] values, int valOffset, int length) {
/*  85 */     synchronized (this.mutex) { this.list.set(offset, values, valOffset, length); }
/*     */   
/*     */   }
/*     */   public float replace(int offset, float val) {
/*  89 */     synchronized (this.mutex) { return this.list.replace(offset, val); }
/*     */   
/*     */   } public void remove(int offset, int length) {
/*  92 */     synchronized (this.mutex) { this.list.remove(offset, length); }
/*     */   
/*     */   } public float removeAt(int offset) {
/*  95 */     synchronized (this.mutex) { return this.list.removeAt(offset); }
/*     */   
/*     */   }
/*     */   public void add(float[] vals) {
/*  99 */     synchronized (this.mutex) { this.list.add(vals); }
/*     */   
/*     */   } public void add(float[] vals, int offset, int length) {
/* 102 */     synchronized (this.mutex) { this.list.add(vals, offset, length); }
/*     */   
/*     */   }
/*     */   public void insert(int offset, float value) {
/* 106 */     synchronized (this.mutex) { this.list.insert(offset, value); }
/*     */   
/*     */   } public void insert(int offset, float[] values) {
/* 109 */     synchronized (this.mutex) { this.list.insert(offset, values); }
/*     */   
/*     */   } public void insert(int offset, float[] values, int valOffset, int len) {
/* 112 */     synchronized (this.mutex) { this.list.insert(offset, values, valOffset, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(float o) {
/* 116 */     synchronized (this.mutex) { return this.list.indexOf(o); }
/*     */   
/*     */   } public int lastIndexOf(float o) {
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
/*     */   public TFloatList subList(int fromIndex, int toIndex) {
/* 131 */     synchronized (this.mutex) {
/* 132 */       return new TSynchronizedFloatList(this.list.subList(fromIndex, toIndex), this.mutex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float[] toArray(int offset, int len) {
/* 138 */     synchronized (this.mutex) { return this.list.toArray(offset, len); }
/*     */   
/*     */   } public float[] toArray(float[] dest, int offset, int len) {
/* 141 */     synchronized (this.mutex) { return this.list.toArray(dest, offset, len); }
/*     */   
/*     */   } public float[] toArray(float[] dest, int source_pos, int dest_pos, int len) {
/* 144 */     synchronized (this.mutex) { return this.list.toArray(dest, source_pos, dest_pos, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(int offset, float value) {
/* 148 */     synchronized (this.mutex) { return this.list.indexOf(offset, value); }
/*     */   
/*     */   } public int lastIndexOf(int offset, float value) {
/* 151 */     synchronized (this.mutex) { return this.list.lastIndexOf(offset, value); }
/*     */   
/*     */   }
/*     */   public void fill(float val) {
/* 155 */     synchronized (this.mutex) { this.list.fill(val); }
/*     */   
/*     */   } public void fill(int fromIndex, int toIndex, float val) {
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
/*     */   public int binarySearch(float value) {
/* 180 */     synchronized (this.mutex) { return this.list.binarySearch(value); }
/*     */   
/*     */   } public int binarySearch(float value, int fromIndex, int toIndex) {
/* 183 */     synchronized (this.mutex) { return this.list.binarySearch(value, fromIndex, toIndex); }
/*     */   
/*     */   }
/*     */   public TFloatList grep(TFloatProcedure condition) {
/* 187 */     synchronized (this.mutex) { return this.list.grep(condition); }
/*     */   
/*     */   } public TFloatList inverseGrep(TFloatProcedure condition) {
/* 190 */     synchronized (this.mutex) { return this.list.inverseGrep(condition); }
/*     */   
/*     */   }
/* 193 */   public float max() { synchronized (this.mutex) { return this.list.max(); }
/* 194 */      } public float min() { synchronized (this.mutex) { return this.list.min(); }
/* 195 */      } public float sum() { synchronized (this.mutex) { return this.list.sum(); }
/*     */      }
/*     */    public boolean forEachDescending(TFloatProcedure procedure) {
/* 198 */     synchronized (this.mutex) { return this.list.forEachDescending(procedure); }
/*     */   
/*     */   }
/*     */   public void transformValues(TFloatFunction function) {
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
/* 218 */     return (this.list instanceof java.util.RandomAccess) ? new TSynchronizedRandomAccessFloatList(this.list) : this;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedFloatList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */