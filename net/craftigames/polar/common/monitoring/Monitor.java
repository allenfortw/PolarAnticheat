package net.craftigames.polar.common.monitoring;

import java.math.BigDecimal;

public interface Monitor extends Runnable {
  BigDecimal getCurrentValue();
  
  void resetValue();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\monitoring\Monitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */