/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 25)
/*    */ public class MessageForceDataSync extends Message {
/*    */   private UUID user;
/*    */   private String server;
/*    */   
/*    */   public MessageForceDataSync(UUID user, String server) {
/* 15 */     this.user = user; this.server = server;
/*    */   }
/*    */   public MessageForceDataSync() {}
/* 18 */   public void setUser(UUID user) { this.user = user; } public void setServer(String server) { this.server = server; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 22 */     return this.user; } public String getServer() {
/* 23 */     return this.server;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("user", this.user);
/* 28 */     out.add("server", this.server);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.user = in.getAsUUID("user");
/* 34 */     this.server = in.get("server").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageForceDataSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */