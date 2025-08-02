/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ import net.craftigames.polar.common.command.PolarCommand;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 8)
/*    */ public class MessageRegisterCommand extends Message {
/*    */   private PolarCommand command;
/*    */   
/*    */   public MessageRegisterCommand() {}
/*    */   
/*    */   public void setCommand(PolarCommand command) {
/* 16 */     this.command = command;
/*    */   }
/*    */ 
/*    */   
/*    */   public PolarCommand getCommand() {
/* 21 */     return this.command;
/*    */   }
/*    */   public MessageRegisterCommand(PolarCommand command) {
/* 24 */     this.command = command;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 29 */     out.add("command", (JsonElement)this.command.toJson());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     setCommand(new PolarCommand(in.get("command").getAsJsonObject()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 40 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageRegisterCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */