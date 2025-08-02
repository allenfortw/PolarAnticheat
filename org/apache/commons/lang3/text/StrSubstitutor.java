/*      */ package org.apache.commons.lang3.text;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class StrSubstitutor
/*      */ {
/*      */   public static final char DEFAULT_ESCAPE = '$';
/*  138 */   public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
/*      */ 
/*      */ 
/*      */   
/*  142 */   public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  147 */   public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char escapeChar;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher prefixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher suffixMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrMatcher valueDelimiterMatcher;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private StrLookup<?> variableResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean enableSubstitutionInVariables;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean preserveEscapes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> String replace(Object source, Map<String, V> valueMap) {
/*  189 */     return (new StrSubstitutor(valueMap)).replace(source);
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
/*      */   public static <V> String replace(Object source, Map<String, V> valueMap, String prefix, String suffix) {
/*  206 */     return (new StrSubstitutor(valueMap, prefix, suffix)).replace(source);
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
/*      */   public static String replace(Object source, Properties valueProperties) {
/*  218 */     if (valueProperties == null) {
/*  219 */       return source.toString();
/*      */     }
/*  221 */     Map<String, String> valueMap = new HashMap<>();
/*  222 */     Enumeration<?> propNames = valueProperties.propertyNames();
/*  223 */     while (propNames.hasMoreElements()) {
/*  224 */       String propName = (String)propNames.nextElement();
/*  225 */       String propValue = valueProperties.getProperty(propName);
/*  226 */       valueMap.put(propName, propValue);
/*      */     } 
/*  228 */     return replace(source, valueMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceSystemProperties(Object source) {
/*  239 */     return (new StrSubstitutor(StrLookup.systemPropertiesLookup())).replace(source);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor() {
/*  248 */     this((StrLookup<?>)null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <V> StrSubstitutor(Map<String, V> valueMap) {
/*  259 */     this(StrLookup.mapLookup(valueMap), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*      */   public <V> StrSubstitutor(Map<String, V> valueMap, String prefix, String suffix) {
/*  272 */     this(StrLookup.mapLookup(valueMap), prefix, suffix, '$');
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
/*      */   public <V> StrSubstitutor(Map<String, V> valueMap, String prefix, String suffix, char escape) {
/*  287 */     this(StrLookup.mapLookup(valueMap), prefix, suffix, escape);
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
/*      */   public <V> StrSubstitutor(Map<String, V> valueMap, String prefix, String suffix, char escape, String valueDelimiter) {
/*  304 */     this(StrLookup.mapLookup(valueMap), prefix, suffix, escape, valueDelimiter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrSubstitutor(StrLookup<?> variableResolver) {
/*  313 */     this(variableResolver, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
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
/*      */   public StrSubstitutor(StrLookup<?> variableResolver, String prefix, String suffix, char escape) {
/*  327 */     setVariableResolver(variableResolver);
/*  328 */     setVariablePrefix(prefix);
/*  329 */     setVariableSuffix(suffix);
/*  330 */     setEscapeChar(escape);
/*  331 */     setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
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
/*      */   public StrSubstitutor(StrLookup<?> variableResolver, String prefix, String suffix, char escape, String valueDelimiter) {
/*  347 */     setVariableResolver(variableResolver);
/*  348 */     setVariablePrefix(prefix);
/*  349 */     setVariableSuffix(suffix);
/*  350 */     setEscapeChar(escape);
/*  351 */     setValueDelimiter(valueDelimiter);
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
/*      */   public StrSubstitutor(StrLookup<?> variableResolver, StrMatcher prefixMatcher, StrMatcher suffixMatcher, char escape) {
/*  366 */     this(variableResolver, prefixMatcher, suffixMatcher, escape, DEFAULT_VALUE_DELIMITER);
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
/*      */   public StrSubstitutor(StrLookup<?> variableResolver, StrMatcher prefixMatcher, StrMatcher suffixMatcher, char escape, StrMatcher valueDelimiterMatcher) {
/*  383 */     setVariableResolver(variableResolver);
/*  384 */     setVariablePrefixMatcher(prefixMatcher);
/*  385 */     setVariableSuffixMatcher(suffixMatcher);
/*  386 */     setEscapeChar(escape);
/*  387 */     setValueDelimiterMatcher(valueDelimiterMatcher);
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
/*      */   public String replace(String source) {
/*  399 */     if (source == null) {
/*  400 */       return null;
/*      */     }
/*  402 */     StrBuilder buf = new StrBuilder(source);
/*  403 */     if (!substitute(buf, 0, source.length())) {
/*  404 */       return source;
/*      */     }
/*  406 */     return buf.toString();
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
/*      */   public String replace(String source, int offset, int length) {
/*  422 */     if (source == null) {
/*  423 */       return null;
/*      */     }
/*  425 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  426 */     if (!substitute(buf, 0, length)) {
/*  427 */       return source.substring(offset, offset + length);
/*      */     }
/*  429 */     return buf.toString();
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
/*      */   public String replace(char[] source) {
/*  442 */     if (source == null) {
/*  443 */       return null;
/*      */     }
/*  445 */     StrBuilder buf = (new StrBuilder(source.length)).append(source);
/*  446 */     substitute(buf, 0, source.length);
/*  447 */     return buf.toString();
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
/*      */   public String replace(char[] source, int offset, int length) {
/*  464 */     if (source == null) {
/*  465 */       return null;
/*      */     }
/*  467 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  468 */     substitute(buf, 0, length);
/*  469 */     return buf.toString();
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
/*      */   public String replace(StringBuffer source) {
/*  482 */     if (source == null) {
/*  483 */       return null;
/*      */     }
/*  485 */     StrBuilder buf = (new StrBuilder(source.length())).append(source);
/*  486 */     substitute(buf, 0, buf.length());
/*  487 */     return buf.toString();
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
/*      */   public String replace(StringBuffer source, int offset, int length) {
/*  504 */     if (source == null) {
/*  505 */       return null;
/*      */     }
/*  507 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  508 */     substitute(buf, 0, length);
/*  509 */     return buf.toString();
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
/*      */   public String replace(CharSequence source) {
/*  522 */     if (source == null) {
/*  523 */       return null;
/*      */     }
/*  525 */     return replace(source, 0, source.length());
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
/*      */   public String replace(CharSequence source, int offset, int length) {
/*  543 */     if (source == null) {
/*  544 */       return null;
/*      */     }
/*  546 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  547 */     substitute(buf, 0, length);
/*  548 */     return buf.toString();
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
/*      */   public String replace(StrBuilder source) {
/*  561 */     if (source == null) {
/*  562 */       return null;
/*      */     }
/*  564 */     StrBuilder buf = (new StrBuilder(source.length())).append(source);
/*  565 */     substitute(buf, 0, buf.length());
/*  566 */     return buf.toString();
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
/*      */   public String replace(StrBuilder source, int offset, int length) {
/*  583 */     if (source == null) {
/*  584 */       return null;
/*      */     }
/*  586 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  587 */     substitute(buf, 0, length);
/*  588 */     return buf.toString();
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
/*      */   public String replace(Object source) {
/*  601 */     if (source == null) {
/*  602 */       return null;
/*      */     }
/*  604 */     StrBuilder buf = (new StrBuilder()).append(source);
/*  605 */     substitute(buf, 0, buf.length());
/*  606 */     return buf.toString();
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
/*      */   public boolean replaceIn(StringBuffer source) {
/*  619 */     if (source == null) {
/*  620 */       return false;
/*      */     }
/*  622 */     return replaceIn(source, 0, source.length());
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
/*      */   public boolean replaceIn(StringBuffer source, int offset, int length) {
/*  639 */     if (source == null) {
/*  640 */       return false;
/*      */     }
/*  642 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  643 */     if (!substitute(buf, 0, length)) {
/*  644 */       return false;
/*      */     }
/*  646 */     source.replace(offset, offset + length, buf.toString());
/*  647 */     return true;
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
/*      */   public boolean replaceIn(StringBuilder source) {
/*  661 */     if (source == null) {
/*  662 */       return false;
/*      */     }
/*  664 */     return replaceIn(source, 0, source.length());
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
/*      */   public boolean replaceIn(StringBuilder source, int offset, int length) {
/*  682 */     if (source == null) {
/*  683 */       return false;
/*      */     }
/*  685 */     StrBuilder buf = (new StrBuilder(length)).append(source, offset, length);
/*  686 */     if (!substitute(buf, 0, length)) {
/*  687 */       return false;
/*      */     }
/*  689 */     source.replace(offset, offset + length, buf.toString());
/*  690 */     return true;
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
/*      */   public boolean replaceIn(StrBuilder source) {
/*  702 */     if (source == null) {
/*  703 */       return false;
/*      */     }
/*  705 */     return substitute(source, 0, source.length());
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
/*      */   public boolean replaceIn(StrBuilder source, int offset, int length) {
/*  721 */     if (source == null) {
/*  722 */       return false;
/*      */     }
/*  724 */     return substitute(source, offset, length);
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
/*      */   protected boolean substitute(StrBuilder buf, int offset, int length) {
/*  743 */     return (substitute(buf, offset, length, null) > 0);
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
/*      */   private int substitute(StrBuilder buf, int offset, int length, List<String> priorVariables) {
/*  759 */     StrMatcher pfxMatcher = getVariablePrefixMatcher();
/*  760 */     StrMatcher suffMatcher = getVariableSuffixMatcher();
/*  761 */     char escape = getEscapeChar();
/*  762 */     StrMatcher valueDelimMatcher = getValueDelimiterMatcher();
/*  763 */     boolean substitutionInVariablesEnabled = isEnableSubstitutionInVariables();
/*      */     
/*  765 */     boolean top = (priorVariables == null);
/*  766 */     boolean altered = false;
/*  767 */     int lengthChange = 0;
/*  768 */     char[] chars = buf.buffer;
/*  769 */     int bufEnd = offset + length;
/*  770 */     int pos = offset;
/*  771 */     while (pos < bufEnd) {
/*  772 */       int startMatchLen = pfxMatcher.isMatch(chars, pos, offset, bufEnd);
/*      */       
/*  774 */       if (startMatchLen == 0) {
/*  775 */         pos++; continue;
/*      */       } 
/*  777 */       if (pos > offset && chars[pos - 1] == escape) {
/*      */         
/*  779 */         if (this.preserveEscapes) {
/*  780 */           pos++;
/*      */           continue;
/*      */         } 
/*  783 */         buf.deleteCharAt(pos - 1);
/*  784 */         chars = buf.buffer;
/*  785 */         lengthChange--;
/*  786 */         altered = true;
/*  787 */         bufEnd--;
/*      */         continue;
/*      */       } 
/*  790 */       int startPos = pos;
/*  791 */       pos += startMatchLen;
/*  792 */       int endMatchLen = 0;
/*  793 */       int nestedVarCount = 0;
/*  794 */       while (pos < bufEnd) {
/*  795 */         if (substitutionInVariablesEnabled && (
/*  796 */           endMatchLen = pfxMatcher.isMatch(chars, pos, offset, bufEnd)) != 0) {
/*      */ 
/*      */           
/*  799 */           nestedVarCount++;
/*  800 */           pos += endMatchLen;
/*      */           
/*      */           continue;
/*      */         } 
/*  804 */         endMatchLen = suffMatcher.isMatch(chars, pos, offset, bufEnd);
/*      */         
/*  806 */         if (endMatchLen == 0) {
/*  807 */           pos++;
/*      */           continue;
/*      */         } 
/*  810 */         if (nestedVarCount == 0) {
/*  811 */           String varNameExpr = new String(chars, startPos + startMatchLen, pos - startPos - startMatchLen);
/*      */ 
/*      */           
/*  814 */           if (substitutionInVariablesEnabled) {
/*  815 */             StrBuilder bufName = new StrBuilder(varNameExpr);
/*  816 */             substitute(bufName, 0, bufName.length());
/*  817 */             varNameExpr = bufName.toString();
/*      */           } 
/*  819 */           pos += endMatchLen;
/*  820 */           int endPos = pos;
/*      */           
/*  822 */           String varName = varNameExpr;
/*  823 */           String varDefaultValue = null;
/*      */           
/*  825 */           if (valueDelimMatcher != null) {
/*  826 */             char[] varNameExprChars = varNameExpr.toCharArray();
/*  827 */             int valueDelimiterMatchLen = 0;
/*  828 */             for (int i = 0; i < varNameExprChars.length; i++) {
/*      */               
/*  830 */               if (!substitutionInVariablesEnabled && pfxMatcher
/*  831 */                 .isMatch(varNameExprChars, i, i, varNameExprChars.length) != 0) {
/*      */                 break;
/*      */               }
/*  834 */               if ((valueDelimiterMatchLen = valueDelimMatcher.isMatch(varNameExprChars, i)) != 0) {
/*  835 */                 varName = varNameExpr.substring(0, i);
/*  836 */                 varDefaultValue = varNameExpr.substring(i + valueDelimiterMatchLen);
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  843 */           if (priorVariables == null) {
/*  844 */             priorVariables = new ArrayList<>();
/*  845 */             priorVariables.add(new String(chars, offset, length));
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  850 */           checkCyclicSubstitution(varName, priorVariables);
/*  851 */           priorVariables.add(varName);
/*      */ 
/*      */           
/*  854 */           String varValue = resolveVariable(varName, buf, startPos, endPos);
/*      */           
/*  856 */           if (varValue == null) {
/*  857 */             varValue = varDefaultValue;
/*      */           }
/*  859 */           if (varValue != null) {
/*      */             
/*  861 */             int varLen = varValue.length();
/*  862 */             buf.replace(startPos, endPos, varValue);
/*  863 */             altered = true;
/*  864 */             int change = substitute(buf, startPos, varLen, priorVariables);
/*      */             
/*  866 */             change = change + varLen - endPos - startPos;
/*      */             
/*  868 */             pos += change;
/*  869 */             bufEnd += change;
/*  870 */             lengthChange += change;
/*  871 */             chars = buf.buffer;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  876 */           priorVariables
/*  877 */             .remove(priorVariables.size() - 1);
/*      */           break;
/*      */         } 
/*  880 */         nestedVarCount--;
/*  881 */         pos += endMatchLen;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  886 */     if (top) {
/*  887 */       return altered ? 1 : 0;
/*      */     }
/*  889 */     return lengthChange;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkCyclicSubstitution(String varName, List<String> priorVariables) {
/*  899 */     if (!priorVariables.contains(varName)) {
/*      */       return;
/*      */     }
/*  902 */     StrBuilder buf = new StrBuilder(256);
/*  903 */     buf.append("Infinite loop in property interpolation of ");
/*  904 */     buf.append(priorVariables.remove(0));
/*  905 */     buf.append(": ");
/*  906 */     buf.appendWithSeparators(priorVariables, "->");
/*  907 */     throw new IllegalStateException(buf.toString());
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
/*      */   protected String resolveVariable(String variableName, StrBuilder buf, int startPos, int endPos) {
/*  928 */     StrLookup<?> resolver = getVariableResolver();
/*  929 */     if (resolver == null) {
/*  930 */       return null;
/*      */     }
/*  932 */     return resolver.lookup(variableName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char getEscapeChar() {
/*  943 */     return this.escapeChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEscapeChar(char escapeCharacter) {
/*  954 */     this.escapeChar = escapeCharacter;
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
/*      */   public StrMatcher getVariablePrefixMatcher() {
/*  969 */     return this.prefixMatcher;
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
/*      */   public StrSubstitutor setVariablePrefixMatcher(StrMatcher prefixMatcher) {
/*  984 */     if (prefixMatcher == null) {
/*  985 */       throw new IllegalArgumentException("Variable prefix matcher must not be null.");
/*      */     }
/*  987 */     this.prefixMatcher = prefixMatcher;
/*  988 */     return this;
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
/*      */   public StrSubstitutor setVariablePrefix(char prefix) {
/* 1002 */     return setVariablePrefixMatcher(StrMatcher.charMatcher(prefix));
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
/*      */   public StrSubstitutor setVariablePrefix(String prefix) {
/* 1016 */     if (prefix == null) {
/* 1017 */       throw new IllegalArgumentException("Variable prefix must not be null.");
/*      */     }
/* 1019 */     return setVariablePrefixMatcher(StrMatcher.stringMatcher(prefix));
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
/*      */   public StrMatcher getVariableSuffixMatcher() {
/* 1034 */     return this.suffixMatcher;
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
/*      */   public StrSubstitutor setVariableSuffixMatcher(StrMatcher suffixMatcher) {
/* 1049 */     if (suffixMatcher == null) {
/* 1050 */       throw new IllegalArgumentException("Variable suffix matcher must not be null.");
/*      */     }
/* 1052 */     this.suffixMatcher = suffixMatcher;
/* 1053 */     return this;
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
/*      */   public StrSubstitutor setVariableSuffix(char suffix) {
/* 1067 */     return setVariableSuffixMatcher(StrMatcher.charMatcher(suffix));
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
/*      */   public StrSubstitutor setVariableSuffix(String suffix) {
/* 1081 */     if (suffix == null) {
/* 1082 */       throw new IllegalArgumentException("Variable suffix must not be null.");
/*      */     }
/* 1084 */     return setVariableSuffixMatcher(StrMatcher.stringMatcher(suffix));
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
/*      */   public StrMatcher getValueDelimiterMatcher() {
/* 1102 */     return this.valueDelimiterMatcher;
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
/*      */   public StrSubstitutor setValueDelimiterMatcher(StrMatcher valueDelimiterMatcher) {
/* 1120 */     this.valueDelimiterMatcher = valueDelimiterMatcher;
/* 1121 */     return this;
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
/*      */   public StrSubstitutor setValueDelimiter(char valueDelimiter) {
/* 1136 */     return setValueDelimiterMatcher(StrMatcher.charMatcher(valueDelimiter));
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
/*      */   public StrSubstitutor setValueDelimiter(String valueDelimiter) {
/* 1154 */     if (StringUtils.isEmpty(valueDelimiter)) {
/* 1155 */       setValueDelimiterMatcher(null);
/* 1156 */       return this;
/*      */     } 
/* 1158 */     return setValueDelimiterMatcher(StrMatcher.stringMatcher(valueDelimiter));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StrLookup<?> getVariableResolver() {
/* 1169 */     return this.variableResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVariableResolver(StrLookup<?> variableResolver) {
/* 1178 */     this.variableResolver = variableResolver;
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
/*      */   public boolean isEnableSubstitutionInVariables() {
/* 1190 */     return this.enableSubstitutionInVariables;
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
/*      */   public void setEnableSubstitutionInVariables(boolean enableSubstitutionInVariables) {
/* 1204 */     this.enableSubstitutionInVariables = enableSubstitutionInVariables;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPreserveEscapes() {
/* 1215 */     return this.preserveEscapes;
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
/*      */   public void setPreserveEscapes(boolean preserveEscapes) {
/* 1231 */     this.preserveEscapes = preserveEscapes;
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\StrSubstitutor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */