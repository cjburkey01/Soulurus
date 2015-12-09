package com.cjburkey.mods.soul.block;

import com.cjburkey.mods.soul.item.ItemSoul;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockWiper extends Block {
	
	public BlockWiper() {
		super(Material.glass);
		this.setStepSound(Block.soundTypeGlass);
		this.setHardness(1.5f);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int xx, float yy, float zz, float aa) {
		ItemStack stack = player.inventory.getCurrentItem();
		if(stack != null) {
			Item i = stack.getItem();
			if(i != null && i instanceof ItemSoul) {
				stack.stackTagCompound = null;
				return true;
			}
		}
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean canRenderInPass(int pass) {
		return true;
	}
	
	public int getRenderBlockPass() {
		return 1;
	}
	
}