/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 105)
/*    */ public class MessageProxyShutdown
/*    */   extends Message
/*    */ {
/*    */   private String identifier;
/*    */   
/*    */   public MessageProxyShutdown() {}
/*    */   
/*    */   public String getIdentifier() {
/* 19 */     return this.identifier;
/*    */   }
/*    */   public MessageProxyShutdown(String identifier) {
/* 22 */     this.identifier = identifier;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("identifier", this.identifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 32 */     this.identifier = in.get("identifier").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 37 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageProxyShutdown.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */