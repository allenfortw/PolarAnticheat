/*    */ package net.craftigames.polar.common.messages.collection;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.TimeoutMessage;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.serialize.Duration;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public abstract class AbstractTimeoutMessage
/*    */   extends Message implements TimeoutMessage {
/*    */   public void setTimeout(@Nullable Duration timeout) {
/* 15 */     this.timeout = timeout;
/*    */   } @Nullable
/*    */   private Duration timeout; @Nullable
/*    */   public Duration getTimeout() {
/* 19 */     return this.timeout;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 23 */     if (this.timeout != null) {
/* 24 */       out.add("timeout", (GsonSerializable)this.timeout);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 30 */     JsonElement timeoutElement = in.get("timeout");
/* 31 */     if (timeoutElement instanceof com.google.gson.JsonObject)
/* 32 */       this.timeout = Duration.deserialize(timeoutElement); 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\AbstractTimeoutMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */