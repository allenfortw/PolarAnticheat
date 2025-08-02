/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 40)
/*    */ public class MessageSendMemberActionBar
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private Component component;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 19 */     this.playerUuid = playerUuid; } public void setComponent(Component component) { this.component = component; }
/*    */ 
/*    */   
/*    */   public MessageSendMemberActionBar() {}
/*    */   
/* 24 */   public UUID getPlayerUuid() { return this.playerUuid; } public Component getComponent() {
/* 25 */     return this.component;
/*    */   }
/*    */   public MessageSendMemberActionBar(UUID playerUuid, Component component) {
/* 28 */     this.playerUuid = playerUuid;
/* 29 */     this.component = component;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("uuid", this.playerUuid);
/* 35 */     out.add("component", TextUtils.toGson(this.component));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     setPlayerUuid(in.getAsUUID("uuid"));
/* 41 */     setComponent(TextUtils.fromGson(in.get("component").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberActionBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */