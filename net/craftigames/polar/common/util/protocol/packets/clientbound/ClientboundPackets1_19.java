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
/*     */ public enum ClientboundPackets1_19
/*     */   implements ClientboundPackets
/*     */ {
/*  24 */   SPAWN_ENTITY,
/*  25 */   SPAWN_EXPERIENCE_ORB,
/*  26 */   SPAWN_PLAYER,
/*  27 */   ENTITY_ANIMATION,
/*  28 */   STATISTICS,
/*  29 */   BLOCK_CHANGED_ACK,
/*  30 */   BLOCK_BREAK_ANIMATION,
/*  31 */   BLOCK_ENTITY_DATA,
/*  32 */   BLOCK_ACTION,
/*  33 */   BLOCK_CHANGE,
/*  34 */   BOSSBAR,
/*  35 */   SERVER_DIFFICULTY,
/*  36 */   CHAT_PREVIEW,
/*  37 */   CLEAR_TITLES,
/*  38 */   TAB_COMPLETE,
/*  39 */   DECLARE_COMMANDS,
/*  40 */   CLOSE_WINDOW,
/*  41 */   WINDOW_ITEMS,
/*  42 */   WINDOW_PROPERTY,
/*  43 */   SET_SLOT,
/*  44 */   COOLDOWN,
/*  45 */   PLUGIN_MESSAGE,
/*  46 */   NAMED_SOUND,
/*  47 */   DISCONNECT,
/*  48 */   ENTITY_STATUS,
/*  49 */   EXPLOSION,
/*  50 */   UNLOAD_CHUNK,
/*  51 */   GAME_EVENT,
/*  52 */   OPEN_HORSE_WINDOW,
/*  53 */   WORLD_BORDER_INIT,
/*  54 */   KEEP_ALIVE,
/*  55 */   CHUNK_DATA,
/*  56 */   EFFECT,
/*  57 */   SPAWN_PARTICLE,
/*  58 */   UPDATE_LIGHT,
/*  59 */   JOIN_GAME,
/*  60 */   MAP_DATA,
/*  61 */   TRADE_LIST,
/*  62 */   ENTITY_POSITION,
/*  63 */   ENTITY_POSITION_AND_ROTATION,
/*  64 */   ENTITY_ROTATION,
/*  65 */   VEHICLE_MOVE,
/*  66 */   OPEN_BOOK,
/*  67 */   OPEN_WINDOW,
/*  68 */   OPEN_SIGN_EDITOR,
/*  69 */   PING,
/*  70 */   CRAFT_RECIPE_RESPONSE,
/*  71 */   PLAYER_ABILITIES,
/*  72 */   PLAYER_CHAT,
/*  73 */   COMBAT_END,
/*  74 */   COMBAT_ENTER,
/*  75 */   COMBAT_KILL,
/*  76 */   PLAYER_INFO,
/*  77 */   FACE_PLAYER,
/*  78 */   PLAYER_POSITION,
/*  79 */   UNLOCK_RECIPES,
/*  80 */   REMOVE_ENTITIES,
/*  81 */   REMOVE_ENTITY_EFFECT,
/*  82 */   RESOURCE_PACK,
/*  83 */   RESPAWN,
/*  84 */   ENTITY_HEAD_LOOK,
/*  85 */   MULTI_BLOCK_CHANGE,
/*  86 */   SELECT_ADVANCEMENTS_TAB,
/*  87 */   SERVER_DATA,
/*  88 */   ACTIONBAR,
/*  89 */   WORLD_BORDER_CENTER,
/*  90 */   WORLD_BORDER_LERP_SIZE,
/*  91 */   WORLD_BORDER_SIZE,
/*  92 */   WORLD_BORDER_WARNING_DELAY,
/*  93 */   WORLD_BORDER_WARNING_DISTANCE,
/*  94 */   CAMERA,
/*  95 */   HELD_ITEM_CHANGE,
/*  96 */   UPDATE_VIEW_POSITION,
/*  97 */   UPDATE_VIEW_DISTANCE,
/*  98 */   SPAWN_POSITION,
/*  99 */   SET_DISPLAY_CHAT_PREVIEW,
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
/* 111 */   SET_SIMULATION_DISTANCE,
/* 112 */   TITLE_SUBTITLE,
/* 113 */   TIME_UPDATE,
/* 114 */   TITLE_TEXT,
/* 115 */   TITLE_TIMES,
/* 116 */   ENTITY_SOUND,
/* 117 */   SOUND,
/* 118 */   STOP_SOUND,
/* 119 */   SYSTEM_CHAT,
/* 120 */   TAB_LIST,
/* 121 */   NBT_QUERY,
/* 122 */   COLLECT_ITEM,
/* 123 */   ENTITY_TELEPORT,
/* 124 */   ADVANCEMENTS,
/* 125 */   ENTITY_PROPERTIES,
/* 126 */   ENTITY_EFFECT,
/* 127 */   DECLARE_RECIPES,
/* 128 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 132 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 137 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_19.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */