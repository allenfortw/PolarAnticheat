/*      */ package org.apache.commons.lang3.reflect;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.GenericArrayType;
/*      */ import java.lang.reflect.GenericDeclaration;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.lang.reflect.WildcardType;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ import org.apache.commons.lang3.builder.Builder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TypeUtils
/*      */ {
/*      */   private static final class GenericArrayTypeImpl
/*      */     implements GenericArrayType
/*      */   {
/*      */     private final Type componentType;
/*      */     
/*      */     private GenericArrayTypeImpl(Type componentType) {
/*   61 */       this.componentType = componentType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/*   69 */       return (obj == this || (obj instanceof GenericArrayType && TypeUtils.equals(this, (GenericArrayType)obj)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getGenericComponentType() {
/*   77 */       return this.componentType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*   85 */       int result = 1072;
/*   86 */       result |= this.componentType.hashCode();
/*   87 */       return result;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*   95 */       return TypeUtils.toString(this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class ParameterizedTypeImpl
/*      */     implements ParameterizedType
/*      */   {
/*      */     private final Class<?> raw;
/*      */ 
/*      */     
/*      */     private final Type useOwner;
/*      */ 
/*      */     
/*      */     private final Type[] typeArguments;
/*      */ 
/*      */ 
/*      */     
/*      */     private ParameterizedTypeImpl(Class<?> rawClass, Type useOwner, Type[] typeArguments) {
/*  115 */       this.raw = rawClass;
/*  116 */       this.useOwner = useOwner;
/*  117 */       this.typeArguments = Arrays.<Type, Type>copyOf(typeArguments, typeArguments.length, Type[].class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/*  125 */       return (obj == this || (obj instanceof ParameterizedType && TypeUtils.equals(this, (ParameterizedType)obj)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getActualTypeArguments() {
/*  133 */       return (Type[])this.typeArguments.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getOwnerType() {
/*  141 */       return this.useOwner;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getRawType() {
/*  149 */       return this.raw;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  157 */       int result = 1136;
/*  158 */       result |= this.raw.hashCode();
/*  159 */       result <<= 4;
/*  160 */       result |= Objects.hashCode(this.useOwner);
/*  161 */       result <<= 8;
/*  162 */       result |= Arrays.hashCode((Object[])this.typeArguments);
/*  163 */       return result;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  171 */       return TypeUtils.toString(this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class WildcardTypeBuilder
/*      */     implements Builder<WildcardType>
/*      */   {
/*      */     private Type[] upperBounds;
/*      */ 
/*      */ 
/*      */     
/*      */     private Type[] lowerBounds;
/*      */ 
/*      */ 
/*      */     
/*      */     private WildcardTypeBuilder() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public WildcardType build() {
/*  194 */       return new TypeUtils.WildcardTypeImpl(this.upperBounds, this.lowerBounds);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WildcardTypeBuilder withLowerBounds(Type... bounds) {
/*  203 */       this.lowerBounds = bounds;
/*  204 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WildcardTypeBuilder withUpperBounds(Type... bounds) {
/*  213 */       this.upperBounds = bounds;
/*  214 */       return this;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class WildcardTypeImpl
/*      */     implements WildcardType
/*      */   {
/*      */     private final Type[] upperBounds;
/*      */ 
/*      */     
/*      */     private final Type[] lowerBounds;
/*      */ 
/*      */ 
/*      */     
/*      */     private WildcardTypeImpl(Type[] upperBounds, Type[] lowerBounds) {
/*  232 */       this.upperBounds = (Type[])ObjectUtils.defaultIfNull(upperBounds, ArrayUtils.EMPTY_TYPE_ARRAY);
/*  233 */       this.lowerBounds = (Type[])ObjectUtils.defaultIfNull(lowerBounds, ArrayUtils.EMPTY_TYPE_ARRAY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/*  241 */       return (obj == this || (obj instanceof WildcardType && TypeUtils.equals(this, (WildcardType)obj)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getLowerBounds() {
/*  249 */       return (Type[])this.lowerBounds.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getUpperBounds() {
/*  257 */       return (Type[])this.upperBounds.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  265 */       int result = 18688;
/*  266 */       result |= Arrays.hashCode((Object[])this.upperBounds);
/*  267 */       result <<= 8;
/*  268 */       result |= Arrays.hashCode((Object[])this.lowerBounds);
/*  269 */       return result;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  277 */       return TypeUtils.toString(this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  285 */   public static final WildcardType WILDCARD_ALL = wildcardType().withUpperBounds(new Type[] { Object.class }).build();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> StringBuilder appendAllTo(StringBuilder builder, String sep, T... types) {
/*  298 */     Validate.notEmpty(Validate.noNullElements((Object[])types));
/*  299 */     if (types.length > 0) {
/*  300 */       builder.append(toString(types[0]));
/*  301 */       for (int i = 1; i < types.length; i++) {
/*  302 */         builder.append(sep).append(toString(types[i]));
/*      */       }
/*      */     } 
/*  305 */     return builder;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void appendRecursiveTypes(StringBuilder builder, int[] recursiveTypeIndexes, Type[] argumentTypes) {
/*  310 */     for (int i = 0; i < recursiveTypeIndexes.length; i++) {
/*  311 */       appendAllTo(builder.append('<'), ", ", new String[] { argumentTypes[i].toString() }).append('>');
/*      */     } 
/*      */     
/*  314 */     Type[] argumentsFiltered = (Type[])ArrayUtils.removeAll((Object[])argumentTypes, recursiveTypeIndexes);
/*      */     
/*  316 */     if (argumentsFiltered.length > 0) {
/*  317 */       appendAllTo(builder.append('<'), ", ", argumentsFiltered).append('>');
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
/*      */   private static String classToString(Class<?> cls) {
/*  329 */     if (cls.isArray()) {
/*  330 */       return toString(cls.getComponentType()) + "[]";
/*      */     }
/*      */     
/*  333 */     StringBuilder buf = new StringBuilder();
/*      */     
/*  335 */     if (cls.getEnclosingClass() != null) {
/*  336 */       buf.append(classToString(cls.getEnclosingClass())).append('.').append(cls.getSimpleName());
/*      */     } else {
/*  338 */       buf.append(cls.getName());
/*      */     } 
/*  340 */     if ((cls.getTypeParameters()).length > 0) {
/*  341 */       buf.append('<');
/*  342 */       appendAllTo(buf, ", ", (Object[])cls.getTypeParameters());
/*  343 */       buf.append('>');
/*      */     } 
/*  345 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsTypeVariables(Type type) {
/*  356 */     if (type instanceof TypeVariable) {
/*  357 */       return true;
/*      */     }
/*  359 */     if (type instanceof Class) {
/*  360 */       return ((((Class)type).getTypeParameters()).length > 0);
/*      */     }
/*  362 */     if (type instanceof ParameterizedType) {
/*  363 */       for (Type arg : ((ParameterizedType)type).getActualTypeArguments()) {
/*  364 */         if (containsTypeVariables(arg)) {
/*  365 */           return true;
/*      */         }
/*      */       } 
/*  368 */       return false;
/*      */     } 
/*  370 */     if (type instanceof WildcardType) {
/*  371 */       WildcardType wild = (WildcardType)type;
/*  372 */       return (containsTypeVariables(getImplicitLowerBounds(wild)[0]) || 
/*  373 */         containsTypeVariables(getImplicitUpperBounds(wild)[0]));
/*      */     } 
/*  375 */     if (type instanceof GenericArrayType) {
/*  376 */       return containsTypeVariables(((GenericArrayType)type).getGenericComponentType());
/*      */     }
/*  378 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean containsVariableTypeSameParametrizedTypeBound(TypeVariable<?> typeVariable, ParameterizedType parameterizedType) {
/*  383 */     return ArrayUtils.contains((Object[])typeVariable.getBounds(), parameterizedType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType superParameterizedType) {
/*  419 */     Validate.notNull(cls, "cls", new Object[0]);
/*  420 */     Validate.notNull(superParameterizedType, "superParameterizedType", new Object[0]);
/*      */     
/*  422 */     Class<?> superClass = getRawType(superParameterizedType);
/*      */ 
/*      */     
/*  425 */     if (!isAssignable(cls, superClass)) {
/*  426 */       return null;
/*      */     }
/*      */     
/*  429 */     if (cls.equals(superClass)) {
/*  430 */       return getTypeArguments(superParameterizedType, superClass, (Map<TypeVariable<?>, Type>)null);
/*      */     }
/*      */ 
/*      */     
/*  434 */     Type midType = getClosestParentType(cls, superClass);
/*      */ 
/*      */     
/*  437 */     if (midType instanceof Class) {
/*  438 */       return determineTypeArguments((Class)midType, superParameterizedType);
/*      */     }
/*      */     
/*  441 */     ParameterizedType midParameterizedType = (ParameterizedType)midType;
/*  442 */     Class<?> midClass = getRawType(midParameterizedType);
/*      */ 
/*      */     
/*  445 */     Map<TypeVariable<?>, Type> typeVarAssigns = determineTypeArguments(midClass, superParameterizedType);
/*      */     
/*  447 */     mapTypeVariablesToArguments(cls, midParameterizedType, typeVarAssigns);
/*      */     
/*  449 */     return typeVarAssigns;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(GenericArrayType genericArrayType, Type type) {
/*  461 */     return (type instanceof GenericArrayType && 
/*  462 */       equals(genericArrayType.getGenericComponentType(), ((GenericArrayType)type).getGenericComponentType()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(ParameterizedType parameterizedType, Type type) {
/*  474 */     if (type instanceof ParameterizedType) {
/*  475 */       ParameterizedType other = (ParameterizedType)type;
/*  476 */       if (equals(parameterizedType.getRawType(), other.getRawType()) && 
/*  477 */         equals(parameterizedType.getOwnerType(), other.getOwnerType())) {
/*  478 */         return equals(parameterizedType.getActualTypeArguments(), other.getActualTypeArguments());
/*      */       }
/*      */     } 
/*  481 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equals(Type type1, Type type2) {
/*  493 */     if (Objects.equals(type1, type2)) {
/*  494 */       return true;
/*      */     }
/*  496 */     if (type1 instanceof ParameterizedType) {
/*  497 */       return equals((ParameterizedType)type1, type2);
/*      */     }
/*  499 */     if (type1 instanceof GenericArrayType) {
/*  500 */       return equals((GenericArrayType)type1, type2);
/*      */     }
/*  502 */     if (type1 instanceof WildcardType) {
/*  503 */       return equals((WildcardType)type1, type2);
/*      */     }
/*  505 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(Type[] type1, Type[] type2) {
/*  517 */     if (type1.length == type2.length) {
/*  518 */       for (int i = 0; i < type1.length; i++) {
/*  519 */         if (!equals(type1[i], type2[i])) {
/*  520 */           return false;
/*      */         }
/*      */       } 
/*  523 */       return true;
/*      */     } 
/*  525 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(WildcardType wildcardType, Type type) {
/*  537 */     if (type instanceof WildcardType) {
/*  538 */       WildcardType other = (WildcardType)type;
/*  539 */       return (equals(getImplicitLowerBounds(wildcardType), getImplicitLowerBounds(other)) && 
/*  540 */         equals(getImplicitUpperBounds(wildcardType), getImplicitUpperBounds(other)));
/*      */     } 
/*  542 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type[] extractTypeArgumentsFrom(Map<TypeVariable<?>, Type> mappings, TypeVariable<?>[] variables) {
/*  553 */     Type[] result = new Type[variables.length];
/*  554 */     int index = 0;
/*  555 */     for (TypeVariable<?> var : variables) {
/*  556 */       Validate.isTrue(mappings.containsKey(var), "missing argument mapping for %s", new Object[] { toString(var) });
/*  557 */       result[index++] = mappings.get(var);
/*      */     } 
/*  559 */     return result;
/*      */   }
/*      */   
/*      */   private static int[] findRecursiveTypes(ParameterizedType parameterizedType) {
/*  563 */     Type[] filteredArgumentTypes = Arrays.<Type>copyOf(parameterizedType.getActualTypeArguments(), (parameterizedType
/*  564 */         .getActualTypeArguments()).length);
/*  565 */     int[] indexesToRemove = new int[0];
/*  566 */     for (int i = 0; i < filteredArgumentTypes.length; i++) {
/*  567 */       if (filteredArgumentTypes[i] instanceof TypeVariable && containsVariableTypeSameParametrizedTypeBound((TypeVariable)filteredArgumentTypes[i], parameterizedType))
/*      */       {
/*  569 */         indexesToRemove = ArrayUtils.add(indexesToRemove, i);
/*      */       }
/*      */     } 
/*  572 */     return indexesToRemove;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GenericArrayType genericArrayType(Type componentType) {
/*  584 */     return new GenericArrayTypeImpl((Type)Validate.notNull(componentType, "componentType", new Object[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String genericArrayTypeToString(GenericArrayType genericArrayType) {
/*  595 */     return String.format("%s[]", new Object[] { toString(genericArrayType.getGenericComponentType()) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type getArrayComponentType(Type type) {
/*  605 */     if (type instanceof Class) {
/*  606 */       Class<?> cls = (Class)type;
/*  607 */       return cls.isArray() ? cls.getComponentType() : null;
/*      */     } 
/*  609 */     if (type instanceof GenericArrayType) {
/*  610 */       return ((GenericArrayType)type).getGenericComponentType();
/*      */     }
/*  612 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type getClosestParentType(Class<?> cls, Class<?> superClass) {
/*  625 */     if (superClass.isInterface()) {
/*      */       
/*  627 */       Type[] interfaceTypes = cls.getGenericInterfaces();
/*      */       
/*  629 */       Type genericInterface = null;
/*      */ 
/*      */       
/*  632 */       for (Type midType : interfaceTypes) {
/*  633 */         Class<?> midClass = null;
/*      */         
/*  635 */         if (midType instanceof ParameterizedType) {
/*  636 */           midClass = getRawType((ParameterizedType)midType);
/*  637 */         } else if (midType instanceof Class) {
/*  638 */           midClass = (Class)midType;
/*      */         } else {
/*  640 */           throw new IllegalStateException("Unexpected generic interface type found: " + midType);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  646 */         if (isAssignable(midClass, superClass) && 
/*  647 */           isAssignable(genericInterface, midClass)) {
/*  648 */           genericInterface = midType;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  653 */       if (genericInterface != null) {
/*  654 */         return genericInterface;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  660 */     return cls.getGenericSuperclass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
/*  673 */     Validate.notNull(typeVariable, "typeVariable", new Object[0]);
/*  674 */     Type[] bounds = typeVariable.getBounds();
/*      */     
/*  676 */     (new Type[1])[0] = Object.class; return (bounds.length == 0) ? new Type[1] : normalizeUpperBounds(bounds);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
/*  689 */     Validate.notNull(wildcardType, "wildcardType", new Object[0]);
/*  690 */     Type[] bounds = wildcardType.getLowerBounds();
/*      */     
/*  692 */     (new Type[1])[0] = null; return (bounds.length == 0) ? new Type[1] : bounds;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
/*  706 */     Validate.notNull(wildcardType, "wildcardType", new Object[0]);
/*  707 */     Type[] bounds = wildcardType.getUpperBounds();
/*      */     
/*  709 */     (new Type[1])[0] = Object.class; return (bounds.length == 0) ? new Type[1] : normalizeUpperBounds(bounds);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class<?> getRawType(ParameterizedType parameterizedType) {
/*  720 */     Type rawType = parameterizedType.getRawType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  727 */     if (!(rawType instanceof Class)) {
/*  728 */       throw new IllegalStateException("Wait... What!? Type of rawType: " + rawType);
/*      */     }
/*      */     
/*  731 */     return (Class)rawType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> getRawType(Type type, Type assigningType) {
/*  747 */     if (type instanceof Class)
/*      */     {
/*  749 */       return (Class)type;
/*      */     }
/*      */     
/*  752 */     if (type instanceof ParameterizedType)
/*      */     {
/*  754 */       return getRawType((ParameterizedType)type);
/*      */     }
/*      */     
/*  757 */     if (type instanceof TypeVariable) {
/*  758 */       if (assigningType == null) {
/*  759 */         return null;
/*      */       }
/*      */ 
/*      */       
/*  763 */       Object genericDeclaration = ((TypeVariable)type).getGenericDeclaration();
/*      */ 
/*      */ 
/*      */       
/*  767 */       if (!(genericDeclaration instanceof Class)) {
/*  768 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  773 */       Map<TypeVariable<?>, Type> typeVarAssigns = getTypeArguments(assigningType, (Class)genericDeclaration);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  778 */       if (typeVarAssigns == null) {
/*  779 */         return null;
/*      */       }
/*      */ 
/*      */       
/*  783 */       Type typeArgument = typeVarAssigns.get(type);
/*      */       
/*  785 */       if (typeArgument == null) {
/*  786 */         return null;
/*      */       }
/*      */ 
/*      */       
/*  790 */       return getRawType(typeArgument, assigningType);
/*      */     } 
/*      */     
/*  793 */     if (type instanceof GenericArrayType) {
/*      */       
/*  795 */       Class<?> rawComponentType = getRawType(((GenericArrayType)type)
/*  796 */           .getGenericComponentType(), assigningType);
/*      */ 
/*      */       
/*  799 */       return Array.newInstance(rawComponentType, 0).getClass();
/*      */     } 
/*      */ 
/*      */     
/*  803 */     if (type instanceof WildcardType) {
/*  804 */       return null;
/*      */     }
/*      */     
/*  807 */     throw new IllegalArgumentException("unknown type: " + type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> cls, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
/*  821 */     if (!isAssignable(cls, toClass)) {
/*  822 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  826 */     if (cls.isPrimitive()) {
/*      */       
/*  828 */       if (toClass.isPrimitive())
/*      */       {
/*      */         
/*  831 */         return new HashMap<>();
/*      */       }
/*      */ 
/*      */       
/*  835 */       cls = ClassUtils.primitiveToWrapper(cls);
/*      */     } 
/*      */ 
/*      */     
/*  839 */     HashMap<TypeVariable<?>, Type> typeVarAssigns = (subtypeVarAssigns == null) ? new HashMap<>() : new HashMap<>(subtypeVarAssigns);
/*      */ 
/*      */ 
/*      */     
/*  843 */     if (toClass.equals(cls)) {
/*  844 */       return typeVarAssigns;
/*      */     }
/*      */ 
/*      */     
/*  848 */     return getTypeArguments(getClosestParentType(cls, toClass), toClass, typeVarAssigns);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType type) {
/*  864 */     return getTypeArguments(type, getRawType(type), (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
/*      */     Map<TypeVariable<?>, Type> typeVarAssigns;
/*  878 */     Class<?> cls = getRawType(parameterizedType);
/*      */ 
/*      */     
/*  881 */     if (!isAssignable(cls, toClass)) {
/*  882 */       return null;
/*      */     }
/*      */     
/*  885 */     Type ownerType = parameterizedType.getOwnerType();
/*      */ 
/*      */     
/*  888 */     if (ownerType instanceof ParameterizedType) {
/*      */       
/*  890 */       ParameterizedType parameterizedOwnerType = (ParameterizedType)ownerType;
/*  891 */       typeVarAssigns = getTypeArguments(parameterizedOwnerType, 
/*  892 */           getRawType(parameterizedOwnerType), subtypeVarAssigns);
/*      */     } else {
/*      */       
/*  895 */       typeVarAssigns = (subtypeVarAssigns == null) ? new HashMap<>() : new HashMap<>(subtypeVarAssigns);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  900 */     Type[] typeArgs = parameterizedType.getActualTypeArguments();
/*      */     
/*  902 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])cls.getTypeParameters();
/*      */ 
/*      */     
/*  905 */     for (int i = 0; i < arrayOfTypeVariable.length; i++) {
/*  906 */       Type typeArg = typeArgs[i];
/*  907 */       typeVarAssigns.put(arrayOfTypeVariable[i], typeVarAssigns
/*      */           
/*  909 */           .getOrDefault(typeArg, typeArg));
/*      */     } 
/*      */ 
/*      */     
/*  913 */     if (toClass.equals(cls))
/*      */     {
/*  915 */       return typeVarAssigns;
/*      */     }
/*      */ 
/*      */     
/*  919 */     return getTypeArguments(getClosestParentType(cls, toClass), toClass, typeVarAssigns);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> toClass) {
/*  961 */     return getTypeArguments(type, toClass, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> toClass, Map<TypeVariable<?>, Type> subtypeVarAssigns) {
/*  974 */     if (type instanceof Class) {
/*  975 */       return getTypeArguments((Class)type, toClass, subtypeVarAssigns);
/*      */     }
/*      */     
/*  978 */     if (type instanceof ParameterizedType) {
/*  979 */       return getTypeArguments((ParameterizedType)type, toClass, subtypeVarAssigns);
/*      */     }
/*      */     
/*  982 */     if (type instanceof GenericArrayType) {
/*  983 */       return getTypeArguments(((GenericArrayType)type).getGenericComponentType(), 
/*  984 */           toClass.isArray() ? toClass.getComponentType() : toClass, subtypeVarAssigns);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  989 */     if (type instanceof WildcardType) {
/*  990 */       for (Type bound : getImplicitUpperBounds((WildcardType)type)) {
/*      */         
/*  992 */         if (isAssignable(bound, toClass)) {
/*  993 */           return getTypeArguments(bound, toClass, subtypeVarAssigns);
/*      */         }
/*      */       } 
/*      */       
/*  997 */       return null;
/*      */     } 
/*      */     
/* 1000 */     if (type instanceof TypeVariable) {
/* 1001 */       for (Type bound : getImplicitBounds((TypeVariable)type)) {
/*      */         
/* 1003 */         if (isAssignable(bound, toClass)) {
/* 1004 */           return getTypeArguments(bound, toClass, subtypeVarAssigns);
/*      */         }
/*      */       } 
/*      */       
/* 1008 */       return null;
/*      */     } 
/* 1010 */     throw new IllegalStateException("found an unhandled type: " + type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isArrayType(Type type) {
/* 1020 */     return (type instanceof GenericArrayType || (type instanceof Class && ((Class)type).isArray()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, Class<?> toClass) {
/* 1032 */     if (type == null)
/*      */     {
/* 1034 */       return (toClass == null || !toClass.isPrimitive());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1039 */     if (toClass == null) {
/* 1040 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1044 */     if (toClass.equals(type)) {
/* 1045 */       return true;
/*      */     }
/*      */     
/* 1048 */     if (type instanceof Class)
/*      */     {
/* 1050 */       return ClassUtils.isAssignable((Class)type, toClass);
/*      */     }
/*      */     
/* 1053 */     if (type instanceof ParameterizedType)
/*      */     {
/* 1055 */       return isAssignable(getRawType((ParameterizedType)type), toClass);
/*      */     }
/*      */ 
/*      */     
/* 1059 */     if (type instanceof TypeVariable) {
/*      */ 
/*      */       
/* 1062 */       for (Type bound : ((TypeVariable)type).getBounds()) {
/* 1063 */         if (isAssignable(bound, toClass)) {
/* 1064 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 1068 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1073 */     if (type instanceof GenericArrayType) {
/* 1074 */       return (toClass.equals(Object.class) || (toClass
/* 1075 */         .isArray() && 
/* 1076 */         isAssignable(((GenericArrayType)type).getGenericComponentType(), toClass
/* 1077 */           .getComponentType())));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1082 */     if (type instanceof WildcardType) {
/* 1083 */       return false;
/*      */     }
/*      */     
/* 1086 */     throw new IllegalStateException("found an unhandled type: " + type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, GenericArrayType toGenericArrayType, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1101 */     if (type == null) {
/* 1102 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1107 */     if (toGenericArrayType == null) {
/* 1108 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1112 */     if (toGenericArrayType.equals(type)) {
/* 1113 */       return true;
/*      */     }
/*      */     
/* 1116 */     Type toComponentType = toGenericArrayType.getGenericComponentType();
/*      */     
/* 1118 */     if (type instanceof Class) {
/* 1119 */       Class<?> cls = (Class)type;
/*      */ 
/*      */       
/* 1122 */       return (cls.isArray() && 
/* 1123 */         isAssignable(cls.getComponentType(), toComponentType, typeVarAssigns));
/*      */     } 
/*      */     
/* 1126 */     if (type instanceof GenericArrayType)
/*      */     {
/* 1128 */       return isAssignable(((GenericArrayType)type).getGenericComponentType(), toComponentType, typeVarAssigns);
/*      */     }
/*      */ 
/*      */     
/* 1132 */     if (type instanceof WildcardType) {
/*      */       
/* 1134 */       for (Type bound : getImplicitUpperBounds((WildcardType)type)) {
/* 1135 */         if (isAssignable(bound, toGenericArrayType)) {
/* 1136 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 1140 */       return false;
/*      */     } 
/*      */     
/* 1143 */     if (type instanceof TypeVariable) {
/*      */ 
/*      */       
/* 1146 */       for (Type bound : getImplicitBounds((TypeVariable)type)) {
/* 1147 */         if (isAssignable(bound, toGenericArrayType)) {
/* 1148 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 1152 */       return false;
/*      */     } 
/*      */     
/* 1155 */     if (type instanceof ParameterizedType)
/*      */     {
/*      */ 
/*      */       
/* 1159 */       return false;
/*      */     }
/*      */     
/* 1162 */     throw new IllegalStateException("found an unhandled type: " + type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, ParameterizedType toParameterizedType, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1176 */     if (type == null) {
/* 1177 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1182 */     if (toParameterizedType == null) {
/* 1183 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1187 */     if (type instanceof GenericArrayType) {
/* 1188 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1192 */     if (toParameterizedType.equals(type)) {
/* 1193 */       return true;
/*      */     }
/*      */ 
/*      */     
/* 1197 */     Class<?> toClass = getRawType(toParameterizedType);
/*      */ 
/*      */     
/* 1200 */     Map<TypeVariable<?>, Type> fromTypeVarAssigns = getTypeArguments(type, toClass, (Map<TypeVariable<?>, Type>)null);
/*      */ 
/*      */     
/* 1203 */     if (fromTypeVarAssigns == null) {
/* 1204 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1210 */     if (fromTypeVarAssigns.isEmpty()) {
/* 1211 */       return true;
/*      */     }
/*      */ 
/*      */     
/* 1215 */     Map<TypeVariable<?>, Type> toTypeVarAssigns = getTypeArguments(toParameterizedType, toClass, typeVarAssigns);
/*      */ 
/*      */ 
/*      */     
/* 1219 */     for (TypeVariable<?> var : toTypeVarAssigns.keySet()) {
/* 1220 */       Type toTypeArg = unrollVariableAssignments(var, toTypeVarAssigns);
/* 1221 */       Type fromTypeArg = unrollVariableAssignments(var, fromTypeVarAssigns);
/*      */       
/* 1223 */       if (toTypeArg == null && fromTypeArg instanceof Class) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1230 */       if (fromTypeArg != null && toTypeArg != null && 
/* 1231 */         !toTypeArg.equals(fromTypeArg) && (!(toTypeArg instanceof WildcardType) || 
/* 1232 */         !isAssignable(fromTypeArg, toTypeArg, typeVarAssigns)))
/*      */       {
/* 1234 */         return false;
/*      */       }
/*      */     } 
/* 1237 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Type type, Type toType) {
/* 1251 */     return isAssignable(type, toType, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, Type toType, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1265 */     if (toType == null || toType instanceof Class) {
/* 1266 */       return isAssignable(type, (Class)toType);
/*      */     }
/*      */     
/* 1269 */     if (toType instanceof ParameterizedType) {
/* 1270 */       return isAssignable(type, (ParameterizedType)toType, typeVarAssigns);
/*      */     }
/*      */     
/* 1273 */     if (toType instanceof GenericArrayType) {
/* 1274 */       return isAssignable(type, (GenericArrayType)toType, typeVarAssigns);
/*      */     }
/*      */     
/* 1277 */     if (toType instanceof WildcardType) {
/* 1278 */       return isAssignable(type, (WildcardType)toType, typeVarAssigns);
/*      */     }
/*      */     
/* 1281 */     if (toType instanceof TypeVariable) {
/* 1282 */       return isAssignable(type, (TypeVariable)toType, typeVarAssigns);
/*      */     }
/*      */     
/* 1285 */     throw new IllegalStateException("found an unhandled type: " + toType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, TypeVariable<?> toTypeVariable, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1300 */     if (type == null) {
/* 1301 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1306 */     if (toTypeVariable == null) {
/* 1307 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1311 */     if (toTypeVariable.equals(type)) {
/* 1312 */       return true;
/*      */     }
/*      */     
/* 1315 */     if (type instanceof TypeVariable) {
/*      */ 
/*      */ 
/*      */       
/* 1319 */       Type[] bounds = getImplicitBounds((TypeVariable)type);
/*      */       
/* 1321 */       for (Type bound : bounds) {
/* 1322 */         if (isAssignable(bound, toTypeVariable, typeVarAssigns)) {
/* 1323 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1328 */     if (type instanceof Class || type instanceof ParameterizedType || type instanceof GenericArrayType || type instanceof WildcardType)
/*      */     {
/* 1330 */       return false;
/*      */     }
/*      */     
/* 1333 */     throw new IllegalStateException("found an unhandled type: " + type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type type, WildcardType toWildcardType, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1348 */     if (type == null) {
/* 1349 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1354 */     if (toWildcardType == null) {
/* 1355 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1359 */     if (toWildcardType.equals(type)) {
/* 1360 */       return true;
/*      */     }
/*      */     
/* 1363 */     Type[] toUpperBounds = getImplicitUpperBounds(toWildcardType);
/* 1364 */     Type[] toLowerBounds = getImplicitLowerBounds(toWildcardType);
/*      */     
/* 1366 */     if (type instanceof WildcardType) {
/* 1367 */       WildcardType wildcardType = (WildcardType)type;
/* 1368 */       Type[] upperBounds = getImplicitUpperBounds(wildcardType);
/* 1369 */       Type[] lowerBounds = getImplicitLowerBounds(wildcardType);
/*      */       
/* 1371 */       for (Type toBound : toUpperBounds) {
/*      */ 
/*      */         
/* 1374 */         toBound = substituteTypeVariables(toBound, typeVarAssigns);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1379 */         for (Type bound : upperBounds) {
/* 1380 */           if (!isAssignable(bound, toBound, typeVarAssigns)) {
/* 1381 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1386 */       for (Type toBound : toLowerBounds) {
/*      */ 
/*      */         
/* 1389 */         toBound = substituteTypeVariables(toBound, typeVarAssigns);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1394 */         for (Type bound : lowerBounds) {
/* 1395 */           if (!isAssignable(toBound, bound, typeVarAssigns)) {
/* 1396 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/* 1400 */       return true;
/*      */     } 
/*      */     
/* 1403 */     for (Type toBound : toUpperBounds) {
/*      */ 
/*      */       
/* 1406 */       if (!isAssignable(type, substituteTypeVariables(toBound, typeVarAssigns), typeVarAssigns))
/*      */       {
/* 1408 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1412 */     for (Type toBound : toLowerBounds) {
/*      */ 
/*      */       
/* 1415 */       if (!isAssignable(substituteTypeVariables(toBound, typeVarAssigns), type, typeVarAssigns))
/*      */       {
/* 1417 */         return false;
/*      */       }
/*      */     } 
/* 1420 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isInstance(Object value, Type type) {
/* 1432 */     if (type == null) {
/* 1433 */       return false;
/*      */     }
/*      */     
/* 1436 */     return (value == null) ? ((!(type instanceof Class) || !((Class)type).isPrimitive())) : 
/* 1437 */       isAssignable(value.getClass(), type, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> void mapTypeVariablesToArguments(Class<T> cls, ParameterizedType parameterizedType, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1451 */     Type ownerType = parameterizedType.getOwnerType();
/*      */     
/* 1453 */     if (ownerType instanceof ParameterizedType)
/*      */     {
/* 1455 */       mapTypeVariablesToArguments(cls, (ParameterizedType)ownerType, typeVarAssigns);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1462 */     Type[] typeArgs = parameterizedType.getActualTypeArguments();
/*      */ 
/*      */ 
/*      */     
/* 1466 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])getRawType(parameterizedType).getTypeParameters();
/*      */ 
/*      */     
/* 1469 */     List<TypeVariable<Class<T>>> typeVarList = Arrays.asList(cls
/* 1470 */         .getTypeParameters());
/*      */     
/* 1472 */     for (int i = 0; i < typeArgs.length; i++) {
/* 1473 */       TypeVariable<?> typeVar = arrayOfTypeVariable[i];
/* 1474 */       Type typeArg = typeArgs[i];
/*      */ 
/*      */       
/* 1477 */       if (typeVarList.contains(typeArg) && typeVarAssigns
/*      */ 
/*      */         
/* 1480 */         .containsKey(typeVar))
/*      */       {
/* 1482 */         typeVarAssigns.put((TypeVariable)typeArg, typeVarAssigns.get(typeVar));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] normalizeUpperBounds(Type[] bounds) {
/* 1512 */     Validate.notNull(bounds, "bounds", new Object[0]);
/*      */     
/* 1514 */     if (bounds.length < 2) {
/* 1515 */       return bounds;
/*      */     }
/*      */     
/* 1518 */     Set<Type> types = new HashSet<>(bounds.length);
/*      */     
/* 1520 */     for (Type type1 : bounds) {
/* 1521 */       boolean subtypeFound = false;
/*      */       
/* 1523 */       for (Type type2 : bounds) {
/* 1524 */         if (type1 != type2 && isAssignable(type2, type1, (Map<TypeVariable<?>, Type>)null)) {
/* 1525 */           subtypeFound = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1530 */       if (!subtypeFound) {
/* 1531 */         types.add(type1);
/*      */       }
/*      */     } 
/*      */     
/* 1535 */     return types.<Type>toArray(ArrayUtils.EMPTY_TYPE_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterize(Class<?> rawClass, Map<TypeVariable<?>, Type> typeVariableMap) {
/* 1548 */     Validate.notNull(rawClass, "rawClass", new Object[0]);
/* 1549 */     Validate.notNull(typeVariableMap, "typeVariableMap", new Object[0]);
/* 1550 */     return parameterizeWithOwner((Type)null, rawClass, 
/* 1551 */         extractTypeArgumentsFrom(typeVariableMap, (TypeVariable<?>[])rawClass.getTypeParameters()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterize(Class<?> rawClass, Type... typeArguments) {
/* 1563 */     return parameterizeWithOwner((Type)null, rawClass, typeArguments);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String parameterizedTypeToString(ParameterizedType parameterizedType) {
/* 1574 */     StringBuilder builder = new StringBuilder();
/*      */     
/* 1576 */     Type useOwner = parameterizedType.getOwnerType();
/* 1577 */     Class<?> raw = (Class)parameterizedType.getRawType();
/*      */     
/* 1579 */     if (useOwner == null) {
/* 1580 */       builder.append(raw.getName());
/*      */     } else {
/* 1582 */       if (useOwner instanceof Class) {
/* 1583 */         builder.append(((Class)useOwner).getName());
/*      */       } else {
/* 1585 */         builder.append(useOwner.toString());
/*      */       } 
/* 1587 */       builder.append('.').append(raw.getSimpleName());
/*      */     } 
/*      */     
/* 1590 */     int[] recursiveTypeIndexes = findRecursiveTypes(parameterizedType);
/*      */     
/* 1592 */     if (recursiveTypeIndexes.length > 0) {
/* 1593 */       appendRecursiveTypes(builder, recursiveTypeIndexes, parameterizedType.getActualTypeArguments());
/*      */     } else {
/* 1595 */       appendAllTo(builder.append('<'), ", ", parameterizedType.getActualTypeArguments()).append('>');
/*      */     } 
/*      */     
/* 1598 */     return builder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterizeWithOwner(Type owner, Class<?> rawClass, Map<TypeVariable<?>, Type> typeVariableMap) {
/* 1612 */     Validate.notNull(rawClass, "rawClass", new Object[0]);
/* 1613 */     Validate.notNull(typeVariableMap, "typeVariableMap", new Object[0]);
/* 1614 */     return parameterizeWithOwner(owner, rawClass, 
/* 1615 */         extractTypeArgumentsFrom(typeVariableMap, (TypeVariable<?>[])rawClass.getTypeParameters()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterizeWithOwner(Type owner, Class<?> rawClass, Type... typeArguments) {
/*      */     Type useOwner;
/* 1630 */     Validate.notNull(rawClass, "rawClass", new Object[0]);
/*      */     
/* 1632 */     if (rawClass.getEnclosingClass() == null) {
/* 1633 */       Validate.isTrue((owner == null), "no owner allowed for top-level %s", new Object[] { rawClass });
/* 1634 */       useOwner = null;
/* 1635 */     } else if (owner == null) {
/* 1636 */       useOwner = rawClass.getEnclosingClass();
/*      */     } else {
/* 1638 */       Validate.isTrue(isAssignable(owner, rawClass.getEnclosingClass()), "%s is invalid owner type for parameterized %s", new Object[] { owner, rawClass });
/*      */       
/* 1640 */       useOwner = owner;
/*      */     } 
/* 1642 */     Validate.noNullElements((Object[])typeArguments, "null type argument at index %s", new Object[0]);
/* 1643 */     Validate.isTrue(((rawClass.getTypeParameters()).length == typeArguments.length), "invalid number of type parameters specified: expected %d, got %d", new Object[] {
/* 1644 */           Integer.valueOf((rawClass.getTypeParameters()).length), 
/* 1645 */           Integer.valueOf(typeArguments.length)
/*      */         });
/* 1647 */     return new ParameterizedTypeImpl(rawClass, useOwner, typeArguments);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type substituteTypeVariables(Type type, Map<TypeVariable<?>, Type> typeVarAssigns) {
/* 1659 */     if (type instanceof TypeVariable && typeVarAssigns != null) {
/* 1660 */       Type replacementType = typeVarAssigns.get(type);
/*      */       
/* 1662 */       if (replacementType == null) {
/* 1663 */         throw new IllegalArgumentException("missing assignment type for type variable " + type);
/*      */       }
/*      */       
/* 1666 */       return replacementType;
/*      */     } 
/* 1668 */     return type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toLongString(TypeVariable<?> typeVariable) {
/* 1679 */     Validate.notNull(typeVariable, "typeVariable", new Object[0]);
/* 1680 */     StringBuilder buf = new StringBuilder();
/* 1681 */     GenericDeclaration d = (GenericDeclaration)typeVariable.getGenericDeclaration();
/* 1682 */     if (d instanceof Class) {
/* 1683 */       Class<?> c = (Class)d;
/*      */       while (true) {
/* 1685 */         if (c.getEnclosingClass() == null) {
/* 1686 */           buf.insert(0, c.getName());
/*      */           break;
/*      */         } 
/* 1689 */         buf.insert(0, c.getSimpleName()).insert(0, '.');
/* 1690 */         c = c.getEnclosingClass();
/*      */       } 
/* 1692 */     } else if (d instanceof Type) {
/* 1693 */       buf.append(toString((Type)d));
/*      */     } else {
/* 1695 */       buf.append(d);
/*      */     } 
/* 1697 */     return buf.append(':').append(typeVariableToString(typeVariable)).toString();
/*      */   }
/*      */   
/*      */   private static <T> String toString(T object) {
/* 1701 */     return (object instanceof Type) ? toString((Type)object) : object.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Type type) {
/* 1712 */     Validate.notNull(type);
/* 1713 */     if (type instanceof Class) {
/* 1714 */       return classToString((Class)type);
/*      */     }
/* 1716 */     if (type instanceof ParameterizedType) {
/* 1717 */       return parameterizedTypeToString((ParameterizedType)type);
/*      */     }
/* 1719 */     if (type instanceof WildcardType) {
/* 1720 */       return wildcardTypeToString((WildcardType)type);
/*      */     }
/* 1722 */     if (type instanceof TypeVariable) {
/* 1723 */       return typeVariableToString((TypeVariable)type);
/*      */     }
/* 1725 */     if (type instanceof GenericArrayType) {
/* 1726 */       return genericArrayTypeToString((GenericArrayType)type);
/*      */     }
/* 1728 */     throw new IllegalArgumentException(ObjectUtils.identityToString(type));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> typeVariableMap) {
/* 1745 */     Validate.notNull(typeVariableMap, "typeVariableMap", new Object[0]);
/*      */ 
/*      */     
/* 1748 */     for (Map.Entry<TypeVariable<?>, Type> entry : typeVariableMap.entrySet()) {
/* 1749 */       TypeVariable<?> typeVar = entry.getKey();
/* 1750 */       Type type = entry.getValue();
/*      */       
/* 1752 */       for (Type bound : getImplicitBounds(typeVar)) {
/* 1753 */         if (!isAssignable(type, substituteTypeVariables(bound, typeVariableMap), typeVariableMap))
/*      */         {
/* 1755 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/* 1759 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String typeVariableToString(TypeVariable<?> typeVariable) {
/* 1770 */     StringBuilder buf = new StringBuilder(typeVariable.getName());
/* 1771 */     Type[] bounds = typeVariable.getBounds();
/* 1772 */     if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
/* 1773 */       buf.append(" extends ");
/* 1774 */       appendAllTo(buf, " & ", typeVariable.getBounds());
/*      */     } 
/* 1776 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type[] unrollBounds(Map<TypeVariable<?>, Type> typeArguments, Type[] bounds) {
/* 1788 */     Type[] result = bounds;
/* 1789 */     int i = 0;
/* 1790 */     for (; i < result.length; i++) {
/* 1791 */       Type unrolled = unrollVariables(typeArguments, result[i]);
/* 1792 */       if (unrolled == null) {
/* 1793 */         result = (Type[])ArrayUtils.remove((Object[])result, i--);
/*      */       } else {
/* 1795 */         result[i] = unrolled;
/*      */       } 
/*      */     } 
/* 1798 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type unrollVariableAssignments(TypeVariable<?> typeVariable, Map<TypeVariable<?>, Type> typeVarAssigns) {
/*      */     Type result;
/*      */     while (true) {
/* 1814 */       result = typeVarAssigns.get(typeVariable);
/* 1815 */       if (result instanceof TypeVariable && !result.equals(typeVariable)) {
/* 1816 */         typeVariable = (TypeVariable)result;
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/* 1821 */     return result;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type unrollVariables(Map<TypeVariable<?>, Type> typeArguments, Type type) {
/* 1833 */     if (typeArguments == null) {
/* 1834 */       typeArguments = Collections.emptyMap();
/*      */     }
/* 1836 */     if (containsTypeVariables(type)) {
/* 1837 */       if (type instanceof TypeVariable) {
/* 1838 */         return unrollVariables(typeArguments, typeArguments.get(type));
/*      */       }
/* 1840 */       if (type instanceof ParameterizedType) {
/* 1841 */         Map<TypeVariable<?>, Type> parameterizedTypeArguments; ParameterizedType p = (ParameterizedType)type;
/*      */         
/* 1843 */         if (p.getOwnerType() == null) {
/* 1844 */           parameterizedTypeArguments = typeArguments;
/*      */         } else {
/* 1846 */           parameterizedTypeArguments = new HashMap<>(typeArguments);
/* 1847 */           parameterizedTypeArguments.putAll(getTypeArguments(p));
/*      */         } 
/* 1849 */         Type[] args = p.getActualTypeArguments();
/* 1850 */         for (int i = 0; i < args.length; i++) {
/* 1851 */           Type unrolled = unrollVariables(parameterizedTypeArguments, args[i]);
/* 1852 */           if (unrolled != null) {
/* 1853 */             args[i] = unrolled;
/*      */           }
/*      */         } 
/* 1856 */         return parameterizeWithOwner(p.getOwnerType(), (Class)p.getRawType(), args);
/*      */       } 
/* 1858 */       if (type instanceof WildcardType) {
/* 1859 */         WildcardType wild = (WildcardType)type;
/* 1860 */         return wildcardType().withUpperBounds(unrollBounds(typeArguments, wild.getUpperBounds()))
/* 1861 */           .withLowerBounds(unrollBounds(typeArguments, wild.getLowerBounds())).build();
/*      */       } 
/*      */     } 
/* 1864 */     return type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WildcardTypeBuilder wildcardType() {
/* 1874 */     return new WildcardTypeBuilder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String wildcardTypeToString(WildcardType wildcardType) {
/* 1885 */     StringBuilder buf = (new StringBuilder()).append('?');
/* 1886 */     Type[] lowerBounds = wildcardType.getLowerBounds();
/* 1887 */     Type[] upperBounds = wildcardType.getUpperBounds();
/* 1888 */     if (lowerBounds.length > 1 || (lowerBounds.length == 1 && lowerBounds[0] != null)) {
/* 1889 */       appendAllTo(buf.append(" super "), " & ", lowerBounds);
/* 1890 */     } else if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
/* 1891 */       appendAllTo(buf.append(" extends "), " & ", upperBounds);
/*      */     } 
/* 1893 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Typed<T> wrap(Class<T> type) {
/* 1905 */     return wrap(type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Typed<T> wrap(Type type) {
/* 1917 */     return () -> type;
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\reflect\TypeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */