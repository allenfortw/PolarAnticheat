/*    */ package net.craftigames.polar.common.util.gson.types;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class StringArray
/*    */   implements GsonSerializable
/*    */ {
/*    */   private String[] value;
/*    */   
/*    */   public StringArray(String[] value) {
/* 19 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String[] getValue() {
/* 23 */     return this.value;
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public JsonArray serialize() {
/* 28 */     return JsonBuilder.array()
/* 29 */       .consume(b -> {
/*    */           for (String s : this.value) {
/*    */             b.add(JsonBuilder.primitive(s));
/*    */           }
/* 33 */         }).build();
/*    */   }
/*    */   
/*    */   public static StringArray deserialize(JsonElement element) {
/* 37 */     Preconditions.checkArgument(element.isJsonArray());
/* 38 */     JsonArray array = element.getAsJsonArray();
/*    */     
/* 40 */     List<String> values = new ArrayList<>();
/* 41 */     for (JsonElement jsonElement : array) {
/* 42 */       values.add(jsonElement.getAsString());
/*    */     }
/*    */     
/* 45 */     return of(values);
/*    */   }
/*    */   
/*    */   public static StringArray of(List<String> values) {
/* 49 */     Objects.requireNonNull(values, "values");
/*    */     
/* 51 */     return new StringArray(values.<String>toArray(new String[0]));
/*    */   }
/*    */   
/*    */   public static StringArray of(String... values) {
/* 55 */     Objects.requireNonNull(values, "values");
/*    */     
/* 57 */     return new StringArray(values);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\types\StringArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */