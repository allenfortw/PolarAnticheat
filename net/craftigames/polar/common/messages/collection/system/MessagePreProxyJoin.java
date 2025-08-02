/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessagePreProxyJoin extends Message implements RequestMessage {
/*    */   private UUID offlineUuid;
/*    */   private String username;
/*    */   private String serverIdentifier;
/*    */   private UUID identifier;
/*    */   
/*    */   public MessagePreProxyJoin() {}
/*    */   
/* 19 */   public UUID getOfflineUuid() { return this.offlineUuid; }
/* 20 */   public String getUsername() { return this.username; } public String getServerIdentifier() {
/* 21 */     return this.serverIdentifier;
/*    */   }
/* 23 */   public UUID getIdentifier() { return this.identifier; } public void setIdentifier(UUID identifier) { this.identifier = identifier; }
/*    */ 
/*    */   
/*    */   public MessagePreProxyJoin(UUID offlineUuid, String username, String serverIdentifier) {
/* 27 */     this.offlineUuid = offlineUuid;
/* 28 */     this.username = username;
/* 29 */     this.serverIdentifier = serverIdentifier;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 34 */     out.add("uuid", this.offlineUuid);
/* 35 */     out.add("username", this.username);
/* 36 */     out.add("server-identifier", this.serverIdentifier);
/* 37 */     out.add("identifier", this.identifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     this.offlineUuid = in.getAsUUID("uuid");
/* 43 */     this.username = in.get("username").getAsString();
/* 44 */     this.serverIdentifier = in.get("server-identifier").getAsString();
/* 45 */     this.identifier = in.getAsUUID("identifier");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessagePreProxyJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */