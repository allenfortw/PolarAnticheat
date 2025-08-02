/*      */ package net.craftigames.polar.common.util.xseries;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import javax.annotation.Nonnull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public enum XPolarMaterial
/*      */ {
/*   13 */   ACACIA_BOAT(new String[] { "BOAT_ACACIA" }),
/*   14 */   ACACIA_BUTTON(new String[] { "WOOD_BUTTON" }),
/*   15 */   ACACIA_CHEST_BOAT(new String[0]),
/*   16 */   ACACIA_DOOR(new String[] { "ACACIA_DOOR", "ACACIA_DOOR_ITEM" }),
/*   17 */   ACACIA_FENCE(new String[0]),
/*   18 */   ACACIA_FENCE_GATE(new String[0]),
/*   19 */   ACACIA_LEAVES(0, new String[] { "LEAVES_2" }),
/*   20 */   ACACIA_LOG(0, new String[] { "LOG_2" }),
/*   21 */   ACACIA_PLANKS(4, new String[] { "WOOD" }),
/*   22 */   ACACIA_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/*   23 */   ACACIA_SAPLING(4, new String[] { "SAPLING" }),
/*   24 */   ACACIA_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/*   25 */   ACACIA_SLAB(4, new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/*   26 */   ACACIA_STAIRS(new String[0]),
/*   27 */   ACACIA_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/*   28 */   ACACIA_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*   29 */   ACACIA_WOOD(0, new String[] { "LOG_2" }),
/*   30 */   ACTIVATOR_RAIL(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   38 */   AIR(new String[0]),
/*   39 */   ALLAY_SPAWN_EGG(new String[0]),
/*   40 */   ALLIUM(2, new String[] { "RED_ROSE" }),
/*   41 */   AMETHYST_BLOCK(new String[0]),
/*   42 */   AMETHYST_CLUSTER(new String[0]),
/*   43 */   AMETHYST_SHARD(new String[0]),
/*   44 */   ANCIENT_DEBRIS(new String[0]),
/*   45 */   ANDESITE(5, new String[] { "STONE" }),
/*   46 */   ANDESITE_SLAB(new String[0]),
/*   47 */   ANDESITE_STAIRS(new String[0]),
/*   48 */   ANDESITE_WALL(new String[0]),
/*   49 */   ANVIL(new String[0]),
/*   50 */   APPLE(new String[0]),
/*   51 */   ARMOR_STAND(new String[0]),
/*   52 */   ARROW(new String[0]),
/*   53 */   ATTACHED_MELON_STEM(7, new String[] { "MELON_STEM" }),
/*   54 */   ATTACHED_PUMPKIN_STEM(7, new String[] { "PUMPKIN_STEM" }),
/*   55 */   AXOLOTL_BUCKET(new String[0]),
/*   56 */   AXOLOTL_SPAWN_EGG(new String[0]),
/*   57 */   AZALEA(new String[0]),
/*   58 */   AZALEA_LEAVES(new String[0]),
/*   59 */   AZURE_BLUET(3, new String[] { "RED_ROSE" }),
/*   60 */   BAKED_POTATO(new String[0]),
/*   61 */   BAMBOO(new String[0]),
/*   62 */   BAMBOO_SAPLING(new String[0]),
/*   63 */   BARREL(new String[0]),
/*   64 */   BARRIER(new String[0]),
/*   65 */   BASALT(new String[0]),
/*   66 */   BAT_SPAWN_EGG(65, new String[] { "MONSTER_EGG" }),
/*   67 */   BEACON(new String[0]),
/*   68 */   BEDROCK(new String[0]),
/*   69 */   BEEF(new String[] { "RAW_BEEF" }),
/*   70 */   BEEHIVE(new String[0]),
/*      */ 
/*      */ 
/*      */   
/*   74 */   BEETROOT(new String[] { "BEETROOT_BLOCK" }),
/*   75 */   BEETROOTS(new String[] { "BEETROOT" }),
/*   76 */   BEETROOT_SEEDS(new String[0]),
/*   77 */   BEETROOT_SOUP(new String[0]),
/*   78 */   BEE_NEST(new String[0]),
/*   79 */   BEE_SPAWN_EGG(new String[0]),
/*   80 */   BELL(new String[0]),
/*   81 */   BIG_DRIPLEAF(new String[0]),
/*   82 */   BIG_DRIPLEAF_STEM(new String[0]),
/*   83 */   BIRCH_BOAT(new String[] { "BOAT_BIRCH" }),
/*   84 */   BIRCH_BUTTON(new String[] { "WOOD_BUTTON" }),
/*   85 */   BIRCH_CHEST_BOAT(new String[0]),
/*   86 */   BIRCH_DOOR(new String[] { "BIRCH_DOOR", "BIRCH_DOOR_ITEM" }),
/*   87 */   BIRCH_FENCE(new String[0]),
/*   88 */   BIRCH_FENCE_GATE(new String[0]),
/*   89 */   BIRCH_LEAVES(2, new String[] { "LEAVES" }),
/*   90 */   BIRCH_LOG(2, new String[] { "LOG" }),
/*   91 */   BIRCH_PLANKS(2, new String[] { "WOOD" }),
/*   92 */   BIRCH_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/*   93 */   BIRCH_SAPLING(2, new String[] { "SAPLING" }),
/*   94 */   BIRCH_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/*   95 */   BIRCH_SLAB(2, new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/*   96 */   BIRCH_STAIRS(new String[] { "BIRCH_WOOD_STAIRS" }),
/*   97 */   BIRCH_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/*   98 */   BIRCH_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*   99 */   BIRCH_WOOD(2, new String[] { "LOG" }),
/*  100 */   BLACKSTONE(new String[0]),
/*  101 */   BLACKSTONE_SLAB(new String[0]),
/*  102 */   BLACKSTONE_STAIRS(new String[0]),
/*  103 */   BLACKSTONE_WALL(new String[0]),
/*  104 */   BLACK_BANNER(new String[] { "STANDING_BANNER", "BANNER"
/*      */ 
/*      */     
/*      */     }),
/*  108 */   BLACK_BED(supports(12) ? 15 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  109 */   BLACK_CANDLE(new String[0]),
/*  110 */   BLACK_CANDLE_CAKE(new String[0]),
/*  111 */   BLACK_CARPET(15, new String[] { "CARPET" }),
/*  112 */   BLACK_CONCRETE(15, new String[] { "CONCRETE" }),
/*  113 */   BLACK_CONCRETE_POWDER(15, new String[] { "CONCRETE_POWDER" }),
/*  114 */   BLACK_DYE(new String[0]),
/*  115 */   BLACK_GLAZED_TERRACOTTA(new String[0]),
/*  116 */   BLACK_SHULKER_BOX(new String[0]),
/*  117 */   BLACK_STAINED_GLASS(15, new String[] { "STAINED_GLASS" }),
/*  118 */   BLACK_STAINED_GLASS_PANE(15, new String[] { "STAINED_GLASS_PANE" }),
/*  119 */   BLACK_TERRACOTTA(15, new String[] { "STAINED_CLAY" }),
/*  120 */   BLACK_WALL_BANNER(new String[] { "WALL_BANNER" }),
/*  121 */   BLACK_WOOL(15, new String[] { "WOOL" }),
/*  122 */   BLAST_FURNACE(new String[0]),
/*  123 */   BLAZE_POWDER(new String[0]),
/*  124 */   BLAZE_ROD(new String[0]),
/*  125 */   BLAZE_SPAWN_EGG(61, new String[] { "MONSTER_EGG" }),
/*  126 */   BLUE_BANNER(4, new String[] { "STANDING_BANNER", "BANNER" }),
/*  127 */   BLUE_BED(supports(12) ? 11 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  128 */   BLUE_CANDLE(new String[0]),
/*  129 */   BLUE_CANDLE_CAKE(new String[0]),
/*  130 */   BLUE_CARPET(11, new String[] { "CARPET" }),
/*  131 */   BLUE_CONCRETE(11, new String[] { "CONCRETE" }),
/*  132 */   BLUE_CONCRETE_POWDER(11, new String[] { "CONCRETE_POWDER" }),
/*  133 */   BLUE_DYE(4, new String[] { "INK_SACK", "LAPIS_LAZULI" }),
/*  134 */   BLUE_GLAZED_TERRACOTTA(new String[0]),
/*  135 */   BLUE_ICE(new String[0]),
/*  136 */   BLUE_ORCHID(1, new String[] { "RED_ROSE" }),
/*  137 */   BLUE_SHULKER_BOX(new String[0]),
/*  138 */   BLUE_STAINED_GLASS(11, new String[] { "STAINED_GLASS" }),
/*  139 */   BLUE_STAINED_GLASS_PANE(11, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  140 */   BLUE_TERRACOTTA(11, new String[] { "STAINED_CLAY" }),
/*  141 */   BLUE_WALL_BANNER(4, new String[] { "WALL_BANNER" }),
/*  142 */   BLUE_WOOL(11, new String[] { "WOOL" }),
/*  143 */   BONE(new String[0]),
/*  144 */   BONE_BLOCK(new String[0]),
/*  145 */   BONE_MEAL(15, new String[] { "INK_SACK" }),
/*  146 */   BOOK(new String[0]),
/*  147 */   BOOKSHELF(new String[0]),
/*  148 */   BOW(new String[0]),
/*  149 */   BOWL(new String[0]),
/*  150 */   BRAIN_CORAL(new String[0]),
/*  151 */   BRAIN_CORAL_BLOCK(new String[0]),
/*  152 */   BRAIN_CORAL_FAN(new String[0]),
/*  153 */   BRAIN_CORAL_WALL_FAN(new String[0]),
/*  154 */   BREAD(new String[0]),
/*  155 */   BREWING_STAND(new String[] { "BREWING_STAND", "BREWING_STAND_ITEM" }),
/*  156 */   BRICK(new String[] { "CLAY_BRICK" }),
/*  157 */   BRICKS(new String[] { "BRICKS", "BRICK" }),
/*  158 */   BRICK_SLAB(4, new String[] { "STEP" }),
/*  159 */   BRICK_STAIRS(new String[0]),
/*  160 */   BRICK_WALL(new String[0]),
/*  161 */   BROWN_BANNER(3, new String[] { "STANDING_BANNER", "BANNER" }),
/*  162 */   BROWN_BED(supports(12) ? 12 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  163 */   BROWN_CANDLE(new String[0]),
/*  164 */   BROWN_CANDLE_CAKE(new String[0]),
/*  165 */   BROWN_CARPET(12, new String[] { "CARPET" }),
/*  166 */   BROWN_CONCRETE(12, new String[] { "CONCRETE" }),
/*  167 */   BROWN_CONCRETE_POWDER(12, new String[] { "CONCRETE_POWDER" }),
/*  168 */   BROWN_DYE(3, new String[] { "INK_SACK", "DYE", "COCOA_BEANS" }),
/*  169 */   BROWN_GLAZED_TERRACOTTA(new String[0]),
/*  170 */   BROWN_MUSHROOM(new String[0]),
/*  171 */   BROWN_MUSHROOM_BLOCK(new String[] { "BROWN_MUSHROOM", "HUGE_MUSHROOM_1" }),
/*  172 */   BROWN_SHULKER_BOX(new String[0]),
/*  173 */   BROWN_STAINED_GLASS(12, new String[] { "STAINED_GLASS" }),
/*  174 */   BROWN_STAINED_GLASS_PANE(12, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  175 */   BROWN_TERRACOTTA(12, new String[] { "STAINED_CLAY" }),
/*  176 */   BROWN_WALL_BANNER(3, new String[] { "WALL_BANNER" }),
/*  177 */   BROWN_WOOL(12, new String[] { "WOOL" }),
/*  178 */   BUBBLE_COLUMN(new String[0]),
/*  179 */   BUBBLE_CORAL(new String[0]),
/*  180 */   BUBBLE_CORAL_BLOCK(new String[0]),
/*  181 */   BUBBLE_CORAL_FAN(new String[0]),
/*  182 */   BUBBLE_CORAL_WALL_FAN(new String[0]),
/*  183 */   BUCKET(new String[0]),
/*  184 */   BUDDING_AMETHYST(new String[0]),
/*  185 */   BUNDLE(new String[0]),
/*  186 */   CACTUS(new String[0]),
/*  187 */   CAKE(new String[] { "CAKE_BLOCK" }),
/*  188 */   CALCITE(new String[0]),
/*  189 */   CAMPFIRE(new String[0]),
/*  190 */   CANDLE(new String[0]),
/*  191 */   CANDLE_CAKE(new String[0]),
/*  192 */   CARROT(new String[] { "CARROT_ITEM" }),
/*  193 */   CARROTS(new String[] { "CARROT" }),
/*  194 */   CARROT_ON_A_STICK(new String[] { "CARROT_STICK" }),
/*  195 */   CARTOGRAPHY_TABLE(new String[0]),
/*  196 */   CARVED_PUMPKIN(new String[0]),
/*  197 */   CAT_SPAWN_EGG(new String[0]),
/*  198 */   CAULDRON(new String[] { "CAULDRON", "CAULDRON_ITEM"
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  204 */   CAVE_AIR(new String[] { "AIR" }),
/*  205 */   CAVE_SPIDER_SPAWN_EGG(59, new String[] { "MONSTER_EGG" }),
/*  206 */   CAVE_VINES(new String[0]),
/*  207 */   CAVE_VINES_PLANT(new String[0]),
/*  208 */   CHAIN(new String[0]),
/*  209 */   CHAINMAIL_BOOTS(new String[0]),
/*  210 */   CHAINMAIL_CHESTPLATE(new String[0]),
/*  211 */   CHAINMAIL_HELMET(new String[0]),
/*  212 */   CHAINMAIL_LEGGINGS(new String[0]),
/*  213 */   CHAIN_COMMAND_BLOCK(new String[] { "COMMAND", "COMMAND_CHAIN" }),
/*  214 */   CHARCOAL(1, new String[] { "COAL" }),
/*  215 */   CHEST(new String[] { "LOCKED_CHEST" }),
/*  216 */   CHEST_MINECART(new String[] { "STORAGE_MINECART" }),
/*  217 */   CHICKEN(new String[] { "RAW_CHICKEN" }),
/*  218 */   CHICKEN_SPAWN_EGG(93, new String[] { "MONSTER_EGG" }),
/*  219 */   CHIPPED_ANVIL(1, new String[] { "ANVIL" }),
/*  220 */   CHISELED_DEEPSLATE(new String[0]),
/*  221 */   CHISELED_NETHER_BRICKS(1, new String[] { "NETHER_BRICKS" }),
/*  222 */   CHISELED_POLISHED_BLACKSTONE(new String[] { "POLISHED_BLACKSTONE" }),
/*  223 */   CHISELED_QUARTZ_BLOCK(1, new String[] { "QUARTZ_BLOCK" }),
/*  224 */   CHISELED_RED_SANDSTONE(1, new String[] { "RED_SANDSTONE" }),
/*  225 */   CHISELED_SANDSTONE(1, new String[] { "SANDSTONE" }),
/*  226 */   CHISELED_STONE_BRICKS(3, new String[] { "SMOOTH_BRICK" }),
/*  227 */   CHORUS_FLOWER(new String[0]),
/*  228 */   CHORUS_FRUIT(new String[0]),
/*  229 */   CHORUS_PLANT(new String[0]),
/*  230 */   CLAY(new String[0]),
/*  231 */   CLAY_BALL(new String[0]),
/*  232 */   CLOCK(new String[] { "WATCH" }),
/*  233 */   COAL(new String[0]),
/*  234 */   COAL_BLOCK(new String[0]),
/*  235 */   COAL_ORE(new String[0]),
/*  236 */   COARSE_DIRT(1, new String[] { "DIRT" }),
/*  237 */   COBBLED_DEEPSLATE(new String[0]),
/*  238 */   COBBLED_DEEPSLATE_SLAB(new String[0]),
/*  239 */   COBBLED_DEEPSLATE_STAIRS(new String[0]),
/*  240 */   COBBLED_DEEPSLATE_WALL(new String[0]),
/*  241 */   COBBLESTONE(new String[0]),
/*  242 */   COBBLESTONE_SLAB(3, new String[] { "STEP" }),
/*  243 */   COBBLESTONE_STAIRS(new String[0]),
/*  244 */   COBBLESTONE_WALL(new String[] { "COBBLE_WALL" }),
/*  245 */   COBWEB(new String[] { "WEB" }),
/*  246 */   COCOA(new String[0]),
/*  247 */   COCOA_BEANS(3, new String[] { "INK_SACK" }),
/*  248 */   COD(new String[] { "RAW_FISH" }),
/*  249 */   COD_BUCKET(new String[0]),
/*  250 */   COD_SPAWN_EGG(new String[0]),
/*  251 */   COMMAND_BLOCK(new String[] { "COMMAND" }),
/*  252 */   COMMAND_BLOCK_MINECART(new String[] { "COMMAND_MINECART"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  260 */   COMPARATOR(new String[] { "REDSTONE_COMPARATOR_OFF", "REDSTONE_COMPARATOR_ON", "REDSTONE_COMPARATOR" }),
/*  261 */   COMPASS(new String[0]),
/*  262 */   COMPOSTER(new String[0]),
/*  263 */   CONDUIT(new String[0]),
/*  264 */   COOKED_BEEF(new String[0]),
/*  265 */   COOKED_CHICKEN(new String[0]),
/*  266 */   COOKED_COD(new String[] { "COOKED_FISH" }),
/*  267 */   COOKED_MUTTON(new String[0]),
/*  268 */   COOKED_PORKCHOP(new String[] { "GRILLED_PORK" }),
/*  269 */   COOKED_RABBIT(new String[0]),
/*  270 */   COOKED_SALMON(1, new String[] { "COOKED_FISH" }),
/*  271 */   COOKIE(new String[0]),
/*  272 */   COPPER_BLOCK(new String[0]),
/*  273 */   COPPER_INGOT(new String[0]),
/*  274 */   COPPER_ORE(new String[0]),
/*  275 */   CORNFLOWER(new String[0]),
/*  276 */   COW_SPAWN_EGG(92, new String[] { "MONSTER_EGG" }),
/*  277 */   CRACKED_DEEPSLATE_BRICKS(new String[0]),
/*  278 */   CRACKED_DEEPSLATE_TILES(new String[0]),
/*  279 */   CRACKED_NETHER_BRICKS(2, new String[] { "NETHER_BRICKS" }),
/*  280 */   CRACKED_POLISHED_BLACKSTONE_BRICKS(new String[] { "POLISHED_BLACKSTONE_BRICKS" }),
/*  281 */   CRACKED_STONE_BRICKS(2, new String[] { "SMOOTH_BRICK" }),
/*  282 */   CRAFTING_TABLE(new String[] { "WORKBENCH" }),
/*  283 */   CREEPER_BANNER_PATTERN(new String[0]),
/*  284 */   CREEPER_HEAD(4, new String[] { "SKULL", "SKULL_ITEM" }),
/*  285 */   CREEPER_SPAWN_EGG(50, new String[] { "MONSTER_EGG" }),
/*  286 */   CREEPER_WALL_HEAD(4, new String[] { "SKULL", "SKULL_ITEM" }),
/*  287 */   CRIMSON_BUTTON(new String[0]),
/*  288 */   CRIMSON_DOOR(new String[0]),
/*  289 */   CRIMSON_FENCE(new String[0]),
/*  290 */   CRIMSON_FENCE_GATE(new String[0]),
/*  291 */   CRIMSON_FUNGUS(new String[0]),
/*  292 */   CRIMSON_HYPHAE(new String[0]),
/*  293 */   CRIMSON_NYLIUM(new String[0]),
/*  294 */   CRIMSON_PLANKS(new String[0]),
/*  295 */   CRIMSON_PRESSURE_PLATE(new String[0]),
/*  296 */   CRIMSON_ROOTS(new String[0]),
/*  297 */   CRIMSON_SIGN(new String[] { "SIGN_POST" }),
/*  298 */   CRIMSON_SLAB(new String[0]),
/*  299 */   CRIMSON_STAIRS(new String[0]),
/*  300 */   CRIMSON_STEM(new String[0]),
/*  301 */   CRIMSON_TRAPDOOR(new String[0]),
/*  302 */   CRIMSON_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*  303 */   CROSSBOW(new String[0]),
/*  304 */   CRYING_OBSIDIAN(new String[0]),
/*  305 */   CUT_COPPER(new String[0]),
/*  306 */   CUT_COPPER_SLAB(new String[0]),
/*  307 */   CUT_COPPER_STAIRS(new String[0]),
/*  308 */   CUT_RED_SANDSTONE(new String[0]),
/*  309 */   CUT_RED_SANDSTONE_SLAB(new String[] { "STONE_SLAB2" }),
/*  310 */   CUT_SANDSTONE(new String[0]),
/*  311 */   CUT_SANDSTONE_SLAB(1, new String[] { "STEP" }),
/*  312 */   CYAN_BANNER(6, new String[] { "STANDING_BANNER", "BANNER" }),
/*  313 */   CYAN_BED(supports(12) ? 9 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  314 */   CYAN_CANDLE(new String[0]),
/*  315 */   CYAN_CANDLE_CAKE(new String[0]),
/*  316 */   CYAN_CARPET(9, new String[] { "CARPET" }),
/*  317 */   CYAN_CONCRETE(9, new String[] { "CONCRETE" }),
/*  318 */   CYAN_CONCRETE_POWDER(9, new String[] { "CONCRETE_POWDER" }),
/*  319 */   CYAN_DYE(6, new String[] { "INK_SACK" }),
/*  320 */   CYAN_GLAZED_TERRACOTTA(new String[0]),
/*  321 */   CYAN_SHULKER_BOX(new String[0]),
/*  322 */   CYAN_STAINED_GLASS(9, new String[] { "STAINED_GLASS" }),
/*  323 */   CYAN_STAINED_GLASS_PANE(9, new String[] { "STAINED_GLASS_PANE" }),
/*  324 */   CYAN_TERRACOTTA(9, new String[] { "STAINED_CLAY" }),
/*  325 */   CYAN_WALL_BANNER(6, new String[] { "WALL_BANNER" }),
/*  326 */   CYAN_WOOL(9, new String[] { "WOOL" }),
/*  327 */   DAMAGED_ANVIL(2, new String[] { "ANVIL" }),
/*  328 */   DANDELION(new String[] { "YELLOW_FLOWER" }),
/*  329 */   DARK_OAK_BOAT(new String[] { "BOAT_DARK_OAK" }),
/*  330 */   DARK_OAK_BUTTON(new String[] { "WOOD_BUTTON" }),
/*  331 */   DARK_OAK_CHEST_BOAT(new String[0]),
/*  332 */   DARK_OAK_DOOR(new String[] { "DARK_OAK_DOOR", "DARK_OAK_DOOR_ITEM" }),
/*  333 */   DARK_OAK_FENCE(new String[0]),
/*  334 */   DARK_OAK_FENCE_GATE(new String[0]),
/*  335 */   DARK_OAK_LEAVES(1, new String[] { "LEAVES_2" }),
/*  336 */   DARK_OAK_LOG(1, new String[] { "LOG_2" }),
/*  337 */   DARK_OAK_PLANKS(5, new String[] { "WOOD" }),
/*  338 */   DARK_OAK_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/*  339 */   DARK_OAK_SAPLING(5, new String[] { "SAPLING" }),
/*  340 */   DARK_OAK_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/*  341 */   DARK_OAK_SLAB(5, new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/*  342 */   DARK_OAK_STAIRS(new String[0]),
/*  343 */   DARK_OAK_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/*  344 */   DARK_OAK_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*  345 */   DARK_OAK_WOOD(1, new String[] { "LOG_2" }),
/*  346 */   DARK_PRISMARINE(2, new String[] { "PRISMARINE" }),
/*  347 */   DARK_PRISMARINE_SLAB(new String[0]),
/*  348 */   DARK_PRISMARINE_STAIRS(new String[0]),
/*  349 */   DAYLIGHT_DETECTOR(new String[] { "DAYLIGHT_DETECTOR_INVERTED" }),
/*  350 */   DEAD_BRAIN_CORAL(new String[0]),
/*  351 */   DEAD_BRAIN_CORAL_BLOCK(new String[0]),
/*  352 */   DEAD_BRAIN_CORAL_FAN(new String[0]),
/*  353 */   DEAD_BRAIN_CORAL_WALL_FAN(new String[0]),
/*  354 */   DEAD_BUBBLE_CORAL(new String[0]),
/*  355 */   DEAD_BUBBLE_CORAL_BLOCK(new String[0]),
/*  356 */   DEAD_BUBBLE_CORAL_FAN(new String[0]),
/*  357 */   DEAD_BUBBLE_CORAL_WALL_FAN(new String[0]),
/*  358 */   DEAD_BUSH(new String[] { "LONG_GRASS" }),
/*  359 */   DEAD_FIRE_CORAL(new String[0]),
/*  360 */   DEAD_FIRE_CORAL_BLOCK(new String[0]),
/*  361 */   DEAD_FIRE_CORAL_FAN(new String[0]),
/*  362 */   DEAD_FIRE_CORAL_WALL_FAN(new String[0]),
/*  363 */   DEAD_HORN_CORAL(new String[0]),
/*  364 */   DEAD_HORN_CORAL_BLOCK(new String[0]),
/*  365 */   DEAD_HORN_CORAL_FAN(new String[0]),
/*  366 */   DEAD_HORN_CORAL_WALL_FAN(new String[0]),
/*  367 */   DEAD_TUBE_CORAL(new String[0]),
/*  368 */   DEAD_TUBE_CORAL_BLOCK(new String[0]),
/*  369 */   DEAD_TUBE_CORAL_FAN(new String[0]),
/*  370 */   DEAD_TUBE_CORAL_WALL_FAN(new String[0]),
/*  371 */   DEBUG_STICK(new String[0]),
/*  372 */   DEEPSLATE(new String[0]),
/*  373 */   DEEPSLATE_BRICKS(new String[0]),
/*  374 */   DEEPSLATE_BRICK_SLAB(new String[0]),
/*  375 */   DEEPSLATE_BRICK_STAIRS(new String[0]),
/*  376 */   DEEPSLATE_BRICK_WALL(new String[0]),
/*  377 */   DEEPSLATE_COAL_ORE(new String[0]),
/*  378 */   DEEPSLATE_COPPER_ORE(new String[0]),
/*  379 */   DEEPSLATE_DIAMOND_ORE(new String[0]),
/*  380 */   DEEPSLATE_EMERALD_ORE(new String[0]),
/*  381 */   DEEPSLATE_GOLD_ORE(new String[0]),
/*  382 */   DEEPSLATE_IRON_ORE(new String[0]),
/*  383 */   DEEPSLATE_LAPIS_ORE(new String[0]),
/*  384 */   DEEPSLATE_REDSTONE_ORE(new String[0]),
/*  385 */   DEEPSLATE_TILES(new String[0]),
/*  386 */   DEEPSLATE_TILE_SLAB(new String[0]),
/*  387 */   DEEPSLATE_TILE_STAIRS(new String[0]),
/*  388 */   DEEPSLATE_TILE_WALL(new String[0]),
/*  389 */   DETECTOR_RAIL(new String[0]),
/*  390 */   DIAMOND(new String[0]),
/*  391 */   DIAMOND_AXE(new String[0]),
/*  392 */   DIAMOND_BLOCK(new String[0]),
/*  393 */   DIAMOND_BOOTS(new String[0]),
/*  394 */   DIAMOND_CHESTPLATE(new String[0]),
/*  395 */   DIAMOND_HELMET(new String[0]),
/*  396 */   DIAMOND_HOE(new String[0]),
/*  397 */   DIAMOND_HORSE_ARMOR(new String[] { "DIAMOND_BARDING" }),
/*  398 */   DIAMOND_LEGGINGS(new String[0]),
/*  399 */   DIAMOND_ORE(new String[0]),
/*  400 */   DIAMOND_PICKAXE(new String[0]),
/*  401 */   DIAMOND_SHOVEL(new String[] { "DIAMOND_SPADE" }),
/*  402 */   DIAMOND_SWORD(new String[0]),
/*  403 */   DIORITE(3, new String[] { "STONE" }),
/*  404 */   DIORITE_SLAB(new String[0]),
/*  405 */   DIORITE_STAIRS(new String[0]),
/*  406 */   DIORITE_WALL(new String[0]),
/*  407 */   DIRT(new String[0]),
/*      */ 
/*      */ 
/*      */   
/*  411 */   DIRT_PATH(new String[] { "GRASS_PATH" }),
/*  412 */   DISC_FRAGMENT_5(new String[0]),
/*  413 */   DISPENSER(new String[0]),
/*  414 */   DOLPHIN_SPAWN_EGG(new String[0]),
/*  415 */   DONKEY_SPAWN_EGG(32, new String[] { "MONSTER_EGG" }),
/*  416 */   DRAGON_BREATH(new String[] { "DRAGONS_BREATH" }),
/*  417 */   DRAGON_EGG(new String[0]),
/*  418 */   DRAGON_HEAD(5, new String[] { "SKULL", "SKULL_ITEM" }),
/*  419 */   DRAGON_WALL_HEAD(5, new String[] { "SKULL", "SKULL_ITEM" }),
/*  420 */   DRIED_KELP(new String[0]),
/*  421 */   DRIED_KELP_BLOCK(new String[0]),
/*  422 */   DRIPSTONE_BLOCK(new String[0]),
/*  423 */   DROPPER(new String[0]),
/*  424 */   DROWNED_SPAWN_EGG(new String[0]),
/*  425 */   ECHO_SHARD(new String[0]),
/*  426 */   EGG(new String[0]),
/*  427 */   ELDER_GUARDIAN_SPAWN_EGG(4, new String[] { "MONSTER_EGG" }),
/*  428 */   ELYTRA(new String[0]),
/*  429 */   EMERALD(new String[0]),
/*  430 */   EMERALD_BLOCK(new String[0]),
/*  431 */   EMERALD_ORE(new String[0]),
/*  432 */   ENCHANTED_BOOK(new String[0]),
/*  433 */   ENCHANTED_GOLDEN_APPLE(1, new String[] { "GOLDEN_APPLE" }),
/*  434 */   ENCHANTING_TABLE(new String[] { "ENCHANTMENT_TABLE" }),
/*  435 */   ENDERMAN_SPAWN_EGG(58, new String[] { "MONSTER_EGG" }),
/*  436 */   ENDERMITE_SPAWN_EGG(67, new String[] { "MONSTER_EGG" }),
/*  437 */   ENDER_CHEST(new String[0]),
/*  438 */   ENDER_EYE(new String[] { "EYE_OF_ENDER" }),
/*  439 */   ENDER_PEARL(new String[0]),
/*  440 */   END_CRYSTAL(new String[0]),
/*  441 */   END_GATEWAY(new String[0]),
/*  442 */   END_PORTAL(new String[] { "ENDER_PORTAL" }),
/*  443 */   END_PORTAL_FRAME(new String[] { "ENDER_PORTAL_FRAME" }),
/*  444 */   END_ROD(new String[0]),
/*  445 */   END_STONE(new String[] { "ENDER_STONE" }),
/*  446 */   END_STONE_BRICKS(new String[] { "END_BRICKS" }),
/*  447 */   END_STONE_BRICK_SLAB(new String[0]),
/*  448 */   END_STONE_BRICK_STAIRS(new String[0]),
/*  449 */   END_STONE_BRICK_WALL(new String[0]),
/*  450 */   EVOKER_SPAWN_EGG(34, new String[] { "MONSTER_EGG" }),
/*  451 */   EXPERIENCE_BOTTLE(new String[] { "EXP_BOTTLE" }),
/*  452 */   EXPOSED_COPPER(new String[0]),
/*  453 */   EXPOSED_CUT_COPPER(new String[0]),
/*  454 */   EXPOSED_CUT_COPPER_SLAB(new String[0]),
/*  455 */   EXPOSED_CUT_COPPER_STAIRS(new String[0]),
/*  456 */   FARMLAND(new String[] { "SOIL" }),
/*  457 */   FEATHER(new String[0]),
/*  458 */   FERMENTED_SPIDER_EYE(new String[0]),
/*  459 */   FERN(2, new String[] { "LONG_GRASS"
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  466 */   FILLED_MAP(new String[] { "MAP" }),
/*  467 */   FIRE(new String[0]),
/*  468 */   FIREWORK_ROCKET(new String[] { "FIREWORK" }),
/*  469 */   FIREWORK_STAR(new String[] { "FIREWORK_CHARGE" }),
/*  470 */   FIRE_CHARGE(new String[] { "FIREBALL" }),
/*  471 */   FIRE_CORAL(new String[0]),
/*  472 */   FIRE_CORAL_BLOCK(new String[0]),
/*  473 */   FIRE_CORAL_FAN(new String[0]),
/*  474 */   FIRE_CORAL_WALL_FAN(new String[0]),
/*  475 */   FISHING_ROD(new String[0]),
/*  476 */   FLETCHING_TABLE(new String[0]),
/*  477 */   FLINT(new String[0]),
/*  478 */   FLINT_AND_STEEL(new String[0]),
/*  479 */   FLOWERING_AZALEA(new String[0]),
/*  480 */   FLOWERING_AZALEA_LEAVES(new String[0]),
/*  481 */   FLOWER_BANNER_PATTERN(new String[0]),
/*  482 */   FLOWER_POT(new String[] { "FLOWER_POT", "FLOWER_POT_ITEM" }),
/*  483 */   FOX_SPAWN_EGG(new String[0]),
/*  484 */   FROGSPAWN(new String[0]),
/*  485 */   FROG_SPAWN_EGG(new String[0]),
/*      */ 
/*      */ 
/*      */   
/*  489 */   FROSTED_ICE(new String[0]),
/*  490 */   FURNACE(new String[] { "BURNING_FURNACE" }),
/*  491 */   FURNACE_MINECART(new String[] { "POWERED_MINECART" }),
/*  492 */   GHAST_SPAWN_EGG(56, new String[] { "MONSTER_EGG" }),
/*  493 */   GHAST_TEAR(new String[0]),
/*  494 */   GILDED_BLACKSTONE(new String[0]),
/*  495 */   GLASS(new String[0]),
/*  496 */   GLASS_BOTTLE(new String[0]),
/*  497 */   GLASS_PANE(new String[] { "THIN_GLASS" }),
/*  498 */   GLISTERING_MELON_SLICE(new String[] { "SPECKLED_MELON" }),
/*  499 */   GLOBE_BANNER_PATTERN(new String[0]),
/*  500 */   GLOWSTONE(new String[0]),
/*  501 */   GLOWSTONE_DUST(new String[0]),
/*  502 */   GLOW_BERRIES(new String[0]),
/*  503 */   GLOW_INK_SAC(new String[0]),
/*  504 */   GLOW_ITEM_FRAME(new String[0]),
/*  505 */   GLOW_LICHEN(new String[0]),
/*  506 */   GLOW_SQUID_SPAWN_EGG(new String[0]),
/*  507 */   GOAT_HORN(new String[0]),
/*  508 */   GOAT_SPAWN_EGG(new String[0]),
/*  509 */   GOLDEN_APPLE(new String[0]),
/*  510 */   GOLDEN_AXE(new String[] { "GOLD_AXE" }),
/*  511 */   GOLDEN_BOOTS(new String[] { "GOLD_BOOTS" }),
/*  512 */   GOLDEN_CARROT(new String[0]),
/*  513 */   GOLDEN_CHESTPLATE(new String[] { "GOLD_CHESTPLATE" }),
/*  514 */   GOLDEN_HELMET(new String[] { "GOLD_HELMET" }),
/*  515 */   GOLDEN_HOE(new String[] { "GOLD_HOE" }),
/*  516 */   GOLDEN_HORSE_ARMOR(new String[] { "GOLD_BARDING" }),
/*  517 */   GOLDEN_LEGGINGS(new String[] { "GOLD_LEGGINGS" }),
/*  518 */   GOLDEN_PICKAXE(new String[] { "GOLD_PICKAXE" }),
/*  519 */   GOLDEN_SHOVEL(new String[] { "GOLD_SPADE" }),
/*  520 */   GOLDEN_SWORD(new String[] { "GOLD_SWORD" }),
/*  521 */   GOLD_BLOCK(new String[0]),
/*  522 */   GOLD_INGOT(new String[0]),
/*  523 */   GOLD_NUGGET(new String[0]),
/*  524 */   GOLD_ORE(new String[0]),
/*  525 */   GRANITE(1, new String[] { "STONE" }),
/*  526 */   GRANITE_SLAB(new String[0]),
/*  527 */   GRANITE_STAIRS(new String[0]),
/*  528 */   GRANITE_WALL(new String[0]),
/*  529 */   GRASS(1, new String[] { "LONG_GRASS" }),
/*  530 */   GRASS_BLOCK(new String[] { "GRASS" }),
/*  531 */   GRAVEL(new String[0]),
/*  532 */   GRAY_BANNER(8, new String[] { "STANDING_BANNER", "BANNER" }),
/*  533 */   GRAY_BED(supports(12) ? 7 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  534 */   GRAY_CANDLE(new String[0]),
/*  535 */   GRAY_CANDLE_CAKE(new String[0]),
/*  536 */   GRAY_CARPET(7, new String[] { "CARPET" }),
/*  537 */   GRAY_CONCRETE(7, new String[] { "CONCRETE" }),
/*  538 */   GRAY_CONCRETE_POWDER(7, new String[] { "CONCRETE_POWDER" }),
/*  539 */   GRAY_DYE(8, new String[] { "INK_SACK" }),
/*  540 */   GRAY_GLAZED_TERRACOTTA(new String[0]),
/*  541 */   GRAY_SHULKER_BOX(new String[0]),
/*  542 */   GRAY_STAINED_GLASS(7, new String[] { "STAINED_GLASS" }),
/*  543 */   GRAY_STAINED_GLASS_PANE(7, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  544 */   GRAY_TERRACOTTA(7, new String[] { "STAINED_CLAY" }),
/*  545 */   GRAY_WALL_BANNER(8, new String[] { "WALL_BANNER" }),
/*  546 */   GRAY_WOOL(7, new String[] { "WOOL" }),
/*  547 */   GREEN_BANNER(2, new String[] { "STANDING_BANNER", "BANNER" }),
/*  548 */   GREEN_BED(supports(12) ? 13 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  549 */   GREEN_CANDLE(new String[0]),
/*  550 */   GREEN_CANDLE_CAKE(new String[0]),
/*  551 */   GREEN_CARPET(13, new String[] { "CARPET" }),
/*  552 */   GREEN_CONCRETE(13, new String[] { "CONCRETE" }),
/*  553 */   GREEN_CONCRETE_POWDER(13, new String[] { "CONCRETE_POWDER"
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  558 */   GREEN_DYE(2, new String[] { "INK_SACK", "CACTUS_GREEN" }),
/*  559 */   GREEN_GLAZED_TERRACOTTA(new String[0]),
/*  560 */   GREEN_SHULKER_BOX(new String[0]),
/*  561 */   GREEN_STAINED_GLASS(13, new String[] { "STAINED_GLASS" }),
/*  562 */   GREEN_STAINED_GLASS_PANE(13, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  563 */   GREEN_TERRACOTTA(13, new String[] { "STAINED_CLAY" }),
/*  564 */   GREEN_WALL_BANNER(2, new String[] { "WALL_BANNER" }),
/*  565 */   GREEN_WOOL(13, new String[] { "WOOL" }),
/*  566 */   GRINDSTONE(new String[0]),
/*  567 */   GUARDIAN_SPAWN_EGG(68, new String[] { "MONSTER_EGG" }),
/*  568 */   GUNPOWDER(new String[] { "SULPHUR" }),
/*  569 */   HANGING_ROOTS(new String[0]),
/*  570 */   HAY_BLOCK(new String[0]),
/*  571 */   HEART_OF_THE_SEA(new String[0]),
/*  572 */   HEAVY_WEIGHTED_PRESSURE_PLATE(new String[] { "IRON_PLATE" }),
/*  573 */   HOGLIN_SPAWN_EGG(new String[] { "MONSTER_EGG" }),
/*  574 */   HONEYCOMB(new String[0]),
/*  575 */   HONEYCOMB_BLOCK(new String[0]),
/*  576 */   HONEY_BLOCK(new String[0]),
/*  577 */   HONEY_BOTTLE(new String[0]),
/*  578 */   HOPPER(new String[0]),
/*  579 */   HOPPER_MINECART(new String[0]),
/*  580 */   HORN_CORAL(new String[0]),
/*  581 */   HORN_CORAL_BLOCK(new String[0]),
/*  582 */   HORN_CORAL_FAN(new String[0]),
/*  583 */   HORN_CORAL_WALL_FAN(new String[0]),
/*  584 */   HORSE_SPAWN_EGG(100, new String[] { "MONSTER_EGG" }),
/*  585 */   HUSK_SPAWN_EGG(23, new String[] { "MONSTER_EGG" }),
/*  586 */   ICE(new String[0]),
/*  587 */   INFESTED_CHISELED_STONE_BRICKS(5, new String[] { "MONSTER_EGGS" }),
/*  588 */   INFESTED_COBBLESTONE(1, new String[] { "MONSTER_EGGS" }),
/*  589 */   INFESTED_CRACKED_STONE_BRICKS(4, new String[] { "MONSTER_EGGS" }),
/*  590 */   INFESTED_DEEPSLATE(new String[0]),
/*  591 */   INFESTED_MOSSY_STONE_BRICKS(3, new String[] { "MONSTER_EGGS" }),
/*  592 */   INFESTED_STONE(new String[] { "MONSTER_EGGS" }),
/*  593 */   INFESTED_STONE_BRICKS(2, new String[] { "MONSTER_EGGS"
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  599 */   INK_SAC(new String[] { "INK_SACK" }),
/*  600 */   IRON_AXE(new String[0]),
/*  601 */   IRON_BARS(new String[] { "IRON_FENCE" }),
/*  602 */   IRON_BLOCK(new String[0]),
/*  603 */   IRON_BOOTS(new String[0]),
/*  604 */   IRON_CHESTPLATE(new String[0]),
/*  605 */   IRON_DOOR(new String[] { "IRON_DOOR_BLOCK" }),
/*  606 */   IRON_HELMET(new String[0]),
/*  607 */   IRON_HOE(new String[0]),
/*  608 */   IRON_HORSE_ARMOR(new String[] { "IRON_BARDING" }),
/*  609 */   IRON_INGOT(new String[0]),
/*  610 */   IRON_LEGGINGS(new String[0]),
/*  611 */   IRON_NUGGET(new String[0]),
/*  612 */   IRON_ORE(new String[0]),
/*  613 */   IRON_PICKAXE(new String[0]),
/*  614 */   IRON_SHOVEL(new String[] { "IRON_SPADE" }),
/*  615 */   IRON_SWORD(new String[0]),
/*  616 */   IRON_TRAPDOOR(new String[0]),
/*  617 */   ITEM_FRAME(new String[0]),
/*  618 */   JACK_O_LANTERN(new String[0]),
/*  619 */   JIGSAW(new String[0]),
/*  620 */   JUKEBOX(new String[0]),
/*  621 */   JUNGLE_BOAT(new String[] { "BOAT_JUNGLE" }),
/*  622 */   JUNGLE_BUTTON(new String[] { "WOOD_BUTTON" }),
/*  623 */   JUNGLE_CHEST_BOAT(new String[0]),
/*  624 */   JUNGLE_DOOR(new String[] { "JUNGLE_DOOR", "JUNGLE_DOOR_ITEM" }),
/*  625 */   JUNGLE_FENCE(new String[0]),
/*  626 */   JUNGLE_FENCE_GATE(new String[0]),
/*  627 */   JUNGLE_LEAVES(3, new String[] { "LEAVES" }),
/*  628 */   JUNGLE_LOG(3, new String[] { "LOG" }),
/*  629 */   JUNGLE_PLANKS(3, new String[] { "WOOD" }),
/*  630 */   JUNGLE_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/*  631 */   JUNGLE_SAPLING(3, new String[] { "SAPLING" }),
/*  632 */   JUNGLE_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/*  633 */   JUNGLE_SLAB(3, new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/*  634 */   JUNGLE_STAIRS(new String[] { "JUNGLE_WOOD_STAIRS" }),
/*  635 */   JUNGLE_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/*  636 */   JUNGLE_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*  637 */   JUNGLE_WOOD(3, new String[] { "LOG" }),
/*  638 */   KELP(new String[0]),
/*  639 */   KELP_PLANT(new String[0]),
/*  640 */   KNOWLEDGE_BOOK(new String[] { "BOOK" }),
/*  641 */   LADDER(new String[0]),
/*  642 */   LANTERN(new String[0]),
/*  643 */   LAPIS_BLOCK(new String[0]),
/*  644 */   LAPIS_LAZULI(4, new String[] { "INK_SACK" }),
/*  645 */   LAPIS_ORE(new String[0]),
/*  646 */   LARGE_AMETHYST_BUD(new String[0]),
/*  647 */   LARGE_FERN(3, new String[] { "DOUBLE_PLANT" }),
/*  648 */   LAVA(new String[] { "STATIONARY_LAVA" }),
/*  649 */   LAVA_BUCKET(new String[0]),
/*  650 */   LAVA_CAULDRON(new String[0]),
/*  651 */   LEAD(new String[] { "LEASH" }),
/*  652 */   LEATHER(new String[0]),
/*  653 */   LEATHER_BOOTS(new String[0]),
/*  654 */   LEATHER_CHESTPLATE(new String[0]),
/*  655 */   LEATHER_HELMET(new String[0]),
/*  656 */   LEATHER_HORSE_ARMOR(new String[] { "IRON_HORSE_ARMOR" }),
/*  657 */   LEATHER_LEGGINGS(new String[0]),
/*  658 */   LECTERN(new String[0]),
/*  659 */   LEVER(new String[0]),
/*  660 */   LIGHT(new String[0]),
/*  661 */   LIGHTNING_ROD(new String[0]),
/*  662 */   LIGHT_BLUE_BANNER(12, new String[] { "STANDING_BANNER", "BANNER" }),
/*  663 */   LIGHT_BLUE_BED(supports(12) ? 3 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  664 */   LIGHT_BLUE_CANDLE(new String[0]),
/*  665 */   LIGHT_BLUE_CANDLE_CAKE(new String[0]),
/*  666 */   LIGHT_BLUE_CARPET(3, new String[] { "CARPET" }),
/*  667 */   LIGHT_BLUE_CONCRETE(3, new String[] { "CONCRETE" }),
/*  668 */   LIGHT_BLUE_CONCRETE_POWDER(3, new String[] { "CONCRETE_POWDER" }),
/*  669 */   LIGHT_BLUE_DYE(12, new String[] { "INK_SACK" }),
/*  670 */   LIGHT_BLUE_GLAZED_TERRACOTTA(new String[0]),
/*  671 */   LIGHT_BLUE_SHULKER_BOX(new String[0]),
/*  672 */   LIGHT_BLUE_STAINED_GLASS(3, new String[] { "STAINED_GLASS" }),
/*  673 */   LIGHT_BLUE_STAINED_GLASS_PANE(3, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  674 */   LIGHT_BLUE_TERRACOTTA(3, new String[] { "STAINED_CLAY" }),
/*  675 */   LIGHT_BLUE_WALL_BANNER(12, new String[] { "WALL_BANNER", "STANDING_BANNER", "BANNER" }),
/*  676 */   LIGHT_BLUE_WOOL(3, new String[] { "WOOL" }),
/*  677 */   LIGHT_GRAY_BANNER(7, new String[] { "STANDING_BANNER", "BANNER" }),
/*  678 */   LIGHT_GRAY_BED(supports(12) ? 8 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  679 */   LIGHT_GRAY_CANDLE(new String[0]),
/*  680 */   LIGHT_GRAY_CANDLE_CAKE(new String[0]),
/*  681 */   LIGHT_GRAY_CARPET(8, new String[] { "CARPET" }),
/*  682 */   LIGHT_GRAY_CONCRETE(8, new String[] { "CONCRETE" }),
/*  683 */   LIGHT_GRAY_CONCRETE_POWDER(8, new String[] { "CONCRETE_POWDER" }),
/*  684 */   LIGHT_GRAY_DYE(7, new String[] { "INK_SACK"
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/*  689 */   LIGHT_GRAY_GLAZED_TERRACOTTA(new String[] { "SILVER_GLAZED_TERRACOTTA" }),
/*  690 */   LIGHT_GRAY_SHULKER_BOX(new String[] { "SILVER_SHULKER_BOX" }),
/*  691 */   LIGHT_GRAY_STAINED_GLASS(8, new String[] { "STAINED_GLASS" }),
/*  692 */   LIGHT_GRAY_STAINED_GLASS_PANE(8, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  693 */   LIGHT_GRAY_TERRACOTTA(8, new String[] { "STAINED_CLAY" }),
/*  694 */   LIGHT_GRAY_WALL_BANNER(7, new String[] { "WALL_BANNER" }),
/*  695 */   LIGHT_GRAY_WOOL(8, new String[] { "WOOL" }),
/*  696 */   LIGHT_WEIGHTED_PRESSURE_PLATE(new String[] { "GOLD_PLATE" }),
/*  697 */   LILAC(1, new String[] { "DOUBLE_PLANT" }),
/*  698 */   LILY_OF_THE_VALLEY(new String[0]),
/*  699 */   LILY_PAD(new String[] { "WATER_LILY" }),
/*  700 */   LIME_BANNER(10, new String[] { "STANDING_BANNER", "BANNER" }),
/*  701 */   LIME_BED(supports(12) ? 5 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  702 */   LIME_CANDLE(new String[0]),
/*  703 */   LIME_CANDLE_CAKE(new String[0]),
/*  704 */   LIME_CARPET(5, new String[] { "CARPET" }),
/*  705 */   LIME_CONCRETE(5, new String[] { "CONCRETE" }),
/*  706 */   LIME_CONCRETE_POWDER(5, new String[] { "CONCRETE_POWDER" }),
/*  707 */   LIME_DYE(10, new String[] { "INK_SACK" }),
/*  708 */   LIME_GLAZED_TERRACOTTA(new String[0]),
/*  709 */   LIME_SHULKER_BOX(new String[0]),
/*  710 */   LIME_STAINED_GLASS(5, new String[] { "STAINED_GLASS" }),
/*  711 */   LIME_STAINED_GLASS_PANE(5, new String[] { "STAINED_GLASS_PANE" }),
/*  712 */   LIME_TERRACOTTA(5, new String[] { "STAINED_CLAY" }),
/*  713 */   LIME_WALL_BANNER(10, new String[] { "WALL_BANNER" }),
/*  714 */   LIME_WOOL(5, new String[] { "WOOL" }),
/*  715 */   LINGERING_POTION(new String[0]),
/*  716 */   LLAMA_SPAWN_EGG(103, new String[] { "MONSTER_EGG" }),
/*  717 */   LODESTONE(new String[0]),
/*  718 */   LOOM(new String[0]),
/*  719 */   MAGENTA_BANNER(13, new String[] { "STANDING_BANNER", "BANNER" }),
/*  720 */   MAGENTA_BED(supports(12) ? 2 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  721 */   MAGENTA_CANDLE(new String[0]),
/*  722 */   MAGENTA_CANDLE_CAKE(new String[0]),
/*  723 */   MAGENTA_CARPET(2, new String[] { "CARPET" }),
/*  724 */   MAGENTA_CONCRETE(2, new String[] { "CONCRETE" }),
/*  725 */   MAGENTA_CONCRETE_POWDER(2, new String[] { "CONCRETE_POWDER" }),
/*  726 */   MAGENTA_DYE(13, new String[] { "INK_SACK" }),
/*  727 */   MAGENTA_GLAZED_TERRACOTTA(new String[0]),
/*  728 */   MAGENTA_SHULKER_BOX(new String[0]),
/*  729 */   MAGENTA_STAINED_GLASS(2, new String[] { "STAINED_GLASS" }),
/*  730 */   MAGENTA_STAINED_GLASS_PANE(2, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  731 */   MAGENTA_TERRACOTTA(2, new String[] { "STAINED_CLAY" }),
/*  732 */   MAGENTA_WALL_BANNER(13, new String[] { "WALL_BANNER" }),
/*  733 */   MAGENTA_WOOL(2, new String[] { "WOOL" }),
/*  734 */   MAGMA_BLOCK(new String[] { "MAGMA" }),
/*  735 */   MAGMA_CREAM(new String[0]),
/*  736 */   MAGMA_CUBE_SPAWN_EGG(62, new String[] { "MONSTER_EGG" }),
/*  737 */   MANGROVE_BOAT(new String[0]),
/*  738 */   MANGROVE_BUTTON(new String[0]),
/*  739 */   MANGROVE_CHEST_BOAT(new String[0]),
/*  740 */   MANGROVE_DOOR(new String[0]),
/*  741 */   MANGROVE_FENCE(new String[0]),
/*  742 */   MANGROVE_FENCE_GATE(new String[0]),
/*  743 */   MANGROVE_LEAVES(new String[0]),
/*  744 */   MANGROVE_LOG(new String[0]),
/*  745 */   MANGROVE_PLANKS(new String[0]),
/*  746 */   MANGROVE_PRESSURE_PLATE(new String[0]),
/*  747 */   MANGROVE_PROPAGULE(new String[0]),
/*  748 */   MANGROVE_ROOTS(new String[0]),
/*  749 */   MANGROVE_SIGN(new String[0]),
/*  750 */   MANGROVE_SLAB(new String[0]),
/*  751 */   MANGROVE_STAIRS(new String[0]),
/*  752 */   MANGROVE_TRAPDOOR(new String[0]),
/*  753 */   MANGROVE_WALL_SIGN(new String[0]),
/*  754 */   MANGROVE_WOOD(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  762 */   MAP(new String[] { "EMPTY_MAP" }),
/*  763 */   MEDIUM_AMETHYST_BUD(new String[0]),
/*  764 */   MELON(new String[] { "MELON_BLOCK" }),
/*  765 */   MELON_SEEDS(new String[0]),
/*  766 */   MELON_SLICE(new String[] { "MELON" }),
/*  767 */   MELON_STEM(new String[0]),
/*  768 */   MILK_BUCKET(new String[0]),
/*  769 */   MINECART(new String[0]),
/*  770 */   MOJANG_BANNER_PATTERN(new String[0]),
/*  771 */   MOOSHROOM_SPAWN_EGG(96, new String[] { "MONSTER_EGG" }),
/*  772 */   MOSSY_COBBLESTONE(new String[0]),
/*  773 */   MOSSY_COBBLESTONE_SLAB(new String[0]),
/*  774 */   MOSSY_COBBLESTONE_STAIRS(new String[0]),
/*  775 */   MOSSY_COBBLESTONE_WALL(1, new String[] { "COBBLE_WALL", "COBBLESTONE_WALL" }),
/*  776 */   MOSSY_STONE_BRICKS(1, new String[] { "SMOOTH_BRICK" }),
/*  777 */   MOSSY_STONE_BRICK_SLAB(new String[0]),
/*  778 */   MOSSY_STONE_BRICK_STAIRS(new String[0]),
/*  779 */   MOSSY_STONE_BRICK_WALL(new String[0]),
/*  780 */   MOSS_BLOCK(new String[0]),
/*  781 */   MOSS_CARPET(new String[0]),
/*  782 */   MOVING_PISTON(new String[] { "PISTON_MOVING_PIECE" }),
/*  783 */   MUD(new String[0]),
/*  784 */   MUDDY_MANGROVE_ROOTS(new String[0]),
/*  785 */   MUD_BRICKS(new String[0]),
/*  786 */   MUD_BRICK_SLAB(new String[0]),
/*  787 */   MUD_BRICK_STAIRS(new String[0]),
/*  788 */   MUD_BRICK_WALL(new String[0]),
/*  789 */   MULE_SPAWN_EGG(32, new String[] { "MONSTER_EGG" }),
/*  790 */   MUSHROOM_STEM(new String[] { "BROWN_MUSHROOM" }),
/*  791 */   MUSHROOM_STEW(new String[] { "MUSHROOM_SOUP" }),
/*  792 */   MUSIC_DISC_11(new String[] { "RECORD_11" }),
/*  793 */   MUSIC_DISC_13(new String[] { "GOLD_RECORD" }),
/*  794 */   MUSIC_DISC_5(new String[0]),
/*  795 */   MUSIC_DISC_BLOCKS(new String[] { "RECORD_3" }),
/*  796 */   MUSIC_DISC_CAT(new String[] { "GREEN_RECORD" }),
/*  797 */   MUSIC_DISC_CHIRP(new String[] { "RECORD_4" }),
/*  798 */   MUSIC_DISC_FAR(new String[] { "RECORD_5" }),
/*  799 */   MUSIC_DISC_MALL(new String[] { "RECORD_6" }),
/*  800 */   MUSIC_DISC_MELLOHI(new String[] { "RECORD_7" }),
/*  801 */   MUSIC_DISC_OTHERSIDE(new String[0]),
/*  802 */   MUSIC_DISC_PIGSTEP(new String[0]),
/*  803 */   MUSIC_DISC_STAL(new String[] { "RECORD_8" }),
/*  804 */   MUSIC_DISC_STRAD(new String[] { "RECORD_9" }),
/*  805 */   MUSIC_DISC_WAIT(new String[] { "RECORD_12" }),
/*  806 */   MUSIC_DISC_WARD(new String[] { "RECORD_10" }),
/*  807 */   MUTTON(new String[0]),
/*  808 */   MYCELIUM(new String[] { "MYCEL" }),
/*  809 */   NAME_TAG(new String[0]),
/*  810 */   NAUTILUS_SHELL(new String[0]),
/*  811 */   NETHERITE_AXE(new String[0]),
/*  812 */   NETHERITE_BLOCK(new String[0]),
/*  813 */   NETHERITE_BOOTS(new String[0]),
/*  814 */   NETHERITE_CHESTPLATE(new String[0]),
/*  815 */   NETHERITE_HELMET(new String[0]),
/*  816 */   NETHERITE_HOE(new String[0]),
/*  817 */   NETHERITE_INGOT(new String[0]),
/*  818 */   NETHERITE_LEGGINGS(new String[0]),
/*  819 */   NETHERITE_PICKAXE(new String[0]),
/*  820 */   NETHERITE_SCRAP(new String[0]),
/*  821 */   NETHERITE_SHOVEL(new String[0]),
/*  822 */   NETHERITE_SWORD(new String[0]),
/*  823 */   NETHERRACK(new String[0]),
/*  824 */   NETHER_BRICK(new String[] { "NETHER_BRICK_ITEM" }),
/*  825 */   NETHER_BRICKS(new String[] { "NETHER_BRICK" }),
/*  826 */   NETHER_BRICK_FENCE(new String[] { "NETHER_FENCE" }),
/*  827 */   NETHER_BRICK_SLAB(6, new String[] { "STEP" }),
/*  828 */   NETHER_BRICK_STAIRS(new String[0]),
/*  829 */   NETHER_BRICK_WALL(new String[0]),
/*  830 */   NETHER_GOLD_ORE(new String[0]),
/*  831 */   NETHER_PORTAL(new String[] { "PORTAL" }),
/*  832 */   NETHER_QUARTZ_ORE(new String[] { "QUARTZ_ORE" }),
/*  833 */   NETHER_SPROUTS(new String[0]),
/*  834 */   NETHER_STAR(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  840 */   NETHER_WART(new String[] { "NETHER_WARTS", "NETHER_STALK" }),
/*  841 */   NETHER_WART_BLOCK(new String[0]),
/*  842 */   NOTE_BLOCK(new String[0]),
/*  843 */   OAK_BOAT(new String[] { "BOAT" }),
/*  844 */   OAK_BUTTON(new String[] { "WOOD_BUTTON" }),
/*  845 */   OAK_CHEST_BOAT(new String[0]),
/*  846 */   OAK_DOOR(new String[] { "WOODEN_DOOR", "WOOD_DOOR" }),
/*  847 */   OAK_FENCE(new String[] { "FENCE" }),
/*  848 */   OAK_FENCE_GATE(new String[] { "FENCE_GATE" }),
/*  849 */   OAK_LEAVES(new String[] { "LEAVES" }),
/*  850 */   OAK_LOG(new String[] { "LOG" }),
/*  851 */   OAK_PLANKS(new String[] { "WOOD" }),
/*  852 */   OAK_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/*  853 */   OAK_SAPLING(new String[] { "SAPLING" }),
/*  854 */   OAK_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/*  855 */   OAK_SLAB(new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/*  856 */   OAK_STAIRS(new String[] { "WOOD_STAIRS" }),
/*  857 */   OAK_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/*  858 */   OAK_WALL_SIGN(new String[] { "WALL_SIGN" }),
/*  859 */   OAK_WOOD(new String[] { "LOG" }),
/*  860 */   OBSERVER(new String[0]),
/*  861 */   OBSIDIAN(new String[0]),
/*  862 */   OCELOT_SPAWN_EGG(98, new String[] { "MONSTER_EGG" }),
/*  863 */   OCHRE_FROGLIGHT(new String[0]),
/*  864 */   ORANGE_BANNER(14, new String[] { "STANDING_BANNER", "BANNER" }),
/*  865 */   ORANGE_BED(supports(12) ? 1 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  866 */   ORANGE_CANDLE(new String[0]),
/*  867 */   ORANGE_CANDLE_CAKE(new String[0]),
/*  868 */   ORANGE_CARPET(1, new String[] { "CARPET" }),
/*  869 */   ORANGE_CONCRETE(1, new String[] { "CONCRETE" }),
/*  870 */   ORANGE_CONCRETE_POWDER(1, new String[] { "CONCRETE_POWDER" }),
/*  871 */   ORANGE_DYE(14, new String[] { "INK_SACK" }),
/*  872 */   ORANGE_GLAZED_TERRACOTTA(new String[0]),
/*  873 */   ORANGE_SHULKER_BOX(new String[0]),
/*  874 */   ORANGE_STAINED_GLASS(1, new String[] { "STAINED_GLASS" }),
/*  875 */   ORANGE_STAINED_GLASS_PANE(1, new String[] { "STAINED_GLASS_PANE" }),
/*  876 */   ORANGE_TERRACOTTA(1, new String[] { "STAINED_CLAY" }),
/*  877 */   ORANGE_TULIP(5, new String[] { "RED_ROSE" }),
/*  878 */   ORANGE_WALL_BANNER(14, new String[] { "WALL_BANNER" }),
/*  879 */   ORANGE_WOOL(1, new String[] { "WOOL" }),
/*  880 */   OXEYE_DAISY(8, new String[] { "RED_ROSE" }),
/*  881 */   OXIDIZED_COPPER(new String[0]),
/*  882 */   OXIDIZED_CUT_COPPER(new String[0]),
/*  883 */   OXIDIZED_CUT_COPPER_SLAB(new String[0]),
/*  884 */   OXIDIZED_CUT_COPPER_STAIRS(new String[0]),
/*  885 */   PACKED_ICE(new String[0]),
/*  886 */   PACKED_MUD(new String[0]),
/*  887 */   PAINTING(new String[0]),
/*  888 */   PANDA_SPAWN_EGG(new String[0]),
/*  889 */   PAPER(new String[0]),
/*  890 */   PARROT_SPAWN_EGG(105, new String[] { "MONSTER_EGG" }),
/*  891 */   PEARLESCENT_FROGLIGHT(new String[0]),
/*  892 */   PEONY(5, new String[] { "DOUBLE_PLANT" }),
/*  893 */   PETRIFIED_OAK_SLAB(new String[] { "WOOD_STEP" }),
/*  894 */   PHANTOM_MEMBRANE(new String[0]),
/*  895 */   PHANTOM_SPAWN_EGG(new String[0]),
/*  896 */   PIGLIN_BANNER_PATTERN(new String[0]),
/*  897 */   PIGLIN_BRUTE_SPAWN_EGG(new String[0]),
/*  898 */   PIGLIN_SPAWN_EGG(57, new String[] { "MONSTER_EGG" }),
/*  899 */   PIG_SPAWN_EGG(90, new String[] { "MONSTER_EGG" }),
/*  900 */   PILLAGER_SPAWN_EGG(new String[0]),
/*  901 */   PINK_BANNER(9, new String[] { "STANDING_BANNER", "BANNER" }),
/*  902 */   PINK_BED(supports(12) ? 6 : 0, new String[] { "BED_BLOCK", "BED" }),
/*  903 */   PINK_CANDLE(new String[0]),
/*  904 */   PINK_CANDLE_CAKE(new String[0]),
/*  905 */   PINK_CARPET(6, new String[] { "CARPET" }),
/*  906 */   PINK_CONCRETE(6, new String[] { "CONCRETE" }),
/*  907 */   PINK_CONCRETE_POWDER(6, new String[] { "CONCRETE_POWDER" }),
/*  908 */   PINK_DYE(9, new String[] { "INK_SACK" }),
/*  909 */   PINK_GLAZED_TERRACOTTA(new String[0]),
/*  910 */   PINK_SHULKER_BOX(new String[0]),
/*  911 */   PINK_STAINED_GLASS(6, new String[] { "STAINED_GLASS" }),
/*  912 */   PINK_STAINED_GLASS_PANE(6, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/*  913 */   PINK_TERRACOTTA(6, new String[] { "STAINED_CLAY" }),
/*  914 */   PINK_TULIP(7, new String[] { "RED_ROSE" }),
/*  915 */   PINK_WALL_BANNER(9, new String[] { "WALL_BANNER" }),
/*  916 */   PINK_WOOL(6, new String[] { "WOOL" }),
/*  917 */   PISTON(new String[] { "PISTON_BASE" }),
/*  918 */   PISTON_HEAD(new String[] { "PISTON_EXTENSION" }),
/*  919 */   PLAYER_HEAD(3, new String[] { "SKULL", "SKULL_ITEM" }),
/*  920 */   PLAYER_WALL_HEAD(3, new String[] { "SKULL", "SKULL_ITEM" }),
/*  921 */   PODZOL(2, new String[] { "DIRT" }),
/*  922 */   POINTED_DRIPSTONE(new String[0]),
/*  923 */   POISONOUS_POTATO(new String[0]),
/*  924 */   POLAR_BEAR_SPAWN_EGG(102, new String[] { "MONSTER_EGG" }),
/*  925 */   POLISHED_ANDESITE(6, new String[] { "STONE" }),
/*  926 */   POLISHED_ANDESITE_SLAB(new String[0]),
/*  927 */   POLISHED_ANDESITE_STAIRS(new String[0]),
/*  928 */   POLISHED_BASALT(new String[0]),
/*  929 */   POLISHED_BLACKSTONE(new String[0]),
/*  930 */   POLISHED_BLACKSTONE_BRICKS(new String[0]),
/*  931 */   POLISHED_BLACKSTONE_BRICK_SLAB(new String[0]),
/*  932 */   POLISHED_BLACKSTONE_BRICK_STAIRS(new String[0]),
/*  933 */   POLISHED_BLACKSTONE_BRICK_WALL(new String[0]),
/*  934 */   POLISHED_BLACKSTONE_BUTTON(new String[0]),
/*  935 */   POLISHED_BLACKSTONE_PRESSURE_PLATE(new String[0]),
/*  936 */   POLISHED_BLACKSTONE_SLAB(new String[0]),
/*  937 */   POLISHED_BLACKSTONE_STAIRS(new String[0]),
/*  938 */   POLISHED_BLACKSTONE_WALL(new String[0]),
/*  939 */   POLISHED_DEEPSLATE(new String[0]),
/*  940 */   POLISHED_DEEPSLATE_SLAB(new String[0]),
/*  941 */   POLISHED_DEEPSLATE_STAIRS(new String[0]),
/*  942 */   POLISHED_DEEPSLATE_WALL(new String[0]),
/*  943 */   POLISHED_DIORITE(4, new String[] { "STONE" }),
/*  944 */   POLISHED_DIORITE_SLAB(new String[0]),
/*  945 */   POLISHED_DIORITE_STAIRS(new String[0]),
/*  946 */   POLISHED_GRANITE(2, new String[] { "STONE" }),
/*  947 */   POLISHED_GRANITE_SLAB(new String[0]),
/*  948 */   POLISHED_GRANITE_STAIRS(new String[0]),
/*  949 */   POPPED_CHORUS_FRUIT(new String[] { "CHORUS_FRUIT_POPPED" }),
/*  950 */   POPPY(new String[] { "RED_ROSE" }),
/*  951 */   PORKCHOP(new String[] { "PORK" }),
/*  952 */   POTATO(new String[] { "POTATO_ITEM" }),
/*  953 */   POTATOES(new String[] { "POTATO" }),
/*  954 */   POTION(new String[0]),
/*  955 */   POTTED_ACACIA_SAPLING(4, new String[] { "FLOWER_POT" }),
/*  956 */   POTTED_ALLIUM(2, new String[] { "FLOWER_POT" }),
/*  957 */   POTTED_AZALEA_BUSH(new String[0]),
/*  958 */   POTTED_AZURE_BLUET(3, new String[] { "FLOWER_POT" }),
/*  959 */   POTTED_BAMBOO(new String[0]),
/*  960 */   POTTED_BIRCH_SAPLING(2, new String[] { "FLOWER_POT" }),
/*  961 */   POTTED_BLUE_ORCHID(1, new String[] { "FLOWER_POT" }),
/*  962 */   POTTED_BROWN_MUSHROOM(new String[] { "FLOWER_POT" }),
/*  963 */   POTTED_CACTUS(new String[] { "FLOWER_POT" }),
/*  964 */   POTTED_CORNFLOWER(new String[0]),
/*  965 */   POTTED_CRIMSON_FUNGUS(new String[0]),
/*  966 */   POTTED_CRIMSON_ROOTS(new String[0]),
/*  967 */   POTTED_DANDELION(new String[] { "FLOWER_POT" }),
/*  968 */   POTTED_DARK_OAK_SAPLING(5, new String[] { "FLOWER_POT" }),
/*  969 */   POTTED_DEAD_BUSH(new String[] { "FLOWER_POT" }),
/*  970 */   POTTED_FERN(2, new String[] { "FLOWER_POT" }),
/*  971 */   POTTED_FLOWERING_AZALEA_BUSH(new String[0]),
/*  972 */   POTTED_JUNGLE_SAPLING(3, new String[] { "FLOWER_POT" }),
/*  973 */   POTTED_LILY_OF_THE_VALLEY(new String[0]),
/*  974 */   POTTED_MANGROVE_PROPAGULE(new String[0]),
/*  975 */   POTTED_OAK_SAPLING(new String[] { "FLOWER_POT" }),
/*  976 */   POTTED_ORANGE_TULIP(5, new String[] { "FLOWER_POT" }),
/*  977 */   POTTED_OXEYE_DAISY(8, new String[] { "FLOWER_POT" }),
/*  978 */   POTTED_PINK_TULIP(7, new String[] { "FLOWER_POT" }),
/*  979 */   POTTED_POPPY(new String[] { "FLOWER_POT" }),
/*  980 */   POTTED_RED_MUSHROOM(new String[] { "FLOWER_POT" }),
/*  981 */   POTTED_RED_TULIP(4, new String[] { "FLOWER_POT" }),
/*  982 */   POTTED_SPRUCE_SAPLING(1, new String[] { "FLOWER_POT" }),
/*  983 */   POTTED_WARPED_FUNGUS(new String[0]),
/*  984 */   POTTED_WARPED_ROOTS(new String[0]),
/*  985 */   POTTED_WHITE_TULIP(6, new String[] { "FLOWER_POT" }),
/*  986 */   POTTED_WITHER_ROSE(new String[0]),
/*  987 */   POWDER_SNOW(new String[0]),
/*  988 */   POWDER_SNOW_BUCKET(new String[0]),
/*  989 */   POWDER_SNOW_CAULDRON(new String[0]),
/*  990 */   POWERED_RAIL(new String[0]),
/*  991 */   PRISMARINE(new String[0]),
/*  992 */   PRISMARINE_BRICKS(1, new String[] { "PRISMARINE" }),
/*  993 */   PRISMARINE_BRICK_SLAB(new String[0]),
/*  994 */   PRISMARINE_BRICK_STAIRS(new String[0]),
/*  995 */   PRISMARINE_CRYSTALS(new String[0]),
/*  996 */   PRISMARINE_SHARD(new String[0]),
/*  997 */   PRISMARINE_SLAB(new String[0]),
/*  998 */   PRISMARINE_STAIRS(new String[0]),
/*  999 */   PRISMARINE_WALL(new String[0]),
/* 1000 */   PUFFERFISH(3, new String[] { "RAW_FISH" }),
/* 1001 */   PUFFERFISH_BUCKET(new String[0]),
/* 1002 */   PUFFERFISH_SPAWN_EGG(new String[0]),
/* 1003 */   PUMPKIN(new String[0]),
/* 1004 */   PUMPKIN_PIE(new String[0]),
/* 1005 */   PUMPKIN_SEEDS(new String[0]),
/* 1006 */   PUMPKIN_STEM(new String[0]),
/* 1007 */   PURPLE_BANNER(5, new String[] { "STANDING_BANNER", "BANNER" }),
/* 1008 */   PURPLE_BED(supports(12) ? 10 : 0, new String[] { "BED_BLOCK", "BED" }),
/* 1009 */   PURPLE_CANDLE(new String[0]),
/* 1010 */   PURPLE_CANDLE_CAKE(new String[0]),
/* 1011 */   PURPLE_CARPET(10, new String[] { "CARPET" }),
/* 1012 */   PURPLE_CONCRETE(10, new String[] { "CONCRETE" }),
/* 1013 */   PURPLE_CONCRETE_POWDER(10, new String[] { "CONCRETE_POWDER" }),
/* 1014 */   PURPLE_DYE(5, new String[] { "INK_SACK" }),
/* 1015 */   PURPLE_GLAZED_TERRACOTTA(new String[0]),
/* 1016 */   PURPLE_SHULKER_BOX(new String[0]),
/* 1017 */   PURPLE_STAINED_GLASS(10, new String[] { "STAINED_GLASS" }),
/* 1018 */   PURPLE_STAINED_GLASS_PANE(10, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/* 1019 */   PURPLE_TERRACOTTA(10, new String[] { "STAINED_CLAY" }),
/* 1020 */   PURPLE_WALL_BANNER(5, new String[] { "WALL_BANNER" }),
/* 1021 */   PURPLE_WOOL(10, new String[] { "WOOL" }),
/* 1022 */   PURPUR_BLOCK(new String[0]),
/* 1023 */   PURPUR_PILLAR(new String[0]),
/* 1024 */   PURPUR_SLAB(new String[] { "PURPUR_DOUBLE_SLAB" }),
/* 1025 */   PURPUR_STAIRS(new String[0]),
/* 1026 */   QUARTZ(new String[0]),
/* 1027 */   QUARTZ_BLOCK(new String[0]),
/* 1028 */   QUARTZ_BRICKS(new String[0]),
/* 1029 */   QUARTZ_PILLAR(2, new String[] { "QUARTZ_BLOCK" }),
/* 1030 */   QUARTZ_SLAB(7, new String[] { "STEP" }),
/* 1031 */   QUARTZ_STAIRS(new String[0]),
/* 1032 */   RABBIT(new String[0]),
/* 1033 */   RABBIT_FOOT(new String[0]),
/* 1034 */   RABBIT_HIDE(new String[0]),
/* 1035 */   RABBIT_SPAWN_EGG(101, new String[] { "MONSTER_EGG" }),
/* 1036 */   RABBIT_STEW(new String[0]),
/* 1037 */   RAIL(new String[] { "RAILS" }),
/* 1038 */   RAVAGER_SPAWN_EGG(new String[0]),
/* 1039 */   RAW_COPPER(new String[0]),
/* 1040 */   RAW_COPPER_BLOCK(new String[0]),
/* 1041 */   RAW_GOLD(new String[0]),
/* 1042 */   RAW_GOLD_BLOCK(new String[0]),
/* 1043 */   RAW_IRON(new String[0]),
/* 1044 */   RAW_IRON_BLOCK(new String[0]),
/* 1045 */   RECOVERY_COMPASS(new String[0]),
/* 1046 */   REDSTONE(new String[0]),
/* 1047 */   REDSTONE_BLOCK(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1054 */   REDSTONE_LAMP(new String[] { "REDSTONE_LAMP_ON", "REDSTONE_LAMP_OFF" }),
/* 1055 */   REDSTONE_ORE(new String[] { "GLOWING_REDSTONE_ORE"
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/* 1061 */   REDSTONE_TORCH(new String[] { "REDSTONE_TORCH_OFF", "REDSTONE_TORCH_ON" }),
/* 1062 */   REDSTONE_WALL_TORCH(new String[0]),
/* 1063 */   REDSTONE_WIRE(new String[0]),
/* 1064 */   RED_BANNER(1, new String[] { "STANDING_BANNER", "BANNER"
/*      */ 
/*      */     
/*      */     }),
/* 1068 */   RED_BED(supports(12) ? 14 : 0, new String[] { "BED_BLOCK", "BED" }),
/* 1069 */   RED_CANDLE(new String[0]),
/* 1070 */   RED_CANDLE_CAKE(new String[0]),
/* 1071 */   RED_CARPET(14, new String[] { "CARPET" }),
/* 1072 */   RED_CONCRETE(14, new String[] { "CONCRETE" }),
/* 1073 */   RED_CONCRETE_POWDER(14, new String[] { "CONCRETE_POWDER"
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/* 1078 */   RED_DYE(1, new String[] { "INK_SACK", "ROSE_RED" }),
/* 1079 */   RED_GLAZED_TERRACOTTA(new String[0]),
/* 1080 */   RED_MUSHROOM(new String[0]),
/* 1081 */   RED_MUSHROOM_BLOCK(new String[] { "RED_MUSHROOM", "HUGE_MUSHROOM_2" }),
/* 1082 */   RED_NETHER_BRICKS(new String[] { "RED_NETHER_BRICK" }),
/* 1083 */   RED_NETHER_BRICK_SLAB(new String[0]),
/* 1084 */   RED_NETHER_BRICK_STAIRS(new String[0]),
/* 1085 */   RED_NETHER_BRICK_WALL(new String[0]),
/* 1086 */   RED_SAND(1, new String[] { "SAND" }),
/* 1087 */   RED_SANDSTONE(new String[0]),
/* 1088 */   RED_SANDSTONE_SLAB(new String[] { "DOUBLE_STONE_SLAB2", "STONE_SLAB2" }),
/* 1089 */   RED_SANDSTONE_STAIRS(new String[0]),
/* 1090 */   RED_SANDSTONE_WALL(new String[0]),
/* 1091 */   RED_SHULKER_BOX(new String[0]),
/* 1092 */   RED_STAINED_GLASS(14, new String[] { "STAINED_GLASS" }),
/* 1093 */   RED_STAINED_GLASS_PANE(14, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/* 1094 */   RED_TERRACOTTA(14, new String[] { "STAINED_CLAY" }),
/* 1095 */   RED_TULIP(4, new String[] { "RED_ROSE" }),
/* 1096 */   RED_WALL_BANNER(1, new String[] { "WALL_BANNER" }),
/* 1097 */   RED_WOOL(14, new String[] { "WOOL" }),
/* 1098 */   REINFORCED_DEEPSLATE(new String[0]),
/* 1099 */   REPEATER(new String[] { "DIODE_BLOCK_ON", "DIODE_BLOCK_OFF", "DIODE" }),
/* 1100 */   REPEATING_COMMAND_BLOCK(new String[] { "COMMAND", "COMMAND_REPEATING" }),
/* 1101 */   RESPAWN_ANCHOR(new String[0]),
/* 1102 */   ROOTED_DIRT(new String[0]),
/* 1103 */   ROSE_BUSH(4, new String[] { "DOUBLE_PLANT" }),
/* 1104 */   ROTTEN_FLESH(new String[0]),
/* 1105 */   SADDLE(new String[0]),
/* 1106 */   SALMON(1, new String[] { "RAW_FISH" }),
/* 1107 */   SALMON_BUCKET(new String[0]),
/* 1108 */   SALMON_SPAWN_EGG(new String[0]),
/* 1109 */   SAND(new String[0]),
/* 1110 */   SANDSTONE(new String[0]),
/* 1111 */   SANDSTONE_SLAB(1, new String[] { "DOUBLE_STEP", "STEP", "STONE_SLAB" }),
/* 1112 */   SANDSTONE_STAIRS(new String[0]),
/* 1113 */   SANDSTONE_WALL(new String[0]),
/* 1114 */   SCAFFOLDING(new String[0]),
/* 1115 */   SCULK(new String[0]),
/* 1116 */   SCULK_CATALYST(new String[0]),
/* 1117 */   SCULK_SENSOR(new String[0]),
/* 1118 */   SCULK_SHRIEKER(new String[0]),
/* 1119 */   SCULK_VEIN(new String[0]),
/* 1120 */   SCUTE(new String[0]),
/* 1121 */   SEAGRASS(new String[0]),
/* 1122 */   SEA_LANTERN(new String[0]),
/* 1123 */   SEA_PICKLE(new String[0]),
/* 1124 */   SHEARS(new String[0]),
/* 1125 */   SHEEP_SPAWN_EGG(91, new String[] { "MONSTER_EGG" }),
/* 1126 */   SHIELD(new String[0]),
/* 1127 */   SHROOMLIGHT(new String[0]),
/* 1128 */   SHULKER_BOX(new String[] { "PURPLE_SHULKER_BOX" }),
/* 1129 */   SHULKER_SHELL(new String[0]),
/* 1130 */   SHULKER_SPAWN_EGG(69, new String[] { "MONSTER_EGG" }),
/* 1131 */   SILVERFISH_SPAWN_EGG(60, new String[] { "MONSTER_EGG" }),
/* 1132 */   SKELETON_HORSE_SPAWN_EGG(28, new String[] { "MONSTER_EGG" }),
/* 1133 */   SKELETON_SKULL(new String[] { "SKULL", "SKULL_ITEM" }),
/* 1134 */   SKELETON_SPAWN_EGG(51, new String[] { "MONSTER_EGG" }),
/* 1135 */   SKELETON_WALL_SKULL(new String[] { "SKULL", "SKULL_ITEM" }),
/* 1136 */   SKULL_BANNER_PATTERN(new String[0]),
/* 1137 */   SLIME_BALL(new String[0]),
/* 1138 */   SLIME_BLOCK(new String[0]),
/* 1139 */   SLIME_SPAWN_EGG(55, new String[] { "MONSTER_EGG" }),
/* 1140 */   SMALL_AMETHYST_BUD(new String[0]),
/* 1141 */   SMALL_DRIPLEAF(new String[0]),
/* 1142 */   SMITHING_TABLE(new String[0]),
/* 1143 */   SMOKER(new String[0]),
/* 1144 */   SMOOTH_BASALT(new String[0]),
/* 1145 */   SMOOTH_QUARTZ(new String[0]),
/* 1146 */   SMOOTH_QUARTZ_SLAB(new String[0]),
/* 1147 */   SMOOTH_QUARTZ_STAIRS(new String[0]),
/* 1148 */   SMOOTH_RED_SANDSTONE(2, new String[] { "RED_SANDSTONE" }),
/* 1149 */   SMOOTH_RED_SANDSTONE_SLAB(new String[] { "STONE_SLAB2" }),
/* 1150 */   SMOOTH_RED_SANDSTONE_STAIRS(new String[0]),
/* 1151 */   SMOOTH_SANDSTONE(2, new String[] { "SANDSTONE" }),
/* 1152 */   SMOOTH_SANDSTONE_SLAB(new String[0]),
/* 1153 */   SMOOTH_SANDSTONE_STAIRS(new String[0]),
/* 1154 */   SMOOTH_STONE(new String[0]),
/* 1155 */   SMOOTH_STONE_SLAB(new String[0]),
/* 1156 */   SNOW(new String[0]),
/* 1157 */   SNOWBALL(new String[] { "SNOW_BALL" }),
/* 1158 */   SNOW_BLOCK(new String[0]),
/* 1159 */   SOUL_CAMPFIRE(new String[0]),
/* 1160 */   SOUL_FIRE(new String[0]),
/* 1161 */   SOUL_LANTERN(new String[0]),
/* 1162 */   SOUL_SAND(new String[0]),
/* 1163 */   SOUL_SOIL(new String[0]),
/* 1164 */   SOUL_TORCH(new String[0]),
/* 1165 */   SOUL_WALL_TORCH(new String[0]),
/* 1166 */   SPAWNER(new String[] { "MOB_SPAWNER" }),
/* 1167 */   SPECTRAL_ARROW(new String[0]),
/* 1168 */   SPIDER_EYE(new String[0]),
/* 1169 */   SPIDER_SPAWN_EGG(52, new String[] { "MONSTER_EGG" }),
/* 1170 */   SPLASH_POTION(new String[0]),
/* 1171 */   SPONGE(new String[0]),
/* 1172 */   SPORE_BLOSSOM(new String[0]),
/* 1173 */   SPRUCE_BOAT(new String[] { "BOAT_SPRUCE" }),
/* 1174 */   SPRUCE_BUTTON(new String[] { "WOOD_BUTTON" }),
/* 1175 */   SPRUCE_CHEST_BOAT(new String[0]),
/* 1176 */   SPRUCE_DOOR(new String[] { "SPRUCE_DOOR", "SPRUCE_DOOR_ITEM" }),
/* 1177 */   SPRUCE_FENCE(new String[0]),
/* 1178 */   SPRUCE_FENCE_GATE(new String[0]),
/* 1179 */   SPRUCE_LEAVES(1, new String[] { "LEAVES" }),
/* 1180 */   SPRUCE_LOG(1, new String[] { "LOG" }),
/* 1181 */   SPRUCE_PLANKS(1, new String[] { "WOOD" }),
/* 1182 */   SPRUCE_PRESSURE_PLATE(new String[] { "WOOD_PLATE" }),
/* 1183 */   SPRUCE_SAPLING(1, new String[] { "SAPLING" }),
/* 1184 */   SPRUCE_SIGN(new String[] { "SIGN_POST", "SIGN" }),
/* 1185 */   SPRUCE_SLAB(1, new String[] { "WOOD_DOUBLE_STEP", "WOOD_STEP", "WOODEN_SLAB" }),
/* 1186 */   SPRUCE_STAIRS(new String[] { "SPRUCE_WOOD_STAIRS" }),
/* 1187 */   SPRUCE_TRAPDOOR(new String[] { "TRAP_DOOR" }),
/* 1188 */   SPRUCE_WALL_SIGN(new String[] { "WALL_SIGN" }),
/* 1189 */   SPRUCE_WOOD(1, new String[] { "LOG" }),
/* 1190 */   SPYGLASS(new String[0]),
/* 1191 */   SQUID_SPAWN_EGG(94, new String[] { "MONSTER_EGG" }),
/* 1192 */   STICK(new String[0]),
/* 1193 */   STICKY_PISTON(new String[] { "PISTON_BASE", "PISTON_STICKY_BASE" }),
/* 1194 */   STONE(new String[0]),
/* 1195 */   STONECUTTER(new String[0]),
/* 1196 */   STONE_AXE(new String[0]),
/* 1197 */   STONE_BRICKS(new String[] { "SMOOTH_BRICK" }),
/* 1198 */   STONE_BRICK_SLAB(5, new String[] { "DOUBLE_STEP", "STEP", "STONE_SLAB" }),
/* 1199 */   STONE_BRICK_STAIRS(new String[] { "SMOOTH_STAIRS" }),
/* 1200 */   STONE_BRICK_WALL(new String[0]),
/* 1201 */   STONE_BUTTON(new String[0]),
/* 1202 */   STONE_HOE(new String[0]),
/* 1203 */   STONE_PICKAXE(new String[0]),
/* 1204 */   STONE_PRESSURE_PLATE(new String[] { "STONE_PLATE" }),
/* 1205 */   STONE_SHOVEL(new String[] { "STONE_SPADE" }),
/* 1206 */   STONE_SLAB(new String[] { "DOUBLE_STEP", "STEP" }),
/* 1207 */   STONE_STAIRS(new String[0]),
/* 1208 */   STONE_SWORD(new String[0]),
/* 1209 */   STRAY_SPAWN_EGG(6, new String[] { "MONSTER_EGG" }),
/* 1210 */   STRIDER_SPAWN_EGG(new String[0]),
/* 1211 */   STRING(new String[0]),
/* 1212 */   STRIPPED_ACACIA_LOG(new String[0]),
/* 1213 */   STRIPPED_ACACIA_WOOD(new String[0]),
/* 1214 */   STRIPPED_BIRCH_LOG(new String[0]),
/* 1215 */   STRIPPED_BIRCH_WOOD(new String[0]),
/* 1216 */   STRIPPED_CRIMSON_HYPHAE(new String[0]),
/* 1217 */   STRIPPED_CRIMSON_STEM(new String[0]),
/* 1218 */   STRIPPED_DARK_OAK_LOG(new String[0]),
/* 1219 */   STRIPPED_DARK_OAK_WOOD(new String[0]),
/* 1220 */   STRIPPED_JUNGLE_LOG(new String[0]),
/* 1221 */   STRIPPED_JUNGLE_WOOD(new String[0]),
/* 1222 */   STRIPPED_MANGROVE_LOG(new String[0]),
/* 1223 */   STRIPPED_MANGROVE_WOOD(new String[0]),
/* 1224 */   STRIPPED_OAK_LOG(new String[0]),
/* 1225 */   STRIPPED_OAK_WOOD(new String[0]),
/* 1226 */   STRIPPED_SPRUCE_LOG(new String[0]),
/* 1227 */   STRIPPED_SPRUCE_WOOD(new String[0]),
/* 1228 */   STRIPPED_WARPED_HYPHAE(new String[0]),
/* 1229 */   STRIPPED_WARPED_STEM(new String[0]),
/* 1230 */   STRUCTURE_BLOCK(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1235 */   STRUCTURE_VOID(10, new String[] { "BARRIER" }),
/* 1236 */   SUGAR(new String[0]),
/*      */ 
/*      */ 
/*      */   
/* 1240 */   SUGAR_CANE(new String[] { "SUGAR_CANE_BLOCK" }),
/* 1241 */   SUNFLOWER(new String[] { "DOUBLE_PLANT" }),
/* 1242 */   SUSPICIOUS_STEW(new String[0]),
/* 1243 */   SWEET_BERRIES(new String[0]),
/* 1244 */   SWEET_BERRY_BUSH(new String[0]),
/* 1245 */   TADPOLE_BUCKET(new String[0]),
/* 1246 */   TADPOLE_SPAWN_EGG(new String[0]),
/* 1247 */   TALL_GRASS(2, new String[] { "DOUBLE_PLANT" }),
/* 1248 */   TALL_SEAGRASS(new String[0]),
/* 1249 */   TARGET(new String[0]),
/* 1250 */   TERRACOTTA(new String[] { "HARD_CLAY" }),
/* 1251 */   TINTED_GLASS(new String[0]),
/* 1252 */   TIPPED_ARROW(new String[0]),
/* 1253 */   TNT(new String[0]),
/* 1254 */   TNT_MINECART(new String[] { "EXPLOSIVE_MINECART" }),
/* 1255 */   TORCH(new String[0]),
/* 1256 */   TOTEM_OF_UNDYING(new String[] { "TOTEM" }),
/* 1257 */   TRADER_LLAMA_SPAWN_EGG(new String[0]),
/* 1258 */   TRAPPED_CHEST(new String[0]),
/* 1259 */   TRIDENT(new String[0]),
/* 1260 */   TRIPWIRE(new String[0]),
/* 1261 */   TRIPWIRE_HOOK(new String[0]),
/* 1262 */   TROPICAL_FISH(2, new String[] { "RAW_FISH" }),
/* 1263 */   TROPICAL_FISH_BUCKET(new String[] { "BUCKET", "WATER_BUCKET" }),
/* 1264 */   TROPICAL_FISH_SPAWN_EGG(new String[] { "MONSTER_EGG" }),
/* 1265 */   TUBE_CORAL(new String[0]),
/* 1266 */   TUBE_CORAL_BLOCK(new String[0]),
/* 1267 */   TUBE_CORAL_FAN(new String[0]),
/* 1268 */   TUBE_CORAL_WALL_FAN(new String[0]),
/* 1269 */   TUFF(new String[0]),
/* 1270 */   TURTLE_EGG(new String[0]),
/* 1271 */   TURTLE_HELMET(new String[0]),
/* 1272 */   TURTLE_SPAWN_EGG(new String[0]),
/* 1273 */   TWISTING_VINES(new String[0]),
/* 1274 */   TWISTING_VINES_PLANT(new String[0]),
/* 1275 */   VERDANT_FROGLIGHT(new String[0]),
/* 1276 */   VEX_SPAWN_EGG(35, new String[] { "MONSTER_EGG" }),
/* 1277 */   VILLAGER_SPAWN_EGG(120, new String[] { "MONSTER_EGG" }),
/* 1278 */   VINDICATOR_SPAWN_EGG(36, new String[] { "MONSTER_EGG" }),
/* 1279 */   VINE(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1285 */   VOID_AIR(new String[] { "AIR" }),
/* 1286 */   WALL_TORCH(new String[] { "TORCH" }),
/* 1287 */   WANDERING_TRADER_SPAWN_EGG(new String[0]),
/* 1288 */   WARDEN_SPAWN_EGG(new String[0]),
/* 1289 */   WARPED_BUTTON(new String[0]),
/* 1290 */   WARPED_DOOR(new String[0]),
/* 1291 */   WARPED_FENCE(new String[0]),
/* 1292 */   WARPED_FENCE_GATE(new String[0]),
/* 1293 */   WARPED_FUNGUS(new String[0]),
/* 1294 */   WARPED_FUNGUS_ON_A_STICK(new String[0]),
/* 1295 */   WARPED_HYPHAE(new String[0]),
/* 1296 */   WARPED_NYLIUM(new String[0]),
/* 1297 */   WARPED_PLANKS(new String[0]),
/* 1298 */   WARPED_PRESSURE_PLATE(new String[0]),
/* 1299 */   WARPED_ROOTS(new String[0]),
/* 1300 */   WARPED_SIGN(new String[] { "SIGN_POST" }),
/* 1301 */   WARPED_SLAB(new String[0]),
/* 1302 */   WARPED_STAIRS(new String[0]),
/* 1303 */   WARPED_STEM(new String[0]),
/* 1304 */   WARPED_TRAPDOOR(new String[0]),
/* 1305 */   WARPED_WALL_SIGN(new String[] { "WALL_SIGN" }),
/* 1306 */   WARPED_WART_BLOCK(new String[0]),
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1313 */   WATER(new String[] { "STATIONARY_WATER" }),
/* 1314 */   WATER_BUCKET(new String[0]),
/* 1315 */   WATER_CAULDRON(new String[0]),
/* 1316 */   WAXED_COPPER_BLOCK(new String[0]),
/* 1317 */   WAXED_CUT_COPPER(new String[0]),
/* 1318 */   WAXED_CUT_COPPER_SLAB(new String[0]),
/* 1319 */   WAXED_CUT_COPPER_STAIRS(new String[0]),
/* 1320 */   WAXED_EXPOSED_COPPER(new String[0]),
/* 1321 */   WAXED_EXPOSED_CUT_COPPER(new String[0]),
/* 1322 */   WAXED_EXPOSED_CUT_COPPER_SLAB(new String[0]),
/* 1323 */   WAXED_EXPOSED_CUT_COPPER_STAIRS(new String[0]),
/* 1324 */   WAXED_OXIDIZED_COPPER(new String[0]),
/* 1325 */   WAXED_OXIDIZED_CUT_COPPER(new String[0]),
/* 1326 */   WAXED_OXIDIZED_CUT_COPPER_SLAB(new String[0]),
/* 1327 */   WAXED_OXIDIZED_CUT_COPPER_STAIRS(new String[0]),
/* 1328 */   WAXED_WEATHERED_COPPER(new String[0]),
/* 1329 */   WAXED_WEATHERED_CUT_COPPER(new String[0]),
/* 1330 */   WAXED_WEATHERED_CUT_COPPER_SLAB(new String[0]),
/* 1331 */   WAXED_WEATHERED_CUT_COPPER_STAIRS(new String[0]),
/* 1332 */   WEATHERED_COPPER(new String[0]),
/* 1333 */   WEATHERED_CUT_COPPER(new String[0]),
/* 1334 */   WEATHERED_CUT_COPPER_SLAB(new String[0]),
/* 1335 */   WEATHERED_CUT_COPPER_STAIRS(new String[0]),
/* 1336 */   WEEPING_VINES(new String[0]),
/* 1337 */   WEEPING_VINES_PLANT(new String[0]),
/* 1338 */   WET_SPONGE(1, new String[] { "SPONGE"
/*      */ 
/*      */     
/*      */     }),
/* 1342 */   WHEAT(new String[] { "CROPS" }),
/* 1343 */   WHEAT_SEEDS(new String[] { "SEEDS" }),
/* 1344 */   WHITE_BANNER(15, new String[] { "STANDING_BANNER", "BANNER" }),
/* 1345 */   WHITE_BED(new String[] { "BED_BLOCK", "BED" }),
/* 1346 */   WHITE_CANDLE(new String[0]),
/* 1347 */   WHITE_CANDLE_CAKE(new String[0]),
/* 1348 */   WHITE_CARPET(new String[] { "CARPET" }),
/* 1349 */   WHITE_CONCRETE(new String[] { "CONCRETE" }),
/* 1350 */   WHITE_CONCRETE_POWDER(new String[] { "CONCRETE_POWDER" }),
/* 1351 */   WHITE_DYE(15, new String[] { "INK_SACK", "BONE_MEAL" }),
/* 1352 */   WHITE_GLAZED_TERRACOTTA(new String[0]),
/* 1353 */   WHITE_SHULKER_BOX(new String[0]),
/* 1354 */   WHITE_STAINED_GLASS(new String[] { "STAINED_GLASS" }),
/* 1355 */   WHITE_STAINED_GLASS_PANE(new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/* 1356 */   WHITE_TERRACOTTA(new String[] { "STAINED_CLAY" }),
/* 1357 */   WHITE_TULIP(6, new String[] { "RED_ROSE" }),
/* 1358 */   WHITE_WALL_BANNER(15, new String[] { "WALL_BANNER" }),
/* 1359 */   WHITE_WOOL(new String[] { "WOOL" }),
/* 1360 */   WITCH_SPAWN_EGG(66, new String[] { "MONSTER_EGG" }),
/* 1361 */   WITHER_ROSE(new String[0]),
/* 1362 */   WITHER_SKELETON_SKULL(1, new String[] { "SKULL", "SKULL_ITEM" }),
/* 1363 */   WITHER_SKELETON_SPAWN_EGG(5, new String[] { "MONSTER_EGG" }),
/* 1364 */   WITHER_SKELETON_WALL_SKULL(1, new String[] { "SKULL", "SKULL_ITEM" }),
/* 1365 */   WOLF_SPAWN_EGG(95, new String[] { "MONSTER_EGG" }),
/* 1366 */   WOODEN_AXE(new String[] { "WOOD_AXE" }),
/* 1367 */   WOODEN_HOE(new String[] { "WOOD_HOE" }),
/* 1368 */   WOODEN_PICKAXE(new String[] { "WOOD_PICKAXE" }),
/* 1369 */   WOODEN_SHOVEL(new String[] { "WOOD_SPADE" }),
/* 1370 */   WOODEN_SWORD(new String[] { "WOOD_SWORD" }),
/* 1371 */   WRITABLE_BOOK(new String[] { "BOOK_AND_QUILL" }),
/* 1372 */   WRITTEN_BOOK(new String[0]),
/* 1373 */   YELLOW_BANNER(11, new String[] { "STANDING_BANNER", "BANNER" }),
/* 1374 */   YELLOW_BED(supports(12) ? 4 : 0, new String[] { "BED_BLOCK", "BED" }),
/* 1375 */   YELLOW_CANDLE(new String[0]),
/* 1376 */   YELLOW_CANDLE_CAKE(new String[0]),
/* 1377 */   YELLOW_CARPET(4, new String[] { "CARPET" }),
/* 1378 */   YELLOW_CONCRETE(4, new String[] { "CONCRETE" }),
/* 1379 */   YELLOW_CONCRETE_POWDER(4, new String[] { "CONCRETE_POWDER"
/*      */ 
/*      */ 
/*      */     
/*      */     }),
/* 1384 */   YELLOW_DYE(11, new String[] { "INK_SACK", "DANDELION_YELLOW" }),
/* 1385 */   YELLOW_GLAZED_TERRACOTTA(new String[0]),
/* 1386 */   YELLOW_SHULKER_BOX(new String[0]),
/* 1387 */   YELLOW_STAINED_GLASS(4, new String[] { "STAINED_GLASS" }),
/* 1388 */   YELLOW_STAINED_GLASS_PANE(4, new String[] { "THIN_GLASS", "STAINED_GLASS_PANE" }),
/* 1389 */   YELLOW_TERRACOTTA(4, new String[] { "STAINED_CLAY" }),
/* 1390 */   YELLOW_WALL_BANNER(11, new String[] { "WALL_BANNER" }),
/* 1391 */   YELLOW_WOOL(4, new String[] { "WOOL" }),
/* 1392 */   ZOGLIN_SPAWN_EGG(new String[0]),
/* 1393 */   ZOMBIE_HEAD(2, new String[] { "SKULL", "SKULL_ITEM" }),
/* 1394 */   ZOMBIE_HORSE_SPAWN_EGG(29, new String[] { "MONSTER_EGG" }),
/* 1395 */   ZOMBIE_SPAWN_EGG(54, new String[] { "MONSTER_EGG" }),
/* 1396 */   ZOMBIE_VILLAGER_SPAWN_EGG(27, new String[] { "MONSTER_EGG" }),
/* 1397 */   ZOMBIE_WALL_HEAD(2, new String[] { "SKULL", "SKULL_ITEM" }),
/* 1398 */   ZOMBIFIED_PIGLIN_SPAWN_EGG(57, new String[] { "MONSTER_EGG", "ZOMBIE_PIGMAN_SPAWN_EGG" });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final byte data;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Nonnull
/*      */   private final String[] legacy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   XPolarMaterial(int data, String... legacy) {
/* 1417 */     this.data = (byte)data;
/* 1418 */     this.legacy = legacy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Nonnull
/*      */   public String[] getLegacy() {
/* 1427 */     return this.legacy;
/*      */   }
/*      */   
/*      */   public byte getData() {
/* 1431 */     return this.data;
/*      */   }
/*      */   
/*      */   private static boolean supports(int version) {
/* 1435 */     return false;
/*      */   }
/*      */   
/*      */   @Nullable
/*      */   public static XPolarMaterial fromName(String name) {
/*      */     try {
/* 1441 */       return valueOf(name);
/* 1442 */     } catch (IllegalArgumentException ignored) {
/* 1443 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<XPolarMaterial> isArmor() {
/* 1449 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1450 */     ma.addAll(isHelmet());
/* 1451 */     ma.addAll(isChestplate());
/* 1452 */     ma.addAll(isLeggings());
/* 1453 */     ma.addAll(isBoots());
/* 1454 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isHelmet() {
/* 1458 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1459 */     ma.add(TURTLE_HELMET);
/* 1460 */     ma.add(NETHERITE_HELMET);
/* 1461 */     ma.add(DIAMOND_HELMET);
/* 1462 */     ma.add(IRON_HELMET);
/* 1463 */     ma.add(CHAINMAIL_HELMET);
/* 1464 */     ma.add(GOLDEN_HELMET);
/* 1465 */     ma.add(LEATHER_HELMET);
/* 1466 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isChestplate() {
/* 1470 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1471 */     ma.add(NETHERITE_CHESTPLATE);
/* 1472 */     ma.add(DIAMOND_CHESTPLATE);
/* 1473 */     ma.add(IRON_CHESTPLATE);
/* 1474 */     ma.add(CHAINMAIL_CHESTPLATE);
/* 1475 */     ma.add(GOLDEN_CHESTPLATE);
/* 1476 */     ma.add(LEATHER_CHESTPLATE);
/* 1477 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isLeggings() {
/* 1481 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1482 */     ma.add(NETHERITE_LEGGINGS);
/* 1483 */     ma.add(DIAMOND_LEGGINGS);
/* 1484 */     ma.add(IRON_LEGGINGS);
/* 1485 */     ma.add(CHAINMAIL_LEGGINGS);
/* 1486 */     ma.add(GOLDEN_LEGGINGS);
/* 1487 */     ma.add(LEATHER_LEGGINGS);
/* 1488 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isBoots() {
/* 1492 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1493 */     ma.add(NETHERITE_BOOTS);
/* 1494 */     ma.add(DIAMOND_BOOTS);
/* 1495 */     ma.add(IRON_BOOTS);
/* 1496 */     ma.add(CHAINMAIL_BOOTS);
/* 1497 */     ma.add(GOLDEN_BOOTS);
/* 1498 */     ma.add(LEATHER_BOOTS);
/* 1499 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isBow() {
/* 1503 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1504 */     ma.add(BOW);
/* 1505 */     ma.add(CROSSBOW);
/* 1506 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isAxe() {
/* 1510 */     List<XPolarMaterial> axe = new ArrayList<>();
/* 1511 */     axe.add(NETHERITE_AXE);
/* 1512 */     axe.add(DIAMOND_AXE);
/* 1513 */     axe.add(IRON_AXE);
/* 1514 */     axe.add(STONE_AXE);
/* 1515 */     axe.add(GOLDEN_AXE);
/* 1516 */     axe.add(WOODEN_AXE);
/* 1517 */     return axe;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isSword() {
/* 1521 */     List<XPolarMaterial> sword = new ArrayList<>();
/* 1522 */     sword.add(NETHERITE_SWORD);
/* 1523 */     sword.add(DIAMOND_SWORD);
/* 1524 */     sword.add(IRON_SWORD);
/* 1525 */     sword.add(STONE_SWORD);
/* 1526 */     sword.add(GOLDEN_SWORD);
/* 1527 */     sword.add(WOODEN_SWORD);
/* 1528 */     return sword;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isWeapon() {
/* 1532 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1533 */     ma.addAll(isAxe());
/* 1534 */     ma.addAll(isSword());
/* 1535 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isPickaxe() {
/* 1539 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1540 */     ma.add(NETHERITE_PICKAXE);
/* 1541 */     ma.add(DIAMOND_PICKAXE);
/* 1542 */     ma.add(IRON_PICKAXE);
/* 1543 */     ma.add(STONE_PICKAXE);
/* 1544 */     ma.add(GOLDEN_PICKAXE);
/* 1545 */     ma.add(WOODEN_PICKAXE);
/* 1546 */     return ma;
/*      */   }
/*      */   
/*      */   public static ArrayList<XPolarMaterial> isShovel() {
/* 1550 */     ArrayList<XPolarMaterial> ma = new ArrayList<>();
/* 1551 */     ma.add(NETHERITE_SHOVEL);
/* 1552 */     ma.add(DIAMOND_SHOVEL);
/* 1553 */     ma.add(IRON_SHOVEL);
/* 1554 */     ma.add(STONE_SHOVEL);
/* 1555 */     ma.add(GOLDEN_SHOVEL);
/* 1556 */     ma.add(WOODEN_SHOVEL);
/* 1557 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isUtility() {
/* 1561 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1562 */     ma.addAll(isTool());
/* 1563 */     ma.addAll(isSword());
/* 1564 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isTool() {
/* 1568 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1569 */     ma.addAll(isPickaxe());
/* 1570 */     ma.addAll(isAxe());
/* 1571 */     ma.addAll(isShovel());
/* 1572 */     ma.addAll(isHoe());
/* 1573 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isHoe() {
/* 1577 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1578 */     ma.add(NETHERITE_HOE);
/* 1579 */     ma.add(DIAMOND_HOE);
/* 1580 */     ma.add(IRON_HOE);
/* 1581 */     ma.add(STONE_HOE);
/* 1582 */     ma.add(GOLDEN_HOE);
/* 1583 */     ma.add(WOODEN_HOE);
/* 1584 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isFishingRod() {
/* 1588 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1589 */     ma.add(FISHING_ROD);
/* 1590 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isShears() {
/* 1594 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1595 */     ma.add(SHEARS);
/* 1596 */     return ma;
/*      */   }
/*      */   
/*      */   public static List<XPolarMaterial> isAll() {
/* 1600 */     List<XPolarMaterial> ma = new ArrayList<>();
/* 1601 */     ma.addAll(isArmor());
/* 1602 */     ma.addAll(isTool());
/* 1603 */     ma.addAll(isBow());
/* 1604 */     ma.addAll(isWeapon());
/* 1605 */     ma.addAll(isFishingRod());
/* 1606 */     ma.addAll(isShears());
/* 1607 */     return ma;
/*      */   }
/*      */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\xseries\XPolarMaterial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */