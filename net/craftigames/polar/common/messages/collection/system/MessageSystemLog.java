/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 60)
/*    */ public class MessageSystemLog extends Message {
/*    */   @NotNull
/*    */   private String type;
/*    */   @Nullable
/*    */   private JsonObject data;
/*    */   
/*    */   public MessageSystemLog() {}
/*    */   
/* 20 */   public void setType(@NotNull String type) { if (type == null) throw new NullPointerException("type is marked non-null but is null");  this.type = type; } public void setData(@Nullable JsonObject data) { this.data = data; }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getType() {
/* 25 */     return this.type;
/*    */   } @Nullable
/*    */   public JsonObject getData() {
/* 28 */     return this.data;
/*    */   }
/*    */   public MessageSystemLog(@NotNull String type) {
/* 31 */     this.type = type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     out.add("type", this.type);
/* 37 */     if (this.data != null) {
/* 38 */       out.add("data", (JsonElement)this.data);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     this.type = in.get("type").getAsString();
/* 45 */     JsonElement dataElement = in.get("data");
/* 46 */     if (dataElement instanceof JsonObject) {
/* 47 */       this.data = dataElement.getAsJsonObject();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 53 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageSystemLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */