/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
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
/*     */ public class LocaleUtils
/*     */ {
/*     */   static class SyncAvoid
/*     */   {
/*     */     private static final List<Locale> AVAILABLE_LOCALE_LIST;
/*     */     private static final Set<Locale> AVAILABLE_LOCALE_SET;
/*     */     
/*     */     static {
/*  48 */       List<Locale> list = new ArrayList<>(Arrays.asList(Locale.getAvailableLocales()));
/*  49 */       AVAILABLE_LOCALE_LIST = Collections.unmodifiableList(list);
/*  50 */       AVAILABLE_LOCALE_SET = Collections.unmodifiableSet(new HashSet<>(list));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  55 */   private static final ConcurrentMap<String, List<Locale>> cLanguagesByCountry = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */   
/*  59 */   private static final ConcurrentMap<String, List<Locale>> cCountriesByLanguage = new ConcurrentHashMap<>();
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
/*     */   public static List<Locale> availableLocaleList() {
/*  72 */     return SyncAvoid.AVAILABLE_LOCALE_LIST;
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
/*     */   public static Set<Locale> availableLocaleSet() {
/*  85 */     return SyncAvoid.AVAILABLE_LOCALE_SET;
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
/*     */   public static List<Locale> countriesByLanguage(String languageCode) {
/*  98 */     if (languageCode == null) {
/*  99 */       return Collections.emptyList();
/*     */     }
/* 101 */     List<Locale> countries = cCountriesByLanguage.get(languageCode);
/* 102 */     if (countries == null) {
/* 103 */       countries = new ArrayList<>();
/* 104 */       List<Locale> locales = availableLocaleList();
/* 105 */       for (Locale locale : locales) {
/* 106 */         if (languageCode.equals(locale.getLanguage()) && 
/* 107 */           !locale.getCountry().isEmpty() && locale
/* 108 */           .getVariant().isEmpty()) {
/* 109 */           countries.add(locale);
/*     */         }
/*     */       } 
/* 112 */       countries = Collections.unmodifiableList(countries);
/* 113 */       cCountriesByLanguage.putIfAbsent(languageCode, countries);
/* 114 */       countries = cCountriesByLanguage.get(languageCode);
/*     */     } 
/* 116 */     return countries;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isAvailableLocale(Locale locale) {
/* 126 */     return availableLocaleList().contains(locale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isISO3166CountryCode(String str) {
/* 136 */     return (StringUtils.isAllUpperCase(str) && str.length() == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isISO639LanguageCode(String str) {
/* 146 */     return (StringUtils.isAllLowerCase(str) && (str.length() == 2 || str.length() == 3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isNumericAreaCode(String str) {
/* 156 */     return (StringUtils.isNumeric(str) && str.length() == 3);
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
/*     */   public static List<Locale> languagesByCountry(String countryCode) {
/* 169 */     if (countryCode == null) {
/* 170 */       return Collections.emptyList();
/*     */     }
/* 172 */     List<Locale> langs = cLanguagesByCountry.get(countryCode);
/* 173 */     if (langs == null) {
/* 174 */       langs = new ArrayList<>();
/* 175 */       List<Locale> locales = availableLocaleList();
/* 176 */       for (Locale locale : locales) {
/* 177 */         if (countryCode.equals(locale.getCountry()) && locale
/* 178 */           .getVariant().isEmpty()) {
/* 179 */           langs.add(locale);
/*     */         }
/*     */       } 
/* 182 */       langs = Collections.unmodifiableList(langs);
/* 183 */       cLanguagesByCountry.putIfAbsent(countryCode, langs);
/* 184 */       langs = cLanguagesByCountry.get(countryCode);
/*     */     } 
/* 186 */     return langs;
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
/*     */   public static List<Locale> localeLookupList(Locale locale) {
/* 202 */     return localeLookupList(locale, locale);
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
/*     */   public static List<Locale> localeLookupList(Locale locale, Locale defaultLocale) {
/* 223 */     List<Locale> list = new ArrayList<>(4);
/* 224 */     if (locale != null) {
/* 225 */       list.add(locale);
/* 226 */       if (!locale.getVariant().isEmpty()) {
/* 227 */         list.add(new Locale(locale.getLanguage(), locale.getCountry()));
/*     */       }
/* 229 */       if (!locale.getCountry().isEmpty()) {
/* 230 */         list.add(new Locale(locale.getLanguage(), ""));
/*     */       }
/* 232 */       if (!list.contains(defaultLocale)) {
/* 233 */         list.add(defaultLocale);
/*     */       }
/*     */     } 
/* 236 */     return Collections.unmodifiableList(list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Locale parseLocale(String str) {
/* 247 */     if (isISO639LanguageCode(str)) {
/* 248 */       return new Locale(str);
/*     */     }
/*     */     
/* 251 */     String[] segments = str.split("_", -1);
/* 252 */     String language = segments[0];
/* 253 */     if (segments.length == 2) {
/* 254 */       String country = segments[1];
/* 255 */       if ((isISO639LanguageCode(language) && isISO3166CountryCode(country)) || 
/* 256 */         isNumericAreaCode(country)) {
/* 257 */         return new Locale(language, country);
/*     */       }
/* 259 */     } else if (segments.length == 3) {
/* 260 */       String country = segments[1];
/* 261 */       String variant = segments[2];
/* 262 */       if (isISO639LanguageCode(language) && (country
/* 263 */         .isEmpty() || isISO3166CountryCode(country) || isNumericAreaCode(country)) && 
/* 264 */         !variant.isEmpty()) {
/* 265 */         return new Locale(language, country, variant);
/*     */       }
/*     */     } 
/* 268 */     throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Locale toLocale(Locale locale) {
/* 279 */     return (locale != null) ? locale : Locale.getDefault();
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
/*     */   
/*     */   public static Locale toLocale(String str) {
/* 313 */     if (str == null) {
/* 314 */       return null;
/*     */     }
/* 316 */     if (str.isEmpty()) {
/* 317 */       return new Locale("", "");
/*     */     }
/* 319 */     if (str.contains("#")) {
/* 320 */       throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */     }
/* 322 */     int len = str.length();
/* 323 */     if (len < 2) {
/* 324 */       throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */     }
/* 326 */     char ch0 = str.charAt(0);
/* 327 */     if (ch0 == '_') {
/* 328 */       if (len < 3) {
/* 329 */         throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */       }
/* 331 */       char ch1 = str.charAt(1);
/* 332 */       char ch2 = str.charAt(2);
/* 333 */       if (!Character.isUpperCase(ch1) || !Character.isUpperCase(ch2)) {
/* 334 */         throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */       }
/* 336 */       if (len == 3) {
/* 337 */         return new Locale("", str.substring(1, 3));
/*     */       }
/* 339 */       if (len < 5) {
/* 340 */         throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */       }
/* 342 */       if (str.charAt(3) != '_') {
/* 343 */         throw new IllegalArgumentException("Invalid locale format: " + str);
/*     */       }
/* 345 */       return new Locale("", str.substring(1, 3), str.substring(4));
/*     */     } 
/*     */     
/* 348 */     return parseLocale(str);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\LocaleUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */