/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ @MessageIdentifier(legacyId = 91)
/*    */ public class MessageMemberUpdateCombat
/*    */   extends Message
/*    */ {
/*    */   private String player;
/*    */   private boolean combat;
/*    */   
/*    */   public MessageMemberUpdateCombat() {}
/*    */   
/*    */   public String getPlayer() {
/* 20 */     return this.player; } public boolean isCombat() {
/* 21 */     return this.combat;
/*    */   }
/*    */   public MessageMemberUpdateCombat(String player, boolean combat) {
/* 24 */     this.player = player;
/* 25 */     this.combat = combat;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     out.add("player", this.player);
/* 31 */     out.add("combat", Boolean.valueOf(this.combat));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 36 */     this.player = in.get("player").getAsString();
/* 37 */     this.combat = in.get("combat").getAsBoolean();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 43 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageMemberUpdateCombat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */