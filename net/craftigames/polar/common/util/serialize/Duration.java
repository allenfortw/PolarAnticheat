/*    */ package net.craftigames.polar.common.util.serialize;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ public class Duration
/*    */   implements GsonSerializable {
/*    */   @NotNull
/*    */   private final java.time.Duration duration;
/*    */   
/*    */   @NotNull
/*    */   public java.time.Duration getDuration() {
/* 18 */     return this.duration;
/*    */   }
/*    */   public Duration(@Nonnull java.time.Duration duration) {
/* 21 */     this.duration = duration;
/*    */   }
/*    */   
/*    */   public Duration(long seconds, int nanos) {
/* 25 */     this.duration = java.time.Duration.ofSeconds(seconds, nanos);
/*    */   }
/*    */   
/*    */   public static Duration deserialize(JsonElement element) {
/* 29 */     Preconditions.checkArgument(element.isJsonObject());
/* 30 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 32 */     Preconditions.checkArgument(object.has("s"));
/* 33 */     Preconditions.checkArgument(object.has("n"));
/*    */     
/* 35 */     long s = object.get("s").getAsLong();
/* 36 */     int n = object.get("n").getAsInt();
/*    */     
/* 38 */     return of(s, n);
/*    */   }
/*    */   
/*    */   public static Duration of(java.time.Duration duration) {
/* 42 */     return new Duration(duration);
/*    */   }
/*    */   
/*    */   public static Duration of(long seconds, int nanos) {
/* 46 */     return new Duration(seconds, nanos);
/*    */   }
/*    */   
/*    */   public static Duration ofSeconds(long seconds) {
/* 50 */     return of(seconds, 0);
/*    */   }
/*    */   
/*    */   public static Duration ofMillis(int millis) {
/* 54 */     return of(java.time.Duration.ofMillis(millis));
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 60 */     return (JsonElement)JsonBuilder.object()
/* 61 */       .add("s", Long.valueOf(this.duration.getSeconds()))
/* 62 */       .add("n", Integer.valueOf(this.duration.getNano()))
/* 63 */       .build();
/*    */   }
/*    */   
/*    */   public java.time.Duration toDuration() {
/* 67 */     return this.duration;
/*    */   }
/*    */   
/*    */   public long toMillis() {
/* 71 */     return this.duration.toMillis();
/*    */   }
/*    */   
/*    */   public long getSeconds() {
/* 75 */     return this.duration.getSeconds();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\serialize\Duration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */