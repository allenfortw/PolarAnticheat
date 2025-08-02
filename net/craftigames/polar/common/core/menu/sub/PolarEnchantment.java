/*    */ package net.craftigames.polar.common.core.menu.sub;
/*    */ import javax.annotation.Nullable;
/*    */ 
/*    */ @Deprecated
/*    */ public enum PolarEnchantment {
/*    */   PolarEnchantment(int id, String legacyName) {
/*    */     this.id = id;
/*    */     this.legacyName = legacyName;
/*    */   }
/*    */   
/*    */   PolarEnchantment(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   private final int id;
/*    */   private String legacyName;
/* 18 */   PROTECTION_ENVIRONMENTAL(0),
/* 19 */   PROTECTION_FIRE(1),
/* 20 */   PROTECTION_FALL(2),
/* 21 */   PROTECTION_EXPLOSIONS(3),
/* 22 */   PROTECTION_PROJECTILE(4),
/* 23 */   OXYGEN(5),
/* 24 */   WATER_WORKER(6),
/* 25 */   THORNS(7),
/* 26 */   DEPTH_STRIDER(8),
/* 27 */   DAMAGE_ALL(16),
/* 28 */   DAMAGE_UNDEAD(17),
/* 29 */   DAMAGE_ARTHROPODS(18),
/* 30 */   KNOCKBACK(19),
/* 31 */   FIRE_ASPECT(20),
/* 32 */   LOOT_BONUS_MOBS(21),
/* 33 */   DIG_SPEED(32),
/* 34 */   SILK_TOUCH(33),
/* 35 */   DURABILITY(34),
/* 36 */   LOOT_BONUS_BLOCKS(35),
/* 37 */   ARROW_DAMAGE(48),
/* 38 */   ARROW_KNOCKBACK(49),
/* 39 */   ARROW_FIRE(50),
/* 40 */   ARROW_INFINITE(51),
/* 41 */   LUCK(61),
/* 42 */   LURE(62); private static final PolarEnchantment[] CACHE;
/*    */   @Deprecated
/*    */   public int getId() {
/* 45 */     return this.id; } public String getLegacyName() {
/* 46 */     return this.legacyName;
/*    */   } static {
/* 48 */     CACHE = values();
/*    */   }
/*    */   @Nullable
/*    */   public static PolarEnchantment fromId(int id) {
/* 52 */     for (PolarEnchantment type : CACHE) {
/* 53 */       if (type.getId() == id) {
/* 54 */         return type;
/*    */       }
/*    */     } 
/* 57 */     return null;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static PolarEnchantment fromName(String name) {
/* 62 */     for (PolarEnchantment type : CACHE) {
/* 63 */       if (name.equalsIgnoreCase(type.name()) || name.equalsIgnoreCase(type.legacyName)) {
/* 64 */         return type;
/*    */       }
/*    */     } 
/*    */     
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\sub\PolarEnchantment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */