/*     */ package net.craftigames.polar.common.logging;
/*     */ import java.util.ResourceBundle;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.logging.Filter;
/*     */ import java.util.logging.Handler;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.LogRecord;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ public class JavaLogging implements PolarLogging {
/*     */   public JavaLogging(Logger logger) {
/*  12 */     this.logger = logger;
/*     */   }
/*     */   private final Logger logger;
/*     */   
/*     */   public void warn(String msg) {
/*  17 */     this.logger.warning(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void warn(String s, Throwable t) {
/*  22 */     this.logger.warning(s);
/*  23 */     t.printStackTrace();
/*     */   }
/*     */ 
/*     */   
/*     */   public void error(String msg) {
/*  28 */     this.logger.log(Level.WARNING, msg);
/*     */   }
/*     */   
/*     */   public static Logger getGlobal() {
/*  32 */     return Logger.getGlobal();
/*     */   }
/*     */   
/*     */   public static Logger getLogger(String name) {
/*  36 */     return Logger.getLogger(name);
/*     */   }
/*     */   
/*     */   public static Logger getLogger(String name, String resourceBundleName) {
/*  40 */     return Logger.getLogger(name, resourceBundleName);
/*     */   }
/*     */   
/*     */   public void setFilter(Filter newFilter) throws SecurityException {
/*  44 */     this.logger.setFilter(newFilter);
/*     */   }
/*     */   
/*     */   public Filter getFilter() {
/*  48 */     return this.logger.getFilter();
/*     */   }
/*     */   
/*     */   public void log(LogRecord record) {
/*  52 */     this.logger.log(record);
/*     */   }
/*     */   
/*     */   public void log(Level level, String msg) {
/*  56 */     this.logger.log(level, msg);
/*     */   }
/*     */   
/*     */   public void log(Level level, Supplier<String> msgSupplier) {
/*  60 */     this.logger.log(level, msgSupplier);
/*     */   }
/*     */   
/*     */   public void log(Level level, String msg, Object param1) {
/*  64 */     this.logger.log(level, msg, param1);
/*     */   }
/*     */   
/*     */   public void log(Level level, String msg, Object[] params) {
/*  68 */     this.logger.log(level, msg, params);
/*     */   }
/*     */   
/*     */   public void log(Level level, String msg, Throwable thrown) {
/*  72 */     if (thrown == null) {
/*  73 */       this.logger.log(level, msg);
/*     */     } else {
/*  75 */       this.logger.log(level, msg, thrown);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug(String s) {
/*  81 */     this.logger.log(Level.INFO, s);
/*     */   }
/*     */   
/*     */   public void log(Level level, Throwable thrown, Supplier<String> msgSupplier) {
/*  85 */     this.logger.log(level, thrown, msgSupplier);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
/*  89 */     this.logger.logp(level, sourceClass, sourceMethod, msg);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, Supplier<String> msgSupplier) {
/*  93 */     this.logger.logp(level, sourceClass, sourceMethod, msgSupplier);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
/*  97 */     this.logger.logp(level, sourceClass, sourceMethod, msg, param1);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
/* 101 */     this.logger.logp(level, sourceClass, sourceMethod, msg, params);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
/* 105 */     this.logger.logp(level, sourceClass, sourceMethod, msg, thrown);
/*     */   }
/*     */   
/*     */   public void logp(Level level, String sourceClass, String sourceMethod, Throwable thrown, Supplier<String> msgSupplier) {
/* 109 */     this.logger.logp(level, sourceClass, sourceMethod, thrown, msgSupplier);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg) {
/* 114 */     this.logger.logrb(level, sourceClass, sourceMethod, bundleName, msg);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object param1) {
/* 119 */     this.logger.logrb(level, sourceClass, sourceMethod, bundleName, msg, param1);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Object[] params) {
/* 124 */     this.logger.logrb(level, sourceClass, sourceMethod, bundleName, msg, params);
/*     */   }
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg, Object... params) {
/* 128 */     this.logger.logrb(level, sourceClass, sourceMethod, bundle, msg, params);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, String bundleName, String msg, Throwable thrown) {
/* 133 */     this.logger.logrb(level, sourceClass, sourceMethod, bundleName, msg, thrown);
/*     */   }
/*     */   
/*     */   public void logrb(Level level, String sourceClass, String sourceMethod, ResourceBundle bundle, String msg, Throwable thrown) {
/* 137 */     this.logger.logrb(level, sourceClass, sourceMethod, bundle, msg, thrown);
/*     */   }
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod) {
/* 141 */     this.logger.entering(sourceClass, sourceMethod);
/*     */   }
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod, Object param1) {
/* 145 */     this.logger.entering(sourceClass, sourceMethod, param1);
/*     */   }
/*     */   
/*     */   public void entering(String sourceClass, String sourceMethod, Object[] params) {
/* 149 */     this.logger.entering(sourceClass, sourceMethod, params);
/*     */   }
/*     */   
/*     */   public void exiting(String sourceClass, String sourceMethod) {
/* 153 */     this.logger.exiting(sourceClass, sourceMethod);
/*     */   }
/*     */   
/*     */   public void exiting(String sourceClass, String sourceMethod, Object result) {
/* 157 */     this.logger.exiting(sourceClass, sourceMethod, result);
/*     */   }
/*     */   
/*     */   public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
/* 161 */     this.logger.throwing(sourceClass, sourceMethod, thrown);
/*     */   }
/*     */   
/*     */   public void severe(String msg) {
/* 165 */     this.logger.severe(msg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void severe(String s, Throwable t) {}
/*     */ 
/*     */   
/*     */   public void warning(String msg) {
/* 174 */     this.logger.warning(msg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void info(String msg) {
/* 179 */     this.logger.info(msg);
/*     */   }
/*     */   
/*     */   public void config(String msg) {
/* 183 */     this.logger.config(msg);
/*     */   }
/*     */   
/*     */   public void fine(String msg) {
/* 187 */     this.logger.fine(msg);
/*     */   }
/*     */   
/*     */   public void finer(String msg) {
/* 191 */     this.logger.finer(msg);
/*     */   }
/*     */   
/*     */   public void finest(String msg) {
/* 195 */     this.logger.finest(msg);
/*     */   }
/*     */   
/*     */   public void severe(Supplier<String> msgSupplier) {
/* 199 */     this.logger.severe(msgSupplier);
/*     */   }
/*     */   
/*     */   public void warning(Supplier<String> msgSupplier) {
/* 203 */     this.logger.warning(msgSupplier);
/*     */   }
/*     */   
/*     */   public void info(Supplier<String> msgSupplier) {
/* 207 */     this.logger.info(msgSupplier);
/*     */   }
/*     */   
/*     */   public void config(Supplier<String> msgSupplier) {
/* 211 */     this.logger.config(msgSupplier);
/*     */   }
/*     */   
/*     */   public void fine(Supplier<String> msgSupplier) {
/* 215 */     this.logger.fine(msgSupplier);
/*     */   }
/*     */   
/*     */   public void finer(Supplier<String> msgSupplier) {
/* 219 */     this.logger.finer(msgSupplier);
/*     */   }
/*     */   
/*     */   public void finest(Supplier<String> msgSupplier) {
/* 223 */     this.logger.finest(msgSupplier);
/*     */   }
/*     */   
/*     */   public void setLevel(Level newLevel) throws SecurityException {
/* 227 */     this.logger.setLevel(newLevel);
/*     */   }
/*     */   
/*     */   public Level getLevel() {
/* 231 */     return this.logger.getLevel();
/*     */   }
/*     */   
/*     */   public boolean isLoggable(Level level) {
/* 235 */     return this.logger.isLoggable(level);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 239 */     return this.logger.getName();
/*     */   }
/*     */   
/*     */   public void addHandler(Handler handler) throws SecurityException {
/* 243 */     this.logger.addHandler(handler);
/*     */   }
/*     */   
/*     */   public void removeHandler(Handler handler) throws SecurityException {
/* 247 */     this.logger.removeHandler(handler);
/*     */   }
/*     */   
/*     */   public Handler[] getHandlers() {
/* 251 */     return this.logger.getHandlers();
/*     */   }
/*     */   
/*     */   public void setUseParentHandlers(boolean useParentHandlers) {
/* 255 */     this.logger.setUseParentHandlers(useParentHandlers);
/*     */   }
/*     */   
/*     */   public boolean getUseParentHandlers() {
/* 259 */     return this.logger.getUseParentHandlers();
/*     */   }
/*     */   
/*     */   public void setResourceBundle(ResourceBundle bundle) {
/* 263 */     this.logger.setResourceBundle(bundle);
/*     */   }
/*     */   
/*     */   public Logger getParent() {
/* 267 */     return this.logger.getParent();
/*     */   }
/*     */   
/*     */   public void setParent(Logger parent) {
/* 271 */     this.logger.setParent(parent);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\JavaLogging.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */