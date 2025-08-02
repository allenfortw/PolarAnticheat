/*    */ package net.craftigames.polar.common.core.menu;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*    */ 
/*    */ public class MenuPolarItemStack
/*    */   extends PolarItemStack {
/*    */   private List<String> commands;
/*    */   
/*    */   public void setCommands(List<String> commands) {
/* 12 */     this.commands = commands; } public void setSlot(int slot) { this.slot = slot; } public void setSlots(List<Integer> slots) { this.slots = slots; }
/*    */ 
/*    */   
/*    */   public List<String> getCommands() {
/* 16 */     return this.commands;
/* 17 */   } private int slot = -1; private List<Integer> slots; public int getSlot() { return this.slot; } public List<Integer> getSlots() {
/* 18 */     return this.slots;
/*    */   }
/*    */   public MenuPolarItemStack(ConfigurationSection cnfs, String index) {
/* 21 */     super(cnfs, index);
/*    */ 
/*    */     
/* 24 */     this.commands = cnfs.getStringList(index + ".commands");
/* 25 */     this.slot = cnfs.getInt(index + ".slot");
/* 26 */     this.slots = cnfs.getIntegerList(index + ".slots");
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Integer> getAllSlots() {
/* 31 */     List<Integer> slots = new ArrayList<>();
/* 32 */     if (this.slots != null && !this.slots.isEmpty()) {
/* 33 */       slots.addAll(this.slots);
/*    */     }
/* 35 */     if (this.slot >= 0) {
/* 36 */       slots.add(Integer.valueOf(this.slot));
/*    */     }
/* 38 */     return slots;
/*    */   }
/*    */   
/*    */   public MenuPolarItemStack() {}
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\MenuPolarItemStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */