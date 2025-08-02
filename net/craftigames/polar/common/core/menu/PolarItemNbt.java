/*     */ package net.craftigames.polar.common.core.menu;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.craftigames.polar.common.util.JsonDataType;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ public class PolarItemNbt
/*     */   implements GsonSerializable
/*     */ {
/*  17 */   private final Map<String, Object> nbt = new HashMap<>(); public Map<String, Object> getNbt() { return this.nbt; }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public JsonElement serialize() {
/*  22 */     JsonObject object = new JsonObject();
/*     */     
/*  24 */     for (Map.Entry<String, Object> entry : this.nbt.entrySet()) {
/*  25 */       String tag = entry.getKey();
/*     */       
/*  27 */       JsonObject dataObject = new JsonObject();
/*     */       
/*  29 */       JsonDataType type = JsonDataType.getFromObject(entry.getValue());
/*  30 */       if (type != null) {
/*  31 */         dataObject.addProperty("type", type.getStoredName());
/*     */         try {
/*  33 */           dataObject.add("value", (JsonElement)type.getWrite().apply(entry.getValue()));
/*  34 */         } catch (ClassCastException e) {
/*  35 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/*  38 */         throw new IllegalArgumentException("No json data type found for class \"" + entry.getValue().getClass().getName() + "\"");
/*     */       } 
/*     */       
/*  41 */       object.add(tag, (JsonElement)dataObject);
/*     */     } 
/*     */     
/*  44 */     return (JsonElement)object;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static PolarItemNbt deserialize(JsonElement element) {
/*  49 */     if (element.isJsonObject()) {
/*  50 */       JsonObject object = element.getAsJsonObject();
/*     */       
/*  52 */       PolarItemNbt nbt = new PolarItemNbt();
/*     */       
/*  54 */       for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)object.entrySet()) {
/*  55 */         JsonObject dataObject = ((JsonElement)entry.getValue()).getAsJsonObject();
/*     */         
/*  57 */         JsonDataType type = JsonDataType.getFromType(dataObject.get("type").getAsString());
/*  58 */         if (type == null) {
/*  59 */           throw new IllegalArgumentException("No json data type found for object \"" + object + "\"");
/*     */         }
/*     */         
/*  62 */         nbt.nbt.put(entry.getKey(), type.getRead().apply(dataObject.get("value")));
/*     */       } 
/*     */       
/*  65 */       return nbt;
/*     */     } 
/*  67 */     return new PolarItemNbt();
/*     */   }
/*     */   
/*     */   public int size() {
/*  71 */     return this.nbt.size();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  75 */     return this.nbt.isEmpty();
/*     */   }
/*     */   
/*     */   public void set(String tag, Object object) {
/*  79 */     this.nbt.put(tag, object);
/*     */   }
/*     */   
/*     */   public Object get(String tag) {
/*  83 */     return this.nbt.get(tag);
/*     */   }
/*     */   
/*     */   public byte getByte(String tag) {
/*  87 */     return ((Byte)this.nbt.get(tag)).byteValue();
/*     */   }
/*     */   
/*     */   public short getShort(String tag) {
/*  91 */     return ((Short)this.nbt.get(tag)).shortValue();
/*     */   }
/*     */   
/*     */   public int getInteger(String tag) {
/*  95 */     return ((Integer)this.nbt.get(tag)).intValue();
/*     */   }
/*     */   
/*     */   public long getLong(String tag) {
/*  99 */     return ((Long)this.nbt.get(tag)).longValue();
/*     */   }
/*     */   
/*     */   public float getFloat(String tag) {
/* 103 */     return ((Float)this.nbt.get(tag)).floatValue();
/*     */   }
/*     */   
/*     */   public double getDouble(String tag) {
/* 107 */     return ((Double)this.nbt.get(tag)).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Object> getList(String tag) {
/* 112 */     return (List<Object>)this.nbt.get(tag);
/*     */   }
/*     */   
/*     */   public List<Object> setList(String tag) {
/* 116 */     List<Object> object = new ArrayList();
/* 117 */     this.nbt.put(tag, object);
/* 118 */     return object;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Object> getMap(String tag) {
/* 123 */     return (Map<String, Object>)this.nbt.get(tag);
/*     */   }
/*     */   
/*     */   public Map<String, Object> setMap(String tag) {
/* 127 */     Map<String, Object> object = new HashMap<>();
/* 128 */     this.nbt.put(tag, object);
/* 129 */     return object;
/*     */   }
/*     */   
/*     */   public void merge(PolarItemNbt nbt) {
/* 133 */     if (nbt != null)
/* 134 */       getNbt().putAll(nbt.getNbt()); 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\PolarItemNbt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */