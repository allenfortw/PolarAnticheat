/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ 
/*    */ import net.craftigames.polar.common.clans.ClanPlayerInfo;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 66)
/*    */ public class MessageRequestClanDataResponse
/*    */   extends Message {
/*    */   private long verificationId;
/*    */   private ClanPlayerInfo clanPlayerInfo;
/*    */   
/*    */   public MessageRequestClanDataResponse(long verificationId, ClanPlayerInfo clanPlayerInfo) {
/* 17 */     this.verificationId = verificationId; this.clanPlayerInfo = clanPlayerInfo;
/*    */   }
/*    */   
/*    */   public MessageRequestClanDataResponse() {}
/*    */   
/*    */   public long getVerificationId() {
/* 23 */     return this.verificationId; } public ClanPlayerInfo getClanPlayerInfo() {
/* 24 */     return this.clanPlayerInfo;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     out.add("verification", Long.valueOf(this.verificationId));
/* 29 */     out.add("info", this.clanPlayerInfo.serialize());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     this.verificationId = in.get("verification").getAsLong();
/*    */     try {
/* 36 */       this.clanPlayerInfo = ClanPlayerInfo.deserialize(in.get("info"));
/* 37 */     } catch (Exception e) {
/* 38 */       this.clanPlayerInfo = new ClanPlayerInfo();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 44 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageRequestClanDataResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */