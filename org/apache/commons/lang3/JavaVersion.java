/*     */ package org.apache.commons.lang3;
/*     */ 
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
/*     */ public enum JavaVersion
/*     */ {
/*  33 */   JAVA_0_9(1.5F, "0.9"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   JAVA_1_1(1.1F, "1.1"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   JAVA_1_2(1.2F, "1.2"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   JAVA_1_3(1.3F, "1.3"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   JAVA_1_4(1.4F, "1.4"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   JAVA_1_5(1.5F, "1.5"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   JAVA_1_6(1.6F, "1.6"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   JAVA_1_7(1.7F, "1.7"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   JAVA_1_8(1.8F, "1.8"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   JAVA_1_9(9.0F, "9"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   JAVA_9(9.0F, "9"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   JAVA_10(10.0F, "10"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   JAVA_11(11.0F, "11"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   JAVA_12(12.0F, "12"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   JAVA_13(13.0F, "13"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   JAVA_14(14.0F, "14"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   JAVA_15(15.0F, "15"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   JAVA_16(16.0F, "16"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   JAVA_17(17.0F, "17"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   JAVA_RECENT(maxVersion(), Float.toString(maxVersion()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final float value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JavaVersion(float value, String name) {
/* 168 */     this.value = value;
/* 169 */     this.name = name;
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
/*     */   public boolean atLeast(JavaVersion requiredVersion) {
/* 183 */     return (this.value >= requiredVersion.value);
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
/*     */   public boolean atMost(JavaVersion requiredVersion) {
/* 198 */     return (this.value <= requiredVersion.value);
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
/*     */   static JavaVersion getJavaVersion(String nom) {
/* 212 */     return get(nom);
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
/*     */   static JavaVersion get(String versionStr) {
/* 225 */     if (versionStr == null) {
/* 226 */       return null;
/*     */     }
/* 228 */     switch (versionStr) {
/*     */       case "0.9":
/* 230 */         return JAVA_0_9;
/*     */       case "1.1":
/* 232 */         return JAVA_1_1;
/*     */       case "1.2":
/* 234 */         return JAVA_1_2;
/*     */       case "1.3":
/* 236 */         return JAVA_1_3;
/*     */       case "1.4":
/* 238 */         return JAVA_1_4;
/*     */       case "1.5":
/* 240 */         return JAVA_1_5;
/*     */       case "1.6":
/* 242 */         return JAVA_1_6;
/*     */       case "1.7":
/* 244 */         return JAVA_1_7;
/*     */       case "1.8":
/* 246 */         return JAVA_1_8;
/*     */       case "9":
/* 248 */         return JAVA_9;
/*     */       case "10":
/* 250 */         return JAVA_10;
/*     */       case "11":
/* 252 */         return JAVA_11;
/*     */       case "12":
/* 254 */         return JAVA_12;
/*     */       case "13":
/* 256 */         return JAVA_13;
/*     */       case "14":
/* 258 */         return JAVA_14;
/*     */       case "15":
/* 260 */         return JAVA_15;
/*     */       case "16":
/* 262 */         return JAVA_16;
/*     */       case "17":
/* 264 */         return JAVA_17;
/*     */     } 
/* 266 */     float v = toFloatVersion(versionStr);
/* 267 */     if (v - 1.0D < 1.0D) {
/* 268 */       int firstComma = Math.max(versionStr.indexOf('.'), versionStr.indexOf(','));
/* 269 */       int end = Math.max(versionStr.length(), versionStr.indexOf(',', firstComma));
/* 270 */       if (Float.parseFloat(versionStr.substring(firstComma + 1, end)) > 0.9F) {
/* 271 */         return JAVA_RECENT;
/*     */       }
/* 273 */     } else if (v > 10.0F) {
/* 274 */       return JAVA_RECENT;
/*     */     } 
/* 276 */     return null;
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
/*     */   public String toString() {
/* 290 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float maxVersion() {
/* 299 */     float v = toFloatVersion(System.getProperty("java.specification.version", "99.0"));
/* 300 */     if (v > 0.0F) {
/* 301 */       return v;
/*     */     }
/* 303 */     return 99.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float toFloatVersion(String value) {
/* 313 */     int defaultReturnValue = -1;
/* 314 */     if (value.contains(".")) {
/* 315 */       String[] toParse = value.split("\\.");
/* 316 */       if (toParse.length >= 2) {
/* 317 */         return NumberUtils.toFloat(toParse[0] + '.' + toParse[1], -1.0F);
/*     */       }
/*     */     } else {
/* 320 */       return NumberUtils.toFloat(value, -1.0F);
/*     */     } 
/* 322 */     return -1.0F;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\JavaVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */