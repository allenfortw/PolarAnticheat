/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ServerConnectReason;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 48)
/*    */ public class MessageMemberServerConnect extends AbstractTimeoutMessage implements RequestMessage {
/*    */   private UUID playerUuid;
/*    */   @Nullable
/*    */   private String serverTarget;
/*    */   
/* 19 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } private ServerConnectReason reason; private UUID identifier; private String serverIdentifier; public void setServerTarget(@Nullable String serverTarget) { this.serverTarget = serverTarget; } public void setReason(ServerConnectReason reason) { this.reason = reason; } public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setServerIdentifier(String serverIdentifier) { this.serverIdentifier = serverIdentifier; }
/*    */ 
/*    */   
/*    */   public MessageMemberServerConnect() {}
/*    */   
/* 24 */   public UUID getPlayerUuid() { return this.playerUuid; } @Nullable
/* 25 */   public String getServerTarget() { return this.serverTarget; } public ServerConnectReason getReason() {
/* 26 */     return this.reason;
/*    */   }
/* 28 */   public UUID getIdentifier() { return this.identifier; } public String getServerIdentifier() {
/* 29 */     return this.serverIdentifier;
/*    */   }
/*    */   public MessageMemberServerConnect(UUID playerUuid, @Nullable String serverTarget, ServerConnectReason reason) {
/* 32 */     this.playerUuid = playerUuid;
/* 33 */     this.serverTarget = serverTarget;
/* 34 */     this.reason = reason;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 39 */     super.send(out);
/* 40 */     out.add("uuid", this.playerUuid);
/* 41 */     out.add("server", this.serverTarget);
/* 42 */     out.add("reason", (GsonSerializable)this.reason);
/* 43 */     out.add("identifier", this.identifier);
/* 44 */     out.add("serverIdentifier", this.serverIdentifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 49 */     super.receive(in);
/* 50 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 51 */     JsonElement serverElement = in.get("server");
/* 52 */     if (serverElement instanceof com.google.gson.JsonPrimitive) {
/* 53 */       setServerTarget(serverElement.getAsString());
/*    */     }
/* 55 */     setReason(ServerConnectReason.deserialize(in.get("reason")));
/* 56 */     setIdentifier(in.getAsUUID("identifier"));
/* 57 */     setServerIdentifier(in.get("serverIdentifier").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 62 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberServerConnect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */