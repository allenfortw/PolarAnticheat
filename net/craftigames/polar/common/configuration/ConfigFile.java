/*     */ package net.craftigames.polar.common.configuration;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParseException;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import net.craftigames.polar.common.Core;
/*     */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*     */ 
/*     */ public class ConfigFile {
/*     */   private final File file;
/*     */   private JsonObject main;
/*     */   
/*     */   public ConfigFile(String fileName) throws IOException, JsonParseException {
/*  18 */     this(new File(fileName));
/*     */   }
/*     */   
/*     */   public ConfigFile(File file) throws IOException, JsonParseException {
/*  22 */     this.file = file;
/*     */     
/*  24 */     if (!file.exists()) {
/*     */       
/*  26 */       if (!file.createNewFile()) {
/*  27 */         throw new RuntimeException("Failed to create file");
/*     */       }
/*     */       
/*  30 */       this.main = new JsonObject();
/*  31 */       save();
/*     */     } 
/*     */     
/*  34 */     loadConfig();
/*     */   }
/*     */   
/*     */   public void loadConfig() throws FileNotFoundException {
/*  38 */     this.main = GsonProvider.readObject(new FileReader(this.file));
/*     */   }
/*     */   
/*     */   public void save() throws IOException {
/*  42 */     Writer out = new FileWriter(this.file, false); 
/*  43 */     try { out.write(GsonProvider.toStringPretty((JsonElement)this.main));
/*  44 */       out.close(); }
/*     */     catch (Throwable throwable) { try { out.close(); }
/*     */       catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }
/*     */        throw throwable; }
/*  48 */      } public void expect(String key, String defVal) throws IOException { JsonElement val = this.main.get(key);
/*  49 */     if (val == null) {
/*  50 */       this.main.addProperty(key, defVal);
/*  51 */       save();
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void expectMessages(JsonObject messages) throws IOException {
/*  56 */     JsonElement val = this.main.get("messages");
/*  57 */     if (val == null) {
/*  58 */       this.main.add("messages", (JsonElement)messages);
/*  59 */       save();
/*     */     } 
/*     */ 
/*     */     
/*  63 */     JsonObject currentMessages = getObject("messages");
/*  64 */     boolean hadMissing = false;
/*     */     
/*  66 */     for (String key : messages.keySet()) {
/*  67 */       if (currentMessages.has(key)) {
/*     */         continue;
/*     */       }
/*  70 */       currentMessages.addProperty(key, messages.get(key).getAsString());
/*  71 */       hadMissing = true;
/*     */     } 
/*     */     
/*  74 */     if (hadMissing) {
/*  75 */       set("messages", currentMessages);
/*  76 */       save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void expect(String key, JsonObject defVal) throws IOException {
/*  81 */     JsonElement val = this.main.get(key);
/*  82 */     if (val == null) {
/*  83 */       this.main.add(key, (JsonElement)defVal);
/*  84 */       save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void expect(String key, Number defVal) throws IOException {
/*  89 */     JsonElement val = this.main.get(key);
/*  90 */     if (val == null) {
/*  91 */       this.main.addProperty(key, defVal);
/*  92 */       save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void set(String key, JsonObject val) {
/*  97 */     this.main.add(key, (JsonElement)val);
/*     */   }
/*     */   
/*     */   public void set(String key, String val) {
/* 101 */     this.main.addProperty(key, val);
/*     */   }
/*     */   
/*     */   public String getString(String key) {
/* 105 */     JsonElement val = this.main.get(key);
/* 106 */     if (val == null) {
/* 107 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 108 */       return null;
/*     */     } 
/* 110 */     return val.getAsString();
/*     */   }
/*     */   
/*     */   public JsonObject getObject(String key) {
/* 114 */     JsonElement val = this.main.get(key);
/* 115 */     if (val == null) {
/* 116 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 117 */       return null;
/*     */     } 
/* 119 */     return val.getAsJsonObject();
/*     */   }
/*     */   
/*     */   public int getInt(String key) {
/* 123 */     JsonElement val = this.main.get(key);
/* 124 */     if (val == null) {
/* 125 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 126 */       return 0;
/*     */     } 
/* 128 */     return val.getAsInt();
/*     */   }
/*     */   
/*     */   public Double getDouble(String key) {
/* 132 */     JsonElement val = this.main.get(key);
/* 133 */     if (val == null) {
/* 134 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 135 */       return null;
/*     */     } 
/* 137 */     return Double.valueOf(val.getAsDouble());
/*     */   }
/*     */   
/*     */   public Long getLong(String key) {
/* 141 */     JsonElement val = this.main.get(key);
/* 142 */     if (val == null) {
/* 143 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 144 */       return null;
/*     */     } 
/* 146 */     return Long.valueOf(val.getAsLong());
/*     */   }
/*     */   
/*     */   public JsonArray getArray(String key) {
/* 150 */     JsonElement val = this.main.get(key);
/* 151 */     if (val == null) {
/* 152 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 153 */       return null;
/*     */     } 
/* 155 */     return val.getAsJsonArray();
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String key) {
/* 159 */     JsonElement val = this.main.get(key);
/* 160 */     if (val == null) {
/* 161 */       Core.getPolarCore().getPolarLogger().warn("Key " + key + " for config " + this.file.getName() + " does not exist.");
/* 162 */       return false;
/*     */     } 
/* 164 */     return val.getAsBoolean();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\ConfigFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */