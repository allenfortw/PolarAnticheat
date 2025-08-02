/*     */ package gnu.trove.list.linked;
/*     */ 
/*     */ import gnu.trove.list.TLinkable;
/*     */ import gnu.trove.procedure.TObjectProcedure;
/*     */ import java.io.Externalizable;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.AbstractSequentialList;
/*     */ import java.util.ListIterator;
/*     */ import java.util.NoSuchElementException;
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
/*     */ public class TLinkedList<T extends TLinkable<T>>
/*     */   extends AbstractSequentialList<T>
/*     */   implements Externalizable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   protected T _head;
/*     */   protected T _tail;
/*  77 */   protected int _size = 0;
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
/*     */   public ListIterator<T> listIterator(int index) {
/*  99 */     return new IteratorImpl(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 109 */     return this._size;
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
/*     */   public void add(int index, T linkable) {
/* 122 */     if (index < 0 || index > size()) {
/* 123 */       throw new IndexOutOfBoundsException("index:" + index);
/*     */     }
/* 125 */     insert(index, linkable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(T linkable) {
/* 136 */     insert(this._size, linkable);
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFirst(T linkable) {
/* 147 */     insert(0, linkable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLast(T linkable) {
/* 157 */     insert(size(), linkable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 163 */     if (null != this._head) {
/* 164 */       TLinkable<T> link = this._head.getNext();
/* 165 */       for (; link != null; 
/* 166 */         link = link.getNext()) {
/* 167 */         TLinkable<T> prev = link.getPrevious();
/* 168 */         prev.setNext(null);
/* 169 */         link.setPrevious(null);
/*     */       } 
/* 171 */       this._head = this._tail = null;
/*     */     } 
/* 173 */     this._size = 0;
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
/*     */   public Object[] toArray() {
/* 189 */     Object[] o = new Object[this._size];
/* 190 */     int i = 0;
/* 191 */     for (T t = this._head; t != null; tLinkable = t.getNext()) {
/* 192 */       TLinkable tLinkable; o[i++] = t;
/*     */     } 
/* 194 */     return o;
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
/*     */   public Object[] toUnlinkedArray() {
/* 209 */     Object[] o = new Object[this._size];
/* 210 */     int i = 0;
/* 211 */     for (T t = this._head; t != null; i++) {
/* 212 */       o[i] = t;
/* 213 */       T t1 = t;
/* 214 */       TLinkable tLinkable = t.getNext();
/* 215 */       t1.setNext(null);
/* 216 */       t1.setPrevious(null);
/*     */     } 
/* 218 */     this._size = 0;
/* 219 */     this._head = this._tail = null;
/* 220 */     return o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] toUnlinkedArray(T[] a) {
/*     */     TLinkable[] arrayOfTLinkable;
/* 232 */     int size = size();
/* 233 */     if (a.length < size) {
/* 234 */       arrayOfTLinkable = (TLinkable[])Array.newInstance(a.getClass().getComponentType(), size);
/*     */     }
/*     */     
/* 237 */     int i = 0;
/* 238 */     for (T link = this._head; link != null; i++) {
/* 239 */       arrayOfTLinkable[i] = (TLinkable)link;
/* 240 */       T tmp = link;
/* 241 */       TLinkable tLinkable = link.getNext();
/* 242 */       tmp.setNext(null);
/* 243 */       tmp.setPrevious(null);
/*     */     } 
/* 245 */     this._size = 0;
/* 246 */     this._head = this._tail = null;
/* 247 */     return (T[])arrayOfTLinkable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object o) {
/* 258 */     for (T t = this._head; t != null; tLinkable = t.getNext()) {
/* 259 */       TLinkable tLinkable; if (o.equals(t)) {
/* 260 */         return true;
/*     */       }
/*     */     } 
/* 263 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(int index) {
/*     */     TLinkable tLinkable;
/* 272 */     if (index < 0 || index >= this._size) {
/* 273 */       throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this._size);
/*     */     }
/*     */ 
/*     */     
/* 277 */     if (index > this._size >> 1) {
/* 278 */       int i = this._size - 1;
/* 279 */       T t = this._tail;
/*     */       
/* 281 */       while (i > index) {
/* 282 */         tLinkable = t.getPrevious();
/* 283 */         i--;
/*     */       } 
/*     */       
/* 286 */       return (T)tLinkable;
/*     */     } 
/* 288 */     int position = 0;
/* 289 */     T node = this._head;
/*     */     
/* 291 */     while (position < index) {
/* 292 */       tLinkable = node.getNext();
/* 293 */       position++;
/*     */     } 
/*     */     
/* 296 */     return (T)tLinkable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getFirst() {
/* 307 */     return this._head;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getLast() {
/* 317 */     return this._tail;
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
/*     */ 
/*     */   
/*     */   public T getNext(T current) {
/* 337 */     return (T)current.getNext();
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
/*     */ 
/*     */   
/*     */   public T getPrevious(T current) {
/* 357 */     return (T)current.getPrevious();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T removeFirst() {
/* 368 */     T o = this._head;
/*     */     
/* 370 */     if (o == null) {
/* 371 */       return null;
/*     */     }
/*     */     
/* 374 */     TLinkable tLinkable = o.getNext();
/* 375 */     o.setNext(null);
/*     */     
/* 377 */     if (null != tLinkable) {
/* 378 */       tLinkable.setPrevious(null);
/*     */     }
/*     */     
/* 381 */     this._head = (T)tLinkable;
/* 382 */     if (--this._size == 0) {
/* 383 */       this._tail = null;
/*     */     }
/* 385 */     return o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T removeLast() {
/* 396 */     T o = this._tail;
/*     */     
/* 398 */     if (o == null) {
/* 399 */       return null;
/*     */     }
/*     */     
/* 402 */     TLinkable tLinkable = o.getPrevious();
/* 403 */     o.setPrevious(null);
/*     */     
/* 405 */     if (null != tLinkable) {
/* 406 */       tLinkable.setNext(null);
/*     */     }
/* 408 */     this._tail = (T)tLinkable;
/* 409 */     if (--this._size == 0) {
/* 410 */       this._head = null;
/*     */     }
/* 412 */     return o;
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
/*     */   protected void insert(int index, T linkable) {
/* 425 */     if (this._size == 0) {
/* 426 */       this._head = this._tail = linkable;
/* 427 */     } else if (index == 0) {
/* 428 */       linkable.setNext((TLinkable)this._head);
/* 429 */       this._head.setPrevious((TLinkable)linkable);
/* 430 */       this._head = linkable;
/* 431 */     } else if (index == this._size) {
/* 432 */       this._tail.setNext((TLinkable)linkable);
/* 433 */       linkable.setPrevious((TLinkable)this._tail);
/* 434 */       this._tail = linkable;
/*     */     } else {
/* 436 */       T node = get(index);
/*     */       
/* 438 */       TLinkable tLinkable = node.getPrevious();
/* 439 */       if (tLinkable != null) {
/* 440 */         tLinkable.setNext((TLinkable)linkable);
/*     */       }
/*     */       
/* 443 */       linkable.setPrevious(tLinkable);
/* 444 */       linkable.setNext((TLinkable)node);
/* 445 */       node.setPrevious((TLinkable)linkable);
/*     */     } 
/* 447 */     this._size++;
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
/*     */   public boolean remove(Object o) {
/* 462 */     if (o instanceof TLinkable) {
/*     */       
/* 464 */       TLinkable<T> link = (TLinkable<T>)o;
/*     */       
/* 466 */       TLinkable tLinkable1 = link.getPrevious();
/* 467 */       TLinkable tLinkable2 = link.getNext();
/*     */       
/* 469 */       if (tLinkable2 == null && tLinkable1 == null) {
/*     */ 
/*     */ 
/*     */         
/* 473 */         if (o != this._head) {
/* 474 */           return false;
/*     */         }
/*     */         
/* 477 */         this._head = this._tail = null;
/* 478 */       } else if (tLinkable2 == null) {
/*     */         
/* 480 */         link.setPrevious(null);
/* 481 */         tLinkable1.setNext(null);
/* 482 */         this._tail = (T)tLinkable1;
/* 483 */       } else if (tLinkable1 == null) {
/*     */         
/* 485 */         link.setNext(null);
/* 486 */         tLinkable2.setPrevious(null);
/* 487 */         this._head = (T)tLinkable2;
/*     */       } else {
/* 489 */         tLinkable1.setNext(tLinkable2);
/* 490 */         tLinkable2.setPrevious(tLinkable1);
/* 491 */         link.setNext(null);
/* 492 */         link.setPrevious(null);
/*     */       } 
/*     */       
/* 495 */       this._size--;
/* 496 */       return true;
/*     */     } 
/* 498 */     return false;
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
/*     */   public void addBefore(T current, T newElement) {
/* 513 */     if (current == this._head) {
/* 514 */       addFirst(newElement);
/* 515 */     } else if (current == null) {
/* 516 */       addLast(newElement);
/*     */     } else {
/* 518 */       TLinkable tLinkable = current.getPrevious();
/* 519 */       newElement.setNext((TLinkable)current);
/* 520 */       tLinkable.setNext((TLinkable)newElement);
/* 521 */       newElement.setPrevious(tLinkable);
/* 522 */       current.setPrevious((TLinkable)newElement);
/* 523 */       this._size++;
/*     */     } 
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
/*     */   public void addAfter(T current, T newElement) {
/* 538 */     if (current == this._tail) {
/* 539 */       addLast(newElement);
/* 540 */     } else if (current == null) {
/* 541 */       addFirst(newElement);
/*     */     } else {
/* 543 */       TLinkable tLinkable = current.getNext();
/* 544 */       newElement.setPrevious((TLinkable)current);
/* 545 */       newElement.setNext(tLinkable);
/* 546 */       current.setNext((TLinkable)newElement);
/* 547 */       tLinkable.setPrevious((TLinkable)newElement);
/* 548 */       this._size++;
/*     */     } 
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
/*     */   public boolean forEachValue(TObjectProcedure<T> procedure) {
/* 562 */     T node = this._head;
/* 563 */     while (node != null) {
/* 564 */       boolean keep_going = procedure.execute(node);
/* 565 */       if (!keep_going) {
/* 566 */         return false;
/*     */       }
/*     */       
/* 569 */       TLinkable tLinkable = node.getNext();
/*     */     } 
/*     */     
/* 572 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 578 */     out.writeByte(0);
/*     */ 
/*     */     
/* 581 */     out.writeInt(this._size);
/*     */ 
/*     */     
/* 584 */     out.writeObject(this._head);
/*     */ 
/*     */     
/* 587 */     out.writeObject(this._tail);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 596 */     in.readByte();
/*     */ 
/*     */     
/* 599 */     this._size = in.readInt();
/*     */ 
/*     */     
/* 602 */     this._head = (T)in.readObject();
/*     */ 
/*     */     
/* 605 */     this._tail = (T)in.readObject();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final class IteratorImpl
/*     */     implements ListIterator<T>
/*     */   {
/* 612 */     private int _nextIndex = 0;
/*     */ 
/*     */ 
/*     */     
/*     */     private T _next;
/*     */ 
/*     */ 
/*     */     
/*     */     private T _lastReturned;
/*     */ 
/*     */ 
/*     */     
/*     */     IteratorImpl(int position) {
/* 625 */       if (position < 0 || position > TLinkedList.this._size) {
/* 626 */         throw new IndexOutOfBoundsException();
/*     */       }
/*     */       
/* 629 */       this._nextIndex = position;
/* 630 */       if (position == 0) {
/* 631 */         this._next = TLinkedList.this._head;
/* 632 */       } else if (position == TLinkedList.this._size) {
/* 633 */         this._next = null;
/* 634 */       } else if (position < TLinkedList.this._size >> 1) {
/* 635 */         int pos = 0;
/* 636 */         for (this._next = TLinkedList.this._head; pos < position; pos++) {
/* 637 */           this._next = (T)this._next.getNext();
/*     */         }
/*     */       } else {
/* 640 */         int pos = TLinkedList.this._size - 1;
/* 641 */         for (this._next = TLinkedList.this._tail; pos > position; pos--) {
/* 642 */           this._next = (T)this._next.getPrevious();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void add(T linkable) {
/* 655 */       this._lastReturned = null;
/* 656 */       this._nextIndex++;
/*     */       
/* 658 */       if (TLinkedList.this._size == 0) {
/* 659 */         TLinkedList.this.add(linkable);
/*     */       } else {
/* 661 */         TLinkedList.this.addBefore(this._next, linkable);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 672 */       return (this._nextIndex != TLinkedList.this._size);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean hasPrevious() {
/* 682 */       return (this._nextIndex != 0);
/*     */     }
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
/*     */     public final T next() {
/* 695 */       if (this._nextIndex == TLinkedList.this._size) {
/* 696 */         throw new NoSuchElementException();
/*     */       }
/*     */       
/* 699 */       this._lastReturned = this._next;
/* 700 */       this._next = (T)this._next.getNext();
/* 701 */       this._nextIndex++;
/* 702 */       return this._lastReturned;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int nextIndex() {
/* 713 */       return this._nextIndex;
/*     */     }
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
/*     */     public final T previous() {
/* 726 */       if (this._nextIndex == 0) {
/* 727 */         throw new NoSuchElementException();
/*     */       }
/*     */       
/* 730 */       if (this._nextIndex == TLinkedList.this._size) {
/* 731 */         this._lastReturned = this._next = TLinkedList.this._tail;
/*     */       } else {
/* 733 */         this._lastReturned = this._next = (T)this._next.getPrevious();
/*     */       } 
/*     */       
/* 736 */       this._nextIndex--;
/* 737 */       return this._lastReturned;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int previousIndex() {
/* 747 */       return this._nextIndex - 1;
/*     */     }
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
/*     */     public final void remove() {
/* 761 */       if (this._lastReturned == null) {
/* 762 */         throw new IllegalStateException("must invoke next or previous before invoking remove");
/*     */       }
/*     */       
/* 765 */       if (this._lastReturned != this._next) {
/* 766 */         this._nextIndex--;
/*     */       }
/* 768 */       this._next = (T)this._lastReturned.getNext();
/* 769 */       TLinkedList.this.remove(this._lastReturned);
/* 770 */       this._lastReturned = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void set(T linkable) {
/* 781 */       if (this._lastReturned == null) {
/* 782 */         throw new IllegalStateException();
/*     */       }
/*     */       
/* 785 */       swap(this._lastReturned, linkable);
/* 786 */       this._lastReturned = linkable;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void swap(T from, T to) {
/* 797 */       TLinkable tLinkable1 = from.getPrevious();
/* 798 */       TLinkable tLinkable2 = from.getNext();
/*     */       
/* 800 */       TLinkable tLinkable3 = to.getPrevious();
/* 801 */       TLinkable tLinkable4 = to.getNext();
/*     */ 
/*     */       
/* 804 */       if (tLinkable2 == to) {
/* 805 */         if (tLinkable1 != null) tLinkable1.setNext((TLinkable)to); 
/* 806 */         to.setPrevious(tLinkable1);
/* 807 */         to.setNext((TLinkable)from);
/* 808 */         from.setPrevious((TLinkable)to);
/* 809 */         from.setNext(tLinkable4);
/* 810 */         if (tLinkable4 != null) tLinkable4.setPrevious((TLinkable)from);
/*     */       
/*     */       }
/* 813 */       else if (tLinkable4 == from) {
/* 814 */         if (tLinkable3 != null) tLinkable3.setNext((TLinkable)to); 
/* 815 */         to.setPrevious((TLinkable)from);
/* 816 */         to.setNext(tLinkable2);
/* 817 */         from.setPrevious(tLinkable3);
/* 818 */         from.setNext((TLinkable)to);
/* 819 */         if (tLinkable2 != null) tLinkable2.setPrevious((TLinkable)to);
/*     */       
/*     */       } else {
/* 822 */         from.setNext(tLinkable4);
/* 823 */         from.setPrevious(tLinkable3);
/* 824 */         if (tLinkable3 != null) tLinkable3.setNext((TLinkable)from); 
/* 825 */         if (tLinkable4 != null) tLinkable4.setPrevious((TLinkable)from);
/*     */         
/* 827 */         to.setNext(tLinkable2);
/* 828 */         to.setPrevious(tLinkable1);
/* 829 */         if (tLinkable1 != null) tLinkable1.setNext((TLinkable)to); 
/* 830 */         if (tLinkable2 != null) tLinkable2.setPrevious((TLinkable)to);
/*     */       
/*     */       } 
/* 833 */       if (TLinkedList.this._head == from) { TLinkedList.this._head = to; }
/* 834 */       else if (TLinkedList.this._head == to) { TLinkedList.this._head = from; }
/*     */       
/* 836 */       if (TLinkedList.this._tail == from) { TLinkedList.this._tail = to; }
/* 837 */       else if (TLinkedList.this._tail == to) { TLinkedList.this._tail = from; }
/*     */       
/* 839 */       if (this._lastReturned == from) { this._lastReturned = to; }
/* 840 */       else if (this._lastReturned == to) { this._lastReturned = from; }
/*     */       
/* 842 */       if (this._next == from) { this._next = to; }
/* 843 */       else if (this._next == to) { this._next = from; }
/*     */     
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\list\linked\TLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */