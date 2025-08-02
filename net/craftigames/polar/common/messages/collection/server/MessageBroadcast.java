/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 24)
/*    */ public class MessageBroadcast extends Message implements UniqueMessage {
/*    */   private String broadcast;
/*    */   private String type;
/*    */   @Nullable
/*    */   private UUID sender;
/*    */   
/*    */   public MessageBroadcast() {}
/*    */   
/*    */   public MessageBroadcast(String broadcast, String type, @Nullable UUID sender) {
/* 17 */     this.broadcast = broadcast; this.type = type; this.sender = sender;
/*    */   } public void setBroadcast(String broadcast) {
/* 19 */     this.broadcast = broadcast; } public void setType(String type) { this.type = type; } public void setSender(@Nullable UUID sender) { this.sender = sender; }
/*    */ 
/*    */   
/*    */   public String getBroadcast() {
/* 23 */     return this.broadcast;
/* 24 */   } public String getType() { return this.type; } @Nullable
/* 25 */   public UUID getSender() { return this.sender; }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 29 */     out.add("broadcast", this.broadcast);
/* 30 */     out.add("type", this.type);
/* 31 */     if (this.sender != null) {
/* 32 */       out.add("sender", this.sender);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.broadcast = in.get("broadcast").getAsString();
/* 39 */     this.type = in.get("type").getAsString();
/* 40 */     if (in.has("sender")) {
/* 41 */       this.sender = in.getAsUUID("sender");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 47 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageBroadcast.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */