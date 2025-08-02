/*     */ package net.craftigames.polar.common.util;
/*     */ import net.craftigames.polar.common.util.protocol.packets.ClientboundPackets;
/*     */ import net.craftigames.polar.common.util.protocol.packets.clientbound.ClientboundPackets1_12;
/*     */ import net.craftigames.polar.common.util.protocol.packets.clientbound.ClientboundPackets1_8;
/*     */ import net.craftigames.polar.common.util.protocol.packets.clientbound.ClientboundPackets1_9;
/*     */ import net.craftigames.polar.common.util.protocol.packets.clientbound.ClientboundPackets1_9_3;
/*     */ import net.craftigames.polar.common.util.protocol.packets.serverbound.ServerboundPackets1_12;
/*     */ import net.craftigames.polar.common.util.protocol.packets.serverbound.ServerboundPackets1_14;
/*     */ import net.craftigames.polar.common.util.protocol.packets.serverbound.ServerboundPackets1_9;
/*     */ import net.craftigames.polar.common.util.protocol.packets.serverbound.ServerboundPackets1_9_3;
/*     */ 
/*     */ public enum VersionProtocol {
/*  13 */   UNKNOWN("Unknown", 0, (Class)ClientboundPackets1_8.class, (Class)ServerboundPackets1_8.class),
/*  14 */   PROTOCOL_4("1.7.1 - 1.7.5", 4, null, null),
/*  15 */   PROTOCOL_5("1.7.6 - 1.7.10", 5, null, null),
/*  16 */   PROTOCOL_44("1.8-pre1", 44, (Class)ClientboundPackets1_8.class, (Class)ServerboundPackets1_8.class),
/*  17 */   PROTOCOL_45("1.8-pre2", 45, (Class)ClientboundPackets1_8.class, (Class)ServerboundPackets1_8.class),
/*  18 */   PROTOCOL_46("1.8-pre3", 46, (Class)ClientboundPackets1_8.class, (Class)ServerboundPackets1_8.class),
/*  19 */   PROTOCOL_47("1.8.x", 47, (Class)ClientboundPackets1_8.class, (Class)ServerboundPackets1_8.class),
/*  20 */   PROTOCOL_103("1.9-pre1", 103, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  21 */   PROTOCOL_104("1.9-pre2", 104, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  22 */   PROTOCOL_105("1.9-pre3", 105, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  23 */   PROTOCOL_106("1.9-pre4", 106, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  24 */   PROTOCOL_107("1.9", 107, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  25 */   PROTOCOL_108("1.9.1", 108, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  26 */   PROTOCOL_109("1.9.2", 109, (Class)ClientboundPackets1_9.class, (Class)ServerboundPackets1_9.class),
/*  27 */   PROTOCOL_110("1.9.3 / 4", 110, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  28 */   PROTOCOL_204("1.10-pre1", 204, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  29 */   PROTOCOL_205("1.10-pre2", 205, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  30 */   PROTOCOL_210("1.10.x", 210, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  31 */   PROTOCOL_314("1.11-pre1", 314, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  32 */   PROTOCOL_315("1.11", 315, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  33 */   PROTOCOL_316("1.11.1 / 2", 316, (Class)ClientboundPackets1_9_3.class, (Class)ServerboundPackets1_9_3.class),
/*  34 */   PROTOCOL_328("1.12-pre1", 328, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  35 */   PROTOCOL_329("1.12-pre2", 329, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  36 */   PROTOCOL_330("1.12-pre3", 330, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  37 */   PROTOCOL_331("1.12-pre4", 331, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  38 */   PROTOCOL_332("1.12-pre5", 332, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  39 */   PROTOCOL_333("1.12-pre6", 333, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  40 */   PROTOCOL_334("1.12-pre7", 334, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  41 */   PROTOCOL_335("1.12", 335, (Class)ClientboundPackets1_12.class, (Class)ServerboundPackets1_12.class),
/*  42 */   PROTOCOL_337("1.12.1-pre", 337, (Class)ClientboundPackets1_12_1.class, (Class)ServerboundPackets1_12_1.class),
/*  43 */   PROTOCOL_338("1.12.1", 338, (Class)ClientboundPackets1_12_1.class, (Class)ServerboundPackets1_12_1.class),
/*  44 */   PROTOCOL_339("1.12.2-pre 1 / 2", 339, (Class)ClientboundPackets1_12_1.class, (Class)ServerboundPackets1_12_1.class),
/*  45 */   PROTOCOL_340("1.12.2", 340, (Class)ClientboundPackets1_12_1.class, (Class)ServerboundPackets1_12_1.class),
/*  46 */   PROTOCOL_393("1.13", 393, (Class)ClientboundPackets1_13.class, (Class)ServerboundPackets1_13.class),
/*  47 */   PROTOCOL_401("1.13.1", 401, (Class)ClientboundPackets1_13.class, (Class)ServerboundPackets1_13.class),
/*  48 */   PROTOCOL_404("1.13.2", 404, (Class)ClientboundPackets1_13.class, (Class)ServerboundPackets1_13.class),
/*  49 */   PROTOCOL_477("1.14", 477, (Class)ClientboundPackets1_14.class, (Class)ServerboundPackets1_14.class),
/*  50 */   PROTOCOL_480("1.14.1", 480, (Class)ClientboundPackets1_14.class, (Class)ServerboundPackets1_14.class),
/*  51 */   PROTOCOL_485("1.14.2", 485, (Class)ClientboundPackets1_14.class, (Class)ServerboundPackets1_14.class),
/*  52 */   PROTOCOL_490("1.14.3", 490, (Class)ClientboundPackets1_14.class, (Class)ServerboundPackets1_14.class),
/*  53 */   PROTOCOL_498("1.14.4", 498, (Class)ClientboundPackets1_14.class, (Class)ServerboundPackets1_14.class),
/*  54 */   PROTOCOL_573("1.15", 573, (Class)ClientboundPackets1_15.class, (Class)ServerboundPackets1_14.class),
/*  55 */   PROTOCOL_575("1.15.1", 575, (Class)ClientboundPackets1_15.class, (Class)ServerboundPackets1_14.class),
/*  56 */   PROTOCOL_578("1.15.2", 578, (Class)ClientboundPackets1_15.class, (Class)ServerboundPackets1_14.class),
/*  57 */   PROTOCOL_735("1.16", 735, (Class)ClientboundPackets1_16.class, (Class)ServerboundPackets1_16.class),
/*  58 */   PROTOCOL_736("1.16.1", 736, (Class)ClientboundPackets1_16.class, (Class)ServerboundPackets1_16.class),
/*  59 */   PROTOCOL_751("1.16.2", 751, (Class)ClientboundPackets1_16_2.class, (Class)ServerboundPackets1_16_2.class),
/*  60 */   PROTOCOL_753("1.16.3", 753, (Class)ClientboundPackets1_16_2.class, (Class)ServerboundPackets1_16_2.class),
/*  61 */   PROTOCOL_754("1.16.5", 754, (Class)ClientboundPackets1_16_2.class, (Class)ServerboundPackets1_16_2.class),
/*  62 */   PROTOCOL_755("1.17", 755, (Class)ClientboundPackets1_17.class, (Class)ServerboundPackets1_17.class),
/*  63 */   PROTOCOL_756("1.17.1", 756, (Class)ClientboundPackets1_17_1.class, (Class)ServerboundPackets1_17.class),
/*  64 */   PROTOCOL_757("1.18.1", 757, (Class)ClientboundPackets1_18.class, (Class)ServerboundPackets1_17.class),
/*  65 */   PROTOCOL_758("1.18.2", 758, (Class)ClientboundPackets1_18.class, (Class)ServerboundPackets1_17.class),
/*  66 */   PROTOCOL_759("1.19", 759, (Class)ClientboundPackets1_19.class, (Class)ServerboundPackets1_19.class),
/*  67 */   PROTOCOL_760("1.19.1/2", 760, (Class)ClientboundPackets1_19_1.class, (Class)ServerboundPackets1_19_1.class),
/*  68 */   PROTOCOL_761("1.19.3", 761, (Class)ClientboundPackets1_19_3.class, (Class)ServerboundPackets1_19_3.class);
/*     */   private final String name; private final int protocol; private final Class<? extends ClientboundPackets> clientboundPackets; private final Class<? extends ServerboundPackets> serverboundPackets; public static VersionProtocol[] CACHE;
/*     */   
/*  71 */   public String getName() { return this.name; }
/*  72 */   public int getProtocol() { return this.protocol; }
/*  73 */   public Class<? extends ClientboundPackets> getClientboundPackets() { return this.clientboundPackets; } public Class<? extends ServerboundPackets> getServerboundPackets() {
/*  74 */     return this.serverboundPackets;
/*     */   }
/*     */   VersionProtocol(String name, int protocol, Class<? extends ClientboundPackets> clientboundPackets, Class<? extends ServerboundPackets> serverboundPackets) {
/*  77 */     this.name = name;
/*  78 */     this.protocol = protocol;
/*  79 */     this.clientboundPackets = clientboundPackets;
/*  80 */     this.serverboundPackets = serverboundPackets;
/*     */   }
/*     */   static {
/*  83 */     CACHE = values();
/*     */   }
/*     */   public static VersionProtocol getByProtocol(int protocol) {
/*  86 */     for (VersionProtocol version : CACHE) {
/*  87 */       if (version.getProtocol() == protocol) {
/*  88 */         return version;
/*     */       }
/*     */     } 
/*     */     
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getPacketOut(int id) {
/*  97 */     if (this.clientboundPackets != null && this.clientboundPackets.isEnum()) {
/*  98 */       ClientboundPackets[] packets = this.clientboundPackets.getEnumConstants();
/*  99 */       if (id >= 0 && id < packets.length) {
/* 100 */         return ((ClientboundPackets[])this.clientboundPackets.getEnumConstants())[id].getName();
/*     */       }
/*     */     } 
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getPacketIn(int id) {
/* 108 */     if (this.serverboundPackets != null && this.serverboundPackets.isEnum()) {
/* 109 */       ClientboundPackets[] packets = this.clientboundPackets.getEnumConstants();
/* 110 */       if (id >= 0 && id < packets.length) {
/* 111 */         return ((ClientboundPackets[])this.clientboundPackets.getEnumConstants())[id].getName();
/*     */       }
/*     */     } 
/* 114 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\VersionProtocol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */