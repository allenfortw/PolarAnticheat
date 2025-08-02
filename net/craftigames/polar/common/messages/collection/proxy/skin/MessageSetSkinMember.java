/*    */ package net.craftigames.polar.common.messages.collection.proxy.skin;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.SkinProperty;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 39)
/*    */ public class MessageSetSkinMember extends Message {
/*    */   private UUID playerUuid;
/*    */   
/* 17 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } private SkinProperty skinProperty; @Nullable private UUID connectionId; public void setSkinProperty(SkinProperty skinProperty) { this.skinProperty = skinProperty; } public void setConnectionId(@Nullable UUID connectionId) { this.connectionId = connectionId; }
/*    */ 
/*    */   
/*    */   public MessageSetSkinMember() {}
/*    */   
/* 22 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 23 */   public SkinProperty getSkinProperty() { return this.skinProperty; } @Nullable
/*    */   public UUID getConnectionId() {
/* 25 */     return this.connectionId;
/*    */   }
/*    */   public MessageSetSkinMember(UUID playerUuid, SkinProperty skinProperty, @Nullable UUID connectionId) {
/* 28 */     this.playerUuid = playerUuid;
/* 29 */     this.skinProperty = skinProperty;
/* 30 */     this.connectionId = connectionId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 35 */     out.add("uuid", this.playerUuid);
/* 36 */     out.add("skinProperty", (GsonSerializable)this.skinProperty);
/* 37 */     if (this.connectionId != null) {
/* 38 */       out.add("con", this.connectionId);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 45 */     setSkinProperty(SkinProperty.deserialize(in.get("skinProperty")));
/* 46 */     if (in.has("con")) {
/* 47 */       setConnectionId(UUID.fromString(in.get("con").getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 53 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\skin\MessageSetSkinMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */