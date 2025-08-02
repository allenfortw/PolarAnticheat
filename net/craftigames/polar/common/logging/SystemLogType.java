package net.craftigames.polar.common.logging;

public interface SystemLogType {
  String getType();
  
  String format(Object... paramVarArgs);
  
  String getLogVariant();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\logging\SystemLogType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */