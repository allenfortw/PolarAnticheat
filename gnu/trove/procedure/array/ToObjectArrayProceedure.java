/*    */ package gnu.trove.procedure.array;
/*    */ 
/*    */ import gnu.trove.procedure.TObjectProcedure;
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
/*    */ public final class ToObjectArrayProceedure<T>
/*    */   implements TObjectProcedure<T>
/*    */ {
/*    */   private final T[] target;
/* 38 */   private int pos = 0;
/*    */ 
/*    */   
/*    */   public ToObjectArrayProceedure(T[] target) {
/* 42 */     this.target = target;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean execute(T value) {
/* 47 */     this.target[this.pos++] = value;
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\procedure\array\ToObjectArrayProceedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */