/*    */ package net.craftigames.polar.common.configuration.annotations;
/*    */ 
/*    */ import net.craftigames.polar.common.configuration.ConfigSettings;
/*    */ 
/*    */ public interface AnnotationCaster<T>
/*    */ {
/*    */   String getKey(AnnotatedField paramAnnotatedField);
/*    */   
/*    */   default T getOrDefault(ConfigSettings s, AnnotatedField a) {
/* 10 */     return (T)s.getConfig().get(getKey(a), getDefault(s, a));
/*    */   }
/*    */   
/*    */   T getDefault(ConfigSettings paramConfigSettings, AnnotatedField paramAnnotatedField);
/*    */   
/*    */   default boolean load(ConfigSettings settings, AnnotatedField annotatedValue, Object value) {
/* 16 */     String key = getKey(annotatedValue);
/* 17 */     if (!settings.getConfig().contains(key)) {
/* 18 */       settings.getConfig().set(key, value);
/* 19 */       return true;
/*    */     } 
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   default void setField(ConfigSettings settings, AnnotatedField annotatedValue, Object value) {
/*    */     try {
/* 26 */       annotatedValue.getField().setAccessible(true);
/* 27 */       annotatedValue.getField().set(settings, value);
/* 28 */     } catch (IllegalAccessException e) {
/* 29 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\annotations\AnnotationCaster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */