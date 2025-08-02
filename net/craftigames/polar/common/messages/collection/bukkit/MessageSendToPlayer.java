/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 75)
/*    */ public class MessageSendToPlayer extends Message {
/*    */   private Object playerIdentifier;
/*    */   private String message;
/*    */   
/* 15 */   public void setPlayerIdentifier(Object playerIdentifier) { this.playerIdentifier = playerIdentifier; } public void setMessage(String message) { this.message = message; } public void setSenderName(String senderName) { this.senderName = senderName; }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getPlayerIdentifier() {
/* 20 */     return this.playerIdentifier; } public String getMessage() {
/* 21 */     return this.message;
/*    */   }
/* 23 */   private String senderName = "Console"; public String getSenderName() { return this.senderName; }
/*    */   
/*    */   public MessageSendToPlayer(UUID playerUuid, String message) {
/* 26 */     this.playerIdentifier = playerUuid;
/* 27 */     this.message = message;
/*    */   }
/*    */   
/*    */   public MessageSendToPlayer(int userId, String message) {
/* 31 */     this.playerIdentifier = Integer.valueOf(userId);
/* 32 */     this.message = message;
/*    */   }
/*    */   
/*    */   public MessageSendToPlayer(String username, String message) {
/* 36 */     this.playerIdentifier = username;
/* 37 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 42 */     out.add("playerIdentifier", this.playerIdentifier.toString());
/* 43 */     out.add("message", this.message);
/* 44 */     out.add("sender", this.senderName);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 49 */     setPlayerIdentifier(in.get("playerIdentifier").getAsString());
/* 50 */     setMessage(in.get("message").getAsString());
/* 51 */     setSenderName(in.get("sender").getAsString());
/*    */   }
/*    */   
/*    */   public boolean isConsole() {
/* 55 */     return (this.senderName == null || this.senderName.equalsIgnoreCase("Console"));
/*    */   }
/*    */   
/*    */   public boolean isUuid() {
/*    */     try {
/* 60 */       UUID uuid = UUID.fromString(this.playerIdentifier.toString());
/* 61 */       return true;
/* 62 */     } catch (IllegalArgumentException e) {
/* 63 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isUserId() {
/*    */     try {
/* 69 */       Integer.parseInt(this.playerIdentifier.toString());
/* 70 */       return true;
/* 71 */     } catch (NumberFormatException e) {
/* 72 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isUsername() {
/* 77 */     return (!isUserId() && !isUuid());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 82 */     return MessageType.SYSTEM;
/*    */   }
/*    */   
/*    */   public MessageSendToPlayer() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageSendToPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */