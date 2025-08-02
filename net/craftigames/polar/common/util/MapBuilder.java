/*    */ package net.craftigames.polar.common.util;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.function.BiFunction;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapBuilder<K, V>
/*    */ {
/*    */   private final Map<K, V> map;
/*    */   
/*    */   public MapBuilder(Map<K, V> map) {
/* 14 */     this.map = map;
/*    */   }
/*    */   
/*    */   public Map<K, V> getMap() {
/* 18 */     return this.map;
/*    */   }
/*    */   public static <K, V> MapBuilder<K, V> builder(Map<K, V> map) {
/* 21 */     return new MapBuilder<>(map);
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> put(K key, V value) {
/* 25 */     this.map.put(key, value);
/* 26 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> putIfAbsent(K key, V value) {
/* 30 */     this.map.putIfAbsent(key, value);
/* 31 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> remove(Object key) {
/* 35 */     this.map.remove(key);
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> remove(Object key, Object value) {
/* 40 */     this.map.remove(key, value);
/* 41 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
/* 45 */     this.map.compute(key, remappingFunction);
/* 46 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
/* 50 */     this.map.computeIfAbsent(key, mappingFunction);
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public MapBuilder<K, V> computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
/* 55 */     this.map.computeIfPresent(key, remappingFunction);
/* 56 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\MapBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */