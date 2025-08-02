/*    */ package net.craftigames.polar.common.monitoring;
/*    */ 
/*    */ import com.google.common.util.concurrent.ThreadFactoryBuilder;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonitorThreadProvider
/*    */ {
/* 16 */   public static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor((new ThreadFactoryBuilder()).setNameFormat("Polar Monitoring Thread - #%d").setDaemon(true).build());
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\MonitorThreadProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */