package ais.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IAISItemHandler {	
	
	public boolean isItemValidForSlot(int slot, ItemStack stack, EntityLivingBase player);

	/**
	 * Used internally to prevent equip/unequip events from triggering when they shouldn't
	 * @return
	 */
	public boolean isEventBlocked();
	public void setEventBlock(boolean blockEvents);

	/**
	 * Used internally for syncing. Indicates if the inventory has changed since last sync
	 * @return
	 */
	boolean isChanged(int slot);
	void setChanged(int slot, boolean changed);
}