/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import java.util.concurrent.ConcurrentLinkedQueue;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 11)
/*    */ public class MessageSendMemberMessagesTypes extends Message {
/*    */   private UUID playerUuid;
/*    */   private ConcurrentLinkedQueue<Object> messages;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 21 */     this.playerUuid = playerUuid; } public void setMessages(ConcurrentLinkedQueue<Object> messages) { this.messages = messages; }
/*    */ 
/*    */   
/*    */   public MessageSendMemberMessagesTypes() {}
/*    */   
/* 26 */   public UUID getPlayerUuid() { return this.playerUuid; } public ConcurrentLinkedQueue<Object> getMessages() {
/* 27 */     return this.messages;
/*    */   }
/*    */   public MessageSendMemberMessagesTypes(UUID playerUuid, ConcurrentLinkedQueue<Object> messages) {
/* 30 */     this.playerUuid = playerUuid;
/* 31 */     this.messages = messages;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     out.add("uuid", this.playerUuid);
/* 37 */     out.add("size", Integer.valueOf(this.messages.size()));
/*    */     
/* 39 */     int index = 0;
/* 40 */     for (Object o : this.messages) {
/* 41 */       if (o instanceof Component) {
/*    */         
/* 43 */         JsonObject jsonObject1 = new JsonObject();
/* 44 */         jsonObject1.addProperty("type", "COMPONENT");
/* 45 */         jsonObject1.addProperty("content", (String)GsonComponentSerializer.builder().legacyHoverEventSerializer(null).downsampleColors()
/* 46 */             .emitLegacyHoverEvent().build().serialize((Component)o));
/*    */         
/* 48 */         out.add(Integer.toString(index++), (JsonElement)jsonObject1);
/*    */         continue;
/*    */       } 
/* 51 */       JsonObject jsonObject = new JsonObject();
/* 52 */       jsonObject.addProperty("type", "STRING");
/* 53 */       jsonObject.addProperty("content", o.toString());
/*    */       
/* 55 */       out.add(Integer.toString(index++), (JsonElement)jsonObject);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 62 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/*    */     
/* 64 */     int size = in.get("size").getAsInt();
/* 65 */     ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue();
/*    */     
/* 67 */     for (int i = 0; i < size; i++) {
/* 68 */       JsonObject jsonObject = in.get(Integer.toString(i)).getAsJsonObject();
/* 69 */       String type = jsonObject.get("type").getAsString();
/* 70 */       if (type.equalsIgnoreCase("COMPONENT")) {
/*    */         
/* 72 */         queue.add(GsonComponentSerializer.builder().legacyHoverEventSerializer(null).downsampleColors()
/* 73 */             .emitLegacyHoverEvent().build().deserialize(jsonObject.get("content").getAsString()));
/*    */       } else {
/*    */         
/* 76 */         queue.add(jsonObject.get("content").getAsString());
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 81 */     setMessages(queue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 87 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberMessagesTypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */