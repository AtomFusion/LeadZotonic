/**
 * 
 */
package dokutoku.lead.zotonic.command;

import java.util.logging.Level;

import thaumcraft.api.EnumTag;
import thaumcraft.api.ObjectTags;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aura.AuraNode;
import dokutoku.lead.zotonic.lib.Commands;
import dokutoku.lead.zotonic.util.LeadLogger;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLiving;

/**
 * Codename: Nickel Rad
 *
 * CommandLZ
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class CommandLZ extends CommandBase {

	@Override
	public String getCommandName() {
		
		return Commands.COMMAND_NR;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		
		if (args.length == 1) {
			
			String cName = args[0];
			LeadLogger.log(Level.INFO, cName);
			
			if(cName.equalsIgnoreCase(Commands.INC_FLUX)) {
				
				if (sender instanceof EntityLiving) {
					ThaumcraftApi.increaseLowestAura(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 1000);
				}
			}
			
			else if(cName.equalsIgnoreCase(Commands.DEC_FLUX)) {
				
				if (sender instanceof EntityLiving) {
					ThaumcraftApi.decreaseClosestAura(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100, true);
				}
				
			}
			
			else if(cName.equalsIgnoreCase(Commands.GET_FLUX)) {
				if (sender instanceof EntityLiving) {
					
					int nodeId = ThaumcraftApi.getClosestAuraWithinRange(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100.0);
					
					if (nodeId >= 0)
					{
						AuraNode node = ThaumcraftApi.getNodeCopy(nodeId);
						if (node != null)
						{
							int aspectCount = node.flux.tags.size();
							if (aspectCount > 0)
							{
								
								ObjectTags ot = new ObjectTags();
								
								for(EnumTag tag : EnumTag.values())
								{
									sender.sendChatToPlayer(tag.toString());
									sender.sendChatToPlayer(Integer.toString(node.flux.getAmount(tag)));
									//node.flux.add(tag, 100);
								}
							}
						}
					}
					
					sender.sendChatToPlayer(Integer.toString(ThaumcraftApi.getClosestAuraWithinRange(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100.0)));
				}
			}
			
			else if(cName.equalsIgnoreCase(Commands.PURIFY)) {
				if (sender instanceof EntityLiving) {
					int nodeId = ThaumcraftApi.getClosestAuraWithinRange(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100.0);
					
					if (nodeId >= 0)
					{
						AuraNode node = ThaumcraftApi.getNodeCopy(nodeId);
						if (node != null)
						{
							int aspectCount = node.flux.tags.size();
							if (aspectCount > 0)
							{
								
								ObjectTags ot = new ObjectTags();
								
								for(EnumTag tag : EnumTag.values())
								{
									sender.sendChatToPlayer(tag.toString());
									ot.remove(tag, 50);
									//node.flux.add(tag, 100);
								}
								
								ThaumcraftApi.queueNodeChanges(node.key, 0, 0, false, ot, 0.0F, 0.0F, 0.0F);
							}
						}
					}
					
				}
			}
			
			else if(cName.equalsIgnoreCase(Commands.DIRTY)) {
				if (sender instanceof EntityLiving) {
					int nodeId = ThaumcraftApi.getClosestAuraWithinRange(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100.0);
					
					if (nodeId >= 0)
					{
						AuraNode node = ThaumcraftApi.getNodeCopy(nodeId);
						if (node != null)
						{
							int aspectCount = node.flux.tags.size();
							if (aspectCount > 0)
							{
								ObjectTags ot = new ObjectTags();
								
								for(EnumTag tag : EnumTag.values())
								{
									sender.sendChatToPlayer(tag.toString());
									ot.add(tag, 50);
									//node.flux.add(tag, 100);
								}
								
								ThaumcraftApi.queueNodeChanges(node.key, 0, 0, false, ot, 0.0F, 0.0F, 0.0F);
							}
						}
					}
					
				}
			}
				
			else if(cName.equalsIgnoreCase(Commands.GROW) || cName.equalsIgnoreCase(Commands.SHRINK)) {
				if (sender instanceof EntityLiving) {
					int nodeId = ThaumcraftApi.getClosestAuraWithinRange(((EntityLiving)sender).worldObj, ((EntityLiving) sender).posX, ((EntityLiving) sender).posY, ((EntityLiving) sender).posZ, 100.0);
					
					if (nodeId >= 0)
					{
						AuraNode node = ThaumcraftApi.getNodeCopy(nodeId);
						if (node != null)
						{
							int aspectCount = node.flux.tags.size();
							if (aspectCount > 0)
							{
								int change = 0;
								
								if(cName.equalsIgnoreCase(Commands.GROW))
									change = 1000;
								else
									change = -1000;
								
								ThaumcraftApi.queueNodeChanges(node.key, 0, change, false, new ObjectTags(), 0.0F, 0.0F, 0.0F);
							}
						}
					}
					
				}
			}
			
			else
				throw new WrongUsageException(Commands.COMMAND_NR_USAGE, new Object[0]);
			
		} else {
			throw new WrongUsageException(Commands.COMMAND_NR_USAGE, new Object[0]);
		}

	}

}
