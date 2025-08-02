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
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FailableFunction<T, R, E extends Throwable>
/*    */ {
/*    */   public static final FailableFunction NOP = t -> null;
/*    */   
/*    */   static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
/* 46 */     return t -> t;
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
/*    */   static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
/* 58 */     return NOP;
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
/*    */   default <V> FailableFunction<T, V, E> andThen(FailableFunction<? super R, ? extends V, E> after) {
/* 70 */     Objects.requireNonNull(after);
/* 71 */     return t -> after.apply(apply((T)t));
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
/*    */ 
/*    */   
/*    */   default <V> FailableFunction<V, R, E> compose(FailableFunction<? super V, ? extends T, E> before) {
/* 93 */     Objects.requireNonNull(before);
/* 94 */     return v -> apply((T)before.apply(v));
/*    */   }
/*    */   
/*    */   R apply(T paramT) throws E;
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */