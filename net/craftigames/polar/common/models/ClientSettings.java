/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class ClientSettings implements GsonSerializable {
/*    */   private String locale;
/*    */   private byte viewDistance;
/*    */   private int chatVisibility;
/*    */   
/*    */   public void setLocale(String locale) {
/* 15 */     this.locale = locale; } private boolean chatColors; private int mainHand; private boolean chatFilteringEnabled; private boolean clientListingAllowed; public void setViewDistance(byte viewDistance) { this.viewDistance = viewDistance; } public void setChatVisibility(int chatVisibility) { this.chatVisibility = chatVisibility; } public void setChatColors(boolean chatColors) { this.chatColors = chatColors; } public void setMainHand(int mainHand) { this.mainHand = mainHand; } public void setChatFilteringEnabled(boolean chatFilteringEnabled) { this.chatFilteringEnabled = chatFilteringEnabled; } public void setClientListingAllowed(boolean clientListingAllowed) { this.clientListingAllowed = clientListingAllowed; }
/*    */    public ClientSettings() {} public ClientSettings(String locale, byte viewDistance, int chatVisibility, boolean chatColors, int mainHand, boolean chatFilteringEnabled, boolean clientListingAllowed) {
/* 17 */     this.locale = locale; this.viewDistance = viewDistance; this.chatVisibility = chatVisibility; this.chatColors = chatColors; this.mainHand = mainHand; this.chatFilteringEnabled = chatFilteringEnabled; this.clientListingAllowed = clientListingAllowed;
/*    */   }
/*    */   
/* 20 */   public String getLocale() { return this.locale; }
/* 21 */   public byte getViewDistance() { return this.viewDistance; }
/* 22 */   public int getChatVisibility() { return this.chatVisibility; }
/* 23 */   public boolean isChatColors() { return this.chatColors; }
/* 24 */   public int getMainHand() { return this.mainHand; }
/* 25 */   public boolean isChatFilteringEnabled() { return this.chatFilteringEnabled; } public boolean isClientListingAllowed() {
/* 26 */     return this.clientListingAllowed;
/*    */   }
/*    */   public static ClientSettings deserialize(JsonElement element) {
/* 29 */     if (element.isJsonNull()) {
/* 30 */       return null;
/*    */     }
/*    */     
/* 33 */     JsonObject object = element.getAsJsonObject();
/* 34 */     ClientSettings result = new ClientSettings();
/* 35 */     result.setLocale(object.get("locale").getAsString());
/* 36 */     result.setViewDistance(object.get("viewDistance").getAsByte());
/* 37 */     result.setChatColors(object.get("chatColors").getAsBoolean());
/* 38 */     result.setChatVisibility(object.get("chatVisibility").getAsInt());
/* 39 */     result.setMainHand(object.get("mainHand").getAsInt());
/* 40 */     result.setChatFilteringEnabled(object.get("chatFilteringEnabled").getAsBoolean());
/* 41 */     result.setClientListingAllowed(object.get("clientListingAllowed").getAsBoolean());
/*    */     
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 49 */     return (JsonElement)JsonBuilder.object()
/* 50 */       .add("locale", this.locale)
/* 51 */       .add("viewDistance", Byte.valueOf(this.viewDistance))
/* 52 */       .add("chatColors", Boolean.valueOf(this.chatColors))
/* 53 */       .add("chatVisibility", Integer.valueOf(this.chatVisibility))
/* 54 */       .add("mainHand", Integer.valueOf(this.mainHand))
/* 55 */       .add("chatFilteringEnabled", Boolean.valueOf(this.chatFilteringEnabled))
/* 56 */       .add("clientListingAllowed", Boolean.valueOf(this.clientListingAllowed))
/* 57 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ClientSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */