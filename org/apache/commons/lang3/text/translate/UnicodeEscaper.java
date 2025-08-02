/*     */ package org.apache.commons.lang3.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class UnicodeEscaper
/*     */   extends CodePointTranslator
/*     */ {
/*     */   private final int below;
/*     */   private final int above;
/*     */   private final boolean between;
/*     */   
/*     */   public UnicodeEscaper() {
/*  41 */     this(0, 2147483647, true);
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
/*     */   protected UnicodeEscaper(int below, int above, boolean between) {
/*  55 */     this.below = below;
/*  56 */     this.above = above;
/*  57 */     this.between = between;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper below(int codepoint) {
/*  67 */     return outsideOf(codepoint, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper above(int codepoint) {
/*  77 */     return outsideOf(0, codepoint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper outsideOf(int codepointLow, int codepointHigh) {
/*  88 */     return new UnicodeEscaper(codepointLow, codepointHigh, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static UnicodeEscaper between(int codepointLow, int codepointHigh) {
/*  99 */     return new UnicodeEscaper(codepointLow, codepointHigh, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean translate(int codepoint, Writer out) throws IOException {
/* 107 */     if (this.between) {
/* 108 */       if (codepoint < this.below || codepoint > this.above) {
/* 109 */         return false;
/*     */       }
/* 111 */     } else if (codepoint >= this.below && codepoint <= this.above) {
/* 112 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 116 */     if (codepoint > 65535) {
/* 117 */       out.write(toUtf16Escape(codepoint));
/*     */     } else {
/* 119 */       out.write("\\u");
/* 120 */       out.write(HEX_DIGITS[codepoint >> 12 & 0xF]);
/* 121 */       out.write(HEX_DIGITS[codepoint >> 8 & 0xF]);
/* 122 */       out.write(HEX_DIGITS[codepoint >> 4 & 0xF]);
/* 123 */       out.write(HEX_DIGITS[codepoint & 0xF]);
/*     */     } 
/* 125 */     return true;
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
/*     */   protected String toUtf16Escape(int codepoint) {
/* 138 */     return "\\u" + hex(codepoint);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\translate\UnicodeEscaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */