package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.common.items.ModMaterial.ModMaterial;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);

	
	
	  //tools
    public static final RegistryObject<PickaxeItem> TEST_PICKAXE = ITEMS.register("test_pickaxe", 
    		() -> new PickaxeItem(ModMaterial.TOOL_TEST, 1, -2.8f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<AxeItem> TEST_AXE = ITEMS.register("test_axe", 
    		() -> new AxeItem(ModMaterial.TOOL_TEST, 6f, -3.1f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<ShovelItem> TEST_SHOVEL = ITEMS.register("test_shovel", 
    		() -> new ShovelItem(ModMaterial.TOOL_TEST, 1.5f, -3f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<HoeItem> TEST_HOE = ITEMS.register("test_hoe", 
    		() -> new HoeItem(ModMaterial.TOOL_TEST, 0, -1.0f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));


	
}
