/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessagePlayerChooseInitialServerResponse extends Message implements PendingRequestResponseMessage {
/*    */   private UUID user;
/*    */   
/*    */   public MessagePlayerChooseInitialServerResponse(UUID user, UUID uuid, JsonElement data) {
/* 13 */     this.user = user; this.uuid = uuid; this.data = data;
/*    */   } private UUID uuid; private JsonElement data; public MessagePlayerChooseInitialServerResponse() {} public void setUser(UUID user) {
/* 15 */     this.user = user; } public void setUuid(UUID uuid) { this.uuid = uuid; } public void setData(JsonElement data) { this.data = data; }
/*    */    public String toString() {
/* 17 */     return "MessagePlayerChooseInitialServerResponse(user=" + getUser() + ", uuid=" + getUuid() + ", data=" + getData() + ")";
/*    */   }
/*    */   
/* 20 */   public UUID getUser() { return this.user; }
/* 21 */   public UUID getUuid() { return this.uuid; } public JsonElement getData() {
/* 22 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 26 */     out.add("user", this.user);
/* 27 */     out.add("uuid", this.uuid);
/* 28 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.user = in.getAsUUID("user");
/* 34 */     this.uuid = in.getAsUUID("uuid");
/* 35 */     this.data = in.get("data");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessagePlayerChooseInitialServerResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */