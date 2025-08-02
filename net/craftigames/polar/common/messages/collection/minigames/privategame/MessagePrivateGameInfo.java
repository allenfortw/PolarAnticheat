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
/*    */ @MessageIdentifier(legacyId = 18)
/*    */ public class MessagePrivateGameInfo extends Message {
/*    */   private PrivateGame game;
/*    */   
/*    */   public MessagePrivateGameInfo(PrivateGame game) {
/* 17 */     this.game = game;
/*    */   }
/*    */   
/*    */   public MessagePrivateGameInfo() {}
/*    */   
/*    */   public PrivateGame getGame() {
/* 23 */     return this.game;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 27 */     if (this.game != null) {
/* 28 */       out.add("game", (GsonSerializable)this.game);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     if (in.has("game")) {
/* 35 */       this.game = (PrivateGame)PrivateGameImpl.deserialize(in.get("game"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 41 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\privategame\MessagePrivateGameInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */