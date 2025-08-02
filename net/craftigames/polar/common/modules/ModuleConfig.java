/*    */ package net.craftigames.polar.common.modules;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*    */ import net.craftigames.polar.common.configuration.polar.PolarConfig;
/*    */ 
/*    */ public class ModuleConfig extends PolarConfig {
/*    */   private final String name;
/*    */   
/*    */   @Nullable
/*    */   public Module getModule() {
/* 12 */     return this.module;
/*    */   } @Nullable
/*    */   private final Module module; public ModuleConfig(Module module) {
/* 15 */     super("modules", module.getName().toLowerCase());
/* 16 */     this.module = module;
/* 17 */     this.name = module.getName();
/* 18 */     loadDefaultConfig();
/*    */   }
/*    */   
/*    */   public void defaultHeader(String explain) {
/* 22 */     header(new String[] { this.name + " main configuration", "Created by CraftiMex", "", explain });
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadDefaultConfig() {
/* 27 */     FileConfiguration file = getConfig();
/* 28 */     defaultHeader();
/*    */     
/* 30 */     if (this.module != null) {
/* 31 */       file.addDefault("enabled", Boolean.valueOf(this.module.isEnabledByDefault()));
/*    */     } else {
/* 33 */       file.addDefault("enabled", Boolean.valueOf(false));
/*    */     } 
/*    */     
/* 36 */     addToFile(file);
/*    */     
/* 38 */     file.options().copyDefaults(true);
/* 39 */     saveConfig();
/* 40 */     reloadConfig();
/*    */   }
/*    */   
/*    */   public void addMessage(String key, Object value) {
/* 44 */     addDefault("messages." + key, value);
/*    */   }
/*    */   
/*    */   public void addSound(String key, Object value) {
/* 48 */     addDefault("sounds." + key, value);
/*    */   }
/*    */ 
/*    */   
/*    */   public <T extends Module> T getModule(Class<T> clazz) {
/* 53 */     if (clazz.isInstance(this.module)) {
/* 54 */       return clazz.cast(this.module);
/*    */     }
/* 56 */     return null;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 60 */     return getConfig().getBoolean("enabled", false);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\ModuleConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */