/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageGenericServerEvent
/*    */   extends Message {
/*    */   private String senderIdentifier;
/*    */   private SenderType senderType;
/*    */   private UUID messageIdentifier;
/*    */   
/*    */   public String getSenderIdentifier() {
/* 18 */     return this.senderIdentifier; } private String type; private JsonElement content; public MessageGenericServerEvent() {} public SenderType getSenderType() {
/* 19 */     return this.senderType; }
/* 20 */   public UUID getMessageIdentifier() { return this.messageIdentifier; }
/* 21 */   public String getType() { return this.type; } public JsonElement getContent() {
/* 22 */     return this.content;
/*    */   }
/*    */   public MessageGenericServerEvent(String senderIdentifier, SenderType senderType, UUID messageIdentifier, String type, JsonElement content) {
/* 25 */     this.senderIdentifier = senderIdentifier;
/* 26 */     this.senderType = senderType;
/* 27 */     this.messageIdentifier = messageIdentifier;
/* 28 */     this.type = type;
/* 29 */     this.content = content;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("server-identifier", this.senderIdentifier);
/* 35 */     out.add("sender-type", this.senderType.name());
/* 36 */     out.add("message-identifier", this.messageIdentifier);
/* 37 */     out.add("type", this.type);
/* 38 */     out.add("content", this.content);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 43 */     this.senderIdentifier = in.get("server-identifier").getAsString();
/*    */     try {
/* 45 */       this.senderType = SenderType.valueOf(in.get("sender-type").getAsString());
/* 46 */     } catch (IllegalArgumentException ignored) {
/* 47 */       this.senderType = SenderType.OTHER;
/*    */     } 
/* 49 */     this.messageIdentifier = in.getAsUUID("message-identifier");
/* 50 */     this.type = in.get("type").getAsString();
/* 51 */     this.content = in.get("content");
/*    */   }
/*    */   
/*    */   public enum SenderType {
/* 55 */     GRIZZLY_SERVER,
/* 56 */     PANDA_SERVER,
/* 57 */     OTHER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageGenericServerEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */