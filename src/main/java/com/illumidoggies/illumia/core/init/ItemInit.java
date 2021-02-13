package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.common.items.SpecialItem;
import com.illumidoggies.illumia.common.items.SpecialItem2;
import com.illumidoggies.illumia.common.rangedWeapons.TorchBow;
import com.illumidoggies.illumia.common.specialItems.EnderStaff;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	// items
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);
	public static final RegistryObject<Item> test = ITEMS.register("test", 
			() -> new Item(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	public static final RegistryObject<SpecialItem> special_item = ITEMS.register("special_item", 
			() -> new SpecialItem(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	public static final RegistryObject<SpecialItem2> special_item2 = ITEMS.register("special_item2", 
			() -> new SpecialItem2(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	
	// teleporting staffs
	public static final RegistryObject<EnderStaff> ender_staff = ITEMS.register("ender_staff", 
			() -> new EnderStaff(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

//bow
	
	public static final RegistryObject<Item> TORCH_BOW = ITEMS.register("torch_bow", 
			() -> new TorchBow(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxDamage(500)));
	
	// Block item
	public static final RegistryObject<BlockItem> nether_block = ITEMS.register("nether_block", () -> new BlockItem(BlockInit.nether_block.get(), new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
}
