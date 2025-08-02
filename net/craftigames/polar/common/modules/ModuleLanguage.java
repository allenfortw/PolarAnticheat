/*    */ package net.craftigames.polar.common.modules;
/*    */ 
/*    */ public interface ModuleLanguage
/*    */ {
/*    */   String getMessage();
/*    */   
/*    */   String getMessage(String... parameters) {
/*  8 */     String message = getMessage();
/*  9 */     for (int i = 0; i < parameters.length; i++) {
/* 10 */       message = message.replace("{" + i + "}", parameters[i]);
/*    */     }
/*    */     
/* 13 */     return message;
/*    */   }
/*    */   
/*    */   String getRawMessage();
/*    */   
/*    */   void setMessage(String paramString);
/*    */   
/*    */   String formatPath();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\modules\ModuleLanguage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */