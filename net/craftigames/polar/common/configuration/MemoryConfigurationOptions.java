/*    */ package net.craftigames.polar.common.configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MemoryConfigurationOptions
/*    */   extends ConfigurationOptions
/*    */ {
/*    */   protected MemoryConfigurationOptions(MemoryConfiguration configuration) {
/* 10 */     super(configuration);
/*    */   }
/*    */ 
/*    */   
/*    */   public MemoryConfiguration configuration() {
/* 15 */     return (MemoryConfiguration)super.configuration();
/*    */   }
/*    */ 
/*    */   
/*    */   public MemoryConfigurationOptions copyDefaults(boolean value) {
/* 20 */     super.copyDefaults(value);
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MemoryConfigurationOptions pathSeparator(char value) {
/* 26 */     super.pathSeparator(value);
/* 27 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\MemoryConfigurationOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */