/*      */ package gnu.trove.map.hash;
/*      */ 
/*      */ import gnu.trove.TFloatCollection;
/*      */ import gnu.trove.function.TFloatFunction;
/*      */ import gnu.trove.impl.HashFunctions;
/*      */ import gnu.trove.impl.hash.TFloatFloatHash;
/*      */ import gnu.trove.impl.hash.THashPrimitiveIterator;
/*      */ import gnu.trove.impl.hash.TPrimitiveHash;
/*      */ import gnu.trove.iterator.TFloatFloatIterator;
/*      */ import gnu.trove.iterator.TFloatIterator;
/*      */ import gnu.trove.map.TFloatFloatMap;
/*      */ import gnu.trove.procedure.TFloatFloatProcedure;
/*      */ import gnu.trove.procedure.TFloatProcedure;
/*      */ import gnu.trove.set.TFloatSet;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TFloatFloatHashMap
/*      */   extends TFloatFloatHash
/*      */   implements TFloatFloatMap, Externalizable
/*      */ {
/*      */   static final long serialVersionUID = 1L;
/*      */   protected transient float[] _values;
/*      */   
/*      */   public TFloatFloatHashMap() {}
/*      */   
/*      */   public TFloatFloatHashMap(int initialCapacity) {
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
/*      */   public TFloatFloatHashMap(int initialCapacity, float loadFactor) {
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
/*      */   public TFloatFloatHashMap(int initialCapacity, float loadFactor, float noEntryKey, float noEntryValue) {
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
/*      */   public TFloatFloatHashMap(float[] keys, float[] values) {
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
/*      */   public TFloatFloatHashMap(TFloatFloatMap map) {
/*  132 */     super(map.size());
/*  133 */     if (map instanceof TFloatFloatHashMap) {
/*  134 */       TFloatFloatHashMap hashmap = (TFloatFloatHashMap)map;
/*  135 */       this._loadFactor = Math.abs(hashmap._loadFactor);
/*  136 */       this.no_entry_key = hashmap.no_entry_key;
/*  137 */       this.no_entry_value = hashmap.no_entry_value;
/*      */       
/*  139 */       if (this.no_entry_key != 0.0F) {
/*  140 */         Arrays.fill(this._set, this.no_entry_key);
/*      */       }
/*      */       
/*  143 */       if (this.no_entry_value != 0.0F) {
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
/*  163 */     this._values = new float[capacity];
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
/*  177 */     float[] oldKeys = this._set;
/*  178 */     float[] oldVals = this._values;
/*  179 */     byte[] oldStates = this._states;
/*      */     
/*  181 */     this._set = new float[newCapacity];
/*  182 */     this._values = new float[newCapacity];
/*  183 */     this._states = new byte[newCapacity];
/*      */     
/*  185 */     for (int i = oldCapacity; i-- > 0;) {
/*  186 */       if (oldStates[i] == 1) {
/*  187 */         float o = oldKeys[i];
/*  188 */         int index = insertKey(o);
/*  189 */         this._values[index] = oldVals[i];
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float put(float key, float value) {
/*  197 */     int index = insertKey(key);
/*  198 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float putIfAbsent(float key, float value) {
/*  204 */     int index = insertKey(key);
/*  205 */     if (index < 0)
/*  206 */       return this._values[-index - 1]; 
/*  207 */     return doPut(key, value, index);
/*      */   }
/*      */ 
/*      */   
/*      */   private float doPut(float key, float value, int index) {
/*  212 */     float previous = this.no_entry_value;
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
/*      */   public void putAll(Map<? extends Float, ? extends Float> map) {
/*  231 */     ensureCapacity(map.size());
/*      */     
/*  233 */     for (Map.Entry<? extends Float, ? extends Float> entry : map.entrySet()) {
/*  234 */       put(((Float)entry.getKey()).floatValue(), ((Float)entry.getValue()).floatValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(TFloatFloatMap map) {
/*  241 */     ensureCapacity(map.size());
/*  242 */     TFloatFloatIterator iter = map.iterator();
/*  243 */     while (iter.hasNext()) {
/*  244 */       iter.advance();
/*  245 */       put(iter.key(), iter.value());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float get(float key) {
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
/*      */   public float remove(float key) {
/*  274 */     float prev = this.no_entry_value;
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
/*      */   public TFloatSet keySet() {
/*  293 */     return new TKeyView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] keys() {
/*  299 */     float[] keys = new float[size()];
/*  300 */     if (keys.length == 0) {
/*  301 */       return keys;
/*      */     }
/*  303 */     float[] k = this._set;
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
/*      */   public float[] keys(float[] array) {
/*  317 */     int size = size();
/*  318 */     if (size == 0) {
/*  319 */       return array;
/*      */     }
/*  321 */     if (array.length < size) {
/*  322 */       array = new float[size];
/*      */     }
/*      */     
/*  325 */     float[] keys = this._set;
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
/*      */   public TFloatCollection valueCollection() {
/*  339 */     return new TValueView();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] values() {
/*  345 */     float[] vals = new float[size()];
/*  346 */     if (vals.length == 0) {
/*  347 */       return vals;
/*      */     }
/*  349 */     float[] v = this._values;
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
/*      */   public float[] values(float[] array) {
/*  363 */     int size = size();
/*  364 */     if (size == 0) {
/*  365 */       return array;
/*      */     }
/*  367 */     if (array.length < size) {
/*  368 */       array = new float[size];
/*      */     }
/*      */     
/*  371 */     float[] v = this._values;
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
/*      */   public boolean containsValue(float val) {
/*  385 */     byte[] states = this._states;
/*  386 */     float[] vals = this._values;
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
/*      */   public boolean containsKey(float key) {
/*  399 */     return contains(key);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TFloatFloatIterator iterator() {
/*  405 */     return new TFloatFloatHashIterator(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachKey(TFloatProcedure procedure) {
/*  411 */     return forEach(procedure);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean forEachValue(TFloatProcedure procedure) {
/*  417 */     byte[] states = this._states;
/*  418 */     float[] values = this._values;
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
/*      */   public boolean forEachEntry(TFloatFloatProcedure procedure) {
/*  430 */     byte[] states = this._states;
/*  431 */     float[] keys = this._set;
/*  432 */     float[] values = this._values;
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
/*      */   public void transformValues(TFloatFunction function) {
/*  444 */     byte[] states = this._states;
/*  445 */     float[] values = this._values;
/*  446 */     for (int i = values.length; i-- > 0;) {
/*  447 */       if (states[i] == 1) {
/*  448 */         values[i] = function.execute(values[i]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retainEntries(TFloatFloatProcedure procedure) {
/*  456 */     boolean modified = false;
/*  457 */     byte[] states = this._states;
/*  458 */     float[] keys = this._set;
/*  459 */     float[] values = this._values;
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
/*      */   public boolean increment(float key) {
/*  482 */     return adjustValue(key, 1.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean adjustValue(float key, float amount) {
/*  488 */     int index = index(key);
/*  489 */     if (index < 0) {
/*  490 */       return false;
/*      */     }
/*  492 */     this._values[index] = this._values[index] + amount;
/*  493 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public float adjustOrPutValue(float key, float adjust_amount, float put_amount) {
/*      */     boolean isNewMapping;
/*      */     float newValue;
/*  500 */     int index = insertKey(key);
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
/*      */     implements TFloatSet
/*      */   {
/*      */     public TFloatIterator iterator() {
/*  527 */       return new TFloatFloatHashMap.TFloatFloatKeyHashIterator((TPrimitiveHash)TFloatFloatHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float getNoEntryValue() {
/*  533 */       return TFloatFloatHashMap.this.no_entry_key;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  539 */       return TFloatFloatHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  545 */       return (0 == TFloatFloatHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(float entry) {
/*  551 */       return TFloatFloatHashMap.this.contains(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float[] toArray() {
/*  557 */       return TFloatFloatHashMap.this.keys();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float[] toArray(float[] dest) {
/*  563 */       return TFloatFloatHashMap.this.keys(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(float entry) {
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(float entry) {
/*  579 */       return (TFloatFloatHashMap.this.no_entry_value != TFloatFloatHashMap.this.remove(entry));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  585 */       for (Object element : collection) {
/*  586 */         if (element instanceof Float) {
/*  587 */           float ele = ((Float)element).floatValue();
/*  588 */           if (!TFloatFloatHashMap.this.containsKey(ele))
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
/*      */     public boolean containsAll(TFloatCollection collection) {
/*  601 */       TFloatIterator iter = collection.iterator();
/*  602 */       while (iter.hasNext()) {
/*  603 */         if (!TFloatFloatHashMap.this.containsKey(iter.next())) {
/*  604 */           return false;
/*      */         }
/*      */       } 
/*  607 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(float[] array) {
/*  613 */       for (float element : array) {
/*  614 */         if (!TFloatFloatHashMap.this.contains(element)) {
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
/*      */     public boolean addAll(Collection<? extends Float> collection) {
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TFloatCollection collection) {
/*  638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(float[] array) {
/*  648 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  655 */       boolean modified = false;
/*  656 */       TFloatIterator iter = iterator();
/*  657 */       while (iter.hasNext()) {
/*  658 */         if (!collection.contains(Float.valueOf(iter.next()))) {
/*  659 */           iter.remove();
/*  660 */           modified = true;
/*      */         } 
/*      */       } 
/*  663 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TFloatCollection collection) {
/*  669 */       if (this == collection) {
/*  670 */         return false;
/*      */       }
/*  672 */       boolean modified = false;
/*  673 */       TFloatIterator iter = iterator();
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
/*      */     public boolean retainAll(float[] array) {
/*  686 */       boolean changed = false;
/*  687 */       Arrays.sort(array);
/*  688 */       float[] set = TFloatFloatHashMap.this._set;
/*  689 */       byte[] states = TFloatFloatHashMap.this._states;
/*      */       
/*  691 */       for (int i = set.length; i-- > 0;) {
/*  692 */         if (states[i] == 1 && Arrays.binarySearch(array, set[i]) < 0) {
/*  693 */           TFloatFloatHashMap.this.removeAt(i);
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
/*  705 */         if (element instanceof Float) {
/*  706 */           float c = ((Float)element).floatValue();
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
/*      */     public boolean removeAll(TFloatCollection collection) {
/*  718 */       if (this == collection) {
/*  719 */         clear();
/*  720 */         return true;
/*      */       } 
/*  722 */       boolean changed = false;
/*  723 */       TFloatIterator iter = collection.iterator();
/*  724 */       while (iter.hasNext()) {
/*  725 */         float element = iter.next();
/*  726 */         if (remove(element)) {
/*  727 */           changed = true;
/*      */         }
/*      */       } 
/*  730 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(float[] array) {
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
/*  748 */       TFloatFloatHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TFloatProcedure procedure) {
/*  754 */       return TFloatFloatHashMap.this.forEachKey(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object other) {
/*  760 */       if (!(other instanceof TFloatSet)) {
/*  761 */         return false;
/*      */       }
/*  763 */       TFloatSet that = (TFloatSet)other;
/*  764 */       if (that.size() != size()) {
/*  765 */         return false;
/*      */       }
/*  767 */       for (int i = TFloatFloatHashMap.this._states.length; i-- > 0;) {
/*  768 */         if (TFloatFloatHashMap.this._states[i] == 1 && 
/*  769 */           !that.contains(TFloatFloatHashMap.this._set[i])) {
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
/*  781 */       for (int i = TFloatFloatHashMap.this._states.length; i-- > 0;) {
/*  782 */         if (TFloatFloatHashMap.this._states[i] == 1) {
/*  783 */           hashcode += HashFunctions.hash(TFloatFloatHashMap.this._set[i]);
/*      */         }
/*      */       } 
/*  786 */       return hashcode;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  792 */       final StringBuilder buf = new StringBuilder("{");
/*  793 */       TFloatFloatHashMap.this.forEachKey(new TFloatProcedure()
/*      */           {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(float key) {
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
/*      */     implements TFloatCollection
/*      */   {
/*      */     public TFloatIterator iterator() {
/*  819 */       return new TFloatFloatHashMap.TFloatFloatValueHashIterator((TPrimitiveHash)TFloatFloatHashMap.this);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float getNoEntryValue() {
/*  825 */       return TFloatFloatHashMap.this.no_entry_value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int size() {
/*  831 */       return TFloatFloatHashMap.this._size;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  837 */       return (0 == TFloatFloatHashMap.this._size);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(float entry) {
/*  843 */       return TFloatFloatHashMap.this.containsValue(entry);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float[] toArray() {
/*  849 */       return TFloatFloatHashMap.this.values();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public float[] toArray(float[] dest) {
/*  855 */       return TFloatFloatHashMap.this.values(dest);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean add(float entry) {
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(float entry) {
/*  867 */       float[] values = TFloatFloatHashMap.this._values;
/*  868 */       byte[] states = TFloatFloatHashMap.this._states;
/*      */       
/*  870 */       for (int i = values.length; i-- > 0;) {
/*  871 */         if (states[i] != 0 && states[i] != 2 && entry == values[i]) {
/*  872 */           TFloatFloatHashMap.this.removeAt(i);
/*  873 */           return true;
/*      */         } 
/*      */       } 
/*  876 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> collection) {
/*  881 */       for (Object element : collection) {
/*  882 */         if (element instanceof Float) {
/*  883 */           float ele = ((Float)element).floatValue();
/*  884 */           if (!TFloatFloatHashMap.this.containsValue(ele))
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
/*      */     public boolean containsAll(TFloatCollection collection) {
/*  897 */       TFloatIterator iter = collection.iterator();
/*  898 */       while (iter.hasNext()) {
/*  899 */         if (!TFloatFloatHashMap.this.containsValue(iter.next())) {
/*  900 */           return false;
/*      */         }
/*      */       } 
/*  903 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsAll(float[] array) {
/*  909 */       for (float element : array) {
/*  910 */         if (!TFloatFloatHashMap.this.containsValue(element)) {
/*  911 */           return false;
/*      */         }
/*      */       } 
/*  914 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends Float> collection) {
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(TFloatCollection collection) {
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(float[] array) {
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> collection) {
/*  939 */       boolean modified = false;
/*  940 */       TFloatIterator iter = iterator();
/*  941 */       while (iter.hasNext()) {
/*  942 */         if (!collection.contains(Float.valueOf(iter.next()))) {
/*  943 */           iter.remove();
/*  944 */           modified = true;
/*      */         } 
/*      */       } 
/*  947 */       return modified;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean retainAll(TFloatCollection collection) {
/*  953 */       if (this == collection) {
/*  954 */         return false;
/*      */       }
/*  956 */       boolean modified = false;
/*  957 */       TFloatIterator iter = iterator();
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
/*      */     public boolean retainAll(float[] array) {
/*  970 */       boolean changed = false;
/*  971 */       Arrays.sort(array);
/*  972 */       float[] values = TFloatFloatHashMap.this._values;
/*  973 */       byte[] states = TFloatFloatHashMap.this._states;
/*      */       
/*  975 */       for (int i = values.length; i-- > 0;) {
/*  976 */         if (states[i] == 1 && Arrays.binarySearch(array, values[i]) < 0) {
/*  977 */           TFloatFloatHashMap.this.removeAt(i);
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
/*  989 */         if (element instanceof Float) {
/*  990 */           float c = ((Float)element).floatValue();
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
/*      */     public boolean removeAll(TFloatCollection collection) {
/* 1002 */       if (this == collection) {
/* 1003 */         clear();
/* 1004 */         return true;
/*      */       } 
/* 1006 */       boolean changed = false;
/* 1007 */       TFloatIterator iter = collection.iterator();
/* 1008 */       while (iter.hasNext()) {
/* 1009 */         float element = iter.next();
/* 1010 */         if (remove(element)) {
/* 1011 */           changed = true;
/*      */         }
/*      */       } 
/* 1014 */       return changed;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean removeAll(float[] array) {
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
/* 1032 */       TFloatFloatHashMap.this.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean forEach(TFloatProcedure procedure) {
/* 1038 */       return TFloatFloatHashMap.this.forEachValue(procedure);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1045 */       final StringBuilder buf = new StringBuilder("{");
/* 1046 */       TFloatFloatHashMap.this.forEachValue(new TFloatProcedure() {
/*      */             private boolean first = true;
/*      */             
/*      */             public boolean execute(float value) {
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
/*      */   class TFloatFloatKeyHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TFloatIterator
/*      */   {
/*      */     TFloatFloatKeyHashIterator(TPrimitiveHash hash) {
/* 1074 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public float next() {
/* 1079 */       moveToNextIndex();
/* 1080 */       return TFloatFloatHashMap.this._set[this._index];
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
/* 1092 */         TFloatFloatHashMap.this.removeAt(this._index);
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
/*      */   class TFloatFloatValueHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TFloatIterator
/*      */   {
/*      */     TFloatFloatValueHashIterator(TPrimitiveHash hash) {
/* 1112 */       super(hash);
/*      */     }
/*      */ 
/*      */     
/*      */     public float next() {
/* 1117 */       moveToNextIndex();
/* 1118 */       return TFloatFloatHashMap.this._values[this._index];
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
/* 1130 */         TFloatFloatHashMap.this.removeAt(this._index);
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
/*      */   class TFloatFloatHashIterator
/*      */     extends THashPrimitiveIterator
/*      */     implements TFloatFloatIterator
/*      */   {
/*      */     TFloatFloatHashIterator(TFloatFloatHashMap map) {
/* 1149 */       super((TPrimitiveHash)map);
/*      */     }
/*      */ 
/*      */     
/*      */     public void advance() {
/* 1154 */       moveToNextIndex();
/*      */     }
/*      */ 
/*      */     
/*      */     public float key() {
/* 1159 */       return TFloatFloatHashMap.this._set[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public float value() {
/* 1164 */       return TFloatFloatHashMap.this._values[this._index];
/*      */     }
/*      */ 
/*      */     
/*      */     public float setValue(float val) {
/* 1169 */       float old = value();
/* 1170 */       TFloatFloatHashMap.this._values[this._index] = val;
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
/* 1182 */         TFloatFloatHashMap.this.removeAt(this._index);
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
/* 1195 */     if (!(other instanceof TFloatFloatMap)) {
/* 1196 */       return false;
/*      */     }
/* 1198 */     TFloatFloatMap that = (TFloatFloatMap)other;
/* 1199 */     if (that.size() != size()) {
/* 1200 */       return false;
/*      */     }
/* 1202 */     float[] values = this._values;
/* 1203 */     byte[] states = this._states;
/* 1204 */     float this_no_entry_value = getNoEntryValue();
/* 1205 */     float that_no_entry_value = that.getNoEntryValue();
/* 1206 */     for (int i = values.length; i-- > 0;) {
/* 1207 */       if (states[i] == 1) {
/* 1208 */         float key = this._set[i];
/*      */         
/* 1210 */         if (!that.containsKey(key)) return false;
/*      */         
/* 1212 */         float that_value = that.get(key);
/* 1213 */         float this_value = values[i];
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
/* 1246 */     forEachEntry(new TFloatFloatProcedure()
/*      */         {
/*      */           public boolean execute(float key, float value) {
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
/* 1277 */         out.writeFloat(this._set[i]);
/* 1278 */         out.writeFloat(this._values[i]);
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
/* 1298 */       float key = in.readFloat();
/* 1299 */       float val = in.readFloat();
/* 1300 */       put(key, val);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\hash\TFloatFloatHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */