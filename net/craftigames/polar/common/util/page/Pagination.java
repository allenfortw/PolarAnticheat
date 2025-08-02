/*    */ package net.craftigames.polar.common.util.page;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Pagination<T>
/*    */   extends ArrayList<T> {
/*    */   private int pageSize;
/*    */   
/*    */   public Pagination(int pageSize) {
/* 13 */     this(pageSize, new ArrayList<>());
/*    */   }
/*    */   
/*    */   @SafeVarargs
/*    */   public Pagination(int pageSize, T... objects) {
/* 18 */     this(pageSize, Arrays.asList(objects));
/*    */   }
/*    */   
/*    */   public Pagination(int pageSize, List<T> objects) {
/* 22 */     this.pageSize = pageSize;
/* 23 */     addAll(objects);
/*    */   }
/*    */   
/*    */   public Pagination(int pageSize, Collection<T> objects) {
/* 27 */     this.pageSize = pageSize;
/* 28 */     addAll(objects);
/*    */   }
/*    */   
/*    */   public int pageSize() {
/* 32 */     return this.pageSize;
/*    */   }
/*    */   
/*    */   public int totalPages() {
/* 36 */     return (int)Math.ceil(size() / this.pageSize);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean exists(int page) {
/* 43 */     return (page >= 0 && page < totalPages());
/*    */   }
/*    */   
/*    */   public boolean hasNextPage(int page) {
/* 47 */     return (page + 1 < totalPages());
/*    */   }
/*    */   
/*    */   public boolean hasPrevious(int page) {
/* 51 */     return (page - 1 >= 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<T> getPage(int page) {
/* 58 */     if (!exists(page)) {
/* 59 */       throw new IndexOutOfBoundsException("Index: " + page + ", Size: " + totalPages());
/*    */     }
/*    */     
/* 62 */     List<T> objects = new ArrayList<>();
/*    */     
/* 64 */     int min = page * this.pageSize;
/* 65 */     int max = page * this.pageSize + this.pageSize;
/*    */     
/* 67 */     if (max > size()) {
/* 68 */       max = size();
/*    */     }
/*    */     
/* 71 */     for (int i = min; max > i; i++) {
/* 72 */       objects.add(get(i));
/*    */     }
/*    */     
/* 75 */     return objects;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\page\Pagination.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */