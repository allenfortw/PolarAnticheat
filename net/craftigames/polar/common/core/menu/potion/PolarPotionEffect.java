/*    */ package net.craftigames.polar.common.core.menu.potion;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*    */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*    */ import net.craftigames.polar.common.util.xseries.XPolarPotion;
/*    */ 
/*    */ public class PolarPotionEffect implements GsonSerializable {
/*    */   private XPolarPotion type;
/*    */   private final int duration;
/*    */   
/* 12 */   public void setType(XPolarPotion type) { this.type = type; } private final int amplifier; private final boolean ambient; private final boolean particles; public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof PolarPotionEffect)) return false;  PolarPotionEffect other = (PolarPotionEffect)o; if (!other.canEqual(this)) return false;  if (getDuration() != other.getDuration()) return false;  if (getAmplifier() != other.getAmplifier()) return false;  if (isAmbient() != other.isAmbient()) return false;  if (isParticles() != other.isParticles()) return false;  Object this$type = getType(), other$type = other.getType(); return !((this$type == null) ? (other$type != null) : !this$type.equals(other$type)); } protected boolean canEqual(Object other) { return other instanceof PolarPotionEffect; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getDuration(); result = result * 59 + getAmplifier(); result = result * 59 + (isAmbient() ? 79 : 97); result = result * 59 + (isParticles() ? 79 : 97); Object $type = getType(); return result * 59 + (($type == null) ? 43 : $type.hashCode()); } public String toString() { return "PolarPotionEffect(type=" + getType() + ", duration=" + getDuration() + ", amplifier=" + getAmplifier() + ", ambient=" + isAmbient() + ", particles=" + isParticles() + ")"; }
/*    */ 
/*    */   
/* 15 */   public XPolarPotion getType() { return this.type; }
/* 16 */   public int getDuration() { return this.duration; }
/* 17 */   public int getAmplifier() { return this.amplifier; }
/* 18 */   public boolean isAmbient() { return this.ambient; } public boolean isParticles() {
/* 19 */     return this.particles;
/*    */   }
/*    */   public PolarPotionEffect(XPolarPotion type, int duration, int amplifier, boolean ambient, boolean particles) {
/* 22 */     this.type = type;
/* 23 */     this.duration = duration;
/* 24 */     this.amplifier = amplifier;
/* 25 */     this.ambient = ambient;
/* 26 */     this.particles = particles;
/*    */   }
/*    */   
/*    */   public PolarPotionEffect(XPolarPotion type, int duration, int amplifier, boolean ambient) {
/* 30 */     this(type, duration, amplifier, ambient, true);
/*    */   }
/*    */   
/*    */   public PolarPotionEffect(XPolarPotion type, int duration, int amplifier) {
/* 34 */     this(type, duration, amplifier, true, true);
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public JsonElement serialize() {
/* 40 */     JsonObject object = new JsonObject();
/* 41 */     object.addProperty("effect", this.type.name());
/* 42 */     object.addProperty("duration", Integer.valueOf(this.duration));
/* 43 */     object.addProperty("amplifier", Integer.valueOf(this.amplifier));
/* 44 */     object.addProperty("ambient", Boolean.valueOf(this.ambient));
/* 45 */     object.addProperty("has-particles", Boolean.valueOf(this.particles));
/* 46 */     return (JsonElement)object;
/*    */   }
/*    */   
/*    */   public static PolarPotionEffect deserialize(JsonElement json) {
/* 50 */     if (json instanceof JsonObject) {
/* 51 */       JsonObject object = json.getAsJsonObject();
/*    */       
/* 53 */       XPolarPotion type = XPolarPotion.fromName(object.get("effect").getAsString());
/* 54 */       if (type == null) {
/* 55 */         return null;
/*    */       }
/* 57 */       int duration = object.get("duration").getAsInt();
/* 58 */       int amplifier = object.get("amplifier").getAsInt();
/* 59 */       boolean ambient = object.get("ambient").getAsBoolean();
/* 60 */       boolean particles = object.get("has-particles").getAsBoolean();
/*    */       
/* 62 */       return new PolarPotionEffect(type, duration, amplifier, ambient, particles);
/*    */     } 
/* 64 */     return null;
/*    */   }
/*    */   
/*    */   public void addToConfig(FileConfiguration file, String path) {
/* 68 */     if (!path.isEmpty() && !path.endsWith(".")) {
/* 69 */       path = path + ".";
/*    */     }
/*    */     
/* 72 */     file.set(path + "effect", this.type.name());
/* 73 */     file.set(path + "duration", Integer.valueOf(this.duration));
/* 74 */     file.set(path + "amplifier", Integer.valueOf(this.amplifier));
/* 75 */     file.set(path + "ambient", Boolean.valueOf(this.ambient));
/* 76 */     file.set(path + "has-particles", Boolean.valueOf(this.particles));
/*    */   }
/*    */   
/*    */   public static PolarPotionEffect of(ConfigurationSection config) {
/* 80 */     XPolarPotion type = XPolarPotion.fromName(config.getString("effect"));
/* 81 */     if (type == null) {
/* 82 */       return null;
/*    */     }
/*    */     
/* 85 */     int duration = config.getInt("duration", 600);
/* 86 */     int amplifier = config.getInt("amplifier", 0);
/* 87 */     boolean ambient = config.getBoolean("ambient", true);
/* 88 */     boolean particles = config.getBoolean("has-particles", true);
/*    */     
/* 90 */     return new PolarPotionEffect(type, duration, amplifier, ambient, particles);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\potion\PolarPotionEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */