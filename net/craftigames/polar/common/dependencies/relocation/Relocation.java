/*    */ package net.craftigames.polar.common.dependencies.relocation;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ 
/*    */ public final class Relocation
/*    */ {
/*  8 */   public static String RELOCATION_PREFIX = "net.craftigames.polar.lib.";
/*    */   private final String pattern;
/*    */   private final String relocatedPattern;
/*    */   
/*    */   private Relocation(String pattern, String relocatedPattern) {
/* 13 */     this.pattern = pattern;
/* 14 */     this.relocatedPattern = relocatedPattern;
/*    */   }
/*    */   
/*    */   public static Relocation of(String id, String pattern) {
/* 18 */     return new Relocation(pattern.replace("{}", "."), RELOCATION_PREFIX + id);
/*    */   }
/*    */   
/*    */   public static List<Relocation> allOf(Relocation... relocations) {
/* 22 */     return Arrays.asList(relocations);
/*    */   }
/*    */   
/*    */   public String getPattern() {
/* 26 */     return this.pattern;
/*    */   }
/*    */   
/*    */   public String getRelocatedPattern() {
/* 30 */     return this.relocatedPattern;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\dependencies\relocation\Relocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */