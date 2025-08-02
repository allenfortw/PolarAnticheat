/*    */ package net.craftigames.polar.common.util.placeholder;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Placeholders
/*    */ {
/*    */   public static List<String> placeholders(List<String> list, PlaceholderBuilder builder) {
/*  9 */     return placeholders(list, builder.getPlaceholders());
/*    */   }
/*    */   
/*    */   public static List<String> placeholders(List<String> list, List<ObjectSet<String, String>> placeholders) {
/* 13 */     if (list == null || list.isEmpty()) {
/* 14 */       return list;
/*    */     }
/*    */     
/* 17 */     boolean usePlaceholders = (placeholders != null && !placeholders.isEmpty());
/*    */     
/* 19 */     List<String> listTemp = new ArrayList<>();
/* 20 */     for (String s : list) {
/* 21 */       if (usePlaceholders) {
/* 22 */         listTemp.add(placeholder(s, placeholders)); continue;
/*    */       } 
/* 24 */       listTemp.add(s);
/*    */     } 
/*    */     
/* 27 */     return listTemp;
/*    */   }
/*    */   
/*    */   public static String placeholder(String s, List<ObjectSet<String, String>> placeholders) {
/* 31 */     if (s == null || s.isEmpty()) {
/* 32 */       return s;
/*    */     }
/*    */     
/* 35 */     if (placeholders != null && !placeholders.isEmpty()) {
/* 36 */       for (ObjectSet<?, ?> placeholder : placeholders) {
/* 37 */         Object key = placeholder.getA();
/* 38 */         Object value = placeholder.getB();
/* 39 */         if (key != null && value != null) {
/* 40 */           s = s.replace(key.toString(), value.toString());
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 45 */     return s;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\placeholder\Placeholders.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */