/*    */ package org.apache.commons.lang3.function;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import java.util.function.Function;
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
/*    */ public interface TriFunction<T, U, V, R>
/*    */ {
/*    */   R apply(T paramT, U paramU, V paramV);
/*    */   
/*    */   default <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> after) {
/* 63 */     Objects.requireNonNull(after);
/* 64 */     return (t, u, v) -> after.apply(apply((T)t, (U)u, (V)v));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\TriFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */