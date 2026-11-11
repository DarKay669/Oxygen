/*    */ package fr.oxygen.gui;
/*    */ 
/*    */ import fr.oxygen.session.GuiAltLogin;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ import net.minecraft.client.gui.GuiOptions;
/*    */ import net.minecraft.client.gui.GuiSelectWorld;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import org.apache.commons.io.Charsets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiCustomMainMenu
/*    */   extends GuiMainMenu
/*    */ {
/*    */   public void initGui()
/*    */   {
/* 27 */     super.initGui();
/*    */     
/* 29 */     this.buttonList.add(new GuiButton(41, 171, 161, 135, 20, I18n.format(EnumChatFormatting.RED + "proxy.paladium-pvp.fr", new Object[] { Charsets.UTF_8, new Object[0] })));
/* 30 */     this.buttonList.add(new GuiButton(34, 171, 215, 135, 20, I18n.format(EnumChatFormatting.RED + "Comptes", new Object[] { Charsets.UTF_8, new Object[0] })));
/* 31 */     this.buttonList.add(new GuiButton(102, 350, 211, 50, 20, I18n.format(EnumChatFormatting.RED + "Logout", new Object[] { Charsets.UTF_8, new Object[0] })));
/*    */   }
/*    */   
/* 34 */   protected void actionPerformed(GuiButton button) { switch (button.id) {
/*    */     case 0: 
/* 36 */       this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
/* 37 */       break;
/*    */     
/*    */     case 41: 
/* 40 */       this.mc.displayGuiScreen(new ConnectToServer());
/* 41 */       break;
/*    */     case 4: 
/* 43 */       this.mc.shutdown();
/* 44 */       break;
/*    */     case 1: 
/* 46 */       this.mc.displayGuiScreen(new GuiSelectWorld(this));
/* 47 */       break;
/*    */     case 2: 
/* 49 */       this.mc.displayGuiScreen(new GuiMultiplayer(this));
/* 50 */       break;
/*    */     case 102: 
/* 52 */       this.mc.displayGuiScreen(new GuiAltLogin());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\GuiCustomMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */