/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.TDoubleCollection;
/*    */ import gnu.trove.set.TDoubleSet;
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
/*    */ public class TSynchronizedDoubleSet
/*    */   extends TSynchronizedDoubleCollection
/*    */   implements TDoubleSet
/*    */ {
/*    */   private static final long serialVersionUID = 487447009682186044L;
/*    */   
/*    */   public TSynchronizedDoubleSet(TDoubleSet s) {
/* 58 */     super((TDoubleCollection)s);
/*    */   }
/*    */   public TSynchronizedDoubleSet(TDoubleSet s, Object mutex) {
/* 61 */     super((TDoubleCollection)s, mutex);
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedDoubleSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */