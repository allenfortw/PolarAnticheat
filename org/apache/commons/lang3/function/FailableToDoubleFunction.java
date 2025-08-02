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
/*    */ @FunctionalInterface
/*    */ public interface FailableToDoubleFunction<T, E extends Throwable>
/*    */ {
/*    */   public static final FailableToDoubleFunction NOP = t -> 0.0D;
/*    */   
/*    */   double applyAsDouble(T paramT) throws E;
/*    */   
/*    */   static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
/* 44 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableToDoubleFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */