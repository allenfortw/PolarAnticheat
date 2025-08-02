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
/*    */ public enum ServerboundPackets1_14
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   QUERY_BLOCK_NBT,
/* 26 */   SET_DIFFICULTY,
/* 27 */   CHAT_MESSAGE,
/* 28 */   CLIENT_STATUS,
/* 29 */   CLIENT_SETTINGS,
/* 30 */   TAB_COMPLETE,
/* 31 */   WINDOW_CONFIRMATION,
/* 32 */   CLICK_WINDOW_BUTTON,
/* 33 */   CLICK_WINDOW,
/* 34 */   CLOSE_WINDOW,
/* 35 */   PLUGIN_MESSAGE,
/* 36 */   EDIT_BOOK,
/* 37 */   ENTITY_NBT_REQUEST,
/* 38 */   INTERACT_ENTITY,
/* 39 */   KEEP_ALIVE,
/* 40 */   LOCK_DIFFICULTY,
/* 41 */   PLAYER_POSITION,
/* 42 */   PLAYER_POSITION_AND_ROTATION,
/* 43 */   PLAYER_ROTATION,
/* 44 */   PLAYER_MOVEMENT,
/* 45 */   VEHICLE_MOVE,
/* 46 */   STEER_BOAT,
/* 47 */   PICK_ITEM,
/* 48 */   CRAFT_RECIPE_REQUEST,
/* 49 */   PLAYER_ABILITIES,
/* 50 */   PLAYER_DIGGING,
/* 51 */   ENTITY_ACTION,
/* 52 */   STEER_VEHICLE,
/* 53 */   RECIPE_BOOK_DATA,
/* 54 */   RENAME_ITEM,
/* 55 */   RESOURCE_PACK_STATUS,
/* 56 */   ADVANCEMENT_TAB,
/* 57 */   SELECT_TRADE,
/* 58 */   SET_BEACON_EFFECT,
/* 59 */   HELD_ITEM_CHANGE,
/* 60 */   UPDATE_COMMAND_BLOCK,
/* 61 */   UPDATE_COMMAND_BLOCK_MINECART,
/* 62 */   CREATIVE_INVENTORY_ACTION,
/* 63 */   UPDATE_JIGSAW_BLOCK,
/* 64 */   UPDATE_STRUCTURE_BLOCK,
/* 65 */   UPDATE_SIGN,
/* 66 */   ANIMATION,
/* 67 */   SPECTATE,
/* 68 */   PLAYER_BLOCK_PLACEMENT,
/* 69 */   USE_ITEM;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 73 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 78 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */