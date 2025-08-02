/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractCircuitBreaker<T>
/*     */   implements CircuitBreaker<T>
/*     */ {
/*     */   public static final String PROPERTY_NAME = "open";
/*  38 */   protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
/*     */ 
/*     */ 
/*     */   
/*     */   private final PropertyChangeSupport changeSupport;
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractCircuitBreaker() {
/*  47 */     this.changeSupport = new PropertyChangeSupport(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/*  55 */     return isOpen(this.state.get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/*  63 */     return !isOpen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean checkState();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean incrementAndCheckState(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*  83 */     changeState(State.CLOSED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open() {
/*  91 */     changeState(State.OPEN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isOpen(State state) {
/* 101 */     return (state == State.OPEN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void changeState(State newState) {
/* 111 */     if (this.state.compareAndSet(newState.oppositeState(), newState)) {
/* 112 */       this.changeSupport.firePropertyChange("open", !isOpen(newState), isOpen(newState));
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
/*     */   public void addChangeListener(PropertyChangeListener listener) {
/* 124 */     this.changeSupport.addPropertyChangeListener(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeChangeListener(PropertyChangeListener listener) {
/* 133 */     this.changeSupport.removePropertyChangeListener(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected enum State
/*     */   {
/* 145 */     CLOSED
/*     */     {
/*     */ 
/*     */       
/*     */       public State oppositeState()
/*     */       {
/* 151 */         return OPEN;
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 156 */     OPEN
/*     */     {
/*     */ 
/*     */       
/*     */       public State oppositeState()
/*     */       {
/* 162 */         return CLOSED;
/*     */       }
/*     */     };
/*     */     
/*     */     public abstract State oppositeState();
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\concurrent\AbstractCircuitBreaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */