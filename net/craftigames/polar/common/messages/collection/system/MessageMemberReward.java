/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMemberReward extends Message {
/*    */   private String username;
/*    */   private String rewardType;
/*    */   
/*    */   public String toString() {
/* 16 */     return "MessageMemberReward(username=" + getUsername() + ", rewardType=" + getRewardType() + ", serverType=" + getServerType() + ", data=" + getData() + ")";
/*    */   } private String serverType; private JsonElement data; public MessageMemberReward() {}
/*    */   public String getUsername() {
/* 19 */     return this.username; }
/* 20 */   public String getRewardType() { return this.rewardType; }
/* 21 */   public String getServerType() { return this.serverType; } public JsonElement getData() {
/* 22 */     return this.data;
/*    */   }
/*    */   public MessageMemberReward(String username, String rewardType, String serverType, JsonElement data) {
/* 25 */     this.username = username;
/* 26 */     this.rewardType = rewardType;
/* 27 */     this.serverType = serverType;
/* 28 */     this.data = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     out.add("user", this.username);
/* 34 */     out.add("reward-type", this.rewardType);
/* 35 */     out.add("server-type", this.serverType);
/* 36 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 41 */     this.username = in.get("user").getAsString();
/* 42 */     this.rewardType = in.get("reward-type").getAsString();
/* 43 */     this.serverType = in.get("server-type").getAsString();
/* 44 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 49 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberReward.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */