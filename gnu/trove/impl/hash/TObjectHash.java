/*     */ package gnu.trove.impl.hash;
/*     */ 
/*     */ import gnu.trove.procedure.TObjectProcedure;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInput;
/*     */ import java.io.ObjectOutput;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ public abstract class TObjectHash<T>
/*     */   extends THash
/*     */ {
/*     */   static final long serialVersionUID = -3461112548087185871L;
/*     */   public transient Object[] _set;
/*  54 */   public static final Object REMOVED = new Object(); public static final Object FREE = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean consumeFreeSlot;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TObjectHash() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TObjectHash(int initialCapacity) {
/*  80 */     super(initialCapacity);
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
/*     */   public TObjectHash(int initialCapacity, float loadFactor) {
/*  93 */     super(initialCapacity, loadFactor);
/*     */   }
/*     */ 
/*     */   
/*     */   public int capacity() {
/*  98 */     return this._set.length;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAt(int index) {
/* 103 */     this._set[index] = REMOVED;
/* 104 */     super.removeAt(index);
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
/*     */   public int setUp(int initialCapacity) {
/* 117 */     int capacity = super.setUp(initialCapacity);
/* 118 */     this._set = new Object[capacity];
/* 119 */     Arrays.fill(this._set, FREE);
/* 120 */     return capacity;
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
/*     */   public boolean forEach(TObjectProcedure<? super T> procedure) {
/* 133 */     Object[] set = this._set;
/* 134 */     for (int i = set.length; i-- > 0;) {
/* 135 */       if (set[i] != FREE && set[i] != REMOVED && 
/*     */         
/* 137 */         !procedure.execute(set[i])) {
/* 138 */         return false;
/*     */       }
/*     */     } 
/* 141 */     return true;
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
/*     */   public boolean contains(Object obj) {
/* 153 */     return (index(obj) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int index(Object obj) {
/* 164 */     if (obj == null) {
/* 165 */       return indexForNull();
/*     */     }
/*     */     
/* 168 */     int hash = hash(obj) & Integer.MAX_VALUE;
/* 169 */     int index = hash % this._set.length;
/* 170 */     Object cur = this._set[index];
/*     */ 
/*     */     
/* 173 */     if (cur == FREE) {
/* 174 */       return -1;
/*     */     }
/*     */     
/* 177 */     if (cur == obj || equals(obj, cur)) {
/* 178 */       return index;
/*     */     }
/*     */     
/* 181 */     return indexRehashed(obj, index, hash, cur);
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
/*     */   private int indexRehashed(Object obj, int index, int hash, Object cur) {
/* 193 */     Object[] set = this._set;
/* 194 */     int length = set.length;
/*     */ 
/*     */ 
/*     */     
/* 198 */     int probe = 1 + hash % (length - 2);
/*     */     
/* 200 */     int loopIndex = index;
/*     */     
/*     */     do {
/* 203 */       index -= probe;
/* 204 */       if (index < 0) {
/* 205 */         index += length;
/*     */       }
/* 207 */       cur = set[index];
/*     */       
/* 209 */       if (cur == FREE) {
/* 210 */         return -1;
/*     */       }
/*     */       
/* 213 */       if (cur == obj || equals(obj, cur))
/* 214 */         return index; 
/* 215 */     } while (index != loopIndex);
/*     */     
/* 217 */     return -1;
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
/*     */   private int indexForNull() {
/* 232 */     int index = 0;
/* 233 */     for (Object o : this._set) {
/* 234 */       if (o == null) {
/* 235 */         return index;
/*     */       }
/* 237 */       if (o == FREE) {
/* 238 */         return -1;
/*     */       }
/* 240 */       index++;
/*     */     } 
/*     */     
/* 243 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected int insertionIndex(T obj) {
/* 255 */     return insertKey(obj);
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
/*     */   protected int insertKey(T key) {
/* 275 */     this.consumeFreeSlot = false;
/*     */     
/* 277 */     if (key == null) {
/* 278 */       return insertKeyForNull();
/*     */     }
/* 280 */     int hash = hash(key) & Integer.MAX_VALUE;
/* 281 */     int index = hash % this._set.length;
/* 282 */     Object cur = this._set[index];
/*     */     
/* 284 */     if (cur == FREE) {
/* 285 */       this.consumeFreeSlot = true;
/* 286 */       this._set[index] = key;
/* 287 */       return index;
/*     */     } 
/*     */     
/* 290 */     if (cur == key || equals(key, cur)) {
/* 291 */       return -index - 1;
/*     */     }
/*     */     
/* 294 */     return insertKeyRehash(key, index, hash, cur);
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
/*     */   private int insertKeyRehash(T key, int index, int hash, Object cur) {
/* 307 */     Object[] set = this._set;
/* 308 */     int length = set.length;
/*     */ 
/*     */     
/* 311 */     int probe = 1 + hash % (length - 2);
/*     */     
/* 313 */     int loopIndex = index;
/* 314 */     int firstRemoved = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 321 */       if (cur == REMOVED && firstRemoved == -1) {
/* 322 */         firstRemoved = index;
/*     */       }
/* 324 */       index -= probe;
/* 325 */       if (index < 0) {
/* 326 */         index += length;
/*     */       }
/* 328 */       cur = set[index];
/*     */ 
/*     */       
/* 331 */       if (cur == FREE) {
/* 332 */         if (firstRemoved != -1) {
/* 333 */           this._set[firstRemoved] = key;
/* 334 */           return firstRemoved;
/*     */         } 
/* 336 */         this.consumeFreeSlot = true;
/* 337 */         this._set[index] = key;
/* 338 */         return index;
/*     */       } 
/*     */ 
/*     */       
/* 342 */       if (cur == key || equals(key, cur)) {
/* 343 */         return -index - 1;
/*     */       
/*     */       }
/*     */     }
/* 347 */     while (index != loopIndex);
/*     */ 
/*     */ 
/*     */     
/* 351 */     if (firstRemoved != -1) {
/* 352 */       this._set[firstRemoved] = key;
/* 353 */       return firstRemoved;
/*     */     } 
/*     */ 
/*     */     
/* 357 */     throw new IllegalStateException("No free or removed slots available. Key set full?!!");
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
/*     */   private int insertKeyForNull() {
/* 370 */     int index = 0;
/* 371 */     int firstRemoved = -1;
/*     */ 
/*     */     
/* 374 */     for (Object o : this._set) {
/*     */       
/* 376 */       if (o == REMOVED && firstRemoved == -1) {
/* 377 */         firstRemoved = index;
/*     */       }
/* 379 */       if (o == FREE) {
/* 380 */         if (firstRemoved != -1) {
/* 381 */           this._set[firstRemoved] = null;
/* 382 */           return firstRemoved;
/*     */         } 
/* 384 */         this.consumeFreeSlot = true;
/* 385 */         this._set[index] = null;
/* 386 */         return index;
/*     */       } 
/*     */ 
/*     */       
/* 390 */       if (o == null) {
/* 391 */         return -index - 1;
/*     */       }
/*     */       
/* 394 */       index++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 399 */     if (firstRemoved != -1) {
/* 400 */       this._set[firstRemoved] = null;
/* 401 */       return firstRemoved;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 406 */     throw new IllegalStateException("Could not find insertion index for null key. Key set full!?!!");
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
/*     */   protected final void throwObjectContractViolation(Object o1, Object o2) throws IllegalArgumentException {
/* 424 */     throw buildObjectContractViolation(o1, o2, "");
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
/*     */   protected final void throwObjectContractViolation(Object o1, Object o2, int size, int oldSize, Object[] oldKeys) throws IllegalArgumentException {
/* 443 */     String extra = dumpExtraInfo(o1, o2, size(), oldSize, oldKeys);
/*     */ 
/*     */     
/* 446 */     throw buildObjectContractViolation(o1, o2, extra);
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
/*     */   protected final IllegalArgumentException buildObjectContractViolation(Object o1, Object o2, String extra) {
/* 462 */     return new IllegalArgumentException("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =" + 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 467 */         objectInfo(o1) + "; object #2 =" + 
/* 468 */         objectInfo(o2) + "\n" + extra);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equals(Object notnull, Object two) {
/* 473 */     if (two == null || two == REMOVED) {
/* 474 */       return false;
/*     */     }
/* 476 */     return notnull.equals(two);
/*     */   }
/*     */   
/*     */   protected int hash(Object notnull) {
/* 480 */     return notnull.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String reportPotentialConcurrentMod(int newSize, int oldSize) {
/* 486 */     if (newSize != oldSize) {
/* 487 */       return "[Warning] apparent concurrent modification of the key set. Size before and after rehash() do not match " + oldSize + " vs " + newSize;
/*     */     }
/*     */     
/* 490 */     return "";
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
/*     */   protected String dumpExtraInfo(Object newVal, Object oldVal, int currentSize, int oldSize, Object[] oldKeys) {
/* 502 */     StringBuilder b = new StringBuilder();
/*     */     
/* 504 */     b.append(dumpKeyTypes(newVal, oldVal));
/*     */     
/* 506 */     b.append(reportPotentialConcurrentMod(currentSize, oldSize));
/* 507 */     b.append(detectKeyLoss(oldKeys, oldSize));
/*     */ 
/*     */     
/* 510 */     if (newVal == oldVal) {
/* 511 */       b.append("Inserting same object twice, rehashing bug. Object= ").append(oldVal);
/*     */     }
/*     */     
/* 514 */     return b.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String detectKeyLoss(Object[] keys, int oldSize) {
/* 524 */     StringBuilder buf = new StringBuilder();
/* 525 */     Set<Object> k = makeKeySet(keys);
/* 526 */     if (k.size() != oldSize) {
/* 527 */       buf.append("\nhashCode() and/or equals() have inconsistent implementation");
/* 528 */       buf.append("\nKey set lost entries, now got ").append(k.size()).append(" instead of ").append(oldSize);
/* 529 */       buf.append(". This can manifest itself as an apparent duplicate key.");
/*     */     } 
/*     */     
/* 532 */     return buf.toString();
/*     */   }
/*     */   
/*     */   private static Set<Object> makeKeySet(Object[] keys) {
/* 536 */     Set<Object> types = new HashSet();
/* 537 */     for (Object o : keys) {
/* 538 */       if (o != FREE && o != REMOVED) {
/* 539 */         types.add(o);
/*     */       }
/*     */     } 
/*     */     
/* 543 */     return types;
/*     */   }
/*     */   
/*     */   private static String equalsSymmetryInfo(Object a, Object b) {
/* 547 */     StringBuilder buf = new StringBuilder();
/* 548 */     if (a == b) {
/* 549 */       return "a == b";
/*     */     }
/*     */     
/* 552 */     if (a.getClass() != b.getClass()) {
/* 553 */       buf.append("Class of objects differ a=").append(a.getClass()).append(" vs b=").append(b.getClass());
/*     */       
/* 555 */       boolean aEb = a.equals(b);
/* 556 */       boolean bEa = b.equals(a);
/* 557 */       if (aEb != bEa) {
/* 558 */         buf.append("\nequals() of a or b object are asymmetric");
/* 559 */         buf.append("\na.equals(b) =").append(aEb);
/* 560 */         buf.append("\nb.equals(a) =").append(bEa);
/*     */       } 
/*     */     } 
/*     */     
/* 564 */     return buf.toString();
/*     */   }
/*     */   
/*     */   protected static String objectInfo(Object o) {
/* 568 */     return ((o == null) ? "class null" : (String)o.getClass()) + " id= " + System.identityHashCode(o) + " hashCode= " + ((o == null) ? 0 : o
/* 569 */       .hashCode()) + " toString= " + String.valueOf(o);
/*     */   }
/*     */   
/*     */   private String dumpKeyTypes(Object newVal, Object oldVal) {
/* 573 */     StringBuilder buf = new StringBuilder();
/* 574 */     Set<Class<?>> types = new HashSet<Class<?>>();
/* 575 */     for (Object o : this._set) {
/* 576 */       if (o != FREE && o != REMOVED) {
/* 577 */         if (o != null) {
/* 578 */           types.add(o.getClass());
/*     */         } else {
/* 580 */           types.add(null);
/*     */         } 
/*     */       }
/*     */     } 
/* 584 */     if (types.size() > 1) {
/* 585 */       buf.append("\nMore than one type used for keys. Watch out for asymmetric equals(). Read about the 'Liskov substitution principle' and the implications for equals() in java.");
/*     */ 
/*     */       
/* 588 */       buf.append("\nKey types: ").append(types);
/* 589 */       buf.append(equalsSymmetryInfo(newVal, oldVal));
/*     */     } 
/*     */     
/* 592 */     return buf.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeExternal(ObjectOutput out) throws IOException {
/* 599 */     out.writeByte(0);
/*     */ 
/*     */     
/* 602 */     super.writeExternal(out);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
/* 611 */     in.readByte();
/*     */ 
/*     */     
/* 614 */     super.readExternal(in);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\impl\hash\TObjectHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */