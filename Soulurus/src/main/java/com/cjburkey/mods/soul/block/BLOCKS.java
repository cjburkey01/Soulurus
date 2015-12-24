package com.cjburkey.mods.soul.block;

import com.cjburkey.mods.soul.Func;
import com.cjburkey.mods.soul.block.tile.BlockSoulSpawnerTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BLOCKS {
	
	public static Block blockSpawner, blockWiper, blockPlayerInteract;
	
	public static final void init() {
		Func.log("--[INIT BLOCKS]--");
		blockSpawner = new BlockSoulSpawner().setBlockName("blockSpawner");
		blockWiper = new BlockWiper().setBlockName("blockWiper");
		blockPlayerInteract = new BlockInteract().setBlockName("blockPlayerInteract");
		
		Func.register(blockSpawner, true);
		Func.register(blockWiper, true);
		Func.register(blockPlayerInteract, true);
		
		GameRegistry.registerTileEntity(BlockSoulSpawnerTileEntity.class, "blockSoulSpawnerTileEntity");
	}
	
}