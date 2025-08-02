/*     */ package net.craftigames.polar.common.configuration.polar;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.craftigames.polar.common.configuration.ConfigSettings;
/*     */ import net.craftigames.polar.common.configuration.Configuration;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*     */ import net.craftigames.polar.common.configuration.annotations.AnnotatedField;
/*     */ import net.craftigames.polar.common.configuration.annotations.AnnotationType;
/*     */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*     */ import net.craftigames.polar.common.core.menu.PolarItemStack;
/*     */ 
/*     */ public class PolarConfig
/*     */   implements Config
/*     */ {
/*     */   private String name;
/*     */   private ConfigWrapper wrapper;
/*     */   
/*     */   public PolarConfig(String folder, String name) {
/*  22 */     this.name = name;
/*  23 */     this.wrapper = new ConfigWrapper(folder, name + ".yml");
/*     */   }
/*     */   
/*     */   public PolarConfig(Path path) {
/*  27 */     this.name = path.getFileName().toString().replace(".yml", "");
/*  28 */     this.wrapper = new ConfigWrapper(path);
/*     */   }
/*     */   
/*     */   public PolarConfig(String name) {
/*  32 */     this(null, name);
/*     */   }
/*     */   
/*     */   public void header(String... headers) {
/*  36 */     StringBuilder sb = new StringBuilder();
/*     */     
/*  38 */     for (String s : headers) {
/*  39 */       sb.append(s).append("\n");
/*     */     }
/*     */     
/*  42 */     getConfig().options().header(sb.toString());
/*     */   }
/*     */   
/*     */   public void loadDefaultConfig() {
/*  46 */     FileConfiguration file = getConfig();
/*  47 */     defaultHeader();
/*     */     
/*  49 */     addToFile(file);
/*     */     
/*  51 */     save();
/*     */   }
/*     */   
/*     */   public void save() {
/*  55 */     getConfig().options().copyDefaults(true);
/*  56 */     saveConfig();
/*  57 */     reloadConfig();
/*     */   }
/*     */   
/*     */   public void addItemToFile(String path, PolarItemStack i) {
/*  61 */     i.addToConfig(this, path);
/*     */   }
/*     */   
/*     */   public void defaultHeader() {
/*  65 */     header(new String[] { this.name + " main configuration", "Created by CraftiMex" });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToFile(FileConfiguration file) {}
/*     */ 
/*     */   
/*     */   public FileConfiguration getFileConfiguration() {
/*  74 */     return getConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public FileConfiguration getConfig() {
/*  79 */     return this.wrapper.getConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveConfig() {
/*  84 */     this.wrapper.saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reloadConfig() {
/*  89 */     this.wrapper.reloadConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public Configuration getDefaults() {
/*  94 */     return getConfig().getDefaults();
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadAnnotated(ConfigSettings settings) {
/*  99 */     boolean modified = false;
/* 100 */     for (AnnotationType value : AnnotationType.values()) {
/* 101 */       Set<AnnotatedField> annotatedValues = findAnnotatedValues(settings.getClass(), value.getAnnotationClass());
/* 102 */       for (AnnotatedField annotatedValue : annotatedValues) {
/* 103 */         Object obj = value.getCaster().getOrDefault(settings, annotatedValue);
/* 104 */         if (value.getCaster().load(settings, annotatedValue, obj)) {
/* 105 */           modified = true;
/*     */         }
/* 107 */         value.getCaster().setField(settings, annotatedValue, obj);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 112 */     if (modified) {
/* 113 */       saveConfig();
/* 114 */       reloadConfig();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String path) {
/* 122 */     return getConfig().getString(path);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getString(String path, String def) {
/* 128 */     return getConfig().getString(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble(String path) {
/* 133 */     return getConfig().getDouble(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<String> getKeys(boolean deep) {
/* 138 */     return getConfig().getKeys(deep);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Object> getValues(boolean deep) {
/* 143 */     return getConfig().getValues(deep);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(String path) {
/* 148 */     return getConfig().contains(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSet(String path) {
/* 153 */     return getConfig().isSet(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentPath() {
/* 158 */     return getConfig().getCurrentPath();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 163 */     return getConfig().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public Configuration getRoot() {
/* 168 */     return getConfig().getRoot();
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigurationSection getParent() {
/* 173 */     return getConfig().getParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object get(String path) {
/* 178 */     return getConfig().get(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object get(String path, Object def) {
/* 183 */     return getConfig().get(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(String path, Object value) {
/* 188 */     getConfig().set(path, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigurationSection createSection(String path) {
/* 193 */     return getConfig().createSection(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigurationSection createSection(String path, Map<?, ?> map) {
/* 198 */     return getConfig().createSection(path, map);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isString(String path) {
/* 203 */     return getConfig().isSet(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(String path) {
/* 208 */     return getConfig().getInt(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(String path, int def) {
/* 213 */     return getConfig().getInt(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInt(String path) {
/* 218 */     return getConfig().isSet(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String path) {
/* 223 */     return getConfig().getBoolean(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBoolean(String path, boolean def) {
/* 228 */     return getConfig().getBoolean(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBoolean(String path) {
/* 233 */     return getConfig().isBoolean(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDouble(String path, double def) {
/* 238 */     return getConfig().getDouble(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDouble(String path) {
/* 243 */     return getConfig().isDouble(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String path) {
/* 248 */     return getConfig().getFloat(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String path, float def) {
/* 253 */     return getConfig().getFloat(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFloat(String path) {
/* 258 */     return getConfig().isFloat(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String path) {
/* 263 */     return getConfig().getLong(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String path, long def) {
/* 268 */     return getConfig().getLong(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLong(String path) {
/* 273 */     return getConfig().isLong(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getList(String path) {
/* 278 */     return getConfig().getList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getList(String path, List<?> def) {
/* 283 */     return getConfig().getList(path, def);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isList(String path) {
/* 288 */     return getConfig().isLong(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getStringList(String path) {
/* 293 */     return getConfig().getStringList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Integer> getIntegerList(String path) {
/* 298 */     return getConfig().getIntegerList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Boolean> getBooleanList(String path) {
/* 303 */     return getConfig().getBooleanList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Double> getDoubleList(String path) {
/* 308 */     return getConfig().getDoubleList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Float> getFloatList(String path) {
/* 313 */     return getConfig().getFloatList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Long> getLongList(String path) {
/* 318 */     return getConfig().getLongList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Byte> getByteList(String path) {
/* 323 */     return getConfig().getByteList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Character> getCharacterList(String path) {
/* 328 */     return getConfig().getCharacterList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Short> getShortList(String path) {
/* 333 */     return getConfig().getShortList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Map<?, ?>> getMapList(String path) {
/* 338 */     return getConfig().getMapList(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigurationSection getConfigurationSection(String path) {
/* 343 */     return getConfig().getConfigurationSection(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConfigurationSection(String path) {
/* 348 */     return getConfig().isConfigurationSection(path);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigurationSection getDefaultSection() {
/* 353 */     return getConfig().getDefaultSection();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addDefault(String path, Object def) {
/* 358 */     getConfig().addDefault(path, def);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\polar\PolarConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */