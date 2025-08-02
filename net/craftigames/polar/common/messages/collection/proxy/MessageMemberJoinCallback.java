/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 6)
/*    */ public class MessageMemberJoinCallback extends Message {
/*    */   private UUID playerUuid;
/*    */   @Nullable
/*    */   private UUID connectionId;
/*    */   private boolean successful;
/*    */   @Nullable
/*    */   private Component message;
/*    */   
/* 20 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } public void setConnectionId(@Nullable UUID connectionId) { this.connectionId = connectionId; } public void setSuccessful(boolean successful) { this.successful = successful; } public void setMessage(@Nullable Component message) { this.message = message; }
/*    */ 
/*    */   
/*    */   public MessageMemberJoinCallback() {}
/*    */   
/* 25 */   public UUID getPlayerUuid() { return this.playerUuid; }
/*    */   @Nullable
/* 27 */   public UUID getConnectionId() { return this.connectionId; }
/* 28 */   public boolean isSuccessful() { return this.successful; } @Nullable
/* 29 */   public Component getMessage() { return this.message; }
/*    */   
/*    */   public MessageMemberJoinCallback(UUID playerUuid, boolean successful, @Nullable Component message, @Nullable UUID connectionId) {
/* 32 */     this.playerUuid = playerUuid;
/* 33 */     this.successful = successful;
/* 34 */     this.message = message;
/* 35 */     this.connectionId = connectionId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 40 */     out.add("uuid", this.playerUuid);
/* 41 */     out.add("successful", Boolean.valueOf(this.successful));
/* 42 */     if (this.message != null) {
/* 43 */       out.add("message", TextUtils.toLegacy(this.message));
/*    */     }
/* 45 */     if (this.connectionId != null) {
/* 46 */       out.add("con", this.connectionId);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 52 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 53 */     setSuccessful(in.get("successful").getAsBoolean());
/* 54 */     if (in.has("message")) {
/* 55 */       setMessage((Component)TextUtils.fromLegacy(in.get("message").getAsString()));
/*    */     }
/* 57 */     if (in.has("con")) {
/* 58 */       setConnectionId(UUID.fromString(in.get("con").getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 64 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageMemberJoinCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */