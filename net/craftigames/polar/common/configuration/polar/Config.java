/*    */ package net.craftigames.polar.common.configuration.polar;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import net.craftigames.polar.common.configuration.ConfigSettings;
/*    */ import net.craftigames.polar.common.configuration.Configuration;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*    */ import net.craftigames.polar.common.configuration.annotations.AnnotatedField;
/*    */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*    */ 
/*    */ public interface Config
/*    */   extends ConfigurationSection, ConfigHelper
/*    */ {
/*    */   void saveConfig();
/*    */   
/*    */   void reloadConfig();
/*    */   
/*    */   void loadDefaultConfig();
/*    */   
/*    */   FileConfiguration getConfig();
/*    */   
/*    */   Configuration getDefaults();
/*    */   
/*    */   default Set<AnnotatedField> findAnnotatedValues(Class<?> clazz, Class<? extends Annotation> ann) {
/* 27 */     Set<AnnotatedField> set = new HashSet<>();
/* 28 */     Class<?> c = clazz;
/* 29 */     while (c != null) {
/* 30 */       for (Field field : c.getDeclaredFields()) {
/* 31 */         if (field.isAnnotationPresent(ann)) {
/* 32 */           set.add(new AnnotatedField(field, field.getAnnotation((Class)ann)));
/*    */         }
/*    */       } 
/* 35 */       c = c.getSuperclass();
/*    */     } 
/* 37 */     return set;
/*    */   }
/*    */   
/*    */   void loadAnnotated(ConfigSettings paramConfigSettings);
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\polar\Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */