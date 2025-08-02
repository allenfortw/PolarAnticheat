/*    */ package net.craftigames.polar.common.messages.collection.economy;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 95)
/*    */ public class MemberMinigameTransactionMessage extends Message {
/*    */   private UUID identifier;
/*    */   private String member;
/*    */   
/*    */   public MemberMinigameTransactionMessage(UUID identifier, String member, int amount, String currency) {
/* 14 */     this.identifier = identifier; this.member = member; this.amount = amount; this.currency = currency;
/*    */   }
/*    */   int amount; String currency;
/*    */   public MemberMinigameTransactionMessage() {}
/*    */   
/*    */   public UUID getIdentifier() {
/* 20 */     return this.identifier;
/* 21 */   } public String getMember() { return this.member; }
/* 22 */   public int getAmount() { return this.amount; } public String getCurrency() {
/* 23 */     return this.currency;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("id", this.identifier.toString());
/* 28 */     out.add("member", this.member);
/* 29 */     out.add("amount", Integer.valueOf(this.amount));
/* 30 */     out.add("currency", this.currency);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 35 */     this.identifier = UUID.fromString(in.get("id").getAsString());
/* 36 */     this.member = in.get("member").getAsString();
/* 37 */     this.amount = in.get("amount").getAsInt();
/* 38 */     this.currency = in.get("currency").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 43 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\economy\MemberMinigameTransactionMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */