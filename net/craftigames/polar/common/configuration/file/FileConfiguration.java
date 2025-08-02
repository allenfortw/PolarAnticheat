/*     */ package net.craftigames.polar.common.configuration.file;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import net.craftigames.polar.common.configuration.Configuration;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationOptions;
/*     */ import net.craftigames.polar.common.configuration.InvalidConfigurationException;
/*     */ import net.craftigames.polar.common.configuration.MemoryConfiguration;
/*     */ import net.craftigames.polar.common.configuration.MemoryConfigurationOptions;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
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
/*     */ public abstract class FileConfiguration
/*     */   extends MemoryConfiguration
/*     */ {
/*     */   @Deprecated
/*     */   public static final boolean UTF8_OVERRIDE;
/*     */   @Deprecated
/*     */   public static final boolean UTF_BIG;
/*     */   @Deprecated
/*     */   public static final boolean SYSTEM_UTF;
/*     */   
/*     */   static {
/*  46 */     byte[] testBytes = Base64Coder.decode("ICEiIyQlJicoKSorLC0uLzAxMjM0NTY3ODk6Ozw9Pj9AQUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVpbXF1eX2BhYmNkZWZnaGlqa2xtbm9wcXJzdHV2d3h5ent8fX4NCg==");
/*  47 */     String testString = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\r\n";
/*  48 */     Charset defaultCharset = Charset.defaultCharset();
/*  49 */     String resultString = new String(testBytes, defaultCharset);
/*  50 */     boolean trueUTF = defaultCharset.name().contains("UTF");
/*  51 */     UTF8_OVERRIDE = (!" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\r\n".equals(resultString) || defaultCharset.equals(StandardCharsets.US_ASCII));
/*  52 */     SYSTEM_UTF = (trueUTF || UTF8_OVERRIDE);
/*  53 */     UTF_BIG = (trueUTF && UTF8_OVERRIDE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileConfiguration() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileConfiguration(Configuration defaults) {
/*  70 */     super(defaults);
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
/*     */   public void save(File file) throws IOException {
/*  89 */     Validate.notNull(file, "File cannot be null", new Object[0]);
/*     */     
/*  91 */     Files.createParentDirs(file);
/*     */     
/*  93 */     String data = saveToString();
/*     */     
/*  95 */     Writer writer = new OutputStreamWriter(new FileOutputStream(file), (UTF8_OVERRIDE && !UTF_BIG) ? Charsets.UTF_8 : Charset.defaultCharset());
/*     */     
/*     */     try {
/*  98 */       writer.write(data);
/*     */     } finally {
/* 100 */       writer.close();
/*     */     } 
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
/*     */   public void save(String file) throws IOException {
/* 120 */     Validate.notNull(file, "File cannot be null", new Object[0]);
/*     */     
/* 122 */     save(new File(file));
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
/*     */   public void load(File file) throws FileNotFoundException, IOException, InvalidConfigurationException {
/* 155 */     Validate.notNull(file, "File cannot be null", new Object[0]);
/*     */     
/* 157 */     FileInputStream stream = new FileInputStream(file);
/*     */     
/* 159 */     load(new InputStreamReader(stream, (UTF8_OVERRIDE && !UTF_BIG) ? Charsets.UTF_8 : Charset.defaultCharset()));
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void load(InputStream stream) throws IOException, InvalidConfigurationException {
/* 182 */     Validate.notNull(stream, "Stream cannot be null", new Object[0]);
/*     */     
/* 184 */     load(new InputStreamReader(stream, UTF8_OVERRIDE ? Charsets.UTF_8 : Charset.defaultCharset()));
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
/*     */   public void load(Reader reader) throws IOException, InvalidConfigurationException {
/* 201 */     BufferedReader input = (reader instanceof BufferedReader) ? (BufferedReader)reader : new BufferedReader(reader);
/*     */     
/* 203 */     StringBuilder builder = new StringBuilder();
/*     */     
/*     */     try {
/*     */       String line;
/*     */       
/* 208 */       while ((line = input.readLine()) != null) {
/* 209 */         builder.append(line);
/* 210 */         builder.append('\n');
/*     */       } 
/*     */     } finally {
/* 213 */       input.close();
/*     */     } 
/*     */     
/* 216 */     loadFromString(builder.toString());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(String file) throws FileNotFoundException, IOException, InvalidConfigurationException {
/* 238 */     Validate.notNull(file, "File cannot be null", new Object[0]);
/*     */     
/* 240 */     load(new File(file));
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
/*     */   public FileConfigurationOptions options() {
/* 274 */     if (this.options == null) {
/* 275 */       this.options = new FileConfigurationOptions(this);
/*     */     }
/*     */     
/* 278 */     return (FileConfigurationOptions)this.options;
/*     */   }
/*     */   
/*     */   public abstract String saveToString();
/*     */   
/*     */   public abstract void loadFromString(String paramString) throws InvalidConfigurationException;
/*     */   
/*     */   protected abstract String buildHeader();
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\file\FileConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */