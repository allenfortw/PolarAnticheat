/*     */ package net.craftigames.polar.common.util.protocol.packets.clientbound;
/*     */ 
/*     */ import net.craftigames.polar.common.util.protocol.packets.ClientboundPackets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ClientboundPackets1_17_1
/*     */   implements ClientboundPackets
/*     */ {
/*  24 */   SPAWN_ENTITY,
/*  25 */   SPAWN_EXPERIENCE_ORB,
/*  26 */   SPAWN_MOB,
/*  27 */   SPAWN_PAINTING,
/*  28 */   SPAWN_PLAYER,
/*  29 */   ADD_VIBRATION_SIGNAL,
/*  30 */   ENTITY_ANIMATION,
/*  31 */   STATISTICS,
/*  32 */   ACKNOWLEDGE_PLAYER_DIGGING,
/*  33 */   BLOCK_BREAK_ANIMATION,
/*  34 */   BLOCK_ENTITY_DATA,
/*  35 */   BLOCK_ACTION,
/*  36 */   BLOCK_CHANGE,
/*  37 */   BOSSBAR,
/*  38 */   SERVER_DIFFICULTY,
/*  39 */   CHAT_MESSAGE,
/*  40 */   CLEAR_TITLES,
/*  41 */   TAB_COMPLETE,
/*  42 */   DECLARE_COMMANDS,
/*  43 */   CLOSE_WINDOW,
/*  44 */   WINDOW_ITEMS,
/*  45 */   WINDOW_PROPERTY,
/*  46 */   SET_SLOT,
/*  47 */   COOLDOWN,
/*  48 */   PLUGIN_MESSAGE,
/*  49 */   NAMED_SOUND,
/*  50 */   DISCONNECT,
/*  51 */   ENTITY_STATUS,
/*  52 */   EXPLOSION,
/*  53 */   UNLOAD_CHUNK,
/*  54 */   GAME_EVENT,
/*  55 */   OPEN_HORSE_WINDOW,
/*  56 */   WORLD_BORDER_INIT,
/*  57 */   KEEP_ALIVE,
/*  58 */   CHUNK_DATA,
/*  59 */   EFFECT,
/*  60 */   SPAWN_PARTICLE,
/*  61 */   UPDATE_LIGHT,
/*  62 */   JOIN_GAME,
/*  63 */   MAP_DATA,
/*  64 */   TRADE_LIST,
/*  65 */   ENTITY_POSITION,
/*  66 */   ENTITY_POSITION_AND_ROTATION,
/*  67 */   ENTITY_ROTATION,
/*  68 */   VEHICLE_MOVE,
/*  69 */   OPEN_BOOK,
/*  70 */   OPEN_WINDOW,
/*  71 */   OPEN_SIGN_EDITOR,
/*  72 */   PING,
/*  73 */   CRAFT_RECIPE_RESPONSE,
/*  74 */   PLAYER_ABILITIES,
/*  75 */   COMBAT_END,
/*  76 */   COMBAT_ENTER,
/*  77 */   COMBAT_KILL,
/*  78 */   PLAYER_INFO,
/*  79 */   FACE_PLAYER,
/*  80 */   PLAYER_POSITION,
/*  81 */   UNLOCK_RECIPES,
/*  82 */   REMOVE_ENTITIES,
/*  83 */   REMOVE_ENTITY_EFFECT,
/*  84 */   RESOURCE_PACK,
/*  85 */   RESPAWN,
/*  86 */   ENTITY_HEAD_LOOK,
/*  87 */   MULTI_BLOCK_CHANGE,
/*  88 */   SELECT_ADVANCEMENTS_TAB,
/*  89 */   ACTIONBAR,
/*  90 */   WORLD_BORDER_CENTER,
/*  91 */   WORLD_BORDER_LERP_SIZE,
/*  92 */   WORLD_BORDER_SIZE,
/*  93 */   WORLD_BORDER_WARNING_DELAY,
/*  94 */   WORLD_BORDER_WARNING_DISTANCE,
/*  95 */   CAMERA,
/*  96 */   HELD_ITEM_CHANGE,
/*  97 */   UPDATE_VIEW_POSITION,
/*  98 */   UPDATE_VIEW_DISTANCE,
/*  99 */   SPAWN_POSITION,
/* 100 */   DISPLAY_SCOREBOARD,
/* 101 */   ENTITY_METADATA,
/* 102 */   ATTACH_ENTITY,
/* 103 */   ENTITY_VELOCITY,
/* 104 */   ENTITY_EQUIPMENT,
/* 105 */   SET_EXPERIENCE,
/* 106 */   UPDATE_HEALTH,
/* 107 */   SCOREBOARD_OBJECTIVE,
/* 108 */   SET_PASSENGERS,
/* 109 */   TEAMS,
/* 110 */   UPDATE_SCORE,
/* 111 */   TITLE_SUBTITLE,
/* 112 */   TIME_UPDATE,
/* 113 */   TITLE_TEXT,
/* 114 */   TITLE_TIMES,
/* 115 */   ENTITY_SOUND,
/* 116 */   SOUND,
/* 117 */   STOP_SOUND,
/* 118 */   TAB_LIST,
/* 119 */   NBT_QUERY,
/* 120 */   COLLECT_ITEM,
/* 121 */   ENTITY_TELEPORT,
/* 122 */   ADVANCEMENTS,
/* 123 */   ENTITY_PROPERTIES,
/* 124 */   ENTITY_EFFECT,
/* 125 */   DECLARE_RECIPES,
/* 126 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 130 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 135 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_17_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */