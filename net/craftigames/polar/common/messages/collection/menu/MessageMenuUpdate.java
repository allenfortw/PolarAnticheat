/*    */ package net.craftigames.polar.common.messages.collection.menu;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.core.menu.MenuItem;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 98)
/*    */ public class MessageMenuUpdate extends Message {
/*    */   private UUID menuId;
/*    */   private UUID userId;
/*    */   private long updateTime;
/*    */   private List<MenuItem> items;
/*    */   
/*    */   public MessageMenuUpdate(UUID menuId, UUID userId, long updateTime, List<MenuItem> items) {
/* 21 */     this.menuId = menuId; this.userId = userId; this.updateTime = updateTime; this.items = items;
/*    */   }
/*    */   public MessageMenuUpdate() {}
/* 24 */   public void setMenuId(UUID menuId) { this.menuId = menuId; } public void setUserId(UUID userId) { this.userId = userId; } public void setUpdateTime(long updateTime) { this.updateTime = updateTime; } public void setItems(List<MenuItem> items) { this.items = items; }
/*    */ 
/*    */   
/*    */   public UUID getMenuId() {
/* 28 */     return this.menuId;
/* 29 */   } public UUID getUserId() { return this.userId; }
/* 30 */   public long getUpdateTime() { return this.updateTime; } public List<MenuItem> getItems() {
/* 31 */     return this.items;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     out.add("menuId", this.menuId);
/* 36 */     out.add("userId", this.userId);
/* 37 */     out.add("updateTime", Long.valueOf(this.updateTime));
/* 38 */     out.add("items", (JsonElement)JsonBuilder.array().addAll(this.items.stream().map(MenuItem::serialize)).build());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 43 */     this.menuId = in.getAsUUID("menuId");
/* 44 */     this.userId = in.getAsUUID("userId");
/* 45 */     this.updateTime = in.get("updateTime").getAsLong();
/* 46 */     JsonElement items = in.get("items");
/* 47 */     if (items instanceof com.google.gson.JsonArray) {
/* 48 */       this.items = new ArrayList<>();
/* 49 */       for (JsonElement element : items.getAsJsonArray()) {
/* 50 */         this.items.add(MenuItem.deserialize(element));
/*    */       }
/*    */     } else {
/*    */       
/* 54 */       this.items = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 60 */     return MessageType.MENU;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\menu\MessageMenuUpdate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */