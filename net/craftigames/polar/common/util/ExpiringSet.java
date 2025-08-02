/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.common.cache.Cache;
/*    */ import com.google.common.cache.CacheBuilder;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExpiringSet<E>
/*    */ {
/*    */   private final Cache<E, Long> cache;
/*    */   private final long lifetime;
/*    */   
/*    */   public ExpiringSet(long duration, TimeUnit unit) {
/* 19 */     this.cache = CacheBuilder.newBuilder().expireAfterWrite(duration, unit).build();
/* 20 */     this.lifetime = unit.toMillis(duration);
/*    */   }
/*    */   
/*    */   public boolean add(E item) {
/* 24 */     boolean present = contains(item);
/* 25 */     this.cache.put(item, Long.valueOf(System.currentTimeMillis() + this.lifetime));
/* 26 */     return !present;
/*    */   }
/*    */   
/*    */   public boolean contains(E item) {
/* 30 */     Long timeout = (Long)this.cache.getIfPresent(item);
/* 31 */     return (timeout != null && timeout.longValue() > System.currentTimeMillis());
/*    */   }
/*    */   
/*    */   public void remove(E item) {
/* 35 */     this.cache.invalidate(item);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ExpiringSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */