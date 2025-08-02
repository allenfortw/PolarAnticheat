/*    */ package net.craftigames.polar.common.messages.collection.minigames.privategame;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.privategame.PrivateGame;
/*    */ import net.craftigames.polar.common.privategame.PrivateGameImpl;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @Deprecated
/*    */ @MessageIdentifier(legacyId = 21)
/*    */ public class MessageBukkitRegisterGameInfo
/*    */   extends Message {
/*    */   private PrivateGame game;
/*    */   
/*    */   public MessageBukkitRegisterGameInfo(PrivateGame game) {
/* 19 */     this.game = game;
/*    */   }
/*    */   
/*    */   public MessageBukkitRegisterGameInfo() {}
/*    */   
/*    */   public PrivateGame getGame() {
/* 25 */     return this.game;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 29 */     if (this.game != null) {
/* 30 */       out.add("game", (GsonSerializable)this.game);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 36 */     if (in.has("game")) {
/* 37 */       this.game = (PrivateGame)PrivateGameImpl.deserialize(in.get("game"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 43 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\privategame\MessageBukkitRegisterGameInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */