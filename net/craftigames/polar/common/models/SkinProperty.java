/*    */ package net.craftigames.polar.common.models;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import javax.annotation.Nonnull;
/*    */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*    */ 
/*    */ public class SkinProperty implements GsonSerializable {
/*    */   private String name;
/*    */   private String value;
/*    */   private String signature;
/*    */   
/* 14 */   public void setName(String name) { this.name = name; } public void setValue(String value) { this.value = value; } public void setSignature(String signature) { this.signature = signature; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SkinProperty)) return false;  SkinProperty other = (SkinProperty)o; if (!other.canEqual(this)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$value = getValue(), other$value = other.getValue(); if ((this$value == null) ? (other$value != null) : !this$value.equals(other$value)) return false;  Object this$signature = getSignature(), other$signature = other.getSignature(); return !((this$signature == null) ? (other$signature != null) : !this$signature.equals(other$signature)); } protected boolean canEqual(Object other) { return other instanceof SkinProperty; } public int hashCode() { int PRIME = 59; result = 1; Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $value = getValue(); result = result * 59 + (($value == null) ? 43 : $value.hashCode()); Object $signature = getSignature(); return result * 59 + (($signature == null) ? 43 : $signature.hashCode()); } public String toString() { return "SkinProperty(name=" + getName() + ", value=" + getValue() + ", signature=" + getSignature() + ")"; } public SkinProperty(String name, String value, String signature) {
/* 15 */     this.name = name; this.value = value; this.signature = signature;
/*    */   }
/*    */   
/*    */   public SkinProperty() {}
/* 19 */   public String getName() { return this.name; }
/* 20 */   public String getValue() { return this.value; } public String getSignature() {
/* 21 */     return this.signature;
/*    */   }
/*    */   public static SkinProperty valuesFromJson(JsonObject obj) {
/* 24 */     if (obj.has("properties")) {
/* 25 */       JsonArray properties = obj.getAsJsonArray("properties");
/* 26 */       JsonObject propertiesObject = properties.get(0).getAsJsonObject();
/*    */       
/* 28 */       String name = propertiesObject.get("name").getAsString();
/* 29 */       String value = propertiesObject.get("value").getAsString();
/* 30 */       String signature = propertiesObject.get("signature").getAsString();
/*    */       
/* 32 */       return new SkinProperty(name, value, signature);
/*    */     } 
/*    */     
/* 35 */     return null;
/*    */   }
/*    */   
/*    */   public static SkinProperty deserialize(JsonElement element) {
/* 39 */     if (element.isJsonNull()) {
/* 40 */       return null;
/*    */     }
/*    */     
/* 43 */     JsonObject object = element.getAsJsonObject();
/* 44 */     SkinProperty skinProperty = new SkinProperty();
/* 45 */     skinProperty.setName(object.get("name").getAsString());
/* 46 */     skinProperty.setValue(object.get("value").getAsString());
/* 47 */     skinProperty.setSignature(object.get("signature").getAsString());
/*    */     
/* 49 */     return skinProperty;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Nonnull
/*    */   public JsonElement serialize() {
/* 56 */     return (JsonElement)JsonBuilder.object()
/* 57 */       .add("name", this.name)
/* 58 */       .add("value", this.value)
/* 59 */       .add("signature", this.signature)
/* 60 */       .build();
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\models\SkinProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */