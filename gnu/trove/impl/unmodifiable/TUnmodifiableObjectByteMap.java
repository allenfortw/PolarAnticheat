/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TByteCollection;
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.function.TByteFunction;
/*     */ import gnu.trove.iterator.TObjectByteIterator;
/*     */ import gnu.trove.map.TObjectByteMap;
/*     */ import gnu.trove.procedure.TByteProcedure;
/*     */ import gnu.trove.procedure.TObjectByteProcedure;
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
/*     */ public class TUnmodifiableObjectByteMap<K>
/*     */   implements TObjectByteMap<K>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TObjectByteMap<K> m;
/*     */   
/*     */   public TUnmodifiableObjectByteMap(TObjectByteMap<K> m) {
/*  53 */     if (m == null)
/*  54 */       throw new NullPointerException(); 
/*  55 */     this.m = m;
/*     */   }
/*     */   
/*  58 */   public int size() { return this.m.size(); }
/*  59 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  60 */   public boolean containsKey(Object key) { return this.m.containsKey(key); }
/*  61 */   public boolean containsValue(byte val) { return this.m.containsValue(val); } public byte get(Object key) {
/*  62 */     return this.m.get(key);
/*     */   }
/*  64 */   public byte put(K key, byte value) { throw new UnsupportedOperationException(); }
/*  65 */   public byte remove(Object key) { throw new UnsupportedOperationException(); }
/*  66 */   public void putAll(TObjectByteMap<? extends K> m) { throw new UnsupportedOperationException(); }
/*  67 */   public void putAll(Map<? extends K, ? extends Byte> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*  70 */   private transient Set<K> keySet = null;
/*  71 */   private transient TByteCollection values = null;
/*     */   
/*     */   public Set<K> keySet() {
/*  74 */     if (this.keySet == null)
/*  75 */       this.keySet = Collections.unmodifiableSet(this.m.keySet()); 
/*  76 */     return this.keySet;
/*     */   }
/*  78 */   public Object[] keys() { return this.m.keys(); } public K[] keys(K[] array) {
/*  79 */     return (K[])this.m.keys((Object[])array);
/*     */   }
/*     */   public TByteCollection valueCollection() {
/*  82 */     if (this.values == null)
/*  83 */       this.values = TCollections.unmodifiableCollection(this.m.valueCollection()); 
/*  84 */     return this.values;
/*     */   }
/*  86 */   public byte[] values() { return this.m.values(); } public byte[] values(byte[] array) {
/*  87 */     return this.m.values(array);
/*     */   }
/*  89 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  90 */   public int hashCode() { return this.m.hashCode(); }
/*  91 */   public String toString() { return this.m.toString(); } public byte getNoEntryValue() {
/*  92 */     return this.m.getNoEntryValue();
/*     */   }
/*     */   public boolean forEachKey(TObjectProcedure<? super K> procedure) {
/*  95 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TByteProcedure procedure) {
/*  98 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TObjectByteProcedure<? super K> procedure) {
/* 101 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TObjectByteIterator<K> iterator() {
/* 105 */     return new TObjectByteIterator<K>() {
/* 106 */         TObjectByteIterator<K> iter = TUnmodifiableObjectByteMap.this.m.iterator();
/*     */         
/* 108 */         public K key() { return (K)this.iter.key(); }
/* 109 */         public byte value() { return this.iter.value(); }
/* 110 */         public void advance() { this.iter.advance(); }
/* 111 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 112 */         public byte setValue(byte val) { throw new UnsupportedOperationException(); } public void remove() {
/* 113 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 117 */   public byte putIfAbsent(K key, byte value) { throw new UnsupportedOperationException(); }
/* 118 */   public void transformValues(TByteFunction function) { throw new UnsupportedOperationException(); }
/* 119 */   public boolean retainEntries(TObjectByteProcedure<? super K> procedure) { throw new UnsupportedOperationException(); }
/* 120 */   public boolean increment(K key) { throw new UnsupportedOperationException(); }
/* 121 */   public boolean adjustValue(K key, byte amount) { throw new UnsupportedOperationException(); } public byte adjustOrPutValue(K key, byte adjust_amount, byte put_amount) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableObjectByteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */