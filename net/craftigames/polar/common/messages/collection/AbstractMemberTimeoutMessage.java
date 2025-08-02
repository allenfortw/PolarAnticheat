/*    */ package net.craftigames.polar.common.messages.collection;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.TimeoutMessage;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.serialize.Duration;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public abstract class AbstractMemberTimeoutMessage extends AbstractMemberMessage implements TimeoutMessage {
/*    */   @Nullable
/*    */   private Duration timeout;
/*    */   
/*    */   public void setTimeout(@Nullable Duration timeout) {
/* 16 */     this.timeout = timeout;
/*    */   }
/*    */   @Nullable
/*    */   public Duration getTimeout() {
/* 20 */     return this.timeout;
/*    */   } public AbstractMemberTimeoutMessage() {}
/*    */   public AbstractMemberTimeoutMessage(UUID uuid, String name) {
/* 23 */     super(uuid, name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/* 29 */     if (this.timeout != null) {
/* 30 */       out.add("timeout", (GsonSerializable)this.timeout);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 36 */     super.receive(in);
/* 37 */     JsonElement timeoutElement = in.get("timeout");
/* 38 */     if (timeoutElement instanceof com.google.gson.JsonObject)
/* 39 */       this.timeout = Duration.deserialize(timeoutElement); 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\AbstractMemberTimeoutMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */