/*    */ package net.craftigames.polar.common.models;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class InitialServerResult implements GsonSerializable {
/*    */   private String server;
/*    */   
/*    */   public InitialServerResult() {}
/*    */   
/*    */   public void setServer(String server) {
/* 14 */     this.server = server;
/*    */   } public InitialServerResult(String server) {
/* 16 */     this.server = server;
/*    */   }
/*    */   public String getServer() {
/* 19 */     return this.server;
/*    */   }
/*    */   public static InitialServerResult deserialize(JsonElement element) {
/* 22 */     if (element.isJsonNull()) {
/* 23 */       return null;
/*    */     }
/*    */     
/* 26 */     JsonObject object = element.getAsJsonObject();
/* 27 */     InitialServerResult result = new InitialServerResult();
/* 28 */     result.setServer(object.get("server").getAsString());
/*    */     
/* 30 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 36 */     return (JsonElement)JsonBuilder.object()
/* 37 */       .add("server", this.server)
/* 38 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\InitialServerResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */