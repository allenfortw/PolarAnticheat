/*    */ package gnu.trove.impl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class HashFunctions
/*    */ {
/*    */   public static int hash(double value) {
/* 26 */     assert !Double.isNaN(value) : "Values of NaN are not supported.";
/*    */     
/* 28 */     long bits = Double.doubleToLongBits(value);
/* 29 */     return (int)(bits ^ bits >>> 32L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int hash(float value) {
/* 41 */     assert !Float.isNaN(value) : "Values of NaN are not supported.";
/*    */     
/* 43 */     return Float.floatToIntBits(value * 6.6360896E8F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int hash(int value) {
/* 54 */     return value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int hash(long value) {
/* 63 */     return (int)(value ^ value >>> 32L);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int hash(Object object) {
/* 72 */     return (object == null) ? 0 : object.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\HashFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */