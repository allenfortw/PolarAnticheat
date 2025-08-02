/*   */ package net.craftigames.polar.common.util.scheduler;
/*   */ 
/*   */ public abstract class PolarRunnable
/*   */   implements Runnable {
/*   */   int id;
/*   */   
/*   */   public void cancel() {
/* 8 */     PolarThread.cancel(this.id);
/*   */   }
/*   */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\scheduler\PolarRunnable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */