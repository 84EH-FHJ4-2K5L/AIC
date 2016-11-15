package ais.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemWithUses extends Item {
	
	@Override
	 public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	    {
		return p_77659_1_;
	    }
	
	public static void init() {
	    Item ItemGenerated;
	    
		ItemGenerated = new ItemWithUses().setUnlocalizedName("IG").setCreativeTab(CreativeTabs.tabMisc);
	    GameRegistry.registerItem(ItemGenerated, "IG");
	
	
	
	
	
}
}