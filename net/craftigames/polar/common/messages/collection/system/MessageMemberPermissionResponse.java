/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 89)
/*    */ public class MessageMemberPermissionResponse extends Message {
/*    */   private UUID identifier;
/*    */   private boolean result;
/*    */   
/*    */   public void setIdentifier(UUID identifier) {
/* 16 */     this.identifier = identifier; } public void setResult(boolean result) { this.result = result; } public MessageMemberPermissionResponse(UUID identifier, boolean result) {
/* 17 */     this.identifier = identifier; this.result = result;
/*    */   }
/*    */   
/*    */   public MessageMemberPermissionResponse() {}
/*    */   
/* 22 */   public UUID getIdentifier() { return this.identifier; } public boolean isResult() {
/* 23 */     return this.result;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("identifier", this.identifier);
/* 28 */     out.add("result", Boolean.valueOf(this.result));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.identifier = in.getAsUUID("identifier");
/* 34 */     this.result = in.get("result").getAsBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberPermissionResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */