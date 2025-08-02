/*     */ package gnu.trove.impl.sync;
/*     */ 
/*     */ import gnu.trove.TByteCollection;
/*     */ import gnu.trove.iterator.TByteIterator;
/*     */ import gnu.trove.procedure.TByteProcedure;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ public class TSynchronizedByteCollection
/*     */   implements TByteCollection, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3053995032091335093L;
/*     */   final TByteCollection c;
/*     */   final Object mutex;
/*     */   
/*     */   public TSynchronizedByteCollection(TByteCollection c) {
/*  59 */     if (c == null)
/*  60 */       throw new NullPointerException(); 
/*  61 */     this.c = c;
/*  62 */     this.mutex = this;
/*     */   }
/*     */   public TSynchronizedByteCollection(TByteCollection c, Object mutex) {
/*  65 */     this.c = c;
/*  66 */     this.mutex = mutex;
/*     */   }
/*     */   
/*     */   public int size() {
/*  70 */     synchronized (this.mutex) { return this.c.size(); }
/*     */   
/*     */   } public boolean isEmpty() {
/*  73 */     synchronized (this.mutex) { return this.c.isEmpty(); }
/*     */   
/*     */   } public boolean contains(byte o) {
/*  76 */     synchronized (this.mutex) { return this.c.contains(o); }
/*     */   
/*     */   } public byte[] toArray() {
/*  79 */     synchronized (this.mutex) { return this.c.toArray(); }
/*     */   
/*     */   } public byte[] toArray(byte[] a) {
/*  82 */     synchronized (this.mutex) { return this.c.toArray(a); }
/*     */   
/*     */   }
/*     */   public TByteIterator iterator() {
/*  86 */     return this.c.iterator();
/*     */   }
/*     */   
/*     */   public boolean add(byte e) {
/*  90 */     synchronized (this.mutex) { return this.c.add(e); }
/*     */   
/*     */   } public boolean remove(byte o) {
/*  93 */     synchronized (this.mutex) { return this.c.remove(o); }
/*     */   
/*     */   }
/*     */   public boolean containsAll(Collection<?> coll) {
/*  97 */     synchronized (this.mutex) { return this.c.containsAll(coll); }
/*     */   
/*     */   } public boolean containsAll(TByteCollection coll) {
/* 100 */     synchronized (this.mutex) { return this.c.containsAll(coll); }
/*     */   
/*     */   } public boolean containsAll(byte[] array) {
/* 103 */     synchronized (this.mutex) { return this.c.containsAll(array); }
/*     */   
/*     */   }
/*     */   public boolean addAll(Collection<? extends Byte> coll) {
/* 107 */     synchronized (this.mutex) { return this.c.addAll(coll); }
/*     */   
/*     */   } public boolean addAll(TByteCollection coll) {
/* 110 */     synchronized (this.mutex) { return this.c.addAll(coll); }
/*     */   
/*     */   } public boolean addAll(byte[] array) {
/* 113 */     synchronized (this.mutex) { return this.c.addAll(array); }
/*     */   
/*     */   }
/*     */   public boolean removeAll(Collection<?> coll) {
/* 117 */     synchronized (this.mutex) { return this.c.removeAll(coll); }
/*     */   
/*     */   } public boolean removeAll(TByteCollection coll) {
/* 120 */     synchronized (this.mutex) { return this.c.removeAll(coll); }
/*     */   
/*     */   } public boolean removeAll(byte[] array) {
/* 123 */     synchronized (this.mutex) { return this.c.removeAll(array); }
/*     */   
/*     */   }
/*     */   public boolean retainAll(Collection<?> coll) {
/* 127 */     synchronized (this.mutex) { return this.c.retainAll(coll); }
/*     */   
/*     */   } public boolean retainAll(TByteCollection coll) {
/* 130 */     synchronized (this.mutex) { return this.c.retainAll(coll); }
/*     */   
/*     */   } public boolean retainAll(byte[] array) {
/* 133 */     synchronized (this.mutex) { return this.c.retainAll(array); }
/*     */   
/*     */   } public byte getNoEntryValue() {
/* 136 */     return this.c.getNoEntryValue();
/*     */   } public boolean forEach(TByteProcedure procedure) {
/* 138 */     synchronized (this.mutex) { return this.c.forEach(procedure); }
/*     */   
/*     */   }
/*     */   public void clear() {
/* 142 */     synchronized (this.mutex) { this.c.clear(); }
/*     */   
/*     */   } public String toString() {
/* 145 */     synchronized (this.mutex) { return this.c.toString(); }
/*     */   
/*     */   } private void writeObject(ObjectOutputStream s) throws IOException {
/* 148 */     synchronized (this.mutex) { s.defaultWriteObject(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\TSynchronizedByteCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */