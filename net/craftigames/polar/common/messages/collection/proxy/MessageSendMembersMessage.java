/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 107)
/*    */ public class MessageSendMembersMessage
/*    */   extends AbstractMultiplePlayersMessage {
/*    */   private String message;
/*    */   
/*    */   public MessageSendMembersMessage() {}
/*    */   
/*    */   public void setMessage(String message) {
/* 18 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 23 */     return this.message;
/*    */   }
/*    */   public MessageSendMembersMessage(String message) {
/* 26 */     this(null, message);
/*    */   }
/*    */   
/*    */   public MessageSendMembersMessage(List<UUID> playerUuids, String message) {
/* 30 */     setPlayerUuids(playerUuids);
/* 31 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     super.send(out);
/* 37 */     out.add("message", this.message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     super.receive(in);
/* 43 */     this.message = in.get("message").getAsString();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 49 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMembersMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */