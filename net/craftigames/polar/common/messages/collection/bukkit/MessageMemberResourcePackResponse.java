/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ResourcePackInfo;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMemberResourcePackResponse extends AbstractMemberMessage {
/*    */   private ResourcePackInfo.Status status;
/*    */   
/* 15 */   public void setStatus(ResourcePackInfo.Status status) { this.status = status; } private ResourcePackInfo resourcePackInfo; public MessageMemberResourcePackResponse() {} public void setResourcePackInfo(ResourcePackInfo resourcePackInfo) { this.resourcePackInfo = resourcePackInfo; }
/*    */ 
/*    */   
/*    */   public ResourcePackInfo.Status getStatus() {
/* 19 */     return this.status; } public ResourcePackInfo getResourcePackInfo() {
/* 20 */     return this.resourcePackInfo;
/*    */   }
/*    */   public MessageMemberResourcePackResponse(UUID uuid, String name, ResourcePackInfo.Status status, ResourcePackInfo resourcePackInfo) {
/* 23 */     super(uuid, name);
/* 24 */     this.status = status;
/* 25 */     this.resourcePackInfo = resourcePackInfo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 30 */     super.send(out);
/* 31 */     out.add("status", this.status.getName());
/* 32 */     out.add("resourcePackInfo", (GsonSerializable)this.resourcePackInfo);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 37 */     super.receive(in);
/* 38 */     setStatus(ResourcePackInfo.Status.get(in.get("status").getAsString()));
/* 39 */     setResourcePackInfo(ResourcePackInfo.deserialize(in.get("resourcePackInfo")));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageMemberResourcePackResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */