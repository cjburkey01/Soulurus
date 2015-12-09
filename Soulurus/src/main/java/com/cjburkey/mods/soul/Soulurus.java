package com.cjburkey.mods.soul;

import com.cjburkey.mods.soul.block.BLOCKS;
import com.cjburkey.mods.soul.event.EventMobRightclick;
import com.cjburkey.mods.soul.item.ITEMS;
import com.cjburkey.mods.soul.recipe.RECIPES;
import com.cjburkey.mods.soul.tab.TABS;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(name = Info.name, version = Info.version, modid = Info.id)
public class Soulurus {
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent e) {
		Func.l = e.getModLog();
		
		Func.log("--[PRE-INIT]--");
		TABS.init();
		ITEMS.init();
		BLOCKS.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		Func.log("--[INIT]--");
		MinecraftForge.EVENT_BUS.register(new EventMobRightclick());
		RECIPES.init();
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
		Func.log("--[POST-INIT]--");
	}
	
}