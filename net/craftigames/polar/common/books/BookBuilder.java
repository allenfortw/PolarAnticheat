/*     */ package net.craftigames.polar.common.books;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.craftigames.polar.common.util.TextUtils;
/*     */ import net.craftigames.polar.common.util.gson.GsonSerializable;
/*     */ import net.kyori.adventure.text.Component;
/*     */ import net.kyori.adventure.text.TextComponent;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class BookBuilder
/*     */   implements GsonSerializable
/*     */ {
/*  17 */   private String title = "Title";
/*  18 */   private String author = "Botervrij";
/*  19 */   private final List<TextComponent> pages = new ArrayList<>();
/*  20 */   private BookBuilderGeneration generation = BookBuilderGeneration.ORIGINAL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder title(String title) {
/*  28 */     this.title = title;
/*  29 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String title() {
/*  38 */     return this.title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder author(String author) {
/*  47 */     this.author = author;
/*  48 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String author() {
/*  57 */     return this.author;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder withPage(TextComponent component) {
/*  66 */     this.pages.add(component);
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public BookBuilder withPage(String input) {
/*  71 */     return withPage(TextUtils.fromLegacy(input));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder insertPage(int page, TextComponent component) {
/*  81 */     this.pages.add(page, component);
/*  82 */     return this;
/*     */   }
/*     */   
/*     */   public BookBuilder insertPage(int page, String input) {
/*  86 */     return insertPage(page, TextUtils.fromLegacy(input));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder replacePage(int page, TextComponent component) {
/*  96 */     this.pages.set(page, component);
/*  97 */     return this;
/*     */   }
/*     */   
/*     */   public BookBuilder replacePage(int page, String input) {
/* 101 */     return replacePage(page, TextUtils.fromLegacy(input));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextComponent getPage(int page) {
/* 112 */     return this.pages.get(page);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPage(int page) {
/* 123 */     return (this.pages.size() < page);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<TextComponent> getPages() {
/* 132 */     return this.pages;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilder generation(BookBuilderGeneration generation) {
/* 141 */     this.generation = generation;
/* 142 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BookBuilderGeneration generation() {
/* 151 */     return this.generation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public JsonElement serialize() {
/* 159 */     JsonObject object = new JsonObject();
/*     */     
/* 161 */     object.addProperty("title", this.title);
/* 162 */     object.addProperty("author", this.author);
/*     */     
/* 164 */     JsonArray pages = new JsonArray();
/* 165 */     for (TextComponent page : this.pages) {
/* 166 */       pages.add(TextUtils.GSON_COMPONENT_SERIALIZER.serializeToTree((Component)page));
/*     */     }
/* 168 */     object.add("pages", (JsonElement)pages);
/*     */     
/* 170 */     return (JsonElement)object;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static BookBuilder deserialize(JsonElement element) {
/* 175 */     BookBuilder bookBuilder = new BookBuilder();
/* 176 */     if (element.isJsonObject()) {
/* 177 */       JsonObject object = element.getAsJsonObject();
/*     */       
/* 179 */       bookBuilder.title(object.get("title").getAsString());
/* 180 */       bookBuilder.author(object.get("author").getAsString());
/*     */       
/* 182 */       if (object.get("pages") instanceof JsonArray) {
/* 183 */         JsonArray pages = object.get("pages").getAsJsonArray();
/*     */         
/* 185 */         for (JsonElement jsonElement : pages) {
/* 186 */           Component component = TextUtils.GSON_COMPONENT_SERIALIZER.deserializeFromTree(jsonElement);
/*     */           try {
/* 188 */             bookBuilder.withPage((TextComponent)component);
/* 189 */           } catch (ClassCastException e) {
/* 190 */             e.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 196 */     return bookBuilder;
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\books\BookBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */