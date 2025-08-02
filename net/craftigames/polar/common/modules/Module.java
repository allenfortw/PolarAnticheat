/*     */ package net.craftigames.polar.common.modules;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Supplier;
/*     */ import net.craftigames.polar.common.Core;
/*     */ import net.craftigames.polar.common.command.GameCommandHandler;
/*     */ import net.craftigames.polar.common.command.PolarCommand;
/*     */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*     */ import net.craftigames.polar.common.configuration.polar.Config;
/*     */ import net.craftigames.polar.common.configuration.polar.ConfigHelper;
/*     */ import net.craftigames.polar.common.core.Reloadable;
/*     */ import net.craftigames.polar.common.util.scheduler.ScheduledTask;
/*     */ 
/*     */ public abstract class Module
/*     */   implements Reloadable, ConfigHelper
/*     */ {
/*     */   public void setOverride(boolean override) {
/*  21 */     this.override = override; } public void setFailedToStart(boolean failedToStart) { this.failedToStart = failedToStart; } public void setForceEnable(boolean forceEnable) { this.forceEnable = forceEnable; } public void setEnabledByDefault(boolean isEnabledByDefault) { this.isEnabledByDefault = isEnabledByDefault; } public void setSuccessfullyEnabled(boolean successfullyEnabled) { this.successfullyEnabled = successfullyEnabled; } public void setVersion(String version) { this.version = version; } public void setCommandList(List<PolarCommand> commandList) { this.commandList = commandList; } public void setTaskList(List<ScheduledTask> taskList) { this.taskList = taskList; } public void setDebug(boolean debug) { this.debug = debug; } public void setName(String name) { this.name = name; } public void setModuleConfig(ModuleConfig moduleConfig) { this.moduleConfig = moduleConfig; }
/*     */   
/*     */   private boolean override = false; private boolean failedToStart = false;
/*  24 */   public boolean isOverride() { return this.override; }
/*  25 */   private boolean forceEnable = false; public boolean isFailedToStart() { return this.failedToStart; } public boolean isForceEnable() {
/*  26 */     return this.forceEnable; } private boolean isEnabledByDefault = false; public boolean isEnabledByDefault() {
/*  27 */     return this.isEnabledByDefault;
/*     */   } private boolean successfullyEnabled = false; private String version; public boolean isSuccessfullyEnabled() {
/*  29 */     return this.successfullyEnabled;
/*     */   } public String getVersion() {
/*  31 */     return this.version;
/*     */   }
/*  33 */   private List<PolarCommand> commandList = new ArrayList<>(); public List<PolarCommand> getCommandList() { return this.commandList; }
/*  34 */    protected List<ScheduledTask> taskList = new ArrayList<>(); public List<ScheduledTask> getTaskList() { return this.taskList; }
/*     */   
/*     */   private boolean debug = false; private String name; private ModuleConfig moduleConfig;
/*     */   
/*     */   public boolean isDebug() {
/*  39 */     return this.debug;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleEnable() {
/*  50 */     onEnable();
/*  51 */     setSuccessfullyEnabled(true);
/*     */   }
/*     */   
/*     */   public void handleDisable(boolean onDisableLater) {
/*  55 */     onDisable();
/*     */ 
/*     */     
/*  58 */     if (onDisableLater) {
/*  59 */       onDisableLater();
/*     */     }
/*  61 */     setSuccessfullyEnabled(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnableLater() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadConfig() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void reloadConfig() {
/*  86 */     getConfig().reloadConfig();
/*     */   }
/*     */   
/*     */   public void saveConfig() {
/*  90 */     getConfig().saveConfig();
/*     */   }
/*     */   
/*     */   public boolean isEnabled() {
/*  94 */     return isEnabled(false);
/*     */   }
/*     */   
/*     */   public Config getConfig() {
/*  98 */     return (Config)getModuleConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfiguration getFileConfiguration() {
/* 103 */     return getConfig().getFileConfiguration();
/*     */   }
/*     */   
/*     */   public String getName() {
/* 107 */     if (this.name == null) {
/* 108 */       this.name = getClass().getSimpleName();
/* 109 */       if (this.name.endsWith("Module")) {
/* 110 */         this.name = this.name.substring(0, this.name.length() - 6);
/*     */       }
/* 112 */       if (this.name.endsWith("System")) {
/* 113 */         this.name = this.name.substring(0, this.name.length() - "System".length());
/*     */       }
/*     */     } 
/* 116 */     return this.name;
/*     */   }
/*     */   
/*     */   private ModuleConfig getModuleConfig() {
/* 120 */     if (this.moduleConfig == null) {
/* 121 */       this.moduleConfig = setupConfig();
/*     */     }
/* 123 */     return this.moduleConfig;
/*     */   }
/*     */   
/*     */   public void error(String s) {
/* 127 */     Core.getPolarCore().getPolarLogger().warn("[" + getName() + "] " + s);
/*     */   }
/*     */   
/*     */   public void exception(Throwable t) {
/* 131 */     Core.getPolarCore().getPolarLogger().warn("[" + getName() + "] ", t);
/*     */   }
/*     */   
/*     */   public void log(String s) {
/* 135 */     Core.getPolarCore().getPolarLogger().info("[" + getName() + "] " + s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Supplier<String> s) {
/* 142 */     if (isDebug()) {
/* 143 */       Core.getPolarCore().getPolarLogger().info("[" + getName() + "] " + (String)s.get());
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug(String s) {
/* 148 */     if (isDebug()) {
/* 149 */       Core.getPolarCore().getPolarLogger().debug("[" + getName() + "] " + s);
/*     */     }
/*     */   }
/*     */   
/*     */   public ModuleConfig defaultConfig() {
/* 154 */     if (this.moduleConfig == null) {
/* 155 */       this.moduleConfig = new ModuleConfig(this);
/*     */     }
/* 157 */     return this.moduleConfig;
/*     */   }
/*     */   
/*     */   public boolean isEnabled(boolean silent) {
/* 161 */     if (this.forceEnable) {
/* 162 */       return true;
/*     */     }
/*     */     
/* 165 */     if (getConfig() == null) {
/* 166 */       if (isOverride()) {
/* 167 */         return true;
/*     */       }
/*     */       
/* 170 */       if (!silent) {
/* 171 */         log("module config is null");
/*     */       }
/* 173 */       return false;
/*     */     } 
/*     */     
/* 176 */     if (getModuleConfig().isEnabled()) {
/* 177 */       return true;
/*     */     }
/*     */     
/* 180 */     if (!silent) {
/* 181 */       log("not enabled.");
/*     */     }
/*     */     
/* 184 */     return false;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void handleOnDisable() {
/* 189 */     onDisable();
/* 190 */     onDisableLater();
/*     */   }
/*     */   
/*     */   public void onDisableLater() {
/* 194 */     int commands = 0;
/* 195 */     for (PolarCommand command : this.commandList) {
/* 196 */       GameCommandHandler.getInstance().unregisterCommand(command);
/* 197 */       commands++;
/*     */     } 
/* 199 */     this.commandList.clear();
/* 200 */     log("Unregistered " + commands + " commands.");
/*     */   }
/*     */   
/*     */   public void registerCommand(PolarCommand... commands) {
/* 204 */     for (PolarCommand command : commands) {
/* 205 */       GameCommandHandler.getInstance().registerCommand(command);
/*     */     }
/* 207 */     this.commandList.addAll(Arrays.asList(commands));
/*     */   }
/*     */   
/*     */   public void registerTask(ScheduledTask... tasks) {
/* 211 */     this.taskList.addAll(Arrays.asList(tasks));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 216 */     if (this == o) return true; 
/* 217 */     if (o == null || getClass() != o.getClass()) return false; 
/* 218 */     Module module = (Module)o;
/* 219 */     return Objects.equals(getName(), module.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 224 */     return Objects.hash(new Object[] { getName() });
/*     */   }
/*     */   
/*     */   public abstract ModuleConfig setupConfig();
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */