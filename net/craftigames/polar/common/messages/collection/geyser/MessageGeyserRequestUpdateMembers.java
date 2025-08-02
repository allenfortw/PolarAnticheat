/*    */ package net.craftigames.polar.common.messages.collection.geyser;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageGeyserRequestUpdateMembers
/*    */   extends Message
/*    */ {
/* 27 */   private final Set<UUID> uuids = new HashSet<>(); public Set<UUID> getUuids() { return this.uuids; }
/*    */   
/*    */   public MessageGeyserRequestUpdateMembers(Collection<UUID> uuids) {
/* 30 */     this.uuids.addAll(uuids);
/*    */   }
/*    */   
/*    */   public MessageGeyserRequestUpdateMembers(UUID uuid) {
/* 34 */     this.uuids.add(uuid);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 39 */     JsonArray array = new JsonArray();
/* 40 */     this.uuids.forEach(uuid -> array.add(uuid.toString()));
/* 41 */     out.add("uuids", (JsonElement)array);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 46 */     JsonArray array = in.getAsJsonArray("uuids");
/* 47 */     for (JsonElement jsonElement : array) {
/* 48 */       this.uuids.add(UUID.fromString(jsonElement.getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 54 */     return MessageType.GEYSER;
/*    */   }
/*    */   
/*    */   public MessageGeyserRequestUpdateMembers() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\MessageGeyserRequestUpdateMembers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */