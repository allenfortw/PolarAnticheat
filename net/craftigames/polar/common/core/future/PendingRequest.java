/*    */ package net.craftigames.polar.common.core.future;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ 
/*    */ public class PendingRequest<T, M extends RequestMessage> {
/*    */   private M message;
/*    */   private RequestDataFuture<T> requestDataFuture;
/*    */   
/*    */   public void setMessage(M message) {
/* 12 */     this.message = message; } public void setRequestDataFuture(RequestDataFuture<T> requestDataFuture) { this.requestDataFuture = requestDataFuture; } public PendingRequest(M message, RequestDataFuture<T> requestDataFuture) {
/* 13 */     this.message = message; this.requestDataFuture = requestDataFuture;
/*    */   }
/*    */   
/* 16 */   public M getMessage() { return this.message; } public RequestDataFuture<T> getRequestDataFuture() {
/* 17 */     return this.requestDataFuture;
/*    */   }
/*    */   public void handleIncoming(UUID user, JsonElement element) {
/* 20 */     this.requestDataFuture.onMessage(user, element);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\future\PendingRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */