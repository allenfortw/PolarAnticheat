/*    */ package net.craftigames.polar.common.database;
/*    */ 
/*    */ import com.zaxxer.hikari.HikariDataSource;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ 
/*    */ public abstract class AbstractDatabaseHandler
/*    */   implements DatabaseHandler
/*    */ {
/*    */   public HikariDataSource hikari;
/*    */   
/*    */   public HikariDataSource getHikariDataSource() {
/* 14 */     return this.hikari;
/*    */   }
/*    */ 
/*    */   
/*    */   public Connection getConnection() throws SQLException {
/* 19 */     if (this.hikari == null) {
/* 20 */       throw new SQLException("Unable to get a connection from the pool. (hikari is null)");
/*    */     }
/* 22 */     Connection connection = this.hikari.getConnection();
/* 23 */     if (connection == null) {
/* 24 */       throw new SQLException("Unable to get a connection from the pool. (getConnection returned null)");
/*    */     }
/* 26 */     return connection;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 31 */     if (this.hikari != null)
/* 32 */       this.hikari.close(); 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\AbstractDatabaseHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */