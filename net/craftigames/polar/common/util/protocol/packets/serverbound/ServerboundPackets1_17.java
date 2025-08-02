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
/*    */ public enum ServerboundPackets1_17
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   QUERY_BLOCK_NBT,
/* 26 */   SET_DIFFICULTY,
/* 27 */   CHAT_MESSAGE,
/* 28 */   CLIENT_STATUS,
/* 29 */   CLIENT_SETTINGS,
/* 30 */   TAB_COMPLETE,
/* 31 */   CLICK_WINDOW_BUTTON,
/* 32 */   CLICK_WINDOW,
/* 33 */   CLOSE_WINDOW,
/* 34 */   PLUGIN_MESSAGE,
/* 35 */   EDIT_BOOK,
/* 36 */   ENTITY_NBT_REQUEST,
/* 37 */   INTERACT_ENTITY,
/* 38 */   GENERATE_JIGSAW,
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
/* 53 */   PONG,
/* 54 */   RECIPE_BOOK_DATA,
/* 55 */   SEEN_RECIPE,
/* 56 */   RENAME_ITEM,
/* 57 */   RESOURCE_PACK_STATUS,
/* 58 */   ADVANCEMENT_TAB,
/* 59 */   SELECT_TRADE,
/* 60 */   SET_BEACON_EFFECT,
/* 61 */   HELD_ITEM_CHANGE,
/* 62 */   UPDATE_COMMAND_BLOCK,
/* 63 */   UPDATE_COMMAND_BLOCK_MINECART,
/* 64 */   CREATIVE_INVENTORY_ACTION,
/* 65 */   UPDATE_JIGSAW_BLOCK,
/* 66 */   UPDATE_STRUCTURE_BLOCK,
/* 67 */   UPDATE_SIGN,
/* 68 */   ANIMATION,
/* 69 */   SPECTATE,
/* 70 */   PLAYER_BLOCK_PLACEMENT,
/* 71 */   USE_ITEM;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 75 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 80 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_17.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */