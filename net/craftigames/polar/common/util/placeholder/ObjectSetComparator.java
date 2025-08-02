/*   */ package net.craftigames.polar.common.util.placeholder;
/*   */ 
/*   */ import java.util.Comparator;
/*   */ 
/*   */ public class ObjectSetComparator
/*   */   implements Comparator<ObjectSet<?, ?>>
/*   */ {
/*   */   public int compare(ObjectSet<?, ?> o1, ObjectSet<?, ?> o2) {
/* 9 */     return ((Comparable)o2.getB()).compareTo(o1.getB());
/*   */   }
/*   */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\placeholder\ObjectSetComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */