/*    */ package net.craftigames.polar.common.core.future;
/*    */ 
/*    */ import com.google.common.cache.Cache;
/*    */ import com.google.common.cache.CacheBuilder;
/*    */ import java.util.UUID;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.MessageSender;
/*    */ import net.craftigames.polar.common.messages.PendingRequestResponseMessage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RequestHandler
/*    */ {
/*    */   private final MessageSender sender;
/* 17 */   private final Cache<UUID, PendingRequest<?, ?>> pending = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.MINUTES).build(); public Cache<UUID, PendingRequest<?, ?>> getPending() { return this.pending; } public MessageSender getSender() {
/* 18 */     return this.sender;
/*    */   }
/*    */   public RequestHandler(MessageSender sender) {
/* 21 */     this.sender = sender;
/*    */   }
/*    */   
/*    */   public void handlePendingRequestResponse(PendingRequestResponseMessage response) {
/* 25 */     UUID uuid = response.getUuid();
/*    */     
/* 27 */     PendingRequest<?, ?> pending = (PendingRequest<?, ?>)this.pending.getIfPresent(uuid);
/* 28 */     if (pending != null) {
/* 29 */       this.pending.invalidate(uuid);
/* 30 */       pending.handleIncoming(response.getUser(), response.getData());
/*    */     } 
/*    */   }
/*    */   
/*    */   public <T, M extends net.craftigames.polar.common.messages.RequestMessage> RequestDataFuture<T> sendDataRequest(UUID user, M message, Class<T> clazz) {
/* 35 */     return sendDataRequest("", user, message, clazz);
/*    */   }
/*    */   
/*    */   public <T, M extends net.craftigames.polar.common.messages.RequestMessage> RequestDataFuture<T> sendDataRequest(String channel, UUID user, M message, Class<T> clazz) {
/* 39 */     UUID uuid = UUID.randomUUID();
/* 40 */     message.setIdentifier(uuid);
/*    */     
/* 42 */     RequestDataFuture<T> future = new RequestDataFuture<>(this, user, uuid, clazz);
/*    */     
/* 44 */     PendingRequest<T, M> pendingRequest = new PendingRequest<>(message, future);
/* 45 */     this.pending.put(uuid, pendingRequest);
/* 46 */     this.sender.sendMessage(channel, new Message[] { (Message)message });
/* 47 */     return future;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\future\RequestHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */