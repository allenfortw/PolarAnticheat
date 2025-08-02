/*    */ package gnu.trove.list;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TLinkableAdapter<T extends TLinkable>
/*    */   implements TLinkable<T>
/*    */ {
/*    */   private volatile T next;
/*    */   private volatile T prev;
/*    */   
/*    */   public T getNext() {
/* 25 */     return this.next;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setNext(T next) {
/* 30 */     this.next = next;
/*    */   }
/*    */ 
/*    */   
/*    */   public T getPrevious() {
/* 35 */     return this.prev;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setPrevious(T prev) {
/* 40 */     this.prev = prev;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\list\TLinkableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */