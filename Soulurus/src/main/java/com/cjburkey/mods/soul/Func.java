package com.cjburkey.mods.soul;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import com.cjburkey.mods.soul.tab.TABS;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Func {
	
	public static Logger l;
	
	public static final void log(Object msg) { l.log(Level.INFO, "[Soulurus]" + msg); }
	
	public static final void register(Item i, boolean tab) {
		String name = i.getUnlocalizedName().substring(5);
		GameRegistry.registerItem(i, name);
		i.setTextureName(Info.id + ":" + name);
		if(tab) i.setCreativeTab(TABS.tabSoulurus);
	}
	
	public static final void register(Block b, boolean tab) {
		String name = b.getUnlocalizedName().substring(5);
		GameRegistry.registerBlock(b, name);
		b.setBlockTextureName(Info.id + ":" + name);
		if(tab) b.setCreativeTab(TABS.tabSoulurus);
	}
	
}