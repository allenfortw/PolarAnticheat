/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.Format;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import org.apache.commons.lang3.LocaleUtils;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ abstract class FormatCache<F extends Format>
/*     */ {
/*     */   static final int NONE = -1;
/*  44 */   private final ConcurrentMap<ArrayKey, F> cInstanceCache = new ConcurrentHashMap<>(7);
/*     */   
/*  46 */   private static final ConcurrentMap<ArrayKey, String> cDateTimeInstanceCache = new ConcurrentHashMap<>(7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public F getInstance() {
/*  55 */     return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
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
/*     */   public F getInstance(String pattern, TimeZone timeZone, Locale locale) {
/*  71 */     Validate.notNull(pattern, "pattern", new Object[0]);
/*  72 */     if (timeZone == null) {
/*  73 */       timeZone = TimeZone.getDefault();
/*     */     }
/*  75 */     locale = LocaleUtils.toLocale(locale);
/*  76 */     ArrayKey key = new ArrayKey(new Object[] { pattern, timeZone, locale });
/*  77 */     Format format = (Format)this.cInstanceCache.get(key);
/*  78 */     if (format == null) {
/*  79 */       format = (Format)createInstance(pattern, timeZone, locale);
/*  80 */       Format format1 = (Format)this.cInstanceCache.putIfAbsent(key, (F)format);
/*  81 */       if (format1 != null)
/*     */       {
/*     */         
/*  84 */         format = format1;
/*     */       }
/*     */     } 
/*  87 */     return (F)format;
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
/*     */   protected abstract F createInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale);
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
/*     */   private F getDateTimeInstance(Integer dateStyle, Integer timeStyle, TimeZone timeZone, Locale locale) {
/* 118 */     locale = LocaleUtils.toLocale(locale);
/* 119 */     String pattern = getPatternForStyle(dateStyle, timeStyle, locale);
/* 120 */     return getInstance(pattern, timeZone, locale);
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
/*     */   F getDateTimeInstance(int dateStyle, int timeStyle, TimeZone timeZone, Locale locale) {
/* 138 */     return getDateTimeInstance(Integer.valueOf(dateStyle), Integer.valueOf(timeStyle), timeZone, locale);
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
/*     */   F getDateInstance(int dateStyle, TimeZone timeZone, Locale locale) {
/* 155 */     return getDateTimeInstance(Integer.valueOf(dateStyle), (Integer)null, timeZone, locale);
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
/*     */   F getTimeInstance(int timeStyle, TimeZone timeZone, Locale locale) {
/* 172 */     return getDateTimeInstance((Integer)null, Integer.valueOf(timeStyle), timeZone, locale);
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
/*     */   static String getPatternForStyle(Integer dateStyle, Integer timeStyle, Locale locale) {
/* 186 */     Locale safeLocale = LocaleUtils.toLocale(locale);
/* 187 */     ArrayKey key = new ArrayKey(new Object[] { dateStyle, timeStyle, safeLocale });
/*     */     
/* 189 */     String pattern = cDateTimeInstanceCache.get(key);
/* 190 */     if (pattern == null) {
/*     */       try {
/*     */         DateFormat formatter;
/* 193 */         if (dateStyle == null) {
/* 194 */           formatter = DateFormat.getTimeInstance(timeStyle.intValue(), safeLocale);
/* 195 */         } else if (timeStyle == null) {
/* 196 */           formatter = DateFormat.getDateInstance(dateStyle.intValue(), safeLocale);
/*     */         } else {
/* 198 */           formatter = DateFormat.getDateTimeInstance(dateStyle.intValue(), timeStyle.intValue(), safeLocale);
/*     */         } 
/* 200 */         pattern = ((SimpleDateFormat)formatter).toPattern();
/* 201 */         String previous = cDateTimeInstanceCache.putIfAbsent(key, pattern);
/* 202 */         if (previous != null)
/*     */         {
/*     */ 
/*     */           
/* 206 */           pattern = previous;
/*     */         }
/* 208 */       } catch (ClassCastException ex) {
/* 209 */         throw new IllegalArgumentException("No date time pattern for locale: " + safeLocale);
/*     */       } 
/*     */     }
/* 212 */     return pattern;
/*     */   }
/*     */   
/*     */   private static final class ArrayKey
/*     */   {
/*     */     private final Object[] keys;
/*     */     private final int hashCode;
/*     */     
/*     */     private static int computeHashCode(Object[] keys) {
/* 221 */       int prime = 31;
/* 222 */       int result = 1;
/* 223 */       result = 31 * result + Arrays.hashCode(keys);
/* 224 */       return result;
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
/*     */     ArrayKey(Object... keys) {
/* 236 */       this.keys = keys;
/* 237 */       this.hashCode = computeHashCode(keys);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 242 */       return this.hashCode;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj) {
/* 247 */       if (this == obj) {
/* 248 */         return true;
/*     */       }
/* 250 */       if (obj == null) {
/* 251 */         return false;
/*     */       }
/* 253 */       if (getClass() != obj.getClass()) {
/* 254 */         return false;
/*     */       }
/* 256 */       ArrayKey other = (ArrayKey)obj;
/* 257 */       return Arrays.deepEquals(this.keys, other.keys);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\time\FormatCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */