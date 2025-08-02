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
/*    */ public enum ServerboundPackets1_19_3
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   QUERY_BLOCK_NBT,
/* 26 */   SET_DIFFICULTY,
/* 27 */   CHAT_ACK,
/* 28 */   CHAT_COMMAND,
/* 29 */   CHAT_MESSAGE,
/* 30 */   CLIENT_STATUS,
/* 31 */   CLIENT_SETTINGS,
/* 32 */   TAB_COMPLETE,
/* 33 */   CLICK_WINDOW_BUTTON,
/* 34 */   CLICK_WINDOW,
/* 35 */   CLOSE_WINDOW,
/* 36 */   PLUGIN_MESSAGE,
/* 37 */   EDIT_BOOK,
/* 38 */   ENTITY_NBT_REQUEST,
/* 39 */   INTERACT_ENTITY,
/* 40 */   GENERATE_JIGSAW,
/* 41 */   KEEP_ALIVE,
/* 42 */   LOCK_DIFFICULTY,
/* 43 */   PLAYER_POSITION,
/* 44 */   PLAYER_POSITION_AND_ROTATION,
/* 45 */   PLAYER_ROTATION,
/* 46 */   PLAYER_MOVEMENT,
/* 47 */   VEHICLE_MOVE,
/* 48 */   STEER_BOAT,
/* 49 */   PICK_ITEM,
/* 50 */   CRAFT_RECIPE_REQUEST,
/* 51 */   PLAYER_ABILITIES,
/* 52 */   PLAYER_DIGGING,
/* 53 */   ENTITY_ACTION,
/* 54 */   STEER_VEHICLE,
/* 55 */   PONG,
/* 56 */   CHAT_SESSION_UPDATE,
/* 57 */   RECIPE_BOOK_DATA,
/* 58 */   SEEN_RECIPE,
/* 59 */   RENAME_ITEM,
/* 60 */   RESOURCE_PACK_STATUS,
/* 61 */   ADVANCEMENT_TAB,
/* 62 */   SELECT_TRADE,
/* 63 */   SET_BEACON_EFFECT,
/* 64 */   HELD_ITEM_CHANGE,
/* 65 */   UPDATE_COMMAND_BLOCK,
/* 66 */   UPDATE_COMMAND_BLOCK_MINECART,
/* 67 */   CREATIVE_INVENTORY_ACTION,
/* 68 */   UPDATE_JIGSAW_BLOCK,
/* 69 */   UPDATE_STRUCTURE_BLOCK,
/* 70 */   UPDATE_SIGN,
/* 71 */   ANIMATION,
/* 72 */   SPECTATE,
/* 73 */   PLAYER_BLOCK_PLACEMENT,
/* 74 */   USE_ITEM;
/*    */ 
/*    */   
/*    */   public int getId() {
/* 78 */     return ordinal();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 83 */     return name();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_19_3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */