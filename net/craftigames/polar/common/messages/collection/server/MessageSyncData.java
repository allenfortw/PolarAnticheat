/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ import com.google.gson.JsonElement;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 28)
/*    */ public class MessageSyncData extends Message implements UniqueMessage {
/*    */   private String type;
/*    */   private String server;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessageSyncData(String type, String server, JsonElement data) {
/* 15 */     this.type = type; this.server = server; this.data = data;
/*    */   }
/*    */   public MessageSyncData() {}
/* 18 */   public void setType(String type) { this.type = type; } public void setServer(String server) { this.server = server; } public void setData(JsonElement data) { this.data = data; }
/*    */ 
/*    */   
/*    */   public String getType() {
/* 22 */     return this.type; } public String getServer() {
/* 23 */     return this.server;
/*    */   }
/*    */   public JsonElement getData() {
/* 26 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("type", this.type);
/* 31 */     out.add("server", this.server);
/* 32 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     this.type = in.get("type").getAsString();
/* 38 */     this.server = in.get("server").getAsString();
/* 39 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 44 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageSyncData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */