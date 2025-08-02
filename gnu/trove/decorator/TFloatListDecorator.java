/*     */ package gnu.trove.decorator;
/*     */ 
/*     */ import gnu.trove.list.TFloatList;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.util.AbstractList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFloatListDecorator
/*     */   extends AbstractList<Float>
/*     */   implements List<Float>, Externalizable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected TFloatList list;
/*     */   
/*     */   public TFloatListDecorator() {}
/*     */   
/*     */   public TFloatListDecorator(TFloatList list) {
/*  68 */     Objects.requireNonNull(list);
/*  69 */     this.list = list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFloatList getList() {
/*  79 */     return this.list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  85 */     return this.list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Float get(int index) {
/*  91 */     float value = this.list.get(index);
/*  92 */     if (value == this.list.getNoEntryValue()) return null; 
/*  93 */     return Float.valueOf(value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Float set(int index, Float value) {
/*  99 */     float previous_value = this.list.set(index, value.floatValue());
/* 100 */     if (previous_value == this.list.getNoEntryValue()) return null; 
/* 101 */     return Float.valueOf(previous_value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int index, Float value) {
/* 107 */     this.list.insert(index, value.floatValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Float remove(int index) {
/* 113 */     float previous_value = this.list.removeAt(index);
/* 114 */     if (previous_value == this.list.getNoEntryValue()) return null; 
/* 115 */     return Float.valueOf(previous_value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 124 */     in.readByte();
/*     */ 
/*     */     
/* 127 */     this.list = (TFloatList)in.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 134 */     out.writeByte(0);
/*     */ 
/*     */     
/* 137 */     out.writeObject(this.list);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\decorator\TFloatListDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */