/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 71)
/*    */ public class MessageClanTeamRequest extends Message {
/*    */   private long verificationId;
/*    */   
/*    */   public MessageClanTeamRequest(long verificationId, String identifier, Map<Integer, UUID> userTeams) {
/* 18 */     this.verificationId = verificationId; this.identifier = identifier; this.userTeams = userTeams;
/*    */   }
/*    */   private String identifier; private Map<Integer, UUID> userTeams;
/*    */   public MessageClanTeamRequest() {}
/*    */   
/*    */   public long getVerificationId() {
/* 24 */     return this.verificationId;
/* 25 */   } public String getIdentifier() { return this.identifier; } public Map<Integer, UUID> getUserTeams() {
/* 26 */     return this.userTeams;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("verification", Long.valueOf(this.verificationId));
/* 31 */     out.add("identifier", this.identifier);
/* 32 */     JsonObject object = new JsonObject();
/* 33 */     for (Map.Entry<Integer, UUID> integerIntegerEntry : this.userTeams.entrySet()) {
/* 34 */       object.addProperty(Integer.toString(((Integer)integerIntegerEntry.getKey()).intValue()), ((UUID)integerIntegerEntry.getValue()).toString());
/*    */     }
/* 36 */     out.add("users", (JsonElement)object);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 41 */     this.verificationId = in.get("verification").getAsLong();
/* 42 */     this.identifier = in.get("identifier").getAsString();
/* 43 */     JsonObject users = in.get("users").getAsJsonObject();
/* 44 */     this.userTeams = new HashMap<>();
/*    */     
/* 46 */     for (Map.Entry<String, JsonElement> stringJsonElementEntry : (Iterable<Map.Entry<String, JsonElement>>)users.entrySet()) {
/* 47 */       int userId = Integer.parseInt(stringJsonElementEntry.getKey());
/* 48 */       UUID teamId = UUID.fromString(((JsonElement)stringJsonElementEntry.getValue()).getAsString());
/*    */       
/* 50 */       this.userTeams.put(Integer.valueOf(userId), teamId);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 56 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanTeamRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */