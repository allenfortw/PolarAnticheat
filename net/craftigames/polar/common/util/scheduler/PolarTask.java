/*    */ package net.craftigames.polar.common.util.scheduler;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ 
/*    */ public class PolarTask implements Runnable, ScheduledTask {
/*    */   private final PolarScheduler sched;
/*    */   private final int id;
/*    */   
/* 10 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PolarTask)) return false;  PolarTask other = (PolarTask)o; if (!other.canEqual(this)) return false;  if (getId() != other.getId()) return false;  if (getDelay() != other.getDelay()) return false;  if (getPeriod() != other.getPeriod()) return false;  Object this$sched = getSched(), other$sched = other.getSched(); if ((this$sched == null) ? (other$sched != null) : !this$sched.equals(other$sched)) return false;  Object this$task = getTask(), other$task = other.getTask(); if ((this$task == null) ? (other$task != null) : !this$task.equals(other$task)) return false;  Object this$running = getRunning(), other$running = other.getRunning(); return !((this$running == null) ? (other$running != null) : !this$running.equals(other$running)); } private final Runnable task; private final long delay; private final long period; protected boolean canEqual(Object other) { return other instanceof PolarTask; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getId(); long $delay = getDelay(); result = result * 59 + (int)($delay >>> 32L ^ $delay); long $period = getPeriod(); result = result * 59 + (int)($period >>> 32L ^ $period); Object $sched = getSched(); result = result * 59 + (($sched == null) ? 43 : $sched.hashCode()); Object $task = getTask(); result = result * 59 + (($task == null) ? 43 : $task.hashCode()); Object $running = getRunning(); return result * 59 + (($running == null) ? 43 : $running.hashCode()); } public String toString() { return "PolarTask(sched=" + getSched() + ", id=" + getId() + ", task=" + getTask() + ", delay=" + getDelay() + ", period=" + getPeriod() + ", running=" + getRunning() + ")"; }
/*    */ 
/*    */   
/* 13 */   public PolarScheduler getSched() { return this.sched; }
/* 14 */   public int getId() { return this.id; } public Runnable getTask() {
/* 15 */     return this.task;
/*    */   }
/* 17 */   public long getDelay() { return this.delay; } public long getPeriod() {
/* 18 */     return this.period;
/* 19 */   } private final AtomicBoolean running = new AtomicBoolean(true); public AtomicBoolean getRunning() { return this.running; }
/*    */   
/*    */   public PolarTask(PolarScheduler sched, int id, Runnable task, long delay, long period, TimeUnit unit) {
/* 22 */     this.sched = sched;
/* 23 */     this.id = id;
/* 24 */     this.task = task;
/* 25 */     this.delay = unit.toMillis(delay);
/* 26 */     this.period = unit.toMillis(period);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel() {
/* 31 */     boolean wasRunning = this.running.getAndSet(false);
/*    */     
/* 33 */     if (wasRunning) {
/* 34 */       this.sched.cancel0(this);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 40 */     if (this.delay > 0L) {
/*    */       try {
/* 42 */         Thread.sleep(this.delay);
/* 43 */       } catch (InterruptedException ex) {
/* 44 */         Thread.currentThread().interrupt();
/*    */       } 
/*    */     }
/*    */     
/* 48 */     while (this.running.get()) {
/*    */       try {
/* 50 */         this.task.run();
/* 51 */       } catch (Throwable t) {
/* 52 */         String msg = String.format("Task %s encountered an exception", new Object[] { this });
/* 53 */         Core.getPolarCore().getPolarLogger().log(Level.SEVERE, msg, t);
/* 54 */         t.printStackTrace();
/* 55 */         Core.getReportable().handleThrowable(t, false);
/*    */       } 
/*    */ 
/*    */       
/* 59 */       if (this.period <= 0L) {
/*    */         break;
/*    */       }
/*    */       
/*    */       try {
/* 64 */         Thread.sleep(this.period);
/* 65 */       } catch (InterruptedException ex) {
/* 66 */         Thread.currentThread().interrupt();
/*    */       } 
/*    */     } 
/*    */     
/* 70 */     cancel();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\scheduler\PolarTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */