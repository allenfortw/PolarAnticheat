/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 97)
/*    */ @Deprecated
/*    */ public class MessageConnectMember
/*    */   extends AbstractMemberMessage {
/*    */   private String server;
/*    */   
/*    */   public MessageConnectMember() {}
/*    */   
/*    */   public String getServer() {
/* 19 */     return this.server;
/*    */   }
/*    */   public MessageConnectMember(UUID uuid, String name, String server) {
/* 22 */     super(uuid, name);
/* 23 */     this.server = server;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/*    */     
/* 30 */     out.add("server", this.server);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 35 */     super.receive(in);
/*    */     
/* 37 */     this.server = in.get("server").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 42 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageConnectMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */