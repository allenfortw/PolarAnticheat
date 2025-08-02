/*    */ package net.craftigames.polar.common.configuration;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigurationOptions
/*    */ {
/*  9 */   private char pathSeparator = '.';
/*    */   private boolean copyDefaults = false;
/*    */   private final Configuration configuration;
/*    */   
/*    */   protected ConfigurationOptions(Configuration configuration) {
/* 14 */     this.configuration = configuration;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Configuration configuration() {
/* 23 */     return this.configuration;
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
/*    */   
/*    */   public char pathSeparator() {
/* 36 */     return this.pathSeparator;
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
/*    */ 
/*    */   
/*    */   public ConfigurationOptions pathSeparator(char value) {
/* 50 */     this.pathSeparator = value;
/* 51 */     return this;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean copyDefaults() {
/* 69 */     return this.copyDefaults;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ConfigurationOptions copyDefaults(boolean value) {
/* 88 */     this.copyDefaults = value;
/* 89 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\ConfigurationOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */