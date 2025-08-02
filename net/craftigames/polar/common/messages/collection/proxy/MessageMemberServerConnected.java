/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ServerConnectResult;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 73)
/*    */ public class MessageMemberServerConnected extends Message {
/*    */   private UUID playerUuid;
/*    */   private ServerConnectResult.Result result;
/*    */   private String server;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 18 */     this.playerUuid = playerUuid; } public void setResult(ServerConnectResult.Result result) { this.result = result; } public void setServer(String server) { this.server = server; }
/*    */ 
/*    */   
/*    */   public MessageMemberServerConnected() {}
/*    */   
/* 23 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 24 */   public ServerConnectResult.Result getResult() { return this.result; } public String getServer() {
/* 25 */     return this.server;
/*    */   }
/*    */   public MessageMemberServerConnected(UUID playerUuid, String server, ServerConnectResult.Result result) {
/* 28 */     this.playerUuid = playerUuid;
/* 29 */     this.result = result;
/* 30 */     this.server = server;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     out.add("uuid", this.playerUuid);
/* 36 */     out.add("result", this.result.serialize());
/* 37 */     out.add("server", this.server);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 43 */     setResult(ServerConnectResult.Result.deserialize(in.get("result")));
/* 44 */     setServer(in.get("server").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 49 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageMemberServerConnected.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */