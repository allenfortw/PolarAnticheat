/*     */ package org.apache.commons.lang3.tuple;
/*     */ 
/*     */ import java.util.Map;
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
/*     */ public final class ImmutablePair<L, R>
/*     */   extends Pair<L, R>
/*     */ {
/*  46 */   public static final ImmutablePair<?, ?>[] EMPTY_ARRAY = (ImmutablePair<?, ?>[])new ImmutablePair[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static final ImmutablePair NULL = of(null, null);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 4954918890077093841L;
/*     */ 
/*     */ 
/*     */   
/*     */   public final L left;
/*     */ 
/*     */   
/*     */   public final R right;
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, R> ImmutablePair<L, R>[] emptyArray() {
/*  69 */     return (ImmutablePair<L, R>[])EMPTY_ARRAY;
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
/*     */   public static <L, R> Pair<L, R> left(L left) {
/*  85 */     return of(left, null);
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
/*     */   public static <L, R> ImmutablePair<L, R> nullPair() {
/*  97 */     return NULL;
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
/*     */   public static <L, R> ImmutablePair<L, R> of(L left, R right) {
/* 113 */     return new ImmutablePair<>(left, right);
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
/*     */   public static <L, R> ImmutablePair<L, R> of(Map.Entry<L, R> pair) {
/*     */     L left;
/*     */     R right;
/* 131 */     if (pair != null) {
/* 132 */       left = pair.getKey();
/* 133 */       right = pair.getValue();
/*     */     } else {
/* 135 */       left = null;
/* 136 */       right = null;
/*     */     } 
/* 138 */     return new ImmutablePair<>(left, right);
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
/*     */   public static <L, R> Pair<L, R> right(R right) {
/* 154 */     return of(null, right);
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
/*     */   public ImmutablePair(L left, R right) {
/* 170 */     this.left = left;
/* 171 */     this.right = right;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public L getLeft() {
/* 179 */     return this.left;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public R getRight() {
/* 187 */     return this.right;
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
/*     */   public R setValue(R value) {
/* 201 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\tuple\ImmutablePair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */