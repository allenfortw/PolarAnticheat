package gnu.trove.map;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.iterator.TByteFloatIterator;
import gnu.trove.procedure.TByteFloatProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TByteSet;
import java.util.Map;

public interface TByteFloatMap {
  byte getNoEntryKey();
  
  float getNoEntryValue();
  
  float put(byte paramByte, float paramFloat);
  
  float putIfAbsent(byte paramByte, float paramFloat);
  
  void putAll(Map<? extends Byte, ? extends Float> paramMap);
  
  void putAll(TByteFloatMap paramTByteFloatMap);
  
  float get(byte paramByte);
  
  void clear();
  
  boolean isEmpty();
  
  float remove(byte paramByte);
  
  int size();
  
  TByteSet keySet();
  
  byte[] keys();
  
  byte[] keys(byte[] paramArrayOfbyte);
  
  TFloatCollection valueCollection();
  
  float[] values();
  
  float[] values(float[] paramArrayOffloat);
  
  boolean containsValue(float paramFloat);
  
  boolean containsKey(byte paramByte);
  
  TByteFloatIterator iterator();
  
  boolean forEachKey(TByteProcedure paramTByteProcedure);
  
  boolean forEachValue(TFloatProcedure paramTFloatProcedure);
  
  boolean forEachEntry(TByteFloatProcedure paramTByteFloatProcedure);
  
  void transformValues(TFloatFunction paramTFloatFunction);
  
  boolean retainEntries(TByteFloatProcedure paramTByteFloatProcedure);
  
  boolean increment(byte paramByte);
  
  boolean adjustValue(byte paramByte, float paramFloat);
  
  float adjustOrPutValue(byte paramByte, float paramFloat1, float paramFloat2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TByteFloatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */