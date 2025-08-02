/*     */ package net.craftigames.polar.common.util.gson;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonNull;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import java.time.Instant;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.UUID;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Stream;
/*     */ import javax.annotation.Nullable;
/*     */ 
/*     */ public final class JsonBuilder
/*     */ {
/*     */   private JsonBuilder() {
/*  22 */     throw new UnsupportedOperationException("This class cannot be instantiated");
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
/*     */   public static JsonObjectBuilder object(JsonObject object) {
/*  34 */     Objects.requireNonNull(object, "object");
/*  35 */     return object(object, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonObjectBuilder object() {
/*  44 */     return object(new JsonObject());
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
/*     */   public static JsonObjectBuilder object(JsonObject object, boolean copy) {
/*  57 */     Objects.requireNonNull(object, "object");
/*     */     
/*  59 */     if (copy) {
/*  60 */       return object().addAll(object, true);
/*     */     }
/*  62 */     return new JsonObjectBuilderImpl(object);
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
/*     */   public static JsonArrayBuilder array(JsonArray array) {
/*  75 */     Objects.requireNonNull(array, "array");
/*  76 */     return array(array, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonArrayBuilder array() {
/*  85 */     return array(new JsonArray());
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
/*     */   public static JsonElement primitive(@Nullable String value) {
/*  97 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value);
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
/*     */   public static JsonElement primitive(@Nullable UUID value) {
/* 109 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value.toString());
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
/*     */   public static JsonElement primitive(@Nullable Number value) {
/* 121 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value);
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
/*     */   public static JsonElement primitive(@Nullable Boolean value) {
/* 133 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value);
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
/*     */   public static JsonElement primitive(@Nullable Character value) {
/* 145 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value);
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
/*     */   public static JsonElement primitive(@Nullable Instant value) {
/* 157 */     return (value == null) ? (JsonElement)nullValue() : (JsonElement)new JsonPrimitive(value.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonNull nullValue() {
/* 166 */     return JsonNull.INSTANCE;
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
/*     */   public static JsonPrimitive primitiveNonNull(String value) {
/* 179 */     Objects.requireNonNull(value, "value");
/* 180 */     return new JsonPrimitive(value);
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
/*     */   public static JsonPrimitive primitiveNonNull(Number value) {
/* 193 */     Objects.requireNonNull(value, "value");
/* 194 */     return new JsonPrimitive(value);
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
/*     */   public static JsonPrimitive primitiveNonNull(Boolean value) {
/* 207 */     Objects.requireNonNull(value, "value");
/* 208 */     return new JsonPrimitive(value);
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
/*     */   public static JsonPrimitive primitiveNonNull(Character value) {
/* 221 */     Objects.requireNonNull(value, "value");
/* 222 */     return new JsonPrimitive(value);
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
/*     */   public static JsonArrayBuilder array(JsonArray array, boolean copy) {
/* 235 */     Objects.requireNonNull(array, "array");
/*     */     
/* 237 */     if (copy) {
/* 238 */       return array().addAll((Iterable<JsonElement>)array, true);
/*     */     }
/* 240 */     return new JsonArrayBuilderImpl(array);
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
/*     */   public static <T> Collector<T, JsonObjectBuilder, JsonObject> collectToObject(Function<? super T, String> keyMapper, Function<? super T, JsonElement> valueMapper) {
/* 253 */     return Collector.of(JsonBuilder::object, (r, t) -> r.add(keyMapper.apply(t), valueMapper.apply(t)), (l, r) -> l.addAll(r.build()), JsonObjectBuilder::build, new Collector.Characteristics[0]);
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
/*     */   
/*     */   public static Collector<JsonElement, JsonArrayBuilder, JsonArray> collectToArray() {
/* 267 */     return Collector.of(JsonBuilder::array, JsonArrayBuilder::add, (l, r) -> l.addAll((Iterable<JsonElement>)r.build()), JsonArrayBuilder::build, new Collector.Characteristics[0]);
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
/*     */   
/*     */   public static Collector<GsonSerializable, JsonArrayBuilder, JsonArray> collectSerializablesToArray() {
/* 281 */     return Collector.of(JsonBuilder::array, JsonArrayBuilder::add, (l, r) -> l.addAll((Iterable<JsonElement>)r.build()), JsonArrayBuilder::build, new Collector.Characteristics[0]);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Collector<T, JsonArrayBuilder, JsonArray> collectToArray(Function<? super T, JsonElement> valueMapper) {
/* 297 */     return Collector.of(JsonBuilder::array, (r, t) -> r.add(valueMapper.apply(t)), (l, r) -> l.addAll((Iterable<JsonElement>)r.build()), JsonArrayBuilder::build, new Collector.Characteristics[0]);
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
/*     */   public static interface JsonObjectBuilder
/*     */     extends BiConsumer<String, JsonElement>, Consumer<Map.Entry<String, JsonElement>>
/*     */   {
/*     */     default void accept(Map.Entry<String, JsonElement> entry) {
/* 312 */       Objects.requireNonNull(entry, "entry");
/* 313 */       add(entry.getKey(), entry.getValue());
/*     */     }
/*     */ 
/*     */     
/*     */     default void accept(String property, JsonElement value) {
/* 318 */       add(property, value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable JsonElement value) {
/* 324 */       return add(property, value, false);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable GsonSerializable serializable) {
/* 328 */       return (serializable == null) ? add(property, (JsonElement)JsonBuilder.nullValue()) : add(property, serializable.serialize());
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable String value) {
/* 332 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable UUID value) {
/* 336 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable Number value) {
/* 340 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable Boolean value) {
/* 344 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable Character value) {
/* 348 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */ 
/*     */     
/*     */     default JsonObjectBuilder add(String property, @Nullable Instant value) {
/* 353 */       return add(property, JsonBuilder.primitive(value));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable JsonElement value) {
/* 359 */       return addIfAbsent(property, value, false);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable GsonSerializable serializable) {
/* 363 */       return (serializable == null) ? addIfAbsent(property, (JsonElement)JsonBuilder.nullValue()) : addIfAbsent(property, serializable.serialize());
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable String value) {
/* 367 */       return addIfAbsent(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable Number value) {
/* 371 */       return addIfAbsent(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable Boolean value) {
/* 375 */       return addIfAbsent(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addIfAbsent(String property, @Nullable Character value) {
/* 379 */       return addIfAbsent(property, JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAll(Iterable<Map.Entry<String, T>> iterable, boolean deepCopy) {
/* 383 */       Objects.requireNonNull(iterable, "iterable");
/* 384 */       for (Map.Entry<String, T> e : iterable) {
/* 385 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 388 */         add(e.getKey(), (JsonElement)e.getValue(), deepCopy);
/*     */       } 
/* 390 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAll(Iterable<Map.Entry<String, T>> iterable) {
/* 394 */       return addAll(iterable, false);
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAll(Stream<Map.Entry<String, T>> stream, boolean deepCopy) {
/* 398 */       Objects.requireNonNull(stream, "stream");
/* 399 */       stream.forEach(e -> {
/*     */             if (e == null || e.getKey() == null) {
/*     */               return;
/*     */             }
/*     */             add((String)e.getKey(), (JsonElement)e.getValue(), deepCopy);
/*     */           });
/* 405 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAll(Stream<Map.Entry<String, T>> stream) {
/* 409 */       return addAll(stream, false);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAll(JsonObject object, boolean deepCopy) {
/* 413 */       Objects.requireNonNull(object, "object");
/* 414 */       return addAll(object.entrySet(), deepCopy);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAll(JsonObject object) {
/* 418 */       return addAll(object, false);
/*     */     }
/*     */     
/*     */     default <T extends GsonSerializable> JsonObjectBuilder addAllSerializables(Iterable<Map.Entry<String, T>> iterable) {
/* 422 */       Objects.requireNonNull(iterable, "iterable");
/* 423 */       for (Map.Entry<String, T> e : iterable) {
/* 424 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 427 */         add(e.getKey(), (GsonSerializable)e.getValue());
/*     */       } 
/* 429 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllStrings(Iterable<Map.Entry<String, String>> iterable) {
/* 433 */       Objects.requireNonNull(iterable, "iterable");
/* 434 */       for (Map.Entry<String, String> e : iterable) {
/* 435 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 438 */         add(e.getKey(), e.getValue());
/*     */       } 
/* 440 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends Number> JsonObjectBuilder addAllNumbers(Iterable<Map.Entry<String, T>> iterable) {
/* 444 */       Objects.requireNonNull(iterable, "iterable");
/* 445 */       for (Map.Entry<String, T> e : iterable) {
/* 446 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 449 */         add(e.getKey(), (Number)e.getValue());
/*     */       } 
/* 451 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllBooleans(Iterable<Map.Entry<String, Boolean>> iterable) {
/* 455 */       Objects.requireNonNull(iterable, "iterable");
/* 456 */       for (Map.Entry<String, Boolean> e : iterable) {
/* 457 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 460 */         add(e.getKey(), e.getValue());
/*     */       } 
/* 462 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllCharacters(Iterable<Map.Entry<String, Character>> iterable) {
/* 466 */       Objects.requireNonNull(iterable, "iterable");
/* 467 */       for (Map.Entry<String, Character> e : iterable) {
/* 468 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 471 */         add(e.getKey(), e.getValue());
/*     */       } 
/* 473 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAllIfAbsent(Iterable<Map.Entry<String, T>> iterable, boolean deepCopy) {
/* 477 */       Objects.requireNonNull(iterable, "iterable");
/* 478 */       for (Map.Entry<String, T> e : iterable) {
/* 479 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 482 */         addIfAbsent(e.getKey(), (JsonElement)e.getValue(), deepCopy);
/*     */       } 
/* 484 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAllIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 488 */       return addAllIfAbsent(iterable, false);
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAllIfAbsent(Stream<Map.Entry<String, T>> stream, boolean deepCopy) {
/* 492 */       Objects.requireNonNull(stream, "stream");
/* 493 */       stream.forEach(e -> {
/*     */             if (e == null || e.getKey() == null) {
/*     */               return;
/*     */             }
/*     */             addIfAbsent((String)e.getKey(), (JsonElement)e.getValue(), deepCopy);
/*     */           });
/* 499 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonObjectBuilder addAllIfAbsent(Stream<Map.Entry<String, T>> stream) {
/* 503 */       return addAllIfAbsent(stream, false);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllIfAbsent(JsonObject object, boolean deepCopy) {
/* 507 */       Objects.requireNonNull(object, "object");
/* 508 */       return addAllIfAbsent(object.entrySet(), deepCopy);
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllIfAbsent(JsonObject object) {
/* 512 */       return addAllIfAbsent(object, false);
/*     */     }
/*     */     
/*     */     default <T extends GsonSerializable> JsonObjectBuilder addAllSerializablesIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 516 */       Objects.requireNonNull(iterable, "iterable");
/* 517 */       for (Map.Entry<String, T> e : iterable) {
/* 518 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 521 */         addIfAbsent(e.getKey(), (GsonSerializable)e.getValue());
/*     */       } 
/* 523 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllStringsIfAbsent(Iterable<Map.Entry<String, String>> iterable) {
/* 527 */       Objects.requireNonNull(iterable, "iterable");
/* 528 */       for (Map.Entry<String, String> e : iterable) {
/* 529 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 532 */         addIfAbsent(e.getKey(), e.getValue());
/*     */       } 
/* 534 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends Number> JsonObjectBuilder addAllNumbersIfAbsent(Iterable<Map.Entry<String, T>> iterable) {
/* 538 */       Objects.requireNonNull(iterable, "iterable");
/* 539 */       for (Map.Entry<String, T> e : iterable) {
/* 540 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 543 */         addIfAbsent(e.getKey(), (Number)e.getValue());
/*     */       } 
/* 545 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllBooleansIfAbsent(Iterable<Map.Entry<String, Boolean>> iterable) {
/* 549 */       Objects.requireNonNull(iterable, "iterable");
/* 550 */       for (Map.Entry<String, Boolean> e : iterable) {
/* 551 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 554 */         addIfAbsent(e.getKey(), e.getValue());
/*     */       } 
/* 556 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder addAllCharactersIfAbsent(Iterable<Map.Entry<String, Character>> iterable) {
/* 560 */       Objects.requireNonNull(iterable, "iterable");
/* 561 */       for (Map.Entry<String, Character> e : iterable) {
/* 562 */         if (e == null || e.getKey() == null) {
/*     */           continue;
/*     */         }
/* 565 */         addIfAbsent(e.getKey(), e.getValue());
/*     */       } 
/* 567 */       return this;
/*     */     }
/*     */     
/*     */     default JsonObjectBuilder consume(Consumer<? super JsonObjectBuilder> consumer) {
/* 571 */       consumer.accept(this);
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     JsonObjectBuilder add(String param1String, @Nullable JsonElement param1JsonElement, boolean param1Boolean);
/*     */     
/*     */     JsonObjectBuilder addIfAbsent(String param1String, @Nullable JsonElement param1JsonElement, boolean param1Boolean);
/*     */     
/*     */     JsonObject build();
/*     */   }
/*     */   
/*     */   private static final class JsonObjectBuilderImpl implements JsonObjectBuilder {
/*     */     private JsonObjectBuilderImpl(JsonObject handle) {
/* 584 */       this.handle = handle;
/*     */     }
/*     */     
/*     */     public JsonBuilder.JsonObjectBuilder add(String property, @Nullable JsonElement value, boolean copy) {
/*     */       JsonNull jsonNull;
/* 589 */       Objects.requireNonNull(property, "property");
/* 590 */       if (value == null) {
/* 591 */         jsonNull = JsonBuilder.nullValue();
/*     */       }
/*     */       
/* 594 */       if (copy && jsonNull.isJsonObject()) {
/* 595 */         this.handle.add(property, (JsonElement)JsonBuilder.object(jsonNull.getAsJsonObject(), true).build());
/* 596 */       } else if (copy && jsonNull.isJsonArray()) {
/* 597 */         this.handle.add(property, (JsonElement)JsonBuilder.array(jsonNull.getAsJsonArray(), true).build());
/*     */       } else {
/* 599 */         this.handle.add(property, (JsonElement)jsonNull);
/*     */       } 
/* 601 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonBuilder.JsonObjectBuilder addIfAbsent(String property, @Nullable JsonElement value, boolean copy) {
/* 606 */       Objects.requireNonNull(property, "property");
/* 607 */       if (this.handle.has(property)) {
/* 608 */         return this;
/*     */       }
/* 610 */       return add(property, value, copy);
/*     */     }
/*     */     private final JsonObject handle;
/*     */     
/*     */     public JsonObject build() {
/* 615 */       return this.handle;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class JsonArrayBuilderImpl implements JsonArrayBuilder {
/*     */     private final JsonArray handle;
/*     */     
/*     */     private JsonArrayBuilderImpl(JsonArray handle) {
/* 623 */       this.handle = handle;
/*     */     }
/*     */     
/*     */     public JsonBuilder.JsonArrayBuilder add(@Nullable JsonElement value, boolean copy) {
/*     */       JsonNull jsonNull;
/* 628 */       if (value == null) {
/* 629 */         jsonNull = JsonBuilder.nullValue();
/*     */       }
/*     */       
/* 632 */       if (copy && jsonNull.isJsonObject()) {
/* 633 */         this.handle.add((JsonElement)JsonBuilder.object(jsonNull.getAsJsonObject(), true).build());
/* 634 */       } else if (copy && jsonNull.isJsonArray()) {
/* 635 */         this.handle.add((JsonElement)JsonBuilder.array(jsonNull.getAsJsonArray(), true).build());
/*     */       } else {
/* 637 */         this.handle.add((JsonElement)jsonNull);
/*     */       } 
/*     */       
/* 640 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonArray build() {
/* 645 */       return this.handle;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface JsonArrayBuilder
/*     */     extends Consumer<JsonElement>
/*     */   {
/*     */     default void accept(JsonElement value) {
/* 656 */       add(value);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable JsonElement value) {
/* 662 */       return add(value, false);
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable GsonSerializable serializable) {
/* 666 */       return (serializable == null) ? add((JsonElement)JsonBuilder.nullValue()) : add(serializable.serialize());
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable String value) {
/* 670 */       return add(JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable Number value) {
/* 674 */       return add(JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable Boolean value) {
/* 678 */       return add(JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable Character value) {
/* 682 */       return add(JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder add(@Nullable UUID value) {
/* 686 */       return add(JsonBuilder.primitive(value));
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonArrayBuilder addAll(Iterable<T> iterable, boolean copy) {
/* 690 */       Objects.requireNonNull(iterable, "iterable");
/* 691 */       for (JsonElement jsonElement : iterable) {
/* 692 */         add(jsonElement, copy);
/*     */       }
/* 694 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonArrayBuilder addAll(Iterable<T> iterable) {
/* 698 */       return addAll(iterable, false);
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonArrayBuilder addAll(Stream<T> stream, boolean copy) {
/* 702 */       Objects.requireNonNull(stream, "iterable");
/* 703 */       stream.forEach(e -> add(e, copy));
/* 704 */       return this;
/*     */     }
/*     */     
/*     */     default <T extends JsonElement> JsonArrayBuilder addAll(Stream<T> stream) {
/* 708 */       return addAll(stream, false);
/*     */     }
/*     */     
/*     */     default <T extends GsonSerializable> JsonArrayBuilder addSerializables(Iterable<T> iterable) {
/* 712 */       Objects.requireNonNull(iterable, "iterable");
/* 713 */       for (GsonSerializable gsonSerializable : iterable) {
/* 714 */         add(gsonSerializable);
/*     */       }
/* 716 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder addStrings(Iterable<String> iterable) {
/* 720 */       Objects.requireNonNull(iterable, "iterable");
/* 721 */       for (String e : iterable) {
/* 722 */         add(e);
/*     */       }
/* 724 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder addEnums(Iterable<Enum<?>> iterable) {
/* 728 */       Objects.requireNonNull(iterable, "iterable");
/* 729 */       for (Enum<?> e : iterable) {
/* 730 */         add(e.name());
/*     */       }
/* 732 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder addUUIDs(Iterable<UUID> iterable) {
/* 736 */       Objects.requireNonNull(iterable, "iterable");
/* 737 */       for (UUID e : iterable) {
/* 738 */         add(e);
/*     */       }
/* 740 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     default <T extends Number> JsonArrayBuilder addNumbers(Iterable<T> iterable) {
/* 745 */       Objects.requireNonNull(iterable, "iterable");
/* 746 */       for (Number number : iterable) {
/* 747 */         add(number);
/*     */       }
/* 749 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder addBooleans(Iterable<Boolean> iterable) {
/* 753 */       Objects.requireNonNull(iterable, "iterable");
/* 754 */       for (Boolean e : iterable) {
/* 755 */         add(e);
/*     */       }
/* 757 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder addCharacters(Iterable<Character> iterable) {
/* 761 */       Objects.requireNonNull(iterable, "iterable");
/* 762 */       for (Character e : iterable) {
/* 763 */         add(e);
/*     */       }
/* 765 */       return this;
/*     */     }
/*     */     
/*     */     default JsonArrayBuilder consume(Consumer<? super JsonArrayBuilder> consumer) {
/* 769 */       consumer.accept(this);
/* 770 */       return this;
/*     */     }
/*     */     
/*     */     JsonArrayBuilder add(@Nullable JsonElement param1JsonElement, boolean param1Boolean);
/*     */     
/*     */     JsonArray build();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\JsonBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */