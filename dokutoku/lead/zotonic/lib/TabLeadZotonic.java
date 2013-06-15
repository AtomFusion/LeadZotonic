/**
 * 
 */
package dokutoku.lead.zotonic.lib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.StringTranslate;

/**
 * Codename: Lead Zotonic
 *
 * TabLeadZotonic
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class TabLeadZotonic extends CreativeTabs {

	
	public TabLeadZotonic(String label) {
		super(label);
	}


	public TabLeadZotonic(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return StringTranslate.getInstance().translateKey("" + this.getTabLabel());
	}
	
	@SideOnly(Side.CLIENT)
	public String getTabLabel()
	{
		return "Golden Thumb Crops";
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Configs.magicalStem.itemID;
	}

}
