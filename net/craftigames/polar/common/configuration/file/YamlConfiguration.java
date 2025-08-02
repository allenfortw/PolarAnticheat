/*     */ package net.craftigames.polar.common.configuration.file;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.util.Map;
/*     */ import net.craftigames.polar.common.configuration.Configuration;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationOptions;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*     */ import net.craftigames.polar.common.configuration.InvalidConfigurationException;
/*     */ import net.craftigames.polar.common.configuration.MemoryConfigurationOptions;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ import org.yaml.snakeyaml.DumperOptions;
/*     */ import org.yaml.snakeyaml.Yaml;
/*     */ import org.yaml.snakeyaml.constructor.BaseConstructor;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.representer.Representer;
/*     */ 
/*     */ public class YamlConfiguration extends FileConfiguration {
/*     */   protected static final String COMMENT_PREFIX = "# ";
/*  22 */   private final DumperOptions yamlOptions = new DumperOptions(); protected static final String BLANK_CONFIG = "{}\n";
/*  23 */   private final Representer yamlRepresenter = new YamlRepresenter();
/*  24 */   private final Yaml yaml = new Yaml((BaseConstructor)new YamlConstructor(), this.yamlRepresenter, this.yamlOptions);
/*     */ 
/*     */   
/*     */   public String saveToString() {
/*  28 */     this.yamlOptions.setIndent(options().indent());
/*  29 */     this.yamlOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
/*  30 */     this.yamlOptions.setAllowUnicode(SYSTEM_UTF);
/*  31 */     this.yamlRepresenter.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
/*     */     
/*  33 */     String header = buildHeader();
/*  34 */     String dump = this.yaml.dump(getValues(false));
/*     */     
/*  36 */     if (dump.equals("{}\n")) {
/*  37 */       dump = "";
/*     */     }
/*     */     
/*  40 */     return header + dump;
/*     */   }
/*     */   
/*     */   public void loadFromString(String contents) throws InvalidConfigurationException {
/*     */     Map<?, ?> input;
/*  45 */     Validate.notNull(contents, "Contents cannot be null", new Object[0]);
/*     */ 
/*     */     
/*     */     try {
/*  49 */       input = (Map<?, ?>)this.yaml.load(contents);
/*  50 */     } catch (YAMLException e) {
/*  51 */       throw new InvalidConfigurationException(e);
/*  52 */     } catch (ClassCastException e) {
/*  53 */       throw new InvalidConfigurationException("Top level is not a Map.");
/*     */     } 
/*     */     
/*  56 */     String header = parseHeader(contents);
/*  57 */     if (header.length() > 0) {
/*  58 */       options().header(header);
/*     */     }
/*     */     
/*  61 */     if (input != null) {
/*  62 */       convertMapsToSections(input, (ConfigurationSection)this);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void convertMapsToSections(Map<?, ?> input, ConfigurationSection section) {
/*  67 */     for (Map.Entry<?, ?> entry : input.entrySet()) {
/*  68 */       String key = entry.getKey().toString();
/*  69 */       Object value = entry.getValue();
/*     */       
/*  71 */       if (value instanceof Map) {
/*  72 */         convertMapsToSections((Map<?, ?>)value, section.createSection(key)); continue;
/*     */       } 
/*  74 */       section.set(key, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected String parseHeader(String input) {
/*  80 */     String[] lines = input.split("\r?\n", -1);
/*  81 */     StringBuilder result = new StringBuilder();
/*  82 */     boolean readingHeader = true;
/*  83 */     boolean foundHeader = false;
/*     */     
/*  85 */     for (int i = 0; i < lines.length && readingHeader; i++) {
/*  86 */       String line = lines[i];
/*     */       
/*  88 */       if (line.startsWith("# ")) {
/*  89 */         if (i > 0) {
/*  90 */           result.append("\n");
/*     */         }
/*     */         
/*  93 */         if (line.length() > "# ".length()) {
/*  94 */           result.append(line.substring("# ".length()));
/*     */         }
/*     */         
/*  97 */         foundHeader = true;
/*  98 */       } else if (foundHeader && line.length() == 0) {
/*  99 */         result.append("\n");
/* 100 */       } else if (foundHeader) {
/* 101 */         readingHeader = false;
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     return result.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String buildHeader() {
/* 110 */     String header = options().header();
/*     */     
/* 112 */     if (options().copyHeader()) {
/* 113 */       Configuration def = getDefaults();
/*     */       
/* 115 */       if (def != null && def instanceof FileConfiguration) {
/* 116 */         FileConfiguration filedefaults = (FileConfiguration)def;
/* 117 */         String defaultsHeader = filedefaults.buildHeader();
/*     */         
/* 119 */         if (defaultsHeader != null && defaultsHeader.length() > 0) {
/* 120 */           return defaultsHeader;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     if (header == null) {
/* 126 */       return "";
/*     */     }
/*     */     
/* 129 */     StringBuilder builder = new StringBuilder();
/* 130 */     String[] lines = header.split("\r?\n", -1);
/* 131 */     boolean startedHeader = false;
/*     */     
/* 133 */     for (int i = lines.length - 1; i >= 0; i--) {
/* 134 */       builder.insert(0, "\n");
/*     */       
/* 136 */       if (startedHeader || lines[i].length() != 0) {
/* 137 */         builder.insert(0, lines[i]);
/* 138 */         builder.insert(0, "# ");
/* 139 */         startedHeader = true;
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public YamlConfigurationOptions options() {
/* 148 */     if (this.options == null) {
/* 149 */       this.options = new YamlConfigurationOptions(this);
/*     */     }
/*     */     
/* 152 */     return (YamlConfigurationOptions)this.options;
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
/*     */   public static YamlConfiguration loadConfiguration(File file) {
/* 169 */     Validate.notNull(file, "File cannot be null", new Object[0]);
/*     */     
/* 171 */     YamlConfiguration config = new YamlConfiguration();
/*     */ 
/*     */     
/* 174 */     try { config.load(file); }
/* 175 */     catch (FileNotFoundException fileNotFoundException) {  }
/* 176 */     catch (IOException|InvalidConfigurationException ex)
/* 177 */     { System.out.println("Cannot load " + file);
/* 178 */       ex.printStackTrace(); }
/*     */ 
/*     */     
/* 181 */     return config;
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
/*     */   @Deprecated
/*     */   public static YamlConfiguration loadConfiguration(InputStream stream) {
/* 200 */     Validate.notNull(stream, "Stream cannot be null", new Object[0]);
/*     */     
/* 202 */     YamlConfiguration config = new YamlConfiguration();
/*     */     
/*     */     try {
/* 205 */       config.load(stream);
/* 206 */     } catch (IOException|InvalidConfigurationException ex) {
/* 207 */       ex.printStackTrace();
/* 208 */       System.out.println("Cannot load configuration from stream");
/*     */     } 
/*     */     
/* 211 */     return config;
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
/*     */   public static YamlConfiguration loadConfiguration(Reader reader) {
/* 227 */     Validate.notNull(reader, "Stream cannot be null", new Object[0]);
/*     */     
/* 229 */     YamlConfiguration config = new YamlConfiguration();
/*     */     
/*     */     try {
/* 232 */       config.load(reader);
/* 233 */     } catch (IOException|InvalidConfigurationException ex) {
/* 234 */       ex.printStackTrace();
/* 235 */       System.out.println("Cannot load configuration from stream");
/*     */     } 
/*     */     
/* 238 */     return config;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\file\YamlConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */