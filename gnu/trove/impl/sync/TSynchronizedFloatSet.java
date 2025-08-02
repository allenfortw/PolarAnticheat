/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.TFloatCollection;
/*    */ import gnu.trove.set.TFloatSet;
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
/*    */ public class TSynchronizedFloatSet
/*    */   extends TSynchronizedFloatCollection
/*    */   implements TFloatSet
/*    */ {
/*    */   private static final long serialVersionUID = 487447009682186044L;
/*    */   
/*    */   public TSynchronizedFloatSet(TFloatSet s) {
/* 58 */     super((TFloatCollection)s);
/*    */   }
/*    */   public TSynchronizedFloatSet(TFloatSet s, Object mutex) {
/* 61 */     super((TFloatCollection)s, mutex);
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 65 */     synchronized (this.mutex) { return this.c.equals(o); }
/*    */   
/*    */   } public int hashCode() {
/* 68 */     synchronized (this.mutex) { return this.c.hashCode(); }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedFloatSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */