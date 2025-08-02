/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.iterator.TIntIterator;
/*     */ import gnu.trove.set.TIntSet;
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
/*     */ public class TIntSetDecorator
/*     */   extends AbstractSet<Integer>
/*     */   implements Set<Integer>, Externalizable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TIntSet _set;
/*     */   
/*     */   public TIntSetDecorator() {}
/*     */   
/*     */   public TIntSetDecorator(TIntSet set) {
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
/*     */   public TIntSet getSet() {
/*  85 */     return this._set;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Integer value) {
/*  95 */     return (value != null && this._set.add(value.intValue()));
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
/* 117 */         if (val instanceof Integer) {
/* 118 */           int v = ((Integer)val).intValue();
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
/* 151 */     return (value instanceof Integer && this._set.remove(((Integer)value).intValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Integer> iterator() {
/* 161 */     return new Iterator<Integer>() {
/* 162 */         private final TIntIterator it = TIntSetDecorator.this._set.iterator();
/*     */         
/*     */         public Integer next() {
/* 165 */           return Integer.valueOf(this.it.next());
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
/* 204 */     if (!(o instanceof Integer)) return false; 
/* 205 */     return this._set.contains(((Integer)o).intValue());
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
/* 217 */     this._set = (TIntSet)in.readObject();
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TIntSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */