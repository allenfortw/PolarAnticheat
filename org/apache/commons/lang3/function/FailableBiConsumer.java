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
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FailableBiConsumer<T, U, E extends Throwable>
/*    */ {
/*    */   public static final FailableBiConsumer NOP = (t, u) -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
/* 47 */     return NOP;
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
/*    */   
/*    */   default FailableBiConsumer<T, U, E> andThen(FailableBiConsumer<? super T, ? super U, E> after) {
/* 67 */     Objects.requireNonNull(after);
/* 68 */     return (t, u) -> {
/*    */         accept((T)t, (U)u);
/*    */         after.accept(t, u);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(T paramT, U paramU) throws E;
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableBiConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */