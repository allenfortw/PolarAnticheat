/*    */ package net.craftigames.polar.common.util;
/*    */ import net.craftigames.polar.common.rank.Rank;
/*    */ 
/*    */ public enum ServerType {
/*    */   private final String name;
/*    */   private final String store;
/*    */   private final String site;
/*    */   private final String color;
/*    */   private final String color1;
/* 10 */   JARTEX("Jartex", "&e", "&e", "&6", "store.jartexnetwork.com", "jartexnetwork.com"),
/* 11 */   PIKA("Pika", "&c", "&e", "&c", "store.pika-network.net", "pika-network.net"),
/* 12 */   BRUTAL("Brutal", "&6", "&c", "&6", "store.brutalprison.com", "brutalprison.com"),
/* 13 */   SNAP("Snap", "&a", "&a", "&a", "store.snapcraft.net", "snapcraft.net"); private final String mainColor;
/*    */   
/*    */   public String getName() {
/* 16 */     return this.name; }
/* 17 */   public String getStore() { return this.store; } public String getSite() {
/* 18 */     return this.site;
/*    */   }
/* 20 */   public String getColor() { return this.color; } public String getColor1() {
/* 21 */     return this.color1;
/*    */   }
/*    */   public String getMainColor() {
/* 24 */     return this.mainColor;
/*    */   }
/*    */   ServerType(String name, String color, String color1, String mainColor, String store, String site) {
/* 27 */     this.name = name;
/* 28 */     this.color = color;
/* 29 */     this.color1 = color1;
/* 30 */     this.mainColor = mainColor;
/* 31 */     this.store = store;
/* 32 */     this.site = site;
/*    */   }
/*    */   
/*    */   public void init() {
/* 36 */     setupLayout();
/* 37 */     if (this == BRUTAL || this == SNAP) {
/* 38 */       Core.USE_UUIDS_FOR_USER_ID = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public String getPrefix() {
/* 43 */     if (this == SNAP) {
/* 44 */       return "&a&lSnapcraft";
/*    */     }
/* 46 */     return "&e&l" + getName() + getMainColor() + "&lNetwork";
/*    */   }
/*    */   
/*    */   public void setupLayout() {
/* 50 */     if (this != PIKA) {
/*    */       return;
/*    */     }
/*    */     
/* 54 */     Rank.RANK_1.setDisplayname("&8<&a&lVIP&8>&2 ");
/* 55 */     Rank.RANK_1.setName("VIP");
/* 56 */     Rank.RANK_1.setNameTag("&a&lVIP&2 ");
/* 57 */     Rank.RANK_1.setPrettyName("&a&lVIP&2 ");
/* 58 */     Rank.RANK_1.setTabName("&a&lVIP&2 ");
/* 59 */     Rank.RANK_1.setColor("&a");
/*    */     
/* 61 */     Rank.RANK_2.setDisplayname("&8<&b&lElite&8>&3 ");
/* 62 */     Rank.RANK_2.setName("Elite");
/* 63 */     Rank.RANK_2.setNameTag("&b&lElite&3 ");
/* 64 */     Rank.RANK_2.setPrettyName("&b&lElite&3 ");
/* 65 */     Rank.RANK_2.setTabName("&b&lElite&3 ");
/* 66 */     Rank.RANK_2.setColor("&b");
/*    */     
/* 68 */     Rank.RANK_3.setDisplayname("&8<&6&lTitan&8>&e ");
/* 69 */     Rank.RANK_3.setName("Titan");
/* 70 */     Rank.RANK_3.setPrettyName("&6&lTitan&e ");
/* 71 */     Rank.RANK_3.setNameTag("&6&lTitan&e ");
/* 72 */     Rank.RANK_3.setTabName("&6&lTitan&e ");
/* 73 */     Rank.RANK_3.setColor("&6");
/*    */     
/* 75 */     Rank.RANK_4.setDisplayname("&8<&4&lChampion&8>&c ");
/* 76 */     Rank.RANK_4.setName("Champion");
/* 77 */     Rank.RANK_4.setPrettyName("&4&lChampion&c ");
/* 78 */     Rank.RANK_4.setNameTag("&4&lChampion&c ");
/* 79 */     Rank.RANK_4.setTabName("&4&lChampion&c ");
/* 80 */     Rank.RANK_4.setColor("&4");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ServerType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */