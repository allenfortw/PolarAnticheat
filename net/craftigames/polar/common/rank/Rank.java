/*    */ package net.craftigames.polar.common.rank;
/*    */ public enum Rank { Rank(int id, int weight, String name, String color, String displayname, String nameTag, String tabName, double coinMultiplier, String permission, String prettyName) { this.id = id;
/*    */     this.weight = weight;
/*    */     this.name = name;
/*    */     this.color = color;
/*    */     this.displayname = displayname;
/*    */     this.nameTag = nameTag;
/*    */     this.tabName = tabName;
/*    */     this.coinMultiplier = coinMultiplier;
/*    */     this.permission = permission;
/* 11 */     this.prettyName = prettyName; } public static final Rank[] CACHE; private int id; RANK_0(0, 999, "Player", "&7", "&7", "&7", "&7", 0.0D, "donator.rank0"),
/* 12 */   RANK_1(1, 918, "Iron", "&f", "&8[&fIron&8]&f ", "&fIron &f", "&fIron &f", 1.5D, "donator.rank1"),
/* 13 */   RANK_2(2, 917, "Gold", "&e", "&8[&eGold&8]&e ", "&eGold &f", "&eGold &f", 2.0D, "donator.rank2"),
/* 14 */   RANK_3(3, 916, "Diamond", "&b", "&8[&bDiamond&8]&b ", "&bDiamond &f", "&bDiamond &f", 3.0D, "donator.rank3"),
/* 15 */   RANK_4(4, 915, "Crystal", "&d&l", "&5&ki&8[&d&lCrystal&8]&5&ki&d ", "&d&lCrystal &f", "&d&lCrystal &f", 3.0D, "donator.rank4"); private int weight; private String name; private String color; private String displayname; private String nameTag; private String tabName; private final double coinMultiplier; private final String permission; private String prettyName;
/*    */   static {
/* 17 */     CACHE = values(); }
/* 18 */   public int getId() { return this.id; } public int getWeight() { return this.weight; } public void setId(int id) { this.id = id; } public void setWeight(int weight) { this.weight = weight; }
/* 19 */   public String getName() { return this.name; } public String getColor() { return this.color; } public String getDisplayname() { return this.displayname; } public String getNameTag() { return this.nameTag; } public String getTabName() { return this.tabName; } public void setName(String name) { this.name = name; } public void setColor(String color) { this.color = color; } public void setDisplayname(String displayname) { this.displayname = displayname; } public void setNameTag(String nameTag) { this.nameTag = nameTag; } public void setTabName(String tabName) { this.tabName = tabName; }
/* 20 */   public double getCoinMultiplier() { return this.coinMultiplier; }
/* 21 */   public String getPermission() { return this.permission; }
/* 22 */   public String getPrettyName() { return this.prettyName; } public void setPrettyName(String prettyName) { this.prettyName = prettyName; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Rank fromId(int rank) {
/* 29 */     for (Rank r : CACHE) {
/* 30 */       if (r.getId() == rank) {
/* 31 */         return r;
/*    */       }
/*    */     } 
/*    */     
/* 35 */     if (rank > RANK_4.getId()) {
/* 36 */       return RANK_4;
/*    */     }
/* 38 */     return RANK_0;
/*    */   }
/*    */   
/*    */   public boolean isAtLeast(Rank rank) {
/* 42 */     return (this.id >= rank.id);
/*    */   }
/*    */   
/*    */   public static Rank getRankFromPermission(RankMember member) {
/* 46 */     Rank userRank = RANK_0;
/* 47 */     for (Rank rank : CACHE) {
/* 48 */       if (rank.getId() > 0 && 
/* 49 */         userRank.getId() < rank.getId()) {
/* 50 */         userRank = rank;
/*    */       }
/*    */     } 
/*    */     
/* 54 */     return userRank;
/*    */   } }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\rank\Rank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */