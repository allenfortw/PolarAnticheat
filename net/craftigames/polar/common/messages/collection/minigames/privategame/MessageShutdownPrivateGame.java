/*    */ package net.craftigames.polar.common.messages.collection.minigames.privategame;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 20)
/*    */ public class MessageShutdownPrivateGame
/*    */   extends Message {
/*    */   public MessageShutdownPrivateGame(UUID owner) {
/* 14 */     this.owner = owner;
/*    */   }
/*    */   private UUID owner;
/*    */   public MessageShutdownPrivateGame() {}
/*    */   
/*    */   public UUID getOwner() {
/* 20 */     return this.owner;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 24 */     out.add("owner", this.owner);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 29 */     this.owner = UUID.fromString(in.get("owner").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 34 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\privategame\MessageShutdownPrivateGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */