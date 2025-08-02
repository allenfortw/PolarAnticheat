/*    */ package net.craftigames.polar.common.messages.collection.guild;
/*    */ import net.craftigames.polar.common.guilds.GuildPlayerInfo;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 94)
/*    */ public class MessageRequestGuildDataResponse extends Message {
/*    */   private long verificationId;
/*    */   
/*    */   public MessageRequestGuildDataResponse(long verificationId, GuildPlayerInfo guildPlayerInfo) {
/* 13 */     this.verificationId = verificationId; this.guildPlayerInfo = guildPlayerInfo;
/*    */   }
/*    */   private GuildPlayerInfo guildPlayerInfo;
/*    */   public MessageRequestGuildDataResponse() {}
/*    */   
/*    */   public long getVerificationId() {
/* 19 */     return this.verificationId; } public GuildPlayerInfo getGuildPlayerInfo() {
/* 20 */     return this.guildPlayerInfo;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 24 */     out.add("verification", Long.valueOf(this.verificationId));
/* 25 */     out.add("info", this.guildPlayerInfo.serialize());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 30 */     this.verificationId = in.get("verification").getAsLong();
/*    */     try {
/* 32 */       this.guildPlayerInfo = GuildPlayerInfo.deserialize(in.get("info"));
/* 33 */     } catch (Exception e) {
/* 34 */       this.guildPlayerInfo = new GuildPlayerInfo();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 40 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\guild\MessageRequestGuildDataResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */