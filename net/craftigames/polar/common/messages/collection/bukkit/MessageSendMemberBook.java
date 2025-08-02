/*    */ package net.craftigames.polar.common.messages.collection.bukkit;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import net.craftigames.polar.common.messages.Message;
/*    */ import net.craftigames.polar.common.messages.collection.MessageIdentifier;
/*    */ import net.craftigames.polar.common.messages.collection.MessageType;
/*    */ import net.craftigames.polar.common.messages.networking.MessageInputStream;
/*    */ import net.craftigames.polar.common.messages.networking.MessageOutputStream;
/*    */ import net.craftigames.polar.common.util.TextUtils;
/*    */ import net.kyori.adventure.inventory.Book;
/*    */ import net.kyori.adventure.text.Component;
/*    */ 
/*    */ @MessageIdentifier(legacyId = 90)
/*    */ public class MessageSendMemberBook
/*    */   extends Message {
/*    */   private UUID player;
/*    */   private Book book;
/*    */   
/*    */   public MessageSendMemberBook() {}
/*    */   
/*    */   public UUID getPlayer() {
/* 27 */     return this.player; } public Book getBook() {
/* 28 */     return this.book;
/*    */   }
/*    */   public MessageSendMemberBook(UUID player, Book book) {
/* 31 */     this.player = player;
/* 32 */     this.book = book;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(MessageOutputStream out) {
/* 37 */     out.add("player", this.player);
/*    */     
/* 39 */     JsonObject book = new JsonObject();
/* 40 */     book.add("title", TextUtils.GSON_COMPONENT_SERIALIZER.serializeToTree(this.book.title()));
/* 41 */     book.add("author", TextUtils.GSON_COMPONENT_SERIALIZER.serializeToTree(this.book.author()));
/* 42 */     JsonArray pages = new JsonArray();
/* 43 */     for (Component page : this.book.pages()) {
/* 44 */       pages.add(TextUtils.GSON_COMPONENT_SERIALIZER.serializeToTree(page));
/*    */     }
/* 46 */     book.add("pages", (JsonElement)pages);
/*    */     
/* 48 */     out.add("book", (JsonElement)book);
/*    */   }
/*    */ 
/*    */   
/*    */   public void receive(MessageInputStream in) {
/* 53 */     if (!in.has("player")) {
/*    */       return;
/*    */     }
/* 56 */     this.player = in.getAsUUID("player");
/*    */     
/* 58 */     JsonObject book = in.get("book").getAsJsonObject();
/* 59 */     Component title = TextUtils.GSON_COMPONENT_SERIALIZER.deserializeFromTree(book.get("title"));
/* 60 */     Component author = TextUtils.GSON_COMPONENT_SERIALIZER.deserializeFromTree(book.get("author"));
/* 61 */     List<Component> pages = new ArrayList<>();
/* 62 */     for (JsonElement jsonElement : book.get("pages").getAsJsonArray()) {
/* 63 */       pages.add(TextUtils.GSON_COMPONENT_SERIALIZER.deserializeFromTree(jsonElement));
/*    */     }
/* 65 */     this.book = Book.book(title, author, pages);
/*    */   }
/*    */ 
/*    */   
/*    */   public MessageType getMessageType() {
/* 70 */     return MessageType.BUKKIT;
/*    */   }
/*    */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\collection\bukkit\MessageSendMemberBook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */