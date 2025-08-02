/*    */ package net.craftigames.polar.common.util.reflection;
/*    */ 
/*    */ import java.lang.reflect.Array;
/*    */ import java.lang.reflect.GenericArrayType;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import java.lang.reflect.TypeVariable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenericTypeReflection
/*    */ {
/*    */   public static Class<?> getClass(Type type) {
/* 19 */     if (type instanceof Class)
/* 20 */       return (Class)type; 
/* 21 */     if (type instanceof ParameterizedType)
/* 22 */       return getClass(((ParameterizedType)type).getRawType()); 
/* 23 */     if (type instanceof GenericArrayType) {
/* 24 */       Type componentType = ((GenericArrayType)type).getGenericComponentType();
/* 25 */       Class<?> componentClass = getClass(componentType);
/* 26 */       if (componentClass != null) {
/* 27 */         return Array.newInstance(componentClass, 0).getClass();
/*    */       }
/* 29 */       return null;
/*    */     } 
/*    */     
/* 32 */     return null;
/*    */   }
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
/*    */   public static <T> List<Class<?>> getTypeArguments(Class<T> baseClass, Class<? extends T> childClass) {
/*    */     Type[] actualTypeArguments;
/* 47 */     Map<Type, Type> resolvedTypes = new HashMap<>();
/* 48 */     Type<? extends T> type = childClass;
/*    */     
/* 50 */     while (!getClass(type).equals(baseClass)) {
/* 51 */       if (type instanceof Class) {
/*    */         
/* 53 */         type = ((Class)type).getGenericSuperclass(); continue;
/*    */       } 
/* 55 */       ParameterizedType parameterizedType = (ParameterizedType)type;
/* 56 */       Class<?> rawType = (Class)parameterizedType.getRawType();
/*    */       
/* 58 */       Type[] arrayOfType = parameterizedType.getActualTypeArguments();
/* 59 */       TypeVariable[] arrayOfTypeVariable = (TypeVariable[])rawType.getTypeParameters();
/* 60 */       for (int i = 0; i < arrayOfType.length; i++) {
/* 61 */         resolvedTypes.put(arrayOfTypeVariable[i], arrayOfType[i]);
/*    */       }
/*    */       
/* 64 */       if (!rawType.equals(baseClass)) {
/* 65 */         type = rawType.getGenericSuperclass();
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 73 */     if (type instanceof Class) {
/* 74 */       TypeVariable[] arrayOfTypeVariable = ((Class)type).getTypeParameters();
/*    */     } else {
/* 76 */       actualTypeArguments = ((ParameterizedType)type).getActualTypeArguments();
/*    */     } 
/* 78 */     List<Class<?>> typeArgumentsAsClasses = new ArrayList<>();
/*    */     
/* 80 */     for (Type baseType : actualTypeArguments) {
/* 81 */       while (resolvedTypes.containsKey(baseType)) {
/* 82 */         baseType = resolvedTypes.get(baseType);
/*    */       }
/* 84 */       typeArgumentsAsClasses.add(getClass(baseType));
/*    */     } 
/* 86 */     return typeArgumentsAsClasses;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\reflection\GenericTypeReflection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */