/*    */ package net.craftigames.polar.common.messages.collection.geyser;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ProxyMotd;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageUpdateMotdGeyser extends Message {
/*    */   private ProxyMotd proxyMotd;
/*    */   
/*    */   public ProxyMotd getProxyMotd() {
/* 16 */     return this.proxyMotd;
/*    */   } public MessageUpdateMotdGeyser() {}
/*    */   public MessageUpdateMotdGeyser(ProxyMotd proxyMotd) {
/* 19 */     this.proxyMotd = proxyMotd;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 24 */     out.add("motd", this.proxyMotd.getMotd());
/* 25 */     out.add("slots", Integer.valueOf(this.proxyMotd.getSlots()));
/* 26 */     out.add("proxyMotd", (GsonSerializable)this.proxyMotd);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 31 */     this.proxyMotd = ProxyMotd.deserialize(in.get("proxyMotd"));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 36 */     return MessageType.GEYSER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\MessageUpdateMotdGeyser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */