/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThresholdCircuitBreaker
/*     */   extends AbstractCircuitBreaker<Long>
/*     */ {
/*     */   private static final long INITIAL_COUNT = 0L;
/*     */   private final long threshold;
/*     */   private final AtomicLong used;
/*     */   
/*     */   public ThresholdCircuitBreaker(long threshold) {
/*  76 */     this.used = new AtomicLong(0L);
/*  77 */     this.threshold = threshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getThreshold() {
/*  86 */     return this.threshold;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkState() {
/*  94 */     return isOpen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 104 */     super.close();
/* 105 */     this.used.set(0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean incrementAndCheckState(Long increment) {
/* 115 */     if (this.threshold == 0L) {
/* 116 */       open();
/*     */     }
/*     */     
/* 119 */     long used = this.used.addAndGet(increment.longValue());
/* 120 */     if (used > this.threshold) {
/* 121 */       open();
/*     */     }
/*     */     
/* 124 */     return checkState();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\concurrent\ThresholdCircuitBreaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */