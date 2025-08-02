/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 12)
/*    */ public class MessageMemberServerSwitch extends AbstractMemberMessage {
/*    */   private String server;
/*    */   
/*    */   public void setServer(String server) {
/* 15 */     this.server = server;
/*    */   }
/*    */   public MessageMemberServerSwitch() {}
/*    */   public String getServer() {
/* 19 */     return this.server;
/*    */   }
/*    */   public MessageMemberServerSwitch(UUID uuid, String name, String server) {
/* 22 */     super(uuid, name);
/* 23 */     this.server = server;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/* 29 */     out.add("server", this.server);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     super.receive(in);
/* 35 */     setServer(in.get("server").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 40 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberServerSwitch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */