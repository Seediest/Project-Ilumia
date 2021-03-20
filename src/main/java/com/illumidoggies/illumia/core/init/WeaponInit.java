package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;

import com.illumidoggies.illumia.common.items.SpecialItem;
import com.illumidoggies.illumia.common.items.ModMaterial.ModMaterial;
import com.illumidoggies.illumia.common.rangedWeapons.TorchBow;
import com.illumidoggies.illumia.common.specialItems.EnderStaff;

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
	
	
	
		
	 
	 
}
