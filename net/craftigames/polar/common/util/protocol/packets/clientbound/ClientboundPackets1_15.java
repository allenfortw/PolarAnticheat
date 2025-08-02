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
/*     */ public enum ClientboundPackets1_15
/*     */   implements ClientboundPackets
/*     */ {
/*  24 */   SPAWN_ENTITY,
/*  25 */   SPAWN_EXPERIENCE_ORB,
/*  26 */   SPAWN_GLOBAL_ENTITY,
/*  27 */   SPAWN_MOB,
/*  28 */   SPAWN_PAINTING,
/*  29 */   SPAWN_PLAYER,
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
/*  40 */   MULTI_BLOCK_CHANGE,
/*  41 */   TAB_COMPLETE,
/*  42 */   DECLARE_COMMANDS,
/*  43 */   WINDOW_CONFIRMATION,
/*  44 */   CLOSE_WINDOW,
/*  45 */   WINDOW_ITEMS,
/*  46 */   WINDOW_PROPERTY,
/*  47 */   SET_SLOT,
/*  48 */   COOLDOWN,
/*  49 */   PLUGIN_MESSAGE,
/*  50 */   NAMED_SOUND,
/*  51 */   DISCONNECT,
/*  52 */   ENTITY_STATUS,
/*  53 */   EXPLOSION,
/*  54 */   UNLOAD_CHUNK,
/*  55 */   GAME_EVENT,
/*  56 */   OPEN_HORSE_WINDOW,
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
/*  68 */   ENTITY_MOVEMENT,
/*  69 */   VEHICLE_MOVE,
/*  70 */   OPEN_BOOK,
/*  71 */   OPEN_WINDOW,
/*  72 */   OPEN_SIGN_EDITOR,
/*  73 */   CRAFT_RECIPE_RESPONSE,
/*  74 */   PLAYER_ABILITIES,
/*  75 */   COMBAT_EVENT,
/*  76 */   PLAYER_INFO,
/*  77 */   FACE_PLAYER,
/*  78 */   PLAYER_POSITION,
/*  79 */   UNLOCK_RECIPES,
/*  80 */   DESTROY_ENTITIES,
/*  81 */   REMOVE_ENTITY_EFFECT,
/*  82 */   RESOURCE_PACK,
/*  83 */   RESPAWN,
/*  84 */   ENTITY_HEAD_LOOK,
/*  85 */   SELECT_ADVANCEMENTS_TAB,
/*  86 */   WORLD_BORDER,
/*  87 */   CAMERA,
/*  88 */   HELD_ITEM_CHANGE,
/*  89 */   UPDATE_VIEW_POSITION,
/*  90 */   UPDATE_VIEW_DISTANCE,
/*  91 */   DISPLAY_SCOREBOARD,
/*  92 */   ENTITY_METADATA,
/*  93 */   ATTACH_ENTITY,
/*  94 */   ENTITY_VELOCITY,
/*  95 */   ENTITY_EQUIPMENT,
/*  96 */   SET_EXPERIENCE,
/*  97 */   UPDATE_HEALTH,
/*  98 */   SCOREBOARD_OBJECTIVE,
/*  99 */   SET_PASSENGERS,
/* 100 */   TEAMS,
/* 101 */   UPDATE_SCORE,
/* 102 */   SPAWN_POSITION,
/* 103 */   TIME_UPDATE,
/* 104 */   TITLE,
/* 105 */   ENTITY_SOUND,
/* 106 */   SOUND,
/* 107 */   STOP_SOUND,
/* 108 */   TAB_LIST,
/* 109 */   NBT_QUERY,
/* 110 */   COLLECT_ITEM,
/* 111 */   ENTITY_TELEPORT,
/* 112 */   ADVANCEMENTS,
/* 113 */   ENTITY_PROPERTIES,
/* 114 */   ENTITY_EFFECT,
/* 115 */   DECLARE_RECIPES,
/* 116 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 120 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 125 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */