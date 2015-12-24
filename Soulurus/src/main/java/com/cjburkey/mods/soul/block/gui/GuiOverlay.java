package com.cjburkey.mods.soul.block.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;

public class GuiOverlay extends Gui {
	
	public GuiOverlay(Minecraft mc) {	
		EntityClientPlayerMP player = mc.thePlayer;
		
		if(player.getEntityData().hasKey("souls")) {
			drawString(mc.fontRenderer, player.getEntityData().getInteger("souls") + " Souls", 10, 10, Integer.parseInt("FFAA00", 16));
		}
	}
	
}