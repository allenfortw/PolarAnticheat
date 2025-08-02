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
/*    */ @MessageIdentifier(legacyId = 64)
/*    */ public class MessageClanFinishMinigame extends Message {
/*    */   private String identifier;
/*    */   private String serverType;
/*    */   private List<Integer> members;
/*    */   private List<Integer> winners;
/*    */   private List<Integer> rankedPlayers;
/*    */   private int gType;
/*    */   
/*    */   public MessageClanFinishMinigame(String identifier, String serverType, List<Integer> members, List<Integer> winners, List<Integer> rankedPlayers, int gType) {
/* 21 */     this.identifier = identifier; this.serverType = serverType; this.members = members; this.winners = winners; this.rankedPlayers = rankedPlayers; this.gType = gType;
/*    */   }
/*    */   
/*    */   public MessageClanFinishMinigame() {}
/*    */   
/*    */   public String getIdentifier() {
/* 27 */     return this.identifier;
/* 28 */   } public String getServerType() { return this.serverType; }
/* 29 */   public List<Integer> getMembers() { return this.members; }
/* 30 */   public List<Integer> getWinners() { return this.winners; } public List<Integer> getRankedPlayers() {
/* 31 */     return this.rankedPlayers;
/*    */   } public int getGType() {
/* 33 */     return this.gType;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 37 */     out.add("identifier", this.identifier);
/* 38 */     out.add("serverType", this.serverType);
/*    */     
/* 40 */     JsonArray memberArray = new JsonArray();
/* 41 */     for (Integer member : this.members) {
/* 42 */       memberArray.add(member);
/*    */     }
/* 44 */     out.add("members", (JsonElement)memberArray);
/*    */     
/* 46 */     JsonArray winnerArray = new JsonArray();
/* 47 */     for (Integer member : this.winners) {
/* 48 */       winnerArray.add(member);
/*    */     }
/* 50 */     out.add("winners", (JsonElement)winnerArray);
/*    */     
/* 52 */     JsonArray rankedPlayerArray = new JsonArray();
/* 53 */     for (Integer member : this.rankedPlayers) {
/* 54 */       rankedPlayerArray.add(member);
/*    */     }
/* 56 */     out.add("rPlayers", (JsonElement)rankedPlayerArray);
/*    */     
/* 58 */     out.add("gType", Integer.valueOf(this.gType));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 63 */     this.identifier = in.get("identifier").getAsString();
/* 64 */     this.serverType = in.get("serverType").getAsString();
/*    */     
/* 66 */     this.members = new ArrayList<>();
/* 67 */     for (JsonElement element : in.get("members").getAsJsonArray()) {
/* 68 */       this.members.add(Integer.valueOf(element.getAsInt()));
/*    */     }
/*    */     
/* 71 */     this.winners = new ArrayList<>();
/* 72 */     for (JsonElement element : in.get("winners").getAsJsonArray()) {
/* 73 */       this.winners.add(Integer.valueOf(element.getAsInt()));
/*    */     }
/*    */     
/* 76 */     this.rankedPlayers = new ArrayList<>();
/* 77 */     for (JsonElement element : in.get("rPlayers").getAsJsonArray()) {
/* 78 */       this.rankedPlayers.add(Integer.valueOf(element.getAsInt()));
/*    */     }
/*    */     
/* 81 */     if (in.has("gType")) {
/* 82 */       this.gType = in.get("gType").getAsInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 88 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanFinishMinigame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */