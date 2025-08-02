/*    */ package net.craftigames.polar.common.database;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.craftigames.polar.common.configuration.ConfigFile;
/*    */ 
/*    */ public class DatabaseConfig
/*    */   extends ConfigFile
/*    */ {
/*    */   public DatabaseConfig() throws IOException {
/* 10 */     super("mysql.json");
/*    */ 
/*    */     
/* 13 */     expect("host", "localhost");
/* 14 */     expect("port", Integer.valueOf(3306));
/* 15 */     expect("database", "mc");
/* 16 */     expect("username", "mc");
/* 17 */     expect("password", "password");
/* 18 */     expect("serverType", "JARTEX");
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\DatabaseConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */