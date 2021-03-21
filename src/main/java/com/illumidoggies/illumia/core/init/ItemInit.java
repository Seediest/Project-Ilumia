package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;

import com.illumidoggies.illumia.client.util.TestArmorMaterial;
import com.illumidoggies.illumia.common.armor.ArmorRenderer;
import com.illumidoggies.illumia.common.armor.MyCustomArmorModel;
import com.illumidoggies.illumia.common.items.GodCore;
import com.illumidoggies.illumia.common.items.SpecialItem;
import com.illumidoggies.illumia.common.items.ModMaterial.ModMaterial;
import com.illumidoggies.illumia.common.rangedWeapons.TorchBow;
import com.illumidoggies.illumia.common.specialItems.EnderStaff;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);
	
	// items
	public static final RegistryObject<Item> test = ITEMS.register("test", 
			() -> new Item(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	public static final RegistryObject<Item> testtwo = ITEMS.register("testtwo", 
			() -> new Item(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	
	public static final RegistryObject<SpecialItem> special_item = ITEMS.register("special_item", 
			() -> new SpecialItem(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	public static final RegistryObject<GodCore> god_core = ITEMS.register("god_core", 
			() -> new GodCore(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	
	
	// Block item
	public static final RegistryObject<BlockItem> nether_block = ITEMS.register("nether_block", () -> new BlockItem(BlockInit.nether_block.get(), new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

	
	
    
    

  

}
