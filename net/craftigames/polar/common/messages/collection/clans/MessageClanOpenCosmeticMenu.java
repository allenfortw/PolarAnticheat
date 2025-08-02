/*    */ package net.craftigames.polar.common.messages.collection.clans;
/*    */ 
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.xseries.XPolarMaterial;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 69)
/*    */ public class MessageClanOpenCosmeticMenu
/*    */   extends Message
/*    */ {
/*    */   private String user;
/*    */   private XPolarMaterial glass;
/*    */   private byte glassPane;
/*    */   
/*    */   public MessageClanOpenCosmeticMenu() {}
/*    */   
/*    */   public String getUser() {
/* 21 */     return this.user;
/* 22 */   } public XPolarMaterial getGlass() { return this.glass; } public byte getGlassPane() {
/* 23 */     return this.glassPane;
/*    */   }
/*    */   public MessageClanOpenCosmeticMenu(String user, XPolarMaterial glass) {
/* 26 */     this.user = user;
/* 27 */     this.glass = glass;
/* 28 */     this.glassPane = glass.getData();
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 33 */     out.add("user", this.user);
/* 34 */     out.add("glass", this.glass.name());
/* 35 */     out.add("glassPane", Byte.valueOf(this.glassPane));
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 40 */     this.user = in.get("user").getAsString();
/* 41 */     if (in.has("glass")) {
/* 42 */       this.glass = XPolarMaterial.fromName(in.get("glass").getAsString());
/*    */     }
/* 44 */     this.glassPane = in.get("glassPane").getAsByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 49 */     return MessageType.CLANS;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\clans\MessageClanOpenCosmeticMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */