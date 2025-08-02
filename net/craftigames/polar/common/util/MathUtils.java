/*     */ package net.craftigames.polar.common.util;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ public class MathUtils {
/*     */   public static String ms(Long time) {
/*  13 */     long ns = System.nanoTime() - time.longValue();
/*  14 */     return ns(ns);
/*     */   }
/*     */   
/*     */   public static String ns(long ns) {
/*  18 */     float ms = (float)ns / 1000000.0F;
/*  19 */     return String.format("%.3f", new Object[] { Float.valueOf(ms) });
/*     */   }
/*     */   
/*     */   public static double round(double value, int places) {
/*  23 */     if (places < 0) {
/*  24 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/*  27 */     BigDecimal bd = new BigDecimal(value);
/*  28 */     bd = bd.setScale(places, RoundingMode.HALF_UP);
/*  29 */     return bd.doubleValue();
/*     */   }
/*     */   
/*     */   public static String formatHourMinute(int millis) {
/*  33 */     return String.format("%02d:%02d", new Object[] {
/*  34 */           Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis)), 
/*  35 */           Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES
/*  36 */             .toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))
/*     */         });
/*     */   }
/*     */   
/*     */   public static String formatHourMinute(Long millis) {
/*  41 */     return String.format("%02d:%02d", new Object[] {
/*  42 */           Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(millis.longValue())), 
/*  43 */           Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(millis.longValue()) - TimeUnit.MINUTES
/*  44 */             .toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis.longValue())))
/*     */         });
/*     */   }
/*     */   
/*     */   public static String format(double value) {
/*  49 */     return NumberFormat.getInstance().format(value);
/*     */   }
/*     */   
/*     */   public static String formatDouble(double value) {
/*  53 */     NumberFormat formatter = new DecimalFormat("#0.00");
/*  54 */     formatter.setRoundingMode(RoundingMode.HALF_UP);
/*  55 */     return formatter.format(value);
/*     */   }
/*     */   
/*     */   public static boolean isNumber(String s) {
/*     */     try {
/*  60 */       Integer.parseInt(s);
/*  61 */     } catch (NumberFormatException nfe) {
/*  62 */       return false;
/*     */     } 
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean randomPicker(int min, int max) {
/*  68 */     if (max == min) {
/*  69 */       return true;
/*     */     }
/*  71 */     int chance = 1 + (new Random()).nextInt(max);
/*  72 */     return (chance >= 1 && chance <= min);
/*     */   }
/*     */   
/*     */   public static long clamp(long val, long min, long max) {
/*  76 */     return Math.max(min, Math.min(max, val));
/*     */   }
/*     */   
/*     */   public static int clamp(int val, int min, int max) {
/*  80 */     return Math.max(min, Math.min(max, val));
/*     */   }
/*     */   
/*     */   public static double clamp(double val, double min, double max) {
/*  84 */     return Math.max(min, Math.min(max, val));
/*     */   }
/*     */   
/*     */   public static float clamp(float val, float min, float max) {
/*  88 */     return Math.max(min, Math.min(max, val));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Number> double getAverage(Collection<T> samples) {
/*  99 */     if (samples.isEmpty()) {
/* 100 */       throw new IllegalArgumentException("Samples are empty");
/*     */     }
/* 102 */     return ((BigDecimal)samples.stream().map(number -> BigDecimal.valueOf(number.doubleValue())).reduce(BigDecimal.ZERO, BigDecimal::add))
/* 103 */       .divide(BigDecimal.valueOf(samples.size()), RoundingMode.HALF_UP).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Number & Comparable<T>> T getMin(Collection<T> samples, T emptyValue) {
/*     */     Number number;
/* 113 */     T min = emptyValue;
/* 114 */     for (Number number1 : samples) {
/* 115 */       if (Objects.equals(min, emptyValue) || ((Comparable<T>)number1).compareTo(min) < 0) {
/* 116 */         number = number1;
/*     */       }
/*     */     } 
/* 119 */     return (T)number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Number & Comparable<T>> T getMax(Collection<T> samples, T emptyValue) {
/*     */     Number number;
/* 129 */     T max = emptyValue;
/* 130 */     for (Number number1 : samples) {
/* 131 */       if (((Comparable<T>)number1).compareTo(max) > 0) {
/* 132 */         number = number1;
/*     */       }
/*     */     } 
/* 135 */     return (T)number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Number> T getPercentile(int percentile, Collection<T> samples) {
/* 146 */     if (percentile < 0 || percentile > 100) {
/* 147 */       throw new IllegalArgumentException("Invalid percentage " + percentile);
/*     */     }
/*     */     
/* 150 */     if (samples.isEmpty()) {
/* 151 */       throw new IllegalArgumentException("Samples are empty");
/*     */     }
/* 153 */     List<T> sortedSamples = new ArrayList<>(samples);
/* 154 */     sortedSamples.sort(null);
/*     */     
/* 156 */     int rank = clamp(NumberConversions.ceil(percentile / 100.0D * sortedSamples.size()), 0, sortedSamples.size() - 1);
/* 157 */     return sortedSamples.get(rank);
/*     */   }
/*     */   
/*     */   public static <T extends Number> T getMedian(Collection<T> samples) {
/* 161 */     return getPercentile(50, samples);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\MathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */