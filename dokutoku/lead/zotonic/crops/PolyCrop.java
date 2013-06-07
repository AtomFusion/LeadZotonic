/**
 * 
 */
package dokutoku.lead.zotonic.crops;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Codename: Lead Zotonic
 *
 * PolyCrop
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class PolyCrop extends BlockCrops {
	
	protected Item drop;
	protected ItemSeeds seed;
	protected int rarity = 3;

	/**
	 * @param par1
	 */
	public PolyCrop(int par1, Item drop, ItemSeeds seed, int rarity) {
		
		super(par1);
		
		this.drop = drop;
		this.seed = seed;
		this.rarity = rarity;
	
	}
	
	/**
     * Generate a seed ItemStack for this crop.
     */
	@Override
    protected int getSeedItem()
    {
        return seed.itemID;
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
	@Override
    protected int getCropItem()
    {
        return drop.itemID;
    }
	
	/**
	 *  Drops only 2 things: A yield and a seed. Whether it drops more seeds/yield is luck.
	 *  As far as I can tell,
	 *  par2 is x
	 *  par3 is y
	 *  par4 is z
	 *  par5 is metadata (like growth or wool color)
	 *  par6 is fortune (I think)
	 *  par7 is set to 0 by the superclass. Ignore it.
	 */
	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
		
        if (!par1World.isRemote) // Are we the server?
        {
        	ItemStack[] items = new ItemStack[]{new ItemStack(drop, 1), new ItemStack(seed, 1)};
        	
        	// Are we mature enough?
        	if(par5 >= 7) {
        		
	        	for(ItemStack item : items)
	        	{
	        		float c = par1World.rand.nextFloat() + ((float)rarity / 10.0f);
		            if (c <= 0.7f)
		            {
		                this.dropBlockAsItem_do(par1World, par2, par3, par4, item);
		                
		                // If c is super low, triple the output
		                if(c <= 0.1f)
		                {
		                	this.dropBlockAsItem_do(par1World, par2, par3, par4, item);
		                }
		            }
	        	}
	        	
        	}
        	
        }
        
    }
	
	@Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(seed, 1));
		ret.add(new ItemStack(drop, 1));
		return ret;
    }
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
		float growthRate = 14.875f * ((float)invertRarity() / 10.0f);
		
		System.out.println("Growth rate: " + Float.toString(growthRate));
		
		if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 7)
            {
            	
            	
                if (par5Random.nextInt((int)(25.0F / growthRate) + 1) == 0)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                    System.out.println("Grow!");
                }
            }
        }
		
	}
	
	private int invertRarity() {
		switch(rarity) {
		case 10: return 1;
		case 9: return 2;
		case 8: return 3;
		case 7: return 4;
		case 6: return 5;
		case 5: return 6;
		case 4: return 7;
		case 3: return 8;
		case 2: return 9;
		case 1: return 10;
		default: return 1;
		}
	}

}
