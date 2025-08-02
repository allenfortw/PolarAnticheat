/*     */ package gnu.trove.impl.sync;
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
/*     */ 
/*     */ 
/*     */ public class TSynchronizedCharList
/*     */   extends TSynchronizedCharCollection
/*     */   implements TCharList
/*     */ {
/*     */   static final long serialVersionUID = -7754090372962971524L;
/*     */   final TCharList list;
/*     */   
/*     */   public TSynchronizedCharList(TCharList list) {
/*  60 */     super((TCharCollection)list);
/*  61 */     this.list = list;
/*     */   }
/*     */   public TSynchronizedCharList(TCharList list, Object mutex) {
/*  64 */     super((TCharCollection)list, mutex);
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
/*     */   public char get(int index) {
/*  76 */     synchronized (this.mutex) { return this.list.get(index); }
/*     */   
/*     */   } public char set(int index, char element) {
/*  79 */     synchronized (this.mutex) { return this.list.set(index, element); }
/*     */   
/*     */   } public void set(int offset, char[] values) {
/*  82 */     synchronized (this.mutex) { this.list.set(offset, values); }
/*     */   
/*     */   } public void set(int offset, char[] values, int valOffset, int length) {
/*  85 */     synchronized (this.mutex) { this.list.set(offset, values, valOffset, length); }
/*     */   
/*     */   }
/*     */   public char replace(int offset, char val) {
/*  89 */     synchronized (this.mutex) { return this.list.replace(offset, val); }
/*     */   
/*     */   } public void remove(int offset, int length) {
/*  92 */     synchronized (this.mutex) { this.list.remove(offset, length); }
/*     */   
/*     */   } public char removeAt(int offset) {
/*  95 */     synchronized (this.mutex) { return this.list.removeAt(offset); }
/*     */   
/*     */   }
/*     */   public void add(char[] vals) {
/*  99 */     synchronized (this.mutex) { this.list.add(vals); }
/*     */   
/*     */   } public void add(char[] vals, int offset, int length) {
/* 102 */     synchronized (this.mutex) { this.list.add(vals, offset, length); }
/*     */   
/*     */   }
/*     */   public void insert(int offset, char value) {
/* 106 */     synchronized (this.mutex) { this.list.insert(offset, value); }
/*     */   
/*     */   } public void insert(int offset, char[] values) {
/* 109 */     synchronized (this.mutex) { this.list.insert(offset, values); }
/*     */   
/*     */   } public void insert(int offset, char[] values, int valOffset, int len) {
/* 112 */     synchronized (this.mutex) { this.list.insert(offset, values, valOffset, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(char o) {
/* 116 */     synchronized (this.mutex) { return this.list.indexOf(o); }
/*     */   
/*     */   } public int lastIndexOf(char o) {
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
/*     */   public TCharList subList(int fromIndex, int toIndex) {
/* 131 */     synchronized (this.mutex) {
/* 132 */       return new TSynchronizedCharList(this.list.subList(fromIndex, toIndex), this.mutex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public char[] toArray(int offset, int len) {
/* 138 */     synchronized (this.mutex) { return this.list.toArray(offset, len); }
/*     */   
/*     */   } public char[] toArray(char[] dest, int offset, int len) {
/* 141 */     synchronized (this.mutex) { return this.list.toArray(dest, offset, len); }
/*     */   
/*     */   } public char[] toArray(char[] dest, int source_pos, int dest_pos, int len) {
/* 144 */     synchronized (this.mutex) { return this.list.toArray(dest, source_pos, dest_pos, len); }
/*     */   
/*     */   }
/*     */   public int indexOf(int offset, char value) {
/* 148 */     synchronized (this.mutex) { return this.list.indexOf(offset, value); }
/*     */   
/*     */   } public int lastIndexOf(int offset, char value) {
/* 151 */     synchronized (this.mutex) { return this.list.lastIndexOf(offset, value); }
/*     */   
/*     */   }
/*     */   public void fill(char val) {
/* 155 */     synchronized (this.mutex) { this.list.fill(val); }
/*     */   
/*     */   } public void fill(int fromIndex, int toIndex, char val) {
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
/*     */   public int binarySearch(char value) {
/* 180 */     synchronized (this.mutex) { return this.list.binarySearch(value); }
/*     */   
/*     */   } public int binarySearch(char value, int fromIndex, int toIndex) {
/* 183 */     synchronized (this.mutex) { return this.list.binarySearch(value, fromIndex, toIndex); }
/*     */   
/*     */   }
/*     */   public TCharList grep(TCharProcedure condition) {
/* 187 */     synchronized (this.mutex) { return this.list.grep(condition); }
/*     */   
/*     */   } public TCharList inverseGrep(TCharProcedure condition) {
/* 190 */     synchronized (this.mutex) { return this.list.inverseGrep(condition); }
/*     */   
/*     */   }
/* 193 */   public char max() { synchronized (this.mutex) { return this.list.max(); }
/* 194 */      } public char min() { synchronized (this.mutex) { return this.list.min(); }
/* 195 */      } public char sum() { synchronized (this.mutex) { return this.list.sum(); }
/*     */      }
/*     */    public boolean forEachDescending(TCharProcedure procedure) {
/* 198 */     synchronized (this.mutex) { return this.list.forEachDescending(procedure); }
/*     */   
/*     */   }
/*     */   public void transformValues(TCharFunction function) {
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
/* 218 */     return (this.list instanceof java.util.RandomAccess) ? new TSynchronizedRandomAccessCharList(this.list) : this;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedCharList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */