/*    */ package javax.annotation;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ import java.util.regex.Pattern;
/*    */ import javax.annotation.meta.TypeQualifier;
/*    */ import javax.annotation.meta.TypeQualifierValidator;
/*    */ import javax.annotation.meta.When;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Documented
/*    */ @TypeQualifier(applicableTo = String.class)
/*    */ @Retention(RetentionPolicy.RUNTIME)
/*    */ public @interface MatchesPattern
/*    */ {
/*    */   @RegEx
/*    */   String value();
/*    */   
/*    */   int flags() default 0;
/*    */   
/*    */   public static class Checker
/*    */     implements TypeQualifierValidator<MatchesPattern>
/*    */   {
/*    */     public When forConstantValue(MatchesPattern annotation, Object value) {
/* 28 */       Pattern p = Pattern.compile(annotation.value(), annotation.flags());
/* 29 */       if (p.matcher((String)value).matches())
/* 30 */         return When.ALWAYS; 
/* 31 */       return When.NEVER;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\javax\annotation\MatchesPattern.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */