/*    */ package net.craftigames.polar.common.messages.collection.party;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 52)
/*    */ public class MessagePartyJoinServer extends Message {
/*    */   private UUID partyId;
/*    */   private UUID partyLeader;
/*    */   private List<UUID> partyMembers;
/*    */   private String server;
/*    */   
/*    */   public MessagePartyJoinServer(UUID partyId, UUID partyLeader, List<UUID> partyMembers, String server) {
/* 19 */     this.partyId = partyId; this.partyLeader = partyLeader; this.partyMembers = partyMembers; this.server = server;
/*    */   }
/*    */   public MessagePartyJoinServer() {}
/* 22 */   public void setPartyId(UUID partyId) { this.partyId = partyId; } public void setPartyLeader(UUID partyLeader) { this.partyLeader = partyLeader; } public void setPartyMembers(List<UUID> partyMembers) { this.partyMembers = partyMembers; } public void setServer(String server) { this.server = server; }
/*    */ 
/*    */   
/*    */   public UUID getPartyId() {
/* 26 */     return this.partyId;
/* 27 */   } public UUID getPartyLeader() { return this.partyLeader; }
/* 28 */   public List<UUID> getPartyMembers() { return this.partyMembers; } public String getServer() {
/* 29 */     return this.server;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     out.add("partyId", this.partyId.toString());
/* 34 */     out.add("partyLeader", this.partyLeader.toString());
/* 35 */     out.add("server", this.server);
/*    */     
/* 37 */     JsonArray array = new JsonArray();
/* 38 */     for (UUID member : this.partyMembers) {
/* 39 */       array.add(member.toString());
/*    */     }
/* 41 */     out.add("partyMembers", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 46 */     this.partyId = UUID.fromString(in.get("partyId").getAsString());
/* 47 */     this.partyLeader = UUID.fromString(in.get("partyLeader").getAsString());
/* 48 */     this.server = in.get("server").getAsString();
/*    */     
/* 50 */     this.partyMembers = new ArrayList<>();
/* 51 */     JsonArray partyMembers = in.get("partyMembers").getAsJsonArray();
/* 52 */     for (JsonElement partyMember : partyMembers) {
/* 53 */       this.partyMembers.add(UUID.fromString(partyMember.getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 59 */     return MessageType.PARTY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\party\MessagePartyJoinServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */