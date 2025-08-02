/*    */ package org.apache.commons.lang3.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public abstract class CodePointTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   public final int translate(CharSequence input, int index, Writer out) throws IOException {
/* 40 */     int codepoint = Character.codePointAt(input, index);
/* 41 */     boolean consumed = translate(codepoint, out);
/* 42 */     return consumed ? 1 : 0;
/*    */   }
/*    */   
/*    */   public abstract boolean translate(int paramInt, Writer paramWriter) throws IOException;
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\text\translate\CodePointTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */