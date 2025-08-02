/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.title.Title;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 35)
/*    */ public class MessageSendMembersTitle extends AbstractMultiplePlayersMessage {
/*    */   private Title title;
/*    */   
/*    */   public MessageSendMembersTitle() {}
/*    */   
/*    */   public void setTitle(Title title) {
/* 20 */     this.title = title;
/*    */   }
/*    */ 
/*    */   
/*    */   public Title getTitle() {
/* 25 */     return this.title;
/*    */   }
/*    */   public MessageSendMembersTitle(Title title) {
/* 28 */     this(null, title);
/*    */   }
/*    */   
/*    */   public MessageSendMembersTitle(@Nullable List<UUID> playerUuids, Title title) {
/* 32 */     super(playerUuids);
/* 33 */     this.title = title;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 38 */     super.send(out);
/* 39 */     out.add("title", TextUtils.toTitle(this.title));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     super.receive(in);
/* 45 */     setTitle(TextUtils.fromTitle(in.get("title").getAsString()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 51 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageSendMembersTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */