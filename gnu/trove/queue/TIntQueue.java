package gnu.trove.queue;

import gnu.trove.TIntCollection;

public interface TIntQueue extends TIntCollection {
  int element();
  
  boolean offer(int paramInt);
  
  int peek();
  
  int poll();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\queue\TIntQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */