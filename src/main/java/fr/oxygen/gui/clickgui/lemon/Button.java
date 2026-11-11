/*     */ package fr.oxygen.gui.clickgui.lemon;
/*     */ 
/*     */ import fr.oxygen.mods.Module;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class Button
/*     */   extends Component
/*     */ {
/*     */   public Module mod;
/*     */   public Frame parent;
/*     */   public int offset;
/*     */   private boolean isHovered;
/*     */   private ArrayList<Component> subcomponents;
/*     */   public boolean open;
/*     */   private int height;
/*     */   
/*     */   public Button(Module mod, Frame parent, int offset)
/*     */   {
/*  24 */     this.mod = mod;
/*  25 */     this.parent = parent;
/*  26 */     this.offset = offset;
/*  27 */     this.subcomponents = new ArrayList();
/*  28 */     this.open = false;
/*  29 */     this.height = 12;
/*  30 */     int opY = offset + 12;
/*     */     
/*  32 */     this.subcomponents.add(new Keybind(this, opY));
/*     */   }
/*     */   
/*     */   public void setOff(int newOff)
/*     */   {
/*  37 */     this.offset = newOff;
/*  38 */     int opY = this.offset + 12;
/*  39 */     for (Component comp : this.subcomponents) {
/*  40 */       comp.setOff(opY);
/*  41 */       opY += 12;
/*     */     }
/*     */   }
/*     */   
/*     */   public void renderComponent()
/*     */   {
/*  47 */     Gui.drawRect(this.parent.getX(), this.parent.getY() + this.offset, this.parent.getX() + this.parent.getWidth(), this.parent.getY() + 12 + this.offset, this.mod.isToggled() ? new Color(80, 170, 155).getRGB() : this.isHovered ? -13619923 : this.mod.isToggled() ? new Color(-13619923).darker().getRGB() : -13619923);
/*  48 */     GL11.glPushMatrix();
/*  49 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*  50 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.mod.getName(), (this.parent.getX() + 2) * 2, (this.parent.getY() + this.offset + 2) * 2 + 4, this.mod.isToggled() ? 10066329 : -1);
/*  51 */     if (this.subcomponents.size() > 1)
/*  52 */       Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.parent.getX() + this.parent.getWidth() - 10) * 2, (this.parent.getY() + this.offset + 2) * 2 + 4, -1);
/*  53 */     GL11.glPopMatrix();
/*  54 */     if ((this.open) && 
/*  55 */       (!this.subcomponents.isEmpty())) {
/*  56 */       for (Component comp : this.subcomponents) {
/*  57 */         comp.renderComponent();
/*     */       }
/*  59 */       Gui.drawRect(this.parent.getX() + 2, this.parent.getY() + this.offset + 12, this.parent.getX() + 3, this.parent.getY() + this.offset + (this.subcomponents.size() + 1) * 12, ClickGui.color);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getHeight()
/*     */   {
/*  66 */     if (this.open) {
/*  67 */       return 12 * (this.subcomponents.size() + 1);
/*     */     }
/*  69 */     return 12;
/*     */   }
/*     */   
/*     */   public void updateComponent(int mouseX, int mouseY)
/*     */   {
/*  74 */     this.isHovered = isMouseOnButton(mouseX, mouseY);
/*  75 */     if (!this.subcomponents.isEmpty()) {
/*  76 */       for (Component comp : this.subcomponents) {
/*  77 */         comp.updateComponent(mouseX, mouseY);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int button)
/*     */   {
/*  84 */     if ((isMouseOnButton(mouseX, mouseY)) && (button == 0)) {
/*  85 */       this.mod.toggle();
/*     */     }
/*  87 */     if ((isMouseOnButton(mouseX, mouseY)) && (button == 1)) {
/*  88 */       this.open = (!this.open);
/*  89 */       this.parent.refresh();
/*     */     }
/*  91 */     for (Component comp : this.subcomponents) {
/*  92 */       comp.mouseClicked(mouseX, mouseY, button);
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseReleased()
/*     */   {
/*  98 */     for (Component comp : this.subcomponents) {
/*  99 */       comp.mouseReleased();
/*     */     }
/*     */   }
/*     */   
/*     */   public void keyTyped(char typedChar, int key)
/*     */   {
/* 105 */     for (Component comp : this.subcomponents) {
/* 106 */       comp.keyTyped(typedChar, key);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isMouseOnButton(int x, int y) {
/* 111 */     if ((x > this.parent.getX()) && (x < this.parent.getX() + this.parent.getWidth()) && (y > this.parent.getY() + this.offset) && (y < this.parent.getY() + 12 + this.offset)) {
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\lemon\Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */