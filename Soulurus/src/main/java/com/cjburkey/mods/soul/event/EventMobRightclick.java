package com.cjburkey.mods.soul.event;

import com.cjburkey.mods.soul.Func;
import com.cjburkey.mods.soul.item.ITEMS;
import com.cjburkey.mods.soul.item.ItemSoul;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventMobRightclick {
	
	@SubscribeEvent
	public void onEntityRightClicked(EntityInteractEvent e) {
		if(!e.target.worldObj.isRemote) {
			ItemStack stack = e.entityPlayer.inventory.getCurrentItem();
			Entity ent = e.target;
			
			Func.log(ent);
			
			if(stack != null && ent instanceof EntityLivingBase) {
				if(stack.getItem() != null && stack.getItem() instanceof ItemSoul) {
					if(ITEMS.itemSoul.collectMob(stack, ent)) {
						((EntityLivingBase) ent).isDead = true;
					} else {
						e.entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "The Soul Cache already contains a soul of another."));
					}
				}
			}
		}
	}
	
}