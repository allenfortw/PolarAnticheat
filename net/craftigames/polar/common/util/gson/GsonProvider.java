/*     */ package net.craftigames.polar.common.util.gson;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.craftigames.polar.common.util.gson.datatree.DataTree;
/*     */ import net.craftigames.polar.common.util.gson.typeadapters.GsonSerializableAdapterFactory;
/*     */ import net.craftigames.polar.common.util.gson.typeadapters.JsonElementTreeSerializer;
/*     */ 
/*     */ public final class GsonProvider {
/*  19 */   private static final Gson STANDARD_GSON = (new GsonBuilder())
/*  20 */     .registerTypeHierarchyAdapter(DataTree.class, JsonElementTreeSerializer.INSTANCE)
/*  21 */     .registerTypeAdapterFactory((TypeAdapterFactory)GsonSerializableAdapterFactory.INSTANCE)
/*  22 */     .serializeNulls()
/*  23 */     .disableHtmlEscaping()
/*  24 */     .create();
/*     */   
/*  26 */   private static final Gson PRETTY_PRINT_GSON = (new GsonBuilder())
/*  27 */     .registerTypeHierarchyAdapter(DataTree.class, JsonElementTreeSerializer.INSTANCE)
/*  28 */     .registerTypeAdapterFactory((TypeAdapterFactory)GsonSerializableAdapterFactory.INSTANCE)
/*  29 */     .serializeNulls()
/*  30 */     .disableHtmlEscaping()
/*  31 */     .setPrettyPrinting()
/*  32 */     .create();
/*     */   
/*  34 */   private static final JsonParser PARSER = new JsonParser();
/*     */   
/*     */   private GsonProvider() {
/*  37 */     throw new UnsupportedOperationException("This class cannot be instantiated");
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static Gson standard() {
/*  42 */     return STANDARD_GSON;
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static Gson prettyPrinting() {
/*  47 */     return PRETTY_PRINT_GSON;
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonParser parser() {
/*  52 */     return PARSER;
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonElement readElement(@Nonnull Reader reader) {
/*  57 */     return PARSER.parse(reader);
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonElement readElement(@Nonnull InputStream reader) {
/*  62 */     return readElement(new InputStreamReader(reader));
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonElement readElement(@Nonnull String s) {
/*  67 */     return PARSER.parse(s);
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonObject readObject(@Nonnull Reader reader) {
/*  72 */     return PARSER.parse(reader).getAsJsonObject();
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static JsonObject readObject(@Nonnull String s) {
/*  77 */     return PARSER.parse(s).getAsJsonObject();
/*     */   }
/*     */   
/*     */   public static void writeObject(@Nonnull Appendable writer, @Nonnull JsonObject object) {
/*  81 */     standard().toJson((JsonElement)object, writer);
/*     */   }
/*     */   
/*     */   public static void writeObjectPretty(@Nonnull Appendable writer, @Nonnull JsonObject object) {
/*  85 */     prettyPrinting().toJson((JsonElement)object, writer);
/*     */   }
/*     */   
/*     */   public static void writeElement(@Nonnull Appendable writer, @Nonnull JsonElement element) {
/*  89 */     standard().toJson(element, writer);
/*     */   }
/*     */   
/*     */   public static void writeElementPretty(@Nonnull Appendable writer, @Nonnull JsonElement element) {
/*  93 */     prettyPrinting().toJson(element, writer);
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static String toString(@Nonnull JsonElement element) {
/*  98 */     return Objects.<String>requireNonNull(standard().toJson(element));
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public static String toStringPretty(@Nonnull JsonElement element) {
/* 103 */     return Objects.<String>requireNonNull(prettyPrinting().toJson(element));
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   @Deprecated
/*     */   public static Gson get() {
/* 109 */     return standard();
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   @Deprecated
/*     */   public static Gson getPrettyPrinting() {
/* 115 */     return prettyPrinting();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\GsonProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */