/*    */ package net.craftigames.polar.common.messages.collection.minigames;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 104)
/*    */ public class MessageMinigameSync extends Message {
/*    */   private String type;
/*    */   private JsonElement data;
/*    */   
/*    */   public MessageMinigameSync(String type, JsonElement data) {
/* 16 */     this.type = type; this.data = data;
/*    */   }
/*    */   
/*    */   public MessageMinigameSync() {}
/*    */   
/*    */   public String getType() {
/* 22 */     return this.type; } public JsonElement getData() {
/* 23 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("type", this.type);
/* 28 */     out.add("data", this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 33 */     this.type = in.get("type").getAsString();
/* 34 */     this.data = in.get("data");
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 39 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\MessageMinigameSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */