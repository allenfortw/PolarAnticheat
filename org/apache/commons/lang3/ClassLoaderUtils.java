/*    */ package org.apache.commons.lang3;
/*    */ 
/*    */ import java.net.URLClassLoader;
/*    */ import java.util.Arrays;
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
/*    */ public class ClassLoaderUtils
/*    */ {
/*    */   public static String toString(ClassLoader classLoader) {
/* 37 */     if (classLoader instanceof URLClassLoader) {
/* 38 */       return toString((URLClassLoader)classLoader);
/*    */     }
/* 40 */     return classLoader.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String toString(URLClassLoader classLoader) {
/* 51 */     return classLoader + Arrays.toString((Object[])classLoader.getURLs());
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\ClassLoaderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */