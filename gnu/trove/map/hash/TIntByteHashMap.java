/*      */ package gnu.trove.map.hash;
/*      */ 
/*      */ import gnu.trove.TByteCollection;
/*      */ import gnu.trove.TIntCollection;
/*      */ import gnu.trove.function.TByteFunction;
/*      */ import gnu.trove.impl.HashFunctions;
/*      */ import gnu.trove.impl.hash.THashPrimitiveIterator;
/*      */ import gnu.trove.impl.hash.TIntByteHash;
/*      */ import gnu.trove.impl.hash.TPrimitiveHash;
/*      */ import gnu.trove.iterator.TByteIterator;
/*      */ import gnu.trove.iterator.TIntByteIterator;
/*      */ import gnu.trove.iterator.TIntIterator;
/*      */ import gnu.trove.map.TIntByteMap;
/*      */ import gnu.trove.procedure.TByteProcedure;
/*      */ import gnu.trove.procedure.TIntByteProcedure;
/*      */ import gnu.trove.procedure.TIntProcedure;
/*      */ import gnu.trove.set.TIntSet;
/*      */ import java.io.Externalizable;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInput;
/*      */ import java.io.ObjectOutput;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Map;
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
/*      */ public class TIntByteHashMap
/*      */   extends TIntByteHash
/*      */   implements TIntByteMap, Externalizable
/*      */ {
/*      */   static final long serialVersionUID = 1L;
/*      */   protected transient byte[] _values;
/*      */   
/*      */   public TIntByteHashMap() {}
/*      */   
/*      */   public TIntByteHashMap(int initialCapacity) {
/*   73 */     super(initialCapacity);
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
/*      */   public TIntByteHashMap(int initialCapacity, float loadFactor) {
/*   86 */     super(initialCapacity, loadFactor);
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
/*      */ 
/*      */   
/*      */   public TIntByteHashMap(int initialCapacity, float loadFactor, int noEntryKey, byte noEntryValue) {
/*  104 */     super(initialCapacity, loadFactor, noEntryKey, noEntryValue);
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
/*      */   public TIntByteHashMap(int[] keys, byte[] values) {
/*  116 */     super(Math.max(keys.length, values.length));
/*      */     
/*  118 */     int size = Math.min(keys.length, values.length);
/*  119 */     for (int i = 0; i < size; i++) {
/*  120 */       put(keys[i], values[i]);
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
/*      */   public TIntByteHashMap(TIntByteMap map) {
/*  132 */     super(map.size());
/*  133 */     if (map instanceof TIntByteHashMap) {
/*  134 */       TIntByteHashMap hashmap = (TIntByteHashMap)map;
/*  135 */       this._loadFactor = Math.abs(hashmap._loadFactor);
/*  136 */       this.no_entry_key = hashmap.no_entry_key;
/*  137 */       this.no_entry_value = hashmap.no_entry_value;
/*      */       
/*  139 */       if (this.no_entry_key != 0) {
/*  140 */         Arrays.fill(this._set, this.no_entry_key);
/*      */       }
/*      */       
/*  143 */       if (this.no_entry_value != 0) {
/*  144 */         Arrays.fill(this._values, this.no_entry_value);
/*      */       }
/*  146 */       setUp(saturatedCast(fastCeil(10.0D / this._loadFactor)));
/*      */     } 
/*  148 */     putAll(map);
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
/*      */   protected int setUp(int initialCapacity) {
/*  162 */     int capacity = super.setUp(initialCapacity);
/*  163 */     this._values = new byte[capacity];
/*  164 */     return capacity;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void rehash(int newCapacity) {
/*  175 */     int oldCapacity = this._set.length;
/*      */     
/*  177 */     int[] oldKeys = this._set;
/*  178 */     byte[] oldVals = this._values;
/*  179 */     byte[] oldStates = this._states;
/*      */     
/*  181 */     this._set = new int[newCapacity];
/*  182 */     this._values = new byte[newCapacity];
/*  183 */     this._states = new byte[newCapacity];
/*      */     
/*  185 */     for (int i = oldCapacity; i-- > 0;) {
/*  186 */       if (oldStates[i] == 1) {
/*  187 */         int o = oldKeys[i];
/*  188 */         int index = insertKey(o);
/*  189 */         this._values[index] = oldVals[i];
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte put(int key, byte value) {
/*  197 */     int index = insertKey(key);
/*  198 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte putIfAbsent(int key, byte value) {
/*  204 */     int index = insertKey(key);
/*  205 */     if (index < 0)
/*  206 */       return this._values[-index - 1]; 
/*  207 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */   
/*      */   private byte doPut(int key, byte value, int index) {
/*  212 */     byte previous = this.no_entry_value;
/*  213 */     boolean isNewMapping = true;
/*  214 */     if (index < 0) {
/*  215 */       index = -index - 1;
/*  216 */       previous = this._values[index];
/*  217 */       isNewMapping = false;
/*      */     } 
/*  219 */     this._values[index] = value;
/*      */     
/*  221 */     if (isNewMapping) {
/*  222 */       postInsertHook(this.consumeFreeSlot);
/*      */     }
/*      */     
/*  225 */     return previous;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<? extends Integer, ? extends Byte> map) {
/*  231 */     ensureCapacity(map.size());
/*      */     
/*  233 */     for (Map.Entry<? extends Integer, ? extends Byte> entry : map.entrySet()) {
/*  234 */       put(((Integer)entry.getKey()).intValue(), ((Byte)entry.getValue()).byteValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(TIntByteMap map) {
/*  241 */     ensureCapacity(map.size());
/*  242 */     TIntByteIterator iter = map.iterator();
/*  243 */     while (iter.hasNext()) {
/*  244 */       iter.advance();
/*  245 */       put(iter.key(), iter.value());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte get(int key) {
/*  252 */     int index = index(key);
/*  253 */     return (index < 0) ? this.no_entry_value : this._values[index];
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  259 */     super.clear();
/*  260 */     Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
/*  261 */     Arrays.fill(this._values, 0, this._values.length, this.no_entry_value);
/*  262 */     Arrays.fill(this._states, 0, this._states.length, (byte)0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  268 */     return (0 == this._size);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte remove(int key) {
/*  274 */     byte prev = this.no_entry_value;
/*  275 */     int index = index(key);
/*  276 */     if (index >= 0) {
/*  277 */       prev = this._values[index];
/*  278 */       removeAt(index);
/*      */     } 
/*  280 */     return prev;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeAt(int index) {
/*  286 */     this._values[index] = this.no_entry_value;
/*  287 */     super.removeAt(index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TIntSet keySet() {
/*  293 */     return new TKeyView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] keys() {
/*  299 */     int[] keys = new int[size()];
/*  300 */     if (keys.length == 0) {
/*  301 */       return keys;
/*      */     }
/*  303 */     int[] k = this._set;
/*  304 */     byte[] states = this._states;
/*      */     
/*  306 */     for (int i = k.length, j = 0; i-- > 0;) {
/*  307 */       if (states[i] == 1) {
/*  308 */         keys[j++] = k[i];
/*      */       }
/*      */     } 
/*  311 */     return keys;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] keys(int[] array) {
/*  317 */     int size = size();
/*  318 */     if (size == 0) {
/*  319 */       return array;
/*      */     }
/*  321 */     if (array.length < size) {
/*  322 */       array = new int[size];
/*      */     }
/*      */     
/*  325 */     int[] keys = this._set;
/*  326 */     byte[] states = this._states;
/*      */     
/*  328 */     for (int i = keys.length, j = 0; i-- > 0;) {
/*  329 */       if (states[i] == 1) {
/*  330 */         array[j++] = keys[i];
/*      */       }
/*      */     } 
/*  333 */     return array;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TByteCollection valueCollection() {
/*  339 */     return new TValueView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] values() {
/*  345 */     byte[] vals = new byte[size()];
/*  346 */     if (vals.length == 0) {
/*  347 */       return vals;
/*      */     }
/*  349 */     byte[] v = this._values;
/*  350 */     byte[] states = this._states;
/*      */     
/*  352 */     for (int i = v.length, j = 0; i-- > 0;) {
/*  353 */       if (states[i] == 1) {
/*  354 */         vals[j++] = v[i];
/*      */       }
/*      */     } 
/*  357 */     return vals;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] values(byte[] array) {
/*  363 */     int size = size();
/*  364 */     if (size == 0) {
/*  365 */       return array;
/*      */     }
/*  367 */     if (array.length < size) {
/*  368 */       array = new byte[size];
/*      */     }
/*      */     
/*  371 */     byte[] v = this._values;
/*  372 */     byte[] states = this._states;
/*      */     
/*  374 */     for (int i = v.length, j = 0; i-- > 0;) {
/*  375 */       if (states[i] == 1) {
/*  376 */         array[j++] = v[i];
/*      */       }
/*      */     } 
/*  379 */     return array;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsValue(byte val) {
/*  385 */     byte[] states = this._states;
/*  386 */     byte[] vals = this._values;
/*      */     
/*  388 */     for (int i = vals.length; i-- > 0;) {
/*  389 */       if (states[i] == 1 && val == vals[i]) {
/*  390 */         return true;
/*      */       }
/*      */     } 
/*  393 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(int key) {
/*  399 */     return contains(key);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TIntByteIterator iterator() {
/*  405 */     return new TIntByteHashIterator(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachKey(TIntProcedure procedure) {
/*  411 */     return forEach(procedure);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachValue(TByteProcedure procedure) {
/*  417 */     byte[] states = this._states;
/*  418 */     byte[] values = this._values;
/*  419 */     for (int i = values.length; i-- > 0;) {
/*  420 */       if (states[i] == 1 && !procedure.execute(values[i])) {
/*  421 */         return false;
/*      */       }
/*      */     } 
/*  424 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachEntry(TIntByteProcedure procedure) {
/*  430 */     byte[] states = this._states;
/*  431 */     int[] keys = this._set;
/*  432 */     byte[] values = this._values;
/*  433 */     for (int i = keys.length; i-- > 0;) {
/*  434 */       if (states[i] == 1 && !procedure.execute(keys[i], values[i])) {
/*  435 */         return false;
/*      */       }
/*      */     } 
/*  438 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void transformValues(TByteFunction function) {
/*  444 */     byte[] states = this._states;
/*  445 */     byte[] values = this._values;
/*  446 */     for (int i = values.length; i-- > 0;) {
/*  447 */       if (states[i] == 1) {
/*  448 */         values[i] = function.execute(values[i]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainEntries(TIntByteProcedure procedure) {
/*  456 */     boolean modified = false;
/*  457 */     byte[] states = this._states;
/*  458 */     int[] keys = this._set;
/*  459 */     byte[] values = this._values;
/*      */ 
/*      */ 
/*      */     
/*  463 */     tempDisableAutoCompaction();
/*      */     try {
/*  465 */       for (int i = keys.length; i-- > 0;) {
/*  466 */         if (states[i] == 1 && !procedure.execute(keys[i], values[i])) {
/*  467 */           removeAt(i);
/*  468 */           modified = true;
/*      */         } 
/*      */       } 
/*      */     } finally {
/*      */       
/*  473 */       reenableAutoCompaction(true);
/*      */     } 
/*      */     
/*  476 */     return modified;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean increment(int key) {
/*  482 */     return adjustValue(key, (byte)1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean adjustValue(int key, byte amount) {
/*  488 */     int index = index(key);
/*  489 */     if (index < 0) {
/*  490 */       return false;
/*      */     }
/*  492 */     this._values[index] = (byte)(this._values[index] + amount);
/*  493 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public byte adjustOrPutValue(int key, byte adjust_amount, byte put_amount) {
/*      */     boolean isNewMapping;
/*      */     byte newValue;
/*  500 */     int index = insertKey(key);
/*      */ 
/*      */     
/*  503 */     if (index < 0) {
/*  504 */       index = -index - 1;
/*  505 */       newValue = this._values[index] = (byte)(this._values[index] + adjust_amount);
/*  506 */       isNewMapping = false;
/*      */     } else {
/*  508 */       newValue = this._values[index] = put_amount;
/*  509 */       isNewMapping = true;
/*      */     } 
/*      */     
/*  512 */     byte previousState = this._states[index];
/*      */     
/*  514 */     if (isNewMapping) {
/*  515 */       postInsertHook(this.consumeFreeSlot);
/*      */     }
/*      */     
/*  518 */     return newValue;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected class TKeyView
/*      */     implements TIntSet
/*      */   {
/*      */     public TIntIterator iterator() {
/*  527 */       return new TIntByteHashMap.TIntByteKeyHashIterator((TPrimitiveHash)TIntByteHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getNoEntryValue() {
/*  533 */       return TIntByteHashMap.this.no_entry_key;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  539 */       return TIntByteHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  545 */       return (0 == TIntByteHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(int entry) {
/*  551 */       return TIntByteHashMap.this.contains(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int[] toArray() {
/*  557 */       return TIntByteHashMap.this.keys();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int[] toArray(int[] dest) {
/*  563 */       return TIntByteHashMap.this.keys(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(int entry) {
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(int entry) {
/*  579 */       return (TIntByteHashMap.this.no_entry_value != TIntByteHashMap.this.remove(entry));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  585 */       for (Object element : collection) {
/*  586 */         if (element instanceof Integer) {
/*  587 */           int ele = ((Integer)element).intValue();
/*  588 */           if (!TIntByteHashMap.this.containsKey(ele))
/*  589 */             return false; 
/*      */           continue;
/*      */         } 
/*  592 */         return false;
/*      */       } 
/*      */       
/*  595 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(TIntCollection collection) {
/*  601 */       TIntIterator iter = collection.iterator();
/*  602 */       while (iter.hasNext()) {
/*  603 */         if (!TIntByteHashMap.this.containsKey(iter.next())) {
/*  604 */           return false;
/*      */         }
/*      */       } 
/*  607 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(int[] array) {
/*  613 */       for (int element : array) {
/*  614 */         if (!TIntByteHashMap.this.contains(element)) {
/*  615 */           return false;
/*      */         }
/*      */       } 
/*  618 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends Integer> collection) {
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TIntCollection collection) {
/*  638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(int[] array) {
/*  648 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  655 */       boolean modified = false;
/*  656 */       TIntIterator iter = iterator();
/*  657 */       while (iter.hasNext()) {
/*  658 */         if (!collection.contains(Integer.valueOf(iter.next()))) {
/*  659 */           iter.remove();
/*  660 */           modified = true;
/*      */         } 
/*      */       } 
/*  663 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TIntCollection collection) {
/*  669 */       if (this == collection) {
/*  670 */         return false;
/*      */       }
/*  672 */       boolean modified = false;
/*  673 */       TIntIterator iter = iterator();
/*  674 */       while (iter.hasNext()) {
/*  675 */         if (!collection.contains(iter.next())) {
/*  676 */           iter.remove();
/*  677 */           modified = true;
/*      */         } 
/*      */       } 
/*  680 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(int[] array) {
/*  686 */       boolean changed = false;
/*  687 */       Arrays.sort(array);
/*  688 */       int[] set = TIntByteHashMap.this._set;
/*  689 */       byte[] states = TIntByteHashMap.this._states;
/*      */       
/*  691 */       for (int i = set.length; i-- > 0;) {
/*  692 */         if (states[i] == 1 && Arrays.binarySearch(array, set[i]) < 0) {
/*  693 */           TIntByteHashMap.this.removeAt(i);
/*  694 */           changed = true;
/*      */         } 
/*      */       } 
/*  697 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(Collection<?> collection) {
/*  703 */       boolean changed = false;
/*  704 */       for (Object element : collection) {
/*  705 */         if (element instanceof Integer) {
/*  706 */           int c = ((Integer)element).intValue();
/*  707 */           if (remove(c)) {
/*  708 */             changed = true;
/*      */           }
/*      */         } 
/*      */       } 
/*  712 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(TIntCollection collection) {
/*  718 */       if (this == collection) {
/*  719 */         clear();
/*  720 */         return true;
/*      */       } 
/*  722 */       boolean changed = false;
/*  723 */       TIntIterator iter = collection.iterator();
/*  724 */       while (iter.hasNext()) {
/*  725 */         int element = iter.next();
/*  726 */         if (remove(element)) {
/*  727 */           changed = true;
/*      */         }
/*      */       } 
/*  730 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(int[] array) {
/*  736 */       boolean changed = false;
/*  737 */       for (int i = array.length; i-- > 0;) {
/*  738 */         if (remove(array[i])) {
/*  739 */           changed = true;
/*      */         }
/*      */       } 
/*  742 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/*  748 */       TIntByteHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TIntProcedure procedure) {
/*  754 */       return TIntByteHashMap.this.forEachKey(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object other) {
/*  760 */       if (!(other instanceof TIntSet)) {
/*  761 */         return false;
/*      */       }
/*  763 */       TIntSet that = (TIntSet)other;
/*  764 */       if (that.size() != size()) {
/*  765 */         return false;
/*      */       }
/*  767 */       for (int i = TIntByteHashMap.this._states.length; i-- > 0;) {
/*  768 */         if (TIntByteHashMap.this._states[i] == 1 && 
/*  769 */           !that.contains(TIntByteHashMap.this._set[i])) {
/*  770 */           return false;
/*      */         }
/*      */       } 
/*      */       
/*  774 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  780 */       int hashcode = 0;
/*  781 */       for (int i = TIntByteHashMap.this._states.length; i-- > 0;) {
/*  782 */         if (TIntByteHashMap.this._states[i] == 1) {
/*  783 */           hashcode += HashFunctions.hash(TIntByteHashMap.this._set[i]);
/*      */         }
/*      */       } 
/*  786 */       return hashcode;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  792 */       final StringBuilder buf = new StringBuilder("{");
/*  793 */       TIntByteHashMap.this.forEachKey(new TIntProcedure()
/*      */           {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(int key) {
/*  798 */               if (this.first) {
/*  799 */                 this.first = false;
/*      */               } else {
/*  801 */                 buf.append(", ");
/*      */               } 
/*      */               
/*  804 */               buf.append(key);
/*  805 */               return true;
/*      */             }
/*      */           });
/*  808 */       buf.append("}");
/*  809 */       return buf.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected class TValueView
/*      */     implements TByteCollection
/*      */   {
/*      */     public TByteIterator iterator() {
/*  819 */       return new TIntByteHashMap.TIntByteValueHashIterator((TPrimitiveHash)TIntByteHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte getNoEntryValue() {
/*  825 */       return TIntByteHashMap.this.no_entry_value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  831 */       return TIntByteHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  837 */       return (0 == TIntByteHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(byte entry) {
/*  843 */       return TIntByteHashMap.this.containsValue(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] toArray() {
/*  849 */       return TIntByteHashMap.this.values();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] toArray(byte[] dest) {
/*  855 */       return TIntByteHashMap.this.values(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(byte entry) {
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(byte entry) {
/*  867 */       byte[] values = TIntByteHashMap.this._values;
/*  868 */       byte[] states = TIntByteHashMap.this._states;
/*      */       
/*  870 */       for (int i = values.length; i-- > 0;) {
/*  871 */         if (states[i] != 0 && states[i] != 2 && entry == values[i]) {
/*  872 */           TIntByteHashMap.this.removeAt(i);
/*  873 */           return true;
/*      */         } 
/*      */       } 
/*  876 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  881 */       for (Object element : collection) {
/*  882 */         if (element instanceof Byte) {
/*  883 */           byte ele = ((Byte)element).byteValue();
/*  884 */           if (!TIntByteHashMap.this.containsValue(ele))
/*  885 */             return false; 
/*      */           continue;
/*      */         } 
/*  888 */         return false;
/*      */       } 
/*      */       
/*  891 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(TByteCollection collection) {
/*  897 */       TByteIterator iter = collection.iterator();
/*  898 */       while (iter.hasNext()) {
/*  899 */         if (!TIntByteHashMap.this.containsValue(iter.next())) {
/*  900 */           return false;
/*      */         }
/*      */       } 
/*  903 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(byte[] array) {
/*  909 */       for (byte element : array) {
/*  910 */         if (!TIntByteHashMap.this.containsValue(element)) {
/*  911 */           return false;
/*      */         }
/*      */       } 
/*  914 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends Byte> collection) {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TByteCollection collection) {
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(byte[] array) {
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  939 */       boolean modified = false;
/*  940 */       TByteIterator iter = iterator();
/*  941 */       while (iter.hasNext()) {
/*  942 */         if (!collection.contains(Byte.valueOf(iter.next()))) {
/*  943 */           iter.remove();
/*  944 */           modified = true;
/*      */         } 
/*      */       } 
/*  947 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TByteCollection collection) {
/*  953 */       if (this == collection) {
/*  954 */         return false;
/*      */       }
/*  956 */       boolean modified = false;
/*  957 */       TByteIterator iter = iterator();
/*  958 */       while (iter.hasNext()) {
/*  959 */         if (!collection.contains(iter.next())) {
/*  960 */           iter.remove();
/*  961 */           modified = true;
/*      */         } 
/*      */       } 
/*  964 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(byte[] array) {
/*  970 */       boolean changed = false;
/*  971 */       Arrays.sort(array);
/*  972 */       byte[] values = TIntByteHashMap.this._values;
/*  973 */       byte[] states = TIntByteHashMap.this._states;
/*      */       
/*  975 */       for (int i = values.length; i-- > 0;) {
/*  976 */         if (states[i] == 1 && Arrays.binarySearch(array, values[i]) < 0) {
/*  977 */           TIntByteHashMap.this.removeAt(i);
/*  978 */           changed = true;
/*      */         } 
/*      */       } 
/*  981 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(Collection<?> collection) {
/*  987 */       boolean changed = false;
/*  988 */       for (Object element : collection) {
/*  989 */         if (element instanceof Byte) {
/*  990 */           byte c = ((Byte)element).byteValue();
/*  991 */           if (remove(c)) {
/*  992 */             changed = true;
/*      */           }
/*      */         } 
/*      */       } 
/*  996 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(TByteCollection collection) {
/* 1002 */       if (this == collection) {
/* 1003 */         clear();
/* 1004 */         return true;
/*      */       } 
/* 1006 */       boolean changed = false;
/* 1007 */       TByteIterator iter = collection.iterator();
/* 1008 */       while (iter.hasNext()) {
/* 1009 */         byte element = iter.next();
/* 1010 */         if (remove(element)) {
/* 1011 */           changed = true;
/*      */         }
/*      */       } 
/* 1014 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(byte[] array) {
/* 1020 */       boolean changed = false;
/* 1021 */       for (int i = array.length; i-- > 0;) {
/* 1022 */         if (remove(array[i])) {
/* 1023 */           changed = true;
/*      */         }
/*      */       } 
/* 1026 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1032 */       TIntByteHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TByteProcedure procedure) {
/* 1038 */       return TIntByteHashMap.this.forEachValue(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1045 */       final StringBuilder buf = new StringBuilder("{");
/* 1046 */       TIntByteHashMap.this.forEachValue(new TByteProcedure() {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(byte value) {
/* 1050 */               if (this.first) {
/* 1051 */                 this.first = false;
/*      */               } else {
/* 1053 */                 buf.append(", ");
/*      */               } 
/*      */               
/* 1056 */               buf.append(value);
/* 1057 */               return true;
/*      */             }
/*      */           });
/* 1060 */       buf.append("}");
/* 1061 */       return buf.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class TIntByteKeyHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TIntIterator
/*      */   {
/*      */     TIntByteKeyHashIterator(TPrimitiveHash hash) {
/* 1074 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public int next() {
/* 1079 */       moveToNextIndex();
/* 1080 */       return TIntByteHashMap.this._set[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1085 */       if (this._expectedSize != this._hash.size()) {
/* 1086 */         throw new ConcurrentModificationException();
/*      */       }
/*      */ 
/*      */       
/*      */       try {
/* 1091 */         this._hash.tempDisableAutoCompaction();
/* 1092 */         TIntByteHashMap.this.removeAt(this._index);
/*      */       } finally {
/*      */         
/* 1095 */         this._hash.reenableAutoCompaction(false);
/*      */       } 
/*      */       
/* 1098 */       this._expectedSize--;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class TIntByteValueHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TByteIterator
/*      */   {
/*      */     TIntByteValueHashIterator(TPrimitiveHash hash) {
/* 1112 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public byte next() {
/* 1117 */       moveToNextIndex();
/* 1118 */       return TIntByteHashMap.this._values[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1123 */       if (this._expectedSize != this._hash.size()) {
/* 1124 */         throw new ConcurrentModificationException();
/*      */       }
/*      */ 
/*      */       
/*      */       try {
/* 1129 */         this._hash.tempDisableAutoCompaction();
/* 1130 */         TIntByteHashMap.this.removeAt(this._index);
/*      */       } finally {
/*      */         
/* 1133 */         this._hash.reenableAutoCompaction(false);
/*      */       } 
/*      */       
/* 1136 */       this._expectedSize--;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class TIntByteHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TIntByteIterator
/*      */   {
/*      */     TIntByteHashIterator(TIntByteHashMap map) {
/* 1149 */       super((TPrimitiveHash)map);
/*      */     }
/*      */ 
/*      */     
/*      */     public void advance() {
/* 1154 */       moveToNextIndex();
/*      */     }
/*      */ 
/*      */     
/*      */     public int key() {
/* 1159 */       return TIntByteHashMap.this._set[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public byte value() {
/* 1164 */       return TIntByteHashMap.this._values[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public byte setValue(byte val) {
/* 1169 */       byte old = value();
/* 1170 */       TIntByteHashMap.this._values[this._index] = val;
/* 1171 */       return old;
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1176 */       if (this._expectedSize != this._hash.size()) {
/* 1177 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/*      */       try {
/* 1181 */         this._hash.tempDisableAutoCompaction();
/* 1182 */         TIntByteHashMap.this.removeAt(this._index);
/*      */       } finally {
/*      */         
/* 1185 */         this._hash.reenableAutoCompaction(false);
/*      */       } 
/* 1187 */       this._expectedSize--;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object other) {
/* 1195 */     if (!(other instanceof TIntByteMap)) {
/* 1196 */       return false;
/*      */     }
/* 1198 */     TIntByteMap that = (TIntByteMap)other;
/* 1199 */     if (that.size() != size()) {
/* 1200 */       return false;
/*      */     }
/* 1202 */     byte[] values = this._values;
/* 1203 */     byte[] states = this._states;
/* 1204 */     byte this_no_entry_value = getNoEntryValue();
/* 1205 */     byte that_no_entry_value = that.getNoEntryValue();
/* 1206 */     for (int i = values.length; i-- > 0;) {
/* 1207 */       if (states[i] == 1) {
/* 1208 */         int key = this._set[i];
/*      */         
/* 1210 */         if (!that.containsKey(key)) return false;
/*      */         
/* 1212 */         byte that_value = that.get(key);
/* 1213 */         byte this_value = values[i];
/* 1214 */         if (this_value != that_value && (this_value != this_no_entry_value || that_value != that_no_entry_value))
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1219 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/* 1223 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1230 */     int hashcode = 0;
/* 1231 */     byte[] states = this._states;
/* 1232 */     for (int i = this._values.length; i-- > 0;) {
/* 1233 */       if (states[i] == 1) {
/* 1234 */         hashcode += HashFunctions.hash(this._set[i]) ^ 
/* 1235 */           HashFunctions.hash(this._values[i]);
/*      */       }
/*      */     } 
/* 1238 */     return hashcode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1245 */     final StringBuilder buf = new StringBuilder("{");
/* 1246 */     forEachEntry(new TIntByteProcedure()
/*      */         {
/*      */           public boolean execute(int key, byte value) {
/* 1249 */             if (this.first) { this.first = false; }
/* 1250 */             else { buf.append(", "); }
/*      */             
/* 1252 */             buf.append(key);
/* 1253 */             buf.append("=");
/* 1254 */             buf.append(value);
/* 1255 */             return true;
/*      */           } private boolean first = true;
/*      */         });
/* 1258 */     buf.append("}");
/* 1259 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeExternal(ObjectOutput out) throws IOException {
/* 1266 */     out.writeByte(0);
/*      */ 
/*      */     
/* 1269 */     super.writeExternal(out);
/*      */ 
/*      */     
/* 1272 */     out.writeInt(this._size);
/*      */ 
/*      */     
/* 1275 */     for (int i = this._states.length; i-- > 0;) {
/* 1276 */       if (this._states[i] == 1) {
/* 1277 */         out.writeInt(this._set[i]);
/* 1278 */         out.writeByte(this._values[i]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 1287 */     in.readByte();
/*      */ 
/*      */     
/* 1290 */     super.readExternal(in);
/*      */ 
/*      */     
/* 1293 */     int size = in.readInt();
/* 1294 */     setUp(size);
/*      */ 
/*      */     
/* 1297 */     while (size-- > 0) {
/* 1298 */       int key = in.readInt();
/* 1299 */       byte val = in.readByte();
/* 1300 */       put(key, val);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\hash\TIntByteHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */