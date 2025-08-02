/*    */ package net.craftigames.polar.common.util.placeholder;
/*    */ 
/*    */ public class ObjectSet<A, B> {
/*    */   private A a;
/*    */   private B b;
/*    */   
/*  7 */   public void setA(A a) { this.a = a; } public void setB(B b) { this.b = b; }
/*    */ 
/*    */   
/* 10 */   public A getA() { return this.a; } public B getB() {
/* 11 */     return this.b;
/*    */   }
/*    */   public ObjectSet(A a, B b) {
/* 14 */     Preconditions.checkNotNull(a, "a");
/* 15 */     Preconditions.checkNotNull(b, "b");
/* 16 */     this.a = a;
/* 17 */     this.b = b;
/*    */   }
/*    */   
/*    */   public A getKey() {
/* 21 */     return this.a;
/*    */   }
/*    */   
/*    */   public void setKey(A key) {
/* 25 */     this.a = key;
/*    */   }
/*    */   
/*    */   public B getValue() {
/* 29 */     return this.b;
/*    */   }
/*    */   
/*    */   public void setValue(B value) {
/* 33 */     this.b = value;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\placeholder\ObjectSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */