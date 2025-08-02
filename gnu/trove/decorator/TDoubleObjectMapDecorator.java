/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TDoubleObjectIterator;
/*     */ import gnu.trove.map.TDoubleObjectMap;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TDoubleObjectMapDecorator<V>
/*     */   extends AbstractMap<Double, V>
/*     */   implements Map<Double, V>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TDoubleObjectMap<V> _map;
/*     */   
/*     */   public TDoubleObjectMapDecorator() {}
/*     */   
/*     */   public TDoubleObjectMapDecorator(TDoubleObjectMap<V> map) {
/*  74 */     Objects.requireNonNull(map);
/*  75 */     this._map = map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TDoubleObjectMap<V> getMap() {
/*  85 */     return this._map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(Double key, V value) {
/*     */     double k;
/*  99 */     if (key == null) {
/* 100 */       k = this._map.getNoEntryKey();
/*     */     } else {
/* 102 */       k = unwrapKey(key);
/*     */     } 
/* 104 */     return (V)this._map.put(k, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object key) {
/*     */     double k;
/* 116 */     if (key != null) {
/* 117 */       if (key instanceof Double) {
/* 118 */         k = unwrapKey((Double)key);
/*     */       } else {
/* 120 */         return null;
/*     */       } 
/*     */     } else {
/* 123 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 125 */     return (V)this._map.get(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 133 */     this._map.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object key) {
/*     */     double k;
/* 145 */     if (key != null) {
/* 146 */       if (key instanceof Double) {
/* 147 */         k = unwrapKey((Double)key);
/*     */       } else {
/* 149 */         return null;
/*     */       } 
/*     */     } else {
/* 152 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 154 */     return (V)this._map.remove(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<Double, V>> entrySet() {
/* 164 */     return new AbstractSet<Map.Entry<Double, V>>() {
/*     */         public int size() {
/* 166 */           return TDoubleObjectMapDecorator.this._map.size();
/*     */         }
/*     */         
/*     */         public boolean isEmpty() {
/* 170 */           return TDoubleObjectMapDecorator.this.isEmpty();
/*     */         }
/*     */         
/*     */         public boolean contains(Object o) {
/* 174 */           if (o instanceof Map.Entry) {
/* 175 */             Object k = ((Map.Entry)o).getKey();
/* 176 */             Object v = ((Map.Entry)o).getValue();
/* 177 */             return (TDoubleObjectMapDecorator.this.containsKey(k) && TDoubleObjectMapDecorator.this
/* 178 */               .get(k).equals(v));
/*     */           } 
/* 180 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<Double, V>> iterator() {
/* 185 */           return new Iterator<Map.Entry<Double, V>>() {
/* 186 */               private final TDoubleObjectIterator<V> it = TDoubleObjectMapDecorator.this._map.iterator();
/*     */               
/*     */               public Map.Entry<Double, V> next() {
/* 189 */                 this.it.advance();
/* 190 */                 double k = this.it.key();
/* 191 */                 final Double key = (k == TDoubleObjectMapDecorator.this._map.getNoEntryKey()) ? null : TDoubleObjectMapDecorator.this.wrapKey(k);
/* 192 */                 final V v = (V)this.it.value();
/* 193 */                 return new Map.Entry<Double, V>() {
/* 194 */                     private V val = (V)v;
/*     */                     
/*     */                     public boolean equals(Object o) {
/* 197 */                       return (o instanceof Map.Entry && ((Map.Entry)o)
/* 198 */                         .getKey().equals(key) && ((Map.Entry)o)
/* 199 */                         .getValue().equals(this.val));
/*     */                     }
/*     */                     
/*     */                     public Double getKey() {
/* 203 */                       return key;
/*     */                     }
/*     */                     
/*     */                     public V getValue() {
/* 207 */                       return this.val;
/*     */                     }
/*     */                     
/*     */                     public int hashCode() {
/* 211 */                       return key.hashCode() + this.val.hashCode();
/*     */                     }
/*     */                     
/*     */                     public V setValue(V value) {
/* 215 */                       this.val = value;
/* 216 */                       return TDoubleObjectMapDecorator.this.put(key, value);
/*     */                     }
/*     */                   };
/*     */               }
/*     */               
/*     */               public boolean hasNext() {
/* 222 */                 return this.it.hasNext();
/*     */               }
/*     */               
/*     */               public void remove() {
/* 226 */                 this.it.remove();
/*     */               }
/*     */             };
/*     */         }
/*     */         
/*     */         public boolean add(Map.Entry<Double, V> o) {
/* 232 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public boolean remove(Object o) {
/* 236 */           boolean modified = false;
/* 237 */           if (contains(o)) {
/*     */             
/* 239 */             Double key = (Double)((Map.Entry)o).getKey();
/* 240 */             TDoubleObjectMapDecorator.this._map.remove(TDoubleObjectMapDecorator.this.unwrapKey(key));
/* 241 */             modified = true;
/*     */           } 
/* 243 */           return modified;
/*     */         }
/*     */         
/*     */         public boolean addAll(Collection<? extends Map.Entry<Double, V>> c) {
/* 247 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public void clear() {
/* 251 */           TDoubleObjectMapDecorator.this.clear();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object val) {
/* 264 */     return this._map.containsValue(val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object key) {
/* 275 */     if (key == null) return this._map.containsKey(this._map.getNoEntryKey()); 
/* 276 */     return (key instanceof Double && this._map.containsKey(((Double)key).doubleValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 286 */     return this._map.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 296 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends Double, ? extends V> map) {
/* 308 */     Iterator<? extends Map.Entry<? extends Double, ? extends V>> it = map.entrySet().iterator();
/* 309 */     for (int i = map.size(); i-- > 0; ) {
/* 310 */       Map.Entry<? extends Double, ? extends V> e = it.next();
/* 311 */       put(e.getKey(), e.getValue());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Double wrapKey(double k) {
/* 323 */     return Double.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double unwrapKey(Double key) {
/* 334 */     return key.doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 343 */     in.readByte();
/*     */ 
/*     */ 
/*     */     
/* 347 */     this._map = (TDoubleObjectMap<V>)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 354 */     out.writeByte(0);
/*     */ 
/*     */     
/* 357 */     out.writeObject(this._map);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TDoubleObjectMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */