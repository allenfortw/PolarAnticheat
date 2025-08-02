/*    */ package net.craftigames.polar.common.util.time;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import javax.annotation.Nonnull;
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
/*    */ public final class Ticks
/*    */ {
/*    */   public static final int TICKS_PER_SECOND = 20;
/*    */   public static final int MILLISECONDS_PER_SECOND = 1000;
/*    */   public static final int MILLISECONDS_PER_TICK = 50;
/*    */   
/*    */   public static long from(long duration, @Nonnull TimeUnit unit) {
/* 27 */     return unit.toMillis(duration) / 50L;
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
/*    */   public static long to(long ticks, @Nonnull TimeUnit unit) {
/* 40 */     return unit.convert(ticks * 50L, TimeUnit.MILLISECONDS);
/*    */   }
/*    */   
/*    */   private Ticks() {
/* 44 */     throw new UnsupportedOperationException("This class cannot be instantiated");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\time\Ticks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */