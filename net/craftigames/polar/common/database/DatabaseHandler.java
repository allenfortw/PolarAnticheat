package net.craftigames.polar.common.database;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import net.craftigames.polar.common.configuration.ConfigFile;

public interface DatabaseHandler {
  HikariDataSource getHikariDataSource();
  
  String getHost();
  
  Connection getConnection() throws SQLException;
  
  void close();
  
  ConfigFile getConfig();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\DatabaseHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */