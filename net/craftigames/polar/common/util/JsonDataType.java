/*     */ package net.craftigames.polar.common.util;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.function.Function;
/*     */ import net.craftigames.polar.common.util.gson.GsonProvider;
/*     */ 
/*     */ public enum JsonDataType {
/*     */   static JsonDataType[] CACHE;
/*     */   private final Function<JsonElement, Object> read;
/*     */   private final Function<Object, JsonElement> write;
/*     */   JSON_NULL,
/*     */   JSON_PRIMITIVE,
/*     */   JSON_OBJECT,
/*     */   JSON_ARRAY,
/*     */   MAP,
/*     */   COLLECTION,
/*     */   UUID,
/*  24 */   CHARACTER("character", Character.class), BOOLEAN("character", Character.class), DOUBLE("character", Character.class), FLOAT("character", Character.class), LONG("character", Character.class), INTEGER("character", Character.class), SHORT("character", Character.class), BYTE("character", Character.class), STRING("character", Character.class);
/*     */   private final Class<?> clazz; private final String storedName; static { STRING = new JsonDataType("STRING", 0, "string", String.class, o -> new JsonPrimitive((String)o), JsonElement::getAsString); BYTE = new JsonDataType("BYTE", 1, "byte", Byte.class, o -> new JsonPrimitive(Byte.valueOf(((Byte)o).byteValue())), JsonElement::getAsByte); SHORT = new JsonDataType("SHORT", 2, "short", Short.class, o -> new JsonPrimitive(Short.valueOf(((Short)o).shortValue())), JsonElement::getAsShort); INTEGER = new JsonDataType("INTEGER", 3, "integer", Integer.class, o -> new JsonPrimitive(Integer.valueOf(((Integer)o).intValue())), JsonElement::getAsInt); LONG = new JsonDataType("LONG", 4, "long", Long.class, o -> new JsonPrimitive(Long.valueOf(((Long)o).longValue())), JsonElement::getAsLong); FLOAT = new JsonDataType("FLOAT", 5, "float", Float.class, o -> new JsonPrimitive(Float.valueOf(((Float)o).floatValue())), JsonElement::getAsFloat); DOUBLE = new JsonDataType("DOUBLE", 6, "double", Double.class, o -> new JsonPrimitive(Double.valueOf(((Double)o).doubleValue())), JsonElement::getAsDouble);
/*  26 */     BOOLEAN = new JsonDataType("BOOLEAN", 7, "boolean", Boolean.class, o -> new JsonPrimitive(Boolean.valueOf(((Boolean)o).booleanValue())), JsonElement::getAsBoolean); } static { UUID = new JsonDataType("UUID", 9, "uuid", UUID.class, o -> new JsonPrimitive(o.toString()), jsonElement -> UUID.fromString(jsonElement.getAsString()));
/*     */     
/*  28 */     COLLECTION = new JsonDataType("COLLECTION", 10, "collection", Collection.class, o -> {
/*     */           Collection<?> collection = (Collection)o;
/*     */           
/*     */           JsonArray array = new JsonArray();
/*     */           
/*     */           for (Object entry : collection) {
/*     */             JsonObject object = new JsonObject();
/*     */             
/*     */             JsonDataType type = getFromObject(entry);
/*     */             
/*     */             if (type != null) {
/*     */               object.addProperty("type", type.getStoredName());
/*     */               
/*     */               object.add("value", type.getWrite().apply(entry));
/*     */             } else {
/*     */               throw new IllegalArgumentException("Cannot save \"" + entry.getClass() + "\"");
/*     */             } 
/*     */             
/*     */             array.add((JsonElement)object);
/*     */           } 
/*     */           
/*     */           return (JsonElement)array;
/*     */         }jsonElement -> {
/*     */           List<Object> list = new ArrayList();
/*     */           
/*     */           for (JsonElement element : jsonElement.getAsJsonArray()) {
/*     */             JsonObject object = element.getAsJsonObject();
/*     */             
/*     */             JsonDataType type = getFromType(object.get("type").getAsString());
/*     */             
/*     */             if (type != null) {
/*     */               list.add(type.getRead().apply(object.get("value")));
/*     */               
/*     */               continue;
/*     */             } 
/*     */             throw new IllegalArgumentException("Cannot load \"" + object.get("type") + "\"");
/*     */           } 
/*     */           return list;
/*     */         });
/*  67 */     MAP = new JsonDataType("MAP", 11, "map", Map.class, o -> {
/*     */           Map<String, ?> map = (Map<String, ?>)o;
/*     */           
/*     */           JsonObject object = new JsonObject();
/*     */           
/*     */           for (Map.Entry<String, ?> entry : map.entrySet()) {
/*     */             Object stored = entry.getValue();
/*     */             
/*     */             JsonObject keyObject = new JsonObject();
/*     */             
/*     */             JsonDataType type = getFromObject(stored);
/*     */             
/*     */             if (type != null) {
/*     */               keyObject.addProperty("type", type.getStoredName());
/*     */               
/*     */               keyObject.add("value", type.getWrite().apply(stored));
/*     */             } else {
/*     */               throw new IllegalArgumentException("Cannot save \"" + stored.getClass() + "\"");
/*     */             } 
/*     */             
/*     */             object.add(entry.getKey(), (JsonElement)keyObject);
/*     */           } 
/*     */           
/*     */           return (JsonElement)object;
/*     */         }jsonElement -> {
/*     */           Map<String, Object> map = new HashMap<>();
/*     */           
/*     */           for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)jsonElement.getAsJsonObject().entrySet()) {
/*     */             JsonObject object = ((JsonElement)entry.getValue()).getAsJsonObject();
/*     */             JsonDataType type = getFromType(object.get("type").getAsString());
/*     */             if (type != null) {
/*     */               map.put(entry.getKey(), type.getRead().apply(object.get("value")));
/*     */               continue;
/*     */             } 
/*     */             throw new IllegalArgumentException("Cannot load \"" + object.get("type") + "\"");
/*     */           } 
/*     */           return map;
/*     */         });
/* 105 */     JSON_ARRAY = new JsonDataType("JSON_ARRAY", 12, "json-array", JsonArray.class, o -> (JsonElement)o, JsonElement::getAsJsonArray);
/* 106 */     JSON_OBJECT = new JsonDataType("JSON_OBJECT", 13, "json-object", JsonObject.class, o -> (JsonElement)o, JsonElement::getAsJsonObject);
/* 107 */     JSON_PRIMITIVE = new JsonDataType("JSON_PRIMITIVE", 14, "json-primitive", JsonPrimitive.class, o -> (JsonElement)o, JsonElement::getAsJsonPrimitive);
/* 108 */     JSON_NULL = new JsonDataType("JSON_NULL", 15, "json-null", JsonPrimitive.class, o -> (JsonElement)o, JsonElement::getAsJsonNull); }
/*     */ 
/*     */   
/* 111 */   public String getStoredName() { return this.storedName; } public Class<?> getClazz() {
/* 112 */     return this.clazz;
/*     */   }
/* 114 */   public Function<Object, JsonElement> getWrite() { return this.write; } public Function<JsonElement, Object> getRead() {
/* 115 */     return this.read;
/*     */   } static {
/* 117 */     CACHE = values();
/*     */   }
/*     */   JsonDataType(String storedName, Class<?> clazz, Function<Object, JsonElement> write, Function<JsonElement, Object> read) {
/* 120 */     this.storedName = storedName;
/* 121 */     this.clazz = clazz;
/* 122 */     this.write = write;
/* 123 */     this.read = read;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonDataType getFromObject(Class<?> clazz) {
/* 136 */     for (JsonDataType storedDataType : CACHE) {
/* 137 */       if (storedDataType.getClazz().isAssignableFrom(clazz)) {
/* 138 */         return storedDataType;
/*     */       }
/*     */     } 
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   public static JsonDataType getFromObject(Object input) {
/* 145 */     return getFromObject(input.getClass());
/*     */   }
/*     */   
/*     */   public static JsonDataType getFromType(String type) {
/* 149 */     for (JsonDataType storedDataType : CACHE) {
/* 150 */       if (storedDataType.getStoredName().equalsIgnoreCase(type)) {
/* 151 */         return storedDataType;
/*     */       }
/*     */     } 
/* 154 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\JsonDataType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */