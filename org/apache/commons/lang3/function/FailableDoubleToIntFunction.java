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
/*    */ @FunctionalInterface
/*    */ public interface FailableDoubleToIntFunction<E extends Throwable>
/*    */ {
/*    */   public static final FailableDoubleToIntFunction NOP = t -> 0;
/*    */   
/*    */   int applyAsInt(double paramDouble) throws E;
/*    */   
/*    */   static <E extends Throwable> FailableDoubleToIntFunction<E> nop() {
/* 42 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableDoubleToIntFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */