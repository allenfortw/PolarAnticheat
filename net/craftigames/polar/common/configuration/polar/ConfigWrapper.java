/*    */ package net.craftigames.polar.common.configuration.polar;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*    */ import net.craftigames.polar.common.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ public class ConfigWrapper
/*    */ {
/*    */   private final String folderName;
/*    */   private final String fileName;
/*    */   private FileConfiguration config;
/*    */   private File configFile;
/*    */   
/*    */   public ConfigWrapper(String folderName, String fileName) {
/* 18 */     this.folderName = folderName;
/* 19 */     this.fileName = fileName + (fileName.endsWith(".yml") ? "" : ".yml");
/*    */   }
/*    */   
/*    */   public ConfigWrapper(Path path) {
/* 23 */     this.folderName = (path.getParent() != null) ? path.getParent().toString() : null;
/* 24 */     this.fileName = path.getFileName().toString() + (path.getFileName().toString().endsWith(".yml") ? "" : ".yml");
/*    */   }
/*    */   
/*    */   public FileConfiguration getConfig() {
/* 28 */     if (this.config == null) {
/* 29 */       reloadConfig();
/*    */     }
/* 31 */     return this.config;
/*    */   }
/*    */   
/*    */   public void reloadConfig() {
/* 35 */     if (this.configFile == null) {
/* 36 */       if (this.folderName == null || this.folderName.isEmpty()) {
/* 37 */         this.configFile = new File(this.fileName);
/*    */       } else {
/* 39 */         this.configFile = new File(this.folderName, this.fileName);
/*    */       } 
/*    */     }
/* 42 */     this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(this.configFile);
/*    */   }
/*    */   
/*    */   public void saveConfig() {
/* 46 */     if (this.config == null || this.configFile == null) {
/* 47 */       System.out.println("Could not save  " + this.fileName);
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 52 */       getConfig().save(this.configFile);
/* 53 */     } catch (IOException ex) {
/* 54 */       ex.printStackTrace();
/* 55 */       System.out.println("Could not save config to " + this.configFile);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\polar\ConfigWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */