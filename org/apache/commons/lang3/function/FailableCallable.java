package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableCallable<R, E extends Throwable> {
  R call() throws E;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableCallable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */