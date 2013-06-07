/**
 * 
 */
package dokutoku.lead.zotonic.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

import dokutoku.lead.zotonic.lib.Reference;

/**
 * Codename: Nickel Rad
 *
 * LeadLogger
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class LeadLogger {

	private static Logger logger = Logger.getLogger(Reference.MOD_ID);
	
	public static void init() {
		
		logger.setParent(FMLLog.getLogger());
		
	}

	public static void log(Level logLevel, String message) {
		
		logger.log(logLevel, message);
	}
}
