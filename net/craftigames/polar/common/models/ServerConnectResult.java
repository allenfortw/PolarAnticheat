/*     */ package net.craftigames.polar.common.models;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.core.CoreUtils;
/*     */ import net.craftigames.polar.common.core.Identifiable;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ 
/*     */ public class ServerConnectResult
/*     */   implements GsonSerializable {
/*     */   private String targetServer;
/*     */   private boolean cancelled;
/*     */   
/*     */   public void setTargetServer(String targetServer) {
/*  17 */     this.targetServer = targetServer; } public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
/*     */    public ServerConnectResult() {} public ServerConnectResult(String targetServer, boolean cancelled) {
/*  19 */     this.targetServer = targetServer; this.cancelled = cancelled;
/*     */   }
/*     */   
/*  22 */   public String getTargetServer() { return this.targetServer; } public boolean isCancelled() {
/*  23 */     return this.cancelled;
/*     */   }
/*     */   public static ServerConnectResult deserialize(JsonElement element) {
/*  26 */     if (element.isJsonNull()) {
/*  27 */       return null;
/*     */     }
/*     */     
/*  30 */     JsonObject object = element.getAsJsonObject();
/*  31 */     ServerConnectResult result = new ServerConnectResult();
/*  32 */     JsonElement serverElement = object.get("server");
/*  33 */     if (serverElement instanceof com.google.gson.JsonPrimitive) {
/*  34 */       result.setTargetServer(serverElement.getAsString());
/*     */     }
/*  36 */     result.setCancelled(object.get("cancelled").getAsBoolean());
/*     */     
/*  38 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonElement serialize() {
/*  44 */     return (JsonElement)JsonBuilder.object()
/*  45 */       .add("server", this.targetServer)
/*  46 */       .add("cancelled", Boolean.valueOf(this.cancelled))
/*  47 */       .build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Result
/*     */     implements GsonSerializable, Identifiable
/*     */   {
/*  60 */     EVENT_CANCEL(1),
/*     */ 
/*     */ 
/*     */     
/*  64 */     ALREADY_CONNECTED(2),
/*     */ 
/*     */ 
/*     */     
/*  68 */     ALREADY_CONNECTING(3),
/*     */ 
/*     */ 
/*     */     
/*  72 */     SUCCESS(4),
/*     */ 
/*     */ 
/*     */     
/*  76 */     FAIL(5),
/*     */ 
/*     */ 
/*     */     
/*  80 */     EVENT_CANCEL_PROXY(6),
/*     */ 
/*     */ 
/*     */     
/*  84 */     TIMEOUT(7),
/*     */ 
/*     */ 
/*     */     
/*  88 */     TARGET_NOT_FOUND(8);
/*     */ 
/*     */     
/*     */     Result(int id) {
/*     */       this.id = id;
/*     */     }
/*     */ 
/*     */     
/*     */     private final int id;
/*  97 */     public static final Result[] CACHE = values();
/*     */     public int getId() {
/*     */       return this.id;
/* 100 */     } public static Result byName(String name) { for (Result reason : CACHE) {
/* 101 */         if (reason.name().equals(name)) {
/* 102 */           return reason;
/*     */         }
/*     */       } 
/* 105 */       return null; }
/*     */     public boolean isSuccess() { return (this == SUCCESS); } static {
/*     */     
/*     */     } public static Result deserialize(JsonElement element) {
/* 109 */       if (element instanceof com.google.gson.JsonPrimitive) {
/* 110 */         int asInt = element.getAsInt();
/* 111 */         return (Result)CoreUtils.getIdentifiable(asInt, (Identifiable[])CACHE);
/*     */       } 
/* 113 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     @Nonnull
/*     */     public JsonElement serialize() {
/* 119 */       return JsonBuilder.primitive(Integer.valueOf(this.id));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ServerConnectResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */