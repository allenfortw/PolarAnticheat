package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TIntByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntByteProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;
import java.util.Map;

public interface TIntByteMap {
  int getNoEntryKey();
  
  byte getNoEntryValue();
  
  byte put(int paramInt, byte paramByte);
  
  byte putIfAbsent(int paramInt, byte paramByte);
  
  void putAll(Map<? extends Integer, ? extends Byte> paramMap);
  
  void putAll(TIntByteMap paramTIntByteMap);
  
  byte get(int paramInt);
  
  void clear();
  
  boolean isEmpty();
  
  byte remove(int paramInt);
  
  int size();
  
  TIntSet keySet();
  
  int[] keys();
  
  int[] keys(int[] paramArrayOfint);
  
  TByteCollection valueCollection();
  
  byte[] values();
  
  byte[] values(byte[] paramArrayOfbyte);
  
  boolean containsValue(byte paramByte);
  
  boolean containsKey(int paramInt);
  
  TIntByteIterator iterator();
  
  boolean forEachKey(TIntProcedure paramTIntProcedure);
  
  boolean forEachValue(TByteProcedure paramTByteProcedure);
  
  boolean forEachEntry(TIntByteProcedure paramTIntByteProcedure);
  
  void transformValues(TByteFunction paramTByteFunction);
  
  boolean retainEntries(TIntByteProcedure paramTIntByteProcedure);
  
  boolean increment(int paramInt);
  
  boolean adjustValue(int paramInt, byte paramByte);
  
  byte adjustOrPutValue(int paramInt, byte paramByte1, byte paramByte2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TIntByteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */