/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCharCollection;
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.function.TCharFunction;
/*     */ import gnu.trove.iterator.TIntCharIterator;
/*     */ import gnu.trove.map.TIntCharMap;
/*     */ import gnu.trove.procedure.TCharProcedure;
/*     */ import gnu.trove.procedure.TIntCharProcedure;
/*     */ import gnu.trove.procedure.TIntProcedure;
/*     */ import gnu.trove.set.TIntSet;
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
/*     */ public class TUnmodifiableIntCharMap
/*     */   implements TIntCharMap, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TIntCharMap m;
/*     */   
/*     */   public TUnmodifiableIntCharMap(TIntCharMap m) {
/*  58 */     if (m == null)
/*  59 */       throw new NullPointerException(); 
/*  60 */     this.m = m;
/*     */   }
/*     */   
/*  63 */   public int size() { return this.m.size(); }
/*  64 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  65 */   public boolean containsKey(int key) { return this.m.containsKey(key); }
/*  66 */   public boolean containsValue(char val) { return this.m.containsValue(val); } public char get(int key) {
/*  67 */     return this.m.get(key);
/*     */   }
/*  69 */   public char put(int key, char value) { throw new UnsupportedOperationException(); }
/*  70 */   public char remove(int key) { throw new UnsupportedOperationException(); }
/*  71 */   public void putAll(TIntCharMap m) { throw new UnsupportedOperationException(); }
/*  72 */   public void putAll(Map<? extends Integer, ? extends Character> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  73 */     throw new UnsupportedOperationException();
/*     */   }
/*  75 */   private transient TIntSet keySet = null;
/*  76 */   private transient TCharCollection values = null;
/*     */   
/*     */   public TIntSet keySet() {
/*  79 */     if (this.keySet == null)
/*  80 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  81 */     return this.keySet;
/*     */   }
/*  83 */   public int[] keys() { return this.m.keys(); } public int[] keys(int[] array) {
/*  84 */     return this.m.keys(array);
/*     */   }
/*     */   public TCharCollection valueCollection() {
/*  87 */     if (this.values == null)
/*  88 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  89 */     return this.values;
/*     */   }
/*  91 */   public char[] values() { return this.m.values(); } public char[] values(char[] array) {
/*  92 */     return this.m.values(array);
/*     */   }
/*  94 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  95 */   public int hashCode() { return this.m.hashCode(); }
/*  96 */   public String toString() { return this.m.toString(); }
/*  97 */   public int getNoEntryKey() { return this.m.getNoEntryKey(); } public char getNoEntryValue() {
/*  98 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TIntProcedure procedure) {
/* 101 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TCharProcedure procedure) {
/* 104 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TIntCharProcedure procedure) {
/* 107 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TIntCharIterator iterator() {
/* 111 */     return new TIntCharIterator() {
/* 112 */         TIntCharIterator iter = TUnmodifiableIntCharMap.this.m.iterator();
/*     */         
/* 114 */         public int key() { return this.iter.key(); }
/* 115 */         public char value() { return this.iter.value(); }
/* 116 */         public void advance() { this.iter.advance(); }
/* 117 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 118 */         public char setValue(char val) { throw new UnsupportedOperationException(); } public void remove() {
/* 119 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 123 */   public char putIfAbsent(int key, char value) { throw new UnsupportedOperationException(); }
/* 124 */   public void transformValues(TCharFunction function) { throw new UnsupportedOperationException(); }
/* 125 */   public boolean retainEntries(TIntCharProcedure procedure) { throw new UnsupportedOperationException(); }
/* 126 */   public boolean increment(int key) { throw new UnsupportedOperationException(); }
/* 127 */   public boolean adjustValue(int key, char amount) { throw new UnsupportedOperationException(); } public char adjustOrPutValue(int key, char adjust_amount, char put_amount) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableIntCharMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */