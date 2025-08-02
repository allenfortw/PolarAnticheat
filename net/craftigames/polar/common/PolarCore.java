/*    */ package net.craftigames.polar.common;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.EnumSet;
/*    */ import net.craftigames.polar.common.dependencies.Dependency;
/*    */ import net.craftigames.polar.common.dependencies.DependencyManager;
/*    */ import net.craftigames.polar.common.dependencies.classloader.PluginClassLoader;
/*    */ import net.craftigames.polar.common.logging.PolarLogger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface PolarCore
/*    */ {
/*    */   File getDataFolder();
/*    */   
/*    */   PolarLogger getPolarLogger();
/*    */   
/*    */   PluginClassLoader getPluginClassLoader();
/*    */   
/*    */   DependencyManager getDependencyManager();
/*    */   
/*    */   default void loadSystemDependencies() {
/* 23 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.CAFFEINE, new Dependency[] { Dependency.BYTEBUDDY, Dependency.OKHTTP, Dependency.OKIO, Dependency.SNAKEYAML, Dependency.CONFIGURATE_CORE, Dependency.CONFIGURATE_GSON, Dependency.CONFIGURATE_YAML }));
/*    */   }
/*    */   
/*    */   default void loadSentryDependencies() {
/* 27 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.JACKSON_CORE, Dependency.SENTRY));
/*    */   }
/*    */   
/*    */   default void loadRedisDependencies() {
/* 31 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.COMMONS_POOL_2, Dependency.JEDIS, Dependency.SLF4J_API, Dependency.SLF4J_SIMPLE));
/*    */   }
/*    */   
/*    */   default void loadInfluxDependencies() {
/* 35 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.INFLUXDB, new Dependency[] { Dependency.RETROFIT2, Dependency.RETROFIT2_MOSHI_CONVERTER, Dependency.OKHTTP_LOGGING, Dependency.RETROFIT2_MOSHI, Dependency.RETROFIT2_GSON_CONVERTER }));
/*    */   }
/*    */   
/*    */   default void loadMariaDBDependencies() {
/* 39 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.MYSQL_DRIVER, Dependency.MARIADB_DRIVER, Dependency.SLF4J_API, Dependency.SLF4J_SIMPLE, Dependency.HIKARI));
/*    */   }
/*    */   
/*    */   default void loadAdventureDependencies() {
/* 43 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.ADVENTURE, Dependency.ADVENTURE_PLATFORM, Dependency.ADVENTURE_PLATFORM_BUKKIT, Dependency.ADVENTURE_PLATFORM_BUNGEECORD));
/*    */   }
/*    */   
/*    */   default void loadConfigDependencies() {
/* 47 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.SNAKEYAML));
/*    */   }
/*    */   
/*    */   default void loadEventDependencies() {
/* 51 */     getDependencyManager().loadDependencies(EnumSet.of(Dependency.EVENT));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\PolarCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */