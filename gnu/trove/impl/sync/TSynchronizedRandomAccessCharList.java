/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.list.TCharList;
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
/*    */ public class TSynchronizedRandomAccessCharList
/*    */   extends TSynchronizedCharList
/*    */   implements RandomAccess
/*    */ {
/*    */   static final long serialVersionUID = 1530674583602358482L;
/*    */   
/*    */   public TSynchronizedRandomAccessCharList(TCharList list) {
/* 58 */     super(list);
/*    */   }
/*    */   
/*    */   public TSynchronizedRandomAccessCharList(TCharList list, Object mutex) {
/* 62 */     super(list, mutex);
/*    */   }
/*    */   
/*    */   public TCharList subList(int fromIndex, int toIndex) {
/* 66 */     synchronized (this.mutex) {
/* 67 */       return new TSynchronizedRandomAccessCharList(this.list
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
/* 79 */     return new TSynchronizedCharList(this.list);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedRandomAccessCharList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */