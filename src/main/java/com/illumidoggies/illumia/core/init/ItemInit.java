package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.util.TestArmorMaterial;
import com.illumidoggies.illumia.common.items.SpecialItem;
import com.illumidoggies.illumia.common.items.SpecialItem2;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);
	
	// items
	public static final RegistryObject<Item> test = ITEMS.register("test", 
			() -> new Item(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	
	
	public static final RegistryObject<SpecialItem> special_item = ITEMS.register("special_item", 
			() -> new SpecialItem(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	public static final RegistryObject<SpecialItem2> special_item2 = ITEMS.register("special_item2", 
			() -> new SpecialItem2(new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
	
	
	// teleporting staffs
	public static final RegistryObject<EnderStaff> ender_staff = ITEMS.register("ender_staff", 
			() -> new EnderStaff(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxStackSize(1)));

	//bow
	
	public static final RegistryObject<Item> TORCH_BOW = ITEMS.register("torch_bow", 
			() -> new TorchBow(new Item.Properties().group(Illlumia.TUTORIAL_GROUP).maxDamage(500)));
	
	// Block item
	public static final RegistryObject<BlockItem> nether_block = ITEMS.register("nether_block", () -> new BlockItem(BlockInit.nether_block.get(), new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

	
	//armour
	public static final RegistryObject<Item> TEST_HELMET = ITEMS.register("test_helmet",
            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> TEST_CHESTPLATE = ITEMS.register("test_chestplate",
            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> TEST_LEGGINGS = ITEMS.register("test_leggings",
            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> TEST_BOOTS = ITEMS.register("test_boots",
            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

    //sword
    public static final RegistryObject<SwordItem> TEST_SWORD = ITEMS.register("test_sword", 
    		() -> new SwordItem(ModMaterial.TOOL_TEST, 3, -2.4f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));


    //tools
    public static final RegistryObject<PickaxeItem> TEST_PICKAXE = ITEMS.register("test_pickaxe", 
    		() -> new PickaxeItem(ModMaterial.TOOL_TEST, 1, -2.8f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<AxeItem> TEST_AXE = ITEMS.register("test_axe", 
    		() -> new AxeItem(ModMaterial.TOOL_TEST, 6f, -3.1f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<ShovelItem> TEST_SHOVEL = ITEMS.register("test_shovel", 
    		() -> new ShovelItem(ModMaterial.TOOL_TEST, 1.5f, -3f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
    
    public static final RegistryObject<HoeItem> TEST_HOE = ITEMS.register("test_hoe", 
    		() -> new HoeItem(ModMaterial.TOOL_TEST, 3, -1.0f, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));



}
