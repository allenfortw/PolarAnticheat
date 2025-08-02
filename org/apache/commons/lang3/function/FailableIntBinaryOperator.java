package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableIntBinaryOperator<E extends Throwable> {
  int applyAsInt(int paramInt1, int paramInt2) throws E;
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\function\FailableIntBinaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */