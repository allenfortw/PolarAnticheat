/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ResourcePackInfo;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMemberSetResourcePack extends AbstractMemberMessage {
/*    */   private ResourcePackInfo resourcePackInfo;
/*    */   
/*    */   public void setResourcePackInfo(ResourcePackInfo resourcePackInfo) {
/* 15 */     this.resourcePackInfo = resourcePackInfo;
/*    */   }
/*    */   public MessageMemberSetResourcePack() {}
/*    */   public ResourcePackInfo getResourcePackInfo() {
/* 19 */     return this.resourcePackInfo;
/*    */   }
/*    */   public MessageMemberSetResourcePack(UUID uuid, String name, ResourcePackInfo resourcePackInfo) {
/* 22 */     super(uuid, name);
/* 23 */     this.resourcePackInfo = resourcePackInfo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/* 29 */     out.add("resourcePackInfo", (GsonSerializable)this.resourcePackInfo);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     super.receive(in);
/* 35 */     setResourcePackInfo(ResourcePackInfo.deserialize(in.get("resourcePackInfo")));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageMemberSetResourcePack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */