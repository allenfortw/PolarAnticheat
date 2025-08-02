/*     */ package net.craftigames.polar.common.core.menu;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ 
/*     */ 
/*     */ public class AbstractPolarMenu
/*     */   implements GsonSerializable
/*     */ {
/*     */   public void setUuid(UUID uuid) {
/*  18 */     this.uuid = uuid; } public void setTitle(String title) { this.title = title; } public void setRows(int rows) { this.rows = rows; } public void setMenuType(MenuType menuType) { this.menuType = menuType; }
/*     */ 
/*     */   
/*     */   private String title;
/*  22 */   private UUID uuid = UUID.randomUUID(); private int rows; public UUID getUuid() { return this.uuid; }
/*  23 */   public String getTitle() { return this.title; } public int getRows() {
/*  24 */     return this.rows;
/*  25 */   } private MenuType menuType = MenuType.PLAYER; public MenuType getMenuType() { return this.menuType; }
/*     */   
/*  27 */   private Map<Integer, MenuItem> items = Maps.newConcurrentMap();
/*     */   
/*  29 */   public final int[] slots = new int[] { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 }; public int[] getSlots() { return this.slots; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getCornerSlots() {
/*  37 */     if (this.rows == 1) {
/*  38 */       return new int[] { 0, 8 };
/*     */     }
/*     */     
/*  41 */     if (this.rows == 2) {
/*  42 */       return new int[] { 0, 8, 9, 17 };
/*     */     }
/*     */     
/*  45 */     if (this.rows == 3) {
/*  46 */       return new int[] { 0, 1, 7, 8, 9, 17, 26 };
/*     */     }
/*     */     
/*  49 */     if (this.rows == 4) {
/*  50 */       return new int[] { 0, 1, 7, 8, 9, 17, 18, 26, 27, 28, 34, 35 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     if (this.rows == 5) {
/*  60 */       return new int[] { 0, 1, 7, 8, 9, 17, 27, 35, 36, 37, 43, 44 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (this.rows == 6) {
/*  68 */       return new int[] { 0, 1, 7, 8, 9, 17, 36, 44, 45, 46, 52, 53 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     return new int[0];
/*     */   }
/*     */   
/*     */   public AbstractPolarMenu(String title, int lines) {
/*  79 */     this.title = title;
/*  80 */     this.rows = lines;
/*     */   }
/*     */   
/*     */   public AbstractPolarMenu(String title, MenuType menuType) {
/*  84 */     this.title = title;
/*  85 */     this.menuType = menuType;
/*     */   }
/*     */   
/*     */   public Map<Integer, MenuItem> getItems() {
/*  89 */     return this.items;
/*     */   }
/*     */   
/*     */   public void setItems(Map<Integer, MenuItem> items) {
/*  93 */     this.items = items;
/*     */   }
/*     */   
/*     */   public static AbstractPolarMenu deserialize(JsonElement element) {
/*  97 */     if (element instanceof JsonObject) {
/*  98 */       JsonObject object = element.getAsJsonObject();
/*  99 */       AbstractPolarMenu polarMenu = new AbstractPolarMenu();
/*     */       
/* 101 */       JsonElement uuidElement = object.get("uuid");
/* 102 */       if (uuidElement instanceof com.google.gson.JsonPrimitive) {
/* 103 */         polarMenu.setUuid(UUID.fromString(uuidElement.getAsString()));
/*     */       }
/*     */       
/* 106 */       JsonElement titleElement = object.get("title");
/* 107 */       if (titleElement instanceof com.google.gson.JsonPrimitive) {
/* 108 */         polarMenu.setTitle(titleElement.getAsString());
/*     */       }
/*     */       
/* 111 */       JsonElement rowsElement = object.get("rows");
/* 112 */       if (rowsElement instanceof com.google.gson.JsonPrimitive) {
/* 113 */         polarMenu.setRows(rowsElement.getAsInt());
/*     */       }
/*     */       
/* 116 */       JsonElement menuTypeElement = object.get("menuType");
/* 117 */       if (menuTypeElement instanceof com.google.gson.JsonPrimitive) {
/* 118 */         polarMenu.setMenuType(MenuType.deserialize(menuTypeElement));
/*     */       }
/*     */       
/* 121 */       JsonElement itemsElement = object.get("items");
/* 122 */       if (itemsElement instanceof com.google.gson.JsonArray) {
/* 123 */         Map<Integer, MenuItem> items = new HashMap<>();
/* 124 */         for (JsonElement jsonElement : itemsElement.getAsJsonArray()) {
/* 125 */           MenuItem item = MenuItem.deserialize(jsonElement);
/* 126 */           items.put(Integer.valueOf(item.getSlot()), item);
/*     */         } 
/* 128 */         polarMenu.setItems(items);
/*     */       } 
/*     */ 
/*     */       
/* 132 */       return polarMenu;
/*     */     } 
/* 134 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonElement serialize() {
/* 140 */     return (JsonElement)JsonBuilder.object()
/* 141 */       .add("uuid", this.uuid)
/* 142 */       .add("title", this.title)
/* 143 */       .add("rows", Integer.valueOf(this.rows))
/* 144 */       .add("menuType", this.menuType)
/* 145 */       .add("items", (JsonElement)JsonBuilder.array().addSerializables(getItems().values()).build())
/* 146 */       .build();
/*     */   }
/*     */   
/*     */   public AbstractPolarMenu() {}
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\AbstractPolarMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */