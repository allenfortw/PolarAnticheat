/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.time.Duration;
/*     */ import java.time.temporal.ChronoUnit;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.ObjectUtils;
/*     */ import org.apache.commons.lang3.Range;
/*     */ import org.apache.commons.lang3.function.FailableBiConsumer;
/*     */ import org.apache.commons.lang3.math.NumberUtils;
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
/*     */ public class DurationUtils
/*     */ {
/*  40 */   static final Range<Long> LONG_TO_INT_RANGE = Range.between(NumberUtils.LONG_INT_MIN_VALUE, NumberUtils.LONG_INT_MAX_VALUE);
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
/*     */   public static <T extends Throwable> void accept(FailableBiConsumer<Long, Integer, T> consumer, Duration duration) throws T {
/*  53 */     if (consumer != null && duration != null) {
/*  54 */       consumer.accept(Long.valueOf(duration.toMillis()), Integer.valueOf(getNanosOfMiili(duration)));
/*     */     }
/*     */   }
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
/*     */   public static int getNanosOfMiili(Duration duration) {
/*  72 */     return duration.getNano() % 1000000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPositive(Duration duration) {
/*  82 */     return (!duration.isNegative() && !duration.isZero());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
/*  93 */     switch ((TimeUnit)Objects.requireNonNull((T)timeUnit)) {
/*     */       case NANOSECONDS:
/*  95 */         return ChronoUnit.NANOS;
/*     */       case MICROSECONDS:
/*  97 */         return ChronoUnit.MICROS;
/*     */       case MILLISECONDS:
/*  99 */         return ChronoUnit.MILLIS;
/*     */       case SECONDS:
/* 101 */         return ChronoUnit.SECONDS;
/*     */       case MINUTES:
/* 103 */         return ChronoUnit.MINUTES;
/*     */       case HOURS:
/* 105 */         return ChronoUnit.HOURS;
/*     */       case DAYS:
/* 107 */         return ChronoUnit.DAYS;
/*     */     } 
/* 109 */     throw new IllegalArgumentException(timeUnit.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Duration toDuration(long amount, TimeUnit timeUnit) {
/* 121 */     return Duration.of(amount, toChronoUnit(timeUnit));
/*     */   }
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
/*     */   public static int toMillisInt(Duration duration) {
/* 140 */     Objects.requireNonNull(duration, "duration");
/*     */     
/* 142 */     return ((Long)LONG_TO_INT_RANGE.fit(Long.valueOf(duration.toMillis()))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Duration zeroIfNull(Duration duration) {
/* 152 */     return (Duration)ObjectUtils.defaultIfNull(duration, Duration.ZERO);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\time\DurationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */