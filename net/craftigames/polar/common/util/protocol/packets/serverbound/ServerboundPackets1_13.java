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
/*    */ public enum ServerboundPackets1_13
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   QUERY_BLOCK_NBT,
/* 26 */   CHAT_MESSAGE,
/* 27 */   CLIENT_STATUS,
/* 28 */   CLIENT_SETTINGS,
/* 29 */   TAB_COMPLETE,
/* 30 */   WINDOW_CONFIRMATION,
/* 31 */   CLICK_WINDOW_BUTTON,
/* 32 */   CLICK_WINDOW,
/* 33 */   CLOSE_WINDOW,
/* 34 */   PLUGIN_MESSAGE,
/* 35 */   EDIT_BOOK,
/* 36 */   ENTITY_NBT_REQUEST,
/* 37 */   INTERACT_ENTITY,
/* 38 */   KEEP_ALIVE,
/* 39 */   PLAYER_MOVEMENT,
/* 40 */   PLAYER_POSITION,
/* 41 */   PLAYER_POSITION_AND_ROTATION,
/* 42 */   PLAYER_ROTATION,
/* 43 */   VEHICLE_MOVE,
/* 44 */   STEER_BOAT,
/* 45 */   PICK_ITEM,
/* 46 */   CRAFT_RECIPE_REQUEST,
/* 47 */   PLAYER_ABILITIES,
/* 48 */   PLAYER_DIGGING,
/* 49 */   ENTITY_ACTION,
/* 50 */   STEER_VEHICLE,
/* 51 */   RECIPE_BOOK_DATA,
/* 52 */   RENAME_ITEM,
/* 53 */   RESOURCE_PACK_STATUS,
/* 54 */   ADVANCEMENT_TAB,
/* 55 */   SELECT_TRADE,
/* 56 */   SET_BEACON_EFFECT,
/* 57 */   HELD_ITEM_CHANGE,
/* 58 */   UPDATE_COMMAND_BLOCK,
/* 59 */   UPDATE_COMMAND_BLOCK_MINECART,
/* 60 */   CREATIVE_INVENTORY_ACTION,
/* 61 */   UPDATE_STRUCTURE_BLOCK,
/* 62 */   UPDATE_SIGN,
/* 63 */   ANIMATION,
/* 64 */   SPECTATE,
/* 65 */   PLAYER_BLOCK_PLACEMENT,
/* 66 */   USE_ITEM;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 70 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 75 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */