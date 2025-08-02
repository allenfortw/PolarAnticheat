/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TShortCollection;
/*     */ import gnu.trove.function.TShortFunction;
/*     */ import gnu.trove.iterator.TObjectShortIterator;
/*     */ import gnu.trove.map.TObjectShortMap;
/*     */ import gnu.trove.procedure.TObjectProcedure;
/*     */ import gnu.trove.procedure.TObjectShortProcedure;
/*     */ import gnu.trove.procedure.TShortProcedure;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TSynchronizedObjectShortMap<K>
/*     */   implements TObjectShortMap<K>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1978198479659022715L;
/*     */   private final TObjectShortMap<K> m;
/*     */   final Object mutex;
/*     */   
/*     */   public TSynchronizedObjectShortMap(TObjectShortMap<K> m) {
/*  59 */     if (m == null)
/*  60 */       throw new NullPointerException(); 
/*  61 */     this.m = m;
/*  62 */     this.mutex = this;
/*     */   }
/*     */   
/*     */   public TSynchronizedObjectShortMap(TObjectShortMap<K> m, Object mutex) {
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
/*     */   } public boolean containsKey(Object key) {
/*  77 */     synchronized (this.mutex) { return this.m.containsKey(key); }
/*     */   
/*     */   } public boolean containsValue(short value) {
/*  80 */     synchronized (this.mutex) { return this.m.containsValue(value); }
/*     */   
/*     */   } public short get(Object key) {
/*  83 */     synchronized (this.mutex) { return this.m.get(key); }
/*     */   
/*     */   }
/*     */   public short put(K key, short value) {
/*  87 */     synchronized (this.mutex) { return this.m.put(key, value); }
/*     */   
/*     */   } public short remove(Object key) {
/*  90 */     synchronized (this.mutex) { return this.m.remove(key); }
/*     */   
/*     */   } public void putAll(Map<? extends K, ? extends Short> map) {
/*  93 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void putAll(TObjectShortMap<? extends K> map) {
/*  96 */     synchronized (this.mutex) { this.m.putAll(map); }
/*     */   
/*     */   } public void clear() {
/*  99 */     synchronized (this.mutex) { this.m.clear(); }
/*     */   
/*     */   }
/* 102 */   private transient Set<K> keySet = null;
/* 103 */   private transient TShortCollection values = null;
/*     */   
/*     */   public Set<K> keySet() {
/* 106 */     synchronized (this.mutex) {
/* 107 */       if (this.keySet == null) {
/* 108 */         this.keySet = new SynchronizedSet<K>(this.m.keySet(), this.mutex);
/*     */       }
/* 110 */       return this.keySet;
/*     */     } 
/*     */   }
/*     */   public Object[] keys() {
/* 114 */     synchronized (this.mutex) { return this.m.keys(); }
/*     */   
/*     */   } public K[] keys(K[] array) {
/* 117 */     synchronized (this.mutex) { return (K[])this.m.keys((Object[])array); }
/*     */   
/*     */   }
/*     */   public TShortCollection valueCollection() {
/* 121 */     synchronized (this.mutex) {
/* 122 */       if (this.values == null)
/* 123 */         this.values = new TSynchronizedShortCollection(this.m.valueCollection(), this.mutex); 
/* 124 */       return this.values;
/*     */     } 
/*     */   }
/*     */   public short[] values() {
/* 128 */     synchronized (this.mutex) { return this.m.values(); }
/*     */   
/*     */   } public short[] values(short[] array) {
/* 131 */     synchronized (this.mutex) { return this.m.values(array); }
/*     */   
/*     */   }
/*     */   public TObjectShortIterator<K> iterator() {
/* 135 */     return this.m.iterator();
/*     */   }
/*     */   
/*     */   public short getNoEntryValue() {
/* 139 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public short putIfAbsent(K key, short value) {
/* 142 */     synchronized (this.mutex) { return this.m.putIfAbsent(key, value); }
/*     */   
/*     */   } public boolean forEachKey(TObjectProcedure<? super K> procedure) {
/* 145 */     synchronized (this.mutex) { return this.m.forEachKey(procedure); }
/*     */   
/*     */   } public boolean forEachValue(TShortProcedure procedure) {
/* 148 */     synchronized (this.mutex) { return this.m.forEachValue(procedure); }
/*     */   
/*     */   } public boolean forEachEntry(TObjectShortProcedure<? super K> procedure) {
/* 151 */     synchronized (this.mutex) { return this.m.forEachEntry(procedure); }
/*     */   
/*     */   } public void transformValues(TShortFunction function) {
/* 154 */     synchronized (this.mutex) { this.m.transformValues(function); }
/*     */   
/*     */   } public boolean retainEntries(TObjectShortProcedure<? super K> procedure) {
/* 157 */     synchronized (this.mutex) { return this.m.retainEntries(procedure); }
/*     */   
/*     */   } public boolean increment(K key) {
/* 160 */     synchronized (this.mutex) { return this.m.increment(key); }
/*     */   
/*     */   } public boolean adjustValue(K key, short amount) {
/* 163 */     synchronized (this.mutex) { return this.m.adjustValue(key, amount); }
/*     */   
/*     */   } public short adjustOrPutValue(K key, short adjust_amount, short put_amount) {
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedObjectShortMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */