/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TLongShortIterator;
/*     */ import gnu.trove.map.TLongShortMap;
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
/*     */ 
/*     */ 
/*     */ public class TLongShortMapDecorator
/*     */   extends AbstractMap<Long, Short>
/*     */   implements Map<Long, Short>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TLongShortMap _map;
/*     */   
/*     */   public TLongShortMapDecorator() {}
/*     */   
/*     */   public TLongShortMapDecorator(TLongShortMap map) {
/*  76 */     Objects.requireNonNull(map);
/*  77 */     this._map = map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TLongShortMap getMap() {
/*  87 */     return this._map;
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
/*     */   public Short put(Long key, Short value) {
/*     */     long k;
/*     */     short v;
/* 102 */     if (key == null) {
/* 103 */       k = this._map.getNoEntryKey();
/*     */     } else {
/* 105 */       k = unwrapKey(key);
/*     */     } 
/* 107 */     if (value == null) {
/* 108 */       v = this._map.getNoEntryValue();
/*     */     } else {
/* 110 */       v = unwrapValue(value);
/*     */     } 
/* 112 */     short retval = this._map.put(k, v);
/* 113 */     if (retval == this._map.getNoEntryValue()) {
/* 114 */       return null;
/*     */     }
/* 116 */     return wrapValue(retval);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Short get(Object key) {
/*     */     long k;
/* 128 */     if (key != null) {
/* 129 */       if (key instanceof Long) {
/* 130 */         k = unwrapKey(key);
/*     */       } else {
/* 132 */         return null;
/*     */       } 
/*     */     } else {
/* 135 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 137 */     short v = this._map.get(k);
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (v == this._map.getNoEntryValue()) {
/* 142 */       return null;
/*     */     }
/* 144 */     return wrapValue(v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 153 */     this._map.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Short remove(Object key) {
/*     */     long k;
/* 165 */     if (key != null) {
/* 166 */       if (key instanceof Long) {
/* 167 */         k = unwrapKey(key);
/*     */       } else {
/* 169 */         return null;
/*     */       } 
/*     */     } else {
/* 172 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 174 */     short v = this._map.remove(k);
/*     */ 
/*     */ 
/*     */     
/* 178 */     if (v == this._map.getNoEntryValue()) {
/* 179 */       return null;
/*     */     }
/* 181 */     return wrapValue(v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<Long, Short>> entrySet() {
/* 192 */     return new AbstractSet<Map.Entry<Long, Short>>() {
/*     */         public int size() {
/* 194 */           return TLongShortMapDecorator.this._map.size();
/*     */         }
/*     */         
/*     */         public boolean isEmpty() {
/* 198 */           return TLongShortMapDecorator.this.isEmpty();
/*     */         }
/*     */         
/*     */         public boolean contains(Object o) {
/* 202 */           if (o instanceof Map.Entry) {
/* 203 */             Object k = ((Map.Entry)o).getKey();
/* 204 */             Object v = ((Map.Entry)o).getValue();
/* 205 */             return (TLongShortMapDecorator.this.containsKey(k) && TLongShortMapDecorator.this
/* 206 */               .get(k).equals(v));
/*     */           } 
/* 208 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<Long, Short>> iterator() {
/* 213 */           return new Iterator<Map.Entry<Long, Short>>() {
/* 214 */               private final TLongShortIterator it = TLongShortMapDecorator.this._map.iterator();
/*     */               
/*     */               public Map.Entry<Long, Short> next() {
/* 217 */                 this.it.advance();
/* 218 */                 long ik = this.it.key();
/* 219 */                 final Long key = (ik == TLongShortMapDecorator.this._map.getNoEntryKey()) ? null : TLongShortMapDecorator.this.wrapKey(ik);
/* 220 */                 short iv = this.it.value();
/* 221 */                 final Short v = (iv == TLongShortMapDecorator.this._map.getNoEntryValue()) ? null : TLongShortMapDecorator.this.wrapValue(iv);
/* 222 */                 return new Map.Entry<Long, Short>() {
/* 223 */                     private Short val = v;
/*     */                     
/*     */                     public boolean equals(Object o) {
/* 226 */                       return (o instanceof Map.Entry && ((Map.Entry)o)
/* 227 */                         .getKey().equals(key) && ((Map.Entry)o)
/* 228 */                         .getValue().equals(this.val));
/*     */                     }
/*     */                     
/*     */                     public Long getKey() {
/* 232 */                       return key;
/*     */                     }
/*     */                     
/*     */                     public Short getValue() {
/* 236 */                       return this.val;
/*     */                     }
/*     */                     
/*     */                     public int hashCode() {
/* 240 */                       return key.hashCode() + this.val.hashCode();
/*     */                     }
/*     */                     
/*     */                     public Short setValue(Short value) {
/* 244 */                       this.val = value;
/* 245 */                       return TLongShortMapDecorator.this.put(key, value);
/*     */                     }
/*     */                   };
/*     */               }
/*     */               
/*     */               public boolean hasNext() {
/* 251 */                 return this.it.hasNext();
/*     */               }
/*     */               
/*     */               public void remove() {
/* 255 */                 this.it.remove();
/*     */               }
/*     */             };
/*     */         }
/*     */         
/*     */         public boolean add(Map.Entry<Long, Short> o) {
/* 261 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public boolean remove(Object o) {
/* 265 */           boolean modified = false;
/* 266 */           if (contains(o)) {
/*     */             
/* 268 */             Long key = (Long)((Map.Entry)o).getKey();
/* 269 */             TLongShortMapDecorator.this._map.remove(TLongShortMapDecorator.this.unwrapKey(key));
/* 270 */             modified = true;
/*     */           } 
/* 272 */           return modified;
/*     */         }
/*     */         
/*     */         public boolean addAll(Collection<? extends Map.Entry<Long, Short>> c) {
/* 276 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public void clear() {
/* 280 */           TLongShortMapDecorator.this.clear();
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
/* 293 */     return (val instanceof Short && this._map.containsValue(unwrapValue(val)));
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
/* 304 */     if (key == null) return this._map.containsKey(this._map.getNoEntryKey()); 
/* 305 */     return (key instanceof Long && this._map.containsKey(unwrapKey(key)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 315 */     return this._map.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 325 */     return (size() == 0);
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
/*     */   public void putAll(Map<? extends Long, ? extends Short> map) {
/* 338 */     Iterator<? extends Map.Entry<? extends Long, ? extends Short>> it = map.entrySet().iterator();
/* 339 */     for (int i = map.size(); i-- > 0; ) {
/* 340 */       Map.Entry<? extends Long, ? extends Short> e = it.next();
/* 341 */       put(e.getKey(), e.getValue());
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
/*     */   protected Long wrapKey(long k) {
/* 353 */     return Long.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long unwrapKey(Object key) {
/* 364 */     return ((Long)key).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Short wrapValue(short k) {
/* 375 */     return Short.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected short unwrapValue(Object value) {
/* 386 */     return ((Short)value).shortValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 395 */     in.readByte();
/*     */ 
/*     */     
/* 398 */     this._map = (TLongShortMap)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 405 */     out.writeByte(0);
/*     */ 
/*     */     
/* 408 */     out.writeObject(this._map);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TLongShortMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */