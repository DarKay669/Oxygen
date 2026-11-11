/*    */ package fr.oxygen.gui.clickgui.lemon;
/*    */ 
/*    */ import fr.oxygen.mods.Module;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class Keybind extends Component
/*    */ {
/*    */   private boolean hovered;
/*    */   private boolean binding;
/*    */   private Button parent;
/*    */   private int offset;
/*    */   private int x;
/*    */   private int y;
/*    */   
/*    */   public Keybind(Button button, int offset)
/*    */   {
/* 20 */     this.parent = button;
/* 21 */     this.x = (button.parent.getX() + button.parent.getWidth());
/* 22 */     this.y = (button.parent.getY() + button.offset);
/* 23 */     this.offset = offset;
/*    */   }
/*    */   
/*    */   public void setOff(int newOff)
/*    */   {
/* 28 */     this.offset = newOff;
/*    */   }
/*    */   
/*    */   public void renderComponent()
/*    */   {
/* 33 */     Gui.drawRect(this.parent.parent.getX() + 2, this.parent.parent.getY() + this.offset, this.parent.parent.getX() + this.parent.parent.getWidth() * 1, this.parent.parent.getY() + this.offset + 12, this.hovered ? -14540254 : -15658735);
/* 34 */     Gui.drawRect(this.parent.parent.getX(), this.parent.parent.getY() + this.offset, this.parent.parent.getX() + 2, this.parent.parent.getY() + this.offset + 12, -15658735);
/* 35 */     GL11.glPushMatrix();
/* 36 */     GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 37 */     Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(" " + org.lwjgl.input.Keyboard.getKeyName(this.parent.mod.getKey()), (this.parent.parent.getX() + 7) * 2, (this.parent.parent.getY() + this.offset + 2) * 2 + 5, -1);
/* 38 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public void updateComponent(int mouseX, int mouseY)
/*    */   {
/* 43 */     this.hovered = isMouseOnButton(mouseX, mouseY);
/* 44 */     this.y = (this.parent.parent.getY() + this.offset);
/* 45 */     this.x = this.parent.parent.getX();
/*    */   }
/*    */   
/*    */   public void mouseClicked(int mouseX, int mouseY, int button)
/*    */   {
/* 50 */     if ((isMouseOnButton(mouseX, mouseY)) && (button == 0) && (this.parent.open)) {
/* 51 */       this.binding = (!this.binding);
/*    */     }
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int key)
/*    */   {
/* 57 */     if (this.binding) {
/* 58 */       this.parent.mod.setKey(key);
/* 59 */       this.binding = false;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isMouseOnButton(int x, int y) {
/* 64 */     if ((x > this.x) && (x < this.x + 88) && (y > this.y) && (y < this.y + 12)) {
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\gui\clickgui\lemon\Keybind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */