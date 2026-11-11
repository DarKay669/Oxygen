/*     */ package fr.oxygen.gui.clickgui.xtrmementbien.objects;
/*     */ 
/*     */ import fr.oxygen.gui.clickgui.xtrmementbien.ClickGUI;
/*     */ import fr.oxygen.main.palamodaddons;
/*     */ import fr.oxygen.mods.Category;
/*     */ import fr.oxygen.mods.Module;
/*     */ import fr.oxygen.utils.ColorUtils;
/*     */ import fr.oxygen.utils.Wrapper;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ 
/*     */ public class CPanel
/*     */ {
/*  16 */   public ArrayList<MButton> elements = new ArrayList();
/*     */   
/*     */ 
/*     */   public Category c;
/*     */   
/*     */ 
/*     */   public ClickGUI parent;
/*     */   
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int x2;
/*     */   public int y2;
/*     */   
/*  30 */   public CPanel(Category c, int x, int y, ClickGUI parent) { this(c, x, y, 85, 14, parent); }
/*     */   
/*     */   public CPanel(Category c, int x, int y, int width, int height, ClickGUI parent) {
/*  33 */     this.c = c;
/*  34 */     this.x = x;
/*  35 */     this.y = y;
/*  36 */     this.width = width;
/*  37 */     this.parent = parent;
/*     */     
/*  39 */     this.height = height;this.heightNow = height;
/*     */     
/*  41 */     this.dragging = false;
/*  42 */     this.oppened = true;
/*  43 */     this.extended = false;
/*     */     
/*  45 */     for (Module m : palamodaddons.getModulesInCategory(c))
/*  46 */       this.elements.add(new MButton(m, this)); }
/*     */   
/*     */   public int height;
/*     */   public int totalHeight;
/*     */   
/*  51 */   public void drawScreen(int mouseX, int mouseY, float partialTicks) { int aNumber = 0;
/*  52 */     for (MButton mb : this.elements) {
/*  53 */       aNumber += mb.heightNow;
/*     */     }
/*     */     
/*  56 */     this.totalHeight = (this.height + aNumber);
/*  57 */     this.totalHeightWithoutPanel = (this.totalHeight - this.height);
/*     */     
/*  59 */     if (this.dragging) {
/*  60 */       this.x = (this.x2 + mouseX);
/*  61 */       this.y = (this.y2 + mouseY);
/*     */     }
/*     */     
/*  64 */     for (int i = 0; i < 2; i++) {
/*  65 */       if (this.oppened) {
/*  66 */         if (this.heightNow < this.totalHeight)
/*  67 */           this.heightNow += 2;
/*  68 */         if (this.heightNow > this.totalHeight) {
/*  69 */           this.heightNow -= 2;
/*     */         }
/*  71 */       } else if (this.heightNow > this.height) {
/*  72 */         this.heightNow -= 2;
/*     */       }
/*     */     }
/*     */     
/*  76 */     Gui.drawRect(this.x + 1, this.y, this.x + this.width - 1, this.y + this.heightNow, -1157627904);
/*  77 */     Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*  78 */     Gui.drawRect(this.x, this.y + this.heightNow, this.x + this.width, this.y + this.heightNow + 2, ColorUtils.effect(0L, 0.7F, 1).getRGB());
/*     */     
/*  80 */     Wrapper.fr.drawStringWithShadow(this.c.name(), this.x + this.width / 2 - Wrapper.fr.getStringWidth(this.c.name()) / 2, this.y + 3, -1); }
/*     */   
/*     */   public int totalHeightWithoutPanel;
/*     */   
/*  84 */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) { if (isHovered(mouseX, mouseY)) {
/*  85 */       if (mouseButton == 0) {
/*  86 */         this.x2 = (this.x - mouseX);
/*  87 */         this.y2 = (this.y - mouseY);
/*  88 */         this.dragging = true;
/*     */       }
/*  90 */       if (mouseButton == 1)
/*  91 */         this.oppened = (!this.oppened); } }
/*     */   
/*     */   public int heightNow;
/*     */   public boolean dragging;
/*     */   public boolean oppened;
/*     */   public boolean extended;
/*  97 */   public void mouseReleased() { this.dragging = false; }
/*     */   
/*     */ 
/*     */   public void keyTyped(char typedChar, int keyCode) {}
/*     */   
/*     */   public boolean isHovered(int mouseX, int mouseY) {
/* 103 */     return (mouseX >= this.x) && (mouseX <= this.x + this.width) && (mouseY >= this.y) && (mouseY <= this.y + this.height);
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\xtrmementbien\objects\CPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */