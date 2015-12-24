package com.cjburkey.mods.soul.block;

import com.cjburkey.mods.soul.item.ItemSoul;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockInteract extends Block {
	
	public BlockInteract() {
		super(Material.iron);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(4.0f);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int xx, float yy, float zz, float aa) {
		ItemStack stack = player.inventory.getCurrentItem();
		if(stack != null && stack.getItem() != null && stack.getItem() instanceof ItemSoul) {
			NBTTagCompound tag = stack.stackTagCompound;
			if(tag != null && tag.hasKey("kills")) {
				int kills = tag.getInteger("kills");
				if(kills > 0) {
					tag.setInteger("kills", kills - 1);
					if(!world.isRemote) {
						NBTTagCompound tag1 = player.getEntityData();
						
						NBTBase modeTag = tag1.getTag("souls");
						int playerSouls = 0;
						if(modeTag != null) {
							player.addChatMessage(new ChatComponentText(tag1.getInteger("souls") + " souls"));
							playerSouls = tag1.getInteger("souls");
						}
						tag1.setInteger("souls", playerSouls + 1);
						return true;
					}
				}
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