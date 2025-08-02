/*    */ package net.craftigames.polar.common.core.menu.sub;
/*    */ import javax.annotation.Nullable;
/*    */ 
/*    */ @Deprecated
/*    */ public enum PolarPotionEffectType {
/*    */   PolarPotionEffectType(int id, String legacyName) {
/*    */     this.id = id;
/*    */     this.legacyName = legacyName;
/*    */   }
/*    */   
/*    */   PolarPotionEffectType(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   private final int id;
/*    */   private String legacyName;
/* 18 */   SPEED(1),
/* 19 */   SLOW(2),
/* 20 */   FAST_DIGGING(3),
/* 21 */   SLOW_DIGGING(4),
/* 22 */   INCREASE_DAMAGE(5),
/* 23 */   HEAL(6),
/* 24 */   HARM(7),
/* 25 */   JUMP(8),
/* 26 */   CONFUSION(9),
/* 27 */   REGENERATION(10),
/* 28 */   DAMAGE_RESISTANCE(11),
/* 29 */   FIRE_RESISTANCE(12),
/* 30 */   WATER_BREATHING(13),
/* 31 */   INVISIBILITY(14),
/* 32 */   BLINDNESS(15),
/* 33 */   NIGHT_VISION(16),
/* 34 */   HUNGER(17),
/* 35 */   WEAKNESS(18),
/* 36 */   POISON(19),
/* 37 */   WITHER(20),
/* 38 */   HEALTH_BOOST(21),
/* 39 */   ABSORPTION(22),
/* 40 */   SATURATION(23); private static final PolarPotionEffectType[] CACHE;
/*    */   @Deprecated
/*    */   public int getId() {
/* 43 */     return this.id; } public String getLegacyName() {
/* 44 */     return this.legacyName;
/*    */   } static {
/* 46 */     CACHE = values();
/*    */   }
/*    */   @Nullable
/*    */   public static PolarPotionEffectType fromId(int id) {
/* 50 */     for (PolarPotionEffectType type : CACHE) {
/* 51 */       if (type.getId() == id) {
/* 52 */         return type;
/*    */       }
/*    */     } 
/* 55 */     return null;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static PolarPotionEffectType fromName(String name) {
/* 60 */     for (PolarPotionEffectType type : CACHE) {
/* 61 */       if (name.equalsIgnoreCase(type.name()) || name.equalsIgnoreCase(type.legacyName)) {
/* 62 */         return type;
/*    */       }
/*    */     } 
/*    */     
/* 66 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\sub\PolarPotionEffectType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */