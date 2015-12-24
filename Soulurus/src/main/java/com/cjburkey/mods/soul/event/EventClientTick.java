package com.cjburkey.mods.soul.event;

import com.cjburkey.mods.soul.block.gui.GuiOverlay;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class EventClientTick {
	
	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent e) {
		new GuiOverlay(Minecraft.getMinecraft());
	}
	
}