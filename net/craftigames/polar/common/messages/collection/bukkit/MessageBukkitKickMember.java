/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 108)
/*    */ public class MessageBukkitKickMember
/*    */   extends Message
/*    */ {
/*    */   public void setMessage(Component message) {
/* 24 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   private Component message;
/* 29 */   private final Set<UUID> playerUuids = new HashSet<>(); public Set<UUID> getPlayerUuids() { return this.playerUuids; } public Component getMessage() {
/* 30 */     return this.message;
/*    */   }
/*    */   public MessageBukkitKickMember(UUID playerUuid, Component message) {
/* 33 */     this.playerUuids.add(playerUuid);
/* 34 */     this.message = message;
/*    */   }
/*    */   
/*    */   public MessageBukkitKickMember(Collection<UUID> players, Component message) {
/* 38 */     this.playerUuids.addAll(players);
/* 39 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 44 */     JsonArray uuids = new JsonArray();
/* 45 */     for (UUID playerUuid : this.playerUuids) {
/* 46 */       uuids.add(playerUuid.toString());
/*    */     }
/* 48 */     out.add("uuids", (JsonElement)uuids);
/* 49 */     out.add("message", TextUtils.toGson(this.message));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 54 */     for (JsonElement uuids : in.get("uuids").getAsJsonArray()) {
/* 55 */       this.playerUuids.add(UUID.fromString(uuids.getAsString()));
/*    */     }
/* 57 */     setMessage(TextUtils.fromGson(in.get("message").getAsString()));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 62 */     return MessageType.PROXY;
/*    */   }
/*    */   
/*    */   public MessageBukkitKickMember() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageBukkitKickMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */