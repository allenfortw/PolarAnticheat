/*    */ package org.apache.commons.lang3.reflect;
/*    */ 
/*    */ import org.apache.commons.lang3.BooleanUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InheritanceUtils
/*    */ {
/*    */   public static int distance(Class<?> child, Class<?> parent) {
/* 49 */     if (child == null || parent == null) {
/* 50 */       return -1;
/*    */     }
/*    */     
/* 53 */     if (child.equals(parent)) {
/* 54 */       return 0;
/*    */     }
/*    */     
/* 57 */     Class<?> cParent = child.getSuperclass();
/* 58 */     int d = BooleanUtils.toInteger(parent.equals(cParent));
/*    */     
/* 60 */     if (d == 1) {
/* 61 */       return d;
/*    */     }
/* 63 */     d += distance(cParent, parent);
/* 64 */     return (d > 0) ? (d + 1) : -1;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\reflect\InheritanceUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */