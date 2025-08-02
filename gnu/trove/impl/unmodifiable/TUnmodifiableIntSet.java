/*    */ package gnu.trove.impl.unmodifiable;
/*    */ 
/*    */ import gnu.trove.TIntCollection;
/*    */ import gnu.trove.set.TIntSet;
/*    */ import java.io.Serializable;
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
/*    */ public class TUnmodifiableIntSet
/*    */   extends TUnmodifiableIntCollection
/*    */   implements TIntSet, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -9215047833775013803L;
/*    */   
/*    */   public TUnmodifiableIntSet(TIntSet s) {
/* 57 */     super((TIntCollection)s);
/* 58 */   } public boolean equals(Object o) { return (o == this || this.c.equals(o)); } public int hashCode() {
/* 59 */     return this.c.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\imp\\unmodifiable\TUnmodifiableIntSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */