package net.craftigames.polar.common.configuration;

import java.util.Map;

public interface Configuration extends ConfigurationSection {
  void addDefault(String paramString, Object paramObject);
  
  void addDefaults(Map<String, Object> paramMap);
  
  void addDefaults(Configuration paramConfiguration);
  
  void setDefaults(Configuration paramConfiguration);
  
  Configuration getDefaults();
  
  ConfigurationOptions options();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\Configuration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */