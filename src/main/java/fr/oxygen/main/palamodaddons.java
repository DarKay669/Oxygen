/*     */ package fr.oxygen.main;
/*     */ 
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import fr.oxygen.mods.Category;
/*     */ import fr.oxygen.mods.Module;
/*     */ import fr.oxygen.mods.combat.AntiKB;
/*     */ import fr.oxygen.mods.combat.Criticals;
/*     */ import fr.oxygen.mods.combat.HitAim;
/*     */ import fr.oxygen.mods.combat.KillAura;
/*     */ import fr.oxygen.mods.combat.TriggerBot;
/*     */ import fr.oxygen.mods.movement.Airjump;
/*     */ import fr.oxygen.mods.movement.AutoWalk;
/*     */ import fr.oxygen.mods.movement.FastLadder;
/*     */ import fr.oxygen.mods.movement.Fly;
/*     */ import fr.oxygen.mods.movement.FreeCam;
/*     */ import fr.oxygen.mods.movement.Glide;
/*     */ import fr.oxygen.mods.movement.HighJump;
/*     */ import fr.oxygen.mods.movement.Speed;
/*     */ import fr.oxygen.mods.movement.SpiderMan;
/*     */ import fr.oxygen.mods.movement.Sprint;
/*     */ import fr.oxygen.mods.player.AntiPotion;
/*     */ import fr.oxygen.mods.player.AutoDeco;
/*     */ import fr.oxygen.mods.player.DeathCordo;
/*     */ import fr.oxygen.mods.player.FastPlace;
/*     */ import fr.oxygen.mods.player.NoClip;
/*     */ import fr.oxygen.mods.player.NoHunger;
/*     */ import fr.oxygen.mods.player.Nofall;
/*     */ import fr.oxygen.mods.player.Spammer;
/*     */ import fr.oxygen.mods.render.ChestESP;
/*     */ import fr.oxygen.mods.render.ClickGui;
/*     */ import fr.oxygen.mods.render.FakeXP;
/*     */ import fr.oxygen.mods.render.Fullbright;
/*     */ import fr.oxygen.mods.render.HUD;
/*     */ import fr.oxygen.mods.render.PlayerESP;
/*     */ import fr.oxygen.mods.render.Xray;
/*     */ import fr.oxygen.mods.render.Zoom;
/*     */ import fr.oxygen.proxy.CommonProxy;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.Session;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid="ArmorStatusHUD", name="ArmorStatusHUD", version="1.28", canBeDeactivated=false)
/*     */ public class palamodaddons
/*     */ {
/*     */   @SidedProxy(clientSide="fr.oxygen.proxy.ClientProxy", serverSide="fr.oxygen.proxy.CommonProxy")
/*     */   public static CommonProxy proxy;
/*     */   private static ArrayList<Module> mods;
/*     */   
/*     */   @Mod.EventHandler
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/*  75 */     proxy.registerRenders();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Mod.EventHandler
/*     */   public void postInit(FMLPostInitializationEvent event) {}
/*     */   
/*     */ 
/*     */   @Mod.EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  87 */     Display.setTitle("Oxygen V0.8 BETA | " + Minecraft.getMinecraft().getSession().getUsername());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public palamodaddons()
/*     */   {
/*  95 */     mods = new ArrayList();
/*     */     
/*  97 */     addMod(new Fullbright());
/*  98 */     addMod(new Fly());
/*  99 */     addMod(new Glide());
/* 100 */     addMod(new Airjump());
/* 101 */     addMod(new Nofall());
/* 102 */     addMod(new Zoom());
/* 103 */     addMod(new KillAura());
/* 104 */     addMod(new Speed());
/* 105 */     addMod(new ClickGui());
/* 106 */     addMod(new HUD());
/* 107 */     addMod(new AntiPotion());
/* 108 */     addMod(new Sprint());
/* 109 */     addMod(new AntiKB());
/* 110 */     addMod(new HighJump());
/* 111 */     addMod(new AutoWalk());
/* 112 */     addMod(new FreeCam());
/* 113 */     addMod(new FakeXP());
/* 114 */     addMod(new AutoDeco());
/* 115 */     addMod(new HitAim());
/* 116 */     addMod(new Spammer());
/* 117 */     addMod(new NoHunger());
/* 118 */     addMod(new SpiderMan());
/* 119 */     addMod(new Xray());
/* 120 */     addMod(new FastPlace());
/* 121 */     addMod(new TriggerBot());
/* 122 */     addMod(new Criticals());
/* 123 */     addMod(new DeathCordo());
/* 124 */     addMod(new ChestESP());
/* 125 */     addMod(new PlayerESP());
/* 126 */     addMod(new FastLadder());
/* 127 */     addMod(new NoClip());
/*     */   }
/*     */   
/*     */   private void addMod(Module m) {
/* 131 */     mods.add(m);
/*     */   }
/*     */   
/*     */   public static ArrayList<Module> getModules() {
/* 135 */     return mods;
/*     */   }
/*     */   
/*     */   public static void onUpdate() {
/* 139 */     for (Module m : mods) {
/* 140 */       m.onUpdate();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onRender() {
/* 145 */     for (Module m : mods) {
/* 146 */       m.onRender();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onRender3D(float partialTicks) {
/* 151 */     for (Module m : mods) {
/* 152 */       m.onRender3D(partialTicks);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onKeyPressed(int k) {
/* 157 */     for (Module m : mods) {
/* 158 */       if (m.getKey() == k) {
/* 159 */         m.toggle();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static ArrayList<Module> getModulesInCategory(Category categoryIn) {
/* 165 */     ArrayList<Module> modz = new ArrayList();
/* 166 */     for (Module m : mods) {
/* 167 */       if (m.getCategory() == categoryIn)
/* 168 */         modz.add(m);
/*     */     }
/* 170 */     return modz;
/*     */   }
/*     */ }


/* Location:              C:\Users\DarKay\Desktop\KTX\OxygenV.0.8.jar!\fr\oxygen\main\palamodaddons.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */