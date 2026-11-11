/*     */ package fr.oxygen.gui.clickgui.xtrmementbien.objects;
/*     */ 
/*     */ import fr.oxygen.gui.clickgui.xtrmementbien.ClickGUI;
/*     */ import fr.oxygen.mods.Module;
/*     */ import fr.oxygen.utils.ColorUtils;
/*     */ import fr.oxygen.utils.TimeHelper;
/*     */ import fr.oxygen.utils.Wrapper;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public class MButton
/*     */ {
/*     */   public Module m;
/*     */   public CPanel parent;
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int height;
/*     */   public int totalHeight;
/*     */   public int heightNow;
/*     */   public boolean extended;
/*     */   public boolean visible;
/*     */   public boolean binding;
/*     */   public boolean hasBeenBinded;
/*     */   private TimeHelper timer;
/*     */   
/*     */   public MButton(Module m, CPanel parent)
/*     */   {
/*  34 */     this.m = m;
/*  35 */     this.parent = parent;
/*     */     
/*  37 */     this.x = (parent.x + 1);
/*  38 */     this.y = (parent.y + parent.height + 1);
/*     */     
/*  40 */     this.width = (parent.width - 2);
/*  41 */     this.height = (parent.height - 2);
/*  42 */     this.heightNow = this.height;
/*     */     
/*  44 */     this.timer = new TimeHelper();
/*     */   }
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/*  49 */     this.visible = false;
/*     */     
/*  51 */     int aNumber = 0;
/*  52 */     this.totalHeight = (this.height + aNumber);
/*     */     
/*  54 */     this.x = (this.parent.x + 1);
/*     */     
/*  56 */     int place = this.parent.elements.indexOf(this);
/*  57 */     int heightBeforeThis = 0;
/*     */     
/*  59 */     for (MButton mb : this.parent.elements) {
/*  60 */       if (mb == this) {
/*     */         break;
/*     */       }
/*  63 */       heightBeforeThis += mb.heightNow;
/*     */     }
/*     */     
/*  66 */     this.y = (this.parent.y + this.parent.height + heightBeforeThis);
/*     */     
/*  68 */     if (this.parent.heightNow >= this.parent.height + (this.y - this.parent.y) - 3) {
/*  69 */       this.visible = true;
/*     */     }
/*     */     
/*  72 */     if (!this.visible) {
/*  73 */       return;
/*     */     }
/*  75 */     if ((this.timer.hasReached(5000L)) && (this.binding)) {
/*  76 */       this.binding = false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  81 */     boolean hovered = (isHovered(mouseX, mouseY)) && (!isHoveredUp(mouseX, mouseY));
/*     */     
/*  83 */     if (hovered) {
/*  84 */       Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*     */     }
/*  86 */     if (this.m.isToggled()) {
/*  87 */       Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*     */     }
/*  89 */     String text = this.m.getName();
/*     */     
/*     */ 
/*     */ 
/*  93 */     Wrapper.fr.drawStringWithShadow(this.hasBeenBinded ? "Binded to " + Keyboard.getKeyName(this.m.getKey()) : this.binding ? "Press a key..." : text, this.x + 3, this.y + 2, -1);
/*     */     
/*  95 */     if ((this.hasBeenBinded) && (this.timer.hasReached(3000L))) {
/*  96 */       this.hasBeenBinded = false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 102 */     if (this.extended) {
/* 103 */       if (this.heightNow < this.totalHeight)
/* 104 */         this.heightNow += 2;
/* 105 */       if (this.heightNow > this.totalHeight) {
/* 106 */         this.heightNow -= 2;
/*     */       }
/* 108 */     } else if (this.heightNow > this.height) {
/* 109 */       this.heightNow -= 2;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*     */   {
/* 118 */     if (!this.visible) {
/* 119 */       return;
/*     */     }
/* 121 */     if ((isHovered(mouseX, mouseY)) && (!isHoveredUp(mouseX, mouseY))) {
/* 122 */       if (mouseButton == 0) {
/* 123 */         this.m.toggle();
/*     */       }
/* 125 */       if (mouseButton == 1) {
/* 126 */         this.extended = (!this.extended);
/*     */       }
/* 128 */       if (mouseButton == 2) {
/* 129 */         if ((Keyboard.isKeyDown(54)) || (Keyboard.isKeyDown(42))) {
/* 130 */           this.hasBeenBinded = true;
/* 131 */           this.timer.reset();
/*     */           
/* 133 */           this.m.setKey(0);
/* 134 */           Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText(this.m.getName() + EnumChatFormatting.GRAY + " was unbinded"));
/*     */         } else {
/* 136 */           this.parent.parent.stopBind();
/* 137 */           this.binding = true;
/* 138 */           this.timer.reset();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseReleased() {}
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) {
/* 147 */     if (this.binding) {
/* 148 */       this.parent.parent.stopBind();
/* 149 */       if (keyCode != 1) {
/* 150 */         this.hasBeenBinded = true;
/* 151 */         this.timer.reset();
/*     */         
/* 153 */         this.m.setKey(keyCode);
/* 154 */         Wrapper.mc.thePlayer.addChatMessage(new ChatComponentText(this.m.getName() + EnumChatFormatting.GRAY + " was binded to " + EnumChatFormatting.BLUE + new StringBuilder().append(typedChar).append("").toString().toUpperCase()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isHovered(int mouseX, int mouseY) {
/* 160 */     return (mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y) && (mouseY <= this.y + this.height);
/*     */   }
/*     */   
/*     */   public boolean isHoveredUp(int mouseX, int mouseY) {
/* 164 */     return (mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y - this.height) && (mouseY <= this.y);
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\xtrmementbien\objects\MButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */