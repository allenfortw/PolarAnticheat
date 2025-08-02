/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class PlayerTeleportQueue implements GsonSerializable, QueueAction {
/*    */   private String targetServer;
/*    */   private UUID target;
/*    */   
/* 14 */   public void setTargetServer(String targetServer) { this.targetServer = targetServer; } public void setTarget(UUID target) { this.target = target; }
/*    */ 
/*    */   
/*    */   public PlayerTeleportQueue() {}
/* 18 */   public String getTargetServer() { return this.targetServer; } public UUID getTarget() {
/* 19 */     return this.target;
/*    */   }
/*    */   public PlayerTeleportQueue(UUID target) {
/* 22 */     this.target = target;
/*    */   }
/*    */   
/*    */   public static PlayerTeleportQueue deserialize(JsonElement element) {
/* 26 */     Preconditions.checkArgument(element.isJsonObject());
/* 27 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 29 */     return new PlayerTeleportQueue(UUID.fromString(object.get("target").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement serialize() {
/* 34 */     return (JsonElement)JsonBuilder.object()
/* 35 */       .add("target", this.target)
/* 36 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\PlayerTeleportQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */