/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 88)
/*    */ public class MessageMemberPermission extends Message {
/*    */   private UUID identifier;
/*    */   private UUID playerUuid;
/*    */   
/* 16 */   public void setIdentifier(UUID identifier) { this.identifier = identifier; } private String permission; @Nullable private String server; @Nullable private String resultChannel; public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } public void setPermission(String permission) { this.permission = permission; } public void setServer(@Nullable String server) { this.server = server; } public void setResultChannel(@Nullable String resultChannel) { this.resultChannel = resultChannel; }
/*    */ 
/*    */   
/*    */   public MessageMemberPermission() {}
/*    */   
/* 21 */   public UUID getIdentifier() { return this.identifier; }
/* 22 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 23 */   public String getPermission() { return this.permission; } @Nullable
/* 24 */   public String getServer() { return this.server; } @Nullable
/* 25 */   public String getResultChannel() { return this.resultChannel; }
/*    */   
/*    */   public MessageMemberPermission(UUID identifier, UUID playerUuid, String permission, @Nullable String server, @Nullable String resultChannel) {
/* 28 */     this.identifier = identifier;
/* 29 */     this.playerUuid = playerUuid;
/* 30 */     this.permission = permission;
/* 31 */     this.server = server;
/* 32 */     this.resultChannel = resultChannel;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 37 */     out.add("identifier", this.identifier);
/* 38 */     out.add("playerUuid", this.playerUuid);
/* 39 */     out.add("permission", this.permission);
/* 40 */     if (this.server != null) {
/* 41 */       out.add("server", this.server);
/*    */     }
/* 43 */     if (this.resultChannel != null) {
/* 44 */       out.add("resultChannel", this.resultChannel);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 50 */     setIdentifier(UUID.fromString(in.get("identifier").getAsString()));
/* 51 */     setPlayerUuid(UUID.fromString(in.get("playerUuid").getAsString()));
/* 52 */     setPermission(in.get("permission").getAsString());
/* 53 */     if (in.has("server")) {
/* 54 */       setServer(in.get("server").getAsString());
/*    */     }
/* 56 */     if (in.has("resultChannel")) {
/* 57 */       setResultChannel(in.get("resultChannel").getAsString());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 63 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */