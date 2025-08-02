/*    */ package net.craftigames.polar.common.dependencies.relocation;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.EnumSet;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import net.craftigames.polar.common.dependencies.Dependency;
/*    */ import net.craftigames.polar.common.dependencies.DependencyManager;
/*    */ import net.craftigames.polar.common.dependencies.classloader.IsolatedClassLoader;
/*    */ 
/*    */ public class RelocationHandler
/*    */ {
/* 17 */   private static final Set<Dependency> DEPENDENCIES = EnumSet.of(Dependency.ASM, Dependency.ASM_COMMONS, Dependency.JAR_RELOCATOR);
/*    */   
/*    */   private static final String JAR_RELOCATOR_CLASS = "me.lucko.jarrelocator.JarRelocator";
/*    */   
/*    */   private static final String JAR_RELOCATOR_RUN_METHOD = "run";
/*    */   private final Constructor<?> jarRelocatorConstructor;
/*    */   private final Method jarRelocatorRunMethod;
/*    */   
/*    */   public RelocationHandler(DependencyManager dependencyManager) {
/*    */     try {
/* 27 */       dependencyManager.loadDependencies(DEPENDENCIES);
/*    */       
/* 29 */       IsolatedClassLoader classLoader = dependencyManager.obtainClassLoaderWith(DEPENDENCIES);
/*    */ 
/*    */       
/* 32 */       Class<?> jarRelocatorClass = classLoader.loadClass("me.lucko.jarrelocator.JarRelocator");
/*    */ 
/*    */       
/* 35 */       this.jarRelocatorConstructor = jarRelocatorClass.getDeclaredConstructor(new Class[] { File.class, File.class, Map.class });
/* 36 */       this.jarRelocatorConstructor.setAccessible(true);
/*    */       
/* 38 */       this.jarRelocatorRunMethod = jarRelocatorClass.getDeclaredMethod("run", new Class[0]);
/* 39 */       this.jarRelocatorRunMethod.setAccessible(true);
/* 40 */     } catch (Exception e) {
/* 41 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void remap(File input, File output, List<Relocation> relocations) throws Exception {
/* 46 */     Map<String, String> mappings = new HashMap<>();
/* 47 */     for (Relocation relocation : relocations) {
/* 48 */       mappings.put(relocation.getPattern(), relocation.getRelocatedPattern());
/*    */     }
/*    */ 
/*    */     
/* 52 */     Object relocator = this.jarRelocatorConstructor.newInstance(new Object[] { input, output, mappings });
/* 53 */     this.jarRelocatorRunMethod.invoke(relocator, new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\relocation\RelocationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */