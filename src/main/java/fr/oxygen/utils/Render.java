/*    */ package fr.oxygen.utils;
/*    */ 
/*    */ import net.minecraft.block.BlockChest;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Render
/*    */ {
/*    */   public static void blockESPBox(BlockChest blockPos)
/*    */   {
/* 15 */     double x = blockPos.getBlockBoundsMaxX() - Minecraft.getMinecraft().thePlayer.posX;
/*    */     
/*    */ 
/* 18 */     double y = blockPos.getBlockBoundsMaxY() - Minecraft.getMinecraft().thePlayer.posY;
/*    */     
/*    */ 
/* 21 */     double z = blockPos.getBlockBoundsMaxZ() - Minecraft.getMinecraft().thePlayer.posZ;
/* 22 */     GL11.glBlendFunc(770, 771);
/* 23 */     GL11.glEnable(3042);
/* 24 */     GL11.glLineWidth(2.0F);
/* 25 */     GL11.glColor4d(0.0D, 1.0D, 0.0D, 0.15000000596046448D);
/* 26 */     GL11.glDisable(3553);
/* 27 */     GL11.glDisable(2929);
/* 28 */     GL11.glDepthMask(false);
/*    */     
/* 30 */     GL11.glColor4d(0.0D, 0.0D, 1.0D, 0.5D);
/* 31 */     GL11.glEnable(3553);
/* 32 */     GL11.glEnable(2929);
/* 33 */     GL11.glDepthMask(true);
/* 34 */     GL11.glDisable(3042);
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxyge\\utils\Render.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */