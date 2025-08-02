/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberConversions
/*     */ {
/*     */   public static int floor(double num) {
/*  10 */     int floor = (int)num;
/*  11 */     return (floor == num) ? floor : (floor - (int)(Double.doubleToRawLongBits(num) >>> 63L));
/*     */   }
/*     */   
/*     */   public static int ceil(double num) {
/*  15 */     int floor = (int)num;
/*  16 */     return (floor == num) ? floor : (floor + (int)((Double.doubleToRawLongBits(num) ^ 0xFFFFFFFFFFFFFFFFL) >>> 63L));
/*     */   }
/*     */   
/*     */   public static int round(double num) {
/*  20 */     return floor(num + 0.5D);
/*     */   }
/*     */   
/*     */   public static double square(double num) {
/*  24 */     return num * num;
/*     */   }
/*     */   
/*     */   public static int toInt(Object object) {
/*  28 */     if (object instanceof Number) {
/*  29 */       return ((Number)object).intValue();
/*     */     }
/*     */ 
/*     */     
/*  33 */     try { return Integer.valueOf(object.toString()).intValue(); }
/*  34 */     catch (NumberFormatException numberFormatException) {  }
/*  35 */     catch (NullPointerException nullPointerException) {}
/*     */     
/*  37 */     return 0;
/*     */   }
/*     */   
/*     */   public static float toFloat(Object object) {
/*  41 */     if (object instanceof Number) {
/*  42 */       return ((Number)object).floatValue();
/*     */     }
/*     */ 
/*     */     
/*  46 */     try { return Float.valueOf(object.toString()).floatValue(); }
/*  47 */     catch (NumberFormatException numberFormatException) {  }
/*  48 */     catch (NullPointerException nullPointerException) {}
/*     */     
/*  50 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public static double toDouble(Object object) {
/*  54 */     if (object instanceof Number) {
/*  55 */       return ((Number)object).doubleValue();
/*     */     }
/*     */ 
/*     */     
/*  59 */     try { return Double.valueOf(object.toString()).doubleValue(); }
/*  60 */     catch (NumberFormatException numberFormatException) {  }
/*  61 */     catch (NullPointerException nullPointerException) {}
/*     */     
/*  63 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public static long toLong(Object object) {
/*  67 */     if (object instanceof Number) {
/*  68 */       return ((Number)object).longValue();
/*     */     }
/*     */ 
/*     */     
/*  72 */     try { return Long.valueOf(object.toString()).longValue(); }
/*  73 */     catch (NumberFormatException numberFormatException) {  }
/*  74 */     catch (NullPointerException nullPointerException) {}
/*     */     
/*  76 */     return 0L;
/*     */   }
/*     */   
/*     */   public static short toShort(Object object) {
/*  80 */     if (object instanceof Number) {
/*  81 */       return ((Number)object).shortValue();
/*     */     }
/*     */ 
/*     */     
/*  85 */     try { return Short.valueOf(object.toString()).shortValue(); }
/*  86 */     catch (NumberFormatException numberFormatException) {  }
/*  87 */     catch (NullPointerException nullPointerException) {}
/*     */     
/*  89 */     return 0;
/*     */   }
/*     */   
/*     */   public static byte toByte(Object object) {
/*  93 */     if (object instanceof Number) {
/*  94 */       return ((Number)object).byteValue();
/*     */     }
/*     */ 
/*     */     
/*  98 */     try { return Byte.valueOf(object.toString()).byteValue(); }
/*  99 */     catch (NumberFormatException numberFormatException) {  }
/* 100 */     catch (NullPointerException nullPointerException) {}
/*     */     
/* 102 */     return 0;
/*     */   }
/*     */   
/*     */   public static boolean isFinite(double d) {
/* 106 */     return (Math.abs(d) <= Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public static boolean isFinite(float f) {
/* 110 */     return (Math.abs(f) <= Float.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public static void checkFinite(double d, String message) {
/* 114 */     if (!isFinite(d)) {
/* 115 */       throw new IllegalArgumentException(message);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void checkFinite(float d, String message) {
/* 120 */     if (!isFinite(d)) {
/* 121 */       throw new IllegalArgumentException(message);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Number addNumbers(Number a, Number b) {
/* 126 */     if (a instanceof Double || b instanceof Double)
/* 127 */       return Double.valueOf(a.doubleValue() + b.doubleValue()); 
/* 128 */     if (a instanceof Float || b instanceof Float)
/* 129 */       return Float.valueOf(a.floatValue() + b.floatValue()); 
/* 130 */     if (a instanceof Long || b instanceof Long) {
/* 131 */       return Long.valueOf(a.longValue() + b.longValue());
/*     */     }
/* 133 */     return Integer.valueOf(a.intValue() + b.intValue());
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\NumberConversions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */