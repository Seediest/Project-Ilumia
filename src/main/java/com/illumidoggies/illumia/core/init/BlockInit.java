package com.illumidoggies.illumia.core.init;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.illumidoggies.illumia.Illlumia;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, 
			Illlumia.MOD_ID);
	public static final RegistryObject<Block> nether_block = BLOCKS.register("nether_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).hardnessAndResistance(15f, 30f).setLightLevel((state) -> { 
		return 15;
		})));
	}
   
