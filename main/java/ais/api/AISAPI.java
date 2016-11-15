package ais.api;

import java.lang.reflect.Method;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import cpw.mods.fml.common.FMLLog;

public class AISAPI 
{
	static Method getAIS;
	
	/**
	 * Retrieves the baubles inventory for the supplied player
	 */
	public static IInventory getAIS(EntityPlayer player)
	{
		IInventory ot = null;
		
	    try
	    {
	        if(getAIS == null) 
	        {
	            Class<?> fake = Class.forName("baubles.common.lib.PlayerHandler");
	            getAIS = fake.getMethod("getPlayerAIS", EntityPlayer.class);
	        }
	        
	        ot = (IInventory) getAIS.invoke(null, player);
	    } 
	    catch(Exception ex) 
	    { 
	    }
	    
		return ot;
	}
	
}