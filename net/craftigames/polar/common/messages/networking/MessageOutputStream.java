/*     */ package net.craftigames.polar.common.messages.networking;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import javax.annotation.Nullable;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ 
/*     */ 
/*     */ public class MessageOutputStream
/*     */ {
/*     */   private final JsonBuilder.JsonObjectBuilder out;
/*     */   
/*     */   public MessageOutputStream(JsonBuilder.JsonObjectBuilder out) {
/*  22 */     this.out = out;
/*     */   }
/*     */   
/*     */   public void accept(Map.Entry<String, JsonElement> entry) {
/*  26 */     this.out.accept(entry);
/*     */   }
/*     */   
/*     */   public void accept(String property, JsonElement value) {
/*  30 */     this.out.accept(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable JsonElement value, boolean copy) {
/*  34 */     return this.out.add(property, value, copy);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable JsonElement value) {
/*  38 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable GsonSerializable serializable) {
/*  42 */     return this.out.add(property, serializable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable String value) {
/*  46 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable UUID value) {
/*  50 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable Number value) {
/*  54 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable Boolean value) {
/*  58 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, @Nullable Character value) {
/*  62 */     return this.out.add(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable JsonElement value, boolean copy) {
/*  66 */     return this.out.addIfAbsent(property, value, copy);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable JsonElement value) {
/*  70 */     return this.out.addIfAbsent(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable GsonSerializable serializable) {
/*  74 */     return this.out.addIfAbsent(property, serializable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable String value) {
/*  78 */     return this.out.addIfAbsent(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable Number value) {
/*  82 */     return this.out.addIfAbsent(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable Boolean value) {
/*  86 */     return this.out.addIfAbsent(property, value);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable Character value) {
/*  90 */     return this.out.addIfAbsent(property, value);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAll(Iterable<Map.Entry<String, T>> iterable, boolean deepCopy) {
/*  94 */     return this.out.addAll(iterable, deepCopy);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAll(Iterable<Map.Entry<String, T>> iterable) {
/*  98 */     return this.out.addAll(iterable);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAll(Stream<Map.Entry<String, T>> stream, boolean deepCopy) {
/* 102 */     return this.out.addAll(stream, deepCopy);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAll(Stream<Map.Entry<String, T>> stream) {
/* 106 */     return this.out.addAll(stream);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAll(JsonObject object, boolean deepCopy) {
/* 110 */     return this.out.addAll(object, deepCopy);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAll(JsonObject object) {
/* 114 */     return this.out.addAll(object);
/*     */   }
/*     */   
/*     */   public <T extends GsonSerializable> JsonBuilder.JsonObjectBuilder addAllSerializables(Iterable<Map.Entry<String, T>> iterable) {
/* 118 */     return this.out.addAllSerializables(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllStrings(Iterable<Map.Entry<String, String>> iterable) {
/* 122 */     return this.out.addAllStrings(iterable);
/*     */   }
/*     */   
/*     */   public <T extends Number> JsonBuilder.JsonObjectBuilder addAllNumbers(Iterable<Map.Entry<String, T>> iterable) {
/* 126 */     return this.out.addAllNumbers(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllBooleans(Iterable<Map.Entry<String, Boolean>> iterable) {
/* 130 */     return this.out.addAllBooleans(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllCharacters(Iterable<Map.Entry<String, Character>> iterable) {
/* 134 */     return this.out.addAllCharacters(iterable);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAllIfAbsent(Iterable<Map.Entry<String, T>> iterable, boolean deepCopy) {
/* 138 */     return this.out.addAllIfAbsent(iterable, deepCopy);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAllIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 142 */     return this.out.addAllIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAllIfAbsent(Stream<Map.Entry<String, T>> stream, boolean deepCopy) {
/* 146 */     return this.out.addAllIfAbsent(stream, deepCopy);
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addAllIfAbsent(Stream<Map.Entry<String, T>> stream) {
/* 150 */     return this.out.addAllIfAbsent(stream);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllIfAbsent(JsonObject object, boolean deepCopy) {
/* 154 */     return this.out.addAllIfAbsent(object, deepCopy);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllIfAbsent(JsonObject object) {
/* 158 */     return this.out.addAllIfAbsent(object);
/*     */   }
/*     */   
/*     */   public <T extends GsonSerializable> JsonBuilder.JsonObjectBuilder addAllSerializablesIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 162 */     return this.out.addAllSerializablesIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllStringsIfAbsent(Iterable<Map.Entry<String, String>> iterable) {
/* 166 */     return this.out.addAllStringsIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public <T extends Number> JsonBuilder.JsonObjectBuilder addAllNumbersIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 170 */     return this.out.addAllNumbersIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllBooleansIfAbsent(Iterable<Map.Entry<String, Boolean>> iterable) {
/* 174 */     return this.out.addAllBooleansIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder addAllCharactersIfAbsent(Iterable<Map.Entry<String, Character>> iterable) {
/* 178 */     return this.out.addAllCharactersIfAbsent(iterable);
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder consume(Consumer<? super JsonBuilder.JsonObjectBuilder> consumer) {
/* 182 */     return this.out.consume(consumer);
/*     */   }
/*     */   
/*     */   public BiConsumer<String, JsonElement> andThen(BiConsumer<? super String, ? super JsonElement> after) {
/* 186 */     return this.out.andThen(after);
/*     */   }
/*     */   
/*     */   public Consumer<Map.Entry<String, JsonElement>> andThen(Consumer<? super Map.Entry<String, JsonElement>> after) {
/* 190 */     return this.out.andThen(after);
/*     */   }
/*     */   
/*     */   public final JsonObject build() {
/* 194 */     return this.out.build();
/*     */   }
/*     */   
/*     */   public <T extends JsonElement> JsonBuilder.JsonObjectBuilder addList(String property, List<T> list) {
/* 198 */     return this.out.add(property, (JsonElement)JsonBuilder.array().addAll(list).build());
/*     */   }
/*     */   
/*     */   public JsonBuilder.JsonObjectBuilder add(String property, List<UUID> list) {
/* 202 */     List<JsonElement> elements = new ArrayList<>(list.size());
/* 203 */     for (UUID uuid : list) {
/* 204 */       elements.add(JsonBuilder.primitive(uuid));
/*     */     }
/* 206 */     return addList(property, elements);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\networking\MessageOutputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */