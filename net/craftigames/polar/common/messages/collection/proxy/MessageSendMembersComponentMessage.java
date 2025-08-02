/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 30)
/*    */ public class MessageSendMembersComponentMessage
/*    */   extends AbstractMultiplePlayersMessage {
/*    */   private Component message;
/*    */   
/*    */   public MessageSendMembersComponentMessage() {}
/*    */   
/*    */   public void setMessage(Component message) {
/* 20 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getMessage() {
/* 25 */     return this.message;
/*    */   }
/*    */   public MessageSendMembersComponentMessage(Component message) {
/* 28 */     this(null, message);
/*    */   }
/*    */   
/*    */   public MessageSendMembersComponentMessage(List<UUID> playerUuids, Component message) {
/* 32 */     setPlayerUuids(playerUuids);
/* 33 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 38 */     super.send(out);
/* 39 */     out.add("message", TextUtils.toGson(this.message));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     super.receive(in);
/* 45 */     setMessage(TextUtils.fromGson(in.get("message").getAsString()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 51 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMembersComponentMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */