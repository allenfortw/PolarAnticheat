/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.list.TFloatList;
/*    */ import java.util.RandomAccess;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TSynchronizedRandomAccessFloatList
/*    */   extends TSynchronizedFloatList
/*    */   implements RandomAccess
/*    */ {
/*    */   static final long serialVersionUID = 1530674583602358482L;
/*    */   
/*    */   public TSynchronizedRandomAccessFloatList(TFloatList list) {
/* 58 */     super(list);
/*    */   }
/*    */   
/*    */   public TSynchronizedRandomAccessFloatList(TFloatList list, Object mutex) {
/* 62 */     super(list, mutex);
/*    */   }
/*    */   
/*    */   public TFloatList subList(int fromIndex, int toIndex) {
/* 66 */     synchronized (this.mutex) {
/* 67 */       return new TSynchronizedRandomAccessFloatList(this.list
/* 68 */           .subList(fromIndex, toIndex), this.mutex);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Object writeReplace() {
/* 79 */     return new TSynchronizedFloatList(this.list);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedRandomAccessFloatList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */