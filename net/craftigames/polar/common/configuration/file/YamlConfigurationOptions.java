/*    */ package net.craftigames.polar.common.configuration.file;
/*    */ 
/*    */ import net.craftigames.polar.common.configuration.Configuration;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationOptions;
/*    */ import net.craftigames.polar.common.configuration.MemoryConfiguration;
/*    */ import net.craftigames.polar.common.configuration.MemoryConfigurationOptions;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ public class YamlConfigurationOptions
/*    */   extends FileConfigurationOptions {
/* 11 */   private int indent = 2;
/*    */   
/*    */   protected YamlConfigurationOptions(YamlConfiguration configuration) {
/* 14 */     super(configuration);
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlConfiguration configuration() {
/* 19 */     return (YamlConfiguration)super.configuration();
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlConfigurationOptions copyDefaults(boolean value) {
/* 24 */     super.copyDefaults(value);
/* 25 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlConfigurationOptions pathSeparator(char value) {
/* 30 */     super.pathSeparator(value);
/* 31 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlConfigurationOptions header(String value) {
/* 36 */     super.header(value);
/* 37 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public YamlConfigurationOptions copyHeader(boolean value) {
/* 42 */     super.copyHeader(value);
/* 43 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int indent() {
/* 54 */     return this.indent;
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
/*    */   public YamlConfigurationOptions indent(int value) {
/* 66 */     Validate.isTrue((value >= 2), "Indent must be at least 2 characters", new Object[0]);
/* 67 */     Validate.isTrue((value <= 9), "Indent cannot be greater than 9 characters", new Object[0]);
/*    */     
/* 69 */     this.indent = value;
/* 70 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\file\YamlConfigurationOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */