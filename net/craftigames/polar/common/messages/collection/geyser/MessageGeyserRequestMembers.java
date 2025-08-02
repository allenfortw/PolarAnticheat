/*    */ package net.craftigames.polar.common.messages.collection.geyser;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.geyser.GeyserData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 77)
/*    */ public class MessageGeyserRequestMembers
/*    */   extends Message
/*    */ {
/*    */   private Map<UUID, GeyserData> uuids;
/*    */   
/*    */   public MessageGeyserRequestMembers(Map<UUID, GeyserData> uuids) {
/* 30 */     this.uuids = new HashMap<>(); this.uuids = uuids; } public MessageGeyserRequestMembers() { this.uuids = new HashMap<>(); } public Map<UUID, GeyserData> getUuids() { return this.uuids; }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     JsonArray array = new JsonArray();
/*    */     
/* 36 */     this.uuids.forEach((uuid, data) -> {
/*    */           JsonObject object = new JsonObject();
/*    */           
/*    */           object.addProperty("uuid", uuid.toString());
/*    */           
/*    */           object.add("data", data.serialize());
/*    */           array.add((JsonElement)object);
/*    */         });
/* 44 */     out.add("uuids", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 49 */     this.uuids = new HashMap<>();
/*    */     
/* 51 */     JsonArray array = in.getAsJsonArray("uuids");
/* 52 */     for (JsonElement jsonElement : array) {
/* 53 */       if (!jsonElement.isJsonObject()) {
/*    */         continue;
/*    */       }
/* 56 */       JsonObject object = jsonElement.getAsJsonObject();
/*    */       
/* 58 */       this.uuids.put(UUID.fromString(object.get("uuid").getAsString()), GeyserData.deserialize(object.get("data")));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 64 */     return MessageType.GEYSER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\MessageGeyserRequestMembers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */