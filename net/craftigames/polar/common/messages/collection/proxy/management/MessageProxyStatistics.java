/*    */ package net.craftigames.polar.common.messages.collection.proxy.management;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.AtomicPair;
/*    */ import net.craftigames.polar.common.util.JsonDataType;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 79)
/*    */ public class MessageProxyStatistics
/*    */   extends Message {
/*    */   private String multicraftId;
/*    */   private List<AtomicPair<String, Object>> playerStatistics;
/*    */   private List<AtomicPair<String, Object>> systemStatistics;
/*    */   
/*    */   public MessageProxyStatistics(String multicraftId, List<AtomicPair<String, Object>> playerStatistics, List<AtomicPair<String, Object>> systemStatistics) {
/* 24 */     this.multicraftId = multicraftId; this.playerStatistics = playerStatistics; this.systemStatistics = systemStatistics;
/*    */   }
/*    */   
/*    */   public MessageProxyStatistics() {}
/*    */   
/*    */   public String getMulticraftId() {
/* 30 */     return this.multicraftId;
/*    */   }
/*    */   
/* 33 */   public List<AtomicPair<String, Object>> getPlayerStatistics() { return this.playerStatistics; } public List<AtomicPair<String, Object>> getSystemStatistics() {
/* 34 */     return this.systemStatistics;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 38 */     out.add("multicraftId", this.multicraftId);
/*    */     
/* 40 */     JsonArray pArray = new JsonArray();
/* 41 */     this.playerStatistics.forEach(p -> {
/*    */           JsonObject object = new JsonObject();
/*    */           object.addProperty("key", (String)p.getKey());
/*    */           JsonDataType type = JsonDataType.getFromObject(p.getValue());
/*    */           object.addProperty("type", type.getStoredName());
/*    */           object.add("value", type.getWrite().apply(p.getValue()));
/*    */           pArray.add((JsonElement)object);
/*    */         });
/* 49 */     out.add("playerStatistics", (JsonElement)pArray);
/*    */     
/* 51 */     JsonArray sArray = new JsonArray();
/* 52 */     this.systemStatistics.forEach(p -> {
/*    */           JsonObject object = new JsonObject();
/*    */           object.addProperty("key", (String)p.getKey());
/*    */           JsonDataType type = JsonDataType.getFromObject(p.getValue());
/*    */           if (type == null) {
/*    */             throw new IllegalArgumentException("No json data type found for class \"" + p.getValue().getClass().getName() + "\"");
/*    */           }
/*    */           object.addProperty("type", type.getStoredName());
/*    */           object.add("value", type.getWrite().apply(p.getValue()));
/*    */           sArray.add((JsonElement)object);
/*    */         });
/* 63 */     out.add("systemStatistics", (JsonElement)sArray);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 68 */     this.multicraftId = in.get("multicraftId").getAsString();
/*    */     
/* 70 */     this.playerStatistics = new ArrayList<>();
/* 71 */     for (JsonElement statistics : in.getAsJsonArray("playerStatistics")) {
/* 72 */       if (!statistics.isJsonObject()) {
/*    */         continue;
/*    */       }
/* 75 */       JsonObject object = statistics.getAsJsonObject();
/* 76 */       JsonDataType type = JsonDataType.getFromType(object.get("type").getAsString());
/* 77 */       if (type == null) {
/* 78 */         throw new IllegalArgumentException("No json data type found for object \"" + object + "\"");
/*    */       }
/* 80 */       this.playerStatistics.add(new AtomicPair(object.get("key").getAsString(), type.getRead().apply(object.get("value"))));
/*    */     } 
/*    */     
/* 83 */     this.systemStatistics = new ArrayList<>();
/* 84 */     for (JsonElement statistics : in.getAsJsonArray("systemStatistics")) {
/* 85 */       if (!statistics.isJsonObject()) {
/*    */         continue;
/*    */       }
/* 88 */       JsonObject object = statistics.getAsJsonObject();
/* 89 */       JsonDataType type = JsonDataType.getFromType(object.get("type").getAsString());
/* 90 */       if (type == null) {
/* 91 */         throw new IllegalArgumentException("No json data type found for object \"" + object + "\"");
/*    */       }
/* 93 */       this.systemStatistics.add(new AtomicPair(object.get("key").getAsString(), type.getRead().apply(object.get("value"))));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 99 */     return MessageType.PROXY;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\management\MessageProxyStatistics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */