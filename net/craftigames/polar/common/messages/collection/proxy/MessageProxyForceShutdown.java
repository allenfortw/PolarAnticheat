/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 62)
/*    */ public class MessageProxyForceShutdown extends Message {
/*    */   private Component message;
/*    */   
/*    */   public MessageProxyForceShutdown() {}
/*    */   
/*    */   public void setMessage(Component message) {
/* 18 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageProxyForceShutdown(Component message) {
/* 23 */     this.message = message;
/*    */   }
/*    */   public Component getMessage() {
/* 26 */     return this.message;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("message", TextUtils.toGson(this.message));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 35 */     setMessage(TextUtils.fromGson(in.get("message").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 40 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageProxyForceShutdown.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */