/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 61)
/*    */ public class MessageDisconnectMembers
/*    */   extends Message {
/*    */   private List<UUID> bypass;
/*    */   private Component message;
/*    */   
/*    */   public void setBypass(List<UUID> bypass) {
/* 21 */     this.bypass = bypass; } public void setMessage(Component message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageDisconnectMembers() {}
/*    */   
/*    */   public MessageDisconnectMembers(List<UUID> bypass, Component message) {
/* 27 */     this.bypass = bypass;
/* 28 */     this.message = message;
/*    */   }
/*    */   
/*    */   public MessageDisconnectMembers(Component message) {
/* 32 */     this(Collections.emptyList(), message);
/*    */   }
/*    */   
/* 35 */   public List<UUID> getBypass() { return this.bypass; } public Component getMessage() {
/* 36 */     return this.message;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 40 */     out.add("bypass", this.bypass);
/* 41 */     out.add("message", TextUtils.toGson(this.message));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 46 */     setBypass(in.getAsList(in.get("bypass"), UUID.class));
/* 47 */     setMessage(TextUtils.fromGson(in.get("message").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 52 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageDisconnectMembers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */