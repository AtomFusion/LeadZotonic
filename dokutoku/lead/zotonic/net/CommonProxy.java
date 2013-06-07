/**
 * 
 */
package dokutoku.lead.zotonic.net;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * Codename: Nickel Rad
 *
 * CommonProxy
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class CommonProxy implements ILZProxy {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void movePlayerToLoc(EntityPlayer e, double x, double y, double z) {

		if (e instanceof EntityPlayerMP) {
			((EntityPlayerMP)e).playerNetServerHandler.setPlayerLocation(x, y, z, e.cameraYaw, e.cameraPitch);
		}

	}

}
