/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public enum DefaultFontInfo {
/*   6 */   A('A', 5),
/*   7 */   a('a', 5),
/*   8 */   B('B', 5),
/*   9 */   b('b', 5),
/*  10 */   C('C', 5),
/*  11 */   c('c', 5),
/*  12 */   D('D', 5),
/*  13 */   d('d', 5),
/*  14 */   E('E', 5),
/*  15 */   e('e', 5),
/*  16 */   F('F', 5),
/*  17 */   f('f', 4),
/*  18 */   G('G', 5),
/*  19 */   g('g', 5),
/*  20 */   H('H', 5),
/*  21 */   h('h', 5),
/*  22 */   I('I', 3),
/*  23 */   i('i', 1),
/*  24 */   J('J', 5),
/*  25 */   j('j', 5),
/*  26 */   K('K', 5),
/*  27 */   k('k', 4),
/*  28 */   L('L', 5),
/*  29 */   l('l', 1),
/*  30 */   M('M', 5),
/*  31 */   m('m', 5),
/*  32 */   N('N', 5),
/*  33 */   n('n', 5),
/*  34 */   O('O', 5),
/*  35 */   o('o', 5),
/*  36 */   P('P', 5),
/*  37 */   p('p', 5),
/*  38 */   Q('Q', 5),
/*  39 */   q('q', 5),
/*  40 */   R('R', 5),
/*  41 */   r('r', 5),
/*  42 */   S('S', 5),
/*  43 */   s('s', 5),
/*  44 */   T('T', 5),
/*  45 */   t('t', 4),
/*  46 */   U('U', 5),
/*  47 */   u('u', 5),
/*  48 */   V('V', 5),
/*  49 */   v('v', 5),
/*  50 */   W('W', 5),
/*  51 */   w('w', 5),
/*  52 */   X('X', 5),
/*  53 */   x('x', 5),
/*  54 */   Y('Y', 5),
/*  55 */   y('y', 5),
/*  56 */   Z('Z', 5),
/*  57 */   z('z', 5),
/*  58 */   NUM_1('1', 5),
/*  59 */   NUM_2('2', 5),
/*  60 */   NUM_3('3', 5),
/*  61 */   NUM_4('4', 5),
/*  62 */   NUM_5('5', 5),
/*  63 */   NUM_6('6', 5),
/*  64 */   NUM_7('7', 5),
/*  65 */   NUM_8('8', 5),
/*  66 */   NUM_9('9', 5),
/*  67 */   NUM_0('0', 5),
/*  68 */   EXCLAMATION_POINT('!', 1),
/*  69 */   AT_SYMBOL('@', 6),
/*  70 */   NUM_SIGN('#', 5),
/*  71 */   DOLLAR_SIGN('$', 5),
/*  72 */   PERCENT('%', 5),
/*  73 */   UP_ARROW('^', 5),
/*  74 */   AMPERSAND('&', 5),
/*  75 */   ASTERISK('*', 5),
/*  76 */   LEFT_PARENTHESIS('(', 4),
/*  77 */   RIGHT_PERENTHESIS(')', 4),
/*  78 */   MINUS('-', 5),
/*  79 */   UNDERSCORE('_', 5),
/*  80 */   PLUS_SIGN('+', 5),
/*  81 */   EQUALS_SIGN('=', 5),
/*  82 */   LEFT_CURL_BRACE('{', 4),
/*  83 */   RIGHT_CURL_BRACE('}', 4),
/*  84 */   LEFT_BRACKET('[', 3),
/*  85 */   RIGHT_BRACKET(']', 3),
/*  86 */   COLON(':', 1),
/*  87 */   SEMI_COLON(';', 1),
/*  88 */   DOUBLE_QUOTE('"', 3),
/*  89 */   SINGLE_QUOTE('\'', 1),
/*  90 */   LEFT_ARROW('<', 4),
/*  91 */   RIGHT_ARROW('>', 4),
/*  92 */   QUESTION_MARK('?', 5),
/*  93 */   SLASH('/', 5),
/*  94 */   BACK_SLASH('\\', 5),
/*  95 */   LINE('|', 1),
/*  96 */   TILDE('~', 5),
/*  97 */   TICK('`', 2),
/*  98 */   PERIOD('.', 1),
/*  99 */   COMMA(',', 1),
/* 100 */   SPACE(' ', 3),
/* 101 */   DEFAULT('a', 4);
/*     */   
/*     */   private final char character;
/*     */   private final int length;
/*     */   
/*     */   DefaultFontInfo(char character, int length) {
/* 107 */     this.character = character;
/* 108 */     this.length = length;
/*     */   }
/*     */   
/*     */   public static DefaultFontInfo getDefaultFontInfo(char c) {
/* 112 */     return Arrays.<DefaultFontInfo>stream(values())
/* 113 */       .filter(d -> (d.getCharacter() == c))
/* 114 */       .findAny().orElse(DEFAULT);
/*     */   }
/*     */   
/*     */   public char getCharacter() {
/* 118 */     return this.character;
/*     */   }
/*     */   
/*     */   public int getLength() {
/* 122 */     return this.length;
/*     */   }
/*     */   
/*     */   public int getBoldLength() {
/* 126 */     if (this == SPACE) {
/* 127 */       return getLength();
/*     */     }
/*     */     
/* 130 */     return this.length + 1;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\DefaultFontInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */