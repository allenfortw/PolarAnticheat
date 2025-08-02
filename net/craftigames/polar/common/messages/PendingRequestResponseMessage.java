package net.craftigames.polar.common.messages;

import com.google.gson.JsonElement;
import java.util.UUID;

public interface PendingRequestResponseMessage {
  UUID getUuid();
  
  UUID getUser();
  
  JsonElement getData();
}


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\common\messages\PendingRequestResponseMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */