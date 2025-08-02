/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.core.CoreUtils;
/*    */ import net.craftigames.polar.common.core.Identifiable;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ServerConnectReason
/*    */   implements GsonSerializable, Identifiable
/*    */ {
/*    */   ServerConnectReason(int id) {
/*    */     this.id = id;
/*    */   }
/*    */   
/*    */   private final int id;
/*    */   public static final ServerConnectReason[] CACHE;
/* 22 */   LOBBY_FALLBACK(1),
/*    */ 
/*    */ 
/*    */   
/* 26 */   COMMAND(2),
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 31 */   SERVER_DOWN_REDIRECT(3),
/*    */ 
/*    */ 
/*    */   
/* 35 */   KICK_REDIRECT(4),
/*    */ 
/*    */ 
/*    */   
/* 39 */   PLUGIN_MESSAGE(5),
/*    */ 
/*    */ 
/*    */   
/* 43 */   JOIN_PROXY(6),
/*    */ 
/*    */ 
/*    */   
/* 47 */   PLUGIN(7),
/*    */ 
/*    */ 
/*    */   
/* 51 */   UNKNOWN(8);
/*    */   public int getId() {
/* 53 */     return this.id;
/*    */   } static {
/* 55 */     CACHE = values();
/*    */   }
/*    */   
/*    */   public static ServerConnectReason byName(String name) {
/* 59 */     for (ServerConnectReason reason : CACHE) {
/* 60 */       if (reason.name().equals(name)) {
/* 61 */         return reason;
/*    */       }
/*    */     } 
/* 64 */     return UNKNOWN;
/*    */   }
/*    */   
/*    */   public static ServerConnectReason deserialize(JsonElement element) {
/* 68 */     if (element instanceof com.google.gson.JsonPrimitive) {
/* 69 */       int asInt = element.getAsInt();
/* 70 */       return (ServerConnectReason)CoreUtils.getIdentifiable(asInt, (Identifiable[])CACHE);
/*    */     } 
/* 72 */     return UNKNOWN;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 78 */     return JsonBuilder.primitive(Integer.valueOf(this.id));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\ServerConnectReason.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */