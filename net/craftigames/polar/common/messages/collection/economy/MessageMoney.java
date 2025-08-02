/*    */ package net.craftigames.polar.common.messages.collection.economy;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 31)
/*    */ public class MessageMoney extends Message {
/*    */   private UUID identifier;
/*    */   private UUID user;
/*    */   private String server;
/*    */   private String type;
/*    */   private BigDecimal money;
/*    */   
/*    */   public MessageMoney(UUID identifier, UUID user, String server, String type, BigDecimal money) {
/* 18 */     this.identifier = identifier; this.user = user; this.server = server; this.type = type; this.money = money;
/*    */   }
/*    */   public MessageMoney() {}
/* 21 */   public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setUser(UUID user) { this.user = user; } public void setServer(String server) { this.server = server; } public void setType(String type) { this.type = type; } public void setMoney(BigDecimal money) { this.money = money; }
/*    */ 
/*    */   
/*    */   public UUID getIdentifier() {
/* 25 */     return this.identifier;
/*    */   }
/* 27 */   public UUID getUser() { return this.user; }
/* 28 */   public String getServer() { return this.server; }
/* 29 */   public String getType() { return this.type; } public BigDecimal getMoney() {
/* 30 */     return this.money;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("identifier", this.identifier);
/* 35 */     out.add("user", this.user);
/* 36 */     out.add("server", this.server);
/* 37 */     out.add("type", this.type);
/* 38 */     out.add("money", this.money);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 43 */     this.identifier = in.getAsUUID("identifier");
/* 44 */     this.user = in.getAsUUID("user");
/* 45 */     this.server = in.get("server").getAsString();
/* 46 */     this.type = in.get("type").getAsString();
/* 47 */     JsonElement money = in.get("money");
/* 48 */     if (money instanceof com.google.gson.JsonPrimitive) {
/* 49 */       this.money = money.getAsBigDecimal();
/*    */     } else {
/* 51 */       this.money = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 57 */     return MessageType.ECONOMY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\economy\MessageMoney.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */