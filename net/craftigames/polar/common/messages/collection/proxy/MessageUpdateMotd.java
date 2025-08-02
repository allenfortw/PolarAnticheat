/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ProxyMotd;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 37)
/*    */ public class MessageUpdateMotd extends Message {
/*    */   @Deprecated
/*    */   private String motd;
/*    */   @Deprecated
/*    */   private Integer slots;
/*    */   
/*    */   @Deprecated
/* 18 */   public String getMotd() { return this.motd; } @Nullable private ProxyMotd proxyMotd; public MessageUpdateMotd() {} @Deprecated
/* 19 */   public Integer getSlots() { return this.slots; } @Nullable
/* 20 */   public ProxyMotd getProxyMotd() { return this.proxyMotd; }
/*    */   
/*    */   public MessageUpdateMotd(@Nullable ProxyMotd proxyMotd) {
/* 23 */     this.proxyMotd = proxyMotd;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     if (this.motd != null) {
/* 29 */       out.add("motd", this.motd);
/*    */     }
/* 31 */     if (this.slots != null) {
/* 32 */       out.add("slots", this.slots);
/*    */     }
/* 34 */     if (this.proxyMotd != null) {
/* 35 */       out.add("motd", this.proxyMotd.getMotd());
/* 36 */       out.add("slots", Integer.valueOf(this.proxyMotd.getSlots()));
/* 37 */       out.add("proxyMotd", (GsonSerializable)this.proxyMotd);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 43 */     if (in.has("motd")) {
/* 44 */       this.motd = in.get("motd").getAsString();
/*    */     }
/* 46 */     if (in.has("slots")) {
/* 47 */       this.slots = Integer.valueOf(in.get("slots").getAsInt());
/*    */     }
/* 49 */     if (in.has("proxyMotd")) {
/* 50 */       this.proxyMotd = ProxyMotd.deserialize(in.get("proxyMotd"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 56 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageUpdateMotd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */