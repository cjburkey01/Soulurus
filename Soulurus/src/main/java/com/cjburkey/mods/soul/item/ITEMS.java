package com.cjburkey.mods.soul.item;

import com.cjburkey.mods.soul.Func;

public class ITEMS {
	
	public static ItemSoul itemSoul, itemCreativeSoul;
	
	public static final void init() {
		Func.log("--[INIT ITEMS]--");
		itemSoul = (ItemSoul) new ItemSoul(false).setUnlocalizedName("itemSoul");
		itemCreativeSoul = (ItemSoul) new ItemSoul(true).setUnlocalizedName("itemCreativeSoul");
		
		Func.register(itemSoul, true);
		Func.register(itemCreativeSoul, true);
	}
	
}