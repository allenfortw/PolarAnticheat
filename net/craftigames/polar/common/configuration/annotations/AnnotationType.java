/*    */ package net.craftigames.polar.common.configuration.annotations;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import net.craftigames.polar.common.configuration.ConfigSettings;
/*    */ import net.craftigames.polar.common.configuration.annotations.types.ConfigBoolean;
/*    */ import net.craftigames.polar.common.configuration.annotations.types.ConfigInteger;
/*    */ import net.craftigames.polar.common.configuration.annotations.types.ConfigLong;
/*    */ import net.craftigames.polar.common.configuration.annotations.types.ConfigString;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum AnnotationType
/*    */ {
/* 19 */   BOOLEAN((Class)ConfigBoolean.class, new AnnotationCaster<Boolean>()
/*    */     {
/*    */       public String getKey(AnnotatedField a) {
/* 22 */         return ((ConfigBoolean)a.<ConfigBoolean>as(ConfigBoolean.class)).key();
/*    */       }
/*    */ 
/*    */       
/*    */       public Boolean getDefault(ConfigSettings s, AnnotatedField a) {
/* 27 */         return Boolean.valueOf(((ConfigBoolean)a.<ConfigBoolean>as(ConfigBoolean.class)).defaultValue());
/*    */       }
/*    */     }),
/*    */   
/* 31 */   INTEGER((Class)ConfigInteger.class, new AnnotationCaster<Integer>()
/*    */     {
/*    */       public String getKey(AnnotatedField a) {
/* 34 */         return ((ConfigInteger)a.<ConfigInteger>as(ConfigInteger.class)).key();
/*    */       }
/*    */ 
/*    */       
/*    */       public Integer getDefault(ConfigSettings s, AnnotatedField a) {
/* 39 */         return Integer.valueOf(((ConfigInteger)a.<ConfigInteger>as(ConfigInteger.class)).defaultValue());
/*    */       }
/*    */     }),
/*    */   
/* 43 */   LONG((Class)ConfigLong.class, new AnnotationCaster<Long>()
/*    */     {
/*    */       public String getKey(AnnotatedField a) {
/* 46 */         return ((ConfigLong)a.<ConfigLong>as(ConfigLong.class)).key();
/*    */       }
/*    */ 
/*    */       
/*    */       public Long getDefault(ConfigSettings s, AnnotatedField a) {
/* 51 */         return Long.valueOf(((ConfigLong)a.<ConfigLong>as(ConfigLong.class)).defaultValue());
/*    */       }
/*    */     }),
/*    */ 
/*    */   
/* 56 */   STRING((Class)ConfigString.class, new AnnotationCaster<String>()
/*    */     {
/*    */       public String getKey(AnnotatedField a) {
/* 59 */         return ((ConfigString)a.<ConfigString>as(ConfigString.class)).key();
/*    */       }
/*    */       
/*    */       public String getDefault(ConfigSettings s, AnnotatedField a)
/*    */       {
/* 64 */         return ((ConfigString)a.<ConfigString>as(ConfigString.class)).defaultValue(); }
/*    */     });
/*    */   AnnotationType(Class<? extends Annotation> annotationClass, AnnotationCaster<?> caster) {
/*    */     this.annotationClass = annotationClass;
/*    */     this.caster = caster;
/* 69 */   } public Class<? extends Annotation> getAnnotationClass() { return this.annotationClass; } private final Class<? extends Annotation> annotationClass; private final AnnotationCaster<?> caster; public AnnotationCaster<?> getCaster() {
/* 70 */     return this.caster;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\annotations\AnnotationType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */