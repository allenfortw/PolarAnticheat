/*     */ package org.apache.commons.lang3.text.translate;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class NumericEntityUnescaper
/*     */   extends CharSequenceTranslator
/*     */ {
/*     */   private final EnumSet<OPTION> options;
/*     */   
/*     */   public enum OPTION
/*     */   {
/*  45 */     semiColonRequired,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     semiColonOptional,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     errorIfNoSemiColon;
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
/*     */   public NumericEntityUnescaper(OPTION... options) {
/*  78 */     if (options.length > 0) {
/*  79 */       this.options = EnumSet.copyOf(Arrays.asList(options));
/*     */     } else {
/*  81 */       this.options = EnumSet.copyOf(Collections.singletonList(OPTION.semiColonRequired));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSet(OPTION option) {
/*  92 */     return (this.options != null && this.options.contains(option));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int translate(CharSequence input, int index, Writer out) throws IOException {
/* 100 */     int seqEnd = input.length();
/*     */     
/* 102 */     if (input.charAt(index) == '&' && index < seqEnd - 2 && input.charAt(index + 1) == '#') {
/* 103 */       int entityValue, start = index + 2;
/* 104 */       boolean isHex = false;
/*     */       
/* 106 */       char firstChar = input.charAt(start);
/* 107 */       if (firstChar == 'x' || firstChar == 'X') {
/* 108 */         start++;
/* 109 */         isHex = true;
/*     */ 
/*     */         
/* 112 */         if (start == seqEnd) {
/* 113 */           return 0;
/*     */         }
/*     */       } 
/*     */       
/* 117 */       int end = start;
/*     */       
/* 119 */       while (end < seqEnd && ((input.charAt(end) >= '0' && input.charAt(end) <= '9') || (input
/* 120 */         .charAt(end) >= 'a' && input.charAt(end) <= 'f') || (input
/* 121 */         .charAt(end) >= 'A' && input.charAt(end) <= 'F'))) {
/* 122 */         end++;
/*     */       }
/*     */       
/* 125 */       boolean semiNext = (end != seqEnd && input.charAt(end) == ';');
/*     */       
/* 127 */       if (!semiNext) {
/* 128 */         if (isSet(OPTION.semiColonRequired)) {
/* 129 */           return 0;
/*     */         }
/* 131 */         if (isSet(OPTION.errorIfNoSemiColon)) {
/* 132 */           throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 138 */         if (isHex) {
/* 139 */           entityValue = Integer.parseInt(input.subSequence(start, end).toString(), 16);
/*     */         } else {
/* 141 */           entityValue = Integer.parseInt(input.subSequence(start, end).toString(), 10);
/*     */         } 
/* 143 */       } catch (NumberFormatException nfe) {
/* 144 */         return 0;
/*     */       } 
/*     */       
/* 147 */       if (entityValue > 65535) {
/* 148 */         char[] chars = Character.toChars(entityValue);
/* 149 */         out.write(chars[0]);
/* 150 */         out.write(chars[1]);
/*     */       } else {
/* 152 */         out.write(entityValue);
/*     */       } 
/*     */       
/* 155 */       return 2 + end - start + (isHex ? 1 : 0) + (semiNext ? 1 : 0);
/*     */     } 
/* 157 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\translate\NumericEntityUnescaper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */