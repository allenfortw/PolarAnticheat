/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.TDoubleCollection;
/*     */ import gnu.trove.function.TDoubleFunction;
/*     */ import gnu.trove.iterator.TDoubleDoubleIterator;
/*     */ import gnu.trove.map.TDoubleDoubleMap;
/*     */ import gnu.trove.procedure.TDoubleDoubleProcedure;
/*     */ import gnu.trove.procedure.TDoubleProcedure;
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
/*     */ 
/*     */ public class TUnmodifiableDoubleDoubleMap
/*     */   implements TDoubleDoubleMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TDoubleDoubleMap m;
/*     */   
/*     */   public TUnmodifiableDoubleDoubleMap(TDoubleDoubleMap m) {
/*  58 */     if (m == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.m = m;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.m.size(); }
/*  64 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  65 */   public boolean containsKey(double key) { return this.m.containsKey(key); }
/*  66 */   public boolean containsValue(double val) { return this.m.containsValue(val); } public double get(double key) {
/*  67 */     return this.m.get(key);
/*     */   }
/*  69 */   public double put(double key, double value) { throw new UnsupportedOperationException(); }
/*  70 */   public double remove(double key) { throw new UnsupportedOperationException(); }
/*  71 */   public void putAll(TDoubleDoubleMap m) { throw new UnsupportedOperationException(); }
/*  72 */   public void putAll(Map<? extends Double, ? extends Double> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*  75 */   private transient TDoubleSet keySet = null;
/*  76 */   private transient TDoubleCollection values = null;
/*     */   
/*     */   public TDoubleSet keySet() {
/*  79 */     if (this.keySet == null)
/*  80 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  81 */     return this.keySet;
/*     */   }
/*  83 */   public double[] keys() { return this.m.keys(); } public double[] keys(double[] array) {
/*  84 */     return this.m.keys(array);
/*     */   }
/*     */   public TDoubleCollection valueCollection() {
/*  87 */     if (this.values == null)
/*  88 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  89 */     return this.values;
/*     */   }
/*  91 */   public double[] values() { return this.m.values(); } public double[] values(double[] array) {
/*  92 */     return this.m.values(array);
/*     */   }
/*  94 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  95 */   public int hashCode() { return this.m.hashCode(); }
/*  96 */   public String toString() { return this.m.toString(); }
/*  97 */   public double getNoEntryKey() { return this.m.getNoEntryKey(); } public double getNoEntryValue() {
/*  98 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TDoubleProcedure procedure) {
/* 101 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TDoubleProcedure procedure) {
/* 104 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TDoubleDoubleProcedure procedure) {
/* 107 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TDoubleDoubleIterator iterator() {
/* 111 */     return new TDoubleDoubleIterator() {
/* 112 */         TDoubleDoubleIterator iter = TUnmodifiableDoubleDoubleMap.this.m.iterator();
/*     */         
/* 114 */         public double key() { return this.iter.key(); }
/* 115 */         public double value() { return this.iter.value(); }
/* 116 */         public void advance() { this.iter.advance(); }
/* 117 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 118 */         public double setValue(double val) { throw new UnsupportedOperationException(); } public void remove() {
/* 119 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 123 */   public double putIfAbsent(double key, double value) { throw new UnsupportedOperationException(); }
/* 124 */   public void transformValues(TDoubleFunction function) { throw new UnsupportedOperationException(); }
/* 125 */   public boolean retainEntries(TDoubleDoubleProcedure procedure) { throw new UnsupportedOperationException(); }
/* 126 */   public boolean increment(double key) { throw new UnsupportedOperationException(); }
/* 127 */   public boolean adjustValue(double key, double amount) { throw new UnsupportedOperationException(); } public double adjustOrPutValue(double key, double adjust_amount, double put_amount) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableDoubleDoubleMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */