/*    */ package fr.oxygen.session;
/*    */ 
/*    */ import fr.oxygen.gui.Goto;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class AltLoginThread
/*    */   extends Thread
/*    */ {
/*    */   private String password;
/*    */   private String status;
/* 29 */   private Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public AltLoginThread(String password) {
/* 32 */     super("Oxygen Connexion");
/*    */     
/* 34 */     this.password = password;
/* 35 */     this.status = (EnumChatFormatting.DARK_RED + "Probleme de connexion !");
/*    */   }
/*    */   
/*    */   public String getStatus()
/*    */   {
/* 40 */     return this.status;
/*    */   }
/*    */   
/*    */   public void run() {
/* 44 */     if (this.password.equals("")) {
/* 45 */       this.status = (EnumChatFormatting.RED + "Connectez-vous avec votre compte Oxygen");
/* 46 */       return;
/*    */     }
/* 48 */     this.status = (EnumChatFormatting.GRAY + "Connexion...");
/* 49 */     if (this.password.equals("DarKay")) {
/* 50 */       this.mc.displayGuiScreen(new Goto());
/* 51 */       if (this.password == null) {
/* 52 */         this.status = (EnumChatFormatting.DARK_RED + "Compte Oxygen non trouvee.");
/* 53 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 59 */     this.status = status;
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\session\AltLoginThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */