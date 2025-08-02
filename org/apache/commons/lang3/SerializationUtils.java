/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializationUtils
/*     */ {
/*     */   static class ClassLoaderAwareObjectInputStream
/*     */     extends ObjectInputStream
/*     */   {
/*  63 */     private static final Map<String, Class<?>> primitiveTypes = new HashMap<>();
/*     */     private final ClassLoader classLoader;
/*     */     
/*     */     static {
/*  67 */       primitiveTypes.put("byte", byte.class);
/*  68 */       primitiveTypes.put("short", short.class);
/*  69 */       primitiveTypes.put("int", int.class);
/*  70 */       primitiveTypes.put("long", long.class);
/*  71 */       primitiveTypes.put("float", float.class);
/*  72 */       primitiveTypes.put("double", double.class);
/*  73 */       primitiveTypes.put("boolean", boolean.class);
/*  74 */       primitiveTypes.put("char", char.class);
/*  75 */       primitiveTypes.put("void", void.class);
/*     */     }
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
/*     */     ClassLoaderAwareObjectInputStream(InputStream in, ClassLoader classLoader) throws IOException {
/*  88 */       super(in);
/*  89 */       this.classLoader = classLoader;
/*     */     }
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
/*     */     protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
/* 102 */       String name = desc.getName();
/*     */       try {
/* 104 */         return Class.forName(name, false, this.classLoader);
/* 105 */       } catch (ClassNotFoundException ex) {
/*     */         try {
/* 107 */           return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
/* 108 */         } catch (ClassNotFoundException cnfe) {
/* 109 */           Class<?> cls = primitiveTypes.get(name);
/* 110 */           if (cls != null) {
/* 111 */             return cls;
/*     */           }
/* 113 */           throw cnfe;
/*     */         } 
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Serializable> T clone(T object) {
/* 135 */     if (object == null) {
/* 136 */       return null;
/*     */     }
/* 138 */     byte[] objectData = serialize((Serializable)object);
/* 139 */     ByteArrayInputStream bais = new ByteArrayInputStream(objectData);
/*     */     
/* 141 */     try (ClassLoaderAwareObjectInputStream in = new ClassLoaderAwareObjectInputStream(bais, object
/* 142 */           .getClass().getClassLoader())) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 149 */       Serializable serializable = (Serializable)in.readObject();
/* 150 */       return (T)serializable;
/*     */     }
/* 152 */     catch (ClassNotFoundException ex) {
/* 153 */       throw new SerializationException("ClassNotFoundException while reading cloned object data", ex);
/* 154 */     } catch (IOException ex) {
/* 155 */       throw new SerializationException("IOException while reading or closing cloned object data", ex);
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
/*     */   public static <T> T deserialize(byte[] objectData) {
/* 178 */     Validate.notNull(objectData, "objectData", new Object[0]);
/* 179 */     return deserialize(new ByteArrayInputStream(objectData));
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
/*     */   public static <T> T deserialize(InputStream inputStream) {
/* 212 */     Validate.notNull(inputStream, "inputStream", new Object[0]);
/* 213 */     try (ObjectInputStream in = new ObjectInputStream(inputStream)) {
/*     */       
/* 215 */       T obj = (T)in.readObject();
/* 216 */       return obj;
/* 217 */     } catch (ClassNotFoundException|IOException ex) {
/* 218 */       throw new SerializationException(ex);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Serializable> T roundtrip(T obj) {
/* 235 */     return (T)deserialize(serialize((Serializable)obj));
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
/*     */   public static byte[] serialize(Serializable obj) {
/* 247 */     ByteArrayOutputStream baos = new ByteArrayOutputStream(512);
/* 248 */     serialize(obj, baos);
/* 249 */     return baos.toByteArray();
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void serialize(Serializable obj, OutputStream outputStream) {
/* 269 */     Validate.notNull(outputStream, "outputStream", new Object[0]);
/* 270 */     try (ObjectOutputStream out = new ObjectOutputStream(outputStream)) {
/* 271 */       out.writeObject(obj);
/* 272 */     } catch (IOException ex) {
/* 273 */       throw new SerializationException(ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\SerializationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */