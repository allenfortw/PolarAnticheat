/*      */ package gnu.trove.list.array;
/*      */ 
/*      */ import gnu.trove.TShortCollection;
/*      */ import gnu.trove.function.TShortFunction;
/*      */ import gnu.trove.impl.HashFunctions;
/*      */ import gnu.trove.iterator.TShortIterator;
/*      */ import gnu.trove.list.TShortList;
/*      */ import gnu.trove.procedure.TShortProcedure;
/*      */ import java.io.Externalizable;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInput;
/*      */ import java.io.ObjectOutput;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Random;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TShortArrayList
/*      */   implements TShortList, Externalizable
/*      */ {
/*      */   static final long serialVersionUID = 1L;
/*      */   protected static final int DEFAULT_CAPACITY = 10;
/*      */   protected short[] _data;
/*      */   protected int _pos;
/*      */   protected short no_entry_value;
/*      */   
/*      */   public TShortArrayList() {
/*   68 */     this(10, (short)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortArrayList(int capacity) {
/*   80 */     this(capacity, (short)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortArrayList(int capacity, short no_entry_value) {
/*   92 */     this._data = new short[capacity];
/*   93 */     this._pos = 0;
/*   94 */     this.no_entry_value = no_entry_value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortArrayList(TShortCollection collection) {
/*  104 */     this(collection.size());
/*  105 */     addAll(collection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortArrayList(short[] values) {
/*  119 */     this(values.length);
/*  120 */     add(values);
/*      */   }
/*      */   
/*      */   protected TShortArrayList(short[] values, short no_entry_value, boolean wrap) {
/*  124 */     if (!wrap) {
/*  125 */       throw new IllegalStateException("Wrong call");
/*      */     }
/*  127 */     if (values == null) {
/*  128 */       throw new IllegalArgumentException("values can not be null");
/*      */     }
/*  130 */     this._data = values;
/*  131 */     this._pos = values.length;
/*  132 */     this.no_entry_value = no_entry_value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TShortArrayList wrap(short[] values) {
/*  147 */     return wrap(values, (short)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TShortArrayList wrap(short[] values, short no_entry_value) {
/*  163 */     return new TShortArrayList(values, no_entry_value, true)
/*      */       {
/*      */ 
/*      */         
/*      */         public void ensureCapacity(int capacity)
/*      */         {
/*  169 */           if (capacity > this._data.length) {
/*  170 */             throw new IllegalStateException("Can not grow ArrayList wrapped external array");
/*      */           }
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   public short getNoEntryValue() {
/*  177 */     return this.no_entry_value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ensureCapacity(int capacity) {
/*  189 */     if (capacity > this._data.length) {
/*  190 */       int newCap = Math.max(this._data.length << 1, capacity);
/*  191 */       short[] tmp = new short[newCap];
/*  192 */       System.arraycopy(this._data, 0, tmp, 0, this._data.length);
/*  193 */       this._data = tmp;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  200 */     return this._pos;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  206 */     return (this._pos == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void trimToSize() {
/*  214 */     if (this._data.length > size()) {
/*  215 */       short[] tmp = new short[size()];
/*  216 */       toArray(tmp, 0, tmp.length);
/*  217 */       this._data = tmp;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean add(short val) {
/*  226 */     ensureCapacity(this._pos + 1);
/*  227 */     this._data[this._pos++] = val;
/*  228 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(short[] vals) {
/*  234 */     add(vals, 0, vals.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(short[] vals, int offset, int length) {
/*  240 */     ensureCapacity(this._pos + length);
/*  241 */     System.arraycopy(vals, offset, this._data, this._pos, length);
/*  242 */     this._pos += length;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void insert(int offset, short value) {
/*  248 */     if (offset == this._pos) {
/*  249 */       add(value);
/*      */       return;
/*      */     } 
/*  252 */     ensureCapacity(this._pos + 1);
/*      */     
/*  254 */     System.arraycopy(this._data, offset, this._data, offset + 1, this._pos - offset);
/*      */     
/*  256 */     this._data[offset] = value;
/*  257 */     this._pos++;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void insert(int offset, short[] values) {
/*  263 */     insert(offset, values, 0, values.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void insert(int offset, short[] values, int valOffset, int len) {
/*  269 */     if (offset == this._pos) {
/*  270 */       add(values, valOffset, len);
/*      */       
/*      */       return;
/*      */     } 
/*  274 */     ensureCapacity(this._pos + len);
/*      */     
/*  276 */     System.arraycopy(this._data, offset, this._data, offset + len, this._pos - offset);
/*      */     
/*  278 */     System.arraycopy(values, valOffset, this._data, offset, len);
/*  279 */     this._pos += len;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short get(int offset) {
/*  285 */     if (offset >= this._pos) {
/*  286 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*  288 */     return this._data[offset];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getQuick(int offset) {
/*  296 */     return this._data[offset];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short set(int offset, short val) {
/*  302 */     if (offset >= this._pos) {
/*  303 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*      */     
/*  306 */     short prev_val = this._data[offset];
/*  307 */     this._data[offset] = val;
/*  308 */     return prev_val;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short replace(int offset, short val) {
/*  314 */     if (offset >= this._pos) {
/*  315 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*  317 */     short old = this._data[offset];
/*  318 */     this._data[offset] = val;
/*  319 */     return old;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(int offset, short[] values) {
/*  325 */     set(offset, values, 0, values.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(int offset, short[] values, int valOffset, int length) {
/*  331 */     if (offset < 0 || offset + length > this._pos) {
/*  332 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*  334 */     System.arraycopy(values, valOffset, this._data, offset, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setQuick(int offset, short val) {
/*  342 */     this._data[offset] = val;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  348 */     clearQuick();
/*  349 */     Arrays.fill(this._data, this.no_entry_value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clearQuick() {
/*  361 */     this._pos = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remove(short value) {
/*  367 */     for (int index = 0; index < this._pos; index++) {
/*  368 */       if (value == this._data[index]) {
/*  369 */         remove(index, 1);
/*  370 */         return true;
/*      */       } 
/*      */     } 
/*  373 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short removeAt(int offset) {
/*  379 */     short old = get(offset);
/*  380 */     remove(offset, 1);
/*  381 */     return old;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove(int offset, int length) {
/*  387 */     if (length == 0)
/*  388 */       return;  if (offset < 0 || offset >= this._pos) {
/*  389 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*      */     
/*  392 */     if (offset == 0) {
/*      */       
/*  394 */       System.arraycopy(this._data, length, this._data, 0, this._pos - length);
/*      */     }
/*  396 */     else if (this._pos - length != offset) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  402 */       System.arraycopy(this._data, offset + length, this._data, offset, this._pos - offset + length);
/*      */     } 
/*      */     
/*  405 */     this._pos -= length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortIterator iterator() {
/*  414 */     return new TShortArrayIterator(0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsAll(Collection<?> collection) {
/*  420 */     for (Object element : collection) {
/*  421 */       if (element instanceof Short) {
/*  422 */         short c = ((Short)element).shortValue();
/*  423 */         if (!contains(c))
/*  424 */           return false; 
/*      */         continue;
/*      */       } 
/*  427 */       return false;
/*      */     } 
/*      */ 
/*      */     
/*  431 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsAll(TShortCollection collection) {
/*  437 */     if (this == collection) {
/*  438 */       return true;
/*      */     }
/*  440 */     TShortIterator iter = collection.iterator();
/*  441 */     while (iter.hasNext()) {
/*  442 */       short element = iter.next();
/*  443 */       if (!contains(element)) {
/*  444 */         return false;
/*      */       }
/*      */     } 
/*  447 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsAll(short[] array) {
/*  453 */     for (int i = array.length; i-- > 0;) {
/*  454 */       if (!contains(array[i])) {
/*  455 */         return false;
/*      */       }
/*      */     } 
/*  458 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAll(Collection<? extends Short> collection) {
/*  464 */     boolean changed = false;
/*  465 */     for (Short element : collection) {
/*  466 */       short e = element.shortValue();
/*  467 */       if (add(e)) {
/*  468 */         changed = true;
/*      */       }
/*      */     } 
/*  471 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAll(TShortCollection collection) {
/*  477 */     boolean changed = false;
/*  478 */     TShortIterator iter = collection.iterator();
/*  479 */     while (iter.hasNext()) {
/*  480 */       short element = iter.next();
/*  481 */       if (add(element)) {
/*  482 */         changed = true;
/*      */       }
/*      */     } 
/*  485 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAll(short[] array) {
/*  491 */     boolean changed = false;
/*  492 */     for (short element : array) {
/*  493 */       if (add(element)) {
/*  494 */         changed = true;
/*      */       }
/*      */     } 
/*  497 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainAll(Collection<?> collection) {
/*  504 */     boolean modified = false;
/*  505 */     TShortIterator iter = iterator();
/*  506 */     while (iter.hasNext()) {
/*  507 */       if (!collection.contains(Short.valueOf(iter.next()))) {
/*  508 */         iter.remove();
/*  509 */         modified = true;
/*      */       } 
/*      */     } 
/*  512 */     return modified;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainAll(TShortCollection collection) {
/*  518 */     if (this == collection) {
/*  519 */       return false;
/*      */     }
/*  521 */     boolean modified = false;
/*  522 */     TShortIterator iter = iterator();
/*  523 */     while (iter.hasNext()) {
/*  524 */       if (!collection.contains(iter.next())) {
/*  525 */         iter.remove();
/*  526 */         modified = true;
/*      */       } 
/*      */     } 
/*  529 */     return modified;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainAll(short[] array) {
/*  535 */     boolean changed = false;
/*  536 */     Arrays.sort(array);
/*  537 */     short[] data = this._data;
/*      */     
/*  539 */     for (int i = this._pos; i-- > 0;) {
/*  540 */       if (Arrays.binarySearch(array, data[i]) < 0) {
/*  541 */         remove(i, 1);
/*  542 */         changed = true;
/*      */       } 
/*      */     } 
/*  545 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeAll(Collection<?> collection) {
/*  551 */     boolean changed = false;
/*  552 */     for (Object element : collection) {
/*  553 */       if (element instanceof Short) {
/*  554 */         short c = ((Short)element).shortValue();
/*  555 */         if (remove(c)) {
/*  556 */           changed = true;
/*      */         }
/*      */       } 
/*      */     } 
/*  560 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeAll(TShortCollection collection) {
/*  566 */     if (collection == this) {
/*  567 */       clear();
/*  568 */       return true;
/*      */     } 
/*  570 */     boolean changed = false;
/*  571 */     TShortIterator iter = collection.iterator();
/*  572 */     while (iter.hasNext()) {
/*  573 */       short element = iter.next();
/*  574 */       if (remove(element)) {
/*  575 */         changed = true;
/*      */       }
/*      */     } 
/*  578 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeAll(short[] array) {
/*  584 */     boolean changed = false;
/*  585 */     for (int i = array.length; i-- > 0;) {
/*  586 */       if (remove(array[i])) {
/*  587 */         changed = true;
/*      */       }
/*      */     } 
/*  590 */     return changed;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void transformValues(TShortFunction function) {
/*  596 */     for (int i = 0; i < this._pos; i++) {
/*  597 */       this._data[i] = function.execute(this._data[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reverse() {
/*  604 */     reverse(0, this._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reverse(int from, int to) {
/*  610 */     if (from == to) {
/*      */       return;
/*      */     }
/*  613 */     if (from > to) {
/*  614 */       throw new IllegalArgumentException("from cannot be greater than to");
/*      */     }
/*  616 */     for (int i = from, j = to - 1; i < j; i++, j--) {
/*  617 */       swap(i, j);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void shuffle(Random rand) {
/*  624 */     for (int i = this._pos; i-- > 1;) {
/*  625 */       swap(i, rand.nextInt(i));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void swap(int i, int j) {
/*  637 */     short tmp = this._data[i];
/*  638 */     this._data[i] = this._data[j];
/*  639 */     this._data[j] = tmp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortList subList(int begin, int end) {
/*  647 */     if (end < begin) {
/*  648 */       throw new IllegalArgumentException("end index " + end + " greater than begin index " + begin);
/*      */     }
/*      */     
/*  651 */     if (begin < 0) {
/*  652 */       throw new IndexOutOfBoundsException("begin index can not be < 0");
/*      */     }
/*  654 */     if (end > this._data.length) {
/*  655 */       throw new IndexOutOfBoundsException("end index < " + this._data.length);
/*      */     }
/*  657 */     TShortArrayList list = new TShortArrayList(end - begin);
/*  658 */     for (int i = begin; i < end; i++) {
/*  659 */       list.add(this._data[i]);
/*      */     }
/*  661 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] toArray() {
/*  667 */     return toArray(0, this._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] toArray(int offset, int len) {
/*  673 */     short[] rv = new short[len];
/*  674 */     toArray(rv, offset, len);
/*  675 */     return rv;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] toArray(short[] dest) {
/*  681 */     int len = dest.length;
/*  682 */     if (dest.length > this._pos) {
/*  683 */       len = this._pos;
/*  684 */       dest[len] = this.no_entry_value;
/*      */     } 
/*  686 */     toArray(dest, 0, len);
/*  687 */     return dest;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] toArray(short[] dest, int offset, int len) {
/*  693 */     if (len == 0) {
/*  694 */       return dest;
/*      */     }
/*  696 */     if (offset < 0 || offset >= this._pos) {
/*  697 */       throw new ArrayIndexOutOfBoundsException(offset);
/*      */     }
/*  699 */     System.arraycopy(this._data, offset, dest, 0, len);
/*  700 */     return dest;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] toArray(short[] dest, int source_pos, int dest_pos, int len) {
/*  706 */     if (len == 0) {
/*  707 */       return dest;
/*      */     }
/*  709 */     if (source_pos < 0 || source_pos >= this._pos) {
/*  710 */       throw new ArrayIndexOutOfBoundsException(source_pos);
/*      */     }
/*  712 */     System.arraycopy(this._data, source_pos, dest, dest_pos, len);
/*  713 */     return dest;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object other) {
/*  722 */     if (other == this) {
/*  723 */       return true;
/*      */     }
/*  725 */     if (!(other instanceof TShortList)) return false;
/*      */     
/*  727 */     if (other instanceof TShortArrayList) {
/*  728 */       TShortArrayList tShortArrayList = (TShortArrayList)other;
/*  729 */       if (tShortArrayList.size() != size()) return false;
/*      */       
/*  731 */       for (int j = this._pos; j-- > 0;) {
/*  732 */         if (this._data[j] != tShortArrayList._data[j]) {
/*  733 */           return false;
/*      */         }
/*      */       } 
/*  736 */       return true;
/*      */     } 
/*      */     
/*  739 */     TShortList that = (TShortList)other;
/*  740 */     if (that.size() != size()) return false;
/*      */     
/*  742 */     for (int i = 0; i < this._pos; i++) {
/*  743 */       if (this._data[i] != that.get(i)) {
/*  744 */         return false;
/*      */       }
/*      */     } 
/*  747 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  755 */     int h = 0;
/*  756 */     for (int i = this._pos; i-- > 0;) {
/*  757 */       h += HashFunctions.hash(this._data[i]);
/*      */     }
/*  759 */     return h;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEach(TShortProcedure procedure) {
/*  767 */     for (int i = 0; i < this._pos; i++) {
/*  768 */       if (!procedure.execute(this._data[i])) {
/*  769 */         return false;
/*      */       }
/*      */     } 
/*  772 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachDescending(TShortProcedure procedure) {
/*  778 */     for (int i = this._pos; i-- > 0;) {
/*  779 */       if (!procedure.execute(this._data[i])) {
/*  780 */         return false;
/*      */       }
/*      */     } 
/*  783 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sort() {
/*  791 */     Arrays.sort(this._data, 0, this._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void sort(int fromIndex, int toIndex) {
/*  797 */     Arrays.sort(this._data, fromIndex, toIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fill(short val) {
/*  805 */     Arrays.fill(this._data, 0, this._pos, val);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void fill(int fromIndex, int toIndex, short val) {
/*  811 */     if (toIndex > this._pos) {
/*  812 */       ensureCapacity(toIndex);
/*  813 */       this._pos = toIndex;
/*      */     } 
/*  815 */     Arrays.fill(this._data, fromIndex, toIndex, val);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int binarySearch(short value) {
/*  823 */     return binarySearch(value, 0, this._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int binarySearch(short value, int fromIndex, int toIndex) {
/*  829 */     if (fromIndex < 0) {
/*  830 */       throw new ArrayIndexOutOfBoundsException(fromIndex);
/*      */     }
/*  832 */     if (toIndex > this._pos) {
/*  833 */       throw new ArrayIndexOutOfBoundsException(toIndex);
/*      */     }
/*      */     
/*  836 */     int low = fromIndex;
/*  837 */     int high = toIndex - 1;
/*      */     
/*  839 */     while (low <= high) {
/*  840 */       int mid = low + high >>> 1;
/*  841 */       short midVal = this._data[mid];
/*      */       
/*  843 */       if (midVal < value) {
/*  844 */         low = mid + 1; continue;
/*      */       } 
/*  846 */       if (midVal > value) {
/*  847 */         high = mid - 1;
/*      */         continue;
/*      */       } 
/*  850 */       return mid;
/*      */     } 
/*      */     
/*  853 */     return -(low + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(short value) {
/*  859 */     return indexOf(0, value);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(int offset, short value) {
/*  865 */     for (int i = offset; i < this._pos; i++) {
/*  866 */       if (this._data[i] == value) {
/*  867 */         return i;
/*      */       }
/*      */     } 
/*  870 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(short value) {
/*  876 */     return lastIndexOf(this._pos, value);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(int offset, short value) {
/*  882 */     for (int i = offset; i-- > 0;) {
/*  883 */       if (this._data[i] == value) {
/*  884 */         return i;
/*      */       }
/*      */     } 
/*  887 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(short value) {
/*  893 */     return (lastIndexOf(value) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortList grep(TShortProcedure condition) {
/*  899 */     TShortArrayList list = new TShortArrayList();
/*  900 */     for (int i = 0; i < this._pos; i++) {
/*  901 */       if (condition.execute(this._data[i])) {
/*  902 */         list.add(this._data[i]);
/*      */       }
/*      */     } 
/*  905 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortList inverseGrep(TShortProcedure condition) {
/*  911 */     TShortArrayList list = new TShortArrayList();
/*  912 */     for (int i = 0; i < this._pos; i++) {
/*  913 */       if (!condition.execute(this._data[i])) {
/*  914 */         list.add(this._data[i]);
/*      */       }
/*      */     } 
/*  917 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short max() {
/*  923 */     if (size() == 0) {
/*  924 */       throw new IllegalStateException("cannot find maximum of an empty list");
/*      */     }
/*  926 */     short max = Short.MIN_VALUE;
/*  927 */     for (int i = 0; i < this._pos; i++) {
/*  928 */       if (this._data[i] > max) {
/*  929 */         max = this._data[i];
/*      */       }
/*      */     } 
/*  932 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short min() {
/*  938 */     if (size() == 0) {
/*  939 */       throw new IllegalStateException("cannot find minimum of an empty list");
/*      */     }
/*  941 */     short min = Short.MAX_VALUE;
/*  942 */     for (int i = 0; i < this._pos; i++) {
/*  943 */       if (this._data[i] < min) {
/*  944 */         min = this._data[i];
/*      */       }
/*      */     } 
/*  947 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short sum() {
/*  953 */     short sum = 0;
/*  954 */     for (int i = 0; i < this._pos; i++) {
/*  955 */       sum = (short)(sum + this._data[i]);
/*      */     }
/*  957 */     return sum;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  966 */     StringBuilder buf = new StringBuilder("{");
/*  967 */     for (int i = 0, end = this._pos - 1; i < end; i++) {
/*  968 */       buf.append(this._data[i]);
/*  969 */       buf.append(", ");
/*      */     } 
/*  971 */     if (size() > 0) {
/*  972 */       buf.append(this._data[this._pos - 1]);
/*      */     }
/*  974 */     buf.append("}");
/*  975 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class TShortArrayIterator
/*      */     implements TShortIterator
/*      */   {
/*  983 */     private int cursor = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  990 */     int lastRet = -1;
/*      */ 
/*      */     
/*      */     TShortArrayIterator(int index) {
/*  994 */       this.cursor = index;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 1000 */       return (this.cursor < TShortArrayList.this.size());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public short next() {
/*      */       try {
/* 1007 */         short next = TShortArrayList.this.get(this.cursor);
/* 1008 */         this.lastRet = this.cursor++;
/* 1009 */         return next;
/* 1010 */       } catch (IndexOutOfBoundsException e) {
/* 1011 */         throw new NoSuchElementException();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1018 */       if (this.lastRet == -1) {
/* 1019 */         throw new IllegalStateException();
/*      */       }
/*      */       try {
/* 1022 */         TShortArrayList.this.remove(this.lastRet, 1);
/* 1023 */         if (this.lastRet < this.cursor)
/* 1024 */           this.cursor--; 
/* 1025 */         this.lastRet = -1;
/* 1026 */       } catch (IndexOutOfBoundsException e) {
/* 1027 */         throw new ConcurrentModificationException();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeExternal(ObjectOutput out) throws IOException {
/* 1035 */     out.writeByte(0);
/*      */ 
/*      */     
/* 1038 */     out.writeInt(this._pos);
/*      */ 
/*      */     
/* 1041 */     out.writeShort(this.no_entry_value);
/*      */ 
/*      */     
/* 1044 */     int len = this._data.length;
/* 1045 */     out.writeInt(len);
/* 1046 */     for (int i = 0; i < len; i++) {
/* 1047 */       out.writeShort(this._data[i]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 1056 */     in.readByte();
/*      */ 
/*      */     
/* 1059 */     this._pos = in.readInt();
/*      */ 
/*      */     
/* 1062 */     this.no_entry_value = in.readShort();
/*      */ 
/*      */     
/* 1065 */     int len = in.readInt();
/* 1066 */     this._data = new short[len];
/* 1067 */     for (int i = 0; i < len; i++)
/* 1068 */       this._data[i] = in.readShort(); 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\list\array\TShortArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */