/*     */ package net.craftigames.polar.common.util.gson;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.function.Function;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface GsonSerializable
/*     */ {
/*     */   @Nonnull
/*     */   static <T extends GsonSerializable> T deserialize(@Nonnull Class<T> clazz, @Nonnull JsonElement element) {
/*  32 */     Method deserializeMethod = getDeserializeMethod(clazz);
/*  33 */     if (deserializeMethod == null) {
/*  34 */       throw new IllegalStateException("Class does not have a deserialize method accessible.");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  39 */       return (T)deserializeMethod.invoke(null, new Object[] { element });
/*  40 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException e) {
/*  41 */       throw new RuntimeException(e);
/*     */     } 
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
/*     */   @Nonnull
/*     */   static GsonSerializable deserializeRaw(@Nonnull Class<?> clazz, @Nonnull JsonElement element) {
/*  55 */     Class<? extends GsonSerializable> typeCastedClass = clazz.asSubclass(GsonSerializable.class);
/*  56 */     return deserialize((Class)typeCastedClass, element);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   static Method getDeserializeMethod(@Nonnull Class<?> clazz) {
/*     */     Method deserializeMethod;
/*  67 */     if (!GsonSerializable.class.isAssignableFrom(clazz)) {
/*  68 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  74 */       deserializeMethod = clazz.getDeclaredMethod("deserialize", new Class[] { JsonElement.class });
/*  75 */       deserializeMethod.setAccessible(true);
/*  76 */     } catch (Exception e) {
/*  77 */       return null;
/*     */     } 
/*     */     
/*  80 */     if (!Modifier.isStatic(deserializeMethod.getModifiers())) {
/*  81 */       return null;
/*     */     }
/*     */     
/*  84 */     return deserializeMethod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   JsonElement serialize();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> T getOrDefault(JsonObject object, String field, Function<JsonElement, T> function, T defaultValue) {
/*  97 */     if (object.has(field) && !object.get(field).isJsonNull()) {
/*  98 */       return function.apply(object.get(field));
/*     */     }
/* 100 */     return defaultValue;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\gson\GsonSerializable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */