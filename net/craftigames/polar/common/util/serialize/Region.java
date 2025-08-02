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
/*     */ public final class Region
/*     */   implements GsonSerializable
/*     */ {
/*     */   private final Position min;
/*     */   private final Position max;
/*     */   private final double width;
/*     */   private final double height;
/*     */   private final double depth;
/*     */   
/*     */   private Region(Position a, Position b) {
/*  23 */     this.min = Position.of(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()), Math.min(a.getZ(), b.getZ()), a.getWorld());
/*  24 */     this.max = Position.of(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()), Math.max(a.getZ(), b.getZ()), a.getWorld());
/*     */     
/*  26 */     this.width = this.max.getX() - this.min.getX();
/*  27 */     this.height = this.max.getY() - this.min.getY();
/*  28 */     this.depth = this.max.getZ() - this.min.getZ();
/*     */   }
/*     */   
/*     */   public static Region deserialize(JsonElement element) {
/*  32 */     Preconditions.checkArgument(element.isJsonObject());
/*  33 */     JsonObject object = element.getAsJsonObject();
/*     */     
/*  35 */     Preconditions.checkArgument(object.has("min"));
/*  36 */     Preconditions.checkArgument(object.has("max"));
/*     */     
/*  38 */     Position a = Position.deserialize(object.get("min"));
/*  39 */     Position b = Position.deserialize(object.get("max"));
/*     */     
/*  41 */     return of(a, b);
/*     */   }
/*     */   
/*     */   public static Region of(Position a, Position b) {
/*  45 */     Objects.requireNonNull(a, "a");
/*  46 */     Objects.requireNonNull(b, "b");
/*     */     
/*  48 */     if (!a.getWorld().equals(b.getWorld())) {
/*  49 */       throw new IllegalArgumentException("positions are in different worlds");
/*     */     }
/*     */     
/*  52 */     return new Region(a, b);
/*     */   }
/*     */   
/*     */   public boolean inRegion(Position pos) {
/*  56 */     Objects.requireNonNull(pos, "pos");
/*  57 */     return (pos.getWorld().equals(this.min.getWorld()) && inRegion(pos.getX(), pos.getY(), pos.getZ()));
/*     */   }
/*     */   
/*     */   public boolean inRegion(double x, double y, double z) {
/*  61 */     return (x >= this.min.getX() && x <= this.max.getX() && y >= this.min
/*  62 */       .getY() && y <= this.max.getY() && z >= this.min
/*  63 */       .getZ() && z <= this.max.getZ());
/*     */   }
/*     */   
/*     */   public Position getMin() {
/*  67 */     return this.min;
/*     */   }
/*     */   
/*     */   public Position getMax() {
/*  71 */     return this.max;
/*     */   }
/*     */   
/*     */   public int getMinX() {
/*  75 */     return (int)getMin().getX();
/*     */   }
/*     */   
/*     */   public int getMinZ() {
/*  79 */     return (int)getMin().getZ();
/*     */   }
/*     */   
/*     */   public int getMinY() {
/*  83 */     return (int)getMin().getY();
/*     */   }
/*     */   
/*     */   public int getMaxX() {
/*  87 */     return (int)getMax().getX();
/*     */   }
/*     */   
/*     */   public int getMaxZ() {
/*  91 */     return (int)getMax().getZ();
/*     */   }
/*     */   
/*     */   public int getMaxY() {
/*  95 */     return (int)getMax().getY();
/*     */   }
/*     */   
/*     */   public double getWidth() {
/*  99 */     return this.width;
/*     */   }
/*     */   
/*     */   public double getHeight() {
/* 103 */     return this.height;
/*     */   }
/*     */   
/*     */   public double getDepth() {
/* 107 */     return this.depth;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonObject serialize() {
/* 113 */     return JsonBuilder.object()
/* 114 */       .add("min", this.min)
/* 115 */       .add("max", this.max)
/* 116 */       .build();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 121 */     if (o == this) return true; 
/* 122 */     if (!(o instanceof Region)) return false; 
/* 123 */     Region other = (Region)o;
/* 124 */     return (getMin().equals(other.getMin()) && getMax().equals(other.getMax()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 129 */     int PRIME = 59;
/* 130 */     int result = 1;
/* 131 */     result = result * 59 + getMin().hashCode();
/* 132 */     result = result * 59 + getMax().hashCode();
/* 133 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 138 */     return "Region(min=" + getMin() + ", max=" + getMax() + ")";
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\Region.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */