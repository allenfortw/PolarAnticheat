/*    */ package net.craftigames.polar.common.database;
/*    */ 
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public interface WaitingLoader
/*    */ {
/*    */   void verifyResponse(boolean paramBoolean, @Nullable Exception paramException);
/*    */   
/*    */   default void verifyResponse(boolean success) {
/* 10 */     verifyResponse(success, null);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\database\WaitingLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */