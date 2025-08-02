/*     */ package net.craftigames.polar.common.util.time;
/*     */ 
/*     */ import java.time.Duration;
/*     */ import java.time.Instant;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Time
/*     */ {
/*     */   public static long nowMillis() {
/*  21 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nowSeconds() {
/*  30 */     return nowMillis() / 1000L;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long getEpoch() {
/*  35 */     return nowMillis() / 1000L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Instant now() {
/*  44 */     return Instant.ofEpochMilli(System.currentTimeMillis());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Duration diffToNow(Instant other) {
/*  54 */     return Duration.between(now(), other).abs();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Duration duration(TimeUnit unit, long amount) {
/*  65 */     Objects.requireNonNull(unit, "unit");
/*  66 */     switch (unit) {
/*     */       case NANOSECONDS:
/*  68 */         return Duration.ofNanos(amount);
/*     */       case MICROSECONDS:
/*  70 */         return Duration.ofNanos(TimeUnit.MICROSECONDS.toNanos(amount));
/*     */       case MILLISECONDS:
/*  72 */         return Duration.ofMillis(amount);
/*     */       case SECONDS:
/*  74 */         return Duration.ofSeconds(amount);
/*     */       case MINUTES:
/*  76 */         return Duration.ofMinutes(amount);
/*     */       case HOURS:
/*  78 */         return Duration.ofHours(amount);
/*     */       case DAYS:
/*  80 */         return Duration.ofDays(amount);
/*     */     } 
/*  82 */     throw new AssertionError("unknown time unit: " + unit);
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
/*     */   public static String formatTime(long millis) {
/*  94 */     List<String> parts = new ArrayList<>();
/*  95 */     long days = millis / TimeUnit.DAYS.toMillis(1L);
/*  96 */     if (days > 0L) {
/*  97 */       millis -= TimeUnit.DAYS.toMillis(days);
/*  98 */       parts.add(days + ((days != 1L) ? " days" : " day"));
/*     */     } 
/*     */     
/* 101 */     long hours = millis / TimeUnit.HOURS.toMillis(1L);
/* 102 */     if (hours > 0L) {
/* 103 */       millis -= TimeUnit.HOURS.toMillis(hours);
/* 104 */       parts.add(hours + ((hours != 1L) ? " hours" : " hour"));
/*     */     } 
/*     */     
/* 107 */     long minutes = millis / TimeUnit.MINUTES.toMillis(1L);
/* 108 */     if (minutes > 0L) {
/* 109 */       millis -= TimeUnit.MINUTES.toMillis(minutes);
/* 110 */       parts.add(minutes + ((minutes != 1L) ? " minutes" : " minute"));
/*     */     } 
/*     */     
/* 113 */     long seconds = millis / TimeUnit.SECONDS.toMillis(1L);
/* 114 */     if (parts.isEmpty() || seconds != 0L) {
/* 115 */       parts.add(seconds + ((seconds != 1L) ? " seconds" : " second"));
/*     */     }
/*     */     
/* 118 */     String formatted = String.join(", ", (Iterable)parts);
/* 119 */     if (formatted.contains(", ")) {
/* 120 */       int index = formatted.lastIndexOf(", ");
/* 121 */       StringBuilder builder = new StringBuilder(formatted);
/* 122 */       formatted = builder.replace(index, index + 2, " and ").toString();
/*     */     } 
/*     */     
/* 125 */     return formatted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long calculateRemaining(long end) {
/* 135 */     return end - System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isWeekSame(long c2) {
/* 140 */     Calendar calendar = Calendar.getInstance();
/* 141 */     calendar.setTimeInMillis(c2);
/* 142 */     return isWeekSame(calendar);
/*     */   }
/*     */   
/*     */   public static boolean isMonthSame(long c2) {
/* 146 */     Calendar calendar = Calendar.getInstance();
/* 147 */     calendar.setTimeInMillis(c2);
/* 148 */     return isMonthSame(calendar);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isWeekSame(Calendar c2) {
/* 153 */     Calendar c1 = Calendar.getInstance();
/* 154 */     c1.setTimeInMillis(System.currentTimeMillis());
/*     */     
/* 156 */     return (c1.get(1) == c2.get(1) && c1
/* 157 */       .get(3) == c2.get(3));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isMonthSame(Calendar c2) {
/* 162 */     Calendar c1 = Calendar.getInstance();
/* 163 */     c1.setTimeInMillis(System.currentTimeMillis());
/*     */     
/* 165 */     return (c1.get(1) == c2.get(1) && c1
/* 166 */       .get(2) == c2.get(2));
/*     */   }
/*     */   
/*     */   private Time() {
/* 170 */     throw new UnsupportedOperationException("This class cannot be instantiated");
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\time\Time.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */