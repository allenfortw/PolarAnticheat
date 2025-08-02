/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 27)
/*    */ public class MessageUserDataResponse extends Message {
/*    */   private UUID user;
/*    */   private String server;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessageUserDataResponse(UUID user, String server, JsonElement data) {
/* 16 */     this.user = user; this.server = server; this.data = data;
/*    */   }
/*    */   public MessageUserDataResponse() {}
/* 19 */   public void setUser(UUID user) { this.user = user; } public void setServer(String server) { this.server = server; } public void setData(JsonElement data) { this.data = data; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 23 */     return this.user; } public String getServer() {
/* 24 */     return this.server;
/*    */   }
/*    */   public JsonElement getData() {
/* 27 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     out.add("user", this.user);
/* 32 */     out.add("server", this.server);
/* 33 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.user = in.getAsUUID("user");
/* 39 */     this.server = in.get("server").getAsString();
/* 40 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 45 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageUserDataResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */