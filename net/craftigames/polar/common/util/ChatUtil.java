/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ public final class ChatUtil
/*     */ {
/*     */   public static final char COLOR_CHAR = '§';
/*  12 */   private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)§[0-9A-FK-OR]");
/*     */   
/*     */   public static String stripColor(String input) {
/*  15 */     return stripColor(input, false);
/*     */   }
/*     */   private static final int CENTER_PX = 154;
/*     */   public static String ms(Long time) {
/*  19 */     long ns = System.nanoTime() - time.longValue();
/*  20 */     float ms = (float)ns / 1000000.0F;
/*  21 */     return String.format("%.3f", new Object[] { Float.valueOf(ms) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String stripColor(String input, boolean deep) {
/*  29 */     if (input == null) {
/*  30 */       return null;
/*     */     }
/*  32 */     if (deep) {
/*  33 */       int timesReplaced = 0;
/*  34 */       String result = strip(input);
/*     */       
/*  36 */       while (timesReplaced++ <= 50 && (result.contains("&") || result.contains(String.valueOf('§')))) {
/*     */         
/*  38 */         if (result.equals(input)) {
/*  39 */           return input;
/*     */         }
/*  41 */         input = result;
/*  42 */         result = strip(color(input));
/*     */       } 
/*     */       
/*  45 */       return result;
/*     */     } 
/*  47 */     return strip(input);
/*     */   }
/*     */   
/*     */   private static String strip(@Nonnull String string) {
/*  51 */     return STRIP_COLOR_PATTERN.matcher(string).replaceAll("");
/*     */   }
/*     */   
/*     */   public static String color(String input) {
/*  55 */     return translateAlternateColorCodes('&', input);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
/*  60 */     if (textToTranslate.startsWith("⁲")) {
/*  61 */       return textToTranslate.substring(1);
/*     */     }
/*  63 */     char[] b = textToTranslate.toCharArray();
/*     */     
/*  65 */     for (int i = 0; i < b.length - 1; i++) {
/*  66 */       if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
/*  67 */         b[i] = '§';
/*  68 */         b[i + 1] = Character.toLowerCase(b[i + 1]);
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     return new String(b);
/*     */   }
/*     */   
/*     */   public static boolean containsInvalidChars(String string) {
/*  76 */     for (char m : string.toCharArray()) {
/*  77 */       if ((m > '' && m < '§') || m > '§') {
/*  78 */         return true;
/*     */       }
/*     */     } 
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public enum AdvertiseLevel {
/*  85 */     NONE,
/*  86 */     NORMAL,
/*  87 */     SEVERE;
/*     */   }
/*     */   
/*     */   public static AdvertiseLevel isAdvertisement(String message) {
/*  91 */     message = message.toLowerCase();
/*  92 */     String messageNoSpace = message.replace(" ", "");
/*  93 */     if (messageNoSpace.contains("hylex") || messageNoSpace
/*  94 */       .contains("nektax") || messageNoSpace
/*  95 */       .contains("blocksmc") || message
/*  96 */       .contains("blockdrop") || messageNoSpace
/*  97 */       .contains("jartexmcml")) {
/*  98 */       return AdvertiseLevel.SEVERE;
/*     */     }
/*     */     
/* 101 */     message = stripColor(translateAlternateColorCodes('&', message));
/*     */     
/* 103 */     String regexUrl = "(http(s)?:\\/\\/.)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}( ?\\. ?| ?\\(?dot\\)? ?)[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
/* 104 */     String regexIP = "(?:[0-9]{1,3}( ?\\. ?|\\(?dot\\)?)){3}[0-9]{1,3}";
/*     */     
/* 106 */     Pattern patternURL = Pattern.compile(regexUrl);
/* 107 */     Pattern patternIP = Pattern.compile(regexIP);
/*     */     
/* 109 */     Matcher matcherUrl = patternURL.matcher(message);
/* 110 */     if (matcherUrl.find()) {
/* 111 */       return AdvertiseLevel.NORMAL;
/*     */     }
/*     */     
/* 114 */     Matcher matcherIp = patternIP.matcher(message);
/* 115 */     if (matcherIp.find()) {
/* 116 */       return AdvertiseLevel.NORMAL;
/*     */     }
/*     */     
/* 119 */     message = message.toLowerCase().replace(" ", "").trim();
/* 120 */     if (message.contains(".,ml") || message.contains(",,ml") || message.contains("..ml") || message.contains(",.ml")) {
/* 121 */       return AdvertiseLevel.SEVERE;
/*     */     }
/*     */     
/* 124 */     if (message.contains("jartex") || message.contains("hypixel") || message.contains("herobrine") || message.contains("hero-brine")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 129 */       String copy = message.replace(",", "").replace(".", "").replace("!", "").replace("?", "");
/* 130 */       if (copy.contains("jartexga") || copy.contains("jartexmcml") || copy.contains("jartextk") || copy.contains("hypixeltk") || copy.contains("herobrinetk") || copy.contains("hero-brinetk")) {
/* 131 */         return AdvertiseLevel.SEVERE;
/*     */       }
/*     */     } 
/* 134 */     return AdvertiseLevel.NONE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String toCenteredMessage(String message) {
/* 140 */     if (message.isEmpty()) {
/* 141 */       return message;
/*     */     }
/*     */     
/* 144 */     message = translateAlternateColorCodes('&', message);
/*     */     
/* 146 */     int messagePxSize = 0;
/* 147 */     boolean previousCode = false;
/* 148 */     boolean isBold = false;
/*     */     
/* 150 */     for (char c : message.toCharArray()) {
/* 151 */       if (c == '§') {
/* 152 */         previousCode = true;
/* 153 */       } else if (previousCode) {
/* 154 */         previousCode = false;
/* 155 */         isBold = (c == 'l' || c == 'L');
/*     */       } else {
/* 157 */         DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
/* 158 */         messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
/* 159 */         messagePxSize++;
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     int halvedMessageSize = messagePxSize / 2;
/* 164 */     int toCompensate = 154 - halvedMessageSize;
/* 165 */     int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
/* 166 */     int compensated = 0;
/*     */     
/* 168 */     StringBuilder sb = new StringBuilder();
/*     */     
/* 170 */     while (compensated < toCompensate) {
/* 171 */       sb.append(" ");
/* 172 */       compensated += spaceLength;
/*     */     } 
/*     */     
/* 175 */     return sb + message;
/*     */   }
/*     */   
/*     */   public static int getWidth(String message) {
/* 179 */     if (message.isEmpty()) {
/* 180 */       return 0;
/*     */     }
/*     */     
/* 183 */     message = translateAlternateColorCodes('&', message);
/*     */     
/* 185 */     int messagePxSize = 0;
/* 186 */     boolean previousCode = false;
/* 187 */     boolean isBold = false;
/*     */     
/* 189 */     for (char c : message.toCharArray()) {
/* 190 */       if (c == '§') {
/* 191 */         previousCode = true;
/* 192 */       } else if (previousCode) {
/* 193 */         previousCode = false;
/* 194 */         isBold = (c == 'l' || c == 'L');
/*     */       } else {
/* 196 */         DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
/* 197 */         messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
/*     */       } 
/*     */     } 
/*     */     
/* 201 */     return messagePxSize;
/*     */   }
/*     */   
/*     */   public static List<String> combineStringLists(List<String> first, List<String> second, int spacing) {
/* 205 */     int maximumWidth = 0;
/*     */     
/* 207 */     for (String s : first) {
/* 208 */       maximumWidth = Math.max(maximumWidth, getWidth(s));
/*     */     }
/*     */     
/* 211 */     int spaceLength = DefaultFontInfo.SPACE.getLength();
/*     */     
/* 213 */     maximumWidth = NumberConversions.floor(((maximumWidth + spacing * spaceLength) / spaceLength)) * spaceLength;
/*     */     
/* 215 */     List<String> list = new ArrayList<>();
/*     */     
/* 217 */     for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
/* 218 */       if (first.size() > i && second.size() > i) {
/* 219 */         String firstText = first.get(i);
/* 220 */         String secondText = second.get(i);
/*     */         
/* 222 */         int width = getWidth(firstText);
/* 223 */         int leftover = maximumWidth - width;
/*     */         
/* 225 */         StringBuilder builder = new StringBuilder(firstText + "&5&o"); int j;
/* 226 */         for (j = 0; j < leftover; j += spaceLength) {
/* 227 */           builder.append(" ");
/*     */         }
/* 229 */         builder.append(secondText);
/* 230 */         list.add(builder.toString());
/*     */       }
/* 232 */       else if (first.size() > i) {
/* 233 */         list.add(first.get(i));
/*     */       } else {
/* 235 */         StringBuilder builder = new StringBuilder("&5&o");
/* 236 */         if (first.size() > 0) {
/* 237 */           int j; for (j = spaceLength; j < maximumWidth; j += spaceLength) {
/* 238 */             builder.append(" ");
/*     */           }
/*     */         } 
/* 241 */         builder.append(second.get(i));
/* 242 */         list.add(builder.toString());
/*     */       } 
/*     */     } 
/*     */     
/* 246 */     return list;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 250 */     ChatUtil$1.init(); List<String> first = new ArrayList<>();
/* 251 */     first.add("&a&lEnchantments:");
/* 252 */     first.add("&7Bowling Ball 1");
/* 253 */     first.add("&7Acid Rain 5");
/*     */     
/* 255 */     List<String> second = new ArrayList<>();
/* 256 */     second.add("&c&lScrolls:");
/* 257 */     second.add("&7Block Counter 5");
/* 258 */     second.add("&7Block Counter 5");
/* 259 */     second.add("&7Block Counter 5");
/*     */     
/* 261 */     for (String combineStringList : combineStringLists(first, second, 0))
/* 262 */       System.out.println("combineStringList = " + stripColor(color(combineStringList))); 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ChatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */