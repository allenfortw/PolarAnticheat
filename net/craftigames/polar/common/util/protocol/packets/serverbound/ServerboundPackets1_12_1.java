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
/*    */ public enum ServerboundPackets1_12_1
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   TAB_COMPLETE,
/* 26 */   CHAT_MESSAGE,
/* 27 */   CLIENT_STATUS,
/* 28 */   CLIENT_SETTINGS,
/* 29 */   WINDOW_CONFIRMATION,
/* 30 */   CLICK_WINDOW_BUTTON,
/* 31 */   CLICK_WINDOW,
/* 32 */   CLOSE_WINDOW,
/* 33 */   PLUGIN_MESSAGE,
/* 34 */   INTERACT_ENTITY,
/* 35 */   KEEP_ALIVE,
/* 36 */   PLAYER_MOVEMENT,
/* 37 */   PLAYER_POSITION,
/* 38 */   PLAYER_POSITION_AND_ROTATION,
/* 39 */   PLAYER_ROTATION,
/* 40 */   VEHICLE_MOVE,
/* 41 */   STEER_BOAT,
/* 42 */   CRAFT_RECIPE_REQUEST,
/* 43 */   PLAYER_ABILITIES,
/* 44 */   PLAYER_DIGGING,
/* 45 */   ENTITY_ACTION,
/* 46 */   STEER_VEHICLE,
/* 47 */   RECIPE_BOOK_DATA,
/* 48 */   RESOURCE_PACK_STATUS,
/* 49 */   ADVANCEMENT_TAB,
/* 50 */   HELD_ITEM_CHANGE,
/* 51 */   CREATIVE_INVENTORY_ACTION,
/* 52 */   UPDATE_SIGN,
/* 53 */   ANIMATION,
/* 54 */   SPECTATE,
/* 55 */   PLAYER_BLOCK_PLACEMENT,
/* 56 */   USE_ITEM;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 60 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 65 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_12_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */