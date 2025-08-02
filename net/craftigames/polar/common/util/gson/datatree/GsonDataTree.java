/*     */ package net.craftigames.polar.common.util.gson.datatree;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Spliterators;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.stream.StreamSupport;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ public class GsonDataTree implements DataTree {
/*     */   public GsonDataTree(JsonElement element) {
/*  16 */     this.element = Objects.<JsonElement>requireNonNull(element, "element");
/*     */   }
/*     */   private final JsonElement element;
/*     */   public JsonElement getElement() {
/*  20 */     return this.element;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public GsonDataTree resolve(@Nonnull Object... path) {
/*  26 */     if (path.length == 0) {
/*  27 */       return this;
/*     */     }
/*     */     
/*  30 */     JsonElement o = this.element;
/*  31 */     for (int i = 0; i < path.length; i++) {
/*  32 */       Object p = path[i];
/*     */       
/*  34 */       if (p instanceof String) {
/*  35 */         String memberName = (String)p;
/*  36 */         JsonObject obj = o.getAsJsonObject();
/*  37 */         if (!obj.has(memberName)) {
/*  38 */           throw new IllegalArgumentException("Object " + obj + " does not have member: " + memberName);
/*     */         }
/*  40 */         o = obj.get(memberName);
/*  41 */       } else if (p instanceof Number) {
/*  42 */         o = o.getAsJsonArray().get(((Number)p).intValue());
/*     */       } else {
/*  44 */         throw new IllegalArgumentException("Unknown path node at index " + i + ": " + p);
/*     */       } 
/*     */     } 
/*  47 */     return new GsonDataTree(o);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Stream<Map.Entry<String, GsonDataTree>> asObject() {
/*  53 */     return this.element.getAsJsonObject().entrySet().stream()
/*  54 */       .map(entry -> Maps.immutableEntry(entry.getKey(), new GsonDataTree((JsonElement)entry.getValue())));
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Stream<GsonDataTree> asArray() {
/*  60 */     return StreamSupport.stream(this.element.getAsJsonArray().spliterator(), false)
/*  61 */       .map(GsonDataTree::new);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Stream<Map.Entry<Integer, GsonDataTree>> asIndexedArray() {
/*  67 */     return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<Map.Entry<Integer, GsonDataTree>>() {
/*  68 */             private final Iterator<JsonElement> iterator = GsonDataTree.this.element.getAsJsonArray().iterator();
/*  69 */             private int index = 0;
/*     */ 
/*     */             
/*     */             public boolean hasNext() {
/*  73 */               return this.iterator.hasNext();
/*     */             }
/*     */ 
/*     */             
/*     */             public Map.Entry<Integer, GsonDataTree> next() {
/*  78 */               return Maps.immutableEntry(Integer.valueOf(this.index++), new GsonDataTree(this.iterator.next()));
/*     */             }
/*     */           }1040), false);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public String asString() {
/*  86 */     return this.element.getAsString();
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Number asNumber() {
/*  92 */     return this.element.getAsNumber();
/*     */   }
/*     */ 
/*     */   
/*     */   public int asInt() {
/*  97 */     return this.element.getAsInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public double asDouble() {
/* 102 */     return this.element.getAsDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean asBoolean() {
/* 107 */     return this.element.getAsBoolean();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\datatree\GsonDataTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */