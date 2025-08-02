package gnu.trove.map;

import gnu.trove.function.TObjectFunction;
import gnu.trove.procedure.TObjectObjectProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.util.Map;

public interface TMap<K, V> extends Map<K, V> {
  V putIfAbsent(K paramK, V paramV);
  
  boolean forEachKey(TObjectProcedure<? super K> paramTObjectProcedure);
  
  boolean forEachValue(TObjectProcedure<? super V> paramTObjectProcedure);
  
  boolean forEachEntry(TObjectObjectProcedure<? super K, ? super V> paramTObjectObjectProcedure);
  
  boolean retainEntries(TObjectObjectProcedure<? super K, ? super V> paramTObjectObjectProcedure);
  
  void transformValues(TObjectFunction<V, V> paramTObjectFunction);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\gnu\trove\map\TMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */