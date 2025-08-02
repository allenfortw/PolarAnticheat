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
/*     */ public enum ClientboundPackets1_9_3
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
/*  61 */   ENTITY_POSITION,
/*  62 */   ENTITY_POSITION_AND_ROTATION,
/*  63 */   ENTITY_ROTATION,
/*  64 */   ENTITY_MOVEMENT,
/*  65 */   VEHICLE_MOVE,
/*  66 */   OPEN_SIGN_EDITOR,
/*  67 */   PLAYER_ABILITIES,
/*  68 */   COMBAT_EVENT,
/*  69 */   PLAYER_INFO,
/*  70 */   PLAYER_POSITION,
/*  71 */   USE_BED,
/*  72 */   DESTROY_ENTITIES,
/*  73 */   REMOVE_ENTITY_EFFECT,
/*  74 */   RESOURCE_PACK,
/*  75 */   RESPAWN,
/*  76 */   ENTITY_HEAD_LOOK,
/*  77 */   WORLD_BORDER,
/*  78 */   CAMERA,
/*  79 */   HELD_ITEM_CHANGE,
/*  80 */   DISPLAY_SCOREBOARD,
/*  81 */   ENTITY_METADATA,
/*  82 */   ATTACH_ENTITY,
/*  83 */   ENTITY_VELOCITY,
/*  84 */   ENTITY_EQUIPMENT,
/*  85 */   SET_EXPERIENCE,
/*  86 */   UPDATE_HEALTH,
/*  87 */   SCOREBOARD_OBJECTIVE,
/*  88 */   SET_PASSENGERS,
/*  89 */   TEAMS,
/*  90 */   UPDATE_SCORE,
/*  91 */   SPAWN_POSITION,
/*  92 */   TIME_UPDATE,
/*  93 */   TITLE,
/*  94 */   SOUND,
/*  95 */   TAB_LIST,
/*  96 */   COLLECT_ITEM,
/*  97 */   ENTITY_TELEPORT,
/*  98 */   ENTITY_PROPERTIES,
/*  99 */   ENTITY_EFFECT;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 103 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 108 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_9_3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */