/*    */ package net.craftigames.polar.common.util.gson.datatree;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import java.util.Map;
/*    */ import java.util.stream.Stream;
/*    */ import javax.annotation.Nonnull;
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
/*    */ public interface DataTree
/*    */ {
/*    */   @Nonnull
/*    */   static GsonDataTree from(@Nonnull JsonElement element) {
/* 48 */     return new GsonDataTree(element);
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   DataTree resolve(@Nonnull Object... paramVarArgs);
/*    */   
/*    */   @Nonnull
/*    */   Stream<? extends Map.Entry<String, ? extends DataTree>> asObject();
/*    */   
/*    */   @Nonnull
/*    */   Stream<? extends DataTree> asArray();
/*    */   
/*    */   @Nonnull
/*    */   Stream<? extends Map.Entry<Integer, ? extends DataTree>> asIndexedArray();
/*    */   
/*    */   @Nonnull
/*    */   String asString();
/*    */   
/*    */   @Nonnull
/*    */   Number asNumber();
/*    */   
/*    */   int asInt();
/*    */   
/*    */   double asDouble();
/*    */   
/*    */   boolean asBoolean();
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\datatree\DataTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */