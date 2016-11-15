package ais;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ais.events.EventHandlerEntity;
import ais.events.EventHanlderNetwork;
import ais.handlers.PacketHandler;
import ais.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ais.MODID, name = ais.MODNAME, version = ais.VERSION, dependencies="required-after:Forge@[10.13.2,);")

public class ais {
	
	public static final String MODID = "ais";
	public static final String MODNAME = "ais";
	public static final String VERSION = "1.0.1.10";

	@SidedProxy(clientSide = "ais.client.ClientProxy", serverSide = "ais.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(value=ais.MODID)
	public static ais instance;
	
	public EventHandlerEntity entityEventHandler;
	public EventHanlderNetwork entityEventNetwork;
	public File modDir;
	
	public static final Logger log = LogManager.getLogger("ais");
	public static final int GUI = 0;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		event.getModMetadata().version = ais.VERSION;
		modDir = event.getModConfigurationDirectory();		
		
		try {
		} catch (Exception e) {
		} finally {
		}
		
		PacketHandler.init();
		
		entityEventHandler = new EventHandlerEntity();
		entityEventNetwork = new EventHanlderNetwork();
		
		MinecraftForge.EVENT_BUS.register(entityEventHandler);
		FMLCommonHandler.instance().bus().register(entityEventNetwork);
		proxy.registerHandlers();
		
		/////////////////////
			
		
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
  		proxy.registerKeyBindings();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

		
	}
		
}