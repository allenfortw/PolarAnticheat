/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 106)
/*    */ public class MessageProxySyncData
/*    */   extends Message {
/*    */   private String identifier;
/*    */   private JsonObject data;
/*    */   
/*    */   public MessageProxySyncData() {}
/*    */   
/*    */   public String getIdentifier() {
/* 20 */     return this.identifier; } public JsonObject getData() {
/* 21 */     return this.data;
/*    */   }
/*    */   public MessageProxySyncData(String identifier, JsonObject data) {
/* 24 */     this.identifier = identifier;
/* 25 */     this.data = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("identifier", this.identifier);
/* 31 */     out.add("data", (JsonElement)this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 36 */     this.identifier = in.get("identifier").getAsString();
/* 37 */     this.data = in.get("data").getAsJsonObject();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 42 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageProxySyncData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */