/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageSpoofChatMessageMember
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private String message;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 16 */     this.playerUuid = playerUuid; } public void setMessage(String message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageSpoofChatMessageMember() {}
/*    */   
/* 21 */   public UUID getPlayerUuid() { return this.playerUuid; } public String getMessage() {
/* 22 */     return this.message;
/*    */   }
/*    */   public MessageSpoofChatMessageMember(UUID playerUuid, String message) {
/* 25 */     this.playerUuid = playerUuid;
/* 26 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     out.add("uuid", this.playerUuid);
/* 32 */     out.add("message", this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 38 */     setMessage(in.get("message").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSpoofChatMessageMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */