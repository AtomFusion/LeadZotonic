/**
 * 
 */
package dokutoku.lead.zotonic.item;

import dokutoku.lead.zotonic.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Codename: Lead Zotonic
 *
 * MagicStem
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class MagicStem extends Item {

	/**
	 * @param par1
	 */
	public MagicStem(int par1) {
		super(par1);
		
		setMaxStackSize(64);
		setUnlocalizedName("seeds.stem");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	
	public void registerIcons(IconRegister iReg)
	{
		itemIcon = iReg.registerIcon(Reference.MOD_ID+":" + "magicStem");
	}

}
