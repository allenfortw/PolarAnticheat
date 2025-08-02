/*    */ package net.craftigames.polar.common.util.adventure;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Objects;
/*    */ import java.util.UUID;
/*    */ import net.kyori.adventure.key.Key;
/*    */ import net.kyori.adventure.nbt.BinaryTag;
/*    */ import net.kyori.adventure.nbt.CompoundBinaryTag;
/*    */ import net.kyori.adventure.nbt.TagStringIO;
/*    */ import net.kyori.adventure.nbt.api.BinaryTagHolder;
/*    */ import net.kyori.adventure.text.Component;
/*    */ import net.kyori.adventure.text.TextComponent;
/*    */ import net.kyori.adventure.text.event.HoverEvent;
/*    */ import net.kyori.adventure.text.serializer.gson.LegacyHoverEventSerializer;
/*    */ import net.kyori.adventure.util.Codec;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ final class NBTLegacyHoverEventSerializerImpl
/*    */   implements LegacyHoverEventSerializer {
/* 20 */   static final NBTLegacyHoverEventSerializerImpl INSTANCE = new NBTLegacyHoverEventSerializerImpl();
/* 21 */   private static final TagStringIO SNBT_IO = TagStringIO.get();
/* 22 */   private static final Codec<CompoundBinaryTag, String, IOException, IOException> SNBT_CODEC = Codec.of(SNBT_IO::asCompound, SNBT_IO::asString); static { Objects.requireNonNull(SNBT_IO); Objects.requireNonNull(SNBT_IO); }
/*    */ 
/*    */ 
/*    */   
/*    */   static final String ITEM_TYPE = "id";
/*    */   
/*    */   static final String ITEM_COUNT = "Count";
/*    */   
/*    */   static final String ITEM_TAG = "tag";
/*    */   
/*    */   static final String ENTITY_NAME = "name";
/*    */   static final String ENTITY_TYPE = "type";
/*    */   static final String ENTITY_ID = "id";
/*    */   
/*    */   public HoverEvent.ShowItem deserializeShowItem(@NotNull Component input) throws IOException {
/* 37 */     assertTextComponent(input);
/* 38 */     CompoundBinaryTag contents = (CompoundBinaryTag)SNBT_CODEC.decode(((TextComponent)input).content());
/* 39 */     CompoundBinaryTag tag = contents.getCompound("tag");
/* 40 */     return HoverEvent.ShowItem.of(
/* 41 */         Key.key(contents.getString("id")), contents
/* 42 */         .getByte("Count", (byte)1), 
/* 43 */         (tag == CompoundBinaryTag.empty()) ? null : BinaryTagHolder.encode(tag, SNBT_CODEC));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public HoverEvent.ShowEntity deserializeShowEntity(@NotNull Component input, Codec.Decoder<Component, String, ? extends RuntimeException> componentCodec) throws IOException {
/* 49 */     assertTextComponent(input);
/* 50 */     CompoundBinaryTag contents = (CompoundBinaryTag)SNBT_CODEC.decode(((TextComponent)input).content());
/* 51 */     return HoverEvent.ShowEntity.of(
/* 52 */         Key.key(contents.getString("type")), 
/* 53 */         UUID.fromString(contents.getString("id")), (Component)componentCodec
/* 54 */         .decode(contents.getString("name")));
/*    */   }
/*    */ 
/*    */   
/*    */   private static void assertTextComponent(Component component) {
/* 59 */     if (!(component instanceof TextComponent) || !component.children().isEmpty()) {
/* 60 */       throw new IllegalArgumentException("Legacy events must be single Component instances");
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public Component serializeShowItem(HoverEvent.ShowItem input) throws IOException {
/* 68 */     CompoundBinaryTag.Builder builder = (CompoundBinaryTag.Builder)((CompoundBinaryTag.Builder)CompoundBinaryTag.builder().putString("id", input.item().asString())).putByte("Count", (byte)input.count());
/* 69 */     BinaryTagHolder nbt = input.nbt();
/* 70 */     if (nbt != null) {
/* 71 */       builder.put("tag", (BinaryTag)nbt.get(SNBT_CODEC));
/*    */     }
/* 73 */     return (Component)Component.text((String)SNBT_CODEC.encode(builder.build()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public Component serializeShowEntity(HoverEvent.ShowEntity input, Codec.Encoder<Component, String, ? extends RuntimeException> componentCodec) throws IOException {
/* 80 */     CompoundBinaryTag.Builder builder = (CompoundBinaryTag.Builder)((CompoundBinaryTag.Builder)CompoundBinaryTag.builder().putString("id", input.id().toString())).putString("type", input.type().asString());
/* 81 */     Component name = input.name();
/* 82 */     if (name != null) {
/* 83 */       builder.putString("name", (String)componentCodec.encode(name));
/*    */     }
/* 85 */     return (Component)Component.text((String)SNBT_CODEC.encode(builder.build()));
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\adventure\NBTLegacyHoverEventSerializerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */