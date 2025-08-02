/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 55)
/*    */ public class MessageMemberServerKick extends AbstractTimeoutMessage implements RequestMessage {
/*    */   private UUID playerUuid;
/*    */   private String kickedFromServer;
/*    */   private String fallbackServer;
/*    */   
/* 20 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } private UUID identifier; private String serverIdentifier; @Nullable private Component kickReason; private boolean disconnectKick; public void setKickedFromServer(String kickedFromServer) { this.kickedFromServer = kickedFromServer; } public void setFallbackServer(String fallbackServer) { this.fallbackServer = fallbackServer; } public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setServerIdentifier(String serverIdentifier) { this.serverIdentifier = serverIdentifier; } public void setKickReason(@Nullable Component kickReason) { this.kickReason = kickReason; } public void setDisconnectKick(boolean disconnectKick) { this.disconnectKick = disconnectKick; }
/*    */ 
/*    */   
/*    */   public MessageMemberServerKick() {}
/*    */   
/* 25 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 26 */   public String getKickedFromServer() { return this.kickedFromServer; } public String getFallbackServer() {
/* 27 */     return this.fallbackServer;
/*    */   }
/* 29 */   public UUID getIdentifier() { return this.identifier; }
/* 30 */   public String getServerIdentifier() { return this.serverIdentifier; } @Nullable
/*    */   public Component getKickReason() {
/* 32 */     return this.kickReason;
/*    */   } public boolean isDisconnectKick() {
/* 34 */     return this.disconnectKick;
/*    */   }
/*    */   public MessageMemberServerKick(UUID playerUuid, String kickedFromServer, String fallbackServer, @Nullable Component kickReason, boolean disconnectKick) {
/* 37 */     this.playerUuid = playerUuid;
/* 38 */     this.kickedFromServer = kickedFromServer;
/* 39 */     this.fallbackServer = fallbackServer;
/* 40 */     this.kickReason = kickReason;
/* 41 */     this.disconnectKick = disconnectKick;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 46 */     super.send(out);
/* 47 */     out.add("uuid", this.playerUuid);
/* 48 */     out.add("server", this.kickedFromServer);
/* 49 */     out.add("fallback", this.fallbackServer);
/* 50 */     out.add("identifier", this.identifier);
/* 51 */     out.add("serverIdentifier", this.serverIdentifier);
/* 52 */     if (this.kickReason != null) {
/* 53 */       out.add("kickReason", TextUtils.toGson(this.kickReason));
/*    */     }
/* 55 */     out.add("disconnectKick", Boolean.valueOf(this.disconnectKick));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 60 */     super.receive(in);
/* 61 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 62 */     setKickedFromServer(in.get("server").getAsString());
/* 63 */     setIdentifier(in.getAsUUID("identifier"));
/* 64 */     setServerIdentifier(in.get("serverIdentifier").getAsString());
/*    */     
/* 66 */     JsonElement fallbackElement = in.get("fallback");
/* 67 */     if (fallbackElement instanceof com.google.gson.JsonPrimitive) {
/* 68 */       setFallbackServer(fallbackElement.getAsString());
/*    */     }
/*    */     
/* 71 */     JsonElement kickReasonElement = in.get("kickReason");
/* 72 */     if (kickReasonElement instanceof com.google.gson.JsonPrimitive) {
/* 73 */       setKickReason(TextUtils.fromGson(kickReasonElement.getAsString()));
/*    */     }
/*    */     
/* 76 */     JsonElement disconnectKickElement = in.get("disconnectKick");
/* 77 */     if (disconnectKickElement instanceof com.google.gson.JsonPrimitive) {
/* 78 */       setDisconnectKick(disconnectKickElement.getAsBoolean());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 84 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberServerKick.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */