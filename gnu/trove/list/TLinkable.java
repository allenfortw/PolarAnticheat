package gnu.trove.list;

import java.io.Serializable;

public interface TLinkable<T extends TLinkable> extends Serializable {
  public static final long serialVersionUID = 997545054865482562L;
  
  T getNext();
  
  T getPrevious();
  
  void setNext(T paramT);
  
  void setPrevious(T paramT);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\list\TLinkable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */