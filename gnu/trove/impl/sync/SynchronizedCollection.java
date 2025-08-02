/*    */ package gnu.trove.impl.sync;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SynchronizedCollection<E>
/*    */   implements Collection<E>, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3053995032091335093L;
/*    */   final Collection<E> c;
/*    */   final Object mutex;
/*    */   
/*    */   SynchronizedCollection(Collection<E> c, Object mutex) {
/* 38 */     this.c = c;
/* 39 */     this.mutex = mutex;
/*    */   }
/*    */   
/*    */   public int size() {
/* 43 */     synchronized (this.mutex) { return this.c.size(); }
/*    */   
/*    */   } public boolean isEmpty() {
/* 46 */     synchronized (this.mutex) { return this.c.isEmpty(); }
/*    */   
/*    */   } public boolean contains(Object o) {
/* 49 */     synchronized (this.mutex) { return this.c.contains(o); }
/*    */   
/*    */   } public Object[] toArray() {
/* 52 */     synchronized (this.mutex) { return this.c.toArray(); }
/*    */   
/*    */   }
/*    */   public <T> T[] toArray(T[] a) {
/* 56 */     synchronized (this.mutex) { return this.c.toArray(a); }
/*    */   
/*    */   }
/*    */   public Iterator<E> iterator() {
/* 60 */     return this.c.iterator();
/*    */   }
/*    */   
/*    */   public boolean add(E e) {
/* 64 */     synchronized (this.mutex) { return this.c.add(e); }
/*    */   
/*    */   } public boolean remove(Object o) {
/* 67 */     synchronized (this.mutex) { return this.c.remove(o); }
/*    */   
/*    */   }
/*    */   public boolean containsAll(Collection<?> coll) {
/* 71 */     synchronized (this.mutex) { return this.c.containsAll(coll); }
/*    */   
/*    */   } public boolean addAll(Collection<? extends E> coll) {
/* 74 */     synchronized (this.mutex) { return this.c.addAll(coll); }
/*    */   
/*    */   } public boolean removeAll(Collection<?> coll) {
/* 77 */     synchronized (this.mutex) { return this.c.removeAll(coll); }
/*    */   
/*    */   } public boolean retainAll(Collection<?> coll) {
/* 80 */     synchronized (this.mutex) { return this.c.retainAll(coll); }
/*    */   
/*    */   } public void clear() {
/* 83 */     synchronized (this.mutex) { this.c.clear(); }
/*    */   
/*    */   } public String toString() {
/* 86 */     synchronized (this.mutex) { return this.c.toString(); }
/*    */   
/*    */   } private void writeObject(ObjectOutputStream s) throws IOException {
/* 89 */     synchronized (this.mutex) { s.defaultWriteObject(); }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\sync\SynchronizedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */