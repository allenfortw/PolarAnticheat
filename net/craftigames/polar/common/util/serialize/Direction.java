/*    */ package net.craftigames.polar.common.util.serialize;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Direction
/*    */   implements GsonSerializable
/*    */ {
/* 15 */   public static final Direction ZERO = of(0.0F, 0.0F);
/*    */   private final float yaw;
/*    */   private final float pitch;
/*    */   
/*    */   private Direction(float yaw, float pitch) {
/* 20 */     this.yaw = yaw;
/* 21 */     this.pitch = pitch;
/*    */   }
/*    */   
/*    */   public static Direction deserialize(JsonElement element) {
/* 25 */     Preconditions.checkArgument(element.isJsonObject());
/* 26 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 28 */     Preconditions.checkArgument(object.has("yaw"));
/* 29 */     Preconditions.checkArgument(object.has("pitch"));
/*    */     
/* 31 */     float yaw = object.get("yaw").getAsFloat();
/* 32 */     float pitch = object.get("pitch").getAsFloat();
/*    */     
/* 34 */     return of(yaw, pitch);
/*    */   }
/*    */   
/*    */   public static Direction of(float yaw, float pitch) {
/* 38 */     return new Direction(yaw, pitch);
/*    */   }
/*    */   
/*    */   public float getYaw() {
/* 42 */     return this.yaw;
/*    */   }
/*    */   
/*    */   public float getPitch() {
/* 46 */     return this.pitch;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonObject serialize() {
/* 52 */     return JsonBuilder.object()
/* 53 */       .add("yaw", Float.valueOf(this.yaw))
/* 54 */       .add("pitch", Float.valueOf(this.pitch))
/* 55 */       .build();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 60 */     if (o == this) return true; 
/* 61 */     if (!(o instanceof Direction)) return false; 
/* 62 */     Direction other = (Direction)o;
/* 63 */     return (Float.compare(getYaw(), other.getYaw()) == 0 && 
/* 64 */       Float.compare(getPitch(), other.getPitch()) == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 69 */     int PRIME = 59;
/* 70 */     int result = 1;
/*    */     
/* 72 */     result = result * 59 + Float.floatToIntBits(getYaw());
/* 73 */     result = result * 59 + Float.floatToIntBits(getPitch());
/*    */     
/* 75 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 80 */     return "Direction(yaw=" + getYaw() + ", pitch=" + getPitch() + ")";
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\Direction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */