/*   */ package net.craftigames.polar.common.messages;
/*   */ 
/*   */ public interface MessageSender
/*   */ {
/*   */   void sendMessage(Message... messages) {
/* 6 */     sendMessage("", messages);
/*   */   }
/*   */   
/*   */   void sendMessage(String paramString, Message... paramVarArgs);
/*   */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\MessageSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */