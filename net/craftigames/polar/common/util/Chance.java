/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.util.Random;
/*    */ import java.util.concurrent.ThreadLocalRandom;
/*    */ 
/*    */ public class Chance
/*    */ {
/*    */   private static Random random;
/*    */   
/*    */   public static Random getRandom() {
/* 11 */     if (random == null) {
/* 12 */       random = new Random();
/*    */     }
/* 14 */     return random;
/*    */   }
/*    */   
/*    */   public static boolean chance(double chance) {
/* 18 */     if (chance <= 0.0D) {
/* 19 */       return false;
/*    */     }
/* 21 */     return (getRandom().nextDouble() * 100.0D <= chance);
/*    */   }
/*    */   
/*    */   public static int generateRandom(int nextInt) {
/* 25 */     return getRandom().nextInt(nextInt);
/*    */   }
/*    */   
/*    */   public static boolean countChance(int chance) {
/* 29 */     return (generateRandom(100) < chance);
/*    */   }
/*    */   
/*    */   public static int percentPick(int min, int max) {
/* 33 */     if (max == min) {
/* 34 */       if (max <= 0) {
/* 35 */         return max;
/*    */       }
/* 37 */       return getRandom().nextInt(max);
/*    */     } 
/* 39 */     return min + getRandom().nextInt(max - min);
/*    */   }
/*    */   
/*    */   public static boolean randomPicker(int max) {
/* 43 */     if (max <= 0) {
/* 44 */       return true;
/*    */     }
/* 46 */     int chance = 1 + getRandom().nextInt(max);
/* 47 */     return (chance == 1);
/*    */   }
/*    */   
/*    */   public static boolean randomPicker(int min, int max) {
/* 51 */     if (max == min) {
/* 52 */       return true;
/*    */     }
/* 54 */     int chance = 1 + getRandom().nextInt(max);
/* 55 */     return (chance <= min);
/*    */   }
/*    */   
/*    */   public static double randomDouble(double min, double max) {
/* 59 */     if (min >= max) {
/* 60 */       return min;
/*    */     }
/* 62 */     return ThreadLocalRandom.current().nextDouble(min, max);
/*    */   }
/*    */   
/*    */   public static long randomLong(long min, long max) {
/* 66 */     if (min >= max) {
/* 67 */       return min;
/*    */     }
/* 69 */     return ThreadLocalRandom.current().nextLong(min, max);
/*    */   }
/*    */   
/*    */   public static int randomInt(double min, double max) {
/* 73 */     return (int)Math.round(ThreadLocalRandom.current().nextDouble(min, max));
/*    */   }
/*    */   
/*    */   public static int randomInt(int min, int max) {
/* 77 */     return ThreadLocalRandom.current().nextInt(min, max);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\Chance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */