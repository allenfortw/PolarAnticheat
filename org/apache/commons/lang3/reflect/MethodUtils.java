/*      */ package org.apache.commons.lang3.reflect;
/*      */ 
/*      */ import java.lang.annotation.Annotation;
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.stream.Collectors;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MethodUtils
/*      */ {
/*   66 */   private static final Comparator<Method> METHOD_BY_SIGNATURE = Comparator.comparing(Method::toString);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object invokeMethod(Object object, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  100 */     return invokeMethod(object, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[])null);
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
/*      */   public static Object invokeMethod(Object object, boolean forceAccess, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  123 */     return invokeMethod(object, forceAccess, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
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
/*      */   public static Object invokeMethod(Object object, String methodName, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  151 */     args = ArrayUtils.nullToEmpty(args);
/*  152 */     Class<?>[] parameterTypes = ClassUtils.toClass(args);
/*  153 */     return invokeMethod(object, methodName, args, parameterTypes);
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
/*      */   public static Object invokeMethod(Object object, boolean forceAccess, String methodName, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  182 */     args = ArrayUtils.nullToEmpty(args);
/*  183 */     Class<?>[] parameterTypes = ClassUtils.toClass(args);
/*  184 */     return invokeMethod(object, forceAccess, methodName, args, parameterTypes);
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
/*      */   public static Object invokeMethod(Object object, boolean forceAccess, String methodName, Object[] args, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*      */     String messagePrefix;
/*  209 */     parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
/*  210 */     args = ArrayUtils.nullToEmpty(args);
/*      */ 
/*      */     
/*  213 */     Method method = null;
/*      */     
/*  215 */     if (forceAccess) {
/*  216 */       messagePrefix = "No such method: ";
/*  217 */       method = getMatchingMethod(object.getClass(), methodName, parameterTypes);
/*      */       
/*  219 */       if (method != null && !method.isAccessible()) {
/*  220 */         method.setAccessible(true);
/*      */       }
/*      */     } else {
/*  223 */       messagePrefix = "No such accessible method: ";
/*  224 */       method = getMatchingAccessibleMethod(object.getClass(), methodName, parameterTypes);
/*      */     } 
/*      */ 
/*      */     
/*  228 */     if (method == null) {
/*  229 */       throw new NoSuchMethodException(messagePrefix + methodName + "() on object: " + object
/*      */           
/*  231 */           .getClass().getName());
/*      */     }
/*  233 */     args = toVarArgs(method, args);
/*      */     
/*  235 */     return method.invoke(object, args);
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
/*      */   public static Object invokeMethod(Object object, String methodName, Object[] args, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  261 */     return invokeMethod(object, false, methodName, args, parameterTypes);
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
/*      */   public static Object invokeExactMethod(Object object, String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  285 */     return invokeExactMethod(object, methodName, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
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
/*      */   public static Object invokeExactMethod(Object object, String methodName, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  308 */     args = ArrayUtils.nullToEmpty(args);
/*  309 */     Class<?>[] parameterTypes = ClassUtils.toClass(args);
/*  310 */     return invokeExactMethod(object, methodName, args, parameterTypes);
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
/*      */   public static Object invokeExactMethod(Object object, String methodName, Object[] args, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  336 */     args = ArrayUtils.nullToEmpty(args);
/*  337 */     parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
/*  338 */     Method method = getAccessibleMethod(object.getClass(), methodName, parameterTypes);
/*      */     
/*  340 */     if (method == null) {
/*  341 */       throw new NoSuchMethodException("No such accessible method: " + methodName + "() on object: " + object
/*      */           
/*  343 */           .getClass().getName());
/*      */     }
/*  345 */     return method.invoke(object, args);
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
/*      */   public static Object invokeExactStaticMethod(Class<?> cls, String methodName, Object[] args, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  371 */     args = ArrayUtils.nullToEmpty(args);
/*  372 */     parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
/*  373 */     Method method = getAccessibleMethod(cls, methodName, parameterTypes);
/*  374 */     if (method == null) {
/*  375 */       throw new NoSuchMethodException("No such accessible method: " + methodName + "() on class: " + cls
/*  376 */           .getName());
/*      */     }
/*  378 */     return method.invoke((Object)null, args);
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
/*      */   public static Object invokeStaticMethod(Class<?> cls, String methodName, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  408 */     args = ArrayUtils.nullToEmpty(args);
/*  409 */     Class<?>[] parameterTypes = ClassUtils.toClass(args);
/*  410 */     return invokeStaticMethod(cls, methodName, args, parameterTypes);
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
/*      */   public static Object invokeStaticMethod(Class<?> cls, String methodName, Object[] args, Class<?>[] parameterTypes) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  439 */     args = ArrayUtils.nullToEmpty(args);
/*  440 */     parameterTypes = ArrayUtils.nullToEmpty(parameterTypes);
/*  441 */     Method method = getMatchingAccessibleMethod(cls, methodName, parameterTypes);
/*      */     
/*  443 */     if (method == null) {
/*  444 */       throw new NoSuchMethodException("No such accessible method: " + methodName + "() on class: " + cls
/*  445 */           .getName());
/*      */     }
/*  447 */     args = toVarArgs(method, args);
/*  448 */     return method.invoke((Object)null, args);
/*      */   }
/*      */   
/*      */   private static Object[] toVarArgs(Method method, Object[] args) {
/*  452 */     if (method.isVarArgs()) {
/*  453 */       Class<?>[] methodParameterTypes = method.getParameterTypes();
/*  454 */       args = getVarArgs(args, methodParameterTypes);
/*      */     } 
/*  456 */     return args;
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
/*      */   static Object[] getVarArgs(Object[] args, Class<?>[] methodParameterTypes) {
/*  470 */     if (args.length == methodParameterTypes.length && (args[args.length - 1] == null || args[args.length - 1]
/*  471 */       .getClass().equals(methodParameterTypes[methodParameterTypes.length - 1])))
/*      */     {
/*  473 */       return args;
/*      */     }
/*      */ 
/*      */     
/*  477 */     Object[] newArgs = new Object[methodParameterTypes.length];
/*      */ 
/*      */     
/*  480 */     System.arraycopy(args, 0, newArgs, 0, methodParameterTypes.length - 1);
/*      */ 
/*      */     
/*  483 */     Class<?> varArgComponentType = methodParameterTypes[methodParameterTypes.length - 1].getComponentType();
/*  484 */     int varArgLength = args.length - methodParameterTypes.length + 1;
/*      */     
/*  486 */     Object varArgsArray = Array.newInstance(ClassUtils.primitiveToWrapper(varArgComponentType), varArgLength);
/*      */     
/*  488 */     System.arraycopy(args, methodParameterTypes.length - 1, varArgsArray, 0, varArgLength);
/*      */     
/*  490 */     if (varArgComponentType.isPrimitive())
/*      */     {
/*  492 */       varArgsArray = ArrayUtils.toPrimitive(varArgsArray);
/*      */     }
/*      */ 
/*      */     
/*  496 */     newArgs[methodParameterTypes.length - 1] = varArgsArray;
/*      */ 
/*      */     
/*  499 */     return newArgs;
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
/*      */   public static Object invokeExactStaticMethod(Class<?> cls, String methodName, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
/*  523 */     args = ArrayUtils.nullToEmpty(args);
/*  524 */     Class<?>[] parameterTypes = ClassUtils.toClass(args);
/*  525 */     return invokeExactStaticMethod(cls, methodName, args, parameterTypes);
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
/*      */   public static Method getAccessibleMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) {
/*      */     try {
/*  543 */       return getAccessibleMethod(cls.getMethod(methodName, parameterTypes));
/*      */     }
/*  545 */     catch (NoSuchMethodException e) {
/*  546 */       return null;
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
/*      */   public static Method getAccessibleMethod(Method method) {
/*  559 */     if (!MemberUtils.isAccessible(method)) {
/*  560 */       return null;
/*      */     }
/*      */     
/*  563 */     Class<?> cls = method.getDeclaringClass();
/*  564 */     if (Modifier.isPublic(cls.getModifiers())) {
/*  565 */       return method;
/*      */     }
/*  567 */     String methodName = method.getName();
/*  568 */     Class<?>[] parameterTypes = method.getParameterTypes();
/*      */ 
/*      */     
/*  571 */     method = getAccessibleMethodFromInterfaceNest(cls, methodName, parameterTypes);
/*      */ 
/*      */ 
/*      */     
/*  575 */     if (method == null) {
/*  576 */       method = getAccessibleMethodFromSuperclass(cls, methodName, parameterTypes);
/*      */     }
/*      */     
/*  579 */     return method;
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
/*      */   private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String methodName, Class<?>... parameterTypes) {
/*  594 */     Class<?> parentClass = cls.getSuperclass();
/*  595 */     while (parentClass != null) {
/*  596 */       if (Modifier.isPublic(parentClass.getModifiers())) {
/*      */         try {
/*  598 */           return parentClass.getMethod(methodName, parameterTypes);
/*  599 */         } catch (NoSuchMethodException e) {
/*  600 */           return null;
/*      */         } 
/*      */       }
/*  603 */       parentClass = parentClass.getSuperclass();
/*      */     } 
/*  605 */     return null;
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
/*      */   private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String methodName, Class<?>... parameterTypes) {
/*  626 */     for (; cls != null; cls = cls.getSuperclass()) {
/*      */ 
/*      */       
/*  629 */       Class<?>[] interfaces = cls.getInterfaces();
/*  630 */       for (Class<?> anInterface : interfaces) {
/*      */         
/*  632 */         if (Modifier.isPublic(anInterface.getModifiers()))
/*      */           
/*      */           try {
/*      */ 
/*      */             
/*  637 */             return anInterface.getDeclaredMethod(methodName, parameterTypes);
/*      */           }
/*  639 */           catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  646 */             Method method = getAccessibleMethodFromInterfaceNest(anInterface, methodName, parameterTypes);
/*      */             
/*  648 */             if (method != null)
/*  649 */               return method; 
/*      */           }  
/*      */       } 
/*      */     } 
/*  653 */     return null;
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
/*      */   public static Method getMatchingAccessibleMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) {
/*      */     try {
/*  681 */       Method method = cls.getMethod(methodName, parameterTypes);
/*  682 */       MemberUtils.setAccessibleWorkaround(method);
/*  683 */       return method;
/*  684 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */ 
/*      */       
/*  687 */       Method[] methods = cls.getMethods();
/*  688 */       List<Method> matchingMethods = new ArrayList<>();
/*  689 */       for (Method method : methods) {
/*      */         
/*  691 */         if (method.getName().equals(methodName) && 
/*  692 */           MemberUtils.isMatchingMethod(method, parameterTypes)) {
/*  693 */           matchingMethods.add(method);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  698 */       matchingMethods.sort(METHOD_BY_SIGNATURE);
/*      */       
/*  700 */       Method bestMatch = null;
/*  701 */       for (Method method : matchingMethods) {
/*      */         
/*  703 */         Method accessibleMethod = getAccessibleMethod(method);
/*  704 */         if (accessibleMethod != null && (bestMatch == null || MemberUtils.compareMethodFit(accessibleMethod, bestMatch, parameterTypes) < 0))
/*      */         {
/*      */ 
/*      */           
/*  708 */           bestMatch = accessibleMethod;
/*      */         }
/*      */       } 
/*  711 */       if (bestMatch != null) {
/*  712 */         MemberUtils.setAccessibleWorkaround(bestMatch);
/*      */       }
/*      */       
/*  715 */       if (bestMatch != null && bestMatch.isVarArgs() && (bestMatch.getParameterTypes()).length > 0 && parameterTypes.length > 0) {
/*  716 */         Class<?>[] methodParameterTypes = bestMatch.getParameterTypes();
/*  717 */         Class<?> methodParameterComponentType = methodParameterTypes[methodParameterTypes.length - 1].getComponentType();
/*  718 */         String methodParameterComponentTypeName = ClassUtils.primitiveToWrapper(methodParameterComponentType).getName();
/*      */         
/*  720 */         Class<?> lastParameterType = parameterTypes[parameterTypes.length - 1];
/*  721 */         String parameterTypeName = (lastParameterType == null) ? null : lastParameterType.getName();
/*  722 */         String parameterTypeSuperClassName = (lastParameterType == null) ? null : lastParameterType.getSuperclass().getName();
/*      */         
/*  724 */         if (parameterTypeName != null && parameterTypeSuperClassName != null && !methodParameterComponentTypeName.equals(parameterTypeName) && 
/*  725 */           !methodParameterComponentTypeName.equals(parameterTypeSuperClassName)) {
/*  726 */           return null;
/*      */         }
/*      */       } 
/*      */       
/*  730 */       return bestMatch;
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
/*      */   public static Method getMatchingMethod(Class<?> cls, String methodName, Class<?>... parameterTypes) {
/*  745 */     Validate.notNull(cls, "cls", new Object[0]);
/*  746 */     Validate.notEmpty(methodName, "methodName", new Object[0]);
/*      */ 
/*      */ 
/*      */     
/*  750 */     List<Method> methods = (List<Method>)Arrays.<Method>stream(cls.getDeclaredMethods()).filter(method -> method.getName().equals(methodName)).collect(Collectors.toList());
/*      */     
/*  752 */     ClassUtils.getAllSuperclasses(cls).stream()
/*  753 */       .map(Class::getDeclaredMethods)
/*  754 */       .flatMap(Arrays::stream)
/*  755 */       .filter(method -> method.getName().equals(methodName))
/*  756 */       .forEach(methods::add);
/*      */     
/*  758 */     for (Method method : methods) {
/*  759 */       if (Arrays.deepEquals((Object[])method.getParameterTypes(), (Object[])parameterTypes)) {
/*  760 */         return method;
/*      */       }
/*      */     } 
/*      */     
/*  764 */     TreeMap<Integer, List<Method>> candidates = new TreeMap<>();
/*      */     
/*  766 */     methods.stream()
/*  767 */       .filter(method -> ClassUtils.isAssignable(parameterTypes, method.getParameterTypes(), true))
/*  768 */       .forEach(method -> {
/*      */           int distance = distance(parameterTypes, method.getParameterTypes());
/*      */           
/*      */           List<Method> candidatesAtDistance = candidates.computeIfAbsent(Integer.valueOf(distance), ());
/*      */           candidatesAtDistance.add(method);
/*      */         });
/*  774 */     if (candidates.isEmpty()) {
/*  775 */       return null;
/*      */     }
/*      */     
/*  778 */     List<Method> bestCandidates = candidates.values().iterator().next();
/*  779 */     if (bestCandidates.size() == 1) {
/*  780 */       return bestCandidates.get(0);
/*      */     }
/*      */     
/*  783 */     throw new IllegalStateException(
/*  784 */         String.format("Found multiple candidates for method %s on class %s : %s", new Object[] {
/*  785 */             methodName + (String)Arrays.<Class<?>>stream(parameterTypes).map(String::valueOf).collect(Collectors.joining(",", "(", ")")), cls
/*  786 */             .getName(), bestCandidates
/*  787 */             .stream().map(Method::toString).collect(Collectors.joining(",", "[", "]"))
/*      */           }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int distance(Class<?>[] fromClassArray, Class<?>[] toClassArray) {
/*  799 */     int answer = 0;
/*      */     
/*  801 */     if (!ClassUtils.isAssignable(fromClassArray, toClassArray, true)) {
/*  802 */       return -1;
/*      */     }
/*  804 */     for (int offset = 0; offset < fromClassArray.length; offset++) {
/*      */       
/*  806 */       Class<?> aClass = fromClassArray[offset];
/*  807 */       Class<?> toClass = toClassArray[offset];
/*  808 */       if (aClass != null && !aClass.equals(toClass))
/*      */       {
/*  810 */         if (ClassUtils.isAssignable(aClass, toClass, true) && 
/*  811 */           !ClassUtils.isAssignable(aClass, toClass, false)) {
/*  812 */           answer++;
/*      */         } else {
/*  814 */           answer += 2;
/*      */         } 
/*      */       }
/*      */     } 
/*  818 */     return answer;
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
/*      */   public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfacesBehavior) {
/*  830 */     Validate.notNull(method);
/*  831 */     Set<Method> result = new LinkedHashSet<>();
/*  832 */     result.add(method);
/*      */     
/*  834 */     Class<?>[] parameterTypes = method.getParameterTypes();
/*      */     
/*  836 */     Class<?> declaringClass = method.getDeclaringClass();
/*      */     
/*  838 */     Iterator<Class<?>> hierarchy = ClassUtils.hierarchy(declaringClass, interfacesBehavior).iterator();
/*      */     
/*  840 */     hierarchy.next();
/*  841 */     label21: while (hierarchy.hasNext()) {
/*  842 */       Class<?> c = hierarchy.next();
/*  843 */       Method m = getMatchingAccessibleMethod(c, method.getName(), parameterTypes);
/*  844 */       if (m == null) {
/*      */         continue;
/*      */       }
/*  847 */       if (Arrays.equals((Object[])m.getParameterTypes(), (Object[])parameterTypes)) {
/*      */         
/*  849 */         result.add(m);
/*      */         
/*      */         continue;
/*      */       } 
/*  853 */       Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, m.getDeclaringClass());
/*  854 */       for (int i = 0; i < parameterTypes.length; i++) {
/*  855 */         Type childType = TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]);
/*  856 */         Type parentType = TypeUtils.unrollVariables(typeArguments, m.getGenericParameterTypes()[i]);
/*  857 */         if (!TypeUtils.equals(childType, parentType)) {
/*      */           continue label21;
/*      */         }
/*      */       } 
/*  861 */       result.add(m);
/*      */     } 
/*  863 */     return result;
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
/*      */   public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
/*  877 */     return getMethodsWithAnnotation(cls, annotationCls, false, false);
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
/*      */   public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
/*  892 */     return getMethodsListWithAnnotation(cls, annotationCls, false, false);
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
/*      */   public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls, boolean searchSupers, boolean ignoreAccess) {
/*  911 */     List<Method> annotatedMethodsList = getMethodsListWithAnnotation(cls, annotationCls, searchSupers, ignoreAccess);
/*      */     
/*  913 */     return annotatedMethodsList.<Method>toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
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
/*      */   public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls, boolean searchSupers, boolean ignoreAccess) {
/*  934 */     Validate.notNull(cls, "cls", new Object[0]);
/*  935 */     Validate.notNull(annotationCls, "annotationCls", new Object[0]);
/*  936 */     List<Class<?>> classes = searchSupers ? getAllSuperclassesAndInterfaces(cls) : new ArrayList<>();
/*      */     
/*  938 */     classes.add(0, cls);
/*  939 */     List<Method> annotatedMethods = new ArrayList<>();
/*  940 */     for (Class<?> acls : classes) {
/*  941 */       Method[] methods = ignoreAccess ? acls.getDeclaredMethods() : acls.getMethods();
/*  942 */       for (Method method : methods) {
/*  943 */         if (method.getAnnotation(annotationCls) != null) {
/*  944 */           annotatedMethods.add(method);
/*      */         }
/*      */       } 
/*      */     } 
/*  948 */     return annotatedMethods;
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
/*      */   public static <A extends Annotation> A getAnnotation(Method method, Class<A> annotationCls, boolean searchSupers, boolean ignoreAccess) {
/*  976 */     Validate.notNull(method, "method", new Object[0]);
/*  977 */     Validate.notNull(annotationCls, "annotationCls", new Object[0]);
/*  978 */     if (!ignoreAccess && !MemberUtils.isAccessible(method)) {
/*  979 */       return null;
/*      */     }
/*      */     
/*  982 */     A annotation = method.getAnnotation(annotationCls);
/*      */     
/*  984 */     if (annotation == null && searchSupers) {
/*  985 */       Class<?> mcls = method.getDeclaringClass();
/*  986 */       List<Class<?>> classes = getAllSuperclassesAndInterfaces(mcls);
/*  987 */       for (Class<?> acls : classes) {
/*      */         
/*  989 */         Method equivalentMethod = ignoreAccess ? getMatchingMethod(acls, method.getName(), method.getParameterTypes()) : getMatchingAccessibleMethod(acls, method.getName(), method.getParameterTypes());
/*  990 */         if (equivalentMethod != null) {
/*  991 */           annotation = equivalentMethod.getAnnotation(annotationCls);
/*  992 */           if (annotation != null) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  999 */     return annotation;
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
/*      */   private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> cls) {
/* 1013 */     if (cls == null) {
/* 1014 */       return null;
/*      */     }
/*      */     
/* 1017 */     List<Class<?>> allSuperClassesAndInterfaces = new ArrayList<>();
/* 1018 */     List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
/* 1019 */     int superClassIndex = 0;
/* 1020 */     List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
/* 1021 */     int interfaceIndex = 0;
/* 1022 */     while (interfaceIndex < allInterfaces.size() || superClassIndex < allSuperclasses
/* 1023 */       .size()) {
/*      */       Class<?> acls;
/* 1025 */       if (interfaceIndex >= allInterfaces.size()) {
/* 1026 */         acls = allSuperclasses.get(superClassIndex++);
/* 1027 */       } else if (superClassIndex >= allSuperclasses.size() || interfaceIndex < superClassIndex || superClassIndex >= interfaceIndex) {
/* 1028 */         acls = allInterfaces.get(interfaceIndex++);
/*      */       } else {
/* 1030 */         acls = allSuperclasses.get(superClassIndex++);
/*      */       } 
/* 1032 */       allSuperClassesAndInterfaces.add(acls);
/*      */     } 
/* 1034 */     return allSuperClassesAndInterfaces;
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\reflect\MethodUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */