/*    */ package fr.oxygen.mods.render;
/*    */ 
/*    */ import fr.oxygen.mods.Category;
/*    */ import fr.oxygen.mods.Module;
/*    */ import fr.oxygen.utils.XrayBlock;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Xray
/*    */   extends Module
/*    */ {
/* 19 */   public ArrayList<XrayBlock> xrayBlocks = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean enable;
/*    */   
/*    */ 
/* 26 */   public static final boolean[] blocks = new boolean['x'];
/*    */   
/*    */   private float oldGamma;
/*    */   
/*    */   public Xray()
/*    */   {
/* 32 */     super("x-Ray", 45, Category.RENDU);
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\mods\render\Xray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */