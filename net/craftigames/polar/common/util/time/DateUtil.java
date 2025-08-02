/*     */ package net.craftigames.polar.common.util.time;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class DateUtil
/*     */ {
/*  12 */   private static final Pattern timePattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
/*     */   private static final int maxYears = 100000;
/*     */   
/*     */   public static String removeTimePattern(String input) {
/*  16 */     return timePattern.matcher(input).replaceFirst("").trim();
/*     */   }
/*     */   
/*     */   public static long parseDateDiff(String time, boolean future) throws Exception {
/*  20 */     Matcher m = timePattern.matcher(time);
/*  21 */     int years = 0;
/*  22 */     int months = 0;
/*  23 */     int weeks = 0;
/*  24 */     int days = 0;
/*  25 */     int hours = 0;
/*  26 */     int minutes = 0;
/*  27 */     int seconds = 0;
/*  28 */     boolean found = false;
/*  29 */     while (m.find()) {
/*  30 */       if (m.group() == null || m.group().isEmpty()) {
/*     */         continue;
/*     */       }
/*  33 */       for (int i = 0; i < m.groupCount(); i++) {
/*  34 */         if (m.group(i) != null && !m.group(i).isEmpty()) {
/*  35 */           found = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*  39 */       if (found) {
/*  40 */         if (m.group(1) != null && !m.group(1).isEmpty()) {
/*  41 */           years = Integer.parseInt(m.group(1));
/*     */         }
/*  43 */         if (m.group(2) != null && !m.group(2).isEmpty()) {
/*  44 */           months = Integer.parseInt(m.group(2));
/*     */         }
/*  46 */         if (m.group(3) != null && !m.group(3).isEmpty()) {
/*  47 */           weeks = Integer.parseInt(m.group(3));
/*     */         }
/*  49 */         if (m.group(4) != null && !m.group(4).isEmpty()) {
/*  50 */           days = Integer.parseInt(m.group(4));
/*     */         }
/*  52 */         if (m.group(5) != null && !m.group(5).isEmpty()) {
/*  53 */           hours = Integer.parseInt(m.group(5));
/*     */         }
/*  55 */         if (m.group(6) != null && !m.group(6).isEmpty()) {
/*  56 */           minutes = Integer.parseInt(m.group(6));
/*     */         }
/*  58 */         if (m.group(7) != null && !m.group(7).isEmpty()) {
/*  59 */           seconds = Integer.parseInt(m.group(7));
/*     */         }
/*     */         break;
/*     */       } 
/*     */     } 
/*  64 */     if (!found) {
/*  65 */       throw new Exception("illegalDate");
/*     */     }
/*  67 */     Calendar c = new GregorianCalendar();
/*  68 */     if (years > 0) {
/*  69 */       if (years > 100000) {
/*  70 */         years = 100000;
/*     */       }
/*  72 */       c.add(1, years * (future ? 1 : -1));
/*     */     } 
/*  74 */     if (months > 0) {
/*  75 */       c.add(2, months * (future ? 1 : -1));
/*     */     }
/*  77 */     if (weeks > 0) {
/*  78 */       c.add(3, weeks * (future ? 1 : -1));
/*     */     }
/*  80 */     if (days > 0) {
/*  81 */       c.add(5, days * (future ? 1 : -1));
/*     */     }
/*  83 */     if (hours > 0) {
/*  84 */       c.add(11, hours * (future ? 1 : -1));
/*     */     }
/*  86 */     if (minutes > 0) {
/*  87 */       c.add(12, minutes * (future ? 1 : -1));
/*     */     }
/*  89 */     if (seconds > 0) {
/*  90 */       c.add(13, seconds * (future ? 1 : -1));
/*     */     }
/*  92 */     Calendar max = new GregorianCalendar();
/*  93 */     max.add(1, 10);
/*  94 */     if (c.after(max)) {
/*  95 */       return max.getTimeInMillis();
/*     */     }
/*  97 */     return c.getTimeInMillis();
/*     */   }
/*     */   
/*     */   static int dateDiff(int type, Calendar fromDate, Calendar toDate, boolean future) {
/* 101 */     int year = 1;
/*     */     
/* 103 */     int fromYear = fromDate.get(year);
/* 104 */     int toYear = toDate.get(year);
/* 105 */     if (Math.abs(fromYear - toYear) > 100000) {
/* 106 */       toDate.set(year, fromYear + (
/* 107 */           future ? 100000 : -100000));
/*     */     }
/*     */     
/* 110 */     int diff = 0;
/* 111 */     long savedDate = fromDate.getTimeInMillis();
/* 112 */     while ((future && !fromDate.after(toDate)) || (!future && !fromDate.before(toDate))) {
/* 113 */       savedDate = fromDate.getTimeInMillis();
/* 114 */       fromDate.add(type, future ? 1 : -1);
/* 115 */       diff++;
/*     */     } 
/* 117 */     diff--;
/* 118 */     fromDate.setTimeInMillis(savedDate);
/* 119 */     return diff;
/*     */   }
/*     */   
/*     */   public static String formatDateDiff(long date) {
/* 123 */     Calendar c = new GregorianCalendar();
/* 124 */     c.setTimeInMillis(date);
/* 125 */     Calendar now = new GregorianCalendar();
/* 126 */     return formatDateDiff(now, c);
/*     */   }
/*     */   
/*     */   public static String formatDateDiff(long from, long to) {
/* 130 */     return formatDateDiff(new Date(from), new Date(to));
/*     */   }
/*     */   
/*     */   public static String formatDateDiff(Calendar fromDate, Calendar toDate) {
/* 134 */     boolean future = false;
/* 135 */     if (toDate.equals(fromDate)) {
/* 136 */       return "now";
/*     */     }
/* 138 */     if (toDate.after(fromDate)) {
/* 139 */       future = true;
/*     */     }
/*     */     
/* 142 */     toDate.add(14, future ? 50 : -50);
/* 143 */     StringBuilder sb = new StringBuilder();
/* 144 */     int[] types = { 1, 2, 5, 11, 12, 13 };
/* 145 */     String[] names = { "year", "years", "month", "months", "day", "days", "hour", "hours", "minute", "minutes", "second", "seconds" };
/* 146 */     int accuracy = 0;
/* 147 */     for (int i = 0; i < types.length && 
/* 148 */       accuracy <= 2; i++) {
/*     */ 
/*     */       
/* 151 */       int diff = dateDiff(types[i], fromDate, toDate, future);
/* 152 */       if (diff > 0) {
/* 153 */         accuracy++;
/* 154 */         sb.append(" ").append(diff).append(" ").append(names[i * 2 + ((diff > 1) ? 1 : 0)]);
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     toDate.add(14, future ? -50 : 50);
/* 159 */     if (sb.length() == 0) {
/* 160 */       return "now";
/*     */     }
/* 162 */     return sb.toString().trim();
/*     */   }
/*     */   
/*     */   public static String formatDateDiff(Date fromDate, Date toDate) {
/* 166 */     Calendar first = Calendar.getInstance();
/* 167 */     first.clear();
/* 168 */     first.setTime(fromDate);
/*     */     
/* 170 */     Calendar second = Calendar.getInstance();
/* 171 */     second.clear();
/* 172 */     second.setTime(toDate);
/* 173 */     return formatDateDiff(first, second);
/*     */   }
/*     */ 
/*     */   
/* 177 */   private static final SimpleDateFormat ddMMyyy_HHmmss = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
/*     */   public static String toFormat_ddMMyyy_HHmmss(long time) {
/* 179 */     return ddMMyyy_HHmmss.format(new Date(time));
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\time\DateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */