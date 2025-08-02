/*    */ package net.craftigames.polar.common.core.menu;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*    */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*    */ import net.craftigames.polar.common.configuration.polar.Config;
/*    */ 
/*    */ public class PolarMenuConfig {
/*    */   private final String configPath;
/*    */   private String title;
/*    */   private int rows;
/*    */   private List<MenuPolarItemStack> dummyItems;
/*    */   
/* 14 */   public void setTitle(String title) { this.title = title; } public void setRows(int rows) { this.rows = rows; } public void setDummyItems(List<MenuPolarItemStack> dummyItems) { this.dummyItems = dummyItems; }
/*    */   
/*    */   public String getConfigPath() {
/* 17 */     return this.configPath;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PolarMenuConfig(String configPath)
/*    */   {
/* 25 */     this.dummyItems = new ArrayList<>(); this.configPath = configPath; } public String getTitle() { return this.title; } public List<MenuPolarItemStack> getDummyItems() { return this.dummyItems; } public int getRows() {
/*    */     return this.rows;
/*    */   } public void load(Config config) {
/* 28 */     ConfigurationSection section = config.getConfigurationSection(this.configPath);
/* 29 */     if (section == null) {
/*    */       return;
/*    */     }
/* 32 */     setTitle(section.getString("title"));
/* 33 */     setRows(section.getInt("rows"));
/*    */ 
/*    */     
/* 36 */     this.dummyItems.clear();
/*    */     
/* 38 */     if (section.contains("dummy-items")) {
/* 39 */       for (String icons : section.getConfigurationSection("dummy-items").getKeys(false)) {
/* 40 */         MenuPolarItemStack item = new MenuPolarItemStack(section.getConfigurationSection("dummy-items"), icons);
/* 41 */         this.dummyItems.add(item);
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public void addToFile(FileConfiguration file) {
/* 47 */     String path = this.configPath + ".";
/* 48 */     file.addDefault(path + "title", this.configPath);
/* 49 */     file.addDefault(path + "rows", Integer.valueOf(3));
/*    */ 
/*    */     
/* 52 */     if (!file.contains(path + "title")) {
/* 53 */       file.addDefault(path + "dummy-items.dummy.material", "PAPER");
/* 54 */       file.addDefault(path + "dummy-items.dummy.slot", Integer.valueOf(10));
/* 55 */       file.addDefault(path + "dummy-items.dummy.name", "&c&lDummy Item");
/* 56 */       file.addDefault(path + "dummy-items.dummy.lore", Arrays.asList(new String[] { "&fLorem ipsum", "&fLorem ipsum" }));
/* 57 */       file.addDefault(path + "dummy-items.dummy.commands", Collections.singletonList("[msg] &cHey welcome {player}"));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\PolarMenuConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */