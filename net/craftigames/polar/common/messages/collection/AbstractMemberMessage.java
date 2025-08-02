/*    */ package net.craftigames.polar.common.messages.collection;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ 
/*    */ public abstract class AbstractMemberMessage extends Message {
/*    */   private UUID uuid;
/*    */   private String name;
/*    */   
/* 12 */   public void setUuid(UUID uuid) { this.uuid = uuid; } public void setName(String name) { this.name = name; }
/*    */ 
/*    */   
/*    */   public AbstractMemberMessage() {}
/* 16 */   public UUID getUuid() { return this.uuid; } public String getName() {
/* 17 */     return this.name;
/*    */   }
/*    */   public AbstractMemberMessage(UUID uuid, String name) {
/* 20 */     this.uuid = uuid;
/* 21 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 26 */     out.add("uuid", this.uuid);
/* 27 */     out.add("name", this.name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 32 */     setUuid(UUID.fromString(in.get("uuid").getAsString()));
/* 33 */     setName(in.get("name").getAsString());
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\AbstractMemberMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */