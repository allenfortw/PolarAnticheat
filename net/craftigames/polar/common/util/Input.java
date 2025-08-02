/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import net.craftigames.polar.common.util.xseries.XPolarMaterial;
/*    */ 
/*    */ 
/*    */ public class Input
/*    */ {
/*    */   public static Optional<Integer> tryInteger(String input) {
/* 10 */     if (input == null || input.isEmpty()) {
/* 11 */       return Optional.empty();
/*    */     }
/*    */     try {
/* 14 */       return Optional.of(Integer.valueOf(Integer.parseInt(input)));
/* 15 */     } catch (NumberFormatException e) {
/* 16 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Optional<Long> tryLong(String input) {
/* 21 */     if (input == null || input.isEmpty()) {
/* 22 */       return Optional.empty();
/*    */     }
/*    */     try {
/* 25 */       return Optional.of(Long.valueOf(Long.parseLong(input)));
/* 26 */     } catch (NumberFormatException e) {
/* 27 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Optional<Double> tryDouble(String input) {
/* 32 */     if (input == null || input.isEmpty()) {
/* 33 */       return Optional.empty();
/*    */     }
/*    */     try {
/* 36 */       return Optional.of(Double.valueOf(Double.parseDouble(input)));
/* 37 */     } catch (NumberFormatException e) {
/* 38 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Optional<Float> tryFloat(String input) {
/* 43 */     if (input == null || input.isEmpty()) {
/* 44 */       return Optional.empty();
/*    */     }
/*    */     try {
/* 47 */       return Optional.of(Float.valueOf(Float.parseFloat(input)));
/* 48 */     } catch (NumberFormatException e) {
/* 49 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Optional<XPolarMaterial> tryMaterial(String input) {
/* 54 */     if (input == null || input.isEmpty()) {
/* 55 */       return Optional.empty();
/*    */     }
/*    */     try {
/* 58 */       return Optional.of(XPolarMaterial.valueOf(input));
/* 59 */     } catch (NumberFormatException e) {
/* 60 */       return Optional.empty();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */