/*     */ package net.craftigames.polar.common.messages;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*     */ import net.craftigames.polar.common.util.ClassUtils;
/*     */ import net.craftigames.polar.common.util.exception.MessageNotFoundException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class MessagingRegister {
/*  18 */   public static final Logger LOGGER = LoggerFactory.getLogger(MessagingRegister.class);
/*     */   
/*  20 */   private static final Map<String, Class<? extends Message>> PACKETS = new HashMap<>();
/*  21 */   private static final Map<Class<? extends Message>, String> IDS = new HashMap<>();
/*  22 */   private static final Map<Class<? extends Message>, String> NAMES = new HashMap<>();
/*  23 */   private static final Set<Class<? extends Message>> MESSAGE_MESSAGES = new HashSet<>();
/*     */ 
/*     */   
/*     */   @Deprecated
/*  27 */   private static final Map<Integer, Class<? extends Message>> PACKETS_LEGACY = new HashMap<>();
/*     */   @Deprecated
/*  29 */   private static final Map<Class<? extends Message>, Integer> IDS_LEGACY = new HashMap<>();
/*     */   
/*     */   static {
/*     */     try {
/*  33 */       String packageName = "net.craftigames.polar.common.messages.collection";
/*  34 */       List<Class<? extends Message>> packets = new ArrayList<>();
/*     */       
/*  36 */       String dir = "/" + packageName.replace(".", "/");
/*  37 */       for (String resourceFile : ClassUtils.getResourceFiles(dir)) {
/*     */         try {
/*  39 */           if (resourceFile.isEmpty() || resourceFile.contains("$")) {
/*     */             continue;
/*     */           }
/*     */           
/*  43 */           resourceFile = resourceFile.replace("/", ".");
/*  44 */           resourceFile = resourceFile.substring(1, resourceFile.length() - ".class".length());
/*     */           
/*  46 */           if (!resourceFile.startsWith(packageName)) {
/*     */             continue;
/*     */           }
/*     */           
/*  50 */           Class<?> clazz = Class.forName(resourceFile);
/*  51 */           if (Message.class.isAssignableFrom(clazz) && clazz.getAnnotation(MessageIdentifier.class) != null) {
/*  52 */             packets.add(clazz);
/*     */           }
/*  54 */         } catch (Throwable t) {
/*  55 */           LOGGER.error("Failed to load packet class: " + resourceFile, t);
/*     */         } 
/*     */       } 
/*     */       
/*  59 */       for (Class<? extends Message> aClass : packets) {
/*  60 */         String name = aClass.getSimpleName().toLowerCase(Locale.ROOT);
/*  61 */         if (name.toLowerCase().startsWith("message")) {
/*  62 */           name = name.substring("Message".length());
/*     */         }
/*     */         try {
/*  65 */           register(name, aClass);
/*  66 */         } catch (Throwable t) {
/*  67 */           t.printStackTrace();
/*     */         } 
/*     */       } 
/*  70 */     } catch (IOException e) {
/*  71 */       LOGGER.error("Failure during message registering", e);
/*  72 */       e.printStackTrace();
/*  73 */     } catch (Throwable t) {
/*  74 */       LOGGER.error("Failure during static initialization", t);
/*  75 */       throw t;
/*     */     } finally {
/*  77 */       MESSAGE_MESSAGES.add(MessageSendMemberMessage.class);
/*  78 */       MESSAGE_MESSAGES.add(MessageSendMemberComponentMessage.class);
/*     */       
/*  80 */       LOGGER.info("Registering " + PACKETS.size() + " packets.");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void register(String id, Class<? extends Message> message) {
/*  86 */     if (PACKETS.containsKey(id)) {
/*  87 */       throw new IllegalArgumentException("Message with ID " + id + " already registered");
/*     */     }
/*  89 */     if (IDS.containsKey(message)) {
/*  90 */       throw new IllegalArgumentException("Message " + message + " already registered");
/*     */     }
/*     */     
/*  93 */     PACKETS.put(id, message);
/*  94 */     IDS.put(message, id);
/*     */     
/*  96 */     MessageIdentifier identifier = message.<MessageIdentifier>getAnnotation(MessageIdentifier.class);
/*  97 */     if (identifier != null && identifier.legacyId() != -1) {
/*  98 */       PACKETS_LEGACY.put(Integer.valueOf(identifier.legacyId()), message);
/*  99 */       IDS_LEGACY.put(message, Integer.valueOf(identifier.legacyId()));
/*     */     } 
/*     */     
/* 102 */     NAMES.put(message, message.getSimpleName());
/*     */   }
/*     */   
/*     */   public static Message createInstance(String id) {
/*     */     try {
/* 107 */       Class<? extends Message> p = PACKETS.get(id);
/* 108 */       if (p == null) {
/* 109 */         throw new MessageNotFoundException("Unknown message ID " + id);
/*     */       }
/*     */       
/* 112 */       Constructor<? extends Message> s = p.getDeclaredConstructor(new Class[0]);
/* 113 */       s.setAccessible(true);
/*     */       
/* 115 */       return s.newInstance(new Object[0]);
/* 116 */     } catch (NoSuchMethodException|SecurityException|InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException e) {
/* 117 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getId(Message packet) {
/* 122 */     if (packet == null) {
/* 123 */       throw new IllegalArgumentException("Packet may not be null");
/*     */     }
/*     */     
/* 126 */     String id = IDS.get(packet.getClass());
/* 127 */     if (id == null) {
/* 128 */       register(packet);
/* 129 */       id = IDS.get(packet.getClass());
/* 130 */       if (id == null) {
/* 131 */         throw new MessageNotFoundException("Unknown message ID " + packet.getClass().getName());
/*     */       }
/*     */     } 
/* 134 */     return id;
/*     */   }
/*     */   public static String getName(Message packet) {
/* 137 */     if (packet == null) {
/* 138 */       throw new IllegalArgumentException("Packet may not be null");
/*     */     }
/*     */     
/* 141 */     String name = NAMES.get(packet.getClass());
/* 142 */     if (name == null) {
/* 143 */       register(packet);
/* 144 */       name = NAMES.get(packet.getClass());
/* 145 */       if (name == null) {
/* 146 */         throw new MessageNotFoundException("Unknown message name " + packet.getClass().getName());
/*     */       }
/*     */     } 
/* 149 */     return name;
/*     */   }
/*     */   
/*     */   private static void register(Message packet) {
/* 153 */     Class<? extends Message> clazz = (Class)packet.getClass();
/* 154 */     String name = clazz.getSimpleName().toLowerCase(Locale.ROOT);
/* 155 */     if (name.toLowerCase().startsWith("message")) {
/* 156 */       name = name.substring("Message".length());
/*     */     }
/*     */     
/* 159 */     register(name, clazz);
/*     */   }
/*     */   
/*     */   public static <T extends Message> boolean isMessagePacket(T clazz) {
/* 163 */     for (Class<? extends Message> classes : MESSAGE_MESSAGES) {
/* 164 */       if (classes.isInstance(clazz)) {
/* 165 */         return true;
/*     */       }
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */   
/*     */   public static Collection<Class<? extends Message>> getMessageClasses() {
/* 172 */     return new HashSet<>(PACKETS.values());
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Message createInstanceLegacy(int id) {
/*     */     try {
/* 179 */       Class<? extends Message> p = PACKETS_LEGACY.get(Integer.valueOf(id));
/* 180 */       if (p == null) {
/* 181 */         throw new MessageNotFoundException("Unknown message ID " + id);
/*     */       }
/*     */       
/* 184 */       Constructor<? extends Message> s = p.getDeclaredConstructor(new Class[0]);
/* 185 */       s.setAccessible(true);
/*     */       
/* 187 */       return s.newInstance(new Object[0]);
/* 188 */     } catch (NoSuchMethodException|SecurityException|InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException e) {
/* 189 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public static int getIdLegacy(Message packet) {
/* 195 */     if (packet == null) {
/* 196 */       throw new IllegalArgumentException("Packet may not be null");
/*     */     }
/*     */     
/* 199 */     Integer id = IDS_LEGACY.get(packet.getClass());
/* 200 */     if (id == null) {
/* 201 */       return -1;
/*     */     }
/*     */     
/* 204 */     return id.intValue();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\MessagingRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */