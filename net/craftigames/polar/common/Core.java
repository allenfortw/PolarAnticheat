/*    */ package net.craftigames.polar.common;
/*    */ 
/*    */ import net.craftigames.polar.common.modules.ModuleManager;
/*    */ 
/*    */ public class Core
/*    */ {
/*    */   public static boolean DEBUG = false;
/*    */   public static boolean USE_UUIDS_FOR_USER_ID = false;
/*    */   private static PolarCore polarCore;
/*    */   
/*    */   public static PolarCore getPolarCore() {
/* 12 */     return polarCore; } public static void setPolarCore(PolarCore polarCore) { Core.polarCore = polarCore; }
/* 13 */    private static ModuleManager moduleManager; private static Reportable reportable = new Reportable() {  }; public static Reportable getReportable() { return reportable; } public static void setReportable(Reportable reportable) { Core.reportable = reportable; }
/* 14 */   public static ModuleManager getModuleManager() { return moduleManager; } public static void setModuleManager(ModuleManager moduleManager) { Core.moduleManager = moduleManager; }
/*    */ 
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\Core.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */