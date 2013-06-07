package dokutoku.lead.zotonic.lib;

public final class Reference {
	
	/* Debug mode On-Off */
	public static final boolean DEBUG_MODE = false;
	
	/* The general stuff */
	public static final String MOD_ID = "NickelRad";
	public static final String MOD_NAME = "Codename: Nickel Rad";
	public static final String VERSION_NUMBER = "1.5.2a001"; /* TODO: Ant Build this */
	public static final String CHANNEL_NAME = MOD_ID;
	public static final String DEPENDENCIES = 
			"after:BuildCraft|Core;" +
			"after:BuildCraft|Factory;" +
			"after:BuildCraft|Energy;" +
			"after:BuildCraft|Builders;" +
			"after:BuildCraft|Transport;" + 
			"after:IC2;" /*+ 
			"required-after:PowerCrystalsCore"*/;
	
	/* Power conversions */
	public static final int powerPerEU = 4;
	public static final int powerPerMJ = 10;
	
}
