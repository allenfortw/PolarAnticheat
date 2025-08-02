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
/*     */ public enum ClientboundPackets1_13
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
/*  38 */   CHAT_MESSAGE,
/*  39 */   MULTI_BLOCK_CHANGE,
/*  40 */   TAB_COMPLETE,
/*  41 */   DECLARE_COMMANDS,
/*  42 */   WINDOW_CONFIRMATION,
/*  43 */   CLOSE_WINDOW,
/*  44 */   OPEN_WINDOW,
/*  45 */   WINDOW_ITEMS,
/*  46 */   WINDOW_PROPERTY,
/*  47 */   SET_SLOT,
/*  48 */   COOLDOWN,
/*  49 */   PLUGIN_MESSAGE,
/*  50 */   NAMED_SOUND,
/*  51 */   DISCONNECT,
/*  52 */   ENTITY_STATUS,
/*  53 */   NBT_QUERY,
/*  54 */   EXPLOSION,
/*  55 */   UNLOAD_CHUNK,
/*  56 */   GAME_EVENT,
/*  57 */   KEEP_ALIVE,
/*  58 */   CHUNK_DATA,
/*  59 */   EFFECT,
/*  60 */   SPAWN_PARTICLE,
/*  61 */   JOIN_GAME,
/*  62 */   MAP_DATA,
/*  63 */   ENTITY_MOVEMENT,
/*  64 */   ENTITY_POSITION,
/*  65 */   ENTITY_POSITION_AND_ROTATION,
/*  66 */   ENTITY_ROTATION,
/*  67 */   VEHICLE_MOVE,
/*  68 */   OPEN_SIGN_EDITOR,
/*  69 */   CRAFT_RECIPE_RESPONSE,
/*  70 */   PLAYER_ABILITIES,
/*  71 */   COMBAT_EVENT,
/*  72 */   PLAYER_INFO,
/*  73 */   FACE_PLAYER,
/*  74 */   PLAYER_POSITION,
/*  75 */   USE_BED,
/*  76 */   UNLOCK_RECIPES,
/*  77 */   DESTROY_ENTITIES,
/*  78 */   REMOVE_ENTITY_EFFECT,
/*  79 */   RESOURCE_PACK,
/*  80 */   RESPAWN,
/*  81 */   ENTITY_HEAD_LOOK,
/*  82 */   SELECT_ADVANCEMENTS_TAB,
/*  83 */   WORLD_BORDER,
/*  84 */   CAMERA,
/*  85 */   HELD_ITEM_CHANGE,
/*  86 */   DISPLAY_SCOREBOARD,
/*  87 */   ENTITY_METADATA,
/*  88 */   ATTACH_ENTITY,
/*  89 */   ENTITY_VELOCITY,
/*  90 */   ENTITY_EQUIPMENT,
/*  91 */   SET_EXPERIENCE,
/*  92 */   UPDATE_HEALTH,
/*  93 */   SCOREBOARD_OBJECTIVE,
/*  94 */   SET_PASSENGERS,
/*  95 */   TEAMS,
/*  96 */   UPDATE_SCORE,
/*  97 */   SPAWN_POSITION,
/*  98 */   TIME_UPDATE,
/*  99 */   TITLE,
/* 100 */   STOP_SOUND,
/* 101 */   SOUND,
/* 102 */   TAB_LIST,
/* 103 */   COLLECT_ITEM,
/* 104 */   ENTITY_TELEPORT,
/* 105 */   ADVANCEMENTS,
/* 106 */   ENTITY_PROPERTIES,
/* 107 */   ENTITY_EFFECT,
/* 108 */   DECLARE_RECIPES,
/* 109 */   TAGS;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 113 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 118 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */