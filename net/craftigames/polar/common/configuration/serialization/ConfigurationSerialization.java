/*     */ package net.craftigames.polar.common.configuration.serialization;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigurationSerialization
/*     */ {
/*     */   public static final String SERIALIZED_TYPE_KEY = "==";
/*     */   private final Class<? extends ConfigurationSerializable> clazz;
/*  21 */   private static final Map<String, Class<? extends ConfigurationSerializable>> aliases = new HashMap<>();
/*     */   
/*     */   protected ConfigurationSerialization(Class<? extends ConfigurationSerializable> clazz) {
/*  24 */     this.clazz = clazz;
/*     */   }
/*     */   
/*     */   protected Method getMethod(String name, boolean isStatic) {
/*     */     try {
/*  29 */       Method method = this.clazz.getDeclaredMethod(name, new Class[] { Map.class });
/*     */       
/*  31 */       if (!ConfigurationSerializable.class.isAssignableFrom(method.getReturnType())) {
/*  32 */         return null;
/*     */       }
/*  34 */       if (Modifier.isStatic(method.getModifiers()) != isStatic) {
/*  35 */         return null;
/*     */       }
/*     */       
/*  38 */       return method;
/*  39 */     } catch (NoSuchMethodException ex) {
/*  40 */       return null;
/*  41 */     } catch (SecurityException ex) {
/*  42 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected Constructor<? extends ConfigurationSerializable> getConstructor() {
/*     */     try {
/*  48 */       return this.clazz.getConstructor(new Class[] { Map.class });
/*  49 */     } catch (NoSuchMethodException ex) {
/*  50 */       return null;
/*  51 */     } catch (SecurityException ex) {
/*  52 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected ConfigurationSerializable deserializeViaMethod(Method method, Map<String, ?> args) {
/*     */     try {
/*  58 */       ConfigurationSerializable result = (ConfigurationSerializable)method.invoke(null, new Object[] { args });
/*     */       
/*  60 */       if (result == null) {
/*  61 */         Logger.getLogger(ConfigurationSerialization.class.getName()).log(Level.SEVERE, "Could not call method '" + method + "' of " + this.clazz + " for deserialization: method returned null");
/*     */       } else {
/*  63 */         return result;
/*     */       } 
/*  65 */     } catch (Throwable ex) {
/*  66 */       Logger.getLogger(ConfigurationSerialization.class.getName()).log(Level.SEVERE, "Could not call method '" + method
/*     */           
/*  68 */           .toString() + "' of " + this.clazz + " for deserialization", 
/*  69 */           (ex instanceof java.lang.reflect.InvocationTargetException) ? ex.getCause() : ex);
/*     */     } 
/*     */     
/*  72 */     return null;
/*     */   }
/*     */   
/*     */   protected ConfigurationSerializable deserializeViaCtor(Constructor<? extends ConfigurationSerializable> ctor, Map<String, ?> args) {
/*     */     try {
/*  77 */       return ctor.newInstance(new Object[] { args });
/*  78 */     } catch (Throwable ex) {
/*  79 */       Logger.getLogger(ConfigurationSerialization.class.getName()).log(Level.SEVERE, "Could not call constructor '" + ctor
/*     */           
/*  81 */           .toString() + "' of " + this.clazz + " for deserialization", 
/*  82 */           (ex instanceof java.lang.reflect.InvocationTargetException) ? ex.getCause() : ex);
/*     */ 
/*     */       
/*  85 */       return null;
/*     */     } 
/*     */   }
/*     */   public ConfigurationSerializable deserialize(Map<String, ?> args) {
/*  89 */     Validate.notNull(args, "Args must not be null", new Object[0]);
/*     */     
/*  91 */     ConfigurationSerializable result = null;
/*  92 */     Method method = null;
/*     */     
/*  94 */     if (result == null) {
/*  95 */       method = getMethod("deserialize", true);
/*     */       
/*  97 */       if (method != null) {
/*  98 */         result = deserializeViaMethod(method, args);
/*     */       }
/*     */     } 
/*     */     
/* 102 */     if (result == null) {
/* 103 */       method = getMethod("valueOf", true);
/*     */       
/* 105 */       if (method != null) {
/* 106 */         result = deserializeViaMethod(method, args);
/*     */       }
/*     */     } 
/*     */     
/* 110 */     if (result == null) {
/* 111 */       Constructor<? extends ConfigurationSerializable> constructor = getConstructor();
/*     */       
/* 113 */       if (constructor != null) {
/* 114 */         result = deserializeViaCtor(constructor, args);
/*     */       }
/*     */     } 
/*     */     
/* 118 */     return result;
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
/*     */   public static ConfigurationSerializable deserializeObject(Map<String, ?> args, Class<? extends ConfigurationSerializable> clazz) {
/* 137 */     return (new ConfigurationSerialization(clazz)).deserialize(args);
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
/*     */   public static ConfigurationSerializable deserializeObject(Map<String, ?> args) {
/* 155 */     Class<? extends ConfigurationSerializable> clazz = null;
/*     */     
/* 157 */     if (args.containsKey("==")) {
/*     */       try {
/* 159 */         String alias = (String)args.get("==");
/*     */         
/* 161 */         if (alias == null) {
/* 162 */           throw new IllegalArgumentException("Cannot have null alias");
/*     */         }
/* 164 */         clazz = getClassByAlias(alias);
/* 165 */         if (clazz == null) {
/* 166 */           throw new IllegalArgumentException("Specified class does not exist ('" + alias + "')");
/*     */         }
/* 168 */       } catch (ClassCastException ex) {
/* 169 */         ex.fillInStackTrace();
/* 170 */         throw ex;
/*     */       } 
/*     */     } else {
/* 173 */       throw new IllegalArgumentException("Args doesn't contain type key ('==')");
/*     */     } 
/*     */     
/* 176 */     return (new ConfigurationSerialization(clazz)).deserialize(args);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerClass(Class<? extends ConfigurationSerializable> clazz) {
/* 186 */     DelegateDeserialization delegate = clazz.<DelegateDeserialization>getAnnotation(DelegateDeserialization.class);
/*     */     
/* 188 */     if (delegate == null) {
/* 189 */       registerClass(clazz, getAlias(clazz));
/* 190 */       registerClass(clazz, clazz.getName());
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
/*     */   public static void registerClass(Class<? extends ConfigurationSerializable> clazz, String alias) {
/* 203 */     aliases.put(alias, clazz);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregisterClass(String alias) {
/* 212 */     aliases.remove(alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregisterClass(Class<? extends ConfigurationSerializable> clazz) {
/* 222 */     while (aliases.values().remove(clazz));
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
/*     */   public static Class<? extends ConfigurationSerializable> getClassByAlias(String alias) {
/* 234 */     return aliases.get(alias);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getAlias(Class<? extends ConfigurationSerializable> clazz) {
/* 245 */     DelegateDeserialization delegate = clazz.<DelegateDeserialization>getAnnotation(DelegateDeserialization.class);
/*     */     
/* 247 */     if (delegate != null) {
/* 248 */       if (delegate.value() == null || delegate.value() == clazz) {
/* 249 */         delegate = null;
/*     */       } else {
/* 251 */         return getAlias(delegate.value());
/*     */       } 
/*     */     }
/*     */     
/* 255 */     if (delegate == null) {
/* 256 */       SerializableAs alias = clazz.<SerializableAs>getAnnotation(SerializableAs.class);
/*     */       
/* 258 */       if (alias != null && alias.value() != null) {
/* 259 */         return alias.value();
/*     */       }
/*     */     } 
/*     */     
/* 263 */     return clazz.getName();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\serialization\ConfigurationSerialization.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */