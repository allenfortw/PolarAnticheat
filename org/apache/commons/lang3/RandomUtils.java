/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ public class RandomUtils
/*     */ {
/*  40 */   private static final Random RANDOM = new Random();
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
/*     */   public static boolean nextBoolean() {
/*  66 */     return RANDOM.nextBoolean();
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
/*     */   public static byte[] nextBytes(int count) {
/*  80 */     Validate.isTrue((count >= 0), "Count cannot be negative.", new Object[0]);
/*     */     
/*  82 */     byte[] result = new byte[count];
/*  83 */     RANDOM.nextBytes(result);
/*  84 */     return result;
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
/*     */   public static int nextInt(int startInclusive, int endExclusive) {
/* 102 */     Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 104 */     Validate.isTrue((startInclusive >= 0), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 106 */     if (startInclusive == endExclusive) {
/* 107 */       return startInclusive;
/*     */     }
/*     */     
/* 110 */     return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nextInt() {
/* 121 */     return nextInt(0, 2147483647);
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
/*     */   public static long nextLong(long startInclusive, long endExclusive) {
/* 139 */     Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 141 */     Validate.isTrue((startInclusive >= 0L), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 143 */     if (startInclusive == endExclusive) {
/* 144 */       return startInclusive;
/*     */     }
/*     */     
/* 147 */     return startInclusive + nextLong(endExclusive - startInclusive);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nextLong() {
/* 158 */     return nextLong(Long.MAX_VALUE);
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
/*     */   private static long nextLong(long n) {
/*     */     long bits;
/*     */     long val;
/*     */     do {
/* 174 */       bits = RANDOM.nextLong() >>> 1L;
/* 175 */       val = bits % n;
/* 176 */     } while (bits - val + n - 1L < 0L);
/*     */     
/* 178 */     return val;
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
/*     */   public static double nextDouble(double startInclusive, double endExclusive) {
/* 196 */     Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 198 */     Validate.isTrue((startInclusive >= 0.0D), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 200 */     if (startInclusive == endExclusive) {
/* 201 */       return startInclusive;
/*     */     }
/*     */     
/* 204 */     return startInclusive + (endExclusive - startInclusive) * RANDOM.nextDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double nextDouble() {
/* 215 */     return nextDouble(0.0D, Double.MAX_VALUE);
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
/*     */   public static float nextFloat(float startInclusive, float endExclusive) {
/* 233 */     Validate.isTrue((endExclusive >= startInclusive), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 235 */     Validate.isTrue((startInclusive >= 0.0F), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 237 */     if (startInclusive == endExclusive) {
/* 238 */       return startInclusive;
/*     */     }
/*     */     
/* 241 */     return startInclusive + (endExclusive - startInclusive) * RANDOM.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nextFloat() {
/* 252 */     return nextFloat(0.0F, Float.MAX_VALUE);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\RandomUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */