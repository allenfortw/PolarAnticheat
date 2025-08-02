/*    */ package net.craftigames.polar.common.command;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import net.craftigames.polar.common.util.ReadWriteListWrapper;
/*    */ 
/*    */ 
/*    */ public class GameCommandHandler
/*    */ {
/*    */   private static GameCommandHandler instance;
/* 12 */   private final ReadWriteListWrapper<PolarCommand> registeredCommands = ReadWriteListWrapper.of(Lists.newArrayList()); public ReadWriteListWrapper<PolarCommand> getRegisteredCommands() { return this.registeredCommands; }
/*    */   
/*    */   public void registerCommands(PolarCommand... commands) {
/* 15 */     registerCommands(null, commands);
/*    */   }
/*    */   
/*    */   public void registerCommands(Runnable callback, PolarCommand... commands) {
/* 19 */     for (PolarCommand command : commands) {
/* 20 */       registerCommand(callback, command);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isCommandRegistered(String command) {
/* 25 */     return (getCommand(command) != null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerCommand(PolarCommand command) {
/* 36 */     registerCommand(null, command);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerCommand(Runnable callback, PolarCommand command) {
/* 48 */     this.registeredCommands.add(command);
/* 49 */     System.out.println("Registering command " + command.getCommand());
/*    */     
/* 51 */     if (callback != null)
/*    */     {
/* 53 */       callback.run();
/*    */     }
/*    */   }
/*    */   
/*    */   public PolarCommand getCommand(String command) {
/* 58 */     if (command == null) {
/* 59 */       return null;
/*    */     }
/* 61 */     for (PolarCommand cmd : this.registeredCommands.get()) {
/*    */       
/* 63 */       if (cmd.getCommand() != null && cmd.getCommand().equalsIgnoreCase(command)) {
/* 64 */         return cmd;
/*    */       }
/*    */ 
/*    */       
/* 68 */       List<String> aliases = cmd.getAliases();
/* 69 */       if (aliases != null) {
/* 70 */         for (String alias : aliases) {
/* 71 */           if (command.equalsIgnoreCase(alias)) {
/* 72 */             return cmd;
/*    */           }
/*    */         } 
/*    */       }
/*    */     } 
/*    */     
/* 78 */     return null;
/*    */   }
/*    */   
/*    */   public void unregisterCommand(PolarCommand polarCommand) {
/* 82 */     Objects.requireNonNull(polarCommand); this.registeredCommands.removeIf(polarCommand::equals);
/*    */   }
/*    */   
/*    */   public static GameCommandHandler getInstance() {
/* 86 */     if (instance == null) {
/* 87 */       synchronized (GameCommandHandler.class) {
/* 88 */         instance = new GameCommandHandler();
/*    */       } 
/*    */     }
/*    */     
/* 92 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\command\GameCommandHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */