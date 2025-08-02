/*     */ package net.craftigames.polar.common.core.menu.sub;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*     */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*     */ import net.craftigames.polar.common.configuration.polar.PolarConfig;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Deprecated
/*     */ public class PolarPotionEffectLegacy implements GsonSerializable {
/*     */   private static final String AMPLIFIER = "amplifier";
/*     */   private static final String DURATION = "duration";
/*     */   private static final String TYPE = "effect";
/*     */   private static final String AMBIENT = "ambient";
/*     */   private static final String PARTICLES = "has-particles";
/*     */   
/*     */   public PolarPotionEffectLegacy(@Nonnull PolarPotionEffectType type, int duration, int amplifier, boolean ambient, boolean particles) {
/*  24 */     if (type == null) throw new NullPointerException("type is marked non-null but is null");  this.type = type; this.duration = duration; this.amplifier = amplifier; this.ambient = ambient; this.particles = particles;
/*     */   }
/*     */   @Nonnull
/*     */   private final PolarPotionEffectType type; private final int duration;
/*     */   private final int amplifier;
/*     */   private final boolean ambient;
/*     */   private final boolean particles;
/*     */   
/*     */   @Nonnull
/*     */   public PolarPotionEffectType getType() {
/*  34 */     return this.type;
/*  35 */   } public int getDuration() { return this.duration; }
/*  36 */   public int getAmplifier() { return this.amplifier; }
/*  37 */   public boolean isAmbient() { return this.ambient; } public boolean isParticles() {
/*  38 */     return this.particles;
/*     */   }
/*     */   public PolarPotionEffectLegacy(PolarPotionEffectType type, int duration, int amplifier, boolean ambient) {
/*  41 */     this(type, duration, amplifier, ambient, true);
/*     */   }
/*     */   
/*     */   public PolarPotionEffectLegacy(PolarPotionEffectType type, int duration, int amplifier) {
/*  45 */     this(type, duration, amplifier, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Object> toMap() {
/*  52 */     return (Map<String, Object>)ImmutableMap.of("effect", Integer.valueOf(this.type.getId()), "duration", Integer.valueOf(this.duration), "amplifier", Integer.valueOf(this.amplifier), "ambient", Boolean.valueOf(this.ambient), "has-particles", Boolean.valueOf(this.particles));
/*     */   }
/*     */   
/*     */   public static PolarPotionEffectLegacy deserialize(JsonElement json) {
/*  56 */     if (json instanceof JsonObject) {
/*  57 */       JsonObject object = json.getAsJsonObject();
/*     */       
/*  59 */       PolarPotionEffectType type = PolarPotionEffectType.fromId(object.get("effect").getAsInt());
/*  60 */       if (type == null) {
/*  61 */         return null;
/*     */       }
/*     */       
/*  64 */       int duration = object.get("duration").getAsInt();
/*  65 */       int amplifier = object.get("amplifier").getAsInt();
/*  66 */       boolean ambient = object.get("ambient").getAsBoolean();
/*  67 */       boolean particles = object.get("has-particles").getAsBoolean();
/*     */       
/*  69 */       return new PolarPotionEffectLegacy(type, duration, amplifier, ambient, particles);
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public JsonElement serialize() {
/*  77 */     return (JsonElement)JsonBuilder.object()
/*  78 */       .add("effect", Integer.valueOf(this.type.getId()))
/*  79 */       .add("duration", Integer.valueOf(this.duration))
/*  80 */       .add("amplifier", Integer.valueOf(this.amplifier))
/*  81 */       .add("ambient", Boolean.valueOf(this.ambient))
/*  82 */       .add("has-particles", Boolean.valueOf(this.particles))
/*  83 */       .build();
/*     */   }
/*     */   
/*     */   public void addToConfig(PolarConfig config, String path) {
/*  87 */     FileConfiguration file = config.getConfig();
/*     */     
/*  89 */     addToConfig(file, path);
/*     */   }
/*     */   
/*     */   public void addToConfig(FileConfiguration file, String path) {
/*  93 */     if (!path.isEmpty() && !path.endsWith(".")) {
/*  94 */       path = path + ".";
/*     */     }
/*     */     
/*  97 */     file.set(path + "effect", this.type.name());
/*  98 */     file.set(path + "duration", Integer.valueOf(this.duration));
/*  99 */     file.set(path + "amplifier", Integer.valueOf(this.amplifier));
/* 100 */     file.set(path + "ambient", Boolean.valueOf(this.ambient));
/* 101 */     file.set(path + "has-particles", Boolean.valueOf(this.particles));
/*     */   }
/*     */ 
/*     */   
/*     */   public static PolarPotionEffectLegacy of(ConfigurationSection config) {
/*     */     PolarPotionEffectType type;
/* 107 */     if (config.isInt("effect")) {
/* 108 */       type = PolarPotionEffectType.fromId(config.getInt("effect"));
/*     */     } else {
/* 110 */       type = PolarPotionEffectType.fromName(config.getString("effect"));
/*     */     } 
/*     */     
/* 113 */     int duration = config.getInt("duration");
/* 114 */     int amplifier = config.getInt("amplifier");
/* 115 */     boolean ambient = config.getBoolean("ambient", true);
/* 116 */     boolean particles = config.getBoolean("has-particles", true);
/*     */     
/* 118 */     if (type != null) {
/* 119 */       return new PolarPotionEffectLegacy(type, duration, amplifier, ambient, particles);
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\sub\PolarPotionEffectLegacy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */