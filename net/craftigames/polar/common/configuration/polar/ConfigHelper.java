/*     */ package net.craftigames.polar.common.configuration.polar;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*     */ import net.craftigames.polar.common.configuration.polar.exception.ConfigItemNotFoundException;
/*     */ import net.craftigames.polar.common.util.NumberConversions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ConfigHelper
/*     */ {
/*     */   FileConfiguration getFileConfiguration();
/*     */   
/*     */   default int getIdFromConfigIndex(String configKey) throws ConfigItemNotFoundException {
/*     */     int id;
/*     */     try {
/*  20 */       id = Integer.parseInt(configKey);
/*  21 */     } catch (NumberFormatException e) {
/*  22 */       throw new ConfigItemNotFoundException("id", configKey);
/*     */     } 
/*  24 */     return id;
/*     */   }
/*     */ 
/*     */   
/*     */   default String getConfigString(String path, String item) throws ConfigItemNotFoundException {
/*  29 */     String s = getFileConfiguration().getString(path + item, null);
/*  30 */     if (s == null) {
/*  31 */       handleExceptions(path, item);
/*     */     }
/*  33 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   default int getConfigInt(String path, String item) throws ConfigItemNotFoundException {
/*  39 */     Integer i = getInt(path + item, null);
/*  40 */     if (i == null) {
/*  41 */       handleExceptions(path, item);
/*     */     }
/*  43 */     return i.intValue();
/*     */   }
/*     */   
/*     */   default Integer getInt(String path, Integer def) {
/*  47 */     Object val = getFileConfiguration().get(path, def);
/*  48 */     return Integer.valueOf((val instanceof Number) ? NumberConversions.toInt(val) : def.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default double getConfigDouble(String path, String item) throws ConfigItemNotFoundException {
/*  55 */     Double i = getDouble(path + item, null);
/*  56 */     if (i == null) {
/*  57 */       handleExceptions(path, item);
/*     */     }
/*  59 */     return i.doubleValue();
/*     */   }
/*     */   
/*     */   default double getConfigDouble(String path, String item, double def) {
/*  63 */     return getFileConfiguration().getDouble(path + item, def);
/*     */   }
/*     */   
/*     */   default Double getDouble(String path, Double def) {
/*  67 */     Object val = getFileConfiguration().get(path, def);
/*  68 */     return Double.valueOf((val instanceof Number) ? NumberConversions.toDouble(val) : def.doubleValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean getConfigBoolean(String path, String item) throws ConfigItemNotFoundException {
/*  75 */     if (!getFileConfiguration().contains(path + item)) {
/*  76 */       handleExceptions(path, item);
/*     */     }
/*  78 */     return getFileConfiguration().getBoolean(path + item);
/*     */   }
/*     */   
/*     */   default boolean getConfigBoolean(String path, String item, boolean def) {
/*  82 */     return getFileConfiguration().getBoolean(path + item, def);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default List<String> getConfigStringList(String path, String item) throws ConfigItemNotFoundException {
/*  89 */     List<String> list = getFileConfiguration().getStringList(path + item);
/*  90 */     if (list == null) {
/*  91 */       handleExceptions(path, item);
/*     */     }
/*  93 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default void handleExceptions(String path, String item) throws ConfigItemNotFoundException {
/* 100 */     throw new ConfigItemNotFoundException("cannot find in '" + path + item + "' in the configuration.");
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\polar\ConfigHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */