/*     */ package net.craftigames.polar.common.util;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.text.NumberFormat;
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import net.craftigames.polar.common.messages.Message;
/*     */ import net.craftigames.polar.common.messages.MessageSender;
/*     */ import net.craftigames.polar.common.messages.collection.proxy.MessageSendMembersComponentMessage;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import net.kyori.adventure.text.TextComponent;
/*     */ import net.kyori.adventure.text.TranslatableComponent;
/*     */ import net.kyori.adventure.text.flattener.ComponentFlattener;
/*     */ import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
/*     */ import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
/*     */ import net.kyori.adventure.title.Title;
/*     */ import net.kyori.adventure.translation.GlobalTranslator;
/*     */ import net.kyori.adventure.translation.TranslationRegistry;
/*     */ import net.kyori.adventure.translation.Translator;
/*     */ 
/*     */ public final class TextUtils {
/*  31 */   private static final Pattern LOCALIZATION_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?s");
/*     */   public static final char SECTION_CHAR = '§';
/*  33 */   private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)&[0-9A-FK-OR]");
/*  34 */   public static final ComponentFlattener TRANSLATIONS_FLATTENER = translationsFlattener();
/*     */   
/*  36 */   public static final GsonComponentSerializer GSON_COMPONENT_SERIALIZER = GsonComponentSerializer.builder()
/*  37 */     .build();
/*     */   
/*  39 */   private static final LegacyComponentSerializer AMPERSAND = LegacyComponentSerializer.builder()
/*  40 */     .hexColors()
/*  41 */     .character('&')
/*  42 */     .hexCharacter('#')
/*  43 */     .flattener(TRANSLATIONS_FLATTENER)
/*  44 */     .build();
/*     */   
/*  46 */   private static final LegacyComponentSerializer AMPERSAND_NO_TRANSLATION = LegacyComponentSerializer.builder()
/*  47 */     .hexColors()
/*  48 */     .character('&')
/*  49 */     .hexCharacter('#')
/*  50 */     .build(); private static NumberFormat format;
/*     */   
/*     */   public static String joinNewline(String... strings) {
/*  53 */     return joinNewline(Arrays.stream(strings));
/*     */   }
/*     */   
/*     */   public static String joinNewline(Stream<String> strings) {
/*  57 */     return strings.collect(Collectors.joining("\n"));
/*     */   }
/*     */   
/*     */   public static String toGson(Component component) {
/*  61 */     return (String)GSON_COMPONENT_SERIALIZER.serialize(component);
/*     */   }
/*     */   
/*     */   public static Component fromGson(String input) {
/*  65 */     return GSON_COMPONENT_SERIALIZER.deserialize(input);
/*     */   }
/*     */   
/*     */   public static String toLegacy(Component component) {
/*  69 */     return AMPERSAND.serialize(component);
/*     */   }
/*     */   
/*     */   public static TextComponent fromLegacy(String input) {
/*  73 */     return AMPERSAND.deserialize(input);
/*     */   }
/*     */   
/*     */   public static TextComponent fromLegacyNoTranslations(String input) {
/*  77 */     return AMPERSAND_NO_TRANSLATION.deserialize(input);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String rewritePlaceholders(String input) {
/*  82 */     int i = 0;
/*  83 */     while (input.contains("{}")) {
/*  84 */       input = input.replaceFirst("\\{\\}", "{" + i++ + "}");
/*     */     }
/*  86 */     return input;
/*     */   }
/*     */   
/*     */   public static String stripColor(String input) {
/*  90 */     return (input == null) ? null : STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static Title fromTitle(String input) {
/*  95 */     Gson gson = GsonComponentSerializer.gson().serializer();
/*  96 */     JsonObject object = (JsonObject)gson.fromJson(input, JsonObject.class);
/*  97 */     if (object == null || !object.isJsonObject()) {
/*  98 */       return null;
/*     */     }
/* 100 */     GsonComponentSerializer serializer = GsonComponentSerializer.gson();
/*     */     
/* 102 */     Component title = serializer.deserialize(object.get("title").getAsString());
/* 103 */     Component subtitle = serializer.deserialize(object.get("subtitle").getAsString());
/* 104 */     Title.Times titleTimes = null;
/*     */     
/* 106 */     if (object.has("times")) {
/* 107 */       JsonObject times = object.get("times").getAsJsonObject();
/*     */       
/* 109 */       long fadeIn = times.get("fadeIn").getAsLong();
/* 110 */       long stay = times.get("stay").getAsLong();
/* 111 */       long fadeOut = times.get("fadeOut").getAsLong();
/*     */       
/* 113 */       titleTimes = Title.Times.of(Duration.ofMillis(fadeIn), Duration.ofMillis(stay), Duration.ofMillis(fadeOut));
/*     */     } 
/*     */     
/* 116 */     return Title.title(title, subtitle, titleTimes);
/*     */   }
/*     */   
/*     */   public static String toTitle(Title component) {
/* 120 */     GsonComponentSerializer serializer = GsonComponentSerializer.gson();
/* 121 */     Gson gson = GsonComponentSerializer.gson().serializer();
/*     */     
/* 123 */     JsonObject object = new JsonObject();
/* 124 */     object.addProperty("title", (String)serializer.serialize(component.title().asComponent()));
/* 125 */     object.addProperty("subtitle", (String)serializer.serialize(component.subtitle().asComponent()));
/*     */     
/* 127 */     Title.Times componentTimes = component.times();
/* 128 */     if (componentTimes != null) {
/* 129 */       JsonObject times = new JsonObject();
/* 130 */       times.addProperty("fadeIn", Long.valueOf(componentTimes.fadeIn().toMillis()));
/* 131 */       times.addProperty("stay", Long.valueOf(componentTimes.stay().toMillis()));
/* 132 */       times.addProperty("fadeOut", Long.valueOf(componentTimes.fadeOut().toMillis()));
/*     */       
/* 134 */       object.add("times", (JsonElement)times);
/*     */     } 
/* 136 */     return gson.toJson((JsonElement)object);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String format(Number value) {
/* 142 */     if (format == null) {
/* 143 */       format = NumberFormat.getInstance();
/*     */     }
/* 145 */     return format.format(value);
/*     */   }
/*     */   
/*     */   public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
/* 149 */     char[] b = textToTranslate.toCharArray();
/*     */     
/* 151 */     for (int i = 0; i < b.length - 1; i++) {
/* 152 */       if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
/* 153 */         b[i] = '§';
/* 154 */         b[i + 1] = Character.toLowerCase(b[i + 1]);
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return new String(b);
/*     */   }
/*     */   
/*     */   public static String color(String s) {
/* 162 */     return translateAlternateColorCodes('&', s);
/*     */   }
/*     */   
/*     */   public static List<String> color(List<String> s) {
/* 166 */     List<String> colored = new ArrayList<>(s.size());
/* 167 */     for (String msg : s) {
/* 168 */       colored.add(color(msg));
/*     */     }
/* 170 */     return colored;
/*     */   }
/*     */   
/*     */   public static void sendToAll(MessageSender sender, String s) {
/* 174 */     MessageSendMembersComponentMessage message = new MessageSendMembersComponentMessage();
/* 175 */     message.setMessage((Component)fromLegacy(s));
/* 176 */     sender.sendMessage(new Message[] { (Message)message });
/*     */   }
/*     */   
/*     */   private static ComponentFlattener translationsFlattener() {
/* 180 */     ComponentFlattener.Builder flattenerBuilder = (ComponentFlattener.Builder)ComponentFlattener.basic().toBuilder();
/* 181 */     flattenerBuilder.complexMapper(TranslatableComponent.class, (translatable, consumer) -> {
/*     */           Translator registry;
/*     */           
/*     */           String key = translatable.key();
/*     */           
/*     */           Iterator<? extends Translator> var5 = GlobalTranslator.get().sources().iterator();
/*     */           
/*     */           do {
/*     */             if (!var5.hasNext()) {
/*     */               Matcher matcher = LOCALIZATION_PATTERN.matcher(key);
/*     */               
/*     */               List<Component> args = translatable.args();
/*     */               
/*     */               int argPosition = 0;
/*     */               int lastIdx = 0;
/*     */               while (matcher.find()) {
/*     */                 if (lastIdx < matcher.start()) {
/*     */                   consumer.accept(Component.text(key.substring(lastIdx, matcher.start())));
/*     */                 }
/*     */                 lastIdx = matcher.end();
/*     */                 String argIdx = matcher.group(1);
/*     */                 if (argIdx != null) {
/*     */                   try {
/*     */                     int i = Integer.parseInt(argIdx) - 1;
/*     */                     if (i < args.size()) {
/*     */                       consumer.accept(args.get(i));
/*     */                     }
/* 208 */                   } catch (NumberFormatException numberFormatException) {}
/*     */                   
/*     */                   continue;
/*     */                 } 
/*     */                 
/*     */                 int idx = argPosition++;
/*     */                 
/*     */                 if (idx < args.size()) {
/*     */                   consumer.accept(args.get(idx));
/*     */                 }
/*     */               } 
/*     */               
/*     */               if (lastIdx < key.length()) {
/*     */                 consumer.accept(Component.text(key.substring(lastIdx)));
/*     */               }
/*     */               
/*     */               return;
/*     */             } 
/*     */             registry = var5.next();
/*     */           } while (!(registry instanceof TranslationRegistry) || !((TranslationRegistry)registry).contains(key));
/*     */           consumer.accept(GlobalTranslator.render((Component)translatable, Locale.getDefault()));
/*     */         });
/* 230 */     return (ComponentFlattener)flattenerBuilder.build();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\TextUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */