/*    */ package org.apache.commons.lang3.function;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface FailableIntUnaryOperator<E extends Throwable>
/*    */ {
/*    */   public static final FailableIntUnaryOperator NOP = t -> 0;
/*    */   
/*    */   static <E extends Throwable> FailableIntUnaryOperator<E> identity() {
/* 42 */     return t -> t;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableIntUnaryOperator<E> nop() {
/* 52 */     return NOP;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableIntUnaryOperator<E> andThen(FailableIntUnaryOperator<E> after) {
/* 64 */     Objects.requireNonNull(after);
/* 65 */     return t -> after.applyAsInt(applyAsInt(t));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableIntUnaryOperator<E> compose(FailableIntUnaryOperator<E> before) {
/* 86 */     Objects.requireNonNull(before);
/* 87 */     return v -> applyAsInt(before.applyAsInt(v));
/*    */   }
/*    */   
/*    */   int applyAsInt(int paramInt) throws E;
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableIntUnaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */