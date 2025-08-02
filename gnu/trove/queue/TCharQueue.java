package gnu.trove.queue;

import gnu.trove.TCharCollection;

public interface TCharQueue extends TCharCollection {
  char element();
  
  boolean offer(char paramChar);
  
  char peek();
  
  char poll();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\queue\TCharQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */