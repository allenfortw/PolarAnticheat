/*    */ package net.craftigames.polar.common.monitoring;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import net.craftigames.polar.common.util.AtomicPair;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class KeyPairMonitor
/*    */   implements Monitor
/*    */ {
/* 17 */   private final Map<String, RollingAverage> averages = new ConcurrentHashMap<>(); public Map<String, RollingAverage> getAverages() { return this.averages; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SafeVarargs
/*    */   public KeyPairMonitor(AtomicPair<String, Integer>... pairs) {
/* 24 */     for (AtomicPair<String, Integer> extraPair : pairs) {
/* 25 */       this.averages.put((String)extraPair.getKey(), new RollingAverage(((Integer)extraPair.getValue()).intValue()));
/*    */     }
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
/*    */   
/*    */   public RollingAverage getByKey(String key) {
/* 48 */     return this.averages.get(key);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 56 */     for (RollingAverage value : this.averages.values()) {
/* 57 */       value.add(getCurrentValue());
/*    */     }
/* 59 */     resetValue();
/*    */   }
/*    */   
/*    */   public abstract BigDecimal getCurrentValue();
/*    */   
/*    */   public abstract void resetValue();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\KeyPairMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */