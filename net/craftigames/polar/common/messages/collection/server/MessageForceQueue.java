/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 102)
/*    */ public class MessageForceQueue extends Message {
/*    */   private String target;
/*    */   private String type;
/*    */   
/*    */   public MessageForceQueue(String target, String type) {
/* 13 */     this.target = target; this.type = type;
/*    */   }
/*    */   public MessageForceQueue() {}
/* 16 */   public void setTarget(String target) { this.target = target; } public void setType(String type) { this.type = type; }
/*    */ 
/*    */   
/*    */   public String getTarget() {
/* 20 */     return this.target; } public String getType() {
/* 21 */     return this.type;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 25 */     out.add("target", this.target);
/* 26 */     out.add("type", this.type);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 31 */     this.target = in.get("target").getAsString();
/* 32 */     this.type = in.get("type").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 37 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageForceQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */