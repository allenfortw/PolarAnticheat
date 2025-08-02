/*     */ package net.craftigames.polar.common.database;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.zaxxer.hikari.HikariDataSource;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.Collectors;
/*     */ import net.craftigames.polar.common.configuration.ConfigFile;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ public class AbstractDatabase extends AbstractDatabaseHandler implements DatabaseHandler {
/*     */   private String host;
/*     */   private ConfigFile config;
/*     */   
/*  17 */   public void setHost(String host) { this.host = host; } public void setConfig(ConfigFile config) { this.config = config; } public void setMinIdle(int minIdle) { this.minIdle = minIdle; } public void setMaxPoolSize(int maxPoolSize) { this.maxPoolSize = maxPoolSize; }
/*     */ 
/*     */   
/*     */   public ConfigFile getConfig() {
/*  21 */     return this.config;
/*     */   }
/*  23 */   private int minIdle = 20; public int getMinIdle() { return this.minIdle; }
/*  24 */    private int maxPoolSize = 20; public int getMaxPoolSize() { return this.maxPoolSize; }
/*     */   
/*     */   public AbstractDatabase() {
/*  27 */     ConfigFile dbConfig = null;
/*     */     try {
/*  29 */       dbConfig = new DatabaseConfig();
/*  30 */     } catch (IOException e) {
/*  31 */       e.printStackTrace();
/*     */     } 
/*  33 */     this.config = dbConfig;
/*     */   }
/*     */   
/*     */   public AbstractDatabase(ConfigFile cnf) {
/*  37 */     if (cnf != null) {
/*  38 */       setup(cnf);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setup() {
/*  43 */     setup(this.config);
/*     */   }
/*     */   
/*     */   public AbstractDatabase setup(ConfigFile cnf) {
/*  47 */     if (cnf == null) {
/*  48 */       throw new UnsupportedOperationException("Could not initialize database config.");
/*     */     }
/*  50 */     this.config = cnf;
/*  51 */     return setup(null, cnf.getString("host"), cnf.getString("port"), cnf.getString("database"), cnf.getString("username"), cnf.getString("password"));
/*     */   }
/*     */   
/*     */   public AbstractDatabase setup(@Nullable String poolName, String host, String port, String database, String username, String password) {
/*  55 */     Preconditions.checkNotNull(host, "host");
/*  56 */     Preconditions.checkNotNull(port, "port");
/*  57 */     Preconditions.checkNotNull(database, "database");
/*  58 */     Preconditions.checkNotNull(username, "username");
/*  59 */     Preconditions.checkNotNull(password, "password");
/*     */     
/*  61 */     this.host = host;
/*  62 */     this.hikari = new HikariDataSource();
/*  63 */     if (poolName == null) {
/*  64 */       poolName = "PolarDatabase";
/*     */     }
/*  66 */     this.hikari.setPoolName(poolName);
/*  67 */     setupDatabaseClass(this.hikari);
/*  68 */     this.hikari.addDataSourceProperty("serverName", host);
/*  69 */     this.hikari.addDataSourceProperty("port", port);
/*  70 */     this.hikari.addDataSourceProperty("databaseName", database);
/*  71 */     this.hikari.addDataSourceProperty("user", username);
/*  72 */     this.hikari.addDataSourceProperty("password", password);
/*     */     
/*  74 */     Map<String, Object> properties = new HashMap<>();
/*  75 */     properties.put("useSSL", Boolean.valueOf(false));
/*  76 */     properties.put("verifyServerCertificate", Boolean.valueOf(false));
/*  77 */     properties.put("useUnicode", Boolean.valueOf(true));
/*  78 */     properties.put("characterEncoding", "utf8");
/*     */     
/*  80 */     addProperties(this.hikari, properties);
/*     */     
/*  82 */     this.hikari.setMinimumIdle(this.minIdle);
/*  83 */     this.hikari.setMaximumPoolSize(this.maxPoolSize);
/*     */     
/*  85 */     this.hikari.setMaxLifetime(TimeUnit.MINUTES.toMillis(10L));
/*  86 */     this.hikari.setConnectionTimeout(TimeUnit.SECONDS.toMillis(5L));
/*     */     
/*  88 */     String propertiesString = properties.entrySet().stream().map(e -> (String)e.getKey() + "=" + e.getValue()).collect(Collectors.joining(";"));
/*     */ 
/*     */ 
/*     */     
/*  92 */     this.hikari.addDataSourceProperty("properties", propertiesString);
/*     */     
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHost() {
/*  99 */     return this.host;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperties(HikariDataSource hikari, Map<String, Object> properties) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setupDatabaseClass(HikariDataSource hikari) {
/* 113 */     hikari.setDataSourceClassName(Relocation.RELOCATION_PREFIX + "mariadb.MariaDbDataSource");
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\AbstractDatabase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */