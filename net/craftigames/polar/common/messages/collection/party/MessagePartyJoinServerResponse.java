/*    */ package net.craftigames.polar.common.messages.collection.party;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.core.party.PartyResponse;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 53)
/*    */ public class MessagePartyJoinServerResponse extends Message {
/*    */   private UUID partyId;
/*    */   private UUID partyLeader;
/*    */   
/*    */   public MessagePartyJoinServerResponse(UUID partyId, UUID partyLeader, List<UUID> partyMembers, PartyResponse response, String server) {
/* 21 */     this.partyId = partyId; this.partyLeader = partyLeader; this.partyMembers = partyMembers; this.response = response; this.server = server;
/*    */   } private List<UUID> partyMembers; private PartyResponse response; private String server; public MessagePartyJoinServerResponse() {}
/*    */   public void setPartyId(UUID partyId) {
/* 24 */     this.partyId = partyId; } public void setPartyLeader(UUID partyLeader) { this.partyLeader = partyLeader; } public void setPartyMembers(List<UUID> partyMembers) { this.partyMembers = partyMembers; } public void setResponse(PartyResponse response) { this.response = response; } public void setServer(String server) { this.server = server; }
/*    */ 
/*    */   
/*    */   public UUID getPartyId() {
/* 28 */     return this.partyId;
/* 29 */   } public UUID getPartyLeader() { return this.partyLeader; }
/* 30 */   public List<UUID> getPartyMembers() { return this.partyMembers; }
/* 31 */   public PartyResponse getResponse() { return this.response; } public String getServer() {
/* 32 */     return this.server;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     out.add("partyId", this.partyId.toString());
/* 37 */     out.add("partyLeader", this.partyLeader.toString());
/* 38 */     out.add("response", this.response.name());
/* 39 */     out.add("server", this.server);
/*    */     
/* 41 */     JsonBuilder.JsonArrayBuilder builder = JsonBuilder.array();
/* 42 */     for (UUID member : this.partyMembers) {
/* 43 */       builder.add(member.toString());
/*    */     }
/* 45 */     out.add("partyMembers", (JsonElement)builder.build());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 50 */     this.partyId = UUID.fromString(in.get("partyId").getAsString());
/* 51 */     this.partyLeader = UUID.fromString(in.get("partyLeader").getAsString());
/* 52 */     this.response = PartyResponse.valueOf(in.get("response").getAsString().toUpperCase());
/* 53 */     this.server = in.get("server").getAsString();
/*    */     
/* 55 */     this.partyMembers = new ArrayList<>();
/* 56 */     JsonArray partyMembers = in.get("partyMembers").getAsJsonArray();
/* 57 */     for (JsonElement partyMember : partyMembers) {
/* 58 */       this.partyMembers.add(UUID.fromString(partyMember.getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 64 */     return MessageType.PARTY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\party\MessagePartyJoinServerResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */