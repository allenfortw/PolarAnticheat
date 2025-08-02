package net.craftigames.polar.common.messages;

import java.util.UUID;

public interface RequestMessage {
  String getId();
  
  UUID getIdentifier();
  
  void setIdentifier(UUID paramUUID);
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\RequestMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */