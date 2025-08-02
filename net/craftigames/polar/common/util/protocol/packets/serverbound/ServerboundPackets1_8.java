/*    */ package net.craftigames.polar.common.util.protocol.packets.serverbound;
/*    */ 
/*    */ import net.craftigames.polar.common.util.protocol.packets.ServerboundPackets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ServerboundPackets1_8
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   KEEP_ALIVE,
/* 25 */   CHAT_MESSAGE,
/* 26 */   INTERACT_ENTITY,
/* 27 */   PLAYER_MOVEMENT,
/* 28 */   PLAYER_POSITION,
/* 29 */   PLAYER_ROTATION,
/* 30 */   PLAYER_POSITION_AND_ROTATION,
/* 31 */   PLAYER_DIGGING,
/* 32 */   PLAYER_BLOCK_PLACEMENT,
/* 33 */   HELD_ITEM_CHANGE,
/* 34 */   ANIMATION,
/* 35 */   ENTITY_ACTION,
/* 36 */   STEER_VEHICLE,
/* 37 */   CLOSE_WINDOW,
/* 38 */   CLICK_WINDOW,
/* 39 */   WINDOW_CONFIRMATION,
/* 40 */   CREATIVE_INVENTORY_ACTION,
/* 41 */   CLICK_WINDOW_BUTTON,
/* 42 */   UPDATE_SIGN,
/* 43 */   PLAYER_ABILITIES,
/* 44 */   TAB_COMPLETE,
/* 45 */   CLIENT_SETTINGS,
/* 46 */   CLIENT_STATUS,
/* 47 */   PLUGIN_MESSAGE,
/* 48 */   SPECTATE,
/* 49 */   RESOURCE_PACK_STATUS;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 53 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 58 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */