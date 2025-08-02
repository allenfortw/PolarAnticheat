/*    */ package net.craftigames.polar.common.messages.collection.proxy.management;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.UpdateStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 81)
/*    */ public class MessageProxyModifyServer
/*    */   extends Message
/*    */ {
/*    */   private UpdateStatus updateStatus;
/*    */   private String server;
/*    */   
/*    */   public UpdateStatus getUpdateStatus() {
/* 21 */     return this.updateStatus;
/*    */   } public String getServer() {
/* 23 */     return this.server;
/* 24 */   } private String value = ""; public String getValue() { return this.value; }
/* 25 */    private String editType = ""; public String getEditType() { return this.editType; }
/*    */   
/*    */   public MessageProxyModifyServer(UpdateStatus updateStatus, String server, String ip) {
/* 28 */     this.updateStatus = updateStatus;
/* 29 */     this.server = server;
/* 30 */     this.value = ip;
/*    */   }
/*    */   
/*    */   public MessageProxyModifyServer(UpdateStatus updateStatus, String server, String value, String editType) {
/* 34 */     this.updateStatus = updateStatus;
/* 35 */     this.server = server;
/* 36 */     this.value = value;
/* 37 */     this.editType = editType;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 42 */     out.add("status", Integer.valueOf(this.updateStatus.getId()));
/* 43 */     out.add("server", this.server);
/* 44 */     out.add("value", this.value);
/* 45 */     out.add("editType", this.editType);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 50 */     this.updateStatus = UpdateStatus.byId(in.get("status").getAsInt());
/* 51 */     this.server = in.get("server").getAsString();
/* 52 */     this.value = in.get("value").getAsString();
/* 53 */     this.editType = in.get("editType").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 58 */     return MessageType.PROXY;
/*    */   }
/*    */   
/*    */   public MessageProxyModifyServer() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\management\MessageProxyModifyServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */