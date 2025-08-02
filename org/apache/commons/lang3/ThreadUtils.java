/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.time.DurationUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThreadUtils
/*     */ {
/*     */   private static final class AlwaysTruePredicate
/*     */     implements ThreadPredicate, ThreadGroupPredicate
/*     */   {
/*     */     private AlwaysTruePredicate() {}
/*     */     
/*     */     public boolean test(Thread thread) {
/*  51 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(ThreadGroup threadGroup) {
/*  56 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NamePredicate
/*     */     implements ThreadPredicate, ThreadGroupPredicate
/*     */   {
/*     */     private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamePredicate(String name) {
/*  74 */       Validate.notNull(name, "name", new Object[0]);
/*  75 */       this.name = name;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(Thread thread) {
/*  80 */       return (thread != null && thread.getName().equals(this.name));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(ThreadGroup threadGroup) {
/*  85 */       return (threadGroup != null && threadGroup.getName().equals(this.name));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ThreadGroupPredicate
/*     */   {
/*     */     boolean test(ThreadGroup param1ThreadGroup);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ThreadIdPredicate
/*     */     implements ThreadPredicate
/*     */   {
/*     */     private final long threadId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ThreadIdPredicate(long threadId) {
/* 118 */       if (threadId <= 0L) {
/* 119 */         throw new IllegalArgumentException("The thread id must be greater than zero");
/*     */       }
/* 121 */       this.threadId = threadId;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean test(Thread thread) {
/* 126 */       return (thread != null && thread.getId() == this.threadId);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Thread findThreadById(long threadId) {
/* 163 */     Collection<Thread> result = findThreads(new ThreadIdPredicate(threadId));
/* 164 */     return result.isEmpty() ? null : result.iterator().next();
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
/*     */   public static Thread findThreadById(long threadId, String threadGroupName) {
/* 182 */     Validate.notNull(threadGroupName, "threadGroupName", new Object[0]);
/* 183 */     Thread thread = findThreadById(threadId);
/* 184 */     if (thread != null && thread.getThreadGroup() != null && thread.getThreadGroup().getName().equals(threadGroupName)) {
/* 185 */       return thread;
/*     */     }
/* 187 */     return null;
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
/*     */   public static Thread findThreadById(long threadId, ThreadGroup threadGroup) {
/* 205 */     Validate.notNull(threadGroup, "threadGroup", new Object[0]);
/* 206 */     Thread thread = findThreadById(threadId);
/* 207 */     if (thread != null && threadGroup.equals(thread.getThreadGroup())) {
/* 208 */       return thread;
/*     */     }
/* 210 */     return null;
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
/*     */   public static Collection<ThreadGroup> findThreadGroups(ThreadGroup group, boolean recurse, ThreadGroupPredicate predicate) {
/*     */     ThreadGroup[] threadGroups;
/* 225 */     Validate.notNull(group, "group", new Object[0]);
/* 226 */     Validate.notNull(predicate, "predicate", new Object[0]);
/*     */     
/* 228 */     int count = group.activeGroupCount();
/*     */     
/*     */     do {
/* 231 */       threadGroups = new ThreadGroup[count + count / 2 + 1];
/* 232 */       count = group.enumerate(threadGroups, recurse);
/*     */     }
/* 234 */     while (count >= threadGroups.length);
/*     */     
/* 236 */     List<ThreadGroup> result = new ArrayList<>(count);
/* 237 */     for (int i = 0; i < count; i++) {
/* 238 */       if (predicate.test(threadGroups[i])) {
/* 239 */         result.add(threadGroups[i]);
/*     */       }
/*     */     } 
/* 242 */     return Collections.unmodifiableCollection(result);
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
/*     */   public static Collection<ThreadGroup> findThreadGroups(ThreadGroupPredicate predicate) {
/* 257 */     return findThreadGroups(getSystemThreadGroup(), true, predicate);
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
/*     */   public static Collection<ThreadGroup> findThreadGroupsByName(String threadGroupName) {
/* 273 */     return findThreadGroups(new NamePredicate(threadGroupName));
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
/*     */   public static Collection<Thread> findThreads(ThreadGroup group, boolean recurse, ThreadPredicate predicate) {
/*     */     Thread[] threads;
/* 288 */     Validate.notNull(group, "The group must not be null", new Object[0]);
/* 289 */     Validate.notNull(predicate, "The predicate must not be null", new Object[0]);
/*     */     
/* 291 */     int count = group.activeCount();
/*     */     
/*     */     do {
/* 294 */       threads = new Thread[count + count / 2 + 1];
/* 295 */       count = group.enumerate(threads, recurse);
/*     */     }
/* 297 */     while (count >= threads.length);
/*     */     
/* 299 */     List<Thread> result = new ArrayList<>(count);
/* 300 */     for (int i = 0; i < count; i++) {
/* 301 */       if (predicate.test(threads[i])) {
/* 302 */         result.add(threads[i]);
/*     */       }
/*     */     } 
/* 305 */     return Collections.unmodifiableCollection(result);
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
/*     */   public static Collection<Thread> findThreads(ThreadPredicate predicate) {
/* 321 */     return findThreads(getSystemThreadGroup(), true, predicate);
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
/*     */   public static Collection<Thread> findThreadsByName(String threadName) {
/* 337 */     return findThreads(new NamePredicate(threadName));
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
/*     */   public static Collection<Thread> findThreadsByName(String threadName, String threadGroupName) {
/* 355 */     Validate.notNull(threadName, "threadName", new Object[0]);
/* 356 */     Validate.notNull(threadGroupName, "threadGroupName", new Object[0]);
/*     */     
/* 358 */     Collection<ThreadGroup> threadGroups = findThreadGroups(new NamePredicate(threadGroupName));
/*     */     
/* 360 */     if (threadGroups.isEmpty()) {
/* 361 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 364 */     Collection<Thread> result = new ArrayList<>();
/* 365 */     NamePredicate threadNamePredicate = new NamePredicate(threadName);
/* 366 */     for (ThreadGroup group : threadGroups) {
/* 367 */       result.addAll(findThreads(group, false, threadNamePredicate));
/*     */     }
/* 369 */     return Collections.unmodifiableCollection(result);
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
/*     */   public static Collection<Thread> findThreadsByName(String threadName, ThreadGroup threadGroup) {
/* 387 */     return findThreads(threadGroup, false, new NamePredicate(threadName));
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
/*     */   public static Collection<ThreadGroup> getAllThreadGroups() {
/* 401 */     return findThreadGroups(ALWAYS_TRUE_PREDICATE);
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
/*     */   public static Collection<Thread> getAllThreads() {
/* 415 */     return findThreads(ALWAYS_TRUE_PREDICATE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ThreadGroup getSystemThreadGroup() {
/* 426 */     ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
/* 427 */     while (threadGroup.getParent() != null) {
/* 428 */       threadGroup = threadGroup.getParent();
/*     */     }
/* 430 */     return threadGroup;
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
/*     */   public static void join(Thread thread, Duration duration) throws InterruptedException {
/* 443 */     DurationUtils.accept(thread::join, duration);
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
/*     */   public static void sleep(Duration duration) throws InterruptedException {
/* 455 */     DurationUtils.accept(Thread::sleep, duration);
/*     */   }
/*     */   
/*     */   @FunctionalInterface
/*     */   public static interface ThreadPredicate {
/*     */     boolean test(Thread param1Thread);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\ThreadUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */