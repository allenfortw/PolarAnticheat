/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.TFloatCollection;
/*     */ import gnu.trove.function.TFloatFunction;
/*     */ import gnu.trove.iterator.TLongFloatIterator;
/*     */ import gnu.trove.map.TLongFloatMap;
/*     */ import gnu.trove.procedure.TFloatProcedure;
/*     */ import gnu.trove.procedure.TLongFloatProcedure;
/*     */ import gnu.trove.procedure.TLongProcedure;
/*     */ import gnu.trove.set.TLongSet;
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
/*     */ public class TUnmodifiableLongFloatMap
/*     */   implements TLongFloatMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TLongFloatMap m;
/*     */   
/*     */   public TUnmodifiableLongFloatMap(TLongFloatMap m) {
/*  58 */     if (m == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.m = m;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.m.size(); }
/*  64 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  65 */   public boolean containsKey(long key) { return this.m.containsKey(key); }
/*  66 */   public boolean containsValue(float val) { return this.m.containsValue(val); } public float get(long key) {
/*  67 */     return this.m.get(key);
/*     */   }
/*  69 */   public float put(long key, float value) { throw new UnsupportedOperationException(); }
/*  70 */   public float remove(long key) { throw new UnsupportedOperationException(); }
/*  71 */   public void putAll(TLongFloatMap m) { throw new UnsupportedOperationException(); }
/*  72 */   public void putAll(Map<? extends Long, ? extends Float> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*  75 */   private transient TLongSet keySet = null;
/*  76 */   private transient TFloatCollection values = null;
/*     */   
/*     */   public TLongSet keySet() {
/*  79 */     if (this.keySet == null)
/*  80 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  81 */     return this.keySet;
/*     */   }
/*  83 */   public long[] keys() { return this.m.keys(); } public long[] keys(long[] array) {
/*  84 */     return this.m.keys(array);
/*     */   }
/*     */   public TFloatCollection valueCollection() {
/*  87 */     if (this.values == null)
/*  88 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  89 */     return this.values;
/*     */   }
/*  91 */   public float[] values() { return this.m.values(); } public float[] values(float[] array) {
/*  92 */     return this.m.values(array);
/*     */   }
/*  94 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  95 */   public int hashCode() { return this.m.hashCode(); }
/*  96 */   public String toString() { return this.m.toString(); }
/*  97 */   public long getNoEntryKey() { return this.m.getNoEntryKey(); } public float getNoEntryValue() {
/*  98 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TLongProcedure procedure) {
/* 101 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TFloatProcedure procedure) {
/* 104 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TLongFloatProcedure procedure) {
/* 107 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TLongFloatIterator iterator() {
/* 111 */     return new TLongFloatIterator() {
/* 112 */         TLongFloatIterator iter = TUnmodifiableLongFloatMap.this.m.iterator();
/*     */         
/* 114 */         public long key() { return this.iter.key(); }
/* 115 */         public float value() { return this.iter.value(); }
/* 116 */         public void advance() { this.iter.advance(); }
/* 117 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 118 */         public float setValue(float val) { throw new UnsupportedOperationException(); } public void remove() {
/* 119 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 123 */   public float putIfAbsent(long key, float value) { throw new UnsupportedOperationException(); }
/* 124 */   public void transformValues(TFloatFunction function) { throw new UnsupportedOperationException(); }
/* 125 */   public boolean retainEntries(TLongFloatProcedure procedure) { throw new UnsupportedOperationException(); }
/* 126 */   public boolean increment(long key) { throw new UnsupportedOperationException(); }
/* 127 */   public boolean adjustValue(long key, float amount) { throw new UnsupportedOperationException(); } public float adjustOrPutValue(long key, float adjust_amount, float put_amount) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableLongFloatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */