package gnu.trove.map;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.iterator.TCharByteIterator;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TCharSet;
import java.util.Map;

public interface TCharByteMap {
  char getNoEntryKey();
  
  byte getNoEntryValue();
  
  byte put(char paramChar, byte paramByte);
  
  byte putIfAbsent(char paramChar, byte paramByte);
  
  void putAll(Map<? extends Character, ? extends Byte> paramMap);
  
  void putAll(TCharByteMap paramTCharByteMap);
  
  byte get(char paramChar);
  
  void clear();
  
  boolean isEmpty();
  
  byte remove(char paramChar);
  
  int size();
  
  TCharSet keySet();
  
  char[] keys();
  
  char[] keys(char[] paramArrayOfchar);
  
  TByteCollection valueCollection();
  
  byte[] values();
  
  byte[] values(byte[] paramArrayOfbyte);
  
  boolean containsValue(byte paramByte);
  
  boolean containsKey(char paramChar);
  
  TCharByteIterator iterator();
  
  boolean forEachKey(TCharProcedure paramTCharProcedure);
  
  boolean forEachValue(TByteProcedure paramTByteProcedure);
  
  boolean forEachEntry(TCharByteProcedure paramTCharByteProcedure);
  
  void transformValues(TByteFunction paramTByteFunction);
  
  boolean retainEntries(TCharByteProcedure paramTCharByteProcedure);
  
  boolean increment(char paramChar);
  
  boolean adjustValue(char paramChar, byte paramByte);
  
  byte adjustOrPutValue(char paramChar, byte paramByte1, byte paramByte2);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TCharByteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */