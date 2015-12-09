package com.cjburkey.mods.soul.recipe;

import com.cjburkey.mods.soul.block.BLOCKS;
import com.cjburkey.mods.soul.item.ITEMS;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RECIPES {
	
	public static final void init() {
		add(new ItemStack(ITEMS.itemSoul, 1), new Object[] {
				"aya",
				"yzy",
				"aya",
				Character.valueOf('y'), "gemEmerald",
				Character.valueOf('z'), "gemDiamond",
				Character.valueOf('a'), "ingotIron",
		});
		add(new ItemStack(BLOCKS.blockSpawner, 1), new Object[] {
				"xbx",
				"aza",
				"yyy",
				Character.valueOf('x'), "ingotIron",
				Character.valueOf('y'), Blocks.iron_bars,
				Character.valueOf('z'), "blockDiamond",
				Character.valueOf('a'), "blockRedstone",
				Character.valueOf('b'), "blockIron",
		});
		add(new ItemStack(BLOCKS.blockWiper), new Object[] {
				"xax",
				"xyx",
				"xzx",
				Character.valueOf('x'), "ingotIron",
				Character.valueOf('y'), "gemEmerald",
				Character.valueOf('z'), "blockRedstone",
				Character.valueOf('a'), "blockGlass",
		});
	}
	
	private static final void add(ItemStack out, Object... obj) {
		GameRegistry.addRecipe(new ShapedOreRecipe(out, obj));
	}
	
	@SuppressWarnings("unused")
	private static final void addShapeless(ItemStack out, Object... obj) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(out, obj));
	}
	
}