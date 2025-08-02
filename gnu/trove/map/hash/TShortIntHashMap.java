/*      */ package gnu.trove.map.hash;
/*      */ 
/*      */ import gnu.trove.TIntCollection;
/*      */ import gnu.trove.TShortCollection;
/*      */ import gnu.trove.function.TIntFunction;
/*      */ import gnu.trove.impl.HashFunctions;
/*      */ import gnu.trove.impl.hash.THashPrimitiveIterator;
/*      */ import gnu.trove.impl.hash.TPrimitiveHash;
/*      */ import gnu.trove.impl.hash.TShortIntHash;
/*      */ import gnu.trove.iterator.TIntIterator;
/*      */ import gnu.trove.iterator.TShortIntIterator;
/*      */ import gnu.trove.iterator.TShortIterator;
/*      */ import gnu.trove.map.TShortIntMap;
/*      */ import gnu.trove.procedure.TIntProcedure;
/*      */ import gnu.trove.procedure.TShortIntProcedure;
/*      */ import gnu.trove.procedure.TShortProcedure;
/*      */ import gnu.trove.set.TShortSet;
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
/*      */ public class TShortIntHashMap
/*      */   extends TShortIntHash
/*      */   implements TShortIntMap, Externalizable
/*      */ {
/*      */   static final long serialVersionUID = 1L;
/*      */   protected transient int[] _values;
/*      */   
/*      */   public TShortIntHashMap() {}
/*      */   
/*      */   public TShortIntHashMap(int initialCapacity) {
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
/*      */   public TShortIntHashMap(int initialCapacity, float loadFactor) {
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
/*      */   public TShortIntHashMap(int initialCapacity, float loadFactor, short noEntryKey, int noEntryValue) {
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
/*      */   public TShortIntHashMap(short[] keys, int[] values) {
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
/*      */   public TShortIntHashMap(TShortIntMap map) {
/*  132 */     super(map.size());
/*  133 */     if (map instanceof TShortIntHashMap) {
/*  134 */       TShortIntHashMap hashmap = (TShortIntHashMap)map;
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
/*  163 */     this._values = new int[capacity];
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
/*  177 */     short[] oldKeys = this._set;
/*  178 */     int[] oldVals = this._values;
/*  179 */     byte[] oldStates = this._states;
/*      */     
/*  181 */     this._set = new short[newCapacity];
/*  182 */     this._values = new int[newCapacity];
/*  183 */     this._states = new byte[newCapacity];
/*      */     
/*  185 */     for (int i = oldCapacity; i-- > 0;) {
/*  186 */       if (oldStates[i] == 1) {
/*  187 */         short o = oldKeys[i];
/*  188 */         int index = insertKey(o);
/*  189 */         this._values[index] = oldVals[i];
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int put(short key, int value) {
/*  197 */     int index = insertKey(key);
/*  198 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int putIfAbsent(short key, int value) {
/*  204 */     int index = insertKey(key);
/*  205 */     if (index < 0)
/*  206 */       return this._values[-index - 1]; 
/*  207 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */   
/*      */   private int doPut(short key, int value, int index) {
/*  212 */     int previous = this.no_entry_value;
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
/*      */   public void putAll(Map<? extends Short, ? extends Integer> map) {
/*  231 */     ensureCapacity(map.size());
/*      */     
/*  233 */     for (Map.Entry<? extends Short, ? extends Integer> entry : map.entrySet()) {
/*  234 */       put(((Short)entry.getKey()).shortValue(), ((Integer)entry.getValue()).intValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(TShortIntMap map) {
/*  241 */     ensureCapacity(map.size());
/*  242 */     TShortIntIterator iter = map.iterator();
/*  243 */     while (iter.hasNext()) {
/*  244 */       iter.advance();
/*  245 */       put(iter.key(), iter.value());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int get(short key) {
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
/*      */   public int remove(short key) {
/*  274 */     int prev = this.no_entry_value;
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
/*      */   public TShortSet keySet() {
/*  293 */     return new TKeyView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] keys() {
/*  299 */     short[] keys = new short[size()];
/*  300 */     if (keys.length == 0) {
/*  301 */       return keys;
/*      */     }
/*  303 */     short[] k = this._set;
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
/*      */   public short[] keys(short[] array) {
/*  317 */     int size = size();
/*  318 */     if (size == 0) {
/*  319 */       return array;
/*      */     }
/*  321 */     if (array.length < size) {
/*  322 */       array = new short[size];
/*      */     }
/*      */     
/*  325 */     short[] keys = this._set;
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
/*      */   public TIntCollection valueCollection() {
/*  339 */     return new TValueView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] values() {
/*  345 */     int[] vals = new int[size()];
/*  346 */     if (vals.length == 0) {
/*  347 */       return vals;
/*      */     }
/*  349 */     int[] v = this._values;
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
/*      */   public int[] values(int[] array) {
/*  363 */     int size = size();
/*  364 */     if (size == 0) {
/*  365 */       return array;
/*      */     }
/*  367 */     if (array.length < size) {
/*  368 */       array = new int[size];
/*      */     }
/*      */     
/*  371 */     int[] v = this._values;
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
/*      */   public boolean containsValue(int val) {
/*  385 */     byte[] states = this._states;
/*  386 */     int[] vals = this._values;
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
/*      */   public boolean containsKey(short key) {
/*  399 */     return contains(key);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TShortIntIterator iterator() {
/*  405 */     return new TShortIntHashIterator(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachKey(TShortProcedure procedure) {
/*  411 */     return forEach(procedure);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachValue(TIntProcedure procedure) {
/*  417 */     byte[] states = this._states;
/*  418 */     int[] values = this._values;
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
/*      */   public boolean forEachEntry(TShortIntProcedure procedure) {
/*  430 */     byte[] states = this._states;
/*  431 */     short[] keys = this._set;
/*  432 */     int[] values = this._values;
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
/*      */   public void transformValues(TIntFunction function) {
/*  444 */     byte[] states = this._states;
/*  445 */     int[] values = this._values;
/*  446 */     for (int i = values.length; i-- > 0;) {
/*  447 */       if (states[i] == 1) {
/*  448 */         values[i] = function.execute(values[i]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainEntries(TShortIntProcedure procedure) {
/*  456 */     boolean modified = false;
/*  457 */     byte[] states = this._states;
/*  458 */     short[] keys = this._set;
/*  459 */     int[] values = this._values;
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
/*      */   public boolean increment(short key) {
/*  482 */     return adjustValue(key, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean adjustValue(short key, int amount) {
/*  488 */     int index = index(key);
/*  489 */     if (index < 0) {
/*  490 */       return false;
/*      */     }
/*  492 */     this._values[index] = this._values[index] + amount;
/*  493 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int adjustOrPutValue(short key, int adjust_amount, int put_amount) {
/*      */     boolean isNewMapping;
/*  500 */     int newValue, index = insertKey(key);
/*      */ 
/*      */     
/*  503 */     if (index < 0) {
/*  504 */       index = -index - 1;
/*  505 */       newValue = this._values[index] = this._values[index] + adjust_amount;
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
/*      */     implements TShortSet
/*      */   {
/*      */     public TShortIterator iterator() {
/*  527 */       return new TShortIntHashMap.TShortIntKeyHashIterator((TPrimitiveHash)TShortIntHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public short getNoEntryValue() {
/*  533 */       return TShortIntHashMap.this.no_entry_key;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  539 */       return TShortIntHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  545 */       return (0 == TShortIntHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(short entry) {
/*  551 */       return TShortIntHashMap.this.contains(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public short[] toArray() {
/*  557 */       return TShortIntHashMap.this.keys();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public short[] toArray(short[] dest) {
/*  563 */       return TShortIntHashMap.this.keys(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(short entry) {
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(short entry) {
/*  579 */       return (TShortIntHashMap.this.no_entry_value != TShortIntHashMap.this.remove(entry));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  585 */       for (Object element : collection) {
/*  586 */         if (element instanceof Short) {
/*  587 */           short ele = ((Short)element).shortValue();
/*  588 */           if (!TShortIntHashMap.this.containsKey(ele))
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
/*      */     public boolean containsAll(TShortCollection collection) {
/*  601 */       TShortIterator iter = collection.iterator();
/*  602 */       while (iter.hasNext()) {
/*  603 */         if (!TShortIntHashMap.this.containsKey(iter.next())) {
/*  604 */           return false;
/*      */         }
/*      */       } 
/*  607 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(short[] array) {
/*  613 */       for (short element : array) {
/*  614 */         if (!TShortIntHashMap.this.contains(element)) {
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
/*      */     public boolean addAll(Collection<? extends Short> collection) {
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TShortCollection collection) {
/*  638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(short[] array) {
/*  648 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  655 */       boolean modified = false;
/*  656 */       TShortIterator iter = iterator();
/*  657 */       while (iter.hasNext()) {
/*  658 */         if (!collection.contains(Short.valueOf(iter.next()))) {
/*  659 */           iter.remove();
/*  660 */           modified = true;
/*      */         } 
/*      */       } 
/*  663 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TShortCollection collection) {
/*  669 */       if (this == collection) {
/*  670 */         return false;
/*      */       }
/*  672 */       boolean modified = false;
/*  673 */       TShortIterator iter = iterator();
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
/*      */     public boolean retainAll(short[] array) {
/*  686 */       boolean changed = false;
/*  687 */       Arrays.sort(array);
/*  688 */       short[] set = TShortIntHashMap.this._set;
/*  689 */       byte[] states = TShortIntHashMap.this._states;
/*      */       
/*  691 */       for (int i = set.length; i-- > 0;) {
/*  692 */         if (states[i] == 1 && Arrays.binarySearch(array, set[i]) < 0) {
/*  693 */           TShortIntHashMap.this.removeAt(i);
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
/*  705 */         if (element instanceof Short) {
/*  706 */           short c = ((Short)element).shortValue();
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
/*      */     public boolean removeAll(TShortCollection collection) {
/*  718 */       if (this == collection) {
/*  719 */         clear();
/*  720 */         return true;
/*      */       } 
/*  722 */       boolean changed = false;
/*  723 */       TShortIterator iter = collection.iterator();
/*  724 */       while (iter.hasNext()) {
/*  725 */         short element = iter.next();
/*  726 */         if (remove(element)) {
/*  727 */           changed = true;
/*      */         }
/*      */       } 
/*  730 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(short[] array) {
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
/*  748 */       TShortIntHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TShortProcedure procedure) {
/*  754 */       return TShortIntHashMap.this.forEachKey(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object other) {
/*  760 */       if (!(other instanceof TShortSet)) {
/*  761 */         return false;
/*      */       }
/*  763 */       TShortSet that = (TShortSet)other;
/*  764 */       if (that.size() != size()) {
/*  765 */         return false;
/*      */       }
/*  767 */       for (int i = TShortIntHashMap.this._states.length; i-- > 0;) {
/*  768 */         if (TShortIntHashMap.this._states[i] == 1 && 
/*  769 */           !that.contains(TShortIntHashMap.this._set[i])) {
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
/*  781 */       for (int i = TShortIntHashMap.this._states.length; i-- > 0;) {
/*  782 */         if (TShortIntHashMap.this._states[i] == 1) {
/*  783 */           hashcode += HashFunctions.hash(TShortIntHashMap.this._set[i]);
/*      */         }
/*      */       } 
/*  786 */       return hashcode;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  792 */       final StringBuilder buf = new StringBuilder("{");
/*  793 */       TShortIntHashMap.this.forEachKey(new TShortProcedure()
/*      */           {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(short key) {
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
/*      */     implements TIntCollection
/*      */   {
/*      */     public TIntIterator iterator() {
/*  819 */       return new TShortIntHashMap.TShortIntValueHashIterator((TPrimitiveHash)TShortIntHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getNoEntryValue() {
/*  825 */       return TShortIntHashMap.this.no_entry_value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  831 */       return TShortIntHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  837 */       return (0 == TShortIntHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(int entry) {
/*  843 */       return TShortIntHashMap.this.containsValue(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int[] toArray() {
/*  849 */       return TShortIntHashMap.this.values();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int[] toArray(int[] dest) {
/*  855 */       return TShortIntHashMap.this.values(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(int entry) {
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(int entry) {
/*  867 */       int[] values = TShortIntHashMap.this._values;
/*  868 */       byte[] states = TShortIntHashMap.this._states;
/*      */       
/*  870 */       for (int i = values.length; i-- > 0;) {
/*  871 */         if (states[i] != 0 && states[i] != 2 && entry == values[i]) {
/*  872 */           TShortIntHashMap.this.removeAt(i);
/*  873 */           return true;
/*      */         } 
/*      */       } 
/*  876 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  881 */       for (Object element : collection) {
/*  882 */         if (element instanceof Integer) {
/*  883 */           int ele = ((Integer)element).intValue();
/*  884 */           if (!TShortIntHashMap.this.containsValue(ele))
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
/*      */     public boolean containsAll(TIntCollection collection) {
/*  897 */       TIntIterator iter = collection.iterator();
/*  898 */       while (iter.hasNext()) {
/*  899 */         if (!TShortIntHashMap.this.containsValue(iter.next())) {
/*  900 */           return false;
/*      */         }
/*      */       } 
/*  903 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(int[] array) {
/*  909 */       for (int element : array) {
/*  910 */         if (!TShortIntHashMap.this.containsValue(element)) {
/*  911 */           return false;
/*      */         }
/*      */       } 
/*  914 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends Integer> collection) {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TIntCollection collection) {
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(int[] array) {
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  939 */       boolean modified = false;
/*  940 */       TIntIterator iter = iterator();
/*  941 */       while (iter.hasNext()) {
/*  942 */         if (!collection.contains(Integer.valueOf(iter.next()))) {
/*  943 */           iter.remove();
/*  944 */           modified = true;
/*      */         } 
/*      */       } 
/*  947 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TIntCollection collection) {
/*  953 */       if (this == collection) {
/*  954 */         return false;
/*      */       }
/*  956 */       boolean modified = false;
/*  957 */       TIntIterator iter = iterator();
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
/*      */     public boolean retainAll(int[] array) {
/*  970 */       boolean changed = false;
/*  971 */       Arrays.sort(array);
/*  972 */       int[] values = TShortIntHashMap.this._values;
/*  973 */       byte[] states = TShortIntHashMap.this._states;
/*      */       
/*  975 */       for (int i = values.length; i-- > 0;) {
/*  976 */         if (states[i] == 1 && Arrays.binarySearch(array, values[i]) < 0) {
/*  977 */           TShortIntHashMap.this.removeAt(i);
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
/*  989 */         if (element instanceof Integer) {
/*  990 */           int c = ((Integer)element).intValue();
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
/*      */     public boolean removeAll(TIntCollection collection) {
/* 1002 */       if (this == collection) {
/* 1003 */         clear();
/* 1004 */         return true;
/*      */       } 
/* 1006 */       boolean changed = false;
/* 1007 */       TIntIterator iter = collection.iterator();
/* 1008 */       while (iter.hasNext()) {
/* 1009 */         int element = iter.next();
/* 1010 */         if (remove(element)) {
/* 1011 */           changed = true;
/*      */         }
/*      */       } 
/* 1014 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(int[] array) {
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
/* 1032 */       TShortIntHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TIntProcedure procedure) {
/* 1038 */       return TShortIntHashMap.this.forEachValue(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1045 */       final StringBuilder buf = new StringBuilder("{");
/* 1046 */       TShortIntHashMap.this.forEachValue(new TIntProcedure() {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(int value) {
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
/*      */   class TShortIntKeyHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TShortIterator
/*      */   {
/*      */     TShortIntKeyHashIterator(TPrimitiveHash hash) {
/* 1074 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public short next() {
/* 1079 */       moveToNextIndex();
/* 1080 */       return TShortIntHashMap.this._set[this._index];
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
/* 1092 */         TShortIntHashMap.this.removeAt(this._index);
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
/*      */   class TShortIntValueHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TIntIterator
/*      */   {
/*      */     TShortIntValueHashIterator(TPrimitiveHash hash) {
/* 1112 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public int next() {
/* 1117 */       moveToNextIndex();
/* 1118 */       return TShortIntHashMap.this._values[this._index];
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
/* 1130 */         TShortIntHashMap.this.removeAt(this._index);
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
/*      */   class TShortIntHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TShortIntIterator
/*      */   {
/*      */     TShortIntHashIterator(TShortIntHashMap map) {
/* 1149 */       super((TPrimitiveHash)map);
/*      */     }
/*      */ 
/*      */     
/*      */     public void advance() {
/* 1154 */       moveToNextIndex();
/*      */     }
/*      */ 
/*      */     
/*      */     public short key() {
/* 1159 */       return TShortIntHashMap.this._set[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public int value() {
/* 1164 */       return TShortIntHashMap.this._values[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public int setValue(int val) {
/* 1169 */       int old = value();
/* 1170 */       TShortIntHashMap.this._values[this._index] = val;
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
/* 1182 */         TShortIntHashMap.this.removeAt(this._index);
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
/* 1195 */     if (!(other instanceof TShortIntMap)) {
/* 1196 */       return false;
/*      */     }
/* 1198 */     TShortIntMap that = (TShortIntMap)other;
/* 1199 */     if (that.size() != size()) {
/* 1200 */       return false;
/*      */     }
/* 1202 */     int[] values = this._values;
/* 1203 */     byte[] states = this._states;
/* 1204 */     int this_no_entry_value = getNoEntryValue();
/* 1205 */     int that_no_entry_value = that.getNoEntryValue();
/* 1206 */     for (int i = values.length; i-- > 0;) {
/* 1207 */       if (states[i] == 1) {
/* 1208 */         short key = this._set[i];
/*      */         
/* 1210 */         if (!that.containsKey(key)) return false;
/*      */         
/* 1212 */         int that_value = that.get(key);
/* 1213 */         int this_value = values[i];
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
/* 1246 */     forEachEntry(new TShortIntProcedure()
/*      */         {
/*      */           public boolean execute(short key, int value) {
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
/* 1277 */         out.writeShort(this._set[i]);
/* 1278 */         out.writeInt(this._values[i]);
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
/* 1298 */       short key = in.readShort();
/* 1299 */       int val = in.readInt();
/* 1300 */       put(key, val);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\hash\TShortIntHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */