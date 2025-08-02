/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMembersUpdatePing
/*    */   extends Message
/*    */ {
/* 23 */   private final Map<String, Long> pings = new HashMap<>(); public Map<String, Long> getPings() { return this.pings; }
/*    */   
/*    */   public MessageMembersUpdatePing(Map<String, Long> pings) {
/* 26 */     this.pings.putAll(pings);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     for (Map.Entry<String, Long> entry : this.pings.entrySet()) {
/* 32 */       out.add(entry.getKey(), entry.getValue());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)in.entrySet())
/* 39 */       this.pings.put(entry.getKey(), Long.valueOf(((JsonElement)entry.getValue()).getAsLong())); 
/*    */   }
/*    */   
/*    */   public MessageMembersUpdatePing() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageMembersUpdatePing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */