/*    */ package net.craftigames.polar.common.messages.collection.economy;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 96)
/*    */ public class MemberMinigameTransactionResponseMessage extends Message {
/*    */   private UUID identifier;
/*    */   private String member;
/*    */   
/*    */   public MemberMinigameTransactionResponseMessage(UUID identifier, String member, int amount, String currency, boolean success) {
/* 14 */     this.identifier = identifier; this.member = member; this.amount = amount; this.currency = currency; this.success = success;
/*    */   }
/*    */   int amount; String currency; boolean success;
/*    */   public MemberMinigameTransactionResponseMessage() {}
/*    */   
/*    */   public UUID getIdentifier() {
/* 20 */     return this.identifier;
/* 21 */   } public String getMember() { return this.member; }
/* 22 */   public int getAmount() { return this.amount; }
/* 23 */   public String getCurrency() { return this.currency; } public boolean isSuccess() {
/* 24 */     return this.success;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     out.add("id", this.identifier.toString());
/* 29 */     out.add("member", this.member);
/* 30 */     out.add("amount", Integer.valueOf(this.amount));
/* 31 */     out.add("currency", this.currency);
/* 32 */     out.add("success", Boolean.valueOf(this.success));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     this.identifier = UUID.fromString(in.get("id").getAsString());
/* 38 */     this.member = in.get("member").getAsString();
/* 39 */     this.amount = in.get("amount").getAsInt();
/* 40 */     this.currency = in.get("currency").getAsString();
/* 41 */     this.success = in.get("success").getAsBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\economy\MemberMinigameTransactionResponseMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */