/*    */ package net.craftigames.polar.common.configuration;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang3.Validate;
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
/*    */ public class MemoryConfiguration
/*    */   extends MemorySection
/*    */   implements Configuration
/*    */ {
/*    */   protected Configuration defaults;
/*    */   protected MemoryConfigurationOptions options;
/*    */   
/*    */   public MemoryConfiguration() {}
/*    */   
/*    */   public MemoryConfiguration(Configuration defaults) {
/* 30 */     this.defaults = defaults;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addDefault(String path, Object value) {
/* 35 */     Validate.notNull(path, "Path may not be null", new Object[0]);
/*    */     
/* 37 */     if (this.defaults == null) {
/* 38 */       this.defaults = new MemoryConfiguration();
/*    */     }
/*    */     
/* 41 */     this.defaults.set(path, value);
/*    */   }
/*    */   
/*    */   public void addDefaults(Map<String, Object> defaults) {
/* 45 */     Validate.notNull(defaults, "Defaults may not be null", new Object[0]);
/*    */     
/* 47 */     for (Map.Entry<String, Object> entry : defaults.entrySet()) {
/* 48 */       addDefault(entry.getKey(), entry.getValue());
/*    */     }
/*    */   }
/*    */   
/*    */   public void addDefaults(Configuration defaults) {
/* 53 */     Validate.notNull(defaults, "Defaults may not be null", new Object[0]);
/*    */     
/* 55 */     addDefaults(defaults.getValues(true));
/*    */   }
/*    */   
/*    */   public void setDefaults(Configuration defaults) {
/* 59 */     Validate.notNull(defaults, "Defaults may not be null", new Object[0]);
/*    */     
/* 61 */     this.defaults = defaults;
/*    */   }
/*    */   
/*    */   public Configuration getDefaults() {
/* 65 */     return this.defaults;
/*    */   }
/*    */ 
/*    */   
/*    */   public ConfigurationSection getParent() {
/* 70 */     return null;
/*    */   }
/*    */   
/*    */   public MemoryConfigurationOptions options() {
/* 74 */     if (this.options == null) {
/* 75 */       this.options = new MemoryConfigurationOptions(this);
/*    */     }
/*    */     
/* 78 */     return this.options;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\MemoryConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */