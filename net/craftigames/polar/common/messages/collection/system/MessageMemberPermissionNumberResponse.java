/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 100)
/*    */ public class MessageMemberPermissionNumberResponse extends Message {
/*    */   private UUID identifier;
/*    */   private int result;
/*    */   
/*    */   public void setIdentifier(UUID identifier) {
/* 16 */     this.identifier = identifier; } public void setResult(int result) { this.result = result; } public MessageMemberPermissionNumberResponse(UUID identifier, int result) {
/* 17 */     this.identifier = identifier; this.result = result;
/*    */   }
/*    */   
/*    */   public MessageMemberPermissionNumberResponse() {}
/*    */   
/* 22 */   public UUID getIdentifier() { return this.identifier; } public int getResult() {
/* 23 */     return this.result;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("identifier", this.identifier);
/* 28 */     out.add("result", Integer.valueOf(this.result));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.identifier = in.getAsUUID("identifier");
/* 34 */     this.result = in.get("result").getAsInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberPermissionNumberResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */