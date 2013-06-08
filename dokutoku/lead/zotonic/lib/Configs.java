/**
 * 
 */
package dokutoku.lead.zotonic.lib;

import java.util.ArrayList;

import thermalexpansion.api.item.ItemRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import dokutoku.lead.zotonic.crops.PolyCrop;
import dokutoku.lead.zotonic.crops.seeds.PolySeeds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.oredict.OreDictionary;

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
		
		public static Item seedGold;
		public static int   seedGoldID;
		
		public static Item seedClay;
		public static int   seedClayID;
		
		// Underground stuff
		public static Item seedRedstone;
		public static int   seedRedstoneID;
		
		public static Item seedCoal;
		public static int   seedCoalID;
		
		// Nether resources
		public static Item seedNetherrack;
		public static int   seedNetherrackID;
		
		public static Item seedGlowstone;
		public static int   seedGlowstoneID;
		
		public static Item seedQuartz;
		public static int   seedQuartzID;
		
		public static Item seedSoulsand;
		public static int   seedSoulsandID;
		
		// Ender resources
		public static Item seedPearl;
		public static int   seedPearlID;
		
		public static Item seedEndstone;
		public static int   seedEndstoneID;
		
		// Extra items
		public static Item seedTin;
		public static int   seedTinID;
		
		public static Item seedCopper;
		public static int   seedCopperID;
		
		public static Item seedSilver;
		public static int   seedSilverID;
		
		public static Item seedLead;
		public static int   seedLeadID;
		
		// Meh, I'll make it
		public static Item seedLavaCrystal;
		public static int  seedLavaCrystalID;
		
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
			
			config.save();
			
		}
		
		public static void load(FMLInitializationEvent event) {
			
			// ITEM REGISTRY
			
			ItemStack tin    = null;
			ItemStack copper = null;
			ItemStack silver = null;
			ItemStack lead   = null;
			
			ArrayList<ItemStack> tins    = new ArrayList<ItemStack>();
			ArrayList<ItemStack> coppers = new ArrayList<ItemStack>();
			ArrayList<ItemStack> silvers = new ArrayList<ItemStack>();
			ArrayList<ItemStack> leads   = new ArrayList<ItemStack>();  
			
			// Try to get TE's ingots first. Personal preference.
			if(ItemRegistry.getItem("ingotElectrum", 1) != null)
			{
				
				tin    = ItemRegistry.getItem("ingotTin", 1);
				copper = ItemRegistry.getItem("ingotCopper", 1);
				silver = ItemRegistry.getItem("ingotSilver", 1);
				lead   = ItemRegistry.getItem("ingotLead", 1);
				
				// Satisfy checks
				tins.add(tin);
				coppers.add(copper);
				silvers.add(silver);
				leads.add(lead);
				
				
			} else {
			
				tins    = OreDictionary.getOres("ingotTin");
				coppers = OreDictionary.getOres("ingotCopper");
				silvers = OreDictionary.getOres("ingotSilver");
				leads   = OreDictionary.getOres("ingotLead");
				
				if(!tins.isEmpty())
					tin = tins.get(0);
				if(!coppers.isEmpty())
					copper = coppers.get(0);
				if(!silvers.isEmpty())
					silver = silvers.get(0);
				if(!leads.isEmpty())
					lead = leads.get(0);
			
			}
			
			/// METALS
			
			seedIron = new PolySeeds(seedIronID, cropIronID, Block.tilledField.blockID, new ItemStack(Item.ingotIron), EnumPlantType.Crop)
					.setType("Iron").setUnlocalizedName("seeds.iron");
			cropIron = new PolyCrop(cropIronID, (ItemSeeds) seedIron, 3).setFXType(FXType.IRON);
			
			seedGold = new PolySeeds(seedGoldID, cropGoldID, Block.tilledField.blockID, new ItemStack(Item.ingotGold), EnumPlantType.Crop)
					.setType("Gold").setUnlocalizedName("seeds.gold");
			cropGold = new PolyCrop(cropGoldID, (ItemSeeds) seedGold, 4).setFXType(FXType.GOLD);
			
			if(!tins.isEmpty()) {
			seedTin = new PolySeeds(seedTinID, cropTinID, Block.tilledField.blockID, tin, EnumPlantType.Crop)
					.setType("Tin").setUnlocalizedName("seeds.tin");
			cropTin = new PolyCrop(cropTinID, (ItemSeeds) seedTin, 2).setFXType(FXType.TIN);
			}
			
			if(!coppers.isEmpty()) {
			seedCopper = new PolySeeds(seedCopperID, cropCopperID, Block.tilledField.blockID, copper, EnumPlantType.Crop)
					.setType("Copper").setUnlocalizedName("seeds.copper");
			cropCopper = new PolyCrop(cropCopperID, (ItemSeeds) seedCopper, 1).setFXType(FXType.COPPER);
			}
			
			if(!silvers.isEmpty()) {
			seedSilver = new PolySeeds(seedSilverID, cropSilverID, Block.tilledField.blockID, silver, EnumPlantType.Crop)
					.setType("Silver").setUnlocalizedName("seeds.silver");
			cropSilver = new PolyCrop(cropSilverID, (ItemSeeds) seedSilver, 4).setFXType(FXType.SILVER);
			}
			
			if(!leads.isEmpty()) {
			seedLead = new PolySeeds(seedLeadID, cropLeadID, Block.tilledField.blockID, lead, EnumPlantType.Crop)
					.setType("Lead").setUnlocalizedName("seeds.lead");
			cropLead = new PolyCrop(cropLeadID, (ItemSeeds) seedLead, 3).setFXType(FXType.LEAD);
			}
			
			
			/// RESOURCES
			
			seedClay = new PolySeeds(seedClayID, cropClayID, 
					Block.tilledField.blockID, new ItemStack(Item.clay), EnumPlantType.Crop)
					.setType("Clay").setUnlocalizedName("seeds.clay");
			cropClay = new PolyCrop(cropClayID, (ItemSeeds) seedClay, 2).setFXType(FXType.CLAY);
			
			seedRedstone = new PolySeeds(seedRedstoneID, cropRedstoneID,
					Block.tilledField.blockID, new ItemStack(Item.redstone, 2), EnumPlantType.Crop)
				    .setType("Redstone").setUnlocalizedName("seeds.redstone");
			cropRedstone = new PolyCrop(cropRedstoneID, (ItemSeeds) seedRedstone, 2).setFXType(FXType.REDSTONE);
	
			seedCoal = new PolySeeds(seedCoalID, cropCoalID,
					Block.tilledField.blockID, new ItemStack(Item.coal), EnumPlantType.Crop)
					.setType("Coal").setUnlocalizedName("seeds.coal");
			cropCoal = new PolyCrop(cropCoalID, (ItemSeeds) seedCoal, 2).setFXType(FXType.COAL);
	
			seedNetherrack = new PolySeeds(seedNetherrackID, cropNetherrackID,
					Block.slowSand.blockID, new ItemStack(Block.netherrack), EnumPlantType.Nether)
					.setType("Hell").setUnlocalizedName("seeds.netherrack");
			cropNetherrack = new PolyCrop(cropNetherrackID, (ItemSeeds) seedNetherrack, 3).setFXType(FXType.HELL);
	
			seedGlowstone = new PolySeeds(seedGlowstoneID, cropGlowstoneID,
					Block.slowSand.blockID, new ItemStack(Item.lightStoneDust, 3), EnumPlantType.Nether)
					.setType("Glow").setUnlocalizedName("seeds.glowstone");
			cropGlowstone = new PolyCrop(cropGlowstoneID, (ItemSeeds) seedGlowstone, 4).setFXType(FXType.GLOW);
	
			seedQuartz = new PolySeeds(seedQuartzID, cropQuartzID,
					Block.slowSand.blockID, new ItemStack(Item.netherQuartz), EnumPlantType.Nether)
					.setType("Quartz").setUnlocalizedName("seeds.quartz");
			cropQuartz = new PolyCrop(cropQuartzID, (ItemSeeds) seedQuartz, 3).setFXType(FXType.QUARTZ);
	
			seedSoulsand = new PolySeeds(seedSoulsandID, cropSoulsandID,
					Block.slowSand.blockID, new ItemStack(Block.slowSand), EnumPlantType.Nether)
					.setType("Soul").setUnlocalizedName("seeds.soulsand");
			cropSoulsand = new PolyCrop(cropSoulsandID, (ItemSeeds) seedSoulsand, 4).setFXType(FXType.SOUL);
	
			seedPearl = new PolySeeds(seedPearlID, cropPearlID,
					Block.tilledField.blockID, new ItemStack(Item.enderPearl), EnumPlantType.Crop)
					.setType("Pearl").setUnlocalizedName("seeds.enderpearl");
			cropPearl = new PolyCrop(cropPearlID, (ItemSeeds) seedPearl, 5).setFXType(FXType.PEARL);

			seedEndstone = new PolySeeds(seedEndstoneID, cropEndstoneID,
					Block.tilledField.blockID, new ItemStack(Block.whiteStone), EnumPlantType.Crop)
					.setType("End").setUnlocalizedName("seeds.endstone");
			cropEndstone = new PolyCrop(cropEndstoneID, (ItemSeeds) seedEndstone, 5).setFXType(FXType.END);
	
			seedLavaCrystal = new PolySeeds(seedLavaCrystalID, cropLavaCrystalID,
					Block.tilledField.blockID, new ItemStack(Item.bucketLava), EnumPlantType.Nether)
					.setType("Lava").setUnlocalizedName("seeds.lavacrystal");
			cropLavaCrystal = new PolyCrop(cropLavaCrystalID, (ItemSeeds) seedLavaCrystal, 4).setFXType(FXType.LAVA);

			
			// LANGUAGE REGISTRY
			
			LanguageRegistry.addName(seedIron, "Iron Seeds");
			LanguageRegistry.addName(cropIron, "Iron crop");
			
			LanguageRegistry.addName(seedGold, "Gold Seeds");
			LanguageRegistry.addName(cropGold, "Gold crop");
			
			if(!tins.isEmpty()) {
			LanguageRegistry.addName(seedTin, "Tin Seeds");
			LanguageRegistry.addName(cropTin, "Tin crop");
			}
			
			if(!coppers.isEmpty()) {
			LanguageRegistry.addName(seedCopper, "Copper Seeds");
			LanguageRegistry.addName(cropCopper, "Copper crop");
			}
			
			if(!silvers.isEmpty()) {
			LanguageRegistry.addName(seedSilver, "Silver Seeds");
			LanguageRegistry.addName(cropSilver, "Silver crop");
			}
			
			if(!leads.isEmpty()) {
			LanguageRegistry.addName(seedLead, "Lead Seeds");
			LanguageRegistry.addName(cropLead, "Lead crop");
			}
			

			LanguageRegistry.addName(seedClay, "Clay Seeds");
			LanguageRegistry.addName(cropClay, "Clay crop");
			
			LanguageRegistry.addName(seedEndstone, "End Stone Seeds");
			LanguageRegistry.addName(cropEndstone, "End Stone crop");
			
			LanguageRegistry.addName(seedGlowstone, "Glowstone Seeds");
			LanguageRegistry.addName(cropGlowstone, "Glowstone crop");
			
			LanguageRegistry.addName(seedNetherrack, "Netherrack Seeds");
			LanguageRegistry.addName(cropNetherrack, "Netherrack crop");
			
			LanguageRegistry.addName(seedLavaCrystal, "Lava Crystal Seeds");
			LanguageRegistry.addName(cropLavaCrystal, "Lava Crystal crop");
			
			LanguageRegistry.addName(seedPearl, "Ender Pearl Seeds");
			LanguageRegistry.addName(cropPearl, "Ender Pearl crop");
			
			LanguageRegistry.addName(seedQuartz, "Quartz Seeds");
			LanguageRegistry.addName(cropQuartz, "Quartz crop");
			
			LanguageRegistry.addName(seedRedstone, "Redstone Seeds");
			LanguageRegistry.addName(cropRedstone, "Redstone crop");
			
			LanguageRegistry.addName(seedSoulsand, "Soul Seeds");
			LanguageRegistry.addName(cropSoulsand, "Soul crop");
			
			LanguageRegistry.addName(seedCoal, "Coal Seeds");
			LanguageRegistry.addName(cropCoal, "Coal crop");
			
			
			// SMELTING RECIPES
			
			GameRegistry.addSmelting(seedIron.itemID, ((PolySeeds) seedIron).getProduct(), 0.0f);
			GameRegistry.addSmelting(seedGold.itemID, ((PolySeeds) seedGold).getProduct(), 0.0f);
			
			if(!tins.isEmpty())    GameRegistry.addSmelting(seedTin.itemID, ((PolySeeds) seedTin).getProduct(), 0.0f);
			if(!coppers.isEmpty()) GameRegistry.addSmelting(seedCopper.itemID, ((PolySeeds) seedCopper).getProduct(), 0.0f);
			if(!silvers.isEmpty()) GameRegistry.addSmelting(seedSilver.itemID, ((PolySeeds) seedSilver).getProduct(), 0.0f);
			if(!leads.isEmpty())   GameRegistry.addSmelting(seedLead.itemID, ((PolySeeds) seedLead).getProduct(), 0.0f);
			
			
			// CRAFTING RECIPES
			
			GameRegistry.addShapelessRecipe(((PolySeeds) seedClay).getProduct(), new ItemStack(seedClay));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedCoal).getProduct(), new ItemStack(seedCoal));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedRedstone).getProduct(), new ItemStack(seedRedstone));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedNetherrack).getProduct(), new ItemStack(seedNetherrack));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedGlowstone).getProduct(), new ItemStack(seedGlowstone));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedQuartz).getProduct(), new ItemStack(seedQuartz));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedSoulsand).getProduct(), new ItemStack(seedSoulsand));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedPearl).getProduct(), new ItemStack(seedPearl));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedEndstone).getProduct(), new ItemStack(seedEndstone));
			GameRegistry.addShapelessRecipe(((PolySeeds) seedLavaCrystal).getProduct(), new ItemStack(seedLavaCrystal), new ItemStack(Item.bucketEmpty));
			
		}

}
