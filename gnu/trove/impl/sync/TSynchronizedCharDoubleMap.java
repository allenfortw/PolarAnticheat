/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TDoubleCollection;
/*     */ import gnu.trove.function.TDoubleFunction;
/*     */ import gnu.trove.iterator.TCharDoubleIterator;
/*     */ import gnu.trove.map.TCharDoubleMap;
/*     */ import gnu.trove.procedure.TCharDoubleProcedure;
/*     */ import gnu.trove.procedure.TCharProcedure;
/*     */ import gnu.trove.procedure.TDoubleProcedure;
/*     */ import gnu.trove.set.TCharSet;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TSynchronizedCharDoubleMap
/*     */   implements TCharDoubleMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1978198479659022715L;
/*     */   private final TCharDoubleMap m;
/*     */   final Object mutex;
/*     */   
/*     */   public TSynchronizedCharDoubleMap(TCharDoubleMap m) {
/*  59 */     if (m == null)
/*  60 */       throw new NullPointerException(); 
/*  61 */     this.m = m;
/*  62 */     this.mutex = this;
/*     */   }
/*     */   
/*     */   public TSynchronizedCharDoubleMap(TCharDoubleMap m, Object mutex) {
/*  66 */     this.m = m;
/*  67 */     this.mutex = mutex;
/*     */   }
/*     */   
/*     */   public int size() {
/*  71 */     synchronized (this.mutex) { return this.m.size(); }
/*     */   
/*     */   } public boolean isEmpty() {
/*  74 */     synchronized (this.mutex) { return this.m.isEmpty(); }
/*     */   
/*     */   } public boolean containsKey(char key) {
/*  77 */     synchronized (this.mutex) { return this.m.containsKey(key); }
/*     */   
/*     */   } public boolean containsValue(double value) {
/*  80 */     synchronized (this.mutex) { return this.m.containsValue(value); }
/*     */   
/*     */   } public double get(char key) {
/*  83 */     synchronized (this.mutex) { return this.m.get(key); }
/*     */   
/*     */   }
/*     */   public double put(char key, double value) {
/*  87 */     synchronized (this.mutex) { return this.m.put(key, value); }
/*     */   
/*     */   } public double remove(char key) {
/*  90 */     synchronized (this.mutex) { return this.m.remove(key); }
/*     */   
/*     */   } public void putAll(Map<? extends Character, ? extends Double> map) {
/*  93 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void putAll(TCharDoubleMap map) {
/*  96 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void clear() {
/*  99 */     synchronized (this.mutex) { this.m.clear(); }
/*     */   
/*     */   }
/* 102 */   private transient TCharSet keySet = null;
/* 103 */   private transient TDoubleCollection values = null;
/*     */   
/*     */   public TCharSet keySet() {
/* 106 */     synchronized (this.mutex) {
/* 107 */       if (this.keySet == null)
/* 108 */         this.keySet = new TSynchronizedCharSet(this.m.keySet(), this.mutex); 
/* 109 */       return this.keySet;
/*     */     } 
/*     */   }
/*     */   public char[] keys() {
/* 113 */     synchronized (this.mutex) { return this.m.keys(); }
/*     */   
/*     */   } public char[] keys(char[] array) {
/* 116 */     synchronized (this.mutex) { return this.m.keys(array); }
/*     */   
/*     */   }
/*     */   public TDoubleCollection valueCollection() {
/* 120 */     synchronized (this.mutex) {
/* 121 */       if (this.values == null)
/* 122 */         this.values = new TSynchronizedDoubleCollection(this.m.valueCollection(), this.mutex); 
/* 123 */       return this.values;
/*     */     } 
/*     */   }
/*     */   public double[] values() {
/* 127 */     synchronized (this.mutex) { return this.m.values(); }
/*     */   
/*     */   } public double[] values(double[] array) {
/* 130 */     synchronized (this.mutex) { return this.m.values(array); }
/*     */   
/*     */   }
/*     */   public TCharDoubleIterator iterator() {
/* 134 */     return this.m.iterator();
/*     */   }
/*     */   
/*     */   public char getNoEntryKey() {
/* 138 */     return this.m.getNoEntryKey(); } public double getNoEntryValue() {
/* 139 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public double putIfAbsent(char key, double value) {
/* 142 */     synchronized (this.mutex) { return this.m.putIfAbsent(key, value); }
/*     */   
/*     */   } public boolean forEachKey(TCharProcedure procedure) {
/* 145 */     synchronized (this.mutex) { return this.m.forEachKey(procedure); }
/*     */   
/*     */   } public boolean forEachValue(TDoubleProcedure procedure) {
/* 148 */     synchronized (this.mutex) { return this.m.forEachValue(procedure); }
/*     */   
/*     */   } public boolean forEachEntry(TCharDoubleProcedure procedure) {
/* 151 */     synchronized (this.mutex) { return this.m.forEachEntry(procedure); }
/*     */   
/*     */   } public void transformValues(TDoubleFunction function) {
/* 154 */     synchronized (this.mutex) { this.m.transformValues(function); }
/*     */   
/*     */   } public boolean retainEntries(TCharDoubleProcedure procedure) {
/* 157 */     synchronized (this.mutex) { return this.m.retainEntries(procedure); }
/*     */   
/*     */   } public boolean increment(char key) {
/* 160 */     synchronized (this.mutex) { return this.m.increment(key); }
/*     */   
/*     */   } public boolean adjustValue(char key, double amount) {
/* 163 */     synchronized (this.mutex) { return this.m.adjustValue(key, amount); }
/*     */   
/*     */   } public double adjustOrPutValue(char key, double adjust_amount, double put_amount) {
/* 166 */     synchronized (this.mutex) { return this.m.adjustOrPutValue(key, adjust_amount, put_amount); }
/*     */   
/*     */   }
/*     */   public boolean equals(Object o) {
/* 170 */     synchronized (this.mutex) { return this.m.equals(o); }
/*     */   
/*     */   } public int hashCode() {
/* 173 */     synchronized (this.mutex) { return this.m.hashCode(); }
/*     */   
/*     */   } public String toString() {
/* 176 */     synchronized (this.mutex) { return this.m.toString(); }
/*     */   
/*     */   } private void writeObject(ObjectOutputStream s) throws IOException {
/* 179 */     synchronized (this.mutex) { s.defaultWriteObject(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedCharDoubleMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */