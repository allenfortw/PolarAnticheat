/*    */ package net.craftigames.polar.common.core;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class CoreUtils
/*    */ {
/*    */   public static <T extends Identifiable> T getIdentifiable(int id, T[] collection) {
/*  8 */     for (T entity : collection) {
/*  9 */       if (entity.getId() == id) {
/* 10 */         return entity;
/*    */       }
/*    */     } 
/* 13 */     return null;
/*    */   }
/*    */   
/*    */   public static <T extends Identifiable> T getIdentifiable(int id, Collection<T> collection) {
/* 17 */     for (Identifiable identifiable : collection) {
/* 18 */       if (identifiable.getId() == id) {
/* 19 */         return (T)identifiable;
/*    */       }
/*    */     } 
/* 22 */     return null;
/*    */   }
/*    */   
/*    */   public static <T extends Nameable> T getNameable(String name, T[] collection) {
/* 26 */     for (T entity : collection) {
/* 27 */       if (entity.getName().equalsIgnoreCase(name)) {
/* 28 */         return entity;
/*    */       }
/*    */     } 
/* 31 */     return null;
/*    */   }
/*    */   
/*    */   public static <T extends Nameable> T getNameable(String name, Collection<T> collection) {
/* 35 */     for (Nameable nameable : collection) {
/* 36 */       if (nameable.getName().equalsIgnoreCase(name)) {
/* 37 */         return (T)nameable;
/*    */       }
/*    */     } 
/* 40 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\CoreUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */