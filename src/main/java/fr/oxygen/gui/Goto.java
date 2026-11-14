/*    */ package fr.oxygen.gui;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.Session;
/*    */ import org.apache.commons.io.Charsets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Goto
/*    */   extends GuiScreen
/*    */ {
/*    */   public void drawScreen(int x2, int y2, float z2)
/*    */   {
/* 24 */     drawDefaultBackground();
/* 25 */     drawCenteredString(this.mc.fontRenderer, "Que voulez-vous faire?", this.width / 2, 20, -1);
/* 26 */     drawCenteredString(this.mc.fontRenderer, EnumChatFormatting.GREEN + "Connexion avec succes", this.width / 2, 40, -1);
/* 27 */     drawCenteredString(this.mc.fontRenderer, EnumChatFormatting.GRAY + "ID : " + this.mc.getSession().getToken(), this.width / 25, 2, -1);
/* 28 */     drawCenteredString(this.mc.fontRenderer, EnumChatFormatting.BOLD + "Bienvenue " + this.mc.getSession().getUsername(), this.width / 2, 100, -1);
/* 29 */     super.drawScreen(x2, y2, z2);
/*    */   }
/*    */   
/*    */   public void initGui()
/*    */   {
/* 34 */     int var3 = this.height / 4 + 24;
/* 35 */     this.buttonList.add(new GuiButton(89, 171, 116, 135, 20, I18n.format(EnumChatFormatting.AQUA + "Acceder à Paladium.", new Object[] { Charsets.UTF_8, new Object[0] })));
/* 36 */     this.buttonList.add(new GuiButton(78, 171, 141, 135, 20, I18n.format(EnumChatFormatting.AQUA + "Menu principal.", new Object[] { Charsets.UTF_8, new Object[0] })));
/*    */   }
/*    */   
/*    */   protected void actionPerformed(GuiButton button) {
/* 40 */     switch (button.id) {
/*    */     case 89: 
/* 42 */       this.mc.displayGuiScreen(new ConnectToServer());
/* 43 */       break;
/*    */     
/*    */     case 78: 
/* 46 */       this.mc.displayGuiScreen(new GuiCustomMainMenu());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\Goto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */