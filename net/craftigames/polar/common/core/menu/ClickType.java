/*    */ package net.craftigames.polar.common.core.menu;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.core.CoreUtils;
/*    */ import net.craftigames.polar.common.core.Identifiable;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public enum ClickType
/*    */   implements Identifiable, GsonSerializable {
/*    */   ClickType(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   private final int id;
/*    */   public static final ClickType[] CACHE;
/* 18 */   LEFT(1),
/* 19 */   SHIFT_LEFT(2),
/* 20 */   RIGHT(3),
/* 21 */   SHIFT_RIGHT(4),
/* 22 */   WINDOW_BORDER_LEFT(5),
/* 23 */   WINDOW_BORDER_RIGHT(6),
/* 24 */   MIDDLE(7),
/* 25 */   NUMBER_KEY(8),
/* 26 */   DOUBLE_CLICK(9),
/* 27 */   DROP(10),
/* 28 */   CONTROL_DROP(11),
/* 29 */   CREATIVE(12),
/* 30 */   UNKNOWN(13);
/*    */   public int getId() {
/* 32 */     return this.id;
/*    */   } static {
/* 34 */     CACHE = values();
/*    */   }
/*    */   public static ClickType deserialize(JsonElement element) {
/* 37 */     if (element instanceof com.google.gson.JsonPrimitive) {
/* 38 */       int asInt = element.getAsInt();
/* 39 */       return (ClickType)CoreUtils.getIdentifiable(asInt, (Identifiable[])CACHE);
/*    */     } 
/* 41 */     return UNKNOWN;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 47 */     return JsonBuilder.primitive(Integer.valueOf(this.id));
/*    */   }
/*    */   
/*    */   public boolean isKeyboardClick() {
/* 51 */     return (this == NUMBER_KEY || this == DROP || this == CONTROL_DROP);
/*    */   }
/*    */   
/*    */   public boolean isCreativeAction() {
/* 55 */     return (this == MIDDLE || this == CREATIVE);
/*    */   }
/*    */   
/*    */   public boolean isRightClick() {
/* 59 */     return (this == RIGHT || this == SHIFT_RIGHT);
/*    */   }
/*    */   
/*    */   public boolean isLeftClick() {
/* 63 */     return (this == LEFT || this == SHIFT_LEFT || this == DOUBLE_CLICK || this == CREATIVE);
/*    */   }
/*    */   
/*    */   public boolean isShiftClick() {
/* 67 */     return (this == SHIFT_LEFT || this == SHIFT_RIGHT || this == CONTROL_DROP);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\ClickType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */