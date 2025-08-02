/*      */ package org.apache.commons.lang3.builder;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.WeakHashMap;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.StringEscapeUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
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
/*      */ public abstract class ToStringStyle
/*      */   implements Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -2587890625525655916L;
/*   84 */   public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
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
/*   98 */   public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
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
/*  109 */   public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
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
/*  121 */   public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  131 */   public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
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
/*  143 */   public static final ToStringStyle NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
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
/*  162 */   public static final ToStringStyle JSON_STYLE = new JsonToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  170 */   private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = new ThreadLocal<>();
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
/*      */   static Map<Object, Object> getRegistry() {
/*  191 */     return REGISTRY.get();
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
/*      */   static boolean isRegistered(Object value) {
/*  206 */     Map<Object, Object> m = getRegistry();
/*  207 */     return (m != null && m.containsKey(value));
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
/*      */   static void register(Object value) {
/*  220 */     if (value != null) {
/*  221 */       Map<Object, Object> m = getRegistry();
/*  222 */       if (m == null) {
/*  223 */         REGISTRY.set(new WeakHashMap<>());
/*      */       }
/*  225 */       getRegistry().put(value, null);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void unregister(Object value) {
/*  242 */     if (value != null) {
/*  243 */       Map<Object, Object> m = getRegistry();
/*  244 */       if (m != null) {
/*  245 */         m.remove(value);
/*  246 */         if (m.isEmpty()) {
/*  247 */           REGISTRY.remove();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useFieldNames = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useClassName = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useShortClassName;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useIdentityHashCode = true;
/*      */ 
/*      */ 
/*      */   
/*  276 */   private String contentStart = "[";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  281 */   private String contentEnd = "]";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  286 */   private String fieldNameValueSeparator = "=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtStart;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtEnd;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  301 */   private String fieldSeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  306 */   private String arrayStart = "{";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  311 */   private String arraySeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean arrayContentDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  321 */   private String arrayEnd = "}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean defaultFullDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  332 */   private String nullText = "<null>";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  337 */   private String sizeStartText = "<size=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  342 */   private String sizeEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  347 */   private String summaryObjectStartText = "<";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  352 */   private String summaryObjectEndText = ">";
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
/*      */   public void appendSuper(StringBuffer buffer, String superToString) {
/*  375 */     appendToString(buffer, superToString);
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
/*      */   public void appendToString(StringBuffer buffer, String toString) {
/*  389 */     if (toString != null) {
/*  390 */       int pos1 = toString.indexOf(this.contentStart) + this.contentStart.length();
/*  391 */       int pos2 = toString.lastIndexOf(this.contentEnd);
/*  392 */       if (pos1 != pos2 && pos1 >= 0 && pos2 >= 0) {
/*  393 */         if (this.fieldSeparatorAtStart) {
/*  394 */           removeLastFieldSeparator(buffer);
/*      */         }
/*  396 */         buffer.append(toString, pos1, pos2);
/*  397 */         appendFieldSeparator(buffer);
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
/*      */   public void appendStart(StringBuffer buffer, Object object) {
/*  409 */     if (object != null) {
/*  410 */       appendClassName(buffer, object);
/*  411 */       appendIdentityHashCode(buffer, object);
/*  412 */       appendContentStart(buffer);
/*  413 */       if (this.fieldSeparatorAtStart) {
/*  414 */         appendFieldSeparator(buffer);
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
/*      */   public void appendEnd(StringBuffer buffer, Object object) {
/*  427 */     if (!this.fieldSeparatorAtEnd) {
/*  428 */       removeLastFieldSeparator(buffer);
/*      */     }
/*  430 */     appendContentEnd(buffer);
/*  431 */     unregister(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeLastFieldSeparator(StringBuffer buffer) {
/*  441 */     if (StringUtils.endsWith(buffer, this.fieldSeparator)) {
/*  442 */       buffer.setLength(buffer.length() - this.fieldSeparator.length());
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
/*  460 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  462 */     if (value == null) {
/*  463 */       appendNullText(buffer, fieldName);
/*      */     } else {
/*      */       
/*  466 */       appendInternal(buffer, fieldName, value, isFullDetail(fullDetail));
/*      */     } 
/*      */     
/*  469 */     appendFieldEnd(buffer, fieldName);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendInternal(StringBuffer buffer, String fieldName, Object value, boolean detail) {
/*  492 */     if (isRegistered(value) && !(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof Character)) {
/*      */       
/*  494 */       appendCyclicObject(buffer, fieldName, value);
/*      */       
/*      */       return;
/*      */     } 
/*  498 */     register(value);
/*      */     
/*      */     try {
/*  501 */       if (value instanceof Collection) {
/*  502 */         if (detail) {
/*  503 */           appendDetail(buffer, fieldName, (Collection)value);
/*      */         } else {
/*  505 */           appendSummarySize(buffer, fieldName, ((Collection)value).size());
/*      */         }
/*      */       
/*  508 */       } else if (value instanceof Map) {
/*  509 */         if (detail) {
/*  510 */           appendDetail(buffer, fieldName, (Map<?, ?>)value);
/*      */         } else {
/*  512 */           appendSummarySize(buffer, fieldName, ((Map)value).size());
/*      */         }
/*      */       
/*  515 */       } else if (value instanceof long[]) {
/*  516 */         if (detail) {
/*  517 */           appendDetail(buffer, fieldName, (long[])value);
/*      */         } else {
/*  519 */           appendSummary(buffer, fieldName, (long[])value);
/*      */         }
/*      */       
/*  522 */       } else if (value instanceof int[]) {
/*  523 */         if (detail) {
/*  524 */           appendDetail(buffer, fieldName, (int[])value);
/*      */         } else {
/*  526 */           appendSummary(buffer, fieldName, (int[])value);
/*      */         }
/*      */       
/*  529 */       } else if (value instanceof short[]) {
/*  530 */         if (detail) {
/*  531 */           appendDetail(buffer, fieldName, (short[])value);
/*      */         } else {
/*  533 */           appendSummary(buffer, fieldName, (short[])value);
/*      */         }
/*      */       
/*  536 */       } else if (value instanceof byte[]) {
/*  537 */         if (detail) {
/*  538 */           appendDetail(buffer, fieldName, (byte[])value);
/*      */         } else {
/*  540 */           appendSummary(buffer, fieldName, (byte[])value);
/*      */         }
/*      */       
/*  543 */       } else if (value instanceof char[]) {
/*  544 */         if (detail) {
/*  545 */           appendDetail(buffer, fieldName, (char[])value);
/*      */         } else {
/*  547 */           appendSummary(buffer, fieldName, (char[])value);
/*      */         }
/*      */       
/*  550 */       } else if (value instanceof double[]) {
/*  551 */         if (detail) {
/*  552 */           appendDetail(buffer, fieldName, (double[])value);
/*      */         } else {
/*  554 */           appendSummary(buffer, fieldName, (double[])value);
/*      */         }
/*      */       
/*  557 */       } else if (value instanceof float[]) {
/*  558 */         if (detail) {
/*  559 */           appendDetail(buffer, fieldName, (float[])value);
/*      */         } else {
/*  561 */           appendSummary(buffer, fieldName, (float[])value);
/*      */         }
/*      */       
/*  564 */       } else if (value instanceof boolean[]) {
/*  565 */         if (detail) {
/*  566 */           appendDetail(buffer, fieldName, (boolean[])value);
/*      */         } else {
/*  568 */           appendSummary(buffer, fieldName, (boolean[])value);
/*      */         }
/*      */       
/*  571 */       } else if (value.getClass().isArray()) {
/*  572 */         if (detail) {
/*  573 */           appendDetail(buffer, fieldName, (Object[])value);
/*      */         } else {
/*  575 */           appendSummary(buffer, fieldName, (Object[])value);
/*      */         }
/*      */       
/*  578 */       } else if (detail) {
/*  579 */         appendDetail(buffer, fieldName, value);
/*      */       } else {
/*  581 */         appendSummary(buffer, fieldName, value);
/*      */       } 
/*      */     } finally {
/*  584 */       unregister(value);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendCyclicObject(StringBuffer buffer, String fieldName, Object value) {
/*  601 */     ObjectUtils.identityToString(buffer, value);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
/*  614 */     buffer.append(value);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
/*  626 */     buffer.append(coll);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Map<?, ?> map) {
/*  638 */     buffer.append(map);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, Object value) {
/*  651 */     buffer.append(this.summaryObjectStartText);
/*  652 */     buffer.append(getShortClassName(value.getClass()));
/*  653 */     buffer.append(this.summaryObjectEndText);
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
/*      */   public void append(StringBuffer buffer, String fieldName, long value) {
/*  667 */     appendFieldStart(buffer, fieldName);
/*  668 */     appendDetail(buffer, fieldName, value);
/*  669 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, long value) {
/*  681 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, int value) {
/*  695 */     appendFieldStart(buffer, fieldName);
/*  696 */     appendDetail(buffer, fieldName, value);
/*  697 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, int value) {
/*  709 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, short value) {
/*  723 */     appendFieldStart(buffer, fieldName);
/*  724 */     appendDetail(buffer, fieldName, value);
/*  725 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, short value) {
/*  737 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, byte value) {
/*  751 */     appendFieldStart(buffer, fieldName);
/*  752 */     appendDetail(buffer, fieldName, value);
/*  753 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, byte value) {
/*  765 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, char value) {
/*  779 */     appendFieldStart(buffer, fieldName);
/*  780 */     appendDetail(buffer, fieldName, value);
/*  781 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, char value) {
/*  793 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, double value) {
/*  807 */     appendFieldStart(buffer, fieldName);
/*  808 */     appendDetail(buffer, fieldName, value);
/*  809 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, double value) {
/*  821 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, float value) {
/*  835 */     appendFieldStart(buffer, fieldName);
/*  836 */     appendDetail(buffer, fieldName, value);
/*  837 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, float value) {
/*  849 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, boolean value) {
/*  863 */     appendFieldStart(buffer, fieldName);
/*  864 */     appendDetail(buffer, fieldName, value);
/*  865 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, boolean value) {
/*  877 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
/*  891 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  893 */     if (array == null) {
/*  894 */       appendNullText(buffer, fieldName);
/*      */     }
/*  896 */     else if (isFullDetail(fullDetail)) {
/*  897 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/*  900 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/*  903 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Object[] array) {
/*  918 */     buffer.append(this.arrayStart);
/*  919 */     for (int i = 0; i < array.length; i++) {
/*  920 */       Object item = array[i];
/*  921 */       appendDetail(buffer, fieldName, i, item);
/*      */     } 
/*  923 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, int i, Object item) {
/*  937 */     if (i > 0) {
/*  938 */       buffer.append(this.arraySeparator);
/*      */     }
/*  940 */     if (item == null) {
/*  941 */       appendNullText(buffer, fieldName);
/*      */     } else {
/*  943 */       appendInternal(buffer, fieldName, item, this.arrayContentDetail);
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
/*      */ 
/*      */   
/*      */   protected void reflectionAppendArrayDetail(StringBuffer buffer, String fieldName, Object array) {
/*  957 */     buffer.append(this.arrayStart);
/*  958 */     int length = Array.getLength(array);
/*  959 */     for (int i = 0; i < length; i++) {
/*  960 */       Object item = Array.get(array, i);
/*  961 */       appendDetail(buffer, fieldName, i, item);
/*      */     } 
/*  963 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, Object[] array) {
/*  976 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, long[] array, Boolean fullDetail) {
/*  992 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  994 */     if (array == null) {
/*  995 */       appendNullText(buffer, fieldName);
/*      */     }
/*  997 */     else if (isFullDetail(fullDetail)) {
/*  998 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1001 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1004 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, long[] array) {
/* 1017 */     buffer.append(this.arrayStart);
/* 1018 */     for (int i = 0; i < array.length; i++) {
/* 1019 */       if (i > 0) {
/* 1020 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1022 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1024 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, long[] array) {
/* 1037 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, int[] array, Boolean fullDetail) {
/* 1053 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1055 */     if (array == null) {
/* 1056 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1058 */     else if (isFullDetail(fullDetail)) {
/* 1059 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1062 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1065 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
/* 1078 */     buffer.append(this.arrayStart);
/* 1079 */     for (int i = 0; i < array.length; i++) {
/* 1080 */       if (i > 0) {
/* 1081 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1083 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1085 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, int[] array) {
/* 1098 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, short[] array, Boolean fullDetail) {
/* 1114 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1116 */     if (array == null) {
/* 1117 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1119 */     else if (isFullDetail(fullDetail)) {
/* 1120 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1123 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1126 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, short[] array) {
/* 1139 */     buffer.append(this.arrayStart);
/* 1140 */     for (int i = 0; i < array.length; i++) {
/* 1141 */       if (i > 0) {
/* 1142 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1144 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1146 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, short[] array) {
/* 1159 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, byte[] array, Boolean fullDetail) {
/* 1175 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1177 */     if (array == null) {
/* 1178 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1180 */     else if (isFullDetail(fullDetail)) {
/* 1181 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1184 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1187 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
/* 1200 */     buffer.append(this.arrayStart);
/* 1201 */     for (int i = 0; i < array.length; i++) {
/* 1202 */       if (i > 0) {
/* 1203 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1205 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1207 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, byte[] array) {
/* 1220 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, char[] array, Boolean fullDetail) {
/* 1236 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1238 */     if (array == null) {
/* 1239 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1241 */     else if (isFullDetail(fullDetail)) {
/* 1242 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1245 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1248 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, char[] array) {
/* 1261 */     buffer.append(this.arrayStart);
/* 1262 */     for (int i = 0; i < array.length; i++) {
/* 1263 */       if (i > 0) {
/* 1264 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1266 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1268 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, char[] array) {
/* 1281 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, double[] array, Boolean fullDetail) {
/* 1297 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1299 */     if (array == null) {
/* 1300 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1302 */     else if (isFullDetail(fullDetail)) {
/* 1303 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1306 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1309 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, double[] array) {
/* 1322 */     buffer.append(this.arrayStart);
/* 1323 */     for (int i = 0; i < array.length; i++) {
/* 1324 */       if (i > 0) {
/* 1325 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1327 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1329 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, double[] array) {
/* 1342 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, float[] array, Boolean fullDetail) {
/* 1358 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1360 */     if (array == null) {
/* 1361 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1363 */     else if (isFullDetail(fullDetail)) {
/* 1364 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1367 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1370 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, float[] array) {
/* 1383 */     buffer.append(this.arrayStart);
/* 1384 */     for (int i = 0; i < array.length; i++) {
/* 1385 */       if (i > 0) {
/* 1386 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1388 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1390 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, float[] array) {
/* 1403 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, boolean[] array, Boolean fullDetail) {
/* 1419 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1421 */     if (array == null) {
/* 1422 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1424 */     else if (isFullDetail(fullDetail)) {
/* 1425 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1428 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1431 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, boolean[] array) {
/* 1444 */     buffer.append(this.arrayStart);
/* 1445 */     for (int i = 0; i < array.length; i++) {
/* 1446 */       if (i > 0) {
/* 1447 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1449 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1451 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, boolean[] array) {
/* 1464 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   protected void appendClassName(StringBuffer buffer, Object object) {
/* 1476 */     if (this.useClassName && object != null) {
/* 1477 */       register(object);
/* 1478 */       if (this.useShortClassName) {
/* 1479 */         buffer.append(getShortClassName(object.getClass()));
/*      */       } else {
/* 1481 */         buffer.append(object.getClass().getName());
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
/*      */   protected void appendIdentityHashCode(StringBuffer buffer, Object object) {
/* 1493 */     if (isUseIdentityHashCode() && object != null) {
/* 1494 */       register(object);
/* 1495 */       buffer.append('@');
/* 1496 */       buffer.append(Integer.toHexString(System.identityHashCode(object)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentStart(StringBuffer buffer) {
/* 1506 */     buffer.append(this.contentStart);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentEnd(StringBuffer buffer) {
/* 1515 */     buffer.append(this.contentEnd);
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
/*      */   protected void appendNullText(StringBuffer buffer, String fieldName) {
/* 1527 */     buffer.append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldSeparator(StringBuffer buffer) {
/* 1536 */     buffer.append(this.fieldSeparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldStart(StringBuffer buffer, String fieldName) {
/* 1546 */     if (this.useFieldNames && fieldName != null) {
/* 1547 */       buffer.append(fieldName);
/* 1548 */       buffer.append(this.fieldNameValueSeparator);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldEnd(StringBuffer buffer, String fieldName) {
/* 1559 */     appendFieldSeparator(buffer);
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
/*      */ 
/*      */   
/*      */   protected void appendSummarySize(StringBuffer buffer, String fieldName, int size) {
/* 1578 */     buffer.append(this.sizeStartText);
/* 1579 */     buffer.append(size);
/* 1580 */     buffer.append(this.sizeEndText);
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
/*      */   
/*      */   protected boolean isFullDetail(Boolean fullDetailRequest) {
/* 1598 */     if (fullDetailRequest == null) {
/* 1599 */       return this.defaultFullDetail;
/*      */     }
/* 1601 */     return fullDetailRequest.booleanValue();
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
/*      */   protected String getShortClassName(Class<?> cls) {
/* 1614 */     return ClassUtils.getShortClassName(cls);
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
/*      */   protected boolean isUseClassName() {
/* 1628 */     return this.useClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseClassName(boolean useClassName) {
/* 1637 */     this.useClassName = useClassName;
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
/*      */   protected boolean isUseShortClassName() {
/* 1649 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseShortClassName(boolean useShortClassName) {
/* 1659 */     this.useShortClassName = useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseIdentityHashCode() {
/* 1670 */     return this.useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseIdentityHashCode(boolean useIdentityHashCode) {
/* 1679 */     this.useIdentityHashCode = useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseFieldNames() {
/* 1690 */     return this.useFieldNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseFieldNames(boolean useFieldNames) {
/* 1699 */     this.useFieldNames = useFieldNames;
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
/*      */   protected boolean isDefaultFullDetail() {
/* 1711 */     return this.defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setDefaultFullDetail(boolean defaultFullDetail) {
/* 1721 */     this.defaultFullDetail = defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isArrayContentDetail() {
/* 1732 */     return this.arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayContentDetail(boolean arrayContentDetail) {
/* 1741 */     this.arrayContentDetail = arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayStart() {
/* 1752 */     return this.arrayStart;
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
/*      */   protected void setArrayStart(String arrayStart) {
/* 1764 */     if (arrayStart == null) {
/* 1765 */       arrayStart = "";
/*      */     }
/* 1767 */     this.arrayStart = arrayStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayEnd() {
/* 1778 */     return this.arrayEnd;
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
/*      */   protected void setArrayEnd(String arrayEnd) {
/* 1790 */     if (arrayEnd == null) {
/* 1791 */       arrayEnd = "";
/*      */     }
/* 1793 */     this.arrayEnd = arrayEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArraySeparator() {
/* 1804 */     return this.arraySeparator;
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
/*      */   protected void setArraySeparator(String arraySeparator) {
/* 1816 */     if (arraySeparator == null) {
/* 1817 */       arraySeparator = "";
/*      */     }
/* 1819 */     this.arraySeparator = arraySeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentStart() {
/* 1830 */     return this.contentStart;
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
/*      */   protected void setContentStart(String contentStart) {
/* 1842 */     if (contentStart == null) {
/* 1843 */       contentStart = "";
/*      */     }
/* 1845 */     this.contentStart = contentStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentEnd() {
/* 1856 */     return this.contentEnd;
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
/*      */   protected void setContentEnd(String contentEnd) {
/* 1868 */     if (contentEnd == null) {
/* 1869 */       contentEnd = "";
/*      */     }
/* 1871 */     this.contentEnd = contentEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldNameValueSeparator() {
/* 1882 */     return this.fieldNameValueSeparator;
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
/*      */   protected void setFieldNameValueSeparator(String fieldNameValueSeparator) {
/* 1894 */     if (fieldNameValueSeparator == null) {
/* 1895 */       fieldNameValueSeparator = "";
/*      */     }
/* 1897 */     this.fieldNameValueSeparator = fieldNameValueSeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldSeparator() {
/* 1908 */     return this.fieldSeparator;
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
/*      */   protected void setFieldSeparator(String fieldSeparator) {
/* 1920 */     if (fieldSeparator == null) {
/* 1921 */       fieldSeparator = "";
/*      */     }
/* 1923 */     this.fieldSeparator = fieldSeparator;
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
/*      */   protected boolean isFieldSeparatorAtStart() {
/* 1936 */     return this.fieldSeparatorAtStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtStart(boolean fieldSeparatorAtStart) {
/* 1947 */     this.fieldSeparatorAtStart = fieldSeparatorAtStart;
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
/*      */   protected boolean isFieldSeparatorAtEnd() {
/* 1960 */     return this.fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtEnd(boolean fieldSeparatorAtEnd) {
/* 1971 */     this.fieldSeparatorAtEnd = fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getNullText() {
/* 1982 */     return this.nullText;
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
/*      */   protected void setNullText(String nullText) {
/* 1994 */     if (nullText == null) {
/* 1995 */       nullText = "";
/*      */     }
/* 1997 */     this.nullText = nullText;
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
/*      */   protected String getSizeStartText() {
/* 2011 */     return this.sizeStartText;
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
/*      */   protected void setSizeStartText(String sizeStartText) {
/* 2026 */     if (sizeStartText == null) {
/* 2027 */       sizeStartText = "";
/*      */     }
/* 2029 */     this.sizeStartText = sizeStartText;
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
/*      */   protected String getSizeEndText() {
/* 2043 */     return this.sizeEndText;
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
/*      */   protected void setSizeEndText(String sizeEndText) {
/* 2058 */     if (sizeEndText == null) {
/* 2059 */       sizeEndText = "";
/*      */     }
/* 2061 */     this.sizeEndText = sizeEndText;
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
/*      */   protected String getSummaryObjectStartText() {
/* 2075 */     return this.summaryObjectStartText;
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
/*      */   protected void setSummaryObjectStartText(String summaryObjectStartText) {
/* 2090 */     if (summaryObjectStartText == null) {
/* 2091 */       summaryObjectStartText = "";
/*      */     }
/* 2093 */     this.summaryObjectStartText = summaryObjectStartText;
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
/*      */   protected String getSummaryObjectEndText() {
/* 2107 */     return this.summaryObjectEndText;
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
/*      */   protected void setSummaryObjectEndText(String summaryObjectEndText) {
/* 2122 */     if (summaryObjectEndText == null) {
/* 2123 */       summaryObjectEndText = "";
/*      */     }
/* 2125 */     this.summaryObjectEndText = summaryObjectEndText;
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
/*      */   private static final class DefaultToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
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
/*      */     private Object readResolve() {
/* 2159 */       return DEFAULT_STYLE;
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
/*      */   private static final class NoFieldNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoFieldNameToStringStyle() {
/* 2183 */       setUseFieldNames(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2192 */       return NO_FIELD_NAMES_STYLE;
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
/*      */   private static final class ShortPrefixToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ShortPrefixToStringStyle() {
/* 2216 */       setUseShortClassName(true);
/* 2217 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2225 */       return SHORT_PREFIX_STYLE;
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
/*      */   private static final class SimpleToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SimpleToStringStyle() {
/* 2249 */       setUseClassName(false);
/* 2250 */       setUseIdentityHashCode(false);
/* 2251 */       setUseFieldNames(false);
/* 2252 */       setContentStart("");
/* 2253 */       setContentEnd("");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2261 */       return SIMPLE_STYLE;
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
/*      */   private static final class MultiLineToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MultiLineToStringStyle() {
/* 2284 */       setContentStart("[");
/* 2285 */       setFieldSeparator(System.lineSeparator() + "  ");
/* 2286 */       setFieldSeparatorAtStart(true);
/* 2287 */       setContentEnd(System.lineSeparator() + "]");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2296 */       return MULTI_LINE_STYLE;
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
/*      */   private static final class NoClassNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoClassNameToStringStyle() {
/* 2320 */       setUseClassName(false);
/* 2321 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2330 */       return NO_CLASS_NAME_STYLE;
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
/*      */ 
/*      */   
/*      */   private static final class JsonToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String FIELD_NAME_QUOTE = "\"";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     JsonToStringStyle() {
/* 2366 */       setUseClassName(false);
/* 2367 */       setUseIdentityHashCode(false);
/*      */       
/* 2369 */       setContentStart("{");
/* 2370 */       setContentEnd("}");
/*      */       
/* 2372 */       setArrayStart("[");
/* 2373 */       setArrayEnd("]");
/*      */       
/* 2375 */       setFieldSeparator(",");
/* 2376 */       setFieldNameValueSeparator(":");
/*      */       
/* 2378 */       setNullText("null");
/*      */       
/* 2380 */       setSummaryObjectStartText("\"<");
/* 2381 */       setSummaryObjectEndText(">\"");
/*      */       
/* 2383 */       setSizeStartText("\"<size=");
/* 2384 */       setSizeEndText(">\"");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
/* 2391 */       if (fieldName == null) {
/* 2392 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2395 */       if (!isFullDetail(fullDetail)) {
/* 2396 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2400 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, long[] array, Boolean fullDetail) {
/* 2407 */       if (fieldName == null) {
/* 2408 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2411 */       if (!isFullDetail(fullDetail)) {
/* 2412 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2416 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, int[] array, Boolean fullDetail) {
/* 2423 */       if (fieldName == null) {
/* 2424 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2427 */       if (!isFullDetail(fullDetail)) {
/* 2428 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2432 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, short[] array, Boolean fullDetail) {
/* 2439 */       if (fieldName == null) {
/* 2440 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2443 */       if (!isFullDetail(fullDetail)) {
/* 2444 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2448 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, byte[] array, Boolean fullDetail) {
/* 2455 */       if (fieldName == null) {
/* 2456 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2459 */       if (!isFullDetail(fullDetail)) {
/* 2460 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2464 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, char[] array, Boolean fullDetail) {
/* 2471 */       if (fieldName == null) {
/* 2472 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2475 */       if (!isFullDetail(fullDetail)) {
/* 2476 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2480 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, double[] array, Boolean fullDetail) {
/* 2487 */       if (fieldName == null) {
/* 2488 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2491 */       if (!isFullDetail(fullDetail)) {
/* 2492 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2496 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, float[] array, Boolean fullDetail) {
/* 2503 */       if (fieldName == null) {
/* 2504 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2507 */       if (!isFullDetail(fullDetail)) {
/* 2508 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2512 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, boolean[] array, Boolean fullDetail) {
/* 2519 */       if (fieldName == null) {
/* 2520 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2523 */       if (!isFullDetail(fullDetail)) {
/* 2524 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2528 */       super.append(buffer, fieldName, array, fullDetail);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
/* 2535 */       if (fieldName == null) {
/* 2536 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */       
/* 2539 */       if (!isFullDetail(fullDetail)) {
/* 2540 */         throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2544 */       super.append(buffer, fieldName, value, fullDetail);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer buffer, String fieldName, char value) {
/* 2549 */       appendValueAsString(buffer, String.valueOf(value));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
/* 2555 */       if (value == null) {
/* 2556 */         appendNullText(buffer, fieldName);
/*      */         
/*      */         return;
/*      */       } 
/* 2560 */       if (value instanceof String || value instanceof Character) {
/* 2561 */         appendValueAsString(buffer, value.toString());
/*      */         
/*      */         return;
/*      */       } 
/* 2565 */       if (value instanceof Number || value instanceof Boolean) {
/* 2566 */         buffer.append(value);
/*      */         
/*      */         return;
/*      */       } 
/* 2570 */       String valueAsString = value.toString();
/* 2571 */       if (isJsonObject(valueAsString) || isJsonArray(valueAsString)) {
/* 2572 */         buffer.append(value);
/*      */         
/*      */         return;
/*      */       } 
/* 2576 */       appendDetail(buffer, fieldName, valueAsString);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
/* 2581 */       if (coll != null && !coll.isEmpty()) {
/* 2582 */         buffer.append(getArrayStart());
/* 2583 */         int i = 0;
/* 2584 */         for (Object item : coll) {
/* 2585 */           appendDetail(buffer, fieldName, i++, item);
/*      */         }
/* 2587 */         buffer.append(getArrayEnd());
/*      */         
/*      */         return;
/*      */       } 
/* 2591 */       buffer.append(coll);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void appendDetail(StringBuffer buffer, String fieldName, Map<?, ?> map) {
/* 2596 */       if (map != null && !map.isEmpty()) {
/* 2597 */         buffer.append(getContentStart());
/*      */         
/* 2599 */         boolean firstItem = true;
/* 2600 */         for (Map.Entry<?, ?> entry : map.entrySet()) {
/* 2601 */           String keyStr = Objects.toString(entry.getKey(), null);
/* 2602 */           if (keyStr != null) {
/* 2603 */             if (firstItem) {
/* 2604 */               firstItem = false;
/*      */             } else {
/* 2606 */               appendFieldEnd(buffer, keyStr);
/*      */             } 
/* 2608 */             appendFieldStart(buffer, keyStr);
/* 2609 */             Object value = entry.getValue();
/* 2610 */             if (value == null) {
/* 2611 */               appendNullText(buffer, keyStr); continue;
/*      */             } 
/* 2613 */             appendInternal(buffer, keyStr, value, true);
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2618 */         buffer.append(getContentEnd());
/*      */         
/*      */         return;
/*      */       } 
/* 2622 */       buffer.append(map);
/*      */     }
/*      */     
/*      */     private boolean isJsonArray(String valueAsString) {
/* 2626 */       return (valueAsString.startsWith(getArrayStart()) && valueAsString
/* 2627 */         .endsWith(getArrayEnd()));
/*      */     }
/*      */     
/*      */     private boolean isJsonObject(String valueAsString) {
/* 2631 */       return (valueAsString.startsWith(getContentStart()) && valueAsString
/* 2632 */         .endsWith(getContentEnd()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void appendValueAsString(StringBuffer buffer, String value) {
/* 2642 */       buffer.append('"').append(StringEscapeUtils.escapeJson(value)).append('"');
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void appendFieldStart(StringBuffer buffer, String fieldName) {
/* 2648 */       if (fieldName == null) {
/* 2649 */         throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
/*      */       }
/*      */ 
/*      */       
/* 2653 */       super.appendFieldStart(buffer, "\"" + StringEscapeUtils.escapeJson(fieldName) + "\"");
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
/*      */     private Object readResolve() {
/* 2665 */       return JSON_STYLE;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\builder\ToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */