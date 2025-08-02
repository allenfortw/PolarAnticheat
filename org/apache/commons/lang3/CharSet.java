/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
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
/*     */ public class CharSet
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5947847346149275958L;
/*  47 */   public static final CharSet EMPTY = new CharSet(new String[] { (String)null });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final CharSet ASCII_ALPHA = new CharSet(new String[] { "a-zA-Z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final CharSet ASCII_ALPHA_LOWER = new CharSet(new String[] { "a-z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   public static final CharSet ASCII_ALPHA_UPPER = new CharSet(new String[] { "A-Z" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final CharSet ASCII_NUMERIC = new CharSet(new String[] { "0-9" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   protected static final Map<String, CharSet> COMMON = Collections.synchronizedMap(new HashMap<>());
/*     */   
/*     */   static {
/*  81 */     COMMON.put(null, EMPTY);
/*  82 */     COMMON.put("", EMPTY);
/*  83 */     COMMON.put("a-zA-Z", ASCII_ALPHA);
/*  84 */     COMMON.put("A-Za-z", ASCII_ALPHA);
/*  85 */     COMMON.put("a-z", ASCII_ALPHA_LOWER);
/*  86 */     COMMON.put("A-Z", ASCII_ALPHA_UPPER);
/*  87 */     COMMON.put("0-9", ASCII_NUMERIC);
/*     */   }
/*     */ 
/*     */   
/*  91 */   private final Set<CharRange> set = Collections.synchronizedSet(new HashSet<>());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSet getInstance(String... setStrs) {
/* 156 */     if (setStrs == null) {
/* 157 */       return null;
/*     */     }
/* 159 */     if (setStrs.length == 1) {
/* 160 */       CharSet common = COMMON.get(setStrs[0]);
/* 161 */       if (common != null) {
/* 162 */         return common;
/*     */       }
/*     */     } 
/* 165 */     return new CharSet(setStrs);
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
/*     */   protected CharSet(String... set) {
/* 177 */     for (String s : set) {
/* 178 */       add(s);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void add(String str) {
/* 189 */     if (str == null) {
/*     */       return;
/*     */     }
/*     */     
/* 193 */     int len = str.length();
/* 194 */     int pos = 0;
/* 195 */     while (pos < len) {
/* 196 */       int remainder = len - pos;
/* 197 */       if (remainder >= 4 && str.charAt(pos) == '^' && str.charAt(pos + 2) == '-') {
/*     */         
/* 199 */         this.set.add(CharRange.isNotIn(str.charAt(pos + 1), str.charAt(pos + 3)));
/* 200 */         pos += 4; continue;
/* 201 */       }  if (remainder >= 3 && str.charAt(pos + 1) == '-') {
/*     */         
/* 203 */         this.set.add(CharRange.isIn(str.charAt(pos), str.charAt(pos + 2)));
/* 204 */         pos += 3; continue;
/* 205 */       }  if (remainder >= 2 && str.charAt(pos) == '^') {
/*     */         
/* 207 */         this.set.add(CharRange.isNot(str.charAt(pos + 1)));
/* 208 */         pos += 2;
/*     */         continue;
/*     */       } 
/* 211 */       this.set.add(CharRange.is(str.charAt(pos)));
/* 212 */       pos++;
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
/*     */   CharRange[] getCharRanges() {
/* 227 */     return this.set.<CharRange>toArray(CharRange.EMPTY_ARRAY);
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
/* 239 */     synchronized (this.set) {
/* 240 */       for (CharRange range : this.set) {
/* 241 */         if (range.contains(ch)) {
/* 242 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 246 */     return false;
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
/* 264 */     if (obj == this) {
/* 265 */       return true;
/*     */     }
/* 267 */     if (!(obj instanceof CharSet)) {
/* 268 */       return false;
/*     */     }
/* 270 */     CharSet other = (CharSet)obj;
/* 271 */     return this.set.equals(other.set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 282 */     return 89 + this.set.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 292 */     return this.set.toString();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\CharSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */