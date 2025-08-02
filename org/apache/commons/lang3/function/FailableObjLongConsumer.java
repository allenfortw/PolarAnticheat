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
/*    */ public interface FailableObjLongConsumer<T, E extends Throwable>
/*    */ {
/*    */   public static final FailableObjLongConsumer NOP = (t, u) -> {
/*    */     
/*    */     };
/*    */   
/*    */   void accept(T paramT, long paramLong) throws E;
/*    */   
/*    */   static <T, E extends Throwable> FailableObjLongConsumer<T, E> nop() {
/* 44 */     return NOP;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableObjLongConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */