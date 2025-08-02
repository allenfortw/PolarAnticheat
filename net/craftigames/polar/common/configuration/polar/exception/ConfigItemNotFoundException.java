/*    */ package net.craftigames.polar.common.configuration.polar.exception;
/*    */ 
/*    */ 
/*    */ public class ConfigItemNotFoundException
/*    */   extends Exception
/*    */ {
/*    */   public ConfigItemNotFoundException() {}
/*    */   
/*    */   public ConfigItemNotFoundException(String item, String type, String path) {
/* 10 */     super("Can not find " + item + " of " + type + ((path != null) ? (" (" + path + ")") : ""));
/*    */   }
/*    */   
/*    */   public ConfigItemNotFoundException(String item, String path) {
/* 14 */     super("Can not find " + item + " " + ((path != null) ? (" (" + path + ")") : ""));
/*    */   }
/*    */   
/*    */   public ConfigItemNotFoundException(String msg) {
/* 18 */     super(msg);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\polar\exception\ConfigItemNotFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */