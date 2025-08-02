/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
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
/*     */ final class CharRange
/*     */   implements Iterable<Character>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8270183163158333422L;
/*     */   private final char start;
/*     */   private final char end;
/*     */   private final boolean negated;
/*     */   private transient String iToString;
/*  53 */   static final CharRange[] EMPTY_ARRAY = new CharRange[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CharRange(char start, char end, boolean negated) {
/*  70 */     if (start > end) {
/*  71 */       char temp = start;
/*  72 */       start = end;
/*  73 */       end = temp;
/*     */     } 
/*     */     
/*  76 */     this.start = start;
/*  77 */     this.end = end;
/*  78 */     this.negated = negated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharRange is(char ch) {
/*  89 */     return new CharRange(ch, ch, false);
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
/*     */   public static CharRange isNot(char ch) {
/* 103 */     return new CharRange(ch, ch, true);
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
/*     */   public static CharRange isIn(char start, char end) {
/* 118 */     return new CharRange(start, end, false);
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
/*     */   public static CharRange isNotIn(char start, char end) {
/* 136 */     return new CharRange(start, end, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getStart() {
/* 147 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEnd() {
/* 156 */     return this.end;
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
/*     */   public boolean isNegated() {
/* 168 */     return this.negated;
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
/*     */   public boolean contains(char ch) {
/* 180 */     return (((ch >= this.start && ch <= this.end)) != this.negated);
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
/*     */   public boolean contains(CharRange range) {
/* 192 */     Validate.notNull(range, "range", new Object[0]);
/* 193 */     if (this.negated) {
/* 194 */       if (range.negated) {
/* 195 */         return (this.start >= range.start && this.end <= range.end);
/*     */       }
/* 197 */       return (range.end < this.start || range.start > this.end);
/*     */     } 
/* 199 */     if (range.negated) {
/* 200 */       return (this.start == '\000' && this.end == Character.MAX_VALUE);
/*     */     }
/* 202 */     return (this.start <= range.start && this.end >= range.end);
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
/*     */   public boolean equals(Object obj) {
/* 216 */     if (obj == this) {
/* 217 */       return true;
/*     */     }
/* 219 */     if (!(obj instanceof CharRange)) {
/* 220 */       return false;
/*     */     }
/* 222 */     CharRange other = (CharRange)obj;
/* 223 */     return (this.start == other.start && this.end == other.end && this.negated == other.negated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 233 */     return 83 + this.start + 7 * this.end + (this.negated ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 243 */     if (this.iToString == null) {
/* 244 */       StringBuilder buf = new StringBuilder(4);
/* 245 */       if (isNegated()) {
/* 246 */         buf.append('^');
/*     */       }
/* 248 */       buf.append(this.start);
/* 249 */       if (this.start != this.end) {
/* 250 */         buf.append('-');
/* 251 */         buf.append(this.end);
/*     */       } 
/* 253 */       this.iToString = buf.toString();
/*     */     } 
/* 255 */     return this.iToString;
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
/*     */   public Iterator<Character> iterator() {
/* 269 */     return new CharacterIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class CharacterIterator
/*     */     implements Iterator<Character>
/*     */   {
/*     */     private char current;
/*     */ 
/*     */     
/*     */     private final CharRange range;
/*     */ 
/*     */     
/*     */     private boolean hasNext;
/*     */ 
/*     */ 
/*     */     
/*     */     private CharacterIterator(CharRange r) {
/* 289 */       this.range = r;
/* 290 */       this.hasNext = true;
/*     */       
/* 292 */       if (this.range.negated) {
/* 293 */         if (this.range.start == '\000') {
/* 294 */           if (this.range.end == Character.MAX_VALUE) {
/*     */             
/* 296 */             this.hasNext = false;
/*     */           } else {
/* 298 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 301 */           this.current = Character.MIN_VALUE;
/*     */         } 
/*     */       } else {
/* 304 */         this.current = this.range.start;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void prepareNext() {
/* 312 */       if (this.range.negated) {
/* 313 */         if (this.current == Character.MAX_VALUE) {
/* 314 */           this.hasNext = false;
/* 315 */         } else if (this.current + 1 == this.range.start) {
/* 316 */           if (this.range.end == Character.MAX_VALUE) {
/* 317 */             this.hasNext = false;
/*     */           } else {
/* 319 */             this.current = (char)(this.range.end + 1);
/*     */           } 
/*     */         } else {
/* 322 */           this.current = (char)(this.current + 1);
/*     */         } 
/* 324 */       } else if (this.current < this.range.end) {
/* 325 */         this.current = (char)(this.current + 1);
/*     */       } else {
/* 327 */         this.hasNext = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 338 */       return this.hasNext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Character next() {
/* 348 */       if (!this.hasNext) {
/* 349 */         throw new NoSuchElementException();
/*     */       }
/* 351 */       char cur = this.current;
/* 352 */       prepareNext();
/* 353 */       return Character.valueOf(cur);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 364 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\CharRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */