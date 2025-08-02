/*    */ package net.craftigames.polar.common.core.menu;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.core.CoreUtils;
/*    */ import net.craftigames.polar.common.core.Identifiable;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public enum MenuType
/*    */   implements Identifiable, GsonSerializable {
/*    */   MenuType(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   private final int id;
/*    */   public static final MenuType[] CACHE;
/* 18 */   PLAYER(1),
/* 19 */   DISPENSER(2);
/*    */   public int getId() {
/* 21 */     return this.id;
/*    */   } static {
/* 23 */     CACHE = values();
/*    */   }
/*    */   public static MenuType deserialize(JsonElement element) {
/* 26 */     if (element instanceof com.google.gson.JsonPrimitive) {
/* 27 */       int asInt = element.getAsInt();
/* 28 */       return (MenuType)CoreUtils.getIdentifiable(asInt, (Identifiable[])CACHE);
/*    */     } 
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 36 */     return JsonBuilder.primitive(Integer.valueOf(this.id));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\MenuType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */