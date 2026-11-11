/*    */ package fr.oxygen.mods.render;
/*    */ 
/*    */ import fr.oxygen.main.palamodaddons;
/*    */ import fr.oxygen.mods.Category;
/*    */ import fr.oxygen.mods.Module;
/*    */ import fr.oxygen.utils.ColorUtils;
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ 
/*    */ public class HUD
/*    */   extends Module
/*    */ {
/*    */   public HUD()
/*    */   {
/* 23 */     super("HUD", 35, Category.GUI);
/* 24 */     setToggled(true);
/*    */   }
/*    */   
/* 27 */   private float hue = 0.0F;
/*    */   
/*    */   public void onRender()
/*    */   {
/* 31 */     if (!isToggled()) return;
/* 32 */     float hue1 = this.hue;
/* 33 */     this.hue += 0.005F;
/* 34 */     if (this.hue >= 255.0F) {
/* 35 */       this.hue = 0.0F;
/*    */     }
/* 37 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Oxygen APRIL UPDATE - " + this.mc.thePlayer.getDisplayName() + " - " + this.mc.thePlayer.getHealth() + "<3", 4, 3, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/* 38 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.mc.debug, 4, 230, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*    */     
/* 40 */     int x = (int)this.mc.thePlayer.posX;
/* 41 */     int y = (int)this.mc.thePlayer.posY;
/* 42 */     int z = (int)this.mc.thePlayer.posZ;
/*    */     
/* 44 */     String var1 = "§c " + x;
/* 45 */     String var2 = "§c " + y;
/* 46 */     String var3 = "§c " + z;
/*    */     
/* 48 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("x :" + var1, 5, 195, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/* 49 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("y :" + var2, 5, 205, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/* 50 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("z :" + var3, 5, 215, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*    */     
/*    */ 
/*    */ 
/* 54 */     ArrayList<Module> mods = palamodaddons.getModules();
/* 55 */     Collections.sort(mods, new Comparator() {
/*    */       public int compare(Module m1, Module m2) {
/* 57 */         if (Minecraft.getMinecraft().fontRenderer.getStringWidth(m1.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(m2.getName())) {
/* 58 */           return -1;
/*    */         }
/* 60 */         if (Minecraft.getMinecraft().fontRenderer.getStringWidth(m1.getName()) < Minecraft.getMinecraft().fontRenderer.getStringWidth(m2.getName())) {
/* 61 */           return 1;
/*    */         }
/* 63 */         return 0;
/*    */       }
/*    */       
/* 66 */

@Override
public int compare(Object arg0, Object arg1) {
	// TODO Auto-generated method stub
	return 0;
}     });
/* 67 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
/*    */     
/* 69 */     int count = 0;
/* 70 */     for (Module m : mods) {
/* 71 */       if ((m.isToggled()) && (!m.isCategory(Category.GUI)))
/*    */       {
/* 73 */         Gui.drawRect(sr.getScaledWidth() - Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName()) - 2, count * 10, sr.getScaledWidth(), (count + 1) * 10, 0);
/* 74 */         Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(m.getName(), sr.getScaledWidth() - Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName()) - 1, count * 10 + 1, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/* 75 */         count++;
/* 76 */         hue1 += ColorUtils.effect(0L, 0.7F, 1).getRGB();
/* 77 */         if (hue1 >= 255.0F) {
/* 78 */           hue1 = 0.0F;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 83 */     super.onRender();
/*    */   }
/*    */   
/*    */   private void drawStringWithShadow(FontRenderer fontRenderer, String bar1, int i, int j, int k) {}
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\mods\render\HUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */