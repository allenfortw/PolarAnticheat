/*    */ package net.craftigames.polar.common.messages.collection.minigames;
/*    */ 
/*    */ public enum DataState
/*    */ {
/*    */   DataState(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   public static DataState[] CACHE;
/* 10 */   SAVING(0),
/* 11 */   SUCCESS(1); private final int id;
/*    */   static {
/* 13 */     CACHE = values(); } public int getId() {
/* 14 */     return this.id;
/*    */   }
/*    */   public static DataState fromId(int id) {
/* 17 */     for (DataState state : CACHE) {
/* 18 */       if (state.getId() == id) {
/* 19 */         return state;
/*    */       }
/*    */     } 
/* 22 */     throw new IllegalArgumentException("Invalid DataState with ID " + id);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\minigames\DataState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */