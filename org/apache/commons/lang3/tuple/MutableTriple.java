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
/*     */ public class MutableTriple<L, M, R>
/*     */   extends Triple<L, M, R>
/*     */ {
/*  40 */   public static final MutableTriple<?, ?, ?>[] EMPTY_ARRAY = (MutableTriple<?, ?, ?>[])new MutableTriple[0];
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   
/*     */   public L left;
/*     */ 
/*     */   
/*     */   public M middle;
/*     */ 
/*     */   
/*     */   public R right;
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, M, R> MutableTriple<L, M, R>[] emptyArray() {
/*  57 */     return (MutableTriple<L, M, R>[])EMPTY_ARRAY;
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
/*     */   public static <L, M, R> MutableTriple<L, M, R> of(L left, M middle, R right) {
/*  75 */     return new MutableTriple<>(left, middle, right);
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
/*     */   public MutableTriple() {}
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
/*     */   public MutableTriple(L left, M middle, R right) {
/*  99 */     this.left = left;
/* 100 */     this.middle = middle;
/* 101 */     this.right = right;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public L getLeft() {
/* 110 */     return this.left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public M getMiddle() {
/* 118 */     return this.middle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public R getRight() {
/* 126 */     return this.right;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeft(L left) {
/* 135 */     this.left = left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMiddle(M middle) {
/* 144 */     this.middle = middle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRight(R right) {
/* 153 */     this.right = right;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\tuple\MutableTriple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */