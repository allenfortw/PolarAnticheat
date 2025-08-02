/*    */ package net.craftigames.polar.common.util.gson.typeadapters;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Method;
/*    */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*    */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*    */ 
/*    */ public final class GsonSerializableAdapterFactory
/*    */   implements TypeAdapterFactory {
/* 17 */   public static final GsonSerializableAdapterFactory INSTANCE = new GsonSerializableAdapterFactory();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> TypeAdapter<T> create(final Gson gson, TypeToken<T> type) {
/* 24 */     Class<? super T> clazz = type.getRawType();
/*    */ 
/*    */     
/* 27 */     final Method deserializeMethod = GsonSerializable.getDeserializeMethod(clazz);
/* 28 */     if (deserializeMethod == null) {
/* 29 */       return null;
/*    */     }
/*    */     
/* 32 */     TypeAdapter<? extends GsonSerializable> typeAdapter = new TypeAdapter<GsonSerializable>()
/*    */       {
/*    */         public void write(JsonWriter out, GsonSerializable value) {
/* 35 */           if (value == null) {
/* 36 */             gson.toJson(null, out);
/*    */             return;
/*    */           } 
/* 39 */           gson.toJson(value.serialize(), out);
/*    */         }
/*    */ 
/*    */         
/*    */         public GsonSerializable read(JsonReader in) throws IOException {
/* 44 */           JsonElement element = GsonProvider.parser().parse(in);
/*    */           
/* 46 */           if (element.isJsonNull()) {
/* 47 */             return null;
/*    */           }
/*    */           
/*    */           try {
/* 51 */             return (GsonSerializable)deserializeMethod.invoke(null, new Object[] { element });
/* 52 */           } catch (Exception e) {
/* 53 */             throw new IOException(e);
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 59 */     return (TypeAdapter)typeAdapter;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\typeadapters\GsonSerializableAdapterFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */