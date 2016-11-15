package ais.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;

import com.google.common.io.Files;

import ais.containers.AISInventory;

public class PlayerHandler {

	private static HashMap<String, AISInventory> playerAIS = new HashMap<String, AISInventory>();

	public static void clearplayerAIS(EntityPlayer player) {
		playerAIS.remove(player.getCommandSenderName());
	}

	public static AISInventory getplayerAIS(EntityPlayer player) {
		if (!playerAIS.containsKey(player.getCommandSenderName())) {
			AISInventory inventory = new AISInventory(player);
			playerAIS.put(player.getCommandSenderName(), inventory);
		}
		return playerAIS.get(player.getCommandSenderName());
	}

	public static void setplayerAIS(EntityPlayer player,
			AISInventory inventory) {
		playerAIS.put(player.getCommandSenderName(), inventory);
	}

	public static void loadplayerAIS(EntityPlayer player, File file1, File file2) {
		if (player != null && !player.worldObj.isRemote) {
			try {
				NBTTagCompound data = null;
				boolean save = false;
				if (file1 != null && file1.exists()) {
					try {
						FileInputStream fileinputstream = new FileInputStream(
								file1);
						data = CompressedStreamTools
								.readCompressed(fileinputstream);
						fileinputstream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (file1 == null || !file1.exists() || data == null
						|| data.hasNoTags()) {
					if (file2 != null && file2.exists()) {
						try {
							FileInputStream fileinputstream = new FileInputStream(
									file2);
							data = CompressedStreamTools
									.readCompressed(fileinputstream);
							fileinputstream.close();
							save = true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

				if (data != null) {
					AISInventory inventory = new AISInventory(player);
					inventory.readNBT(data);
					playerAIS.put(player.getCommandSenderName(), inventory);
					if (save)
						saveplayerAIS(player, file1, file2);
				}
			} catch (Exception exception1) {
				exception1.printStackTrace();
			}
		}
	}

	public static void saveplayerAIS(EntityPlayer player, File file1, File file2) {
		if (player != null && !player.worldObj.isRemote) {
			try {
				if (file1 != null && file1.exists()) {
					try {
						Files.copy(file1, file2);
					} catch (Exception e) {
						System.out.println("You stupid fag")
					;}			}

				try {
					if (file1 != null) {
						AISInventory inventory = getplayerAIS(player);
						NBTTagCompound data = new NBTTagCompound();
						inventory.saveNBT(data);

						FileOutputStream fileoutputstream = new FileOutputStream(
								file1);
						CompressedStreamTools.writeCompressed(data,
								fileoutputstream);
						fileoutputstream.close();

					}
				} catch (Exception e) {
					
					e.printStackTrace();
					if (file1.exists()) {
						try {
							file1.delete();
						} catch (Exception e2) {
						}
					}
				}
			} catch (Exception exception1) {
				
			}
		}
	}
}