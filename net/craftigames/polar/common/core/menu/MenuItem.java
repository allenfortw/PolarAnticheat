/*    */ package net.craftigames.polar.common.core.menu;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.Objects;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class MenuItem
/*    */   implements GsonSerializable {
/*    */   private int slot;
/*    */   private PolarItemStack item;
/*    */   
/*    */   public void setSlot(int slot) {
/* 16 */     this.slot = slot; } public void setItem(PolarItemStack item) { this.item = item; } public void setClickable(boolean clickable) { this.clickable = clickable; }
/*    */    public MenuItem(int slot, PolarItemStack item, boolean clickable) {
/* 18 */     this.slot = slot; this.item = item; this.clickable = clickable;
/*    */   }
/*    */   
/* 21 */   public int getSlot() { return this.slot; }
/* 22 */   public PolarItemStack getItem() { return this.item; } public boolean isClickable() {
/* 23 */     return this.clickable;
/*    */   } private boolean clickable = false;
/*    */   public MenuItem(int slot, PolarItemStack item) {
/* 26 */     this.slot = slot;
/* 27 */     this.item = item;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 32 */     if (this == o) return true; 
/* 33 */     if (o == null || getClass() != o.getClass()) return false; 
/* 34 */     MenuItem menuItem = (MenuItem)o;
/* 35 */     return (this.slot == menuItem.slot && 
/* 36 */       Objects.equals(this.item, menuItem.item));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 41 */     return Objects.hash(new Object[] { Integer.valueOf(this.slot), this.item });
/*    */   }
/*    */   
/*    */   public static MenuItem deserialize(JsonElement element) {
/* 45 */     if (element instanceof JsonObject) {
/* 46 */       JsonObject object = element.getAsJsonObject();
/*    */       
/* 48 */       MenuItem item = new MenuItem();
/*    */       
/* 50 */       JsonElement itemElement = object.get("item");
/* 51 */       if (itemElement instanceof JsonObject) {
/* 52 */         item.setItem(PolarItemStack.deserialize(itemElement));
/*    */       }
/*    */       
/* 55 */       JsonElement slotElement = object.get("slot");
/* 56 */       if (slotElement instanceof com.google.gson.JsonPrimitive) {
/* 57 */         item.setSlot(slotElement.getAsInt());
/*    */       }
/*    */       
/* 60 */       JsonElement clickableElement = object.get("clickable");
/* 61 */       if (clickableElement instanceof com.google.gson.JsonPrimitive) {
/* 62 */         item.setClickable(clickableElement.getAsBoolean());
/*    */       }
/*    */       
/* 65 */       return item;
/*    */     } 
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 74 */     return (JsonElement)JsonBuilder.object()
/* 75 */       .add("item", this.item)
/* 76 */       .add("slot", Integer.valueOf(this.slot))
/* 77 */       .add("clickable", Boolean.valueOf(this.clickable))
/* 78 */       .build();
/*    */   }
/*    */   
/*    */   public MenuItem() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\MenuItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */