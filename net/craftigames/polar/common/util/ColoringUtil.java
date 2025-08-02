/*     */ package net.craftigames.polar.common.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.craftigames.polar.common.core.menu.PolarItemBuilder;
/*     */ import net.craftigames.polar.common.core.menu.PolarItemStack;
/*     */ import net.craftigames.polar.common.util.xseries.XPolarMaterial;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ColoringUtil
/*     */ {
/*  22 */   WHITE(15, XPolarMaterial.WHITE_WOOL, XPolarMaterial.WHITE_DYE, XPolarMaterial.WHITE_STAINED_GLASS_PANE, Color.WHITE, Color.WHITE),
/*  23 */   ORANGE(6, XPolarMaterial.ORANGE_WOOL, XPolarMaterial.ORANGE_DYE, XPolarMaterial.ORANGE_STAINED_GLASS_PANE, new Color(14188339), Color.ORANGE),
/*  24 */   MAGENTA(5, XPolarMaterial.MAGENTA_WOOL, XPolarMaterial.MAGENTA_DYE, XPolarMaterial.MAGENTA_STAINED_GLASS_PANE, new Color(11685080), Color.MAGENTA)
/*     */   {
/*     */     public boolean isDuplicate() {
/*  27 */       return true;
/*     */     }
/*     */   },
/*  30 */   LIGHT_BLUE(11, XPolarMaterial.LIGHT_BLUE_WOOL, XPolarMaterial.LIGHT_BLUE_DYE, XPolarMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, new Color(6724056), new Color(0, 255, 255), "Aqua")
/*     */   {
/*     */     public PolarItemStack getColorItem() {
/*  33 */       return new PolarItemStack(XPolarMaterial.DIAMOND);
/*     */     }
/*     */   },
/*  36 */   YELLOW(14, XPolarMaterial.YELLOW_WOOL, XPolarMaterial.YELLOW_DYE, XPolarMaterial.YELLOW_STAINED_GLASS_PANE, new Color(15066419), Color.YELLOW),
/*  37 */   LIME(10, XPolarMaterial.LIME_WOOL, XPolarMaterial.LIME_DYE, XPolarMaterial.LIME_STAINED_GLASS_PANE, new Color(8375321), new Color(100, 200, 0)),
/*  38 */   PINK(13, XPolarMaterial.PINK_WOOL, XPolarMaterial.PINK_DYE, XPolarMaterial.PINK_STAINED_GLASS_PANE, new Color(15892389), Color.PINK),
/*  39 */   GRAY(8, XPolarMaterial.GRAY_WOOL, XPolarMaterial.GRAY_DYE, XPolarMaterial.GRAY_STAINED_GLASS_PANE, new Color(5000268), Color.GRAY),
/*  40 */   SILVER(7, XPolarMaterial.LIGHT_GRAY_WOOL, XPolarMaterial.LIGHT_GRAY_DYE, XPolarMaterial.LIGHT_GRAY_STAINED_GLASS_PANE, new Color(10066329), Color.DARK_GRAY),
/*  41 */   CYAN(3, XPolarMaterial.CYAN_WOOL, XPolarMaterial.CYAN_DYE, XPolarMaterial.CYAN_STAINED_GLASS_PANE, new Color(5013401), new Color(0, 200, 200))
/*     */   {
/*     */     public PolarItemStack getColorItem() {
/*  44 */       return PolarItemStack.builder().material(XPolarMaterial.CYAN_DYE).build();
/*     */     }
/*     */   },
/*  47 */   PURPLE(5, XPolarMaterial.PURPLE_WOOL, XPolarMaterial.PURPLE_DYE, XPolarMaterial.PURPLE_STAINED_GLASS_PANE, new Color(8339378), new Color(85, 0, 175)),
/*  48 */   BLUE(9, XPolarMaterial.BLUE_WOOL, XPolarMaterial.BLUE_DYE, XPolarMaterial.BLUE_STAINED_GLASS_PANE, new Color(3361970), Color.BLUE)
/*     */   {
/*     */     public PolarItemStack getColorItem() {
/*  51 */       return PolarItemStack.builder().material(XPolarMaterial.BLUE_DYE).build();
/*     */     }
/*     */   },
/*  54 */   BROWN(6, XPolarMaterial.BROWN_WOOL, XPolarMaterial.BROWN_DYE, XPolarMaterial.BROWN_STAINED_GLASS_PANE, new Color(6704179), new Color(100, 50, 0))
/*     */   {
/*     */     public boolean isDuplicate() {
/*  57 */       return true;
/*     */     }
/*     */   },
/*  60 */   GREEN(2, XPolarMaterial.GREEN_WOOL, XPolarMaterial.GREEN_DYE, XPolarMaterial.GREEN_STAINED_GLASS_PANE, new Color(6717235), Color.GREEN),
/*  61 */   RED(12, XPolarMaterial.RED_WOOL, XPolarMaterial.RED_DYE, XPolarMaterial.RED_STAINED_GLASS_PANE, new Color(10040115), Color.RED),
/*  62 */   BLACK(0, XPolarMaterial.BLACK_WOOL, XPolarMaterial.BLACK_DYE, XPolarMaterial.BLACK_STAINED_GLASS_PANE, new Color(1644825), Color.BLACK),
/*     */ 
/*     */   
/*  65 */   DARK_RED(4, XPolarMaterial.RED_WOOL, XPolarMaterial.RED_DYE, XPolarMaterial.RED_STAINED_GLASS_PANE, new Color(9440782), new Color(128, 0, 0), "Crimson")
/*     */   {
/*     */     public PolarItemStack getColorItem() {
/*  68 */       return new PolarItemStack(XPolarMaterial.REDSTONE);
/*     */     }
/*     */   },
/*     */   
/*  72 */   DARK_BLUE(1, XPolarMaterial.BLUE_WOOL, XPolarMaterial.BLUE_DYE, XPolarMaterial.BLUE_STAINED_GLASS_PANE, new Color(3492240), new Color(0, 0, 175), "Navy")
/*     */   {
/*     */     public PolarItemStack getColorItem() {
/*  75 */       return new PolarItemStack(XPolarMaterial.LAPIS_BLOCK);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   WEALTHY(42, XPolarMaterial.LIME_WOOL, XPolarMaterial.LIME_DYE, XPolarMaterial.LIME_STAINED_GLASS_PANE, new Color(6717235), new Color(100, 200, 0)),
/*     */   
/*  86 */   FAIRY(213, XPolarMaterial.PURPLE_WOOL, XPolarMaterial.PURPLE_DYE, XPolarMaterial.PURPLE_STAINED_GLASS_PANE, new Color(8339378), new Color(85, 0, 175)),
/*     */   
/*  88 */   LOTUS(173, XPolarMaterial.LIME_WOOL, XPolarMaterial.LIME_DYE, XPolarMaterial.LIME_STAINED_GLASS_PANE, new Color(8375321), new Color(0, 255, 0)),
/*     */   
/*  90 */   DRACO(203, XPolarMaterial.LIGHT_BLUE_WOOL, XPolarMaterial.LIGHT_BLUE_DYE, XPolarMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, new Color(6724056), new Color(0, 255, 255)),
/*     */   
/*  92 */   YINYANG(248, XPolarMaterial.WHITE_WOOL, XPolarMaterial.WHITE_DYE, XPolarMaterial.WHITE_STAINED_GLASS_PANE, Color.WHITE, Color.WHITE),
/*     */   
/*  94 */   DEMONIC(200, XPolarMaterial.RED_WOOL, XPolarMaterial.RED_DYE, XPolarMaterial.RED_STAINED_GLASS_PANE, new Color(10040115), Color.RED),
/*     */ 
/*     */   
/*  97 */   GRADIENT_BLACK(24, XPolarMaterial.BLACK_WOOL, XPolarMaterial.BLACK_DYE, XPolarMaterial.BLACK_STAINED_GLASS_PANE, new Color(0), new Color(100, 100, 100), "Midnight")
/*     */   {
/*     */     public String toChatColor() {
/* 100 */       return "§0";
/*     */     }
/*     */   },
/*     */ 
/*     */   
/* 105 */   GRADIENT_BLUE(25, XPolarMaterial.BLUE_WOOL, XPolarMaterial.BLUE_DYE, XPolarMaterial.BLUE_STAINED_GLASS_PANE, new Color(3492240), new Color(0, 0, 175)),
/*     */ 
/*     */   
/* 108 */   GRADIENT_AQUA(59, XPolarMaterial.LIGHT_BLUE_WOOL, XPolarMaterial.LIGHT_BLUE_DYE, XPolarMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, new Color(5013401), new Color(0, 200, 200)),
/*     */ 
/*     */   
/* 111 */   GRADIENT_RED(76, XPolarMaterial.RED_WOOL, XPolarMaterial.RED_DYE, XPolarMaterial.RED_STAINED_GLASS_PANE, new Color(9440782), new Color(128, 0, 0)),
/*     */ 
/*     */   
/* 114 */   GRADIENT_PURPLE(93, XPolarMaterial.PURPLE_WOOL, XPolarMaterial.PURPLE_DYE, XPolarMaterial.PURPLE_STAINED_GLASS_PANE, new Color(8339378), new Color(85, 0, 175)),
/*     */ 
/*     */   
/* 117 */   GRADIENT_ORANGE(110, XPolarMaterial.ORANGE_WOOL, XPolarMaterial.ORANGE_DYE, XPolarMaterial.ORANGE_STAINED_GLASS_PANE, new Color(14188339), new Color(255, 255, 0)),
/*     */ 
/*     */   
/* 120 */   GRADIENT_SILVER(127, XPolarMaterial.LIGHT_GRAY_WOOL, XPolarMaterial.LIGHT_GRAY_DYE, XPolarMaterial.LIGHT_GRAY_STAINED_GLASS_PANE, new Color(10066329), new Color(255, 255, 255));
/*     */   
/*     */   public static final ColoringUtil[] CHATCOLOR_VIABLE;
/*     */   
/*     */   static {
/* 125 */     CHATCOLOR_VIABLE = new ColoringUtil[] { DARK_RED, RED, ORANGE, YELLOW, GREEN, LIME, LIGHT_BLUE, CYAN, BLUE, DARK_BLUE, PINK, PURPLE, WHITE, SILVER, GRAY, BLACK };
/*     */ 
/*     */ 
/*     */     
/* 129 */     TAG_COLOR = new ColoringUtil[] { BLACK, GRAY, SILVER, WHITE, DARK_RED, RED, ORANGE, YELLOW, GREEN, LIME, LIGHT_BLUE, CYAN, BLUE, DARK_BLUE, PINK, PURPLE, WEALTHY, FAIRY, LOTUS, DRACO, YINYANG, DEMONIC };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 280 */     CACHE = values();
/*     */   }
/*     */   
/*     */   public static final ColoringUtil[] TAG_COLOR;
/*     */   private final short chatColor;
/*     */   private final XPolarMaterial woolItem;
/*     */   private final XPolarMaterial dyeItem;
/*     */   private final XPolarMaterial paneItem;
/*     */   private final XPolarMaterial glassItem;
/*     */   private final Color minecraftColor;
/*     */   private final Color javaColor;
/*     */   private final String fancyName;
/*     */   public static final ColoringUtil[] CACHE;
/*     */   
/*     */   public short getChatColor() {
/*     */     return this.chatColor;
/*     */   }
/*     */   
/*     */   public XPolarMaterial getWoolItem() {
/*     */     return this.woolItem;
/*     */   }
/*     */   
/*     */   public XPolarMaterial getDyeItem() {
/*     */     return this.dyeItem;
/*     */   }
/*     */   
/*     */   public Color getMinecraftColor() {
/*     */     return this.minecraftColor;
/*     */   }
/*     */   
/*     */   public Color getJavaColor() {
/*     */     return this.javaColor;
/*     */   }
/*     */   
/*     */   public String getFancyName() {
/*     */     return this.fancyName;
/*     */   }
/*     */   
/*     */   ColoringUtil(int chatColor, XPolarMaterial woolItem, XPolarMaterial dyeItem, XPolarMaterial paneItem, Color minecraftColor, Color javaColor, String fancyName) {
/*     */     this.chatColor = (short)chatColor;
/*     */     this.woolItem = woolItem;
/*     */     this.dyeItem = dyeItem;
/*     */     this.paneItem = paneItem;
/*     */     this.glassItem = XPolarMaterial.valueOf(paneItem.name().substring(0, paneItem.name().lastIndexOf("_")));
/*     */     this.minecraftColor = minecraftColor;
/*     */     this.javaColor = javaColor;
/*     */     if (fancyName != null) {
/*     */       this.fancyName = fancyName;
/*     */     } else {
/*     */       this.fancyName = getName();
/*     */     } 
/*     */   }
/*     */   
/*     */   public PolarItemStack getWoolBlock() {
/*     */     return new PolarItemStack(this.woolItem);
/*     */   }
/*     */   
/*     */   public PolarItemStack getColorItem() {
/*     */     return new PolarItemStack(this.dyeItem);
/*     */   }
/*     */   
/*     */   public PolarItemStack getPaneItem() {
/*     */     return (new PolarItemBuilder(this.paneItem)).setDisplayName(" ").toItemStack();
/*     */   }
/*     */   
/*     */   public XPolarMaterial getGlassItem() {
/*     */     return this.glassItem;
/*     */   }
/*     */   
/*     */   public boolean isDuplicate() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public String getName() {
/*     */     return StringUtils.capitalize(name().toLowerCase().replace("_", " "));
/*     */   }
/*     */   
/*     */   public String toChatColor() {
/*     */     return '§' + Integer.toHexString(this.chatColor).substring(0, 1);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getSecondColor() {
/*     */     if (this.chatColor > 15)
/*     */       return '§' + Integer.toHexString(this.chatColor).substring(1, 2); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public String applyTo(String tag) {
/*     */     if (getSecondColor() == null)
/*     */       return toChatColor() + tag; 
/*     */     int middle = tag.length() / 2;
/*     */     if (tag.contains(" "))
/*     */       middle = tag.indexOf(' '); 
/*     */     return toChatColor() + tag.substring(0, middle) + getSecondColor() + tag.substring(middle);
/*     */   }
/*     */   
/*     */   public static ColoringUtil getFromChatColor(int color) {
/*     */     for (ColoringUtil coloringUtil : CACHE) {
/*     */       if (coloringUtil.chatColor == color)
/*     */         return coloringUtil; 
/*     */     } 
/*     */     return SILVER;
/*     */   }
/*     */   
/*     */   public static ColoringUtil getFromTagColor(int color) {
/*     */     for (ColoringUtil coloringUtil : TAG_COLOR) {
/*     */       if (coloringUtil.chatColor == color)
/*     */         return coloringUtil; 
/*     */     } 
/*     */     return SILVER;
/*     */   }
/*     */   
/*     */   public static ColoringUtil getFromViableChatColor(int color) {
/*     */     for (ColoringUtil coloringUtil : CHATCOLOR_VIABLE) {
/*     */       if (coloringUtil.chatColor == color)
/*     */         return coloringUtil; 
/*     */     } 
/*     */     return SILVER;
/*     */   }
/*     */   
/*     */   public static ColoringUtil getFromId(int id) {
/*     */     for (ColoringUtil coloringUtil : CACHE) {
/*     */       if (coloringUtil.ordinal() == id)
/*     */         return coloringUtil; 
/*     */     } 
/*     */     return SILVER;
/*     */   }
/*     */   
/*     */   public static ColoringUtil getFromName(String name) {
/*     */     for (ColoringUtil coloringUtil : CACHE) {
/*     */       if (coloringUtil.toString().equalsIgnoreCase(name))
/*     */         return coloringUtil; 
/*     */     } 
/*     */     return SILVER;
/*     */   }
/*     */   
/*     */   public ColoringUtil[] getGreenToRed(int options) {
/*     */     switch (options) {
/*     */       case 2:
/*     */         return new ColoringUtil[] { LIME, RED };
/*     */       case 3:
/*     */         return new ColoringUtil[] { LIME, YELLOW, RED };
/*     */       case 4:
/*     */         return new ColoringUtil[] { GREEN, LIME, RED, DARK_RED };
/*     */     } 
/*     */     List<ColoringUtil> list = new ArrayList<>(Arrays.asList(new ColoringUtil[] { GREEN, LIME }));
/*     */     for (int i = 4; i < options; i++)
/*     */       list.add(YELLOW); 
/*     */     list.addAll(Arrays.asList(new ColoringUtil[] { RED, DARK_RED }));
/*     */     return list.<ColoringUtil>toArray(new ColoringUtil[0]);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\ColoringUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */