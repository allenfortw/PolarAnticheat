/*    */ package org.apache.commons.lang3.builder;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.lang3.ClassUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecursiveToStringStyle
/*    */   extends ToStringStyle
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void appendDetail(StringBuffer buffer, String fieldName, Object value) {
/* 70 */     if (!ClassUtils.isPrimitiveWrapper(value.getClass()) && 
/* 71 */       !String.class.equals(value.getClass()) && 
/* 72 */       accept(value.getClass())) {
/* 73 */       buffer.append(ReflectionToStringBuilder.toString(value, this));
/*    */     } else {
/* 75 */       super.appendDetail(buffer, fieldName, value);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
/* 81 */     appendClassName(buffer, coll);
/* 82 */     appendIdentityHashCode(buffer, coll);
/* 83 */     appendDetail(buffer, fieldName, coll.toArray());
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
/*    */   
/*    */   protected boolean accept(Class<?> clazz) {
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\builder\RecursiveToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */