package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableDoubleBinaryOperator<E extends Throwable> {
  double applyAsDouble(double paramDouble1, double paramDouble2) throws E;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableDoubleBinaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */