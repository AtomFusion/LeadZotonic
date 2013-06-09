/**
 * 
 */
package dokutoku.lead.zotonic.item;

import dokutoku.lead.zotonic.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

/**
 * Codename: Lead Zotonic
 *
 * MagicBucket
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class MagicBucket extends ItemBucket {

	private int isFull = 1;

	public MagicBucket(int par1, int par2) {
		super(par1, par2);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        float f = 1.0F;
        double d0 = par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)f;
        double d1 = par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)f + 1.62D - (double)par3EntityPlayer.yOffset;
        double d2 = par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)f;
        boolean flag = false;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return par1ItemStack;
        }

        if (event.getResult() == Event.Result.ALLOW)
        {
            if (par3EntityPlayer.capabilities.isCreativeMode)
            {
                return par1ItemStack;
            }

            if (--par1ItemStack.stackSize <= 0)
            {
                return event.result;
            }

            if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
            {
                par3EntityPlayer.dropPlayerItem(event.result);
            }

            return par1ItemStack;
        }

        if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
        {
        	
            int i = movingobjectposition.blockX;
            int j = movingobjectposition.blockY;
            int k = movingobjectposition.blockZ;
            if (par2World.getBlockMaterial(i, j, k) == Material.water)
            {
            	System.out.println("True");
            }
            	
                
            if (movingobjectposition.sideHit == 0)
            {
                --j;
            }

            if (movingobjectposition.sideHit == 1)
            {
                ++j;
            }

            if (movingobjectposition.sideHit == 2)
            {
                --k;
            }

            if (movingobjectposition.sideHit == 3)
            {
                ++k;
            }

            if (movingobjectposition.sideHit == 4)
            {
                --i;
            }

            if (movingobjectposition.sideHit == 5)
            {
                ++i;
            }
            
            if(par2World.getBlockMaterial(i, j, k).isLiquid() && par2World.getBlockMetadata(i, j, k) == 0)
            {
            	par2World.setBlockToAir(i, j, k);
            	
            } else {

                if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                {
                    return par1ItemStack;
                }

                if (this.tryPlaceContainedLiquid(par2World, d0, d1, d2, i, j, k) && !par3EntityPlayer.capabilities.isCreativeMode)
                {
                    return new ItemStack(this);
                }
            }
        }

        return par1ItemStack;
    }
	
	public void registerIcons(IconRegister iReg)
	{
		itemIcon = iReg.registerIcon(Reference.MOD_ID+":" + "magic_bucket");
	}

}
