/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 2)
/*    */ public class MessageMemberQuit extends AbstractMemberMessage {
/*    */   @Nullable
/*    */   private UUID connectionId;
/*    */   
/*    */   public void setConnectionId(@Nullable UUID connectionId) {
/* 16 */     this.connectionId = connectionId;
/*    */   }
/*    */   public MessageMemberQuit() {}
/*    */   @Nullable
/*    */   public UUID getConnectionId() {
/* 21 */     return this.connectionId;
/*    */   }
/*    */   public MessageMemberQuit(UUID uuid, String name, @Nullable UUID connectionId) {
/* 24 */     super(uuid, name);
/* 25 */     this.connectionId = connectionId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     super.send(out);
/* 31 */     if (this.connectionId != null) {
/* 32 */       out.add("con", this.connectionId);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     super.receive(in);
/* 39 */     if (in.has("con")) {
/* 40 */       setConnectionId(UUID.fromString(in.get("con").getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 46 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberQuit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */