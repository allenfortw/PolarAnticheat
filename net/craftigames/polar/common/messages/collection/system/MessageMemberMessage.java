/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 4)
/*    */ public class MessageMemberMessage extends Message {
/*    */   private UUID playerUuid;
/*    */   private String message;
/*    */   
/* 14 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } public void setMessage(String message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageMemberMessage() {}
/*    */   
/* 19 */   public UUID getPlayerUuid() { return this.playerUuid; } public String getMessage() {
/* 20 */     return this.message;
/*    */   }
/*    */   public MessageMemberMessage(UUID playerUuid, String message) {
/* 23 */     this.playerUuid = playerUuid;
/* 24 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 29 */     out.add("uuid", this.playerUuid);
/* 30 */     out.add("message", this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 35 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 36 */     setMessage(in.get("message").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 41 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */