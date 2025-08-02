/*    */ package net.craftigames.polar.common.logging;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ 
/*    */ public interface PolarLogging
/*    */ {
/*    */   void info(String paramString);
/*    */   
/*    */   void warn(String paramString);
/*    */   
/*    */   void warn(String paramString, Throwable paramThrowable);
/*    */   
/*    */   void severe(String paramString);
/*    */   
/*    */   void severe(String paramString, Throwable paramThrowable);
/*    */   
/*    */   void error(String paramString);
/*    */   
/*    */   default void log(Level severe, String msg) {
/* 20 */     log(severe, msg, null);
/*    */   }
/*    */   
/*    */   void log(Level paramLevel, String paramString, Throwable paramThrowable);
/*    */   
/*    */   void debug(String paramString);
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\PolarLogging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */