/*     */ package net.craftigames.polar.common.command;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.craftigames.polar.common.util.gson.JsonBuilder;
/*     */ 
/*     */ public class PolarCommand {
/*     */   private CommandType commandType;
/*     */   private String command;
/*     */   
/*  18 */   public void setCommandType(CommandType commandType) { this.commandType = commandType; } private String permission; private List<String> aliases; public void setCommand(String command) { this.command = command; } public void setPermission(String permission) { this.permission = permission; } public void setAliases(List<String> aliases) { this.aliases = aliases; } public void setAliasesNotAllowedOn(Map<String, List<String>> aliasesNotAllowedOn) { this.aliasesNotAllowedOn = aliasesNotAllowedOn; } public void setActiveOnServers(List<String> activeOnServers) { this.activeOnServers = activeOnServers; } public String toString() { return "PolarCommand(commandType=" + getCommandType() + ", command=" + getCommand() + ", permission=" + getPermission() + ", aliases=" + getAliases() + ", aliasesNotAllowedOn=" + getAliasesNotAllowedOn() + ", activeOnServers=" + getActiveOnServers() + ")"; }
/*     */ 
/*     */   
/*  21 */   public CommandType getCommandType() { return this.commandType; }
/*  22 */   public String getCommand() { return this.command; } public String getPermission() { return this.permission; } public List<String> getAliases() {
/*  23 */     return this.aliases;
/*  24 */   } private Map<String, List<String>> aliasesNotAllowedOn = new HashMap<>(); public Map<String, List<String>> getAliasesNotAllowedOn() { return this.aliasesNotAllowedOn; }
/*  25 */    private List<String> activeOnServers = new ArrayList<>(); public List<String> getActiveOnServers() { return this.activeOnServers; }
/*     */   
/*     */   public PolarCommand(CommandType commandType, String command, String permission, String... aliases) {
/*  28 */     this.command = command;
/*  29 */     this.permission = permission;
/*  30 */     this.aliases = new ArrayList<>(Arrays.asList(aliases));
/*  31 */     this.commandType = commandType;
/*     */   }
/*     */   
/*     */   public PolarCommand(JsonObject jsonObject) {
/*  35 */     this.command = jsonObject.get("command").getAsString();
/*  36 */     this.permission = jsonObject.get("permission").getAsString();
/*  37 */     this.commandType = CommandType.valueOf(jsonObject.get("type").getAsString());
/*     */     
/*  39 */     JsonArray array = jsonObject.get("aliases").getAsJsonArray();
/*  40 */     this.aliases = Lists.newArrayList();
/*     */     
/*  42 */     for (JsonElement e : array) {
/*  43 */       this.aliases.add(e.getAsString());
/*     */     }
/*     */     
/*  46 */     if (jsonObject.has("allowedOn")) {
/*  47 */       JsonArray allowedOn = jsonObject.get("allowedOn").getAsJsonArray();
/*  48 */       for (JsonElement e : allowedOn) {
/*  49 */         this.activeOnServers.add(e.getAsString());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isUsingPermission() {
/*  55 */     return (this.permission != null && this.permission.equals(""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonObject toJson() {
/*  63 */     JsonBuilder.JsonObjectBuilder b = JsonBuilder.object().add("command", getCommand()).add("type", this.commandType.name()).add("permission", (getPermission() == null) ? "" : "").add("aliases", this::aliasesToJson);
/*     */     
/*  65 */     if (this.activeOnServers != null && !this.activeOnServers.isEmpty()) {
/*  66 */       b.add("allowedOn", this::aliasesToJson);
/*     */     }
/*     */     
/*  69 */     return b.build();
/*     */   }
/*     */   
/*     */   public void addDisallowedAlias(String server, String alias) {
/*  73 */     getAliasesNotAllowedOn().putIfAbsent(server, Lists.newArrayList());
/*  74 */     ((List<String>)getAliasesNotAllowedOn().get(server)).add(alias);
/*     */   }
/*     */   
/*     */   private JsonArray allowedServersToJson() {
/*  78 */     JsonArray array = new JsonArray();
/*  79 */     for (String server : getActiveOnServers()) {
/*  80 */       array.add(server);
/*     */     }
/*     */     
/*  83 */     return array;
/*     */   }
/*     */ 
/*     */   
/*     */   private JsonArray aliasesToJson() {
/*  88 */     JsonArray array = new JsonArray();
/*  89 */     for (String alias : getAliases()) {
/*  90 */       array.add(alias);
/*     */     }
/*     */     
/*  93 */     return array;
/*     */   }
/*     */   
/*     */   public boolean canUseCommand(String server) {
/*  97 */     if (getActiveOnServers() == null || getActiveOnServers().isEmpty()) {
/*  98 */       return true;
/*     */     }
/*     */     
/* 101 */     for (String activeOnServer : getActiveOnServers()) {
/* 102 */       if (activeOnServer.contains(server)) {
/* 103 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 112 */     if (this == o) return true; 
/* 113 */     if (o == null || getClass() != o.getClass()) return false;
/*     */     
/* 115 */     PolarCommand that = (PolarCommand)o;
/*     */     
/* 117 */     return Objects.equals(this.command, that.command);
/*     */   }
/*     */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\command\PolarCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */