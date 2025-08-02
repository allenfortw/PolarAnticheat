/*    */ package net.craftigames.polar.common.util.xseries;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public enum XPolarEnchantment {
/*    */   public static final XPolarEnchantment[] CACHE;
/*    */   private final String[] legacyNames;
/*  7 */   ARROW_DAMAGE(new String[] { "POWER", "ARROW_DAMAGE", "ARROW_POWER", "AD" }),
/*  8 */   ARROW_FIRE(new String[] { "FLAME", "FLAME_ARROW", "FIRE_ARROW", "AF" }),
/*  9 */   ARROW_INFINITE(new String[] { "INFINITY", "INF_ARROWS", "INFINITE_ARROWS", "INFINITE", "UNLIMITED", "UNLIMITED_ARROWS", "AI" }),
/* 10 */   ARROW_KNOCKBACK(new String[] { "PUNCH", "ARROW_KNOCKBACK", "ARROWKB", "ARROW_PUNCH", "AK" }),
/* 11 */   BINDING_CURSE(true, new String[] { "BINDING_CURSE", "BIND_CURSE", "BINDING", "BIND" }),
/* 12 */   CHANNELING(true, new String[] { "CHANNELLING", "CHANELLING", "CHANELING", "CHANNEL" }),
/* 13 */   DAMAGE_ALL(new String[] { "SHARPNESS", "ALL_DAMAGE", "ALL_DMG", "SHARP", "DAL" }),
/* 14 */   DAMAGE_ARTHROPODS(new String[] { "BANE_OF_ARTHROPODS", "ARDMG", "BANE_OF_ARTHROPOD", "ARTHROPOD", "DAR" }),
/* 15 */   DAMAGE_UNDEAD(new String[] { "SMITE", "UNDEAD_DAMAGE", "DU" }),
/* 16 */   DEPTH_STRIDER(true, new String[] { "DEPTH", "STRIDER" }),
/* 17 */   DIG_SPEED(new String[] { "EFFICIENCY", "MINE_SPEED", "CUT_SPEED", "DS", "EFF" }),
/* 18 */   DURABILITY(new String[] { "UNBREAKING", "DURA" }),
/* 19 */   FIRE_ASPECT(true, new String[] { "FIRE", "MELEE_FIRE", "MELEE_FLAME", "FA" }),
/* 20 */   FROST_WALKER(true, new String[] { "FROST", "WALKER" }),
/* 21 */   IMPALING(true, new String[] { "IMPALE", "OCEAN_DAMAGE", "OCEAN_DMG" }),
/* 22 */   KNOCKBACK(true, new String[] { "K_BACK", "KB" }),
/* 23 */   LOOT_BONUS_BLOCKS(new String[] { "FORTUNE", "BLOCKS_LOOT_BONUS", "FORT", "LBB" }),
/* 24 */   LOOT_BONUS_MOBS(new String[] { "LOOTING", "MOB_LOOT", "MOBS_LOOT_BONUS", "LBM" }),
/* 25 */   LOYALTY(true, new String[] { "LOYAL", "RETURN" }),
/* 26 */   LUCK(new String[] { "LUCK_OF_THE_SEA", "LUCK_OF_SEA", "LUCK_OF_SEAS", "ROD_LUCK" }),
/* 27 */   LURE(true, new String[] { "ROD_LURE" }),
/* 28 */   MENDING(true, new String[0]),
/* 29 */   MULTISHOT(true, new String[] { "TRIPLE_SHOT" }),
/* 30 */   OXYGEN(new String[] { "RESPIRATION", "BREATH", "BREATHING", "O2", "O" }),
/* 31 */   PIERCING(true, new String[0]),
/* 32 */   PROTECTION_ENVIRONMENTAL(new String[] { "PROTECTION", "PROTECT", "PROT" }),
/* 33 */   PROTECTION_EXPLOSIONS(new String[] { "BLAST_PROTECTION", "BLAST_PROTECT", "EXPLOSIONS_PROTECTION", "EXPLOSION_PROTECTION", "BLAST_PROTECTION", "PE" }),
/* 34 */   PROTECTION_FALL(new String[] { "FEATHER_FALLING", "FALL_PROT", "FEATHER_FALL", "FALL_PROTECTION", "FEATHER_FALLING", "PFA" }),
/* 35 */   PROTECTION_FIRE(new String[] { "FIRE_PROTECTION", "FIRE_PROT", "FIRE_PROTECT", "FIRE_PROTECTION", "FLAME_PROTECTION", "FLAME_PROTECT", "FLAME_PROT", "PF" }),
/* 36 */   PROTECTION_PROJECTILE(new String[] { "PROJECTILE_PROTECTION", "PROJECTILE_PROTECTION", "PROJ_PROT", "PP" }),
/* 37 */   QUICK_CHARGE(true, new String[] { "QUICKCHARGE", "QUICK_DRAW", "FAST_CHARGE", "FAST_DRAW" }),
/* 38 */   RIPTIDE(true, new String[] { "RIP", "TIDE", "LAUNCH" }),
/* 39 */   SILK_TOUCH(true, new String[] { "SOFT_TOUCH", "ST" }),
/* 40 */   SOUL_SPEED(true, new String[] { "SPEED_SOUL", "SOUL_RUNNER" }),
/* 41 */   SWEEPING_EDGE(new String[] { "SWEEPING", "SWEEPING_EDGE", "SWEEP_EDGE" }),
/* 42 */   SWIFT_SNEAK(true, new String[] { "SNEAK_SWIFT" }),
/* 43 */   THORNS(true, new String[] { "HIGHCRIT", "THORN", "HIGHERCRIT", "T" }),
/* 44 */   VANISHING_CURSE(true, new String[] { "VANISHING_CURSE", "VANISH_CURSE", "VANISHING", "VANISH" }),
/* 45 */   WATER_WORKER(new String[] { "AQUA_AFFINITY", "WATER_WORKER", "AQUA_AFFINITY", "WATER_MINE", "WW" });
/*    */   static {
/* 47 */     CACHE = values();
/*    */   } private final boolean value;
/*    */   public boolean isValue() {
/* 50 */     return this.value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   XPolarEnchantment(boolean value, String... legacyNames) {
/* 58 */     this.legacyNames = legacyNames;
/* 59 */     this.value = value;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static XPolarEnchantment fromName(String name) {
/*    */     try {
/* 65 */       return valueOf(name);
/* 66 */     } catch (IllegalArgumentException e) {
/* 67 */       for (XPolarEnchantment potion : CACHE) {
/* 68 */         for (String legacyName : potion.legacyNames) {
/* 69 */           if (name.equalsIgnoreCase(legacyName)) {
/* 70 */             return potion;
/*    */           }
/*    */         } 
/*    */       } 
/*    */       
/* 75 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\xseries\XPolarEnchantment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */