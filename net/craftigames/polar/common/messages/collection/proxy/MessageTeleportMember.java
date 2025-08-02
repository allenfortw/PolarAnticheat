/*    */ package net.craftigames.polar.common.messages.collection.proxy;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ import net.craftigames.polar.common.util.serialize.Point;
/*    */ 
/*    */ @Deprecated
/*    */ @MessageIdentifier(legacyId = 92)
/*    */ public class MessageTeleportMember
/*    */   extends AbstractMemberMessage
/*    */ {
/*    */   private String server;
/*    */   private Point location;
/*    */   private boolean proxyEnabled;
/*    */   
/*    */   public MessageTeleportMember() {}
/*    */   
/*    */   public String getServer() {
/* 24 */     return this.server;
/* 25 */   } public Point getLocation() { return this.location; } public boolean isProxyEnabled() {
/* 26 */     return this.proxyEnabled;
/*    */   }
/*    */   public MessageTeleportMember(UUID uuid, String name, String server, Point location, boolean proxyEnabled) {
/* 29 */     super(uuid, name);
/* 30 */     this.server = server;
/* 31 */     this.location = location;
/* 32 */     this.proxyEnabled = proxyEnabled;
/*    */   }
/*    */   
/*    */   public MessageTeleportMember(UUID uuid, String name, String server, Point location) {
/* 36 */     this(uuid, name, server, location, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 41 */     super.send(out);
/*    */     
/* 43 */     out.add("server", this.server);
/* 44 */     out.add("location", (GsonSerializable)this.location);
/* 45 */     out.add("proxyEnabled", Boolean.valueOf(this.proxyEnabled));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 50 */     super.receive(in);
/*    */     
/* 52 */     this.server = in.get("server").getAsString();
/* 53 */     this.location = Point.deserialize(in.get("location"));
/* 54 */     this.proxyEnabled = in.get("proxyEnabled").getAsBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 59 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\proxy\MessageTeleportMember.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */