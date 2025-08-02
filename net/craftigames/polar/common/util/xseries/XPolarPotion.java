/*    */ package net.craftigames.polar.common.util.xseries;
/*    */ 
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public enum XPolarPotion
/*    */ {
/*    */   public static final XPolarPotion[] CACHE;
/*    */   private final String[] legacyNames;
/*    */   private final String displayName;
/* 10 */   ABSORPTION("Absorption", new String[] { "ABSORB" }),
/* 11 */   BAD_OMEN("Bad Omen", new String[] { "OMEN_BAD", "PILLAGER" }),
/* 12 */   BLINDNESS("Blindness", new String[] { "BLIND" }),
/* 13 */   CONDUIT_POWER("Conduit Power", new String[] { "CONDUIT", "POWER_CONDUIT" }),
/* 14 */   CONFUSION("Nausea", new String[] { "NAUSEA", "SICKNESS", "SICK" }),
/* 15 */   DAMAGE_RESISTANCE("Resistance", new String[] { "RESISTANCE", "ARMOR", "DMG_RESIST", "DMG_RESISTANCE" }),
/* 16 */   DARKNESS("Darkness", new String[0]),
/* 17 */   DOLPHINS_GRACE("Dolphin's Grace", new String[] { "DOLPHIN", "GRACE" }),
/* 18 */   FAST_DIGGING("Haste", new String[] { "HASTE", "SUPER_PICK", "DIGFAST", "DIG_SPEED", "QUICK_MINE", "SHARP" }),
/* 19 */   FIRE_RESISTANCE("Fire Resistance", new String[] { "FIRE_RESIST", "RESIST_FIRE", "FIRE_RESISTANCE" }),
/* 20 */   GLOWING("Glow", new String[] { "GLOW", "SHINE", "SHINY" }),
/* 21 */   HARM("Instant Damage", new String[] { "INJURE", "DAMAGE", "HARMING", "INFLICT", "INSTANT_DAMAGE" }),
/* 22 */   HEAL("Instant Health", new String[] { "HEALTH", "INSTA_HEAL", "INSTANT_HEAL", "INSTA_HEALTH", "INSTANT_HEALTH" }),
/* 23 */   HEALTH_BOOST("Health Boost", new String[] { "BOOST_HEALTH", "BOOST", "HP" }),
/* 24 */   HERO_OF_THE_VILLAGE("Hero Of The Village", new String[] { "HERO", "VILLAGE_HERO" }),
/* 25 */   HUNGER("Hunger", new String[] { "STARVE", "HUNGRY" }),
/* 26 */   INCREASE_DAMAGE("Strength", new String[] { "STRENGTH", "BULL", "STRONG", "ATTACK" }),
/* 27 */   INVISIBILITY("Invisibility", new String[] { "INVISIBLE", "VANISH", "INVIS", "DISAPPEAR", "HIDE" }),
/* 28 */   JUMP("Jump Boost", new String[] { "LEAP", "JUMP_BOOST" }),
/* 29 */   LEVITATION("Levitation", new String[] { "LEVITATE" }),
/* 30 */   LUCK("Luck", new String[] { "LUCKY" }),
/* 31 */   NIGHT_VISION("Night Vision", new String[] { "VISION", "VISION_NIGHT" }),
/* 32 */   POISON("Poison", new String[] { "VENOM" }),
/* 33 */   REGENERATION("Regeneration", new String[] { "REGEN" }),
/* 34 */   SATURATION("Saturation", new String[] { "FOOD" }),
/* 35 */   SLOW("Slowness", new String[] { "SLOWNESS", "SLUGGISH" }),
/* 36 */   SLOW_DIGGING("Mining Fatigue", new String[] { "FATIGUE", "DULL", "DIGGING", "SLOW_DIG", "DIG_SLOW" }),
/* 37 */   SLOW_FALLING("Slow Falling", new String[] { "SLOW_FALL", "FALL_SLOW" }),
/* 38 */   SPEED("Speed", new String[] { "SPRINT", "RUNFAST", "SWIFT", "FAST" }),
/* 39 */   UNLUCK("Unluck", new String[] { "UNLUCKY" }),
/* 40 */   WATER_BREATHING("Water Breathing", new String[] { "WATER_BREATH", "UNDERWATER_BREATHING", "UNDERWATER_BREATH", "AIR" }),
/* 41 */   WEAKNESS("Weakness", new String[] { "WEAK" }),
/* 42 */   WITHER("Wither", new String[] { "DECAY" });
/*    */   static {
/* 44 */     CACHE = values();
/*    */   } public String getDisplayName() {
/* 46 */     return this.displayName;
/*    */   }
/*    */   
/*    */   XPolarPotion(String displayName, String... legacyNames) {
/* 50 */     this.displayName = displayName;
/* 51 */     this.legacyNames = legacyNames;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public static XPolarPotion fromName(String name) {
/*    */     try {
/* 57 */       return valueOf(name);
/* 58 */     } catch (IllegalArgumentException e) {
/* 59 */       for (XPolarPotion potion : CACHE) {
/* 60 */         for (String legacyName : potion.legacyNames) {
/* 61 */           if (name.equalsIgnoreCase(legacyName)) {
/* 62 */             return potion;
/*    */           }
/*    */         } 
/*    */       } 
/*    */       
/* 67 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\xseries\XPolarPotion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */