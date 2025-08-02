/*    */ package gnu.trove;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   public static void main(String[] args) {
/* 47 */     Version$1.init(); System.out.println(getVersion());
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
/*    */ 
/*    */   
/*    */   public static String getVersion() {
/* 61 */     String version = Version.class.getPackage().getImplementationVersion();
/*    */     
/* 63 */     if (version != null) {
/* 64 */       return "trove4j version " + version;
/*    */     }
/*    */     
/* 67 */     return "Sorry no Implementation-Version manifest attribute available";
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */