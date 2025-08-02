/*     */ package gnu.trove.impl.unmodifiable;
/*     */ 
/*     */ import gnu.trove.TCollections;
/*     */ import gnu.trove.function.TObjectFunction;
/*     */ import gnu.trove.iterator.TByteObjectIterator;
/*     */ import gnu.trove.map.TByteObjectMap;
/*     */ import gnu.trove.procedure.TByteObjectProcedure;
/*     */ import gnu.trove.procedure.TByteProcedure;
/*     */ import gnu.trove.procedure.TObjectProcedure;
/*     */ import gnu.trove.set.TByteSet;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ public class TUnmodifiableByteObjectMap<V>
/*     */   implements TByteObjectMap<V>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1034234728574286014L;
/*     */   private final TByteObjectMap<V> m;
/*     */   
/*     */   public TUnmodifiableByteObjectMap(TByteObjectMap<V> m) {
/*  53 */     if (m == null)
/*  54 */       throw new NullPointerException(); 
/*  55 */     this.m = m;
/*     */   }
/*     */   
/*  58 */   public int size() { return this.m.size(); }
/*  59 */   public boolean isEmpty() { return this.m.isEmpty(); }
/*  60 */   public boolean containsKey(byte key) { return this.m.containsKey(key); }
/*  61 */   public boolean containsValue(Object val) { return this.m.containsValue(val); } public V get(byte key) {
/*  62 */     return (V)this.m.get(key);
/*     */   }
/*  64 */   public V put(byte key, V value) { throw new UnsupportedOperationException(); }
/*  65 */   public V remove(byte key) { throw new UnsupportedOperationException(); }
/*  66 */   public void putAll(TByteObjectMap<? extends V> m) { throw new UnsupportedOperationException(); }
/*  67 */   public void putAll(Map<? extends Byte, ? extends V> map) { throw new UnsupportedOperationException(); } public void clear() {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*  70 */   private transient TByteSet keySet = null;
/*  71 */   private transient Collection<V> values = null;
/*     */   
/*     */   public TByteSet keySet() {
/*  74 */     if (this.keySet == null)
/*  75 */       this.keySet = TCollections.unmodifiableSet(this.m.keySet()); 
/*  76 */     return this.keySet;
/*     */   }
/*  78 */   public byte[] keys() { return this.m.keys(); } public byte[] keys(byte[] array) {
/*  79 */     return this.m.keys(array);
/*     */   }
/*     */   public Collection<V> valueCollection() {
/*  82 */     if (this.values == null)
/*  83 */       this.values = Collections.unmodifiableCollection(this.m.valueCollection()); 
/*  84 */     return this.values;
/*     */   }
/*  86 */   public Object[] values() { return this.m.values(); } public V[] values(V[] array) {
/*  87 */     return (V[])this.m.values((Object[])array);
/*     */   }
/*  89 */   public boolean equals(Object o) { return (o == this || this.m.equals(o)); }
/*  90 */   public int hashCode() { return this.m.hashCode(); }
/*  91 */   public String toString() { return this.m.toString(); } public byte getNoEntryKey() {
/*  92 */     return this.m.getNoEntryKey();
/*     */   }
/*     */   public boolean forEachKey(TByteProcedure procedure) {
/*  95 */     return this.m.forEachKey(procedure);
/*     */   }
/*     */   public boolean forEachValue(TObjectProcedure<? super V> procedure) {
/*  98 */     return this.m.forEachValue(procedure);
/*     */   }
/*     */   public boolean forEachEntry(TByteObjectProcedure<? super V> procedure) {
/* 101 */     return this.m.forEachEntry(procedure);
/*     */   }
/*     */   
/*     */   public TByteObjectIterator<V> iterator() {
/* 105 */     return new TByteObjectIterator<V>() {
/* 106 */         TByteObjectIterator<V> iter = TUnmodifiableByteObjectMap.this.m.iterator();
/*     */         
/* 108 */         public byte key() { return this.iter.key(); }
/* 109 */         public V value() { return (V)this.iter.value(); }
/* 110 */         public void advance() { this.iter.advance(); }
/* 111 */         public boolean hasNext() { return this.iter.hasNext(); }
/* 112 */         public V setValue(V val) { throw new UnsupportedOperationException(); } public void remove() {
/* 113 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/* 117 */   public V putIfAbsent(byte key, V value) { throw new UnsupportedOperationException(); }
/* 118 */   public void transformValues(TObjectFunction<V, V> function) { throw new UnsupportedOperationException(); } public boolean retainEntries(TByteObjectProcedure<? super V> procedure) {
/* 119 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableByteObjectMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */