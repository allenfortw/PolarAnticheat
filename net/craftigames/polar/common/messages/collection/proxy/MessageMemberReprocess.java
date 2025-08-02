/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 54)
/*    */ public class MessageMemberReprocess extends Message {
/*    */   private UUID playerUuid;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 15 */     this.playerUuid = playerUuid;
/*    */   }
/*    */   public MessageMemberReprocess() {}
/*    */   public UUID getPlayerUuid() {
/* 19 */     return this.playerUuid;
/*    */   }
/*    */   public MessageMemberReprocess(UUID playerUuid) {
/* 22 */     this.playerUuid = playerUuid;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("uuid", this.playerUuid);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 32 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 37 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageMemberReprocess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */