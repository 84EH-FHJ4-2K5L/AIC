package ais.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class EventHanlderNetwork {
	
	@SubscribeEvent
	public void playerLoggedEvent (PlayerEvent.PlayerLoggedInEvent event) {
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER)
			syncAIS(event.player);
	}
	
	public static void syncAIS(EntityPlayer player) {
		for (int a = 0; a < 4; a++) {
			PlayerHandler.getPlayerAIS(player.syncSlotToClients(a);
		}
	}
}