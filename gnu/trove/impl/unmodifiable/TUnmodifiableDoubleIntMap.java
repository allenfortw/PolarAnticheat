/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.TIntCollection;
/*     */ import gnu.trove.function.TIntFunction;
/*     */ import gnu.trove.iterator.TDoubleIntIterator;
/*     */ import gnu.trove.map.TDoubleIntMap;
/*     */ import gnu.trove.procedure.TDoubleIntProcedure;
/*     */ import gnu.trove.procedure.TDoubleProcedure;
/*     */ import gnu.trove.procedure.TIntProcedure;
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
/*     */ public class TUnmodifiableDoubleIntMap
/*     */   implements TDoubleIntMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TDoubleIntMap m;
/*     */   
/*     */   public TUnmodifiableDoubleIntMap(TDoubleIntMap m) {
/*  58 */     if (m == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.m = m;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.m.size(); }
/*  64 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  65 */   public boolean containsKey(double key) { return this.m.containsKey(key); }
/*  66 */   public boolean containsValue(int val) { return this.m.containsValue(val); } public int get(double key) {
/*  67 */     return this.m.get(key);
/*     */   }
/*  69 */   public int put(double key, int value) { throw new UnsupportedOperationException(); }
/*  70 */   public int remove(double key) { throw new UnsupportedOperationException(); }
/*  71 */   public void putAll(TDoubleIntMap m) { throw new UnsupportedOperationException(); }
/*  72 */   public void putAll(Map<? extends Double, ? extends Integer> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*  75 */   private transient TDoubleSet keySet = null;
/*  76 */   private transient TIntCollection values = null;
/*     */   
/*     */   public TDoubleSet keySet() {
/*  79 */     if (this.keySet == null)
/*  80 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  81 */     return this.keySet;
/*     */   }
/*  83 */   public double[] keys() { return this.m.keys(); } public double[] keys(double[] array) {
/*  84 */     return this.m.keys(array);
/*     */   }
/*     */   public TIntCollection valueCollection() {
/*  87 */     if (this.values == null)
/*  88 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  89 */     return this.values;
/*     */   }
/*  91 */   public int[] values() { return this.m.values(); } public int[] values(int[] array) {
/*  92 */     return this.m.values(array);
/*     */   }
/*  94 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  95 */   public int hashCode() { return this.m.hashCode(); }
/*  96 */   public String toString() { return this.m.toString(); }
/*  97 */   public double getNoEntryKey() { return this.m.getNoEntryKey(); } public int getNoEntryValue() {
/*  98 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TDoubleProcedure procedure) {
/* 101 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TIntProcedure procedure) {
/* 104 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TDoubleIntProcedure procedure) {
/* 107 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TDoubleIntIterator iterator() {
/* 111 */     return new TDoubleIntIterator() {
/* 112 */         TDoubleIntIterator iter = TUnmodifiableDoubleIntMap.this.m.iterator();
/*     */         
/* 114 */         public double key() { return this.iter.key(); }
/* 115 */         public int value() { return this.iter.value(); }
/* 116 */         public void advance() { this.iter.advance(); }
/* 117 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 118 */         public int setValue(int val) { throw new UnsupportedOperationException(); } public void remove() {
/* 119 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 123 */   public int putIfAbsent(double key, int value) { throw new UnsupportedOperationException(); }
/* 124 */   public void transformValues(TIntFunction function) { throw new UnsupportedOperationException(); }
/* 125 */   public boolean retainEntries(TDoubleIntProcedure procedure) { throw new UnsupportedOperationException(); }
/* 126 */   public boolean increment(double key) { throw new UnsupportedOperationException(); }
/* 127 */   public boolean adjustValue(double key, int amount) { throw new UnsupportedOperationException(); } public int adjustOrPutValue(double key, int adjust_amount, int put_amount) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableDoubleIntMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */