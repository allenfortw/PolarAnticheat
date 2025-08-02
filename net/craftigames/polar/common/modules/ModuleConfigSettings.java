/*    */ package net.craftigames.polar.common.modules;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ import net.craftigames.polar.common.configuration.polar.Config;
/*    */ 
/*    */ public abstract class ModuleConfigSettings<T extends Module> {
/*    */   private final T module;
/*    */   private final Config config;
/*    */   
/*    */   public T getModule() {
/* 12 */     return this.module; } public Config getConfig() {
/* 13 */     return this.config;
/*    */   }
/* 15 */   private final Map<String, String> messages = Maps.newHashMap(); public Map<String, String> getMessages() { return this.messages; }
/*    */   
/*    */   public ModuleConfigSettings(T module) {
/* 18 */     this.module = module;
/* 19 */     this.config = module.getConfig();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void loadMessages() {
/* 25 */     this.messages.clear();
/* 26 */     if (this.config.contains("messages")) {
/* 27 */       for (String key : this.config.getConfigurationSection("messages").getKeys(false)) {
/* 28 */         this.messages.put(key, this.config.getString("messages." + key));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public String getMessage(String key) {
/* 34 */     return this.messages.get(key);
/*    */   }
/*    */   
/*    */   public abstract void load();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\ModuleConfigSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */