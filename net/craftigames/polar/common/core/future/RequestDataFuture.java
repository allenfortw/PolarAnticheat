/*    */ package net.craftigames.polar.common.core.future;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import java.util.concurrent.CountDownLatch;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.TimeoutException;
/*    */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*    */ import net.craftigames.polar.common.util.serialize.Duration;
/*    */ 
/*    */ public class RequestDataFuture<T> implements Future<T> {
/*    */   private final RequestHandler handler;
/*    */   private final UUID user;
/*    */   private final UUID uuid;
/*    */   
/*    */   private enum State {
/* 16 */     WAITING, DONE, CANCELLED;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 21 */   private final CountDownLatch latch = new CountDownLatch(1);
/*    */   
/*    */   private T value;
/* 24 */   private volatile State state = State.WAITING;
/*    */   
/*    */   private final Class<T> clazz;
/*    */   
/*    */   public RequestDataFuture(RequestHandler handler, UUID user, UUID uuid, Class<T> clazz) {
/* 29 */     this.handler = handler;
/* 30 */     this.user = user;
/* 31 */     this.uuid = uuid;
/* 32 */     this.clazz = clazz;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean cancel(boolean mayInterruptIfRunning) {
/* 37 */     this.state = State.CANCELLED;
/* 38 */     cleanUp();
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCancelled() {
/* 44 */     return (this.state == State.CANCELLED);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDone() {
/* 49 */     return (this.state == State.DONE);
/*    */   }
/*    */ 
/*    */   
/*    */   public T get() throws InterruptedException {
/* 54 */     this.latch.await();
/* 55 */     return this.value;
/*    */   }
/*    */   
/*    */   public T get(Duration duration) throws InterruptedException, TimeoutException {
/* 59 */     return get(duration.toMillis(), TimeUnit.MILLISECONDS);
/*    */   }
/*    */ 
/*    */   
/*    */   public T get(long timeout, @Nonnull TimeUnit unit) throws InterruptedException, TimeoutException {
/* 64 */     if (this.latch.await(timeout, unit)) {
/* 65 */       return this.value;
/*    */     }
/* 67 */     throw new TimeoutException();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onMessage(UUID user, JsonElement element) {
/* 72 */     if (!user.equals(this.user)) {
/*    */       return;
/*    */     }
/* 75 */     this.value = (T)GsonProvider.standard().fromJson(element, this.clazz);
/* 76 */     this.state = State.DONE;
/* 77 */     this.latch.countDown();
/* 78 */     cleanUp();
/*    */   }
/*    */   
/*    */   private void cleanUp() {
/* 82 */     this.handler.getPending().invalidate(this.uuid);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\future\RequestDataFuture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */