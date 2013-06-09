package dokutoku.lead.zotonic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import dokutoku.lead.zotonic.command.CommandHandler;
import dokutoku.lead.zotonic.lib.Configs;
import dokutoku.lead.zotonic.lib.Reference;
import dokutoku.lead.zotonic.net.ClientPacketHandler;
import dokutoku.lead.zotonic.net.ConnectionHandler;
import dokutoku.lead.zotonic.net.ILZProxy;
import dokutoku.lead.zotonic.net.ServerPacketHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER,
dependencies = Reference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false,
clientPacketHandlerSpec = @SidedPacketHandler(channels = { Reference.CHANNEL_NAME }, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = { Reference.CHANNEL_NAME }, packetHandler = ServerPacketHandler.class),
connectionHandler = ConnectionHandler.class)
public class LeadCore {
	
	@SidedProxy(clientSide = "dokutoku.lead.zotonic.net.ClientProxy", serverSide = "dokutoku.lead.zotonic.net.CommonProxy")
	public static ILZProxy proxy;
	
	@Mod.Instance("LeadZotonic")
	public static LeadCore instance;
	
	@Mod.ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		CommandHandler.initCommands(event);
	}
	
	@Mod.PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configs.init(event);
		// LocalizationManager.setupLocalizationInfo();
		
		// TEHelper.init();
		
		
	}
	
	@Mod.Init
	public void doInit(FMLInitializationEvent event) {
		
		Configs.load(event);
		
	}
	
	@Mod.PostInit
	public void doPost(FMLPostInitializationEvent event) {
		
		Configs.postLoad(event);
		
	}
	
}
