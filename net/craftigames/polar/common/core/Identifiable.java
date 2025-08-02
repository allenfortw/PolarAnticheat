/*   */ package net.craftigames.polar.common.core;
/*   */ 
/*   */ public interface Identifiable
/*   */ {
/*   */   int getId();
/*   */   
/*   */   default String getIdAsString() {
/* 8 */     return String.valueOf(getId());
/*   */   }
/*   */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\Identifiable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */