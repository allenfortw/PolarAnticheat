/*    */ package net.craftigames.polar.common.monitoring;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class MultiMonitor
/*    */   implements Monitor
/*    */ {
/* 16 */   private final List<RollingAverage> averages = Collections.synchronizedList(new ArrayList<>());
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MultiMonitor(int... sizes) {
/* 22 */     for (int size : sizes) {
/* 23 */       this.averages.add(new RollingAverage(size));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract BigDecimal getCurrentValue();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void resetValue();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RollingAverage get(int index) {
/* 47 */     return this.averages.get(index);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Optional<RollingAverage> getBySize(int size) {
/* 57 */     for (RollingAverage average : this.averages) {
/* 58 */       if (average.getSize() == size) {
/* 59 */         return Optional.of(average);
/*    */       }
/*    */     } 
/* 62 */     return Optional.empty();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 70 */     for (RollingAverage value : this.averages) {
/* 71 */       value.add(getCurrentValue());
/*    */     }
/* 73 */     resetValue();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\MultiMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */