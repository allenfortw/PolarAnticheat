/*     */ package org.apache.commons.lang3.builder;
/*     */ 
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultilineRecursiveToStringStyle
/*     */   extends RecursiveToStringStyle
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final int INDENT = 2;
/*  76 */   private int spaces = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultilineRecursiveToStringStyle() {
/*  82 */     resetIndent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetIndent() {
/*  90 */     setArrayStart("{" + System.lineSeparator() + spacer(this.spaces));
/*  91 */     setArraySeparator("," + System.lineSeparator() + spacer(this.spaces));
/*  92 */     setArrayEnd(System.lineSeparator() + spacer(this.spaces - 2) + "}");
/*     */     
/*  94 */     setContentStart("[" + System.lineSeparator() + spacer(this.spaces));
/*  95 */     setFieldSeparator("," + System.lineSeparator() + spacer(this.spaces));
/*  96 */     setContentEnd(System.lineSeparator() + spacer(this.spaces - 2) + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StringBuilder spacer(int spaces) {
/* 106 */     StringBuilder sb = new StringBuilder();
/* 107 */     for (int i = 0; i < spaces; i++) {
/* 108 */       sb.append(" ");
/*     */     }
/* 110 */     return sb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendDetail(StringBuffer buffer, String fieldName, Object value) {
/* 115 */     if (!ClassUtils.isPrimitiveWrapper(value.getClass()) && !String.class.equals(value.getClass()) && 
/* 116 */       accept(value.getClass())) {
/* 117 */       this.spaces += 2;
/* 118 */       resetIndent();
/* 119 */       buffer.append(ReflectionToStringBuilder.toString(value, this));
/* 120 */       this.spaces -= 2;
/* 121 */       resetIndent();
/*     */     } else {
/* 123 */       super.appendDetail(buffer, fieldName, value);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, Object[] array) {
/* 129 */     this.spaces += 2;
/* 130 */     resetIndent();
/* 131 */     super.appendDetail(buffer, fieldName, array);
/* 132 */     this.spaces -= 2;
/* 133 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void reflectionAppendArrayDetail(StringBuffer buffer, String fieldName, Object array) {
/* 138 */     this.spaces += 2;
/* 139 */     resetIndent();
/* 140 */     super.reflectionAppendArrayDetail(buffer, fieldName, array);
/* 141 */     this.spaces -= 2;
/* 142 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, long[] array) {
/* 147 */     this.spaces += 2;
/* 148 */     resetIndent();
/* 149 */     super.appendDetail(buffer, fieldName, array);
/* 150 */     this.spaces -= 2;
/* 151 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
/* 156 */     this.spaces += 2;
/* 157 */     resetIndent();
/* 158 */     super.appendDetail(buffer, fieldName, array);
/* 159 */     this.spaces -= 2;
/* 160 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, short[] array) {
/* 165 */     this.spaces += 2;
/* 166 */     resetIndent();
/* 167 */     super.appendDetail(buffer, fieldName, array);
/* 168 */     this.spaces -= 2;
/* 169 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
/* 174 */     this.spaces += 2;
/* 175 */     resetIndent();
/* 176 */     super.appendDetail(buffer, fieldName, array);
/* 177 */     this.spaces -= 2;
/* 178 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, char[] array) {
/* 183 */     this.spaces += 2;
/* 184 */     resetIndent();
/* 185 */     super.appendDetail(buffer, fieldName, array);
/* 186 */     this.spaces -= 2;
/* 187 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, double[] array) {
/* 192 */     this.spaces += 2;
/* 193 */     resetIndent();
/* 194 */     super.appendDetail(buffer, fieldName, array);
/* 195 */     this.spaces -= 2;
/* 196 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, float[] array) {
/* 201 */     this.spaces += 2;
/* 202 */     resetIndent();
/* 203 */     super.appendDetail(buffer, fieldName, array);
/* 204 */     this.spaces -= 2;
/* 205 */     resetIndent();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendDetail(StringBuffer buffer, String fieldName, boolean[] array) {
/* 210 */     this.spaces += 2;
/* 211 */     resetIndent();
/* 212 */     super.appendDetail(buffer, fieldName, array);
/* 213 */     this.spaces -= 2;
/* 214 */     resetIndent();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\builder\MultilineRecursiveToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */