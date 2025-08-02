/*    */ package net.craftigames.polar.common.util.placeholder;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlaceholderBuilder
/*    */ {
/* 13 */   private final List<ObjectSet<String, String>> placeholders = Lists.newArrayList(); public List<ObjectSet<String, String>> getPlaceholders() { return this.placeholders; }
/*    */   
/*    */   public void add(String key, Number value) {
/* 16 */     add(key, String.valueOf(value));
/*    */   }
/*    */   
/*    */   public void add(String key, String value) {
/* 20 */     this.placeholders.add(new ObjectSet<>(key, value));
/*    */   }
/*    */   
/*    */   public PlaceholderBuilder append(String key, Number value) {
/* 24 */     return append(key, String.valueOf(value));
/*    */   }
/*    */   
/*    */   public PlaceholderBuilder append(String key, String value) {
/* 28 */     this.placeholders.add(new ObjectSet<>(key, value));
/* 29 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 34 */     StringBuilder builder = new StringBuilder("PlaceholderBuilder[");
/* 35 */     for (ObjectSet<String, String> set : this.placeholders) {
/* 36 */       builder.append("{").append(set.getA()).append(" : ").append(set.getB()).append("}");
/*    */     }
/*    */     
/* 39 */     builder.append("]");
/*    */     
/* 41 */     return builder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public PlaceholderBuilder append(PlaceholderBuilder other) {
/* 46 */     for (ObjectSet<String, String> placeholder : other.getPlaceholders()) {
/* 47 */       append(placeholder.getKey(), placeholder.getValue());
/*    */     }
/* 49 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\placeholder\PlaceholderBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */