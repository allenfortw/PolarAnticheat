package gnu.trove.stack;

public interface TLongStack {
  long getNoEntryValue();
  
  void push(long paramLong);
  
  long pop();
  
  long peek();
  
  int size();
  
  void clear();
  
  long[] toArray();
  
  void toArray(long[] paramArrayOflong);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\stack\TLongStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */