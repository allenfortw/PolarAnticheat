/*    */ package net.craftigames.polar.common.dependencies.classloader;
/*    */ 
/*    */ import com.google.common.base.Supplier;
/*    */ import com.google.common.base.Suppliers;
/*    */ import java.io.File;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ 
/*    */ public class ReflectionClassLoader
/*    */   implements PluginClassLoader
/*    */ {
/*    */   private final URLClassLoader classLoader;
/*    */   private final Supplier<URLClassLoaderAccess> URL_INJECTOR;
/*    */   
/*    */   public ReflectionClassLoader(Object plugin) throws IllegalStateException {
/* 17 */     ClassLoader classLoader = plugin.getClass().getClassLoader();
/*    */     
/* 19 */     this.URL_INJECTOR = Suppliers.memoize(() -> URLClassLoaderAccess.create((URLClassLoader)classLoader));
/*    */     
/* 21 */     if (classLoader instanceof URLClassLoader) {
/* 22 */       this.classLoader = (URLClassLoader)classLoader;
/*    */     } else {
/* 24 */       throw new IllegalStateException("ClassLoader is not plugin of URLClassLoader but was " + ((classLoader != null) ? classLoader.getClass().getSimpleName() : "null"));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public URLClassLoader getClassLoader() {
/* 30 */     return this.classLoader;
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadJar(URL url) {
/*    */     try {
/* 36 */       ((URLClassLoaderAccess)this.URL_INJECTOR.get()).addURL(url);
/* 37 */     } catch (Exception e) {
/* 38 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadJar(File file) {
/*    */     try {
/* 45 */       loadJar(file.toURI().toURL());
/* 46 */     } catch (MalformedURLException e) {
/* 47 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\classloader\ReflectionClassLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */