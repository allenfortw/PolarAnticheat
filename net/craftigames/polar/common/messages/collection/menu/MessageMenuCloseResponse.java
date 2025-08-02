/*    */ package net.craftigames.polar.common.messages.collection.menu;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 47)
/*    */ public class MessageMenuCloseResponse extends Message {
/*    */   private UUID user;
/*    */   private UUID menu;
/*    */   
/*    */   public MessageMenuCloseResponse(UUID user, UUID menu) {
/* 15 */     this.user = user; this.menu = menu;
/*    */   }
/*    */   public MessageMenuCloseResponse() {}
/* 18 */   public void setUser(UUID user) { this.user = user; } public void setMenu(UUID menu) { this.menu = menu; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 22 */     return this.user; } public UUID getMenu() {
/* 23 */     return this.menu;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("user", this.user);
/* 28 */     out.add("menu", this.menu);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.user = in.getAsUUID("user");
/* 34 */     this.menu = in.getAsUUID("menu");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.MENU;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\menu\MessageMenuCloseResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */