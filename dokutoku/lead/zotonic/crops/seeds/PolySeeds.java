/**
 * 
 */
package dokutoku.lead.zotonic.crops.seeds;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dokutoku.lead.zotonic.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

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
	private EnumPlantType plantType;

	public PolySeeds(int par1, int par2, int par3, ItemStack smeltProduct, EnumPlantType plantType) {
		super(par1, par2, par3);
		
		this.smeltProduct = smeltProduct;
		this.plantType = plantType;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID+":" + dropType + "_seed");
	}
	
	public ItemStack getProduct() {
		
		return smeltProduct;
		
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
		return getPolyType();	
	}
	
	public EnumPlantType getPolyType()
	{
		return plantType;
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
