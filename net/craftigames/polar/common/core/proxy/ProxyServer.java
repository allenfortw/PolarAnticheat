/*    */ package net.craftigames.polar.common.core.proxy;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ public class ProxyServer implements IServer, GsonSerializable {
/*    */   private final String name;
/*    */   private final String ip;
/*    */   private final int port;
/*    */   
/* 12 */   public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof ProxyServer)) return false;  ProxyServer other = (ProxyServer)o; if (!other.canEqual(this)) return false;  if (getPort() != other.getPort()) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$ip = getIp(), other$ip = other.getIp(); return !((this$ip == null) ? (other$ip != null) : !this$ip.equals(other$ip)); } protected boolean canEqual(Object other) { return other instanceof ProxyServer; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getPort(); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $ip = getIp(); return result * 59 + (($ip == null) ? 43 : $ip.hashCode()); } public String toString() { return "ProxyServer(name=" + getName() + ", ip=" + getIp() + ", port=" + getPort() + ")"; }
/*    */ 
/*    */   
/* 15 */   public String getName() { return this.name; }
/* 16 */   public String getIp() { return this.ip; } public int getPort() {
/* 17 */     return this.port;
/*    */   }
/*    */   public ProxyServer(String name, String ip, int port) {
/* 20 */     this.name = name;
/* 21 */     this.ip = ip;
/* 22 */     this.port = port;
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement serialize() {
/* 27 */     JsonObject object = new JsonObject();
/* 28 */     object.addProperty("name", this.name);
/* 29 */     object.addProperty("ip", this.ip);
/* 30 */     object.addProperty("port", Integer.valueOf(this.port));
/* 31 */     return (JsonElement)object;
/*    */   }
/*    */   
/*    */   public static ProxyServer deserialize(JsonElement element) {
/* 35 */     if (!element.isJsonObject()) {
/* 36 */       return null;
/*    */     }
/*    */     
/* 39 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 41 */     if (!object.has("name") || !object.has("ip") || !object.has("port")) {
/* 42 */       return null;
/*    */     }
/*    */     
/* 45 */     return new ProxyServer(object
/* 46 */         .get("name").getAsString(), object
/* 47 */         .get("ip").getAsString(), object
/* 48 */         .get("port").getAsInt());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getProxyName() {
/* 54 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPlayerCount() {
/* 59 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public String getIpAndPort() {
/* 63 */     return this.ip + ":" + this.port;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\proxy\ProxyServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */