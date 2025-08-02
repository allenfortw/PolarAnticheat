/*    */ package net.craftigames.polar.common.util.gson.typeadapters;
/*    */ import com.google.gson.JsonDeserializationContext;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonParseException;
/*    */ import com.google.gson.JsonSerializationContext;
/*    */ import java.lang.reflect.Type;
/*    */ import net.craftigames.polar.common.util.gson.datatree.DataTree;
/*    */ 
/*    */ public final class JsonElementTreeSerializer implements JsonSerializer<DataTree>, JsonDeserializer<DataTree> {
/* 10 */   public static final JsonElementTreeSerializer INSTANCE = new JsonElementTreeSerializer();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataTree deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
/* 18 */     return (DataTree)DataTree.from(json);
/*    */   }
/*    */ 
/*    */   
/*    */   public JsonElement serialize(DataTree src, Type typeOfSrc, JsonSerializationContext context) {
/* 23 */     return ((GsonDataTree)src).getElement();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\typeadapters\JsonElementTreeSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */