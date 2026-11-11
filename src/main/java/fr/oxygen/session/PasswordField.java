/*     */ package fr.oxygen.session;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class PasswordField extends net.minecraft.client.gui.Gui
/*     */ {
/*     */   private final FontRenderer fontRenderer;
/*     */   private final int xPos;
/*     */   private final int yPos;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private String text;
/*     */   private int maxStringLength;
/*     */   private int cursorCounter;
/*     */   private boolean enableBackgroundDrawing;
/*     */   private boolean canLoseFocus;
/*     */   public boolean isFocused;
/*     */   private boolean isEnabled;
/*     */   private int i;
/*     */   private int cursorPosition;
/*     */   private int selectionEnd;
/*     */   private int enabledColor;
/*     */   private int disabledColor;
/*     */   private boolean b;
/*     */   
/*     */   public PasswordField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5)
/*     */   {
/*  31 */     this.text = "";
/*  32 */     this.maxStringLength = 50;
/*  33 */     this.enableBackgroundDrawing = true;
/*  34 */     this.canLoseFocus = true;
/*  35 */     this.isFocused = false;
/*  36 */     this.isEnabled = true;
/*  37 */     this.i = 0;
/*  38 */     this.cursorPosition = 0;
/*  39 */     this.selectionEnd = 0;
/*  40 */     this.enabledColor = 14737632;
/*  41 */     this.disabledColor = 7368816;
/*  42 */     this.b = true;
/*  43 */     this.fontRenderer = par1FontRenderer;
/*  44 */     this.xPos = par2;
/*  45 */     this.yPos = par3;
/*  46 */     this.width = par4;
/*  47 */     this.height = par5;
/*     */   }
/*     */   
/*     */   public void updateCursorCounter() {
/*  51 */     this.cursorCounter += 1;
/*     */   }
/*     */   
/*     */   public void setText(String par1Str) {
/*  55 */     if (par1Str.length() > this.maxStringLength) {
/*  56 */       this.text = par1Str.substring(0, this.maxStringLength);
/*     */     }
/*     */     else {
/*  59 */       this.text = par1Str;
/*     */     }
/*  61 */     setCursorPositionEnd();
/*     */   }
/*     */   
/*     */   public String getText() {
/*  65 */     String newtext = this.text.replaceAll(" ", "");
/*  66 */     return newtext;
/*     */   }
/*     */   
/*     */   public String getSelectedtext() {
/*  70 */     int var1 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
/*  71 */     int var2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
/*  72 */     return this.text.substring(var1, var2);
/*     */   }
/*     */   
/*     */   public void writeText(String par1Str) {
/*  76 */     String var2 = "";
/*  77 */     String var3 = net.minecraft.util.ChatAllowedCharacters.filerAllowedCharacters(par1Str);
/*  78 */     int var4 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
/*  79 */     int var5 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
/*  80 */     int var6 = this.maxStringLength - this.text.length() - (var4 - this.selectionEnd);
/*  81 */     boolean var7 = false;
/*  82 */     if (this.text.length() > 0)
/*  83 */       var2 = String.valueOf(String.valueOf(var2)) + this.text.substring(0, var4);
/*     */     int var8;
/*  86 */     if (var6 < var3.length()) {
/*  87 */       var2 = String.valueOf(String.valueOf(var2)) + var3.substring(0, var6);
/*  88 */       var8 = var6;
/*     */     }
/*     */     else {
/*  91 */       var2 = String.valueOf(String.valueOf(var2)) + var3;
/*  92 */       var8 = var3.length();
/*     */     }
/*  94 */     if ((this.text.length() > 0) && (var5 < this.text.length())) {
/*  95 */       var2 = String.valueOf(String.valueOf(var2)) + this.text.substring(var5);
/*     */     }
/*  97 */     this.text = var2.replaceAll(" ", "");
/*  98 */     cursorPos(var4 - this.selectionEnd + var8);
/*     */   }
/*     */   
/*     */   public void func_73779_a(int par1) {
/* 102 */     if (this.text.length() != 0) {
/* 103 */       if (this.selectionEnd != this.cursorPosition) {
/* 104 */         writeText("");
/*     */       }
/*     */       else {
/* 107 */         deleteFromCursor(getNthWordFromCursor(par1) - this.cursorPosition);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteFromCursor(int par1) {
/* 113 */     if (this.text.length() != 0) {
/* 114 */       if (this.selectionEnd != this.cursorPosition) {
/* 115 */         writeText("");
/*     */       }
/*     */       else {
/* 118 */         boolean var2 = par1 < 0;
/* 119 */         int var3 = var2 ? this.cursorPosition + par1 : this.cursorPosition;
/* 120 */         int var4 = var2 ? this.cursorPosition : this.cursorPosition + par1;
/* 121 */         String var5 = "";
/* 122 */         if (var3 >= 0) {
/* 123 */           var5 = this.text.substring(0, var3);
/*     */         }
/* 125 */         if (var4 < this.text.length()) {
/* 126 */           var5 = String.valueOf(String.valueOf(var5)) + this.text.substring(var4);
/*     */         }
/* 128 */         this.text = var5;
/* 129 */         if (var2) {
/* 130 */           cursorPos(par1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getNthWordFromCursor(int par1) {
/* 137 */     return getNthWordFromPos(par1, getCursorPosition());
/*     */   }
/*     */   
/*     */   public int getNthWordFromPos(int par1, int par2) {
/* 141 */     return type(par1, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public int type(int par1, int par2, boolean par3) {
/* 145 */     int var4 = par2;
/* 146 */     boolean var5 = par1 < 0;
/* 147 */     int var6 = Math.abs(par1); for (int var7 = 0; var7 < var6; var7++) {
/* 148 */       if (!var5) {
/* 149 */         int var8 = this.text.length();
/* 150 */         var4 = this.text.indexOf(' ', var4);
/* 151 */         if (var4 == -1) {
/* 152 */           var4 = var8;
/*     */         }
/*     */         else {
/* 155 */           while ((par3) && 
/* 156 */             (var4 < var8))
/*     */           {
/*     */ 
/* 159 */             if (this.text.charAt(var4) != ' ') {
/*     */               break;
/*     */             }
/* 162 */             var4++;
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         while ((par3) && 
/* 168 */           (var4 > 0))
/*     */         {
/*     */ 
/* 171 */           if (this.text.charAt(var4 - 1) != ' ') {
/*     */             break;
/*     */           }
/* 174 */           var4--;
/*     */         }
/* 176 */         while ((var4 > 0) && (this.text.charAt(var4 - 1) != ' ')) {
/* 177 */           var4--;
/*     */         }
/*     */       }
/*     */     }
/* 181 */     return var4;
/*     */   }
/*     */   
/*     */   public void cursorPos(int par1) {
/* 185 */     setCursorPosition(this.selectionEnd + par1);
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int par1) {
/* 189 */     this.cursorPosition = par1;
/* 190 */     int var2 = this.text.length();
/* 191 */     if (this.cursorPosition < 0) {
/* 192 */       this.cursorPosition = 0;
/*     */     }
/* 194 */     if (this.cursorPosition > var2) {
/* 195 */       this.cursorPosition = var2;
/*     */     }
/* 197 */     func_73800_i(this.cursorPosition);
/*     */   }
/*     */   
/*     */   public void setCursorPositionZero() {
/* 201 */     setCursorPosition(0);
/*     */   }
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 205 */     setCursorPosition(this.text.length());
/*     */   }
/*     */   
/*     */   public boolean textboxKeyTyped(char par1, int par2) {
/* 209 */     if ((!this.isEnabled) || (!this.isFocused)) {
/* 210 */       return false;
/*     */     }
/* 212 */     switch (par1) {
/*     */     case '\001': 
/* 214 */       setCursorPositionEnd();
/* 215 */       func_73800_i(0);
/* 216 */       return true;
/*     */     
/*     */     case '\003': 
/* 219 */       GuiScreen.setClipboardString(getSelectedtext());
/* 220 */       return true;
/*     */     
/*     */     case '\026': 
/* 223 */       writeText(GuiScreen.getClipboardString());
/* 224 */       return true;
/*     */     
/*     */     case '\030': 
/* 227 */       GuiScreen.setClipboardString(getSelectedtext());
/* 228 */       writeText("");
/* 229 */       return true;
/*     */     }
/*     */     
/* 232 */     switch (par2) {
/*     */     case 14: 
/* 234 */       if (GuiScreen.isCtrlKeyDown()) {
/* 235 */         func_73779_a(-1);
/*     */       }
/*     */       else {
/* 238 */         deleteFromCursor(-1);
/*     */       }
/* 240 */       return true;
/*     */     
/*     */     case 199: 
/* 243 */       if (GuiScreen.isShiftKeyDown()) {
/* 244 */         func_73800_i(0);
/*     */       }
/*     */       else {
/* 247 */         setCursorPositionZero();
/*     */       }
/* 249 */       return true;
/*     */     
/*     */     case 203: 
/* 252 */       if (GuiScreen.isShiftKeyDown()) {
/* 253 */         if (GuiScreen.isCtrlKeyDown()) {
/* 254 */           func_73800_i(getNthWordFromPos(-1, getSelectionEnd()));
/*     */         }
/*     */         else {
/* 257 */           func_73800_i(getSelectionEnd() - 1);
/*     */         }
/*     */       }
/* 260 */       else if (GuiScreen.isCtrlKeyDown()) {
/* 261 */         setCursorPosition(getNthWordFromCursor(-1));
/*     */       }
/*     */       else {
/* 264 */         cursorPos(-1);
/*     */       }
/* 266 */       return true;
/*     */     
/*     */     case 205: 
/* 269 */       if (GuiScreen.isShiftKeyDown()) {
/* 270 */         if (GuiScreen.isCtrlKeyDown()) {
/* 271 */           func_73800_i(getNthWordFromPos(1, getSelectionEnd()));
/*     */         }
/*     */         else {
/* 274 */           func_73800_i(getSelectionEnd() + 1);
/*     */         }
/*     */       }
/* 277 */       else if (GuiScreen.isCtrlKeyDown()) {
/* 278 */         setCursorPosition(getNthWordFromCursor(1));
/*     */       }
/*     */       else {
/* 281 */         cursorPos(1);
/*     */       }
/* 283 */       return true;
/*     */     
/*     */     case 207: 
/* 286 */       if (GuiScreen.isShiftKeyDown()) {
/* 287 */         func_73800_i(this.text.length());
/*     */       }
/*     */       else {
/* 290 */         setCursorPositionEnd();
/*     */       }
/* 292 */       return true;
/*     */     
/*     */     case 211: 
/* 295 */       if (GuiScreen.isCtrlKeyDown()) {
/* 296 */         func_73779_a(1);
/*     */       }
/*     */       else {
/* 299 */         deleteFromCursor(1);
/*     */       }
/* 301 */       return true;
/*     */     }
/*     */     
/* 304 */     if (net.minecraft.util.ChatAllowedCharacters.isAllowedCharacter(par1)) {
/* 305 */       writeText(Character.toString(par1));
/* 306 */       return true;
/*     */     }
/* 308 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void mouseClicked(int par1, int par2, int par3)
/*     */   {
/* 316 */     boolean var4 = (par1 >= this.xPos) && (par1 < this.xPos + this.width) && (par2 >= this.yPos) && (par2 < this.yPos + this.height);
/* 317 */     if (this.canLoseFocus) {
/* 318 */       setFocused((this.isEnabled) && (var4));
/*     */     }
/* 320 */     if ((this.isFocused) && (par3 == 0)) {
/* 321 */       int var5 = par1 - this.xPos;
/* 322 */       if (this.enableBackgroundDrawing) {
/* 323 */         var5 -= 4;
/*     */       }
/* 325 */       String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 326 */       setCursorPosition(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/* 331 */     if (func_73778_q()) {
/* 332 */       if (getEnableBackgroundDrawing()) {
/* 333 */         net.minecraft.client.gui.Gui.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
/* 334 */         net.minecraft.client.gui.Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
/*     */       }
/* 336 */       int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 337 */       int var2 = this.cursorPosition - this.i;
/* 338 */       int var3 = this.selectionEnd - this.i;
/* 339 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 340 */       boolean var5 = (var2 >= 0) && (var2 <= var4.length());
/* 341 */       boolean var6 = (this.isFocused) && (this.cursorCounter / 6 % 2 == 0) && (var5);
/* 342 */       int var7 = this.enableBackgroundDrawing ? this.xPos + 4 : this.xPos;
/* 343 */       int var8 = this.enableBackgroundDrawing ? this.yPos + (this.height - 8) / 2 : this.yPos;
/* 344 */       int var9 = var7;
/* 345 */       if (var3 > var4.length()) {
/* 346 */         var3 = var4.length();
/*     */       }
/* 348 */       if (var4.length() > 0) {
/* 349 */         if (var5) {
/* 350 */           var4.substring(0, var2);
/*     */         }
/* 352 */         var9 = Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), var7, var8, var1);
/*     */       }
/* 354 */       boolean var10 = (this.cursorPosition < this.text.length()) || (this.text.length() >= getMaxStringLength());
/* 355 */       int var11 = var9;
/* 356 */       if (!var5) {
/* 357 */         var11 = var2 > 0 ? var7 + this.width : var7;
/*     */       }
/* 359 */       else if (var10) {
/* 360 */         var11 = var9 - 1;
/* 361 */         var9--;
/*     */       }
/* 363 */       if ((var4.length() > 0) && (var5) && (var2 < var4.length())) {
/* 364 */         Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*     */       }
/* 366 */       if (var6) {
/* 367 */         if (var10) {
/* 368 */           net.minecraft.client.gui.Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
/*     */         }
/*     */         else {
/* 371 */           Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("_", var11, var8, var1);
/*     */         }
/*     */       }
/* 374 */       if (var3 != var2) {
/* 375 */         int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
/* 376 */         drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawCursorVertical(int par1, int par2, int par3, int par4) {
/* 382 */     if (par1 < par3) {
/* 383 */       int var5 = par1;
/* 384 */       par1 = par3;
/* 385 */       par3 = var5;
/*     */     }
/* 387 */     if (par2 < par4) {
/* 388 */       int var5 = par2;
/* 389 */       par2 = par4;
/* 390 */       par4 = var5;
/*     */     }
/* 392 */     net.minecraft.client.renderer.Tessellator var6 = net.minecraft.client.renderer.Tessellator.instance;
/* 393 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 394 */     GL11.glDisable(3553);
/* 395 */     GL11.glEnable(3058);
/* 396 */     GL11.glLogicOp(5387);
/* 397 */     GL11.glDisable(3058);
/* 398 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int par1) {
/* 402 */     this.maxStringLength = par1;
/* 403 */     if (this.text.length() > par1) {
/* 404 */       this.text = this.text.substring(0, par1);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMaxStringLength() {
/* 409 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 413 */     return this.cursorPosition;
/*     */   }
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 417 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean par1) {
/* 421 */     this.enableBackgroundDrawing = par1;
/*     */   }
/*     */   
/*     */   public void func_73794_g(int par1) {
/* 425 */     this.enabledColor = par1;
/*     */   }
/*     */   
/*     */   public void setFocused(boolean par1) {
/* 429 */     if ((par1) && (!this.isFocused)) {
/* 430 */       this.cursorCounter = 0;
/*     */     }
/* 432 */     this.isFocused = par1;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 436 */     return this.isFocused;
/*     */   }
/*     */   
/*     */   public int getSelectionEnd() {
/* 440 */     return this.selectionEnd;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 444 */     return getEnableBackgroundDrawing() ? this.width - 8 : this.width;
/*     */   }
/*     */   
/*     */   public void func_73800_i(int par1) {
/* 448 */     int var2 = this.text.length();
/* 449 */     if (par1 > var2) {
/* 450 */       par1 = var2;
/*     */     }
/* 452 */     if (par1 < 0) {
/* 453 */       par1 = 0;
/*     */     }
/* 455 */     this.selectionEnd = par1;
/* 456 */     if (this.fontRenderer != null) {
/* 457 */       if (this.i > var2) {
/* 458 */         this.i = var2;
/*     */       }
/* 460 */       int var3 = getWidth();
/* 461 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), var3);
/* 462 */       int var5 = var4.length() + this.i;
/* 463 */       if (par1 == this.i) {
/* 464 */         this.i -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
/*     */       }
/* 466 */       if (par1 > var5) {
/* 467 */         this.i += par1 - var5;
/*     */       }
/* 469 */       else if (par1 <= this.i) {
/* 470 */         this.i -= this.i - par1;
/*     */       }
/* 472 */       if (this.i < 0) {
/* 473 */         this.i = 0;
/*     */       }
/* 475 */       if (this.i > var2) {
/* 476 */         this.i = var2;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean par1) {
/* 482 */     this.canLoseFocus = par1;
/*     */   }
/*     */   
/*     */   public boolean func_73778_q() {
/* 486 */     return this.b;
/*     */   }
/*     */   
/*     */   public void func_73790_e(boolean par1) {
/* 490 */     this.b = par1;
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\session\PasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */