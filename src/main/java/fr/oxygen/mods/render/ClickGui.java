/*    */ package fr.oxygen.mods.render;
import org.lwjgl.input.Keyboard;

import fr.oxygen.mods.Category;
/*    */ 
/*    */ import fr.oxygen.mods.Module;
/*    */ 
/*    */ public class ClickGui extends Module
/*    */ {
/*    */   private fr.oxygen.gui.clickgui.xtrmementbien.ClickGUI gui;
/*    */   
/*    */   public ClickGui()
/*    */   {
/* 11 */     super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDU);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 18 */     if (this.gui == null) {
/* 19 */       this.gui = new fr.oxygen.gui.clickgui.xtrmementbien.ClickGUI();
/*    */     }
/* 21 */     this.mc.displayGuiScreen(this.gui);
/*    */     
/* 23 */     toggle();
/* 24 */     super.onEnable();
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\mods\render\ClickGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */