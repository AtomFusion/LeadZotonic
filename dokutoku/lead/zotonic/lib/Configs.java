/**
 * 
 */
package dokutoku.lead.zotonic.lib;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dokutoku.lead.zotonic.crops.PolyCrop;
import dokutoku.lead.zotonic.crops.seeds.PolySeeds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.Configuration;

/**
 * Codename: Lead Zotonic
 *
 * Configs
 *
 * @author Atomfusion/DokuToku
 * @license MIT License (http://opensource.org/licenses/MIT)
 */
public class Configs {

		public static Configuration config;

		/** Crops **/
		// Common resources
		public static Block cropIron;
		public static int   cropIronID;
		
		public static Block cropGold;
		public static int   cropGoldID;
		
		public static Block cropClay;
		public static int   cropClayID;
		
		// Underground stuff
		public static Block cropRedstone;
		public static int   cropRedstoneID;
		
		public static Block cropCoal;
		public static int   cropCoalID;
		
		// Nether resources
		public static Block cropNetherrack;
		public static int   cropNetherrackID;
		
		public static Block cropGlowstone;
		public static int   cropGlowstoneID;
		
		public static Block cropQuartz;
		public static int   cropQuartzID;
		
		public static Block cropSoulsand;
		public static int   cropSoulsandID;
		
		// Ender resources
		public static Block cropPearl;
		public static int   cropPearlID;
		
		public static Block cropEndstone;
		public static int   cropEndstoneID;
		
		// Extra items
		public static Block cropTin;
		public static int   cropTinID;
		
		public static Block cropCopper;
		public static int   cropCopperID;
		
		public static Block cropSilver;
		public static int   cropSilverID;
		
		public static Block cropLead;
		public static int   cropLeadID;
		
		// Meh, I'll make it
		public static Block cropLavaCrystal;
		public static int   cropLavaCrystalID;
		
		
		/** Seeds **/
		// Common resources
		public static Item seedIron;
		public static int   seedIronID;
		
		public static ItemSeeds seedGold;
		public static int   seedGoldID;
		
		public static ItemSeeds seedClay;
		public static int   seedClayID;
		
		// Underground stuff
		public static ItemSeeds seedRedstone;
		public static int   seedRedstoneID;
		
		public static ItemSeeds seedCoal;
		public static int   seedCoalID;
		
		// Nether resources
		public static ItemSeeds seedNetherrack;
		public static int   seedNetherrackID;
		
		public static ItemSeeds seedGlowstone;
		public static int   seedGlowstoneID;
		
		public static ItemSeeds seedQuartz;
		public static int   seedQuartzID;
		
		public static ItemSeeds seedSoulsand;
		public static int   seedSoulsandID;
		
		// Ender resources
		public static ItemSeeds seedPearl;
		public static int   seedPearlID;
		
		public static ItemSeeds seedEndstone;
		public static int   seedEndstoneID;
		
		// Extra items
		public static ItemSeeds seedTin;
		public static int   seedTinID;
		
		public static ItemSeeds seedCopper;
		public static int   seedCopperID;
		
		public static ItemSeeds seedSilver;
		public static int   seedSilverID;
		
		public static ItemSeeds seedLead;
		public static int   seedLeadID;
		
		// Meh, I'll make it
		public static ItemSeeds seedLavaCrystal;
		public static int   seedLavaCrystalID;
		
		public static void init(FMLPreInitializationEvent event) {
			config = new Configuration(event.getSuggestedConfigurationFile());
			
			config.load();
			
			/* Crops */
			cropIronID = config.getBlock("block", "Iron Crop ID", 2800).getInt(cropIronID);
			cropGoldID = config.getBlock("block", "Gold Crop ID", 2801).getInt(cropGoldID);
			cropClayID = config.getBlock("block", "Clay Crop ID", 2802).getInt(cropClayID);
			
			cropRedstoneID = config.getBlock("block", "Redstone Crop ID", 2803).getInt(cropRedstoneID);
			cropCoalID = config.getBlock("block", "Coal Crop ID", 2804).getInt(cropCoalID);
			
			cropNetherrackID = config.getBlock("block", "Netherrack Crop ID", 2805).getInt(cropNetherrackID);
			cropGlowstoneID = config.getBlock("block", "Glowstone Crop ID", 2806).getInt(cropGlowstoneID);
			cropQuartzID = config.getBlock("block", "Quartz Crop ID", 2807).getInt(cropQuartzID);
			cropSoulsandID = config.getBlock("block", "Soulsand Crop ID", 2808).getInt(cropSoulsandID);
			
			cropPearlID = config.getBlock("block", "Ender Pearl Crop ID", 2809).getInt(cropPearlID);
			cropEndstoneID = config.getBlock("block", "Endstone Crop ID", 2810).getInt(cropEndstoneID);
			
			cropTinID = config.getBlock("block", "Tin Crop ID", 2811).getInt(cropTinID);
			cropCopperID = config.getBlock("block", "Copper Crop ID", 2812).getInt(cropCopperID);
			cropSilverID = config.getBlock("block", "Silver Crop ID", 2813).getInt(cropSilverID);
			cropLeadID = config.getBlock("block", "Lead Crop ID", 2814).getInt(cropLeadID);
			
			cropLavaCrystalID = config.getBlock("block", "Lava Crystal Crop ID", 2815).getInt(cropLavaCrystalID);
			
			/* Seeds */
			seedIronID = config.getItem("item", "Iron Seed ID", 5300).getInt(seedIronID);
			seedGoldID = config.getItem("item", "Gold Seed ID", 5301).getInt(seedGoldID);
			seedClayID = config.getItem("item", "Clay Seed ID", 5302).getInt(seedClayID);
			
			seedRedstoneID = config.getItem("item", "Redstone Seed ID", 5303).getInt(seedRedstoneID);
			seedCoalID = config.getItem("item", "Coal Seed ID", 5304).getInt(seedCoalID);
			
			seedNetherrackID = config.getItem("item", "Netherrack Seed ID", 5305).getInt(seedNetherrackID);
			seedGlowstoneID = config.getItem("item", "Glowstone Seed ID", 5306).getInt(seedGlowstoneID);
			seedQuartzID = config.getItem("item", "Quartz Seed ID", 5307).getInt(seedQuartzID);
			seedSoulsandID = config.getItem("item", "Soulsand Seed ID", 5308).getInt(seedSoulsandID);
			
			seedPearlID = config.getItem("item", "Ender Pearl Seed ID", 5309).getInt(seedPearlID);
			seedEndstoneID = config.getItem("item", "Endstone Seed ID", 5310).getInt(seedEndstoneID);
			
			seedTinID = config.getItem("item", "Tin Seed ID", 5311).getInt(seedTinID);
			seedCopperID = config.getItem("item", "Copper Seed ID", 5312).getInt(seedCopperID);
			seedSilverID = config.getItem("item", "Silver Seed ID", 5313).getInt(seedSilverID);
			seedLeadID = config.getItem("item", "Lead Seed ID", 5314).getInt(seedLeadID);
			
			seedLavaCrystalID = config.getItem("item", "Lava Crystal Seed ID", 5315).getInt(seedLavaCrystalID);
			
		}
		
		public static void load(FMLInitializationEvent event) {
			
			seedIron = new PolySeeds(seedIronID, cropIronID, Block.tilledField.blockID).setUnlocalizedName("seeds.iron");
			cropIron = new PolyCrop(cropIronID, Item.goldNugget, (ItemSeeds) seedIron, 3);
			
			LanguageRegistry.addName(seedIron, "Iron Seeds");
			LanguageRegistry.addName(cropIron, "Iron crop");
			
		}

}
