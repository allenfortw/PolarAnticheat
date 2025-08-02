/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 78)
/*    */ public class MessageLitebansEntry extends Message {
/*    */   private long punishmentId;
/*    */   private String uuid;
/*    */   private String ip;
/*    */   
/*    */   public MessageLitebansEntry(long punishmentId, String uuid, String ip, boolean ipPunishment, boolean removed, long expiry) {
/* 12 */     this.punishmentId = punishmentId; this.uuid = uuid; this.ip = ip; this.ipPunishment = ipPunishment; this.removed = removed; this.expiry = expiry;
/*    */   }
/*    */   private boolean ipPunishment; private boolean removed; private long expiry;
/*    */   public MessageLitebansEntry() {}
/*    */   
/*    */   public long getPunishmentId() {
/* 18 */     return this.punishmentId;
/* 19 */   } public String getUuid() { return this.uuid; }
/* 20 */   public String getIp() { return this.ip; }
/* 21 */   public boolean isIpPunishment() { return this.ipPunishment; }
/* 22 */   public boolean isRemoved() { return this.removed; } public long getExpiry() {
/* 23 */     return this.expiry;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     out.add("punishmentId", Long.valueOf(this.punishmentId));
/* 28 */     out.add("uuid", this.uuid);
/* 29 */     out.add("ip", this.ip);
/* 30 */     out.add("ipPunishment", Boolean.valueOf(this.ipPunishment));
/* 31 */     out.add("removed", Boolean.valueOf(this.removed));
/* 32 */     out.add("expiry", Long.valueOf(this.expiry));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     this.punishmentId = in.get("punishmentId").getAsLong();
/* 38 */     this.uuid = in.get("uuid").getAsString();
/* 39 */     this.ip = in.get("ip").getAsString();
/* 40 */     this.ipPunishment = in.get("ipPunishment").getAsBoolean();
/* 41 */     this.removed = in.get("removed").getAsBoolean();
/* 42 */     this.expiry = in.get("expiry").getAsLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 47 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageLitebansEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */