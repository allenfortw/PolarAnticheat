/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.mutable.MutableObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassUtils
/*      */ {
/*      */   public static final char PACKAGE_SEPARATOR_CHAR = '.';
/*      */   
/*      */   public enum Interfaces
/*      */   {
/*   55 */     INCLUDE,
/*      */ 
/*      */     
/*   58 */     EXCLUDE;
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
/*   69 */   public static final String PACKAGE_SEPARATOR = String.valueOf('.');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   79 */   public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   84 */   private static final Map<String, Class<?>> namePrimitiveMap = new HashMap<>();
/*      */   static {
/*   86 */     namePrimitiveMap.put("boolean", boolean.class);
/*   87 */     namePrimitiveMap.put("byte", byte.class);
/*   88 */     namePrimitiveMap.put("char", char.class);
/*   89 */     namePrimitiveMap.put("short", short.class);
/*   90 */     namePrimitiveMap.put("int", int.class);
/*   91 */     namePrimitiveMap.put("long", long.class);
/*   92 */     namePrimitiveMap.put("double", double.class);
/*   93 */     namePrimitiveMap.put("float", float.class);
/*   94 */     namePrimitiveMap.put("void", void.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  100 */   private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<>();
/*      */   static {
/*  102 */     primitiveWrapperMap.put(boolean.class, Boolean.class);
/*  103 */     primitiveWrapperMap.put(byte.class, Byte.class);
/*  104 */     primitiveWrapperMap.put(char.class, Character.class);
/*  105 */     primitiveWrapperMap.put(short.class, Short.class);
/*  106 */     primitiveWrapperMap.put(int.class, Integer.class);
/*  107 */     primitiveWrapperMap.put(long.class, Long.class);
/*  108 */     primitiveWrapperMap.put(double.class, Double.class);
/*  109 */     primitiveWrapperMap.put(float.class, Float.class);
/*  110 */     primitiveWrapperMap.put(void.class, void.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  116 */   private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();
/*      */   static {
/*  118 */     for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
/*  119 */       Class<?> primitiveClass = entry.getKey();
/*  120 */       Class<?> wrapperClass = entry.getValue();
/*  121 */       if (!primitiveClass.equals(wrapperClass)) {
/*  122 */         wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
/*      */       }
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
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  138 */     Map<String, String> m = new HashMap<>();
/*  139 */     m.put("int", "I");
/*  140 */     m.put("boolean", "Z");
/*  141 */     m.put("float", "F");
/*  142 */     m.put("long", "J");
/*  143 */     m.put("short", "S");
/*  144 */     m.put("byte", "B");
/*  145 */     m.put("double", "D");
/*  146 */     m.put("char", "C");
/*  147 */     Map<String, String> r = new HashMap<>();
/*  148 */     for (Map.Entry<String, String> e : m.entrySet()) {
/*  149 */       r.put(e.getValue(), e.getKey());
/*      */     }
/*  151 */     abbreviationMap = Collections.unmodifiableMap(m);
/*  152 */     reverseAbbreviationMap = Collections.unmodifiableMap(r);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Map<String, String> abbreviationMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Map<String, String> reverseAbbreviationMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortClassName(Object object, String valueIfNull) {
/*  180 */     if (object == null) {
/*  181 */       return valueIfNull;
/*      */     }
/*  183 */     return getShortClassName(object.getClass());
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
/*      */   public static String getShortClassName(Class<?> cls) {
/*  198 */     if (cls == null) {
/*  199 */       return "";
/*      */     }
/*  201 */     return getShortClassName(cls.getName());
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
/*      */   public static String getShortClassName(String className) {
/*  230 */     if (StringUtils.isEmpty(className)) {
/*  231 */       return "";
/*      */     }
/*      */     
/*  234 */     StringBuilder arrayPrefix = new StringBuilder();
/*      */ 
/*      */     
/*  237 */     if (className.startsWith("[")) {
/*  238 */       while (className.charAt(0) == '[') {
/*  239 */         className = className.substring(1);
/*  240 */         arrayPrefix.append("[]");
/*      */       } 
/*      */       
/*  243 */       if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
/*  244 */         className = className.substring(1, className.length() - 1);
/*      */       }
/*      */       
/*  247 */       if (reverseAbbreviationMap.containsKey(className)) {
/*  248 */         className = reverseAbbreviationMap.get(className);
/*      */       }
/*      */     } 
/*      */     
/*  252 */     int lastDotIdx = className.lastIndexOf('.');
/*  253 */     int innerIdx = className.indexOf('$', (lastDotIdx == -1) ? 0 : (lastDotIdx + 1));
/*      */     
/*  255 */     String out = className.substring(lastDotIdx + 1);
/*  256 */     if (innerIdx != -1) {
/*  257 */       out = out.replace('$', '.');
/*      */     }
/*  259 */     return out + arrayPrefix;
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
/*      */   public static String getSimpleName(Class<?> cls) {
/*  271 */     return getSimpleName(cls, "");
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
/*      */   public static String getSimpleName(Class<?> cls, String valueIfNull) {
/*  285 */     return (cls == null) ? valueIfNull : cls.getSimpleName();
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
/*      */   public static String getSimpleName(Object object) {
/*  303 */     return getSimpleName(object, "");
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
/*      */   public static String getSimpleName(Object object, String valueIfNull) {
/*  317 */     return (object == null) ? valueIfNull : object.getClass().getSimpleName();
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
/*      */   public static String getName(Class<?> cls) {
/*  329 */     return getName(cls, "");
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
/*      */   public static String getName(Class<?> cls, String valueIfNull) {
/*  342 */     return (cls == null) ? valueIfNull : cls.getName();
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
/*      */   public static String getName(Object object) {
/*  354 */     return getName(object, "");
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
/*      */   public static String getName(Object object, String valueIfNull) {
/*  367 */     return (object == null) ? valueIfNull : object.getClass().getName();
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
/*      */   public static String getPackageName(Object object, String valueIfNull) {
/*  380 */     if (object == null) {
/*  381 */       return valueIfNull;
/*      */     }
/*  383 */     return getPackageName(object.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageName(Class<?> cls) {
/*  393 */     if (cls == null) {
/*  394 */       return "";
/*      */     }
/*  396 */     return getPackageName(cls.getName());
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
/*      */   public static String getPackageName(String className) {
/*  409 */     if (StringUtils.isEmpty(className)) {
/*  410 */       return "";
/*      */     }
/*      */ 
/*      */     
/*  414 */     while (className.charAt(0) == '[') {
/*  415 */       className = className.substring(1);
/*      */     }
/*      */     
/*  418 */     if (className.charAt(0) == 'L' && className.charAt(className.length() - 1) == ';') {
/*  419 */       className = className.substring(1);
/*      */     }
/*      */     
/*  422 */     int i = className.lastIndexOf('.');
/*  423 */     if (i == -1) {
/*  424 */       return "";
/*      */     }
/*  426 */     return className.substring(0, i);
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
/*      */   public static String getAbbreviatedName(Class<?> cls, int lengthHint) {
/*  442 */     if (cls == null) {
/*  443 */       return "";
/*      */     }
/*  445 */     return getAbbreviatedName(cls.getName(), lengthHint);
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
/*      */   public static String getAbbreviatedName(String className, int lengthHint) {
/*  489 */     if (lengthHint <= 0) {
/*  490 */       throw new IllegalArgumentException("len must be > 0");
/*      */     }
/*  492 */     if (className == null) {
/*  493 */       return "";
/*      */     }
/*  495 */     if (className.length() <= lengthHint) {
/*  496 */       return className;
/*      */     }
/*  498 */     char[] abbreviated = className.toCharArray();
/*  499 */     int target = 0;
/*  500 */     int source = 0;
/*  501 */     while (source < abbreviated.length) {
/*      */       
/*  503 */       int runAheadTarget = target;
/*  504 */       while (source < abbreviated.length && abbreviated[source] != '.') {
/*  505 */         abbreviated[runAheadTarget++] = abbreviated[source++];
/*      */       }
/*      */       
/*  508 */       target++;
/*  509 */       if (useFull(runAheadTarget, source, abbreviated.length, lengthHint) || target > runAheadTarget)
/*      */       {
/*  511 */         target = runAheadTarget;
/*      */       }
/*      */ 
/*      */       
/*  515 */       if (source < abbreviated.length) {
/*  516 */         abbreviated[target++] = abbreviated[source++];
/*      */       }
/*      */     } 
/*  519 */     return new String(abbreviated, 0, target);
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
/*      */   private static boolean useFull(int runAheadTarget, int source, int originalLength, int desiredLength) {
/*  554 */     return (source >= originalLength || runAheadTarget + originalLength - source <= desiredLength);
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
/*      */   public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
/*  568 */     if (cls == null) {
/*  569 */       return null;
/*      */     }
/*  571 */     List<Class<?>> classes = new ArrayList<>();
/*  572 */     Class<?> superclass = cls.getSuperclass();
/*  573 */     while (superclass != null) {
/*  574 */       classes.add(superclass);
/*  575 */       superclass = superclass.getSuperclass();
/*      */     } 
/*  577 */     return classes;
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
/*      */   public static List<Class<?>> getAllInterfaces(Class<?> cls) {
/*  594 */     if (cls == null) {
/*  595 */       return null;
/*      */     }
/*      */     
/*  598 */     LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<>();
/*  599 */     getAllInterfaces(cls, interfacesFound);
/*      */     
/*  601 */     return new ArrayList<>(interfacesFound);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
/*  611 */     while (cls != null) {
/*  612 */       Class<?>[] interfaces = cls.getInterfaces();
/*      */       
/*  614 */       for (Class<?> i : interfaces) {
/*  615 */         if (interfacesFound.add(i)) {
/*  616 */           getAllInterfaces(i, interfacesFound);
/*      */         }
/*      */       } 
/*      */       
/*  620 */       cls = cls.getSuperclass();
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
/*      */   public static List<Class<?>> convertClassNamesToClasses(List<String> classNames) {
/*  639 */     if (classNames == null) {
/*  640 */       return null;
/*      */     }
/*  642 */     List<Class<?>> classes = new ArrayList<>(classNames.size());
/*  643 */     for (String className : classNames) {
/*      */       try {
/*  645 */         classes.add(Class.forName(className));
/*  646 */       } catch (Exception ex) {
/*  647 */         classes.add(null);
/*      */       } 
/*      */     } 
/*  650 */     return classes;
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
/*      */   public static List<String> convertClassesToClassNames(List<Class<?>> classes) {
/*  666 */     if (classes == null) {
/*  667 */       return null;
/*      */     }
/*  669 */     List<String> classNames = new ArrayList<>(classes.size());
/*  670 */     for (Class<?> cls : classes) {
/*  671 */       if (cls == null) {
/*  672 */         classNames.add(null); continue;
/*      */       } 
/*  674 */       classNames.add(cls.getName());
/*      */     } 
/*      */     
/*  677 */     return classNames;
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
/*      */   public static boolean isAssignable(Class<?>[] classArray, Class<?>... toClassArray) {
/*  719 */     return isAssignable(classArray, toClassArray, true);
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
/*      */   public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, boolean autoboxing) {
/*  755 */     if (!ArrayUtils.isSameLength((Object[])classArray, (Object[])toClassArray)) {
/*  756 */       return false;
/*      */     }
/*  758 */     if (classArray == null) {
/*  759 */       classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  761 */     if (toClassArray == null) {
/*  762 */       toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  764 */     for (int i = 0; i < classArray.length; i++) {
/*  765 */       if (!isAssignable(classArray[i], toClassArray[i], autoboxing)) {
/*  766 */         return false;
/*      */       }
/*      */     } 
/*  769 */     return true;
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
/*      */   public static boolean isPrimitiveOrWrapper(Class<?> type) {
/*  783 */     if (type == null) {
/*  784 */       return false;
/*      */     }
/*  786 */     return (type.isPrimitive() || isPrimitiveWrapper(type));
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
/*      */   public static boolean isPrimitiveWrapper(Class<?> type) {
/*  800 */     return wrapperPrimitiveMap.containsKey(type);
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
/*      */   public static boolean isAssignable(Class<?> cls, Class<?> toClass) {
/*  835 */     return isAssignable(cls, toClass, true);
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
/*      */   public static boolean isAssignable(Class<?> cls, Class<?> toClass, boolean autoboxing) {
/*  866 */     if (toClass == null) {
/*  867 */       return false;
/*      */     }
/*      */     
/*  870 */     if (cls == null) {
/*  871 */       return !toClass.isPrimitive();
/*      */     }
/*      */     
/*  874 */     if (autoboxing) {
/*  875 */       if (cls.isPrimitive() && !toClass.isPrimitive()) {
/*  876 */         cls = primitiveToWrapper(cls);
/*  877 */         if (cls == null) {
/*  878 */           return false;
/*      */         }
/*      */       } 
/*  881 */       if (toClass.isPrimitive() && !cls.isPrimitive()) {
/*  882 */         cls = wrapperToPrimitive(cls);
/*  883 */         if (cls == null) {
/*  884 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*  888 */     if (cls.equals(toClass)) {
/*  889 */       return true;
/*      */     }
/*  891 */     if (cls.isPrimitive()) {
/*  892 */       if (!toClass.isPrimitive()) {
/*  893 */         return false;
/*      */       }
/*  895 */       if (int.class.equals(cls)) {
/*  896 */         return (long.class.equals(toClass) || float.class
/*  897 */           .equals(toClass) || double.class
/*  898 */           .equals(toClass));
/*      */       }
/*  900 */       if (long.class.equals(cls)) {
/*  901 */         return (float.class.equals(toClass) || double.class
/*  902 */           .equals(toClass));
/*      */       }
/*  904 */       if (boolean.class.equals(cls)) {
/*  905 */         return false;
/*      */       }
/*  907 */       if (double.class.equals(cls)) {
/*  908 */         return false;
/*      */       }
/*  910 */       if (float.class.equals(cls)) {
/*  911 */         return double.class.equals(toClass);
/*      */       }
/*  913 */       if (char.class.equals(cls)) {
/*  914 */         return (int.class.equals(toClass) || long.class
/*  915 */           .equals(toClass) || float.class
/*  916 */           .equals(toClass) || double.class
/*  917 */           .equals(toClass));
/*      */       }
/*  919 */       if (short.class.equals(cls)) {
/*  920 */         return (int.class.equals(toClass) || long.class
/*  921 */           .equals(toClass) || float.class
/*  922 */           .equals(toClass) || double.class
/*  923 */           .equals(toClass));
/*      */       }
/*  925 */       if (byte.class.equals(cls)) {
/*  926 */         return (short.class.equals(toClass) || int.class
/*  927 */           .equals(toClass) || long.class
/*  928 */           .equals(toClass) || float.class
/*  929 */           .equals(toClass) || double.class
/*  930 */           .equals(toClass));
/*      */       }
/*      */       
/*  933 */       return false;
/*      */     } 
/*  935 */     return toClass.isAssignableFrom(cls);
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
/*      */   public static Class<?> primitiveToWrapper(Class<?> cls) {
/*  951 */     Class<?> convertedClass = cls;
/*  952 */     if (cls != null && cls.isPrimitive()) {
/*  953 */       convertedClass = primitiveWrapperMap.get(cls);
/*      */     }
/*  955 */     return convertedClass;
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
/*      */   public static Class<?>[] primitivesToWrappers(Class<?>... classes) {
/*  969 */     if (classes == null) {
/*  970 */       return null;
/*      */     }
/*      */     
/*  973 */     if (classes.length == 0) {
/*  974 */       return classes;
/*      */     }
/*      */     
/*  977 */     Class<?>[] convertedClasses = new Class[classes.length];
/*  978 */     for (int i = 0; i < classes.length; i++) {
/*  979 */       convertedClasses[i] = primitiveToWrapper(classes[i]);
/*      */     }
/*  981 */     return convertedClasses;
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
/*      */   public static Class<?> wrapperToPrimitive(Class<?> cls) {
/* 1001 */     return wrapperPrimitiveMap.get(cls);
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
/*      */   public static Class<?>[] wrappersToPrimitives(Class<?>... classes) {
/* 1019 */     if (classes == null) {
/* 1020 */       return null;
/*      */     }
/*      */     
/* 1023 */     if (classes.length == 0) {
/* 1024 */       return classes;
/*      */     }
/*      */     
/* 1027 */     Class<?>[] convertedClasses = new Class[classes.length];
/* 1028 */     for (int i = 0; i < classes.length; i++) {
/* 1029 */       convertedClasses[i] = wrapperToPrimitive(classes[i]);
/*      */     }
/* 1031 */     return convertedClasses;
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
/*      */   public static boolean isInnerClass(Class<?> cls) {
/* 1044 */     return (cls != null && cls.getEnclosingClass() != null);
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
/*      */   public static Class<?> getClass(ClassLoader classLoader, String className, boolean initialize) throws ClassNotFoundException {
/*      */     try {
/*      */       Class<?> clazz;
/* 1065 */       if (namePrimitiveMap.containsKey(className)) {
/* 1066 */         clazz = namePrimitiveMap.get(className);
/*      */       } else {
/* 1068 */         clazz = Class.forName(toCanonicalName(className), initialize, classLoader);
/*      */       } 
/* 1070 */       return clazz;
/* 1071 */     } catch (ClassNotFoundException ex) {
/*      */       
/* 1073 */       int lastDotIndex = className.lastIndexOf('.');
/*      */       
/* 1075 */       if (lastDotIndex != -1) {
/*      */         try {
/* 1077 */           return getClass(classLoader, className.substring(0, lastDotIndex) + '$' + className
/* 1078 */               .substring(lastDotIndex + 1), initialize);
/*      */         }
/* 1080 */         catch (ClassNotFoundException classNotFoundException) {}
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1085 */       throw ex;
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
/*      */   public static Class<?> getClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
/* 1102 */     return getClass(classLoader, className, true);
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
/*      */   public static Class<?> getClass(String className) throws ClassNotFoundException {
/* 1117 */     return getClass(className, true);
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
/*      */   public static Class<?> getClass(String className, boolean initialize) throws ClassNotFoundException {
/* 1132 */     ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
/* 1133 */     ClassLoader loader = (contextCL == null) ? ClassUtils.class.getClassLoader() : contextCL;
/* 1134 */     return getClass(loader, className, initialize);
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
/*      */   public static Method getPublicMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
/* 1164 */     Method declaredMethod = cls.getMethod(methodName, parameterTypes);
/* 1165 */     if (Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
/* 1166 */       return declaredMethod;
/*      */     }
/*      */     
/* 1169 */     List<Class<?>> candidateClasses = new ArrayList<>(getAllInterfaces(cls));
/* 1170 */     candidateClasses.addAll(getAllSuperclasses(cls));
/*      */     
/* 1172 */     for (Class<?> candidateClass : candidateClasses) {
/* 1173 */       Method candidateMethod; if (!Modifier.isPublic(candidateClass.getModifiers())) {
/*      */         continue;
/*      */       }
/*      */       
/*      */       try {
/* 1178 */         candidateMethod = candidateClass.getMethod(methodName, parameterTypes);
/* 1179 */       } catch (NoSuchMethodException ex) {
/*      */         continue;
/*      */       } 
/* 1182 */       if (Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) {
/* 1183 */         return candidateMethod;
/*      */       }
/*      */     } 
/*      */     
/* 1187 */     throw new NoSuchMethodException("Can't find a public method for " + methodName + " " + 
/* 1188 */         ArrayUtils.toString(parameterTypes));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String toCanonicalName(String className) {
/* 1199 */     className = StringUtils.deleteWhitespace(className);
/* 1200 */     Validate.notNull(className, "className", new Object[0]);
/* 1201 */     if (className.endsWith("[]")) {
/* 1202 */       StringBuilder classNameBuffer = new StringBuilder();
/* 1203 */       while (className.endsWith("[]")) {
/* 1204 */         className = className.substring(0, className.length() - 2);
/* 1205 */         classNameBuffer.append("[");
/*      */       } 
/* 1207 */       String abbreviation = abbreviationMap.get(className);
/* 1208 */       if (abbreviation != null) {
/* 1209 */         classNameBuffer.append(abbreviation);
/*      */       } else {
/* 1211 */         classNameBuffer.append("L").append(className).append(";");
/*      */       } 
/* 1213 */       className = classNameBuffer.toString();
/*      */     } 
/* 1215 */     return className;
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
/*      */   public static Class<?>[] toClass(Object... array) {
/* 1229 */     if (array == null)
/* 1230 */       return null; 
/* 1231 */     if (array.length == 0) {
/* 1232 */       return ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/* 1234 */     Class<?>[] classes = new Class[array.length];
/* 1235 */     for (int i = 0; i < array.length; i++) {
/* 1236 */       classes[i] = (array[i] == null) ? null : array[i].getClass();
/*      */     }
/* 1238 */     return classes;
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
/*      */   public static String getShortCanonicalName(Object object, String valueIfNull) {
/* 1252 */     if (object == null) {
/* 1253 */       return valueIfNull;
/*      */     }
/* 1255 */     return getShortCanonicalName(object.getClass().getName());
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
/*      */   public static String getCanonicalName(Class<?> cls) {
/* 1267 */     return getCanonicalName(cls, "");
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
/*      */   public static String getCanonicalName(Class<?> cls, String valueIfNull) {
/* 1280 */     if (cls == null) {
/* 1281 */       return valueIfNull;
/*      */     }
/* 1283 */     String canonicalName = cls.getCanonicalName();
/* 1284 */     return (canonicalName == null) ? valueIfNull : canonicalName;
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
/*      */   public static String getCanonicalName(Object object) {
/* 1296 */     return getCanonicalName(object, "");
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
/*      */   public static String getCanonicalName(Object object, String valueIfNull) {
/* 1309 */     if (object == null) {
/* 1310 */       return valueIfNull;
/*      */     }
/* 1312 */     String canonicalName = object.getClass().getCanonicalName();
/* 1313 */     return (canonicalName == null) ? valueIfNull : canonicalName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortCanonicalName(Class<?> cls) {
/* 1324 */     if (cls == null) {
/* 1325 */       return "";
/*      */     }
/* 1327 */     return getShortCanonicalName(cls.getName());
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
/*      */   public static String getShortCanonicalName(String canonicalName) {
/* 1374 */     return getShortClassName(getCanonicalName(canonicalName));
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
/*      */   public static String getPackageCanonicalName(Object object, String valueIfNull) {
/* 1388 */     if (object == null) {
/* 1389 */       return valueIfNull;
/*      */     }
/* 1391 */     return getPackageCanonicalName(object.getClass().getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageCanonicalName(Class<?> cls) {
/* 1402 */     if (cls == null) {
/* 1403 */       return "";
/*      */     }
/* 1405 */     return getPackageCanonicalName(cls.getName());
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
/*      */   public static String getPackageCanonicalName(String name) {
/* 1419 */     return getPackageName(getCanonicalName(name));
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
/*      */   private static String getCanonicalName(String className) {
/* 1443 */     className = StringUtils.deleteWhitespace(className);
/* 1444 */     if (className == null) {
/* 1445 */       return null;
/*      */     }
/* 1447 */     int dim = 0;
/* 1448 */     while (className.startsWith("[")) {
/* 1449 */       dim++;
/* 1450 */       className = className.substring(1);
/*      */     } 
/* 1452 */     if (dim < 1) {
/* 1453 */       return className;
/*      */     }
/* 1455 */     if (className.startsWith("L")) {
/* 1456 */       className = className.substring(1, 
/*      */           
/* 1458 */           className.endsWith(";") ? (className
/* 1459 */           .length() - 1) : className
/* 1460 */           .length());
/* 1461 */     } else if (!className.isEmpty()) {
/* 1462 */       className = reverseAbbreviationMap.get(className.substring(0, 1));
/*      */     } 
/* 1464 */     StringBuilder canonicalClassNameBuffer = new StringBuilder(className);
/* 1465 */     for (int i = 0; i < dim; i++) {
/* 1466 */       canonicalClassNameBuffer.append("[]");
/*      */     }
/* 1468 */     return canonicalClassNameBuffer.toString();
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
/*      */   public static Iterable<Class<?>> hierarchy(Class<?> type) {
/* 1480 */     return hierarchy(type, Interfaces.EXCLUDE);
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
/*      */   public static Iterable<Class<?>> hierarchy(Class<?> type, Interfaces interfacesBehavior) {
/* 1492 */     Iterable<Class<?>> classes = () -> {
/*      */         MutableObject<Class<?>> next = new MutableObject(type);
/*      */         return new Iterator<Class<?>>()
/*      */           {
/*      */             public boolean hasNext()
/*      */             {
/* 1498 */               return (next.getValue() != null);
/*      */             }
/*      */ 
/*      */             
/*      */             public Class<?> next() {
/* 1503 */               Class<?> result = (Class)next.getValue();
/* 1504 */               next.setValue(result.getSuperclass());
/* 1505 */               return result;
/*      */             }
/*      */ 
/*      */             
/*      */             public void remove() {
/* 1510 */               throw new UnsupportedOperationException();
/*      */             }
/*      */           };
/*      */       };
/*      */     
/* 1515 */     if (interfacesBehavior != Interfaces.INCLUDE) {
/* 1516 */       return classes;
/*      */     }
/* 1518 */     return () -> {
/*      */         final Set<Class<?>> seenInterfaces = new HashSet<>();
/*      */         final Iterator<Class<?>> wrapped = classes.iterator();
/*      */         return new Iterator<Class<?>>()
/*      */           {
/* 1523 */             Iterator interfaces = Collections.emptySet().iterator();
/*      */ 
/*      */             
/*      */             public boolean hasNext() {
/* 1527 */               return (this.interfaces.hasNext() || wrapped.hasNext());
/*      */             }
/*      */ 
/*      */             
/*      */             public Class<?> next() {
/* 1532 */               if (this.interfaces.hasNext()) {
/* 1533 */                 Class<?> nextInterface = this.interfaces.next();
/* 1534 */                 seenInterfaces.add(nextInterface);
/* 1535 */                 return nextInterface;
/*      */               } 
/* 1537 */               Class<?> nextSuperclass = wrapped.next();
/* 1538 */               Set<Class<?>> currentInterfaces = new LinkedHashSet();
/* 1539 */               walkInterfaces(currentInterfaces, nextSuperclass);
/* 1540 */               this.interfaces = currentInterfaces.iterator();
/* 1541 */               return nextSuperclass;
/*      */             }
/*      */             
/*      */             private void walkInterfaces(Set<Class<?>> addTo, Class c) {
/* 1545 */               for (Class<?> iface : c.getInterfaces()) {
/* 1546 */                 if (!seenInterfaces.contains(iface)) {
/* 1547 */                   addTo.add(iface);
/*      */                 }
/* 1549 */                 walkInterfaces(addTo, iface);
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             public void remove() {
/* 1555 */               throw new UnsupportedOperationException();
/*      */             }
/*      */           };
/*      */       };
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */