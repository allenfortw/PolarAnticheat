/*     */ package net.craftigames.polar.common.util.time;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DateParser
/*     */ {
/*  16 */   private static final Pattern TIME_PATTERN = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MAX_YEARS = 100000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long parseDate(String time, boolean future) throws IllegalArgumentException {
/*  31 */     Matcher matcher = TIME_PATTERN.matcher(time);
/*  32 */     int years = 0, months = 0, weeks = 0, days = 0, hours = 0, minutes = 0, seconds = 0;
/*     */     
/*  34 */     boolean found = false;
/*  35 */     while (matcher.find()) {
/*  36 */       if (matcher.group() == null || matcher.group().isEmpty()) {
/*     */         continue;
/*     */       }
/*  39 */       for (int i = 0; i < matcher.groupCount(); i++) {
/*  40 */         if (matcher.group(i) != null && !matcher.group(i).isEmpty()) {
/*  41 */           found = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  45 */       if (found) {
/*  46 */         if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
/*  47 */           years = Integer.parseInt(matcher.group(1));
/*     */         }
/*  49 */         if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
/*  50 */           months = Integer.parseInt(matcher.group(2));
/*     */         }
/*  52 */         if (matcher.group(3) != null && !matcher.group(3).isEmpty()) {
/*  53 */           weeks = Integer.parseInt(matcher.group(3));
/*     */         }
/*  55 */         if (matcher.group(4) != null && !matcher.group(4).isEmpty()) {
/*  56 */           days = Integer.parseInt(matcher.group(4));
/*     */         }
/*  58 */         if (matcher.group(5) != null && !matcher.group(5).isEmpty()) {
/*  59 */           hours = Integer.parseInt(matcher.group(5));
/*     */         }
/*  61 */         if (matcher.group(6) != null && !matcher.group(6).isEmpty()) {
/*  62 */           minutes = Integer.parseInt(matcher.group(6));
/*     */         }
/*  64 */         if (matcher.group(7) != null && !matcher.group(7).isEmpty()) {
/*  65 */           seconds = Integer.parseInt(matcher.group(7));
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  71 */     if (!found) {
/*  72 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/*  75 */     Calendar c = new GregorianCalendar();
/*  76 */     if (years > 0) {
/*  77 */       if (years > 100000) {
/*  78 */         years = 100000;
/*     */       }
/*  80 */       c.add(1, years * (future ? 1 : -1));
/*     */     } 
/*  82 */     if (months > 0) {
/*  83 */       c.add(2, months * (future ? 1 : -1));
/*     */     }
/*  85 */     if (weeks > 0) {
/*  86 */       c.add(3, weeks * (future ? 1 : -1));
/*     */     }
/*  88 */     if (days > 0) {
/*  89 */       c.add(5, days * (future ? 1 : -1));
/*     */     }
/*  91 */     if (hours > 0) {
/*  92 */       c.add(11, hours * (future ? 1 : -1));
/*     */     }
/*  94 */     if (minutes > 0) {
/*  95 */       c.add(12, minutes * (future ? 1 : -1));
/*     */     }
/*  97 */     if (seconds > 0) {
/*  98 */       c.add(13, seconds * (future ? 1 : -1));
/*     */     }
/*     */     
/* 101 */     Calendar max = new GregorianCalendar();
/* 102 */     max.add(1, 10);
/*     */     
/* 104 */     if (c.after(max)) {
/* 105 */       return max.getTimeInMillis() / 1000L + 1L;
/*     */     }
/* 107 */     return c.getTimeInMillis() / 1000L + 1L;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\time\DateParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */