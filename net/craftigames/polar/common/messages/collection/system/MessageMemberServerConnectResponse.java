/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 49)
/*    */ public class MessageMemberServerConnectResponse extends Message implements PendingRequestResponseMessage {
/*    */   private UUID user;
/*    */   private UUID uuid;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessageMemberServerConnectResponse(UUID user, UUID uuid, JsonElement data) {
/* 17 */     this.user = user; this.uuid = uuid; this.data = data;
/*    */   }
/*    */   public MessageMemberServerConnectResponse() {}
/* 20 */   public void setUser(UUID user) { this.user = user; } public void setUuid(UUID uuid) { this.uuid = uuid; } public void setData(JsonElement data) { this.data = data; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 24 */     return this.user;
/* 25 */   } public UUID getUuid() { return this.uuid; } public JsonElement getData() {
/* 26 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("user", this.user);
/* 31 */     out.add("uuid", this.uuid);
/* 32 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     this.user = in.getAsUUID("user");
/* 38 */     this.uuid = in.getAsUUID("uuid");
/* 39 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 44 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberServerConnectResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */