/*    */ package javax.annotation;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import javax.annotation.meta.TypeQualifier;
/*    */ import javax.annotation.meta.TypeQualifierValidator;
/*    */ import javax.annotation.meta.When;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @TypeQualifier(applicableTo = Number.class)
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface Nonnegative
/*    */ {
/*    */   When when() default When.ALWAYS;
/*    */   
/*    */   public static class Checker
/*    */     implements TypeQualifierValidator<Nonnegative>
/*    */   {
/*    */     public When forConstantValue(Nonnegative annotation, Object v) {
/*    */       boolean isNegative;
/* 25 */       if (!(v instanceof Number)) {
/* 26 */         return When.NEVER;
/*    */       }
/* 28 */       Number value = (Number)v;
/* 29 */       if (value instanceof Long) {
/* 30 */         isNegative = (value.longValue() < 0L);
/* 31 */       } else if (value instanceof Double) {
/* 32 */         isNegative = (value.doubleValue() < 0.0D);
/* 33 */       } else if (value instanceof Float) {
/* 34 */         isNegative = (value.floatValue() < 0.0F);
/*    */       } else {
/* 36 */         isNegative = (value.intValue() < 0);
/*    */       } 
/* 38 */       if (isNegative) {
/* 39 */         return When.NEVER;
/*    */       }
/* 41 */       return When.ALWAYS;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\javax\annotation\Nonnegative.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */