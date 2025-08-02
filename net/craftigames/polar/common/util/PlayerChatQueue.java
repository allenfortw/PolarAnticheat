/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ 
/*    */ public class PlayerChatQueue implements GsonSerializable, QueueAction {
/*    */   private String targetServer;
/*    */   private String chat;
/*    */   private long expire;
/*    */   
/* 12 */   public void setTargetServer(String targetServer) { this.targetServer = targetServer; } public void setChat(String chat) { this.chat = chat; } public void setExpire(long expire) { this.expire = expire; }
/*    */   
/*    */   public PlayerChatQueue() {}
/*    */   public String getTargetServer() {
/* 16 */     return this.targetServer;
/*    */   }
/* 18 */   public String getChat() { return this.chat; } public long getExpire() {
/* 19 */     return this.expire;
/*    */   }
/*    */   public PlayerChatQueue(String chat, long expire) {
/* 22 */     this.chat = chat;
/* 23 */     this.expire = expire;
/*    */   }
/*    */   
/*    */   public static PlayerChatQueue deserialize(JsonElement element) {
/* 27 */     Preconditions.checkArgument(element.isJsonObject());
/* 28 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 30 */     Preconditions.checkArgument(object.has("chat"));
/* 31 */     Preconditions.checkArgument(object.has("expire"));
/*    */     
/* 33 */     String chat = object.get("chat").getAsString();
/* 34 */     long expire = object.get("expire").getAsLong();
/*    */     
/* 36 */     return new PlayerChatQueue(chat, expire);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement serialize() {
/* 41 */     return (JsonElement)JsonBuilder.object()
/* 42 */       .add("chat", this.chat)
/* 43 */       .add("expire", Long.valueOf(this.expire))
/* 44 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\PlayerChatQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */