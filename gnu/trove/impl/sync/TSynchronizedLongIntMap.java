/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TIntCollection;
/*     */ import gnu.trove.function.TIntFunction;
/*     */ import gnu.trove.iterator.TLongIntIterator;
/*     */ import gnu.trove.map.TLongIntMap;
/*     */ import gnu.trove.procedure.TIntProcedure;
/*     */ import gnu.trove.procedure.TLongIntProcedure;
/*     */ import gnu.trove.procedure.TLongProcedure;
/*     */ import gnu.trove.set.TLongSet;
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
/*     */ public class TSynchronizedLongIntMap
/*     */   implements TLongIntMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1978198479659022715L;
/*     */   private final TLongIntMap m;
/*     */   final Object mutex;
/*     */   
/*     */   public TSynchronizedLongIntMap(TLongIntMap m) {
/*  59 */     if (m == null)
/*  60 */       throw new NullPointerException(); 
/*  61 */     this.m = m;
/*  62 */     this.mutex = this;
/*     */   }
/*     */   
/*     */   public TSynchronizedLongIntMap(TLongIntMap m, Object mutex) {
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
/*     */   } public boolean containsKey(long key) {
/*  77 */     synchronized (this.mutex) { return this.m.containsKey(key); }
/*     */   
/*     */   } public boolean containsValue(int value) {
/*  80 */     synchronized (this.mutex) { return this.m.containsValue(value); }
/*     */   
/*     */   } public int get(long key) {
/*  83 */     synchronized (this.mutex) { return this.m.get(key); }
/*     */   
/*     */   }
/*     */   public int put(long key, int value) {
/*  87 */     synchronized (this.mutex) { return this.m.put(key, value); }
/*     */   
/*     */   } public int remove(long key) {
/*  90 */     synchronized (this.mutex) { return this.m.remove(key); }
/*     */   
/*     */   } public void putAll(Map<? extends Long, ? extends Integer> map) {
/*  93 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void putAll(TLongIntMap map) {
/*  96 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void clear() {
/*  99 */     synchronized (this.mutex) { this.m.clear(); }
/*     */   
/*     */   }
/* 102 */   private transient TLongSet keySet = null;
/* 103 */   private transient TIntCollection values = null;
/*     */   
/*     */   public TLongSet keySet() {
/* 106 */     synchronized (this.mutex) {
/* 107 */       if (this.keySet == null)
/* 108 */         this.keySet = new TSynchronizedLongSet(this.m.keySet(), this.mutex); 
/* 109 */       return this.keySet;
/*     */     } 
/*     */   }
/*     */   public long[] keys() {
/* 113 */     synchronized (this.mutex) { return this.m.keys(); }
/*     */   
/*     */   } public long[] keys(long[] array) {
/* 116 */     synchronized (this.mutex) { return this.m.keys(array); }
/*     */   
/*     */   }
/*     */   public TIntCollection valueCollection() {
/* 120 */     synchronized (this.mutex) {
/* 121 */       if (this.values == null)
/* 122 */         this.values = new TSynchronizedIntCollection(this.m.valueCollection(), this.mutex); 
/* 123 */       return this.values;
/*     */     } 
/*     */   }
/*     */   public int[] values() {
/* 127 */     synchronized (this.mutex) { return this.m.values(); }
/*     */   
/*     */   } public int[] values(int[] array) {
/* 130 */     synchronized (this.mutex) { return this.m.values(array); }
/*     */   
/*     */   }
/*     */   public TLongIntIterator iterator() {
/* 134 */     return this.m.iterator();
/*     */   }
/*     */   
/*     */   public long getNoEntryKey() {
/* 138 */     return this.m.getNoEntryKey(); } public int getNoEntryValue() {
/* 139 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public int putIfAbsent(long key, int value) {
/* 142 */     synchronized (this.mutex) { return this.m.putIfAbsent(key, value); }
/*     */   
/*     */   } public boolean forEachKey(TLongProcedure procedure) {
/* 145 */     synchronized (this.mutex) { return this.m.forEachKey(procedure); }
/*     */   
/*     */   } public boolean forEachValue(TIntProcedure procedure) {
/* 148 */     synchronized (this.mutex) { return this.m.forEachValue(procedure); }
/*     */   
/*     */   } public boolean forEachEntry(TLongIntProcedure procedure) {
/* 151 */     synchronized (this.mutex) { return this.m.forEachEntry(procedure); }
/*     */   
/*     */   } public void transformValues(TIntFunction function) {
/* 154 */     synchronized (this.mutex) { this.m.transformValues(function); }
/*     */   
/*     */   } public boolean retainEntries(TLongIntProcedure procedure) {
/* 157 */     synchronized (this.mutex) { return this.m.retainEntries(procedure); }
/*     */   
/*     */   } public boolean increment(long key) {
/* 160 */     synchronized (this.mutex) { return this.m.increment(key); }
/*     */   
/*     */   } public boolean adjustValue(long key, int amount) {
/* 163 */     synchronized (this.mutex) { return this.m.adjustValue(key, amount); }
/*     */   
/*     */   } public int adjustOrPutValue(long key, int adjust_amount, int put_amount) {
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedLongIntMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */