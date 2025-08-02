/*    */ package net.craftigames.polar.common.messages.collection.proxy.management;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 80)
/*    */ public class MessageRequestProxyStatistics
/*    */   extends Message
/*    */ {
/*    */   private long refreshTime;
/*    */   
/*    */   public MessageRequestProxyStatistics(long refreshTime) {
/* 16 */     this.refreshTime = refreshTime;
/*    */   }
/*    */   
/*    */   public MessageRequestProxyStatistics() {}
/*    */   
/*    */   public long getRefreshTime() {
/* 22 */     return this.refreshTime;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 26 */     out.add("refreshTime", Long.valueOf(this.refreshTime));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 31 */     this.refreshTime = in.get("refreshTime").getAsLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 36 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\management\MessageRequestProxyStatistics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */