/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 68)
/*    */ public class MessageClanPlayerEarnings extends Message {
/*    */   private String identifier;
/*    */   private String serverType;
/*    */   private int userId;
/*    */   private int experience;
/*    */   private int coins;
/*    */   
/*    */   public MessageClanPlayerEarnings(String identifier, String serverType, int userId, int experience, int coins) {
/* 16 */     this.identifier = identifier; this.serverType = serverType; this.userId = userId; this.experience = experience; this.coins = coins;
/*    */   }
/*    */   
/*    */   public MessageClanPlayerEarnings() {}
/*    */   
/*    */   public String getIdentifier() {
/* 22 */     return this.identifier; } public String getServerType() {
/* 23 */     return this.serverType;
/*    */   }
/* 25 */   public int getUserId() { return this.userId; }
/* 26 */   public int getExperience() { return this.experience; } public int getCoins() {
/* 27 */     return this.coins;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     out.add("identifier", this.identifier);
/* 32 */     out.add("serverType", this.serverType);
/*    */     
/* 34 */     out.add("user", Integer.valueOf(this.userId));
/* 35 */     out.add("experience", Integer.valueOf(this.experience));
/* 36 */     out.add("coins", Integer.valueOf(this.coins));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     this.identifier = in.get("identifier").getAsString();
/* 43 */     this.serverType = in.get("serverType").getAsString();
/*    */     
/* 45 */     this.userId = in.get("user").getAsInt();
/* 46 */     this.experience = in.get("experience").getAsInt();
/* 47 */     this.coins = in.get("coins").getAsInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 52 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanPlayerEarnings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */