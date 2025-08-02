/*     */ package net.craftigames.polar.common.configuration.file;
/*     */ 
/*     */ import net.craftigames.polar.common.configuration.Configuration;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationOptions;
/*     */ import net.craftigames.polar.common.configuration.MemoryConfiguration;
/*     */ import net.craftigames.polar.common.configuration.MemoryConfigurationOptions;
/*     */ 
/*     */ 
/*     */ public class FileConfigurationOptions
/*     */   extends MemoryConfigurationOptions
/*     */ {
/*  12 */   private String header = null;
/*     */   private boolean copyHeader = true;
/*     */   
/*     */   protected FileConfigurationOptions(MemoryConfiguration configuration) {
/*  16 */     super(configuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfiguration configuration() {
/*  21 */     return (FileConfiguration)super.configuration();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfigurationOptions copyDefaults(boolean value) {
/*  26 */     super.copyDefaults(value);
/*  27 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfigurationOptions pathSeparator(char value) {
/*  32 */     super.pathSeparator(value);
/*  33 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String header() {
/*  51 */     return this.header;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileConfigurationOptions header(String value) {
/*  70 */     this.header = value;
/*  71 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean copyHeader() {
/*  87 */     return this.copyHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileConfigurationOptions copyHeader(boolean value) {
/* 104 */     this.copyHeader = value;
/*     */     
/* 106 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\file\FileConfigurationOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */