/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ 
/*    */ public class PolarVote implements GsonSerializable {
/*    */   private final String serviceName;
/*    */   private final String username;
/*    */   
/*  9 */   public PolarVote(String serviceName, String username, String address, String timeStamp, long localTimestamp) { this.serviceName = serviceName; this.username = username; this.address = address; this.timeStamp = timeStamp; this.localTimestamp = localTimestamp; } private final String address; private final String timeStamp; private final long localTimestamp; public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PolarVote)) return false;  PolarVote other = (PolarVote)o; if (!other.canEqual(this)) return false;  if (getLocalTimestamp() != other.getLocalTimestamp()) return false;  Object this$serviceName = getServiceName(), other$serviceName = other.getServiceName(); if ((this$serviceName == null) ? (other$serviceName != null) : !this$serviceName.equals(other$serviceName)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$address = getAddress(), other$address = other.getAddress(); if ((this$address == null) ? (other$address != null) : !this$address.equals(other$address)) return false;  Object this$timeStamp = getTimeStamp(), other$timeStamp = other.getTimeStamp(); return !((this$timeStamp == null) ? (other$timeStamp != null) : !this$timeStamp.equals(other$timeStamp)); } protected boolean canEqual(Object other) { return other instanceof PolarVote; } public int hashCode() { int PRIME = 59; result = 1; long $localTimestamp = getLocalTimestamp(); result = result * 59 + (int)($localTimestamp >>> 32L ^ $localTimestamp); Object $serviceName = getServiceName(); result = result * 59 + (($serviceName == null) ? 43 : $serviceName.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $address = getAddress(); result = result * 59 + (($address == null) ? 43 : $address.hashCode()); Object $timeStamp = getTimeStamp(); return result * 59 + (($timeStamp == null) ? 43 : $timeStamp.hashCode()); } public String toString() { return "PolarVote(serviceName=" + getServiceName() + ", username=" + getUsername() + ", address=" + getAddress() + ", timeStamp=" + getTimeStamp() + ", localTimestamp=" + getLocalTimestamp() + ")"; }
/*    */ 
/*    */   
/* 12 */   public String getServiceName() { return this.serviceName; }
/* 13 */   public String getUsername() { return this.username; }
/* 14 */   public String getAddress() { return this.address; }
/* 15 */   public String getTimeStamp() { return this.timeStamp; } public long getLocalTimestamp() {
/* 16 */     return this.localTimestamp;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public JsonElement serialize() {
/* 21 */     JsonObject object = new JsonObject();
/* 22 */     object.addProperty("serviceName", this.serviceName);
/* 23 */     object.addProperty("username", this.username);
/* 24 */     object.addProperty("address", this.address);
/* 25 */     object.addProperty("timeStamp", this.timeStamp);
/* 26 */     object.addProperty("localTimestamp", Long.valueOf(this.localTimestamp));
/* 27 */     return (JsonElement)object;
/*    */   }
/*    */   
/*    */   public static PolarVote deserialize(JsonElement element) {
/* 31 */     if (element.isJsonObject()) {
/* 32 */       JsonObject object = element.getAsJsonObject();
/* 33 */       return new PolarVote(object
/* 34 */           .get("serviceName").getAsString(), object
/* 35 */           .get("username").getAsString(), object
/* 36 */           .get("address").getAsString(), object
/* 37 */           .get("timeStamp").getAsString(), object
/* 38 */           .get("localTimestamp").getAsLong());
/*    */     } 
/*    */     
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\PolarVote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */