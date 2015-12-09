package com.cjburkey.mods.soul.block.tile;

import java.util.Random;
import com.cjburkey.mods.soul.item.ITEMS;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSoulSpawnerTileEntity extends TileEntity {
	
	public boolean has = false;
	public int mobID = -1;
	public int kills = -1;
	
	public void activate(ItemStack s, World world, int x, int y, int z, EntityPlayer player) {
		if(!has) {
			if(s != null) {
				NBTTagCompound nbt = s.stackTagCompound;
				if(nbt != null) {
					has = true;
					this.mobID = nbt.getInteger("mobID");
					this.kills = nbt.getInteger("kills");
					s.stackSize = 0;
				}
			}
		} else {
			has = false;
			ItemStack stack = new ItemStack(ITEMS.itemSoul);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("mobID", this.mobID);
			nbt.setInteger("kills", this.kills);
			stack.stackTagCompound = nbt;
			
			world.spawnEntityInWorld(new EntityItem(world, player.posX, player.posY, player.posZ, stack));
			
			this.mobID = -1;
			this.kills = -1;
		}
		
		this.markDirty();
	}
	
	long ticks = 0;
	long time;
	
	public void updateEntity() {
		time = (int) (5 - (((float) this.kills / (float) ITEMS.itemSoul.maxSouls) * 5)) + 1;
		ticks ++;

		World world = this.worldObj;
		
		if(!world.isRemote && ticks >= time * 20) {
			ticks = 0;
			
			int x = this.xCoord, y = this.yCoord, z = this.zCoord;
			
			if(world.isBlockIndirectlyGettingPowered(x, y, z)) {
				BlockSoulSpawnerTileEntity t = (BlockSoulSpawnerTileEntity) world.getTileEntity(x, y, z);
				if(t != null && t.mobID > 0) {
					int xadd = new Random().nextInt((2 - -2) + 1) + -2;
					int zadd = new Random().nextInt((2 - -2) + 1) + -2;
					x += (xadd != 0) ? xadd : 1;
					z += (zadd != 0) ? zadd : 1;
					
					Entity ent = EntityList.createEntityByID(t.mobID, world);
					ent.setPosition(x + 0.5, y - 1, z + 0.5);
					world.spawnEntityInWorld(ent);
				}
			}
		}
	}
	
	public void destroy(World world) {
		if(has) {
			ItemStack stack = new ItemStack(ITEMS.itemSoul);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("mobID", this.mobID);
			nbt.setInteger("kills", this.kills);
			stack.stackTagCompound = nbt;
			
			world.spawnEntityInWorld(new EntityItem(world, this.xCoord, this.yCoord, this.zCoord, stack));
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.has = nbt.getBoolean("has");
		this.mobID = nbt.getInteger("mobID");
		this.kills = nbt.getInteger("kills");
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("has", this.has);
		nbt.setInteger("mobID", this.mobID);
		nbt.setInteger("kills", this.kills);
	}
	
}