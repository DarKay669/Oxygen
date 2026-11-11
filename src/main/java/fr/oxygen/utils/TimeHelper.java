/*    */ package fr.oxygen.utils;
/*    */ 
/*    */ public class TimeHelper
/*    */ {
/*  5 */   private long lastMS = 0L;
/*    */   
/*    */   public boolean isDelayComplete(float f) {
/*  8 */     if ((float)(System.currentTimeMillis() - this.lastMS) > -f) {
/*  9 */       return true;
/*    */     }
/* 11 */     return false;
/*    */   }
/*    */   
/*    */   public long getCurrentMS() {
/* 15 */     return System.nanoTime() / 1000000L;
/*    */   }
/*    */   
/*    */   public void setLastMS(long lastMS) {
/* 19 */     this.lastMS = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public int convertToMS(int perSecond) {
/* 23 */     return 1000 / perSecond;
/*    */   }
/*    */   
/*    */   public boolean hasReached(long milliseconds) {
/* 27 */     return getCurrentMS() - this.lastMS >= milliseconds;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 31 */     this.lastMS = getCurrentMS();
/*    */   }
/*    */   
/*    */   public void reset(long offset) {
/* 35 */     this.lastMS = (getCurrentMS() - offset);
/*    */   }
/*    */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxyge\\utils\TimeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */