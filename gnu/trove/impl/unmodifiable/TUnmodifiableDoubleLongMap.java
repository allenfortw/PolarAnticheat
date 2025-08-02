/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.TLongCollection;
/*     */ import gnu.trove.function.TLongFunction;
/*     */ import gnu.trove.iterator.TDoubleLongIterator;
/*     */ import gnu.trove.map.TDoubleLongMap;
/*     */ import gnu.trove.procedure.TDoubleLongProcedure;
/*     */ import gnu.trove.procedure.TDoubleProcedure;
/*     */ import gnu.trove.procedure.TLongProcedure;
/*     */ import gnu.trove.set.TDoubleSet;
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
/*     */ public class TUnmodifiableDoubleLongMap
/*     */   implements TDoubleLongMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TDoubleLongMap m;
/*     */   
/*     */   public TUnmodifiableDoubleLongMap(TDoubleLongMap m) {
/*  58 */     if (m == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.m = m;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.m.size(); }
/*  64 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  65 */   public boolean containsKey(double key) { return this.m.containsKey(key); }
/*  66 */   public boolean containsValue(long val) { return this.m.containsValue(val); } public long get(double key) {
/*  67 */     return this.m.get(key);
/*     */   }
/*  69 */   public long put(double key, long value) { throw new UnsupportedOperationException(); }
/*  70 */   public long remove(double key) { throw new UnsupportedOperationException(); }
/*  71 */   public void putAll(TDoubleLongMap m) { throw new UnsupportedOperationException(); }
/*  72 */   public void putAll(Map<? extends Double, ? extends Long> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*  75 */   private transient TDoubleSet keySet = null;
/*  76 */   private transient TLongCollection values = null;
/*     */   
/*     */   public TDoubleSet keySet() {
/*  79 */     if (this.keySet == null)
/*  80 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  81 */     return this.keySet;
/*     */   }
/*  83 */   public double[] keys() { return this.m.keys(); } public double[] keys(double[] array) {
/*  84 */     return this.m.keys(array);
/*     */   }
/*     */   public TLongCollection valueCollection() {
/*  87 */     if (this.values == null)
/*  88 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  89 */     return this.values;
/*     */   }
/*  91 */   public long[] values() { return this.m.values(); } public long[] values(long[] array) {
/*  92 */     return this.m.values(array);
/*     */   }
/*  94 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  95 */   public int hashCode() { return this.m.hashCode(); }
/*  96 */   public String toString() { return this.m.toString(); }
/*  97 */   public double getNoEntryKey() { return this.m.getNoEntryKey(); } public long getNoEntryValue() {
/*  98 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TDoubleProcedure procedure) {
/* 101 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TLongProcedure procedure) {
/* 104 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TDoubleLongProcedure procedure) {
/* 107 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TDoubleLongIterator iterator() {
/* 111 */     return new TDoubleLongIterator() {
/* 112 */         TDoubleLongIterator iter = TUnmodifiableDoubleLongMap.this.m.iterator();
/*     */         
/* 114 */         public double key() { return this.iter.key(); }
/* 115 */         public long value() { return this.iter.value(); }
/* 116 */         public void advance() { this.iter.advance(); }
/* 117 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 118 */         public long setValue(long val) { throw new UnsupportedOperationException(); } public void remove() {
/* 119 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 123 */   public long putIfAbsent(double key, long value) { throw new UnsupportedOperationException(); }
/* 124 */   public void transformValues(TLongFunction function) { throw new UnsupportedOperationException(); }
/* 125 */   public boolean retainEntries(TDoubleLongProcedure procedure) { throw new UnsupportedOperationException(); }
/* 126 */   public boolean increment(double key) { throw new UnsupportedOperationException(); }
/* 127 */   public boolean adjustValue(double key, long amount) { throw new UnsupportedOperationException(); } public long adjustOrPutValue(double key, long adjust_amount, long put_amount) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableDoubleLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */