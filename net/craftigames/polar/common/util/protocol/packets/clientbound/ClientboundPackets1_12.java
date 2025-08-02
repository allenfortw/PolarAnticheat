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
/*     */ public enum ClientboundPackets1_12
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
/*  32 */   BLOCK_BREAK_ANIMATION,
/*  33 */   BLOCK_ENTITY_DATA,
/*  34 */   BLOCK_ACTION,
/*  35 */   BLOCK_CHANGE,
/*  36 */   BOSSBAR,
/*  37 */   SERVER_DIFFICULTY,
/*  38 */   TAB_COMPLETE,
/*  39 */   CHAT_MESSAGE,
/*  40 */   MULTI_BLOCK_CHANGE,
/*  41 */   WINDOW_CONFIRMATION,
/*  42 */   CLOSE_WINDOW,
/*  43 */   OPEN_WINDOW,
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
/*  55 */   KEEP_ALIVE,
/*  56 */   CHUNK_DATA,
/*  57 */   EFFECT,
/*  58 */   SPAWN_PARTICLE,
/*  59 */   JOIN_GAME,
/*  60 */   MAP_DATA,
/*  61 */   ENTITY_MOVEMENT,
/*  62 */   ENTITY_POSITION,
/*  63 */   ENTITY_POSITION_AND_ROTATION,
/*  64 */   ENTITY_ROTATION,
/*  65 */   VEHICLE_MOVE,
/*  66 */   OPEN_SIGN_EDITOR,
/*  67 */   PLAYER_ABILITIES,
/*  68 */   COMBAT_EVENT,
/*  69 */   PLAYER_INFO,
/*  70 */   PLAYER_POSITION,
/*  71 */   USE_BED,
/*  72 */   UNLOCK_RECIPES,
/*  73 */   DESTROY_ENTITIES,
/*  74 */   REMOVE_ENTITY_EFFECT,
/*  75 */   RESOURCE_PACK,
/*  76 */   RESPAWN,
/*  77 */   ENTITY_HEAD_LOOK,
/*  78 */   SELECT_ADVANCEMENTS_TAB,
/*  79 */   WORLD_BORDER,
/*  80 */   CAMERA,
/*  81 */   HELD_ITEM_CHANGE,
/*  82 */   DISPLAY_SCOREBOARD,
/*  83 */   ENTITY_METADATA,
/*  84 */   ATTACH_ENTITY,
/*  85 */   ENTITY_VELOCITY,
/*  86 */   ENTITY_EQUIPMENT,
/*  87 */   SET_EXPERIENCE,
/*  88 */   UPDATE_HEALTH,
/*  89 */   SCOREBOARD_OBJECTIVE,
/*  90 */   SET_PASSENGERS,
/*  91 */   TEAMS,
/*  92 */   UPDATE_SCORE,
/*  93 */   SPAWN_POSITION,
/*  94 */   TIME_UPDATE,
/*  95 */   TITLE,
/*  96 */   SOUND,
/*  97 */   TAB_LIST,
/*  98 */   COLLECT_ITEM,
/*  99 */   ENTITY_TELEPORT,
/* 100 */   ADVANCEMENTS,
/* 101 */   ENTITY_PROPERTIES,
/* 102 */   ENTITY_EFFECT;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 106 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 111 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_12.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */