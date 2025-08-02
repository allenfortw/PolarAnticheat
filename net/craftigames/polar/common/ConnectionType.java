/*    */ package net.craftigames.polar.common;
/*    */ 
/*    */ public enum ConnectionType
/*    */ {
/*  5 */   UNSPECIFIED(0), SYSTEM(1), API_CLIENT(2), BUNGEECORD(3), BUKKIT(4), LEADERBOARD(5), GEYSER(6); private final int id;
/*    */   static {
/*  7 */     CACHE = values();
/*    */   }
/*    */   private static final ConnectionType[] CACHE;
/*    */   ConnectionType(int id) {
/* 11 */     this.id = id;
/*    */   }
/*    */   
/*    */   public static ConnectionType byId(int id) {
/* 15 */     for (ConnectionType c : CACHE) {
/* 16 */       if (c.getId() == id) {
/* 17 */         return c;
/*    */       }
/*    */     } 
/* 20 */     throw new UnsupportedOperationException("Unknown ConnectionType with id " + id);
/*    */   }
/*    */   
/*    */   public int getId() {
/* 24 */     return this.id;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\ConnectionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */