/*     */ package net.craftigames.polar.common.util.time;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum DurationFormatter
/*     */ {
/*  14 */   CONCISE {
/*  15 */     private final String[] names = new String[] { "y", "y", "m", "m", "d", "d", "h", "h", "m", "m", "s", "s" };
/*     */ 
/*     */     
/*     */     public String format(Calendar from, Calendar to) {
/*  19 */       return dateDiff(from, to, 4, this.names, true);
/*     */     }
/*     */   },
/*     */   
/*  23 */   CONCISE_LOW_ACCURACY {
/*  24 */     private final String[] names = new String[] { "y", "y", "m", "m", "d", "d", "h", "h", "m", "m", "s", "s" };
/*     */ 
/*     */     
/*     */     public String format(Calendar from, Calendar to) {
/*  28 */       return dateDiff(from, to, 2, this.names, true);
/*     */     }
/*     */   },
/*     */   
/*  32 */   LONG {
/*  33 */     private final String[] names = new String[] { "year", "years", "month", "months", "day", "days", "hour", "hours", "minute", "minutes", "second", "seconds" };
/*     */ 
/*     */     
/*     */     public String format(Calendar from, Calendar to) {
/*  37 */       return dateDiff(from, to, 4, this.names, false);
/*     */     }
/*     */   },
/*     */   
/*  41 */   LONG_LOW_ACCURACY {
/*  42 */     private final String[] names = new String[] { "year", "years", "month", "months", "day", "days", "hour", "hours", "minute", "minutes", "second", "seconds" };
/*     */ 
/*     */     
/*     */     public String format(Calendar from, Calendar to) {
/*  46 */       return dateDiff(from, to, 2, this.names, false);
/*     */     }
/*     */   };
/*     */   private static final int[] CALENDAR_TYPES;
/*     */   private static final int MAX_YEARS = 100000;
/*     */   
/*     */   static {
/*  53 */     CALENDAR_TYPES = new int[] { 1, 2, 5, 11, 12, 13 };
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
/*     */   private static String dateDiff(Calendar from, Calendar to, int maxAccuracy, String[] names, boolean concise) {
/*  74 */     if (to.equals(from)) {
/*  75 */       return "now";
/*     */     }
/*     */     
/*  78 */     boolean future = to.after(from);
/*     */ 
/*     */     
/*  81 */     to.add(14, future ? 50 : -50);
/*     */     
/*  83 */     StringBuilder sb = new StringBuilder();
/*  84 */     int accuracy = 0;
/*  85 */     for (int i = 0; i < CALENDAR_TYPES.length && 
/*  86 */       accuracy <= maxAccuracy; i++) {
/*     */ 
/*     */ 
/*     */       
/*  90 */       int diff = dateDiff(CALENDAR_TYPES[i], from, to, future);
/*  91 */       if (diff > 0) {
/*  92 */         int plural = (diff > 1) ? 1 : 0;
/*  93 */         String unit = names[i * 2 + plural];
/*     */         
/*  95 */         sb.append(" ");
/*  96 */         sb.append(diff);
/*  97 */         if (!concise) {
/*  98 */           sb.append(" ");
/*     */         }
/* 100 */         sb.append(unit);
/*     */         
/* 102 */         accuracy++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 107 */     to.add(14, future ? -50 : 50);
/*     */     
/* 109 */     if (sb.length() == 0) {
/* 110 */       return "now";
/*     */     }
/*     */     
/* 113 */     return sb.toString().trim();
/*     */   }
/*     */   
/*     */   private static int dateDiff(int type, Calendar fromDate, Calendar toDate, boolean future) {
/* 117 */     int fromYear = fromDate.get(1);
/* 118 */     int toYear = toDate.get(1);
/* 119 */     if (Math.abs(fromYear - toYear) > 100000) {
/* 120 */       toDate.set(1, fromYear + (future ? 100000 : -100000));
/*     */     }
/*     */     
/* 123 */     int diff = 0;
/* 124 */     long savedDate = fromDate.getTimeInMillis();
/* 125 */     while ((future && !fromDate.after(toDate)) || (!future && !fromDate.before(toDate))) {
/* 126 */       savedDate = fromDate.getTimeInMillis();
/* 127 */       fromDate.add(type, future ? 1 : -1);
/* 128 */       diff++;
/*     */     } 
/*     */     
/* 131 */     diff--;
/* 132 */     fromDate.setTimeInMillis(savedDate);
/* 133 */     return diff;
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
/*     */   public String format(long seconds) {
/* 152 */     Calendar from = new GregorianCalendar();
/* 153 */     from.setTimeInMillis(0L);
/*     */     
/* 155 */     Calendar to = new GregorianCalendar();
/* 156 */     to.setTimeInMillis(seconds * 1000L);
/*     */     
/* 158 */     return format(from, to);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatMillis(long millis) {
/* 168 */     return format(millis / 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDateDiffMillis(long millisTimestamp) {
/* 178 */     long now = System.currentTimeMillis();
/* 179 */     return formatMillis(millisTimestamp - now);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatDateDiff(long unixTimestamp) {
/* 190 */     long now = System.currentTimeMillis() / 1000L;
/* 191 */     return format(unixTimestamp - now);
/*     */   }
/*     */   
/*     */   public abstract String format(Calendar paramCalendar1, Calendar paramCalendar2);
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\time\DurationFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */