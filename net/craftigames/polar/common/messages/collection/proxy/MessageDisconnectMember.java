/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 34)
/*    */ public class MessageDisconnectMember
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private Component message;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 19 */     this.playerUuid = playerUuid; } public void setMessage(Component message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageDisconnectMember() {}
/*    */   
/* 24 */   public UUID getPlayerUuid() { return this.playerUuid; } public Component getMessage() {
/* 25 */     return this.message;
/*    */   }
/*    */   public MessageDisconnectMember(UUID playerUuid, Component message) {
/* 28 */     this.playerUuid = playerUuid;
/* 29 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("uuid", this.playerUuid);
/* 35 */     out.add("message", TextUtils.toGson(this.message));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 41 */     setMessage(TextUtils.fromGson(in.get("message").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageDisconnectMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */