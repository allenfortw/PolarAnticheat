/*    */ package net.craftigames.polar.common.modules;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Optional;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import net.craftigames.polar.common.Core;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModuleManager
/*    */ {
/* 15 */   private final List<Module> moduleList = new ArrayList<>(); public List<Module> getModuleList() { return this.moduleList; }
/* 16 */    private final Map<Class<? extends Module>, Module> moduleMap = new ConcurrentHashMap<>(); public Map<Class<? extends Module>, Module> getModuleMap() { return this.moduleMap; }
/*    */   
/*    */   public void registerModule(Module module) {
/* 19 */     registerModule(module, true);
/*    */   }
/*    */   
/*    */   public void registerModule(Module module, boolean fireOnEnable) {
/*    */     try {
/* 24 */       if (!this.moduleList.contains(module)) {
/* 25 */         this.moduleList.add(module);
/*    */       }
/* 27 */       this.moduleMap.put(module.getClass(), module);
/* 28 */       module.setupConfig();
/*    */       
/* 30 */       if (fireOnEnable && (
/* 31 */         module.isEnabled() || module.isOverride())) {
/* 32 */         module.handleEnable();
/*    */       
/*    */       }
/*    */     }
/* 36 */     catch (Throwable e) {
/* 37 */       Core.getPolarCore().getPolarLogger().warn("Can not register the module: " + module.getName(), e);
/* 38 */       module.setFailedToStart(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void unregister() {
/* 44 */     for (Module module : this.moduleList) {
/* 45 */       if (!module.isSuccessfullyEnabled()) {
/*    */         continue;
/*    */       }
/*    */       
/*    */       try {
/* 50 */         module.handleDisable(false);
/* 51 */       } catch (Exception e) {
/* 52 */         Core.getPolarCore().getPolarLogger().warn("Can not disable the module: " + module.getName(), e);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public Module getByName(String name) {
/* 58 */     return this.moduleList.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findAny().orElse(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T extends Module> T get(Class<T> clazz) {
/* 69 */     Module module = this.moduleMap.get(clazz);
/* 70 */     if (module == null) {
/* 71 */       for (Module modules : this.moduleList) {
/* 72 */         if (clazz.isInstance(modules)) {
/* 73 */           return clazz.cast(modules);
/*    */         }
/*    */       } 
/*    */     }
/* 77 */     if (clazz.isInstance(module)) {
/* 78 */       return clazz.cast(module);
/*    */     }
/* 80 */     return null;
/*    */   }
/*    */   
/*    */   public <T extends Module> Optional<T> getModule(Class<T> clazz) {
/* 84 */     T module = get(clazz);
/* 85 */     if (module != null) {
/* 86 */       return Optional.of(module);
/*    */     }
/* 88 */     return Optional.empty();
/*    */   }
/*    */   public <T extends Module> boolean isEnabled(Class<T> clazz) {
/* 91 */     Module module = get(clazz);
/* 92 */     return (module != null && module.isSuccessfullyEnabled());
/*    */   }
/*    */   
/*    */   public boolean isEnabled(String name) {
/* 96 */     Module module = getByName(name);
/* 97 */     return (module != null && module.isSuccessfullyEnabled());
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\ModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */