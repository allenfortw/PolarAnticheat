/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.Serializable;
/*      */ import java.io.Writer;
/*      */ import java.nio.CharBuffer;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Objects;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.builder.Builder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class StrBuilder
/*      */   implements CharSequence, Appendable, Serializable, Builder<String>
/*      */ {
/*      */   static final int CAPACITY = 32;
/*      */   private static final long serialVersionUID = 7628716375283629643L;
/*      */   protected char[] buffer;
/*      */   protected int size;
/*      */   private String newLine;
/*      */   private String nullText;
/*      */   
/*      */   public StrBuilder() {
/*  109 */     this(32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(int initialCapacity) {
/*  118 */     if (initialCapacity <= 0) {
/*  119 */       initialCapacity = 32;
/*      */     }
/*  121 */     this.buffer = new char[initialCapacity];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder(String str) {
/*  131 */     if (str == null) {
/*  132 */       this.buffer = new char[32];
/*      */     } else {
/*  134 */       this.buffer = new char[str.length() + 32];
/*  135 */       append(str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNewLineText() {
/*  146 */     return this.newLine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNewLineText(String newLine) {
/*  156 */     this.newLine = newLine;
/*  157 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNullText() {
/*  167 */     return this.nullText;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder setNullText(String nullText) {
/*  177 */     if (nullText != null && nullText.isEmpty()) {
/*  178 */       nullText = null;
/*      */     }
/*  180 */     this.nullText = nullText;
/*  181 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  192 */     return this.size;
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
/*      */   public StrBuilder setLength(int length) {
/*  204 */     if (length < 0) {
/*  205 */       throw new StringIndexOutOfBoundsException(length);
/*      */     }
/*  207 */     if (length < this.size) {
/*  208 */       this.size = length;
/*  209 */     } else if (length > this.size) {
/*  210 */       ensureCapacity(length);
/*  211 */       int oldEnd = this.size;
/*  212 */       int newEnd = length;
/*  213 */       this.size = length;
/*  214 */       for (int i = oldEnd; i < newEnd; i++) {
/*  215 */         this.buffer[i] = Character.MIN_VALUE;
/*      */       }
/*      */     } 
/*  218 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  228 */     return this.buffer.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder ensureCapacity(int capacity) {
/*  238 */     if (capacity > this.buffer.length) {
/*  239 */       char[] old = this.buffer;
/*  240 */       this.buffer = new char[capacity * 2];
/*  241 */       System.arraycopy(old, 0, this.buffer, 0, this.size);
/*      */     } 
/*  243 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder minimizeCapacity() {
/*  252 */     if (this.buffer.length > length()) {
/*  253 */       char[] old = this.buffer;
/*  254 */       this.buffer = new char[length()];
/*  255 */       System.arraycopy(old, 0, this.buffer, 0, this.size);
/*      */     } 
/*  257 */     return this;
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
/*      */   public int size() {
/*  270 */     return this.size;
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
/*      */   public boolean isEmpty() {
/*  282 */     return (this.size == 0);
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
/*      */   public boolean isNotEmpty() {
/*  295 */     return (this.size > 0);
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
/*      */   public StrBuilder clear() {
/*  310 */     this.size = 0;
/*  311 */     return this;
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
/*      */   public char charAt(int index) {
/*  326 */     if (index < 0 || index >= length()) {
/*  327 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  329 */     return this.buffer[index];
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
/*      */   public StrBuilder setCharAt(int index, char ch) {
/*  343 */     if (index < 0 || index >= length()) {
/*  344 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  346 */     this.buffer[index] = ch;
/*  347 */     return this;
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
/*      */   public StrBuilder deleteCharAt(int index) {
/*  360 */     if (index < 0 || index >= this.size) {
/*  361 */       throw new StringIndexOutOfBoundsException(index);
/*      */     }
/*  363 */     deleteImpl(index, index + 1, 1);
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] toCharArray() {
/*  374 */     if (this.size == 0) {
/*  375 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  377 */     char[] chars = new char[this.size];
/*  378 */     System.arraycopy(this.buffer, 0, chars, 0, this.size);
/*  379 */     return chars;
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
/*      */   public char[] toCharArray(int startIndex, int endIndex) {
/*  393 */     endIndex = validateRange(startIndex, endIndex);
/*  394 */     int len = endIndex - startIndex;
/*  395 */     if (len == 0) {
/*  396 */       return ArrayUtils.EMPTY_CHAR_ARRAY;
/*      */     }
/*  398 */     char[] chars = new char[len];
/*  399 */     System.arraycopy(this.buffer, startIndex, chars, 0, len);
/*  400 */     return chars;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getChars(char[] destination) {
/*  410 */     int len = length();
/*  411 */     if (destination == null || destination.length < len) {
/*  412 */       destination = new char[len];
/*      */     }
/*  414 */     System.arraycopy(this.buffer, 0, destination, 0, len);
/*  415 */     return destination;
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
/*      */   public void getChars(int startIndex, int endIndex, char[] destination, int destinationIndex) {
/*  429 */     if (startIndex < 0) {
/*  430 */       throw new StringIndexOutOfBoundsException(startIndex);
/*      */     }
/*  432 */     if (endIndex < 0 || endIndex > length()) {
/*  433 */       throw new StringIndexOutOfBoundsException(endIndex);
/*      */     }
/*  435 */     if (startIndex > endIndex) {
/*  436 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/*  438 */     System.arraycopy(this.buffer, startIndex, destination, destinationIndex, endIndex - startIndex);
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
/*      */   public int readFrom(Readable readable) throws IOException {
/*  454 */     int oldSize = this.size;
/*  455 */     if (readable instanceof Reader) {
/*  456 */       Reader r = (Reader)readable;
/*  457 */       ensureCapacity(this.size + 1);
/*      */       int read;
/*  459 */       while ((read = r.read(this.buffer, this.size, this.buffer.length - this.size)) != -1) {
/*  460 */         this.size += read;
/*  461 */         ensureCapacity(this.size + 1);
/*      */       } 
/*  463 */     } else if (readable instanceof CharBuffer) {
/*  464 */       CharBuffer cb = (CharBuffer)readable;
/*  465 */       int remaining = cb.remaining();
/*  466 */       ensureCapacity(this.size + remaining);
/*  467 */       cb.get(this.buffer, this.size, remaining);
/*  468 */       this.size += remaining;
/*      */     } else {
/*      */       while (true) {
/*  471 */         ensureCapacity(this.size + 1);
/*  472 */         CharBuffer buf = CharBuffer.wrap(this.buffer, this.size, this.buffer.length - this.size);
/*  473 */         int read = readable.read(buf);
/*  474 */         if (read == -1) {
/*      */           break;
/*      */         }
/*  477 */         this.size += read;
/*      */       } 
/*      */     } 
/*  480 */     return this.size - oldSize;
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
/*      */   public StrBuilder appendNewLine() {
/*  494 */     if (this.newLine == null) {
/*  495 */       append(System.lineSeparator());
/*  496 */       return this;
/*      */     } 
/*  498 */     return append(this.newLine);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendNull() {
/*  507 */     if (this.nullText == null) {
/*  508 */       return this;
/*      */     }
/*  510 */     return append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(Object obj) {
/*  521 */     if (obj == null) {
/*  522 */       return appendNull();
/*      */     }
/*  524 */     if (obj instanceof CharSequence) {
/*  525 */       return append((CharSequence)obj);
/*      */     }
/*  527 */     return append(obj.toString());
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
/*      */   public StrBuilder append(CharSequence seq) {
/*  540 */     if (seq == null) {
/*  541 */       return appendNull();
/*      */     }
/*  543 */     if (seq instanceof StrBuilder) {
/*  544 */       return append((StrBuilder)seq);
/*      */     }
/*  546 */     if (seq instanceof StringBuilder) {
/*  547 */       return append((StringBuilder)seq);
/*      */     }
/*  549 */     if (seq instanceof StringBuffer) {
/*  550 */       return append((StringBuffer)seq);
/*      */     }
/*  552 */     if (seq instanceof CharBuffer) {
/*  553 */       return append((CharBuffer)seq);
/*      */     }
/*  555 */     return append(seq.toString());
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
/*      */   public StrBuilder append(CharSequence seq, int startIndex, int length) {
/*  570 */     if (seq == null) {
/*  571 */       return appendNull();
/*      */     }
/*  573 */     return append(seq.toString(), startIndex, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(String str) {
/*  584 */     if (str == null) {
/*  585 */       return appendNull();
/*      */     }
/*  587 */     int strLen = str.length();
/*  588 */     if (strLen > 0) {
/*  589 */       int len = length();
/*  590 */       ensureCapacity(len + strLen);
/*  591 */       str.getChars(0, strLen, this.buffer, len);
/*  592 */       this.size += strLen;
/*      */     } 
/*  594 */     return this;
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
/*      */   public StrBuilder append(String str, int startIndex, int length) {
/*  608 */     if (str == null) {
/*  609 */       return appendNull();
/*      */     }
/*  611 */     if (startIndex < 0 || startIndex > str.length()) {
/*  612 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  614 */     if (length < 0 || startIndex + length > str.length()) {
/*  615 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  617 */     if (length > 0) {
/*  618 */       int len = length();
/*  619 */       ensureCapacity(len + length);
/*  620 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  621 */       this.size += length;
/*      */     } 
/*  623 */     return this;
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
/*      */   public StrBuilder append(String format, Object... objs) {
/*  636 */     return append(String.format(format, objs));
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
/*      */   public StrBuilder append(CharBuffer buf) {
/*  648 */     if (buf == null) {
/*  649 */       return appendNull();
/*      */     }
/*  651 */     if (buf.hasArray()) {
/*  652 */       int length = buf.remaining();
/*  653 */       int len = length();
/*  654 */       ensureCapacity(len + length);
/*  655 */       System.arraycopy(buf.array(), buf.arrayOffset() + buf.position(), this.buffer, len, length);
/*  656 */       this.size += length;
/*      */     } else {
/*  658 */       append(buf.toString());
/*      */     } 
/*  660 */     return this;
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
/*      */   public StrBuilder append(CharBuffer buf, int startIndex, int length) {
/*  674 */     if (buf == null) {
/*  675 */       return appendNull();
/*      */     }
/*  677 */     if (buf.hasArray()) {
/*  678 */       int totalLength = buf.remaining();
/*  679 */       if (startIndex < 0 || startIndex > totalLength) {
/*  680 */         throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */       }
/*  682 */       if (length < 0 || startIndex + length > totalLength) {
/*  683 */         throw new StringIndexOutOfBoundsException("length must be valid");
/*      */       }
/*  685 */       int len = length();
/*  686 */       ensureCapacity(len + length);
/*  687 */       System.arraycopy(buf.array(), buf.arrayOffset() + buf.position() + startIndex, this.buffer, len, length);
/*  688 */       this.size += length;
/*      */     } else {
/*  690 */       append(buf.toString(), startIndex, length);
/*      */     } 
/*  692 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StringBuffer str) {
/*  703 */     if (str == null) {
/*  704 */       return appendNull();
/*      */     }
/*  706 */     int strLen = str.length();
/*  707 */     if (strLen > 0) {
/*  708 */       int len = length();
/*  709 */       ensureCapacity(len + strLen);
/*  710 */       str.getChars(0, strLen, this.buffer, len);
/*  711 */       this.size += strLen;
/*      */     } 
/*  713 */     return this;
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
/*      */   public StrBuilder append(StringBuffer str, int startIndex, int length) {
/*  726 */     if (str == null) {
/*  727 */       return appendNull();
/*      */     }
/*  729 */     if (startIndex < 0 || startIndex > str.length()) {
/*  730 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  732 */     if (length < 0 || startIndex + length > str.length()) {
/*  733 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  735 */     if (length > 0) {
/*  736 */       int len = length();
/*  737 */       ensureCapacity(len + length);
/*  738 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  739 */       this.size += length;
/*      */     } 
/*  741 */     return this;
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
/*      */   public StrBuilder append(StringBuilder str) {
/*  753 */     if (str == null) {
/*  754 */       return appendNull();
/*      */     }
/*  756 */     int strLen = str.length();
/*  757 */     if (strLen > 0) {
/*  758 */       int len = length();
/*  759 */       ensureCapacity(len + strLen);
/*  760 */       str.getChars(0, strLen, this.buffer, len);
/*  761 */       this.size += strLen;
/*      */     } 
/*  763 */     return this;
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
/*      */   public StrBuilder append(StringBuilder str, int startIndex, int length) {
/*  777 */     if (str == null) {
/*  778 */       return appendNull();
/*      */     }
/*  780 */     if (startIndex < 0 || startIndex > str.length()) {
/*  781 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  783 */     if (length < 0 || startIndex + length > str.length()) {
/*  784 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  786 */     if (length > 0) {
/*  787 */       int len = length();
/*  788 */       ensureCapacity(len + length);
/*  789 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  790 */       this.size += length;
/*      */     } 
/*  792 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(StrBuilder str) {
/*  803 */     if (str == null) {
/*  804 */       return appendNull();
/*      */     }
/*  806 */     int strLen = str.length();
/*  807 */     if (strLen > 0) {
/*  808 */       int len = length();
/*  809 */       ensureCapacity(len + strLen);
/*  810 */       System.arraycopy(str.buffer, 0, this.buffer, len, strLen);
/*  811 */       this.size += strLen;
/*      */     } 
/*  813 */     return this;
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
/*      */   public StrBuilder append(StrBuilder str, int startIndex, int length) {
/*  826 */     if (str == null) {
/*  827 */       return appendNull();
/*      */     }
/*  829 */     if (startIndex < 0 || startIndex > str.length()) {
/*  830 */       throw new StringIndexOutOfBoundsException("startIndex must be valid");
/*      */     }
/*  832 */     if (length < 0 || startIndex + length > str.length()) {
/*  833 */       throw new StringIndexOutOfBoundsException("length must be valid");
/*      */     }
/*  835 */     if (length > 0) {
/*  836 */       int len = length();
/*  837 */       ensureCapacity(len + length);
/*  838 */       str.getChars(startIndex, startIndex + length, this.buffer, len);
/*  839 */       this.size += length;
/*      */     } 
/*  841 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] chars) {
/*  852 */     if (chars == null) {
/*  853 */       return appendNull();
/*      */     }
/*  855 */     int strLen = chars.length;
/*  856 */     if (strLen > 0) {
/*  857 */       int len = length();
/*  858 */       ensureCapacity(len + strLen);
/*  859 */       System.arraycopy(chars, 0, this.buffer, len, strLen);
/*  860 */       this.size += strLen;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(char[] chars, int startIndex, int length) {
/*  875 */     if (chars == null) {
/*  876 */       return appendNull();
/*      */     }
/*  878 */     if (startIndex < 0 || startIndex > chars.length) {
/*  879 */       throw new StringIndexOutOfBoundsException("Invalid startIndex: " + length);
/*      */     }
/*  881 */     if (length < 0 || startIndex + length > chars.length) {
/*  882 */       throw new StringIndexOutOfBoundsException("Invalid length: " + length);
/*      */     }
/*  884 */     if (length > 0) {
/*  885 */       int len = length();
/*  886 */       ensureCapacity(len + length);
/*  887 */       System.arraycopy(chars, startIndex, this.buffer, len, length);
/*  888 */       this.size += length;
/*      */     } 
/*  890 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(boolean value) {
/*  900 */     if (value) {
/*  901 */       ensureCapacity(this.size + 4);
/*  902 */       this.buffer[this.size++] = 't';
/*  903 */       this.buffer[this.size++] = 'r';
/*  904 */       this.buffer[this.size++] = 'u';
/*  905 */       this.buffer[this.size++] = 'e';
/*      */     } else {
/*  907 */       ensureCapacity(this.size + 5);
/*  908 */       this.buffer[this.size++] = 'f';
/*  909 */       this.buffer[this.size++] = 'a';
/*  910 */       this.buffer[this.size++] = 'l';
/*  911 */       this.buffer[this.size++] = 's';
/*  912 */       this.buffer[this.size++] = 'e';
/*      */     } 
/*  914 */     return this;
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
/*      */   public StrBuilder append(char ch) {
/*  926 */     int len = length();
/*  927 */     ensureCapacity(len + 1);
/*  928 */     this.buffer[this.size++] = ch;
/*  929 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(int value) {
/*  939 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(long value) {
/*  949 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(float value) {
/*  959 */     return append(String.valueOf(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder append(double value) {
/*  969 */     return append(String.valueOf(value));
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
/*      */   public StrBuilder appendln(Object obj) {
/*  982 */     return append(obj).appendNewLine();
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
/*      */   public StrBuilder appendln(String str) {
/*  994 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(String str, int startIndex, int length) {
/* 1008 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(String format, Object... objs) {
/* 1021 */     return append(format, objs).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuffer str) {
/* 1033 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuilder str) {
/* 1045 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuilder str, int startIndex, int length) {
/* 1059 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(StringBuffer str, int startIndex, int length) {
/* 1073 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(StrBuilder str) {
/* 1085 */     return append(str).appendNewLine();
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
/*      */   public StrBuilder appendln(StrBuilder str, int startIndex, int length) {
/* 1099 */     return append(str, startIndex, length).appendNewLine();
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
/*      */   public StrBuilder appendln(char[] chars) {
/* 1111 */     return append(chars).appendNewLine();
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
/*      */   public StrBuilder appendln(char[] chars, int startIndex, int length) {
/* 1125 */     return append(chars, startIndex, length).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(boolean value) {
/* 1136 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(char ch) {
/* 1147 */     return append(ch).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(int value) {
/* 1158 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(long value) {
/* 1169 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(float value) {
/* 1180 */     return append(value).appendNewLine();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendln(double value) {
/* 1191 */     return append(value).appendNewLine();
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
/*      */   public <T> StrBuilder appendAll(T... array) {
/* 1212 */     if (ArrayUtils.isNotEmpty((Object[])array)) {
/* 1213 */       for (T element : array) {
/* 1214 */         append(element);
/*      */       }
/*      */     }
/* 1217 */     return this;
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
/*      */   public StrBuilder appendAll(Iterable<?> iterable) {
/* 1230 */     if (iterable != null) {
/* 1231 */       for (Object o : iterable) {
/* 1232 */         append(o);
/*      */       }
/*      */     }
/* 1235 */     return this;
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
/*      */   public StrBuilder appendAll(Iterator<?> it) {
/* 1248 */     if (it != null) {
/* 1249 */       while (it.hasNext()) {
/* 1250 */         append(it.next());
/*      */       }
/*      */     }
/* 1253 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Object[] array, String separator) {
/* 1268 */     if (array != null && array.length > 0) {
/* 1269 */       String sep = Objects.toString(separator, "");
/* 1270 */       append(array[0]);
/* 1271 */       for (int i = 1; i < array.length; i++) {
/* 1272 */         append(sep);
/* 1273 */         append(array[i]);
/*      */       } 
/*      */     } 
/* 1276 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Iterable<?> iterable, String separator) {
/* 1290 */     if (iterable != null) {
/* 1291 */       String sep = Objects.toString(separator, "");
/* 1292 */       Iterator<?> it = iterable.iterator();
/* 1293 */       while (it.hasNext()) {
/* 1294 */         append(it.next());
/* 1295 */         if (it.hasNext()) {
/* 1296 */           append(sep);
/*      */         }
/*      */       } 
/*      */     } 
/* 1300 */     return this;
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
/*      */   public StrBuilder appendWithSeparators(Iterator<?> it, String separator) {
/* 1314 */     if (it != null) {
/* 1315 */       String sep = Objects.toString(separator, "");
/* 1316 */       while (it.hasNext()) {
/* 1317 */         append(it.next());
/* 1318 */         if (it.hasNext()) {
/* 1319 */           append(sep);
/*      */         }
/*      */       } 
/*      */     } 
/* 1323 */     return this;
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
/*      */   
/*      */   public StrBuilder appendSeparator(String separator) {
/* 1348 */     return appendSeparator(separator, (String)null);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder appendSeparator(String standard, String defaultIfEmpty) {
/* 1379 */     String str = isEmpty() ? defaultIfEmpty : standard;
/* 1380 */     if (str != null) {
/* 1381 */       append(str);
/*      */     }
/* 1383 */     return this;
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
/*      */   public StrBuilder appendSeparator(char separator) {
/* 1406 */     if (isNotEmpty()) {
/* 1407 */       append(separator);
/*      */     }
/* 1409 */     return this;
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
/*      */   public StrBuilder appendSeparator(char standard, char defaultIfEmpty) {
/* 1424 */     if (isNotEmpty()) {
/* 1425 */       append(standard);
/*      */     } else {
/* 1427 */       append(defaultIfEmpty);
/*      */     } 
/* 1429 */     return this;
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
/*      */   
/*      */   public StrBuilder appendSeparator(String separator, int loopIndex) {
/* 1454 */     if (separator != null && loopIndex > 0) {
/* 1455 */       append(separator);
/*      */     }
/* 1457 */     return this;
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
/*      */   
/*      */   public StrBuilder appendSeparator(char separator, int loopIndex) {
/* 1482 */     if (loopIndex > 0) {
/* 1483 */       append(separator);
/*      */     }
/* 1485 */     return this;
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
/*      */   public StrBuilder appendPadding(int length, char padChar) {
/* 1497 */     if (length >= 0) {
/* 1498 */       ensureCapacity(this.size + length);
/* 1499 */       for (int i = 0; i < length; i++) {
/* 1500 */         this.buffer[this.size++] = padChar;
/*      */       }
/*      */     } 
/* 1503 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadLeft(Object obj, int width, char padChar) {
/* 1519 */     if (width > 0) {
/* 1520 */       ensureCapacity(this.size + width);
/* 1521 */       String str = (obj == null) ? getNullText() : obj.toString();
/* 1522 */       if (str == null) {
/* 1523 */         str = "";
/*      */       }
/* 1525 */       int strLen = str.length();
/* 1526 */       if (strLen >= width) {
/* 1527 */         str.getChars(strLen - width, strLen, this.buffer, this.size);
/*      */       } else {
/* 1529 */         int padLen = width - strLen;
/* 1530 */         for (int i = 0; i < padLen; i++) {
/* 1531 */           this.buffer[this.size + i] = padChar;
/*      */         }
/* 1533 */         str.getChars(0, strLen, this.buffer, this.size + padLen);
/*      */       } 
/* 1535 */       this.size += width;
/*      */     } 
/* 1537 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadLeft(int value, int width, char padChar) {
/* 1551 */     return appendFixedWidthPadLeft(String.valueOf(value), width, padChar);
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
/*      */   public StrBuilder appendFixedWidthPadRight(Object obj, int width, char padChar) {
/* 1566 */     if (width > 0) {
/* 1567 */       ensureCapacity(this.size + width);
/* 1568 */       String str = (obj == null) ? getNullText() : obj.toString();
/* 1569 */       if (str == null) {
/* 1570 */         str = "";
/*      */       }
/* 1572 */       int strLen = str.length();
/* 1573 */       if (strLen >= width) {
/* 1574 */         str.getChars(0, width, this.buffer, this.size);
/*      */       } else {
/* 1576 */         int padLen = width - strLen;
/* 1577 */         str.getChars(0, strLen, this.buffer, this.size);
/* 1578 */         for (int i = 0; i < padLen; i++) {
/* 1579 */           this.buffer[this.size + strLen + i] = padChar;
/*      */         }
/*      */       } 
/* 1582 */       this.size += width;
/*      */     } 
/* 1584 */     return this;
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
/*      */   public StrBuilder appendFixedWidthPadRight(int value, int width, char padChar) {
/* 1598 */     return appendFixedWidthPadRight(String.valueOf(value), width, padChar);
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
/*      */   public StrBuilder insert(int index, Object obj) {
/* 1612 */     if (obj == null) {
/* 1613 */       return insert(index, this.nullText);
/*      */     }
/* 1615 */     return insert(index, obj.toString());
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
/*      */   public StrBuilder insert(int index, String str) {
/* 1628 */     validateIndex(index);
/* 1629 */     if (str == null) {
/* 1630 */       str = this.nullText;
/*      */     }
/* 1632 */     if (str != null) {
/* 1633 */       int strLen = str.length();
/* 1634 */       if (strLen > 0) {
/* 1635 */         int newSize = this.size + strLen;
/* 1636 */         ensureCapacity(newSize);
/* 1637 */         System.arraycopy(this.buffer, index, this.buffer, index + strLen, this.size - index);
/* 1638 */         this.size = newSize;
/* 1639 */         str.getChars(0, strLen, this.buffer, index);
/*      */       } 
/*      */     } 
/* 1642 */     return this;
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
/*      */   public StrBuilder insert(int index, char[] chars) {
/* 1655 */     validateIndex(index);
/* 1656 */     if (chars == null) {
/* 1657 */       return insert(index, this.nullText);
/*      */     }
/* 1659 */     int len = chars.length;
/* 1660 */     if (len > 0) {
/* 1661 */       ensureCapacity(this.size + len);
/* 1662 */       System.arraycopy(this.buffer, index, this.buffer, index + len, this.size - index);
/* 1663 */       System.arraycopy(chars, 0, this.buffer, index, len);
/* 1664 */       this.size += len;
/*      */     } 
/* 1666 */     return this;
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
/*      */   public StrBuilder insert(int index, char[] chars, int offset, int length) {
/* 1681 */     validateIndex(index);
/* 1682 */     if (chars == null) {
/* 1683 */       return insert(index, this.nullText);
/*      */     }
/* 1685 */     if (offset < 0 || offset > chars.length) {
/* 1686 */       throw new StringIndexOutOfBoundsException("Invalid offset: " + offset);
/*      */     }
/* 1688 */     if (length < 0 || offset + length > chars.length) {
/* 1689 */       throw new StringIndexOutOfBoundsException("Invalid length: " + length);
/*      */     }
/* 1691 */     if (length > 0) {
/* 1692 */       ensureCapacity(this.size + length);
/* 1693 */       System.arraycopy(this.buffer, index, this.buffer, index + length, this.size - index);
/* 1694 */       System.arraycopy(chars, offset, this.buffer, index, length);
/* 1695 */       this.size += length;
/*      */     } 
/* 1697 */     return this;
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
/*      */   public StrBuilder insert(int index, boolean value) {
/* 1709 */     validateIndex(index);
/* 1710 */     if (value) {
/* 1711 */       ensureCapacity(this.size + 4);
/* 1712 */       System.arraycopy(this.buffer, index, this.buffer, index + 4, this.size - index);
/* 1713 */       this.buffer[index++] = 't';
/* 1714 */       this.buffer[index++] = 'r';
/* 1715 */       this.buffer[index++] = 'u';
/* 1716 */       this.buffer[index] = 'e';
/* 1717 */       this.size += 4;
/*      */     } else {
/* 1719 */       ensureCapacity(this.size + 5);
/* 1720 */       System.arraycopy(this.buffer, index, this.buffer, index + 5, this.size - index);
/* 1721 */       this.buffer[index++] = 'f';
/* 1722 */       this.buffer[index++] = 'a';
/* 1723 */       this.buffer[index++] = 'l';
/* 1724 */       this.buffer[index++] = 's';
/* 1725 */       this.buffer[index] = 'e';
/* 1726 */       this.size += 5;
/*      */     } 
/* 1728 */     return this;
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
/*      */   public StrBuilder insert(int index, char value) {
/* 1740 */     validateIndex(index);
/* 1741 */     ensureCapacity(this.size + 1);
/* 1742 */     System.arraycopy(this.buffer, index, this.buffer, index + 1, this.size - index);
/* 1743 */     this.buffer[index] = value;
/* 1744 */     this.size++;
/* 1745 */     return this;
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
/*      */   public StrBuilder insert(int index, int value) {
/* 1757 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, long value) {
/* 1769 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, float value) {
/* 1781 */     return insert(index, String.valueOf(value));
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
/*      */   public StrBuilder insert(int index, double value) {
/* 1793 */     return insert(index, String.valueOf(value));
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
/*      */   private void deleteImpl(int startIndex, int endIndex, int len) {
/* 1806 */     System.arraycopy(this.buffer, endIndex, this.buffer, startIndex, this.size - endIndex);
/* 1807 */     this.size -= len;
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
/*      */   public StrBuilder delete(int startIndex, int endIndex) {
/* 1820 */     endIndex = validateRange(startIndex, endIndex);
/* 1821 */     int len = endIndex - startIndex;
/* 1822 */     if (len > 0) {
/* 1823 */       deleteImpl(startIndex, endIndex, len);
/*      */     }
/* 1825 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(char ch) {
/* 1836 */     for (int i = 0; i < this.size; i++) {
/* 1837 */       if (this.buffer[i] == ch) {
/* 1838 */         int start = i; do {  }
/* 1839 */         while (++i < this.size && 
/* 1840 */           this.buffer[i] == ch);
/*      */ 
/*      */ 
/*      */         
/* 1844 */         int len = i - start;
/* 1845 */         deleteImpl(start, i, len);
/* 1846 */         i -= len;
/*      */       } 
/*      */     } 
/* 1849 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(char ch) {
/* 1859 */     for (int i = 0; i < this.size; i++) {
/* 1860 */       if (this.buffer[i] == ch) {
/* 1861 */         deleteImpl(i, i + 1, 1);
/*      */         break;
/*      */       } 
/*      */     } 
/* 1865 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteAll(String str) {
/* 1876 */     int len = (str == null) ? 0 : str.length();
/* 1877 */     if (len > 0) {
/* 1878 */       int index = indexOf(str, 0);
/* 1879 */       while (index >= 0) {
/* 1880 */         deleteImpl(index, index + len, len);
/* 1881 */         index = indexOf(str, index);
/*      */       } 
/*      */     } 
/* 1884 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder deleteFirst(String str) {
/* 1894 */     int len = (str == null) ? 0 : str.length();
/* 1895 */     if (len > 0) {
/* 1896 */       int index = indexOf(str, 0);
/* 1897 */       if (index >= 0) {
/* 1898 */         deleteImpl(index, index + len, len);
/*      */       }
/*      */     } 
/* 1901 */     return this;
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
/*      */   public StrBuilder deleteAll(StrMatcher matcher) {
/* 1916 */     return replace(matcher, null, 0, this.size, -1);
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
/*      */   public StrBuilder deleteFirst(StrMatcher matcher) {
/* 1930 */     return replace(matcher, null, 0, this.size, 1);
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
/*      */   private void replaceImpl(int startIndex, int endIndex, int removeLen, String insertStr, int insertLen) {
/* 1945 */     int newSize = this.size - removeLen + insertLen;
/* 1946 */     if (insertLen != removeLen) {
/* 1947 */       ensureCapacity(newSize);
/* 1948 */       System.arraycopy(this.buffer, endIndex, this.buffer, startIndex + insertLen, this.size - endIndex);
/* 1949 */       this.size = newSize;
/*      */     } 
/* 1951 */     if (insertLen > 0) {
/* 1952 */       insertStr.getChars(0, insertLen, this.buffer, startIndex);
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
/*      */   public StrBuilder replace(int startIndex, int endIndex, String replaceStr) {
/* 1968 */     endIndex = validateRange(startIndex, endIndex);
/* 1969 */     int insertLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 1970 */     replaceImpl(startIndex, endIndex, endIndex - startIndex, replaceStr, insertLen);
/* 1971 */     return this;
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
/*      */   public StrBuilder replaceAll(char search, char replace) {
/* 1984 */     if (search != replace) {
/* 1985 */       for (int i = 0; i < this.size; i++) {
/* 1986 */         if (this.buffer[i] == search) {
/* 1987 */           this.buffer[i] = replace;
/*      */         }
/*      */       } 
/*      */     }
/* 1991 */     return this;
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
/*      */   public StrBuilder replaceFirst(char search, char replace) {
/* 2003 */     if (search != replace) {
/* 2004 */       for (int i = 0; i < this.size; i++) {
/* 2005 */         if (this.buffer[i] == search) {
/* 2006 */           this.buffer[i] = replace;
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2011 */     return this;
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
/*      */   public StrBuilder replaceAll(String searchStr, String replaceStr) {
/* 2023 */     int searchLen = (searchStr == null) ? 0 : searchStr.length();
/* 2024 */     if (searchLen > 0) {
/* 2025 */       int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 2026 */       int index = indexOf(searchStr, 0);
/* 2027 */       while (index >= 0) {
/* 2028 */         replaceImpl(index, index + searchLen, searchLen, replaceStr, replaceLen);
/* 2029 */         index = indexOf(searchStr, index + replaceLen);
/*      */       } 
/*      */     } 
/* 2032 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder replaceFirst(String searchStr, String replaceStr) {
/* 2043 */     int searchLen = (searchStr == null) ? 0 : searchStr.length();
/* 2044 */     if (searchLen > 0) {
/* 2045 */       int index = indexOf(searchStr, 0);
/* 2046 */       if (index >= 0) {
/* 2047 */         int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 2048 */         replaceImpl(index, index + searchLen, searchLen, replaceStr, replaceLen);
/*      */       } 
/*      */     } 
/* 2051 */     return this;
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
/*      */   public StrBuilder replaceAll(StrMatcher matcher, String replaceStr) {
/* 2067 */     return replace(matcher, replaceStr, 0, this.size, -1);
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
/*      */   public StrBuilder replaceFirst(StrMatcher matcher, String replaceStr) {
/* 2082 */     return replace(matcher, replaceStr, 0, this.size, 1);
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
/*      */   public StrBuilder replace(StrMatcher matcher, String replaceStr, int startIndex, int endIndex, int replaceCount) {
/* 2105 */     endIndex = validateRange(startIndex, endIndex);
/* 2106 */     return replaceImpl(matcher, replaceStr, startIndex, endIndex, replaceCount);
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
/*      */   private StrBuilder replaceImpl(StrMatcher matcher, String replaceStr, int from, int to, int replaceCount) {
/* 2127 */     if (matcher == null || this.size == 0) {
/* 2128 */       return this;
/*      */     }
/* 2130 */     int replaceLen = (replaceStr == null) ? 0 : replaceStr.length();
/* 2131 */     for (int i = from; i < to && replaceCount != 0; i++) {
/* 2132 */       char[] buf = this.buffer;
/* 2133 */       int removeLen = matcher.isMatch(buf, i, from, to);
/* 2134 */       if (removeLen > 0) {
/* 2135 */         replaceImpl(i, i + removeLen, removeLen, replaceStr, replaceLen);
/* 2136 */         to = to - removeLen + replaceLen;
/* 2137 */         i = i + replaceLen - 1;
/* 2138 */         if (replaceCount > 0) {
/* 2139 */           replaceCount--;
/*      */         }
/*      */       } 
/*      */     } 
/* 2143 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder reverse() {
/* 2153 */     if (this.size == 0) {
/* 2154 */       return this;
/*      */     }
/*      */     
/* 2157 */     int half = this.size / 2;
/* 2158 */     char[] buf = this.buffer;
/* 2159 */     for (int leftIdx = 0, rightIdx = this.size - 1; leftIdx < half; leftIdx++, rightIdx--) {
/* 2160 */       char swap = buf[leftIdx];
/* 2161 */       buf[leftIdx] = buf[rightIdx];
/* 2162 */       buf[rightIdx] = swap;
/*      */     } 
/* 2164 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrBuilder trim() {
/* 2175 */     if (this.size == 0) {
/* 2176 */       return this;
/*      */     }
/* 2178 */     int len = this.size;
/* 2179 */     char[] buf = this.buffer;
/* 2180 */     int pos = 0;
/* 2181 */     while (pos < len && buf[pos] <= ' ') {
/* 2182 */       pos++;
/*      */     }
/* 2184 */     while (pos < len && buf[len - 1] <= ' ') {
/* 2185 */       len--;
/*      */     }
/* 2187 */     if (len < this.size) {
/* 2188 */       delete(len, this.size);
/*      */     }
/* 2190 */     if (pos > 0) {
/* 2191 */       delete(0, pos);
/*      */     }
/* 2193 */     return this;
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
/*      */   public boolean startsWith(String str) {
/* 2206 */     if (str == null) {
/* 2207 */       return false;
/*      */     }
/* 2209 */     int len = str.length();
/* 2210 */     if (len == 0) {
/* 2211 */       return true;
/*      */     }
/* 2213 */     if (len > this.size) {
/* 2214 */       return false;
/*      */     }
/* 2216 */     for (int i = 0; i < len; i++) {
/* 2217 */       if (this.buffer[i] != str.charAt(i)) {
/* 2218 */         return false;
/*      */       }
/*      */     } 
/* 2221 */     return true;
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
/*      */   public boolean endsWith(String str) {
/* 2233 */     if (str == null) {
/* 2234 */       return false;
/*      */     }
/* 2236 */     int len = str.length();
/* 2237 */     if (len == 0) {
/* 2238 */       return true;
/*      */     }
/* 2240 */     if (len > this.size) {
/* 2241 */       return false;
/*      */     }
/* 2243 */     int pos = this.size - len;
/* 2244 */     for (int i = 0; i < len; i++, pos++) {
/* 2245 */       if (this.buffer[pos] != str.charAt(i)) {
/* 2246 */         return false;
/*      */       }
/*      */     } 
/* 2249 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CharSequence subSequence(int startIndex, int endIndex) {
/* 2259 */     if (startIndex < 0) {
/* 2260 */       throw new StringIndexOutOfBoundsException(startIndex);
/*      */     }
/* 2262 */     if (endIndex > this.size) {
/* 2263 */       throw new StringIndexOutOfBoundsException(endIndex);
/*      */     }
/* 2265 */     if (startIndex > endIndex) {
/* 2266 */       throw new StringIndexOutOfBoundsException(endIndex - startIndex);
/*      */     }
/* 2268 */     return substring(startIndex, endIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int start) {
/* 2279 */     return substring(start, this.size);
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
/*      */   public String substring(int startIndex, int endIndex) {
/* 2296 */     endIndex = validateRange(startIndex, endIndex);
/* 2297 */     return new String(this.buffer, startIndex, endIndex - startIndex);
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
/*      */   public String leftString(int length) {
/* 2313 */     if (length <= 0)
/* 2314 */       return ""; 
/* 2315 */     if (length >= this.size) {
/* 2316 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2318 */     return new String(this.buffer, 0, length);
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
/*      */   public String rightString(int length) {
/* 2335 */     if (length <= 0)
/* 2336 */       return ""; 
/* 2337 */     if (length >= this.size) {
/* 2338 */       return new String(this.buffer, 0, this.size);
/*      */     }
/* 2340 */     return new String(this.buffer, this.size - length, length);
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
/*      */   public String midString(int index, int length) {
/* 2361 */     if (index < 0) {
/* 2362 */       index = 0;
/*      */     }
/* 2364 */     if (length <= 0 || index >= this.size) {
/* 2365 */       return "";
/*      */     }
/* 2367 */     if (this.size <= index + length) {
/* 2368 */       return new String(this.buffer, index, this.size - index);
/*      */     }
/* 2370 */     return new String(this.buffer, index, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(char ch) {
/* 2381 */     char[] thisBuf = this.buffer;
/* 2382 */     for (int i = 0; i < this.size; i++) {
/* 2383 */       if (thisBuf[i] == ch) {
/* 2384 */         return true;
/*      */       }
/*      */     } 
/* 2387 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(String str) {
/* 2397 */     return (indexOf(str, 0) >= 0);
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
/*      */   public boolean contains(StrMatcher matcher) {
/* 2412 */     return (indexOf(matcher, 0) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char ch) {
/* 2423 */     return indexOf(ch, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(char ch, int startIndex) {
/* 2434 */     startIndex = Math.max(startIndex, 0);
/* 2435 */     if (startIndex >= this.size) {
/* 2436 */       return -1;
/*      */     }
/* 2438 */     char[] thisBuf = this.buffer;
/* 2439 */     for (int i = startIndex; i < this.size; i++) {
/* 2440 */       if (thisBuf[i] == ch) {
/* 2441 */         return i;
/*      */       }
/*      */     } 
/* 2444 */     return -1;
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
/*      */   public int indexOf(String str) {
/* 2456 */     return indexOf(str, 0);
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
/*      */   public int indexOf(String str, int startIndex) {
/* 2470 */     startIndex = Math.max(startIndex, 0);
/* 2471 */     if (str == null || startIndex >= this.size) {
/* 2472 */       return -1;
/*      */     }
/* 2474 */     int strLen = str.length();
/* 2475 */     if (strLen == 1) {
/* 2476 */       return indexOf(str.charAt(0), startIndex);
/*      */     }
/* 2478 */     if (strLen == 0) {
/* 2479 */       return startIndex;
/*      */     }
/* 2481 */     if (strLen > this.size) {
/* 2482 */       return -1;
/*      */     }
/* 2484 */     char[] thisBuf = this.buffer;
/* 2485 */     int len = this.size - strLen + 1;
/*      */     
/* 2487 */     for (int i = startIndex; i < len; i++) {
/* 2488 */       int j = 0; while (true) { if (j < strLen) {
/* 2489 */           if (str.charAt(j) != thisBuf[i + j])
/*      */             break;  j++;
/*      */           continue;
/*      */         } 
/* 2493 */         return i; }
/*      */     
/* 2495 */     }  return -1;
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
/*      */   public int indexOf(StrMatcher matcher) {
/* 2509 */     return indexOf(matcher, 0);
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
/*      */   public int indexOf(StrMatcher matcher, int startIndex) {
/* 2525 */     startIndex = Math.max(startIndex, 0);
/* 2526 */     if (matcher == null || startIndex >= this.size) {
/* 2527 */       return -1;
/*      */     }
/* 2529 */     int len = this.size;
/* 2530 */     char[] buf = this.buffer;
/* 2531 */     for (int i = startIndex; i < len; i++) {
/* 2532 */       if (matcher.isMatch(buf, i, startIndex, len) > 0) {
/* 2533 */         return i;
/*      */       }
/*      */     } 
/* 2536 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char ch) {
/* 2547 */     return lastIndexOf(ch, this.size - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int lastIndexOf(char ch, int startIndex) {
/* 2558 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2559 */     if (startIndex < 0) {
/* 2560 */       return -1;
/*      */     }
/* 2562 */     for (int i = startIndex; i >= 0; i--) {
/* 2563 */       if (this.buffer[i] == ch) {
/* 2564 */         return i;
/*      */       }
/*      */     } 
/* 2567 */     return -1;
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
/*      */   public int lastIndexOf(String str) {
/* 2579 */     return lastIndexOf(str, this.size - 1);
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
/*      */   public int lastIndexOf(String str, int startIndex) {
/* 2593 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2594 */     if (str == null || startIndex < 0) {
/* 2595 */       return -1;
/*      */     }
/* 2597 */     int strLen = str.length();
/* 2598 */     if (strLen > 0 && strLen <= this.size) {
/* 2599 */       if (strLen == 1) {
/* 2600 */         return lastIndexOf(str.charAt(0), startIndex);
/*      */       }
/*      */ 
/*      */       
/* 2604 */       for (int i = startIndex - strLen + 1; i >= 0; i--) {
/* 2605 */         int j = 0; while (true) { if (j < strLen) {
/* 2606 */             if (str.charAt(j) != this.buffer[i + j])
/*      */               break;  j++;
/*      */             continue;
/*      */           } 
/* 2610 */           return i; }
/*      */       
/*      */       } 
/* 2613 */     } else if (strLen == 0) {
/* 2614 */       return startIndex;
/*      */     } 
/* 2616 */     return -1;
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
/*      */   public int lastIndexOf(StrMatcher matcher) {
/* 2630 */     return lastIndexOf(matcher, this.size);
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
/*      */   public int lastIndexOf(StrMatcher matcher, int startIndex) {
/* 2646 */     startIndex = (startIndex >= this.size) ? (this.size - 1) : startIndex;
/* 2647 */     if (matcher == null || startIndex < 0) {
/* 2648 */       return -1;
/*      */     }
/* 2650 */     char[] buf = this.buffer;
/* 2651 */     int endIndex = startIndex + 1;
/* 2652 */     for (int i = startIndex; i >= 0; i--) {
/* 2653 */       if (matcher.isMatch(buf, i, 0, endIndex) > 0) {
/* 2654 */         return i;
/*      */       }
/*      */     } 
/* 2657 */     return -1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrTokenizer asTokenizer() {
/* 2694 */     return new StrBuilderTokenizer();
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
/*      */   public Reader asReader() {
/* 2718 */     return new StrBuilderReader();
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
/*      */   
/*      */   public Writer asWriter() {
/* 2743 */     return new StrBuilderWriter();
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
/*      */   public void appendTo(Appendable appendable) throws IOException {
/* 2759 */     if (appendable instanceof Writer) {
/* 2760 */       ((Writer)appendable).write(this.buffer, 0, this.size);
/* 2761 */     } else if (appendable instanceof StringBuilder) {
/* 2762 */       ((StringBuilder)appendable).append(this.buffer, 0, this.size);
/* 2763 */     } else if (appendable instanceof StringBuffer) {
/* 2764 */       ((StringBuffer)appendable).append(this.buffer, 0, this.size);
/* 2765 */     } else if (appendable instanceof CharBuffer) {
/* 2766 */       ((CharBuffer)appendable).put(this.buffer, 0, this.size);
/*      */     } else {
/* 2768 */       appendable.append(this);
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
/*      */   public boolean equalsIgnoreCase(StrBuilder other) {
/* 2780 */     if (this == other) {
/* 2781 */       return true;
/*      */     }
/* 2783 */     if (this.size != other.size) {
/* 2784 */       return false;
/*      */     }
/* 2786 */     char[] thisBuf = this.buffer;
/* 2787 */     char[] otherBuf = other.buffer;
/* 2788 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2789 */       char c1 = thisBuf[i];
/* 2790 */       char c2 = otherBuf[i];
/* 2791 */       if (c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
/* 2792 */         return false;
/*      */       }
/*      */     } 
/* 2795 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(StrBuilder other) {
/* 2806 */     if (this == other) {
/* 2807 */       return true;
/*      */     }
/* 2809 */     if (other == null) {
/* 2810 */       return false;
/*      */     }
/* 2812 */     if (this.size != other.size) {
/* 2813 */       return false;
/*      */     }
/* 2815 */     char[] thisBuf = this.buffer;
/* 2816 */     char[] otherBuf = other.buffer;
/* 2817 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2818 */       if (thisBuf[i] != otherBuf[i]) {
/* 2819 */         return false;
/*      */       }
/*      */     } 
/* 2822 */     return true;
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
/*      */   public boolean equals(Object obj) {
/* 2834 */     return (obj instanceof StrBuilder && equals((StrBuilder)obj));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 2844 */     char[] buf = this.buffer;
/* 2845 */     int hash = 0;
/* 2846 */     for (int i = this.size - 1; i >= 0; i--) {
/* 2847 */       hash = 31 * hash + buf[i];
/*      */     }
/* 2849 */     return hash;
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
/*      */   public String toString() {
/* 2864 */     return new String(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer toStringBuffer() {
/* 2874 */     return (new StringBuffer(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder toStringBuilder() {
/* 2885 */     return (new StringBuilder(this.size)).append(this.buffer, 0, this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String build() {
/* 2896 */     return toString();
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
/*      */   protected int validateRange(int startIndex, int endIndex) {
/* 2910 */     if (startIndex < 0) {
/* 2911 */       throw new StringIndexOutOfBoundsException(startIndex);
/*      */     }
/* 2913 */     if (endIndex > this.size) {
/* 2914 */       endIndex = this.size;
/*      */     }
/* 2916 */     if (startIndex > endIndex) {
/* 2917 */       throw new StringIndexOutOfBoundsException("end < start");
/*      */     }
/* 2919 */     return endIndex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void validateIndex(int index) {
/* 2929 */     if (index < 0 || index > this.size) {
/* 2930 */       throw new StringIndexOutOfBoundsException(index);
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
/*      */   class StrBuilderTokenizer
/*      */     extends StrTokenizer
/*      */   {
/*      */     protected List<String> tokenize(char[] chars, int offset, int count) {
/* 2949 */       if (chars == null) {
/* 2950 */         return super.tokenize(StrBuilder.this.buffer, 0, StrBuilder.this.size());
/*      */       }
/* 2952 */       return super.tokenize(chars, offset, count);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getContent() {
/* 2958 */       String str = super.getContent();
/* 2959 */       if (str == null) {
/* 2960 */         return StrBuilder.this.toString();
/*      */       }
/* 2962 */       return str;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class StrBuilderReader
/*      */     extends Reader
/*      */   {
/*      */     private int pos;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int mark;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() {
/* 2991 */       if (!ready()) {
/* 2992 */         return -1;
/*      */       }
/* 2994 */       return StrBuilder.this.charAt(this.pos++);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read(char[] b, int off, int len) {
/* 3000 */       if (off < 0 || len < 0 || off > b.length || off + len > b.length || off + len < 0)
/*      */       {
/* 3002 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 3004 */       if (len == 0) {
/* 3005 */         return 0;
/*      */       }
/* 3007 */       if (this.pos >= StrBuilder.this.size()) {
/* 3008 */         return -1;
/*      */       }
/* 3010 */       if (this.pos + len > StrBuilder.this.size()) {
/* 3011 */         len = StrBuilder.this.size() - this.pos;
/*      */       }
/* 3013 */       StrBuilder.this.getChars(this.pos, this.pos + len, b, off);
/* 3014 */       this.pos += len;
/* 3015 */       return len;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public long skip(long n) {
/* 3021 */       if (this.pos + n > StrBuilder.this.size()) {
/* 3022 */         n = (StrBuilder.this.size() - this.pos);
/*      */       }
/* 3024 */       if (n < 0L) {
/* 3025 */         return 0L;
/*      */       }
/* 3027 */       this.pos = (int)(this.pos + n);
/* 3028 */       return n;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean ready() {
/* 3034 */       return (this.pos < StrBuilder.this.size());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean markSupported() {
/* 3040 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(int readAheadLimit) {
/* 3046 */       this.mark = this.pos;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void reset() {
/* 3052 */       this.pos = this.mark;
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
/*      */   class StrBuilderWriter
/*      */     extends Writer
/*      */   {
/*      */     public void close() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void flush() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(int c) {
/* 3083 */       StrBuilder.this.append((char)c);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] cbuf) {
/* 3089 */       StrBuilder.this.append(cbuf);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(char[] cbuf, int off, int len) {
/* 3095 */       StrBuilder.this.append(cbuf, off, len);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String str) {
/* 3101 */       StrBuilder.this.append(str);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(String str, int off, int len) {
/* 3107 */       StrBuilder.this.append(str, off, len);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\StrBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */