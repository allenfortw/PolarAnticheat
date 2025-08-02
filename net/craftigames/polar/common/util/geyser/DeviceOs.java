/*    */ package net.craftigames.polar.common.util.geyser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum DeviceOs
/*    */ {
/* 11 */   UNKNOWN("Unknown"),
/* 12 */   GOOGLE("Android"),
/* 13 */   IOS("iOS"),
/* 14 */   OSX("macOS"),
/* 15 */   AMAZON("Amazon"),
/* 16 */   GEARVR("Gear VR"),
/* 17 */   HOLOLENS("Hololens"),
/* 18 */   UWP("Windows 10"),
/* 19 */   WIN32("Windows x86"),
/* 20 */   DEDICATED("Dedicated"),
/* 21 */   TVOS("Apple TV"),
/* 22 */   PS4("PS4"),
/* 23 */   NX("Switch"),
/* 24 */   XBOX("Xbox One"),
/* 25 */   WINDOWS_PHONE("Windows Phone"),
/* 26 */   JAVA("Java");
/*    */   
/*    */   static {
/* 29 */     VALUES = values();
/*    */   }
/*    */   
/*    */   DeviceOs(String displayName) {
/*    */     this.displayName = displayName;
/*    */   }
/*    */   
/*    */   private static final DeviceOs[] VALUES;
/*    */   private final String displayName;
/*    */   
/*    */   public static DeviceOs fromId(int id) {
/* 40 */     return (id < VALUES.length) ? VALUES[id] : VALUES[0];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 48 */     return this.displayName;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\geyser\DeviceOs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */