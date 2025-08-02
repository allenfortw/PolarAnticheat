/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StopWatch
/*     */ {
/*     */   private static final long NANO_2_MILLIS = 1000000L;
/*     */   private final String message;
/*     */   
/*     */   private enum SplitState
/*     */   {
/*  68 */     SPLIT,
/*  69 */     UNSPLIT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum State
/*     */   {
/*  77 */     RUNNING
/*     */     {
/*     */       boolean isStarted() {
/*  80 */         return true;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/*  84 */         return false;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/*  88 */         return false;
/*     */       }
/*     */     },
/*  91 */     STOPPED
/*     */     {
/*     */       boolean isStarted() {
/*  94 */         return false;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/*  98 */         return true;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 102 */         return false;
/*     */       }
/*     */     },
/* 105 */     SUSPENDED
/*     */     {
/*     */       boolean isStarted() {
/* 108 */         return true;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/* 112 */         return false;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 116 */         return true;
/*     */       }
/*     */     },
/* 119 */     UNSTARTED
/*     */     {
/*     */       boolean isStarted() {
/* 122 */         return false;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/* 126 */         return true;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 130 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isStarted();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isStopped();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isSuspended();
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
/*     */   public static StopWatch create() {
/* 174 */     return new StopWatch();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StopWatch createStarted() {
/* 185 */     StopWatch sw = new StopWatch();
/* 186 */     sw.start();
/* 187 */     return sw;
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
/* 200 */   private State runningState = State.UNSTARTED;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 205 */   private SplitState splitState = SplitState.UNSPLIT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long startTimeNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long startTimeMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long stopTimeMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long stopTimeNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StopWatch() {
/* 237 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StopWatch(String message) {
/* 248 */     this.message = message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatSplitTime() {
/* 258 */     return DurationFormatUtils.formatDurationHMS(getSplitTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatTime() {
/* 268 */     return DurationFormatUtils.formatDurationHMS(getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 278 */     return this.message;
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
/*     */   public long getNanoTime() {
/* 296 */     if (this.runningState == State.STOPPED || this.runningState == State.SUSPENDED)
/* 297 */       return this.stopTimeNanos - this.startTimeNanos; 
/* 298 */     if (this.runningState == State.UNSTARTED)
/* 299 */       return 0L; 
/* 300 */     if (this.runningState == State.RUNNING) {
/* 301 */       return System.nanoTime() - this.startTimeNanos;
/*     */     }
/* 303 */     throw new IllegalStateException("Illegal running state has occurred.");
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
/*     */   public long getSplitNanoTime() {
/* 322 */     if (this.splitState != SplitState.SPLIT) {
/* 323 */       throw new IllegalStateException("Stopwatch must be split to get the split time.");
/*     */     }
/* 325 */     return this.stopTimeNanos - this.startTimeNanos;
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
/*     */   public long getSplitTime() {
/* 344 */     return getSplitNanoTime() / 1000000L;
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
/*     */   public long getStartTime() {
/* 357 */     if (this.runningState == State.UNSTARTED) {
/* 358 */       throw new IllegalStateException("Stopwatch has not been started");
/*     */     }
/*     */     
/* 361 */     return this.startTimeMillis;
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
/*     */   public long getStopTime() {
/* 374 */     if (this.runningState == State.UNSTARTED) {
/* 375 */       throw new IllegalStateException("Stopwatch has not been started");
/*     */     }
/*     */     
/* 378 */     return this.stopTimeMillis;
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
/*     */   public long getTime() {
/* 394 */     return getNanoTime() / 1000000L;
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
/*     */   
/*     */   public long getTime(TimeUnit timeUnit) {
/* 414 */     return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
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
/*     */   public boolean isStarted() {
/* 426 */     return this.runningState.isStarted();
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
/*     */   public boolean isStopped() {
/* 439 */     return this.runningState.isStopped();
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
/*     */   public boolean isSuspended() {
/* 452 */     return this.runningState.isSuspended();
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
/*     */   public void reset() {
/* 465 */     this.runningState = State.UNSTARTED;
/* 466 */     this.splitState = SplitState.UNSPLIT;
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
/*     */   public void resume() {
/* 483 */     if (this.runningState != State.SUSPENDED) {
/* 484 */       throw new IllegalStateException("Stopwatch must be suspended to resume. ");
/*     */     }
/* 486 */     this.startTimeNanos += System.nanoTime() - this.stopTimeNanos;
/* 487 */     this.runningState = State.RUNNING;
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
/*     */   public void split() {
/* 504 */     if (this.runningState != State.RUNNING) {
/* 505 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 507 */     this.stopTimeNanos = System.nanoTime();
/* 508 */     this.splitState = SplitState.SPLIT;
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
/*     */   public void start() {
/* 524 */     if (this.runningState == State.STOPPED) {
/* 525 */       throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
/*     */     }
/* 527 */     if (this.runningState != State.UNSTARTED) {
/* 528 */       throw new IllegalStateException("Stopwatch already started. ");
/*     */     }
/* 530 */     this.startTimeNanos = System.nanoTime();
/* 531 */     this.startTimeMillis = System.currentTimeMillis();
/* 532 */     this.runningState = State.RUNNING;
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
/*     */   public void stop() {
/* 548 */     if (this.runningState != State.RUNNING && this.runningState != State.SUSPENDED) {
/* 549 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 551 */     if (this.runningState == State.RUNNING) {
/* 552 */       this.stopTimeNanos = System.nanoTime();
/* 553 */       this.stopTimeMillis = System.currentTimeMillis();
/*     */     } 
/* 555 */     this.runningState = State.STOPPED;
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
/*     */   public void suspend() {
/* 572 */     if (this.runningState != State.RUNNING) {
/* 573 */       throw new IllegalStateException("Stopwatch must be running to suspend. ");
/*     */     }
/* 575 */     this.stopTimeNanos = System.nanoTime();
/* 576 */     this.stopTimeMillis = System.currentTimeMillis();
/* 577 */     this.runningState = State.SUSPENDED;
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
/*     */   public String toSplitString() {
/* 594 */     String msgStr = Objects.toString(this.message, "");
/* 595 */     String formattedTime = formatSplitTime();
/* 596 */     return msgStr.isEmpty() ? formattedTime : (msgStr + " " + formattedTime);
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
/*     */   public String toString() {
/* 613 */     String msgStr = Objects.toString(this.message, "");
/* 614 */     String formattedTime = formatTime();
/* 615 */     return msgStr.isEmpty() ? formattedTime : (msgStr + " " + formattedTime);
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
/*     */   public void unsplit() {
/* 632 */     if (this.splitState != SplitState.SPLIT) {
/* 633 */       throw new IllegalStateException("Stopwatch has not been split. ");
/*     */     }
/* 635 */     this.splitState = SplitState.UNSPLIT;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\time\StopWatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */