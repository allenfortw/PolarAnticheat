/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.core.sound.PolarSound;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.xseries.XPolarSound;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 63)
/*    */ public class MessagePlaySound
/*    */   extends Message
/*    */ {
/*    */   private UUID playerUuid;
/*    */   private String sound;
/*    */   private float volume;
/*    */   private float pitch;
/*    */   
/*    */   public MessagePlaySound() {}
/*    */   
/*    */   public UUID getPlayerUuid() {
/* 24 */     return this.playerUuid;
/* 25 */   } public String getSound() { return this.sound; }
/* 26 */   public float getVolume() { return this.volume; } public float getPitch() {
/* 27 */     return this.pitch;
/*    */   }
/*    */   public MessagePlaySound(UUID playerUuid, String sound, float volume, float pitch) {
/* 30 */     this.playerUuid = playerUuid;
/* 31 */     this.sound = sound;
/* 32 */     this.volume = volume;
/* 33 */     this.pitch = pitch;
/*    */   }
/*    */   
/*    */   public MessagePlaySound(UUID playerUuid, XPolarSound sound, float volume, float pitch) {
/* 37 */     this.playerUuid = playerUuid;
/* 38 */     this.sound = sound.name();
/* 39 */     this.volume = volume;
/* 40 */     this.pitch = pitch;
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public MessagePlaySound(UUID playerUuid, PolarSound sound, float volume, float pitch) {
/* 45 */     this.playerUuid = playerUuid;
/* 46 */     this.sound = sound.getSound();
/* 47 */     this.volume = volume;
/* 48 */     this.pitch = pitch;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 53 */     out.add("uuid", this.playerUuid);
/* 54 */     out.add("sound", this.sound);
/* 55 */     out.add("volume", Float.valueOf(this.volume));
/* 56 */     out.add("pitch", Float.valueOf(this.pitch));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 61 */     this.playerUuid = UUID.fromString(in.get("uuid").getAsString());
/* 62 */     this.sound = in.get("sound").getAsString();
/* 63 */     this.volume = in.get("volume").getAsFloat();
/* 64 */     this.pitch = in.get("pitch").getAsFloat();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 70 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessagePlaySound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */