/*    */ package net.craftigames.polar.common.messages.collection.server;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.collection.AbstractMemberMessage;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.serialize.Point;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 85)
/*    */ public class MessageMemberTeleportSurvival extends AbstractMemberMessage {
/*    */   private String server;
/*    */   private Point location;
/*    */   private double delay;
/*    */   private String teleportCause;
/*    */   
/*    */   public MessageMemberTeleportSurvival() {}
/*    */   
/*    */   public String getServer() {
/* 22 */     return this.server;
/* 23 */   } public Point getLocation() { return this.location; }
/* 24 */   public double getDelay() { return this.delay; } public String getTeleportCause() {
/* 25 */     return this.teleportCause;
/*    */   }
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, String server, Point location, double delay, String teleportCause) {
/* 28 */     super(uuid, name);
/* 29 */     this.server = server;
/* 30 */     this.location = location;
/* 31 */     this.delay = delay;
/* 32 */     this.teleportCause = teleportCause;
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, String server, Point location, double delay) {
/* 36 */     this(uuid, name, server, location, delay, "PLUGIN");
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, String server, Point location) {
/* 40 */     this(uuid, name, server, location, -1.0D, "PLUGIN");
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, String server, Point location, String teleportCause) {
/* 44 */     this(uuid, name, server, location, -1.0D, teleportCause);
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, Point location, double delay) {
/* 48 */     this(uuid, name, "", location, delay, "PLUGIN");
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, Point location) {
/* 52 */     this(uuid, name, "", location, -1.0D, "PLUGIN");
/*    */   }
/*    */   
/*    */   public MessageMemberTeleportSurvival(UUID uuid, String name, Point location, String teleportCause) {
/* 56 */     this(uuid, name, "", location, -1.0D, teleportCause);
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 61 */     super.send(out);
/*    */     
/* 63 */     out.add("server", this.server);
/* 64 */     out.add("location", (JsonElement)this.location.serialize());
/* 65 */     out.add("delay", Double.valueOf(this.delay));
/* 66 */     out.add("teleportCause", this.teleportCause);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 71 */     super.receive(in);
/*    */     
/* 73 */     this.server = in.get("server").getAsString();
/* 74 */     this.location = Point.deserialize(in.get("location"));
/* 75 */     this.delay = in.get("delay").getAsDouble();
/* 76 */     this.teleportCause = in.get("teleportCause").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 81 */     return MessageType.SERVER;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\server\MessageMemberTeleportSurvival.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */