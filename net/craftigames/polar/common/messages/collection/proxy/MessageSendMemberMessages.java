/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 10)
/*    */ public class MessageSendMemberMessages
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private String[] messages;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 21 */     this.playerUuid = playerUuid; } public void setMessages(String[] messages) { this.messages = messages; }
/*    */ 
/*    */   
/*    */   public MessageSendMemberMessages() {}
/*    */   
/* 26 */   public UUID getPlayerUuid() { return this.playerUuid; } public String[] getMessages() {
/* 27 */     return this.messages;
/*    */   }
/*    */   public MessageSendMemberMessages(UUID playerUuid, String... messages) {
/* 30 */     this.playerUuid = playerUuid;
/* 31 */     this.messages = messages;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     out.add("uuid", this.playerUuid);
/* 37 */     JsonArray array = new JsonArray();
/* 38 */     for (String m : this.messages) {
/* 39 */       array.add(m);
/*    */     }
/* 41 */     out.add("message", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 46 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/*    */     
/* 48 */     JsonArray array = in.get("message").getAsJsonArray();
/* 49 */     List<String> messages = Lists.newArrayList();
/* 50 */     for (JsonElement e : array) {
/* 51 */       messages.add(e.getAsString());
/*    */     }
/*    */     
/* 54 */     setMessages(messages.<String>toArray(new String[0]));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 60 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */