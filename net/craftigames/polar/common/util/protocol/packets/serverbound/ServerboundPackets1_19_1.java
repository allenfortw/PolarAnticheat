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
/*    */ public enum ServerboundPackets1_19_1
/*    */   implements ServerboundPackets
/*    */ {
/* 24 */   TELEPORT_CONFIRM,
/* 25 */   QUERY_BLOCK_NBT,
/* 26 */   SET_DIFFICULTY,
/* 27 */   CHAT_ACK,
/* 28 */   CHAT_COMMAND,
/* 29 */   CHAT_MESSAGE,
/* 30 */   CHAT_PREVIEW,
/* 31 */   CLIENT_STATUS,
/* 32 */   CLIENT_SETTINGS,
/* 33 */   TAB_COMPLETE,
/* 34 */   CLICK_WINDOW_BUTTON,
/* 35 */   CLICK_WINDOW,
/* 36 */   CLOSE_WINDOW,
/* 37 */   PLUGIN_MESSAGE,
/* 38 */   EDIT_BOOK,
/* 39 */   ENTITY_NBT_REQUEST,
/* 40 */   INTERACT_ENTITY,
/* 41 */   GENERATE_JIGSAW,
/* 42 */   KEEP_ALIVE,
/* 43 */   LOCK_DIFFICULTY,
/* 44 */   PLAYER_POSITION,
/* 45 */   PLAYER_POSITION_AND_ROTATION,
/* 46 */   PLAYER_ROTATION,
/* 47 */   PLAYER_MOVEMENT,
/* 48 */   VEHICLE_MOVE,
/* 49 */   STEER_BOAT,
/* 50 */   PICK_ITEM,
/* 51 */   CRAFT_RECIPE_REQUEST,
/* 52 */   PLAYER_ABILITIES,
/* 53 */   PLAYER_DIGGING,
/* 54 */   ENTITY_ACTION,
/* 55 */   STEER_VEHICLE,
/* 56 */   PONG,
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


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\serverbound\ServerboundPackets1_19_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */