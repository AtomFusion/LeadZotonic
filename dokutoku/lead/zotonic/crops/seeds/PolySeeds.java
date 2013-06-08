/**
 * 
 */
package dokutoku.lead.zotonic.crops.seeds;

import dokutoku.lead.zotonic.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * Codename: Lead Zotonic
 *
 * PolySeeds
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class PolySeeds extends ItemSeeds {
	
	private String dropType;
	private ItemStack smeltProduct;

	public PolySeeds(int par1, int par2, int par3, ItemStack smeltProduct) {
		super(par1, par2, par3);
		
		this.smeltProduct = smeltProduct;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID+":" + dropType + "_seed");
	}
	
	public ItemStack getProduct() {
		
		return smeltProduct;
		
	}

	/**
	 * @param string
	 * @return
	 */
	public PolySeeds setType(String string) {
		dropType = string;
		return this;
	}
}
