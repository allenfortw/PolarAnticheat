/*    */ package net.craftigames.polar.common.messages.collection.minigames;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @MessageIdentifier(legacyId = 103)
/*    */ public class MessageTrackDataSaving
/*    */   extends Message
/*    */ {
/*    */   private DataState dataState;
/*    */   private String targetServer;
/*    */   private String targetMember;
/*    */   
/*    */   public MessageTrackDataSaving(DataState dataState, String targetServer, String targetMember) {
/* 20 */     this.dataState = dataState; this.targetServer = targetServer; this.targetMember = targetMember;
/*    */   }
/*    */   
/*    */   public MessageTrackDataSaving() {}
/*    */   
/*    */   public DataState getDataState() {
/* 26 */     return this.dataState;
/* 27 */   } public String getTargetServer() { return this.targetServer; } public String getTargetMember() {
/* 28 */     return this.targetMember;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     out.add("state", Integer.valueOf(this.dataState.getId()));
/* 34 */     out.add("server", this.targetServer);
/* 35 */     out.add("member", this.targetMember);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     if (in.has("state")) {
/* 41 */       this.dataState = DataState.fromId(in.get("state").getAsInt());
/*    */     }
/* 43 */     if (in.has("server")) {
/* 44 */       this.targetServer = in.get("server").getAsString();
/*    */     }
/* 46 */     if (in.has("member")) {
/* 47 */       this.targetMember = in.get("member").getAsString();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 53 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\MessageTrackDataSaving.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */