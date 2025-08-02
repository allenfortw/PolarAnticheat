/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.TLongCollection;
/*    */ import gnu.trove.set.TLongSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TSynchronizedLongSet
/*    */   extends TSynchronizedLongCollection
/*    */   implements TLongSet
/*    */ {
/*    */   private static final long serialVersionUID = 487447009682186044L;
/*    */   
/*    */   public TSynchronizedLongSet(TLongSet s) {
/* 58 */     super((TLongCollection)s);
/*    */   }
/*    */   public TSynchronizedLongSet(TLongSet s, Object mutex) {
/* 61 */     super((TLongCollection)s, mutex);
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedLongSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */