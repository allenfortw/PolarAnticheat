/*    */ package org.apache.commons.lang3.function;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FailableToDoubleBiFunction<T, U, E extends Throwable>
/*    */ {
/*    */   public static final FailableToDoubleBiFunction NOP = (t, u) -> 0.0D;
/*    */   
/*    */   double applyAsDouble(T paramT, U paramU) throws E;
/*    */   
/*    */   static <T, U, E extends Throwable> FailableToDoubleBiFunction<T, U, E> nop() {
/* 46 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableToDoubleBiFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */