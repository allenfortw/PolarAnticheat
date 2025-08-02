/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassPathUtils
/*     */ {
/*     */   public static String toFullyQualifiedName(Class<?> context, String resourceName) {
/*  57 */     Validate.notNull(context, "context", new Object[0]);
/*  58 */     Validate.notNull(resourceName, "resourceName", new Object[0]);
/*  59 */     return toFullyQualifiedName(context.getPackage(), resourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toFullyQualifiedName(Package context, String resourceName) {
/*  79 */     Validate.notNull(context, "context", new Object[0]);
/*  80 */     Validate.notNull(resourceName, "resourceName", new Object[0]);
/*  81 */     return context.getName() + "." + resourceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toFullyQualifiedPath(Class<?> context, String resourceName) {
/* 101 */     Validate.notNull(context, "context", new Object[0]);
/* 102 */     Validate.notNull(resourceName, "resourceName", new Object[0]);
/* 103 */     return toFullyQualifiedPath(context.getPackage(), resourceName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toFullyQualifiedPath(Package context, String resourceName) {
/* 124 */     Validate.notNull(context, "context", new Object[0]);
/* 125 */     Validate.notNull(resourceName, "resourceName", new Object[0]);
/* 126 */     return context.getName().replace('.', '/') + "/" + resourceName;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\ClassPathUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */