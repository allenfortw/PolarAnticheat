/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ public class PreJoinResult implements GsonSerializable {
/*    */   private Result result;
/*    */   @Nullable
/*    */   private String username;
/*    */   
/* 16 */   public void setResult(Result result) { this.result = result; } @Nullable private UUID uuid; @Nullable private Component message; public void setUsername(@Nullable String username) { this.username = username; } public void setUuid(@Nullable UUID uuid) { this.uuid = uuid; } public void setMessage(@Nullable Component message) { this.message = message; }
/*    */ 
/*    */   
/* 19 */   public Result getResult() { return this.result; } @Nullable
/* 20 */   public String getUsername() { return this.username; } @Nullable
/* 21 */   public UUID getUuid() { return this.uuid; } @Nullable
/* 22 */   public Component getMessage() { return this.message; }
/*    */   
/*    */   public PreJoinResult(Result result, @Nullable String username, @Nullable UUID uuid, @Nullable Component message) {
/* 25 */     this.result = result;
/* 26 */     this.username = username;
/* 27 */     this.uuid = uuid;
/* 28 */     this.message = message;
/*    */   }
/*    */   
/*    */   public PreJoinResult(Result result, @Nullable String username, @Nullable UUID uuid) {
/* 32 */     this(result, username, uuid, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public PreJoinResult(Result result, @Nullable Component component) {
/* 37 */     this(result, null, null, component);
/*    */   }
/*    */   
/*    */   public PreJoinResult(Result result) {
/* 41 */     this(result, null, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PreJoinResult deserialize(JsonElement element) {
/* 46 */     if (element.isJsonNull()) {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     JsonObject object = element.getAsJsonObject();
/*    */     
/* 52 */     Result result = Result.valueOf(object.get("result").getAsString());
/*    */     
/* 54 */     String username = null;
/* 55 */     if (object.has("username")) {
/* 56 */       username = object.get("username").getAsString();
/*    */     }
/*    */     
/* 59 */     UUID uuid = null;
/* 60 */     if (object.has("uuid")) {
/* 61 */       uuid = UUID.fromString(object.get("uuid").getAsString());
/*    */     }
/*    */     
/* 64 */     Component message = null;
/* 65 */     if (object.has("message")) {
/* 66 */       message = TextUtils.fromGson(object.get("message").getAsString());
/*    */     }
/*    */     
/* 69 */     return new PreJoinResult(result, username, uuid, message);
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 75 */     return (JsonElement)JsonBuilder.object()
/* 76 */       .add("result", this.result.name())
/* 77 */       .consume(out -> {
/*    */           if (this.username != null) {
/*    */             out.add("username", this.username);
/*    */           }
/*    */           
/*    */           if (this.uuid != null) {
/*    */             out.add("uuid", this.uuid);
/*    */           }
/*    */           if (this.message != null) {
/*    */             out.add("message", TextUtils.toGson(this.message));
/*    */           }
/* 88 */         }).build();
/*    */   }
/*    */   
/*    */   public enum Result {
/* 92 */     ALLOWED,
/* 93 */     FORCE_ONLINE,
/* 94 */     FORCE_OFFLINE,
/* 95 */     DISALLOWED;
/*    */ 
/*    */     
/*    */     public boolean isAllowed() {
/* 99 */       return (this != DISALLOWED);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\PreJoinResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */