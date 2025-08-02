/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
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
/*     */ public final class Range<T>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Comparator<T> comparator;
/*     */   private transient int hashCode;
/*     */   private final T maximum;
/*     */   private final T minimum;
/*     */   private transient String toString;
/*     */   
/*     */   private enum ComparableComparator
/*     */     implements Comparator
/*     */   {
/*  37 */     INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compare(Object obj1, Object obj2) {
/*  47 */       return ((Comparable<Object>)obj1).compareTo(obj2);
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
/*     */   public static <T extends Comparable<T>> Range<T> between(T fromInclusive, T toInclusive) {
/*  73 */     return between(fromInclusive, toInclusive, null);
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
/*     */   
/*     */   public static <T> Range<T> between(T fromInclusive, T toInclusive, Comparator<T> comparator) {
/*  94 */     return new Range<>(fromInclusive, toInclusive, comparator);
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
/*     */   public static <T extends Comparable<T>> Range<T> is(T element) {
/* 111 */     return between(element, element, null);
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
/*     */   public static <T> Range<T> is(T element, Comparator<T> comparator) {
/* 129 */     return between(element, element, comparator);
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
/*     */   private Range(T element1, T element2, Comparator<T> comp) {
/* 166 */     if (element1 == null || element2 == null) {
/* 167 */       throw new IllegalArgumentException("Elements in a range must not be null: element1=" + element1 + ", element2=" + element2);
/*     */     }
/*     */     
/* 170 */     if (comp == null) {
/* 171 */       this.comparator = ComparableComparator.INSTANCE;
/*     */     } else {
/* 173 */       this.comparator = comp;
/*     */     } 
/* 175 */     if (this.comparator.compare(element1, element2) < 1) {
/* 176 */       this.minimum = element1;
/* 177 */       this.maximum = element2;
/*     */     } else {
/* 179 */       this.minimum = element2;
/* 180 */       this.maximum = element1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T element) {
/* 191 */     if (element == null) {
/* 192 */       return false;
/*     */     }
/* 194 */     return (this.comparator.compare(element, this.minimum) > -1 && this.comparator.compare(element, this.maximum) < 1);
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
/*     */   public boolean containsRange(Range<T> otherRange) {
/* 207 */     if (otherRange == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     return (contains(otherRange.minimum) && 
/* 211 */       contains(otherRange.maximum));
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
/*     */   public int elementCompareTo(T element) {
/* 226 */     Validate.notNull(element, "element", new Object[0]);
/* 227 */     if (isAfter(element))
/* 228 */       return -1; 
/* 229 */     if (isBefore(element)) {
/* 230 */       return 1;
/*     */     }
/* 232 */     return 0;
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
/*     */   public boolean equals(Object obj) {
/* 250 */     if (obj == this)
/* 251 */       return true; 
/* 252 */     if (obj == null || obj.getClass() != getClass()) {
/* 253 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 257 */     Range<T> range = (Range<T>)obj;
/* 258 */     return (this.minimum.equals(range.minimum) && this.maximum
/* 259 */       .equals(range.maximum));
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
/*     */   public Comparator<T> getComparator() {
/* 272 */     return this.comparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMaximum() {
/* 281 */     return this.maximum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinimum() {
/* 290 */     return this.minimum;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 300 */     int result = this.hashCode;
/* 301 */     if (this.hashCode == 0) {
/* 302 */       result = 17;
/* 303 */       result = 37 * result + getClass().hashCode();
/* 304 */       result = 37 * result + this.minimum.hashCode();
/* 305 */       result = 37 * result + this.maximum.hashCode();
/* 306 */       this.hashCode = result;
/*     */     } 
/* 308 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Range<T> intersectionWith(Range<T> other) {
/* 319 */     if (!isOverlappedBy(other)) {
/* 320 */       throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[] { other }));
/*     */     }
/*     */     
/* 323 */     if (equals(other)) {
/* 324 */       return this;
/*     */     }
/* 326 */     T min = (getComparator().compare(this.minimum, other.minimum) < 0) ? other.minimum : this.minimum;
/* 327 */     T max = (getComparator().compare(this.maximum, other.maximum) < 0) ? this.maximum : other.maximum;
/* 328 */     return between(min, max, getComparator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAfter(T element) {
/* 338 */     if (element == null) {
/* 339 */       return false;
/*     */     }
/* 341 */     return (this.comparator.compare(element, this.minimum) < 0);
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
/*     */   public boolean isAfterRange(Range<T> otherRange) {
/* 354 */     if (otherRange == null) {
/* 355 */       return false;
/*     */     }
/* 357 */     return isAfter(otherRange.maximum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBefore(T element) {
/* 367 */     if (element == null) {
/* 368 */       return false;
/*     */     }
/* 370 */     return (this.comparator.compare(element, this.maximum) > 0);
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
/*     */   public boolean isBeforeRange(Range<T> otherRange) {
/* 383 */     if (otherRange == null) {
/* 384 */       return false;
/*     */     }
/* 386 */     return isBefore(otherRange.minimum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEndedBy(T element) {
/* 396 */     if (element == null) {
/* 397 */       return false;
/*     */     }
/* 399 */     return (this.comparator.compare(element, this.maximum) == 0);
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
/*     */   public boolean isNaturalOrdering() {
/* 411 */     return (this.comparator == ComparableComparator.INSTANCE);
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
/*     */   public boolean isOverlappedBy(Range<T> otherRange) {
/* 427 */     if (otherRange == null) {
/* 428 */       return false;
/*     */     }
/* 430 */     return (otherRange.contains(this.minimum) || otherRange
/* 431 */       .contains(this.maximum) || 
/* 432 */       contains(otherRange.minimum));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStartedBy(T element) {
/* 442 */     if (element == null) {
/* 443 */       return false;
/*     */     }
/* 445 */     return (this.comparator.compare(element, this.minimum) == 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T fit(T element) {
/* 471 */     Validate.notNull(element, "element", new Object[0]);
/* 472 */     if (isAfter(element))
/* 473 */       return this.minimum; 
/* 474 */     if (isBefore(element)) {
/* 475 */       return this.maximum;
/*     */     }
/* 477 */     return element;
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
/*     */   public String toString() {
/* 490 */     if (this.toString == null) {
/* 491 */       this.toString = "[" + this.minimum + ".." + this.maximum + "]";
/*     */     }
/* 493 */     return this.toString;
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
/*     */   public String toString(String format) {
/* 509 */     return String.format(format, new Object[] { this.minimum, this.maximum, this.comparator });
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\Range.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */