/*    */ package fr.oxygen.mods;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ 
/*    */ 
/*    */ public class Module
/*    */ {
/*  9 */   protected Minecraft mc = Minecraft.getMinecraft();
/* 10 */   protected FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
/*    */   private String name;
/*    */   private int key;
/*    */   private boolean toggled;
/*    */   private Category category;
/*    */   
/*    */   public Module(String nm, int k, Category c) {
/* 17 */     this.name = nm;
/* 18 */     this.key = k;
/* 19 */     this.category = c;
/* 20 */     this.toggled = false;
/*    */   }
/*    */   
/*    */   public void toggle()
/*    */   {
/* 25 */     this.toggled = (!this.toggled);
/* 26 */     if (this.toggled) {
/* 27 */       onEnable();
/*    */     } else
/* 29 */       onDisable(); }
/*    */   
/*    */   public void onEnable() {}
/*    */   
/*    */   public void onDisable() {}
/*    */   
/*    */   public void onUpdate() {}
/*    */   
/*    */   public void onRender() {}
/*    */   
/*    */   public void onRender3D(float partialTicks) {}
/* 40 */   public Minecraft getMc() { return this.mc; }
/*    */   
/*    */   public void setMc(Minecraft mc)
/*    */   {
/* 44 */     this.mc = mc;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 52 */     this.name = name;
/*    */   }
/*    */   
/*    */   public int getKey() {
/* 56 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(int key) {
/* 60 */     this.key = key;
/*    */   }
/*    */   
/*    */   public boolean isToggled() {
/* 64 */     return this.toggled;
/*    */   }
/*    */   
/*    */   public void setToggled(boolean toggled) {
/* 68 */     this.toggled = toggled;
/*    */   }
/*    */   
/*    */   public Category getCategory() {
/* 72 */     return this.category;
/*    */   }
/*    */   
/*    */   public boolean isCategory(Category cat) {
/* 76 */     return this.category == cat;
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\mods\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */