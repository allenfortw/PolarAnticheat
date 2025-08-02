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
/*    */ public interface FailableIntToLongFunction<E extends Throwable>
/*    */ {
/*    */   public static final FailableIntToLongFunction NOP = t -> 0L;
/*    */   
/*    */   long applyAsLong(int paramInt) throws E;
/*    */   
/*    */   static <E extends Throwable> FailableIntToLongFunction<E> nop() {
/* 42 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableIntToLongFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */