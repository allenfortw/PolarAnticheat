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
/*     */ public enum ClientboundPackets1_16_2
/*     */   implements ClientboundPackets
/*     */ {
/*  24 */   SPAWN_ENTITY,
/*  25 */   SPAWN_EXPERIENCE_ORB,
/*  26 */   SPAWN_MOB,
/*  27 */   SPAWN_PAINTING,
/*  28 */   SPAWN_PLAYER,
/*  29 */   ENTITY_ANIMATION,
/*  30 */   STATISTICS,
/*  31 */   ACKNOWLEDGE_PLAYER_DIGGING,
/*  32 */   BLOCK_BREAK_ANIMATION,
/*  33 */   BLOCK_ENTITY_DATA,
/*  34 */   BLOCK_ACTION,
/*  35 */   BLOCK_CHANGE,
/*  36 */   BOSSBAR,
/*  37 */   SERVER_DIFFICULTY,
/*  38 */   CHAT_MESSAGE,
/*  39 */   TAB_COMPLETE,
/*  40 */   DECLARE_COMMANDS,
/*  41 */   WINDOW_CONFIRMATION,
/*  42 */   CLOSE_WINDOW,
/*  43 */   WINDOW_ITEMS,
/*  44 */   WINDOW_PROPERTY,
/*  45 */   SET_SLOT,
/*  46 */   COOLDOWN,
/*  47 */   PLUGIN_MESSAGE,
/*  48 */   NAMED_SOUND,
/*  49 */   DISCONNECT,
/*  50 */   ENTITY_STATUS,
/*  51 */   EXPLOSION,
/*  52 */   UNLOAD_CHUNK,
/*  53 */   GAME_EVENT,
/*  54 */   OPEN_HORSE_WINDOW,
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
/*  66 */   ENTITY_MOVEMENT,
/*  67 */   VEHICLE_MOVE,
/*  68 */   OPEN_BOOK,
/*  69 */   OPEN_WINDOW,
/*  70 */   OPEN_SIGN_EDITOR,
/*  71 */   CRAFT_RECIPE_RESPONSE,
/*  72 */   PLAYER_ABILITIES,
/*  73 */   COMBAT_EVENT,
/*  74 */   PLAYER_INFO,
/*  75 */   FACE_PLAYER,
/*  76 */   PLAYER_POSITION,
/*  77 */   UNLOCK_RECIPES,
/*  78 */   DESTROY_ENTITIES,
/*  79 */   REMOVE_ENTITY_EFFECT,
/*  80 */   RESOURCE_PACK,
/*  81 */   RESPAWN,
/*  82 */   ENTITY_HEAD_LOOK,
/*  83 */   MULTI_BLOCK_CHANGE,
/*  84 */   SELECT_ADVANCEMENTS_TAB,
/*  85 */   WORLD_BORDER,
/*  86 */   CAMERA,
/*  87 */   HELD_ITEM_CHANGE,
/*  88 */   UPDATE_VIEW_POSITION,
/*  89 */   UPDATE_VIEW_DISTANCE,
/*  90 */   SPAWN_POSITION,
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
/* 102 */   TIME_UPDATE,
/* 103 */   TITLE,
/* 104 */   ENTITY_SOUND,
/* 105 */   SOUND,
/* 106 */   STOP_SOUND,
/* 107 */   TAB_LIST,
/* 108 */   NBT_QUERY,
/* 109 */   COLLECT_ITEM,
/* 110 */   ENTITY_TELEPORT,
/* 111 */   ADVANCEMENTS,
/* 112 */   ENTITY_PROPERTIES,
/* 113 */   ENTITY_EFFECT,
/* 114 */   DECLARE_RECIPES,
/* 115 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 119 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 124 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_16_2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */