package com.cjburkey.mods.soul.item;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemSoul extends Item {
	
	public int maxSouls = 500;
	public boolean creative = false;
	
	public ItemSoul(boolean c) {
		this.maxStackSize = 1;
		this.creative = c;
	}
	
	public boolean onItemUse(ItemStack a, EntityPlayer b, World c, int d, int e, int f, int g, float h, float i, float j) {
		return true;
	}
	
	public boolean collectMob(ItemStack stack, Entity entity) {
		if(stack.stackTagCompound == null) {
			stack.stackTagCompound = new NBTTagCompound();
			
			stack.stackTagCompound.setInteger("mobID", EntityList.getEntityID(entity));
			stack.stackTagCompound.setInteger("kills", (((ItemSoul) stack.getItem()).creative) ? maxSouls : 1);
		} else {
			if(stack.stackTagCompound.getInteger("mobID") != EntityList.getEntityID(entity)) return false;
			
			int kills = stack.stackTagCompound.getInteger("kills");
			if(kills < maxSouls) stack.stackTagCompound.setInteger("kills", kills + 1);
		}
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return (stack.stackTagCompound != null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		if(stack.stackTagCompound != null) {
			String entityName = EntityList.getStringFromID(stack.stackTagCompound.getInteger("mobID"));
			int kills = stack.stackTagCompound.getInteger("kills");
			list.add(EnumChatFormatting.GREEN + "Mob: " + entityName);
			list.add(EnumChatFormatting.GREEN + "Souls: " + kills);
		} else {
			list.add(EnumChatFormatting.RED + "No Souls!");
			list.add(EnumChatFormatting.RED + "Right click on a mob to collect its soul.");
			if(((ItemSoul) stack.getItem()).creative) list.add(EnumChatFormatting.GREEN + "Souls will be 500(max) automatically."); 
		}
	}
	
}