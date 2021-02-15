package com.illumidoggies.illumia.common.items.ModMaterial;

import com.illumidoggies.illumia.core.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ModMaterial {
    public static IItemTier TOOL_TEST = new IItemTier() {

        @Override
        public Ingredient getRepairMaterial() {
            Ingredient repairMaterial = Ingredient.fromItems(ItemInit.special_item.get());
            return repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return 313;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 18;
        }

        @Override
        public float getEfficiency() {
            return 5f;
        }

        @Override
        public float getAttackDamage() {
            return 2f;
        }
    };
}

