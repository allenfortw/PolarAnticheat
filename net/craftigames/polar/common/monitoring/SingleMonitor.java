/*    */ package net.craftigames.polar.common.monitoring;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SingleMonitor
/*    */   implements Monitor
/*    */ {
/*    */   private final RollingAverage average;
/*    */   
/*    */   public RollingAverage getAverage() {
/* 14 */     return this.average;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SingleMonitor(int size) {
/* 20 */     this.average = new RollingAverage(size);
/*    */   }
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
/*    */   public RollingAverage get() {
/* 41 */     synchronized (this.average) {
/* 42 */       return this.average;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 51 */     synchronized (this.average) {
/* 52 */       get().add(getCurrentValue());
/*    */     } 
/* 54 */     resetValue();
/*    */   }
/*    */   
/*    */   public abstract BigDecimal getCurrentValue();
/*    */   
/*    */   public abstract void resetValue();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\SingleMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */