/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessagePlayerChooseInitialServer extends AbstractTimeoutMessage implements RequestMessage {
/*    */   private UUID playerUuid;
/*    */   private String playerUsername;
/*    */   private UUID identifier;
/*    */   private String serverIdentifier;
/*    */   
/*    */   public MessagePlayerChooseInitialServer() {}
/*    */   
/* 17 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } public void setPlayerUsername(String playerUsername) { this.playerUsername = playerUsername; } public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setServerIdentifier(String serverIdentifier) { this.serverIdentifier = serverIdentifier; }
/*    */    public String toString() {
/* 19 */     return "MessagePlayerChooseInitialServer(playerUuid=" + getPlayerUuid() + ", playerUsername=" + getPlayerUsername() + ", identifier=" + getIdentifier() + ", serverIdentifier=" + getServerIdentifier() + ")";
/*    */   }
/*    */   
/* 22 */   public UUID getPlayerUuid() { return this.playerUuid; } public String getPlayerUsername() {
/* 23 */     return this.playerUsername;
/*    */   }
/*    */   
/* 26 */   public UUID getIdentifier() { return this.identifier; } public String getServerIdentifier() {
/* 27 */     return this.serverIdentifier;
/*    */   }
/*    */   public MessagePlayerChooseInitialServer(UUID playerUuid, String playerUsername) {
/* 30 */     this.playerUuid = playerUuid;
/* 31 */     this.playerUsername = playerUsername;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 36 */     super.send(out);
/* 37 */     out.add("playerUuid", this.playerUuid);
/* 38 */     out.add("playerUsername", this.playerUsername);
/* 39 */     out.add("identifier", this.identifier);
/* 40 */     out.add("serverIdentifier", this.serverIdentifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 45 */     super.receive(in);
/* 46 */     this.playerUuid = in.getAsUUID("playerUuid");
/* 47 */     this.playerUsername = in.get("playerUsername").getAsString();
/* 48 */     this.identifier = in.getAsUUID("identifier");
/* 49 */     this.serverIdentifier = in.get("serverIdentifier").getAsString();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessagePlayerChooseInitialServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */