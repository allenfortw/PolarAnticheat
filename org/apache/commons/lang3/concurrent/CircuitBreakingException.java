/*    */ package org.apache.commons.lang3.concurrent;
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
/*    */ public class CircuitBreakingException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1408176654686913340L;
/*    */   
/*    */   public CircuitBreakingException() {}
/*    */   
/*    */   public CircuitBreakingException(String message, Throwable cause) {
/* 45 */     super(message, cause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircuitBreakingException(String message) {
/* 54 */     super(message);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CircuitBreakingException(Throwable cause) {
/* 63 */     super(cause);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\concurrent\CircuitBreakingException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */