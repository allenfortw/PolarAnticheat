/*   */ package net.craftigames.polar.common.util.protocol.packets;
/*   */ 
/*   */ public interface ClientboundPackets
/*   */   extends PacketType
/*   */ {
/*   */   default Direction direction() {
/* 7 */     return Direction.CLIENTBOUND;
/*   */   }
/*   */ }


/* Location:              D:\Minecraft 伺服器資料\Pika&Jartex\PolarCommon-1.3.5-20230128.224209-66-LEAKED.jar!\net\craftigames\polar\commo\\util\protocol\packets\ClientboundPackets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */