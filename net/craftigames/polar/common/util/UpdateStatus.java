/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum UpdateStatus
/*    */ {
/*    */   UpdateStatus(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   private static final UpdateStatus[] CACHE;
/* 13 */   ADD(0),
/* 14 */   REMOVE(1),
/*    */   
/* 16 */   EDIT(4),
/*    */   
/* 18 */   SPIGOT(2),
/* 19 */   PROXY(3); private final int id;
/*    */   
/*    */   static {
/* 22 */     CACHE = values(); } public int getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   public static UpdateStatus byId(int id) {
/* 26 */     for (UpdateStatus geyserStatus : CACHE) {
/* 27 */       if (geyserStatus.getId() == id) {
/* 28 */         return geyserStatus;
/*    */       }
/*    */     } 
/* 31 */     throw new UnsupportedOperationException("Unknown UpdateStatus with id " + id);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\UpdateStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */