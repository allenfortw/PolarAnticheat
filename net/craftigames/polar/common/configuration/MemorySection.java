/*     */ package net.craftigames.polar.common.configuration;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.craftigames.polar.common.util.NumberConversions;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ public class MemorySection
/*     */   implements ConfigurationSection {
/*  14 */   protected final Map<String, Object> map = new LinkedHashMap<>();
/*     */ 
/*     */   
/*     */   private final Configuration root;
/*     */ 
/*     */   
/*     */   private final ConfigurationSection parent;
/*     */ 
/*     */   
/*     */   private final String path;
/*     */ 
/*     */   
/*     */   private final String fullPath;
/*     */ 
/*     */ 
/*     */   
/*     */   protected MemorySection() {
/*  31 */     if (!(this instanceof Configuration)) {
/*  32 */       throw new IllegalStateException("Cannot construct a root MemorySection when not a Configuration");
/*     */     }
/*     */     
/*  35 */     this.path = "";
/*  36 */     this.fullPath = "";
/*  37 */     this.parent = null;
/*  38 */     this.root = (Configuration)this;
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
/*     */   
/*     */   protected MemorySection(ConfigurationSection parent, String path) {
/*  51 */     Validate.notNull(parent, "Parent cannot be null", new Object[0]);
/*  52 */     Validate.notNull(path, "Path cannot be null", new Object[0]);
/*     */     
/*  54 */     this.path = path;
/*  55 */     this.parent = parent;
/*  56 */     this.root = parent.getRoot();
/*     */     
/*  58 */     Validate.notNull(this.root, "Path cannot be orphaned", new Object[0]);
/*     */     
/*  60 */     this.fullPath = createPath(parent, path);
/*     */   }
/*     */   
/*     */   public Set<String> getKeys(boolean deep) {
/*  64 */     Set<String> result = new LinkedHashSet<>();
/*     */     
/*  66 */     Configuration root = getRoot();
/*  67 */     if (root != null && root.options().copyDefaults()) {
/*  68 */       ConfigurationSection defaults = getDefaultSection();
/*     */       
/*  70 */       if (defaults != null) {
/*  71 */         result.addAll(defaults.getKeys(deep));
/*     */       }
/*     */     } 
/*     */     
/*  75 */     mapChildrenKeys(result, this, deep);
/*     */     
/*  77 */     return result;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getValues(boolean deep) {
/*  81 */     Map<String, Object> result = new LinkedHashMap<>();
/*     */     
/*  83 */     Configuration root = getRoot();
/*  84 */     if (root != null && root.options().copyDefaults()) {
/*  85 */       ConfigurationSection defaults = getDefaultSection();
/*     */       
/*  87 */       if (defaults != null) {
/*  88 */         result.putAll(defaults.getValues(deep));
/*     */       }
/*     */     } 
/*     */     
/*  92 */     mapChildrenValues(result, this, deep);
/*     */     
/*  94 */     return result;
/*     */   }
/*     */   
/*     */   public boolean contains(String path) {
/*  98 */     return (get(path) != null);
/*     */   }
/*     */   
/*     */   public boolean isSet(String path) {
/* 102 */     Configuration root = getRoot();
/* 103 */     if (root == null) {
/* 104 */       return false;
/*     */     }
/* 106 */     if (root.options().copyDefaults()) {
/* 107 */       return contains(path);
/*     */     }
/* 109 */     return (get(path, null) != null);
/*     */   }
/*     */   
/*     */   public String getCurrentPath() {
/* 113 */     return this.fullPath;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 117 */     return this.path;
/*     */   }
/*     */   
/*     */   public Configuration getRoot() {
/* 121 */     return this.root;
/*     */   }
/*     */   
/*     */   public ConfigurationSection getParent() {
/* 125 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void addDefault(String path, Object value) {
/* 129 */     Validate.notNull(path, "Path cannot be null", new Object[0]);
/*     */     
/* 131 */     Configuration root = getRoot();
/* 132 */     if (root == null) {
/* 133 */       throw new IllegalStateException("Cannot add default without root");
/*     */     }
/* 135 */     if (root == this) {
/* 136 */       throw new UnsupportedOperationException("Unsupported addDefault(String, Object) implementation");
/*     */     }
/* 138 */     root.addDefault(createPath(this, path), value);
/*     */   }
/*     */   
/*     */   public ConfigurationSection getDefaultSection() {
/* 142 */     Configuration root = getRoot();
/* 143 */     Configuration defaults = (root == null) ? null : root.getDefaults();
/*     */     
/* 145 */     if (defaults != null && 
/* 146 */       defaults.isConfigurationSection(getCurrentPath())) {
/* 147 */       return defaults.getConfigurationSection(getCurrentPath());
/*     */     }
/*     */ 
/*     */     
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   public void set(String path, Object value) {
/* 155 */     Validate.notEmpty(path, "Cannot set to an empty path", new Object[0]);
/*     */     
/* 157 */     Configuration root = getRoot();
/* 158 */     if (root == null) {
/* 159 */       throw new IllegalStateException("Cannot use section without a root");
/*     */     }
/*     */     
/* 162 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 165 */     int i1 = -1;
/* 166 */     ConfigurationSection section = this; int i2;
/* 167 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 168 */       String node = path.substring(i2, i1);
/* 169 */       ConfigurationSection subSection = section.getConfigurationSection(node);
/* 170 */       if (subSection == null) {
/* 171 */         section = section.createSection(node); continue;
/*     */       } 
/* 173 */       section = subSection;
/*     */     } 
/*     */ 
/*     */     
/* 177 */     String key = path.substring(i2);
/* 178 */     if (section == this) {
/* 179 */       if (value == null) {
/* 180 */         this.map.remove(key);
/*     */       } else {
/* 182 */         this.map.put(key, value);
/*     */       } 
/*     */     } else {
/* 185 */       section.set(key, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object get(String path) {
/* 190 */     return get(path, getDefault(path));
/*     */   }
/*     */   
/*     */   public Object get(String path, Object def) {
/* 194 */     Validate.notNull(path, "Path cannot be null", new Object[0]);
/*     */     
/* 196 */     if (path.length() == 0) {
/* 197 */       return this;
/*     */     }
/*     */     
/* 200 */     Configuration root = getRoot();
/* 201 */     if (root == null) {
/* 202 */       throw new IllegalStateException("Cannot access section without a root");
/*     */     }
/*     */     
/* 205 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 208 */     int i1 = -1;
/* 209 */     ConfigurationSection section = this; int i2;
/* 210 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 211 */       section = section.getConfigurationSection(path.substring(i2, i1));
/* 212 */       if (section == null) {
/* 213 */         return def;
/*     */       }
/*     */     } 
/*     */     
/* 217 */     String key = path.substring(i2);
/* 218 */     if (section == this) {
/* 219 */       Object result = this.map.get(key);
/* 220 */       return (result == null) ? def : result;
/*     */     } 
/* 222 */     return section.get(key, def);
/*     */   }
/*     */   
/*     */   public ConfigurationSection createSection(String path) {
/* 226 */     Validate.notEmpty(path, "Cannot create section at empty path", new Object[0]);
/* 227 */     Configuration root = getRoot();
/* 228 */     if (root == null) {
/* 229 */       throw new IllegalStateException("Cannot create section without a root");
/*     */     }
/*     */     
/* 232 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 235 */     int i1 = -1;
/* 236 */     ConfigurationSection section = this; int i2;
/* 237 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 238 */       String node = path.substring(i2, i1);
/* 239 */       ConfigurationSection subSection = section.getConfigurationSection(node);
/* 240 */       if (subSection == null) {
/* 241 */         section = section.createSection(node); continue;
/*     */       } 
/* 243 */       section = subSection;
/*     */     } 
/*     */ 
/*     */     
/* 247 */     String key = path.substring(i2);
/* 248 */     if (section == this) {
/* 249 */       ConfigurationSection result = new MemorySection(this, key);
/* 250 */       this.map.put(key, result);
/* 251 */       return result;
/*     */     } 
/* 253 */     return section.createSection(key);
/*     */   }
/*     */   
/*     */   public ConfigurationSection createSection(String path, Map<?, ?> map) {
/* 257 */     ConfigurationSection section = createSection(path);
/*     */     
/* 259 */     for (Map.Entry<?, ?> entry : map.entrySet()) {
/* 260 */       if (entry.getValue() instanceof Map) {
/* 261 */         section.createSection(entry.getKey().toString(), (Map<?, ?>)entry.getValue()); continue;
/*     */       } 
/* 263 */       section.set(entry.getKey().toString(), entry.getValue());
/*     */     } 
/*     */ 
/*     */     
/* 267 */     return section;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(String path) {
/* 272 */     Object def = getDefault(path);
/* 273 */     return getString(path, (def != null) ? def.toString() : null);
/*     */   }
/*     */   
/*     */   public String getString(String path, String def) {
/* 277 */     Object val = get(path, def);
/* 278 */     return (val != null) ? val.toString() : def;
/*     */   }
/*     */   
/*     */   public boolean isString(String path) {
/* 282 */     Object val = get(path);
/* 283 */     return val instanceof String;
/*     */   }
/*     */   
/*     */   public int getInt(String path) {
/* 287 */     Object def = getDefault(path);
/* 288 */     return getInt(path, (def instanceof Number) ? NumberConversions.toInt(def) : 0);
/*     */   }
/*     */   
/*     */   public int getInt(String path, int def) {
/* 292 */     Object val = get(path, Integer.valueOf(def));
/* 293 */     return (val instanceof Number) ? NumberConversions.toInt(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isInt(String path) {
/* 297 */     Object val = get(path);
/* 298 */     return val instanceof Integer;
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String path) {
/* 302 */     Object def = getDefault(path);
/* 303 */     return getBoolean(path, (def instanceof Boolean) ? ((Boolean)def).booleanValue() : false);
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String path, boolean def) {
/* 307 */     Object val = get(path, Boolean.valueOf(def));
/* 308 */     return (val instanceof Boolean) ? ((Boolean)val).booleanValue() : def;
/*     */   }
/*     */   
/*     */   public boolean isBoolean(String path) {
/* 312 */     Object val = get(path);
/* 313 */     return val instanceof Boolean;
/*     */   }
/*     */   
/*     */   public double getDouble(String path) {
/* 317 */     Object def = getDefault(path);
/* 318 */     return getDouble(path, (def instanceof Number) ? NumberConversions.toDouble(def) : 0.0D);
/*     */   }
/*     */   
/*     */   public double getDouble(String path, double def) {
/* 322 */     Object val = get(path, Double.valueOf(def));
/* 323 */     return (val instanceof Number) ? NumberConversions.toDouble(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isDouble(String path) {
/* 327 */     Object val = get(path);
/* 328 */     return val instanceof Double;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloat(String path) {
/* 333 */     Object def = getDefault(path);
/* 334 */     return getFloat(path, (def instanceof Float) ? NumberConversions.toFloat(def) : 0.0F);
/*     */   }
/*     */   
/*     */   public float getFloat(String path, float def) {
/* 338 */     Object val = get(path, Float.valueOf(def));
/* 339 */     return (val instanceof Float) ? NumberConversions.toFloat(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isFloat(String path) {
/* 343 */     Object val = get(path);
/* 344 */     return val instanceof Float;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getLong(String path) {
/* 349 */     Object def = getDefault(path);
/* 350 */     return getLong(path, (def instanceof Number) ? NumberConversions.toLong(def) : 0L);
/*     */   }
/*     */   
/*     */   public long getLong(String path, long def) {
/* 354 */     Object val = get(path, Long.valueOf(def));
/* 355 */     return (val instanceof Number) ? NumberConversions.toLong(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isLong(String path) {
/* 359 */     Object val = get(path);
/* 360 */     return val instanceof Long;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getList(String path) {
/* 365 */     Object def = getDefault(path);
/* 366 */     return getList(path, (def instanceof List) ? (List)def : null);
/*     */   }
/*     */   
/*     */   public List<?> getList(String path, List<?> def) {
/* 370 */     Object val = get(path, def);
/* 371 */     return (val instanceof List) ? (List)val : def;
/*     */   }
/*     */   
/*     */   public boolean isList(String path) {
/* 375 */     Object val = get(path);
/* 376 */     return val instanceof List;
/*     */   }
/*     */   
/*     */   public List<String> getStringList(String path) {
/* 380 */     List<?> list = getList(path);
/*     */     
/* 382 */     if (list == null) {
/* 383 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 386 */     List<String> result = new ArrayList<>();
/*     */     
/* 388 */     for (Object object : list) {
/* 389 */       if (object instanceof String || isPrimitiveWrapper(object)) {
/* 390 */         result.add(String.valueOf(object));
/*     */       }
/*     */     } 
/*     */     
/* 394 */     return result;
/*     */   }
/*     */   
/*     */   public List<Integer> getIntegerList(String path) {
/* 398 */     List<?> list = getList(path);
/*     */     
/* 400 */     if (list == null) {
/* 401 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 404 */     List<Integer> result = new ArrayList<>();
/*     */     
/* 406 */     for (Object object : list) {
/* 407 */       if (object instanceof Integer) {
/* 408 */         result.add((Integer)object); continue;
/* 409 */       }  if (object instanceof String) {
/*     */         try {
/* 411 */           result.add(Integer.valueOf((String)object));
/* 412 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 414 */       if (object instanceof Character) {
/* 415 */         result.add(Integer.valueOf(((Character)object).charValue())); continue;
/* 416 */       }  if (object instanceof Number) {
/* 417 */         result.add(Integer.valueOf(((Number)object).intValue()));
/*     */       }
/*     */     } 
/*     */     
/* 421 */     return result;
/*     */   }
/*     */   
/*     */   public List<Boolean> getBooleanList(String path) {
/* 425 */     List<?> list = getList(path);
/*     */     
/* 427 */     if (list == null) {
/* 428 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 431 */     List<Boolean> result = new ArrayList<>();
/*     */     
/* 433 */     for (Object object : list) {
/* 434 */       if (object instanceof Boolean) {
/* 435 */         result.add((Boolean)object); continue;
/* 436 */       }  if (object instanceof String) {
/* 437 */         if (Boolean.TRUE.toString().equals(object)) {
/* 438 */           result.add(Boolean.valueOf(true)); continue;
/* 439 */         }  if (Boolean.FALSE.toString().equals(object)) {
/* 440 */           result.add(Boolean.valueOf(false));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 445 */     return result;
/*     */   }
/*     */   
/*     */   public List<Double> getDoubleList(String path) {
/* 449 */     List<?> list = getList(path);
/*     */     
/* 451 */     if (list == null) {
/* 452 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 455 */     List<Double> result = new ArrayList<>();
/*     */     
/* 457 */     for (Object object : list) {
/* 458 */       if (object instanceof Double) {
/* 459 */         result.add((Double)object); continue;
/* 460 */       }  if (object instanceof String) {
/*     */         try {
/* 462 */           result.add(Double.valueOf((String)object));
/* 463 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 465 */       if (object instanceof Character) {
/* 466 */         result.add(Double.valueOf(((Character)object).charValue())); continue;
/* 467 */       }  if (object instanceof Number) {
/* 468 */         result.add(Double.valueOf(((Number)object).doubleValue()));
/*     */       }
/*     */     } 
/*     */     
/* 472 */     return result;
/*     */   }
/*     */   
/*     */   public List<Float> getFloatList(String path) {
/* 476 */     List<?> list = getList(path);
/*     */     
/* 478 */     if (list == null) {
/* 479 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 482 */     List<Float> result = new ArrayList<>();
/*     */     
/* 484 */     for (Object object : list) {
/* 485 */       if (object instanceof Float) {
/* 486 */         result.add((Float)object); continue;
/* 487 */       }  if (object instanceof String) {
/*     */         try {
/* 489 */           result.add(Float.valueOf((String)object));
/* 490 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 492 */       if (object instanceof Character) {
/* 493 */         result.add(Float.valueOf(((Character)object).charValue())); continue;
/* 494 */       }  if (object instanceof Number) {
/* 495 */         result.add(Float.valueOf(((Number)object).floatValue()));
/*     */       }
/*     */     } 
/*     */     
/* 499 */     return result;
/*     */   }
/*     */   
/*     */   public List<Long> getLongList(String path) {
/* 503 */     List<?> list = getList(path);
/*     */     
/* 505 */     if (list == null) {
/* 506 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 509 */     List<Long> result = new ArrayList<>();
/*     */     
/* 511 */     for (Object object : list) {
/* 512 */       if (object instanceof Long) {
/* 513 */         result.add((Long)object); continue;
/* 514 */       }  if (object instanceof String) {
/*     */         try {
/* 516 */           result.add(Long.valueOf((String)object));
/* 517 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 519 */       if (object instanceof Character) {
/* 520 */         result.add(Long.valueOf(((Character)object).charValue())); continue;
/* 521 */       }  if (object instanceof Number) {
/* 522 */         result.add(Long.valueOf(((Number)object).longValue()));
/*     */       }
/*     */     } 
/*     */     
/* 526 */     return result;
/*     */   }
/*     */   
/*     */   public List<Byte> getByteList(String path) {
/* 530 */     List<?> list = getList(path);
/*     */     
/* 532 */     if (list == null) {
/* 533 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 536 */     List<Byte> result = new ArrayList<>();
/*     */     
/* 538 */     for (Object object : list) {
/* 539 */       if (object instanceof Byte) {
/* 540 */         result.add((Byte)object); continue;
/* 541 */       }  if (object instanceof String) {
/*     */         try {
/* 543 */           result.add(Byte.valueOf((String)object));
/* 544 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 546 */       if (object instanceof Character) {
/* 547 */         result.add(Byte.valueOf((byte)((Character)object).charValue())); continue;
/* 548 */       }  if (object instanceof Number) {
/* 549 */         result.add(Byte.valueOf(((Number)object).byteValue()));
/*     */       }
/*     */     } 
/*     */     
/* 553 */     return result;
/*     */   }
/*     */   
/*     */   public List<Character> getCharacterList(String path) {
/* 557 */     List<?> list = getList(path);
/*     */     
/* 559 */     if (list == null) {
/* 560 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 563 */     List<Character> result = new ArrayList<>();
/*     */     
/* 565 */     for (Object object : list) {
/* 566 */       if (object instanceof Character) {
/* 567 */         result.add((Character)object); continue;
/* 568 */       }  if (object instanceof String) {
/* 569 */         String str = (String)object;
/*     */         
/* 571 */         if (str.length() == 1)
/* 572 */           result.add(Character.valueOf(str.charAt(0)));  continue;
/*     */       } 
/* 574 */       if (object instanceof Number) {
/* 575 */         result.add(Character.valueOf((char)((Number)object).intValue()));
/*     */       }
/*     */     } 
/*     */     
/* 579 */     return result;
/*     */   }
/*     */   
/*     */   public List<Short> getShortList(String path) {
/* 583 */     List<?> list = getList(path);
/*     */     
/* 585 */     if (list == null) {
/* 586 */       return new ArrayList<>(0);
/*     */     }
/*     */     
/* 589 */     List<Short> result = new ArrayList<>();
/*     */     
/* 591 */     for (Object object : list) {
/* 592 */       if (object instanceof Short) {
/* 593 */         result.add((Short)object); continue;
/* 594 */       }  if (object instanceof String) {
/*     */         try {
/* 596 */           result.add(Short.valueOf((String)object));
/* 597 */         } catch (Exception exception) {} continue;
/*     */       } 
/* 599 */       if (object instanceof Character) {
/* 600 */         result.add(Short.valueOf((short)((Character)object).charValue())); continue;
/* 601 */       }  if (object instanceof Number) {
/* 602 */         result.add(Short.valueOf(((Number)object).shortValue()));
/*     */       }
/*     */     } 
/*     */     
/* 606 */     return result;
/*     */   }
/*     */   
/*     */   public List<Map<?, ?>> getMapList(String path) {
/* 610 */     List<?> list = getList(path);
/* 611 */     List<Map<?, ?>> result = new ArrayList<>();
/*     */     
/* 613 */     if (list == null) {
/* 614 */       return result;
/*     */     }
/*     */     
/* 617 */     for (Object object : list) {
/* 618 */       if (object instanceof Map) {
/* 619 */         result.add((Map<?, ?>)object);
/*     */       }
/*     */     } 
/*     */     
/* 623 */     return result;
/*     */   }
/*     */   
/*     */   public ConfigurationSection getConfigurationSection(String path) {
/* 627 */     Object val = get(path, null);
/* 628 */     if (val != null) {
/* 629 */       return (val instanceof ConfigurationSection) ? (ConfigurationSection)val : null;
/*     */     }
/*     */     
/* 632 */     val = get(path, getDefault(path));
/* 633 */     return (val instanceof ConfigurationSection) ? createSection(path) : null;
/*     */   }
/*     */   
/*     */   public boolean isConfigurationSection(String path) {
/* 637 */     Object val = get(path);
/* 638 */     return val instanceof ConfigurationSection;
/*     */   }
/*     */   
/*     */   protected boolean isPrimitiveWrapper(Object input) {
/* 642 */     return (input instanceof Integer || input instanceof Boolean || input instanceof Character || input instanceof Byte || input instanceof Short || input instanceof Double || input instanceof Long || input instanceof Float);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getDefault(String path) {
/* 649 */     Validate.notNull(path, "Path cannot be null", new Object[0]);
/*     */     
/* 651 */     Configuration root = getRoot();
/* 652 */     Configuration defaults = (root == null) ? null : root.getDefaults();
/* 653 */     return (defaults == null) ? null : defaults.get(createPath(this, path));
/*     */   }
/*     */   
/*     */   protected void mapChildrenKeys(Set<String> output, ConfigurationSection section, boolean deep) {
/* 657 */     if (section instanceof MemorySection) {
/* 658 */       MemorySection sec = (MemorySection)section;
/*     */       
/* 660 */       for (Map.Entry<String, Object> entry : sec.map.entrySet()) {
/* 661 */         output.add(createPath(section, entry.getKey(), this));
/*     */         
/* 663 */         if (deep && entry.getValue() instanceof ConfigurationSection) {
/* 664 */           ConfigurationSection subsection = (ConfigurationSection)entry.getValue();
/* 665 */           mapChildrenKeys(output, subsection, deep);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 669 */       Set<String> keys = section.getKeys(deep);
/*     */       
/* 671 */       for (String key : keys) {
/* 672 */         output.add(createPath(section, key, this));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void mapChildrenValues(Map<String, Object> output, ConfigurationSection section, boolean deep) {
/* 678 */     if (section instanceof MemorySection) {
/* 679 */       MemorySection sec = (MemorySection)section;
/*     */       
/* 681 */       for (Map.Entry<String, Object> entry : sec.map.entrySet()) {
/* 682 */         output.put(createPath(section, entry.getKey(), this), entry.getValue());
/*     */         
/* 684 */         if (entry.getValue() instanceof ConfigurationSection && 
/* 685 */           deep) {
/* 686 */           mapChildrenValues(output, (ConfigurationSection)entry.getValue(), deep);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 691 */       Map<String, Object> values = section.getValues(deep);
/*     */       
/* 693 */       for (Map.Entry<String, Object> entry : values.entrySet()) {
/* 694 */         output.put(createPath(section, entry.getKey(), this), entry.getValue());
/*     */       }
/*     */     } 
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createPath(ConfigurationSection section, String key) {
/* 711 */     return createPath(section, key, (section == null) ? null : section.getRoot());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createPath(ConfigurationSection section, String key, ConfigurationSection relativeTo) {
/* 727 */     Validate.notNull(section, "Cannot create path without a section", new Object[0]);
/* 728 */     Configuration root = section.getRoot();
/* 729 */     if (root == null) {
/* 730 */       throw new IllegalStateException("Cannot create path without a root");
/*     */     }
/* 732 */     char separator = root.options().pathSeparator();
/*     */     
/* 734 */     StringBuilder builder = new StringBuilder();
/* 735 */     if (section != null) {
/* 736 */       for (ConfigurationSection parent = section; parent != null && parent != relativeTo; parent = parent.getParent()) {
/* 737 */         if (builder.length() > 0) {
/* 738 */           builder.insert(0, separator);
/*     */         }
/*     */         
/* 741 */         builder.insert(0, parent.getName());
/*     */       } 
/*     */     }
/*     */     
/* 745 */     if (key != null && key.length() > 0) {
/* 746 */       if (builder.length() > 0) {
/* 747 */         builder.append(separator);
/*     */       }
/*     */       
/* 750 */       builder.append(key);
/*     */     } 
/*     */     
/* 753 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 758 */     Configuration root = getRoot();
/* 759 */     return 
/* 760 */       getClass().getSimpleName() + "[path='" + 
/*     */       
/* 762 */       getCurrentPath() + "', root='" + (
/*     */       
/* 764 */       (root == null) ? null : root.getClass().getSimpleName()) + "']";
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\MemorySection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */