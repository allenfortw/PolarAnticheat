/*    */ package net.craftigames.polar.common.messages.collection.proxy;
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
/*    */ @MessageIdentifier(legacyId = 23)
/*    */ public class MessageProxyStartup
/*    */   extends Message
/*    */ {
/*    */   private String identifier;
/*    */   
/*    */   public String getIdentifier() {
/* 19 */     return this.identifier; } public boolean isPolarReboot() {
/* 20 */     return this.polarReboot;
/*    */   } private boolean polarReboot = false;
/*    */   public MessageProxyStartup(String identifier, boolean polarReboot) {
/* 23 */     this.identifier = identifier;
/* 24 */     this.polarReboot = polarReboot;
/*    */   }
/*    */   
/*    */   public MessageProxyStartup(String identifier) {
/* 28 */     this(identifier, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     out.add("identifier", this.identifier);
/* 34 */     out.add("polarReboot", Boolean.valueOf(this.polarReboot));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 39 */     if (in.has("identifier")) {
/* 40 */       this.identifier = in.get("identifier").getAsString();
/* 41 */       this.polarReboot = in.get("polarReboot").getAsBoolean();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 47 */     return MessageType.PROXY;
/*    */   }
/*    */   
/*    */   public MessageProxyStartup() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageProxyStartup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */