/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberTimeoutMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 1)
/*    */ public class MessageMemberJoin extends AbstractMemberTimeoutMessage {
/*    */   private JsonElement data;
/*    */   
/*    */   public void setData(JsonElement data) {
/* 17 */     this.data = data; } @Nullable private UUID connectionId; public MessageMemberJoin() {} public void setConnectionId(@Nullable UUID connectionId) { this.connectionId = connectionId; }
/*    */ 
/*    */   
/*    */   public JsonElement getData()
/*    */   {
/* 22 */     return this.data; } @Nullable
/* 23 */   public UUID getConnectionId() { return this.connectionId; }
/*    */   
/*    */   public MessageMemberJoin(UUID uuid, String name, JsonElement data, @Nullable UUID connectionId) {
/* 26 */     super(uuid, name);
/* 27 */     this.data = data;
/* 28 */     this.connectionId = connectionId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     super.send(out);
/* 34 */     out.add("data", this.data);
/* 35 */     if (this.connectionId != null) {
/* 36 */       out.add("con", this.connectionId);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 42 */     super.receive(in);
/* 43 */     setData(in.get("data"));
/* 44 */     if (in.has("con")) {
/* 45 */       setConnectionId(UUID.fromString(in.get("con").getAsString()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 51 */     return MessageType.SYSTEM;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberJoin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */