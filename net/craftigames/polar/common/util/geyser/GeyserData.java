/*    */ package net.craftigames.polar.common.util.geyser;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class GeyserData implements GsonSerializable {
/*    */   private DeviceOs deviceOs;
/*    */   private String langCode;
/*    */   private String xuid;
/*    */   
/*    */   public GeyserData() {}
/*    */   
/*    */   public GeyserData(DeviceOs deviceOs, String langCode, String xuid) {
/* 17 */     this.deviceOs = deviceOs; this.langCode = langCode; this.xuid = xuid;
/*    */   } public void setDeviceOs(DeviceOs deviceOs) {
/* 19 */     this.deviceOs = deviceOs; } public void setLangCode(String langCode) { this.langCode = langCode; } public void setXuid(String xuid) { this.xuid = xuid; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof GeyserData)) return false;  GeyserData other = (GeyserData)o; if (!other.canEqual(this)) return false;  Object this$deviceOs = getDeviceOs(), other$deviceOs = other.getDeviceOs(); if ((this$deviceOs == null) ? (other$deviceOs != null) : !this$deviceOs.equals(other$deviceOs)) return false;  Object this$langCode = getLangCode(), other$langCode = other.getLangCode(); if ((this$langCode == null) ? (other$langCode != null) : !this$langCode.equals(other$langCode)) return false;  Object this$xuid = getXuid(), other$xuid = other.getXuid(); return !((this$xuid == null) ? (other$xuid != null) : !this$xuid.equals(other$xuid)); } protected boolean canEqual(Object other) { return other instanceof GeyserData; } public int hashCode() { int PRIME = 59; result = 1; Object $deviceOs = getDeviceOs(); result = result * 59 + (($deviceOs == null) ? 43 : $deviceOs.hashCode()); Object $langCode = getLangCode(); result = result * 59 + (($langCode == null) ? 43 : $langCode.hashCode()); Object $xuid = getXuid(); return result * 59 + (($xuid == null) ? 43 : $xuid.hashCode()); } public String toString() { return "GeyserData(deviceOs=" + getDeviceOs() + ", langCode=" + getLangCode() + ", xuid=" + getXuid() + ")"; }
/*    */ 
/*    */   
/* 22 */   public DeviceOs getDeviceOs() { return this.deviceOs; }
/* 23 */   public String getLangCode() { return this.langCode; } public String getXuid() {
/* 24 */     return this.xuid;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public JsonElement serialize() {
/* 29 */     return (JsonElement)JsonBuilder.object()
/* 30 */       .add("deviceOs", Integer.valueOf(this.deviceOs.ordinal()))
/* 31 */       .add("langCode", this.langCode)
/* 32 */       .add("xuid", this.xuid)
/* 33 */       .build();
/*    */   }
/*    */   
/*    */   public static GeyserData deserialize(JsonElement element) {
/* 37 */     if (element.isJsonNull()) {
/* 38 */       return new GeyserData(DeviceOs.UNKNOWN, "en_us", "0");
/*    */     }
/* 40 */     JsonObject object = element.getAsJsonObject();
/* 41 */     return new GeyserData(
/* 42 */         DeviceOs.fromId(object.get("deviceOs").getAsInt()), object
/* 43 */         .get("langCode").getAsString(), object
/* 44 */         .get("xuid").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public static GeyserData deserialize(String string) {
/* 49 */     return deserialize(JsonParser.parseString(string));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\geyser\GeyserData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */