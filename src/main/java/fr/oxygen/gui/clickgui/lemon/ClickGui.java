/*    */ package fr.oxygen.gui.clickgui.lemon;
/*    */ 
/*    */ import fr.oxygen.mods.Category;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClickGui
/*    */   extends GuiScreen
/*    */ {
/*    */   public static ArrayList<Frame> frames;
/*    */   public static int color;
/*    */   
/*    */   public ClickGui()
/*    */   {
/* 18 */     color = -12389185;
/* 19 */     frames = new ArrayList();
/* 20 */     int frameY = 5;
/* 21 */     for (Category category : Category.values()) {
/* 22 */       if (category != Category.GUI) {
/* 23 */         Frame frame = new Frame(category);
/* 24 */         frame.setY(frameY);
/* 25 */         frames.add(frame);
/* 26 */         frameY += 14;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void initGui() {}
/*    */   
/*    */ 
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*    */   {
/* 37 */     for (Frame frame : frames) {
/* 38 */       frame.renderFrame(this.fontRendererObj);
/* 39 */       frame.updatePosition(mouseX, mouseY);
/* 40 */       for (Component comp : frame.getComponents()) {
/* 41 */         comp.updateComponent(mouseX, mouseY);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*    */   {
/* 48 */     for (Frame frame : frames) {
/* 49 */       if ((frame.isWithinHeader(mouseX, mouseY)) && (mouseButton == 0)) {
/* 50 */         frame.setDrag(true);
/* 51 */         frame.dragX = (mouseX - frame.getX());
/* 52 */         frame.dragY = (mouseY - frame.getY());
/*    */       }
/* 54 */       if ((frame.isWithinHeader(mouseX, mouseY)) && (mouseButton == 1)) {
/* 55 */         frame.setOpen(!frame.isOpen());
/*    */       }
/* 57 */       if ((frame.isOpen()) && 
/* 58 */         (!frame.getComponents().isEmpty())) {
/* 59 */         for (Component component : frame.getComponents()) {
/* 60 */           component.mouseClicked(mouseX, mouseY, mouseButton);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void keyTyped(char typedChar, int keyCode)
/*    */   {
/* 69 */     for (Frame frame : frames) {
/* 70 */       if ((frame.isOpen()) && (keyCode != 1) && 
/* 71 */         (!frame.getComponents().isEmpty())) {
/* 72 */         for (Component component : frame.getComponents()) {
/* 73 */           component.keyTyped(typedChar, keyCode);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 78 */     if (keyCode == 1) {
/* 79 */       this.mc.displayGuiScreen(null);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_)
/*    */   {
/* 86 */     for (Frame frame : frames) {
/* 87 */       frame.setDrag(false);
/*    */     }
/* 89 */     for (Frame frame : frames) {
/* 90 */       if ((frame.isOpen()) && 
/* 91 */         (!frame.getComponents().isEmpty())) {
/* 92 */         for (Component component : frame.getComponents()) {
/* 93 */           component.mouseReleased();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\lemon\ClickGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */