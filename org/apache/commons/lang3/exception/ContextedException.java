/*     */ package org.apache.commons.lang3.exception;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContextedException
/*     */   extends Exception
/*     */   implements ExceptionContext
/*     */ {
/*     */   private static final long serialVersionUID = 20110706L;
/*     */   private final ExceptionContext exceptionContext;
/*     */   
/*     */   public ContextedException() {
/* 100 */     this.exceptionContext = new DefaultExceptionContext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContextedException(String message) {
/* 111 */     super(message);
/* 112 */     this.exceptionContext = new DefaultExceptionContext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContextedException(Throwable cause) {
/* 123 */     super(cause);
/* 124 */     this.exceptionContext = new DefaultExceptionContext();
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
/*     */   public ContextedException(String message, Throwable cause) {
/* 136 */     super(message, cause);
/* 137 */     this.exceptionContext = new DefaultExceptionContext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContextedException(String message, Throwable cause, ExceptionContext context) {
/* 148 */     super(message, cause);
/* 149 */     if (context == null) {
/* 150 */       context = new DefaultExceptionContext();
/*     */     }
/* 152 */     this.exceptionContext = context;
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
/*     */   public ContextedException addContextValue(String label, Object value) {
/* 171 */     this.exceptionContext.addContextValue(label, value);
/* 172 */     return this;
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
/*     */   public ContextedException setContextValue(String label, Object value) {
/* 190 */     this.exceptionContext.setContextValue(label, value);
/* 191 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Object> getContextValues(String label) {
/* 199 */     return this.exceptionContext.getContextValues(label);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getFirstContextValue(String label) {
/* 207 */     return this.exceptionContext.getFirstContextValue(label);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Pair<String, Object>> getContextEntries() {
/* 215 */     return this.exceptionContext.getContextEntries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getContextLabels() {
/* 223 */     return this.exceptionContext.getContextLabels();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 234 */     return getFormattedExceptionMessage(super.getMessage());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRawMessage() {
/* 245 */     return super.getMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormattedExceptionMessage(String baseMessage) {
/* 253 */     return this.exceptionContext.getFormattedExceptionMessage(baseMessage);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\exception\ContextedException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */