/*    */ package net.craftigames.polar.common.monitoring;
/*    */ 
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonitorStorage
/*    */ {
/* 17 */   private static final AtomicReference<Object> instance = new AtomicReference(); public static MonitorStorage getInstance() { Object value = instance.get(); if (value == null) synchronized (instance) { value = instance.get(); if (value == null) { MonitorStorage actualValue = new MonitorStorage(); value = (actualValue == null) ? instance : actualValue; instance.set(value); }  }   return (value == instance) ? null : (MonitorStorage)value; }
/*    */ 
/*    */   
/*    */   private static boolean ACTIVE = false;
/* 21 */   private final List<KeyPairMonitor> monitors = new ArrayList<>(); public List<KeyPairMonitor> getMonitors() { return this.monitors; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addMonitor(KeyPairMonitor monitor) {
/* 29 */     if (getMonitor(monitor.getClass()) != null) {
/* 30 */       throw new IllegalArgumentException("A monitor already exists with class \"" + monitor.getClass().getName() + "\"");
/*    */     }
/* 32 */     if (!Modifier.isFinal(monitor.getClass().getModifiers())) {
/* 33 */       throw new IllegalArgumentException("Monitor class must be final of \"" + monitor.getClass().getName() + "\"");
/*    */     }
/* 35 */     this.monitors.add(monitor);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T extends KeyPairMonitor> T getMonitor(Class<T> clazz) {
/* 46 */     for (KeyPairMonitor monitor : this.monitors) {
/* 47 */       if (clazz.isInstance(monitor)) {
/* 48 */         return (T)monitor;
/*    */       }
/*    */     } 
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize() {
/* 59 */     if (ACTIVE) {
/* 60 */       throw new IllegalAccessError("Monitoring is already enabled.");
/*    */     }
/* 62 */     ACTIVE = true;
/*    */     
/* 64 */     MonitorThreadProvider.EXECUTOR.scheduleAtFixedRate(() -> { for (KeyPairMonitor monitor : this.monitors) monitor.run();  }1L, 1L, TimeUnit.SECONDS);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\MonitorStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */