/*    */ package net.craftigames.polar.common.logging;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ 
/*    */ public class PolarLogger {
/*    */   private final PolarLogging logging;
/*    */   
/*    */   public PolarLogger(PolarLogging logging) {
/*  9 */     this.logging = logging;
/*    */   }
/*    */   
/*    */   public static String ms(long time) {
/* 13 */     long ns = System.nanoTime() - time;
/* 14 */     float ms = (float)ns / 1000000.0F;
/*    */     
/* 16 */     return String.format("%.3f", new Object[] { Float.valueOf(ms) });
/*    */   }
/*    */   
/*    */   public void info(String s) {
/* 20 */     this.logging.info(s);
/*    */   }
/*    */   
/*    */   public void info(String msg, Throwable t) {
/* 24 */     this.logging.log(Level.INFO, msg, t);
/*    */   }
/*    */   
/*    */   public void warn(String s) {
/* 28 */     this.logging.warn(s);
/*    */   }
/*    */   
/*    */   public void warn(String s, Throwable t) {
/* 32 */     this.logging.warn(s, t);
/*    */   }
/*    */   
/*    */   public void log(Level severe, String msg, Throwable t) {
/* 36 */     this.logging.log(severe, msg, t);
/*    */   }
/*    */   
/*    */   public void debug(String s) {
/* 40 */     this.logging.debug(s);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\PolarLogger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */