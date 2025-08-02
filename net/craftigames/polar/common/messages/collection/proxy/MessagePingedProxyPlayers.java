/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 29)
/*    */ public class MessagePingedProxyPlayers
/*    */   extends Message
/*    */ {
/*    */   public void setPlayers(List<UUID> players) {
/* 19 */     this.players = players;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 24 */   private List<UUID> players = Lists.newArrayList(); public List<UUID> getPlayers() { return this.players; }
/*    */   
/*    */   public MessagePingedProxyPlayers(List<UUID> players) {
/* 27 */     this.players = players;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 32 */     JsonArray array = new JsonArray();
/* 33 */     for (UUID uuid : this.players) {
/* 34 */       array.add(uuid.toString());
/*    */     }
/* 36 */     out.add("players", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 41 */     JsonArray array = in.get("players").getAsJsonArray();
/* 42 */     for (JsonElement element : array) {
/*    */       try {
/* 44 */         UUID uuid = UUID.fromString(element.getAsString());
/* 45 */         this.players.add(uuid);
/* 46 */       } catch (Exception exception) {}
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 53 */     return MessageType.PROXY;
/*    */   }
/*    */   
/*    */   public MessagePingedProxyPlayers() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessagePingedProxyPlayers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */