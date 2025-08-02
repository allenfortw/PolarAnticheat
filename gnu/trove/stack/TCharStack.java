package gnu.trove.stack;

public interface TCharStack {
  char getNoEntryValue();
  
  void push(char paramChar);
  
  char pop();
  
  char peek();
  
  int size();
  
  void clear();
  
  char[] toArray();
  
  void toArray(char[] paramArrayOfchar);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\stack\TCharStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */