package ais.containers;

import ais.api.AISType;
import ais.api.IAIS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class AISSlot extends Slot {
		
	AISType type;

	    public AISSlot(IInventory par2IInventory, AISType type, int par3, int par4, int par5)
	    {
	        super(par2IInventory, par3, par4, par5);
	        this.type = type;
	    }
	    

	    /**
	     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	     */
	    @Override
	    public boolean isItemValid(ItemStack stack)
	    {
	    	return stack!=null && stack.getItem() !=null &&
	        	   stack.getItem() instanceof IAIS && 
	        	   ((IAIS)stack.getItem()).getAISType(stack)==this.type &&
	        	   ((IAIS)stack.getItem()).canEquip(stack, ((AISInventory)this.inventory).player.get());
	    }
	    

		@Override
		public boolean canTakeStack(EntityPlayer player) {
			return this.getStack()!=null &&
				   ((IAIS)this.getStack().getItem()).canUnequip(this.getStack(), player);
		}


		@Override
	    public int getSlotStackLimit()
	    {
	        return 1;
	    }
	    
}