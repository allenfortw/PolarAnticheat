/*     */ package org.apache.commons.lang3.tuple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ImmutableTriple<L, M, R>
/*     */   extends Triple<L, M, R>
/*     */ {
/*  45 */   public static final ImmutableTriple<?, ?, ?>[] EMPTY_ARRAY = (ImmutableTriple<?, ?, ?>[])new ImmutableTriple[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  52 */   private static final ImmutableTriple NULL = of(null, null, null);
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   
/*     */   public final L left;
/*     */ 
/*     */   
/*     */   public final M middle;
/*     */ 
/*     */   
/*     */   public final R right;
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, M, R> ImmutableTriple<L, M, R>[] emptyArray() {
/*  69 */     return (ImmutableTriple<L, M, R>[])EMPTY_ARRAY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, M, R> ImmutableTriple<L, M, R> nullTriple() {
/*  82 */     return NULL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, M, R> ImmutableTriple<L, M, R> of(L left, M middle, R right) {
/* 100 */     return new ImmutableTriple<>(left, middle, right);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImmutableTriple(L left, M middle, R right) {
/* 118 */     this.left = left;
/* 119 */     this.middle = middle;
/* 120 */     this.right = right;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public L getLeft() {
/* 129 */     return this.left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public M getMiddle() {
/* 137 */     return this.middle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public R getRight() {
/* 145 */     return this.right;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\tuple\ImmutableTriple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */