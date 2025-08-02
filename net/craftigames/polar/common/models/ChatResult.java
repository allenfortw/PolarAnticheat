/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class ChatResult implements GsonSerializable {
/*    */   private String message;
/*    */   private boolean cancelled;
/*    */   
/*    */   public void setMessage(String message) {
/* 14 */     this.message = message; } public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */    public ChatResult() {} public ChatResult(String message, boolean cancelled) {
/* 16 */     this.message = message; this.cancelled = cancelled;
/*    */   }
/*    */   
/* 19 */   public String getMessage() { return this.message; } public boolean isCancelled() {
/* 20 */     return this.cancelled;
/*    */   }
/*    */   public static ChatResult deserialize(JsonElement element) {
/* 23 */     if (element.isJsonNull()) {
/* 24 */       return null;
/*    */     }
/*    */     
/* 27 */     JsonObject object = element.getAsJsonObject();
/* 28 */     ChatResult result = new ChatResult();
/* 29 */     result.setMessage(object.get("message").getAsString());
/* 30 */     result.setCancelled(object.get("cancelled").getAsBoolean());
/*    */     
/* 32 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 38 */     return (JsonElement)JsonBuilder.object()
/* 39 */       .add("message", this.message)
/* 40 */       .add("cancelled", Boolean.valueOf(this.cancelled))
/* 41 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ChatResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */