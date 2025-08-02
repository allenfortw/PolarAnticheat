/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.system.MessageMemberMessage;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageGrizzlyMemberSync
/*    */   extends MessageMemberMessage
/*    */ {
/*    */   public MessageGrizzlyMemberSync() {}
/*    */   
/*    */   public MessageGrizzlyMemberSync(UUID playerUuid, String message) {
/* 16 */     super(playerUuid, message);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 21 */     super.send(out);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 26 */     super.receive(in);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageGrizzlyMemberSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */