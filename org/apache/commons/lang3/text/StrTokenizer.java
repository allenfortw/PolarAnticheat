/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
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
/*      */ @Deprecated
/*      */ public class StrTokenizer
/*      */   implements ListIterator<String>, Cloneable
/*      */ {
/*   95 */   private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*   96 */     CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
/*   97 */     CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*   98 */     CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*   99 */     CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  100 */     CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  101 */     CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*  103 */   private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE = new StrTokenizer(); static {
/*  104 */     TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
/*  105 */     TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
/*  106 */     TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
/*  107 */     TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
/*  108 */     TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
/*  109 */     TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] chars;
/*      */   
/*      */   private String[] tokens;
/*      */   
/*      */   private int tokenPos;
/*      */   
/*  120 */   private StrMatcher delimMatcher = StrMatcher.splitMatcher();
/*      */   
/*  122 */   private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
/*      */   
/*  124 */   private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
/*      */   
/*  126 */   private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean emptyAsNull;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ignoreEmptyTokens = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getCSVClone() {
/*  141 */     return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getCSVInstance() {
/*  154 */     return getCSVClone();
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
/*      */   public static StrTokenizer getCSVInstance(String input) {
/*  167 */     StrTokenizer tok = getCSVClone();
/*  168 */     tok.reset(input);
/*  169 */     return tok;
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
/*      */   public static StrTokenizer getCSVInstance(char[] input) {
/*  182 */     StrTokenizer tok = getCSVClone();
/*  183 */     tok.reset(input);
/*  184 */     return tok;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StrTokenizer getTSVClone() {
/*  193 */     return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
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
/*      */   public static StrTokenizer getTSVInstance() {
/*  206 */     return getTSVClone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(String input) {
/*  217 */     StrTokenizer tok = getTSVClone();
/*  218 */     tok.reset(input);
/*  219 */     return tok;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static StrTokenizer getTSVInstance(char[] input) {
/*  230 */     StrTokenizer tok = getTSVClone();
/*  231 */     tok.reset(input);
/*  232 */     return tok;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer() {
/*  243 */     this.chars = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input) {
/*  253 */     if (input != null) {
/*  254 */       this.chars = input.toCharArray();
/*      */     } else {
/*  256 */       this.chars = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, char delim) {
/*  267 */     this(input);
/*  268 */     setDelimiterChar(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, String delim) {
/*  278 */     this(input);
/*  279 */     setDelimiterString(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(String input, StrMatcher delim) {
/*  289 */     this(input);
/*  290 */     setDelimiterMatcher(delim);
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
/*      */   public StrTokenizer(String input, char delim, char quote) {
/*  302 */     this(input, delim);
/*  303 */     setQuoteChar(quote);
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
/*      */   public StrTokenizer(String input, StrMatcher delim, StrMatcher quote) {
/*  315 */     this(input, delim);
/*  316 */     setQuoteMatcher(quote);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] input) {
/*  326 */     this.chars = ArrayUtils.clone(input);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] input, char delim) {
/*  336 */     this(input);
/*  337 */     setDelimiterChar(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] input, String delim) {
/*  347 */     this(input);
/*  348 */     setDelimiterString(delim);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer(char[] input, StrMatcher delim) {
/*  358 */     this(input);
/*  359 */     setDelimiterMatcher(delim);
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
/*      */   public StrTokenizer(char[] input, char delim, char quote) {
/*  371 */     this(input, delim);
/*  372 */     setQuoteChar(quote);
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
/*      */   public StrTokenizer(char[] input, StrMatcher delim, StrMatcher quote) {
/*  384 */     this(input, delim);
/*  385 */     setQuoteMatcher(quote);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  396 */     checkTokenized();
/*  397 */     return this.tokens.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String nextToken() {
/*  408 */     if (hasNext()) {
/*  409 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  411 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previousToken() {
/*  420 */     if (hasPrevious()) {
/*  421 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  423 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getTokenArray() {
/*  432 */     checkTokenized();
/*  433 */     return (String[])this.tokens.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getTokenList() {
/*  442 */     checkTokenized();
/*  443 */     List<String> list = new ArrayList<>(this.tokens.length);
/*  444 */     list.addAll(Arrays.asList(this.tokens));
/*  445 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer reset() {
/*  456 */     this.tokenPos = 0;
/*  457 */     this.tokens = null;
/*  458 */     return this;
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
/*      */   public StrTokenizer reset(String input) {
/*  470 */     reset();
/*  471 */     if (input != null) {
/*  472 */       this.chars = input.toCharArray();
/*      */     } else {
/*  474 */       this.chars = null;
/*      */     } 
/*  476 */     return this;
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
/*      */   public StrTokenizer reset(char[] input) {
/*  488 */     reset();
/*  489 */     this.chars = ArrayUtils.clone(input);
/*  490 */     return this;
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
/*      */   public boolean hasNext() {
/*  502 */     checkTokenized();
/*  503 */     return (this.tokenPos < this.tokens.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String next() {
/*  514 */     if (hasNext()) {
/*  515 */       return this.tokens[this.tokenPos++];
/*      */     }
/*  517 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int nextIndex() {
/*  527 */     return this.tokenPos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevious() {
/*  537 */     checkTokenized();
/*  538 */     return (this.tokenPos > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String previous() {
/*  548 */     if (hasPrevious()) {
/*  549 */       return this.tokens[--this.tokenPos];
/*      */     }
/*  551 */     throw new NoSuchElementException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int previousIndex() {
/*  561 */     return this.tokenPos - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove() {
/*  571 */     throw new UnsupportedOperationException("remove() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(String obj) {
/*  581 */     throw new UnsupportedOperationException("set() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void add(String obj) {
/*  591 */     throw new UnsupportedOperationException("add() is unsupported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkTokenized() {
/*  600 */     if (this.tokens == null) {
/*  601 */       if (this.chars == null) {
/*      */         
/*  603 */         List<String> split = tokenize(null, 0, 0);
/*  604 */         this.tokens = split.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */       } else {
/*  606 */         List<String> split = tokenize(this.chars, 0, this.chars.length);
/*  607 */         this.tokens = split.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
/*      */       } 
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
/*      */   protected List<String> tokenize(char[] srcChars, int offset, int count) {
/*  633 */     if (srcChars == null || count == 0) {
/*  634 */       return Collections.emptyList();
/*      */     }
/*  636 */     StrBuilder buf = new StrBuilder();
/*  637 */     List<String> tokenList = new ArrayList<>();
/*  638 */     int pos = offset;
/*      */ 
/*      */     
/*  641 */     while (pos >= 0 && pos < count) {
/*      */       
/*  643 */       pos = readNextToken(srcChars, pos, count, buf, tokenList);
/*      */ 
/*      */       
/*  646 */       if (pos >= count) {
/*  647 */         addToken(tokenList, "");
/*      */       }
/*      */     } 
/*  650 */     return tokenList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addToken(List<String> list, String tok) {
/*  660 */     if (StringUtils.isEmpty(tok)) {
/*  661 */       if (isIgnoreEmptyTokens()) {
/*      */         return;
/*      */       }
/*  664 */       if (isEmptyTokenAsNull()) {
/*  665 */         tok = null;
/*      */       }
/*      */     } 
/*  668 */     list.add(tok);
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
/*      */   private int readNextToken(char[] srcChars, int start, int len, StrBuilder workArea, List<String> tokenList) {
/*  685 */     while (start < len) {
/*  686 */       int removeLen = Math.max(
/*  687 */           getIgnoredMatcher().isMatch(srcChars, start, start, len), 
/*  688 */           getTrimmerMatcher().isMatch(srcChars, start, start, len));
/*  689 */       if (removeLen == 0 || 
/*  690 */         getDelimiterMatcher().isMatch(srcChars, start, start, len) > 0 || 
/*  691 */         getQuoteMatcher().isMatch(srcChars, start, start, len) > 0) {
/*      */         break;
/*      */       }
/*  694 */       start += removeLen;
/*      */     } 
/*      */ 
/*      */     
/*  698 */     if (start >= len) {
/*  699 */       addToken(tokenList, "");
/*  700 */       return -1;
/*      */     } 
/*      */ 
/*      */     
/*  704 */     int delimLen = getDelimiterMatcher().isMatch(srcChars, start, start, len);
/*  705 */     if (delimLen > 0) {
/*  706 */       addToken(tokenList, "");
/*  707 */       return start + delimLen;
/*      */     } 
/*      */ 
/*      */     
/*  711 */     int quoteLen = getQuoteMatcher().isMatch(srcChars, start, start, len);
/*  712 */     if (quoteLen > 0) {
/*  713 */       return readWithQuotes(srcChars, start + quoteLen, len, workArea, tokenList, start, quoteLen);
/*      */     }
/*  715 */     return readWithQuotes(srcChars, start, len, workArea, tokenList, 0, 0);
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
/*      */ 
/*      */ 
/*      */   
/*      */   private int readWithQuotes(char[] srcChars, int start, int len, StrBuilder workArea, List<String> tokenList, int quoteStart, int quoteLen) {
/*  736 */     workArea.clear();
/*  737 */     int pos = start;
/*  738 */     boolean quoting = (quoteLen > 0);
/*  739 */     int trimStart = 0;
/*      */     
/*  741 */     while (pos < len) {
/*      */ 
/*      */ 
/*      */       
/*  745 */       if (quoting) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  752 */         if (isQuote(srcChars, pos, len, quoteStart, quoteLen)) {
/*  753 */           if (isQuote(srcChars, pos + quoteLen, len, quoteStart, quoteLen)) {
/*      */             
/*  755 */             workArea.append(srcChars, pos, quoteLen);
/*  756 */             pos += quoteLen * 2;
/*  757 */             trimStart = workArea.size();
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*  762 */           quoting = false;
/*  763 */           pos += quoteLen;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  768 */         workArea.append(srcChars[pos++]);
/*  769 */         trimStart = workArea.size();
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  775 */       int delimLen = getDelimiterMatcher().isMatch(srcChars, pos, start, len);
/*  776 */       if (delimLen > 0) {
/*      */         
/*  778 */         addToken(tokenList, workArea.substring(0, trimStart));
/*  779 */         return pos + delimLen;
/*      */       } 
/*      */ 
/*      */       
/*  783 */       if (quoteLen > 0 && isQuote(srcChars, pos, len, quoteStart, quoteLen)) {
/*  784 */         quoting = true;
/*  785 */         pos += quoteLen;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  790 */       int ignoredLen = getIgnoredMatcher().isMatch(srcChars, pos, start, len);
/*  791 */       if (ignoredLen > 0) {
/*  792 */         pos += ignoredLen;
/*      */ 
/*      */         
/*      */         continue;
/*      */       } 
/*      */ 
/*      */       
/*  799 */       int trimmedLen = getTrimmerMatcher().isMatch(srcChars, pos, start, len);
/*  800 */       if (trimmedLen > 0) {
/*  801 */         workArea.append(srcChars, pos, trimmedLen);
/*  802 */         pos += trimmedLen;
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  807 */       workArea.append(srcChars[pos++]);
/*  808 */       trimStart = workArea.size();
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  813 */     addToken(tokenList, workArea.substring(0, trimStart));
/*  814 */     return -1;
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
/*      */   private boolean isQuote(char[] srcChars, int pos, int len, int quoteStart, int quoteLen) {
/*  829 */     for (int i = 0; i < quoteLen; i++) {
/*  830 */       if (pos + i >= len || srcChars[pos + i] != srcChars[quoteStart + i]) {
/*  831 */         return false;
/*      */       }
/*      */     } 
/*  834 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrMatcher getDelimiterMatcher() {
/*  845 */     return this.delimMatcher;
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
/*      */   public StrTokenizer setDelimiterMatcher(StrMatcher delim) {
/*  857 */     if (delim == null) {
/*  858 */       this.delimMatcher = StrMatcher.noneMatcher();
/*      */     } else {
/*  860 */       this.delimMatcher = delim;
/*      */     } 
/*  862 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterChar(char delim) {
/*  872 */     return setDelimiterMatcher(StrMatcher.charMatcher(delim));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setDelimiterString(String delim) {
/*  882 */     return setDelimiterMatcher(StrMatcher.stringMatcher(delim));
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
/*      */   public StrMatcher getQuoteMatcher() {
/*  897 */     return this.quoteMatcher;
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
/*      */   public StrTokenizer setQuoteMatcher(StrMatcher quote) {
/*  910 */     if (quote != null) {
/*  911 */       this.quoteMatcher = quote;
/*      */     }
/*  913 */     return this;
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
/*      */   public StrTokenizer setQuoteChar(char quote) {
/*  926 */     return setQuoteMatcher(StrMatcher.charMatcher(quote));
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
/*      */   public StrMatcher getIgnoredMatcher() {
/*  941 */     return this.ignoredMatcher;
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
/*      */   public StrTokenizer setIgnoredMatcher(StrMatcher ignored) {
/*  954 */     if (ignored != null) {
/*  955 */       this.ignoredMatcher = ignored;
/*      */     }
/*  957 */     return this;
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
/*      */   public StrTokenizer setIgnoredChar(char ignored) {
/*  970 */     return setIgnoredMatcher(StrMatcher.charMatcher(ignored));
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
/*      */   public StrMatcher getTrimmerMatcher() {
/*  985 */     return this.trimmerMatcher;
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
/*      */   public StrTokenizer setTrimmerMatcher(StrMatcher trimmer) {
/*  998 */     if (trimmer != null) {
/*  999 */       this.trimmerMatcher = trimmer;
/*      */     }
/* 1001 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmptyTokenAsNull() {
/* 1012 */     return this.emptyAsNull;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setEmptyTokenAsNull(boolean emptyAsNull) {
/* 1023 */     this.emptyAsNull = emptyAsNull;
/* 1024 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIgnoreEmptyTokens() {
/* 1035 */     return this.ignoreEmptyTokens;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer setIgnoreEmptyTokens(boolean ignoreEmptyTokens) {
/* 1046 */     this.ignoreEmptyTokens = ignoreEmptyTokens;
/* 1047 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getContent() {
/* 1057 */     if (this.chars == null) {
/* 1058 */       return null;
/*      */     }
/* 1060 */     return new String(this.chars);
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
/*      */   public Object clone() {
/*      */     try {
/* 1074 */       return cloneReset();
/* 1075 */     } catch (CloneNotSupportedException ex) {
/* 1076 */       return null;
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
/*      */   
/*      */   Object cloneReset() throws CloneNotSupportedException {
/* 1089 */     StrTokenizer cloned = (StrTokenizer)super.clone();
/* 1090 */     if (cloned.chars != null) {
/* 1091 */       cloned.chars = (char[])cloned.chars.clone();
/*      */     }
/* 1093 */     cloned.reset();
/* 1094 */     return cloned;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1105 */     if (this.tokens == null) {
/* 1106 */       return "StrTokenizer[not tokenized yet]";
/*      */     }
/* 1108 */     return "StrTokenizer" + getTokenList();
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\StrTokenizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */