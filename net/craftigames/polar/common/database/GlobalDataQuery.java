/*    */ package net.craftigames.polar.common.database;
/*    */ 
/*    */ public class GlobalDataQuery
/*    */ {
/*  5 */   public static String TABLE = "users";
/*  6 */   public static String POLAR_TABLE = "polar_global";
/*  7 */   public static String DISCORD_TABLE = "discord_users";
/*    */   
/*  9 */   public static final String INSERT_DATA = "INSERT INTO " + TABLE + " (username, realname, uuid) VALUES (?,?,?)";
/*    */   
/* 11 */   public static final String SELECT_DATA = "SELECT * FROM " + TABLE + " WHERE username = ?";
/* 12 */   public static final String SELECT_DATA_BY_UUID = "SELECT * FROM " + TABLE + " WHERE uuid = ?";
/*    */   
/* 14 */   public static final String SELECT_POLAR_DATA = "SELECT * FROM " + POLAR_TABLE + " WHERE user_id = ?";
/*    */   
/* 16 */   public static final String SELECT_DISCORD_DATA = "SELECT * FROM " + DISCORD_TABLE + " WHERE user_id = ?";
/* 17 */   public static final String UPDATE_DISCORD_DONATOR = "UPDATE " + DISCORD_TABLE + " SET donator = ? WHERE user_id = ?";
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\GlobalDataQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */