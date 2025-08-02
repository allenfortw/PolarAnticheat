/*    */ package net.craftigames.polar.common.modules;
/*    */ 
/*    */ import net.craftigames.polar.common.command.CommandType;
/*    */ import net.craftigames.polar.common.command.PolarCommand;
/*    */ 
/*    */ public class ModuleCommand
/*    */   extends PolarCommand {
/*    */   private final Module module;
/*    */   
/*    */   public ModuleCommand(String command, Module module) {
/* 11 */     super(CommandType.PROXY, command, null, new String[0]);
/*    */     
/* 13 */     this.module = module;
/*    */   }
/*    */   
/*    */   public void registerReloadCommand() {}
/*    */   
/*    */   public void registerDebugCommand() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\ModuleCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */