/*     */ package net.craftigames.polar.common.monitoring;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import net.craftigames.polar.common.util.NumberConversions;
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
/*     */ public class RollingAverage
/*     */ {
/*     */   private final Queue<BigDecimal> samples;
/*     */   private final int size;
/*  36 */   private BigDecimal total = BigDecimal.ZERO;
/*     */   
/*     */   public RollingAverage(int size) {
/*  39 */     this.size = size;
/*  40 */     this.samples = new ArrayDeque<>(this.size);
/*     */   }
/*     */   
/*     */   public void add(BigDecimal num) {
/*  44 */     synchronized (this) {
/*  45 */       this.total = this.total.add(num);
/*  46 */       this.samples.add(num);
/*  47 */       if (this.samples.size() > this.size) {
/*  48 */         this.total = this.total.subtract(this.samples.remove());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public BigDecimal getAverage() {
/*  54 */     synchronized (this) {
/*  55 */       if (this.samples.isEmpty()) {
/*  56 */         return BigDecimal.ZERO;
/*     */       }
/*  58 */       return this.total.divide(BigDecimal.valueOf(this.samples.size()), 30, RoundingMode.HALF_UP);
/*     */     } 
/*     */   }
/*     */   
/*     */   public BigDecimal getMax() {
/*  63 */     synchronized (this) {
/*  64 */       BigDecimal max = BigDecimal.ZERO;
/*  65 */       for (BigDecimal sample : this.samples) {
/*  66 */         if (sample.compareTo(max) > 0) {
/*  67 */           max = sample;
/*     */         }
/*     */       } 
/*  70 */       return max;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BigDecimal getMin() {
/*  75 */     synchronized (this) {
/*  76 */       BigDecimal min = BigDecimal.ZERO;
/*  77 */       for (BigDecimal sample : this.samples) {
/*  78 */         if (min == BigDecimal.ZERO || sample.compareTo(min) < 0) {
/*  79 */           min = sample;
/*     */         }
/*     */       } 
/*  82 */       return min;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BigDecimal getMedian() {
/*  87 */     return getPercentile(50);
/*     */   }
/*     */   public BigDecimal getPercentile(int percentile) {
/*     */     List<BigDecimal> sortedSamples;
/*  91 */     if (percentile < 0 || percentile > 100) {
/*  92 */       throw new IllegalArgumentException("Invalid percentage " + percentile);
/*     */     }
/*     */ 
/*     */     
/*  96 */     synchronized (this) {
/*  97 */       if (this.samples.isEmpty()) {
/*  98 */         return BigDecimal.ZERO;
/*     */       }
/* 100 */       sortedSamples = new ArrayList<>(this.samples);
/*     */     } 
/* 102 */     sortedSamples.sort(null);
/*     */     
/* 104 */     int rank = NumberConversions.ceil(percentile / 100.0D * sortedSamples.size());
/* 105 */     return sortedSamples.get(rank);
/*     */   }
/*     */   
/*     */   public BigDecimal getTotal() {
/* 109 */     return this.total;
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 113 */     return this.size;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\RollingAverage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */