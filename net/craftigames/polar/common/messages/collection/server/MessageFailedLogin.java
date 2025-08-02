/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 7)
/*    */ public class MessageFailedLogin extends AbstractMemberMessage {
/*    */   private String ip;
/*    */   
/*    */   public void setIp(String ip) {
/* 15 */     this.ip = ip;
/*    */   }
/*    */   public MessageFailedLogin() {}
/*    */   public String getIp() {
/* 19 */     return this.ip;
/*    */   }
/*    */   public MessageFailedLogin(UUID uuid, String name, String ip) {
/* 22 */     super(uuid, name);
/* 23 */     this.ip = ip;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/* 29 */     out.add("ip", this.ip);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     super.receive(in);
/* 35 */     setIp(in.get("ip").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 40 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageFailedLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */