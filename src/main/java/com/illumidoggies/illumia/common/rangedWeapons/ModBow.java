package com.illumidoggies.illumia.common.rangedWeapons;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class ModBow extends BowItem {
    public ModBow(Properties builder) {
        super(builder);
    }

    public void onPlayerStoppedUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            
            boolean hasInfinity = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bowStack) > 0;
            ItemStack ammoStack = playerentity.findAmmo(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - timeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, playerentity, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;
            
            int i = this.getUseDuration(bowStack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, playerentity, i, !bowStack.isEmpty() || hasInfinity);
            if (i < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {
                boolean isTippedArrow = ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW;

                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(Items.ARROW);
                }

                
                
                float f = getArrowVelocity(i);
                if (!((double)f < 0.1D)) {
                   boolean flag1 = playerentity.abilities.isCreativeMode || (ammoStack.getItem() instanceof ArrowItem && ((ArrowItem)ammoStack.getItem()).isInfinite(ammoStack, bowStack, playerentity));
                   if (!worldIn.isRemote) {
                	   
                       AbstractArrowEntity abstractarrowentity = createArrow(worldIn, ammoStack, playerentity);

                      abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                      if (f == 1.0F) {
                         abstractarrowentity.setIsCritical(true);
                      }

                      int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);
                      if (j > 0) {
                         abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + 0.5D);
                      }

                      int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, bowStack);
                      if (k > 0) {
                         abstractarrowentity.setKnockbackStrength(k);
                      }

                      if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, bowStack) > 0) {
                         abstractarrowentity.setFire(100);
                      }

                      bowStack.damageItem(1, playerentity, (p_220009_1_) -> {
                         p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                      });
                      if (flag1 || playerentity.abilities.isCreativeMode && (ammoStack.getItem() == Items.SPECTRAL_ARROW || ammoStack.getItem() == Items.TIPPED_ARROW)) {
                         abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                      }

                      worldIn.addEntity(abstractarrowentity);
                   }

                    // sound
                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    // use an arrow
                    boolean shouldConsumeArrow = !hasInfinity || isTippedArrow;
                    if (shouldConsumeArrow) {
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.inventory.deleteStack(ammoStack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    // override to use a custom arrow entity
    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity) {
        ArrowItem arrowitem = (ArrowItem)(ammoStack.getItem() instanceof ArrowItem ? ammoStack.getItem() : Items.ARROW);
        return arrowitem.createArrow(worldIn, ammoStack, playerentity);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);

        if (powerLevel > 0) return arrowEntity.getDamage() + (double)powerLevel * 0.5D + 0.5D;
        else return arrowEntity.getDamage();
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, bowStack);
    }

    // Override to change what it uses as ammo
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem().isIn(ItemTags.ARROWS);
        };
    }
}
