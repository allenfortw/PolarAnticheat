/*     */ package org.apache.commons.lang3;
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
/*     */ public class CharUtils
/*     */ {
/*  31 */   private static final String[] CHAR_STRING_ARRAY = new String[128];
/*     */   
/*  33 */   private static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char LF = '\n';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char CR = '\r';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char NUL = '\000';
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  61 */     for (char c = Character.MIN_VALUE; c < CHAR_STRING_ARRAY.length; c = (char)(c + 1)) {
/*  62 */       CHAR_STRING_ARRAY[c] = String.valueOf(c);
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
/*     */   @Deprecated
/*     */   public static Character toCharacterObject(char ch) {
/*  94 */     return Character.valueOf(ch);
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
/*     */ 
/*     */   
/*     */   public static Character toCharacterObject(String str) {
/* 115 */     if (StringUtils.isEmpty(str)) {
/* 116 */       return null;
/*     */     }
/* 118 */     return Character.valueOf(str.charAt(0));
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
/*     */   public static char toChar(Character ch) {
/* 136 */     Validate.notNull(ch, "ch", new Object[0]);
/* 137 */     return ch.charValue();
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
/*     */   public static char toChar(Character ch, char defaultValue) {
/* 154 */     if (ch == null) {
/* 155 */       return defaultValue;
/*     */     }
/* 157 */     return ch.charValue();
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
/*     */ 
/*     */   
/*     */   public static char toChar(String str) {
/* 178 */     Validate.notEmpty(str, "The String must not be empty", new Object[0]);
/* 179 */     return str.charAt(0);
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
/*     */   public static char toChar(String str, char defaultValue) {
/* 198 */     if (StringUtils.isEmpty(str)) {
/* 199 */       return defaultValue;
/*     */     }
/* 201 */     return str.charAt(0);
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
/*     */   
/*     */   public static int toIntValue(char ch) {
/* 221 */     if (!isAsciiNumeric(ch)) {
/* 222 */       throw new IllegalArgumentException("The character " + ch + " is not in the range '0' - '9'");
/*     */     }
/* 224 */     return ch - 48;
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
/*     */   public static int toIntValue(char ch, int defaultValue) {
/* 243 */     if (!isAsciiNumeric(ch)) {
/* 244 */       return defaultValue;
/*     */     }
/* 246 */     return ch - 48;
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
/*     */ 
/*     */   
/*     */   public static int toIntValue(Character ch) {
/* 267 */     Validate.notNull(ch, "ch", new Object[0]);
/* 268 */     return toIntValue(ch.charValue());
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
/*     */   
/*     */   public static int toIntValue(Character ch, int defaultValue) {
/* 288 */     if (ch == null) {
/* 289 */       return defaultValue;
/*     */     }
/* 291 */     return toIntValue(ch.charValue(), defaultValue);
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
/*     */   public static String toString(char ch) {
/* 310 */     if (ch < '') {
/* 311 */       return CHAR_STRING_ARRAY[ch];
/*     */     }
/* 313 */     return new String(new char[] { ch });
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
/*     */ 
/*     */   
/*     */   public static String toString(Character ch) {
/* 334 */     if (ch == null) {
/* 335 */       return null;
/*     */     }
/* 337 */     return toString(ch.charValue());
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
/*     */   public static String unicodeEscaped(char ch) {
/* 355 */     return "\\u" + HEX_DIGITS[ch >> 12 & 0xF] + HEX_DIGITS[ch >> 8 & 0xF] + HEX_DIGITS[ch >> 4 & 0xF] + HEX_DIGITS[ch & 0xF];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unicodeEscaped(Character ch) {
/* 379 */     if (ch == null) {
/* 380 */       return null;
/*     */     }
/* 382 */     return unicodeEscaped(ch.charValue());
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
/*     */   
/*     */   public static boolean isAscii(char ch) {
/* 402 */     return (ch < '');
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
/*     */   public static boolean isAsciiPrintable(char ch) {
/* 421 */     return (ch >= ' ' && ch < '');
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
/*     */   public static boolean isAsciiControl(char ch) {
/* 440 */     return (ch < ' ' || ch == '');
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
/*     */   public static boolean isAsciiAlpha(char ch) {
/* 459 */     return (isAsciiAlphaUpper(ch) || isAsciiAlphaLower(ch));
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
/*     */   public static boolean isAsciiAlphaUpper(char ch) {
/* 478 */     return (ch >= 'A' && ch <= 'Z');
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
/*     */   public static boolean isAsciiAlphaLower(char ch) {
/* 497 */     return (ch >= 'a' && ch <= 'z');
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
/*     */   public static boolean isAsciiNumeric(char ch) {
/* 516 */     return (ch >= '0' && ch <= '9');
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
/*     */   public static boolean isAsciiAlphanumeric(char ch) {
/* 535 */     return (isAsciiAlpha(ch) || isAsciiNumeric(ch));
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
/*     */   public static int compare(char x, char y) {
/* 549 */     return x - y;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\CharUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */