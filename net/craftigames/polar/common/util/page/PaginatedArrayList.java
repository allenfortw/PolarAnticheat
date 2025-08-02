/*     */ package net.craftigames.polar.common.util.page;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ public class PaginatedArrayList implements PaginatedList {
/*  10 */   private static final ArrayList<Object> EMPTY_LIST = new ArrayList(0);
/*     */ 
/*     */   
/*     */   private List<Object> list;
/*     */ 
/*     */   
/*     */   private List<Object> page;
/*     */   
/*     */   private int pageSize;
/*     */   
/*     */   private int index;
/*     */ 
/*     */   
/*     */   public PaginatedArrayList(int pageSize) {
/*  24 */     this.pageSize = pageSize;
/*  25 */     this.index = 0;
/*  26 */     this.list = new ArrayList();
/*  27 */     repaginate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PaginatedArrayList(int initialCapacity, int pageSize) {
/*  37 */     this.pageSize = pageSize;
/*  38 */     this.index = 0;
/*  39 */     this.list = new ArrayList(initialCapacity);
/*  40 */     repaginate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PaginatedArrayList(Collection<?> c, int pageSize) {
/*  50 */     this.pageSize = pageSize;
/*  51 */     this.index = 0;
/*  52 */     this.list = new ArrayList(c);
/*  53 */     repaginate();
/*     */   }
/*     */   
/*     */   private void repaginate() {
/*  57 */     if (this.list.isEmpty()) {
/*  58 */       this.page = EMPTY_LIST;
/*     */     } else {
/*  60 */       int start = this.index * this.pageSize;
/*  61 */       int end = start + this.pageSize - 1;
/*  62 */       if (end >= this.list.size()) {
/*  63 */         end = this.list.size() - 1;
/*     */       }
/*  65 */       if (start >= this.list.size()) {
/*  66 */         this.index = 0;
/*  67 */         repaginate();
/*  68 */       } else if (start < 0) {
/*  69 */         this.index = this.list.size() / this.pageSize;
/*  70 */         if (this.list.size() % this.pageSize == 0) {
/*  71 */           this.index--;
/*     */         }
/*  73 */         repaginate();
/*     */       } else {
/*  75 */         this.page = this.list.subList(start, end + 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  83 */     return this.page.size();
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  87 */     return this.page.isEmpty();
/*     */   }
/*     */   
/*     */   public boolean contains(Object o) {
/*  91 */     return this.page.contains(o);
/*     */   }
/*     */   
/*     */   public Iterator<Object> iterator() {
/*  95 */     return this.page.iterator();
/*     */   }
/*     */   
/*     */   public Object[] toArray() {
/*  99 */     return this.page.toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray(Object[] a) {
/* 104 */     return this.page.toArray(a);
/*     */   }
/*     */   
/*     */   public boolean containsAll(Collection<?> c) {
/* 108 */     return this.page.containsAll(c);
/*     */   }
/*     */   
/*     */   public Object get(int index) {
/* 112 */     return this.page.get(index);
/*     */   }
/*     */   
/*     */   public int indexOf(Object o) {
/* 116 */     return this.page.indexOf(o);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object o) {
/* 120 */     return this.page.lastIndexOf(o);
/*     */   }
/*     */   
/*     */   public ListIterator<Object> listIterator() {
/* 124 */     return this.page.listIterator();
/*     */   }
/*     */   
/*     */   public ListIterator<Object> listIterator(int index) {
/* 128 */     return this.page.listIterator(index);
/*     */   }
/*     */   
/*     */   public List<Object> subList(int fromIndex, int toIndex) {
/* 132 */     return this.page.subList(fromIndex, toIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Object o) {
/* 138 */     boolean b = this.list.add(o);
/* 139 */     repaginate();
/* 140 */     return b;
/*     */   }
/*     */   
/*     */   public boolean remove(Object o) {
/* 144 */     boolean b = this.list.remove(o);
/* 145 */     repaginate();
/* 146 */     return b;
/*     */   }
/*     */   
/*     */   public boolean addAll(Collection<?> c) {
/* 150 */     boolean b = this.list.addAll(c);
/* 151 */     repaginate();
/* 152 */     return b;
/*     */   }
/*     */   
/*     */   public boolean addAll(int index, Collection<?> c) {
/* 156 */     boolean b = this.list.addAll(index, c);
/* 157 */     repaginate();
/* 158 */     return b;
/*     */   }
/*     */   
/*     */   public boolean removeAll(Collection<?> c) {
/* 162 */     boolean b = this.list.removeAll(c);
/* 163 */     repaginate();
/* 164 */     return b;
/*     */   }
/*     */   
/*     */   public boolean retainAll(Collection<?> c) {
/* 168 */     boolean b = this.list.retainAll(c);
/* 169 */     repaginate();
/* 170 */     return b;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 174 */     this.list.clear();
/* 175 */     repaginate();
/*     */   }
/*     */   
/*     */   public Object set(int index, Object element) {
/* 179 */     Object o = this.list.set(index, element);
/* 180 */     repaginate();
/* 181 */     return o;
/*     */   }
/*     */   
/*     */   public void add(int index, Object element) {
/* 185 */     this.list.add(index, element);
/* 186 */     repaginate();
/*     */   }
/*     */   
/*     */   public Object remove(int index) {
/* 190 */     Object o = this.list.remove(index);
/* 191 */     repaginate();
/* 192 */     return o;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPageSize() {
/* 198 */     return this.pageSize;
/*     */   }
/*     */   
/*     */   public boolean isFirstPage() {
/* 202 */     return (this.index == 0);
/*     */   }
/*     */   
/*     */   public boolean isMiddlePage() {
/* 206 */     return (!isFirstPage() && !isLastPage());
/*     */   }
/*     */   
/*     */   public boolean isLastPage() {
/* 210 */     return (this.list.size() - (this.index + 1) * this.pageSize < 1);
/*     */   }
/*     */   
/*     */   public boolean isNextPageAvailable() {
/* 214 */     return !isLastPage();
/*     */   }
/*     */   
/*     */   public boolean isPreviousPageAvailable() {
/* 218 */     return !isFirstPage();
/*     */   }
/*     */   
/*     */   public boolean nextPage() {
/* 222 */     if (isNextPageAvailable()) {
/* 223 */       this.index++;
/* 224 */       repaginate();
/* 225 */       return true;
/*     */     } 
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean previousPage() {
/* 232 */     if (isPreviousPageAvailable()) {
/* 233 */       this.index--;
/* 234 */       repaginate();
/* 235 */       return true;
/*     */     } 
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void gotoPage(int pageNumber) {
/* 242 */     this.index = pageNumber;
/* 243 */     repaginate();
/*     */   }
/*     */   
/*     */   public int getPageIndex() {
/* 247 */     return this.index;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\page\PaginatedArrayList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */