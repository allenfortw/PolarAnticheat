/*      */ package gnu.trove.map.hash;
/*      */ 
/*      */ import gnu.trove.TByteCollection;
/*      */ import gnu.trove.TDoubleCollection;
/*      */ import gnu.trove.function.TDoubleFunction;
/*      */ import gnu.trove.impl.HashFunctions;
/*      */ import gnu.trove.impl.hash.TByteDoubleHash;
/*      */ import gnu.trove.impl.hash.THashPrimitiveIterator;
/*      */ import gnu.trove.impl.hash.TPrimitiveHash;
/*      */ import gnu.trove.iterator.TByteDoubleIterator;
/*      */ import gnu.trove.iterator.TByteIterator;
/*      */ import gnu.trove.iterator.TDoubleIterator;
/*      */ import gnu.trove.map.TByteDoubleMap;
/*      */ import gnu.trove.procedure.TByteDoubleProcedure;
/*      */ import gnu.trove.procedure.TByteProcedure;
/*      */ import gnu.trove.procedure.TDoubleProcedure;
/*      */ import gnu.trove.set.TByteSet;
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
/*      */ public class TByteDoubleHashMap
/*      */   extends TByteDoubleHash
/*      */   implements TByteDoubleMap, Externalizable
/*      */ {
/*      */   static final long serialVersionUID = 1L;
/*      */   protected transient double[] _values;
/*      */   
/*      */   public TByteDoubleHashMap() {}
/*      */   
/*      */   public TByteDoubleHashMap(int initialCapacity) {
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
/*      */   public TByteDoubleHashMap(int initialCapacity, float loadFactor) {
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
/*      */   public TByteDoubleHashMap(int initialCapacity, float loadFactor, byte noEntryKey, double noEntryValue) {
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
/*      */   public TByteDoubleHashMap(byte[] keys, double[] values) {
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
/*      */   public TByteDoubleHashMap(TByteDoubleMap map) {
/*  132 */     super(map.size());
/*  133 */     if (map instanceof TByteDoubleHashMap) {
/*  134 */       TByteDoubleHashMap hashmap = (TByteDoubleHashMap)map;
/*  135 */       this._loadFactor = Math.abs(hashmap._loadFactor);
/*  136 */       this.no_entry_key = hashmap.no_entry_key;
/*  137 */       this.no_entry_value = hashmap.no_entry_value;
/*      */       
/*  139 */       if (this.no_entry_key != 0) {
/*  140 */         Arrays.fill(this._set, this.no_entry_key);
/*      */       }
/*      */       
/*  143 */       if (this.no_entry_value != 0.0D) {
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
/*  163 */     this._values = new double[capacity];
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
/*  177 */     byte[] oldKeys = this._set;
/*  178 */     double[] oldVals = this._values;
/*  179 */     byte[] oldStates = this._states;
/*      */     
/*  181 */     this._set = new byte[newCapacity];
/*  182 */     this._values = new double[newCapacity];
/*  183 */     this._states = new byte[newCapacity];
/*      */     
/*  185 */     for (int i = oldCapacity; i-- > 0;) {
/*  186 */       if (oldStates[i] == 1) {
/*  187 */         byte o = oldKeys[i];
/*  188 */         int index = insertKey(o);
/*  189 */         this._values[index] = oldVals[i];
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double put(byte key, double value) {
/*  197 */     int index = insertKey(key);
/*  198 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double putIfAbsent(byte key, double value) {
/*  204 */     int index = insertKey(key);
/*  205 */     if (index < 0)
/*  206 */       return this._values[-index - 1]; 
/*  207 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */   
/*      */   private double doPut(byte key, double value, int index) {
/*  212 */     double previous = this.no_entry_value;
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
/*      */   public void putAll(Map<? extends Byte, ? extends Double> map) {
/*  231 */     ensureCapacity(map.size());
/*      */     
/*  233 */     for (Map.Entry<? extends Byte, ? extends Double> entry : map.entrySet()) {
/*  234 */       put(((Byte)entry.getKey()).byteValue(), ((Double)entry.getValue()).doubleValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(TByteDoubleMap map) {
/*  241 */     ensureCapacity(map.size());
/*  242 */     TByteDoubleIterator iter = map.iterator();
/*  243 */     while (iter.hasNext()) {
/*  244 */       iter.advance();
/*  245 */       put(iter.key(), iter.value());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double get(byte key) {
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
/*      */   public double remove(byte key) {
/*  274 */     double prev = this.no_entry_value;
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
/*      */   public TByteSet keySet() {
/*  293 */     return new TKeyView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] keys() {
/*  299 */     byte[] keys = new byte[size()];
/*  300 */     if (keys.length == 0) {
/*  301 */       return keys;
/*      */     }
/*  303 */     byte[] k = this._set;
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
/*      */   public byte[] keys(byte[] array) {
/*  317 */     int size = size();
/*  318 */     if (size == 0) {
/*  319 */       return array;
/*      */     }
/*  321 */     if (array.length < size) {
/*  322 */       array = new byte[size];
/*      */     }
/*      */     
/*  325 */     byte[] keys = this._set;
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
/*      */   public TDoubleCollection valueCollection() {
/*  339 */     return new TValueView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double[] values() {
/*  345 */     double[] vals = new double[size()];
/*  346 */     if (vals.length == 0) {
/*  347 */       return vals;
/*      */     }
/*  349 */     double[] v = this._values;
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
/*      */   public double[] values(double[] array) {
/*  363 */     int size = size();
/*  364 */     if (size == 0) {
/*  365 */       return array;
/*      */     }
/*  367 */     if (array.length < size) {
/*  368 */       array = new double[size];
/*      */     }
/*      */     
/*  371 */     double[] v = this._values;
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
/*      */   public boolean containsValue(double val) {
/*  385 */     byte[] states = this._states;
/*  386 */     double[] vals = this._values;
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
/*      */   public boolean containsKey(byte key) {
/*  399 */     return contains(key);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TByteDoubleIterator iterator() {
/*  405 */     return new TByteDoubleHashIterator(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachKey(TByteProcedure procedure) {
/*  411 */     return forEach(procedure);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachValue(TDoubleProcedure procedure) {
/*  417 */     byte[] states = this._states;
/*  418 */     double[] values = this._values;
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
/*      */   public boolean forEachEntry(TByteDoubleProcedure procedure) {
/*  430 */     byte[] states = this._states;
/*  431 */     byte[] keys = this._set;
/*  432 */     double[] values = this._values;
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
/*      */   public void transformValues(TDoubleFunction function) {
/*  444 */     byte[] states = this._states;
/*  445 */     double[] values = this._values;
/*  446 */     for (int i = values.length; i-- > 0;) {
/*  447 */       if (states[i] == 1) {
/*  448 */         values[i] = function.execute(values[i]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainEntries(TByteDoubleProcedure procedure) {
/*  456 */     boolean modified = false;
/*  457 */     byte[] states = this._states;
/*  458 */     byte[] keys = this._set;
/*  459 */     double[] values = this._values;
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
/*      */   public boolean increment(byte key) {
/*  482 */     return adjustValue(key, 1.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean adjustValue(byte key, double amount) {
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
/*      */   
/*      */   public double adjustOrPutValue(byte key, double adjust_amount, double put_amount) {
/*  500 */     int index = insertKey(key);
/*      */ 
/*      */ 
/*      */     
/*  504 */     index = -index - 1;
/*  505 */     double newValue = this._values[index] = this._values[index] + adjust_amount;
/*  506 */     boolean isNewMapping = false;
/*      */     
/*  508 */     newValue = this._values[index] = put_amount;
/*  509 */     isNewMapping = true;
/*      */ 
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
/*      */     implements TByteSet
/*      */   {
/*      */     public TByteIterator iterator() {
/*  527 */       return new TByteDoubleHashMap.TByteDoubleKeyHashIterator((TPrimitiveHash)TByteDoubleHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte getNoEntryValue() {
/*  533 */       return TByteDoubleHashMap.this.no_entry_key;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  539 */       return TByteDoubleHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  545 */       return (0 == TByteDoubleHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(byte entry) {
/*  551 */       return TByteDoubleHashMap.this.contains(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] toArray() {
/*  557 */       return TByteDoubleHashMap.this.keys();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] toArray(byte[] dest) {
/*  563 */       return TByteDoubleHashMap.this.keys(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(byte entry) {
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(byte entry) {
/*  579 */       return (TByteDoubleHashMap.this.no_entry_value != TByteDoubleHashMap.this.remove(entry));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  585 */       for (Object element : collection) {
/*  586 */         if (element instanceof Byte) {
/*  587 */           byte ele = ((Byte)element).byteValue();
/*  588 */           if (!TByteDoubleHashMap.this.containsKey(ele))
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
/*      */     public boolean containsAll(TByteCollection collection) {
/*  601 */       TByteIterator iter = collection.iterator();
/*  602 */       while (iter.hasNext()) {
/*  603 */         if (!TByteDoubleHashMap.this.containsKey(iter.next())) {
/*  604 */           return false;
/*      */         }
/*      */       } 
/*  607 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(byte[] array) {
/*  613 */       for (byte element : array) {
/*  614 */         if (!TByteDoubleHashMap.this.contains(element)) {
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
/*      */     public boolean addAll(Collection<? extends Byte> collection) {
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TByteCollection collection) {
/*  638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(byte[] array) {
/*  648 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  655 */       boolean modified = false;
/*  656 */       TByteIterator iter = iterator();
/*  657 */       while (iter.hasNext()) {
/*  658 */         if (!collection.contains(Byte.valueOf(iter.next()))) {
/*  659 */           iter.remove();
/*  660 */           modified = true;
/*      */         } 
/*      */       } 
/*  663 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TByteCollection collection) {
/*  669 */       if (this == collection) {
/*  670 */         return false;
/*      */       }
/*  672 */       boolean modified = false;
/*  673 */       TByteIterator iter = iterator();
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
/*      */     public boolean retainAll(byte[] array) {
/*  686 */       boolean changed = false;
/*  687 */       Arrays.sort(array);
/*  688 */       byte[] set = TByteDoubleHashMap.this._set;
/*  689 */       byte[] states = TByteDoubleHashMap.this._states;
/*      */       
/*  691 */       for (int i = set.length; i-- > 0;) {
/*  692 */         if (states[i] == 1 && Arrays.binarySearch(array, set[i]) < 0) {
/*  693 */           TByteDoubleHashMap.this.removeAt(i);
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
/*  705 */         if (element instanceof Byte) {
/*  706 */           byte c = ((Byte)element).byteValue();
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
/*      */     public boolean removeAll(TByteCollection collection) {
/*  718 */       if (this == collection) {
/*  719 */         clear();
/*  720 */         return true;
/*      */       } 
/*  722 */       boolean changed = false;
/*  723 */       TByteIterator iter = collection.iterator();
/*  724 */       while (iter.hasNext()) {
/*  725 */         byte element = iter.next();
/*  726 */         if (remove(element)) {
/*  727 */           changed = true;
/*      */         }
/*      */       } 
/*  730 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(byte[] array) {
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
/*  748 */       TByteDoubleHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TByteProcedure procedure) {
/*  754 */       return TByteDoubleHashMap.this.forEachKey(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object other) {
/*  760 */       if (!(other instanceof TByteSet)) {
/*  761 */         return false;
/*      */       }
/*  763 */       TByteSet that = (TByteSet)other;
/*  764 */       if (that.size() != size()) {
/*  765 */         return false;
/*      */       }
/*  767 */       for (int i = TByteDoubleHashMap.this._states.length; i-- > 0;) {
/*  768 */         if (TByteDoubleHashMap.this._states[i] == 1 && 
/*  769 */           !that.contains(TByteDoubleHashMap.this._set[i])) {
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
/*  781 */       for (int i = TByteDoubleHashMap.this._states.length; i-- > 0;) {
/*  782 */         if (TByteDoubleHashMap.this._states[i] == 1) {
/*  783 */           hashcode += HashFunctions.hash(TByteDoubleHashMap.this._set[i]);
/*      */         }
/*      */       } 
/*  786 */       return hashcode;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  792 */       final StringBuilder buf = new StringBuilder("{");
/*  793 */       TByteDoubleHashMap.this.forEachKey(new TByteProcedure()
/*      */           {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(byte key) {
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
/*      */     implements TDoubleCollection
/*      */   {
/*      */     public TDoubleIterator iterator() {
/*  819 */       return new TByteDoubleHashMap.TByteDoubleValueHashIterator((TPrimitiveHash)TByteDoubleHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double getNoEntryValue() {
/*  825 */       return TByteDoubleHashMap.this.no_entry_value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  831 */       return TByteDoubleHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  837 */       return (0 == TByteDoubleHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(double entry) {
/*  843 */       return TByteDoubleHashMap.this.containsValue(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double[] toArray() {
/*  849 */       return TByteDoubleHashMap.this.values();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double[] toArray(double[] dest) {
/*  855 */       return TByteDoubleHashMap.this.values(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(double entry) {
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(double entry) {
/*  867 */       double[] values = TByteDoubleHashMap.this._values;
/*  868 */       byte[] states = TByteDoubleHashMap.this._states;
/*      */       
/*  870 */       for (int i = values.length; i-- > 0;) {
/*  871 */         if (states[i] != 0 && states[i] != 2 && entry == values[i]) {
/*  872 */           TByteDoubleHashMap.this.removeAt(i);
/*  873 */           return true;
/*      */         } 
/*      */       } 
/*  876 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  881 */       for (Object element : collection) {
/*  882 */         if (element instanceof Double) {
/*  883 */           double ele = ((Double)element).doubleValue();
/*  884 */           if (!TByteDoubleHashMap.this.containsValue(ele))
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
/*      */     public boolean containsAll(TDoubleCollection collection) {
/*  897 */       TDoubleIterator iter = collection.iterator();
/*  898 */       while (iter.hasNext()) {
/*  899 */         if (!TByteDoubleHashMap.this.containsValue(iter.next())) {
/*  900 */           return false;
/*      */         }
/*      */       } 
/*  903 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(double[] array) {
/*  909 */       for (double element : array) {
/*  910 */         if (!TByteDoubleHashMap.this.containsValue(element)) {
/*  911 */           return false;
/*      */         }
/*      */       } 
/*  914 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends Double> collection) {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TDoubleCollection collection) {
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(double[] array) {
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  939 */       boolean modified = false;
/*  940 */       TDoubleIterator iter = iterator();
/*  941 */       while (iter.hasNext()) {
/*  942 */         if (!collection.contains(Double.valueOf(iter.next()))) {
/*  943 */           iter.remove();
/*  944 */           modified = true;
/*      */         } 
/*      */       } 
/*  947 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TDoubleCollection collection) {
/*  953 */       if (this == collection) {
/*  954 */         return false;
/*      */       }
/*  956 */       boolean modified = false;
/*  957 */       TDoubleIterator iter = iterator();
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
/*      */     public boolean retainAll(double[] array) {
/*  970 */       boolean changed = false;
/*  971 */       Arrays.sort(array);
/*  972 */       double[] values = TByteDoubleHashMap.this._values;
/*  973 */       byte[] states = TByteDoubleHashMap.this._states;
/*      */       
/*  975 */       for (int i = values.length; i-- > 0;) {
/*  976 */         if (states[i] == 1 && Arrays.binarySearch(array, values[i]) < 0) {
/*  977 */           TByteDoubleHashMap.this.removeAt(i);
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
/*  989 */         if (element instanceof Double) {
/*  990 */           double c = ((Double)element).doubleValue();
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
/*      */     public boolean removeAll(TDoubleCollection collection) {
/* 1002 */       if (this == collection) {
/* 1003 */         clear();
/* 1004 */         return true;
/*      */       } 
/* 1006 */       boolean changed = false;
/* 1007 */       TDoubleIterator iter = collection.iterator();
/* 1008 */       while (iter.hasNext()) {
/* 1009 */         double element = iter.next();
/* 1010 */         if (remove(element)) {
/* 1011 */           changed = true;
/*      */         }
/*      */       } 
/* 1014 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(double[] array) {
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
/* 1032 */       TByteDoubleHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TDoubleProcedure procedure) {
/* 1038 */       return TByteDoubleHashMap.this.forEachValue(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1045 */       final StringBuilder buf = new StringBuilder("{");
/* 1046 */       TByteDoubleHashMap.this.forEachValue(new TDoubleProcedure() {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(double value) {
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
/*      */   class TByteDoubleKeyHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TByteIterator
/*      */   {
/*      */     TByteDoubleKeyHashIterator(TPrimitiveHash hash) {
/* 1074 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public byte next() {
/* 1079 */       moveToNextIndex();
/* 1080 */       return TByteDoubleHashMap.this._set[this._index];
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
/* 1092 */         TByteDoubleHashMap.this.removeAt(this._index);
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
/*      */   class TByteDoubleValueHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TDoubleIterator
/*      */   {
/*      */     TByteDoubleValueHashIterator(TPrimitiveHash hash) {
/* 1112 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public double next() {
/* 1117 */       moveToNextIndex();
/* 1118 */       return TByteDoubleHashMap.this._values[this._index];
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
/* 1130 */         TByteDoubleHashMap.this.removeAt(this._index);
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
/*      */   class TByteDoubleHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TByteDoubleIterator
/*      */   {
/*      */     TByteDoubleHashIterator(TByteDoubleHashMap map) {
/* 1149 */       super((TPrimitiveHash)map);
/*      */     }
/*      */ 
/*      */     
/*      */     public void advance() {
/* 1154 */       moveToNextIndex();
/*      */     }
/*      */ 
/*      */     
/*      */     public byte key() {
/* 1159 */       return TByteDoubleHashMap.this._set[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public double value() {
/* 1164 */       return TByteDoubleHashMap.this._values[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public double setValue(double val) {
/* 1169 */       double old = value();
/* 1170 */       TByteDoubleHashMap.this._values[this._index] = val;
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
/* 1182 */         TByteDoubleHashMap.this.removeAt(this._index);
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
/* 1195 */     if (!(other instanceof TByteDoubleMap)) {
/* 1196 */       return false;
/*      */     }
/* 1198 */     TByteDoubleMap that = (TByteDoubleMap)other;
/* 1199 */     if (that.size() != size()) {
/* 1200 */       return false;
/*      */     }
/* 1202 */     double[] values = this._values;
/* 1203 */     byte[] states = this._states;
/* 1204 */     double this_no_entry_value = getNoEntryValue();
/* 1205 */     double that_no_entry_value = that.getNoEntryValue();
/* 1206 */     for (int i = values.length; i-- > 0;) {
/* 1207 */       if (states[i] == 1) {
/* 1208 */         byte key = this._set[i];
/*      */         
/* 1210 */         if (!that.containsKey(key)) return false;
/*      */         
/* 1212 */         double that_value = that.get(key);
/* 1213 */         double this_value = values[i];
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
/* 1246 */     forEachEntry(new TByteDoubleProcedure()
/*      */         {
/*      */           public boolean execute(byte key, double value) {
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
/* 1277 */         out.writeByte(this._set[i]);
/* 1278 */         out.writeDouble(this._values[i]);
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
/* 1298 */       byte key = in.readByte();
/* 1299 */       double val = in.readDouble();
/* 1300 */       put(key, val);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\hash\TByteDoubleHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */