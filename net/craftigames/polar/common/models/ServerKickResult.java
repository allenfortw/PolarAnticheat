/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class ServerKickResult implements GsonSerializable {
/*    */   @Nullable
/*    */   private String targetServer;
/*    */   private boolean disconnect;
/*    */   private boolean cancelled;
/*    */   
/* 16 */   public void setTargetServer(@Nullable String targetServer) { this.targetServer = targetServer; } public void setDisconnect(boolean disconnect) { this.disconnect = disconnect; } public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*    */    public ServerKickResult() {} public ServerKickResult(@Nullable String targetServer, boolean disconnect, boolean cancelled) {
/* 18 */     this.targetServer = targetServer; this.disconnect = disconnect; this.cancelled = cancelled;
/*    */   }
/*    */   @Nullable
/* 21 */   public String getTargetServer() { return this.targetServer; } public boolean isDisconnect() {
/* 22 */     return this.disconnect;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCancelled() {
/* 27 */     return this.cancelled;
/*    */   }
/*    */   public boolean useFallbackServer() {
/* 30 */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public static ServerKickResult deserialize(JsonElement element) {
/* 34 */     if (element.isJsonNull()) {
/* 35 */       return null;
/*    */     }
/*    */     
/* 38 */     JsonObject object = element.getAsJsonObject();
/* 39 */     ServerKickResult result = new ServerKickResult();
/* 40 */     JsonElement serverElement = object.get("server");
/* 41 */     if (serverElement instanceof com.google.gson.JsonPrimitive) {
/* 42 */       result.setTargetServer(serverElement.getAsString());
/*    */     }
/*    */     
/* 45 */     JsonElement disconnectElement = object.get("disconnect");
/* 46 */     if (disconnectElement instanceof com.google.gson.JsonPrimitive) {
/* 47 */       result.setDisconnect(disconnectElement.getAsBoolean());
/*    */     }
/* 49 */     result.setCancelled(object.get("cancelled").getAsBoolean());
/*    */     
/* 51 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 57 */     return (JsonElement)JsonBuilder.object()
/* 58 */       .add("server", this.targetServer)
/* 59 */       .add("disconnect", Boolean.valueOf(this.disconnect))
/* 60 */       .add("cancelled", Boolean.valueOf(this.cancelled))
/* 61 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ServerKickResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */