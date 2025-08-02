package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TCharFloatIterator;
import gnu.trove.procedure.TCharFloatProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

public interface TCharFloatMap {
  char getNoEntryKey();
  
  float getNoEntryValue();
  
  float put(char paramChar, float paramFloat);
  
  float putIfAbsent(char paramChar, float paramFloat);
  
  void putAll(Map<? extends Character, ? extends Float> paramMap);
  
  void putAll(TCharFloatMap paramTCharFloatMap);
  
  float get(char paramChar);
  
  void clear();
  
  boolean isEmpty();
  
  float remove(char paramChar);
  
  int size();
  
  TCharSet keySet();
  
  char[] keys();
  
  char[] keys(char[] paramArrayOfchar);
  
  TFloatCollection valueCollection();
  
  float[] values();
  
  float[] values(float[] paramArrayOffloat);
  
  boolean containsValue(float paramFloat);
  
  boolean containsKey(char paramChar);
  
  TCharFloatIterator iterator();
  
  boolean forEachKey(TCharProcedure paramTCharProcedure);
  
  boolean forEachValue(TFloatProcedure paramTFloatProcedure);
  
  boolean forEachEntry(TCharFloatProcedure paramTCharFloatProcedure);
  
  void transformValues(TFloatFunction paramTFloatFunction);
  
  boolean retainEntries(TCharFloatProcedure paramTCharFloatProcedure);
  
  boolean increment(char paramChar);
  
  boolean adjustValue(char paramChar, float paramFloat);
  
  float adjustOrPutValue(char paramChar, float paramFloat1, float paramFloat2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TCharFloatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */