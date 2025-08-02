/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.xseries.XPolarPotion;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 84)
/*    */ public class MessageMemberPotionEffect extends Message {
/*    */   private UUID playerUuid;
/*    */   private XPolarPotion potion;
/*    */   private int ticks;
/*    */   private int amplifier;
/*    */   private boolean ambient;
/*    */   private boolean particles;
/*    */   private boolean overwrite;
/*    */   
/*    */   public MessageMemberPotionEffect() {}
/*    */   
/* 23 */   public UUID getPlayerUuid() { return this.playerUuid; }
/* 24 */   public XPolarPotion getPotion() { return this.potion; }
/* 25 */   public int getTicks() { return this.ticks; }
/* 26 */   public int getAmplifier() { return this.amplifier; }
/* 27 */   public boolean isAmbient() { return this.ambient; }
/* 28 */   public boolean isParticles() { return this.particles; } public boolean isOverwrite() {
/* 29 */     return this.overwrite;
/*    */   }
/*    */   public MessageMemberPotionEffect(UUID playerUuid, XPolarPotion potion, int ticks, int amplifier, boolean ambient, boolean particles, boolean overwrite) {
/* 32 */     this.playerUuid = playerUuid;
/* 33 */     this.potion = potion;
/* 34 */     this.ticks = ticks;
/* 35 */     this.amplifier = amplifier;
/* 36 */     this.ambient = ambient;
/* 37 */     this.particles = particles;
/* 38 */     this.overwrite = overwrite;
/*    */   }
/*    */   
/*    */   public MessageMemberPotionEffect(UUID playerUuid, XPolarPotion potion, int ticks, int amplifier, boolean ambient, boolean particles) {
/* 42 */     this(playerUuid, potion, ticks, amplifier, ambient, particles, false);
/*    */   }
/*    */   
/*    */   public MessageMemberPotionEffect(UUID playerUuid, XPolarPotion potion, int ticks, int amplifier, boolean ambient) {
/* 46 */     this(playerUuid, potion, ticks, amplifier, ambient, true);
/*    */   }
/*    */   
/*    */   public MessageMemberPotionEffect(UUID playerUuid, XPolarPotion potion, int ticks, int amplifier) {
/* 50 */     this(playerUuid, potion, ticks, amplifier, true);
/*    */   }
/*    */   
/*    */   public MessageMemberPotionEffect(UUID playerUuid, XPolarPotion potion, int ticks) {
/* 54 */     this(playerUuid, potion, ticks, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 59 */     out.add("uuid", this.playerUuid);
/*    */     
/* 61 */     out.add("potion", this.potion.name());
/* 62 */     out.add("ticks", Integer.valueOf(this.ticks));
/* 63 */     out.add("amplifier", Integer.valueOf(this.amplifier));
/* 64 */     out.add("ambient", Boolean.valueOf(this.ambient));
/* 65 */     out.add("particles", Boolean.valueOf(this.particles));
/* 66 */     out.add("overwrite", Boolean.valueOf(this.overwrite));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 71 */     this.playerUuid = UUID.fromString(in.get("uuid").getAsString());
/*    */     
/* 73 */     this.potion = XPolarPotion.valueOf(in.get("potion").getAsString());
/* 74 */     this.ticks = in.get("ticks").getAsInt();
/* 75 */     this.amplifier = in.get("amplifier").getAsInt();
/* 76 */     this.ambient = in.get("ambient").getAsBoolean();
/* 77 */     this.particles = in.get("particles").getAsBoolean();
/* 78 */     this.overwrite = in.get("overwrite").getAsBoolean();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 84 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageMemberPotionEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */