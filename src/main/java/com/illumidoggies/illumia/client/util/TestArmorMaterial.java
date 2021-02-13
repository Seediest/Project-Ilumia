package com.illumidoggies.illumia.client.util;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.core.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.function.Supplier;

public enum TestArmorMaterial implements IArmorMaterial {
    TEST(Illlumia.MOD_ID + ":test", 20, new int[]{4, 7, 9, 4}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            3.0F, () -> { return Ingredient.fromItems(ItemInit.SMILE.get()); });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private void ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
    }

    public int getDurability1(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount1(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getKnockbackResistance() {
		// TODO Auto-generated method stub
		return 0;
	}
}
