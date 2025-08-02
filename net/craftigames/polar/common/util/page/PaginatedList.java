package net.craftigames.polar.common.util.page;

import java.util.List;

public interface PaginatedList extends List<Object> {
  int getPageSize();
  
  boolean isFirstPage();
  
  boolean isMiddlePage();
  
  boolean isLastPage();
  
  boolean isNextPageAvailable();
  
  boolean isPreviousPageAvailable();
  
  boolean nextPage();
  
  boolean previousPage();
  
  void gotoPage(int paramInt);
  
  int getPageIndex();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\page\PaginatedList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */