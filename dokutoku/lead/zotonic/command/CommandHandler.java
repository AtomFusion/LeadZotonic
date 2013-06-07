/**
 * 
 */
package dokutoku.lead.zotonic.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Codename: Nickel Rad
 *
 * CommandHandler
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class CommandHandler {
	
	public static void initCommands(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandLZ());
	}

}
