/*    */ package net.craftigames.polar.common.logging;
/*    */ 
/*    */ import net.craftigames.polar.common.core.CoreUtils;
/*    */ import net.craftigames.polar.common.core.Nameable;
/*    */ 
/*    */ 
/*    */ public enum SystemLog
/*    */   implements SystemLogType, Nameable
/*    */ {
/* 10 */   PRE_JOIN_TIMEOUT("Pre join request for %s timed out..."),
/* 11 */   JOIN_TIMEOUT("Polar join request for %s timed out..."),
/* 12 */   SERVER_CHAT_TIMEOUT("Server Chat Timed out for %s"),
/*    */   
/* 14 */   POLAR_SERVER_CONNECT_TIMEOUT("Polar's Internal Server Connect Timed out for %s"),
/* 15 */   SERVER_CONNECT_TIMEOUT("Server Connect Timed out for %s"),
/* 16 */   FIRST_SERVER_CONNECT_TIMEOUT("First Server Connect Timed out for %s"),
/* 17 */   SHUTDOWN_24H_PANDA_SERVERS("Shutting down %s panda servers because they are online for more than 24h"); SystemLog(String message) {
/*    */     this.message = message;
/*    */   } static {
/* 20 */     CACHE = values();
/*    */   }
/*    */   public static final SystemLog[] CACHE;
/*    */   private final String message;
/*    */   
/*    */   public String getName() {
/* 26 */     return name();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getType() {
/* 31 */     return name();
/*    */   }
/*    */ 
/*    */   
/*    */   public String format(Object... objects) {
/* 36 */     return String.format(this.message, objects);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLogVariant() {
/* 41 */     return "SystemLog";
/*    */   }
/*    */   
/*    */   public static SystemLog get(String name) {
/* 45 */     return (SystemLog)CoreUtils.getNameable(name, (Nameable[])CACHE);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\SystemLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */