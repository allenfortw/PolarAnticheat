/*     */ package net.craftigames.polar.common.core.menu;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import java.util.function.Consumer;
/*     */ import net.craftigames.polar.common.core.menu.potion.PolarPotionEffect;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarEnchantment;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarMaterial;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ public class PolarItemBuilder
/*     */ {
/*  17 */   private PolarItemStack stack = new PolarItemStack();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemBuilder(String material) {
/*  24 */     this.stack.setMaterial(material);
/*     */   }
/*     */   
/*     */   public PolarItemBuilder(XPolarMaterial material) {
/*  28 */     this.stack.setMaterial(material.name());
/*     */   }
/*     */   
/*     */   public PolarItemBuilder(PolarItemStack stack) {
/*  32 */     this.stack = stack;
/*     */   }
/*     */ 
/*     */   
/*     */   public static PolarItemBuilder getItem(XPolarMaterial material, String displayName) {
/*  37 */     return getItem(material, displayName, null);
/*     */   }
/*     */   
/*     */   public static PolarItemBuilder getItem(XPolarMaterial material, String displayName, List<String> lore) {
/*  41 */     return getItem(material, null, displayName, lore);
/*     */   }
/*     */   
/*     */   public static PolarItemBuilder getItem(XPolarMaterial material, Integer amount, String displayName, List<String> lore) {
/*  45 */     PolarItemBuilder builder = new PolarItemBuilder(material);
/*  46 */     if (amount != null) {
/*  47 */       builder.setAmount(amount.intValue());
/*     */     }
/*  49 */     builder.setDisplayName(displayName);
/*  50 */     if (lore != null) {
/*  51 */       builder.setLore(new ArrayList<>(lore));
/*     */     }
/*  53 */     return builder;
/*     */   }
/*     */   
/*     */   public PolarItemStack toItemStack() {
/*  57 */     return this.stack;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setMaterial(String material) {
/*  61 */     this.stack.setMaterial(material);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setMaterial(XPolarMaterial material) {
/*  66 */     this.stack.setMaterial(material.name());
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setAmount(int amount) {
/*  71 */     this.stack.setAmount(amount);
/*  72 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setDisplayName(@Nullable String displayName) {
/*  76 */     this.stack.setDisplayName(displayName);
/*  77 */     return this;
/*     */   }
/*     */   public PolarItemBuilder setName(@Nullable String name) {
/*  80 */     return setDisplayName(name);
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setLore(@Nullable List<String> lore) {
/*  84 */     this.stack.setLore(lore);
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder addLoreLines(List<String> line) {
/*  89 */     if (this.stack.getLore() == null) {
/*  90 */       this.stack.setLore(new ArrayList<>());
/*     */     }
/*     */     
/*  93 */     if (line != null && line.size() > 0) {
/*  94 */       this.stack.getLore().addAll(line);
/*     */     }
/*  96 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder addLoreLines(String... line) {
/* 100 */     return addLoreLines(new ArrayList<>(Arrays.asList(line)));
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setEnchanted(boolean enchanted) {
/* 104 */     this.stack.setEnchanted(enchanted);
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setPlayerHead(String playerHead) {
/* 109 */     this.stack.setPlayerHead(playerHead);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setSkinUUID(UUID skinUUID) {
/* 114 */     this.stack.setSkinUUID(skinUUID);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setColor(Color color) {
/* 119 */     this.stack.setColor(color);
/* 120 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setDurability(short durability) {
/* 124 */     this.stack.setDurability(durability);
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemBuilder setItem(String item) {
/* 133 */     this.stack.setItem(item);
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setItem(XPolarMaterial item) {
/* 138 */     this.stack.setItem(item);
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder hideAttributes() {
/* 143 */     this.stack.hideAttributes();
/* 144 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder hideAttribute(int attribute) {
/* 148 */     this.stack.hideAttribute(attribute);
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setCustomModelData(int customModelData) {
/* 153 */     this.stack.setCustomModelData(customModelData);
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder nbtAction(Consumer<PolarItemNbt> nbtAction) {
/* 158 */     nbtAction.accept(this.stack.getNbt());
/* 159 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setSlot(int value) {
/* 163 */     this.stack.setSlot(value);
/* 164 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setDisplay(boolean value) {
/* 168 */     this.stack.setDisplay(value);
/* 169 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setCommands(List<String> commands) {
/* 173 */     this.stack.setCommands(commands);
/* 174 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder setSplash(boolean value) {
/* 178 */     this.stack.setSplash(value);
/* 179 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder addPotionEffect(PolarPotionEffect potionEffect) {
/* 183 */     this.stack.addPotionEffect(potionEffect);
/* 184 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder addEnchant(XPolarEnchantment enchantment, int level) {
/* 188 */     this.stack.addEnchant(enchantment, level);
/* 189 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemBuilder clone() {
/* 193 */     return new PolarItemBuilder(this.stack.clone());
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\PolarItemBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */