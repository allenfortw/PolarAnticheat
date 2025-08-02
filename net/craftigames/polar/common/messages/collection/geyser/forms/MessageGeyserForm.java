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
/*    */ @MessageIdentifier(legacyId = 82)
/*    */ public class MessageGeyserForm
/*    */   extends AbstractMemberMessage
/*    */ {
/*    */   private int formId;
/*    */   private int formType;
/*    */   private String formJson;
/*    */   
/*    */   public MessageGeyserForm() {}
/*    */   
/*    */   public int getFormId() {
/* 22 */     return this.formId;
/* 23 */   } public int getFormType() { return this.formType; } public String getFormJson() {
/* 24 */     return this.formJson;
/*    */   }
/*    */   public MessageGeyserForm(UUID uuid, String name, int formId, int formType, String formJson) {
/* 27 */     super(uuid, name);
/* 28 */     this.formId = formId;
/* 29 */     this.formType = formType;
/* 30 */     this.formJson = formJson;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     super.send(out);
/* 36 */     out.add("id", Integer.valueOf(this.formId));
/* 37 */     out.add("type", Integer.valueOf(this.formType));
/* 38 */     out.add("json", this.formJson);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 43 */     super.receive(in);
/* 44 */     this.formId = in.get("id").getAsInt();
/* 45 */     this.formType = in.get("type").getAsInt();
/* 46 */     this.formJson = in.get("json").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 51 */     return MessageType.GEYSER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\forms\MessageGeyserForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */