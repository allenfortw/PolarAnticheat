/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 72)
/*    */ public class MessageClanTeamRequestResponse extends Message {
/*    */   private long verificationId;
/*    */   private List<Integer> disallowedUsers;
/*    */   
/*    */   public MessageClanTeamRequestResponse(long verificationId, List<Integer> disallowedUsers) {
/* 17 */     this.verificationId = verificationId; this.disallowedUsers = disallowedUsers;
/*    */   }
/*    */   
/*    */   public MessageClanTeamRequestResponse() {}
/*    */   
/*    */   public long getVerificationId() {
/* 23 */     return this.verificationId; } public List<Integer> getDisallowedUsers() {
/* 24 */     return this.disallowedUsers;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     out.add("verification", Long.valueOf(this.verificationId));
/* 29 */     JsonArray array = new JsonArray();
/* 30 */     for (Integer disallowedUser : this.disallowedUsers) {
/* 31 */       array.add(disallowedUser);
/*    */     }
/* 33 */     out.add("users", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.verificationId = in.get("verification").getAsLong();
/* 39 */     JsonArray users = in.get("users").getAsJsonArray();
/* 40 */     this.disallowedUsers = new ArrayList<>();
/*    */     
/* 42 */     for (JsonElement user : users) {
/* 43 */       this.disallowedUsers.add(Integer.valueOf(user.getAsInt()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 49 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanTeamRequestResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */