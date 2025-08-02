/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TCharIterator;
/*     */ import gnu.trove.set.TCharSet;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ public class TCharSetDecorator
/*     */   extends AbstractSet<Character>
/*     */   implements Set<Character>, Externalizable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TCharSet _set;
/*     */   
/*     */   public TCharSetDecorator() {}
/*     */   
/*     */   public TCharSetDecorator(TCharSet set) {
/*  74 */     Objects.requireNonNull(set);
/*  75 */     this._set = set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TCharSet getSet() {
/*  85 */     return this._set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Character value) {
/*  95 */     return (value != null && this._set.add(value.charValue()));
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
/*     */   public boolean equals(Object other) {
/* 107 */     if (this._set.equals(other))
/* 108 */       return true; 
/* 109 */     if (other instanceof Set) {
/* 110 */       Set that = (Set)other;
/* 111 */       if (that.size() != this._set.size()) {
/* 112 */         return false;
/*     */       }
/* 114 */       Iterator it = that.iterator();
/* 115 */       for (int i = that.size(); i-- > 0; ) {
/* 116 */         Object val = it.next();
/* 117 */         if (val instanceof Character) {
/* 118 */           char v = ((Character)val).charValue();
/* 119 */           if (this._set.contains(v)) {
/*     */             continue;
/*     */           }
/* 122 */           return false;
/*     */         } 
/*     */         
/* 125 */         return false;
/*     */       } 
/*     */       
/* 128 */       return true;
/*     */     } 
/*     */     
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 140 */     this._set.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object value) {
/* 151 */     return (value instanceof Character && this._set.remove(((Character)value).charValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Character> iterator() {
/* 161 */     return new Iterator<Character>() {
/* 162 */         private final TCharIterator it = TCharSetDecorator.this._set.iterator();
/*     */         
/*     */         public Character next() {
/* 165 */           return Character.valueOf(this.it.next());
/*     */         }
/*     */         
/*     */         public boolean hasNext() {
/* 169 */           return this.it.hasNext();
/*     */         }
/*     */         
/*     */         public void remove() {
/* 173 */           this.it.remove();
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
/*     */   public int size() {
/* 185 */     return this._set.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 195 */     return (this._set.size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object o) {
/* 204 */     if (!(o instanceof Character)) return false; 
/* 205 */     return this._set.contains(((Character)o).charValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 214 */     in.readByte();
/*     */ 
/*     */     
/* 217 */     this._set = (TCharSet)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 224 */     out.writeByte(0);
/*     */ 
/*     */     
/* 227 */     out.writeObject(this._set);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TCharSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */