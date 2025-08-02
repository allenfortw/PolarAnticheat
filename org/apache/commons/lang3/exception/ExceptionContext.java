package org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public interface ExceptionContext {
  ExceptionContext addContextValue(String paramString, Object paramObject);
  
  ExceptionContext setContextValue(String paramString, Object paramObject);
  
  List<Object> getContextValues(String paramString);
  
  Object getFirstContextValue(String paramString);
  
  Set<String> getContextLabels();
  
  List<Pair<String, Object>> getContextEntries();
  
  String getFormattedExceptionMessage(String paramString);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\org\apache\commons\lang3\exception\ExceptionContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */