/*    */ package org.apache.commons.lang3.function;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FailableConsumer<T, E extends Throwable>
/*    */ {
/*    */   public static final FailableConsumer NOP = t -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <T, E extends Throwable> FailableConsumer<T, E> nop() {
/* 45 */     return NOP;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableConsumer<T, E> andThen(FailableConsumer<? super T, E> after) {
/* 64 */     Objects.requireNonNull(after);
/* 65 */     return t -> {
/*    */         accept((T)t);
/*    */         after.accept(t);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(T paramT) throws E;
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */