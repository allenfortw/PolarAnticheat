/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TObjectCharIterator;
/*     */ import gnu.trove.map.TObjectCharMap;
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
/*     */ public class TObjectCharMapDecorator<K>
/*     */   extends AbstractMap<K, Character>
/*     */   implements Map<K, Character>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TObjectCharMap<K> _map;
/*     */   
/*     */   public TObjectCharMapDecorator() {}
/*     */   
/*     */   public TObjectCharMapDecorator(TObjectCharMap<K> map) {
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
/*     */   public TObjectCharMap<K> getMap() {
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
/*     */   public Character put(K key, Character value) {
/* 100 */     if (value == null) return wrapValue(this._map.put(key, this._map.getNoEntryValue())); 
/* 101 */     return wrapValue(this._map.put(key, unwrapValue(value)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Character get(Object key) {
/* 112 */     char v = this._map.get(key);
/*     */ 
/*     */ 
/*     */     
/* 116 */     if (v == this._map.getNoEntryValue()) {
/* 117 */       return null;
/*     */     }
/* 119 */     return wrapValue(v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 128 */     this._map.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Character remove(Object key) {
/* 139 */     char v = this._map.remove(key);
/*     */ 
/*     */ 
/*     */     
/* 143 */     if (v == this._map.getNoEntryValue()) {
/* 144 */       return null;
/*     */     }
/* 146 */     return wrapValue(v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, Character>> entrySet() {
/* 157 */     return new AbstractSet<Map.Entry<K, Character>>() {
/*     */         public int size() {
/* 159 */           return TObjectCharMapDecorator.this._map.size();
/*     */         }
/*     */         
/*     */         public boolean isEmpty() {
/* 163 */           return TObjectCharMapDecorator.this.isEmpty();
/*     */         }
/*     */         
/*     */         public boolean contains(Object o) {
/* 167 */           if (o instanceof Map.Entry) {
/* 168 */             Object k = ((Map.Entry)o).getKey();
/* 169 */             Object v = ((Map.Entry)o).getValue();
/* 170 */             return (TObjectCharMapDecorator.this.containsKey(k) && TObjectCharMapDecorator.this
/* 171 */               .get(k).equals(v));
/*     */           } 
/* 173 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<Map.Entry<K, Character>> iterator() {
/* 178 */           return new Iterator<Map.Entry<K, Character>>() {
/* 179 */               private final TObjectCharIterator<K> it = TObjectCharMapDecorator.this._map.iterator();
/*     */               
/*     */               public Map.Entry<K, Character> next() {
/* 182 */                 this.it.advance();
/* 183 */                 final K key = (K)this.it.key();
/* 184 */                 final Character v = TObjectCharMapDecorator.this.wrapValue(this.it.value());
/* 185 */                 return new Map.Entry<K, Character>() {
/* 186 */                     private Character val = v;
/*     */                     
/*     */                     public boolean equals(Object o) {
/* 189 */                       return (o instanceof Map.Entry && ((Map.Entry)o)
/* 190 */                         .getKey().equals(key) && ((Map.Entry)o)
/* 191 */                         .getValue().equals(this.val));
/*     */                     }
/*     */                     
/*     */                     public K getKey() {
/* 195 */                       return (K)key;
/*     */                     }
/*     */                     
/*     */                     public Character getValue() {
/* 199 */                       return this.val;
/*     */                     }
/*     */                     
/*     */                     public int hashCode() {
/* 203 */                       return key.hashCode() + this.val.hashCode();
/*     */                     }
/*     */                     
/*     */                     public Character setValue(Character value) {
/* 207 */                       this.val = value;
/* 208 */                       return TObjectCharMapDecorator.this.put(key, value);
/*     */                     }
/*     */                   };
/*     */               }
/*     */               
/*     */               public boolean hasNext() {
/* 214 */                 return this.it.hasNext();
/*     */               }
/*     */               
/*     */               public void remove() {
/* 218 */                 this.it.remove();
/*     */               }
/*     */             };
/*     */         }
/*     */         
/*     */         public boolean add(Map.Entry<K, Character> o) {
/* 224 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public boolean remove(Object o) {
/* 228 */           boolean modified = false;
/* 229 */           if (contains(o)) {
/*     */             
/* 231 */             K key = (K)((Map.Entry)o).getKey();
/* 232 */             TObjectCharMapDecorator.this._map.remove(key);
/* 233 */             modified = true;
/*     */           } 
/* 235 */           return modified;
/*     */         }
/*     */         
/*     */         public boolean addAll(Collection<? extends Map.Entry<K, Character>> c) {
/* 239 */           throw new UnsupportedOperationException();
/*     */         }
/*     */         
/*     */         public void clear() {
/* 243 */           TObjectCharMapDecorator.this.clear();
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
/* 256 */     return (val instanceof Character && this._map.containsValue(unwrapValue(val)));
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
/* 267 */     return this._map.containsKey(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 277 */     return this._map.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 287 */     return (this._map.size() == 0);
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
/*     */   public void putAll(Map<? extends K, ? extends Character> map) {
/* 299 */     Iterator<? extends Map.Entry<? extends K, ? extends Character>> it = map.entrySet().iterator();
/* 300 */     for (int i = map.size(); i-- > 0; ) {
/* 301 */       Map.Entry<? extends K, ? extends Character> e = it.next();
/* 302 */       put(e.getKey(), e.getValue());
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
/*     */   protected Character wrapValue(char k) {
/* 314 */     return Character.valueOf(k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected char unwrapValue(Object value) {
/* 325 */     return ((Character)value).charValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 334 */     in.readByte();
/*     */ 
/*     */ 
/*     */     
/* 338 */     this._map = (TObjectCharMap<K>)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 345 */     out.writeByte(0);
/*     */ 
/*     */     
/* 348 */     out.writeObject(this._map);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TObjectCharMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */