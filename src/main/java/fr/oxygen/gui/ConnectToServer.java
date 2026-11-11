/*    */ package fr.oxygen.gui;
/*    */ 
/*    */ import fr.oxygen.utils.RL;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.multiplayer.GuiConnecting;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConnectToServer
/*    */   extends GuiScreen
/*    */ {
/* 15 */   private final RL background = new RL("assets/palamodaddons/textures/items/paladium_green_sword.png");
/*    */   
/*    */ 
/* 18 */   private int updateCounter = 0;
/*    */   
/* 20 */   String chargementText = "Connexion a Paladium...";
/* 21 */   String serverName = "";
/* 22 */   String textHaut = "Le serveur n'est toujours pas patch !";
/* 23 */   String typeserveur = "Oxygen";
/*    */   
/*    */   public void initGui()
/*    */   {
/* 27 */     this.buttonList.add(new GuiButton(41, this.width - 100, this.height - 30, 60, 20, "Annuler"));
/*    */   }
/*    */   
/*    */   public void updateScreen()
/*    */   {
/* 32 */     this.updateCounter += 1;
/*    */     
/* 34 */     if (this.updateCounter == 1) {
/* 35 */       this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, "proxy.paladium-pvp.fr", 25565));
/*    */     }
/*    */     
/* 38 */     if (this.updateCounter >= 2) {
/* 39 */       this.mc.displayGuiScreen(new GuiCustomMainMenu());
/*    */     }
/*    */   }
/*    */   
/*    */   public void actionPerformed(GuiButton button)
/*    */   {
/* 45 */     if (button.id == 41) {
/* 46 */       this.mc.displayGuiScreen(new GuiCustomMainMenu());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\ConnectToServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */