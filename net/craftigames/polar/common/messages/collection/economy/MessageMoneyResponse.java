/*    */ package net.craftigames.polar.common.messages.collection.economy;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 32)
/*    */ public class MessageMoneyResponse extends Message {
/*    */   @Nullable
/*    */   private UUID identifier;
/*    */   private UUID user;
/*    */   
/*    */   public MessageMoneyResponse(@Nullable UUID identifier, UUID user, String server, String type, @Nullable BigDecimal money) {
/* 19 */     this.identifier = identifier; this.user = user; this.server = server; this.type = type; this.money = money;
/*    */   } private String server; private String type; @Nullable
/*    */   private BigDecimal money; public MessageMoneyResponse() {} public void setIdentifier(@Nullable UUID identifier) {
/* 22 */     this.identifier = identifier; } public void setUser(UUID user) { this.user = user; } public void setServer(String server) { this.server = server; } public void setType(String type) { this.type = type; } public void setMoney(@Nullable BigDecimal money) { this.money = money; }
/*    */   
/*    */   @Nullable
/*    */   public UUID getIdentifier() {
/* 26 */     return this.identifier;
/*    */   }
/* 28 */   public UUID getUser() { return this.user; }
/* 29 */   public String getServer() { return this.server; }
/* 30 */   public String getType() { return this.type; } @Nullable
/* 31 */   public BigDecimal getMoney() { return this.money; }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     out.add("identifier", this.identifier);
/* 36 */     out.add("user", this.user);
/* 37 */     out.add("server", this.server);
/* 38 */     out.add("type", this.type);
/* 39 */     out.add("money", this.money);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     JsonElement identifierElement = in.get("identifier");
/* 45 */     if (identifierElement.isJsonPrimitive()) {
/* 46 */       this.identifier = in.getAsUUID("identifier");
/*    */     }
/*    */     
/* 49 */     this.user = in.getAsUUID("user");
/* 50 */     this.server = in.get("server").getAsString();
/* 51 */     this.type = in.get("type").getAsString();
/*    */     
/* 53 */     JsonElement moneyElement = in.get("money");
/* 54 */     if (moneyElement instanceof com.google.gson.JsonPrimitive) {
/* 55 */       this.money = moneyElement.getAsBigDecimal();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 61 */     return MessageType.ECONOMY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\economy\MessageMoneyResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */