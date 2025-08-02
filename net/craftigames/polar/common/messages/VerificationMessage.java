/*    */ package net.craftigames.polar.common.messages;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.apache.commons.lang3.RandomUtils;
/*    */ 
/*    */ 
/*    */ public abstract class VerificationMessage
/*    */   extends Message
/*    */ {
/*    */   private long verificationId;
/*    */   
/*    */   public VerificationMessage() {}
/*    */   
/*    */   public void setVerificationId(long verificationId) {
/* 16 */     this.verificationId = verificationId;
/*    */   } public VerificationMessage(long verificationId) {
/* 18 */     this.verificationId = verificationId;
/*    */   }
/*    */   public long getVerificationId() {
/* 21 */     return this.verificationId;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 25 */     out.add("verificationId", Long.valueOf(this.verificationId));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 30 */     this.verificationId = in.get("verificationId").getAsLong();
/*    */   }
/*    */ 
/*    */   
/*    */   public static long generateVerificationId() {
/*    */     while (true) {
/* 36 */       long id = RandomUtils.nextLong();
/* 37 */       if (id != 0L)
/* 38 */         return id; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\VerificationMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */