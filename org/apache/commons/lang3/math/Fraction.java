/*     */ package org.apache.commons.lang3.math;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Fraction
/*     */   extends Number
/*     */   implements Comparable<Fraction>
/*     */ {
/*     */   private static final long serialVersionUID = 65382027393090L;
/*  48 */   public static final Fraction ZERO = new Fraction(0, 1);
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static final Fraction ONE = new Fraction(1, 1);
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final Fraction ONE_HALF = new Fraction(1, 2);
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final Fraction ONE_THIRD = new Fraction(1, 3);
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final Fraction TWO_THIRDS = new Fraction(2, 3);
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final Fraction ONE_QUARTER = new Fraction(1, 4);
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
/*     */ 
/*     */ 
/*     */   
/*  80 */   public static final Fraction ONE_FIFTH = new Fraction(1, 5);
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int numerator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int denominator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient int hashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient String toString;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient String toProperString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Fraction(int numerator, int denominator) {
/* 125 */     this.numerator = numerator;
/* 126 */     this.denominator = denominator;
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
/*     */   public static Fraction getFraction(int numerator, int denominator) {
/* 142 */     if (denominator == 0) {
/* 143 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 145 */     if (denominator < 0) {
/* 146 */       if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE) {
/* 147 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 149 */       numerator = -numerator;
/* 150 */       denominator = -denominator;
/*     */     } 
/* 152 */     return new Fraction(numerator, denominator);
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
/*     */   public static Fraction getFraction(int whole, int numerator, int denominator) {
/*     */     long numeratorValue;
/* 172 */     if (denominator == 0) {
/* 173 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 175 */     if (denominator < 0) {
/* 176 */       throw new ArithmeticException("The denominator must not be negative");
/*     */     }
/* 178 */     if (numerator < 0) {
/* 179 */       throw new ArithmeticException("The numerator must not be negative");
/*     */     }
/*     */     
/* 182 */     if (whole < 0) {
/* 183 */       numeratorValue = whole * denominator - numerator;
/*     */     } else {
/* 185 */       numeratorValue = whole * denominator + numerator;
/*     */     } 
/* 187 */     if (numeratorValue < -2147483648L || numeratorValue > 2147483647L) {
/* 188 */       throw new ArithmeticException("Numerator too large to represent as an Integer.");
/*     */     }
/* 190 */     return new Fraction((int)numeratorValue, denominator);
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
/*     */   public static Fraction getReducedFraction(int numerator, int denominator) {
/* 208 */     if (denominator == 0) {
/* 209 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 211 */     if (numerator == 0) {
/* 212 */       return ZERO;
/*     */     }
/*     */     
/* 215 */     if (denominator == Integer.MIN_VALUE && (numerator & 0x1) == 0) {
/* 216 */       numerator /= 2;
/* 217 */       denominator /= 2;
/*     */     } 
/* 219 */     if (denominator < 0) {
/* 220 */       if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE) {
/* 221 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 223 */       numerator = -numerator;
/* 224 */       denominator = -denominator;
/*     */     } 
/*     */     
/* 227 */     int gcd = greatestCommonDivisor(numerator, denominator);
/* 228 */     numerator /= gcd;
/* 229 */     denominator /= gcd;
/* 230 */     return new Fraction(numerator, denominator);
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
/*     */   public static Fraction getFraction(double value) {
/*     */     double delta1;
/* 248 */     int sign = (value < 0.0D) ? -1 : 1;
/* 249 */     value = Math.abs(value);
/* 250 */     if (value > 2.147483647E9D || Double.isNaN(value)) {
/* 251 */       throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
/*     */     }
/* 253 */     int wholeNumber = (int)value;
/* 254 */     value -= wholeNumber;
/*     */     
/* 256 */     int numer0 = 0;
/* 257 */     int denom0 = 1;
/* 258 */     int numer1 = 1;
/* 259 */     int denom1 = 0;
/* 260 */     int numer2 = 0;
/* 261 */     int denom2 = 0;
/* 262 */     int a1 = (int)value;
/* 263 */     int a2 = 0;
/* 264 */     double x1 = 1.0D;
/* 265 */     double x2 = 0.0D;
/* 266 */     double y1 = value - a1;
/* 267 */     double y2 = 0.0D;
/* 268 */     double delta2 = Double.MAX_VALUE;
/*     */     
/* 270 */     int i = 1;
/*     */     do {
/* 272 */       delta1 = delta2;
/* 273 */       a2 = (int)(x1 / y1);
/* 274 */       x2 = y1;
/* 275 */       y2 = x1 - a2 * y1;
/* 276 */       numer2 = a1 * numer1 + numer0;
/* 277 */       denom2 = a1 * denom1 + denom0;
/* 278 */       double fraction = numer2 / denom2;
/* 279 */       delta2 = Math.abs(value - fraction);
/* 280 */       a1 = a2;
/* 281 */       x1 = x2;
/* 282 */       y1 = y2;
/* 283 */       numer0 = numer1;
/* 284 */       denom0 = denom1;
/* 285 */       numer1 = numer2;
/* 286 */       denom1 = denom2;
/* 287 */       i++;
/* 288 */     } while (delta1 > delta2 && denom2 <= 10000 && denom2 > 0 && i < 25);
/* 289 */     if (i == 25) {
/* 290 */       throw new ArithmeticException("Unable to convert double to fraction");
/*     */     }
/* 292 */     return getReducedFraction((numer0 + wholeNumber * denom0) * sign, denom0);
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
/*     */   public static Fraction getFraction(String str) {
/* 314 */     Validate.notNull(str, "str", new Object[0]);
/*     */     
/* 316 */     int pos = str.indexOf('.');
/* 317 */     if (pos >= 0) {
/* 318 */       return getFraction(Double.parseDouble(str));
/*     */     }
/*     */ 
/*     */     
/* 322 */     pos = str.indexOf(' ');
/* 323 */     if (pos > 0) {
/* 324 */       int whole = Integer.parseInt(str.substring(0, pos));
/* 325 */       str = str.substring(pos + 1);
/* 326 */       pos = str.indexOf('/');
/* 327 */       if (pos < 0) {
/* 328 */         throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
/*     */       }
/* 330 */       int i = Integer.parseInt(str.substring(0, pos));
/* 331 */       int j = Integer.parseInt(str.substring(pos + 1));
/* 332 */       return getFraction(whole, i, j);
/*     */     } 
/*     */ 
/*     */     
/* 336 */     pos = str.indexOf('/');
/* 337 */     if (pos < 0)
/*     */     {
/* 339 */       return getFraction(Integer.parseInt(str), 1);
/*     */     }
/* 341 */     int numer = Integer.parseInt(str.substring(0, pos));
/* 342 */     int denom = Integer.parseInt(str.substring(pos + 1));
/* 343 */     return getFraction(numer, denom);
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
/*     */   public int getNumerator() {
/* 358 */     return this.numerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDenominator() {
/* 367 */     return this.denominator;
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
/*     */   public int getProperNumerator() {
/* 382 */     return Math.abs(this.numerator % this.denominator);
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
/*     */   public int getProperWhole() {
/* 397 */     return this.numerator / this.denominator;
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
/*     */   public int intValue() {
/* 411 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 422 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 433 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 444 */     return this.numerator / this.denominator;
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
/*     */   public Fraction reduce() {
/* 460 */     if (this.numerator == 0) {
/* 461 */       return equals(ZERO) ? this : ZERO;
/*     */     }
/* 463 */     int gcd = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
/* 464 */     if (gcd == 1) {
/* 465 */       return this;
/*     */     }
/* 467 */     return getFraction(this.numerator / gcd, this.denominator / gcd);
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
/*     */   public Fraction invert() {
/* 480 */     if (this.numerator == 0) {
/* 481 */       throw new ArithmeticException("Unable to invert zero.");
/*     */     }
/* 483 */     if (this.numerator == Integer.MIN_VALUE) {
/* 484 */       throw new ArithmeticException("overflow: can't negate numerator");
/*     */     }
/* 486 */     if (this.numerator < 0) {
/* 487 */       return new Fraction(-this.denominator, -this.numerator);
/*     */     }
/* 489 */     return new Fraction(this.denominator, this.numerator);
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
/*     */   public Fraction negate() {
/* 501 */     if (this.numerator == Integer.MIN_VALUE) {
/* 502 */       throw new ArithmeticException("overflow: too large to negate");
/*     */     }
/* 504 */     return new Fraction(-this.numerator, this.denominator);
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
/*     */   public Fraction abs() {
/* 517 */     if (this.numerator >= 0) {
/* 518 */       return this;
/*     */     }
/* 520 */     return negate();
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
/*     */   public Fraction pow(int power) {
/* 536 */     if (power == 1)
/* 537 */       return this; 
/* 538 */     if (power == 0)
/* 539 */       return ONE; 
/* 540 */     if (power < 0) {
/* 541 */       if (power == Integer.MIN_VALUE) {
/* 542 */         return invert().pow(2).pow(-(power / 2));
/*     */       }
/* 544 */       return invert().pow(-power);
/*     */     } 
/* 546 */     Fraction f = multiplyBy(this);
/* 547 */     if (power % 2 == 0) {
/* 548 */       return f.pow(power / 2);
/*     */     }
/* 550 */     return f.pow(power / 2).multiplyBy(this);
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
/*     */   private static int greatestCommonDivisor(int u, int v) {
/* 566 */     if (u == 0 || v == 0) {
/* 567 */       if (u == Integer.MIN_VALUE || v == Integer.MIN_VALUE) {
/* 568 */         throw new ArithmeticException("overflow: gcd is 2^31");
/*     */       }
/* 570 */       return Math.abs(u) + Math.abs(v);
/*     */     } 
/*     */     
/* 573 */     if (Math.abs(u) == 1 || Math.abs(v) == 1) {
/* 574 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 580 */     if (u > 0) {
/* 581 */       u = -u;
/*     */     }
/* 583 */     if (v > 0) {
/* 584 */       v = -v;
/*     */     }
/*     */     
/* 587 */     int k = 0;
/* 588 */     while ((u & 0x1) == 0 && (v & 0x1) == 0 && k < 31) {
/* 589 */       u /= 2;
/* 590 */       v /= 2;
/* 591 */       k++;
/*     */     } 
/* 593 */     if (k == 31) {
/* 594 */       throw new ArithmeticException("overflow: gcd is 2^31");
/*     */     }
/*     */ 
/*     */     
/* 598 */     int t = ((u & 0x1) == 1) ? v : -(u / 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 604 */       while ((t & 0x1) == 0) {
/* 605 */         t /= 2;
/*     */       }
/*     */       
/* 608 */       if (t > 0) {
/* 609 */         u = -t;
/*     */       } else {
/* 611 */         v = t;
/*     */       } 
/*     */       
/* 614 */       t = (v - u) / 2;
/*     */ 
/*     */       
/* 617 */       if (t == 0) {
/* 618 */         return -u * (1 << k);
/*     */       }
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
/*     */   private static int mulAndCheck(int x, int y) {
/* 634 */     long m = x * y;
/* 635 */     if (m < -2147483648L || m > 2147483647L) {
/* 636 */       throw new ArithmeticException("overflow: mul");
/*     */     }
/* 638 */     return (int)m;
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
/*     */   private static int mulPosAndCheck(int x, int y) {
/* 652 */     long m = x * y;
/* 653 */     if (m > 2147483647L) {
/* 654 */       throw new ArithmeticException("overflow: mulPos");
/*     */     }
/* 656 */     return (int)m;
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
/*     */   private static int addAndCheck(int x, int y) {
/* 669 */     long s = x + y;
/* 670 */     if (s < -2147483648L || s > 2147483647L) {
/* 671 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 673 */     return (int)s;
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
/*     */   private static int subAndCheck(int x, int y) {
/* 686 */     long s = x - y;
/* 687 */     if (s < -2147483648L || s > 2147483647L) {
/* 688 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 690 */     return (int)s;
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
/*     */   public Fraction add(Fraction fraction) {
/* 704 */     return addSub(fraction, true);
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
/*     */   public Fraction subtract(Fraction fraction) {
/* 718 */     return addSub(fraction, false);
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
/*     */   private Fraction addSub(Fraction fraction, boolean isAdd) {
/* 732 */     Validate.notNull(fraction, "fraction", new Object[0]);
/*     */     
/* 734 */     if (this.numerator == 0) {
/* 735 */       return isAdd ? fraction : fraction.negate();
/*     */     }
/* 737 */     if (fraction.numerator == 0) {
/* 738 */       return this;
/*     */     }
/*     */ 
/*     */     
/* 742 */     int d1 = greatestCommonDivisor(this.denominator, fraction.denominator);
/* 743 */     if (d1 == 1) {
/*     */       
/* 745 */       int i = mulAndCheck(this.numerator, fraction.denominator);
/* 746 */       int j = mulAndCheck(fraction.numerator, this.denominator);
/* 747 */       return new Fraction(isAdd ? addAndCheck(i, j) : subAndCheck(i, j), mulPosAndCheck(this.denominator, fraction.denominator));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 753 */     BigInteger uvp = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf((fraction.denominator / d1)));
/* 754 */     BigInteger upv = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf((this.denominator / d1)));
/* 755 */     BigInteger t = isAdd ? uvp.add(upv) : uvp.subtract(upv);
/*     */ 
/*     */     
/* 758 */     int tmodd1 = t.mod(BigInteger.valueOf(d1)).intValue();
/* 759 */     int d2 = (tmodd1 == 0) ? d1 : greatestCommonDivisor(tmodd1, d1);
/*     */ 
/*     */     
/* 762 */     BigInteger w = t.divide(BigInteger.valueOf(d2));
/* 763 */     if (w.bitLength() > 31) {
/* 764 */       throw new ArithmeticException("overflow: numerator too large after multiply");
/*     */     }
/* 766 */     return new Fraction(w.intValue(), mulPosAndCheck(this.denominator / d1, fraction.denominator / d2));
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
/*     */   public Fraction multiplyBy(Fraction fraction) {
/* 780 */     Validate.notNull(fraction, "fraction", new Object[0]);
/* 781 */     if (this.numerator == 0 || fraction.numerator == 0) {
/* 782 */       return ZERO;
/*     */     }
/*     */ 
/*     */     
/* 786 */     int d1 = greatestCommonDivisor(this.numerator, fraction.denominator);
/* 787 */     int d2 = greatestCommonDivisor(fraction.numerator, this.denominator);
/* 788 */     return getReducedFraction(mulAndCheck(this.numerator / d1, fraction.numerator / d2), 
/* 789 */         mulPosAndCheck(this.denominator / d2, fraction.denominator / d1));
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
/*     */   public Fraction divideBy(Fraction fraction) {
/* 803 */     Validate.notNull(fraction, "fraction", new Object[0]);
/* 804 */     if (fraction.numerator == 0) {
/* 805 */       throw new ArithmeticException("The fraction to divide by must not be zero");
/*     */     }
/* 807 */     return multiplyBy(fraction.invert());
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
/*     */   public boolean equals(Object obj) {
/* 823 */     if (obj == this) {
/* 824 */       return true;
/*     */     }
/* 826 */     if (!(obj instanceof Fraction)) {
/* 827 */       return false;
/*     */     }
/* 829 */     Fraction other = (Fraction)obj;
/* 830 */     return (getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 840 */     if (this.hashCode == 0)
/*     */     {
/* 842 */       this.hashCode = 37 * (629 + getNumerator()) + getDenominator();
/*     */     }
/* 844 */     return this.hashCode;
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
/*     */   public int compareTo(Fraction other) {
/* 861 */     if (this == other) {
/* 862 */       return 0;
/*     */     }
/* 864 */     if (this.numerator == other.numerator && this.denominator == other.denominator) {
/* 865 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 869 */     long first = this.numerator * other.denominator;
/* 870 */     long second = other.numerator * this.denominator;
/* 871 */     return Long.compare(first, second);
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
/*     */   public String toString() {
/* 883 */     if (this.toString == null) {
/* 884 */       this.toString = getNumerator() + "/" + getDenominator();
/*     */     }
/* 886 */     return this.toString;
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
/*     */   public String toProperString() {
/* 899 */     if (this.toProperString == null) {
/* 900 */       if (this.numerator == 0) {
/* 901 */         this.toProperString = "0";
/* 902 */       } else if (this.numerator == this.denominator) {
/* 903 */         this.toProperString = "1";
/* 904 */       } else if (this.numerator == -1 * this.denominator) {
/* 905 */         this.toProperString = "-1";
/* 906 */       } else if (((this.numerator > 0) ? -this.numerator : this.numerator) < -this.denominator) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 911 */         int properNumerator = getProperNumerator();
/* 912 */         if (properNumerator == 0) {
/* 913 */           this.toProperString = Integer.toString(getProperWhole());
/*     */         } else {
/* 915 */           this.toProperString = getProperWhole() + " " + properNumerator + "/" + getDenominator();
/*     */         } 
/*     */       } else {
/* 918 */         this.toProperString = getNumerator() + "/" + getDenominator();
/*     */       } 
/*     */     }
/* 921 */     return this.toProperString;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\math\Fraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */