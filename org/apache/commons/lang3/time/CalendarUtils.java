/*    */ package org.apache.commons.lang3.time;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CalendarUtils
/*    */ {
/* 33 */   public static final CalendarUtils INSTANCE = new CalendarUtils(Calendar.getInstance());
/*    */ 
/*    */ 
/*    */   
/*    */   private final Calendar calendar;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CalendarUtils(Calendar calendar) {
/* 43 */     this.calendar = Objects.<Calendar>requireNonNull(calendar, "calendar");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDayOfMonth() {
/* 52 */     return this.calendar.get(5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMonth() {
/* 61 */     return this.calendar.get(2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getYear() {
/* 70 */     return this.calendar.get(1);
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\time\CalendarUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */