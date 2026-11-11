/*    */ package fr.oxygen.session;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GuiAltLogin
/*    */   extends GuiScreen
/*    */ {
/*    */   private PasswordField password;
/*    */   private AltLoginThread thread;
/*    */   private GuiTextField username;
/*    */   
/*    */   protected void actionPerformed(GuiButton button)
/*    */   {
/* 24 */     switch (button.id) {
/*    */     case 100: 
/* 26 */       this.mc.shutdown();
/* 27 */       break;
/*    */     
/*    */     case 0: 
/* 30 */       this.thread = new AltLoginThread(this.password.getText());
/* 31 */       this.thread.start();
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */   public void drawScreen(int x2, int y2, float z2)
/*    */   {
/* 38 */     drawDefaultBackground();
/*    */     
/* 40 */     this.password.drawTextBox();
/* 41 */     drawCenteredString(this.mc.fontRenderer, "Oxygen Connexion", this.width / 2, 20, -1);
/* 42 */     drawCenteredString(this.mc.fontRenderer, this.thread == null ? EnumChatFormatting.GRAY + "En attente d'auth..." : this.thread.getStatus(), this.width / 2, 40, -1);
/*    */     
/*    */ 
/*    */ 
/* 46 */     if (this.password.getText().isEmpty()) {
/* 47 */       drawString(this.mc.fontRenderer, "ID Compte", this.width / 2 - 96, 106, -7829368);
/*    */     }
/* 49 */     super.drawScreen(x2, y2, z2);
/*    */   }
/*    */   
/*    */   public void initGui()
/*    */   {
/* 54 */     int var3 = this.height / 4 + 24;
/* 55 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, var3 + 72 + 12, "Connexion"));
/* 56 */     this.buttonList.add(new GuiButton(100, this.width / 2 - 100, var3 + 72 + 12 + 24, "Quitter"));
/*    */     
/* 58 */     this.password = new PasswordField(this.mc.fontRenderer, this.width / 2 - 100, 100, 200, 20);
/*    */     
/* 60 */     Keyboard.enableRepeatEvents(true);
/*    */   }
/*    */   
/*    */   protected void keyTyped(char character, int key)
/*    */   {
/* 65 */     super.keyTyped(character, key);
/* 66 */     if (character == '\t')
/*    */     {
/*    */ 
/*    */ 
/* 70 */       this.username.setFocused(this.password.isFocused());
/* 71 */       this.password.setFocused(!this.username.isFocused());
/*    */     }
/*    */     
/* 74 */     if (character == '\r') {
/* 75 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*    */     }
/*    */     
/* 78 */     this.password.textboxKeyTyped(character, key);
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int x2, int y2, int button)
/*    */   {
/* 83 */     super.mouseClicked(x2, y2, button);
/*    */     
/* 85 */     this.password.mouseClicked(x2, y2, button);
/*    */   }
/*    */   
/*    */   public void onGuiClosed()
/*    */   {
/* 90 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */   
/*    */ 
/*    */   public void updateScreen()
/*    */   {
/* 96 */     this.password.updateCursorCounter();
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\session\GuiAltLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */