package com.cjburkey.mods.soul;

import java.io.File;
import com.cjburkey.mods.soul.block.BLOCKS;
import com.cjburkey.mods.soul.event.EventClientTick;
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
import net.minecraftforge.common.config.Configuration;

@Mod(name = Info.name, version = Info.version, modid = Info.id)
public class Soulurus {
	
	public static int spawnRadius = 2;
	public static int maxEntities = 200;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent e) {
		Func.l = e.getModLog();
		
		Configuration c = new Configuration(new File(e.getModConfigurationDirectory(), "/soulurus/config.cfg"));
		spawnRadius = c.getInt("spawnRadius", Configuration.CATEGORY_GENERAL, 2, 1, 10, "The spawning radius of the mob spawner");
		maxEntities = c.getInt("maxEntities", Configuration.CATEGORY_GENERAL, 200, 1, 1000, "The max entities allowed before the spawner disables");
		c.save();
		
		Func.log("--[PRE-INIT]--");
		TABS.init();
		ITEMS.init();
		BLOCKS.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		Func.log("--[INIT]--");
		MinecraftForge.EVENT_BUS.register(new EventMobRightclick());
		MinecraftForge.EVENT_BUS.register(new EventClientTick());
		RECIPES.init();
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent e) {
		Func.log("--[POST-INIT]--");
	}
	
}