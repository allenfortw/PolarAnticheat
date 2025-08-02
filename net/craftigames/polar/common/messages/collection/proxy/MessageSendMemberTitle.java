/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.title.Title;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 33)
/*    */ public class MessageSendMemberTitle
/*    */   extends Message {
/*    */   private UUID playerUuid;
/*    */   private Title title;
/*    */   
/*    */   public void setPlayerUuid(UUID playerUuid) {
/* 19 */     this.playerUuid = playerUuid; } public void setTitle(Title title) { this.title = title; }
/*    */ 
/*    */   
/*    */   public MessageSendMemberTitle() {}
/*    */   
/* 24 */   public UUID getPlayerUuid() { return this.playerUuid; } public Title getTitle() {
/* 25 */     return this.title;
/*    */   }
/*    */   public MessageSendMemberTitle(UUID playerUuid, Title title) {
/* 28 */     this.playerUuid = playerUuid;
/* 29 */     this.title = title;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("uuid", this.playerUuid);
/* 35 */     out.add("title", TextUtils.toTitle(this.title));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     setPlayerUuid(in.getAsUUID("uuid"));
/* 41 */     setTitle(TextUtils.fromTitle(in.get("title").getAsString()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 47 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMemberTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */