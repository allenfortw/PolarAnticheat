/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public class ProxyMotd implements GsonSerializable {
/*    */   private String motd;
/*    */   private int slots;
/*    */   
/* 13 */   public void setMotd(String motd) { this.motd = motd; } @Nullable private String protocol; @Nullable private Integer online; public void setSlots(int slots) { this.slots = slots; } public void setProtocol(@Nullable String protocol) { this.protocol = protocol; } public void setOnline(@Nullable Integer online) { this.online = online; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ProxyMotd)) return false;  ProxyMotd other = (ProxyMotd)o; if (!other.canEqual(this)) return false;  if (getSlots() != other.getSlots()) return false;  Object this$online = getOnline(), other$online = other.getOnline(); if ((this$online == null) ? (other$online != null) : !this$online.equals(other$online)) return false;  Object this$motd = getMotd(), other$motd = other.getMotd(); if ((this$motd == null) ? (other$motd != null) : !this$motd.equals(other$motd)) return false;  Object this$protocol = getProtocol(), other$protocol = other.getProtocol(); return !((this$protocol == null) ? (other$protocol != null) : !this$protocol.equals(other$protocol)); } protected boolean canEqual(Object other) { return other instanceof ProxyMotd; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getSlots(); Object $online = getOnline(); result = result * 59 + (($online == null) ? 43 : $online.hashCode()); Object $motd = getMotd(); result = result * 59 + (($motd == null) ? 43 : $motd.hashCode()); Object $protocol = getProtocol(); return result * 59 + (($protocol == null) ? 43 : $protocol.hashCode()); } public String toString() { return "ProxyMotd(motd=" + getMotd() + ", slots=" + getSlots() + ", protocol=" + getProtocol() + ", online=" + getOnline() + ")"; }
/*    */   
/*    */   public ProxyMotd() {}
/*    */   
/* 17 */   public String getMotd() { return this.motd; }
/* 18 */   public int getSlots() { return this.slots; } @Nullable
/* 19 */   public String getProtocol() { return this.protocol; } @Nullable
/* 20 */   public Integer getOnline() { return this.online; }
/*    */   
/*    */   public ProxyMotd(String motd, int slots, @Nullable String protocol, @Nullable Integer online) {
/* 23 */     this.motd = motd;
/* 24 */     this.slots = slots;
/* 25 */     this.protocol = protocol;
/* 26 */     this.online = online;
/*    */   }
/*    */   
/*    */   public static ProxyMotd deserialize(JsonElement element) {
/* 30 */     if (element.isJsonNull()) {
/* 31 */       return null;
/*    */     }
/*    */     
/* 34 */     JsonObject object = element.getAsJsonObject();
/* 35 */     ProxyMotd result = new ProxyMotd();
/* 36 */     result.setMotd(object.get("motd").getAsString());
/* 37 */     result.setSlots(object.get("slots").getAsInt());
/* 38 */     if (object.has("protocol")) {
/* 39 */       result.setProtocol(object.get("protocol").getAsString());
/*    */     }
/* 41 */     if (object.has("online")) {
/* 42 */       result.setOnline(Integer.valueOf(object.get("online").getAsInt()));
/*    */     }
/* 44 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 51 */     return (JsonElement)JsonBuilder.object()
/* 52 */       .add("motd", this.motd)
/* 53 */       .add("slots", Integer.valueOf(this.slots))
/* 54 */       .consume(b -> {
/*    */           if (this.protocol != null) {
/*    */             b.add("protocol", this.protocol);
/*    */           }
/*    */           
/*    */           if (this.online != null) {
/*    */             b.add("online", this.online);
/*    */           }
/* 62 */         }).build();
/*    */   }
/*    */ 
/*    */   
/*    */   public ProxyMotd clone() {
/* 67 */     return new ProxyMotd(this.motd, this.slots, this.protocol, this.online);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ProxyMotd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */