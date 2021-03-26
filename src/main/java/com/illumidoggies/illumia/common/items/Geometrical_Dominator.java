package com.illumidoggies.illumia.common.items;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;

	public class Geometrical_Dominator extends SwordItem {

	    public Geometrical_Dominator(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
	        super(tier, attackDamageIn, attackSpeedIn, builderIn);
	    }

	    public boolean hasEffect(ItemStack itemstack) {
	        return true;
	    }

	    public boolean hitEntity(ItemStack stack, LivingEntity entity, LivingEntity player) {
	        if (!Minecraft.getInstance().player.getCooldownTracker().hasCooldown(this)) {
	            LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(player.world);
	            lightning.setPosition(entity.getPosX(), entity.getPosY(), entity.getPosZ());
	            player.world.addEntity(lightning);
	            assert Minecraft.getInstance().player != null;
	            Minecraft.getInstance().player.getCooldownTracker().setCooldown(this, 200);
	            ActionResult.resultSuccess(Minecraft.getInstance().player.getHeldItem(player.getActiveHand()));
	            return true;
	        }
	        ActionResult.resultFail(Minecraft.getInstance().player.getHeldItem(player.getActiveHand()));
	        return true;
	    }
	}

