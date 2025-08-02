/*    */ package net.craftigames.polar.common.messages;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ public abstract class Message
/*    */ {
/*    */   public abstract void send(MessageOutputStream paramMessageOutputStream);
/*    */   
/*    */   public abstract void receive(MessageInputStream paramMessageInputStream);
/*    */   
/*    */   @Deprecated
/*    */   public int getLegacyId() {
/* 15 */     return MessagingRegister.getIdLegacy(this);
/*    */   }
/*    */   
/*    */   public String getId() {
/* 19 */     return MessagingRegister.getId(this);
/*    */   }
/*    */   
/*    */   public String getMessageName() {
/* 23 */     return MessagingRegister.getName(this);
/*    */   }
/*    */   
/*    */   public String getFrom() {
/* 27 */     return "polar";
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public MessageType getMessageType() {
/* 32 */     return MessageType.OTHER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */