/*    */ package fr.oxygen.utils;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.lang3.Validate;
/*    */ 
/*    */ public class RL
/*    */ {
/*    */   private final String resourceDomain;
/*    */   private final String resourcePath;
/*    */   private static final String __OBFID = "CL_00001082";
/*    */   
/*    */   public RL(String p_i1292_1_, String p_i1292_2_)
/*    */   {
/* 14 */     Validate.notNull(p_i1292_2_);
/*    */     
/* 16 */     if ((p_i1292_1_ != null) && (p_i1292_1_.length() != 0))
/*    */     {
/* 18 */       this.resourceDomain = p_i1292_1_;
/*    */     }
/*    */     else
/*    */     {
/* 22 */       this.resourceDomain = "palamodaddons";
/*    */     }
/*    */     
/* 25 */     this.resourcePath = p_i1292_2_;
/*    */   }
/*    */   
/*    */   public RL(String p_i1293_1_)
/*    */   {
/* 30 */     String s1 = "palamodaddons";
/* 31 */     String s2 = p_i1293_1_;
/* 32 */     int i = p_i1293_1_.indexOf(':');
/*    */     
/* 34 */     if (i >= 0)
/*    */     {
/* 36 */       s2 = p_i1293_1_.substring(i + 1, p_i1293_1_.length());
/*    */       
/* 38 */       if (i > 1)
/*    */       {
/* 40 */         s1 = p_i1293_1_.substring(0, i);
/*    */       }
/*    */     }
/*    */     
/* 44 */     this.resourceDomain = s1.toLowerCase();
/* 45 */     this.resourcePath = s2;
/*    */   }
/*    */   
/*    */   public String getResourcePath()
/*    */   {
/* 50 */     return this.resourcePath;
/*    */   }
/*    */   
/*    */   public String getResourceDomain()
/*    */   {
/* 55 */     return this.resourceDomain;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 60 */     return this.resourceDomain + ":" + this.resourcePath;
/*    */   }
/*    */   
/*    */   public boolean equals(Object p_equals_1_)
/*    */   {
/* 65 */     if (this == p_equals_1_)
/*    */     {
/* 67 */       return true;
/*    */     }
/* 69 */     if (!(p_equals_1_ instanceof ResourceLocation))
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 75 */     RL resourcelocation = (RL)p_equals_1_;
/* 76 */     return (this.resourceDomain.equals(resourcelocation.resourceDomain)) && (this.resourcePath.equals(resourcelocation.resourcePath));
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 82 */     return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxyge\\utils\RL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */