/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 42)
/*    */ public class MessageMemberMessageCallback extends AbstractTimeoutMessage implements RequestMessage {
/*    */   private UUID playerUuid;
/*    */   private String message;
/*    */   
/* 15 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } private UUID identifier; private String serverIdentifier; public void setMessage(String message) { this.message = message; } public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setServerIdentifier(String serverIdentifier) { this.serverIdentifier = serverIdentifier; }
/*    */ 
/*    */   
/*    */   public MessageMemberMessageCallback() {}
/*    */   
/* 20 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 21 */   public String getMessage() { return this.message; }
/* 22 */   public UUID getIdentifier() { return this.identifier; } public String getServerIdentifier() {
/* 23 */     return this.serverIdentifier;
/*    */   }
/*    */   public MessageMemberMessageCallback(UUID playerUuid, String message) {
/* 26 */     this.playerUuid = playerUuid;
/* 27 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 32 */     super.send(out);
/* 33 */     out.add("uuid", this.playerUuid);
/* 34 */     out.add("message", this.message);
/* 35 */     out.add("identifier", this.identifier);
/* 36 */     out.add("serverIdentifier", this.serverIdentifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 41 */     super.receive(in);
/* 42 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 43 */     setMessage(in.get("message").getAsString());
/* 44 */     setIdentifier(in.getAsUUID("identifier"));
/* 45 */     setServerIdentifier(in.get("serverIdentifier").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 50 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberMessageCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */