/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 17)
/*    */ public class MessageSendMemberToServer extends Message implements RequestMessage {
/*    */   private UUID uuid;
/*    */   private String server;
/*    */   private UUID identifier;
/*    */   
/* 18 */   public void setUuid(UUID uuid) { this.uuid = uuid; } public void setServer(String server) { this.server = server; } public void setIdentifier(UUID identifier) { this.identifier = identifier; }
/*    */    public MessageSendMemberToServer() {} public MessageSendMemberToServer(UUID uuid, String server, UUID identifier) {
/* 20 */     this.uuid = uuid; this.server = server; this.identifier = identifier;
/*    */   }
/*    */   
/*    */   public UUID getUuid() {
/* 24 */     return this.uuid; } public String getServer() {
/* 25 */     return this.server;
/*    */   }
/*    */   public UUID getIdentifier() {
/* 28 */     return this.identifier;
/*    */   }
/*    */   public MessageSendMemberToServer(UUID uuid, String server) {
/* 31 */     this.uuid = uuid;
/* 32 */     this.server = server;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 37 */     out.add("uuid", this.uuid);
/* 38 */     out.add("server", this.server);
/* 39 */     if (this.identifier != null) {
/* 40 */       out.add("identifier", this.identifier);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 46 */     this.uuid = UUID.fromString(in.get("uuid").getAsString());
/* 47 */     this.server = in.get("server").getAsString();
/* 48 */     JsonElement identifierElement = in.get("identifier");
/* 49 */     if (identifierElement instanceof com.google.gson.JsonPrimitive) {
/* 50 */       this.identifier = in.getAsUUID(identifierElement);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 57 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberToServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */