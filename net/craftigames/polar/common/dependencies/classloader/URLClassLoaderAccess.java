/*     */ package net.craftigames.polar.common.dependencies.classloader;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.Collection;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class URLClassLoaderAccess
/*     */ {
/*     */   private final URLClassLoader classLoader;
/*     */   
/*     */   static URLClassLoaderAccess create(URLClassLoader classLoader) {
/*  24 */     if (Reflection.isSupported())
/*  25 */       return new Reflection(classLoader); 
/*  26 */     if (Unsafe.isSupported()) {
/*  27 */       return new Unsafe(classLoader);
/*     */     }
/*  29 */     return Noop.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected URLClassLoaderAccess(URLClassLoader classLoader) {
/*  36 */     this.classLoader = classLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void addURL(@Nonnull URL paramURL);
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Reflection
/*     */     extends URLClassLoaderAccess
/*     */   {
/*     */     private static final Method ADD_URL_METHOD;
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       Method addUrlMethod;
/*     */       try {
/*  56 */         addUrlMethod = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
/*  57 */         addUrlMethod.setAccessible(true);
/*  58 */       } catch (Exception e) {
/*  59 */         addUrlMethod = null;
/*     */       } 
/*  61 */       ADD_URL_METHOD = addUrlMethod;
/*     */     }
/*     */     
/*     */     private static boolean isSupported() {
/*  65 */       return (ADD_URL_METHOD != null);
/*     */     }
/*     */     
/*     */     Reflection(URLClassLoader classLoader) {
/*  69 */       super(classLoader);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addURL(@Nonnull URL url) {
/*     */       try {
/*  75 */         ADD_URL_METHOD.invoke(this.classLoader, new Object[] { url });
/*  76 */       } catch (ReflectiveOperationException e) {
/*  77 */         throw new RuntimeException(e);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Unsafe
/*     */     extends URLClassLoaderAccess
/*     */   {
/*     */     private static final Object UNSAFE;
/*     */     private static Method UNSAFE_OBJECTFIELDOFFSET;
/*     */     private static Method UNSAFE_GETOBJECT;
/*     */     private final Collection<URL> unopenedURLs;
/*     */     private final Collection<URL> pathURLs;
/*     */     
/*     */     static {
/*     */       Object unsafe;
/*     */       try {
/*  95 */         Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
/*  96 */         Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
/*  97 */         unsafeField.setAccessible(true);
/*  98 */         unsafe = unsafeField.get(null);
/*     */         
/* 100 */         UNSAFE_OBJECTFIELDOFFSET = unsafeClass.getMethod("objectFieldOffset", new Class[] { Field.class });
/* 101 */         UNSAFE_GETOBJECT = unsafeClass.getMethod("getObject", new Class[] { Object.class, long.class });
/* 102 */       } catch (Throwable t) {
/* 103 */         unsafe = null;
/*     */       } 
/* 105 */       UNSAFE = unsafe;
/*     */     }
/*     */     
/*     */     private static boolean isSupported() {
/* 109 */       return (UNSAFE != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Unsafe(URLClassLoader classLoader) {
/* 117 */       super(classLoader);
/*     */       
/*     */       Collection<URL> unopenedURLs, pathURLs;
/*     */       
/*     */       try {
/* 122 */         Object ucp = fetchField(URLClassLoader.class, classLoader, "ucp");
/* 123 */         unopenedURLs = (Collection<URL>)fetchField(ucp.getClass(), ucp, "unopenedUrls");
/* 124 */         pathURLs = (Collection<URL>)fetchField(ucp.getClass(), ucp, "path");
/* 125 */       } catch (Throwable e) {
/* 126 */         unopenedURLs = null;
/* 127 */         pathURLs = null;
/*     */       } 
/* 129 */       this.unopenedURLs = unopenedURLs;
/* 130 */       this.pathURLs = pathURLs;
/*     */     }
/*     */     
/*     */     private static Object fetchField(Class<?> clazz, Object object, String name) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
/* 134 */       Field field = clazz.getDeclaredField(name);
/*     */ 
/*     */       
/* 137 */       long offset = ((Long)UNSAFE_OBJECTFIELDOFFSET.invoke(UNSAFE, new Object[] { field })).longValue();
/* 138 */       return UNSAFE_GETOBJECT.invoke(UNSAFE, new Object[] { object, Long.valueOf(offset) });
/*     */     }
/*     */ 
/*     */     
/*     */     public void addURL(@Nonnull URL url) {
/* 143 */       this.unopenedURLs.add(url);
/* 144 */       this.pathURLs.add(url);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Noop extends URLClassLoaderAccess {
/* 149 */     private static final Noop INSTANCE = new Noop();
/*     */     
/*     */     private Noop() {
/* 152 */       super(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addURL(@Nonnull URL url) {
/* 157 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\classloader\URLClassLoaderAccess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */