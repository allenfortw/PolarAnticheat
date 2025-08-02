/*      */ package org.apache.commons.lang3.time;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.Serializable;
/*      */ import java.text.DateFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import org.apache.commons.lang3.LocaleUtils;
/*      */ import org.apache.commons.lang3.exception.ExceptionUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FastDatePrinter
/*      */   implements DatePrinter, Serializable
/*      */ {
/*   95 */   private static final Rule[] EMPTY_RULE_ARRAY = new Rule[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int FULL = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int LONG = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int MEDIUM = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int SHORT = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String mPattern;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient Rule[] mRules;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private transient int mMaxLengthEstimate;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MAX_DIGITS = 10;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected FastDatePrinter(String pattern, TimeZone timeZone, Locale locale) {
/*  155 */     this.mPattern = pattern;
/*  156 */     this.mTimeZone = timeZone;
/*  157 */     this.mLocale = LocaleUtils.toLocale(locale);
/*      */     
/*  159 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void init() {
/*  166 */     List<Rule> rulesList = parsePattern();
/*  167 */     this.mRules = rulesList.<Rule>toArray(EMPTY_RULE_ARRAY);
/*      */     
/*  169 */     int len = 0;
/*  170 */     for (int i = this.mRules.length; --i >= 0;) {
/*  171 */       len += this.mRules[i].estimateLength();
/*      */     }
/*      */     
/*  174 */     this.mMaxLengthEstimate = len;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<Rule> parsePattern() {
/*  186 */     DateFormatSymbols symbols = new DateFormatSymbols(this.mLocale);
/*  187 */     List<Rule> rules = new ArrayList<>();
/*      */     
/*  189 */     String[] ERAs = symbols.getEras();
/*  190 */     String[] months = symbols.getMonths();
/*  191 */     String[] shortMonths = symbols.getShortMonths();
/*  192 */     String[] weekdays = symbols.getWeekdays();
/*  193 */     String[] shortWeekdays = symbols.getShortWeekdays();
/*  194 */     String[] AmPmStrings = symbols.getAmPmStrings();
/*      */     
/*  196 */     int length = this.mPattern.length();
/*  197 */     int[] indexRef = new int[1];
/*      */     
/*  199 */     for (int i = 0; i < length; i++) {
/*  200 */       Rule rule; String sub; indexRef[0] = i;
/*  201 */       String token = parseToken(this.mPattern, indexRef);
/*  202 */       i = indexRef[0];
/*      */       
/*  204 */       int tokenLen = token.length();
/*  205 */       if (tokenLen == 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  210 */       char c = token.charAt(0);
/*      */       
/*  212 */       switch (c) {
/*      */         case 'G':
/*  214 */           rule = new TextField(0, ERAs);
/*      */           break;
/*      */         case 'Y':
/*      */         case 'y':
/*  218 */           if (tokenLen == 2) {
/*  219 */             rule = TwoDigitYearField.INSTANCE;
/*      */           } else {
/*  221 */             rule = selectNumberRule(1, Math.max(tokenLen, 4));
/*      */           } 
/*  223 */           if (c == 'Y') {
/*  224 */             rule = new WeekYear((NumberRule)rule);
/*      */           }
/*      */           break;
/*      */         case 'M':
/*  228 */           if (tokenLen >= 4) {
/*  229 */             rule = new TextField(2, months); break;
/*  230 */           }  if (tokenLen == 3) {
/*  231 */             rule = new TextField(2, shortMonths); break;
/*  232 */           }  if (tokenLen == 2) {
/*  233 */             rule = TwoDigitMonthField.INSTANCE; break;
/*      */           } 
/*  235 */           rule = UnpaddedMonthField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'd':
/*  239 */           rule = selectNumberRule(5, tokenLen);
/*      */           break;
/*      */         case 'h':
/*  242 */           rule = new TwelveHourField(selectNumberRule(10, tokenLen));
/*      */           break;
/*      */         case 'H':
/*  245 */           rule = selectNumberRule(11, tokenLen);
/*      */           break;
/*      */         case 'm':
/*  248 */           rule = selectNumberRule(12, tokenLen);
/*      */           break;
/*      */         case 's':
/*  251 */           rule = selectNumberRule(13, tokenLen);
/*      */           break;
/*      */         case 'S':
/*  254 */           rule = selectNumberRule(14, tokenLen);
/*      */           break;
/*      */         case 'E':
/*  257 */           rule = new TextField(7, (tokenLen < 4) ? shortWeekdays : weekdays);
/*      */           break;
/*      */         case 'u':
/*  260 */           rule = new DayInWeekField(selectNumberRule(7, tokenLen));
/*      */           break;
/*      */         case 'D':
/*  263 */           rule = selectNumberRule(6, tokenLen);
/*      */           break;
/*      */         case 'F':
/*  266 */           rule = selectNumberRule(8, tokenLen);
/*      */           break;
/*      */         case 'w':
/*  269 */           rule = selectNumberRule(3, tokenLen);
/*      */           break;
/*      */         case 'W':
/*  272 */           rule = selectNumberRule(4, tokenLen);
/*      */           break;
/*      */         case 'a':
/*  275 */           rule = new TextField(9, AmPmStrings);
/*      */           break;
/*      */         case 'k':
/*  278 */           rule = new TwentyFourHourField(selectNumberRule(11, tokenLen));
/*      */           break;
/*      */         case 'K':
/*  281 */           rule = selectNumberRule(10, tokenLen);
/*      */           break;
/*      */         case 'X':
/*  284 */           rule = Iso8601_Rule.getRule(tokenLen);
/*      */           break;
/*      */         case 'z':
/*  287 */           if (tokenLen >= 4) {
/*  288 */             rule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1); break;
/*      */           } 
/*  290 */           rule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
/*      */           break;
/*      */         
/*      */         case 'Z':
/*  294 */           if (tokenLen == 1) {
/*  295 */             rule = TimeZoneNumberRule.INSTANCE_NO_COLON; break;
/*  296 */           }  if (tokenLen == 2) {
/*  297 */             rule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES; break;
/*      */           } 
/*  299 */           rule = TimeZoneNumberRule.INSTANCE_COLON;
/*      */           break;
/*      */         
/*      */         case '\'':
/*  303 */           sub = token.substring(1);
/*  304 */           if (sub.length() == 1) {
/*  305 */             rule = new CharacterLiteral(sub.charAt(0)); break;
/*      */           } 
/*  307 */           rule = new StringLiteral(sub);
/*      */           break;
/*      */         
/*      */         default:
/*  311 */           throw new IllegalArgumentException("Illegal pattern component: " + token);
/*      */       } 
/*      */       
/*  314 */       rules.add(rule);
/*      */     } 
/*      */     
/*  317 */     return rules;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String parseToken(String pattern, int[] indexRef) {
/*  328 */     StringBuilder buf = new StringBuilder();
/*      */     
/*  330 */     int i = indexRef[0];
/*  331 */     int length = pattern.length();
/*      */     
/*  333 */     char c = pattern.charAt(i);
/*  334 */     if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/*      */ 
/*      */       
/*  337 */       buf.append(c);
/*      */       
/*  339 */       while (i + 1 < length) {
/*  340 */         char peek = pattern.charAt(i + 1);
/*  341 */         if (peek == c) {
/*  342 */           buf.append(c);
/*  343 */           i++;
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/*  350 */       buf.append('\'');
/*      */       
/*  352 */       boolean inLiteral = false;
/*      */       
/*  354 */       for (; i < length; i++) {
/*  355 */         c = pattern.charAt(i);
/*      */         
/*  357 */         if (c == '\'')
/*  358 */         { if (i + 1 < length && pattern.charAt(i + 1) == '\'') {
/*      */             
/*  360 */             i++;
/*  361 */             buf.append(c);
/*      */           } else {
/*  363 */             inLiteral = !inLiteral;
/*      */           }  }
/*  365 */         else { if (!inLiteral && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
/*      */             
/*  367 */             i--;
/*      */             break;
/*      */           } 
/*  370 */           buf.append(c); }
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  375 */     indexRef[0] = i;
/*  376 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected NumberRule selectNumberRule(int field, int padding) {
/*  387 */     switch (padding) {
/*      */       case 1:
/*  389 */         return new UnpaddedNumberField(field);
/*      */       case 2:
/*  391 */         return new TwoDigitNumberField(field);
/*      */     } 
/*  393 */     return new PaddedNumberField(field, padding);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
/*  411 */     if (obj instanceof Date)
/*  412 */       return format((Date)obj, toAppendTo); 
/*  413 */     if (obj instanceof Calendar)
/*  414 */       return format((Calendar)obj, toAppendTo); 
/*  415 */     if (obj instanceof Long) {
/*  416 */       return format(((Long)obj).longValue(), toAppendTo);
/*      */     }
/*  418 */     throw new IllegalArgumentException("Unknown class: " + ((obj == null) ? "<null>" : obj
/*  419 */         .getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String format(Object obj) {
/*  431 */     if (obj instanceof Date)
/*  432 */       return format((Date)obj); 
/*  433 */     if (obj instanceof Calendar)
/*  434 */       return format((Calendar)obj); 
/*  435 */     if (obj instanceof Long) {
/*  436 */       return format(((Long)obj).longValue());
/*      */     }
/*  438 */     throw new IllegalArgumentException("Unknown class: " + ((obj == null) ? "<null>" : obj
/*  439 */         .getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(long millis) {
/*  448 */     Calendar c = newCalendar();
/*  449 */     c.setTimeInMillis(millis);
/*  450 */     return applyRulesToString(c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String applyRulesToString(Calendar c) {
/*  459 */     return ((StringBuilder)applyRules(c, new StringBuilder(this.mMaxLengthEstimate))).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Calendar newCalendar() {
/*  467 */     return Calendar.getInstance(this.mTimeZone, this.mLocale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Date date) {
/*  475 */     Calendar c = newCalendar();
/*  476 */     c.setTime(date);
/*  477 */     return applyRulesToString(c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Calendar calendar) {
/*  485 */     return ((StringBuilder)format(calendar, new StringBuilder(this.mMaxLengthEstimate))).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(long millis, StringBuffer buf) {
/*  493 */     Calendar c = newCalendar();
/*  494 */     c.setTimeInMillis(millis);
/*  495 */     return applyRules(c, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Date date, StringBuffer buf) {
/*  503 */     Calendar c = newCalendar();
/*  504 */     c.setTime(date);
/*  505 */     return applyRules(c, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Calendar calendar, StringBuffer buf) {
/*  514 */     return format(calendar.getTime(), buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(long millis, B buf) {
/*  522 */     Calendar c = newCalendar();
/*  523 */     c.setTimeInMillis(millis);
/*  524 */     return applyRules(c, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(Date date, B buf) {
/*  532 */     Calendar c = newCalendar();
/*  533 */     c.setTime(date);
/*  534 */     return applyRules(c, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <B extends Appendable> B format(Calendar calendar, B buf) {
/*  543 */     if (!calendar.getTimeZone().equals(this.mTimeZone)) {
/*  544 */       calendar = (Calendar)calendar.clone();
/*  545 */       calendar.setTimeZone(this.mTimeZone);
/*      */     } 
/*  547 */     return applyRules(calendar, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   protected StringBuffer applyRules(Calendar calendar, StringBuffer buf) {
/*  562 */     return applyRules(calendar, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <B extends Appendable> B applyRules(Calendar calendar, B buf) {
/*      */     try {
/*  576 */       for (Rule rule : this.mRules) {
/*  577 */         rule.appendTo((Appendable)buf, calendar);
/*      */       }
/*  579 */     } catch (IOException ioe) {
/*  580 */       ExceptionUtils.rethrow(ioe);
/*      */     } 
/*  582 */     return buf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPattern() {
/*  592 */     return this.mPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TimeZone getTimeZone() {
/*  600 */     return this.mTimeZone;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Locale getLocale() {
/*  608 */     return this.mLocale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLengthEstimate() {
/*  621 */     return this.mMaxLengthEstimate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object obj) {
/*  634 */     if (!(obj instanceof FastDatePrinter)) {
/*  635 */       return false;
/*      */     }
/*  637 */     FastDatePrinter other = (FastDatePrinter)obj;
/*  638 */     return (this.mPattern.equals(other.mPattern) && this.mTimeZone
/*  639 */       .equals(other.mTimeZone) && this.mLocale
/*  640 */       .equals(other.mLocale));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  650 */     return this.mPattern.hashCode() + 13 * (this.mTimeZone.hashCode() + 13 * this.mLocale.hashCode());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  660 */     return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/*  674 */     in.defaultReadObject();
/*  675 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void appendDigits(Appendable buffer, int value) throws IOException {
/*  685 */     buffer.append((char)(value / 10 + 48));
/*  686 */     buffer.append((char)(value % 10 + 48));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void appendFullDigits(Appendable buffer, int value, int minFieldWidth) throws IOException {
/*  700 */     if (value < 10000) {
/*      */ 
/*      */       
/*  703 */       int nDigits = 4;
/*  704 */       if (value < 1000) {
/*  705 */         nDigits--;
/*  706 */         if (value < 100) {
/*  707 */           nDigits--;
/*  708 */           if (value < 10) {
/*  709 */             nDigits--;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  714 */       for (int i = minFieldWidth - nDigits; i > 0; i--) {
/*  715 */         buffer.append('0');
/*      */       }
/*      */       
/*  718 */       switch (nDigits) {
/*      */         case 4:
/*  720 */           buffer.append((char)(value / 1000 + 48));
/*  721 */           value %= 1000;
/*      */         case 3:
/*  723 */           if (value >= 100) {
/*  724 */             buffer.append((char)(value / 100 + 48));
/*  725 */             value %= 100;
/*      */           } else {
/*  727 */             buffer.append('0');
/*      */           } 
/*      */         case 2:
/*  730 */           if (value >= 10) {
/*  731 */             buffer.append((char)(value / 10 + 48));
/*  732 */             value %= 10;
/*      */           } else {
/*  734 */             buffer.append('0');
/*      */           } 
/*      */         case 1:
/*  737 */           buffer.append((char)(value + 48));
/*      */           break;
/*      */       } 
/*      */ 
/*      */     
/*      */     } else {
/*  743 */       char[] work = new char[10];
/*  744 */       int digit = 0;
/*  745 */       while (value != 0) {
/*  746 */         work[digit++] = (char)(value % 10 + 48);
/*  747 */         value /= 10;
/*      */       } 
/*      */ 
/*      */       
/*  751 */       while (digit < minFieldWidth) {
/*  752 */         buffer.append('0');
/*  753 */         minFieldWidth--;
/*      */       } 
/*      */ 
/*      */       
/*  757 */       while (--digit >= 0) {
/*  758 */         buffer.append(work[digit]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface Rule
/*      */   {
/*      */     int estimateLength();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void appendTo(Appendable param1Appendable, Calendar param1Calendar) throws IOException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface NumberRule
/*      */     extends Rule
/*      */   {
/*      */     void appendTo(Appendable param1Appendable, int param1Int) throws IOException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class CharacterLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final char mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CharacterLiteral(char value) {
/*  813 */       this.mValue = value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  821 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/*  829 */       buffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class StringLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final String mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     StringLiteral(String value) {
/*  846 */       this.mValue = value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  854 */       return this.mValue.length();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/*  862 */       buffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TextField
/*      */     implements Rule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */     
/*      */     private final String[] mValues;
/*      */ 
/*      */ 
/*      */     
/*      */     TextField(int field, String[] values) {
/*  881 */       this.mField = field;
/*  882 */       this.mValues = values;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  890 */       int max = 0;
/*  891 */       for (int i = this.mValues.length; --i >= 0; ) {
/*  892 */         int len = this.mValues[i].length();
/*  893 */         if (len > max) {
/*  894 */           max = len;
/*      */         }
/*      */       } 
/*  897 */       return max;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/*  905 */       buffer.append(this.mValues[calendar.get(this.mField)]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class UnpaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     UnpaddedNumberField(int field) {
/*  921 */       this.mField = field;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  929 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/*  937 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/*  945 */       if (value < 10) {
/*  946 */         buffer.append((char)(value + 48));
/*  947 */       } else if (value < 100) {
/*  948 */         FastDatePrinter.appendDigits(buffer, value);
/*      */       } else {
/*  950 */         FastDatePrinter.appendFullDigits(buffer, value, 1);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class UnpaddedMonthField
/*      */     implements NumberRule
/*      */   {
/*  959 */     static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/*  973 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/*  981 */       appendTo(buffer, calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/*  989 */       if (value < 10) {
/*  990 */         buffer.append((char)(value + 48));
/*      */       } else {
/*  992 */         FastDatePrinter.appendDigits(buffer, value);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class PaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */     
/*      */     private final int mSize;
/*      */ 
/*      */ 
/*      */     
/*      */     PaddedNumberField(int field, int size) {
/* 1011 */       if (size < 3)
/*      */       {
/* 1013 */         throw new IllegalArgumentException();
/*      */       }
/* 1015 */       this.mField = field;
/* 1016 */       this.mSize = size;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1024 */       return this.mSize;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1032 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/* 1040 */       FastDatePrinter.appendFullDigits(buffer, value, this.mSize);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwoDigitNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwoDigitNumberField(int field) {
/* 1056 */       this.mField = field;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1064 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1072 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/* 1080 */       if (value < 100) {
/* 1081 */         FastDatePrinter.appendDigits(buffer, value);
/*      */       } else {
/* 1083 */         FastDatePrinter.appendFullDigits(buffer, value, 2);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitYearField
/*      */     implements NumberRule
/*      */   {
/* 1092 */     static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1105 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1113 */       appendTo(buffer, calendar.get(1) % 100);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/* 1121 */       FastDatePrinter.appendDigits(buffer, value % 100);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitMonthField
/*      */     implements NumberRule
/*      */   {
/* 1129 */     static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1142 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1150 */       appendTo(buffer, calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(Appendable buffer, int value) throws IOException {
/* 1158 */       FastDatePrinter.appendDigits(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwelveHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwelveHourField(FastDatePrinter.NumberRule rule) {
/* 1175 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1183 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1191 */       int value = calendar.get(10);
/* 1192 */       if (value == 0) {
/* 1193 */         value = calendar.getLeastMaximum(10) + 1;
/*      */       }
/* 1195 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, int value) throws IOException {
/* 1203 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwentyFourHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwentyFourHourField(FastDatePrinter.NumberRule rule) {
/* 1220 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1228 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1236 */       int value = calendar.get(11);
/* 1237 */       if (value == 0) {
/* 1238 */         value = calendar.getMaximum(11) + 1;
/*      */       }
/* 1240 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, int value) throws IOException {
/* 1248 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class DayInWeekField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */     
/*      */     DayInWeekField(FastDatePrinter.NumberRule rule) {
/* 1259 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1264 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1269 */       int value = calendar.get(7);
/* 1270 */       this.mRule.appendTo(buffer, (value == 1) ? 7 : (value - 1));
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, int value) throws IOException {
/* 1275 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class WeekYear
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDatePrinter.NumberRule mRule;
/*      */     
/*      */     WeekYear(FastDatePrinter.NumberRule rule) {
/* 1286 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1291 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1296 */       this.mRule.appendTo(buffer, calendar.getWeekYear());
/*      */     }
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, int value) throws IOException {
/* 1301 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1307 */   private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap<>(7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getTimeZoneDisplay(TimeZone tz, boolean daylight, int style, Locale locale) {
/* 1319 */     TimeZoneDisplayKey key = new TimeZoneDisplayKey(tz, daylight, style, locale);
/* 1320 */     String value = cTimeZoneDisplayCache.get(key);
/* 1321 */     if (value == null) {
/*      */       
/* 1323 */       value = tz.getDisplayName(daylight, style, locale);
/* 1324 */       String prior = cTimeZoneDisplayCache.putIfAbsent(key, value);
/* 1325 */       if (prior != null) {
/* 1326 */         value = prior;
/*      */       }
/*      */     } 
/* 1329 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNameRule
/*      */     implements Rule
/*      */   {
/*      */     private final Locale mLocale;
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */     
/*      */     private final String mStandard;
/*      */     
/*      */     private final String mDaylight;
/*      */ 
/*      */     
/*      */     TimeZoneNameRule(TimeZone timeZone, Locale locale, int style) {
/* 1349 */       this.mLocale = LocaleUtils.toLocale(locale);
/* 1350 */       this.mStyle = style;
/*      */       
/* 1352 */       this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, style, locale);
/* 1353 */       this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, style, locale);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1364 */       return Math.max(this.mStandard.length(), this.mDaylight.length());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1372 */       TimeZone zone = calendar.getTimeZone();
/* 1373 */       if (calendar.get(16) == 0) {
/* 1374 */         buffer.append(FastDatePrinter.getTimeZoneDisplay(zone, false, this.mStyle, this.mLocale));
/*      */       } else {
/* 1376 */         buffer.append(FastDatePrinter.getTimeZoneDisplay(zone, true, this.mStyle, this.mLocale));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNumberRule
/*      */     implements Rule
/*      */   {
/* 1386 */     static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
/* 1387 */     static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean mColon;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneNumberRule(boolean colon) {
/* 1397 */       this.mColon = colon;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1405 */       return 5;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1414 */       int offset = calendar.get(15) + calendar.get(16);
/*      */       
/* 1416 */       if (offset < 0) {
/* 1417 */         buffer.append('-');
/* 1418 */         offset = -offset;
/*      */       } else {
/* 1420 */         buffer.append('+');
/*      */       } 
/*      */       
/* 1423 */       int hours = offset / 3600000;
/* 1424 */       FastDatePrinter.appendDigits(buffer, hours);
/*      */       
/* 1426 */       if (this.mColon) {
/* 1427 */         buffer.append(':');
/*      */       }
/*      */       
/* 1430 */       int minutes = offset / 60000 - 60 * hours;
/* 1431 */       FastDatePrinter.appendDigits(buffer, minutes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Iso8601_Rule
/*      */     implements Rule
/*      */   {
/* 1442 */     static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
/*      */     
/* 1444 */     static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
/*      */     
/* 1446 */     static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
/*      */ 
/*      */ 
/*      */     
/*      */     final int length;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static Iso8601_Rule getRule(int tokenLen) {
/* 1456 */       switch (tokenLen) {
/*      */         case 1:
/* 1458 */           return ISO8601_HOURS;
/*      */         case 2:
/* 1460 */           return ISO8601_HOURS_MINUTES;
/*      */         case 3:
/* 1462 */           return ISO8601_HOURS_COLON_MINUTES;
/*      */       } 
/* 1464 */       throw new IllegalArgumentException("invalid number of X");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Iso8601_Rule(int length) {
/* 1476 */       this.length = length;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1484 */       return this.length;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(Appendable buffer, Calendar calendar) throws IOException {
/* 1492 */       int offset = calendar.get(15) + calendar.get(16);
/* 1493 */       if (offset == 0) {
/* 1494 */         buffer.append("Z");
/*      */         
/*      */         return;
/*      */       } 
/* 1498 */       if (offset < 0) {
/* 1499 */         buffer.append('-');
/* 1500 */         offset = -offset;
/*      */       } else {
/* 1502 */         buffer.append('+');
/*      */       } 
/*      */       
/* 1505 */       int hours = offset / 3600000;
/* 1506 */       FastDatePrinter.appendDigits(buffer, hours);
/*      */       
/* 1508 */       if (this.length < 5) {
/*      */         return;
/*      */       }
/*      */       
/* 1512 */       if (this.length == 6) {
/* 1513 */         buffer.append(':');
/*      */       }
/*      */       
/* 1516 */       int minutes = offset / 60000 - 60 * hours;
/* 1517 */       FastDatePrinter.appendDigits(buffer, minutes);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneDisplayKey
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneDisplayKey(TimeZone timeZone, boolean daylight, int style, Locale locale) {
/* 1540 */       this.mTimeZone = timeZone;
/* 1541 */       if (daylight) {
/* 1542 */         this.mStyle = style | Integer.MIN_VALUE;
/*      */       } else {
/* 1544 */         this.mStyle = style;
/*      */       } 
/* 1546 */       this.mLocale = LocaleUtils.toLocale(locale);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1554 */       return (this.mStyle * 31 + this.mLocale.hashCode()) * 31 + this.mTimeZone.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/* 1562 */       if (this == obj) {
/* 1563 */         return true;
/*      */       }
/* 1565 */       if (obj instanceof TimeZoneDisplayKey) {
/* 1566 */         TimeZoneDisplayKey other = (TimeZoneDisplayKey)obj;
/* 1567 */         return (this.mTimeZone
/* 1568 */           .equals(other.mTimeZone) && this.mStyle == other.mStyle && this.mLocale
/*      */           
/* 1570 */           .equals(other.mLocale));
/*      */       } 
/* 1572 */       return false;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\time\FastDatePrinter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */