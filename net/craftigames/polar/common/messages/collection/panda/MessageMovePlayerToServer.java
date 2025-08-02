/*    */ package net.craftigames.polar.common.messages.collection.panda;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 101)
/*    */ public class MessageMovePlayerToServer
/*    */   extends Message {
/*    */   private UUID uuid;
/*    */   private String server;
/*    */   private int methodId;
/*    */   
/*    */   public void setUuid(UUID uuid) {
/* 18 */     this.uuid = uuid; } public void setServer(String server) { this.server = server; } public void setMethodId(int methodId) { this.methodId = methodId; }
/*    */ 
/*    */   
/*    */   public MessageMovePlayerToServer() {}
/*    */   
/* 23 */   public UUID getUuid() { return this.uuid; }
/* 24 */   public String getServer() { return this.server; } public int getMethodId() {
/* 25 */     return this.methodId;
/*    */   }
/*    */   public MessageMovePlayerToServer(UUID uuid, String server, int methodId) {
/* 28 */     this.uuid = uuid;
/* 29 */     this.server = server;
/* 30 */     this.methodId = methodId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     out.add("uuid", this.uuid);
/* 36 */     out.add("server", this.server);
/* 37 */     out.add("methodId", Integer.valueOf(this.methodId));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     this.uuid = UUID.fromString(in.get("uuid").getAsString());
/* 43 */     this.server = in.get("server").getAsString();
/* 44 */     this.methodId = in.get("methodId").getAsInt();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 50 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\panda\MessageMovePlayerToServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */