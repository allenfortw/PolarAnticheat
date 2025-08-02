/*     */ package net.craftigames.polar.common.util;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ public class ReadWriteListWrapper<E> implements List<E> {
/*  12 */   private final ReadWriteLock lock = new ReentrantReadWriteLock(); private final List<E> list;
/*  13 */   private final Lock r = this.lock.readLock();
/*  14 */   private final Lock w = this.lock.writeLock();
/*     */   
/*     */   public static <E> ReadWriteListWrapper<E> of(List<E> map) {
/*  17 */     return new ReadWriteListWrapper<>(map);
/*     */   }
/*     */   
/*     */   public ReadWriteListWrapper(List<E> list) {
/*  21 */     this.list = list;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  26 */     this.r.lock();
/*     */     try {
/*  28 */       return this.list.size();
/*     */     } finally {
/*  30 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  36 */     this.r.lock();
/*     */     try {
/*  38 */       return this.list.isEmpty();
/*     */     } finally {
/*  40 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object o) {
/*  46 */     this.r.lock();
/*     */     try {
/*  48 */       return this.list.contains(o);
/*     */     } finally {
/*  50 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Iterator<E> iterator() {
/*  57 */     this.r.lock();
/*     */     try {
/*  59 */       return this.list.iterator();
/*     */     } finally {
/*  61 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public Object[] toArray() {
/*  68 */     this.r.lock();
/*     */     try {
/*  70 */       return this.list.toArray();
/*     */     } finally {
/*  72 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(@Nonnull T[] a) {
/*  78 */     this.r.lock();
/*     */     try {
/*  80 */       return (T[])this.list.toArray((Object[])a);
/*     */     } finally {
/*  82 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E e) {
/*  88 */     this.w.lock();
/*     */     try {
/*  90 */       return this.list.add(e);
/*     */     } finally {
/*  92 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object o) {
/*  98 */     this.w.lock();
/*     */     try {
/* 100 */       return this.list.remove(o);
/*     */     } finally {
/* 102 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(@Nonnull Collection<?> c) {
/* 108 */     this.r.lock();
/*     */     try {
/* 110 */       return this.list.containsAll(c);
/*     */     } finally {
/* 112 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(@Nonnull Collection<? extends E> c) {
/* 118 */     this.w.lock();
/*     */     try {
/* 120 */       return this.list.addAll(c);
/*     */     } finally {
/* 122 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(int index, @Nonnull Collection<? extends E> c) {
/* 128 */     this.w.lock();
/*     */     try {
/* 130 */       return this.list.addAll(c);
/*     */     } finally {
/* 132 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(@Nonnull Collection<?> c) {
/* 138 */     this.w.lock();
/*     */     try {
/* 140 */       return this.list.removeAll(c);
/*     */     } finally {
/* 142 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(@Nonnull Collection<?> c) {
/* 148 */     this.w.lock();
/*     */     try {
/* 150 */       return this.list.retainAll(c);
/*     */     } finally {
/* 152 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 158 */     this.w.lock();
/*     */     try {
/* 160 */       this.list.clear();
/*     */     } finally {
/* 162 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public E get(int index) {
/* 168 */     this.r.lock();
/*     */     try {
/* 170 */       return this.list.get(index);
/*     */     } finally {
/* 172 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(int index, E element) {
/* 178 */     this.w.lock();
/*     */     try {
/* 180 */       return this.list.set(index, element);
/*     */     } finally {
/* 182 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int index, E element) {
/* 188 */     this.w.lock();
/*     */     try {
/* 190 */       this.list.add(index, element);
/*     */     } finally {
/* 192 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove(int index) {
/* 198 */     this.w.lock();
/*     */     try {
/* 200 */       return this.list.remove(index);
/*     */     } finally {
/* 202 */       this.w.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object o) {
/* 208 */     this.r.lock();
/*     */     try {
/* 210 */       return this.list.indexOf(o);
/*     */     } finally {
/* 212 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object o) {
/* 218 */     this.r.lock();
/*     */     try {
/* 220 */       return this.list.lastIndexOf(o);
/*     */     } finally {
/* 222 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public ListIterator<E> listIterator() {
/* 229 */     this.r.lock();
/*     */     try {
/* 231 */       return this.list.listIterator();
/*     */     } finally {
/* 233 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public ListIterator<E> listIterator(int index) {
/* 240 */     this.r.lock();
/*     */     try {
/* 242 */       return this.list.listIterator(index);
/*     */     } finally {
/* 244 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public List<E> subList(int fromIndex, int toIndex) {
/* 251 */     this.r.lock();
/*     */     try {
/* 253 */       return this.list.subList(fromIndex, toIndex);
/*     */     } finally {
/* 255 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Collection<E> get() {
/* 260 */     this.r.lock();
/*     */     try {
/* 262 */       return Collections.unmodifiableCollection(this.list);
/*     */     } finally {
/* 264 */       this.r.unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ReadWriteListWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */