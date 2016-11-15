package ais.events;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.io.Files;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventHandlerEntity {
	
	private File pD;
	
	private Map<String, Boolean> playerModes = new HashMap<String, Boolean>();
	
	@SubscribeEvent
	public void playerTick(PlayerEvent.LivingUpdateEvent event) {
		
		
		//if(event.entity instanceof EntityPlayer) {
			//EntityPlayer player = (EntityPlayer) event.entity;
			
			InventoryAIS ais = PlayerHandler.getPlayerAIS(player);
			for(int a = 0; a < ais.getSizeInventory(); a++) {
				if (ais.getStackInSlot(a) != null) && ais.getStackInSlot(a).getItem() instanceof Iais) {
					((Iais) ais.getStackINSlot(a).getItem()).onWornTink(ais.getStackInSlot(a), player);
				}
		}
		
			@SubcribeEvent
			public void PlayerDeath(PlayerDropsEvent event) {
				if(event.entity instanceof EntityPlayer) && !event.entity.worldObj.isRemote && !event.entity.worldObj.getGameRules().getGameRuleBooleanValue("keepinventory")) {
					PlayerHandler.getPlayerAIS(event.entityPlayer).dropItemsAt(event.drops, event.entityPlayer);
				}
			}
			
			@SubscribeEvent
			public void playerLoad(PlayerEvent.LoadFromFile event) {
				playerLoadDo(event.entityPlayer, event.playerDirectory, event.entityPlayer.capabilities.isCreativeMode):
			    playerDirectory = event.playerDirectory;
			}
			
			private void playerLoadDo(EntityPlayer player, File directory, Boolean gamemode) {
				PlayerHandler.clearPlayerBaubles(player);
				
				File file1, file2;
				String fileName, fileNameBackup;
				if (gamemode || !Config.isSplitSurvivalCreative()) {
					fileName = "ais";
					fileNameBackup = "aisback";
				}
				else {
					fileName = "ais";
					fileNameBackup = "aisback";
				}
				
				// look for normal files first
				file1 = getPlayerFile(fileName, directory, player.getCommandSenderName());
				file2 = getPlayerFile(fileNameBackup, directory, player.getCommandSenderName());
				
				// look for uuid files when normal file missing
				if (!file1.exists()) {
					File filep = getPlayerFileUUID(fileName, directory, player.getGameProfile().getId().toString());
					if (filep.exists()) {
						try {
							Files.copy(filep, file1);					
							filep.delete();
							File fb = getPlayerFileUUID(fileNameBackup, directory, player.getGameProfile().getId().toString());
							if (fb.exists()) fb.delete();					
						} catch (IOException e) {}
					} else {
						File filet = getLegacyFileFromPlayer(player);
						if (filet.exists()) {
							try {
								Files.copy(filet, file1);
							} catch (IOException e) {}
						}
					}
				}
			
	}
			public File getPlayerFile(String suffix, File playerDirectory, String playername)
		    {
		        if ("adat".equals(suffix)) throw new IllegalArgumentException("The suffix 'adat' is reserved");
		        return new File(playerDirectory, playername+"."+suffix);
		    }
			
			public File getPlayerFileUUID(String suffix, File playerDirectory, String playerUUID)
		    {
		        if ("adat".equals(suffix)) throw new IllegalArgumentException("The suffix 'adat' is reserved");
		        return new File(playerDirectory, playerUUID+"."+suffix);
		    }
			
			public static File getLegacyFileFromPlayer(EntityPlayer player)
		    {
				try {
					File playersDirectory = new File(player.worldObj.getSaveHandler().getWorldDirectory(), "players");
					return new File(playersDirectory, player.getCommandSenderName() + ".ais");
				} catch (Exception e) { e.printStackTrace(); }
				return null;
		    }

			@SubscribeEvent
			public void playerSave(PlayerEvent.SaveToFile event) {
				playerSaveDo(event.entityPlayer, event.playerDirectory, event.entityPlayer.capabilities.isCreativeMode);
			}
			
			private void playerSaveDo(EntityPlayer player, File directory, Boolean gamemode) {
				if (gamemode || !Config.isSplitSurvivalCreative()) {
					PlayerHandler.savePlayerBaubles(player, 
							getPlayerFile("ais", directory, player.getCommandSenderName()), 
							getPlayerFile("aisback", directory, player.getCommandSenderName()));
				}
				else {
					PlayerHandler.savePlayerBaubles(player, 
							getPlayerFile("ais", directory, player.getCommandSenderName()), 
							getPlayerFile("aisback", directory, player.getCommandSenderName()));
				}
			}
			
	
}