/*    */ package net.craftigames.polar.common.util.adventure;
/*    */ 
/*    */ import net.kyori.adventure.text.serializer.gson.LegacyHoverEventSerializer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface NBTLegacyHoverEventSerializer
/*    */   extends LegacyHoverEventSerializer
/*    */ {
/*    */   @NotNull
/*    */   static LegacyHoverEventSerializer get() {
/* 20 */     return NBTLegacyHoverEventSerializerImpl.INSTANCE;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\adventure\NBTLegacyHoverEventSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */