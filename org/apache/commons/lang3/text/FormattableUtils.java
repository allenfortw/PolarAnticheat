/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.util.Formattable;
/*     */ import java.util.Formatter;
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
/*     */ @Deprecated
/*     */ public class FormattableUtils
/*     */ {
/*     */   private static final String SIMPLEST_FORMAT = "%s";
/*     */   
/*     */   public static String toString(Formattable formattable) {
/*  68 */     return String.format("%s", new Object[] { formattable });
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
/*     */   public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision) {
/*  85 */     return append(seq, formatter, flags, width, precision, ' ', null);
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
/*     */   public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, char padChar) {
/* 102 */     return append(seq, formatter, flags, width, precision, padChar, null);
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
/*     */   public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, CharSequence ellipsis) {
/* 120 */     return append(seq, formatter, flags, width, precision, ' ', ellipsis);
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
/*     */   public static Formatter append(CharSequence seq, Formatter formatter, int flags, int width, int precision, char padChar, CharSequence ellipsis) {
/* 138 */     Validate.isTrue((ellipsis == null || precision < 0 || ellipsis.length() <= precision), "Specified ellipsis '%1$s' exceeds precision of %2$s", new Object[] { ellipsis, 
/* 139 */           Integer.valueOf(precision) });
/* 140 */     StringBuilder buf = new StringBuilder(seq);
/* 141 */     if (precision >= 0 && precision < seq.length()) {
/* 142 */       CharSequence _ellipsis = (CharSequence)ObjectUtils.defaultIfNull(ellipsis, "");
/* 143 */       buf.replace(precision - _ellipsis.length(), seq.length(), _ellipsis.toString());
/*     */     } 
/* 145 */     boolean leftJustify = ((flags & 0x1) == 1);
/* 146 */     for (int i = buf.length(); i < width; i++) {
/* 147 */       buf.insert(leftJustify ? i : 0, padChar);
/*     */     }
/* 149 */     formatter.format(buf.toString(), new Object[0]);
/* 150 */     return formatter;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\FormattableUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */