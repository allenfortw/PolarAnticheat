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
/*     */ public final class BlockPosition
/*     */   implements GsonSerializable
/*     */ {
/*     */   private final int x;
/*     */   private final int y;
/*     */   private final int z;
/*     */   private final String world;
/*     */   
/*     */   private BlockPosition(int x, int y, int z, String world) {
/*  22 */     this.x = x;
/*  23 */     this.y = y;
/*  24 */     this.z = z;
/*  25 */     this.world = world;
/*     */   }
/*     */   
/*     */   public static BlockPosition deserialize(JsonElement element) {
/*  29 */     Preconditions.checkArgument(element.isJsonObject());
/*  30 */     JsonObject object = element.getAsJsonObject();
/*     */     
/*  32 */     Preconditions.checkArgument(object.has("x"));
/*  33 */     Preconditions.checkArgument(object.has("y"));
/*  34 */     Preconditions.checkArgument(object.has("z"));
/*  35 */     Preconditions.checkArgument(object.has("world"));
/*     */     
/*  37 */     int x = object.get("x").getAsInt();
/*  38 */     int y = object.get("y").getAsInt();
/*  39 */     int z = object.get("z").getAsInt();
/*  40 */     String world = object.get("world").getAsString();
/*     */     
/*  42 */     return of(x, y, z, world);
/*     */   }
/*     */   
/*     */   public static BlockPosition of(int x, int y, int z, String world) {
/*  46 */     Objects.requireNonNull(world, "world");
/*  47 */     return new BlockPosition(x, y, z, world);
/*     */   }
/*     */   
/*     */   public int getX() {
/*  51 */     return this.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/*  55 */     return this.y;
/*     */   }
/*     */   
/*     */   public int getZ() {
/*  59 */     return this.z;
/*     */   }
/*     */   
/*     */   public String getWorld() {
/*  63 */     return this.world;
/*     */   }
/*     */   
/*     */   public Position toPosition() {
/*  67 */     return Position.of(this.x, this.y, this.z, this.world);
/*     */   }
/*     */   
/*     */   public Position toPositionCenter() {
/*  71 */     return Position.of(this.x + 0.5D, this.y + 0.5D, this.z + 0.5D, this.world);
/*     */   }
/*     */   
/*     */   public boolean contains(Position position) {
/*  75 */     return equals(position.floor());
/*     */   }
/*     */   
/*     */   public BlockRegion regionWith(BlockPosition other) {
/*  79 */     Objects.requireNonNull(other, "other");
/*  80 */     return BlockRegion.of(this, other);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonObject serialize() {
/*  86 */     return JsonBuilder.object()
/*  87 */       .add("x", Integer.valueOf(this.x))
/*  88 */       .add("y", Integer.valueOf(this.y))
/*  89 */       .add("z", Integer.valueOf(this.z))
/*  90 */       .add("world", this.world)
/*  91 */       .build();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/*  96 */     if (o == this) return true; 
/*  97 */     if (!(o instanceof BlockPosition)) return false; 
/*  98 */     BlockPosition other = (BlockPosition)o;
/*  99 */     return (getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ() && getWorld().equals(other.getWorld()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 104 */     int PRIME = 59;
/* 105 */     int result = 1;
/* 106 */     result = result * 59 + getX();
/* 107 */     result = result * 59 + getY();
/* 108 */     result = result * 59 + getZ();
/* 109 */     result = result * 59 + getWorld().hashCode();
/* 110 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 115 */     return "BlockPosition(x=" + getX() + ", y=" + getY() + ", z=" + getZ() + ", world=" + getWorld() + ")";
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\BlockPosition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */