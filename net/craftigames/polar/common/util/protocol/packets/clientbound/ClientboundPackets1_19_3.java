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
/*     */ public enum ClientboundPackets1_19_3
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
/*  36 */   CLEAR_TITLES,
/*  37 */   TAB_COMPLETE,
/*  38 */   DECLARE_COMMANDS,
/*  39 */   CLOSE_WINDOW,
/*  40 */   WINDOW_ITEMS,
/*  41 */   WINDOW_PROPERTY,
/*  42 */   SET_SLOT,
/*  43 */   COOLDOWN,
/*  44 */   CUSTOM_CHAT_COMPLETIONS,
/*  45 */   PLUGIN_MESSAGE,
/*  46 */   DELETE_CHAT_MESSAGE,
/*  47 */   DISCONNECT,
/*  48 */   DISGUISED_CHAT,
/*  49 */   ENTITY_STATUS,
/*  50 */   EXPLOSION,
/*  51 */   UNLOAD_CHUNK,
/*  52 */   GAME_EVENT,
/*  53 */   OPEN_HORSE_WINDOW,
/*  54 */   WORLD_BORDER_INIT,
/*  55 */   KEEP_ALIVE,
/*  56 */   CHUNK_DATA,
/*  57 */   EFFECT,
/*  58 */   SPAWN_PARTICLE,
/*  59 */   UPDATE_LIGHT,
/*  60 */   JOIN_GAME,
/*  61 */   MAP_DATA,
/*  62 */   TRADE_LIST,
/*  63 */   ENTITY_POSITION,
/*  64 */   ENTITY_POSITION_AND_ROTATION,
/*  65 */   ENTITY_ROTATION,
/*  66 */   VEHICLE_MOVE,
/*  67 */   OPEN_BOOK,
/*  68 */   OPEN_WINDOW,
/*  69 */   OPEN_SIGN_EDITOR,
/*  70 */   PING,
/*  71 */   CRAFT_RECIPE_RESPONSE,
/*  72 */   PLAYER_ABILITIES,
/*  73 */   PLAYER_CHAT,
/*  74 */   COMBAT_END,
/*  75 */   COMBAT_ENTER,
/*  76 */   COMBAT_KILL,
/*  77 */   PLAYER_INFO_REMOVE,
/*  78 */   PLAYER_INFO_UPDATE,
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
/*  89 */   SERVER_DATA,
/*  90 */   ACTIONBAR,
/*  91 */   WORLD_BORDER_CENTER,
/*  92 */   WORLD_BORDER_LERP_SIZE,
/*  93 */   WORLD_BORDER_SIZE,
/*  94 */   WORLD_BORDER_WARNING_DELAY,
/*  95 */   WORLD_BORDER_WARNING_DISTANCE,
/*  96 */   CAMERA,
/*  97 */   HELD_ITEM_CHANGE,
/*  98 */   UPDATE_VIEW_POSITION,
/*  99 */   UPDATE_VIEW_DISTANCE,
/* 100 */   SPAWN_POSITION,
/* 101 */   DISPLAY_SCOREBOARD,
/* 102 */   ENTITY_METADATA,
/* 103 */   ATTACH_ENTITY,
/* 104 */   ENTITY_VELOCITY,
/* 105 */   ENTITY_EQUIPMENT,
/* 106 */   SET_EXPERIENCE,
/* 107 */   UPDATE_HEALTH,
/* 108 */   SCOREBOARD_OBJECTIVE,
/* 109 */   SET_PASSENGERS,
/* 110 */   TEAMS,
/* 111 */   UPDATE_SCORE,
/* 112 */   SET_SIMULATION_DISTANCE,
/* 113 */   TITLE_SUBTITLE,
/* 114 */   TIME_UPDATE,
/* 115 */   TITLE_TEXT,
/* 116 */   TITLE_TIMES,
/* 117 */   ENTITY_SOUND,
/* 118 */   SOUND,
/* 119 */   STOP_SOUND,
/* 120 */   SYSTEM_CHAT,
/* 121 */   TAB_LIST,
/* 122 */   NBT_QUERY,
/* 123 */   COLLECT_ITEM,
/* 124 */   ENTITY_TELEPORT,
/* 125 */   ADVANCEMENTS,
/* 126 */   ENTITY_PROPERTIES,
/* 127 */   UPDATE_ENABLED_FEATURES,
/* 128 */   ENTITY_EFFECT,
/* 129 */   DECLARE_RECIPES,
/* 130 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 134 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 139 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_19_3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */