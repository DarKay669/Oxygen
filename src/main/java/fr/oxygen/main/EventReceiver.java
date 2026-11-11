/*    */ package fr.oxygen.main;
/*    */ import org.lwjgl.input.Keyboard;

/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ 
/*    */ public class EventReceiver
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onRender2D(RenderGameOverlayEvent event)
/*    */   {
/* 16 */     if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
/*    */       try {
/* 18 */         palamodaddons.onRender();
/*    */       } catch (Exception localException) {}
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onUpdate(LivingEvent.LivingUpdateEvent event) {
/* 25 */     if (event.entityLiving == null) {
/* 26 */       return;
/*    */     }
/* 28 */     if ((event.entityLiving instanceof net.minecraft.client.entity.EntityPlayerSP)) {
/*    */       try {
/* 30 */         palamodaddons.onUpdate();
/*    */       } catch (Exception localException) {}
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onKeyInput(InputEvent.KeyInputEvent event) {
/* 37 */     if (!Keyboard.getEventKeyState()) {
/* 38 */       return;
/*    */     }
/*    */     try {
/* 41 */       palamodaddons.onKeyPressed(Keyboard.getEventKey());
/*    */     } catch (Exception localException) {}
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onRender3D(RenderWorldLastEvent event) {
/* 47 */     palamodaddons.onRender3D(event.partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\main\EventReceiver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */