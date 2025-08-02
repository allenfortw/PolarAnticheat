/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import gnu.trove.list.TLongList;
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
/*    */ public class TSynchronizedRandomAccessLongList
/*    */   extends TSynchronizedLongList
/*    */   implements RandomAccess
/*    */ {
/*    */   static final long serialVersionUID = 1530674583602358482L;
/*    */   
/*    */   public TSynchronizedRandomAccessLongList(TLongList list) {
/* 58 */     super(list);
/*    */   }
/*    */   
/*    */   public TSynchronizedRandomAccessLongList(TLongList list, Object mutex) {
/* 62 */     super(list, mutex);
/*    */   }
/*    */   
/*    */   public TLongList subList(int fromIndex, int toIndex) {
/* 66 */     synchronized (this.mutex) {
/* 67 */       return new TSynchronizedRandomAccessLongList(this.list
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
/* 79 */     return new TSynchronizedLongList(this.list);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedRandomAccessLongList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */