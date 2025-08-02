/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 50)
/*    */ public class MessageAuthUpdate extends Message {
/*    */   private String username;
/*    */   
/* 13 */   public void setUsername(String username) { this.username = username; } private String type; public MessageAuthUpdate() {} public void setType(String type) { this.type = type; }
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 17 */     return this.username; } public String getType() {
/* 18 */     return this.type;
/*    */   }
/*    */   public MessageAuthUpdate(String username, String type) {
/* 21 */     this.username = username;
/* 22 */     this.type = type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("username", this.username);
/* 28 */     out.add("type", this.type);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     setUsername(in.get("username").getAsString());
/* 34 */     setType(in.get("type").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageAuthUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */