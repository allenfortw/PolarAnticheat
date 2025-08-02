/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 87)
/*    */ public class MessageBukkitPerformCommand extends Message {
/*    */   private String identifier;
/*    */   private String sender;
/*    */   private String command;
/*    */   
/*    */   public MessageBukkitPerformCommand() {}
/*    */   
/* 19 */   public String getIdentifier() { return this.identifier; }
/* 20 */   public String getSender() { return this.sender; } public String getCommand() {
/* 21 */     return this.command;
/*    */   }
/*    */   public MessageBukkitPerformCommand(@NotNull String identifier, String sender, String command) {
/* 24 */     this.identifier = Objects.<String>requireNonNull(identifier);
/* 25 */     this.sender = sender;
/* 26 */     this.command = command;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 31 */     out.add("identifier", this.identifier);
/* 32 */     out.add("sender", this.sender);
/* 33 */     out.add("command", this.command);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 38 */     this.identifier = in.get("identifier").getAsString();
/* 39 */     this.sender = in.get("sender").getAsString();
/* 40 */     this.command = in.get("command").getAsString();
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 45 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageBukkitPerformCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */