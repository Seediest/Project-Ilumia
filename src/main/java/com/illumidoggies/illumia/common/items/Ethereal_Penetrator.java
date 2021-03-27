package com.illumidoggies.illumia.common.items;
import java.util.List;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

	public class Ethereal_Penetrator extends SwordItem {

	    public Ethereal_Penetrator(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
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
	    
		@Override
		@OnlyIn(Dist.CLIENT)
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
				tooltip.add(new StringTextComponent("Advanced tooltip"));
			}
				else {
					
					tooltip.add(new TranslationTextComponent("tooltip.Special_Item.hold_shift"));
				}
		}
	}

