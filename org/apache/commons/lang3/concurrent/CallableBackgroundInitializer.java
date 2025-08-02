/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CallableBackgroundInitializer<T>
/*     */   extends BackgroundInitializer<T>
/*     */ {
/*     */   private final Callable<T> callable;
/*     */   
/*     */   public CallableBackgroundInitializer(Callable<T> call) {
/*  81 */     checkCallable(call);
/*  82 */     this.callable = call;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableBackgroundInitializer(Callable<T> call, ExecutorService exec) {
/*  97 */     super(exec);
/*  98 */     checkCallable(call);
/*  99 */     this.callable = call;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T initialize() throws Exception {
/* 112 */     return this.callable.call();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkCallable(Callable<T> callable) {
/* 123 */     Validate.notNull(callable, "callable", new Object[0]);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\concurrent\CallableBackgroundInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */