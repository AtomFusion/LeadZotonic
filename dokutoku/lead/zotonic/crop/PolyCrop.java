/**
 * 
 */
package dokutoku.lead.zotonic.crop;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dokutoku.lead.zotonic.client.CropParticleFX;
import dokutoku.lead.zotonic.lib.Configs;
import dokutoku.lead.zotonic.lib.FXType;
import dokutoku.lead.zotonic.lib.Reference;
import dokutoku.lead.zotonic.crop.seed.PolySeeds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.EnumPlantType;

/**
 * Codename: Lead Zotonic
 *
 * PolyCrop
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class PolyCrop extends BlockCrops {
	
	protected ItemSeeds seed;
	protected int       rarity = 3;
	protected FXType    fxtype = FXType.IRON;
	private   Icon      iconArray[];
	private   boolean   fullyGrown = false;
	
	
	/**
	 * @param par1
	 */
	public PolyCrop(int par1, ItemSeeds seed, int rarity) {
		
		super(par1);
		
		this.seed = seed;
		this.rarity = rarity;
		
		this.setLightValue(0.4f);
	
	}
	
	public FXType getFXType()
	{
		return fxtype;
	}
	
	@Override
	public boolean canThisPlantGrowOnThisBlockID(int par1)
    {
		if(((PolySeeds)seed).getPolyType() == EnumCropType.NETHER)
			return par1 == Block.slowSand.blockID;
		else if(((PolySeeds)seed).getPolyType() == EnumCropType.OVERWORLD)
			return par1 == Block.tilledField.blockID;
		else if(((PolySeeds)seed).getPolyType() == EnumCropType.LAVA)
			return par1 == Block.obsidian.blockID;
		else if(((PolySeeds)seed).getPolyType() == EnumCropType.END)
			return par1 == Block.whiteStone.blockID;
		return false;
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
        return seed.itemID;
    }
	
	@Override
	public void fertilize(World par1World, int par2, int par3, int par4)
    {
        super.fertilize(par1World, par2, par3, par4);
        
        tellTheNeighbors(par1World, par2, par3, par4);
        
        //par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
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
        	ItemStack[] items = new ItemStack[]{ new ItemStack(seed, 1)};
        	
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
		return ret;
    }
	
	public boolean canProvidePower()
	{
		if(fxtype == FXType.REDSTONE)
		{
			return true;
		}
		
		return false;
	}
	
	public int isProvidingWeakPower(IBlockAccess metadata, int par2, int par3, int par4, int par5)
    {
		if(fxtype == FXType.REDSTONE)
		{
			int i = 0;
			switch(metadata.getBlockMetadata(par2, par3, par4))
			{
			case 15: 
			case 14: 
			case 13: 
			case 12: 
			case 11: 
			case 10: 
			case 9:  
			case 8:  
			case 7:  i++; i++;
			case 6:  i++; i++;
			case 5:  i++; i++;
			case 4:  i++; i++;
			case 3:  i++; i++;
			case 2:  i++; i++;
			case 1:  i++; i++;
			case 0:  i++; i++;
			}
			return i;
		}
        return 0;
    }
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
		float growthRate = 14.875f * ((float)invertRarity() / 10.0f);
		
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
		
		tellTheNeighbors(par1World, par2, par3, par4);
		
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
	
	public Block setFXType(FXType fxt) {
		this.fxtype = fxt;
		return this;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
				
		float rand    = par5Random.nextFloat();
		float randu   = par5Random.nextInt(2); // 0 or 1
		
		switch(fxtype)
		{
		case IRON:   if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 2.55F, 2.55F, 2.55F);
		 		     else           metalFXEffect(par1World, par2, par3, par4, par5Random, 0.68F, 0.68F, 0.68F); break;
		 		   
		case GOLD:   if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 2.24F, 2.24F, 0.02F);
		   		     else           metalFXEffect(par1World, par2, par3, par4, par5Random, 2.25F, 0.71F, 0.27F); break;
		   		   
		case TIN:    if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 0.36F, 0.54F, 0.68F);
		 		     else           metalFXEffect(par1World, par2, par3, par4, par5Random, 0.82F, 1.14F, 1.42F); break;
		
		case COPPER: if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 1.72F, 0.83F, 0.01F);
					 else           metalFXEffect(par1World, par2, par3, par4, par5Random, 1.56F, 0.63F, 0.01F); break;
					 
		case SILVER: if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 2.00F, 2.20F, 2.27F);
		 			 else           metalFXEffect(par1World, par2, par3, par4, par5Random, 0.72F, 1.40F, 1.46F); break;
		 			 
		case LEAD:   if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 0.73F, 0.84F, 1.16F);
		 		     else           metalFXEffect(par1World, par2, par3, par4, par5Random, 0.45F, 0.52F, 0.73F); break;
		 		     
		case NICKEL: if(randu == 1) metalFXEffect(par1World, par2, par3, par4, par5Random, 2.55F, 2.55F, 2.22F);
	     			 else           metalFXEffect(par1World, par2, par3, par4, par5Random, 1.28F, 1.24F, 0.98F); break;
		 		     
		case CLAY:   rainFXEffect(par1World, par2 + par5Random.nextFloat(), par3 + 0.9f, par4 + par5Random.nextFloat(), par5Random); break;
		
		case COAL:	 if(rand <= 0.3f) par1World.spawnParticle("smoke", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
											                0.0f, 0.03f, 0.0f); break;
		
		case HELL:	 if(rand <= 0.3f) par1World.spawnParticle("flame", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
                	 0.0f, 0.03f, 0.0f);
					 par1World.spawnParticle("portal", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
					 0.0f, 0.00f, 0.0f);
					 break;
					 
		case REDSTONE: if(rand <= 0.3f) par1World.spawnParticle("reddust", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
           	 		   0.0f, 0.00f, 0.0f); break;
		
		case SOUL:
		case QUARTZ:
		case GLOW: par1World.spawnParticle("portal", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
    	 		   0.0f, 0.00f, 0.0f); break;
    	 		   
		case LAVA: if(rand <= 0.3f) par1World.spawnParticle("flame", par2 + par5Random.nextFloat(), par3 + 0.1f, par4 + par5Random.nextFloat(),
           	 	   0.0f, 0.03f, 0.0f);
				   if(rand <= 0.05f) par1World.spawnParticle("lava", par2, par3, par4, 0.0f, 0.0f, 0.0f);
				   break;
				   
		case END:
		case PEARL: par1World.spawnParticle("townaura", par2 + par5Random.nextFloat(), par3 + 0.5f, par4 + par5Random.nextFloat(),
 	 		   		0.0f, 0.00f, 0.0f); break;
		
		default:   break;
		}
		
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[4];

        for (int i = 0; i < this.iconArray.length - 1; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("carrots_" + i);
        }
        
        this.iconArray[this.iconArray.length - 1] = par1IconRegister.registerIcon(Reference.MOD_ID+":" + fxtype.toString() + "_crop");
    }
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }
	
	/** FX Effect Handlers **/
	
	private void metalFXEffect(World par1World, float par2, float par3,
			float par4, Random par5Random, float r, float g, float b) {
		
		if(par5Random.nextInt() <= 5) {
			CropParticleFX fx = new CropParticleFX(par1World,
			/* Motion to */ par2 + .5f, par3, par4 + .5f,
			/* Spawn at  */ par5Random.nextDouble() - .5f, .9D, par5Random.nextDouble() - .5f,
			/* Color     */ r, g, b);
			
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
		}
	}
	
	private void rainFXEffect(World par1World, float f, float g, float h, Random par5Random)
	{
		
		if(par5Random.nextInt() <= 5) {
			
			EntityRainFX fx = new EntityRainFX(par1World, f, g, h);
			
			ModLoader.getMinecraftInstance().effectRenderer.addEffect(fx);
			
		}
		
	}
	
	public void tellTheNeighbors(World world, int x, int y, int z)
	{
		if(fxtype == FXType.REDSTONE)
		{
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
            world.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
            world.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
            world.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
		}
	}

}
