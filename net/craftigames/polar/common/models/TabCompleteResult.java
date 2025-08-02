/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class TabCompleteResult
/*    */   implements GsonSerializable {
/*    */   private List<String> suggestions;
/*    */   private boolean cancelled;
/*    */   
/*    */   public void setSuggestions(List<String> suggestions) {
/* 17 */     this.suggestions = suggestions; } public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */    public TabCompleteResult() {} public TabCompleteResult(List<String> suggestions, boolean cancelled) {
/* 19 */     this.suggestions = suggestions; this.cancelled = cancelled;
/*    */   }
/*    */   
/* 22 */   public List<String> getSuggestions() { return this.suggestions; } public boolean isCancelled() {
/* 23 */     return this.cancelled;
/*    */   }
/*    */   public static TabCompleteResult deserialize(JsonElement element) {
/* 26 */     if (element.isJsonNull()) {
/* 27 */       return null;
/*    */     }
/*    */     
/* 30 */     JsonObject object = element.getAsJsonObject();
/* 31 */     TabCompleteResult result = new TabCompleteResult();
/* 32 */     result.setCancelled(object.get("cancelled").getAsBoolean());
/*    */     
/* 34 */     if (object.has("suggestions")) {
/* 35 */       List<String> suggestions = new ArrayList<>();
/* 36 */       JsonElement suggestionsElement = object.get("suggestions");
/* 37 */       if (suggestionsElement instanceof com.google.gson.JsonArray) {
/* 38 */         for (JsonElement arrayElement : suggestionsElement.getAsJsonArray()) {
/* 39 */           suggestions.add(arrayElement.getAsString());
/*    */         }
/*    */       }
/* 42 */       result.setSuggestions(suggestions);
/*    */     } 
/*    */     
/* 45 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 51 */     return (JsonElement)JsonBuilder.object()
/* 52 */       .consume(b -> {
/*    */           
/*    */           if (this.suggestions != null) {
/*    */             if (this.suggestions.isEmpty()) {
/*    */               b.add("suggestions", (JsonElement)JsonBuilder.nullValue());
/*    */             } else {
/*    */               b.add("suggestions", (JsonElement)JsonBuilder.array().addStrings(this.suggestions).build());
/*    */             } 
/*    */           }
/* 61 */         }).add("cancelled", Boolean.valueOf(this.cancelled))
/* 62 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\TabCompleteResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */