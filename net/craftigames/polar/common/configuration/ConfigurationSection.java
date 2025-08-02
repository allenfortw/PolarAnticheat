package net.craftigames.polar.common.configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConfigurationSection {
  Set<String> getKeys(boolean paramBoolean);
  
  Map<String, Object> getValues(boolean paramBoolean);
  
  boolean contains(String paramString);
  
  boolean isSet(String paramString);
  
  String getCurrentPath();
  
  String getName();
  
  Configuration getRoot();
  
  ConfigurationSection getParent();
  
  Object get(String paramString);
  
  Object get(String paramString, Object paramObject);
  
  void set(String paramString, Object paramObject);
  
  ConfigurationSection createSection(String paramString);
  
  ConfigurationSection createSection(String paramString, Map<?, ?> paramMap);
  
  String getString(String paramString);
  
  String getString(String paramString1, String paramString2);
  
  boolean isString(String paramString);
  
  int getInt(String paramString);
  
  int getInt(String paramString, int paramInt);
  
  boolean isInt(String paramString);
  
  boolean getBoolean(String paramString);
  
  boolean getBoolean(String paramString, boolean paramBoolean);
  
  boolean isBoolean(String paramString);
  
  double getDouble(String paramString);
  
  double getDouble(String paramString, double paramDouble);
  
  boolean isDouble(String paramString);
  
  float getFloat(String paramString);
  
  float getFloat(String paramString, float paramFloat);
  
  boolean isFloat(String paramString);
  
  long getLong(String paramString);
  
  long getLong(String paramString, long paramLong);
  
  boolean isLong(String paramString);
  
  List<?> getList(String paramString);
  
  List<?> getList(String paramString, List<?> paramList);
  
  boolean isList(String paramString);
  
  List<String> getStringList(String paramString);
  
  List<Integer> getIntegerList(String paramString);
  
  List<Boolean> getBooleanList(String paramString);
  
  List<Double> getDoubleList(String paramString);
  
  List<Float> getFloatList(String paramString);
  
  List<Long> getLongList(String paramString);
  
  List<Byte> getByteList(String paramString);
  
  List<Character> getCharacterList(String paramString);
  
  List<Short> getShortList(String paramString);
  
  List<Map<?, ?>> getMapList(String paramString);
  
  ConfigurationSection getConfigurationSection(String paramString);
  
  boolean isConfigurationSection(String paramString);
  
  ConfigurationSection getDefaultSection();
  
  void addDefault(String paramString, Object paramObject);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\ConfigurationSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */