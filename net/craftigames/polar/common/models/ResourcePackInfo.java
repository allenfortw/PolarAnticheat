/*     */ package net.craftigames.polar.common.models;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.UUID;
/*     */ import net.craftigames.polar.common.core.CoreUtils;
/*     */ import net.craftigames.polar.common.core.Nameable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
/*     */ 
/*     */ public class ResourcePackInfo implements GsonSerializable {
/*     */   private UUID requestId;
/*     */   private String url;
/*     */   private boolean shouldForce;
/*     */   private String hash;
/*     */   private Component prompt;
/*     */   private Origin origin;
/*     */   
/*  20 */   public void setRequestId(UUID requestId) { this.requestId = requestId; } public void setUrl(String url) { this.url = url; } public void setShouldForce(boolean shouldForce) { this.shouldForce = shouldForce; } public void setHash(String hash) { this.hash = hash; } public void setPrompt(Component prompt) { this.prompt = prompt; } public void setOrigin(Origin origin) { this.origin = origin; }
/*     */    public ResourcePackInfo() {} public ResourcePackInfo(UUID requestId, String url, boolean shouldForce, String hash, Component prompt, Origin origin) {
/*  22 */     this.requestId = requestId; this.url = url; this.shouldForce = shouldForce; this.hash = hash; this.prompt = prompt; this.origin = origin;
/*     */   }
/*     */   
/*  25 */   public UUID getRequestId() { return this.requestId; }
/*  26 */   public String getUrl() { return this.url; }
/*  27 */   public boolean isShouldForce() { return this.shouldForce; }
/*  28 */   public String getHash() { return this.hash; }
/*  29 */   public Component getPrompt() { return this.prompt; } public Origin getOrigin() {
/*  30 */     return this.origin;
/*     */   }
/*     */   public static ResourcePackInfo deserialize(JsonElement element) {
/*  33 */     if (element.isJsonNull()) {
/*  34 */       return null;
/*     */     }
/*     */     
/*  37 */     JsonObject object = element.getAsJsonObject();
/*  38 */     ResourcePackInfo result = new ResourcePackInfo();
/*  39 */     result.setRequestId(UUID.fromString(object.get("requestId").getAsString()));
/*  40 */     result.setUrl(object.get("url").getAsString());
/*  41 */     result.setShouldForce(object.get("shouldForce").getAsBoolean());
/*  42 */     result.setOrigin(Origin.get(object.get("origin").getAsString()));
/*     */     
/*  44 */     if (object.has("prompt")) {
/*  45 */       result.setPrompt(GsonComponentSerializer.gson().deserialize(object.get("prompt").getAsString()));
/*     */     }
/*  47 */     if (object.has("hash")) {
/*  48 */       result.setHash(object.get("hash").getAsString());
/*     */     }
/*     */     
/*  51 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonElement serialize() {
/*  57 */     return (JsonElement)JsonBuilder.object()
/*  58 */       .add("requestId", this.requestId)
/*  59 */       .add("url", this.url)
/*  60 */       .add("shouldForce", Boolean.valueOf(this.shouldForce))
/*  61 */       .add("origin", this.origin.getName())
/*  62 */       .consume(b -> {
/*     */           if (this.hash != null) {
/*     */             b.add("hash", this.hash);
/*     */           }
/*     */           
/*     */           if (this.prompt != null) {
/*     */             b.add("prompt", (String)GsonComponentSerializer.gson().serialize(this.prompt));
/*     */           }
/*  70 */         }).build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Origin
/*     */     implements Nameable
/*     */   {
/*  80 */     DOWNSTREAM_SERVER,
/*     */ 
/*     */ 
/*     */     
/*  84 */     PLUGIN_ON_PROXY;
/*     */     
/*  86 */     public static final Origin[] CACHE = values(); static {
/*     */     
/*     */     }
/*     */     public String getName() {
/*  90 */       return name();
/*     */     }
/*     */     
/*     */     public static Origin get(String name) {
/*  94 */       return (Origin)CoreUtils.getNameable(name, (Nameable[])CACHE);
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Status
/*     */     implements Nameable {
/* 100 */     SUCCESSFUL,
/* 101 */     DECLINED,
/* 102 */     FAILED_DOWNLOAD,
/* 103 */     ACCEPTED,
/* 104 */     UNKNOWN;
/*     */ 
/*     */     
/* 107 */     public static final Status[] CACHE = values(); static {
/*     */     
/*     */     }
/*     */     public String getName() {
/* 111 */       return name();
/*     */     }
/*     */     
/*     */     public static Status get(String name) {
/* 115 */       return (Status)CoreUtils.getNameable(name, (Nameable[])CACHE);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ResourcePackInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */