package ais.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;

public class ItemConstructor {
	static Item ItemGenerated;
	static String[][] NewCollection = new String[64][64];
	static String[] ICollection = { "Copper", "Iron", "Steel", "Adamantium" };
	static String BPack;
	static boolean cBool;
	static int i;
	static IInventory inv;
	public static void init() {
		
	}

}

class ItemConstruction {
		
	
	/**
	 * public static String[][] getCollectionGenerated(String[][] NewCollection)
	 * { or(int i=0; i<Collection.length; i++) { for(int j=0;
	 * j<ITypeCollection.length; j++) { NewCollection[i][j]=+""; return
	 * NewCollection; }
	 */

	/**public static String[][] getCollection(String[] Collection, String[][] NewCollection, Item ItemGenerated) {
		for (int i = 0; i < Collection.length; i++) {
			for (int j = 0; j < ITypeCollection.length; j++) {
				NewCollection[i][j] = Collection[i] + ITypeCollection[j];
				if (NewCollection[i][j] != null) {
					ItemGenerated = new Item().setUnlocalizedName(NewCollection[i][j])
							.setTextureName(NewCollection[i][j]).setCreativeTab(CreativeTabs.tabMisc);
					GameRegistry.registerItem(ItemGenerated, NewCollection[i][j]);
				}
			}
		}
		return NewCollection;
	}*/
}