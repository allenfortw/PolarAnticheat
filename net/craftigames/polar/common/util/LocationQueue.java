/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import net.craftigames.polar.common.util.serialize.Point;
/*    */ 
/*    */ public class LocationQueue implements GsonSerializable, QueueAction {
/*    */   private String targetServer;
/*    */   private Point point;
/*    */   
/* 13 */   public void setTargetServer(String targetServer) { this.targetServer = targetServer; } public void setPoint(Point point) { this.point = point; }
/*    */   
/*    */   public LocationQueue() {}
/*    */   public String getTargetServer() {
/* 17 */     return this.targetServer;
/*    */   } public Point getPoint() {
/* 19 */     return this.point;
/*    */   }
/*    */   public LocationQueue(Point point) {
/* 22 */     this.point = point;
/*    */   }
/*    */   
/*    */   public static LocationQueue deserialize(JsonElement element) {
/* 26 */     Preconditions.checkArgument(element.isJsonObject());
/* 27 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 29 */     return new LocationQueue(Point.deserialize(object.get("point")));
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement serialize() {
/* 34 */     return (JsonElement)JsonBuilder.object()
/* 35 */       .add("point", (GsonSerializable)this.point)
/* 36 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\LocationQueue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */