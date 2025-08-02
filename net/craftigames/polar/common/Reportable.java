/*    */ package net.craftigames.polar.common;
/*    */ 
/*    */ public interface Reportable
/*    */ {
/*    */   default void handleThrowable(Throwable t) {
/*  6 */     handleThrowable(t, null, true);
/*    */   }
/*    */   
/*    */   default void handleThrowable(Throwable t, boolean print) {
/* 10 */     handleThrowable(t, null, print);
/*    */   }
/*    */   
/*    */   default void handleThrowable(Throwable t, String msg, boolean print) {
/* 14 */     if (print)
/* 15 */       t.printStackTrace(); 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\Reportable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */