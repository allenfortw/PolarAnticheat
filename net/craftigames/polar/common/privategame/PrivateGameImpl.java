/*    */ package net.craftigames.polar.common.privategame;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nonnull;
/*    */ 
/*    */ public class PrivateGameImpl
/*    */   implements PrivateGame {
/*    */   protected final UUID owner;
/*    */   protected final String serverType;
/*    */   protected final String mapName;
/*    */   
/*    */   public void setBungeeName(String bungeeName) {
/* 15 */     this.bungeeName = bungeeName; } public void setAllowSpectators(boolean allowSpectators) { this.allowSpectators = allowSpectators; } public void setBooted(boolean booted) { this.booted = booted; }
/*    */ 
/*    */   
/* 18 */   public UUID getOwner() { return this.owner; }
/* 19 */   public String getServerType() { return this.serverType; } public String getMapName() {
/* 20 */     return this.mapName;
/* 21 */   } protected String bungeeName = "-"; protected boolean allowSpectators = true; public String getBungeeName() { return this.bungeeName; }
/* 22 */   public boolean isAllowSpectators() { return this.allowSpectators; } public boolean isBooted() {
/* 23 */     return this.booted;
/*    */   } protected boolean booted = false;
/*    */   public PrivateGameImpl(UUID owner, String serverType, String mapName, String bungeeName) {
/* 26 */     this.owner = owner;
/* 27 */     this.serverType = serverType;
/* 28 */     this.mapName = mapName;
/* 29 */     this.bungeeName = bungeeName;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 35 */     JsonObject obj = new JsonObject();
/*    */     
/* 37 */     obj.addProperty("owner", this.owner.toString());
/* 38 */     obj.addProperty("serverType", this.serverType);
/* 39 */     obj.addProperty("mapName", this.mapName);
/* 40 */     obj.addProperty("bungee_name", this.bungeeName);
/* 41 */     obj.addProperty("booted", Boolean.valueOf(this.booted));
/* 42 */     obj.addProperty("allowSpectators", Boolean.valueOf(this.allowSpectators));
/*    */     
/* 44 */     return (JsonElement)obj;
/*    */   }
/*    */   
/*    */   public static PrivateGameImpl deserialize(JsonElement element) {
/* 48 */     if (element.isJsonNull()) {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     JsonObject object = element.getAsJsonObject();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 58 */     PrivateGameImpl game = new PrivateGameImpl(UUID.fromString(object.get("owner").getAsString()), object.get("serverType").getAsString(), object.get("mapName").getAsString(), object.get("bungee_name").getAsString());
/*    */     
/* 60 */     game.setBooted(object.get("booted").getAsBoolean());
/*    */     
/* 62 */     if (object.has("allowSpectators")) {
/* 63 */       game.setAllowSpectators(object.get("allowSpectators").getAsBoolean());
/*    */     }
/*    */     
/* 66 */     return game;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\privategame\PrivateGameImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */