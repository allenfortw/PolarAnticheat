/*     */ package net.craftigames.polar.common.util.serialize;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Position
/*     */   implements GsonSerializable
/*     */ {
/*     */   private final double x;
/*     */   private final double y;
/*     */   private final double z;
/*     */   private final String world;
/*     */   
/*     */   private Position(double x, double y, double z, String world) {
/*  22 */     this.x = x;
/*  23 */     this.y = y;
/*  24 */     this.z = z;
/*  25 */     this.world = world;
/*     */   }
/*     */   
/*     */   public static Position deserialize(JsonElement element) {
/*  29 */     Preconditions.checkArgument(element.isJsonObject());
/*  30 */     JsonObject object = element.getAsJsonObject();
/*     */     
/*  32 */     Preconditions.checkArgument(object.has("x"));
/*  33 */     Preconditions.checkArgument(object.has("y"));
/*  34 */     Preconditions.checkArgument(object.has("z"));
/*  35 */     Preconditions.checkArgument(object.has("world"));
/*     */     
/*  37 */     double x = object.get("x").getAsDouble();
/*  38 */     double y = object.get("y").getAsDouble();
/*  39 */     double z = object.get("z").getAsDouble();
/*  40 */     String world = object.get("world").getAsString();
/*     */     
/*  42 */     return of(x, y, z, world);
/*     */   }
/*     */   
/*     */   public static Position of(double x, double y, double z, String world) {
/*  46 */     Objects.requireNonNull(world, "world");
/*  47 */     return new Position(x, y, z, world);
/*     */   }
/*     */   
/*     */   private static int bukkitFloor(double num) {
/*  51 */     int floor = (int)num;
/*  52 */     return (floor == num) ? floor : (floor - (int)(Double.doubleToRawLongBits(num) >>> 63L));
/*     */   }
/*     */   
/*     */   public double getX() {
/*  56 */     return this.x;
/*     */   }
/*     */   
/*     */   public double getY() {
/*  60 */     return this.y;
/*     */   }
/*     */   
/*     */   public double getZ() {
/*  64 */     return this.z;
/*     */   }
/*     */   
/*     */   public String getWorld() {
/*  68 */     return this.world;
/*     */   }
/*     */   
/*     */   public BlockPosition floor() {
/*  72 */     return BlockPosition.of(bukkitFloor(this.x), bukkitFloor(this.y), bukkitFloor(this.z), this.world);
/*     */   }
/*     */   
/*     */   public Position add(double x, double y, double z) {
/*  76 */     return of(this.x + x, this.y + y, this.z + z, this.world);
/*     */   }
/*     */   
/*     */   public Position subtract(double x, double y, double z) {
/*  80 */     return add(-x, -y, -z);
/*     */   }
/*     */   
/*     */   public Region regionWith(Position other) {
/*  84 */     Objects.requireNonNull(other, "other");
/*  85 */     return Region.of(this, other);
/*     */   }
/*     */   
/*     */   public Point withDirection(Direction direction) {
/*  89 */     return Point.of(this, direction);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonObject serialize() {
/*  95 */     return JsonBuilder.object()
/*  96 */       .add("x", Double.valueOf(this.x))
/*  97 */       .add("y", Double.valueOf(this.y))
/*  98 */       .add("z", Double.valueOf(this.z))
/*  99 */       .add("world", this.world)
/* 100 */       .build();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 105 */     if (o == this) return true; 
/* 106 */     if (!(o instanceof Position)) return false; 
/* 107 */     Position other = (Position)o;
/* 108 */     return (Double.compare(getX(), other.getX()) == 0 && 
/* 109 */       Double.compare(getY(), other.getY()) == 0 && 
/* 110 */       Double.compare(getZ(), other.getZ()) == 0 && 
/* 111 */       getWorld().equals(other.getWorld()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     int PRIME = 59;
/* 117 */     int result = 1;
/*     */     
/* 119 */     long x = Double.doubleToLongBits(getX());
/* 120 */     long y = Double.doubleToLongBits(getY());
/* 121 */     long z = Double.doubleToLongBits(getZ());
/*     */     
/* 123 */     result = result * 59 + (int)(x >>> 32L ^ x);
/* 124 */     result = result * 59 + (int)(y >>> 32L ^ y);
/* 125 */     result = result * 59 + (int)(z >>> 32L ^ z);
/* 126 */     result = result * 59 + getWorld().hashCode();
/* 127 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return "Position(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", world=" + getWorld() + ")";
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\Position.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */