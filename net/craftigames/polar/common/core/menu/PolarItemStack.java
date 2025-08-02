/*     */ package net.craftigames.polar.common.core.menu;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.annotation.Nonnull;
/*     */ import javax.annotation.Nullable;
/*     */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*     */ import net.craftigames.polar.common.configuration.file.FileConfiguration;
/*     */ import net.craftigames.polar.common.configuration.polar.PolarConfig;
/*     */ import net.craftigames.polar.common.core.menu.potion.PolarPotionEffect;
/*     */ import net.craftigames.polar.common.core.menu.sub.PolarEnchantment;
/*     */ import net.craftigames.polar.common.core.menu.sub.PolarPotionEffectLegacy;
/*     */ import net.craftigames.polar.common.util.Input;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ import net.craftigames.polar.common.util.placeholder.ObjectSet;
/*     */ import net.craftigames.polar.common.util.placeholder.PlaceholderBuilder;
/*     */ import net.craftigames.polar.common.util.placeholder.Placeholders;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarEnchantment;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarMaterial;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarPotion;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class PolarItemStack
/*     */   implements GsonSerializable {
/*     */   public void setAmount(int amount) {
/*  37 */     this.amount = amount; } public void setDisplayName(@Nullable String displayName) { this.displayName = displayName; } public void setLore(@Nullable List<String> lore) { this.lore = lore; } @Deprecated public void setEnchanted(boolean enchanted) { this.enchanted = enchanted; } public void setPlayerHead(String playerHead) { this.playerHead = playerHead; } public void setSkinUUID(UUID skinUUID) { this.skinUUID = skinUUID; } public void setColor(Color color) { this.color = color; } @Deprecated public void setDurability(short durability) { this.durability = durability; } public void setCustomModelData(int customModelData) { this.customModelData = customModelData; } public void setSlot(int slot) { this.slot = slot; } public void setCommands(List<String> commands) { this.commands = commands; } public void setDisplay(boolean display) { this.display = display; } public void setSplash(boolean splash) { this.splash = splash; } public void setSerializedStack(@Nullable String serializedStack) { this.serializedStack = serializedStack; }
/*     */ 
/*     */ 
/*     */   
/*  41 */   private String material = "STONE"; public String getMaterial() { return this.material; } @Nullable private String displayName; @Nullable private List<String> lore; @Deprecated
/*  42 */   private boolean enchanted; private String playerHead; private int amount = 1; private UUID skinUUID; private Color color; @Deprecated private short durability; public int getAmount() { return this.amount; }
/*     */   @Nullable
/*  44 */   public String getDisplayName() { return this.displayName; } @Nullable
/*  45 */   public List<String> getLore() { return this.lore; }
/*     */   @Deprecated
/*  47 */   public boolean isEnchanted() { return this.enchanted; }
/*  48 */   public String getPlayerHead() { return this.playerHead; }
/*  49 */   public UUID getSkinUUID() { return this.skinUUID; } public Color getColor() {
/*  50 */     return this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public short getDurability() {
/*  56 */     return this.durability;
/*     */   } @NotNull
/*  58 */   private final List<Integer> itemFlags = new ArrayList<>(); @NotNull
/*  59 */   public List<Integer> getItemFlags() { return this.itemFlags; }
/*  60 */    private int customModelData = -1; public int getCustomModelData() { return this.customModelData; }
/*     */   
/*  62 */   private int slot = -1; public int getSlot() { return this.slot; }
/*  63 */    private List<String> commands = new ArrayList<>(); public List<String> getCommands() { return this.commands; } private boolean display = true;
/*  64 */   public boolean isDisplay() { return this.display; } @NotNull
/*  65 */   private final PolarItemNbt nbt = new PolarItemNbt(); @NotNull
/*  66 */   public PolarItemNbt getNbt() { return this.nbt; }
/*     */    @NotNull
/*  68 */   private final List<PolarPotionEffect> potionEffects = new ArrayList<>(); @NotNull
/*  69 */   public List<PolarPotionEffect> getPotionEffects() { return this.potionEffects; } private boolean splash = false; public boolean isSplash() {
/*  70 */     return this.splash;
/*     */   } @NotNull
/*  72 */   private final Map<XPolarEnchantment, Integer> enchantments = new HashMap<>(); @Nullable private String serializedStack; @NotNull
/*  73 */   public Map<XPolarEnchantment, Integer> getEnchantments() { return this.enchantments; } @Nullable
/*     */   public String getSerializedStack() {
/*  75 */     return this.serializedStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack(String item, int amount, short durability) {
/*  82 */     this.material = item;
/*  83 */     this.amount = amount;
/*  84 */     this.durability = durability;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack(String item, int amount) {
/*  92 */     this(item, amount, (short)0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack(String item, short durability) {
/* 100 */     this(item, 1, durability);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack(String item) {
/* 108 */     this(item, 1, (short)0);
/*     */   }
/*     */   
/*     */   public PolarItemStack(XPolarMaterial item, int amount) {
/* 112 */     this(item.name(), amount, (short)0);
/*     */   }
/*     */   
/*     */   public PolarItemStack(XPolarMaterial item) {
/* 116 */     this(item.name(), 1, (short)0);
/*     */   }
/*     */   
/*     */   public static PolarItemStack of(PolarItemStack item, List<ObjectSet<String, String>> placeholders) {
/* 120 */     item = item.clone();
/* 121 */     String name = item.getDisplayName();
/* 122 */     if (name != null) {
/* 123 */       item.setDisplayName(Placeholders.placeholder(name, placeholders));
/*     */     }
/*     */     
/* 126 */     List<String> lore = item.getLore();
/* 127 */     if (lore != null && !lore.isEmpty()) {
/* 128 */       item.setLore(Placeholders.placeholders(lore, placeholders));
/*     */     }
/* 130 */     return item;
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public JsonElement serialize() {
/* 136 */     return (JsonElement)JsonBuilder.object()
/* 137 */       .add("material", this.material)
/* 138 */       .consume(builder -> {
/*     */           if (this.serializedStack != null && !this.serializedStack.isEmpty()) {
/*     */             builder.add("serializedStack", this.serializedStack);
/*     */           }
/*     */           
/*     */           if (this.amount != 1) {
/*     */             builder.add("amount", Integer.valueOf(this.amount));
/*     */           }
/*     */           
/*     */           if (this.displayName != null) {
/*     */             builder.add("name", this.displayName);
/*     */           }
/*     */           
/*     */           if (this.lore != null && !this.lore.isEmpty()) {
/*     */             builder.add("lore", (JsonElement)JsonBuilder.array().addStrings(this.lore).build());
/*     */           }
/*     */           
/*     */           if (this.enchanted) {
/*     */             builder.add("enchanted", Boolean.valueOf(true));
/*     */           }
/*     */           
/*     */           if (this.playerHead != null && this.playerHead.length() > 0) {
/*     */             builder.add("playerHead", this.playerHead);
/*     */           }
/*     */           
/*     */           if (this.skinUUID != null) {
/*     */             builder.add("skinUUID", this.skinUUID);
/*     */           }
/*     */           
/*     */           if (this.color != null) {
/*     */             builder.add("color", Integer.valueOf(this.color.getRGB()));
/*     */           }
/*     */           
/*     */           if (this.durability != 0) {
/*     */             builder.add("durability", Short.valueOf(this.durability));
/*     */           }
/*     */           
/*     */           if (!this.itemFlags.isEmpty()) {
/*     */             builder.add("itemFlags", (JsonElement)JsonBuilder.array().addNumbers(this.itemFlags).build());
/*     */           }
/*     */           
/*     */           if (this.customModelData >= 0) {
/*     */             builder.add("customModelData", Integer.valueOf(this.customModelData));
/*     */           }
/*     */           if (!this.nbt.isEmpty()) {
/*     */             builder.add("nbt", this.nbt);
/*     */           }
/*     */           if (!this.potionEffects.isEmpty()) {
/*     */             builder.add("potionEffects", (JsonElement)JsonBuilder.array().addSerializables(this.potionEffects).build());
/*     */             builder.add("splash", Boolean.valueOf(this.splash));
/*     */           } 
/*     */           if (!this.enchantments.isEmpty()) {
/*     */             builder.add("enchantments", (JsonElement)JsonBuilder.array().addAll((Iterable)this.enchantments.entrySet().stream().map(()).collect(Collectors.toList())).build());
/*     */           }
/*     */           if (this.slot != -1) {
/*     */             builder.add("slot", Integer.valueOf(this.slot));
/*     */           }
/* 195 */         }).build();
/*     */   }
/*     */   
/*     */   public static PolarItemStack deserialize(JsonElement element) {
/* 199 */     if (element instanceof JsonObject) {
/* 200 */       JsonObject object = element.getAsJsonObject();
/*     */       
/* 202 */       PolarItemStack item = new PolarItemStack();
/*     */       
/* 204 */       JsonElement serializedStackElement = object.get("serializedStack");
/* 205 */       if (serializedStackElement instanceof com.google.gson.JsonPrimitive) {
/* 206 */         item.setSerializedStack(serializedStackElement.getAsString());
/*     */       }
/*     */       
/* 209 */       JsonElement itemElement = object.get("material");
/* 210 */       if (itemElement instanceof com.google.gson.JsonPrimitive) {
/* 211 */         item.setMaterial(itemElement.getAsString());
/*     */       }
/*     */       
/* 214 */       JsonElement amountElement = object.get("amount");
/* 215 */       if (amountElement instanceof com.google.gson.JsonPrimitive) {
/* 216 */         item.setAmount(amountElement.getAsInt());
/*     */       }
/*     */       
/* 219 */       JsonElement displayNameElement = object.get("name");
/* 220 */       if (displayNameElement instanceof com.google.gson.JsonPrimitive) {
/* 221 */         item.setDisplayName(displayNameElement.getAsString());
/*     */       }
/*     */       
/* 224 */       JsonElement loreElement = object.get("lore");
/* 225 */       if (loreElement instanceof com.google.gson.JsonArray) {
/* 226 */         List<String> lore = new ArrayList<>();
/* 227 */         for (JsonElement jsonElement : loreElement.getAsJsonArray()) {
/* 228 */           lore.add(jsonElement.getAsString());
/*     */         }
/* 230 */         item.setLore(lore);
/*     */       } 
/*     */       
/* 233 */       JsonElement enchantedElement = object.get("enchanted");
/* 234 */       if (enchantedElement instanceof com.google.gson.JsonPrimitive) {
/* 235 */         item.setEnchanted(enchantedElement.getAsBoolean());
/*     */       }
/*     */       
/* 238 */       JsonElement playerHeadElement = object.get("playerHead");
/* 239 */       if (playerHeadElement instanceof com.google.gson.JsonPrimitive) {
/* 240 */         item.setPlayerHead(playerHeadElement.getAsString());
/*     */       }
/*     */       
/* 243 */       JsonElement skinUUIDElement = object.get("skinUUID");
/* 244 */       if (skinUUIDElement instanceof com.google.gson.JsonPrimitive) {
/* 245 */         item.setSkinUUID(UUID.fromString(skinUUIDElement.getAsString()));
/*     */       }
/*     */       
/* 248 */       JsonElement colorElement = object.get("color");
/* 249 */       if (colorElement instanceof com.google.gson.JsonPrimitive) {
/* 250 */         item.setColor(new Color(colorElement.getAsInt()));
/*     */       }
/*     */       
/* 253 */       JsonElement durabilityElement = object.get("durability");
/* 254 */       if (durabilityElement instanceof com.google.gson.JsonPrimitive) {
/* 255 */         item.setDurability(durabilityElement.getAsShort());
/*     */       }
/*     */       
/* 258 */       JsonElement itemFlagsElement = object.get("itemFlags");
/* 259 */       if (itemFlagsElement instanceof com.google.gson.JsonArray) {
/* 260 */         List<Integer> itemFlags = new ArrayList<>();
/* 261 */         for (JsonElement jsonElement : itemFlagsElement.getAsJsonArray()) {
/* 262 */           itemFlags.add(Integer.valueOf(jsonElement.getAsInt()));
/*     */         }
/* 264 */         item.getItemFlags().addAll(itemFlags);
/*     */       } 
/*     */       
/* 267 */       JsonElement customModelDataElement = object.get("customModelData");
/* 268 */       if (customModelDataElement instanceof com.google.gson.JsonPrimitive) {
/* 269 */         item.setCustomModelData(customModelDataElement.getAsInt());
/*     */       }
/*     */       
/* 272 */       if (object.has("nbt")) {
/* 273 */         PolarItemNbt deserialized = PolarItemNbt.deserialize(object.get("nbt"));
/* 274 */         item.getNbt().getNbt().putAll(deserialized.getNbt());
/*     */       } 
/*     */       
/* 277 */       JsonElement effectsElement = object.get("potionEffects");
/* 278 */       if (effectsElement instanceof com.google.gson.JsonArray) {
/* 279 */         List<PolarPotionEffect> effects = new ArrayList<>();
/* 280 */         for (JsonElement effect : effectsElement.getAsJsonArray()) {
/* 281 */           effects.add(PolarPotionEffect.deserialize(effect));
/*     */         }
/* 283 */         item.potionEffects.addAll(effects);
/*     */         
/* 285 */         if (object.has("splash")) {
/* 286 */           item.splash = object.get("splash").getAsBoolean();
/*     */         }
/*     */       } 
/*     */       
/* 290 */       JsonElement enchantsElement = object.get("enchantments");
/* 291 */       if (enchantsElement instanceof com.google.gson.JsonArray) {
/* 292 */         Map<XPolarEnchantment, Integer> enchants = new HashMap<>();
/* 293 */         for (JsonElement enchantObject : enchantsElement.getAsJsonArray()) {
/* 294 */           if (enchantObject instanceof JsonObject) {
/* 295 */             JsonObject enchant = enchantObject.getAsJsonObject();
/* 296 */             XPolarEnchantment ench = XPolarEnchantment.fromName(enchant.get("type").getAsString());
/* 297 */             if (ench != null) {
/* 298 */               enchants.put(ench, Integer.valueOf(enchant.has("level") ? enchant.get("level").getAsInt() : 1));
/*     */             }
/*     */           } 
/*     */         } 
/* 302 */         item.enchantments.putAll(enchants);
/*     */       } 
/*     */       
/* 305 */       JsonElement slotElement = object.get("slot");
/* 306 */       if (slotElement instanceof com.google.gson.JsonPrimitive) {
/* 307 */         item.slot = slotElement.getAsInt();
/*     */       }
/*     */       
/* 310 */       return item;
/*     */     } 
/* 312 */     return null;
/*     */   }
/*     */   
/*     */   public PolarItemStack(ConfigurationSection cnfs, String index) {
/* 316 */     this(cnfs.getConfigurationSection(index));
/*     */   }
/*     */   
/*     */   public PolarItemStack(ConfigurationSection config) {
/* 320 */     this.amount = config.getInt("amount", 1);
/*     */     
/* 322 */     this.displayName = config.getString("name");
/* 323 */     if (this.displayName == null) {
/* 324 */       this.displayName = config.getString("displayname");
/*     */     }
/* 326 */     if (this.displayName == null) {
/* 327 */       this.displayName = config.getString("display_name");
/*     */     }
/*     */     
/* 330 */     if (config.contains("itemFlags")) {
/*     */       try {
/* 332 */         this.itemFlags.addAll((Collection<? extends Integer>)config.getStringList("itemFlags").stream().map(Integer::parseInt).collect(Collectors.toList()));
/* 333 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 337 */     if (config.contains("lore")) {
/* 338 */       this.lore = config.getStringList("lore");
/*     */     }
/*     */     
/* 341 */     if (config.contains("material")) {
/* 342 */       if (config.getString("material").contains(":")) {
/* 343 */         String[] m = config.getString("material").split(":");
/* 344 */         this.material = m[0];
/* 345 */         this.durability = (m.length == 1) ? 0 : Short.parseShort(m[1]);
/*     */       } else {
/* 347 */         this.material = config.getString("material");
/*     */       } 
/*     */     }
/*     */     
/* 351 */     if (config.contains("playerhead")) {
/* 352 */       this.playerHead = config.getString("playerhead");
/*     */     }
/*     */     
/* 355 */     this.slot = config.getInt("slot", -1);
/* 356 */     if (config.contains("skin-uuid")) {
/* 357 */       this.skinUUID = UUID.fromString(config.getString("skin-uuid"));
/*     */     }
/*     */     
/* 360 */     if (config.contains("commands")) {
/* 361 */       this.commands = config.getStringList("commands");
/*     */     }
/*     */     
/* 364 */     if (config.contains("color")) {
/* 365 */       this.color = new Color(config.getInt("color"));
/*     */     }
/*     */     
/* 368 */     this.display = config.getBoolean("display", true);
/*     */     
/* 370 */     if (config.contains("potionEffects")) {
/* 371 */       for (String key : config.getConfigurationSection("potionEffects").getKeys(false)) {
/* 372 */         PolarPotionEffect effect = PolarPotionEffect.of(config.getConfigurationSection("potionEffects." + key));
/*     */         
/* 374 */         if (effect != null) {
/* 375 */           this.potionEffects.add(effect);
/*     */         }
/*     */       } 
/*     */     }
/* 379 */     this.splash = config.getBoolean("splash", false);
/*     */     
/* 381 */     this.enchanted = config.getBoolean("enchanted", false);
/*     */     
/* 383 */     if (config.contains("enchantments")) {
/* 384 */       config.getStringList("enchantments").forEach(string -> {
/*     */             String[] split = string.split(":");
/*     */             
/*     */             XPolarEnchantment ench = XPolarEnchantment.fromName(split[0]);
/*     */             if (ench != null) {
/*     */               this.enchantments.put(ench, Integer.valueOf((split.length > 1) ? ((Integer)Input.tryInteger(split[1]).orElse(Integer.valueOf(1))).intValue() : 1));
/*     */             }
/*     */           });
/*     */     }
/* 393 */     if (config.contains("custom_model_data")) {
/* 394 */       this.customModelData = config.getInt("custom_model_data");
/*     */     }
/*     */   }
/*     */   
/*     */   public static PolarItemStackBuilder builderCurrent(PolarItemStack current) {
/* 399 */     return builder().material(current.material).amount(current.amount).durability(current.durability).displayName(current.displayName).itemFlags(current.itemFlags)
/* 400 */       .lore(current.lore).slot(current.slot).display(current.display).commands(current.commands).enchanted(current.enchanted).playerHead(current.playerHead).skinUUID(current.skinUUID).color(current.color)
/* 401 */       .potionEffects(current.potionEffects).enchantments(current.enchantments);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PolarItemStack clone() {
/* 407 */     return deserialize(serialize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PolarItemStack cloneWithSlot() {
/* 414 */     PolarItemStack clone = clone();
/*     */     
/* 416 */     clone.setSlot(this.slot);
/* 417 */     clone.setCommands(new ArrayList<>(this.commands));
/* 418 */     clone.setDisplay(this.display);
/*     */     
/* 420 */     return clone;
/*     */   }
/*     */   
/*     */   public void addToConfig(PolarConfig config, String path) {
/* 424 */     FileConfiguration file = config.getConfig();
/*     */     
/* 426 */     addToConfig(file, path);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PolarItemStack placeholders(PlaceholderBuilder placeholders) {
/* 435 */     return placeholders(placeholders.getPlaceholders());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PolarItemStack placeholders(List<ObjectSet<String, String>> placeholders) {
/* 444 */     if (this.displayName != null && !this.displayName.isEmpty()) {
/* 445 */       this.displayName = Placeholders.placeholder(this.displayName, placeholders);
/*     */     }
/*     */     
/* 448 */     if (this.lore != null && !this.lore.isEmpty()) {
/* 449 */       List<String> newLore = new ArrayList<>();
/* 450 */       for (String l : this.lore) {
/* 451 */         newLore.add(Placeholders.placeholder(l, placeholders));
/*     */       }
/*     */       
/* 454 */       this.lore.clear();
/* 455 */       this.lore.addAll(newLore);
/*     */     } 
/*     */     
/* 458 */     return this;
/*     */   }
/*     */   
/*     */   public static PolarItemStack skullOf(@Nonnull String playerHead) {
/* 462 */     return (new PolarItemBuilder(XPolarMaterial.PLAYER_HEAD)).setPlayerHead(playerHead).toItemStack();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static PolarItemStack of(PolarConfig config, String path) {
/* 467 */     return of(config.getConfigurationSection(path));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static PolarItemStack of(@Nullable ConfigurationSection config) {
/* 472 */     if (config == null) {
/* 473 */       return null;
/*     */     }
/* 475 */     return new PolarItemStack(config);
/*     */   }
/*     */   
/*     */   public void addToConfig(FileConfiguration file, String path) {
/* 479 */     if (!path.isEmpty() && !path.endsWith(".")) {
/* 480 */       path = path + ".";
/*     */     }
/*     */     
/* 483 */     if (this.amount > 1) {
/* 484 */       file.set(path + "amount", Integer.valueOf(this.amount));
/*     */     }
/*     */     
/* 487 */     if (this.displayName != null) {
/* 488 */       file.set(path + "name", this.displayName);
/*     */     }
/*     */     
/* 491 */     if (this.enchanted) {
/* 492 */       file.set(path + "enchanted", Boolean.valueOf(true));
/*     */     }
/*     */     
/* 495 */     if (!this.itemFlags.isEmpty()) {
/* 496 */       file.set(path + "itemFlags", this.itemFlags.stream().map(String::valueOf).collect(Collectors.toList()));
/*     */     }
/*     */     
/* 499 */     if (!this.enchantments.isEmpty()) {
/* 500 */       file.set(path + "enchantments", this.enchantments.entrySet().stream().map(entry -> ((XPolarEnchantment)entry.getKey()).name() + ":" + entry.getValue()).collect(Collectors.toList()));
/*     */     }
/*     */     
/* 503 */     if (!this.potionEffects.isEmpty()) {
/* 504 */       int index = 1;
/* 505 */       for (PolarPotionEffect effect : this.potionEffects) {
/* 506 */         effect.addToConfig(file, path + "potionEffects." + index++);
/*     */       }
/*     */     } 
/*     */     
/* 510 */     if (this.splash) {
/* 511 */       file.set(path + "splash", Boolean.valueOf(true));
/*     */     }
/*     */     
/* 514 */     if (this.lore != null && !this.lore.isEmpty()) {
/* 515 */       file.set(path + "lore", this.lore);
/*     */     }
/*     */     
/* 518 */     if (this.material != null) {
/* 519 */       if (this.durability != 0) {
/* 520 */         file.set(path + "material", this.material + ":" + this.durability);
/*     */       } else {
/* 522 */         file.set(path + "material", this.material);
/*     */       } 
/*     */     }
/*     */     
/* 526 */     if (this.playerHead != null) {
/* 527 */       file.set(path + "playerhead", this.playerHead);
/*     */     }
/*     */     
/* 530 */     if (this.slot != -1) {
/* 531 */       file.set(path + "slot", Integer.valueOf(this.slot));
/*     */     }
/*     */     
/* 534 */     if (this.skinUUID != null) {
/* 535 */       file.set(path + "skin-uuid", this.skinUUID.toString());
/*     */     }
/*     */     
/* 538 */     if (this.color != null) {
/* 539 */       file.set(path + "color", Integer.valueOf(this.color.getRGB()));
/*     */     }
/*     */     
/* 542 */     if (!this.display) {
/* 543 */       file.set(path + "display", Boolean.valueOf(false));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setItem(String item) {
/* 552 */     this.material = item;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void setMaterial(String material) {
/* 557 */     this.material = material;
/*     */   }
/*     */   
/*     */   public void setItem(XPolarMaterial item) {
/* 561 */     this.material = item.name();
/*     */   }
/*     */   
/*     */   public void setMaterial(XPolarMaterial material) {
/* 565 */     this.material = material.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public PolarItemStack addEnchant(XPolarEnchantment enchantment, int level) {
/* 570 */     if (enchantment != null) {
/* 571 */       this.enchantments.put(enchantment, Integer.valueOf(level));
/*     */     }
/* 573 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack addEnchant(PolarEnchantment enchantment, int level) {
/* 581 */     return addEnchant(XPolarEnchantment.fromName(enchantment.name()), level);
/*     */   }
/*     */   
/*     */   public PolarItemStack addPotionEffect(PolarPotionEffect potionEffect) {
/* 585 */     if (potionEffect != null) {
/* 586 */       this.potionEffects.add(potionEffect);
/*     */     }
/* 588 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public PolarItemStack addPotionEffect(PolarPotionEffectLegacy potionEffect) {
/* 596 */     return addPotionEffect(new PolarPotionEffect(
/* 597 */           XPolarPotion.fromName(potionEffect.getType().name()), potionEffect
/* 598 */           .getDuration(), potionEffect
/* 599 */           .getAmplifier(), potionEffect
/* 600 */           .isAmbient(), potionEffect
/* 601 */           .isParticles()));
/*     */   }
/*     */ 
/*     */   
/*     */   public PolarItemStack addLoreLine(String line) {
/* 606 */     if (!(this.lore instanceof ArrayList)) {
/* 607 */       if (this.lore == null) {
/* 608 */         this.lore = new ArrayList<>();
/*     */       } else {
/* 610 */         this.lore = new ArrayList<>(this.lore);
/*     */       } 
/*     */     }
/*     */     
/* 614 */     this.lore.add(line);
/*     */     
/* 616 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemStack addLoreLines(String... lines) {
/* 620 */     if (!(this.lore instanceof ArrayList)) {
/* 621 */       if (this.lore == null) {
/* 622 */         this.lore = new ArrayList<>();
/*     */       } else {
/* 624 */         this.lore = new ArrayList<>(this.lore);
/*     */       } 
/*     */     }
/*     */     
/* 628 */     this.lore.addAll(Arrays.asList(lines));
/*     */     
/* 630 */     return this;
/*     */   }
/*     */   
/*     */   public PolarItemStack addLoreLines(List<String> lines) {
/* 634 */     if (!(this.lore instanceof ArrayList)) {
/* 635 */       if (this.lore == null) {
/* 636 */         this.lore = new ArrayList<>();
/*     */       } else {
/* 638 */         this.lore = new ArrayList<>(this.lore);
/*     */       } 
/*     */     }
/*     */     
/* 642 */     this.lore.addAll(lines);
/*     */     
/* 644 */     return this;
/*     */   }
/*     */   
/*     */   public void hideAttribute(int attribute) {
/* 648 */     this.itemFlags.add(Integer.valueOf(attribute));
/*     */   }
/*     */   
/*     */   public PolarItemStack hideAttributes() {
/* 652 */     for (int i = 0; i < 6; i++) {
/* 653 */       this.itemFlags.add(Integer.valueOf(i));
/*     */     }
/*     */     
/* 656 */     return this;
/*     */   }
/*     */   
/*     */   public boolean hasDisplayName() {
/* 660 */     return (this.displayName != null && this.displayName.length() > 0);
/*     */   }
/*     */   
/*     */   public boolean hasLore() {
/* 664 */     return (this.lore != null && this.lore.size() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PolarItemStackBuilder builder() {
/* 676 */     return new PolarItemStackBuilder();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class PolarItemStackBuilder
/*     */   {
/*     */     private boolean material$set;
/*     */     
/*     */     private String material$value;
/*     */     private boolean amount$set;
/*     */     private int amount$value;
/*     */     private String displayName;
/*     */     private List<String> lore;
/*     */     private boolean enchanted;
/*     */     private String playerHead;
/*     */     private UUID skinUUID;
/*     */     private Color color;
/*     */     private short durability;
/* 695 */     private List<Integer> itemFlags = new ArrayList<>();
/* 696 */     private int customModelData = -1;
/* 697 */     private int slot = -1;
/*     */     
/*     */     private List<String> commands;
/*     */     
/*     */     private boolean display = true;
/*     */     
/*     */     private PolarItemNbt nbt;
/*     */     
/*     */     private List<PolarPotionEffect> potionEffects;
/*     */     
/*     */     private boolean splash = false;
/*     */     
/*     */     private Map<XPolarEnchantment, Integer> enchantments;
/*     */     private String serializedStack;
/*     */     
/*     */     @Deprecated
/*     */     public PolarItemStackBuilder material(String material) {
/* 714 */       this.material$value = material;
/* 715 */       this.material$set = true;
/* 716 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder material(XPolarMaterial material) {
/* 720 */       this.material$value = material.name();
/* 721 */       this.material$set = true;
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder amount(int amount) {
/* 726 */       this.amount$value = amount;
/* 727 */       this.amount$set = true;
/* 728 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder displayName(@Nullable String displayName) {
/* 732 */       this.displayName = displayName;
/* 733 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder lore(@Nullable List<String> lore) {
/* 737 */       this.lore = lore;
/* 738 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public PolarItemStackBuilder enchanted(boolean enchanted) {
/* 744 */       this.enchanted = enchanted;
/* 745 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder playerHead(String playerHead) {
/* 749 */       this.playerHead = playerHead;
/* 750 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder skinUUID(UUID skinUUID) {
/* 754 */       this.skinUUID = skinUUID;
/* 755 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder color(Color color) {
/* 759 */       this.color = color;
/* 760 */       return this;
/*     */     }
/*     */     
/*     */     @Deprecated
/*     */     public PolarItemStackBuilder durability(short durability) {
/* 765 */       this.durability = durability;
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder itemFlags(@NotNull List<Integer> itemFlags) {
/* 770 */       Preconditions.checkNotNull(itemFlags, "item flags are null");
/* 771 */       this.itemFlags = itemFlags;
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder customModelData(int customModelData) {
/* 776 */       this.customModelData = customModelData;
/* 777 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder slot(int slot) {
/* 781 */       this.slot = slot;
/* 782 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder commands(List<String> commands) {
/* 786 */       this.commands = commands;
/* 787 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder display(boolean display) {
/* 791 */       this.display = display;
/* 792 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder nbt(@Nullable PolarItemNbt nbt) {
/* 796 */       this.nbt = nbt;
/* 797 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder potionEffects(List<PolarPotionEffect> potionEffects) {
/* 801 */       this.potionEffects = potionEffects;
/* 802 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder splash(boolean splash) {
/* 806 */       this.splash = splash;
/* 807 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder enchantments(Map<XPolarEnchantment, Integer> enchantments) {
/* 811 */       this.enchantments = enchantments;
/* 812 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStackBuilder serializedStack(@Nullable String serializedStack) {
/* 816 */       this.serializedStack = serializedStack;
/* 817 */       return this;
/*     */     }
/*     */     
/*     */     public PolarItemStack build() {
/* 821 */       String material$value = this.material$value;
/* 822 */       if (!this.material$set) {
/* 823 */         material$value = "STONE";
/*     */       }
/*     */       
/* 826 */       int amount$value = this.amount$value;
/* 827 */       if (!this.amount$set) {
/* 828 */         amount$value = 1;
/*     */       }
/*     */       
/* 831 */       return new PolarItemStack(material$value, amount$value, this.displayName, this.lore, this.enchanted, this.playerHead, this.skinUUID, this.color, this.durability, this.itemFlags, this.customModelData, this.slot, this.commands, this.display, this.nbt, this.potionEffects, this.splash, this.enchantments, this.serializedStack);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 835 */       return "PolarItemStack.PolarItemStackBuilder(material$value=" + this.material$value + ", amount$value=" + this.amount$value + ", displayName=" + this.displayName + ", lore=" + this.lore + ", enchanted=" + this.enchanted + ", playerHead=" + this.playerHead + ", skinUUID=" + this.skinUUID + ", color=" + this.color + ", durability=" + this.durability + ", itemFlags=" + this.itemFlags + ", customModelData=" + this.customModelData + ", slot=" + this.slot + ", commands=" + this.commands + ", display=" + this.display + ", nbt=" + this.nbt + ", potionEffects=" + this.potionEffects + ", splash=" + this.splash + ", enchantments=" + this.enchantments + ", serializedStack=" + this.serializedStack + ")";
/*     */     }
/*     */   }
/*     */   
/*     */   public PolarItemStack(String material, int amount, @Nullable String displayName, @Nullable List<String> lore, boolean enchanted, String playerHead, UUID skinUUID, Color color, short durability, List<Integer> itemFlags, int customModelData, int slot, List<String> commands, boolean display, @Nullable PolarItemNbt nbt, List<PolarPotionEffect> potionEffects, boolean splash, Map<XPolarEnchantment, Integer> enchantments, @Nullable String serializedStack) {
/* 840 */     this.splash = false;
/* 841 */     this.material = material;
/* 842 */     this.amount = amount;
/* 843 */     this.displayName = displayName;
/* 844 */     this.lore = lore;
/* 845 */     this.enchanted = enchanted;
/* 846 */     this.playerHead = playerHead;
/* 847 */     this.skinUUID = skinUUID;
/* 848 */     this.color = color;
/* 849 */     this.durability = durability;
/* 850 */     this.customModelData = customModelData;
/* 851 */     this.slot = slot;
/* 852 */     this.commands = commands;
/* 853 */     this.display = display;
/*     */     
/* 855 */     if (itemFlags != null) {
/* 856 */       this.itemFlags.addAll(itemFlags);
/*     */     }
/* 858 */     this.nbt.merge(nbt);
/* 859 */     if (potionEffects != null) {
/* 860 */       this.potionEffects.addAll(potionEffects);
/*     */     }
/* 862 */     this.splash = splash;
/* 863 */     if (enchantments != null) {
/* 864 */       this.enchantments.putAll(enchantments);
/*     */     }
/* 866 */     this.serializedStack = serializedStack;
/*     */   }
/*     */   
/*     */   public PolarItemStack() {}
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\core\menu\PolarItemStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */