/*    */ package net.craftigames.polar.common.messages.collection.guild;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 93)
/*    */ public class MessageRequestGuildData extends Message {
/*    */   private long verificationId;
/*    */   
/*    */   public MessageRequestGuildData(long verificationId, int userId) {
/* 12 */     this.verificationId = verificationId; this.userId = userId;
/*    */   }
/*    */   private int userId;
/*    */   public MessageRequestGuildData() {}
/*    */   
/*    */   public long getVerificationId() {
/* 18 */     return this.verificationId; } public int getUserId() {
/* 19 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 23 */     out.add("verification", Long.valueOf(this.verificationId));
/* 24 */     out.add("userId", Integer.valueOf(this.userId));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 29 */     this.verificationId = in.get("verification").getAsLong();
/* 30 */     this.userId = in.get("userId").getAsInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 35 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\guild\MessageRequestGuildData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */