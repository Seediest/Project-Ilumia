package com.illumidoggies.illumia.common.specialItems;

import javax.annotation.Nullable;

import org.lwjgl.glfw.GLFW;

import com.illumidoggies.illumia.client.util.KeyboardHelper;
import com.mojang.datafixers.types.templates.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EnderStaff extends Item{

	public EnderStaff(Properties properties) {
        super(properties);
	
}
	//tooltip not working need to fix
	/*
	// adds a tool tip when you hover over the item in your inventory and press shift
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
	*/
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        // cooldown = 3 seconds
        playerIn.getCooldownTracker().getCooldown(this, 60);

        // track where player is looking and move there
        Vector3d lookPos = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE).getHitVec();
        playerIn.setPosition(lookPos.x, lookPos.y, lookPos.z);

        //  cancel fall damage
        playerIn.fallDistance = 0F;

        // reduce durability
        ItemStack stack = playerIn.getHeldItem(handIn);
        stack.setDamage(stack.getDamage() + 1);

        // break if durability gets to 0
        if (stack.getDamage() == 0) stack.setCount(0);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    // the same as Item.rayTrace(World, PlayerEntity, FluidMode) but with a longer range
    protected static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        double range = 10; // player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();;

        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vector3d vec3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vector3d vec3d1 = vec3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
        return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }

    
}