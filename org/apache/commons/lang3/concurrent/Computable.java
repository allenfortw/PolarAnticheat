package org.apache.commons.lang3.concurrent;

public interface Computable<I, O> {
  O compute(I paramI) throws InterruptedException;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\concurrent\Computable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */