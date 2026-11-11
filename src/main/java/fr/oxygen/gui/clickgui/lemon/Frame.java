/*     */ package fr.oxygen.gui.clickgui.lemon;
/*     */ 
/*     */ import fr.oxygen.main.palamodaddons;
/*     */ import fr.oxygen.mods.Category;
/*     */ import fr.oxygen.mods.Module;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Frame
/*     */ {
/*     */   public ArrayList<Component> components;
/*     */   public Category category;
/*     */   private boolean open;
/*     */   private int width;
/*     */   private int y;
/*     */   private int x;
/*     */   private int barHeight;
/*     */   private boolean isDragging;
/*     */   public int dragX;
/*     */   public int dragY;
/*     */   
/*     */   public Frame(Category cat)
/*     */   {
/*  29 */     this.components = new ArrayList();
/*  30 */     this.category = cat;
/*  31 */     this.width = 90;
/*  32 */     this.x = 8;
/*  33 */     this.y = 8;
/*  34 */     this.barHeight = 15;
/*  35 */     this.dragX = 0;
/*  36 */     this.open = false;
/*  37 */     this.isDragging = false;
/*  38 */     int tY = this.barHeight;
/*     */     
/*  40 */     for (Module mod : palamodaddons.getModulesInCategory(this.category)) {
/*  41 */       Button modButton = new Button(mod, this, tY);
/*  42 */       this.components.add(modButton);
/*  43 */       tY += 12;
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Component> getComponents() {
/*  48 */     return this.components;
/*     */   }
/*     */   
/*     */   public void setX(int newX) {
/*  52 */     this.x = newX;
/*     */   }
/*     */   
/*     */   public void setY(int newY) {
/*  56 */     this.y = newY;
/*     */   }
/*     */   
/*     */   public void setDrag(boolean drag) {
/*  60 */     this.isDragging = drag;
/*     */   }
/*     */   
/*     */   public boolean isOpen() {
/*  64 */     return this.open;
/*     */   }
/*     */   
/*     */   public void setOpen(boolean open) {
/*  68 */     this.open = open;
/*     */   }
/*     */   
/*     */   public void renderFrame(FontRenderer fontRenderer) {
/*  72 */     Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.barHeight, ClickGui.color);
/*  73 */     GL11.glPushMatrix();
/*  74 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/*  75 */     fontRenderer.drawStringWithShadow(this.category.name(), (this.x + 2) * 2 + 5, (int)(this.y + 2.8F) * 2 + 5, -1);
/*     */     
/*  77 */     if (!this.components.isEmpty()) {
/*  78 */       fontRenderer.drawStringWithShadow(this.open ? "-" : "+", (this.x + this.width - 15) * 2 + 5, (int)(this.y + 3.4F) * 2 + 5, -1);
/*     */     }
/*  80 */     GL11.glPopMatrix();
/*  81 */     if ((this.open) && 
/*  82 */       (!this.components.isEmpty())) {
/*  83 */       Gui.drawRect(this.x, this.y + this.barHeight, this.x + 1, this.y + this.barHeight + 12 * this.components.size(), new Color(196, 78, 78).getRGB());
/*  84 */       Gui.drawRect(this.x, this.y + this.barHeight + 12 * this.components.size(), this.x + this.width, this.y + this.barHeight + 12 * this.components.size() + 1, new Color(196, 78, 78).getRGB());
/*  85 */       Gui.drawRect(this.x + this.width, this.y + this.barHeight, this.x + this.width - 1, this.y + this.barHeight + 12 * this.components.size(), new Color(196, 78, 78).getRGB());
/*  86 */       for (Component component : this.components) {
/*  87 */         component.renderComponent();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void refresh()
/*     */   {
/*  94 */     int off = this.barHeight;
/*  95 */     for (Component comp : this.components) {
/*  96 */       comp.setOff(off);
/*  97 */       off += comp.getHeight();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getX() {
/* 102 */     return this.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 106 */     return this.y;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 110 */     return this.width;
/*     */   }
/*     */   
/*     */   public void updatePosition(int mouseX, int mouseY) {
/* 114 */     if (this.isDragging) {
/* 115 */       setX(mouseX - this.dragX);
/* 116 */       setY(mouseY - this.dragY);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isWithinHeader(int x, int y) {
/* 121 */     if ((x >= this.x) && (x <= this.x + this.width) && (y >= this.y) && (y <= this.y + this.barHeight)) {
/* 122 */       return true;
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\lemon\Frame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */