package gnu.trove.strategy;

import java.io.Serializable;

public interface HashingStrategy<T> extends Serializable {
  public static final long serialVersionUID = 5674097166776615540L;
  
  int computeHashCode(T paramT);
  
  boolean equals(T paramT1, T paramT2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\strategy\HashingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */