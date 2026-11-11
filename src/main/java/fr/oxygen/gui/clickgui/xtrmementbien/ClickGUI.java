/*     */ package fr.oxygen.gui.clickgui.xtrmementbien;
/*     */ 
/*     */ import fr.oxygen.gui.clickgui.xtrmementbien.objects.CPanel;
/*     */ import fr.oxygen.gui.clickgui.xtrmementbien.objects.MButton;
/*     */ import fr.oxygen.main.palamodaddons;
/*     */ import fr.oxygen.mods.Category;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClickGUI
/*     */   extends GuiScreen
/*     */ {
/*     */   public ArrayList<CPanel> elements;
/*     */   private float scale;
/*     */   
/*     */   public ClickGUI()
/*     */   {
/*  22 */     this.scale = 0.0F;
/*  23 */     this.elements = new ArrayList();
/*     */     
/*  25 */     int count = 0;
/*  26 */     for (Category c : Category.values()) {
/*  27 */       if (c != Category.GUI)
/*     */       {
/*  29 */         if (!palamodaddons.getModulesInCategory(c).isEmpty())
/*     */         {
/*     */ 
/*  32 */           this.elements.add(new CPanel(c, 15 + count * 100, 15, this));
/*  33 */           count++;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/*     */     
/*  42 */     for (CPanel cp : this.elements) {
/*  43 */       cp.drawScreen(mouseX, mouseY, partialTicks);
/*  44 */       for (MButton mb : cp.elements) {
/*  45 */         mb.drawScreen(mouseX, mouseY, partialTicks);
/*     */       }
/*     */     }
/*     */     
/*  49 */     GL11.glPopMatrix();
/*     */     
/*  51 */     if (this.scale < 1.0F) {
/*  52 */       this.scale += 0.1F;
/*     */     }
/*     */     
/*  55 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*     */   {
/*  60 */     for (CPanel cp : this.elements) {
/*  61 */       cp.mouseClicked(mouseX, mouseY, mouseButton);
/*  62 */       for (MButton mb : cp.elements) {
/*  63 */         mb.mouseClicked(mouseX, mouseY, mouseButton);
/*     */       }
/*     */     }
/*  66 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int dsaas)
/*     */   {
/*  72 */     if (dsaas != -1) {
/*  73 */       for (CPanel cp : this.elements) {
/*  74 */         cp.mouseReleased();
/*  75 */         for (MButton mb : cp.elements) {
/*  76 */           mb.mouseReleased();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void keyTyped(char typedChar, int keyCode)
/*     */   {
/*  90 */     for (CPanel cp : this.elements) {
/*  91 */       cp.keyTyped(typedChar, keyCode);
/*  92 */       for (MButton mb : cp.elements) {
/*  93 */         mb.keyTyped(typedChar, keyCode);
/*     */       }
/*     */     }
/*  96 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */   
/*     */   public boolean doesGuiPauseGame()
/*     */   {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public void onGuiClosed()
/*     */   {
/* 106 */     stopBind();
/* 107 */     this.scale = 0.0F;
/* 108 */     super.onGuiClosed();
/*     */   }
/*     */   
/*     */   public void stopBind() {
/* 112 */     for (CPanel cp : this.elements) {
/* 113 */       for (MButton mb : cp.elements) {
/* 114 */         mb.binding = false;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\xtrmementbien\ClickGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */