/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.time.Duration;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.TreeSet;
/*      */ import java.util.function.Supplier;
/*      */ import org.apache.commons.lang3.exception.CloneFailedException;
/*      */ import org.apache.commons.lang3.mutable.MutableInt;
/*      */ import org.apache.commons.lang3.text.StrBuilder;
/*      */ import org.apache.commons.lang3.time.DurationUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ObjectUtils
/*      */ {
/*      */   private static final char AT_SIGN = '@';
/*      */   
/*      */   public static class Null
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 7092611880189329093L;
/*      */     
/*      */     private Object readResolve() {
/*   89 */       return ObjectUtils.NULL;
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
/*  110 */   public static final Null NULL = new Null();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean allNotNull(Object... values) {
/*  138 */     if (values == null) {
/*  139 */       return false;
/*      */     }
/*      */     
/*  142 */     for (Object val : values) {
/*  143 */       if (val == null) {
/*  144 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  148 */     return true;
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
/*      */   public static boolean allNull(Object... values) {
/*  174 */     return !anyNotNull(values);
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
/*      */   public static boolean anyNotNull(Object... values) {
/*  201 */     return (firstNonNull(values) != null);
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
/*      */   public static boolean anyNull(Object... values) {
/*  229 */     return !allNotNull(values);
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
/*      */   public static <T> T clone(T obj) {
/*  244 */     if (obj instanceof Cloneable) {
/*      */       Object result;
/*  246 */       if (obj.getClass().isArray()) {
/*  247 */         Class<?> componentType = obj.getClass().getComponentType();
/*  248 */         if (componentType.isPrimitive()) {
/*  249 */           int length = Array.getLength(obj);
/*  250 */           result = Array.newInstance(componentType, length);
/*  251 */           while (length-- > 0) {
/*  252 */             Array.set(result, length, Array.get(obj, length));
/*      */           }
/*      */         } else {
/*  255 */           result = ((Object[])obj).clone();
/*      */         } 
/*      */       } else {
/*      */         try {
/*  259 */           Method clone = obj.getClass().getMethod("clone", new Class[0]);
/*  260 */           result = clone.invoke(obj, new Object[0]);
/*  261 */         } catch (NoSuchMethodException e) {
/*  262 */           throw new CloneFailedException("Cloneable type " + obj
/*  263 */               .getClass().getName() + " has no clone method", e);
/*      */         }
/*  265 */         catch (IllegalAccessException e) {
/*  266 */           throw new CloneFailedException("Cannot clone Cloneable type " + obj
/*  267 */               .getClass().getName(), e);
/*  268 */         } catch (InvocationTargetException e) {
/*  269 */           throw new CloneFailedException("Exception cloning Cloneable type " + obj
/*  270 */               .getClass().getName(), e.getCause());
/*      */         } 
/*      */       } 
/*      */       
/*  274 */       T checked = (T)result;
/*  275 */       return checked;
/*      */     } 
/*      */     
/*  278 */     return null;
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
/*      */   public static <T> T cloneIfPossible(T obj) {
/*  298 */     T clone = clone(obj);
/*  299 */     return (clone == null) ? obj : clone;
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
/*      */   public static <T extends Comparable<? super T>> int compare(T c1, T c2) {
/*  313 */     return compare(c1, c2, false);
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
/*      */   public static <T extends Comparable<? super T>> int compare(T c1, T c2, boolean nullGreater) {
/*  330 */     if (c1 == c2)
/*  331 */       return 0; 
/*  332 */     if (c1 == null)
/*  333 */       return nullGreater ? 1 : -1; 
/*  334 */     if (c2 == null) {
/*  335 */       return nullGreater ? -1 : 1;
/*      */     }
/*  337 */     return c1.compareTo(c2);
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
/*      */   public static boolean CONST(boolean v) {
/*  358 */     return v;
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
/*      */   public static byte CONST(byte v) {
/*  379 */     return v;
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
/*      */   public static char CONST(char v) {
/*  400 */     return v;
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
/*      */   public static double CONST(double v) {
/*  421 */     return v;
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
/*      */   public static float CONST(float v) {
/*  442 */     return v;
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
/*      */   public static int CONST(int v) {
/*  463 */     return v;
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
/*      */   public static long CONST(long v) {
/*  484 */     return v;
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
/*      */   public static short CONST(short v) {
/*  505 */     return v;
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
/*      */   public static <T> T CONST(T v) {
/*  527 */     return v;
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
/*      */   public static byte CONST_BYTE(int v) {
/*  551 */     if (v < -128 || v > 127) {
/*  552 */       throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + v + "]");
/*      */     }
/*  554 */     return (byte)v;
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
/*      */   public static short CONST_SHORT(int v) {
/*  578 */     if (v < -32768 || v > 32767) {
/*  579 */       throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + v + "]");
/*      */     }
/*  581 */     return (short)v;
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
/*      */   public static <T> T defaultIfNull(T object, T defaultValue) {
/*  602 */     return (object != null) ? object : defaultValue;
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
/*      */   @Deprecated
/*      */   public static boolean equals(Object object1, Object object2) {
/*  630 */     if (object1 == object2) {
/*  631 */       return true;
/*      */     }
/*  633 */     if (object1 == null || object2 == null) {
/*  634 */       return false;
/*      */     }
/*  636 */     return object1.equals(object2);
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
/*      */   @SafeVarargs
/*      */   public static <T> T firstNonNull(T... values) {
/*  663 */     if (values != null) {
/*  664 */       for (T val : values) {
/*  665 */         if (val != null) {
/*  666 */           return val;
/*      */         }
/*      */       } 
/*      */     }
/*  670 */     return null;
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
/*      */   @SafeVarargs
/*      */   public static <T> T getFirstNonNull(Supplier<T>... suppliers) {
/*  699 */     if (suppliers != null) {
/*  700 */       for (Supplier<T> supplier : suppliers) {
/*  701 */         if (supplier != null) {
/*  702 */           T value = supplier.get();
/*  703 */           if (value != null) {
/*  704 */             return value;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*  709 */     return null;
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
/*      */   public static <T> T getIfNull(T object, Supplier<T> defaultSupplier) {
/*  738 */     return (object != null) ? object : ((defaultSupplier == null) ? null : defaultSupplier.get());
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
/*      */   @Deprecated
/*      */   public static int hashCode(Object obj) {
/*  759 */     return (obj == null) ? 0 : obj.hashCode();
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
/*      */   @Deprecated
/*      */   public static int hashCodeMulti(Object... objects) {
/*  786 */     int hash = 1;
/*  787 */     if (objects != null) {
/*  788 */       for (Object object : objects) {
/*  789 */         int tmpHash = hashCode(object);
/*  790 */         hash = hash * 31 + tmpHash;
/*      */       } 
/*      */     }
/*  793 */     return hash;
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
/*      */   public static void identityToString(Appendable appendable, Object object) throws IOException {
/*  813 */     Validate.notNull(object, "object", new Object[0]);
/*  814 */     appendable.append(object.getClass().getName())
/*  815 */       .append('@')
/*  816 */       .append(Integer.toHexString(System.identityHashCode(object)));
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
/*      */   public static String identityToString(Object object) {
/*  838 */     if (object == null) {
/*  839 */       return null;
/*      */     }
/*  841 */     String name = object.getClass().getName();
/*  842 */     String hexString = Integer.toHexString(System.identityHashCode(object));
/*  843 */     StringBuilder builder = new StringBuilder(name.length() + 1 + hexString.length());
/*      */     
/*  845 */     builder.append(name)
/*  846 */       .append('@')
/*  847 */       .append(hexString);
/*      */     
/*  849 */     return builder.toString();
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
/*      */   @Deprecated
/*      */   public static void identityToString(StrBuilder builder, Object object) {
/*  871 */     Validate.notNull(object, "object", new Object[0]);
/*  872 */     String name = object.getClass().getName();
/*  873 */     String hexString = Integer.toHexString(System.identityHashCode(object));
/*  874 */     builder.ensureCapacity(builder.length() + name.length() + 1 + hexString.length());
/*  875 */     builder.append(name)
/*  876 */       .append('@')
/*  877 */       .append(hexString);
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
/*      */   public static void identityToString(StringBuffer buffer, Object object) {
/*  896 */     Validate.notNull(object, "object", new Object[0]);
/*  897 */     String name = object.getClass().getName();
/*  898 */     String hexString = Integer.toHexString(System.identityHashCode(object));
/*  899 */     buffer.ensureCapacity(buffer.length() + name.length() + 1 + hexString.length());
/*  900 */     buffer.append(name)
/*  901 */       .append('@')
/*  902 */       .append(hexString);
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
/*      */   public static void identityToString(StringBuilder builder, Object object) {
/*  921 */     Validate.notNull(object, "object", new Object[0]);
/*  922 */     String name = object.getClass().getName();
/*  923 */     String hexString = Integer.toHexString(System.identityHashCode(object));
/*  924 */     builder.ensureCapacity(builder.length() + name.length() + 1 + hexString.length());
/*  925 */     builder.append(name)
/*  926 */       .append('@')
/*  927 */       .append(hexString);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(Object object) {
/*  980 */     if (object == null) {
/*  981 */       return true;
/*      */     }
/*  983 */     if (object instanceof CharSequence) {
/*  984 */       return (((CharSequence)object).length() == 0);
/*      */     }
/*  986 */     if (object.getClass().isArray()) {
/*  987 */       return (Array.getLength(object) == 0);
/*      */     }
/*  989 */     if (object instanceof Collection) {
/*  990 */       return ((Collection)object).isEmpty();
/*      */     }
/*  992 */     if (object instanceof Map) {
/*  993 */       return ((Map)object).isEmpty();
/*      */     }
/*  995 */     return false;
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
/*      */   public static boolean isNotEmpty(Object object) {
/* 1024 */     return !isEmpty(object);
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
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T max(T... values) {
/* 1042 */     T result = null;
/* 1043 */     if (values != null) {
/* 1044 */       for (T value : values) {
/* 1045 */         if (compare(value, result, false) > 0) {
/* 1046 */           result = value;
/*      */         }
/*      */       } 
/*      */     }
/* 1050 */     return result;
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
/*      */   @SafeVarargs
/*      */   public static <T> T median(Comparator<T> comparator, T... items) {
/* 1066 */     Validate.notEmpty(items, "null/empty items", new Object[0]);
/* 1067 */     Validate.noNullElements(items);
/* 1068 */     Validate.notNull(comparator, "comparator", new Object[0]);
/* 1069 */     TreeSet<T> sort = new TreeSet<>(comparator);
/* 1070 */     Collections.addAll(sort, items);
/*      */ 
/*      */     
/* 1073 */     T result = (T)sort.toArray()[(sort.size() - 1) / 2];
/* 1074 */     return result;
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
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T median(T... items) {
/* 1089 */     Validate.notEmpty(items);
/* 1090 */     Validate.noNullElements(items);
/* 1091 */     TreeSet<T> sort = new TreeSet<>();
/* 1092 */     Collections.addAll(sort, items);
/*      */     
/* 1094 */     return (T)sort.toArray()[(sort.size() - 1) / 2];
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
/*      */   @SafeVarargs
/*      */   public static <T extends Comparable<? super T>> T min(T... values) {
/* 1115 */     T result = null;
/* 1116 */     if (values != null) {
/* 1117 */       for (T value : values) {
/* 1118 */         if (compare(value, result, true) < 0) {
/* 1119 */           result = value;
/*      */         }
/*      */       } 
/*      */     }
/* 1123 */     return result;
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
/*      */   @SafeVarargs
/*      */   public static <T> T mode(T... items) {
/* 1139 */     if (ArrayUtils.isNotEmpty(items)) {
/* 1140 */       HashMap<T, MutableInt> occurrences = new HashMap<>(items.length);
/* 1141 */       for (T t : items) {
/* 1142 */         MutableInt count = occurrences.get(t);
/* 1143 */         if (count == null) {
/* 1144 */           occurrences.put(t, new MutableInt(1));
/*      */         } else {
/* 1146 */           count.increment();
/*      */         } 
/*      */       } 
/* 1149 */       T result = null;
/* 1150 */       int max = 0;
/* 1151 */       for (Map.Entry<T, MutableInt> e : occurrences.entrySet()) {
/* 1152 */         int cmp = ((MutableInt)e.getValue()).intValue();
/* 1153 */         if (cmp == max) {
/* 1154 */           result = null; continue;
/* 1155 */         }  if (cmp > max) {
/* 1156 */           max = cmp;
/* 1157 */           result = e.getKey();
/*      */         } 
/*      */       } 
/* 1160 */       return result;
/*      */     } 
/* 1162 */     return null;
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
/*      */   public static boolean notEqual(Object object1, Object object2) {
/* 1185 */     return !equals(object1, object2);
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
/*      */   public static <T> T requireNonEmpty(T obj) {
/* 1211 */     return requireNonEmpty(obj, "object");
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
/*      */   public static <T> T requireNonEmpty(T obj, String message) {
/* 1239 */     Objects.requireNonNull(obj, message);
/* 1240 */     if (isEmpty(obj)) {
/* 1241 */       throw new IllegalArgumentException(message);
/*      */     }
/* 1243 */     return obj;
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
/*      */   @Deprecated
/*      */   public static String toString(Object obj) {
/* 1270 */     return (obj == null) ? "" : obj.toString();
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
/*      */   @Deprecated
/*      */   public static String toString(Object obj, String nullStr) {
/* 1295 */     return (obj == null) ? nullStr : obj.toString();
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
/*      */   public static String toString(Object obj, Supplier<String> supplier) {
/* 1319 */     return (obj == null) ? ((supplier == null) ? null : supplier.get()) : obj.toString();
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
/*      */   public static void wait(Object obj, Duration duration) throws InterruptedException {
/* 1336 */     DurationUtils.accept(obj::wait, DurationUtils.zeroIfNull(duration));
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\ObjectUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */