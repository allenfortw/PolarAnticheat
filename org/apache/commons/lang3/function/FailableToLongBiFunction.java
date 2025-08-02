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
/*    */ public interface FailableToLongBiFunction<T, U, E extends Throwable>
/*    */ {
/*    */   public static final FailableToLongBiFunction NOP = (t, u) -> 0L;
/*    */   
/*    */   long applyAsLong(T paramT, U paramU) throws E;
/*    */   
/*    */   static <T, U, E extends Throwable> FailableToLongBiFunction<T, U, E> nop() {
/* 46 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableToLongBiFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */