/*    */ package net.craftigames.polar.common.messages.collection.geyser;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.UpdateStatus;
/*    */ import net.craftigames.polar.common.util.geyser.GeyserData;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 76)
/*    */ public class MessageGeyserUpdateMember
/*    */   extends Message {
/*    */   private UUID uuid;
/*    */   private UpdateStatus geyserStatus;
/*    */   private GeyserData data;
/*    */   
/*    */   public MessageGeyserUpdateMember(UUID uuid, UpdateStatus geyserStatus, GeyserData data) {
/* 21 */     this.uuid = uuid; this.geyserStatus = geyserStatus; this.data = data;
/*    */   }
/*    */   
/*    */   public MessageGeyserUpdateMember() {}
/*    */   
/* 26 */   public UUID getUuid() { return this.uuid; }
/* 27 */   public UpdateStatus getGeyserStatus() { return this.geyserStatus; } public GeyserData getData() {
/* 28 */     return this.data;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 32 */     out.add("uuid", this.uuid);
/* 33 */     out.add("status", Integer.valueOf(this.geyserStatus.getId()));
/* 34 */     out.add("data", (GsonSerializable)this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 39 */     this.uuid = in.getAsUUID("uuid");
/* 40 */     this.geyserStatus = UpdateStatus.byId(in.get("status").getAsInt());
/* 41 */     this.data = GeyserData.deserialize(in.get("data"));
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.GEYSER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\geyser\MessageGeyserUpdateMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */