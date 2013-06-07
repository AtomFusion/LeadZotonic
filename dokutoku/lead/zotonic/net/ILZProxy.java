/**
 * 
 */
package dokutoku.lead.zotonic.net;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Codename: Nickel Rad
 *
 * ILZProxy
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public interface ILZProxy {

	public void init();
	
	public void movePlayerToLoc(EntityPlayer e, double x, double y, double z);
}
