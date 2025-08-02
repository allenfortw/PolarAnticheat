package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TShortByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TShortByteProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
import java.util.Map;

public interface TShortByteMap {
  short getNoEntryKey();
  
  byte getNoEntryValue();
  
  byte put(short paramShort, byte paramByte);
  
  byte putIfAbsent(short paramShort, byte paramByte);
  
  void putAll(Map<? extends Short, ? extends Byte> paramMap);
  
  void putAll(TShortByteMap paramTShortByteMap);
  
  byte get(short paramShort);
  
  void clear();
  
  boolean isEmpty();
  
  byte remove(short paramShort);
  
  int size();
  
  TShortSet keySet();
  
  short[] keys();
  
  short[] keys(short[] paramArrayOfshort);
  
  TByteCollection valueCollection();
  
  byte[] values();
  
  byte[] values(byte[] paramArrayOfbyte);
  
  boolean containsValue(byte paramByte);
  
  boolean containsKey(short paramShort);
  
  TShortByteIterator iterator();
  
  boolean forEachKey(TShortProcedure paramTShortProcedure);
  
  boolean forEachValue(TByteProcedure paramTByteProcedure);
  
  boolean forEachEntry(TShortByteProcedure paramTShortByteProcedure);
  
  void transformValues(TByteFunction paramTByteFunction);
  
  boolean retainEntries(TShortByteProcedure paramTShortByteProcedure);
  
  boolean increment(short paramShort);
  
  boolean adjustValue(short paramShort, byte paramByte);
  
  byte adjustOrPutValue(short paramShort, byte paramByte1, byte paramByte2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TShortByteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */