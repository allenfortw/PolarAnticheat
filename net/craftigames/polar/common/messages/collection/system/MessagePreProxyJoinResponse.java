/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.PendingRequestResponseMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessagePreProxyJoinResponse extends Message implements PendingRequestResponseMessage {
/*    */   private UUID user;
/*    */   private UUID uuid;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessagePreProxyJoinResponse() {}
/*    */   
/* 19 */   public UUID getUser() { return this.user; }
/* 20 */   public UUID getUuid() { return this.uuid; } public JsonElement getData() {
/* 21 */     return this.data;
/*    */   }
/*    */   public MessagePreProxyJoinResponse(UUID user, UUID uuid, JsonElement data) {
/* 24 */     this.user = user;
/* 25 */     this.uuid = uuid;
/* 26 */     this.data = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     out.add("user", this.user);
/* 32 */     out.add("uuid", this.uuid);
/* 33 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.user = in.getAsUUID("user");
/* 39 */     this.uuid = in.getAsUUID("uuid");
/* 40 */     this.data = in.get("data");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessagePreProxyJoinResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */