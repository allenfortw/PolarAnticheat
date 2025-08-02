/*    */ package net.craftigames.polar.common.configuration.annotations;
/*    */ import java.lang.reflect.Field;
/*    */ 
/*    */ public class AnnotatedField {
/*    */   private final Field field;
/*    */   private final Annotation annotation;
/*    */   
/*    */   public AnnotatedField(Field field, Annotation annotation) {
/*  9 */     this.field = field; this.annotation = annotation;
/*    */   }
/*    */   
/*    */   public Field getField() {
/* 13 */     return this.field; } public Annotation getAnnotation() {
/* 14 */     return this.annotation;
/*    */   }
/*    */   public <T extends Annotation> T as(Class<T> clazz) {
/* 17 */     if (clazz.isInstance(this.annotation)) {
/* 18 */       return clazz.cast(this.annotation);
/*    */     }
/* 20 */     throw new UnsupportedOperationException(this.field.getName() + ":" + this.annotation.getClass().getName() + " - Can not get it as this annotation");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\annotations\AnnotatedField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */