/*    */ package net.craftigames.polar.common.messages.collection.system;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.models.ClientSettings;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ @MessageIdentifier
/*    */ public class MessageMemberClientSettings extends AbstractMemberMessage {
/*    */   private ClientSettings settings;
/*    */   
/*    */   public void setSettings(ClientSettings settings) {
/* 15 */     this.settings = settings;
/*    */   }
/*    */   public MessageMemberClientSettings() {}
/*    */   public ClientSettings getSettings() {
/* 19 */     return this.settings;
/*    */   }
/*    */   public MessageMemberClientSettings(UUID uuid, String name, ClientSettings settings) {
/* 22 */     super(uuid, name);
/* 23 */     this.settings = settings;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 28 */     super.send(out);
/* 29 */     out.add("settings", (GsonSerializable)this.settings);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 34 */     super.receive(in);
/* 35 */     setSettings(ClientSettings.deserialize(in.get("settings")));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\system\MessageMemberClientSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */