/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.PolarVote;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMemberVote extends Message {
/*    */   private String username;
/*    */   private PolarVote vote;
/*    */   
/*    */   public MessageMemberVote() {}
/*    */   
/* 17 */   public String getUsername() { return this.username; } public PolarVote getVote() {
/* 18 */     return this.vote;
/*    */   }
/*    */   public MessageMemberVote(String username, PolarVote vote) {
/* 21 */     this.username = username;
/* 22 */     this.vote = vote;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("username", this.username);
/* 28 */     out.add("vote", (GsonSerializable)this.vote);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.username = in.get("username").getAsString();
/* 34 */     this.vote = PolarVote.deserialize(in.get("vote"));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageMemberVote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */