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
/*     */ public enum ClientboundPackets1_8
/*     */   implements ClientboundPackets
/*     */ {
/*  24 */   KEEP_ALIVE,
/*  25 */   JOIN_GAME,
/*  26 */   CHAT_MESSAGE,
/*  27 */   TIME_UPDATE,
/*  28 */   ENTITY_EQUIPMENT,
/*  29 */   SPAWN_POSITION,
/*  30 */   UPDATE_HEALTH,
/*  31 */   RESPAWN,
/*  32 */   PLAYER_POSITION,
/*  33 */   HELD_ITEM_CHANGE,
/*  34 */   USE_BED,
/*  35 */   ENTITY_ANIMATION,
/*  36 */   SPAWN_PLAYER,
/*  37 */   COLLECT_ITEM,
/*  38 */   SPAWN_ENTITY,
/*  39 */   SPAWN_MOB,
/*  40 */   SPAWN_PAINTING,
/*  41 */   SPAWN_EXPERIENCE_ORB,
/*  42 */   ENTITY_VELOCITY,
/*  43 */   DESTROY_ENTITIES,
/*  44 */   ENTITY_MOVEMENT,
/*  45 */   ENTITY_POSITION,
/*  46 */   ENTITY_ROTATION,
/*  47 */   ENTITY_POSITION_AND_ROTATION,
/*  48 */   ENTITY_TELEPORT,
/*  49 */   ENTITY_HEAD_LOOK,
/*  50 */   ENTITY_STATUS,
/*  51 */   ATTACH_ENTITY,
/*  52 */   ENTITY_METADATA,
/*  53 */   ENTITY_EFFECT,
/*  54 */   REMOVE_ENTITY_EFFECT,
/*  55 */   SET_EXPERIENCE,
/*  56 */   ENTITY_PROPERTIES,
/*  57 */   CHUNK_DATA,
/*  58 */   MULTI_BLOCK_CHANGE,
/*  59 */   BLOCK_CHANGE,
/*  60 */   BLOCK_ACTION,
/*  61 */   BLOCK_BREAK_ANIMATION,
/*  62 */   MAP_BULK_CHUNK,
/*  63 */   EXPLOSION,
/*  64 */   EFFECT,
/*  65 */   NAMED_SOUND,
/*  66 */   SPAWN_PARTICLE,
/*  67 */   GAME_EVENT,
/*  68 */   SPAWN_GLOBAL_ENTITY,
/*  69 */   OPEN_WINDOW,
/*  70 */   CLOSE_WINDOW,
/*  71 */   SET_SLOT,
/*  72 */   WINDOW_ITEMS,
/*  73 */   WINDOW_PROPERTY,
/*  74 */   WINDOW_CONFIRMATION,
/*  75 */   UPDATE_SIGN,
/*  76 */   MAP_DATA,
/*  77 */   BLOCK_ENTITY_DATA,
/*  78 */   OPEN_SIGN_EDITOR,
/*  79 */   STATISTICS,
/*  80 */   PLAYER_INFO,
/*  81 */   PLAYER_ABILITIES,
/*  82 */   TAB_COMPLETE,
/*  83 */   SCOREBOARD_OBJECTIVE,
/*  84 */   UPDATE_SCORE,
/*  85 */   DISPLAY_SCOREBOARD,
/*  86 */   TEAMS,
/*  87 */   PLUGIN_MESSAGE,
/*  88 */   DISCONNECT,
/*  89 */   SERVER_DIFFICULTY,
/*  90 */   COMBAT_EVENT,
/*  91 */   CAMERA,
/*  92 */   WORLD_BORDER,
/*  93 */   TITLE,
/*  94 */   SET_COMPRESSION,
/*  95 */   TAB_LIST,
/*  96 */   RESOURCE_PACK,
/*  97 */   UPDATE_ENTITY_NBT;
/*     */ 
/*     */   
/*     */   public int getId() {
/* 101 */     return ordinal();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 106 */     return name();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\clientbound\ClientboundPackets1_8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */