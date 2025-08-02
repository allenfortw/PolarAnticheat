/*     */ package org.apache.commons.lang3.text;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class WordUtils
/*     */ {
/*     */   public static String wrap(String str, int wrapLength) {
/* 103 */     return wrap(str, wrapLength, null, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String wrap(String str, int wrapLength, String newLineStr, boolean wrapLongWords) {
/* 180 */     return wrap(str, wrapLength, newLineStr, wrapLongWords, " ");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String wrap(String str, int wrapLength, String newLineStr, boolean wrapLongWords, String wrapOn) {
/* 274 */     if (str == null) {
/* 275 */       return null;
/*     */     }
/* 277 */     if (newLineStr == null) {
/* 278 */       newLineStr = System.lineSeparator();
/*     */     }
/* 280 */     if (wrapLength < 1) {
/* 281 */       wrapLength = 1;
/*     */     }
/* 283 */     if (StringUtils.isBlank(wrapOn)) {
/* 284 */       wrapOn = " ";
/*     */     }
/* 286 */     Pattern patternToWrapOn = Pattern.compile(wrapOn);
/* 287 */     int inputLineLength = str.length();
/* 288 */     int offset = 0;
/* 289 */     StringBuilder wrappedLine = new StringBuilder(inputLineLength + 32);
/*     */     
/* 291 */     while (offset < inputLineLength) {
/* 292 */       int spaceToWrapAt = -1;
/* 293 */       Matcher matcher = patternToWrapOn.matcher(str
/* 294 */           .substring(offset, Math.min((int)Math.min(2147483647L, (offset + wrapLength) + 1L), inputLineLength)));
/* 295 */       if (matcher.find()) {
/* 296 */         if (matcher.start() == 0) {
/* 297 */           offset += matcher.end();
/*     */           continue;
/*     */         } 
/* 300 */         spaceToWrapAt = matcher.start() + offset;
/*     */       } 
/*     */ 
/*     */       
/* 304 */       if (inputLineLength - offset <= wrapLength) {
/*     */         break;
/*     */       }
/*     */       
/* 308 */       while (matcher.find()) {
/* 309 */         spaceToWrapAt = matcher.start() + offset;
/*     */       }
/*     */       
/* 312 */       if (spaceToWrapAt >= offset) {
/*     */         
/* 314 */         wrappedLine.append(str, offset, spaceToWrapAt);
/* 315 */         wrappedLine.append(newLineStr);
/* 316 */         offset = spaceToWrapAt + 1;
/*     */         continue;
/*     */       } 
/* 319 */       if (wrapLongWords) {
/*     */         
/* 321 */         wrappedLine.append(str, offset, wrapLength + offset);
/* 322 */         wrappedLine.append(newLineStr);
/* 323 */         offset += wrapLength;
/*     */         continue;
/*     */       } 
/* 326 */       matcher = patternToWrapOn.matcher(str.substring(offset + wrapLength));
/* 327 */       if (matcher.find()) {
/* 328 */         spaceToWrapAt = matcher.start() + offset + wrapLength;
/*     */       }
/*     */       
/* 331 */       if (spaceToWrapAt >= 0) {
/* 332 */         wrappedLine.append(str, offset, spaceToWrapAt);
/* 333 */         wrappedLine.append(newLineStr);
/* 334 */         offset = spaceToWrapAt + 1; continue;
/*     */       } 
/* 336 */       wrappedLine.append(str, offset, str.length());
/* 337 */       offset = inputLineLength;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 343 */     wrappedLine.append(str, offset, str.length());
/*     */     
/* 345 */     return wrappedLine.toString();
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
/*     */   public static String capitalize(String str) {
/* 373 */     return capitalize(str, null);
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
/*     */   public static String capitalize(String str, char... delimiters) {
/* 406 */     int delimLen = (delimiters == null) ? -1 : delimiters.length;
/* 407 */     if (StringUtils.isEmpty(str) || delimLen == 0) {
/* 408 */       return str;
/*     */     }
/* 410 */     char[] buffer = str.toCharArray();
/* 411 */     boolean capitalizeNext = true;
/* 412 */     for (int i = 0; i < buffer.length; i++) {
/* 413 */       char ch = buffer[i];
/* 414 */       if (isDelimiter(ch, delimiters)) {
/* 415 */         capitalizeNext = true;
/* 416 */       } else if (capitalizeNext) {
/* 417 */         buffer[i] = Character.toTitleCase(ch);
/* 418 */         capitalizeNext = false;
/*     */       } 
/*     */     } 
/* 421 */     return new String(buffer);
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
/*     */   public static String capitalizeFully(String str) {
/* 445 */     return capitalizeFully(str, null);
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
/*     */   public static String capitalizeFully(String str, char... delimiters) {
/* 475 */     int delimLen = (delimiters == null) ? -1 : delimiters.length;
/* 476 */     if (StringUtils.isEmpty(str) || delimLen == 0) {
/* 477 */       return str;
/*     */     }
/* 479 */     str = str.toLowerCase();
/* 480 */     return capitalize(str, delimiters);
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
/*     */   public static String uncapitalize(String str) {
/* 502 */     return uncapitalize(str, null);
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
/*     */   public static String uncapitalize(String str, char... delimiters) {
/* 531 */     int delimLen = (delimiters == null) ? -1 : delimiters.length;
/* 532 */     if (StringUtils.isEmpty(str) || delimLen == 0) {
/* 533 */       return str;
/*     */     }
/* 535 */     char[] buffer = str.toCharArray();
/* 536 */     boolean uncapitalizeNext = true;
/* 537 */     for (int i = 0; i < buffer.length; i++) {
/* 538 */       char ch = buffer[i];
/* 539 */       if (isDelimiter(ch, delimiters)) {
/* 540 */         uncapitalizeNext = true;
/* 541 */       } else if (uncapitalizeNext) {
/* 542 */         buffer[i] = Character.toLowerCase(ch);
/* 543 */         uncapitalizeNext = false;
/*     */       } 
/*     */     } 
/* 546 */     return new String(buffer);
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
/*     */   public static String swapCase(String str) {
/* 573 */     if (StringUtils.isEmpty(str)) {
/* 574 */       return str;
/*     */     }
/* 576 */     char[] buffer = str.toCharArray();
/*     */     
/* 578 */     boolean whitespace = true;
/*     */     
/* 580 */     for (int i = 0; i < buffer.length; i++) {
/* 581 */       char ch = buffer[i];
/* 582 */       if (Character.isUpperCase(ch) || Character.isTitleCase(ch)) {
/* 583 */         buffer[i] = Character.toLowerCase(ch);
/* 584 */         whitespace = false;
/* 585 */       } else if (Character.isLowerCase(ch)) {
/* 586 */         if (whitespace) {
/* 587 */           buffer[i] = Character.toTitleCase(ch);
/* 588 */           whitespace = false;
/*     */         } else {
/* 590 */           buffer[i] = Character.toUpperCase(ch);
/*     */         } 
/*     */       } else {
/* 593 */         whitespace = Character.isWhitespace(ch);
/*     */       } 
/*     */     } 
/* 596 */     return new String(buffer);
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
/*     */   public static String initials(String str) {
/* 622 */     return initials(str, null);
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
/*     */   public static String initials(String str, char... delimiters) {
/* 652 */     if (StringUtils.isEmpty(str)) {
/* 653 */       return str;
/*     */     }
/* 655 */     if (delimiters != null && delimiters.length == 0) {
/* 656 */       return "";
/*     */     }
/* 658 */     int strLen = str.length();
/* 659 */     char[] buf = new char[strLen / 2 + 1];
/* 660 */     int count = 0;
/* 661 */     boolean lastWasGap = true;
/* 662 */     for (int i = 0; i < strLen; i++) {
/* 663 */       char ch = str.charAt(i);
/*     */       
/* 665 */       if (isDelimiter(ch, delimiters)) {
/* 666 */         lastWasGap = true;
/* 667 */       } else if (lastWasGap) {
/* 668 */         buf[count++] = ch;
/* 669 */         lastWasGap = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 674 */     return new String(buf, 0, count);
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
/*     */   public static boolean containsAllWords(CharSequence word, CharSequence... words) {
/* 702 */     if (StringUtils.isEmpty(word) || ArrayUtils.isEmpty((Object[])words)) {
/* 703 */       return false;
/*     */     }
/* 705 */     for (CharSequence w : words) {
/* 706 */       if (StringUtils.isBlank(w)) {
/* 707 */         return false;
/*     */       }
/* 709 */       Pattern p = Pattern.compile(".*\\b" + w + "\\b.*");
/* 710 */       if (!p.matcher(word).matches()) {
/* 711 */         return false;
/*     */       }
/*     */     } 
/* 714 */     return true;
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
/*     */   private static boolean isDelimiter(char ch, char[] delimiters) {
/* 726 */     if (delimiters == null) {
/* 727 */       return Character.isWhitespace(ch);
/*     */     }
/* 729 */     for (char delimiter : delimiters) {
/* 730 */       if (ch == delimiter) {
/* 731 */         return true;
/*     */       }
/*     */     } 
/* 734 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\WordUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */