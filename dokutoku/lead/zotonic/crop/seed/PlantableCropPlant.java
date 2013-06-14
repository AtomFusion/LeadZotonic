/**
 * 
 */
package dokutoku.lead.zotonic.crop.seed;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import powercrystals.minefactoryreloaded.api.IFactoryPlantable;
import dokutoku.lead.zotonic.crop.PolyCrop;

public class PlantableCropPlant extends PlantableStandard implements IFactoryPlantable
{
	public PlantableCropPlant(int seedItemID, int plantBlockID)
	{
		super(seedItemID, plantBlockID);
	}
	
	@Override
	public boolean canBePlantedHere(World world, int x, int y, int z, ItemStack stack)
	{
		int groundId = world.getBlockId(x, y - 1, z);
		if(!world.isAirBlock(x, y, z))
		{
			return false;
		}
		return (
				
				((PolyCrop)Block.blocksList[_plantedBlockId]).canThisPlantGrowOnThisBlockID(groundId)
				
				/*groundId == Block.dirt.blockID ||
				groundId == Block.grass.blockID ||
				groundId == Block.tilledField.blockID ||
				(Block.blocksList[_plantedBlockId] instanceof IPlantable && Block.blocksList[groundId] != null &&
				Block.blocksList[groundId].canSustainPlant(world, x, y, z, ForgeDirection.UP, ((IPlantable)Block.blocksList[_plantedBlockId])))*/);
	}
	
	@Override
	public void prePlant(World world, int x, int y, int z, ItemStack stack)
	{
		int groundId = world.getBlockId(x, y - 1, z);
		if(groundId == Block.dirt.blockID || groundId == Block.grass.blockID)
		{
			world.setBlock(x, y - 1, z, Block.tilledField.blockID);
		}
	}
}
