/*    */ package net.craftigames.polar.common.util.scheduler;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ public abstract class CountdownTask extends PolarRunnable {
/*    */   private int time;
/*    */   
/*    */   public int getTime() {
/*  9 */     return this.time;
/*    */   }
/*    */   public CountdownTask(int time) {
/* 12 */     this.time = time;
/*    */   }
/*    */   
/*    */   public CountdownTask() {
/* 16 */     this(60);
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 21 */     if (this.time == 0) {
/* 22 */       end();
/* 23 */       cancel();
/*    */       return;
/*    */     } 
/* 26 */     tick();
/* 27 */     this.time--;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void start() {
/* 35 */     PolarThread.schedule(this, 0L, 1L, TimeUnit.SECONDS);
/*    */   }
/*    */   
/*    */   public abstract void tick();
/*    */   
/*    */   public abstract void end();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\scheduler\CountdownTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */