/*    */ package net.craftigames.polar.common.messages.collection.menu;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.core.menu.ClickType;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 45)
/*    */ public class MessageMenuClickResponse extends Message {
/*    */   private UUID user;
/*    */   private UUID menu;
/*    */   
/*    */   public MessageMenuClickResponse(UUID user, UUID menu, int slot, ClickType type) {
/* 16 */     this.user = user; this.menu = menu; this.slot = slot; this.type = type;
/*    */   } private int slot; private ClickType type; public MessageMenuClickResponse() {}
/*    */   public void setUser(UUID user) {
/* 19 */     this.user = user; } public void setMenu(UUID menu) { this.menu = menu; } public void setSlot(int slot) { this.slot = slot; } public void setType(ClickType type) { this.type = type; }
/*    */ 
/*    */   
/*    */   public UUID getUser() {
/* 23 */     return this.user;
/* 24 */   } public UUID getMenu() { return this.menu; }
/* 25 */   public int getSlot() { return this.slot; } public ClickType getType() {
/* 26 */     return this.type;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("user", this.user);
/* 31 */     out.add("menu", this.menu);
/* 32 */     out.add("slot", Integer.valueOf(this.slot));
/* 33 */     out.add("type", (GsonSerializable)this.type);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.user = in.getAsUUID("user");
/* 39 */     this.menu = in.getAsUUID("menu");
/* 40 */     this.slot = in.get("slot").getAsInt();
/* 41 */     this.type = ClickType.deserialize(in.get("type"));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.MENU;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\menu\MessageMenuClickResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */