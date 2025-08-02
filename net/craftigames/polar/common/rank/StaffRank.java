/*    */ package net.craftigames.polar.common.rank;
/*    */ public class StaffRank { private int priority; private String permission;
/*    */   private String name;
/*    */   
/*  5 */   public void setPriority(int priority) { this.priority = priority; } private String color; private String prefix; private String nametagColor; public void setPermission(String permission) { this.permission = permission; } public void setName(String name) { this.name = name; } public void setColor(String color) { this.color = color; } public void setPrefix(String prefix) { this.prefix = prefix; } public void setNametagColor(String nametagColor) { this.nametagColor = nametagColor; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof StaffRank)) return false;  StaffRank other = (StaffRank)o; if (!other.canEqual(this)) return false;  if (getPriority() != other.getPriority()) return false;  Object this$permission = getPermission(), other$permission = other.getPermission(); if ((this$permission == null) ? (other$permission != null) : !this$permission.equals(other$permission)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$color = getColor(), other$color = other.getColor(); if ((this$color == null) ? (other$color != null) : !this$color.equals(other$color)) return false;  Object this$prefix = getPrefix(), other$prefix = other.getPrefix(); if ((this$prefix == null) ? (other$prefix != null) : !this$prefix.equals(other$prefix)) return false;  Object this$nametagColor = getNametagColor(), other$nametagColor = other.getNametagColor(); return !((this$nametagColor == null) ? (other$nametagColor != null) : !this$nametagColor.equals(other$nametagColor)); } protected boolean canEqual(Object other) { return other instanceof StaffRank; } public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getPriority(); Object $permission = getPermission(); result = result * 59 + (($permission == null) ? 43 : $permission.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $color = getColor(); result = result * 59 + (($color == null) ? 43 : $color.hashCode()); Object $prefix = getPrefix(); result = result * 59 + (($prefix == null) ? 43 : $prefix.hashCode()); Object $nametagColor = getNametagColor(); return result * 59 + (($nametagColor == null) ? 43 : $nametagColor.hashCode()); } public String toString() { return "StaffRank(priority=" + getPriority() + ", permission=" + getPermission() + ", name=" + getName() + ", color=" + getColor() + ", prefix=" + getPrefix() + ", nametagColor=" + getNametagColor() + ")"; }
/*    */ 
/*    */   
/*  8 */   public int getPriority() { return this.priority; }
/*  9 */   public String getPermission() { return this.permission; }
/* 10 */   public String getName() { return this.name; }
/* 11 */   public String getColor() { return this.color; }
/* 12 */   public String getPrefix() { return this.prefix; } public String getNametagColor() {
/* 13 */     return this.nametagColor;
/*    */   }
/*    */   public StaffRank(int priority, String name, String color, String prefix) {
/* 16 */     this(priority, "group." + name.replace(".", "").toLowerCase(), name, color, prefix);
/*    */   }
/*    */   
/*    */   public StaffRank(int priority, String permission, String name, String color, String prefix) {
/* 20 */     this.priority = priority;
/* 21 */     this.permission = permission;
/* 22 */     this.name = name;
/* 23 */     this.color = color;
/* 24 */     this.prefix = prefix;
/*    */   }
/*    */   
/*    */   public String getNametag() {
/* 28 */     return getColor() + getName() + ((this.nametagColor == null) ? "&f " : (this.nametagColor + " "));
/*    */   }
/*    */   
/*    */   public boolean isHigherThan(StaffRank other) {
/* 32 */     return (other == null || other.getPriority() < getPriority());
/*    */   } }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\rank\StaffRank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */