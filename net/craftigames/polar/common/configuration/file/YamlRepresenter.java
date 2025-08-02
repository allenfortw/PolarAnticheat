/*    */ package net.craftigames.polar.common.configuration.file;
/*    */ 
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import net.craftigames.polar.common.configuration.ConfigurationSection;
/*    */ import net.craftigames.polar.common.configuration.serialization.ConfigurationSerializable;
/*    */ import net.craftigames.polar.common.configuration.serialization.ConfigurationSerialization;
/*    */ import org.yaml.snakeyaml.nodes.Node;
/*    */ import org.yaml.snakeyaml.representer.Representer;
/*    */ import org.yaml.snakeyaml.representer.SafeRepresenter;
/*    */ 
/*    */ public class YamlRepresenter
/*    */   extends Representer {
/*    */   public YamlRepresenter() {
/* 15 */     this.multiRepresenters.put(ConfigurationSection.class, new RepresentConfigurationSection());
/* 16 */     this.multiRepresenters.put(ConfigurationSerializable.class, new RepresentConfigurationSerializable());
/*    */   }
/*    */   private class RepresentConfigurationSection extends SafeRepresenter.RepresentMap { private RepresentConfigurationSection() {
/* 19 */       super((SafeRepresenter)YamlRepresenter.this);
/*    */     }
/*    */     public Node representData(Object data) {
/* 22 */       return super.representData(((ConfigurationSection)data).getValues(false));
/*    */     } }
/*    */   
/*    */   private class RepresentConfigurationSerializable extends SafeRepresenter.RepresentMap { private RepresentConfigurationSerializable() {
/* 26 */       super((SafeRepresenter)YamlRepresenter.this);
/*    */     }
/*    */     public Node representData(Object data) {
/* 29 */       ConfigurationSerializable serializable = (ConfigurationSerializable)data;
/* 30 */       Map<String, Object> values = new LinkedHashMap<>();
/* 31 */       values.put("==", ConfigurationSerialization.getAlias(serializable.getClass()));
/* 32 */       values.putAll(serializable.serialize());
/*    */       
/* 34 */       return super.representData(values);
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\configuration\file\YamlRepresenter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */