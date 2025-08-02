/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 5)
/*    */ public class MessageSendMemberMessage
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private String message;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 17 */     this.playerUuid = playerUuid; } public void setMessage(String message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageSendMemberMessage() {}
/*    */   
/* 22 */   public UUID getPlayerUuid() { return this.playerUuid; } public String getMessage() {
/* 23 */     return this.message;
/*    */   }
/*    */   public MessageSendMemberMessage(UUID playerUuid, String message) {
/* 26 */     this.playerUuid = playerUuid;
/* 27 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 32 */     out.add("uuid", this.playerUuid);
/* 33 */     out.add("message", this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 39 */     setMessage(in.get("message").getAsString());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 45 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */