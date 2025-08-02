/*    */ package net.craftigames.polar.common.messages.collection.menu;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 46)
/*    */ public class MessageMenuClose extends Message {
/*    */   private UUID user;
/*    */   
/*    */   public void setUser(UUID user) {
/* 15 */     this.user = user;
/*    */   } public MessageMenuClose(UUID user) {
/* 17 */     this.user = user;
/*    */   }
/*    */   public MessageMenuClose() {}
/*    */   public UUID getUser() {
/* 21 */     return this.user;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 25 */     out.add("user", this.user);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 30 */     this.user = in.getAsUUID("user");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 35 */     return MessageType.MENU;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\menu\MessageMenuClose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */