/*    */ package fr.oxygen.mods.player;
/*    */ 
/*    */ import fr.oxygen.mods.Category;
/*    */ import fr.oxygen.mods.Module;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ 
/*    */ public class DeathCordo
/*    */   extends Module
/*    */ {
/*    */   public DeathCordo()
/*    */   {
/* 14 */     super("DeathCoords", 66, Category.JOUEUR);
/*    */   }
/*    */   
/*    */   public void onUpdate()
/*    */   {
/* 19 */     if ((isToggled()) && 
/* 20 */       (this.mc.thePlayer.isDead)) {
/* 21 */       this.mc.thePlayer.respawnPlayer();
/* 22 */       this.mc.thePlayer.addChatMessage(new ChatComponentText("Death coords: [X:" + this.mc.thePlayer.posX + ", Y:" + this.mc.thePlayer.posY + ", Z:" + this.mc.thePlayer.posZ + "]"));
/*    */     }
/*    */     
/* 25 */     super.onUpdate();
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\mods\player\DeathCordo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */