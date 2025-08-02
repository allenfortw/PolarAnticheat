/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 70)
/*    */ public class MessageClanChangeTag
/*    */   extends Message
/*    */ {
/*    */   private String tag;
/*    */   private List<Integer> members;
/*    */   
/*    */   public MessageClanChangeTag(String tag, List<Integer> members) {
/* 21 */     this.tag = tag; this.members = members;
/*    */   }
/*    */   
/*    */   public MessageClanChangeTag() {}
/*    */   
/*    */   public String getTag() {
/* 27 */     return this.tag; } public List<Integer> getMembers() {
/* 28 */     return this.members;
/*    */   }
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 32 */     out.add("tag", this.tag);
/*    */     
/* 34 */     JsonArray memberArray = new JsonArray();
/* 35 */     for (Integer member : this.members) {
/* 36 */       memberArray.add(member);
/*    */     }
/* 38 */     out.add("members", (JsonElement)memberArray);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 44 */     this.tag = in.get("tag").getAsString();
/*    */     
/* 46 */     this.members = new ArrayList<>();
/* 47 */     for (JsonElement element : in.get("members").getAsJsonArray()) {
/* 48 */       this.members.add(Integer.valueOf(element.getAsInt()));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 54 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanChangeTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */