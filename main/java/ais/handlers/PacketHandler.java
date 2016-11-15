package ais.handlers;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ais.MODID.toLowerCase());

    public static void init()
    { 
        INSTANCE.registerMessage(PacketOpenAISInventory.class, PacketOpenAISInventory.class, 0, Side.SERVER);
        INSTANCE.registerMessage(PacketOpenNormalInventory.class, PacketOpenAISInventory.class, 1, Side.SERVER);
        INSTANCE.registerMessage(PacketSync.class, PacketSync.class, 2, Side.CLIENT);
    }
    
    
}