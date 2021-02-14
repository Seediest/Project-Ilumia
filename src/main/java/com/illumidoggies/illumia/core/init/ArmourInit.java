package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.util.TestArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmourInit {
	   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Illlumia.MOD_ID);
	   
	   public static final RegistryObject<Item> TEST_HELMET = ITEMS.register("test_helmet",
	            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

	    public static final RegistryObject<Item> TEST_CHESTPLATE = ITEMS.register("test_chestplate",
	            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

	    public static final RegistryObject<Item> TEST_LEGGINGS = ITEMS.register("test_leggings",
	            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));

	    public static final RegistryObject<Item> TEST_BOOTS = ITEMS.register("test_boots",
	            () -> new ArmorItem(TestArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(Illlumia.TUTORIAL_GROUP)));
}
