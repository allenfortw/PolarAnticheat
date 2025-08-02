/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TFloatDoubleIterator;
/*     */ import gnu.trove.map.TFloatDoubleMap;
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
/*     */ public class TFloatDoubleMapDecorator
/*     */   extends AbstractMap<Float, Double>
/*     */   implements Map<Float, Double>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TFloatDoubleMap _map;
/*     */   
/*     */   public TFloatDoubleMapDecorator() {}
/*     */   
/*     */   public TFloatDoubleMapDecorator(TFloatDoubleMap map) {
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
/*     */   public TFloatDoubleMap getMap() {
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
/*     */   public Double put(Float key, Double value) {
/*     */     float k;
/*     */     double v;
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
/* 112 */     double retval = this._map.put(k, v);
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
/*     */   public Double get(Object key) {
/*     */     float k;
/* 128 */     if (key != null) {
/* 129 */       if (key instanceof Float) {
/* 130 */         k = unwrapKey(key);
/*     */       } else {
/* 132 */         return null;
/*     */       } 
/*     */     } else {
/* 135 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 137 */     double v = this._map.get(k);
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
/*     */   public Double remove(Object key) {
/*     */     float k;
/* 165 */     if (key != null) {
/* 166 */       if (key instanceof Float) {
/* 167 */         k = unwrapKey(key);
/*     */       } else {
/* 169 */         return null;
/*     */       } 
/*     */     } else {
/* 172 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 174 */     double v = this._map.remove(k);
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
/*     */   public Set<Map.Entry<Float, Double>> entrySet() {
/* 192 */     return new AbstractSet<Map.Entry<Float, Double>>() {
/*     */         public int size() {
/* 194 */           return TFloatDoubleMapDecorator.this._map.size();
/*     */         }
/*     */         
/*     */         public boolean isEmpty() {
/* 198 */           return TFloatDoubleMapDecorator.this.isEmpty();
/*     */         }
/*     */         
/*     */         public boolean contains(Object o) {
/* 202 */           if (o instanceof Map.Entry) {
/* 203 */             Object k = ((Map.Entry)o).getKey();
/* 204 */             Object v = ((Map.Entry)o).getValue();
/* 205 */             return (TFloatDoubleMapDecorator.this.containsKey(k) && TFloatDoubleMapDecorator.this
/* 206 */               .get(k).equals(v));
/*     */           } 
/* 208 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<Float, Double>> iterator() {
/* 213 */           return new Iterator<Map.Entry<Float, Double>>() {
/* 214 */               private final TFloatDoubleIterator it = TFloatDoubleMapDecorator.this._map.iterator();
/*     */               
/*     */               public Map.Entry<Float, Double> next() {
/* 217 */                 this.it.advance();
/* 218 */                 float ik = this.it.key();
/* 219 */                 final Float key = (ik == TFloatDoubleMapDecorator.this._map.getNoEntryKey()) ? null : TFloatDoubleMapDecorator.this.wrapKey(ik);
/* 220 */                 double iv = this.it.value();
/* 221 */                 final Double v = (iv == TFloatDoubleMapDecorator.this._map.getNoEntryValue()) ? null : TFloatDoubleMapDecorator.this.wrapValue(iv);
/* 222 */                 return new Map.Entry<Float, Double>() {
/* 223 */                     private Double val = v;
/*     */                     
/*     */                     public boolean equals(Object o) {
/* 226 */                       return (o instanceof Map.Entry && ((Map.Entry)o)
/* 227 */                         .getKey().equals(key) && ((Map.Entry)o)
/* 228 */                         .getValue().equals(this.val));
/*     */                     }
/*     */                     
/*     */                     public Float getKey() {
/* 232 */                       return key;
/*     */                     }
/*     */                     
/*     */                     public Double getValue() {
/* 236 */                       return this.val;
/*     */                     }
/*     */                     
/*     */                     public int hashCode() {
/* 240 */                       return key.hashCode() + this.val.hashCode();
/*     */                     }
/*     */                     
/*     */                     public Double setValue(Double value) {
/* 244 */                       this.val = value;
/* 245 */                       return TFloatDoubleMapDecorator.this.put(key, value);
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
/*     */         public boolean add(Map.Entry<Float, Double> o) {
/* 261 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public boolean remove(Object o) {
/* 265 */           boolean modified = false;
/* 266 */           if (contains(o)) {
/*     */             
/* 268 */             Float key = (Float)((Map.Entry)o).getKey();
/* 269 */             TFloatDoubleMapDecorator.this._map.remove(TFloatDoubleMapDecorator.this.unwrapKey(key));
/* 270 */             modified = true;
/*     */           } 
/* 272 */           return modified;
/*     */         }
/*     */         
/*     */         public boolean addAll(Collection<? extends Map.Entry<Float, Double>> c) {
/* 276 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public void clear() {
/* 280 */           TFloatDoubleMapDecorator.this.clear();
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
/* 293 */     return (val instanceof Double && this._map.containsValue(unwrapValue(val)));
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
/* 305 */     return (key instanceof Float && this._map.containsKey(unwrapKey(key)));
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
/*     */   public void putAll(Map<? extends Float, ? extends Double> map) {
/* 338 */     Iterator<? extends Map.Entry<? extends Float, ? extends Double>> it = map.entrySet().iterator();
/* 339 */     for (int i = map.size(); i-- > 0; ) {
/* 340 */       Map.Entry<? extends Float, ? extends Double> e = it.next();
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
/*     */   protected Float wrapKey(float k) {
/* 353 */     return Float.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float unwrapKey(Object key) {
/* 364 */     return ((Float)key).floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Double wrapValue(double k) {
/* 375 */     return Double.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double unwrapValue(Object value) {
/* 386 */     return ((Double)value).doubleValue();
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
/* 398 */     this._map = (TFloatDoubleMap)in.readObject();
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TFloatDoubleMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */