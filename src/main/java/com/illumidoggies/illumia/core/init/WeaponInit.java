package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.util.ItemTier.EtherealTier;
import com.illumidoggies.illumia.client.util.ItemTier.GeometricalTier;
import com.illumidoggies.illumia.client.util.ItemTier.BeholdingTier;
import com.illumidoggies.illumia.common.items.ModMaterial.ModMaterial;
import com.illumidoggies.illumia.common.rangedWeapons.TorchBow;
import com.illumidoggies.illumia.common.specialItems.BananaStaff;
import com.illumidoggies.illumia.common.specialItems.EnderStaff;
import com.illumidoggies.illumia.common.specialItems.TesseractStaff;
import com.illumidoggies.illumia.common.items.BEHOLDING_EYE;
import com.illumidoggies.illumia.common.items.Geometrical_Dominator;
import com.illumidoggies.illumia.common.items.Ethereal_Penetrator;


import net.minecraft.item.Item;
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
	public static final RegistryObject<TesseractStaff> tesseract_staff = ITEMS.register("tesseract_staff", 
			() -> new TesseractStaff(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxStackSize(1)));
	public static final RegistryObject<BananaStaff> banana_staff = ITEMS.register("banana_staff", 
			() -> new BananaStaff(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxStackSize(1)));
	

	//bow
	public static final RegistryObject<Item> TORCH_BOW = ITEMS.register("torch_bow", 
				() -> new TorchBow(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxDamage(500)));


	//jomee sword
	public static final RegistryObject<SwordItem> BEHOLDING_EYE = ITEMS.register("beholding_eye", 
	    		() -> new BEHOLDING_EYE(BeholdingTier.BEHOLDING, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	 
	

	//kyle sword
	public static final RegistryObject<SwordItem> Geometrical_Dominator = ITEMS.register("geometrical_dominator", 
		    	() -> new Geometrical_Dominator(GeometricalTier.Geometrical, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	//kyle sword 2
	public static final RegistryObject<SwordItem> Ethereal_Penetrator = ITEMS.register("ethereal_penetrator", 
		    	() -> new Ethereal_Penetrator(EtherealTier.Ethereal, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));	

	 
	
	
	
		
	 
	 
}
