/*    */ package net.craftigames.polar.common.rank;
/*    */ 
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public interface RankMember
/*    */ {
/*    */   Rank getRank();
/*    */   
/*    */   void setRank(Rank paramRank);
/*    */   
/*    */   @Nullable
/*    */   StaffRank getStaffRank();
/*    */   
/*    */   void setStaffRank(StaffRank paramStaffRank);
/*    */   
/*    */   default boolean isStaff() {
/* 17 */     return (getStaffRank() != null);
/*    */   }
/*    */   
/*    */   default boolean isDonator() {
/* 21 */     return getRank().isAtLeast(Rank.RANK_1);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\rank\RankMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */