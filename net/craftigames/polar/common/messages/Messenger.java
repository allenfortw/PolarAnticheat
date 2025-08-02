/*    */ package net.craftigames.polar.common.messages;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.ConnectionType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.ExpiringSet;
/*    */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import redis.clients.jedis.JedisPool;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Messenger
/*    */   extends AutoCloseable
/*    */ {
/*    */   ExpiringSet<UUID> getAlreadyProcessed();
/*    */   
/*    */   void sendMessage(Message paramMessage);
/*    */   
/*    */   void sendMessage(Message paramMessage, String paramString);
/*    */   
/*    */   void sendRawJsonMessage(String paramString1, String paramString2);
/*    */   
/*    */   void connect(String paramString1, String paramString2, ConnectionType paramConnectionType, String... paramVarArgs);
/*    */   
/*    */   @Nullable
/*    */   SubscriptionHandler getSubscriptionHandler();
/*    */   
/*    */   @Nullable
/*    */   JedisPool getJedisPool();
/*    */   
/*    */   default void close() {}
/*    */   
/*    */   default String asEncodedString(Message message) {
/* 41 */     MessageOutputStream out = new MessageOutputStream(JsonBuilder.object());
/* 42 */     message.send(out);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 56 */     JsonObject json = JsonBuilder.object().add("id", Integer.valueOf(message.getLegacyId())).add("new-id", message.getId()).add("content", (JsonElement)out.build()).add("from", message.getFrom()).consume(b -> { if (message instanceof UniqueMessage) { UUID value = UUID.randomUUID(); getAlreadyProcessed().add(value); b.add("unique", value); }  }).build();
/*    */     
/* 58 */     return GsonProvider.toString((JsonElement)json);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\Messenger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */