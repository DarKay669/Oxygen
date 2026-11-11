/*    */ package fr.oxygen.gui;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class F3
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   @SubscribeEvent
/*    */   public void onRenderPre(RenderGameOverlayEvent.Pre event)
/*    */   {
/* 24 */     if (event.type == RenderGameOverlayEvent.ElementType.DEBUG)
/*    */     {
/*    */ 
/*    */ 
/* 28 */       Minecraft mc = Minecraft.getMinecraft();
/* 29 */       event.setCanceled(true);
/*    */       
/*    */ 
/*    */ 
/* 33 */       int angle = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
/* 34 */       String direction = net.minecraft.util.Direction.directions[angle];
/* 35 */       String var = "    ";
/*    */       
/* 37 */       int x = (int)mc.thePlayer.posX;
/* 38 */       int y = (int)mc.thePlayer.posY;
/* 39 */       int z = (int)mc.thePlayer.posZ;
/*    */       
/* 41 */       String bar1 = "-------------------------";
/* 42 */       String var1 = " X > " + x;
/* 43 */       String var2 = " Y > " + y;
/* 44 */       String var3 = " Z > " + z;
/* 45 */       String var4 = "Oxygen / MC1.7.10";
/* 46 */       String var5 = "FPS : ";
/* 47 */       String bar2 = "-------------------------";
/*    */       
/* 49 */       drawString(mc.fontRenderer, bar1, 2, 9, 16777215);
/* 50 */       drawString(mc.fontRenderer, var3, 10, 65, 16777215);
/* 51 */       drawString(mc.fontRenderer, var2, 10, 50, 16777215);
/* 52 */       drawString(mc.fontRenderer, var1, 10, 35, 16777215);
/* 53 */       drawString(mc.fontRenderer, var4, 2, 15, 16777215);
/* 54 */       drawString(mc.fontRenderer, var5, 15, 80, 16777215);
/* 55 */       drawString(mc.fontRenderer, bar2, 2, 90, 16777215);
/* 56 */       drawString(mc.fontRenderer, mc.debug.split(",", 0)[0], 50, 80, 16777215);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   private void drawString(FontRenderer fontRenderer, String string, int x, int y, int color)
/*    */   {
/* 64 */     fontRenderer.drawStringWithShadow(string, x, y, color);
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\F3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */