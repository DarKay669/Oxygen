/*    */ package fr.oxygen.utils;
/*    */ 
/*    */ import net.minecraft.network.Packet;
/*    */ 
/*    */ public class Event
/*    */ {
/*    */   public Packet packet;
/*    */   
/*    */   public Event(Packet packet)
/*    */   {
/* 11 */     this.packet = packet;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean b) {}
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxyge\\utils\Event.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */