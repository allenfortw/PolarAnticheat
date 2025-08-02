/*    */ package net.craftigames.polar.common.messages.collection.menu;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.core.menu.AbstractPolarMenu;
/*    */ import net.craftigames.polar.common.core.menu.MenuItem;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 44)
/*    */ public class MessageMenuOpen extends Message {
/*    */   private UUID user;
/*    */   private AbstractPolarMenu polarMenu;
/*    */   private List<MenuItem> updateItems;
/*    */   
/*    */   public MessageMenuOpen(UUID user, AbstractPolarMenu polarMenu, List<MenuItem> updateItems) {
/* 23 */     this.user = user; this.polarMenu = polarMenu; this.updateItems = updateItems;
/*    */   }
/*    */   public MessageMenuOpen() {}
/* 26 */   public void setUser(UUID user) { this.user = user; } public void setPolarMenu(AbstractPolarMenu polarMenu) { this.polarMenu = polarMenu; } public void setUpdateItems(List<MenuItem> updateItems) { this.updateItems = updateItems; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 30 */     return this.user;
/* 31 */   } public AbstractPolarMenu getPolarMenu() { return this.polarMenu; } public List<MenuItem> getUpdateItems() {
/* 32 */     return this.updateItems;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     out.add("user", this.user);
/* 37 */     out.add("menu", (GsonSerializable)this.polarMenu);
/* 38 */     if (this.updateItems != null) {
/* 39 */       out.add("update", (JsonElement)JsonBuilder.array().addAll(this.updateItems.stream().map(MenuItem::serialize)).build());
/*    */     }
/*    */   }
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     this.user = in.getAsUUID("user");
/* 45 */     JsonElement menu = in.get("menu");
/* 46 */     if (menu instanceof com.google.gson.JsonObject) {
/* 47 */       this.polarMenu = AbstractPolarMenu.deserialize(menu);
/*    */     } else {
/* 49 */       this.polarMenu = null;
/*    */     } 
/* 51 */     JsonElement items = in.get("update");
/* 52 */     if (items instanceof com.google.gson.JsonArray) {
/* 53 */       this.updateItems = new ArrayList<>();
/* 54 */       for (JsonElement element : items.getAsJsonArray()) {
/* 55 */         this.updateItems.add(MenuItem.deserialize(element));
/*    */       }
/*    */     } else {
/*    */       
/* 59 */       this.updateItems = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 65 */     return MessageType.MENU;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\menu\MessageMenuOpen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */