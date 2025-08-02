/*     */ package net.craftigames.polar.common.messages.networking;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ 
/*     */ public class MessageInputStream {
/*     */   public JsonObject getIn() {
/*  14 */     return this.in;
/*     */   } private final JsonObject in;
/*     */   public MessageInputStream(JsonObject in) {
/*  17 */     this.in = in;
/*     */   }
/*     */   
/*     */   public void add(String property, JsonElement value) {
/*  21 */     this.in.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonElement remove(String property) {
/*  25 */     return this.in.remove(property);
/*     */   }
/*     */   
/*     */   public void addProperty(String property, String value) {
/*  29 */     this.in.addProperty(property, value);
/*     */   }
/*     */   
/*     */   public void addProperty(String property, Number value) {
/*  33 */     this.in.addProperty(property, value);
/*     */   }
/*     */   
/*     */   public void addProperty(String property, Boolean value) {
/*  37 */     this.in.addProperty(property, value);
/*     */   }
/*     */   
/*     */   public void addProperty(String property, Character value) {
/*  41 */     this.in.addProperty(property, value);
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<String, JsonElement>> entrySet() {
/*  45 */     return this.in.entrySet();
/*     */   }
/*     */   
/*     */   public Set<String> keySet() {
/*  49 */     return this.in.keySet();
/*     */   }
/*     */   
/*     */   public int size() {
/*  53 */     return this.in.size();
/*     */   }
/*     */   
/*     */   public boolean has(String memberName) {
/*  57 */     return this.in.has(memberName);
/*     */   }
/*     */   
/*     */   public JsonElement get(String memberName) {
/*  61 */     return this.in.get(memberName);
/*     */   }
/*     */   
/*     */   public JsonElement get(String memberName, JsonElement defaultValue) {
/*  65 */     return this.in.has(memberName) ? this.in.get(memberName) : defaultValue;
/*     */   }
/*     */   
/*     */   public JsonPrimitive getAsJsonPrimitive(String memberName) {
/*  69 */     return this.in.getAsJsonPrimitive(memberName);
/*     */   }
/*     */   
/*     */   public JsonArray getAsJsonArray(String memberName) {
/*  73 */     return this.in.getAsJsonArray(memberName);
/*     */   }
/*     */   
/*     */   public JsonObject getAsJsonObject(String memberName) {
/*  77 */     return this.in.getAsJsonObject(memberName);
/*     */   }
/*     */   
/*     */   public boolean isJsonArray() {
/*  81 */     return this.in.isJsonArray();
/*     */   }
/*     */   
/*     */   public boolean isJsonObject() {
/*  85 */     return this.in.isJsonObject();
/*     */   }
/*     */   
/*     */   public boolean isJsonPrimitive() {
/*  89 */     return this.in.isJsonPrimitive();
/*     */   }
/*     */   
/*     */   public boolean isJsonNull() {
/*  93 */     return this.in.isJsonNull();
/*     */   }
/*     */   
/*     */   public JsonObject getAsJsonObject() {
/*  97 */     return this.in.getAsJsonObject();
/*     */   }
/*     */   
/*     */   public JsonArray getAsJsonArray() {
/* 101 */     return this.in.getAsJsonArray();
/*     */   }
/*     */   
/*     */   public JsonPrimitive getAsJsonPrimitive() {
/* 105 */     return this.in.getAsJsonPrimitive();
/*     */   }
/*     */   
/*     */   public JsonNull getAsJsonNull() {
/* 109 */     return this.in.getAsJsonNull();
/*     */   }
/*     */   
/*     */   public boolean getAsBoolean() {
/* 113 */     return this.in.getAsBoolean();
/*     */   }
/*     */   
/*     */   public Number getAsNumber() {
/* 117 */     return this.in.getAsNumber();
/*     */   }
/*     */   
/*     */   public String getAsString() {
/* 121 */     return this.in.getAsString();
/*     */   }
/*     */   
/*     */   public double getAsDouble() {
/* 125 */     return this.in.getAsDouble();
/*     */   }
/*     */   
/*     */   public float getAsFloat() {
/* 129 */     return this.in.getAsFloat();
/*     */   }
/*     */   
/*     */   public long getAsLong() {
/* 133 */     return this.in.getAsLong();
/*     */   }
/*     */   
/*     */   public int getAsInt() {
/* 137 */     return this.in.getAsInt();
/*     */   }
/*     */   
/*     */   public byte getAsByte() {
/* 141 */     return this.in.getAsByte();
/*     */   }
/*     */   
/*     */   public char getAsCharacter() {
/* 145 */     return this.in.getAsCharacter();
/*     */   }
/*     */   
/*     */   public BigDecimal getAsBigDecimal() {
/* 149 */     return this.in.getAsBigDecimal();
/*     */   }
/*     */   
/*     */   public BigInteger getAsBigInteger() {
/* 153 */     return this.in.getAsBigInteger();
/*     */   }
/*     */   
/*     */   public short getAsShort() {
/* 157 */     return this.in.getAsShort();
/*     */   }
/*     */   
/*     */   public UUID getAsUUID() {
/* 161 */     return UUID.fromString(this.in.getAsString());
/*     */   }
/*     */   
/*     */   public UUID getAsUUID(JsonElement element) {
/* 165 */     return UUID.fromString(element.getAsString());
/*     */   }
/*     */   
/*     */   public UUID getAsUUID(String member) {
/* 169 */     return UUID.fromString(this.in.get(member).getAsString());
/*     */   }
/*     */   
/*     */   public <T> List<T> getAsList(JsonElement element, Class<T> clazz) {
/* 173 */     List<T> list = new ArrayList<>();
/* 174 */     if (element instanceof JsonArray) {
/* 175 */       for (JsonElement jsonElement : element.getAsJsonArray()) {
/* 176 */         list.add((T)GsonProvider.standard().fromJson(jsonElement, clazz));
/*     */       }
/*     */     }
/* 179 */     return list;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\networking\MessageInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */