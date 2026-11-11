/*    */ package fr.oxygen.proxy;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.eventhandler.EventBus;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import fr.oxygen.gui.F3;
/*    */ import fr.oxygen.main.EventReceiver;
/*    */ import fr.oxygen.session.GuiAltLogin;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
/*    */ import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent.Post;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ 
/*    */ public class ClientProxy
/*    */   extends CommonProxy
/*    */ {
/*    */   public void registerRenders()
/*    */   {
/* 21 */     EventReceiver eventReceiver = new EventReceiver();
/* 22 */     MinecraftForge.EVENT_BUS.register(eventReceiver);
/* 23 */     MinecraftForge.EVENT_BUS.register(this);
/* 24 */     MinecraftForge.EVENT_BUS.register(new F3());
/*    */     
/* 26 */     FMLCommonHandler.instance().bus().register(eventReceiver);
/* 27 */     super.registerRenders();
/*    */   }
/*    */   
/*    */ 
/*    */   @SubscribeEvent
/*    */   public void onOpenGui(GuiOpenEvent event)
/*    */   {
/* 34 */     if ((event.gui != null) && ((event.gui.getClass() == GuiMainMenu.class) || (event.gui.getClass().getName().equalsIgnoreCase("fr.paladium.palamod.client.gui.custom.GuiMainMenu"))))
/*    */     {
/* 36 */       event.gui = new GuiAltLogin();
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onInitGuiEvent(GuiScreenEvent.InitGuiEvent.Post event)
/*    */   {
/* 43 */     if ((event.gui instanceof GuiMainMenu)) {
/* 44 */       for (Object b : event.buttonList) {
/* 45 */         if (((GuiButton)b).id == 14) {
/* 46 */           ((GuiButton)b).visible = false;
/*    */         }
/* 48 */         if (((GuiButton)b).id == 6) {
/* 49 */           ((GuiButton)b).visible = false;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 54 */     if ((event.gui instanceof GuiMainMenu)) {
/* 55 */       for (Object b : event.buttonList) {
/* 56 */         if (((GuiButton)b).id == 6) {
/* 57 */           ((GuiButton)b).visible = false;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 62 */     if ((event.gui instanceof GuiMainMenu)) {
/* 63 */       for (Object b : event.buttonList) {
/* 64 */         if (((GuiButton)b).id == 5) {
/* 65 */           ((GuiButton)b).visible = false;
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */