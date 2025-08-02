/*    */ package net.craftigames.polar.common.util.scheduler;
/*    */ 
/*    */ import com.google.common.util.concurrent.ThreadFactoryBuilder;
/*    */ import java.util.concurrent.Executor;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PolarThread
/*    */ {
/* 14 */   public static final ScheduledExecutorService EXECUTOR_MEMBER_MESSAGES = Executors.newSingleThreadScheduledExecutor((new ThreadFactoryBuilder()).setNameFormat("Polar Member Messages - #%d").build());
/*    */   
/* 16 */   public static PolarScheduler scheduler = new PolarScheduler();
/*    */   
/*    */   public static Executor async() {
/* 19 */     return PolarThread::runAsync;
/*    */   }
/*    */   
/*    */   public static ScheduledTask runAsync(Runnable task) {
/* 23 */     return schedule(task, 0L, TimeUnit.MILLISECONDS);
/*    */   }
/*    */   
/*    */   public static ScheduledTask schedule(Runnable task, long delay, TimeUnit unit) {
/* 27 */     return schedule(task, delay, 0L, unit);
/*    */   }
/*    */   
/*    */   public static void cancel(int id) {
/* 31 */     scheduler.cancel(id);
/*    */   }
/*    */   
/*    */   public static void cancel(ScheduledTask task) {
/* 35 */     scheduler.cancel(task);
/*    */   }
/*    */   
/*    */   public static ScheduledTask schedule(Runnable task, long delay, long period, TimeUnit unit) {
/* 39 */     return scheduler.schedule(task, delay, period, unit);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\scheduler\PolarThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */