/*    */ package net.craftigames.polar.common.messages.collection.geyser.forms;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 83)
/*    */ public class MessageGeyserFormResponse
/*    */   extends AbstractMemberMessage
/*    */ {
/*    */   private int formId;
/*    */   private String response;
/*    */   
/*    */   public MessageGeyserFormResponse() {}
/*    */   
/*    */   public int getFormId() {
/* 22 */     return this.formId; } public String getResponse() {
/* 23 */     return this.response;
/*    */   }
/*    */   public MessageGeyserFormResponse(UUID uuid, String name, int formId, String response) {
/* 26 */     super(uuid, name);
/* 27 */     this.formId = formId;
/* 28 */     this.response = response;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     super.send(out);
/* 34 */     out.add("id", Integer.valueOf(this.formId));
/* 35 */     out.add("response", this.response);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     super.receive(in);
/* 41 */     this.formId = in.get("id").getAsInt();
/* 42 */     this.response = !in.get("response").isJsonNull() ? in.get("response").getAsString() : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 47 */     return MessageType.GEYSER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\forms\MessageGeyserFormResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */