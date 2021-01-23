package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);
	public static final RegistryObject<Item> test = ITEMS.register("test", () -> new 
			Item(new Item.Properties().group(ItemGroup.MISC)));
	
}
