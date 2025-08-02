/*    */ package gnu.trove.strategy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IdentityHashingStrategy<K>
/*    */   implements HashingStrategy<K>
/*    */ {
/*    */   static final long serialVersionUID = -5188534454583764904L;
/* 15 */   public static final IdentityHashingStrategy<Object> INSTANCE = new IdentityHashingStrategy();
/*    */ 
/*    */ 
/*    */   
/*    */   public int computeHashCode(K object) {
/* 20 */     return System.identityHashCode(object);
/*    */   }
/*    */   
/*    */   public boolean equals(K o1, K o2) {
/* 24 */     return (o1 == o2);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\strategy\IdentityHashingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */