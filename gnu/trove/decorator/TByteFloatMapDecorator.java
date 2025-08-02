/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TByteFloatIterator;
/*     */ import gnu.trove.map.TByteFloatMap;
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
/*     */ public class TByteFloatMapDecorator
/*     */   extends AbstractMap<Byte, Float>
/*     */   implements Map<Byte, Float>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TByteFloatMap _map;
/*     */   
/*     */   public TByteFloatMapDecorator() {}
/*     */   
/*     */   public TByteFloatMapDecorator(TByteFloatMap map) {
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
/*     */   public TByteFloatMap getMap() {
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
/*     */   public Float put(Byte key, Float value) {
/*     */     byte k;
/*     */     float v;
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
/* 112 */     float retval = this._map.put(k, v);
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
/*     */   public Float get(Object key) {
/*     */     byte k;
/* 128 */     if (key != null) {
/* 129 */       if (key instanceof Byte) {
/* 130 */         k = unwrapKey(key);
/*     */       } else {
/* 132 */         return null;
/*     */       } 
/*     */     } else {
/* 135 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 137 */     float v = this._map.get(k);
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
/*     */   public Float remove(Object key) {
/*     */     byte k;
/* 165 */     if (key != null) {
/* 166 */       if (key instanceof Byte) {
/* 167 */         k = unwrapKey(key);
/*     */       } else {
/* 169 */         return null;
/*     */       } 
/*     */     } else {
/* 172 */       k = this._map.getNoEntryKey();
/*     */     } 
/* 174 */     float v = this._map.remove(k);
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
/*     */   public Set<Map.Entry<Byte, Float>> entrySet() {
/* 192 */     return new AbstractSet<Map.Entry<Byte, Float>>() {
/*     */         public int size() {
/* 194 */           return TByteFloatMapDecorator.this._map.size();
/*     */         }
/*     */         
/*     */         public boolean isEmpty() {
/* 198 */           return TByteFloatMapDecorator.this.isEmpty();
/*     */         }
/*     */         
/*     */         public boolean contains(Object o) {
/* 202 */           if (o instanceof Map.Entry) {
/* 203 */             Object k = ((Map.Entry)o).getKey();
/* 204 */             Object v = ((Map.Entry)o).getValue();
/* 205 */             return (TByteFloatMapDecorator.this.containsKey(k) && TByteFloatMapDecorator.this
/* 206 */               .get(k).equals(v));
/*     */           } 
/* 208 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<Byte, Float>> iterator() {
/* 213 */           return new Iterator<Map.Entry<Byte, Float>>() {
/* 214 */               private final TByteFloatIterator it = TByteFloatMapDecorator.this._map.iterator();
/*     */               
/*     */               public Map.Entry<Byte, Float> next() {
/* 217 */                 this.it.advance();
/* 218 */                 byte ik = this.it.key();
/* 219 */                 final Byte key = (ik == TByteFloatMapDecorator.this._map.getNoEntryKey()) ? null : TByteFloatMapDecorator.this.wrapKey(ik);
/* 220 */                 float iv = this.it.value();
/* 221 */                 final Float v = (iv == TByteFloatMapDecorator.this._map.getNoEntryValue()) ? null : TByteFloatMapDecorator.this.wrapValue(iv);
/* 222 */                 return new Map.Entry<Byte, Float>() {
/* 223 */                     private Float val = v;
/*     */                     
/*     */                     public boolean equals(Object o) {
/* 226 */                       return (o instanceof Map.Entry && ((Map.Entry)o)
/* 227 */                         .getKey().equals(key) && ((Map.Entry)o)
/* 228 */                         .getValue().equals(this.val));
/*     */                     }
/*     */                     
/*     */                     public Byte getKey() {
/* 232 */                       return key;
/*     */                     }
/*     */                     
/*     */                     public Float getValue() {
/* 236 */                       return this.val;
/*     */                     }
/*     */                     
/*     */                     public int hashCode() {
/* 240 */                       return key.hashCode() + this.val.hashCode();
/*     */                     }
/*     */                     
/*     */                     public Float setValue(Float value) {
/* 244 */                       this.val = value;
/* 245 */                       return TByteFloatMapDecorator.this.put(key, value);
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
/*     */         public boolean add(Map.Entry<Byte, Float> o) {
/* 261 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public boolean remove(Object o) {
/* 265 */           boolean modified = false;
/* 266 */           if (contains(o)) {
/*     */             
/* 268 */             Byte key = (Byte)((Map.Entry)o).getKey();
/* 269 */             TByteFloatMapDecorator.this._map.remove(TByteFloatMapDecorator.this.unwrapKey(key));
/* 270 */             modified = true;
/*     */           } 
/* 272 */           return modified;
/*     */         }
/*     */         
/*     */         public boolean addAll(Collection<? extends Map.Entry<Byte, Float>> c) {
/* 276 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public void clear() {
/* 280 */           TByteFloatMapDecorator.this.clear();
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
/* 293 */     return (val instanceof Float && this._map.containsValue(unwrapValue(val)));
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
/* 305 */     return (key instanceof Byte && this._map.containsKey(unwrapKey(key)));
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
/*     */   public void putAll(Map<? extends Byte, ? extends Float> map) {
/* 338 */     Iterator<? extends Map.Entry<? extends Byte, ? extends Float>> it = map.entrySet().iterator();
/* 339 */     for (int i = map.size(); i-- > 0; ) {
/* 340 */       Map.Entry<? extends Byte, ? extends Float> e = it.next();
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
/*     */   protected Byte wrapKey(byte k) {
/* 353 */     return Byte.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte unwrapKey(Object key) {
/* 364 */     return ((Byte)key).byteValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Float wrapValue(float k) {
/* 375 */     return Float.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected float unwrapValue(Object value) {
/* 386 */     return ((Float)value).floatValue();
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
/* 398 */     this._map = (TByteFloatMap)in.readObject();
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TByteFloatMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */