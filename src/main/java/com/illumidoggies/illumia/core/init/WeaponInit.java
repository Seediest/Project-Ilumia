package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.util.ModItemTier;
import com.illumidoggies.illumia.common.items.SpecialItem;
import com.illumidoggies.illumia.common.items.ModMaterial.ModMaterial;
import com.illumidoggies.illumia.common.rangedWeapons.TorchBow;
import com.illumidoggies.illumia.common.specialItems.EnderStaff;
import com.illumidoggies.illumia.common.items.BEHOLDING_EYE;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WeaponInit {
	// items
	
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);

	
	 public static final RegistryObject<SwordItem> TEST_SWORD = ITEMS.register("test_sword", 
	    		() -> new SwordItem(ModMaterial.TOOL_TEST, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	 
	 
	// teleporting staffs
	public static final RegistryObject<EnderStaff> ender_staff = ITEMS.register("ender_staff", 
				() -> new EnderStaff(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxStackSize(1)));

	//bow
	public static final RegistryObject<Item> TORCH_BOW = ITEMS.register("torch_bow", 
				() -> new TorchBow(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxDamage(500)));


	//jomee sword
	public static final RegistryObject<SwordItem> BEHOLDING_EYE = ITEMS.register("beholding_eye", 
	    		() -> new BEHOLDING_EYE(ModItemTier.BEHOLDING, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	 
	
	//need to be implemented I followed instructions but did not work
	/*
	//kyle sword
	public static final RegistryObject<SwordItem> Geometrical_Dominator = ITEMS.register("geometrical_dominator", 
		    	() -> new Geometrical_Dominator(ModItemTier.Geometry, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	//kyle sword 2
	public static final RegistryObject<SwordItem> Ethereal_Penetrator = ITEMS.register("ethereal_penetrator", 
		    	() -> new com.illumidoggies.illumia.common.items.Ethereal_Penetrator(ModItemTier.Ethereal, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));	
	*/
	 
	
	
	
		
	 
	 
}
