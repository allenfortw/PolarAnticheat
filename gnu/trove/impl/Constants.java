/*     */ package gnu.trove.impl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Constants
/*     */ {
/*     */   private static final boolean VERBOSE;
/*     */   public static final int DEFAULT_CAPACITY = 10;
/*     */   public static final float DEFAULT_LOAD_FACTOR = 0.5F;
/*     */   public static final byte DEFAULT_BYTE_NO_ENTRY_VALUE;
/*     */   public static final short DEFAULT_SHORT_NO_ENTRY_VALUE;
/*     */   public static final char DEFAULT_CHAR_NO_ENTRY_VALUE;
/*     */   public static final int DEFAULT_INT_NO_ENTRY_VALUE;
/*     */   public static final long DEFAULT_LONG_NO_ENTRY_VALUE;
/*     */   public static final float DEFAULT_FLOAT_NO_ENTRY_VALUE;
/*     */   public static final double DEFAULT_DOUBLE_NO_ENTRY_VALUE;
/*     */   
/*     */   static {
/*     */     short s;
/*     */     int i;
/*     */     long l;
/*     */     float f;
/*     */     double value;
/*  28 */     boolean verbose = false;
/*     */     try {
/*  30 */       verbose = (System.getProperty("gnu.trove.verbose", null) != null);
/*     */     }
/*  32 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  35 */     VERBOSE = verbose;
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
/*  49 */     String property = "0";
/*     */     try {
/*  51 */       property = System.getProperty("gnu.trove.no_entry.byte", property);
/*     */     }
/*  53 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  56 */     if ("MAX_VALUE".equalsIgnoreCase(property)) { s = 127; }
/*  57 */     else if ("MIN_VALUE".equalsIgnoreCase(property)) { s = -128; }
/*  58 */     else { s = Byte.valueOf(property).byteValue(); }
/*     */     
/*  60 */     if (s > 127) { s = 127; }
/*  61 */     else if (s < -128) { s = -128; }
/*  62 */      DEFAULT_BYTE_NO_ENTRY_VALUE = s;
/*  63 */     if (VERBOSE) {
/*  64 */       System.out.println("DEFAULT_BYTE_NO_ENTRY_VALUE: " + DEFAULT_BYTE_NO_ENTRY_VALUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     property = "0";
/*     */     try {
/*  76 */       property = System.getProperty("gnu.trove.no_entry.short", property);
/*     */     }
/*  78 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  81 */     if ("MAX_VALUE".equalsIgnoreCase(property)) { short s1 = Short.MAX_VALUE; }
/*  82 */     else if ("MIN_VALUE".equalsIgnoreCase(property)) { short s1 = Short.MIN_VALUE; }
/*  83 */     else { s = Short.valueOf(property).shortValue(); }
/*     */     
/*  85 */     if (s > Short.MAX_VALUE) { s = Short.MAX_VALUE; }
/*  86 */     else if (s < Short.MIN_VALUE) { s = Short.MIN_VALUE; }
/*  87 */      DEFAULT_SHORT_NO_ENTRY_VALUE = s;
/*  88 */     if (VERBOSE) {
/*  89 */       System.out.println("DEFAULT_SHORT_NO_ENTRY_VALUE: " + DEFAULT_SHORT_NO_ENTRY_VALUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     property = "\000";
/*     */     try {
/* 101 */       property = System.getProperty("gnu.trove.no_entry.char", property);
/*     */     }
/* 103 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 106 */     if ("MAX_VALUE".equalsIgnoreCase(property)) { i = 65535; }
/* 107 */     else if ("MIN_VALUE".equalsIgnoreCase(property)) { i = 0; }
/* 108 */     else { i = property.toCharArray()[0]; }
/*     */     
/* 110 */     if (i > 65535) { i = 65535; }
/* 111 */     else if (i < 0) { i = 0; }
/* 112 */      DEFAULT_CHAR_NO_ENTRY_VALUE = i;
/* 113 */     if (VERBOSE) {
/* 114 */       System.out.println("DEFAULT_CHAR_NO_ENTRY_VALUE: " + 
/* 115 */           Integer.valueOf(i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     property = "0";
/*     */     try {
/* 126 */       property = System.getProperty("gnu.trove.no_entry.int", property);
/*     */     }
/* 128 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 131 */     if ("MAX_VALUE".equalsIgnoreCase(property)) { int j = Integer.MAX_VALUE; }
/* 132 */     else if ("MIN_VALUE".equalsIgnoreCase(property)) { int j = Integer.MIN_VALUE; }
/* 133 */     else { i = Integer.valueOf(property).intValue(); }
/* 134 */      DEFAULT_INT_NO_ENTRY_VALUE = i;
/* 135 */     if (VERBOSE) {
/* 136 */       System.out.println("DEFAULT_INT_NO_ENTRY_VALUE: " + DEFAULT_INT_NO_ENTRY_VALUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     String str1 = "0";
/*     */     try {
/* 148 */       str1 = System.getProperty("gnu.trove.no_entry.long", str1);
/*     */     }
/* 150 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 153 */     if ("MAX_VALUE".equalsIgnoreCase(str1)) { l = Long.MAX_VALUE; }
/* 154 */     else if ("MIN_VALUE".equalsIgnoreCase(str1)) { l = Long.MIN_VALUE; }
/* 155 */     else { l = Long.valueOf(str1).longValue(); }
/* 156 */      DEFAULT_LONG_NO_ENTRY_VALUE = l;
/* 157 */     if (VERBOSE) {
/* 158 */       System.out.println("DEFAULT_LONG_NO_ENTRY_VALUE: " + DEFAULT_LONG_NO_ENTRY_VALUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     property = "0";
/*     */     try {
/* 170 */       property = System.getProperty("gnu.trove.no_entry.float", property);
/*     */     }
/* 172 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 175 */     if ("MAX_VALUE".equalsIgnoreCase(property)) { f = Float.MAX_VALUE; }
/* 176 */     else if ("MIN_VALUE".equalsIgnoreCase(property)) { f = Float.MIN_VALUE; }
/*     */     
/* 178 */     else if ("MIN_NORMAL".equalsIgnoreCase(property)) { f = 1.17549435E-38F; }
/* 179 */     else if ("NEGATIVE_INFINITY".equalsIgnoreCase(property)) { f = Float.NEGATIVE_INFINITY; }
/* 180 */     else if ("POSITIVE_INFINITY".equalsIgnoreCase(property)) { f = Float.POSITIVE_INFINITY; }
/*     */     else
/* 182 */     { f = Float.valueOf(property).floatValue(); }
/* 183 */      DEFAULT_FLOAT_NO_ENTRY_VALUE = f;
/* 184 */     if (VERBOSE) {
/* 185 */       System.out.println("DEFAULT_FLOAT_NO_ENTRY_VALUE: " + DEFAULT_FLOAT_NO_ENTRY_VALUE);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     str1 = "0";
/*     */     try {
/* 197 */       str1 = System.getProperty("gnu.trove.no_entry.double", str1);
/*     */     }
/* 199 */     catch (SecurityException securityException) {}
/*     */ 
/*     */     
/* 202 */     if ("MAX_VALUE".equalsIgnoreCase(str1)) { value = Double.MAX_VALUE; }
/* 203 */     else if ("MIN_VALUE".equalsIgnoreCase(str1)) { value = Double.MIN_VALUE; }
/*     */     
/* 205 */     else if ("MIN_NORMAL".equalsIgnoreCase(str1)) { value = 2.2250738585072014E-308D; }
/* 206 */     else if ("NEGATIVE_INFINITY".equalsIgnoreCase(str1)) { value = Double.NEGATIVE_INFINITY; }
/* 207 */     else if ("POSITIVE_INFINITY".equalsIgnoreCase(str1)) { value = Double.POSITIVE_INFINITY; }
/*     */     else
/* 209 */     { value = Double.valueOf(str1).doubleValue(); }
/* 210 */      DEFAULT_DOUBLE_NO_ENTRY_VALUE = value;
/* 211 */     if (VERBOSE)
/* 212 */       System.out.println("DEFAULT_DOUBLE_NO_ENTRY_VALUE: " + DEFAULT_DOUBLE_NO_ENTRY_VALUE); 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */