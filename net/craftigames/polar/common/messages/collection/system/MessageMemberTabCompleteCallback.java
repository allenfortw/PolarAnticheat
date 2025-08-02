/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.RequestMessage;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractTimeoutMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 51)
/*    */ public class MessageMemberTabCompleteCallback extends AbstractTimeoutMessage implements RequestMessage {
/*    */   private UUID playerUuid;
/*    */   private String cursor;
/*    */   
/* 20 */   public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; } private List<String> suggestions; private UUID identifier; private String serverIdentifier; public void setCursor(String cursor) { this.cursor = cursor; } public void setSuggestions(List<String> suggestions) { this.suggestions = suggestions; } public void setIdentifier(UUID identifier) { this.identifier = identifier; } public void setServerIdentifier(String serverIdentifier) { this.serverIdentifier = serverIdentifier; }
/*    */ 
/*    */   
/*    */   public MessageMemberTabCompleteCallback() {}
/*    */   
/* 25 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 26 */   public String getCursor() { return this.cursor; } public List<String> getSuggestions() {
/* 27 */     return this.suggestions;
/*    */   }
/* 29 */   public UUID getIdentifier() { return this.identifier; } public String getServerIdentifier() {
/* 30 */     return this.serverIdentifier;
/*    */   }
/*    */   public MessageMemberTabCompleteCallback(UUID playerUuid, String cursor, List<String> suggestions) {
/* 33 */     this.playerUuid = playerUuid;
/* 34 */     this.cursor = cursor;
/* 35 */     this.suggestions = suggestions;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 40 */     super.send(out);
/* 41 */     out.add("uuid", this.playerUuid);
/* 42 */     out.add("cursor", this.cursor);
/* 43 */     if (this.suggestions != null) {
/* 44 */       if (this.suggestions.isEmpty()) {
/* 45 */         out.add("suggestions", (JsonElement)JsonBuilder.nullValue());
/*    */       } else {
/* 47 */         out.add("suggestions", (JsonElement)JsonBuilder.array().addStrings(this.suggestions).build());
/*    */       } 
/*    */     }
/* 50 */     out.add("identifier", this.identifier);
/* 51 */     out.add("serverIdentifier", this.serverIdentifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 56 */     super.receive(in);
/* 57 */     setPlayerUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 58 */     setCursor(in.get("cursor").getAsString());
/*    */     
/* 60 */     if (in.has("suggestions")) {
/* 61 */       List<String> suggestions = new ArrayList<>();
/* 62 */       JsonElement suggestionsElement = in.get("suggestions");
/* 63 */       if (suggestionsElement instanceof com.google.gson.JsonArray) {
/* 64 */         for (JsonElement arrayElement : suggestionsElement.getAsJsonArray()) {
/* 65 */           suggestions.add(arrayElement.getAsString());
/*    */         }
/*    */       }
/* 68 */       setSuggestions(suggestions);
/*    */     } 
/*    */     
/* 71 */     setIdentifier(in.getAsUUID("identifier"));
/* 72 */     setServerIdentifier(in.get("serverIdentifier").getAsString());
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 77 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberTabCompleteCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */