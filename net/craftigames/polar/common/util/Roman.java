/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ public class Roman
/*     */ {
/*  10 */   private static final Map<String, Integer> integerCache = Maps.newHashMap();
/*  11 */   private static final Map<Integer, String> stringCache = Maps.newHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String numeralOf(int value) {
/*  20 */     Validate.isTrue((value > 0), "Roman numbers can't express zero or negative numbers!", new Object[0]);
/*     */     
/*  22 */     String cache = stringCache.get(Integer.valueOf(value));
/*  23 */     if (cache != null) {
/*  24 */       return cache;
/*     */     }
/*     */     
/*  27 */     StringBuilder builder = new StringBuilder();
/*  28 */     RomanNumber[] romanNumbers = RomanNumber.values();
/*     */     
/*  30 */     for (int i = 0; i < romanNumbers.length; i++) {
/*  31 */       RomanNumber romanNumber = romanNumbers[i];
/*     */ 
/*     */       
/*  34 */       while (value >= romanNumber.getInDecimal()) {
/*  35 */         value -= romanNumber.getInDecimal();
/*  36 */         builder.append(romanNumber.name());
/*     */       } 
/*     */ 
/*     */       
/*  40 */       if (i < romanNumbers.length - 1) {
/*  41 */         int index = i - i % 2 + 2;
/*  42 */         RomanNumber subtractNum = romanNumbers[index];
/*     */         
/*  44 */         if (value >= romanNumber.getInDecimal() - subtractNum.getInDecimal()) {
/*  45 */           value -= romanNumber.getInDecimal() - subtractNum.getInDecimal();
/*  46 */           builder.append(subtractNum.name());
/*  47 */           builder.append(romanNumber.name());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  52 */     String result = builder.toString();
/*  53 */     stringCache.put(Integer.valueOf(value), result);
/*     */     
/*  55 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getValueOf(String romanNumeral) {
/*  65 */     Integer cache = integerCache.get(romanNumeral);
/*  66 */     if (cache != null) {
/*  67 */       return cache.intValue();
/*     */     }
/*     */     
/*  70 */     char[] numerals = romanNumeral.toCharArray();
/*  71 */     int total = 0;
/*     */     
/*  73 */     for (int i = 0; i < numerals.length; i++) {
/*  74 */       int value = getNumeralValue(numerals[i]);
/*  75 */       if (i < numerals.length - 1 && 
/*  76 */         getNumeralValue(numerals[i + 1]) > value) {
/*  77 */         value = -value;
/*     */       }
/*     */       
/*  80 */       if (value == 0) {
/*  81 */         return 0;
/*     */       }
/*  83 */       total += value;
/*     */     } 
/*     */     
/*  86 */     integerCache.put(romanNumeral, Integer.valueOf(total));
/*  87 */     return total;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getNumeralValue(char numeral) {
/*  97 */     String romanNumeral = ("" + numeral).toUpperCase();
/*     */     try {
/*  99 */       RomanNumber romanNumber = RomanNumber.valueOf(romanNumeral);
/* 100 */       return romanNumber.getInDecimal();
/* 101 */     } catch (IllegalArgumentException e) {
/* 102 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private enum RomanNumber
/*     */   {
/* 108 */     M(1000), D(500), C(100), L(50), X(10), V(5), I(1);
/*     */ 
/*     */ 
/*     */     
/*     */     private final int valueInDec;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RomanNumber(int decimal) {
/* 118 */       this.valueInDec = decimal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getInDecimal() {
/* 127 */       return this.valueInDec;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\Roman.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */