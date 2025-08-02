/*    */ package net.craftigames.polar.common.util.scheduler;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.common.util.concurrent.ThreadFactoryBuilder;
/*    */ import gnu.trove.TCollections;
/*    */ import gnu.trove.map.TIntObjectMap;
/*    */ import gnu.trove.map.hash.TIntObjectHashMap;
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ 
/*    */ 
/*    */ public class PolarScheduler
/*    */ {
/* 16 */   public static ExecutorService SERVICE = Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setNameFormat("Polar Thread - #%d").build());
/*    */   
/* 18 */   private final Object lock = new Object();
/* 19 */   private final AtomicInteger taskCounter = new AtomicInteger();
/* 20 */   private final TIntObjectMap<PolarTask> tasks = TCollections.synchronizedMap((TIntObjectMap)new TIntObjectHashMap());
/*    */   
/*    */   public ScheduledTask runAsync(Runnable task) {
/* 23 */     return schedule(task, 0L, TimeUnit.MILLISECONDS);
/*    */   }
/*    */   
/*    */   public ScheduledTask schedule(Runnable task, long delay, TimeUnit unit) {
/* 27 */     return schedule(task, delay, 0L, unit);
/*    */   }
/*    */   
/*    */   public ScheduledTask schedule(Runnable task, long delay, long period, TimeUnit unit) {
/* 31 */     Preconditions.checkNotNull(task, "task");
/* 32 */     PolarTask prepared = new PolarTask(this, this.taskCounter.getAndIncrement(), task, delay, period, unit);
/*    */     
/* 34 */     synchronized (this.lock) {
/* 35 */       this.tasks.put(prepared.getId(), prepared);
/*    */     } 
/*    */     
/* 38 */     if (task instanceof PolarRunnable) {
/* 39 */       ((PolarRunnable)task).id = prepared.getId();
/*    */     }
/*    */     
/* 42 */     SERVICE.execute(prepared);
/*    */     
/* 44 */     return prepared;
/*    */   }
/*    */   
/*    */   public void cancel(int id) {
/* 48 */     PolarTask task = (PolarTask)this.tasks.get(id);
/* 49 */     Preconditions.checkArgument((task != null), "No task with id %s", id);
/*    */     
/* 51 */     task.cancel();
/*    */   }
/*    */   
/*    */   public void cancel(ScheduledTask task) {
/* 55 */     task.cancel();
/*    */   }
/*    */   
/*    */   void cancel0(PolarTask task) {
/* 59 */     synchronized (this.lock) {
/* 60 */       this.tasks.remove(task.getId());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\scheduler\PolarScheduler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */