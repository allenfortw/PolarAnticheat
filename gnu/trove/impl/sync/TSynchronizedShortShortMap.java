/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TShortCollection;
/*     */ import gnu.trove.function.TShortFunction;
/*     */ import gnu.trove.iterator.TShortShortIterator;
/*     */ import gnu.trove.map.TShortShortMap;
/*     */ import gnu.trove.procedure.TShortProcedure;
/*     */ import gnu.trove.procedure.TShortShortProcedure;
/*     */ import gnu.trove.set.TShortSet;
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
/*     */ 
/*     */ public class TSynchronizedShortShortMap
/*     */   implements TShortShortMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1978198479659022715L;
/*     */   private final TShortShortMap m;
/*     */   final Object mutex;
/*     */   
/*     */   public TSynchronizedShortShortMap(TShortShortMap m) {
/*  59 */     if (m == null)
/*  60 */       throw new NullPointerException(); 
/*  61 */     this.m = m;
/*  62 */     this.mutex = this;
/*     */   }
/*     */   
/*     */   public TSynchronizedShortShortMap(TShortShortMap m, Object mutex) {
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
/*     */   } public boolean containsKey(short key) {
/*  77 */     synchronized (this.mutex) { return this.m.containsKey(key); }
/*     */   
/*     */   } public boolean containsValue(short value) {
/*  80 */     synchronized (this.mutex) { return this.m.containsValue(value); }
/*     */   
/*     */   } public short get(short key) {
/*  83 */     synchronized (this.mutex) { return this.m.get(key); }
/*     */   
/*     */   }
/*     */   public short put(short key, short value) {
/*  87 */     synchronized (this.mutex) { return this.m.put(key, value); }
/*     */   
/*     */   } public short remove(short key) {
/*  90 */     synchronized (this.mutex) { return this.m.remove(key); }
/*     */   
/*     */   } public void putAll(Map<? extends Short, ? extends Short> map) {
/*  93 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void putAll(TShortShortMap map) {
/*  96 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void clear() {
/*  99 */     synchronized (this.mutex) { this.m.clear(); }
/*     */   
/*     */   }
/* 102 */   private transient TShortSet keySet = null;
/* 103 */   private transient TShortCollection values = null;
/*     */   
/*     */   public TShortSet keySet() {
/* 106 */     synchronized (this.mutex) {
/* 107 */       if (this.keySet == null)
/* 108 */         this.keySet = new TSynchronizedShortSet(this.m.keySet(), this.mutex); 
/* 109 */       return this.keySet;
/*     */     } 
/*     */   }
/*     */   public short[] keys() {
/* 113 */     synchronized (this.mutex) { return this.m.keys(); }
/*     */   
/*     */   } public short[] keys(short[] array) {
/* 116 */     synchronized (this.mutex) { return this.m.keys(array); }
/*     */   
/*     */   }
/*     */   public TShortCollection valueCollection() {
/* 120 */     synchronized (this.mutex) {
/* 121 */       if (this.values == null)
/* 122 */         this.values = new TSynchronizedShortCollection(this.m.valueCollection(), this.mutex); 
/* 123 */       return this.values;
/*     */     } 
/*     */   }
/*     */   public short[] values() {
/* 127 */     synchronized (this.mutex) { return this.m.values(); }
/*     */   
/*     */   } public short[] values(short[] array) {
/* 130 */     synchronized (this.mutex) { return this.m.values(array); }
/*     */   
/*     */   }
/*     */   public TShortShortIterator iterator() {
/* 134 */     return this.m.iterator();
/*     */   }
/*     */   
/*     */   public short getNoEntryKey() {
/* 138 */     return this.m.getNoEntryKey(); } public short getNoEntryValue() {
/* 139 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public short putIfAbsent(short key, short value) {
/* 142 */     synchronized (this.mutex) { return this.m.putIfAbsent(key, value); }
/*     */   
/*     */   } public boolean forEachKey(TShortProcedure procedure) {
/* 145 */     synchronized (this.mutex) { return this.m.forEachKey(procedure); }
/*     */   
/*     */   } public boolean forEachValue(TShortProcedure procedure) {
/* 148 */     synchronized (this.mutex) { return this.m.forEachValue(procedure); }
/*     */   
/*     */   } public boolean forEachEntry(TShortShortProcedure procedure) {
/* 151 */     synchronized (this.mutex) { return this.m.forEachEntry(procedure); }
/*     */   
/*     */   } public void transformValues(TShortFunction function) {
/* 154 */     synchronized (this.mutex) { this.m.transformValues(function); }
/*     */   
/*     */   } public boolean retainEntries(TShortShortProcedure procedure) {
/* 157 */     synchronized (this.mutex) { return this.m.retainEntries(procedure); }
/*     */   
/*     */   } public boolean increment(short key) {
/* 160 */     synchronized (this.mutex) { return this.m.increment(key); }
/*     */   
/*     */   } public boolean adjustValue(short key, short amount) {
/* 163 */     synchronized (this.mutex) { return this.m.adjustValue(key, amount); }
/*     */   
/*     */   } public short adjustOrPutValue(short key, short adjust_amount, short put_amount) {
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedShortShortMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */