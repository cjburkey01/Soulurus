package com.cjburkey.mods.soul.tab;

import com.cjburkey.mods.soul.item.ITEMS;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TABS {
	
	public static CreativeTabs tabSoulurus;
	
	public static final void init() {
		tabSoulurus = new CreativeTabs("tabSoulurus") {
			public Item getTabIconItem() {
				return ITEMS.itemSoul;
			}
		};
	}
	
}