/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ import net.craftigames.polar.common.grafana.ExternalServerStatistic;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 86)
/*    */ public class MessageInfluxSendData extends Message {
/*    */   private ExternalServerStatistic serverStatistic;
/*    */   
/*    */   public void setServerStatistic(ExternalServerStatistic serverStatistic) {
/* 14 */     this.serverStatistic = serverStatistic;
/*    */   }
/*    */   public MessageInfluxSendData() {}
/*    */   public ExternalServerStatistic getServerStatistic() {
/* 18 */     return this.serverStatistic;
/*    */   }
/*    */   public MessageInfluxSendData(ExternalServerStatistic serverStatistic) {
/* 21 */     this.serverStatistic = serverStatistic;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 26 */     out.add("statistic", this.serverStatistic.serialize());
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 31 */     this.serverStatistic = ExternalServerStatistic.deserialize(in.get("statistic"));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 36 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageInfluxSendData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */