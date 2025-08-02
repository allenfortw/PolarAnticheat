/*    */ package net.craftigames.polar.common.messages;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonPrimitive;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import java.util.function.Function;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*    */ 
/*    */ 
/*    */ public class MessageConsumer
/*    */ {
/* 17 */   public static final Map<String, Function<String, Message>> CONSUMERS = new HashMap<>();
/*    */   
/*    */   @Deprecated
/* 20 */   public static final Map<String, Function<Integer, Message>> CONSUMERS_LEGACY = new HashMap<>();
/*    */   
/*    */   static {
/* 23 */     CONSUMERS.put("polar", MessagingRegister::createInstance);
/* 24 */     CONSUMERS_LEGACY.put("polar", MessagingRegister::createInstanceLegacy);
/*    */   }
/*    */   public static Message consumeIncomingMessageAsString(String encodedString, Messenger messenger) {
/*    */     JsonPrimitive jsonPrimitive;
/* 28 */     Objects.requireNonNull(encodedString, "encodedString");
/* 29 */     JsonObject decodedObject = ((JsonObject)GsonProvider.standard().fromJson(encodedString, JsonObject.class)).getAsJsonObject();
/*    */ 
/*    */     
/* 32 */     JsonElement idElement = decodedObject.get("new-id");
/* 33 */     boolean legacy = false;
/* 34 */     if (idElement == null) {
/* 35 */       idElement = decodedObject.get("id");
/* 36 */       legacy = true;
/*    */     } 
/*    */     
/* 39 */     if (idElement == null) {
/* 40 */       throw new IllegalStateException("Incoming message has no id argument: " + encodedString);
/*    */     }
/*    */     
/* 43 */     JsonElement typeElement = decodedObject.get("from");
/* 44 */     if (typeElement == null) {
/* 45 */       jsonPrimitive = new JsonPrimitive("polar");
/*    */     }
/*    */ 
/*    */     
/* 49 */     JsonElement contentElement = decodedObject.get("content");
/* 50 */     if (contentElement == null) {
/* 51 */       throw new IllegalStateException("Incoming message has no content argument: " + encodedString);
/*    */     }
/*    */ 
/*    */     
/* 55 */     if (decodedObject.has("unique")) {
/* 56 */       JsonElement unique = decodedObject.get("unique");
/* 57 */       UUID uuid = UUID.fromString(unique.getAsString());
/*    */       
/* 59 */       if (messenger.getAlreadyProcessed().contains(uuid)) {
/* 60 */         return null;
/*    */       }
/*    */     } 
/*    */     
/* 64 */     MessageInputStream inputStream = new MessageInputStream(contentElement.getAsJsonObject());
/*    */ 
/*    */ 
/*    */     
/* 68 */     String type = jsonPrimitive.getAsString();
/*    */ 
/*    */     
/* 71 */     Message m = !legacy ? ((Function<String, Message>)CONSUMERS.getOrDefault(type, MessagingRegister::createInstance)).apply(idElement.getAsString()) : ((Function<Integer, Message>)CONSUMERS_LEGACY.getOrDefault(type, MessagingRegister::createInstanceLegacy)).apply(Integer.valueOf(idElement.getAsInt()));
/* 72 */     m.receive(inputStream);
/*    */     
/* 74 */     return m;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\MessageConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */