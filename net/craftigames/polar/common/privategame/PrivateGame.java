package net.craftigames.polar.common.privategame;

import java.util.UUID;
import net.craftigames.polar.common.util.gson.GsonSerializable;

public interface PrivateGame extends GsonSerializable {
  UUID getOwner();
  
  String getServerType();
  
  String getMapName();
  
  void setBungeeName(String paramString);
  
  String getBungeeName();
  
  void setBooted(boolean paramBoolean);
  
  boolean isBooted();
  
  boolean isAllowSpectators();
  
  void setAllowSpectators(boolean paramBoolean);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\privategame\PrivateGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */