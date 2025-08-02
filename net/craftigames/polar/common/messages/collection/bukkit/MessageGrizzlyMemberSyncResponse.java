/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.system.MessageMemberMessage;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageGrizzlyMemberSyncResponse
/*    */   extends MessageMemberMessage {
/*    */   private String identifier;
/*    */   private boolean status;
/*    */   
/*    */   public MessageGrizzlyMemberSyncResponse() {}
/*    */   
/*    */   public String getIdentifier() {
/* 18 */     return this.identifier;
/*    */   }
/*    */   
/*    */   public MessageGrizzlyMemberSyncResponse(UUID playerUuid, String message, String identifier, boolean status) {
/* 22 */     super(playerUuid, message);
/* 23 */     this.identifier = identifier;
/* 24 */     this.status = status;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 29 */     super.send(out);
/* 30 */     out.add("identifier", this.identifier);
/* 31 */     out.add("status", Boolean.valueOf(this.status));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 36 */     super.receive(in);
/* 37 */     this.identifier = in.get("identifier").getAsString();
/* 38 */     this.status = in.get("status").getAsBoolean();
/*    */   }
/*    */   
/*    */   public boolean getStatus() {
/* 42 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageGrizzlyMemberSyncResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */