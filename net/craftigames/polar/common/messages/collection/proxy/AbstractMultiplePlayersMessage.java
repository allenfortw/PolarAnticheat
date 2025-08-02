/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ public abstract class AbstractMultiplePlayersMessage extends Message {
/*    */   @Nullable
/*    */   private List<UUID> playerUuids;
/*    */   
/*    */   public AbstractMultiplePlayersMessage() {}
/*    */   
/*    */   public void setPlayerUuids(@Nullable List<UUID> playerUuids) {
/* 18 */     this.playerUuids = playerUuids;
/*    */   }
/*    */   @Nullable
/*    */   public List<UUID> getPlayerUuids() {
/* 22 */     return this.playerUuids;
/*    */   }
/*    */   public AbstractMultiplePlayersMessage(@Nullable List<UUID> playerUuids) {
/* 25 */     this.playerUuids = playerUuids;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     if (this.playerUuids != null) {
/* 31 */       JsonArray array = new JsonArray();
/* 32 */       for (UUID uuid : this.playerUuids) {
/* 33 */         array.add(uuid.toString());
/*    */       }
/* 35 */       out.add("uuids", (JsonElement)array);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 41 */     JsonElement uuidsElement = in.get("uuids");
/* 42 */     if (uuidsElement != null && uuidsElement.isJsonArray()) {
/* 43 */       JsonArray array = uuidsElement.getAsJsonArray();
/* 44 */       List<UUID> uuids = Lists.newArrayList();
/* 45 */       for (JsonElement e : array) {
/*    */         try {
/* 47 */           uuids.add(UUID.fromString(e.getAsString()));
/* 48 */         } catch (IllegalArgumentException illegalArgumentException) {}
/*    */       } 
/*    */ 
/*    */       
/* 52 */       setPlayerUuids(uuids);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\AbstractMultiplePlayersMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */