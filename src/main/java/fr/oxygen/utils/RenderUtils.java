/*    */ package fr.oxygen.utils;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class RenderUtils
/*    */ {
/* 10 */   private static Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public static void init3D() {
/* 13 */     GL11.glDisable(3553);
/* 14 */     GL11.glDisable(2929);
/* 15 */     GL11.glDisable(2884);
/* 16 */     GL11.glDepthMask(false);
/* 17 */     GL11.glEnable(3042);
/* 18 */     GL11.glBlendFunc(770, 771);
/* 19 */     GL11.glLineWidth(1.0F);
/*    */   }
/*    */   
/*    */   public static void reset3D() {
/* 23 */     GL11.glDepthMask(true);
/* 24 */     GL11.glDisable(3042);
/* 25 */     GL11.glEnable(3553);
/* 26 */     GL11.glEnable(2929);
/* 27 */     GL11.glEnable(2884);
/*    */   }
/*    */   
/*    */   public static void drawOutlinedBlock(float fx, double bx, double by, double bz, int color) {
/* 31 */     float dx = (float)mc.thePlayer.posX;
/* 32 */     float dy = (float)mc.thePlayer.posY;
/* 33 */     float dz = (float)mc.thePlayer.posZ;
/* 34 */     float mx = (float)mc.thePlayer.prevPosX;
/* 35 */     float my = (float)mc.thePlayer.prevPosY;
/* 36 */     float mz = (float)mc.thePlayer.prevPosZ;
/* 37 */     float px = mx + (dx - mx) * fx;
/* 38 */     float py = my + (dy - my) * fx;
/* 39 */     float pz = mz + (dz - mz) * fx;
/*    */     
/* 41 */     float f = 0.0F;
/* 42 */     float f1 = 1.0F;
/*    */     
/* 44 */     Tessellator tes = Tessellator.instance;
/*    */     
/* 46 */     tes.startDrawing(1);
/* 47 */     tes.setColorRGBA_I(color, 255);
/* 48 */     tes.setBrightness(200);
/*    */     
/*    */ 
/* 51 */     tes.addVertex(bx - px + f, by - py + f1, bz - pz + f);tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f);
/* 52 */     tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f);tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f1);
/* 53 */     tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f1);tes.addVertex(bx - px + f, by - py + f1, bz - pz + f1);
/* 54 */     tes.addVertex(bx - px + f, by - py + f1, bz - pz + f1);tes.addVertex(bx - px + f, by - py + f1, bz - pz + f);
/*    */     
/*    */ 
/* 57 */     tes.addVertex(bx - px + f1, by - py + f, bz - pz + f);tes.addVertex(bx - px + f1, by - py + f, bz - pz + f1);
/* 58 */     tes.addVertex(bx - px + f1, by - py + f, bz - pz + f1);tes.addVertex(bx - px + f, by - py + f, bz - pz + f1);
/* 59 */     tes.addVertex(bx - px + f, by - py + f, bz - pz + f1);tes.addVertex(bx - px + f, by - py + f, bz - pz + f);
/* 60 */     tes.addVertex(bx - px + f, by - py + f, bz - pz + f);tes.addVertex(bx - px + f1, by - py + f, bz - pz + f);
/*    */     
/*    */ 
/* 63 */     tes.addVertex(bx - px + f1, by - py + f, bz - pz + f1);tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f1);
/* 64 */     tes.addVertex(bx - px + f1, by - py + f, bz - pz + f);tes.addVertex(bx - px + f1, by - py + f1, bz - pz + f);
/* 65 */     tes.addVertex(bx - px + f, by - py + f, bz - pz + f1);tes.addVertex(bx - px + f, by - py + f1, bz - pz + f1);
/* 66 */     tes.addVertex(bx - px + f, by - py + f, bz - pz + f);tes.addVertex(bx - px + f, by - py + f1, bz - pz + f);
/*    */     
/* 68 */     tes.draw();
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxyge\\utils\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */