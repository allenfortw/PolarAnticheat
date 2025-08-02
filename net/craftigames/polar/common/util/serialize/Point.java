/*    */ package net.craftigames.polar.common.util.serialize;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.Objects;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Point
/*    */   implements GsonSerializable
/*    */ {
/*    */   private final Position position;
/*    */   private final Direction direction;
/*    */   
/*    */   private Point(Position position, Direction direction) {
/* 20 */     this.position = position;
/* 21 */     this.direction = direction;
/*    */   }
/*    */   
/*    */   public static Point deserialize(JsonElement element) {
/* 25 */     Position position = Position.deserialize(element);
/* 26 */     Direction direction = Direction.deserialize(element);
/*    */     
/* 28 */     return of(position, direction);
/*    */   }
/*    */   
/*    */   public static Point of(Position position, Direction direction) {
/* 32 */     Objects.requireNonNull(position, "position");
/* 33 */     Objects.requireNonNull(direction, "direction");
/* 34 */     return new Point(position, direction);
/*    */   }
/*    */   
/*    */   public Position getPosition() {
/* 38 */     return this.position;
/*    */   }
/*    */   
/*    */   public Direction getDirection() {
/* 42 */     return this.direction;
/*    */   }
/*    */   
/*    */   public Point add(double x, double y, double z) {
/* 46 */     return this.position.add(x, y, z).withDirection(this.direction);
/*    */   }
/*    */   
/*    */   public Point subtract(double x, double y, double z) {
/* 50 */     return this.position.subtract(x, y, z).withDirection(this.direction);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonObject serialize() {
/* 56 */     return JsonBuilder.object()
/* 57 */       .addAll(this.position.serialize())
/* 58 */       .addAll(this.direction.serialize())
/* 59 */       .build();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object o) {
/* 64 */     if (o == this) return true; 
/* 65 */     if (!(o instanceof Point)) return false; 
/* 66 */     Point other = (Point)o;
/* 67 */     return (getPosition().equals(other.getPosition()) && getDirection().equals(other.getDirection()));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 72 */     int PRIME = 59;
/* 73 */     int result = 1;
/*    */     
/* 75 */     result = result * 59 + getPosition().hashCode();
/* 76 */     result = result * 59 + getDirection().hashCode();
/*    */     
/* 78 */     return result;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 83 */     return "Point(position=" + getPosition() + ", direction=" + getDirection() + ")";
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\Point.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */