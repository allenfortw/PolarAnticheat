/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.util.Iterator;
/*      */ import java.util.Objects;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Validate
/*      */ {
/*      */   private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
/*      */   private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
/*      */   private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
/*      */   private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
/*      */   private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
/*      */   private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
/*      */   private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
/*      */   private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
/*      */   private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
/*      */   private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
/*      */   private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
/*      */   private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
/*      */   private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
/*      */   private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";
/*      */   private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
/*      */   private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
/*      */   
/*      */   public static void isTrue(boolean expression, String message, long value) {
/*  108 */     if (!expression) {
/*  109 */       throw new IllegalArgumentException(String.format(message, new Object[] { Long.valueOf(value) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isTrue(boolean expression, String message, double value) {
/*  133 */     if (!expression) {
/*  134 */       throw new IllegalArgumentException(String.format(message, new Object[] { Double.valueOf(value) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isTrue(boolean expression, String message, Object... values) {
/*  157 */     if (!expression) {
/*  158 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isTrue(boolean expression) {
/*  182 */     if (!expression) {
/*  183 */       throw new IllegalArgumentException("The validated expression is false");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T notNull(T object) {
/*  206 */     return notNull(object, "The validated object is null", new Object[0]);
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
/*      */   public static <T> T notNull(T object, String message, Object... values) {
/*  224 */     return Objects.requireNonNull(object, () -> String.format(message, values));
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
/*      */   public static <T> T[] notEmpty(T[] array, String message, Object... values) {
/*  247 */     Objects.requireNonNull(array, () -> String.format(message, values));
/*  248 */     if (array.length == 0) {
/*  249 */       throw new IllegalArgumentException(String.format(message, values));
/*      */     }
/*  251 */     return array;
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
/*      */   public static <T> T[] notEmpty(T[] array) {
/*  271 */     return notEmpty(array, "The validated array is empty", new Object[0]);
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
/*      */   public static <T extends java.util.Collection<?>> T notEmpty(T collection, String message, Object... values) {
/*  294 */     Objects.requireNonNull(collection, () -> String.format(message, values));
/*  295 */     if (collection.isEmpty()) {
/*  296 */       throw new IllegalArgumentException(String.format(message, values));
/*      */     }
/*  298 */     return collection;
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
/*      */   public static <T extends java.util.Collection<?>> T notEmpty(T collection) {
/*  318 */     return notEmpty(collection, "The validated collection is empty", new Object[0]);
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
/*      */   public static <T extends java.util.Map<?, ?>> T notEmpty(T map, String message, Object... values) {
/*  341 */     Objects.requireNonNull(map, () -> String.format(message, values));
/*  342 */     if (map.isEmpty()) {
/*  343 */       throw new IllegalArgumentException(String.format(message, values));
/*      */     }
/*  345 */     return map;
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
/*      */   public static <T extends java.util.Map<?, ?>> T notEmpty(T map) {
/*  365 */     return notEmpty(map, "The validated map is empty", new Object[0]);
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
/*      */   public static <T extends CharSequence> T notEmpty(T chars, String message, Object... values) {
/*  388 */     Objects.requireNonNull(chars, () -> String.format(message, values));
/*  389 */     if (chars.length() == 0) {
/*  390 */       throw new IllegalArgumentException(String.format(message, values));
/*      */     }
/*  392 */     return chars;
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
/*      */   public static <T extends CharSequence> T notEmpty(T chars) {
/*  413 */     return notEmpty(chars, "The validated character sequence is empty", new Object[0]);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T notBlank(T chars, String message, Object... values) {
/*  439 */     Objects.requireNonNull(chars, () -> String.format(message, values));
/*  440 */     if (StringUtils.isBlank((CharSequence)chars)) {
/*  441 */       throw new IllegalArgumentException(String.format(message, values));
/*      */     }
/*  443 */     return chars;
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
/*      */   public static <T extends CharSequence> T notBlank(T chars) {
/*  466 */     return notBlank(chars, "The validated character sequence is blank", new Object[0]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] noNullElements(T[] array, String message, Object... values) {
/*  496 */     notNull(array);
/*  497 */     for (int i = 0; i < array.length; i++) {
/*  498 */       if (array[i] == null) {
/*  499 */         Object[] values2 = ArrayUtils.add(values, Integer.valueOf(i));
/*  500 */         throw new IllegalArgumentException(String.format(message, values2));
/*      */       } 
/*      */     } 
/*  503 */     return array;
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
/*      */ 
/*      */   
/*      */   public static <T> T[] noNullElements(T[] array) {
/*  528 */     return noNullElements(array, "The validated array contains null element at index: %d", new Object[0]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Iterable<?>> T noNullElements(T iterable, String message, Object... values) {
/*  558 */     notNull(iterable);
/*  559 */     int i = 0;
/*  560 */     for (Iterator<?> it = iterable.iterator(); it.hasNext(); i++) {
/*  561 */       if (it.next() == null) {
/*  562 */         Object[] values2 = ArrayUtils.addAll(values, new Object[] { Integer.valueOf(i) });
/*  563 */         throw new IllegalArgumentException(String.format(message, values2));
/*      */       } 
/*      */     } 
/*  566 */     return iterable;
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
/*      */ 
/*      */   
/*      */   public static <T extends Iterable<?>> T noNullElements(T iterable) {
/*  591 */     return noNullElements(iterable, "The validated collection contains null element at index: %d", new Object[0]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] validIndex(T[] array, int index, String message, Object... values) {
/*  619 */     notNull(array);
/*  620 */     if (index < 0 || index >= array.length) {
/*  621 */       throw new IndexOutOfBoundsException(String.format(message, values));
/*      */     }
/*  623 */     return array;
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T[] validIndex(T[] array, int index) {
/*  650 */     return validIndex(array, index, "The validated array index is invalid: %d", new Object[] { Integer.valueOf(index) });
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T validIndex(T collection, int index, String message, Object... values) {
/*  678 */     notNull(collection);
/*  679 */     if (index < 0 || index >= collection.size()) {
/*  680 */       throw new IndexOutOfBoundsException(String.format(message, values));
/*      */     }
/*  682 */     return collection;
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
/*      */   
/*      */   public static <T extends java.util.Collection<?>> T validIndex(T collection, int index) {
/*  706 */     return validIndex(collection, index, "The validated collection index is invalid: %d", new Object[] { Integer.valueOf(index) });
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T validIndex(T chars, int index, String message, Object... values) {
/*  735 */     notNull(chars);
/*  736 */     if (index < 0 || index >= chars.length()) {
/*  737 */       throw new IndexOutOfBoundsException(String.format(message, values));
/*      */     }
/*  739 */     return chars;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CharSequence> T validIndex(T chars, int index) {
/*  767 */     return validIndex(chars, index, "The validated character sequence index is invalid: %d", new Object[] { Integer.valueOf(index) });
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void validState(boolean expression) {
/*  793 */     if (!expression) {
/*  794 */       throw new IllegalStateException("The validated state is false");
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void validState(boolean expression, String message, Object... values) {
/*  815 */     if (!expression) {
/*  816 */       throw new IllegalStateException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void matchesPattern(CharSequence input, String pattern) {
/*  840 */     if (!Pattern.matches(pattern, input)) {
/*  841 */       throw new IllegalArgumentException(String.format("The string %s does not match the pattern %s", new Object[] { input, pattern }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void matchesPattern(CharSequence input, String pattern, String message, Object... values) {
/*  864 */     if (!Pattern.matches(pattern, input)) {
/*  865 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void notNaN(double value) {
/*  888 */     notNaN(value, "The validated value is not a number", new Object[0]);
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
/*      */   public static void notNaN(double value, String message, Object... values) {
/*  906 */     if (Double.isNaN(value)) {
/*  907 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void finite(double value) {
/*  929 */     finite(value, "The value is invalid: %f", new Object[] { Double.valueOf(value) });
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
/*      */   public static void finite(double value, String message, Object... values) {
/*  947 */     if (Double.isNaN(value) || Double.isInfinite(value)) {
/*  948 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> void inclusiveBetween(T start, T end, Comparable<T> value) {
/*  972 */     if (value.compareTo(start) < 0 || value.compareTo(end) > 0) {
/*  973 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { value, start, end }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> void inclusiveBetween(T start, T end, Comparable<T> value, String message, Object... values) {
/*  997 */     if (value.compareTo(start) < 0 || value.compareTo(end) > 0) {
/*  998 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */   
/*      */   public static void inclusiveBetween(long start, long end, long value) {
/* 1018 */     if (value < start || value > end) {
/* 1019 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Long.valueOf(value), Long.valueOf(start), Long.valueOf(end) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void inclusiveBetween(long start, long end, long value, String message) {
/* 1041 */     if (value < start || value > end) {
/* 1042 */       throw new IllegalArgumentException(message);
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
/*      */ 
/*      */   
/*      */   public static void inclusiveBetween(double start, double end, double value) {
/* 1062 */     if (value < start || value > end) {
/* 1063 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified inclusive range of %s to %s", new Object[] { Double.valueOf(value), Double.valueOf(start), Double.valueOf(end) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void inclusiveBetween(double start, double end, double value, String message) {
/* 1085 */     if (value < start || value > end) {
/* 1086 */       throw new IllegalArgumentException(message);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> void exclusiveBetween(T start, T end, Comparable<T> value) {
/* 1110 */     if (value.compareTo(start) <= 0 || value.compareTo(end) >= 0) {
/* 1111 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { value, start, end }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> void exclusiveBetween(T start, T end, Comparable<T> value, String message, Object... values) {
/* 1135 */     if (value.compareTo(start) <= 0 || value.compareTo(end) >= 0) {
/* 1136 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */   
/*      */   public static void exclusiveBetween(long start, long end, long value) {
/* 1156 */     if (value <= start || value >= end) {
/* 1157 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Long.valueOf(value), Long.valueOf(start), Long.valueOf(end) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void exclusiveBetween(long start, long end, long value, String message) {
/* 1179 */     if (value <= start || value >= end) {
/* 1180 */       throw new IllegalArgumentException(message);
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
/*      */ 
/*      */   
/*      */   public static void exclusiveBetween(double start, double end, double value) {
/* 1200 */     if (value <= start || value >= end) {
/* 1201 */       throw new IllegalArgumentException(String.format("The value %s is not in the specified exclusive range of %s to %s", new Object[] { Double.valueOf(value), Double.valueOf(start), Double.valueOf(end) }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void exclusiveBetween(double start, double end, double value, String message) {
/* 1223 */     if (value <= start || value >= end) {
/* 1224 */       throw new IllegalArgumentException(message);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isInstanceOf(Class<?> type, Object obj) {
/* 1249 */     if (!type.isInstance(obj)) {
/* 1250 */       throw new IllegalArgumentException(String.format("Expected type: %s, actual: %s", new Object[] { type.getName(), (obj == null) ? "null" : obj
/* 1251 */               .getClass().getName() }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isInstanceOf(Class<?> type, Object obj, String message, Object... values) {
/* 1274 */     if (!type.isInstance(obj)) {
/* 1275 */       throw new IllegalArgumentException(String.format(message, values));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isAssignableFrom(Class<?> superType, Class<?> type) {
/* 1300 */     if (!superType.isAssignableFrom(type)) {
/* 1301 */       throw new IllegalArgumentException(String.format("Cannot assign a %s to a %s", new Object[] { (type == null) ? "null" : type.getName(), superType
/* 1302 */               .getName() }));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void isAssignableFrom(Class<?> superType, Class<?> type, String message, Object... values) {
/* 1325 */     if (!superType.isAssignableFrom(type))
/* 1326 */       throw new IllegalArgumentException(String.format(message, values)); 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\Validate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */