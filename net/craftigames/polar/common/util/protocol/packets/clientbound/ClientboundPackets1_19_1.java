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
/*     */ public enum ClientboundPackets1_19_1
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
/*  45 */   CUSTOM_CHAT_COMPLETIONS,
/*  46 */   PLUGIN_MESSAGE,
/*  47 */   NAMED_SOUND,
/*  48 */   DELETE_CHAT_MESSAGE,
/*  49 */   DISCONNECT,
/*  50 */   ENTITY_STATUS,
/*  51 */   EXPLOSION,
/*  52 */   UNLOAD_CHUNK,
/*  53 */   GAME_EVENT,
/*  54 */   OPEN_HORSE_WINDOW,
/*  55 */   WORLD_BORDER_INIT,
/*  56 */   KEEP_ALIVE,
/*  57 */   CHUNK_DATA,
/*  58 */   EFFECT,
/*  59 */   SPAWN_PARTICLE,
/*  60 */   UPDATE_LIGHT,
/*  61 */   JOIN_GAME,
/*  62 */   MAP_DATA,
/*  63 */   TRADE_LIST,
/*  64 */   ENTITY_POSITION,
/*  65 */   ENTITY_POSITION_AND_ROTATION,
/*  66 */   ENTITY_ROTATION,
/*  67 */   VEHICLE_MOVE,
/*  68 */   OPEN_BOOK,
/*  69 */   OPEN_WINDOW,
/*  70 */   OPEN_SIGN_EDITOR,
/*  71 */   PING,
/*  72 */   CRAFT_RECIPE_RESPONSE,
/*  73 */   PLAYER_ABILITIES,
/*  74 */   PLAYER_CHAT_HEADER,
/*  75 */   PLAYER_CHAT,
/*  76 */   COMBAT_END,
/*  77 */   COMBAT_ENTER,
/*  78 */   COMBAT_KILL,
/*  79 */   PLAYER_INFO,
/*  80 */   FACE_PLAYER,
/*  81 */   PLAYER_POSITION,
/*  82 */   UNLOCK_RECIPES,
/*  83 */   REMOVE_ENTITIES,
/*  84 */   REMOVE_ENTITY_EFFECT,
/*  85 */   RESOURCE_PACK,
/*  86 */   RESPAWN,
/*  87 */   ENTITY_HEAD_LOOK,
/*  88 */   MULTI_BLOCK_CHANGE,
/*  89 */   SELECT_ADVANCEMENTS_TAB,
/*  90 */   SERVER_DATA,
/*  91 */   ACTIONBAR,
/*  92 */   WORLD_BORDER_CENTER,
/*  93 */   WORLD_BORDER_LERP_SIZE,
/*  94 */   WORLD_BORDER_SIZE,
/*  95 */   WORLD_BORDER_WARNING_DELAY,
/*  96 */   WORLD_BORDER_WARNING_DISTANCE,
/*  97 */   CAMERA,
/*  98 */   HELD_ITEM_CHANGE,
/*  99 */   UPDATE_VIEW_POSITION,
/* 100 */   UPDATE_VIEW_DISTANCE,
/* 101 */   SPAWN_POSITION,
/* 102 */   SET_DISPLAY_CHAT_PREVIEW,
/* 103 */   DISPLAY_SCOREBOARD,
/* 104 */   ENTITY_METADATA,
/* 105 */   ATTACH_ENTITY,
/* 106 */   ENTITY_VELOCITY,
/* 107 */   ENTITY_EQUIPMENT,
/* 108 */   SET_EXPERIENCE,
/* 109 */   UPDATE_HEALTH,
/* 110 */   SCOREBOARD_OBJECTIVE,
/* 111 */   SET_PASSENGERS,
/* 112 */   TEAMS,
/* 113 */   UPDATE_SCORE,
/* 114 */   SET_SIMULATION_DISTANCE,
/* 115 */   TITLE_SUBTITLE,
/* 116 */   TIME_UPDATE,
/* 117 */   TITLE_TEXT,
/* 118 */   TITLE_TIMES,
/* 119 */   ENTITY_SOUND,
/* 120 */   SOUND,
/* 121 */   STOP_SOUND,
/* 122 */   SYSTEM_CHAT,
/* 123 */   TAB_LIST,
/* 124 */   NBT_QUERY,
/* 125 */   COLLECT_ITEM,
/* 126 */   ENTITY_TELEPORT,
/* 127 */   ADVANCEMENTS,
/* 128 */   ENTITY_PROPERTIES,
/* 129 */   ENTITY_EFFECT,
/* 130 */   DECLARE_RECIPES,
/* 131 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 135 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 140 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_19_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */