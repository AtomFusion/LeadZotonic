/**
 * 
 */
package dokutoku.lead.zotonic.crop.seed;

import java.util.logging.Level;

import dokutoku.lead.zotonic.util.LeadLogger;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;

/**
 * Codename: Lead Zotonic
 *
 * PlantableStandard
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class PlantableStandard implements IFactoryPlantable {

	protected int _sourceId;
	protected int _plantedBlockId;

	public PlantableStandard(int sourceId, int plantedBlockId)
	{
		LeadLogger.log(Level.SEVERE, "Constructor called");
		if(plantedBlockId >= Block.blocksList.length)
		{
			throw new IllegalArgumentException("Passed an Item ID to FactoryPlantableStandard's planted block argument");
		}
		this._sourceId = sourceId;
		this._plantedBlockId = plantedBlockId;
	}

	@Override
	public boolean canBePlantedHere(World world, int x, int y, int z, ItemStack stack)
	{
		LeadLogger.log(Level.SEVERE, "canBePlantedHere called");
		int groundId = world.getBlockId(x, y - 1, z);
		if(!world.isAirBlock(x, y, z))
		{
			return false;
		}
		return 
				(Block.blocksList[_plantedBlockId].canPlaceBlockAt(world, x, y, z) && Block.blocksList[_plantedBlockId].canBlockStay(world, x, y, z)) ||
				(Block.blocksList[_plantedBlockId] instanceof IPlantable && Block.blocksList[groundId] != null &&
				Block.blocksList[groundId].canSustainPlant(world, x, y, z, ForgeDirection.UP, ((IPlantable)Block.blocksList[_plantedBlockId])));
	}

	@Override
	public void prePlant(World world, int x, int y, int z, ItemStack stack)
	{
		LeadLogger.log(Level.SEVERE, "prePlant called");
		return;
	}

	@Override
	public void postPlant(World world, int x, int y, int z, ItemStack stack)
	{
		LeadLogger.log(Level.SEVERE, "postPlant called");
		return;
	}

	@Override
	public int getPlantedBlockId(World world, int x, int y, int z, ItemStack stack)
	{
		LeadLogger.log(Level.SEVERE, "getPlantedBlockId called");
		if(stack.itemID != _sourceId)
		{
			return -1;
		}
		return _plantedBlockId;
	}

	@Override
	public int getPlantedBlockMetadata(World world, int x, int y, int z, ItemStack stack)
	{
		LeadLogger.log(Level.SEVERE, "getPlantedBlockMetadata called");
		return stack.getItemDamage();
	}

	@Override
	public int getSeedId()
	{
		LeadLogger.log(Level.SEVERE, "getSeedId called");
		return _sourceId;
	}

}
