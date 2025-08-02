/*    */ package net.craftigames.polar.common.util.number;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.DecimalFormatSymbols;
/*    */ import java.text.NumberFormat;
/*    */ import java.util.Locale;
/*    */ 
/*    */ 
/*    */ public class NumberUtil
/*    */ {
/* 13 */   private static final DecimalFormat twoDPlaces = new DecimalFormat("#,###.##");
/* 14 */   private static final DecimalFormat currencyFormat = new DecimalFormat("#0.00", DecimalFormatSymbols.getInstance(Locale.US));
/*    */ 
/*    */ 
/*    */   
/* 18 */   private static NumberFormat PRETTY_FORMAT = NumberFormat.getInstance(Locale.US);
/*    */   
/*    */   static {
/* 21 */     twoDPlaces.setRoundingMode(RoundingMode.HALF_UP);
/* 22 */     currencyFormat.setRoundingMode(RoundingMode.FLOOR);
/*    */     
/* 24 */     PRETTY_FORMAT.setRoundingMode(RoundingMode.FLOOR);
/* 25 */     PRETTY_FORMAT.setGroupingUsed(true);
/* 26 */     PRETTY_FORMAT.setMinimumFractionDigits(2);
/* 27 */     PRETTY_FORMAT.setMaximumFractionDigits(2);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void internalSetPrettyFormat(NumberFormat prettyFormat) {
/* 32 */     PRETTY_FORMAT = prettyFormat;
/*    */   }
/*    */   
/*    */   public static String formatDouble(double value) {
/* 36 */     return twoDPlaces.format(value);
/*    */   }
/*    */   
/*    */   public static String formatAsCurrency(BigDecimal value) {
/* 40 */     String str = currencyFormat.format(value);
/* 41 */     if (str.endsWith(".00")) {
/* 42 */       str = str.substring(0, str.length() - 3);
/*    */     }
/* 44 */     return str;
/*    */   }
/*    */   
/*    */   public static String formatAsPrettyCurrency(BigDecimal value) {
/* 48 */     String str = PRETTY_FORMAT.format(value);
/* 49 */     if (str.endsWith(".00")) {
/* 50 */       str = str.substring(0, str.length() - 3);
/*    */     }
/* 52 */     return str;
/*    */   }
/*    */   
/*    */   public static String displayCurrency(BigDecimal value) {
/* 56 */     String currency = formatAsPrettyCurrency(value);
/* 57 */     String sign = "";
/* 58 */     if (value.signum() < 0) {
/* 59 */       currency = currency.substring(1);
/* 60 */       sign = "-";
/*    */     } 
/* 62 */     return sign + currency;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\number\NumberUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */