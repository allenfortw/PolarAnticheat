/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.text.Format;
/*     */ import java.text.MessageFormat;
/*     */ import java.text.ParsePosition;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.lang3.LocaleUtils;
/*     */ import org.apache.commons.lang3.ObjectUtils;
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
/*     */ @Deprecated
/*     */ public class ExtendedMessageFormat
/*     */   extends MessageFormat
/*     */ {
/*     */   private static final long serialVersionUID = -2362048321261811743L;
/*     */   private static final int HASH_SEED = 31;
/*     */   private static final String DUMMY_PATTERN = "";
/*     */   private static final char START_FMT = ',';
/*     */   private static final char END_FE = '}';
/*     */   private static final char START_FE = '{';
/*     */   private static final char QUOTE = '\'';
/*     */   private String toPattern;
/*     */   private final Map<String, ? extends FormatFactory> registry;
/*     */   
/*     */   public ExtendedMessageFormat(String pattern) {
/*  94 */     this(pattern, Locale.getDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String pattern, Locale locale) {
/* 105 */     this(pattern, locale, (Map<String, ? extends FormatFactory>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtendedMessageFormat(String pattern, Map<String, ? extends FormatFactory> registry) {
/* 116 */     this(pattern, Locale.getDefault(), registry);
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
/*     */   public ExtendedMessageFormat(String pattern, Locale locale, Map<String, ? extends FormatFactory> registry) {
/* 128 */     super("");
/* 129 */     setLocale(LocaleUtils.toLocale(locale));
/* 130 */     this.registry = registry;
/* 131 */     applyPattern(pattern);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toPattern() {
/* 139 */     return this.toPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyPattern(String pattern) {
/* 149 */     if (this.registry == null) {
/* 150 */       super.applyPattern(pattern);
/* 151 */       this.toPattern = super.toPattern();
/*     */       return;
/*     */     } 
/* 154 */     ArrayList<Format> foundFormats = new ArrayList<>();
/* 155 */     ArrayList<String> foundDescriptions = new ArrayList<>();
/* 156 */     StringBuilder stripCustom = new StringBuilder(pattern.length());
/*     */     
/* 158 */     ParsePosition pos = new ParsePosition(0);
/* 159 */     char[] c = pattern.toCharArray();
/* 160 */     int fmtCount = 0;
/* 161 */     while (pos.getIndex() < pattern.length()) {
/* 162 */       int start, index; Format format; String formatDescription; switch (c[pos.getIndex()]) {
/*     */         case '\'':
/* 164 */           appendQuotedString(pattern, pos, stripCustom);
/*     */           continue;
/*     */         case '{':
/* 167 */           fmtCount++;
/* 168 */           seekNonWs(pattern, pos);
/* 169 */           start = pos.getIndex();
/* 170 */           index = readArgumentIndex(pattern, next(pos));
/* 171 */           stripCustom.append('{').append(index);
/* 172 */           seekNonWs(pattern, pos);
/* 173 */           format = null;
/* 174 */           formatDescription = null;
/* 175 */           if (c[pos.getIndex()] == ',') {
/* 176 */             formatDescription = parseFormatDescription(pattern, 
/* 177 */                 next(pos));
/* 178 */             format = getFormat(formatDescription);
/* 179 */             if (format == null) {
/* 180 */               stripCustom.append(',').append(formatDescription);
/*     */             }
/*     */           } 
/* 183 */           foundFormats.add(format);
/* 184 */           foundDescriptions.add((format == null) ? null : formatDescription);
/* 185 */           Validate.isTrue((foundFormats.size() == fmtCount));
/* 186 */           Validate.isTrue((foundDescriptions.size() == fmtCount));
/* 187 */           if (c[pos.getIndex()] != '}') {
/* 188 */             throw new IllegalArgumentException("Unreadable format element at position " + start);
/*     */           }
/*     */           break;
/*     */       } 
/*     */       
/* 193 */       stripCustom.append(c[pos.getIndex()]);
/* 194 */       next(pos);
/*     */     } 
/*     */     
/* 197 */     super.applyPattern(stripCustom.toString());
/* 198 */     this.toPattern = insertFormats(super.toPattern(), foundDescriptions);
/* 199 */     if (containsElements(foundFormats)) {
/* 200 */       Format[] origFormats = getFormats();
/*     */ 
/*     */       
/* 203 */       int i = 0;
/* 204 */       for (Iterator<Format> it = foundFormats.iterator(); it.hasNext(); i++) {
/* 205 */         Format f = it.next();
/* 206 */         if (f != null) {
/* 207 */           origFormats[i] = f;
/*     */         }
/*     */       } 
/* 210 */       super.setFormats(origFormats);
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
/*     */   public void setFormat(int formatElementIndex, Format newFormat) {
/* 223 */     throw new UnsupportedOperationException();
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
/*     */   public void setFormatByArgumentIndex(int argumentIndex, Format newFormat) {
/* 235 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormats(Format[] newFormats) {
/* 246 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatsByArgumentIndex(Format[] newFormats) {
/* 257 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 268 */     if (obj == this) {
/* 269 */       return true;
/*     */     }
/* 271 */     if (obj == null) {
/* 272 */       return false;
/*     */     }
/* 274 */     if (!super.equals(obj)) {
/* 275 */       return false;
/*     */     }
/* 277 */     if (ObjectUtils.notEqual(getClass(), obj.getClass())) {
/* 278 */       return false;
/*     */     }
/* 280 */     ExtendedMessageFormat rhs = (ExtendedMessageFormat)obj;
/* 281 */     if (ObjectUtils.notEqual(this.toPattern, rhs.toPattern)) {
/* 282 */       return false;
/*     */     }
/* 284 */     return !ObjectUtils.notEqual(this.registry, rhs.registry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 292 */     int result = super.hashCode();
/* 293 */     result = 31 * result + Objects.hashCode(this.registry);
/* 294 */     result = 31 * result + Objects.hashCode(this.toPattern);
/* 295 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Format getFormat(String desc) {
/* 305 */     if (this.registry != null) {
/* 306 */       String name = desc;
/* 307 */       String args = null;
/* 308 */       int i = desc.indexOf(',');
/* 309 */       if (i > 0) {
/* 310 */         name = desc.substring(0, i).trim();
/* 311 */         args = desc.substring(i + 1).trim();
/*     */       } 
/* 313 */       FormatFactory factory = this.registry.get(name);
/* 314 */       if (factory != null) {
/* 315 */         return factory.getFormat(name, args, getLocale());
/*     */       }
/*     */     } 
/* 318 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readArgumentIndex(String pattern, ParsePosition pos) {
/* 329 */     int start = pos.getIndex();
/* 330 */     seekNonWs(pattern, pos);
/* 331 */     StringBuilder result = new StringBuilder();
/* 332 */     boolean error = false;
/* 333 */     for (; !error && pos.getIndex() < pattern.length(); next(pos)) {
/* 334 */       char c = pattern.charAt(pos.getIndex());
/* 335 */       if (Character.isWhitespace(c)) {
/* 336 */         seekNonWs(pattern, pos);
/* 337 */         c = pattern.charAt(pos.getIndex());
/* 338 */         if (c != ',' && c != '}') {
/* 339 */           error = true;
/*     */           continue;
/*     */         } 
/*     */       } 
/* 343 */       if ((c == ',' || c == '}') && result.length() > 0) {
/*     */         try {
/* 345 */           return Integer.parseInt(result.toString());
/* 346 */         } catch (NumberFormatException numberFormatException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 351 */       error = !Character.isDigit(c);
/* 352 */       result.append(c); continue;
/*     */     } 
/* 354 */     if (error) {
/* 355 */       throw new IllegalArgumentException("Invalid format argument index at position " + start + ": " + pattern
/*     */           
/* 357 */           .substring(start, pos.getIndex()));
/*     */     }
/* 359 */     throw new IllegalArgumentException("Unterminated format element at position " + start);
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
/*     */   private String parseFormatDescription(String pattern, ParsePosition pos) {
/* 371 */     int start = pos.getIndex();
/* 372 */     seekNonWs(pattern, pos);
/* 373 */     int text = pos.getIndex();
/* 374 */     int depth = 1;
/* 375 */     for (; pos.getIndex() < pattern.length(); next(pos)) {
/* 376 */       switch (pattern.charAt(pos.getIndex())) {
/*     */         case '{':
/* 378 */           depth++;
/*     */           break;
/*     */         case '}':
/* 381 */           depth--;
/* 382 */           if (depth == 0) {
/* 383 */             return pattern.substring(text, pos.getIndex());
/*     */           }
/*     */           break;
/*     */         case '\'':
/* 387 */           getQuotedString(pattern, pos);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 393 */     throw new IllegalArgumentException("Unterminated format element at position " + start);
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
/*     */   private String insertFormats(String pattern, ArrayList<String> customPatterns) {
/* 405 */     if (!containsElements(customPatterns)) {
/* 406 */       return pattern;
/*     */     }
/* 408 */     StringBuilder sb = new StringBuilder(pattern.length() * 2);
/* 409 */     ParsePosition pos = new ParsePosition(0);
/* 410 */     int fe = -1;
/* 411 */     int depth = 0;
/* 412 */     while (pos.getIndex() < pattern.length()) {
/* 413 */       char c = pattern.charAt(pos.getIndex());
/* 414 */       switch (c) {
/*     */         case '\'':
/* 416 */           appendQuotedString(pattern, pos, sb);
/*     */           continue;
/*     */         case '{':
/* 419 */           depth++;
/* 420 */           sb.append('{').append(readArgumentIndex(pattern, next(pos)));
/*     */           
/* 422 */           if (depth == 1) {
/* 423 */             fe++;
/* 424 */             String customPattern = customPatterns.get(fe);
/* 425 */             if (customPattern != null) {
/* 426 */               sb.append(',').append(customPattern);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         case '}':
/* 431 */           depth--;
/*     */           break;
/*     */       } 
/* 434 */       sb.append(c);
/* 435 */       next(pos);
/*     */     } 
/*     */     
/* 438 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void seekNonWs(String pattern, ParsePosition pos) {
/* 448 */     int len = 0;
/* 449 */     char[] buffer = pattern.toCharArray();
/*     */     do {
/* 451 */       len = StrMatcher.splitMatcher().isMatch(buffer, pos.getIndex());
/* 452 */       pos.setIndex(pos.getIndex() + len);
/* 453 */     } while (len > 0 && pos.getIndex() < pattern.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ParsePosition next(ParsePosition pos) {
/* 463 */     pos.setIndex(pos.getIndex() + 1);
/* 464 */     return pos;
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
/*     */   private StringBuilder appendQuotedString(String pattern, ParsePosition pos, StringBuilder appendTo) {
/* 478 */     assert pattern.toCharArray()[pos.getIndex()] == '\'' : "Quoted string must start with quote character";
/*     */ 
/*     */ 
/*     */     
/* 482 */     if (appendTo != null) {
/* 483 */       appendTo.append('\'');
/*     */     }
/* 485 */     next(pos);
/*     */     
/* 487 */     int start = pos.getIndex();
/* 488 */     char[] c = pattern.toCharArray();
/* 489 */     int lastHold = start;
/* 490 */     for (int i = pos.getIndex(); i < pattern.length(); i++) {
/* 491 */       if (c[pos.getIndex()] == '\'') {
/* 492 */         next(pos);
/* 493 */         return (appendTo == null) ? null : appendTo.append(c, lastHold, pos
/* 494 */             .getIndex() - lastHold);
/*     */       } 
/* 496 */       next(pos);
/*     */     } 
/* 498 */     throw new IllegalArgumentException("Unterminated quoted string at position " + start);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getQuotedString(String pattern, ParsePosition pos) {
/* 509 */     appendQuotedString(pattern, pos, (StringBuilder)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean containsElements(Collection<?> coll) {
/* 518 */     if (coll == null || coll.isEmpty()) {
/* 519 */       return false;
/*     */     }
/* 521 */     for (Object name : coll) {
/* 522 */       if (name != null) {
/* 523 */         return true;
/*     */       }
/*     */     } 
/* 526 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\ExtendedMessageFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */