/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AtomicPair<K, V>
/*    */ {
/*    */   private K key;
/*    */   private V value;
/*    */   
/*    */   public void setKey(K key) {
/* 14 */     this.key = key; } public void setValue(V value) { this.value = value; } public AtomicPair(K key, V value) {
/* 15 */     this.key = key; this.value = value;
/*    */   }
/* 17 */   public K getKey() { return this.key; } public V getValue() {
/* 18 */     return this.value;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 22 */     if (this == o) return true; 
/* 23 */     if (!(o instanceof AtomicPair)) return false; 
/* 24 */     AtomicPair<?, ?> that = (AtomicPair<?, ?>)o;
/* 25 */     return (Objects.equals(this.key, that.key) && 
/* 26 */       Objects.equals(this.value, that.value));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 31 */     return Objects.hash(new Object[] { this.key, this.value });
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 36 */     return "AtomicPair{key=" + this.key + ", value=" + this.value + '}';
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\AtomicPair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */