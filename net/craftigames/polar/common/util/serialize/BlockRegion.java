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
/*     */ public final class BlockRegion
/*     */   implements GsonSerializable
/*     */ {
/*     */   private final BlockPosition min;
/*     */   private final BlockPosition max;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final int depth;
/*     */   
/*     */   private BlockRegion(BlockPosition a, BlockPosition b) {
/*  23 */     this.min = BlockPosition.of(Math.min(a.getX(), b.getX()), Math.min(a.getY(), b.getY()), Math.min(a.getZ(), b.getZ()), a.getWorld());
/*  24 */     this.max = BlockPosition.of(Math.max(a.getX(), b.getX()), Math.max(a.getY(), b.getY()), Math.max(a.getZ(), b.getZ()), a.getWorld());
/*     */     
/*  26 */     this.width = this.max.getX() - this.min.getX();
/*  27 */     this.height = this.max.getY() - this.min.getY();
/*  28 */     this.depth = this.max.getZ() - this.min.getZ();
/*     */   }
/*     */   
/*     */   public static BlockRegion deserialize(JsonElement element) {
/*  32 */     Preconditions.checkArgument(element.isJsonObject());
/*  33 */     JsonObject object = element.getAsJsonObject();
/*     */     
/*  35 */     Preconditions.checkArgument(object.has("min"));
/*  36 */     Preconditions.checkArgument(object.has("max"));
/*     */     
/*  38 */     BlockPosition a = BlockPosition.deserialize(object.get("min"));
/*  39 */     BlockPosition b = BlockPosition.deserialize(object.get("max"));
/*     */     
/*  41 */     return of(a, b);
/*     */   }
/*     */   
/*     */   public static BlockRegion of(BlockPosition a, BlockPosition b) {
/*  45 */     Objects.requireNonNull(a, "a");
/*  46 */     Objects.requireNonNull(b, "b");
/*     */     
/*  48 */     if (!a.getWorld().equals(b.getWorld())) {
/*  49 */       throw new IllegalArgumentException("positions are in different worlds");
/*     */     }
/*     */     
/*  52 */     return new BlockRegion(a, b);
/*     */   }
/*     */   
/*     */   public boolean inRegion(BlockPosition pos) {
/*  56 */     Objects.requireNonNull(pos, "pos");
/*  57 */     return (pos.getWorld().equals(this.min.getWorld()) && inRegion(pos.getX(), pos.getY(), pos.getZ()));
/*     */   }
/*     */   
/*     */   public boolean inRegion(int x, int y, int z) {
/*  61 */     return (x >= this.min.getX() && x <= this.max.getX() && y >= this.min
/*  62 */       .getY() && y <= this.max.getY() && z >= this.min
/*  63 */       .getZ() && z <= this.max.getZ());
/*     */   }
/*     */   
/*     */   public BlockPosition getMin() {
/*  67 */     return this.min;
/*     */   }
/*     */   
/*     */   public BlockPosition getMax() {
/*  71 */     return this.max;
/*     */   }
/*     */   
/*     */   public int getMinX() {
/*  75 */     return getMin().getX();
/*     */   }
/*     */   
/*     */   public int getMinZ() {
/*  79 */     return getMin().getZ();
/*     */   }
/*     */   
/*     */   public int getMinY() {
/*  83 */     return getMin().getY();
/*     */   }
/*     */   
/*     */   public int getMaxX() {
/*  87 */     return getMax().getX();
/*     */   }
/*     */   
/*     */   public int getMaxZ() {
/*  91 */     return getMax().getZ();
/*     */   }
/*     */   
/*     */   public int getMaxY() {
/*  95 */     return getMax().getY();
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*  99 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 103 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getDepth() {
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
/* 122 */     if (!(o instanceof BlockRegion)) return false; 
/* 123 */     BlockRegion other = (BlockRegion)o;
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
/* 138 */     return "BlockRegion(min=" + getMin() + ", max=" + getMax() + ")";
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\BlockRegion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */