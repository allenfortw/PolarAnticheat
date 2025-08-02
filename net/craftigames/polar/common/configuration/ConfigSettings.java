/*    */ package net.craftigames.polar.common.configuration;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.attribute.FileAttribute;
/*    */ import net.craftigames.polar.common.configuration.polar.PolarConfig;
/*    */ 
/*    */ public class ConfigSettings {
/*    */   private final PolarConfig config;
/*    */   private final Path path;
/*    */   
/* 13 */   public PolarConfig getConfig() { return this.config; } public Path getPath() {
/* 14 */     return this.path;
/*    */   }
/*    */   public ConfigSettings(Path path, String name) {
/* 17 */     Path defaultFile = path.resolve(name + ".yml");
/*    */     
/* 19 */     if (!Files.exists(defaultFile, new java.nio.file.LinkOption[0])) {
/*    */       try {
/* 21 */         Files.createFile(defaultFile, (FileAttribute<?>[])new FileAttribute[0]);
/* 22 */       } catch (IOException e) {
/* 23 */         e.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 27 */     this.config = new PolarConfig(defaultFile);
/* 28 */     this.path = path;
/*    */   }
/*    */   
/*    */   public void load() {
/* 32 */     this.config.loadAnnotated(this);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\ConfigSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */