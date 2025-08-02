/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.function.Consumer;
/*    */ import java.util.function.Function;
/*    */ import java.util.stream.Stream;
/*    */ import java.util.stream.StreamSupport;
/*    */ 
/*    */ 
/*    */ public class GsonUtil
/*    */ {
/*    */   public static <T> void hasAndAccept(JsonObject data, String field, Function<JsonElement, T> function, Consumer<T> apply) {
/* 15 */     if (data.has(field)) {
/* 16 */       T value = function.apply(data.get(field));
/* 17 */       apply.accept(value);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static <T> T get(JsonObject data, String field, Function<JsonElement, T> function, T defaultValue) {
/* 22 */     if (data.has(field)) {
/* 23 */       return function.apply(data.get(field));
/*    */     }
/* 25 */     return defaultValue;
/*    */   }
/*    */   
/*    */   public static Stream<JsonElement> stream(JsonArray array) {
/* 29 */     return StreamSupport.stream(array.spliterator(), false);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\GsonUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */