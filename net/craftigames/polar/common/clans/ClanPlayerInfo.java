/*    */ package net.craftigames.polar.common.clans;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClanPlayerInfo
/*    */   implements GsonSerializable
/*    */ {
/*    */   public void setName(String name) {
/* 16 */     this.name = name; } public void setClanId(int clanId) { this.clanId = clanId; } public void setCoinMultiplier(float coinMultiplier) { this.coinMultiplier = coinMultiplier; } public void setExpMultiplier(float expMultiplier) { this.expMultiplier = expMultiplier; } public void setLootboxMultiplier(float lootboxMultiplier) { this.lootboxMultiplier = lootboxMultiplier; } public void setPlayingRanked(boolean playingRanked) { this.playingRanked = playingRanked; } public void setTrophies(int trophies) { this.trophies = trophies; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ClanPlayerInfo)) return false;  ClanPlayerInfo other = (ClanPlayerInfo)o; if (!other.canEqual(this)) return false;  if (getClanId() != other.getClanId()) return false;  if (Float.compare(getCoinMultiplier(), other.getCoinMultiplier()) != 0) return false;  if (Float.compare(getExpMultiplier(), other.getExpMultiplier()) != 0) return false;  if (Float.compare(getLootboxMultiplier(), other.getLootboxMultiplier()) != 0) return false;  if (isPlayingRanked() != other.isPlayingRanked()) return false;  if (getTrophies() != other.getTrophies()) return false;  Object this$name = getName(), other$name = other.getName(); return !((this$name == null) ? (other$name != null) : !this$name.equals(other$name)); } protected boolean canEqual(Object other) { return other instanceof ClanPlayerInfo; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getClanId(); result = result * 59 + Float.floatToIntBits(getCoinMultiplier()); result = result * 59 + Float.floatToIntBits(getExpMultiplier()); result = result * 59 + Float.floatToIntBits(getLootboxMultiplier()); result = result * 59 + (isPlayingRanked() ? 79 : 97); result = result * 59 + getTrophies(); Object $name = getName(); return result * 59 + (($name == null) ? 43 : $name.hashCode()); } public String toString() { return "ClanPlayerInfo(name=" + getName() + ", clanId=" + getClanId() + ", coinMultiplier=" + getCoinMultiplier() + ", expMultiplier=" + getExpMultiplier() + ", lootboxMultiplier=" + getLootboxMultiplier() + ", playingRanked=" + isPlayingRanked() + ", trophies=" + getTrophies() + ")"; } public ClanPlayerInfo(String name, int clanId, float coinMultiplier, float expMultiplier, float lootboxMultiplier, boolean playingRanked, int trophies) {
/* 17 */     this.name = name; this.clanId = clanId; this.coinMultiplier = coinMultiplier; this.expMultiplier = expMultiplier; this.lootboxMultiplier = lootboxMultiplier; this.playingRanked = playingRanked; this.trophies = trophies;
/*    */   }
/*    */ 
/*    */   
/* 21 */   private String name = ""; public String getName() { return this.name; }
/* 22 */    private int clanId = -1; public int getClanId() { return this.clanId; }
/* 23 */    private float coinMultiplier = 1.0F; public float getCoinMultiplier() { return this.coinMultiplier; }
/* 24 */    private float expMultiplier = 1.0F; public float getExpMultiplier() { return this.expMultiplier; }
/* 25 */    private float lootboxMultiplier = 1.0F; public float getLootboxMultiplier() { return this.lootboxMultiplier; } public boolean isPlayingRanked() {
/* 26 */     return this.playingRanked;
/* 27 */   } private boolean playingRanked = false; private int trophies = 0; public int getTrophies() { return this.trophies; }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 32 */     JsonObject object = new JsonObject();
/* 33 */     object.addProperty("name", this.name);
/* 34 */     object.addProperty("clan", Integer.valueOf(this.clanId));
/* 35 */     object.addProperty("coinMultiplier", Float.valueOf(this.coinMultiplier));
/* 36 */     object.addProperty("expMultiplier", Float.valueOf(this.lootboxMultiplier));
/* 37 */     object.addProperty("lootboxMultiplier", Float.valueOf(this.lootboxMultiplier));
/* 38 */     object.addProperty("playingRanked", Boolean.valueOf(this.playingRanked));
/* 39 */     object.addProperty("trophies", Integer.valueOf(this.trophies));
/* 40 */     return (JsonElement)object;
/*    */   }
/*    */   
/*    */   public static ClanPlayerInfo deserialize(JsonElement element) {
/* 44 */     if (element.isJsonObject()) {
/* 45 */       JsonObject object = element.getAsJsonObject();
/* 46 */       return new ClanPlayerInfo(object
/* 47 */           .get("name").getAsString(), object
/* 48 */           .get("clan").getAsInt(), object
/* 49 */           .get("coinMultiplier").getAsFloat(), object
/* 50 */           .get("expMultiplier").getAsFloat(), object
/* 51 */           .get("lootboxMultiplier").getAsFloat(), object
/* 52 */           .get("playingRanked").getAsBoolean(), (
/* 53 */           (Integer)GsonSerializable.getOrDefault(object, "trophies", JsonElement::getAsInt, Integer.valueOf(0))).intValue());
/*    */     } 
/*    */     
/* 56 */     return new ClanPlayerInfo();
/*    */   }
/*    */   
/*    */   public ClanPlayerInfo() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\clans\ClanPlayerInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */