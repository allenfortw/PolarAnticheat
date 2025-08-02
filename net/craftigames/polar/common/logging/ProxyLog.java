/*    */ package net.craftigames.polar.common.logging;
/*    */ 
/*    */ import net.craftigames.polar.common.core.CoreUtils;
/*    */ import net.craftigames.polar.common.core.Nameable;
/*    */ 
/*    */ 
/*    */ public enum ProxyLog
/*    */   implements SystemLogType, Nameable
/*    */ {
/* 10 */   JOIN_TIMEOUT("Polar join request for %s timed out..."),
/* 11 */   SERVER_CHAT_TIMEOUT("Server Chat Timed out for %s"),
/* 12 */   TAB_COMPLETE_TIMEOUT("Tab Complete Timed out for %s"),
/* 13 */   SERVER_CONNECT_TIMEOUT("Server Connect Timed out for %s"),
/* 14 */   FIRST_SERVER_CONNECT_TIMEOUT("First Server Connect Timed out for %s"),
/* 15 */   SERVER_KICK_REMOTE_TARGET_SERVER_NOT_FOUND("Server Kick: could not find remote target server %s"),
/* 16 */   SERVER_KICK_TIMEOUT("Server Kick Timed out for %s"),
/*    */   
/* 18 */   JOIN_FAILED_PENDING("Unable to handle login for %s because their login is already pending."),
/* 19 */   JOIN_FAILED_POLAR_OFFLINE("Unable to handle login for %s because polar is offline."),
/*    */ 
/*    */   
/* 22 */   INITIAL_SERVER_CHOOSE_TIMEOUT("Initial Server Choose Timed out for user %s"),
/* 23 */   INVALID_INITIAL_SERVER_CHOOSE("Initial Server Choose Failed because server %s does not exist"),
/* 24 */   SERVER_NOT_FOUND("Server not found for %s"); ProxyLog(String message) {
/*    */     this.message = message;
/*    */   } static {
/* 27 */     CACHE = values();
/*    */   }
/*    */   public static final ProxyLog[] CACHE;
/*    */   private final String message;
/*    */   
/*    */   public String getName() {
/* 33 */     return name();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getType() {
/* 38 */     return name();
/*    */   }
/*    */ 
/*    */   
/*    */   public String format(Object... objects) {
/* 43 */     return String.format(this.message, objects);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLogVariant() {
/* 48 */     return "ProxyLog";
/*    */   }
/*    */   
/*    */   public static ProxyLog get(String name) {
/* 52 */     return (ProxyLog)CoreUtils.getNameable(name, (Nameable[])CACHE);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\ProxyLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */