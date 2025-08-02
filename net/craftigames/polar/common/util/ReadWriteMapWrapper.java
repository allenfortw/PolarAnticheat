/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ public class ReadWriteMapWrapper<K, V>
/*     */   implements Map<K, V> {
/*     */   private final Map<K, V> map;
/*  14 */   private final ReadWriteLock lock = new ReentrantReadWriteLock();
/*  15 */   private final Lock r = this.lock.readLock();
/*  16 */   private final Lock w = this.lock.writeLock();
/*     */   
/*     */   public static <K, V> ReadWriteMapWrapper<K, V> of(Map<K, V> map) {
/*  19 */     return new ReadWriteMapWrapper<>(map);
/*     */   }
/*     */   
/*     */   public ReadWriteMapWrapper(Map<K, V> map) {
/*  23 */     this.map = map;
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K key, V value) {
/*  28 */     this.w.lock();
/*     */     try {
/*  30 */       return this.map.put(key, value);
/*     */     } finally {
/*  32 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object key) {
/*  38 */     this.w.lock();
/*     */     try {
/*  40 */       return this.map.remove(key);
/*     */     } finally {
/*  42 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(@Nonnull Map<? extends K, ? extends V> m) {
/*  48 */     this.w.lock();
/*     */     try {
/*  50 */       this.map.putAll(m);
/*     */     } finally {
/*  52 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  58 */     this.w.lock();
/*     */     try {
/*  60 */       this.map.clear();
/*     */     } finally {
/*  62 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object key) {
/*  68 */     this.r.lock();
/*     */     try {
/*  70 */       return this.map.get(key);
/*     */     } finally {
/*  72 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  78 */     this.r.lock();
/*     */     try {
/*  80 */       return this.map.size();
/*     */     } finally {
/*  82 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  88 */     this.r.lock();
/*     */     try {
/*  90 */       return this.map.isEmpty();
/*     */     } finally {
/*  92 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object key) {
/*  98 */     this.r.lock();
/*     */     try {
/* 100 */       return this.map.containsKey(key);
/*     */     } finally {
/* 102 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object value) {
/* 108 */     this.r.lock();
/*     */     try {
/* 110 */       return this.map.containsValue(value);
/*     */     } finally {
/* 112 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Set<K> keySet() {
/* 119 */     this.r.lock();
/*     */     try {
/* 121 */       return this.map.keySet();
/*     */     } finally {
/* 123 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Collection<V> values() {
/* 130 */     this.r.lock();
/*     */     try {
/* 132 */       return this.map.values();
/*     */     } finally {
/* 134 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 141 */     this.r.lock();
/*     */     try {
/* 143 */       return this.map.entrySet();
/*     */     } finally {
/* 145 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ReadWriteMapWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */