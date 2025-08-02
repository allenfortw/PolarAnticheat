/*    */ package net.craftigames.polar.common.messages.collection.minigames;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonPrimitive;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 74)
/*    */ public class MessageMinigameInfo extends Message {
/*    */   private String serverType;
/*    */   private int gType;
/*    */   private List<Integer> players;
/*    */   private long length;
/*    */   private int experienceTotal;
/*    */   private int coinsTotal;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessageMinigameInfo(String serverType, int gType, List<Integer> players, long length, int experienceTotal, int coinsTotal, JsonElement data) {
/* 23 */     this.serverType = serverType; this.gType = gType; this.players = players; this.length = length; this.experienceTotal = experienceTotal; this.coinsTotal = coinsTotal; this.data = data;
/*    */   }
/*    */   
/*    */   public MessageMinigameInfo() {}
/*    */   
/*    */   public String getServerType() {
/* 29 */     return this.serverType;
/* 30 */   } public int getGType() { return this.gType; }
/* 31 */   public List<Integer> getPlayers() { return this.players; }
/* 32 */   public long getLength() { return this.length; }
/* 33 */   public int getExperienceTotal() { return this.experienceTotal; }
/* 34 */   public int getCoinsTotal() { return this.coinsTotal; }
/* 35 */   public JsonElement getData() { return this.data; } public void setData(JsonElement data) { this.data = data; }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 39 */     out.add("serverType", this.serverType);
/* 40 */     out.add("gType", Integer.valueOf(this.gType));
/*    */     
/* 42 */     JsonArray memberArray = new JsonArray();
/* 43 */     for (Integer player : this.players) {
/* 44 */       memberArray.add(player);
/*    */     }
/* 46 */     out.add("players", (JsonElement)memberArray);
/*    */     
/* 48 */     out.add("length", Long.valueOf(this.length));
/*    */     
/* 50 */     out.add("eTotal", Integer.valueOf(this.experienceTotal));
/* 51 */     out.add("cTotal", Integer.valueOf(this.coinsTotal));
/* 52 */     if (this.data != null) {
/* 53 */       out.add("data", this.data);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 59 */     this.serverType = in.get("serverType").getAsString();
/* 60 */     this.gType = in.get("gType").getAsInt();
/*    */     
/* 62 */     this.players = new ArrayList<>();
/* 63 */     for (JsonElement element : in.get("players").getAsJsonArray()) {
/* 64 */       this.players.add(Integer.valueOf(element.getAsInt()));
/*    */     }
/*    */     
/* 67 */     this.length = in.get("length").getAsLong();
/*    */ 
/*    */     
/* 70 */     this.experienceTotal = in.get("eTotal", (JsonElement)new JsonPrimitive(Integer.valueOf(0))).getAsInt();
/* 71 */     this.coinsTotal = in.get("cTotal", (JsonElement)new JsonPrimitive(Integer.valueOf(0))).getAsInt();
/* 72 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 77 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\MessageMinigameInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */