/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 65)
/*    */ public class MessageRequestClanData
/*    */   extends Message {
/*    */   private long verificationId;
/*    */   private int userId;
/*    */   
/*    */   public MessageRequestClanData(long verificationId, int userId) {
/* 16 */     this.verificationId = verificationId; this.userId = userId;
/*    */   }
/*    */   
/*    */   public MessageRequestClanData() {}
/*    */   
/*    */   public long getVerificationId() {
/* 22 */     return this.verificationId; } public int getUserId() {
/* 23 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("verification", Long.valueOf(this.verificationId));
/* 28 */     out.add("userId", Integer.valueOf(this.userId));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.verificationId = in.get("verification").getAsLong();
/* 34 */     this.userId = in.get("userId").getAsInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageRequestClanData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */