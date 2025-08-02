/*     */ package net.craftigames.polar.common.guilds;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ 
/*     */ public class GuildPlayerInfo
/*     */   implements GsonSerializable
/*     */ {
/*     */   public void setName(String name) {
/*  12 */     this.name = name; } public void setGuildId(int guildId) { this.guildId = guildId; } public void setDoubleCoinChance(float doubleCoinChance) { this.doubleCoinChance = doubleCoinChance; } public void setDoubleExpChance(float doubleExpChance) { this.doubleExpChance = doubleExpChance; } public void setDoubleVoteChance(float doubleVoteChance) { this.doubleVoteChance = doubleVoteChance; } public void setCoinMultiplier(float coinMultiplier) { this.coinMultiplier = coinMultiplier; } public void setExpMultiplier(float expMultiplier) { this.expMultiplier = expMultiplier; } public void setExtraGuildCoinsChance(float extraGuildCoinsChance) { this.extraGuildCoinsChance = extraGuildCoinsChance; } public void setGuildExpMultiplier(float guildExpMultiplier) { this.guildExpMultiplier = guildExpMultiplier; } public void setLootboxMultiplier(float lootboxMultiplier) { this.lootboxMultiplier = lootboxMultiplier; } public void setRareLootboxChance(float rareLootboxChance) { this.rareLootboxChance = rareLootboxChance; } public void setGuildCosmeticChance(float guildCosmeticChance) { this.guildCosmeticChance = guildCosmeticChance; } public void setNormalCosmeticChance(float normalCosmeticChance) { this.normalCosmeticChance = normalCosmeticChance; } public void setBoxInBoxChance(float boxInBoxChance) { this.boxInBoxChance = boxInBoxChance; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GuildPlayerInfo)) return false;  GuildPlayerInfo other = (GuildPlayerInfo)o; if (!other.canEqual(this)) return false;  if (getGuildId() != other.getGuildId()) return false;  if (Float.compare(getDoubleCoinChance(), other.getDoubleCoinChance()) != 0) return false;  if (Float.compare(getDoubleExpChance(), other.getDoubleExpChance()) != 0) return false;  if (Float.compare(getDoubleVoteChance(), other.getDoubleVoteChance()) != 0) return false;  if (Float.compare(getCoinMultiplier(), other.getCoinMultiplier()) != 0) return false;  if (Float.compare(getExpMultiplier(), other.getExpMultiplier()) != 0) return false;  if (Float.compare(getExtraGuildCoinsChance(), other.getExtraGuildCoinsChance()) != 0) return false;  if (Float.compare(getGuildExpMultiplier(), other.getGuildExpMultiplier()) != 0) return false;  if (Float.compare(getLootboxMultiplier(), other.getLootboxMultiplier()) != 0) return false;  if (Float.compare(getRareLootboxChance(), other.getRareLootboxChance()) != 0) return false;  if (Float.compare(getGuildCosmeticChance(), other.getGuildCosmeticChance()) != 0) return false;  if (Float.compare(getNormalCosmeticChance(), other.getNormalCosmeticChance()) != 0) return false;  if (Float.compare(getBoxInBoxChance(), other.getBoxInBoxChance()) != 0) return false;  Object this$name = getName(), other$name = other.getName(); return !((this$name == null) ? (other$name != null) : !this$name.equals(other$name)); } protected boolean canEqual(Object other) { return other instanceof GuildPlayerInfo; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getGuildId(); result = result * 59 + Float.floatToIntBits(getDoubleCoinChance()); result = result * 59 + Float.floatToIntBits(getDoubleExpChance()); result = result * 59 + Float.floatToIntBits(getDoubleVoteChance()); result = result * 59 + Float.floatToIntBits(getCoinMultiplier()); result = result * 59 + Float.floatToIntBits(getExpMultiplier()); result = result * 59 + Float.floatToIntBits(getExtraGuildCoinsChance()); result = result * 59 + Float.floatToIntBits(getGuildExpMultiplier()); result = result * 59 + Float.floatToIntBits(getLootboxMultiplier()); result = result * 59 + Float.floatToIntBits(getRareLootboxChance()); result = result * 59 + Float.floatToIntBits(getGuildCosmeticChance()); result = result * 59 + Float.floatToIntBits(getNormalCosmeticChance()); result = result * 59 + Float.floatToIntBits(getBoxInBoxChance()); Object $name = getName(); return result * 59 + (($name == null) ? 43 : $name.hashCode()); } public String toString() { return "GuildPlayerInfo(name=" + getName() + ", guildId=" + getGuildId() + ", doubleCoinChance=" + getDoubleCoinChance() + ", doubleExpChance=" + getDoubleExpChance() + ", doubleVoteChance=" + getDoubleVoteChance() + ", coinMultiplier=" + getCoinMultiplier() + ", expMultiplier=" + getExpMultiplier() + ", extraGuildCoinsChance=" + getExtraGuildCoinsChance() + ", guildExpMultiplier=" + getGuildExpMultiplier() + ", lootboxMultiplier=" + getLootboxMultiplier() + ", rareLootboxChance=" + getRareLootboxChance() + ", guildCosmeticChance=" + getGuildCosmeticChance() + ", normalCosmeticChance=" + getNormalCosmeticChance() + ", boxInBoxChance=" + getBoxInBoxChance() + ")"; } public GuildPlayerInfo(String name, int guildId, float doubleCoinChance, float doubleExpChance, float doubleVoteChance, float coinMultiplier, float expMultiplier, float extraGuildCoinsChance, float guildExpMultiplier, float lootboxMultiplier, float rareLootboxChance, float guildCosmeticChance, float normalCosmeticChance, float boxInBoxChance) {
/*  13 */     this.name = name; this.guildId = guildId; this.doubleCoinChance = doubleCoinChance; this.doubleExpChance = doubleExpChance; this.doubleVoteChance = doubleVoteChance; this.coinMultiplier = coinMultiplier; this.expMultiplier = expMultiplier; this.extraGuildCoinsChance = extraGuildCoinsChance; this.guildExpMultiplier = guildExpMultiplier; this.lootboxMultiplier = lootboxMultiplier; this.rareLootboxChance = rareLootboxChance; this.guildCosmeticChance = guildCosmeticChance; this.normalCosmeticChance = normalCosmeticChance; this.boxInBoxChance = boxInBoxChance;
/*     */   }
/*     */ 
/*     */   
/*  17 */   private String name = ""; public String getName() { return this.name; }
/*  18 */    private int guildId = -1; public int getGuildId() { return this.guildId; }
/*     */ 
/*     */ 
/*     */   
/*  22 */   private float doubleCoinChance = 0.0F; public float getDoubleCoinChance() { return this.doubleCoinChance; }
/*     */ 
/*     */ 
/*     */   
/*  26 */   private float doubleExpChance = 0.0F; public float getDoubleExpChance() { return this.doubleExpChance; }
/*     */ 
/*     */ 
/*     */   
/*  30 */   private float doubleVoteChance = 0.0F; public float getDoubleVoteChance() { return this.doubleVoteChance; }
/*     */ 
/*     */ 
/*     */   
/*  34 */   private float coinMultiplier = 1.0F; public float getCoinMultiplier() { return this.coinMultiplier; }
/*     */ 
/*     */ 
/*     */   
/*  38 */   private float expMultiplier = 1.0F; public float getExpMultiplier() { return this.expMultiplier; }
/*     */ 
/*     */ 
/*     */   
/*  42 */   private float extraGuildCoinsChance = 0.0F; public float getExtraGuildCoinsChance() { return this.extraGuildCoinsChance; }
/*     */ 
/*     */ 
/*     */   
/*  46 */   private float guildExpMultiplier = 1.0F; public float getGuildExpMultiplier() { return this.guildExpMultiplier; }
/*     */ 
/*     */ 
/*     */   
/*  50 */   private float lootboxMultiplier = 1.0F; public float getLootboxMultiplier() { return this.lootboxMultiplier; }
/*     */ 
/*     */ 
/*     */   
/*  54 */   private float rareLootboxChance = 0.0F; public float getRareLootboxChance() { return this.rareLootboxChance; }
/*     */ 
/*     */ 
/*     */   
/*  58 */   private float guildCosmeticChance = 0.0F; public float getGuildCosmeticChance() { return this.guildCosmeticChance; }
/*     */ 
/*     */ 
/*     */   
/*  62 */   private float normalCosmeticChance = 0.0F; public float getNormalCosmeticChance() { return this.normalCosmeticChance; }
/*     */ 
/*     */ 
/*     */   
/*  66 */   private float boxInBoxChance = 0.0F; public float getBoxInBoxChance() { return this.boxInBoxChance; }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonElement serialize() {
/*  71 */     JsonObject object = new JsonObject();
/*  72 */     object.addProperty("name", this.name);
/*  73 */     object.addProperty("guild", Integer.valueOf(this.guildId));
/*  74 */     object.addProperty("doubleCoin", Float.valueOf(this.doubleCoinChance));
/*  75 */     object.addProperty("doubleExp", Float.valueOf(this.doubleExpChance));
/*  76 */     object.addProperty("doubleVote", Float.valueOf(this.doubleVoteChance));
/*  77 */     object.addProperty("coinMultiplier", Float.valueOf(this.coinMultiplier));
/*  78 */     object.addProperty("expMultiplier", Float.valueOf(this.expMultiplier));
/*  79 */     object.addProperty("guildCoins500", Float.valueOf(this.extraGuildCoinsChance));
/*  80 */     object.addProperty("guildExpMultiplier", Float.valueOf(this.guildExpMultiplier));
/*  81 */     object.addProperty("lootboxMultiplier", Float.valueOf(this.lootboxMultiplier));
/*  82 */     object.addProperty("rareLootbox", Float.valueOf(this.rareLootboxChance));
/*  83 */     object.addProperty("guildCosmetic", Float.valueOf(this.guildCosmeticChance));
/*  84 */     object.addProperty("normalCosmetic", Float.valueOf(this.normalCosmeticChance));
/*  85 */     object.addProperty("boxInBox", Float.valueOf(this.boxInBoxChance));
/*  86 */     return (JsonElement)object;
/*     */   }
/*     */   
/*     */   public static GuildPlayerInfo deserialize(JsonElement element) {
/*     */     try {
/*  91 */       JsonObject object = element.getAsJsonObject();
/*  92 */       return new GuildPlayerInfo(object
/*  93 */           .get("name").getAsString(), object
/*  94 */           .get("guild").getAsInt(), object
/*  95 */           .get("doubleCoin").getAsFloat(), object
/*  96 */           .get("doubleExp").getAsFloat(), object
/*  97 */           .get("doubleVote").getAsFloat(), object
/*  98 */           .get("coinMultiplier").getAsFloat(), object
/*  99 */           .get("expMultiplier").getAsFloat(), object
/* 100 */           .get("guildCoins500").getAsFloat(), object
/* 101 */           .get("guildExpMultiplier").getAsFloat(), object
/* 102 */           .get("lootboxMultiplier").getAsFloat(), object
/* 103 */           .get("rareLootbox").getAsFloat(), object
/* 104 */           .get("guildCosmetic").getAsFloat(), object
/* 105 */           .get("normalCosmetic").getAsFloat(), object
/* 106 */           .get("boxInBox").getAsFloat());
/*     */     }
/* 108 */     catch (Exception ignored) {
/* 109 */       return new GuildPlayerInfo();
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuildPlayerInfo() {}
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\guilds\GuildPlayerInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */