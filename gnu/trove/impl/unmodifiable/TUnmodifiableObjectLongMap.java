/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.TLongCollection;
/*     */ import gnu.trove.function.TLongFunction;
/*     */ import gnu.trove.iterator.TObjectLongIterator;
/*     */ import gnu.trove.map.TObjectLongMap;
/*     */ import gnu.trove.procedure.TLongProcedure;
/*     */ import gnu.trove.procedure.TObjectLongProcedure;
/*     */ import gnu.trove.procedure.TObjectProcedure;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
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
/*     */ public class TUnmodifiableObjectLongMap<K>
/*     */   implements TObjectLongMap<K>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TObjectLongMap<K> m;
/*     */   
/*     */   public TUnmodifiableObjectLongMap(TObjectLongMap<K> m) {
/*  53 */     if (m == null)
/*  54 */       throw new NullPointerException(); 
/*  55 */     this.m = m;
/*     */   }
/*     */   
/*  58 */   public int size() { return this.m.size(); }
/*  59 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  60 */   public boolean containsKey(Object key) { return this.m.containsKey(key); }
/*  61 */   public boolean containsValue(long val) { return this.m.containsValue(val); } public long get(Object key) {
/*  62 */     return this.m.get(key);
/*     */   }
/*  64 */   public long put(K key, long value) { throw new UnsupportedOperationException(); }
/*  65 */   public long remove(Object key) { throw new UnsupportedOperationException(); }
/*  66 */   public void putAll(TObjectLongMap<? extends K> m) { throw new UnsupportedOperationException(); }
/*  67 */   public void putAll(Map<? extends K, ? extends Long> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*  70 */   private transient Set<K> keySet = null;
/*  71 */   private transient TLongCollection values = null;
/*     */   
/*     */   public Set<K> keySet() {
/*  74 */     if (this.keySet == null)
/*  75 */       this.keySet = Collections.unmodifiableSet(this.m.keySet()); 
/*  76 */     return this.keySet;
/*     */   }
/*  78 */   public Object[] keys() { return this.m.keys(); } public K[] keys(K[] array) {
/*  79 */     return (K[])this.m.keys((Object[])array);
/*     */   }
/*     */   public TLongCollection valueCollection() {
/*  82 */     if (this.values == null)
/*  83 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  84 */     return this.values;
/*     */   }
/*  86 */   public long[] values() { return this.m.values(); } public long[] values(long[] array) {
/*  87 */     return this.m.values(array);
/*     */   }
/*  89 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  90 */   public int hashCode() { return this.m.hashCode(); }
/*  91 */   public String toString() { return this.m.toString(); } public long getNoEntryValue() {
/*  92 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TObjectProcedure<? super K> procedure) {
/*  95 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TLongProcedure procedure) {
/*  98 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TObjectLongProcedure<? super K> procedure) {
/* 101 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TObjectLongIterator<K> iterator() {
/* 105 */     return new TObjectLongIterator<K>() {
/* 106 */         TObjectLongIterator<K> iter = TUnmodifiableObjectLongMap.this.m.iterator();
/*     */         
/* 108 */         public K key() { return (K)this.iter.key(); }
/* 109 */         public long value() { return this.iter.value(); }
/* 110 */         public void advance() { this.iter.advance(); }
/* 111 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 112 */         public long setValue(long val) { throw new UnsupportedOperationException(); } public void remove() {
/* 113 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 117 */   public long putIfAbsent(K key, long value) { throw new UnsupportedOperationException(); }
/* 118 */   public void transformValues(TLongFunction function) { throw new UnsupportedOperationException(); }
/* 119 */   public boolean retainEntries(TObjectLongProcedure<? super K> procedure) { throw new UnsupportedOperationException(); }
/* 120 */   public boolean increment(K key) { throw new UnsupportedOperationException(); }
/* 121 */   public boolean adjustValue(K key, long amount) { throw new UnsupportedOperationException(); } public long adjustOrPutValue(K key, long adjust_amount, long put_amount) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableObjectLongMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */