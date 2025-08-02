/*    */ package net.craftigames.polar.common.dependencies.classloader;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IsolatedClassLoader
/*    */   extends URLClassLoader
/*    */ {
/*    */   static {
/* 16 */     ClassLoader.registerAsParallelCapable();
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
/*    */   public IsolatedClassLoader(URL[] urls) {
/* 28 */     super(urls, ClassLoader.getSystemClassLoader().getParent());
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\classloader\IsolatedClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */