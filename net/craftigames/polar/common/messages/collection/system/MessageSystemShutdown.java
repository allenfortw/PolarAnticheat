/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 22)
/*    */ public class MessageSystemShutdown
/*    */   extends Message
/*    */ {
/*    */   public void send(MessageOutputStream out) {}
/*    */   
/*    */   public void receive(MessageInputStream in) {}
/*    */   
/*    */   public MessageType getMessageType() {
/* 30 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageSystemShutdown.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */