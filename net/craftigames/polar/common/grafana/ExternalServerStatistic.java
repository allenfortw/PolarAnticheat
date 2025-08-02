/*     */ package net.craftigames.polar.common.grafana;
/*     */ import java.util.Map;
/*     */ public class ExternalServerStatistic implements GsonSerializable { private final String name; @Deprecated private final Map<String, Map<String, Double>> legacyData; private final Map<String, Double> values; private final Map<String, String> tags; public boolean equals(Object o) { if (o == this)
/*     */       return true;  if (!(o instanceof ExternalServerStatistic))
/*     */       return false;  ExternalServerStatistic other = (ExternalServerStatistic)o; if (!other.canEqual(this))
/*     */       return false; 
/*     */     Object this$name = getName(), other$name = other.getName();
/*     */     if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name))
/*     */       return false; 
/*     */     Object<String, Map<String, Double>> this$legacyData = (Object<String, Map<String, Double>>)getLegacyData(), other$legacyData = (Object<String, Map<String, Double>>)other.getLegacyData();
/*     */     if ((this$legacyData == null) ? (other$legacyData != null) : !this$legacyData.equals(other$legacyData))
/*     */       return false; 
/*     */     Object<String, Double> this$values = (Object<String, Double>)getValues(), other$values = (Object<String, Double>)other.getValues();
/*     */     if ((this$values == null) ? (other$values != null) : !this$values.equals(other$values))
/*     */       return false; 
/*     */     Object<String, String> this$tags = (Object<String, String>)getTags(), other$tags = (Object<String, String>)other.getTags();
/*  17 */     return !((this$tags == null) ? (other$tags != null) : !this$tags.equals(other$tags)); } protected boolean canEqual(Object other) { return other instanceof ExternalServerStatistic; } public ExternalServerStatistic(String name) { this.legacyData = new ConcurrentHashMap<>();
/*     */ 
/*     */     
/*  20 */     this.values = new ConcurrentHashMap<>();
/*  21 */     this.tags = new ConcurrentHashMap<>(); this.name = name; } public int hashCode() { int PRIME = 59; result = 1; Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object<String, Map<String, Double>> $legacyData = (Object<String, Map<String, Double>>)getLegacyData(); result = result * 59 + (($legacyData == null) ? 43 : $legacyData.hashCode()); Object<String, Double> $values = (Object<String, Double>)getValues(); result = result * 59 + (($values == null) ? 43 : $values.hashCode()); Object<String, String> $tags = (Object<String, String>)getTags(); return result * 59 + (($tags == null) ? 43 : $tags.hashCode()); } public Map<String, String> getTags() { return this.tags; } public String toString() { return "ExternalServerStatistic(name=" + getName() + ", legacyData=" + getLegacyData() + ", values=" + getValues() + ", tags=" + getTags() + ")"; }
/*     */   public String getName() { return this.name; }
/*     */   @Deprecated
/*     */   public Map<String, Map<String, Double>> getLegacyData() { return this.legacyData; }
/*     */   public Map<String, Double> getValues() { return this.values; }
/*     */   @Deprecated
/*     */   public void addStat(String tag, String stat, double value) {
/*  28 */     Map<String, Double> dataMap = this.legacyData.computeIfAbsent(tag, s -> new ConcurrentHashMap<>());
/*  29 */     dataMap.put(stat, Double.valueOf(((Double)dataMap.getOrDefault(stat, Double.valueOf(0.0D))).doubleValue() + value));
/*     */   }
/*     */   
/*     */   public void addStat(String stat, double value) {
/*  33 */     this.values.put(stat, Double.valueOf(((Double)this.values.getOrDefault(stat, Double.valueOf(0.0D))).doubleValue() + value));
/*     */   }
/*     */   
/*     */   protected void addTag(String tag, String key) {
/*  37 */     this.tags.put(tag, key);
/*     */   }
/*     */   
/*     */   public void resetStatisticValues(boolean resetTags) {
/*  41 */     if (resetTags) {
/*  42 */       this.tags.clear();
/*     */     }
/*  44 */     this.legacyData.values().forEach(Map::clear);
/*  45 */     this.values.clear();
/*     */   }
/*     */   
/*     */   public void resetStatisticValues() {
/*  49 */     resetStatisticValues(true);
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public JsonElement serialize() {
/*  55 */     JsonObject object = new JsonObject();
/*     */     
/*  57 */     object.addProperty("name", this.name);
/*     */     
/*  59 */     JsonObject legacyData = new JsonObject();
/*  60 */     for (Map.Entry<String, Map<String, Double>> entry : this.legacyData.entrySet()) {
/*  61 */       JsonObject jsonObject = new JsonObject();
/*     */       
/*  63 */       for (Map.Entry<String, Double> dataEntry : (Iterable<Map.Entry<String, Double>>)((Map)entry.getValue()).entrySet()) {
/*  64 */         jsonObject.addProperty(dataEntry.getKey(), dataEntry.getValue());
/*     */       }
/*     */       
/*  67 */       legacyData.add(entry.getKey(), (JsonElement)jsonObject);
/*     */     } 
/*  69 */     object.add("data", (JsonElement)legacyData);
/*     */     
/*  71 */     JsonObject data = new JsonObject();
/*  72 */     for (Map.Entry<String, Double> entry : this.values.entrySet()) {
/*  73 */       data.addProperty(entry.getKey(), entry.getValue());
/*     */     }
/*  75 */     object.add("values", (JsonElement)data);
/*     */     
/*  77 */     JsonObject tag = new JsonObject();
/*  78 */     for (Map.Entry<String, String> entry : this.tags.entrySet()) {
/*  79 */       tag.addProperty(entry.getKey(), entry.getValue());
/*     */     }
/*  81 */     object.add("tag", (JsonElement)tag);
/*     */ 
/*     */     
/*  84 */     return (JsonElement)object;
/*     */   }
/*     */   
/*     */   public static ExternalServerStatistic deserialize(JsonElement element) {
/*  88 */     if (element.isJsonObject()) {
/*  89 */       JsonObject object = element.getAsJsonObject();
/*     */       
/*  91 */       String name = object.get("name").getAsString();
/*     */       
/*  93 */       Map<String, Map<String, Double>> legacyData = new ConcurrentHashMap<>();
/*  94 */       JsonObject data = object.get("data").getAsJsonObject();
/*  95 */       for (Map.Entry<String, JsonElement> entry : (Iterable<Map.Entry<String, JsonElement>>)data.entrySet()) {
/*  96 */         ConcurrentHashMap<String, Double> tagMap = new ConcurrentHashMap<>();
/*  97 */         JsonObject tag = ((JsonElement)entry.getValue()).getAsJsonObject();
/*     */         
/*  99 */         for (Map.Entry<String, JsonElement> dataEntry : (Iterable<Map.Entry<String, JsonElement>>)tag.entrySet()) {
/* 100 */           tagMap.put(dataEntry.getKey(), Double.valueOf(((JsonElement)dataEntry.getValue()).getAsDouble()));
/*     */         }
/*     */         
/* 103 */         legacyData.put(entry.getKey(), tagMap);
/*     */       } 
/*     */       
/* 106 */       Map<String, Double> values = new ConcurrentHashMap<>();
/* 107 */       if (object.has("values")) {
/* 108 */         for (Map.Entry<String, JsonElement> tag : (Iterable<Map.Entry<String, JsonElement>>)object.get("values").getAsJsonObject().entrySet()) {
/* 109 */           values.put(tag.getKey(), Double.valueOf(((JsonElement)tag.getValue()).getAsDouble()));
/*     */         }
/*     */       }
/*     */       
/* 113 */       Map<String, String> tags = new ConcurrentHashMap<>();
/* 114 */       if (object.has("tag")) {
/* 115 */         for (Map.Entry<String, JsonElement> tag : (Iterable<Map.Entry<String, JsonElement>>)object.get("tag").getAsJsonObject().entrySet()) {
/* 116 */           tags.put(tag.getKey(), ((JsonElement)tag.getValue()).getAsString());
/*     */         }
/*     */       }
/*     */       
/* 120 */       ExternalServerStatistic commonGrafanaStatistic = new ExternalServerStatistic(name);
/* 121 */       commonGrafanaStatistic.legacyData.putAll(legacyData);
/* 122 */       commonGrafanaStatistic.values.putAll(values);
/* 123 */       commonGrafanaStatistic.tags.putAll(tags);
/*     */       
/* 125 */       return commonGrafanaStatistic;
/*     */     } 
/* 127 */     return null;
/*     */   } }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\grafana\ExternalServerStatistic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */