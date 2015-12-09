package com.cjburkey.mods.soul.block;

import java.util.Random;
import com.cjburkey.mods.soul.block.tile.BlockSoulSpawnerTileEntity;
import com.cjburkey.mods.soul.item.ITEMS;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSoulSpawner extends Block implements ITileEntityProvider {

	public BlockSoulSpawner() {
		super(Material.iron);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(5.0f);
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BlockSoulSpawnerTileEntity();
	}
	
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	public void updateTick(World world, int x, int y, int z, Random r) {
		
		world.scheduleBlockUpdate(x, y, z, this, 20);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		world.scheduleBlockUpdate(x, y, z, this, 20);
	}
	
	public void onBlockPreDestroy(World world, int x, int y, int z, int four) {
		if(!world.isRemote) {
			TileEntity t = world.getTileEntity(x, y, z);
			((BlockSoulSpawnerTileEntity) t).destroy(world);
		}
		super.onBlockPreDestroy(world, x, y, z, four);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int xx, float yy, float zz, float aa) {
		ItemStack stack = player.inventory.getCurrentItem();
		if(!world.isRemote) {
			TileEntity t = world.getTileEntity(x, y, z);
			((BlockSoulSpawnerTileEntity) t).activate(stack, world, x, y, z, player);
		}
		return ((stack != null) && (stack.getItem().equals(ITEMS.itemSoul)));
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